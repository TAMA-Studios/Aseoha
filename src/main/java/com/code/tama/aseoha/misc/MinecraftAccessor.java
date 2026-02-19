/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.misc;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.Minecraft;

@Mixin(Minecraft.class)
public interface MinecraftAccessor {
	@Accessor("pausePartialTick")
	float pausePartialTick(float tick);
}
