package com.rumaruka.lightningcraft.event;


import com.rumaruka.lightningcraft.init.LCTypes;
import com.rumaruka.lightningcraft.recipes.LightningTransformRecipes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.items.ItemHandlerHelper;

import java.util.Map;

public class EntityItemEvent {
    @SubscribeEvent
    public void onEntityItemStruckByLightning(EntityStruckByLightningEvent e) {
        World level = e.getEntity().level;
        PlayerEntity player = (PlayerEntity) e.getEntity();

        if(!level.isClientSide&&player!=null){

            final ItemStack heldItem = player.getMainHandItem();

            for (final IRecipe<?> recipe : this.getRecipes(LCTypes.LIGHTNING_TRANSFORM_RECIPES, level.getRecipeManager()).values()) {


                if (recipe instanceof LightningTransformRecipes) {

                    final LightningTransformRecipes clickBlockRecipe = (LightningTransformRecipes) recipe;


                    if (clickBlockRecipe.isValid(heldItem)) {


                        heldItem.shrink(1);


                        ItemHandlerHelper.giveItemToPlayer(player, clickBlockRecipe.getResultItem().copy());
                        e.setCanceled(true);
                        break;
                    }
                }
            }
        }
    }




    private Map<ResourceLocation, IRecipe<?>> getRecipes (IRecipeType<?> recipeType, RecipeManager manager) {

        final Map<IRecipeType<?>, Map<ResourceLocation, IRecipe<?>>> recipesMap = ObfuscationReflectionHelper.getPrivateValue(RecipeManager.class, manager, "field_199522_d");
        return recipesMap.get(recipeType);
    }
}



