/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.blocks;

import com.code.tama.aseoha.tileEntities.TileRegistry;
import com.code.tama.aseoha.tileEntities.WhirlygigTile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WhirlyGigBlock extends BaseEntityBlock {

	public static final VoxelShape SHAPE = Shapes.create(0.25, 0, 0.25, 0.75, 1, 0.75);

	public WhirlyGigBlock() {
		super(Properties.of().strength(1.5f).noOcclusion().lightLevel(BlockState -> 1));
	}

	@Nullable @Override
	public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
		return TileRegistry.WHIRLYGIG_TILE.get().create(pos, state);
	}

	@Nullable @Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
			BlockEntityType<T> otherType) {
		return WhirlygigTile::tick;
	}
}
