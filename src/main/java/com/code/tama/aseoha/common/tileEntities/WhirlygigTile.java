/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.common.tileEntities;

import net.tardis.mod.cap.Capabilities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.level.block.state.BlockState;

public class WhirlygigTile extends TickingTile {
	public WhirlygigTile(BlockPos pos, BlockState state) {
		super(TileRegistry.WHIRLYGIG_TILE.get(), pos, state);
	}

	public final AnimationState ANIM = new AnimationState();

	@Override
	public void tick() {
		if (this.level != null && !this.level.isClientSide)
			return;

		assert this.level != null;
		this.level.getCapability(Capabilities.TARDIS).ifPresent(
				cap -> this.ANIM.animateWhen(cap.getFlightState().isFlying(), (int) cap.getAnimationTicks()));
	}
}
