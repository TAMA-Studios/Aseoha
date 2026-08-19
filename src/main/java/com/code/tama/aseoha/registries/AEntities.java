/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.registries;

import com.code.tama.aseoha.entities.DalekEntity;
import com.code.tama.aseoha.entities.K9Entity;
import net.tardis.mod.entity.CarExteriorEntity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import com.code.tama.aseoha.aseoha;

public class AEntities {
	public static final DeferredRegister<EntityType<?>> TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
			aseoha.MODID);

	public static final RegistryObject<EntityType<CarExteriorEntity>> DELOREAN_TIME_MACHINE = createVehicle(
			"exteriors/delorean", CarExteriorEntity::new, 2F, 1.5F);

	public static final RegistryObject<EntityType<K9Entity>> K9 = TYPES.register("k9",
			() -> EntityType.Builder.of(K9Entity::new, MobCategory.MISC).sized(0.5f, 0.5f).build(aseoha.MODID));

	public static final RegistryObject<EntityType<DalekEntity>> DALEK = TYPES.register("dalek",
			() -> EntityType.Builder.of(DalekEntity::new, MobCategory.MISC).sized(1, 2).build(aseoha.MODID));

	public static final RegistryObject<EntityType<K9Entity>> WALLE = TYPES.register("walle",
			() -> EntityType.Builder.of(K9Entity::new, MobCategory.MISC).sized(0.5f, 0.5f).build(aseoha.MODID));

	public static final RegistryObject<EntityType<K9Entity>> HANDLES = TYPES.register("handles",
			() -> EntityType.Builder.of(K9Entity::new, MobCategory.MISC).sized(0.5f, 0.5f).build(aseoha.MODID));

	public static <T extends Entity> RegistryObject<EntityType<T>> createVehicle(String name,
			EntityType.EntityFactory<T> factory, float width, float height) {
		return TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.MISC).sized(width, height)
				.setTrackingRange(128).setUpdateInterval(5).setShouldReceiveVelocityUpdates(true).build(aseoha.MODID));
	}
}
