/* (C) TAMA Studios 2025 */
package com.code.tama.triggerapi;

import java.util.ArrayList;
import java.util.List;

import com.code.tama.aseoha.AseohaMod;
import com.code.tama.aseoha.common.blocks.ABlocks;
import com.code.tama.aseoha.common.registries.AEntities;
import com.code.tama.aseoha.common.registries.AItems;
import com.code.tama.aseoha.common.registries.ControlRegistry;
import com.code.tama.aseoha.common.registries.FlightEventRegistry;
import com.code.tama.aseoha.common.tileEntities.ExteriorRegistry;
import net.tardis.mod.Constants;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.loading.FMLLoader;

/**
 * This is for functions related to string manipulation
 *
 * @version 2.6
 */
public class GrammarNazi {
	private static final List<String> MissingTranslations = new ArrayList<>();

	public GrammarNazi() {
	}

	/**
	 * @return The ID of an Item
	 */
	public static String BlockPosToString(BlockPos blockPos) {
		return blockPos.toString().toLowerCase().replace("blockpos", "").replaceAll("[{}:xyz=]", "");
	}

	/**
	 * @return The Original text with all first letters capitalized
	 */
	public static String CapitalizeFirstLetters(String text) {
		String firstLetter = text.substring(0, 1).toUpperCase();
		/*
		 * - - Find any characters coming after a space char and replace it with the -
		 * uppercase variant -
		 */
		for (int i = 0; i < text.length(); i++) {
			if (text.substring(i, i + 1).contains(" "))
				text = text.replace(text.substring(i, i + 2), text.substring(i, i + 2).toUpperCase());
		}
		return firstLetter + text.substring(1);
	}

	/**
	 * Replaces Underscore characters ('_') with space characters (' ') and
	 * capitalizes the first letter of every word
	 */
	public static String CleanString(String text) {
		return CapitalizeFirstLetters(ScoreToSpace(text));
	}

	/**
	 * Made to accept Item#toString(), remove the minecraft:item@modid, and
	 * capitalize every first letter of every word while also replacing underscores
	 * with spaces
	 *
	 * @param text
	 *            Item#toString()
	 * @return Item#toString() without minecraft:item@modid and every first letter
	 *         of every word capitalized
	 */
	public static String CleanItemString(String text) {
		/** remove minecraft:item@modid */
		text = text.replace("minecraft:item@" + TriggerAPI.getModId() + ":", "");
		return CapitalizeFirstLetters(ScoreToSpace(text));
	}

	/**
	 * @return The ID of a Block (With Namespace)
	 */
	public static String FullIDFromBlock(Block block) {
		return block.toString().replace("{", "").replace("}", "").toLowerCase().substring(5);
	}

	/**
	 * @return The ID of a Block
	 */
	public static String IDFromBlock(Block block) {
		return block.toString().replaceAll(AseohaMod.MODID + ":", "").replaceAll("minecraft:", "").replace("{", "")
				.replace("}", "").replace(":", "").toLowerCase().substring(5);
	}

	/**
	 * @return The ID of an Item
	 */
	public static String IDFromItem(Item item) {
		return item.toString().replaceAll(TriggerAPI.getModId(), "").replaceAll("[{}:]", "").toLowerCase();
	}

	/**
	 * Replace _ chars with space chars
	 */
	public static String ScoreToSpace(String text) {
		return text.replace("_", " ");
	}

	/**
	 *
	 * @param strings
	 *            Strings to stitch together
	 * @return All the strings as one string
	 */
	public static String Stitch(String... strings) {
		StringBuilder toReturn = new StringBuilder();
		for (String string : strings) {
			toReturn.append(string);
		}

		return toReturn.toString();
	}

	/**
	 * @param delimiter
	 *            Delimiter to put in between Strings
	 * @param strings
	 *            Strings to stitch together
	 * @return All the strings as one string
	 */
	public static String StitchWithDelimeter(String delimiter, String... strings) {
		StringBuilder toReturn = new StringBuilder();
		for (String string : strings) {
			toReturn.append(delimiter).append(string);
		}

		return toReturn.toString();
	}

	public static void checkTranslation(String key) {
		String translation = I18n.get(key); // I18n.get(key);
		if (translation == null || translation.equals(key) || translation.isEmpty()) {
			MissingTranslations.add(key);
			// throw new RuntimeException("Missing translation key: " + key);
		}
	}

	public static void checkAllTranslations() {
		if (FMLLoader.isProduction())
			return;
		AItems.ITEMS.getEntries().forEach(item -> {
			String key = item.get().getDescriptionId();
			checkTranslation(key);
		});

		ABlocks.BLOCKS.getEntries().forEach(block -> {
			String key = block.get().getDescriptionId();
			checkTranslation(key);
		});

		AEntities.TYPES.getEntries().forEach(entity -> {
			String key = entity.get().getDescriptionId();
			checkTranslation(key);
		});

		ControlRegistry.CONTROLS.getEntries().forEach(mode -> {
			String key = mode.get().getTranslationKey();
			checkTranslation(key);
		});

		FlightEventRegistry.FLIGHT_EVENTS.getEntries().forEach(mode -> {
			String key = Constants.Translation
					.makeGenericTranslation(net.tardis.mod.registry.FlightEventRegistry.REGISTRY.get(), mode.get());
			checkTranslation(key);
		});

		ExteriorRegistry.EXTERIORS.getEntries().forEach(exterior -> {
			String key = Constants.Translation
					.makeGenericTranslation(net.tardis.mod.registry.ExteriorRegistry.REGISTRY.get(), exterior.get());
			checkTranslation(key);
		});

		if (!MissingTranslations.isEmpty()) {
			AseohaMod.LOGGER.error("Missing translations!");
			MissingTranslations.forEach(AseohaMod.LOGGER::error);

//			throw new RuntimeException();
		}
	}

}