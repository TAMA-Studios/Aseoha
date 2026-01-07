//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.code.aseoha.misc.manual;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.tardis.mod.client.guis.manual.ManualScreen;
import org.jetbrains.annotations.NotNull;

public class ReturnToIndexButton extends ChangeChapterButton {
    public ReturnToIndexButton(int x, int y, boolean isForward, Button.IPressable onPress, boolean playTurnSound) {
        super(x, y, 12, 16, isForward, onPress, playTurnSound);
    }

    public void renderButton(@NotNull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        Minecraft.getInstance().getTextureManager().bind(ManualScreen.TEXTURE);
        int u = 52;
        int v = 200;
        if (this.isHovered()) {
            u += 22;
        }

        if (!this.isForward) {
            v += 19;
        }

        this.blit(matrixStack, this.x, this.y, u, v, this.width, this.height);
    }
}
