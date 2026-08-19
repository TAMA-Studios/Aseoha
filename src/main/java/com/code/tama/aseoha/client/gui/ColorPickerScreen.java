/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.client.gui;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.code.tama.aseoha.AseohaMod;

@OnlyIn(Dist.CLIENT)
public class ColorPickerScreen extends Screen {
	private static final ResourceLocation COLOR_WHEEL = new ResourceLocation(AseohaMod.MODID,
			"textures/gui/color_wheel.png");// "textures/gui/color_wheel.png");

	private int wheelX, wheelY, wheelSize;
	private int selectedColor = 0xFFFFFF;

	public ColorPickerScreen() {
		super(Component.literal("Color Wheel"));
	}

	@Override
	protected void init() {
		super.init();
		wheelSize = 128; // size in pixels
		wheelX = (this.width - wheelSize) / 2;
		wheelY = (this.height - wheelSize) / 2;
	}

	@Override
	public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(graphics);

		// draw the wheel
		RenderSystem.setShaderTexture(0, COLOR_WHEEL);
		graphics.blit(COLOR_WHEEL, wheelX, wheelY, 0, 0, wheelSize, wheelSize, wheelSize, wheelSize);

		// draw currently selected color box
		graphics.fill(wheelX, wheelY + wheelSize + 10, wheelX + wheelSize, wheelY + wheelSize + 30,
				0xFF000000 | selectedColor);

		super.render(graphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		if (isInsideWheel(mouseX, mouseY)) {
			updateColor((int) mouseX, (int) mouseY);
			return true;
		}
		return super.mouseClicked(mouseX, mouseY, button);
	}

	@Override
	public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
		if (isInsideWheel(mouseX, mouseY)) {
			updateColor((int) mouseX, (int) mouseY);
			return true;
		}
		return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
	}

	private boolean isInsideWheel(double mouseX, double mouseY) {
		return mouseX >= wheelX && mouseX < wheelX + wheelSize && mouseY >= wheelY && mouseY < wheelY + wheelSize;
	}

	private void updateColor(int mouseX, int mouseY) {
		int texX = (int) ((mouseX - wheelX) * 256.0 / wheelSize);
		int texY = (int) ((mouseY - wheelY) * 256.0 / wheelSize);

		// Load pixel color from the texture
		Minecraft mc = Minecraft.getInstance();
		mc.getResourceManager().getResource(COLOR_WHEEL).ifPresent(res -> {
			try {
				NativeImage img = NativeImage.read(res.open());
				int pixel = img.getPixelRGBA(texX, texY);
				selectedColor = pixel;
				// selectedColor = (pixel >> 8) & 0xFFFFFF; // strip alpha
				System.out.println(selectedColor);
				img.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
