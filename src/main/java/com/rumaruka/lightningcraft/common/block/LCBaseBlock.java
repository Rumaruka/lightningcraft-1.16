package com.rumaruka.lightningcraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import ru.timeconqueror.timecore.api.registry.util.BlockPropsFactory;

public class LCBaseBlock extends Block {

    public static final BlockPropsFactory METAL_PROP = new BlockPropsFactory(() -> Properties.of(Material.HEAVY_METAL)
            .strength(2.0F, 6.0F)
            .sound(SoundType.METAL)
            .lightLevel(value -> 0));

    public LCBaseBlock(Properties prob ) {
        super(prob);
    }
}
