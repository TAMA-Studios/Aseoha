/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.mixin.client;

import static com.code.tama.aseoha.aseoha.EntityTickRateLimit;

import java.util.Set;

import com.code.tama.aseoha.misc.IHelpWithTime;
import com.code.tama.aseoha.misc.TickrateManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.Tickable;

@Mixin(TextureManager.class)
public class TextureManagerMixin {
	@Shadow
	@Final
	private Set<Tickable> tickableTextures;

	@Inject(at = @At(value = "HEAD"), method = "tick", cancellable = true)
	private void tick(CallbackInfo ci) {
		Minecraft mc = Minecraft.getInstance();
		if (TickrateManager.hasDimensionTimer(mc.level.dimension()) && TickrateManager.isExcluded(mc.player)) {
			ci.cancel();
			int j = ((IHelpWithTime) mc.level).aseoha$getTime();
			for (int k = 0; k < Math.min(EntityTickRateLimit ? 0x1F4 : 0xA, j); ++k) {
				for (Tickable tickable : this.tickableTextures) {
					tickable.tick();
				}
			}
		}
	}
}
