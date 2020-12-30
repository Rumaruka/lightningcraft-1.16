package com.rumaruka.lightningcraft.common.config;

import com.rumaruka.lightningcraft.LightningCraft;
import net.minecraftforge.fml.config.ModConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.timeconqueror.timecore.api.common.config.Config;
import ru.timeconqueror.timecore.api.common.config.IQuickConfigValue;
import ru.timeconqueror.timecore.api.common.config.ImprovedConfigBuilder;

public class ConfigurationCustom extends Config {
    public static final ConfigurationCustom MAIN = new ConfigurationCustom();

    public static IQuickConfigValue<Boolean> portalEnabled;
    public static IQuickConfigValue<Integer> portalCooldown;
    public static IQuickConfigValue<Boolean> demonSoldiersAlwaysNeutral, demonSoldiersInNether, demonSoldiersFullPower;
    public static IQuickConfigValue<Boolean> useVanillaGhastSounds;

    public static IQuickConfigValue<Boolean> upgradeEnabled;
    public static IQuickConfigValue<String[]> minerFillerBlocks;
    public static IQuickConfigValue<Integer> minerMaxRetries;

    public static IQuickConfigValue<Boolean> autoSmelt, autoRepair, mysticGear;

    public static IQuickConfigValue<Integer> underworldDimensionID;
    public static IQuickConfigValue<Boolean> JEIIntegration, RFIntegration;
    public static IQuickConfigValue<Integer> RFtoLEConversion;
    public static IQuickConfigValue<Boolean> tinkersIntegration;
    public static IQuickConfigValue<Boolean> disableOtherRods;
    public static IQuickConfigValue<Boolean> chiselIntegration, chiselCorruptStone;

    public ConfigurationCustom() {
        super(ModConfig.Type.COMMON, LightningCraft.MODID, null);
    }


    @Override
    public void setup(ImprovedConfigBuilder builder) {
        portalEnabled = builder.optimized(
                builder.comment("Set to false to disable default portal creation.")
                        .define("Portal Enabled", true)
        );
        portalCooldown= builder
                .optimized(builder
                .comment("The cooldown time for the underworld portal. Increase if repeated teleporting occurs.")
                .define("Portal Cooldown Time",200));
    }
}
