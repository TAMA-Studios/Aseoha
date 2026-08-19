/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.common.networking.c2s;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import net.tardis.mod.block.ExteriorBlock;
import net.tardis.mod.block.InteriorDoorBlock;
import net.tardis.mod.blockentities.InteriorDoorTile;
import net.tardis.mod.blockentities.exteriors.ExteriorTile;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.cap.level.ITardisLevel;
import net.tardis.mod.misc.DoorHandler;
import net.tardis.mod.misc.enums.DoorState;

import java.util.function.Supplier;

public class SnapPacketC2S {
	public SnapPacketC2S(FriendlyByteBuf buf) {}
	public SnapPacketC2S() {}
	public void encode() {}
	public void decode() {}

	public static boolean onMessage(SnapPacketC2S message, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			if (ctx.get().getSender() != null) {
				ServerPlayer player = ctx.get().getSender();
				Level l = player.level();
				BlockPos start = player.blockPosition().south(15).west(15).below(15);

				for (int x = start.getX(); x < start.getX() + 15; x++) {
					for (int y = start.getY(); y < start.getY() + 15; y++) {
						for (int z = start.getZ(); z < start.getZ() + 15; z++) {
							BlockPos pos = new BlockPos(x, y, z);
							if (l.getBlockState(pos).getBlock() instanceof ExteriorBlock) {
								ExteriorTile tile = (ExteriorTile) l.getBlockEntity(pos);

								if (!tile.getLinkedTardis().isPresent()) return;
								ITardisLevel level = tile.getLinkedTardis().orElse(null);
								if (level == null) return;

								if (level.getEmotionalHandler().getLoyalty(player.getUUID()).isPresent() && level.getEmotionalHandler().getLoyalty(player.getUUID()).get() > 100) {
									DoorHandler handler = tile.getDoorHandler();

									handler.setLocked(!handler.getDoorState().equals(DoorState.CLOSED));
									handler.setDoorState(handler.validDoorStates, handler.getDoorState().equals(DoorState.CLOSED) ? DoorState.BOTH : DoorState.CLOSED);
								}
							}

							if (l.getBlockState(pos).getBlock() instanceof InteriorDoorBlock<?>) {
								InteriorDoorTile tile = (InteriorDoorTile) l.getBlockEntity(pos);

								if (tile == null || tile.getDoorHandler() == null) return;
								DoorHandler handler = tile.getDoorHandler();

								ITardisLevel level = (ITardisLevel) Capabilities.getCap(Capabilities.TARDIS, tile.getLevel());
								if (level == null) return;

								if (level.getEmotionalHandler().getLoyalty(player.getUUID()).isPresent() && level.getEmotionalHandler().getLoyalty(player.getUUID()).get() > 100) {
									handler.setLocked(!handler.getDoorState().equals(DoorState.CLOSED));
									handler.setDoorState(handler.validDoorStates, handler.getDoorState().equals(DoorState.CLOSED) ? DoorState.BOTH : DoorState.CLOSED);
								}
							}
						}
					}
				}
			}
		});
		ctx.get().setPacketHandled(true);
		return true;
	}
}
