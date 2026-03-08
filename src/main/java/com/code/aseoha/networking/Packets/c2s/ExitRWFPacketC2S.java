package com.code.aseoha.networking.Packets.c2s;

import com.code.aseoha.Helpers.IHelpWithConsole;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.world.dimensions.TDimensions;

import java.util.Objects;
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

            ServerWorld world = sender.getLevel();
            if (!WorldHelper.areDimensionTypesSame(world, TDimensions.DimensionTypes.TARDIS_TYPE)) return;

            TileEntity te = world.getBlockEntity(TardisHelper.TARDIS_POS);
            if (!(te instanceof ConsoleTile)) return;

            ConsoleTile consoleTile = (ConsoleTile) te;

            // Stop riding before teleporting
            sender.stopRiding();

            // Clean up the RWF ride state
            ((IHelpWithConsole) consoleTile).Aseoha$CleanupRide();

            // Teleport player back to the TARDIS interior spawn point properly
            // rather than hardcoded coords
            BlockPos interiorSpawn = TardisHelper.TARDIS_POS.offset(0, 1, 0);
            WorldHelper.teleportEntities(sender, world, interiorSpawn, sender.yRot, sender.xRot);
        });
        ctx.get().setPacketHandled(true);
    }
}
