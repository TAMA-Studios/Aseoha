/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.common.tileEntities.Console;

import com.code.tama.aseoha.common.tileEntities.TileRegistry;
import net.tardis.mod.blockentities.consoles.ConsoleTile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class CopperConsoleTile extends ConsoleTile {
	public CopperConsoleTile(BlockPos pos, BlockState state) {
		super(TileRegistry.COPPER_CONSOLE_TILE.get(), pos, state);
	}
}
