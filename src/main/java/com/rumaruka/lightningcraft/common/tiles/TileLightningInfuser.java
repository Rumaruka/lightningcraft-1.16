package com.rumaruka.lightningcraft.common.tiles;

import com.rumaruka.lightningcraft.init.LCTiles;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import org.jetbrains.annotations.Nullable;

public class TileLightningInfuser extends TileLightningItemHandler.Upgradable{
    public TileLightningInfuser( ) {
        super(LCTiles.INFUSER);
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return new int[0];
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack itemStackIn, @Nullable Direction directionIn) {
        return false;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction directionIn) {
        return false;
    }

    @Override
    public int getContainerSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        return null;
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return null;
    }

    @Override
    public void setItem(int index, ItemStack stack) {

    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return false;
    }

    @Override
    public void clearContent() {

    }

    @Override
    public void tick() {

    }
}
