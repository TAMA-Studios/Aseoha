/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.common.registries;

import com.code.tama.aseoha.AseohaMod;
import com.code.tama.aseoha.common.blocks.Roundels;
import com.code.tama.aseoha.common.tileEntities.ConsoleBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ATabs {
	public static DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
			AseohaMod.MODID);

	public static RegistryObject<CreativeModeTab> MAIN = TABS.register("main",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(Roundels.COPPER_ROUNDEL.get()))
					.title(Component.translatable(buildName("main"))).build());

	public static RegistryObject<CreativeModeTab> CONSOLES = TABS.register("consoles",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(ConsoleBlocks.COPPER_CONSOLE_BLOCK.get()))
					.title(Component.translatable(buildName("consoles"))).build());

	public static RegistryObject<CreativeModeTab> FOOD = TABS.register("food",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(AItems.GOLDEN_POTATO.get()))
					.title(Component.translatable(buildName("food"))).build());

	public static String buildName(String name) {
		return "itemGroup." + AseohaMod.MODID + "." + name;
	}
}
