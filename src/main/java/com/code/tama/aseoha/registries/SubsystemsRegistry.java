/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.registries;

import com.code.tama.aseoha.subsystems.Type40NavCom;
import net.tardis.mod.registry.SubsystemRegistry;

import net.minecraftforge.eventbus.api.IEventBus;

public class SubsystemsRegistry {
	public static void register(IEventBus bus) {
	}

	public static void registerSubsystems() {
		SubsystemRegistry.NAV_COM.get().registerSubsystem(stack -> stack.getItem() == AItems.TYPE_40_NAV_COM.get(),
				Type40NavCom::new);
	}
}
