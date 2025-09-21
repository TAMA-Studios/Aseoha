package tama.mixin;

import net.minecraft.nbt.CompoundTag;
import net.tardis.mod.blockentities.exteriors.ExteriorTile;
import net.tardis.mod.exterior.ExteriorType;
import net.tardis.mod.misc.MatterStateHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tama.Misc.IHelpWithMatterStateHandlers;

@Mixin(ExteriorTile.class)
public abstract class ExteriorTileMixin {

    @Shadow(remap = false) private ExteriorType exteriorType;

    @Shadow(remap = false) @Final public MatterStateHandler matterStateHandler;

    @Inject(method = "saveAdditional", at = @At("TAIL"))
    private void Aseoha$SaveAdditional(CompoundTag tag, CallbackInfo ci) {
        tag.putBoolean("Aseoha$IsCloaked", ((IHelpWithMatterStateHandlers) this.matterStateHandler).Aseoha$IsCloaked());
    }

    @Inject(method = "load", at = @At("TAIL"))
    private void Aseoha$Load(CompoundTag tag, CallbackInfo ci) {
        ((IHelpWithMatterStateHandlers) this.matterStateHandler).Aseoha$SetCloaked(tag.getBoolean("Aseoha$IsCloaked"));
    }
}
