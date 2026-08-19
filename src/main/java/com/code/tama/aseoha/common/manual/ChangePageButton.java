/* (C) TAMA Studios 2026 */
package com.code.tama.aseoha.common.manual;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChangePageButton extends Button {
	private final boolean isForward;
	public static final ResourceLocation BOOK_LOCATION = new ResourceLocation("textures/gui/book.png");
	private final boolean playTurnSound;

	public ChangePageButton(int p_i51079_1_, int p_i51079_2_, boolean p_i51079_3_, OnPress p_i51079_4_,
			boolean p_i51079_5_) {
		super(p_i51079_1_, p_i51079_2_, 23, 13, Component.empty(), p_i51079_4_, DEFAULT_NARRATION);
		this.isForward = p_i51079_3_;
		this.playTurnSound = p_i51079_5_;
	}

	@Override
	public void playDownSound(SoundManager soundManager) {
		if (this.playTurnSound) {
			soundManager.play(SimpleSoundInstance.forUI(SoundEvents.BOOK_PAGE_TURN, 1.0F));
		}
	}
}
