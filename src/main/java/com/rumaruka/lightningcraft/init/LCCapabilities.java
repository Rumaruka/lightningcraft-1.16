package com.rumaruka.lightningcraft.init;



import com.rumaruka.lightningcraft.LightningCraft;
import com.rumaruka.lightningcraft.api.cap.ILightningUpgradable;
import com.rumaruka.lightningcraft.api.cap.impl.BaseLightningUpgradable;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import org.jetbrains.annotations.Nullable;


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

    public static void setupCap(){
        LightningCraft.logger.info("Register LightningUpgradable Capability");
        CapabilityManager.INSTANCE.register(ILightningUpgradable.class,new CapabilityLightningUpgradable(),new BaseLightningUpgradable());
    }



}
