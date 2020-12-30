package com.rumaruka.lightningcraft.api.leenergy;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.EnergyStorage;
import org.jetbrains.annotations.Nullable;

public class LEEnergyStorage implements Capability.IStorage<ILEEnergy> {
    @Nullable
    @Override
    public INBT writeNBT(Capability<ILEEnergy> capability, ILEEnergy instance, Direction side) {
        return IntNBT.valueOf(instance.getEnergyStored());
    }

    @Override
    public void readNBT(Capability<ILEEnergy> capability, ILEEnergy instance, Direction side, INBT nbt) {
        if (!(instance instanceof LEEnergy))
            throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
        ((LEEnergy)instance).energy = ((IntNBT)nbt).getAsInt();

    }
}
