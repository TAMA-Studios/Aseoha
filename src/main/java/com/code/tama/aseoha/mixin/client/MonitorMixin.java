/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.mixin.client;

import net.tardis.mod.client.gui.monitor.MonitorScreen;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

@Mixin(MonitorScreen.class)
public abstract class MonitorMixin extends Screen {

	protected MonitorMixin(Component p_96550_) {
		super(p_96550_);
	}

	@Override
	public boolean isPauseScreen() {
		return false;
	}
}
