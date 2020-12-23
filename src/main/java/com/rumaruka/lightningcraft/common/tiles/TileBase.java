package com.rumaruka.lightningcraft.common.tiles;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Random;

public abstract class TileBase extends TileEntity implements ITickableTileEntity {
    protected Random random = new Random();
    public TileBase(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT nbt = new CompoundNBT();
        return this.save(nbt);
    }



    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(getBlockPos(),0,getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        this.load(getBlockState(),pkt.getTag());
    }
    /** Gets the x-coordinate */
    public int getX() {
        return this.getBlockPos().getX();
    }

    /** Gets the y-coordinate */
    public int getY() {
        return this.getBlockPos().getY();
    }

    /** Gets the z-coordinate */
    public int getZ() {
        return this.getBlockPos().getZ();
    }

    public boolean isUseableByPlayer(PlayerEntity player) {
        TileBase tile = this;
        return Objects.requireNonNull(tile.getLevel()).getBlockEntity(tile.getBlockPos()) == tile && player.distanceToSqr(tile.getX() + 0.5D, tile.getY() + 0.5D, tile.getZ() + 0.5D) <= 64.0D;
    }
}
