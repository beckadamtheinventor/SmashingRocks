package ${mod.package};

import ${mod.package}.registry.ModBlocks;
import ${mod.package}.registry.ModItems;
import ${mod.package}.rocksmasher.RockSmasherRecipes;
import ${mod.package}.rocksmasher.RockSmasherRecipeManager;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Blocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


public class ${mod.class} implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("${mod.mcpath}");
	public static final String MOD_ID = "${mod.mcpath}";

	private static ConfiguredFeature<?, ?> OVERWORLD_GRAVELLY_SILT_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
		(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.GRAVELLY_SILT.getDefaultState(), 20));

	public static PlacedFeature OVERWORLD_GRAVELLY_SILT_ORE_PLACED_FEATURE = new PlacedFeature
		(RegistryEntry.of(OVERWORLD_GRAVELLY_SILT_ORE_CONFIGURED_FEATURE),
			Arrays.asList(
				CountPlacementModifier.of(10),
				SquarePlacementModifier.of(),
				HeightRangePlacementModifier.uniform(
	YOffset.getBottom(), YOffset.fixed(63))));

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "general"),
			() -> new ItemStack(ModItems.DIAMOND_ROCK_SMASHER));

	@Override
	public void onInitialize() {
		ModItems.RegisterItems();
		ModBlocks.RegisterBlocks();
		String configDir = FabricLoader.getInstance().getConfigDir().toString().concat(File.separator).concat("SmashingRocks");
		String recipesDir = configDir.concat(File.separator).concat("recipes");
		Path recipesPath = Path.of(recipesDir);
		try {
			RockSmasherRecipeManager.addFromDirectory(recipesDir);
		} catch (IOException e) {
			try {
				Files.createDirectories(recipesPath);
				RockSmasherRecipes.writeDefaultRecipes(recipesDir);
				RockSmasherRecipeManager.addFromDirectory(recipesDir);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
			new Identifier("smashingrocks", "overworld_gravelly_silt_ore"), OVERWORLD_GRAVELLY_SILT_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE,
			new Identifier("smashingrocks", "overworld_gravelly_silt_ore"), OVERWORLD_GRAVELLY_SILT_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
			RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("smashingrocks", "overworld_gravelly_silt_ore")));
	}
}
