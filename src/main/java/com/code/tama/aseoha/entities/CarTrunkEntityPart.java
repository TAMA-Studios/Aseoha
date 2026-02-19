/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.entities;

import net.tardis.mod.entity.CarExteriorEntity;
import org.jetbrains.annotations.NotNull;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;

public class CarTrunkEntityPart<T extends CarExteriorEntity> extends net.tardis.mod.entity.CarTrunkEntityPart<T> {
	final EntityDimensions size;

	public CarTrunkEntityPart(T parent, float size) {
		super(parent, size);
		this.size = EntityDimensions.fixed(size, size);
		this.refreshDimensions();
	}

	public CarTrunkEntityPart(T parent, float size, float size2) {
		super(parent, size);
		this.size = EntityDimensions.fixed(size, size2);
		this.refreshDimensions();
	}

	@Override
	public @NotNull InteractionResult interact(Player pPlayer, InteractionHand pHand) {
		return this.getParent().getDoorHandler().onInteract(pPlayer, pPlayer.getItemInHand(pHand), pHand).isSuccess()
				? InteractionResult.sidedSuccess(pPlayer.level().isClientSide())
				: InteractionResult.PASS;
	}

	@Override
	public void tick() {
		super.tick();
		if (this.getParent().cachedTardis != null && !this.level().isClientSide()) {
			this.getParent().getTeleportHandler().tick((ServerLevel) this.level());
		}
	}

	public @NotNull EntityDimensions getDimensions(Pose pPose) {
		return this.size;
	}
}
