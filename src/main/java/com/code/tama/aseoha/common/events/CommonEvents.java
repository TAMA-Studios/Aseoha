/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.common.events;

import static com.code.tama.aseoha.AseohaMod.MODID;

import com.code.tama.aseoha.client.Keybinds;
import com.code.tama.aseoha.client.gui.ColorPickerScreen;
import com.code.tama.aseoha.client.gui.K9Screen;
import com.code.tama.aseoha.common.events.custom.ControlEvent;
import com.code.tama.aseoha.common.misc.TickrateManager;
import com.code.tama.aseoha.common.misc.XtonicImmune;
import com.code.tama.aseoha.common.networking.Networking;
import com.code.tama.aseoha.common.networking.c2s.SnapPacketC2S;
import com.code.tama.aseoha.common.networking.s2c.UpdateAreaTickratePacketS2C;
import com.code.tama.aseoha.common.networking.s2c.UpdateDimensionTickratePacketS2C;
import com.code.tama.aseoha.common.registries.ADimensions;
import com.code.tama.aseoha.common.registries.DamageTypes;
import com.code.tama.aseoha.server.data.QuantiscopeDataLoader;
import com.code.tama.aseoha.server.world.Dimensions;
import com.code.tama.aseoha.server.world.TickrateSavedData;
import net.tardis.api.events.TardisEvent;
import net.tardis.mod.block.ExteriorBlock;
import net.tardis.mod.cap.level.ITardisLevel;
import net.tardis.mod.config.Config;
import net.tardis.mod.misc.SpaceTimeCoord;
import net.tardis.mod.registry.ControlRegistry;
import net.tardis.mod.registry.SubsystemRegistry;
import net.tardis.mod.upgrade.Upgrade;
import net.tardis.mod.upgrade.tardis.BaseTardisUpgrade;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.code.tama.triggerapi.GrammarNazi;
import com.code.tama.triggerapi.universal.UniversalServerOnly;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEvents {

	@SubscribeEvent
	public static void chatEvent(ServerChatEvent event) {
		if (event.getMessage().getString().contains("k9")) {
			String msg = event.getMessage().getString();
		}
	}

	@SubscribeEvent
	public static void onAddReloadListeners(AddReloadListenerEvent event) {
		event.addListener(new QuantiscopeDataLoader());
	}

	@SubscribeEvent
	public static void OnSonicInsert(ControlEvent.SonicInsertEvent event) {
		/** If the item being inserted is Minecraft's Music Disc 11 * */
		if (event.getItem().getItem().equals(Items.MUSIC_DISC_11)) {
			/** Unlock Trenzalore, Set destination, and take off * */
			event.getTARDIS().getUnlockHandler().unlock(Dimensions.TRENZALORE_TYPE);
			event.getTARDIS()
					.setDestination(new SpaceTimeCoord(Dimensions.TRENZALORE, new BlockPos(0, 64, 0), Direction.NORTH));
			event.getTARDIS().takeoff();
		}
	}

	@SubscribeEvent
	public static void OnWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase != TickEvent.Phase.END)
			return;
		if (event.level == null)
			return;
		if (event.level.isClientSide)
			return;
		if (event.level.getServer() == null)
			return;
		if (event.level.getServer().getLevel(event.level.dimension()) == null)
			return;
		if (event.level.getServer() == null)
			return;
		UniversalServerOnly.getServer().getLevel(event.level.dimension()).getAllEntities().forEach((entity -> {
			if (entity instanceof Projectile projectile) {
				BlockPos touchingPos = projectile.blockPosition().relative(projectile.getDirection(), 1);
				BlockState touching = event.level.getBlockState(touchingPos);
				if (touching.getBlock() instanceof ExteriorBlock) {
					if (!entity.level().isClientSide) {
						UniversalServerOnly.getServer().getCommands().performPrefixedCommand(
								UniversalServerOnly.getServer().createCommandSourceStack().withEntity(entity)
										.withPosition(entity.position()).withSuppressedOutput(),
								"function aseoha:shield/animate");
					}
				}
			}

			if (event.level.dimension() == ADimensions.MIDNIGHT) {
				if (!(entity instanceof XtonicImmune) && entity instanceof LivingEntity livingEntity) {
					if (!entity.fireImmune())
						livingEntity.hurt(
								new DamageSource(livingEntity.level().registryAccess()
										.registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.XTONIC)),
								Integer.MAX_VALUE);
				}
			}
		}));
		event.level.getCapability(net.tardis.mod.cap.Capabilities.TARDIS).ifPresent(cap -> {
			cap.getSubsystem(SubsystemRegistry.NAV_COM.get()).ifPresent(navcom -> {
			});
			cap.getFuelHandler().flightTick(calcTravelSpeed(cap));
		});
	}

	public static float calcTravelSpeed(ITardisLevel cap) {
		float base = Config.Server.TARDIS_BASE_SPEED.get()
				* cap.getControlDataOrCreate(ControlRegistry.THROTTLE.get()).get();

		final TardisEvent.TardisSpeedCalcEvent event = new TardisEvent.TardisSpeedCalcEvent(cap, base);
		MinecraftForge.EVENT_BUS.post(event);

		float speed = event.getSpeed();
		for (Upgrade<?> upgrade : cap.getUpgrades()) {
			if (upgrade instanceof BaseTardisUpgrade upgrade1)
				speed *= upgrade1.speedMod();
		}

		return speed;
	}

	@SubscribeEvent
	public static void onLevelLoadEvent(LevelEvent.Load event) {
		ResourceKey<Level> dimension = ((Level) event.getLevel()).dimension();
		TickrateSavedData data = TickrateSavedData.get(dimension);
		if (data != null) {
			Networking.sendToAll(new UpdateDimensionTickratePacketS2C(dimension, data.getTimer().tickrate));
			data.getTickrateAreas()
					.forEach(t -> Networking.sendToAll(new UpdateAreaTickratePacketS2C(t.getLeft(), t.getRight())));
		}
	}

	@SubscribeEvent
	public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
		Entity entity = event.getEntity();
		TickrateManager.ENTITY_MAP.put(entity.getClass().hashCode(), entity);
		TickrateManager.ENTITY_MAP2.put(entity.getClass().getSuperclass().hashCode(), entity);
	}

	@SubscribeEvent
	public static void onClientTick(TickEvent.ClientTickEvent event) {
		if (event.phase == TickEvent.Phase.END) { // Only call code once as the tick event is called twice every tick
			GrammarNazi.checkAllTranslations();
			while (Keybinds.REMOTE_TARDIS_GUI.consumeClick())
				Minecraft.getInstance().setScreen(new K9Screen());

			while (Keybinds.PICKER.consumeClick())
				Minecraft.getInstance().setScreen(new ColorPickerScreen());

			while (Keybinds.THANOS.consumeClick())
				Networking.sendToServer(new SnapPacketC2S());
		}
	}
}
