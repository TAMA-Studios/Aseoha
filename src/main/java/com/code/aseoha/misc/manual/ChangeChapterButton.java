//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.code.aseoha.misc.manual;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;

public class ChangeChapterButton extends Button {
    protected final boolean isForward;
    protected final boolean playTurnSound;
    protected final int width;
    protected final int height;

    public ChangeChapterButton(int x, int y, int width, int height, boolean isForward, Button.IPressable onPress, boolean playTurnSound) {
        super(x, y, width, height, StringTextComponent.EMPTY, onPress);
        this.isForward = isForward;
        this.playTurnSound = playTurnSound;
        this.width = width;
        this.height = height;
    }

    public ChangeChapterButton(int x, int y, boolean isForward, Button.IPressable onPress, boolean playTurnSound) {
        this(x, y, 17, 12, isForward, onPress, playTurnSound);
    }

    public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        Minecraft.getInstance().getTextureManager().bind(ManualScreen.TEXTURE);
        int u = 5;
        int v = 228;
        if (this.isHovered()) {
            u += 22;
        }

        if (!this.isForward) {
            v += 14;
        }

        this.blit(matrixStack, this.x, this.y, u, v, this.width, this.height);
    }

    public void playDownSound(SoundHandler handler) {
        if (this.playTurnSound) {
            handler.play(SimpleSound.forUI(SoundEvents.BOOK_PAGE_TURN, 1.0F));
        }

    }
}
