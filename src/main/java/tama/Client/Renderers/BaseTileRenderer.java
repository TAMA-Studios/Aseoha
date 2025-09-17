/* (C) TAMA Studios 2025 */
package tama.Client.Renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.cap.level.ITardisLevel;
import net.tardis.mod.client.models.IAnimatableTileModel;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class BaseTileRenderer<T extends BlockEntity, M extends EntityModel<Entity> & IAnimatableTileModel<T>>
        implements BlockEntityRenderer<T> {
    private final M model;
    private final ResourceLocation texture;

    /**
     * @param model the model that will get rendered
     * @param texture the texture to render the layer with
     */
    public BaseTileRenderer(BlockEntityRendererProvider.Context context, M model, ResourceLocation texture) {
        this.model = model;
        this.texture = texture;
    }

    @Override
    public void render(@NotNull T t, float v1, PoseStack poseStack, MultiBufferSource buffer, int light, int v2) {
        poseStack.pushPose();
        assert t.getLevel() != null;
        long animTicks = Capabilities.getCap(Capabilities.TARDIS, t.getLevel())
                .map(ITardisLevel::getAnimationTicks)
                .orElse(t.getLevel().getGameTime());

        this.model.setupAnimations(t, animTicks + v1);
        this.model.renderToBuffer(
                poseStack, buffer.getBuffer(RenderType.entityTranslucent(texture)), light, v2, 1, 1, 1, 1);
        poseStack.popPose();
    }
}
