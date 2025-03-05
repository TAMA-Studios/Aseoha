package com.code.aseoha.client.renderers.sky;

import com.code.aseoha.misc.PlanetUVs;
import com.code.aseoha.misc.Planets;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
//import com.mojang.blaze3d.;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;
import net.tardis.mod.Tardis;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("deprecation")
public class KlomSkyRenderer implements ISkyRenderHandler {
    
    private VertexBuffer STAR_VERTEX_BUFFER;
    private VertexBuffer PLANET_VERTEX_BUFFER;
    private final ResourceLocation PLANETS_TEXTURE = new ResourceLocation(Tardis.MODID, "textures/sky/planets.png");
    private final VertexFormat VERTEX_FORMAT = DefaultVertexFormats.POSITION_COLOR;
    private final VertexFormat PLANET_VERTEX_FORMAT = DefaultVertexFormats.POSITION_TEX;

    @Override
    public void render(int ticks, float partialTicks, @NotNull MatrixStack matrixStack, @NotNull ClientWorld world, Minecraft mc) {
        matrixStack.pushPose();
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuilder();
        RenderSystem.disableTexture();
        RenderSystem.depthMask(false);
        RenderSystem.disableFog();
        RenderSystem.disableAlphaTest();
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.shadeModel(7425);
        this.DrawStars(bufferBuilder, matrixStack);
        RenderSystem.enableAlphaTest();
        RenderSystem.depthMask(true);
        RenderSystem.disableBlend();
        RenderSystem.shadeModel(7424);
        RenderSystem.enableTexture();
        RenderSystem.disableAlphaTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(false);
        matrixStack.pushPose();
        matrixStack.mulPose(Vector3f.ZN.rotation(world.getSunAngle(partialTicks)));
        matrixStack.translate(-10, 60, 60);
        float scale = 1.125F;
        matrixStack.scale(scale, scale, scale);
        Minecraft.getInstance().getTextureManager().bind(PLANETS_TEXTURE);
        this.GeneratePlanets(bufferBuilder, matrixStack);
        matrixStack.popPose();
        RenderSystem.disableTexture();
        RenderSystem.enableAlphaTest();
        RenderSystem.disableBlend();
        RenderSystem.depthMask(true);
        RenderSystem.enableFog();
        matrixStack.popPose();
    }

    private void DrawStars(BufferBuilder bufferbuilder, MatrixStack matrixStack){
        if (STAR_VERTEX_BUFFER == null) { // If the vbo is null (which it is when first called),
            // initialize it and render our data onto it
            this.STAR_VERTEX_BUFFER = new VertexBuffer(this.VERTEX_FORMAT);
            this.RenderSky(bufferbuilder, matrixStack);
            bufferbuilder.end();
            this.STAR_VERTEX_BUFFER.upload(bufferbuilder);
        }
        if (STAR_VERTEX_BUFFER != null) { // Once our rendering is done, set up the buffer and send the quads to the gpu
            STAR_VERTEX_BUFFER.bind();
           VERTEX_FORMAT.setupBufferState(0L);
            STAR_VERTEX_BUFFER.draw(matrixStack.last().pose(), GL11.GL_QUADS);
            VertexBuffer.unbind();
           VERTEX_FORMAT.clearBufferState();
        }

    }

    private void GeneratePlanets(BufferBuilder bufferbuilder, MatrixStack matrixStack){
        if (PLANET_VERTEX_BUFFER == null) {
            this.PLANET_VERTEX_BUFFER = new VertexBuffer(this.VERTEX_FORMAT);
            this.RenderSinglePlanets(bufferbuilder, matrixStack);
            bufferbuilder.end();
            this.PLANET_VERTEX_BUFFER.upload(bufferbuilder);
        }

        if(PLANET_VERTEX_BUFFER != null) {
            PLANET_VERTEX_BUFFER.bind();
           PLANET_VERTEX_FORMAT.setupBufferState(0L);
            PLANET_VERTEX_BUFFER.draw(matrixStack.last().pose(), GL11.GL_QUADS);
            VertexBuffer.unbind();
           PLANET_VERTEX_FORMAT.clearBufferState();
        }
    }

    private void RenderSinglePlanets(BufferBuilder bufferBuilder, MatrixStack matrixStack) {
        bufferBuilder.begin(GL11.GL_QUADS,PLANET_VERTEX_FORMAT);
        Matrix4f matrix4f = matrixStack.last().pose();

//        PlanetUVs mars = new PlanetUVs();
//        mars.SetHorizontalUVs(0.203125F, 0F, 0.29296875F, 0.08984375F);
//        mars.SetVerticleUVs(0.3046875F, 0F, 0.39453125F, 0.08984375F);

        this.RenderSinglePlanet(bufferBuilder, matrix4f, 45, -26, -40, 25, new Planets().GetMars());
    }

    private void RenderSky(@NotNull BufferBuilder bufferBuilder, @NotNull MatrixStack matrixStack) {
        bufferBuilder.begin(GL11.GL_QUADS,VERTEX_FORMAT);
        assert Minecraft.getInstance().level != null;
        Random rand = new Random(Minecraft.getInstance().level.getGameTime());
        int skySize = 190;
        Matrix4f matrix4f = matrixStack.last().pose();
        for(int i = 0; i < 1000; ++i){
            this.RenderStarDirectionUp(bufferBuilder, matrix4f, skySize - rand.nextFloat() * (skySize * 2), skySize, skySize - rand.nextFloat() * (skySize * 2));
        }

        for(int i = 0; i < 1000; ++i){
            this.RenderStarDirectionS(bufferBuilder, matrix4f, skySize - rand.nextFloat() * (skySize * 2), skySize - rand.nextFloat() * (skySize * 2), skySize);
        }

        for(int i = 0; i < 1000; ++i){
            this.RenderStarDirectionW(bufferBuilder, matrix4f, -skySize, skySize - rand.nextFloat() * (skySize * 2), skySize - rand.nextFloat() * (skySize * 2));
        }

        for(int i = 0; i < 1000; ++i){
            this.RenderStarDirectionN(bufferBuilder, matrix4f, skySize - rand.nextFloat() * (skySize * 2), skySize - rand.nextFloat() * (skySize * 2), -skySize);
        }

        for(int i = 0; i < 1000; ++i){
            this.RenderStarDirectionE(bufferBuilder, matrix4f, skySize, skySize - rand.nextFloat() * (skySize * 2), skySize - rand.nextFloat() * (skySize * 2));
        }

        for(int i = 0; i < 1000; ++i){
            this.renderStarDown(bufferBuilder, matrix4f, skySize - rand.nextFloat() * (skySize * 2), -skySize, skySize - rand.nextFloat() * (skySize * 2));
        }

    }

    private void RenderSinglePlanet(BufferBuilder bufferBuilder, Matrix4f matrix4f, float x, float y, float z, float size, PlanetUVs planet) {
        //NORTH
        bufferBuilder.vertex(matrix4f, x, y, z).uv(planet.MaximumHU, planet.MinimumHV).endVertex();
        bufferBuilder.vertex(matrix4f, x, y + size, z).uv(planet.MaximumHU, planet.MaximumHV).endVertex();
        bufferBuilder.vertex(matrix4f, x - size, y + size, z).uv(planet.MinimumHU, planet.MaximumHV).endVertex();
        bufferBuilder.vertex(matrix4f, x - size, y, z).uv(planet.MinimumHU, planet.MinimumHV).endVertex();

        //UP
        bufferBuilder.vertex(matrix4f, x - size, y + size, z - size).uv(planet.MinimumVU, planet.MinimumVV).endVertex();
        bufferBuilder.vertex(matrix4f, x - size, y + size, z).uv(planet.MinimumVU, planet.MaximumVV).endVertex();
        bufferBuilder.vertex(matrix4f, x, y + size, z).uv(planet.MaximumVU, planet.MaximumVV).endVertex();
        bufferBuilder.vertex(matrix4f, x, y + size, z - size).uv(planet.MaximumVU, planet.MinimumVV).endVertex();

        //East
        bufferBuilder.vertex(matrix4f, x, y, z - size).uv(planet.MinimumHU, planet.MinimumHV).endVertex();
        bufferBuilder.vertex(matrix4f, x, y + size, z - size).uv(planet.MinimumHU, planet.MaximumHV).endVertex();
        bufferBuilder.vertex(matrix4f, x, y + size, z).uv(planet.MaximumHU, planet.MaximumHV).endVertex();
        bufferBuilder.vertex(matrix4f, x, y, z).uv(planet.MaximumHU, planet.MinimumHV).endVertex();

        //West
        bufferBuilder.vertex(matrix4f, x - size, y, z).uv(planet.MinimumHU, planet.MinimumHV).endVertex();
        bufferBuilder.vertex(matrix4f, x - size, y + size, z).uv(planet.MinimumHU, planet.MaximumHV).endVertex();
        bufferBuilder.vertex(matrix4f, x - size, y + size, z - size).uv(planet.MaximumHU, planet.MaximumHV).endVertex();
        bufferBuilder.vertex(matrix4f, x - size, y, z - size).uv(planet.MaximumHU, planet.MinimumHV).endVertex();

        //SOUTH
        bufferBuilder.vertex(matrix4f, x - size, y, z - size).uv(planet.MinimumHU, planet.MinimumHV).endVertex();
        bufferBuilder.vertex(matrix4f, x - size, y + size, z - size).uv(planet.MinimumHU, planet.MaximumHV).endVertex();
        bufferBuilder.vertex(matrix4f, x, y + size, z - size).uv(planet.MaximumHU, planet.MaximumHV).endVertex();
        bufferBuilder.vertex(matrix4f, x, y, z - size).uv(planet.MaximumHU, planet.MinimumHV).endVertex();

        //Down
        bufferBuilder.vertex(matrix4f, x, y, z - size).uv(planet.MaximumVU, planet.MinimumVV).endVertex();
        bufferBuilder.vertex(matrix4f, x, y, z).uv(planet.MaximumVU, planet.MaximumVV).endVertex();
        bufferBuilder.vertex(matrix4f, x - size, y, z).uv(planet.MinimumVU, planet.MaximumVV).endVertex();
        bufferBuilder.vertex(matrix4f, x - size, y, z - size).uv(planet.MinimumVU, planet.MinimumVV).endVertex();

    }

    private void RenderStarDirectionUp(@NotNull BufferBuilder bufferBuilder, Matrix4f matrix4f, float x, float y, float z){
        float size = 0.5F;
        bufferBuilder.vertex(matrix4f, x, y, z).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x + size, y, z).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x + size, y, z + size).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x, y, z + size).color(1F, 1, 1, 1).endVertex();
    }

    private void RenderStarDirectionS(@NotNull BufferBuilder bufferBuilder, Matrix4f matrix4f, float x, float y, float z){
        float size = 0.5F;
        bufferBuilder.vertex(matrix4f, x, y, z).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x, y + size, z).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x + size, y + size, z).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x + size, y, z).color(1F, 1, 1, 1).endVertex();
    }

    private void RenderStarDirectionW(@NotNull BufferBuilder bufferBuilder, Matrix4f matrix4f, float x, float y, float z){
        float size = 0.5F;
        bufferBuilder.vertex(matrix4f, x, y, z).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x, y, z - size).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x, y + size, z - size).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x, y + size, z).color(1F, 1, 1, 1).endVertex();
    }

    private void RenderStarDirectionN(@NotNull BufferBuilder bufferBuilder, Matrix4f matrix4f, float x, float y, float z){
        float size = 0.5F;
        bufferBuilder.vertex(matrix4f, x, y, z).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x, y + size, z).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x - size, y + size, z).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x - size, y, z).color(1F, 1, 1, 1).endVertex();
    }

    private void RenderStarDirectionE(@NotNull BufferBuilder bufferBuilder, Matrix4f matrix4f, float x, float y, float z){
        float size = 0.5F;
        bufferBuilder.vertex(matrix4f, x, y, z).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x, y + size, z).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x, y + size, z - size).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x, y, z - size).color(1F, 1, 1, 1).endVertex();
    }

    private void renderStarDown(@NotNull BufferBuilder bufferBuilder, Matrix4f matrix4f, float x, float y, float z){
        float size = 0.5F;
        bufferBuilder.vertex(matrix4f, x, y, z).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x, y, z + size).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x + size, y, z + size).color(1F, 1, 1, 1).endVertex();
        bufferBuilder.vertex(matrix4f, x + size, y, z).color(1F, 1, 1, 1).endVertex();
    }
}
