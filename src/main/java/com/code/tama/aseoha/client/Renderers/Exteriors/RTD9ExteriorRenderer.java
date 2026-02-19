/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.client.Renderers.Exteriors;

import com.code.tama.aseoha.client.Models.Exteriors.RTD9ExteriorModel;
import net.tardis.mod.blockentities.exteriors.ExteriorTile;
import net.tardis.mod.client.models.BaseTileHierarchicalModel;
import net.tardis.mod.client.models.exteriors.IExteriorModel;
import net.tardis.mod.client.renderers.exteriors.ExteriorRenderer;

import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.code.tama.aseoha.aseoha;

@OnlyIn(Dist.CLIENT)
public class RTD9ExteriorRenderer<T extends ExteriorTile, M extends BaseTileHierarchicalModel<T> & IExteriorModel<T>>
		extends
			ExteriorRenderer<T, M> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(aseoha.MODID,
			"textures/exteriors/colin_richmond/rtd_9.png");

	public RTD9ExteriorRenderer(BlockEntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public M bakeModel(EntityModelSet set) {
		return (M) new RTD9ExteriorModel<T>(set.bakeLayer(RTD9ExteriorModel.LAYER_LOCATION));
	}

	@Override
	public ResourceLocation getTexture(T exterior) {
		return TEXTURE;
	}
}
