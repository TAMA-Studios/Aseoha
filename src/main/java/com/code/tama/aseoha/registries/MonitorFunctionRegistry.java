/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.registries;

import com.code.tama.aseoha.client.gui.MonitorColorPickerScreen;
import net.tardis.mod.helpers.Helper;
import net.tardis.mod.misc.tardis.montior.MonitorFunction;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import com.code.tama.aseoha.aseoha;

public class MonitorFunctionRegistry {

	public static final DeferredRegister<MonitorFunction> FUNCTIONS = DeferredRegister
			.create(Helper.createRL("monitor_functions"), aseoha.MODID);

	public static final RegistryObject<MonitorColorPickerScreen> CUSTOMIZATION = FUNCTIONS
			.register("interior/customization", MonitorColorPickerScreen::new);
}
