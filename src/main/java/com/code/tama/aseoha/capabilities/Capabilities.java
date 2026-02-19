/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.capabilities;

import static com.code.tama.aseoha.aseoha.MODID;

import javax.annotation.Nonnull;

import com.code.tama.aseoha.capabilities.Interfaces.IControlDiscCapability;
import com.code.tama.aseoha.capabilities.Interfaces.ITickrateCapability;
import com.code.tama.aseoha.capabilities.tick.TickrateCapabilityImpl;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.code.tama.aseoha.aseoha;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Capabilities {

	public static final Capability<IControlDiscCapability> CONTROL_DISC = CapabilityManager
			.get(new CapabilityToken<>() {
			});

	public static final Capability<ITickrateCapability> TICK_RATE = CapabilityManager.get(new CapabilityToken<>() {
	});

	static {
		aseoha.LOGGER.info("ASEOHA: Capabilities class loaded");
	}

	@SubscribeEvent
	public static void registerCaps(RegisterCapabilitiesEvent event) {
		aseoha.LOGGER.info("ASEOHA: Started Registering Capabilities");
		event.register(IControlDiscCapability.class);
		aseoha.LOGGER.info("ASEOHA: Finished Registering Capabilities");
	}

	public static <T, O extends ICapabilityProvider> LazyOptional<T> getCap(Capability<T> cap, O object) {
		if (object == null)
			return LazyOptional.empty();
		return object.getCapability(cap);
	}

	public static void attachEntityCapability(AttachCapabilitiesEvent<Entity> e) {
		e.addCapability(ITickrateCapability.ID, new ICapabilitySerializable<CompoundTag>() {
			final LazyOptional<ITickrateCapability> inst = LazyOptional.of(() -> {
				TickrateCapabilityImpl i = new TickrateCapabilityImpl();
				i.setEntity(e.getObject());
				return i;
			});

			@Nonnull
			@Override
			public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, Direction facing) {
				return TICK_RATE.orEmpty(capability, this.inst.cast());
			}

			@Override
			public CompoundTag serializeNBT() {
				return this.inst.orElseThrow(NullPointerException::new).serializeNBT();
			}

			@Override
			public void deserializeNBT(CompoundTag nbt) {
				this.inst.orElseThrow(NullPointerException::new).deserializeNBT(nbt);
			}
		});
	}
}
