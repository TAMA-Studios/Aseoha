/* (C) TAMA Studios 2026 */
package com.code.tama.aseoha.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import com.code.tama.aseoha.aseoha;

public class DamageTypes {
	public static final ResourceKey<DamageType> XTONIC =
			ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(aseoha.MODID, "xtonic"));
}
