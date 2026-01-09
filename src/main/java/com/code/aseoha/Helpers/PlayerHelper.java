package com.code.aseoha.Helpers;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.event.world.NoteBlockEvent;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.tardis.mod.entity.TardisEntity;
import net.tardis.mod.helper.TardisHelper;
import net.tardis.mod.items.KeyItem;
import net.tardis.mod.tileentities.ConsoleTile;

import java.util.concurrent.atomic.AtomicReference;

public class PlayerHelper {
    public static void decreaseExp(PlayerEntity player, int amount) {
        player.giveExperiencePoints(-amount);
    }

    public static void increaseExp(PlayerEntity player, int amount){
        player.giveExperiencePoints(amount);
    }

    public static void giveItemStack(PlayerEntity player, IItemProvider item, int amount) {player.addItem(new ItemStack(item, amount));}

    public static void removeItemInHand(PlayerEntity player, Hand hand, int amount){
        player.getItemInHand(hand).shrink(amount);
    }

    public static Vector3d getVectorForRotation(float pitch, float yaw) {
        float f = pitch * ((float)Math.PI / 180F);
        float f1 = -yaw * ((float)Math.PI / 180F);
        float f2 = MathHelper.cos(f1);
        float f3 = MathHelper.sin(f1);
        float f4 = MathHelper.cos(f);
        float f5 = MathHelper.sin(f);
        return new Vector3d(f3 * f4, -f5, f2 * f4);
    }

    /**
     * Takes a PlayerEntity and whips out a ServerPlayerEntity
     */
    public static ServerPlayerEntity PlayerToServer(PlayerEntity Player) {
        return ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayer(Player.getUUID());
    }

    /**
     * Returns true if the player has a key to the TARDIS
     * @param player the player to check
     * @param console the console of the TARDIS the player should have a key to
     * @return a boolean
     */
    public static boolean HasKey(PlayerEntity player, ConsoleTile console) {
        AtomicReference<Boolean> atomic = new AtomicReference<>();
        atomic.set(false);
        for(ItemStack item : player.inventory.items) {
            if(item.getItem() instanceof KeyItem) {
                if(((KeyItem) item.getItem()).getTardis(item).equals(console.getLevel().dimension().location())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean HasItem(PlayerEntity player, Item item) {
        for(ItemStack i : player.inventory.items) {
            if(item.getItem() instanceof KeyItem) {
                if((i.getItem()).equals(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static float calculateNetHeadYaw(LivingEntity entity) {
        float headYaw = entity.yHeadRot;    // Head rotation in degrees
        float bodyYaw = entity.yBodyRot;    // Body rotation in degrees
        float netHeadYaw = headYaw - bodyYaw;      // Raw difference
        return MathHelper.wrapDegrees(netHeadYaw); // Normalize to [-180, 180]
    }

    public static float getInterpolatedHeadPitch(LivingEntity entity, float partialTick) {
        return entity.xRotO + (entity.xRot - entity.xRotO) * partialTick;
    }
}