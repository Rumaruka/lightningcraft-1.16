package com.rumaruka.lightningcraft.common.tiles;

import com.rumaruka.lightningcraft.api.leenergy.CapabilityLEEnergy;
import com.rumaruka.lightningcraft.common.tiles.ifaces.ISidedInventoryLC;
import com.rumaruka.lightningcraft.utils.LCMisc;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public abstract class TileLightningItemHandler extends TileLightningUser implements ISidedInventoryLC {

    protected SidedInvWrapper[] itemCap;
    private ItemStack[] stacks;

    public TileLightningItemHandler(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        itemCap = LCMisc.makeInvWrapper(this);
        stacks = new ItemStack[0];
    }

    public void setSizeInventory(int size) {
        stacks = new ItemStack[size];
        for (int i = 0; i < size; i++) {
            stacks[i] = ItemStack.EMPTY;
        }
    }

    /**
     * Get the specified stack
     */
    public @Nonnull
    ItemStack getStack(int index) {
        if (index >= stacks.length) return ItemStack.EMPTY;
        return stacks[index];
    }

    /**
     * Set the specified stack
     */
    public boolean setStack(int index, @Nonnull ItemStack stack) {
        if (index >= stacks.length) return false;
        stacks[index] = stack;
        return true;
    }

    public boolean hasCapability(Capability<?> capability, Direction facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return true;
        } else {
            return hasCapability(capability, facing);
        }
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return getCapability(cap, side);
    }

    @Override
    public int getMaxStackSize() {
        return stacks.length;
    }

    @Override
    public ItemStack getItem(int index) {
        return stacks[index];
    }


    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        ListNBT nbtList = nbt.getList("Items", 10);
        setSizeInventory(this.getMaxStackSize());
        for (int i = 0; i < nbtList.stream().count(); ++i) {
            CompoundNBT slotTag = nbtList.getCompound(i);
            byte slot = slotTag.getByte("Slot");

            if (slot >= 0 && slot < this.stacks.length) {
                this.stacks[slot] = new ItemStack((IItemProvider) slotTag);
            }
        }
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);
        ListNBT tagList = new ListNBT();

        for (int i = 0; i < this.stacks.length; ++i) {
            if (!this.stacks[i].isEmpty()) {
                CompoundNBT slotTag = new CompoundNBT();
                slotTag.putByte("Slot", (byte) i);
                this.stacks[i].save(slotTag);
                tagList.add(slotTag);
            }
        }

        compound.put("Items", tagList);

        return compound;
    }

    public static abstract class Upgradable extends TileLightningItemHandler {
        public Upgradable(TileEntityType<?> tileEntityTypeIn) {
            super(tileEntityTypeIn);
        }

        public boolean hasCapability(Capability<?> capability, Direction facing) {
            if (capability == CapabilityLEEnergy.LIGHTNING_UPGRADABLE) {
                return true;
            } else {
                return hasCapability(capability, facing);
            }
        }

        @NotNull
        @Override
        public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
            return super.getCapability(cap, side);
        }

        @Override
        public void load(BlockState state, CompoundNBT nbt) {
            super.load(state, nbt);
        }

        @Override
        public CompoundNBT save(CompoundNBT compound) {
            return super.save(compound);
        }
    }
}
