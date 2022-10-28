package ${mod.package}.rocksmasher;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Random;

public class RockSmasher extends Item {
	private final boolean isUnbreakable;

	public RockSmasher(Settings settings) {
		super(settings);
		this.isUnbreakable = false;
	}

	public RockSmasher(boolean isUnbreakable, Settings settings) {
		super(settings);
		this.isUnbreakable = isUnbreakable;
	}

	private static void giveItem(ItemUsageContext context, Block block) {
		giveItem(context, new ItemStack(block.asItem()));
	}

	private static void giveItem(ItemUsageContext context, Item item) {
		giveItem(context, new ItemStack(item));
	}

	private static void giveItem(ItemUsageContext context, ItemStack item) {
        if (!context.getWorld().isClient) {
			BlockPos pos = context.getBlockPos();
			World world = context.getWorld();
			world.spawnEntity(new ItemEntity(world, pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f, item));
        }
    }

	private void damageItem(ItemUsageContext context) {
		if (!this.isUnbreakable) {
			context.getStack().damage(1, Objects.requireNonNull(context.getPlayer()), playerEntity -> playerEntity.getMainHandStack().setCount(0));
		}
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient) {
            if (context.getSide().equals(Direction.UP)) {
                if (smashBlock(context)) {
                	damageItem(context);
					return ActionResult.SUCCESS;
				}
            }
        }
        return super.useOnBlock(context);
    }

	public static boolean smashBlock(ItemUsageContext context) {
		final World world = context.getWorld();
		final Random random = world.getRandom();
		final BlockPos pos = context.getBlockPos();
		final BlockState block = world.getBlockState(pos);
		RockSmasherRecipe recipe = null;
		for (int i = 0; i < RockSmasherRecipes.recipes.length; i++) {
			BlockState ingredient = RockSmasherRecipes.recipes[i].ingredient;
			Material material = RockSmasherRecipes.recipes[i].ingredientMaterial;
			if (material != null) {
				if (block.getMaterial().equals(material)) {
					recipe = RockSmasherRecipes.recipes[i];
				}
			}
			if (ingredient != null) {
				if (block.equals(ingredient)) {
					recipe = RockSmasherRecipes.recipes[i];
				}
			}
		}
		if (recipe == null) {
			return false;
		} else {
			world.breakBlock(pos, false);
			if (recipe.output != null) {
				giveItem(context, recipe.output);
			}
			for (int i = 0; i < recipe.secondaryOutputs.length; i++) {
				if (random.nextInt(recipe.secondaryOutputChances[i]) == 0) {
					giveItem(context, recipe.secondaryOutputs[i]);
				}
			}
			return true;
		}
	}
}