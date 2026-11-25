package org.zyon.halopaper;

import io.papermc.paper.datacomponent.DataComponentTypes;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;


public class PHGold {
    public ItemStack getpHGold() {
        ItemStack pHGold = new ItemStack(Material.GOLD_INGOT);

        pHGold.setData(DataComponentTypes.ITEM_MODEL, Key.key("zyon", "purified_hellish_gold"));

        pHGold.setData(DataComponentTypes.ITEM_NAME, Component.text("Purified Hellish Gold", NamedTextColor.LIGHT_PURPLE));

        return pHGold;
    }
    public void registerRecipe() {
        NamespacedKey purekey = new NamespacedKey("zyon", "purified_hellish_gold");
        ShapedRecipe recipe = new ShapedRecipe(purekey, getpHGold());
        recipe.shape(
        "   ",
        "AHQ",
        "   "
        );
        recipe.setIngredient('A', Material.AMETHYST_SHARD);
        recipe.setIngredient('H', RecipeChoice.exactChoice(
            new HellishGold().getHGold()
        ));
        recipe.setIngredient('Q', Material.QUARTZ);

        Bukkit.removeRecipe(purekey);
        Bukkit.addRecipe(recipe);
    }
}