package tama.mixin;

import net.tardis.mod.misc.MatterStateHandler;
import net.tardis.mod.network.packets.tardis.TardisExteriorExtraData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import tama.Misc.IHelpWithMatterStateHandlers;

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
