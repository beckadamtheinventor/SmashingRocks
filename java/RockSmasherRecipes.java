package ${mod.package}.rocksmasher;

import ${mod.package}.registry.ModItems;
import ${mod.package}.registry.ModBlocks;

import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;

public class RockSmasherRecipes {
	private static final ItemStack[] leavesSecondaryOutputs = {
			new ItemStack(Items.APPLE),
			new ItemStack(Items.STICK),
			new ItemStack(ModItems.DAMP_MOSS),
			new ItemStack(ModItems.ORGANIC_MASS),
	};
	private static final int[] leavesSecondaryChances = {
			10, 3, 20, 1,
	};

	private static final ItemStack[] gravellySiltSecondaryOutputs = {
			new ItemStack(ModItems.FLINT_SHARD),
			new ItemStack(Items.POINTED_DRIPSTONE),
	};
	private static final int[] gravellySiltSecondaryChances = {
			2, 64,
	};

	private static final ItemStack[] cobblestoneSecondaryOutputs = {
			new ItemStack(Items.COARSE_DIRT),
			new ItemStack(ModItems.PEBBLE),
			new ItemStack(Items.FLINT),
	};
	private static final int[] cobblestoneSecondaryOutputChances = {
			10, 2, 8,
	};

	private static final ItemStack[] cobbledDeepslateSecondaryOutputs = {
			new ItemStack(Items.COARSE_DIRT),
			new ItemStack(ModItems.DEEPSLATE_PEBBLE),
			new ItemStack(ModItems.ASH_PILE),
	};
	private static final int[] cobbledDeepslateSecondaryOutputChances = {
			10, 2, 6,
	};

	private static final ItemStack[] gravelSecondaryOutputs = {
			new ItemStack(Items.FLINT),
			new ItemStack(ModItems.GRAVEL_DUST),
			new ItemStack(ModItems.IRON_PEBBLE),
			new ItemStack(ModItems.GOLD_PEBBLE),
	};
	private static final int[] gravelSecondaryOutputChances = {
			5, 6, 12, 20,
	};

	private static final ItemStack[] sandSecondaryOutputs = {
			new ItemStack(ModItems.IRON_DUST),
			new ItemStack(ModItems.GOLD_DUST),
			new ItemStack(Items.SUGAR_CANE),
			new ItemStack(Items.CACTUS),
	};
	private static final int[] sandSecondaryOutputChances = {
			8, 12, 24, 24,
	};

	private static final ItemStack[] coarseDirtSecondaryOutputs = {
			new ItemStack(Items.WHEAT_SEEDS),
			new ItemStack(Items.BEETROOT_SEEDS),
			new ItemStack(Items.MELON_SEEDS),
			new ItemStack(Items.PUMPKIN_SEEDS),
			new ItemStack(Items.CARROT),
			new ItemStack(Items.POTATO),
			new ItemStack(Items.COCOA_BEANS),
			new ItemStack(Items.OAK_SAPLING),
			new ItemStack(Items.SPRUCE_SAPLING),
			new ItemStack(Items.ACACIA_SAPLING),
			new ItemStack(Items.BIRCH_SAPLING),
			new ItemStack(Items.JUNGLE_SAPLING),
			new ItemStack(Items.DARK_OAK_SAPLING),
			new ItemStack(Items.CLAY_BALL),
			new ItemStack(ModItems.PEBBLE),
			new ItemStack(ModItems.ANDESITE_PEBBLE),
			new ItemStack(ModItems.DIORITE_PEBBLE),
			new ItemStack(ModItems.GRANITE_PEBBLE),
			new ItemStack(ModItems.DEEPSLATE_PEBBLE),
	};
	private static final int[] coarseDirtSecondaryOutputChances = {
			12, 16, 16, 16, 16, 16, 16, 16, 12, 12, 12, 12, 12, 11, 8, 6, 6, 6, 6, 6,
	};

	private static final ItemStack[] dirtSecondaryOutputs = {
			new ItemStack(Items.WHEAT_SEEDS),
			new ItemStack(Items.BEETROOT_SEEDS),
			new ItemStack(Items.MELON_SEEDS),
			new ItemStack(Items.PUMPKIN_SEEDS),
			new ItemStack(Items.CARROT),
			new ItemStack(Items.POTATO),
			new ItemStack(Items.COCOA_BEANS),
			new ItemStack(Items.OAK_SAPLING),
			new ItemStack(Items.SPRUCE_SAPLING),
			new ItemStack(Items.ACACIA_SAPLING),
			new ItemStack(Items.BIRCH_SAPLING),
			new ItemStack(Items.JUNGLE_SAPLING),
			new ItemStack(Items.DARK_OAK_SAPLING),
			new ItemStack(Items.CLAY_BALL),
	};
	private static final int[] dirtSecondaryOutputChances = {
			12, 16, 16, 16, 16, 16, 16, 16, 12, 12, 12, 12, 12, 11, 8,
	};

	private static final ItemStack[] charcoalDustBlockOutputs = {
			new ItemStack(ModItems.DIAMOND_DUST),
			new ItemStack(ModItems.DIAMOND_DUST),
			new ItemStack(ModItems.ASH_PILE),
			new ItemStack(ModItems.CARBON_COATED_PEBBLE),
	};
	private static final int[] charcoalDustBlockOutputChances = {
			4, 4, 2, 4,
	};

	private static final ItemStack[] dustBlockSecondaryOutputs = {
			new ItemStack(ModItems.BONE_DUST),
			new ItemStack(ModItems.IRON_DUST),
			new ItemStack(Items.CLAY_BALL),
	};
	private static final int[] dustBlockSecondaryOutputChances = {
			2, 5, 2,
	};

	private static final ItemStack[] clayBlockSecondaryOutputs = {
			new ItemStack(ModItems.BONE_DUST),
			new ItemStack(Items.CLAY_BALL),
			new ItemStack(Items.CLAY_BALL),
			new ItemStack(ModItems.TUFF_PEBBLE),
			new ItemStack(ModItems.CALCITE_PEBBLE),
	};
	private static final int[] clayBlockSecondaryOutputChances = {
			4, 5, 5, 6, 6,
	};

	public static final RockSmasherRecipe[] recipes = {
			new RockSmasherRecipe(Material.LEAVES, null, leavesSecondaryOutputs, leavesSecondaryChances),
			new RockSmasherRecipe(ModBlocks.GRAVELLY_SILT.getDefaultState(), new ItemStack(ModItems.FLINT_SHARD), gravellySiltSecondaryOutputs, gravellySiltSecondaryChances),
			new RockSmasherRecipe(Blocks.COBBLESTONE.getDefaultState(), new ItemStack(Items.GRAVEL), cobblestoneSecondaryOutputs, cobblestoneSecondaryOutputChances),
			new RockSmasherRecipe(Blocks.COBBLED_DEEPSLATE.getDefaultState(), new ItemStack(Items.GRAVEL), cobbledDeepslateSecondaryOutputs, cobbledDeepslateSecondaryOutputChances),
			new RockSmasherRecipe(Blocks.GRAVEL.getDefaultState(), new ItemStack(Items.SAND), gravelSecondaryOutputs, gravelSecondaryOutputChances),
			new RockSmasherRecipe(Blocks.SAND.getDefaultState(), new ItemStack(ModItems.DUST_BLOCK), sandSecondaryOutputs, sandSecondaryOutputChances),
			new RockSmasherRecipe(Blocks.COARSE_DIRT.getDefaultState(), null, coarseDirtSecondaryOutputs, coarseDirtSecondaryOutputChances),
			new RockSmasherRecipe(Blocks.DIRT.getDefaultState(), null, dirtSecondaryOutputs, dirtSecondaryOutputChances),
			new RockSmasherRecipe(ModBlocks.CHARCOAL_DUST_BLOCK.getDefaultState(), null, charcoalDustBlockOutputs, charcoalDustBlockOutputChances),
			new RockSmasherRecipe(ModBlocks.DUST_BLOCK.getDefaultState(), null, dustBlockSecondaryOutputs, dustBlockSecondaryOutputChances),
			new RockSmasherRecipe(Blocks.CLAY.getDefaultState(), new ItemStack(ModItems.DUST_BLOCK), clayBlockSecondaryOutputs, clayBlockSecondaryOutputChances),
	};
}