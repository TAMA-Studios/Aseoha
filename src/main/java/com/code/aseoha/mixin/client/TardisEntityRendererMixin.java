package com.code.aseoha.mixin.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.util.math.vector.Vector3f;
import net.tardis.mod.client.renderers.entity.transport.TardisEntityRenderer;
import net.tardis.mod.entity.TardisEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TardisEntityRenderer.class)
public class TardisEntityRendererMixin {
    @Unique
    private float Aseoha$SpinAmount = 0;
    @Inject(method = "render(Lnet/tardis/mod/entity/TardisEntity;FFLcom/mojang/blaze3d/matrix/MatrixStack;Lnet/minecraft/client/renderer/IRenderTypeBuffer;I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/tileentity/TileEntityRendererDispatcher;getRenderer(Lnet/minecraft/tileentity/TileEntity;)Lnet/minecraft/client/renderer/tileentity/TileEntityRenderer;"))
    public void render(TardisEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, CallbackInfo ci) {
//        if(((IHelpWithExterior)entity.getExterior()).Aseoha$ShouldSpin())
        if (!entity.getPassengers().isEmpty()) {
            matrixStackIn.translate(0.5, 0, 0.5);
            matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(++Aseoha$SpinAmount));
        }
    }
}
