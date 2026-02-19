/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

import com.code.tama.triggerapi.universal.UniversalCommon;

public class Dimensions {
	public static final ResourceKey<DimensionType> RAXICORICOFALLAPITORIUS_TYPE = ResourceKey
			.create(Registries.DIMENSION_TYPE, UniversalCommon.modRL("raxicoricofallapatorious"));
	public static final ResourceKey<DimensionType> TRENZALORE_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
			UniversalCommon.modRL("trenzalore"));
	public static final ResourceKey<DimensionType> GALLIFREY_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
			UniversalCommon.modRL("gallifrey"));
	public static final ResourceKey<DimensionType> MONDAS_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
			UniversalCommon.modRL("mondas_type"));
	public static final ResourceKey<DimensionType> MIDNIGHT_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
			UniversalCommon.modRL("midnight_type"));
	public static final ResourceKey<DimensionType> ADIPOSE_THREE_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
			UniversalCommon.modRL("adipose_three_type"));
	public static final ResourceKey<DimensionType> SKARO_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
			UniversalCommon.modRL("skaro_type"));
	public static final ResourceKey<DimensionType> KLOM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
			UniversalCommon.modRL("klom_type"));
	public static final ResourceKey<Level> TRENZALORE = ResourceKey.create(Registries.DIMENSION,
			UniversalCommon.modRL("trenzalore"));
}
