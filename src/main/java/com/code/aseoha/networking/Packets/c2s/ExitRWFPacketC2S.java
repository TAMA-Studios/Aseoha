package com.code.aseoha.networking.Packets.c2s;

import com.code.aseoha.Helpers.IHelpWithConsole;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.world.dimensions.TDimensions;

import java.util.function.Supplier;

public class ExitRWFPacketC2S {
    public ResourceLocation console;

    public ExitRWFPacketC2S(ResourceLocation console) {
        this.console = console;
    }

    public static void encode(ExitRWFPacketC2S mes, PacketBuffer buffer) {
        buffer.writeResourceLocation(mes.console);
    }

    public static ExitRWFPacketC2S decode(PacketBuffer buffer) {
        return new ExitRWFPacketC2S(buffer.readResourceLocation());
    }

    public static void handle(ExitRWFPacketC2S mes, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity sender = ctx.get().getSender();
            if (sender == null) return;

            // Player is in the exterior world during RWF, so we need to
            // resolve the console dimension from the packet, not the sender's
            // current world (which is the exterior, not the TARDIS)
            ServerWorld tardisWorld = WorldHelper.getWorldFromRL(
                    sender.getServer(), mes.console);
            if (tardisWorld == null) return;

            if (!WorldHelper.areDimensionTypesSame(tardisWorld, TDimensions.DimensionTypes.TARDIS_TYPE)) return;

            TileEntity te = tardisWorld.getBlockEntity(TardisHelper.TARDIS_POS);
            if (!(te instanceof ConsoleTile)) return;

            ConsoleTile consoleTile = (ConsoleTile) te;
            IHelpWithConsole helper = (IHelpWithConsole) consoleTile;

            // Aseoha$StopRide handles dismounting cleanly
            helper.Aseoha$StopRide(true);

            // CleanupRide clears the RWF state and entity references
            helper.Aseoha$CleanupRide();

            // Teleport the player back into the TARDIS interior properly
            WorldHelper.teleportEntities(sender, tardisWorld, TardisHelper.TARDIS_POS.above(), sender.yRot, sender.xRot);
        });
        ctx.get().setPacketHandled(true);
    }
}
