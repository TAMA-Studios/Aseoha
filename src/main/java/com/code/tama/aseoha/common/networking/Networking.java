/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.common.networking;

import com.code.tama.aseoha.AseohaMod;
import com.code.tama.aseoha.common.networking.c2s.SnapPacketC2S;
import com.code.tama.aseoha.common.networking.s2c.UpdateAreaTickratePacketS2C;
import com.code.tama.aseoha.common.networking.s2c.UpdateDimensionTickratePacketS2C;
import com.code.tama.aseoha.common.networking.s2c.UpdateTickratePacketS2C;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.server.ServerLifecycleHooks;

public class Networking {
	public static int ID;
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(AseohaMod.MODID, "aseoha"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static void registerMessages() {
		CHANNEL.registerMessage(ID++, UpdateTickratePacketS2C.class, UpdateTickratePacketS2C::encode,
				UpdateTickratePacketS2C::new, UpdateTickratePacketS2C.Handler::onMessage);
		CHANNEL.registerMessage(ID++, UpdateDimensionTickratePacketS2C.class, UpdateDimensionTickratePacketS2C::encode,
				UpdateDimensionTickratePacketS2C::new, UpdateDimensionTickratePacketS2C.Handler::onMessage);
		CHANNEL.registerMessage(ID++, UpdateAreaTickratePacketS2C.class, UpdateAreaTickratePacketS2C::encode,
				UpdateAreaTickratePacketS2C::new, UpdateAreaTickratePacketS2C.Handler::onMessage);

		CHANNEL.registerMessage(ID++, SnapPacketC2S.class, (msg, m) -> msg.encode(),
				SnapPacketC2S::new, SnapPacketC2S::onMessage);
	}

	public static <MSG> void sendToServer(MSG message) {
		CHANNEL.sendToServer(message);
	}

	public static <MSG> void sendToAll(MSG message) {
		for (ServerPlayer player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()) {
			CHANNEL.sendTo(message, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
		}
	}
	public static int id() {
		return ID++;
	}
}
