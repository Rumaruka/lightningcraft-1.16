package com.rumaruka.lightningcraft.common.config;
import com.rumaruka.lightningcraft.LightningCraft;
import net.minecraftforge.fml.config.ModConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.timeconqueror.timecore.api.common.config.Config;
import ru.timeconqueror.timecore.api.common.config.IQuickConfigValue;
import ru.timeconqueror.timecore.api.common.config.ImprovedConfigBuilder;
import ru.timeconqueror.timecore.mod.common.config.MainConfig;

public class TestCfg  extends Config{
    public static final TestCfg INSTANCE = new TestCfg();
    public IQuickConfigValue<Boolean> features;

    public TestCfg() {
        super(ModConfig.Type.COMMON, LightningCraft.MODID, null);
    }

    @Override
    public void setup(ImprovedConfigBuilder builder) {
        features = builder.optimized(
                builder.comment("Test work cfg files.")
                        .define("test", false)
        );
    }
}
