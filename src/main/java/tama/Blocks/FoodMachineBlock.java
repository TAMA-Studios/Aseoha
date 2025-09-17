/* (C) TAMA Studios 2025 */
package tama.Blocks;

import java.util.Objects;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tardis.mod.cap.Capabilities;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class FoodMachineBlock extends Block implements SimpleWaterloggedBlock {
    VoxelShape voxel = Block.box(3, 0, 3.6999999999999997, 13, 22, 12.700000000000001);

    @NotNull
    @Override
    public VoxelShape getShape(
            @NotNull BlockState state,
            @NotNull BlockGetter worldIn,
            @NotNull BlockPos pos,
            @NotNull CollisionContext context) {
        return voxel.optimize();
    }

    public FoodMachineBlock(Properties prop) {
        super(prop);
        this.registerDefaultState(
                (BlockState) this.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[] {BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.WATERLOGGED});
    }

    @NotNull
    public FluidState getFluidState(BlockState state) {
        return (Boolean) state.getValue(BlockStateProperties.WATERLOGGED)
                ? Fluids.WATER.getSource(false)
                : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        return (BlockState) ((BlockState) Objects.requireNonNull(super.getStateForPlacement(context))
                        .setValue(
                                BlockStateProperties.HORIZONTAL_FACING,
                                Objects.requireNonNull(context.getPlayer())
                                        .getDirection()
                                        .getOpposite()))
                .setValue(BlockStateProperties.WATERLOGGED, fluid.getType().is(FluidTags.WATER));
    }

    @Override
    public @NotNull InteractionResult use(
            @NotNull BlockState state,
            @NotNull Level worldIn,
            @NotNull BlockPos pos,
            @NotNull Player player,
            @NotNull InteractionHand handIn,
            @NotNull BlockHitResult hit) {
        if (handIn.equals(InteractionHand.OFF_HAND) || worldIn.isClientSide) return InteractionResult.PASS;
        Capabilities.getCap(Capabilities.TARDIS, worldIn).ifPresent(console -> {
            if (console.getFuelHandler().getStoredArtron() >= (float) 16) {
                player.addItem(new ItemStack(Items.POTATO, (int) 1));

                console.getFuelHandler().takeArtron(16, false);
            }
        });
        return InteractionResult.SUCCESS;
    }
}

// package com.code.aseoha.block;
//
// import java.util.List;
// import net.minecraft.block.AbstractBlock;
// import net.minecraft.block.Block;
// import net.minecraft.block.BlockRenderType;
// import net.minecraft.block.BlockState;
// import net.minecraft.block.IWaterLoggable;
// import net.minecraft.client.gui.screen.Screen;
// import net.minecraft.client.util.ITooltipFlag;
// import net.minecraft.entity.player.PlayerEntity;
// import net.minecraft.entity.player.ServerPlayerEntity;
// import net.minecraft.fluid.FluidState;
// import net.minecraft.fluid.Fluids;
// import net.minecraft.item.BlockItemUseContext;
// import net.minecraft.item.Item;
// import net.minecraft.item.ItemStack;
// import net.minecraft.item.Items;
// import net.minecraft.state.Property;
// import net.minecraft.state.StateContainer;
// import net.minecraft.state.properties.BlockStateProperties;
// import net.minecraft.tags.FluidTags;
// import net.minecraft.util.ActionResultType;
// import net.minecraft.util.Hand;
// import net.minecraft.util.math.BlockPos;
// import net.minecraft.util.math.BlockRayTraceResult;
// import net.minecraft.util.text.IFormattableTextComponent;
// import net.minecraft.util.text.ITextComponent;
// import net.minecraft.util.text.TranslationTextComponent;
// import net.minecraft.world.World;
// import net.minecraftforge.fml.network.NetworkHooks;
// import net.tardis.mod.blocks.MultiblockBlock;
// import net.tardis.mod.blocks.multiblock.MultiblockPatterns;
// import net.tardis.mod.constants.TardisConstants;
// import net.tardis.mod.constants.TardisConstants.Translations;
// import net.tardis.mod.containers.WaypointBankContainer;
// import net.tardis.mod.helper.TextHelper;
// import net.tardis.mod.helper.WorldHelper;
// import net.tardis.mod.items.MultiblockBlockItem;
// import net.tardis.mod.misc.ContainerProvider;
// import net.tardis.mod.tileentities.WaypointBankTile;
//
// public class FoodMachineBlock extends MultiblockBlock implements IWaterLoggable {
//    public FoodMachineBlock(AbstractBlock.Properties prop) {
//        super(prop);
//        this.registerDefaultState((BlockState)this.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED,
// false));
//    }
//
//    public BlockRenderType getRenderShape(BlockState state) {
//        return BlockRenderType.MODEL;
//    }
//
//    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
//        builder.add(new Property[]{BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.WATERLOGGED});
//    }
//
//    public FluidState getFluidState(BlockState state) {
//        return (Boolean)state.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) :
// super.getFluidState(state);
//    }
//
//    public BlockState getStateForPlacement(BlockItemUseContext context) {
//        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
//        return
// (BlockState)((BlockState)super.getStateForPlacement(context).setValue(BlockStateProperties.HORIZONTAL_FACING,
// context.getPlayer().getDirection().getOpposite())).setValue(BlockStateProperties.WATERLOGGED,
// fluid.getFluidState().is(FluidTags.WATER));
//    }
//
//    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
// BlockRayTraceResult hit) {
////        if (!worldIn.isClientSide) {
////            NetworkHooks.openGui((ServerPlayerEntity)player, new ContainerProvider("container.tardis.waypoint", (id,
// inv, player1) -> {
////                return new WaypointBankContainer(id, inv, (WaypointBankTile)worldIn.getBlockEntity(pos));
////            }), pos);
////        }
////
////        return ActionResultType.SUCCESS;
//
//        if (!WorldHelper.isDimensionBlocked(worldIn)) {
//            if (worldIn.isClientSide) {
//                if (player.isCrouching()) {
//                    player.addItem(new ItemStack(Items.COOKED_BEEF, 16));
//                }
//                else  {
//                    player.addItem(new ItemStack(Items.COOKED_BEEF, 1));
//                }
//            }
//        } else if (!worldIn.isClientSide()) {
//            player.displayClientMessage(TardisConstants.Translations.NO_USE_OUTSIDE_TARDIS, true);
//        }
//
//        return ActionResultType.SUCCESS;
//    }
//
// }
//
// public static class FoodMachineBlockItem extends MultiblockBlockItem {
//    private final IFormattableTextComponent descriptionTooltip = TextHelper.createDescriptionItemTooltip(new
// TranslationTextComponent("tooltip.food_machine.desc"));
//
//    public FoodMachineBlockItem(Block blockIn, MultiblockPatterns.MultiblockPattern pattern, Item.Properties builder)
// {
//        super(blockIn, pattern, builder);
//    }
//
//    public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
//        super.appendHoverText(stack, worldIn, tooltip, flagIn);
//        tooltip.add(Translations.TOOLTIP_CONTROL);
//        if (Screen.hasControlDown()) {
//            tooltip.clear();
//            tooltip.add(0, stack.getHoverName());
//            tooltip.add(this.descriptionTooltip);
//        }
//
//    }
// }
// }
