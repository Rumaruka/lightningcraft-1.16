package com.rumaruka.lightningcraft.init;

import com.rumaruka.lightningcraft.LightningCraft;
import com.rumaruka.lightningcraft.client.render.tesr.TesrInfuser;
import com.rumaruka.lightningcraft.common.tiles.TileLightningInfuser;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;
import ru.timeconqueror.timecore.registry.AutoRegistrable;
import ru.timeconqueror.timecore.registry.newreg.TileEntityRegister;

import static ru.timeconqueror.timecore.util.Hacks.promise;

@ObjectHolder(LightningCraft.MODID)
public class LCTiles {

    public static final TileEntityType<TileLightningInfuser> INFUSER = promise();

    private static class Setup {

        @AutoRegistrable
        private static final TileEntityRegister REGISTER = new TileEntityRegister(LightningCraft.MODID);

        @AutoRegistrable.InitMethod
        private static void register() {
            REGISTER.registerSingleBound("infuser",
                    TileLightningInfuser::new,
                    () -> LCBlocks.INFUSER).regCustomRenderer(() -> TesrInfuser::new)

            ;


        }
    }
}
