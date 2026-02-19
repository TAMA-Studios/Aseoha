/* (C) TAMA Studios 2026 */
package com.code.tama.aseoha.manual;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

import com.code.tama.tts.TTSMod;
import com.google.common.collect.Lists;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.Level;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;

public class Index {
	private List<Chapter> chapters = Lists.newArrayList();

	public Index(List<Chapter> chapters) {
		this.chapters.addAll(chapters);
	}

	public List<Chapter> getChapters() {
		return this.chapters;
	}

	public static Index read(ResourceLocation id, JsonObject object, String localeCode) {
		try {
			List<Chapter> chapters = Lists.newArrayList();

			for (JsonElement e : object.get("chapters").getAsJsonArray()) {
				ResourceLocation chapterID = Chapter.getChapterResourceLocation(new ResourceLocation(e.getAsString()),
						localeCode);
				chapters.add(Chapter.read(chapterID, getResourceAsJson(chapterID), localeCode));
			}

			return new Index(chapters);

		} catch (Exception e) {
			TTSMod.LOGGER.log(Level.ALL, "Caught error in manual index {}", id.toString());
			return null;
		}
	}

	public static ResourceLocation getIndexResourceLocation(ResourceLocation loc, String localeCode) {
		return new ResourceLocation(loc.getNamespace(), "manual/" + localeCode + "/index/" + loc.getPath() + ".json");
	}

	public static JsonObject getResourceAsJson(ResourceLocation loc) {
		try {
			Optional<Resource> resource = Minecraft.getInstance().getResourceManager().getResource(loc);
			if (resource.isPresent()) {
				return (new JsonParser()).parse(new InputStreamReader(resource.get().open())).getAsJsonObject();
			}
		} catch (IOException e) {
			TTSMod.LOGGER.log(Level.ALL, "Error occured parsing json file " + loc.toString());
			TTSMod.LOGGER.catching(Level.ALL, e);
		}

		return null;
	}

}