package com.rumaruka.lightningcraft.recipes;

import net.minecraft.item.crafting.IRecipeType;

public class LightningTransformRecipesBlock implements IRecipeType<LightningTransformRecipes> {
    @Override
    public String toString () {

        // All vanilla recipe types return their ID in toString. I am not sure how vanilla uses
        // this, or if it does. Modded types should follow this trend for the sake of
        // consistency. I am also using it during registry to create the ResourceLocation ID.
        return "lightning_transform_recipes";
    }
}
