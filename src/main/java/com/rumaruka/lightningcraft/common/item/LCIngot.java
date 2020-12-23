package com.rumaruka.lightningcraft.common.item;

import com.rumaruka.lightningcraft.client.LCItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class LCIngot extends Item {
    public LCIngot( ) {
        super(new Item.Properties().tab(LCItemGroup.LC_ITEM_GROUP));
    }
}
