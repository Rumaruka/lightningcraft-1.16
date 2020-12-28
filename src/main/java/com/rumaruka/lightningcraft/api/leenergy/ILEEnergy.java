package com.rumaruka.lightningcraft.api.leenergy;

public interface ILEEnergy {

    int receiveEnergy(int maxReceive, boolean fake);

    int extractEnergy(int maxExtract, boolean fake);

    int getEnergyStored();

    int getMaxEnergyStored();

    boolean canExtract();

    boolean canReceive();
}
