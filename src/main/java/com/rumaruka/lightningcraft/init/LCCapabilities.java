package com.rumaruka.lightningcraft.init;

import com.google.common.base.Throwables;
import com.rumaruka.lightningcraft.api.cap.ILightningUpgradable;
import com.rumaruka.lightningcraft.api.cap.impl.BaseLightningUpgradable;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import org.jetbrains.annotations.Nullable;
import org.jline.utils.InfoCmp;

import java.util.concurrent.Callable;

import static ru.timeconqueror.timecore.util.Hacks.promise;

public class LCCapabilities {

    /** Access to the lightning-upgradable capability */
    @CapabilityInject(ILightningUpgradable.class)
    public static Capability<ILightningUpgradable> LIGHTNING_UPGRADABLE = promise();

    /** Lightning-upgradable storage handler */
    public static class CapabilityLightningUpgradable implements Capability.IStorage<ILightningUpgradable> {



        @Nullable
        @Override
        public INBT writeNBT(Capability<ILightningUpgradable> capability, ILightningUpgradable instance, Direction side) {
            return null;
        }

        @Override
        public void readNBT(Capability<ILightningUpgradable> capability, ILightningUpgradable instance, Direction side, INBT nbt) {

        }
    }
    public static class CapabilityLightningUpgradableFactory implements Callable<ILightningUpgradable>{

        @Override
        public ILightningUpgradable call() throws Exception {
            try
            {
                return this.call();
            }
            catch (Exception e)
            {
                Throwables.throwIfUnchecked(e);
                throw new RuntimeException(e);
            }
        }
    }
    public static void setupCap(){
        CapabilityManager.INSTANCE.register(ILightningUpgradable.class,new CapabilityLightningUpgradable(),new CapabilityLightningUpgradableFactory());
    }



}
