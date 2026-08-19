/* (C) TAMA Studios 2026 */
package com.code.tama.aseoha.common.registries;

import com.code.tama.aseoha.AseohaMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class DamageTypes {
	public static final ResourceKey<DamageType> XTONIC = ResourceKey.create(Registries.DAMAGE_TYPE,
			new ResourceLocation(AseohaMod.MODID, "xtonic"));
}
