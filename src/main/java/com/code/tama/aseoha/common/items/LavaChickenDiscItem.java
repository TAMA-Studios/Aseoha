/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.common.items;

import com.code.tama.aseoha.common.registries.ASounds;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

public class LavaChickenDiscItem extends RecordItem {
	public LavaChickenDiscItem() {
		super(15, ASounds.LAVA_CHICKEN.get(), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 20); // TODO: Set
																											// the tick
																											// duration
																											// properly
	}
}
