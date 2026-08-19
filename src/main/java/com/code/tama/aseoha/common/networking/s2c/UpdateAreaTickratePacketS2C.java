/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.common.networking.s2c;

import java.util.Iterator;
import java.util.function.Supplier;

import com.code.tama.aseoha.common.misc.TickrateManager;
import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.util.LogicalSidedProvider;
import net.minecraftforge.network.NetworkEvent;

public class UpdateAreaTickratePacketS2C {
	private final AABB aabb;
	private final float tickrate;

	public UpdateAreaTickratePacketS2C(AABB aabb, float tickrate) {
		this.aabb = aabb;
		this.tickrate = tickrate;
	}

	public UpdateAreaTickratePacketS2C(FriendlyByteBuf buf) {
		this.aabb = new AABB(buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(),
				buf.readDouble());
		this.tickrate = buf.readFloat();
	}

	public void encode(FriendlyByteBuf buf) {
		buf.writeDouble(this.aabb.minX);
		buf.writeDouble(this.aabb.minY);
		buf.writeDouble(this.aabb.minZ);
		buf.writeDouble(this.aabb.maxX);
		buf.writeDouble(this.aabb.maxY);
		buf.writeDouble(this.aabb.maxZ);
		buf.writeFloat(this.tickrate);
	}

	public static class Handler {
		public static boolean onMessage(UpdateAreaTickratePacketS2C message, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				if (ctx.get().getDirection().getReceptionSide().isClient()) {
					LogicalSidedProvider.CLIENTWORLD.get(ctx.get().getDirection().getReceptionSide())
							.filter(ClientLevel.class::isInstance).ifPresent(t -> {
								if (message.tickrate == 20) {
									for (Iterator<Pair<AABB, Float>> itr = TickrateManager.AABB_LIST.iterator(); itr
											.hasNext();) {
										Pair<AABB, Float> next = itr.next();
										if (next.getLeft().equals(message.aabb)) {
											itr.remove();
										}
									}
								} else {
									TickrateManager.AABB_LIST.add(Pair.of(message.aabb, message.tickrate));
								}
							});
				}
			});
			ctx.get().setPacketHandled(true);
			return true;
		}
	}
}
