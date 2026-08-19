/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.common.items.gadgets;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import net.tardis.mod.block.machines.ARSPanelBlock;
import net.tardis.mod.blockentities.ARSPanelTile;
import net.tardis.mod.world.data.ARSRoomLevelData;
import org.jetbrains.annotations.NotNull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class PortableARSPanel extends Item {

	public PortableARSPanel(Properties p_41383_) {
		super(p_41383_);
	}

	@Override
	public @NotNull InteractionResult useOn(@NotNull UseOnContext useOnContext) {
		use(useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getPlayer(), useOnContext.getHand(),
				new BlockHitResult(useOnContext.getClickLocation(), useOnContext.getHorizontalDirection(),
						useOnContext.getClickedPos(), useOnContext.isInside()));
		return super.useOn(useOnContext);
	}

	public InteractionResult use(Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pHit) {
		// List<BlockState> blocks = pLevel.getBlockStates(new AABB(pPos.getX() - 24,
		// pPos.getY() - 24, pPos.getZ() - 24, pPos.getX() + 24, pPos.getY() + 24,
		// pPos.getZ() + 24)).filter(p ->
		// p.getBlock().equals(BlockRegistry.ARS_PANEL.get())).toList();

		// if (pLevel instanceof ServerLevel server &&
		// !ARSPanelBlock.isInRepairableRoom(server, pPos)) {
		// return InteractionResult.sidedSuccess(pLevel.isClientSide());
		// }

		// if (pLevel.getBlockEntity(pPos) instanceof ARSPanelTile ars) {
		//
		// if (ars.doWork(pLevel, pHit.getLocation(), pPlayer.getItemInHand(pHand))) {
		// return InteractionResult.sidedSuccess(pLevel.isClientSide());
		// }
		//
		// if (pHand == InteractionHand.MAIN_HAND) {
		// if (!pLevel.isClientSide()) {
		//
		// assert pLevel instanceof ServerLevel;
		// ARSRoomLevelData.getData((ServerLevel) pLevel).getRoomFor(pPos)
		// .ifPresent(entry -> Tardis.LOGGER.debug("Found ARS Entry " +
		// entry.room.toString()));
		//
		// ars.displayMissingWork(pPlayer);
		// NetworkHooks.openScreen((ServerPlayer) pPlayer,
		// new SimpleMenuProvider((id, inv, player) -> new ARSMenu(id, inv, ars),
		// Component.empty()),
		// pPos);
		// }
		// }
		// }

		AtomicReference<InteractionResult> result = new AtomicReference<>();

		result.set(InteractionResult.SUCCESS);

		// ForBlocks((pos) -> {
		int range = 48;

		for (int x = -range / 2; x < range / 2; x++) {
			for (int y = -range / 2; y < range / 2; y++) {
				for (int z = -range / 2; z < range / 2; z++) {
					BlockPos pos = pPlayer.blockPosition().offset(x, y, z);

					if (pLevel.getBlockState(pos).getBlock() instanceof ARSPanelBlock) {

						AtomicBoolean panelInsideRoom = new AtomicBoolean(true);
						if (!pLevel.isClientSide())
							ARSRoomLevelData.getData((ServerLevel) pLevel).getRoomFor(pPos).ifPresent(entry -> {
								panelInsideRoom.set(entry.isInside(pos));
							});

						if (!panelInsideRoom.get())
							continue;
						BlockState state = pLevel.getBlockState(pos);
						ARSPanelTile ars = (ARSPanelTile) pLevel.getBlockEntity(pos);

						assert ars != null;

						if (ars.doWork(pLevel, ars.getBlockPos().getCenter(), pPlayer.getOffhandItem())) {
							result.set(InteractionResult.sidedSuccess(pLevel.isClientSide()));
							return result.get();
						} else {

							// assert pLevel instanceof ServerLevel;
							// ARSRoomLevelData.getData((ServerLevel) pLevel).getRoomFor(pPos)
							// .ifPresent(entry -> {
							// Tardis.LOGGER.debug("Found ARS Entry " + entry.room.toString());
							//
							// ars.displayMissingWork(pPlayer);
							// NetworkHooks.openScreen((ServerPlayer) pPlayer, new SimpleMenuProvider(
							// (id, inv, player) -> new ARSMenu(id, inv, ars), Component.empty()), pPos);
							// });

							state.use(pLevel, pPlayer, pHand,
									new BlockHitResult(pos.getCenter(), pHit.getDirection(), pos, false));
						}
					}

					// pLevel.setBlockAndUpdate(pos, state);
				}
			}
		}
		return result.get();
	}

	@Override
	public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int p_41431_) {
		super.onUseTick(level, entity, stack, p_41431_);

		if (entity instanceof Player player) {
			use(level, entity.blockPosition(), player, InteractionHand.MAIN_HAND, new BlockHitResult(
					entity.blockPosition().getCenter(), Direction.NORTH, entity.blockPosition(), false));
		}
	}

	public void ForBlocks(Consumer<BlockPos> run, Level level, BlockPos pos) {
		int range = 24;

		for (int x = -range / 2; x < range / 2; x++) {
			for (int y = -range / 2; y < range / 2; y++) {
				for (int z = -range / 2; z < range / 2; z++) {
					BlockPos relativePos = pos.offset(x, y, z);
					run.accept(relativePos);
				}
			}
		}
	}
}