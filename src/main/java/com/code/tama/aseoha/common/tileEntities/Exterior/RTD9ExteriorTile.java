/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.common.tileEntities.Exterior;

import com.code.tama.aseoha.common.tileEntities.TileRegistry;
import net.tardis.mod.blockentities.exteriors.ExteriorTile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class RTD9ExteriorTile extends ExteriorTile {
	public RTD9ExteriorTile(BlockPos pos, BlockState state) {
		super(TileRegistry.RTD_9_EXTERIOR_TILE.get(), pos, state);
	}
}
