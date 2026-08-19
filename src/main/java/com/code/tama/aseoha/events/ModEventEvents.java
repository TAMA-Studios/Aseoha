package com.code.tama.aseoha.events;

import com.code.tama.aseoha.aseoha;
import com.code.tama.aseoha.entities.DalekEntity;
import com.code.tama.aseoha.entities.K9Entity;
import com.code.tama.aseoha.registries.AEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = aseoha.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventEvents {
    @SubscribeEvent
    public static void RegisterAttributesEvent(EntityAttributeCreationEvent event) {
        event.put(AEntities.K9.get(), K9Entity.createAttributes().build());
        event.put(AEntities.WALLE.get(), K9Entity.createAttributes().build());
        event.put(AEntities.DALEK.get(), DalekEntity.createAttributes().build());
    }
}
