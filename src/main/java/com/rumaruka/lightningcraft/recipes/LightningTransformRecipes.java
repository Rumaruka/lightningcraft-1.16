package com.rumaruka.lightningcraft.recipes;

import com.rumaruka.lightningcraft.api.util.JointList;
import com.rumaruka.lightningcraft.init.LCItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LightningTransformRecipes   {
    private static LightningTransformRecipes instance = new LightningTransformRecipes();


    private Map<List<ItemStack>, ItemStack> recipeMaps;
    public static LightningTransformRecipes instance() {
        return instance;
    }


    public void addDefaultRecipes(){
        recipeMaps = new HashMap();


        addRecipe(new ItemStack(LCItems.INGOT_ELECTRICIUM),
                new JointList().join(new ItemStack(Items.IRON_INGOT)).join(new ItemStack(Items.GOLD_INGOT)).join(new ItemStack(Items.DIAMOND)));
    }
    public void addRecipe(@Nonnull ItemStack output, List<ItemStack> input) {
        recipeMaps.put(input, output);
    }

    /** Get the transformation of the input item stacks */
    public @Nonnull ItemStack getTransformResult(List<ItemStack> input) {
        int matches = 0;
        List comp = null;
        ItemStack result = ItemStack.EMPTY;
        for(Map.Entry<List<ItemStack>, ItemStack> entry : recipeMaps.entrySet()) {
            for(ItemStack rIn : entry.getKey()) {
                for(ItemStack iIn : input) {
                    if(ItemStack.isSame(rIn, iIn)) {
                        matches++;
                        result = entry.getValue();
                        comp = entry.getKey();
                    }
                }
            }
        }
        if(matches == input.size() && matches == comp.size()) {
            return result.copy(); // don't alter this stack!
        } else {
            return ItemStack.EMPTY;
        }
    }
}
