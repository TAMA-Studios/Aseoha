/* (C) TAMA Studios 2026 */
package com.code.tama.aseoha.client;

import static com.mojang.blaze3d.platform.InputConstants.*;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public class Keybinds {
	public static final KeyMapping REMOTE_TARDIS_GUI = new KeyMapping("aseoha.keybinds.tardis.gui",
			KeyConflictContext.IN_GAME, Type.KEYSYM, GLFW.GLFW_KEY_P, "aseoha.keybinds");

	public static final KeyMapping PICKER = new KeyMapping("aseoha.keybinds.tardis.cpicker", KeyConflictContext.IN_GAME,
			Type.KEYSYM, GLFW.GLFW_KEY_X, "aseoha.keybinds");
}
