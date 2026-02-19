/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.tileEntities;

import java.util.concurrent.atomic.AtomicBoolean;

import com.code.tama.aseoha.blocks.VortexDetectorBlock;
import net.tardis.mod.cap.Capabilities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class VortexDetectorTile extends TickingTile {
	public VortexDetectorTile(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
		super(p_155228_, p_155229_, p_155230_);
	}

	public VortexDetectorTile(BlockPos p_155229_, BlockState p_155230_) {
		super(TileRegistry.VORTEX_DETECTOR.get(), p_155229_, p_155230_);
	}

	@Override
	public void tick() {
		if (level != null && level.isClientSide)
			return;

		boolean shouldBeOn = this.shouldBeOn();
		if (shouldBeOn != this.getOn())
			this.setOn(shouldBeOn);
	}

	private boolean shouldBeOn() {
		AtomicBoolean bool = new AtomicBoolean();
		bool.set(false);
		assert level != null;
		level.getCapability(Capabilities.TARDIS).ifPresent(cap -> {
			bool.set(cap.getFlightState().isFlying() && !this.getInverted());
		});
		return bool.get();
	}

	private boolean getInverted() {
		assert level != null;
		BlockState state = level.getBlockState(worldPosition);
		if (state.hasProperty(VortexDetectorBlock.INVERTED))
			return state.getValue(VortexDetectorBlock.INVERTED);
		return false;
	}

	private void setOn(boolean on) {
		assert level != null;
		BlockState state = level.getBlockState(worldPosition);
		if (state.hasProperty(VortexDetectorBlock.POWERED))
			level.setBlockAndUpdate(worldPosition, state.setValue(VortexDetectorBlock.POWERED, on));
	}

	private boolean getOn() {
		assert level != null;
		BlockState state = level.getBlockState(worldPosition);
		if (state.hasProperty(VortexDetectorBlock.POWERED))
			return state.getValue(VortexDetectorBlock.POWERED);
		return false;
	}
}
