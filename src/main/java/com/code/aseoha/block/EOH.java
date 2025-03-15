package com.code.aseoha.block;

import com.code.aseoha.networking.Networking;
import com.code.aseoha.networking.Packets.EOHInteractPacket;
import com.code.aseoha.networking.Packets.PlayerItemRemovePacket;
import com.code.aseoha.tileentities.AseohaTiles;
import com.code.aseoha.tileentities.blocks.EOHTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.tardis.mod.helper.TardisHelper;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class EOH extends Block {
    public PlayerEntity LastPlayerClick;

    public boolean getHasStar() {
        return hasStar;
    }

    public void setHasStar(boolean hasStar) {
        this.hasStar = hasStar;
    }

    private boolean hasStar = false;

    /**
     * DON'T USE IF UNINITIALIZED
     */
    private EOHTile Tile;

    public EOH(Properties props) {
        super(props);
    }

    public static VoxelShape SHAPE = createVoxelShape();

    public static VoxelShape createVoxelShape() {
        VoxelShape shape = VoxelShapes.box(0, 0, 0, 1, 1, 1);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0, 0, 1, 1, 1), IBooleanFunction.OR);
        return shape;
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState state, @NotNull IBlockReader worldIn, @NotNull BlockPos pos, @NotNull ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        this.Tile = AseohaTiles.EYE_OF_HARMONY.get().create();
        return this.Tile;
    }

    @NotNull
    @Override
    public ActionResultType use(@NotNull BlockState p_225533_1_, @NotNull World p_225533_2_, @NotNull BlockPos p_225533_3_, @NotNull PlayerEntity p_225533_4_, @NotNull Hand p_225533_5_, @NotNull BlockRayTraceResult p_225533_6_) {
        /** Put this BEFORE we make the tile variable so we don't waste memory on a useless variable if this turns out to be server side **/
        if (!p_225533_2_.isClientSide) return ActionResultType.PASS;

        TileEntity tile = p_225533_2_.getBlockEntity(p_225533_3_);

        if (!(tile instanceof EOHTile)) return ActionResultType.PASS;

        if (this.hasStar) {
            ((EOHTile) tile).Activate(); // ACTIVATE
            ((EOHTile) tile).setChanged();
            Networking.sendToServer(new EOHInteractPacket(false));
            return ActionResultType.SUCCESS;
        }
        else {
            if (!p_225533_4_.getMainHandItem().getItem().equals(Items.NETHER_STAR)) return ActionResultType.FAIL;
            ((EOHTile) tile).setHasStar(true); // STAR
            this.LastPlayerClick = p_225533_4_;
            p_225533_4_.getMainHandItem().shrink(1);
            Networking.sendToServer(new EOHInteractPacket(true));
            Networking.sendToServer(new PlayerItemRemovePacket(p_225533_4_.getUUID()));
            this.hasStar = true;
            this.Mark();
            return ActionResultType.SUCCESS;
        }
    }

    public void Mark() {
        this.Tile.setChanged();
        this.Tile.Mark = true;
    }

    @Override
    public void destroy(@NotNull IWorld p_176206_1_, @NotNull BlockPos p_176206_2_, @NotNull BlockState p_176206_3_) {
        if (!TardisHelper.getConsoleInWorld((World) p_176206_1_).isPresent()) return;
        if (((World) p_176206_1_).getServer() == null) return;
        try {
            (((World) p_176206_1_).getServer()).tell(new TickDelayedTask(20, () -> TardisHelper.getConsoleInWorld((World) p_176206_1_).get().updateArtronValues()));
        } catch (Exception e) {
            throw new RuntimeException("Jeepers cripes alfrighty, you broke the game breaking the eoh, here's some data for ya\n" +
                    "Tile Data: \n" +
                    "Position: " + this.Tile != null ? this.Tile.getBlockPos().toString() : "Null" + "\n" +
                    "Level: " + this.Tile != null ? this.Tile.getLevel().dimension().toString() : "null");
        } finally {
            this.hasStar = false;
        }
    }
}
