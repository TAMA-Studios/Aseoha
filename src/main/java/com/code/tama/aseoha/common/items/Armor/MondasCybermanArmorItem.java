/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.common.items.Armor;

import static com.code.tama.aseoha.AseohaMod.MODID;

import com.code.tama.aseoha.client.Models.Armor.MondasCybermanArmorModel;
import com.code.tama.aseoha.client.Renderers.Armor.MondasCybermanArmorRenderer;
import org.jetbrains.annotations.Nullable;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class MondasCybermanArmorItem extends ModdedArmorItem {
	public MondasCybermanArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
		super(pMaterial, pType, pProperties);
	}

	@Override
	protected ModelPart getRenderer(LivingEntity living, ItemStack stack, EquipmentSlot slot) {
		return new MondasCybermanArmorRenderer<>(MondasCybermanArmorModel::createBodyLayer,
				MondasCybermanArmorModel::new).makeArmorParts(slot);
	}

	@Override
	public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return makeCustomTextureLocation(MODID, "mondas_cyber_man");
	}
}
