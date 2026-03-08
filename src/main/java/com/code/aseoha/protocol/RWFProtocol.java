package com.code.aseoha.protocol;

import com.code.aseoha.Helpers.IHelpWithConsole;
import com.code.aseoha.networking.Packets.EnterRWFPacket;
import com.code.aseoha.aseoha;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.protocols.Protocol;
import net.tardis.mod.tileentities.ConsoleTile;

public class RWFProtocol extends Protocol {
    @Override
    public void call(World world, PlayerEntity playerIn, ConsoleTile console) {
        // closeContainer must run client-side; all logic below is server-side only
        if (world.isClientSide) {
            playerIn.closeContainer();
            return;
        }

        console.setPilot(playerIn);
        ((IHelpWithConsole) console).Aseoha$SetRealWorldFlight(true);

        // Send the packet that actually kicks off entity spawning and teleportation.
        // Without this the RWF flag was set but nothing ever happened.
        aseoha.NETWORK.send(
                net.minecraftforge.fml.network.PacketDistributor.PLAYER.with(
                        () -> (net.minecraft.entity.player.ServerPlayerEntity) playerIn),
                new EnterRWFPacket(console.getLevel().dimension().location())
        );
    }

    @Override
    public String getSubmenu() {
        return TardisConstants.Strings.SECURITY_MENU;
    }
}
