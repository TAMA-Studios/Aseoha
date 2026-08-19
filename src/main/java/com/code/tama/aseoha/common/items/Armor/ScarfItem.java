/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.common.items.Armor;

import static com.code.tama.aseoha.AseohaMod.MODID;

import com.code.tama.aseoha.client.Models.Armor.ScarfModel;
import com.code.tama.aseoha.client.Renderers.Armor.ScarfRenderer;
import org.jetbrains.annotations.Nullable;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class ScarfItem extends ModdedArmorItem {
	public ScarfItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
		super(pMaterial, pType, pProperties);
	}

	@Override
	protected ModelPart getRenderer(LivingEntity living, ItemStack stack, EquipmentSlot slot) {
		return new ScarfRenderer<>(ScarfModel::createBodyLayer, ScarfModel::new).makeArmorParts(slot);
	}

	@Override
	public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return makeCustomTextureLocation(MODID, "scarf");
	}
}
