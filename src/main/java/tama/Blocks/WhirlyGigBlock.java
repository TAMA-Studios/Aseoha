/* (C) TAMA Studios 2025 */
package tama.Blocks;

import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tama.TileEntities.TileRegistry;
import tama.TileEntities.WhirlygigTile;

public class WhirlyGigBlock extends BaseEntityBlock {

    public static final VoxelShape SHAPE = Shapes.create(0.25, 0, 0.25, 0.75, 1, 0.75);

    public WhirlyGigBlock() {
        super(Properties.of().strength(1.5f).noOcclusion().lightLevel(BlockState -> 1));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return TileRegistry.WHIRLYGIG_TILE.get().create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level pLevel, BlockState pState, BlockEntityType<T> otherType) {
        return WhirlygigTile::tick;
    }
}
