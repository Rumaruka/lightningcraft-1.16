package com.rumaruka.lightningcraft.api.cap;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ILightningUpgradable {

    /** Perform the upgrade when it is right-clicked on the related tile's block. Called on both sides */
    public ActionResultType onLightningUpgrade(ItemStack stack, PlayerEntity player, World world, BlockPos pos,
                                               Hand hand, Direction facing, float hitX, float hitY, float hitZ);

    /** Is the related tile entity currently upgraded with the Lightning Upgrade? */
    public boolean isUpgraded();

    /** Set the related tile entity to a specified upgraded state */
    public void setUpgraded(boolean upgraded);
}
