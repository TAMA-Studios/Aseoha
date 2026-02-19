/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.tileEntities.Console;

import com.code.tama.aseoha.tileEntities.TileRegistry;
import net.tardis.mod.blockentities.consoles.ConsoleTile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TokamakConsoleTile extends ConsoleTile {
	public TokamakConsoleTile(BlockPos pos, BlockState state) {
		super(TileRegistry.TOKAMAK_CONSOLE_TILE.get(), pos, state);
	}
}
