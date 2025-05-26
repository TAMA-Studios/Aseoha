package com.code.aseoha.client.models.controls;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ScreenModel extends EntityModel<Entity> {
	private final ModelRenderer Shape1;

	public ScreenModel() {
		texWidth = 8;
		texHeight = 8;

		Shape1 = new ModelRenderer(this);
		Shape1.setPos(0.0F, 0.0F, 0.0F);
		Shape1.texOffs(-8, 0).addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Shape1.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape1.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}