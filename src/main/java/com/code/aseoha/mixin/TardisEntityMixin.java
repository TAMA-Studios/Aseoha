package com.code.aseoha.mixin;

import com.code.aseoha.Helpers.IHelpWithConsole;
import com.code.aseoha.Helpers.IHelpWithTardisEntity;
import com.code.aseoha.Helpers.MiscHelper;
import com.code.aseoha.Helpers.PlayerHelper;
import com.code.aseoha.aseoha;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.play.server.SEntityVelocityPacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.tardis.mod.entity.DoorEntity;
import net.tardis.mod.entity.TardisEntity;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(TardisEntity.class)
public abstract class TardisEntityMixin extends Entity implements IHelpWithTardisEntity {

    public TardisEntityMixin(EntityType<?> p_i48580_1_, World p_i48580_2_) {
        super(p_i48580_1_, p_i48580_2_);
    }

    // -------------------------------------------------------------------------
    // Shadows
    // -------------------------------------------------------------------------

    @Shadow(remap = false) @Nullable
    public abstract ExteriorTile getExteriorTile();

    @Shadow(remap = false)
    private boolean hasLanded;

    @Shadow(remap = false)
    public abstract Entity changeDimension(@NotNull ServerWorld destination);

    @Shadow
    private ConsoleTile console;

    // -------------------------------------------------------------------------
    // Mixin-added fields
    // -------------------------------------------------------------------------

    private RegistryKey<DimensionType> interiorDimension;
    private boolean canDismount = false;
    private boolean jumping = false;
    public float renderYaw = 0;

    private float prevRotationPitch;
    private float prevRotationYaw;
    private float rotationPitch;
    private float rotationYaw;

    @Override public boolean isJumping() { return jumping; }
    @Override public void setJumping(boolean v) { this.jumping = v; }
    @Override public void setHasLanded(boolean v) { this.hasLanded = v; }
    @Override public void setCanDismount(boolean v) { this.canDismount = v; }
    @Override public boolean canDismount() { return canDismount; }
    @Override public boolean canBeRiddenInWater(Entity rider) { return true; }
    @Override public RegistryKey<DimensionType> getInteriorDimension() { return interiorDimension; }
    @Override public void setInteriorDimension(RegistryKey<DimensionType> v) { this.interiorDimension = v; }

    /**
     * @author Codiak540
     * @reason Cache + server-only console lookup
     */
    @Overwrite(remap = false)
    public ConsoleTile getConsole() {
        if (this.console != null) return this.console;
        if (this.level.isClientSide) return null;
        return this.console = TardisHelper.getConsole(
                this.level.getServer(), this.interiorDimension.location()).get();
    }

    /**
     * @author Codiak
     * @reason Must be pushable for physics to allow movement
     */
    @Overwrite(remap = false)
    public boolean isPushable() { return true; }

    @Override
    public double getPassengersRidingOffset() {
        return (double) this.getDimensions(this.getPose()).height * 0.9D;
    }

    @Override
    protected boolean canRide(@NotNull Entity entityIn) { return true; }

    public boolean canBeControlledByRider() { return true; }

    @Override
    public Entity getControllingPassenger() {
        return !this.getPassengers().isEmpty() ? this.getPassengers().get(0) : null;
    }

    @Inject(
            method = "interact(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/ActionResultType;",
            at = @At("HEAD"),
            cancellable = true
    )
    private void Aseoha$Interact(PlayerEntity player, Hand hand,
                                 CallbackInfoReturnable<ActionResultType> cir) {
        if (!this.level.isClientSide) {
            if (this.getPassengers().isEmpty()) {
                boolean mounted = player.startRiding((Entity)(Object)this, true);
                aseoha.LOGGER.info("RWF mount attempt for {}: {}", player.getName().getString(), mounted);
                cir.setReturnValue(mounted ? ActionResultType.SUCCESS : ActionResultType.FAIL);
            } else {
                cir.setReturnValue(ActionResultType.FAIL);
            }
        } else {
            cir.setReturnValue(ActionResultType.SUCCESS);
        }
    }
    @Redirect(
            method = "tick()V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/tardis/mod/entity/TardisEntity;remove()V",
                    ordinal = 0
            )
    )
    private void Aseoha$SuppressRemoveWhileRiding(TardisEntity self) {
        if (self.isVehicle()) {
            return;
        }
        self.remove();
    }

    @Inject(
            method = "tick()V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;tick()V", shift = At.Shift.AFTER)
    )
    private void Aseoha$Tick(CallbackInfo ci) {
        if (this.getConsole() == null) return;

        if (this.level.isClientSide) {
                MiscHelper.forceThirdPerson();
            return;
        }

        if (!this.isVehicle()) {
            this.setNoGravity(false);
            return;
        }

        Entity passenger = this.getControllingPassenger();
        if (!(passenger instanceof PlayerEntity)) {
            this.setNoGravity(false);
            ((IHelpWithConsole) this.getConsole()).Aseoha$StopRide(true);
            return;
        }

        PlayerEntity rider = (PlayerEntity) passenger;

        this.setNoGravity(true);

        // Steal the riders rotation
        this.prevRotationPitch = this.rotationPitch;
        this.prevRotationYaw  = this.rotationYaw;
        this.rotationPitch    = rider.xRot;
        this.rotationYaw      = rider.yRot;

        if (rider.isCrouching() && !level.getBlockState(blockPosition().below(2)).isAir()) {
                ((IHelpWithConsole) this.getConsole()).Aseoha$CleanupRide();
        }

        float speed = 1.0f; // TODO: wire to ThrottleControl

        // Build motion fresh every tick from rider inputs.
        // Starting from ZERO means no velocity buildup between ticks.
        Vector3d motion = Vector3d.ZERO;

        // Forward / backward
        // zza > 0 = W (forward), zza < 0 = S (backward)
        if (rider.zza != 0) {
            Vector3d fwd = PlayerHelper.getVectorForRotation(0, this.rotationYaw)
                    .scale(rider.zza * speed);
            motion = motion.add(fwd.x, 0, fwd.z);
        }

        // Strafe left / right
        // xxa > 0 = D (right) = rotationYaw - 90 direction
        // xxa < 0 = A (left)  = sign flip handles it automatically
        if (rider.xxa != 0) {
            Vector3d strafe = PlayerHelper.getVectorForRotation(0, this.rotationYaw - 90F)
                    .scale(rider.xxa * speed);
            motion = motion.add(strafe.x, 0, strafe.z);
        }

        // TODO: Gordon, I don't think you can jump or crouch in the middle of the air...
        if (this.isJumping()) {
            motion = motion.add(0, speed, 0);
            this.setJumping(false);
        }

        if (rider.isCrouching()) {
            motion = motion.add(0, -speed, 0);
        }

        this.setDeltaMovement(motion);

        // Keep console display updated
        this.getConsole().setCurrentLocation(this.level.dimension(), this.blockPosition());
        this.getConsole().updateFlightTime();
    }

    @Override
    protected void removePassenger(Entity ent) {
        if(!((IHelpWithConsole) this.getConsole()).Aseoha$IsRealWorldFlight())
            super.removePassenger(ent);
    }
}