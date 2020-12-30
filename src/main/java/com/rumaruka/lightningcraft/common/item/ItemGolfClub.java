package com.rumaruka.lightningcraft.common.item;

import com.rumaruka.lightningcraft.client.LCItemGroup;
import com.rumaruka.lightningcraft.utils.EffectUtils;
import com.rumaruka.lightningcraft.utils.SkyUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemGolfClub extends Item {
    public ItemGolfClub( ) {
        super(new Item.Properties().tab(LCItemGroup.LC_ITEM_GROUP));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("lc.golf_club"));
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(!worldIn.isClientSide){
            ItemStack stack = playerIn.getItemInHand(handIn);
            stack.setDamageValue(2);
            EffectUtils.lightning(playerIn,false);

        }
        return super.use(worldIn, playerIn, handIn);
    }
}
