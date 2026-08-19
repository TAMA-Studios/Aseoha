/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.mixin;

import com.code.tama.aseoha.common.misc.IHelpWithMatterStateHandlers;
import net.tardis.mod.misc.MatterStateHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(MatterStateHandler.class)
public class ExteriorExtraDataMixin implements IHelpWithMatterStateHandlers {
	@Unique boolean Aseoha$IsCloaked = false;

	@Override
	public boolean Aseoha$IsCloaked() {
		return this.Aseoha$IsCloaked;
	}

	@Override
	public void Aseoha$SetCloaked(boolean IsCloaked) {
		this.Aseoha$IsCloaked = IsCloaked;
	}
}
