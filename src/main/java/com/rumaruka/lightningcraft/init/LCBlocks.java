package com.rumaruka.lightningcraft.init;

import com.rumaruka.lightningcraft.LightningCraft;
import com.rumaruka.lightningcraft.client.LCItemGroup;
import com.rumaruka.lightningcraft.common.block.BlockInfuser;
import com.rumaruka.lightningcraft.common.block.LCBaseBlock;
import net.minecraftforge.registries.ObjectHolder;
import ru.timeconqueror.timecore.registry.AutoRegistrable;
import ru.timeconqueror.timecore.registry.newreg.BlockRegister;

import static com.rumaruka.lightningcraft.common.block.LCBaseBlock.METAL_PROP;
import static ru.timeconqueror.timecore.util.Hacks.promise;

@ObjectHolder(LightningCraft.MODID)
public class LCBlocks {


    public static final LCBaseBlock MYSTIC_BLOCK = promise();
    public static final LCBaseBlock SKYFATHER_BLOCK = promise();
    public static final LCBaseBlock ELECTRICIUM_BLOCK = promise();
    public static final BlockInfuser INFUSER = promise();


    private static class Setup {

        @AutoRegistrable
        private static final BlockRegister REGISTER = new BlockRegister(LightningCraft.MODID);

        @AutoRegistrable.InitMethod
        private static void register() {
            REGISTER.register("mystic_block",()->new LCBaseBlock(METAL_PROP.create())).genDefaultStateAndModel().regDefaultBlockItem(LCItemGroup.LC_ITEM_GROUP);
            REGISTER.register("skyfather_block",()->new LCBaseBlock(METAL_PROP.create())).genDefaultStateAndModel().regDefaultBlockItem(LCItemGroup.LC_ITEM_GROUP);
            REGISTER.register("electricium_block",()->new LCBaseBlock(METAL_PROP.create())).genDefaultStateAndModel().regDefaultBlockItem(LCItemGroup.LC_ITEM_GROUP);
            REGISTER.register("infuser",()->new BlockInfuser(BlockInfuser.INFUSER.create())).regDefaultBlockItem(LCItemGroup.LC_ITEM_GROUP);


        }
    }
}
