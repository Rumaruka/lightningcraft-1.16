package com.rumaruka.lightningcraft.init;

import com.rumaruka.lightningcraft.LightningCraft;
import com.rumaruka.lightningcraft.client.LCItemGroup;
import com.rumaruka.lightningcraft.common.block.BlockInfuser;
import com.rumaruka.lightningcraft.common.block.LCBaseBlock;
import com.rumaruka.lightningcraft.common.config.TestCfg;
import net.minecraftforge.registries.ObjectHolder;
import ru.timeconqueror.timecore.api.registry.BlockRegister;
import ru.timeconqueror.timecore.api.registry.ConfigRegister;
import ru.timeconqueror.timecore.api.registry.util.AutoRegistrable;


@ObjectHolder(LightningCraft.MODID)
public class LCConfig {


    private static class Setup {

        @AutoRegistrable
        private static final ConfigRegister REGISTER = new ConfigRegister(LightningCraft.MODID);

        @AutoRegistrable.InitMethod
        private static void register() {
            REGISTER.register(TestCfg.INSTANCE);
        }
    }
}
