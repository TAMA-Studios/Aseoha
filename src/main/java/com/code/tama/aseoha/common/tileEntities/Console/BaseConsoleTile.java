/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.common.tileEntities.Console;

import net.tardis.mod.blockentities.consoles.ConsoleTile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;

public class BaseConsoleTile<T extends ConsoleTile> extends ConsoleTile {
	public BaseConsoleTile(BlockPos pos, BlockState state, RegistryObject<BlockEntityType<T>> te) {
		super(te.get(), pos, state);
	}
}
