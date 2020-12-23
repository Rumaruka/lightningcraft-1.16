package com.rumaruka.lightningcraft.event;


import com.rumaruka.lightningcraft.api.util.JointList;
import com.rumaruka.lightningcraft.recipes.LightningTransformRecipes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityItemEvent {
    @SubscribeEvent
    public void onEntityItemStruckByLightning(EntityStruckByLightningEvent e) {
        World level = e.getEntity().level;
        PlayerEntity player= (PlayerEntity) e.getEntity();
        if(!level.isClientSide && e.getEntity().isAlive() && e.getEntity() instanceof ItemEntity){
            ItemEntity drop = (ItemEntity) e.getEntity();
            JointList<ItemStack> input = new JointList().join(drop.getItem());
            JointList<ItemEntity> activeItem = new JointList().join(drop.getItem());

            for(Entity t :level.getLoadedEntitiesOfClass(Entity.class, player.getBoundingBox())) {
                if(!t.isAlive() && t instanceof ItemEntity && t != drop && t.distanceTo(drop) <= 2) {
                    ItemEntity et = (ItemEntity)t;
                    input.add(et.getItem());
                    activeItem.add(et);
                }
            }
            ItemStack out = LightningTransformRecipes.instance().getTransformResult(input);
            if(out.isEmpty()) return; // abort processing here if there's no output

            // now remove the items
            for(ItemEntity ent : activeItem) ent.remove();

            // spawn an invincible resulting item at that position
            ItemEntity entityitem = new ItemEntity(level, drop.position().x, drop.position().y, drop.position().z, out);
            level.addFreshEntity(entityitem);
        }
    }




}
