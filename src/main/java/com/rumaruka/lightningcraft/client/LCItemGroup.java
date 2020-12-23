package com.rumaruka.lightningcraft.client;

import com.rumaruka.lightningcraft.LightningCraft;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class LCItemGroup extends ItemGroup {

    public static final LCItemGroup LC_ITEM_GROUP = new LCItemGroup(LightningCraft.MODID);

    public LCItemGroup(String label) {
        super(label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.DIAMOND);
    }
}
