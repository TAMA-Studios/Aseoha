/* (C) TAMA Studios 2026 */
package com.code.tama.aseoha.common.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import com.code.tama.triggerapi.universal.UniversalCommon;

public class ADimensions {
	public static final ResourceKey<Level> MIDNIGHT = ResourceKey.create(Registries.DIMENSION,
			UniversalCommon.modRL("midnight"));
}
