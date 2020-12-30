package com.rumaruka.lightningcraft;

import com.rumaruka.lightningcraft.api.leenergy.ILEEnergy;
import com.rumaruka.lightningcraft.api.leenergy.LEEnergy;
import com.rumaruka.lightningcraft.api.leenergy.LEEnergyStorage;
import com.rumaruka.lightningcraft.init.LCEntites;
import com.rumaruka.lightningcraft.init.LCTypes;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.timeconqueror.timecore.api.TimeMod;
import ru.timeconqueror.timecore.api.client.resource.location.TextureLocation;


@Mod(LightningCraft.MODID)
public class LightningCraft implements TimeMod {

    public static final String MODID ="lightningcraft";
    public static final Logger logger = LogManager.getLogger(MODID);
    public static LightningCraft INSTANCE = null;
    public LightningCraft() {


        logger.info("LightningCraft add in you modpack");
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);

        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(IRecipeSerializer.class, LCTypes::setupRecipe);
        LCEntites.setup();
    }

    public void commonSetup(FMLCommonSetupEvent event) {
        logger.info("LEEnergy Capability register");
        CapabilityManager.INSTANCE.register(ILEEnergy.class, new LEEnergyStorage(), ()-> new LEEnergy(1000));
    }
    public static ResourceLocation rl(String path){
        return new ResourceLocation(LightningCraft.MODID,path);
    }


    public static TextureLocation tl(String path){
        return new TextureLocation(LightningCraft.MODID,path);
    }
}
