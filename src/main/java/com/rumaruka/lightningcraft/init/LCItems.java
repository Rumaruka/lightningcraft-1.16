package com.rumaruka.lightningcraft.init;

import com.rumaruka.lightningcraft.LightningCraft;
import com.rumaruka.lightningcraft.common.item.LCIngot;
import net.minecraftforge.registries.ObjectHolder;
import ru.timeconqueror.timecore.api.registry.ItemRegister;
import ru.timeconqueror.timecore.api.registry.util.AutoRegistrable;


import static com.rumaruka.lightningcraft.LightningCraft.tl;
import static ru.timeconqueror.timecore.api.util.Hacks.promise;


@ObjectHolder(LightningCraft.MODID)
public class LCItems {


    public static final LCIngot INGOT_MYSTIC = promise();
    public static final LCIngot INGOT_ELECTRICIUM = promise();
    public static final LCIngot INGOT_SKYFATHER = promise();

    private static class Setup {


        @AutoRegistrable
        private static final ItemRegister REGISTER = new ItemRegister(LightningCraft.MODID);

        @AutoRegistrable.InitMethod
        private static void register() {
            REGISTER.register("ingot_mystic", LCIngot::new).genDefaultModel(tl("item/ingot_mystic"));
            REGISTER.register("ingot_electricium", LCIngot::new).genDefaultModel(tl("item/ingot_electricium"));
            REGISTER.register("ingot_skyfather", LCIngot::new).genDefaultModel(tl("item/ingot_skyfather"));

        }
    }

}
