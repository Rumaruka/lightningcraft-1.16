package com.rumaruka.lightningcraft.api.cap.impl;

import com.rumaruka.lightningcraft.api.cap.ILightningUpgradable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import org.jetbrains.annotations.Nullable;

public class BaseLightningUpgradable implements Capability.IStorage, ILightningUpgradable, INBTSerializable<CompoundNBT> {
    private boolean isUpgraded;
    @Override
    public ActionResultType onLightningUpgrade(ItemStack stack, PlayerEntity player, World world, BlockPos pos, Hand hand, Direction facing, float hitX, float hitY, float hitZ) {
        setUpgraded(true);
        return ActionResultType.SUCCESS;
    }

    @Override
    public boolean isUpgraded() {
        return isUpgraded;
    }

    @Override
    public void setUpgraded(boolean upgraded) {
        isUpgraded=upgraded;
    }

    @Override
    public CompoundNBT serializeNBT() {
        return serializeNBT(new CompoundNBT());
    }
    public CompoundNBT serializeNBT(CompoundNBT existingTag) {
        existingTag.putBoolean("isUpgraded", this.isUpgraded);
        return existingTag;
    }
    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.isUpgraded = nbt.getBoolean("isUpgraded");

    }

    @Nullable
    @Override
    public INBT writeNBT(Capability capability, Object instance, Direction side) {
        return null;
    }

    @Override
    public void readNBT(Capability capability, Object instance, Direction side, INBT nbt) {

    }
}
