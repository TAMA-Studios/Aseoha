package com.code.aseoha.client.models.controls;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ValveWheelModel extends EntityModel<Entity> {
	private final ModelRenderer bb_main;
	private final ModelRenderer Shape3_r1;

	public ValveWheelModel() {
		texWidth = 64;
		texHeight = 32;

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(0, 0).addBox(0.0F, -24.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bb_main.texOffs(4, 0).addBox(-0.5F, -26.0F, -0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bb_main.texOffs(12, 0).addBox(-5.0F, -25.0F, 0.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.texOffs(12, 2).addBox(-6.0F, -25.0F, 6.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.texOffs(0, 5).addBox(6.0F, -25.0F, -5.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
		bb_main.texOffs(12, 2).addBox(-5.0F, -25.0F, -6.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.texOffs(0, 5).addBox(-6.0F, -25.0F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
		bb_main.texOffs(38, 0).addBox(-6.0F, -28.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bb_main.texOffs(42, 0).addBox(-6.0F, -28.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Shape3_r1 = new ModelRenderer(this);
		Shape3_r1.setPos(-6.0F, 0.0F, 6.0F);
		bb_main.addChild(Shape3_r1);
		setRotationAngle(Shape3_r1, 0.0F, 1.5708F, 0.0F);
		Shape3_r1.texOffs(12, 0).addBox(0.0F, -25.0F, 6.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}