/* (C) TAMA Studios 2025 */
package tama.Blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.Nullable;

public class AxisRotatedBlock extends Block {
    public AxisRotatedBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(
                this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext p_49820_) {
        return this.defaultBlockState()
                .setValue(
                        BlockStateProperties.HORIZONTAL_FACING,
                        p_49820_.getHorizontalDirection().getOpposite());
    }
}
