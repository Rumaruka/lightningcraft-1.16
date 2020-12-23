package com.rumaruka.lightningcraft.common.tiles;

import net.minecraft.tileentity.TileEntityType;

public abstract class TileLightningUser extends TileBase{


    public double cellPower;
    public double maxPower;
    private double efficiency;

    public TileLightningUser(TileEntityType<?> tileEntityTypeIn) {

        super(tileEntityTypeIn);
    }


}
