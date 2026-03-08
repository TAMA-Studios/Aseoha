package com.code.aseoha.protocol;

import com.code.aseoha.Helpers.IHelpWithConsole;
import com.code.aseoha.networking.Networking;
import com.code.aseoha.networking.Packets.EnterRWFPacket;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.World;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.protocols.Protocol;
import net.tardis.mod.tileentities.ConsoleTile;

public class RWFProtocol extends Protocol {
    @Override
    public void call(World world, PlayerEntity playerIn, ConsoleTile console) {
        if (world.isClientSide) {
            playerIn.closeContainer();
            return;
        }

        console.setPilot(playerIn);
        ((IHelpWithConsole) console).Aseoha$SetRealWorldFlight(true);

        // Networking.INSTANCE is the correct channel — not aseoha.NETWORK
        Networking.sendToClient(
                (ServerPlayerEntity) playerIn,
                new EnterRWFPacket(console.getLevel().dimension().location())
        );
    }

    @Override
    public String getSubmenu() {
        return TardisConstants.Strings.SECURITY_MENU;
    }
}
