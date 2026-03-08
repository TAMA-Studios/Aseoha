package com.code.aseoha.protocol;

import com.code.aseoha.Helpers.IHelpWithConsole;
import com.code.aseoha.aseoha;
import com.code.aseoha.networking.Packets.EnterRWFPacket;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.protocols.Protocol;
import net.tardis.mod.tileentities.ConsoleTile;

public class RWFProtocol extends Protocol {
    @Override
    public void call(World world, PlayerEntity playerIn, ConsoleTile console) {
        // Close the GUI client-side only — nothing else should run on the client
        if (world.isClientSide) {
            playerIn.closeContainer();
            return;
        }

        // Set state server-side
        console.setPilot(playerIn);
        ((IHelpWithConsole) console).Aseoha$SetRealWorldFlight(true);

        // Send the enter packet to the player — this is what actually triggers
        // the entity spawn, exterior deletion, and teleport sequence.
        // Without this call the RWF flag was set but nothing ever happened.
        aseoha.NETWORK.send(
                PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerIn),
                new EnterRWFPacket(console.getLevel().dimension().location())
        );
    }

    @Override
    public String getSubmenu() {
        return TardisConstants.Strings.SECURITY_MENU;
    }
}
