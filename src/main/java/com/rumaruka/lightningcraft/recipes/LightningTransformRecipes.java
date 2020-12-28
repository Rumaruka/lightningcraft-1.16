package com.rumaruka.lightningcraft.recipes;

import com.google.gson.JsonObject;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.Nullable;

import static com.rumaruka.lightningcraft.LightningCraft.rl;



public class LightningTransformRecipes implements IRecipe<IInventory> {
    public static final LCSerializer SERIALIZER = new LCSerializer();

    private final Ingredient input;
    private final ItemStack output;

    private final ResourceLocation id;

    public LightningTransformRecipes(ResourceLocation id, Ingredient input, ItemStack output, Block block) {

        this.id = id;
        this.input = input;
        this.output = output;


        // This output is not required, but it can be used to detect when a recipe has been
        // loaded into the game.
        System.out.println("Loaded " + this.toString());
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        return this.input.test(inv.getItem(0));
    }

    @Override
    public ItemStack assemble(IInventory inv) {
        return this.output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResultItem() {
        return this.output;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public IRecipeType<?> getType() {
        return null;
    }

    @Override
    public String toString() {
        return "LightningTransformRecipes{" +
                "input=" + input +
                ", output=" + output +

                ", id=" + id +
                '}';
    }
    public boolean isValid (ItemStack input) {

        return this.input.test(input);
    }
    private static class LCSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<LightningTransformRecipes> {

        LCSerializer() {

            // This registry name is what people will specify in their json files.
            this.setRegistryName(rl("lightning_transform_recipes"));
        }

        @Override
        public LightningTransformRecipes fromJson(ResourceLocation recipeId, JsonObject json) {
            return null;
        }

        @Nullable
        @Override
        public LightningTransformRecipes fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
            return null;
        }

        @Override
        public void toNetwork(PacketBuffer buffer, LightningTransformRecipes recipe) {

        }
    }
}
