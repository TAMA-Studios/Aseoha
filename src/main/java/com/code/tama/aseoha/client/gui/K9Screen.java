/* (C) TAMA Studios 2026 */
package com.code.tama.aseoha.client.gui;

import org.jetbrains.annotations.NotNull;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import com.code.tama.aseoha.AseohaMod;

public class K9Screen extends Screen {
	public static final Component TITLE = Component.translatable("gui.k9.title");
	public static final ResourceLocation TEXTURE = new ResourceLocation(AseohaMod.MODID, "textures/gui/monitors/k9.png");
	private static final int cWidth = 256;
	private static final int cHeight = 256;

	public K9Screen() {
		super(TITLE);
	}

	@Override
	protected void init() {
		super.init();
		this.children().clear();

		assert this.minecraft != null;
		AseohaMod.LOGGER.info("w={}, h={}", width, height);
		// this.minecraft.font.getClass();
		PlainTextButton button = new PlainTextButton(width, height, 20, 20, TITLE, (button1) -> {
			assert Minecraft.getInstance().player != null;
			Minecraft.getInstance().player.sendSystemMessage(TITLE);
		}, Minecraft.getInstance().font);
		this.addWidget(button);
	}

	@Override
	public void render(@NotNull GuiGraphics gui, int pMouseX, int pMouseY, float pPartialTick) {

		super.render(gui, pMouseX, pMouseY, pPartialTick);

		gui.blit(TEXTURE, ((width / 2) / 2), ((height / 2) / 2), 0, 0, width, height);

		for (Renderable render : this.renderables) {
			render.render(gui, pMouseX, pMouseY, pPartialTick);
		}

	}
}
