package com.rumaruka.lightningcraft.utils;

import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

import javax.annotation.Nonnull;
import java.util.Random;

public class SkyUtils {
    public static final int skyRepairTime = 5 * 20; // every 5 seconds * 20 tps
    static final Random random = new Random();
    public static void damageStack(int damage, @Nonnull ItemStack stack, LivingEntity user, EquipmentSlotType slot, boolean zeroMax) {
        int cdamage = stack.getDamageValue();
        stack.hurtAndBreak(damage, user, (playerEntity_) -> {
            playerEntity_.broadcastBreakEvent(slot);
        });
        if(!stack.isEmpty()) {
            boolean comp2 = zeroMax ? cdamage + damage >= stack.getMaxDamage() : cdamage + damage > stack.getMaxDamage();
            if(comp2) user.setItemSlot(slot, ItemStack.EMPTY);
        }
    }

    /** Damage an itemstack */
    public static void damageStack(int damage, @Nonnull ItemStack stack, LivingEntity user, EquipmentSlotType slot) {
        damageStack(damage, stack, user, slot, false);
    }
}
