package com.rumaruka.lightningcraft.utils;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.util.Direction;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public class LCMisc {
    public static SidedInvWrapper[] makeInvWrapper(ISidedInventory inv) {
        SidedInvWrapper[] wrapper = new SidedInvWrapper[6];
        for(int i = 0; i < 6; i++) {
            wrapper[i] = new SidedInvWrapper(inv, Direction.from2DDataValue(i));
        }
        return wrapper;
    }
}
