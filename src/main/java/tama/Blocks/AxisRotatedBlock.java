/* (C) TAMA Studios 2025 */
package tama.Blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.Nullable;

public class AxisRotatedBlock extends Block {
    public AxisRotatedBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.FACING, Direction.NORTH));
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext p_49820_) {
        return this.defaultBlockState()
                .setValue(
                        BlockStateProperties.FACING,
                        p_49820_.getHorizontalDirection().getOpposite());
    }
}
