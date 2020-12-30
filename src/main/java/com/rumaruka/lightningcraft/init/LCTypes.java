package com.rumaruka.lightningcraft.init;

import com.rumaruka.lightningcraft.recipes.LightningTransformRecipes;
import com.rumaruka.lightningcraft.recipes.LightningTransformRecipesBlock;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;

import static com.rumaruka.lightningcraft.LightningCraft.rl;


public class LCTypes {

    public static final IRecipeType<LightningTransformRecipes> LIGHTNING_TRANSFORM_RECIPES = new LightningTransformRecipesBlock();


    public static void setupRecipe(RegistryEvent.Register<IRecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE,rl(LIGHTNING_TRANSFORM_RECIPES.toString()),LIGHTNING_TRANSFORM_RECIPES);
        event.getRegistry().register(LightningTransformRecipes.SERIALIZER);
    }
}
