package com.code.aseoha.networking.Packets;

import com.code.aseoha.Helpers.IHelpWithExterior;
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

            if (WorldHelper.areDimensionTypesSame(world, TDimensions.DimensionTypes.TARDIS_TYPE)) {
                TileEntity te = world.getBlockEntity(TardisHelper.TARDIS_POS);
                if (!(te instanceof ConsoleTile)) return;

                ConsoleTile consoleTile = (ConsoleTile) te;
                TardisEntity tardis = consoleTile.getEntity();
                if (tardis == null) return;

                ExteriorTile exterior = TARDISHelper.getExteriorTile(consoleTile);
                if (exterior == null || exterior.getLevel() == null) return;

                ServerWorld exteriorWorld = (ServerWorld) exterior.getLevel();

                // 1. Configure entity fully BEFORE spawning so it's ready on first tick
                tardis.setConsole(consoleTile);
                tardis.setExteriorTile(exterior);
                tardis.setInvulnerable(true);
                tardis.setNoGravity(true);

                // 2. Now spawn into the world
                exteriorWorld.addFreshEntity(tardis);

                // 3. Teleport entity to exterior position
                WorldHelper.teleportEntities(tardis, exteriorWorld, exterior.getBlockPos(), 0, 90);

                // 4. Update console reference to the now-spawned entity
                consoleTile.setEntity(tardis);

                // 5. Delete exterior blocks only after entity is safely in place
                exterior.deleteExteriorBlocks();

                // 6. Teleport player THEN start riding, so the player is already
                //    in the correct world before the ride is established
                WorldHelper.teleportEntities(ctx.get().getSender(), exteriorWorld, exterior.getBlockPos(), 0, 90);
                ctx.get().getSender().startRiding(tardis, true);

                // 7. Also seat the stored pilot if different from the sender
                if (consoleTile.getPilot() != null && consoleTile.getPilot() != ctx.get().getSender()) {
                    consoleTile.getPilot().startRiding(tardis, true);
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
