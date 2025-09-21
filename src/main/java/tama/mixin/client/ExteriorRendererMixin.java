package tama.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.tardis.mod.client.animations.demat.DematAnimation;
import net.tardis.mod.client.renderers.exteriors.ExteriorRenderer;
import net.tardis.mod.misc.MatterStateHandler;
import net.tardis.mod.misc.enums.MatterState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import tama.Misc.IHelpWithMatterStateHandlers;

@Mixin(ExteriorRenderer.class)
public class ExteriorRendererMixin {

    @WrapOperation(remap = false,
            method = "render(Lnet/tardis/mod/blockentities/exteriors/ExteriorTile;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V",
            at = @At(value = "INVOKE", target = "Lnet/tardis/mod/misc/MatterStateHandler;getMatterState()Lnet/tardis/mod/misc/enums/MatterState;")
    )
    private MatterState getMatterState(MatterStateHandler instance, Operation<MatterState> original) {
        if (((IHelpWithMatterStateHandlers) instance).Aseoha$IsCloaked()) {
            return MatterState.DEMAT;
        } else {
            return original.call(instance);
        }
    }

    @WrapOperation(remap = false,
            method = "render(Lnet/tardis/mod/blockentities/exteriors/ExteriorTile;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V",
            at = @At(value = "INVOKE", target = "Lnet/tardis/mod/client/animations/demat/DematAnimation;getColors(Lnet/tardis/mod/misc/MatterStateHandler;F)[F")
    )
    private float[] getColors(DematAnimation instance, MatterStateHandler handler, float partialTicks, Operation<float[]> original) {
        if(((IHelpWithMatterStateHandlers) handler).Aseoha$IsCloaked()) return new float[] {0, 0, 0, 0};
        else return original.call(instance, handler, partialTicks);
    }
}
