package ${mod.package}.rocksmasher;

import com.beckati.smashingrocks.SmashingRocks;
import com.beckati.smashingrocks.registry.ModItems;
import com.beckati.smashingrocks.registry.ModBlocks;

import com.google.gson.JsonObject;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RockSmasherRecipes {
	public static final ItemStack[] leavesSecondaryOutputs = {
			new ItemStack(Items.APPLE),
			new ItemStack(Items.STICK),
			new ItemStack(ModItems.DAMP_MOSS),
	};
	public static final int[] leavesSecondaryChances = {
			10, 3, 20,
	};

	public static final ItemStack[] gravellySiltSecondaryOutputs = {
			new ItemStack(ModItems.FLINT_SHARD),
			new ItemStack(Items.POINTED_DRIPSTONE),
	};
	public static final int[] gravellySiltSecondaryChances = {
			2, 64,
	};

	public static final ItemStack[] cobblestoneSecondaryOutputs = {
			new ItemStack(Items.COARSE_DIRT),
			new ItemStack(ModItems.PEBBLE),
			new ItemStack(Items.FLINT),
	};
	public static final int[] cobblestoneSecondaryOutputChances = {
			10, 2, 8,
	};

	public static final ItemStack[] cobbledDeepslateSecondaryOutputs = {
			new ItemStack(Items.COARSE_DIRT),
			new ItemStack(ModItems.DEEPSLATE_PEBBLE),
			new ItemStack(ModItems.ASH_PILE),
	};
	public static final int[] cobbledDeepslateSecondaryOutputChances = {
			10, 2, 6,
	};

	public static final ItemStack[] gravelSecondaryOutputs = {
			new ItemStack(ModItems.GRAVEL_DUST),
			new ItemStack(Items.FLINT),
			new ItemStack(ModItems.IRON_PEBBLE),
			new ItemStack(ModItems.GOLD_PEBBLE),
	};
	public static final int[] gravelSecondaryOutputChances = {
			3, 5, 12, 20,
	};

	public static final ItemStack[] sandSecondaryOutputs = {
			new ItemStack(ModItems.IRON_DUST),
			new ItemStack(ModItems.GOLD_DUST),
			new ItemStack(Items.SUGAR_CANE),
			new ItemStack(Items.CACTUS),
	};
	public static final int[] sandSecondaryOutputChances = {
			8, 12, 24, 24,
	};

	public static final ItemStack[] coarseDirtSecondaryOutputs = {
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
	public static final int[] coarseDirtSecondaryOutputChances = {
			12, 16, 16, 16, 16, 16, 16, 16, 12, 12, 12, 12, 12, 11, 8, 6, 6, 6, 6, 6,
	};

	public static final ItemStack[] dirtSecondaryOutputs = {
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
	public static final int[] dirtSecondaryOutputChances = {
			12, 16, 16, 16, 16, 16, 16, 16, 12, 12, 12, 12, 12, 11, 8,
	};

	public static final ItemStack[] charcoalDustBlockOutputs = {
			new ItemStack(ModItems.DIAMOND_DUST),
			new ItemStack(ModItems.DIAMOND_DUST),
			new ItemStack(ModItems.ASH_PILE),
			new ItemStack(ModItems.CARBON_COATED_PEBBLE),
	};
	public static final int[] charcoalDustBlockOutputChances = {
			4, 4, 2, 4,
	};

	public static final ItemStack[] dustBlockSecondaryOutputs = {
			new ItemStack(ModItems.BONE_DUST),
			new ItemStack(ModItems.IRON_DUST),
			new ItemStack(Items.CLAY_BALL),
	};
	public static final int[] dustBlockSecondaryOutputChances = {
			2, 5, 2,
	};

	public static final ItemStack[] clayBlockSecondaryOutputs = {
			new ItemStack(ModItems.BONE_DUST),
			new ItemStack(Items.CLAY_BALL),
			new ItemStack(Items.CLAY_BALL),
			new ItemStack(Items.CLAY_BALL),
			new ItemStack(ModItems.TUFF_PEBBLE),
			new ItemStack(ModItems.CALCITE_PEBBLE),
	};
	public static final int[] clayBlockSecondaryOutputChances = {
			4, 4, 4, 4, 4, 4,
	};

	public static final Block[] listAllLeaves = {
			Blocks.OAK_LEAVES,
			Blocks.BIRCH_LEAVES,
			Blocks.ACACIA_LEAVES,
			Blocks.JUNGLE_LEAVES,
			Blocks.SPRUCE_LEAVES,
			Blocks.DARK_OAK_LEAVES,
	};

	public static final RockSmasherRecipe[] recipes = {
			new RockSmasherRecipe(listAllLeaves, new ItemStack(ModItems.ORGANIC_MASS), leavesSecondaryOutputs, leavesSecondaryChances),
			new RockSmasherRecipe(ModBlocks.GRAVELLY_SILT, new ItemStack(ModItems.FLINT_SHARD), gravellySiltSecondaryOutputs, gravellySiltSecondaryChances),
			new RockSmasherRecipe(Blocks.COBBLESTONE, new ItemStack(Items.GRAVEL), cobblestoneSecondaryOutputs, cobblestoneSecondaryOutputChances),
			new RockSmasherRecipe(Blocks.COBBLED_DEEPSLATE, new ItemStack(Items.GRAVEL), cobbledDeepslateSecondaryOutputs, cobbledDeepslateSecondaryOutputChances),
			new RockSmasherRecipe(Blocks.GRAVEL, new ItemStack(Items.SAND), gravelSecondaryOutputs, gravelSecondaryOutputChances),
			new RockSmasherRecipe(Blocks.SAND, new ItemStack(ModItems.DUST_BLOCK), sandSecondaryOutputs, sandSecondaryOutputChances),
			new RockSmasherRecipe(Blocks.COARSE_DIRT, null, coarseDirtSecondaryOutputs, coarseDirtSecondaryOutputChances),
			new RockSmasherRecipe(Blocks.DIRT, null, dirtSecondaryOutputs, dirtSecondaryOutputChances),
			new RockSmasherRecipe(ModBlocks.CHARCOAL_DUST_BLOCK, null, charcoalDustBlockOutputs, charcoalDustBlockOutputChances),
			new RockSmasherRecipe(ModBlocks.DUST_BLOCK, null, dustBlockSecondaryOutputs, dustBlockSecondaryOutputChances),
			new RockSmasherRecipe(Blocks.CLAY, new ItemStack(ModItems.DUST_BLOCK), clayBlockSecondaryOutputs, clayBlockSecondaryOutputChances),
	};

	public static final String[] recipeFileNames = {
			"leaves",
			"gravelly_silt",
			"cobblestone",
			"cobbled_deepslate",
			"gravel",
			"sand",
			"coarse_dirt",
			"dirt",
			"charcoal_dust_block",
			"dust_block",
			"clay",
	};

	public static void writeDefaultRecipes(String configPath) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		for (int i=0; i<recipes.length; i++) {
			FileWriter fileWriter = null;
			String path = configPath.concat(File.separator).concat(recipeFileNames[i]).concat(".json");
			try
			{
				fileWriter = new FileWriter(path);
				JsonObject obj = new JsonObject();
				RockSmasherRecipe.Serializer.toJson(obj, recipes[i], null);
				fileWriter.write(gson.toJson(obj));
				fileWriter.close();
			}
			catch (Exception ex)
			{
				SmashingRocks.LOGGER.warn("Failed to write default configuration file: ".concat(path));
				ex.printStackTrace();
			}
		}
	}

}