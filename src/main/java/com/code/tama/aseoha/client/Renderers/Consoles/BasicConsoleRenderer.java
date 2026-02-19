/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.client.Renderers.Consoles;

import net.tardis.mod.blockentities.consoles.ConsoleTile;
import net.tardis.mod.client.models.IAnimatableTileModel;
import net.tardis.mod.client.renderers.consoles.ConsoleRenderer;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class BasicConsoleRenderer<T extends HierarchicalModel<?> & IAnimatableTileModel<ConsoleTile>>
		extends
			ConsoleRenderer<ConsoleTile, T> {
	public BasicConsoleRenderer(BlockEntityRendererProvider.Context context, T model, ResourceLocation tex) {
		super(context, model, tex);
	}
}
