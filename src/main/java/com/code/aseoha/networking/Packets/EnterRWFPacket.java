package com.code.aseoha.networking.Packets;

import com.code.aseoha.Helpers.IHelpWithConsole;
import com.code.aseoha.Helpers.TARDISHelper;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.tardis.mod.entity.TardisEntity;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import net.tardis.mod.world.dimensions.TDimensions;

import java.util.function.Supplier;

public class EnterRWFPacket {
    public ResourceLocation console;

    public EnterRWFPacket(ResourceLocation console) {
        this.console = console;
    }

    public static void encode(EnterRWFPacket mes, PacketBuffer buffer) {
        buffer.writeResourceLocation(mes.console);
    }

    public static EnterRWFPacket decode(PacketBuffer buffer) {
        return new EnterRWFPacket(buffer.readResourceLocation());
    }

    public static void handle(EnterRWFPacket mes, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerWorld world = WorldHelper.getWorldFromRL(ServerLifecycleHooks.getCurrentServer(), mes.console);
            if (world == null) return;

            if (!WorldHelper.areDimensionTypesSame(world, TDimensions.DimensionTypes.TARDIS_TYPE)) return;

            TileEntity te = world.getBlockEntity(TardisHelper.TARDIS_POS);
            if (!(te instanceof ConsoleTile)) return;

            ConsoleTile consoleTile = (ConsoleTile) te;
            IHelpWithConsole helper = (IHelpWithConsole) consoleTile;

            TardisEntity tardis = consoleTile.getEntity();
            if (tardis == null) return;

            ExteriorTile exterior = TARDISHelper.getExteriorTile(consoleTile);
            if (exterior == null || exterior.getLevel() == null) return;

            ServerWorld exteriorWorld = (ServerWorld) exterior.getLevel();

            // setConsole + setExteriorTile MUST be called before the entity
            // does anything, otherwise it NPEs with no context to work from
            tardis.setConsole(consoleTile);
            tardis.setExteriorTile(exterior);
            tardis.setInvulnerable(true);
            tardis.setNoGravity(true);

            // Spawn and move the tardis entity into the exterior world
            exteriorWorld.addFreshEntity(tardis);
            WorldHelper.teleportEntities(tardis, exteriorWorld, exterior.getBlockPos(), 0, 90);
            consoleTile.setEntity(tardis);

            // Delete exterior blocks now that the entity is in place to replace them
            exterior.deleteExteriorBlocks();

            // Teleport player to exterior world BEFORE riding — riding across
            // a dimension boundary causes an NPE
            WorldHelper.teleportEntities(ctx.get().getSender(), exteriorWorld, exterior.getBlockPos(), 0, 90);

            // Use Aseoha$Ride which handles the riding logic properly.
            // getPilot() is always non-null here (dev confirmed: player must
            // have interacted with console/monitor to get this far)
            helper.Aseoha$Ride(ctx.get().getSender());

            // Also seat the stored pilot if they're a different player
            if (helper.Aseoha$GetPilot() != ctx.get().getSender()) {
                helper.Aseoha$Ride(helper.Aseoha$GetPilot());
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
