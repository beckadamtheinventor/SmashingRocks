package ${mod.package}.rocksmasher;

import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.ItemStack;

public class RockSmasherRecipe {
    public final BlockState ingredient;
    public final Material ingredientMaterial;
    public final ItemStack output;
    public final ItemStack[] secondaryOutputs;
    public final int[] secondaryOutputChances;

    public RockSmasherRecipe(BlockState ingredient, ItemStack output, ItemStack[] secondaryOutputs, int[] secondaryOutputChances) {
        this.ingredient = ingredient;
        this.ingredientMaterial = null;
        this.output = output;
        this.secondaryOutputs = secondaryOutputs;
        this.secondaryOutputChances = secondaryOutputChances;
    }

    public RockSmasherRecipe(Material ingredient, ItemStack output, ItemStack[] secondaryOutputs, int[] secondaryOutputChances) {
        this.ingredient = null;
        this.ingredientMaterial = ingredient;
        this.output = output;
        this.secondaryOutputs = secondaryOutputs;
        this.secondaryOutputChances = secondaryOutputChances;
    }

}