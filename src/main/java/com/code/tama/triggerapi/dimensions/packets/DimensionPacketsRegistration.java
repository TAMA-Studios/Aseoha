/* (C) TAMA Studios 2026 */
package com.code.tama.triggerapi.dimensions.packets;

import com.code.tama.aseoha.networking.Networking;

import com.code.tama.triggerapi.dimensions.packets.s2c.SyncDimensionsS2C;
import com.code.tama.triggerapi.dimensions.packets.s2c.UpdateDimensionsS2C;

public class DimensionPacketsRegistration {
	public static void registerPackets() {
		Networking.CHANNEL.registerMessage(Networking.id(), SyncDimensionsS2C.class, SyncDimensionsS2C::encode,
				SyncDimensionsS2C::decode, SyncDimensionsS2C::handle);

		Networking.CHANNEL.registerMessage(Networking.id(), UpdateDimensionsS2C.class, UpdateDimensionsS2C::encode,
				UpdateDimensionsS2C::decode, UpdateDimensionsS2C::handle);
	}
}
