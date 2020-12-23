package com.rumaruka.lightningcraft;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import ru.timeconqueror.timecore.api.TimeMod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.timeconqueror.timecore.api.client.resource.location.TextureLocation;


@Mod(LightningCraft.MODID)
public class LightningCraft implements TimeMod {

    public static final String MODID ="lightningcraft";
    public static final Logger logger = LogManager.getLogger(MODID);
    public static LightningCraft INSTANCE = null;
    public LightningCraft() {
        logger.info("LightningCraft add in you modpack");
    }


    public static ResourceLocation rl(String path){
        return new ResourceLocation(LightningCraft.MODID,path);
    }


    public static TextureLocation tl(String path){
        return new TextureLocation(LightningCraft.MODID,path);
    }
}
