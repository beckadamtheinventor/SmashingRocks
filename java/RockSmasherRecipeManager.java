package ${mod.package}.rocksmasher;

import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class RockSmasherRecipeManager {
    public static ArrayList<RockSmasherRecipe> recipes = new ArrayList<>();

    public static void addFromDirectory(String directoryNameString) throws FileNotFoundException {
		File dir = new File(directoryNameString);
		File[] directoryListing = dir.listFiles((dir1, name) -> name.endsWith(".json"));
		if (directoryListing == null) {
			throw new FileNotFoundException();
		} else if (directoryListing.length == 0) {
			throw new FileNotFoundException();
		} else {
			for (File child : directoryListing) {
				RockSmasherRecipeManager.add(directoryNameString.concat(File.separator).concat(child.getName()));
			}
		}
    }

    public static void add(String fileNameString) throws FileNotFoundException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(fileNameString);
		JsonObject obj = JsonParser.parseReader(reader).getAsJsonObject();
        RockSmasherRecipeManager.add(RockSmasherRecipe.Serializer.fromJson(obj, null));
    }
	
	public static void add(RockSmasherRecipe recipe) {
		RockSmasherRecipeManager.recipes.add(recipe);
	}
	
	public static void add(RockSmasherRecipe[] recipes) {
		RockSmasherRecipeManager.recipes.addAll(Arrays.asList(recipes));
	}
	
	public static void add(ArrayList<RockSmasherRecipe> recipes) {
		RockSmasherRecipeManager.recipes.addAll(recipes);
	}

}
