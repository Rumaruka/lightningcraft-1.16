package com.rumaruka.lightningcraft;

import com.rumaruka.lightningcraft.api.leenergy.CapabilityLEEnergy;
import com.rumaruka.lightningcraft.init.LCTypes;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
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
//        CapabilityLEEnergy.setupCap();
//        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(IRecipeSerializer.class, LCTypes::setupRecipe);

    }


    public static ResourceLocation rl(String path){
        return new ResourceLocation(LightningCraft.MODID,path);
    }


    public static TextureLocation tl(String path){
        return new TextureLocation(LightningCraft.MODID,path);
    }
}
