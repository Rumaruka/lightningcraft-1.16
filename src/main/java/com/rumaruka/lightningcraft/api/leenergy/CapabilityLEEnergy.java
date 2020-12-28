package com.rumaruka.lightningcraft.api.leenergy;

import com.rumaruka.lightningcraft.LightningCraft;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.*;


public class CapabilityLEEnergy {

    @CapabilityInject(ILEEnergy.class)
    public static Capability<ILEEnergy> LIGHTNING_UPGRADABLE ;

    public static void setupCap(){
        LightningCraft.logger.info("LIGHTNING_UPGRADABLE REGISTER");
        CapabilityManager.INSTANCE.register(ILEEnergy.class, new Capability.IStorage<ILEEnergy>()
                {
                    @Override
                    public INBT writeNBT(Capability<ILEEnergy> capability, ILEEnergy instance, Direction side)
                    {
                        return IntNBT.valueOf(instance.getEnergyStored());
                    }

                    @Override
                    public void readNBT(Capability<ILEEnergy> capability, ILEEnergy instance, Direction side, INBT nbt)
                    {
                        if (!(instance instanceof LEEnergyStorage))
                            throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
                        ((LEEnergyStorage)instance).energy = ((IntNBT)nbt).getAsInt();
                    }
                },
                () -> new LEEnergyStorage(1000));

    }
}
