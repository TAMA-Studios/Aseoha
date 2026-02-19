/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.tileEntities.Exterior;

import com.code.tama.aseoha.tileEntities.TileRegistry;
import net.tardis.mod.blockentities.exteriors.ExteriorTile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class CapaldiExteriorTile extends ExteriorTile {
	public CapaldiExteriorTile(BlockPos pos, BlockState state) {
		super(TileRegistry.CAPALDI_EXTERIOR_TILE.get(), pos, state);
	}
}
