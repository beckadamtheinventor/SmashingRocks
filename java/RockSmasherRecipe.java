package ${mod.package}.rocksmasher;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonElement;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.JsonSerializer;
import net.minecraft.util.registry.Registry;
import org.apache.commons.lang3.ArrayUtils;

import javax.management.ListenerNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RockSmasherRecipe {
	public final Block[] ingredient;
	public final ItemStack output;
	public final ItemStack[] secondaryOutputs;
	public final int[] secondaryOutputChances;

	public RockSmasherRecipe(Block ingredient, ItemStack output, ItemStack[] secondaryOutputs, int[] secondaryOutputChances) {
		this.ingredient = new Block[]{ingredient};
		this.output = output;
		this.secondaryOutputs = secondaryOutputs;
		this.secondaryOutputChances = secondaryOutputChances;
	}

	public RockSmasherRecipe(Block[] ingredient, ItemStack output, ItemStack[] secondaryOutputs, int[] secondaryOutputChances) {
		this.ingredient = ingredient;
		this.output = output;
		this.secondaryOutputs = secondaryOutputs;
		this.secondaryOutputChances = secondaryOutputChances;
	}

	public static class Serializer {
		public Serializer() {}

		public static void toJson(JsonObject jsonObject, RockSmasherRecipe recipe, JsonSerializationContext jsonSerializationContext) {
			JsonArray ingredients = new JsonArray();
			JsonArray secondaryOutputs = new JsonArray();
			for (Block ingredient : recipe.ingredient) {
				ingredients.add(Registry.BLOCK.getId(ingredient).toString());
			}
			jsonObject.add("ingredients", ingredients);
			if (recipe.output != null) {
				JsonObject result = new JsonObject();
				result.addProperty("item", Registry.ITEM.getId(recipe.output.getItem()).toString());
				result.addProperty("count", recipe.output.getCount());
				jsonObject.add("result", result);
			}
			for (int i=0; i<recipe.secondaryOutputs.length; i++) {
				JsonObject obj = new JsonObject();
				obj.addProperty("item", Registry.ITEM.getId(recipe.secondaryOutputs[i].getItem()).toString());
				obj.addProperty("count", recipe.secondaryOutputs[i].getCount());
				obj.addProperty("chance", recipe.secondaryOutputChances[i]);
				secondaryOutputs.add(obj);
			}
			jsonObject.add("secondary", secondaryOutputs);
		}

		public static RockSmasherRecipe fromJson(JsonObject json, JsonDeserializationContext context) {
			List<Block> ingredients = new ArrayList<>();
			List<ItemStack> secondaryOutputs = new ArrayList<>();
			List<Integer> secondaryOutputChances = new ArrayList<>();
			JsonObject outputObj = json.getAsJsonObject("result");
			ItemStack output = null;
			if (outputObj != null) {
				Item outputItem = JsonHelper.getItem(outputObj, "item");
				output = new ItemStack(outputItem, JsonHelper.getInt(outputObj, "count"));
			}
			JsonArray ingredientsArray = JsonHelper.getArray(json, "ingredients");
			for (JsonElement ingredient : ingredientsArray) {
				if (ingredient.isJsonPrimitive()) {
					String blockId = ingredient.getAsString();
					ingredients.add(Registry.BLOCK.get(new Identifier(blockId)));
				}
			}
			JsonArray secondaryOutputsArray = JsonHelper.getArray(json, "secondary");
			if (secondaryOutputsArray != null) {
				for (JsonElement secondaryOutput : secondaryOutputsArray) {
					if (secondaryOutput.isJsonObject()) {
						String itemId = secondaryOutput.getAsJsonObject().get("item").getAsString();
						int count = secondaryOutput.getAsJsonObject().get("count").getAsInt();
						int chance = secondaryOutput.getAsJsonObject().get("chance").getAsInt();
						secondaryOutputs.add(new ItemStack(Registry.ITEM.get(new Identifier(itemId)), count));
						secondaryOutputChances.add(chance);
					}
				}
			}
			Block[] ingredientsArray2 = new Block[ingredientsArray.size()];
			for (int i=0; i<ingredientsArray.size(); i++) {
				ingredientsArray2[i] = ingredients.get(i);
			}
			ItemStack[] secondaryOutputsArray2 = new ItemStack[secondaryOutputs.size()];
			int[] secondaryOutputChancesArray2 = new int[secondaryOutputChances.size()];
			for (int i=0; i<secondaryOutputs.size(); i++) {
				secondaryOutputsArray2[i] = secondaryOutputs.get(i);
				secondaryOutputChancesArray2[i] = secondaryOutputChances.get(i);
			}
			return new RockSmasherRecipe(ingredientsArray2, output, secondaryOutputsArray2, secondaryOutputChancesArray2);

		}
	}
}