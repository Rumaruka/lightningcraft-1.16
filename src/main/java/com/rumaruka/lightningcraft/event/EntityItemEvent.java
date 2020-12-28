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
//    @SubscribeEvent
//    public void onEntityItemStruckByLightning(EntityStruckByLightningEvent e) {
//        World level = e.getEntity().level;
//        PlayerEntity player = (PlayerEntity) e.getEntity();
//
//        if(!level.isClientSide&&player!=null){
//            // Get the currently held item of the player, for the hand that was used in the
//            // event.
//            final ItemStack heldItem = player.getMainHandItem();
//
//            // Iterates all the recipes for the custom recipe type. If you have lots of recipes
//            // you may want to consider adding some form of recipe caching. In this case we
//            // could store the last successful recipe in a global field to lower the lookup
//            // time for repeat crafting. You could also use RecipesUpdatedEvent to build a
//            // cache of your recipes. Make sure to build the cache on LOWEST priority so mods
//            // like CraftTweaker can work with your recipes.
//            for (final IRecipe<?> recipe : this.getRecipes(LCTypes.LIGHTNING_TRANSFORM_RECIPES, level.getRecipeManager()).values()) {
//
//                // If you need access to custom recipe methods you will need to check and cast
//                // to your recipe type. This step could be skipped if you did it during a cache
//                // process.
//                if (recipe instanceof LightningTransformRecipes) {
//
//                    final LightningTransformRecipes clickBlockRecipe = (LightningTransformRecipes) recipe;
//
//                    // isValid is a custom recipe which checks if the held item and block match
//                    // a known recipe. If this were cached to a multimap you could use Block as
//                    // a key and only check the held item.
//                    if (clickBlockRecipe.isValid(heldItem) {
//
//                        // When the recipe is valid, shrink the held item by one.
//                        heldItem.shrink(1);
//
//                        // This forge method tries to give a player an item. If they have no
//                        // room it drops on the ground. We're giving them a copy of the output
//                        // item.
//                        ItemHandlerHelper.giveItemToPlayer(player, clickBlockRecipe.getResultItem().copy());
//                        e.setCanceled(true);
//                        break;
//                    }
//                }
//            }
//        }
//    }
//
//
//
//
//    private Map<ResourceLocation, IRecipe<?>> getRecipes (IRecipeType<?> recipeType, RecipeManager manager) {
//
//        final Map<IRecipeType<?>, Map<ResourceLocation, IRecipe<?>>> recipesMap = ObfuscationReflectionHelper.getPrivateValue(RecipeManager.class, manager, "field_199522_d");
//        return recipesMap.get(recipeType);
//    }
}



