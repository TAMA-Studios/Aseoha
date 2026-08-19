/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha;

import static com.code.tama.aseoha.common.blocks.ABlocks.BLOCKS;
import static com.code.tama.aseoha.common.registries.AItems.FOOD_ITEMS;
import static com.code.tama.aseoha.common.registries.AItems.ITEMS;
import static com.code.tama.aseoha.common.registries.ATabs.TABS;
import static com.code.tama.aseoha.common.registries.ControlRegistry.CONTROLS;

import com.code.tama.aseoha.common.blocks.Roundels;
import com.code.tama.aseoha.common.registries.*;
import com.code.tama.aseoha.server.capabilities.Capabilities;
import com.code.tama.aseoha.common.networking.Networking;
import com.code.tama.aseoha.common.tileEntities.ConsoleBlocks;
import com.code.tama.aseoha.common.tileEntities.ExteriorBlocks;
import com.code.tama.aseoha.common.tileEntities.ExteriorRegistry;
import com.code.tama.aseoha.common.tileEntities.TileRegistry;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AseohaMod.MODID)
@SuppressWarnings("removal")
public class AseohaMod {
	public static boolean EntityTickRateLimit = false;

	public static final String MODID = "aseoha";

	public static final Logger LOGGER = LogUtils.getLogger();

	public AseohaMod() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		FOOD_ITEMS.register(modEventBus);
		ASounds.SOUND_EVENTS.register(modEventBus);
		BLOCKS.register(modEventBus);
		Roundels.register(modEventBus);
		AEntities.TYPES.register(modEventBus);
		ConsoleBlocks.Register(modEventBus);
		ExteriorBlocks.EXTERIOR_BLOCKS.register(modEventBus);
		TileRegistry.TYPES.register(modEventBus);
		MonitorFunctionRegistry.FUNCTIONS.register(modEventBus);
		ExteriorRegistry.EXTERIORS.register(modEventBus);
		CONTROLS.register(modEventBus);
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientRegistry::RegisterBrokenExteriorRenderers);
		ITEMS.register(modEventBus);
		SubsystemsRegistry.register(modEventBus);
		TABS.register(modEventBus);
		modEventBus.addListener(this::commonSetup);
		modEventBus.addListener(this::clientSetup);
		FlightEventRegistry.FLIGHT_EVENTS.register(modEventBus);
		Networking.registerMessages();
		MinecraftForge.EVENT_BUS.addGenericListener(Entity.class, Capabilities::attachEntityCapability);
	}

	public void commonSetup(FMLCommonSetupEvent event) {
		SubsystemsRegistry.registerSubsystems();
	}

	public void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
		});
	}
}
