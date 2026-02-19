/* (C) TAMA Studios 2026 */
package com.code.tama.aseoha.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import com.code.tama.aseoha.aseoha;

public class DamageTypes {
	public static DeferredRegister<DamageType> DAMAGE = DeferredRegister.create(Registries.DAMAGE_TYPE, aseoha.MODID);

	public static RegistryObject<DamageType> XTONIC = DAMAGE.register("xtonic", () -> new DamageType("xtonic", 50));
}
