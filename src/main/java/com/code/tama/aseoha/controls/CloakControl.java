/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.controls;

import com.code.tama.aseoha.items.RoundelRemote;
import com.code.tama.aseoha.misc.IHelpWithMatterStateHandlers;
import net.tardis.mod.blockentities.exteriors.ExteriorTile;
import net.tardis.mod.cap.level.ITardisLevel;
import net.tardis.mod.control.Control;
import net.tardis.mod.control.ControlType;
import net.tardis.mod.control.datas.ControlDataBool;
import net.tardis.mod.control.datas.ControlDataFloat;
import net.tardis.mod.sound.SoundRegistry;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.server.ServerLifecycleHooks;

public class CloakControl extends Control<ControlDataBool> {
	public RoundelRemote.Range range = RoundelRemote.Range.LONGEST;

	public CloakControl(ControlType<ControlDataBool> type) {
		super(type);
	}

	public SoundEvent getDefaultSuccessSound(ControlDataFloat controlData) {
		return SoundRegistry.CONTROL_GENERIC.get();
	}

	public InteractionResult onUse(Player player, InteractionHand hand, ITardisLevel level) {
		if (hand != InteractionHand.MAIN_HAND)
			return InteractionResult.PASS;
		if (level.getLevel().isClientSide)
			return InteractionResult.PASS;

		if (ServerLifecycleHooks.getCurrentServer().getLevel(level.getDestination().getLevel())
				.getBlockEntity(level.getDestination().getPos()) instanceof ExteriorTile exteriorTile) {
			player.sendSystemMessage(Component.translatable("control.aseoha.cloak",
					!((IHelpWithMatterStateHandlers) exteriorTile.getMatterStateHandler()).Aseoha$IsCloaked()
							? "On"
							: "Off"));
			((IHelpWithMatterStateHandlers) exteriorTile.getMatterStateHandler()).Aseoha$SetCloaked(
					!((IHelpWithMatterStateHandlers) exteriorTile.getMatterStateHandler()).Aseoha$IsCloaked());
		}

		return InteractionResult.SUCCESS;
	}

	public InteractionResult onPunch(Player player, ITardisLevel level) {
		return InteractionResult.PASS;
	}

	@Override
	public ControlDataBool getData(ITardisLevel tardis) {
		return super.getData(tardis);
	}
}
