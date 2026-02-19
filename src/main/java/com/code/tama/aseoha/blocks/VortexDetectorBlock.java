/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.blocks;

import com.code.tama.aseoha.tileEntities.TileRegistry;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VortexDetectorBlock extends net.minecraft.world.level.block.Block implements EntityBlock {

	public static final BooleanProperty POWERED = BooleanProperty.create("powered");
	public static final BooleanProperty INVERTED = BooleanProperty.create("inverted");

	public VortexDetectorBlock() {
		super(Properties.of());
		this.registerDefaultState(this.defaultBlockState().setValue(POWERED, false).setValue(INVERTED, false));
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
			BlockHitResult hit) {
		if (handIn == InteractionHand.MAIN_HAND && !worldIn.isClientSide) {
			// Helper.cycleBlockStateProperty(state, INVERTED);
			worldIn.setBlockAndUpdate(pos, state.setValue(INVERTED, !state.getValue(INVERTED)));
		}
		return InteractionResult.sidedSuccess(worldIn.isClientSide);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return Shapes.create(0, 0, 0, 1, 0.375, 1);
	}

	@Override
	public boolean isSignalSource(BlockState state) {
		return this.getPower(state) != 0;
	}

	public int getSignal(BlockState state, BlockGetter p_60484_, BlockPos p_60485_, Direction p_60486_) {
		return this.getPower(state);
	}

	@Override
	public int getDirectSignal(BlockState blockState, BlockGetter blockAccess, BlockPos pos, Direction side) {
		return this.getPower(blockState);
	}

	public int getPower(BlockState state) {
		return state.getValue(POWERED) ? 15 : 0;
	}

	@Override
	public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return TileRegistry.VORTEX_DETECTOR.get().create(pos, state);
	}
}
