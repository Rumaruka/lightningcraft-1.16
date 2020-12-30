package com.rumaruka.lightningcraft.init;

import com.rumaruka.lightningcraft.client.render.LCLightningBoltRenderer;
import com.rumaruka.lightningcraft.common.entity.LCLightningBoltEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.rumaruka.lightningcraft.LightningCraft.MODID;

public class LCEntites {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);
    public static void setup(){
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());


    }

    public static final RegistryObject<EntityType<LCLightningBoltEntity>> lightning_bolt =

            ENTITIES.register("lightning_bolt", ()->EntityType.Builder.<LCLightningBoltEntity>of(LCLightningBoltEntity::new, EntityClassification.MISC).sized(0.25F, 0.25F).setTrackingRange(4).updateInterval(10).build("lightning_bolt"));


}
