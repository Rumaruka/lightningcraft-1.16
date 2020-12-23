package com.rumaruka.lightningcraft.common.block;

import com.rumaruka.lightningcraft.common.tiles.TileLightningInfuser;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import org.jetbrains.annotations.Nullable;
import ru.timeconqueror.timecore.registry.BlockPropsFactory;

public class BlockInfuser extends ContainerBlock {


    public static final BlockPropsFactory INFUSER = new BlockPropsFactory(() -> Properties.of(Material.HEAVY_METAL)
            .strength(2.0F, 6.0F)
            .sound(SoundType.METAL)
            .lightLevel(value -> 0));


    public BlockInfuser(Properties builder) {
        super(builder);
    }

    @Override
    public BlockRenderType getRenderShape(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader worldIn) {
        return new TileLightningInfuser();
    }
}
