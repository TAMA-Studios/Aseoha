/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.client.Renderers.Exteriors;

import com.code.tama.aseoha.client.Models.Exteriors.CapaldiExteriorModel;
import net.tardis.mod.blockentities.exteriors.ExteriorTile;
import net.tardis.mod.client.models.BaseTileHierarchicalModel;
import net.tardis.mod.client.models.exteriors.IExteriorModel;
import net.tardis.mod.client.renderers.exteriors.ExteriorRenderer;

import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.code.tama.aseoha.AseohaMod;

@OnlyIn(Dist.CLIENT)
public class CapaldiExteriorRenderer<T extends ExteriorTile, M extends BaseTileHierarchicalModel<T> & IExteriorModel<T>>
		extends
			ExteriorRenderer<T, M> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(AseohaMod.MODID,
			"textures/exteriors/capaldi.png");

	public CapaldiExteriorRenderer(BlockEntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public M bakeModel(EntityModelSet set) {
		return (M) new CapaldiExteriorModel<T>(set.bakeLayer(CapaldiExteriorModel.LAYER_LOCATION));
	}

	@Override
	public ResourceLocation getTexture(T exterior) {
		return TEXTURE;
	}
}
