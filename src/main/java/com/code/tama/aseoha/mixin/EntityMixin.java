/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.mixin;

import com.code.tama.aseoha.server.capabilities.Capabilities;
import com.code.tama.aseoha.server.capabilities.Interfaces.ITickrateCapability;
import com.code.tama.aseoha.common.misc.TickrateManager;
import org.apache.commons.lang3.tuple.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.world.entity.Entity;

@Mixin(Entity.class)
public class EntityMixin {
	@Inject(method = "tick", at = @At("HEAD"))
	private void tick(CallbackInfo ci) {
		Entity entity = Entity.class.cast(this);
		entity.getCapability(Capabilities.TICK_RATE).ifPresent(ITickrateCapability::tick);

		Pair<Boolean, Float> pair = TickrateManager.getArea(entity.level().dimension(), entity.getBoundingBox());
		if (pair.getLeft()) {
			if (entity.getCapability(Capabilities.TICK_RATE).isPresent()) {
				if (!entity.getCapability(Capabilities.TICK_RATE).orElseGet(null).isExcluded())
					TickrateManager.setTickrate(entity, pair.getRight());
			} else
				TickrateManager.setTickrate(entity, pair.getRight());
		}
	}
}
