package org.zyon.halopaper;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.papermc.paper.datacomponent.DataComponentTypes;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class AngelicGold {
    public ItemStack getAGold() {
        ItemStack AGold = new ItemStack(Material.GOLD_INGOT);
        
        AGold.setData(DataComponentTypes.ITEM_MODEL, Key.key("zyon", "angelic_gold"));

        AGold.setData(DataComponentTypes.ITEM_NAME, Component.text("Angelic Gold", NamedTextColor.GOLD));

        return AGold;
     }
    public void registerRecipe() {
        NamespacedKey angelkey = new NamespacedKey("zyon", "angelic_gold");
        ShapedRecipe recipe = new ShapedRecipe(angelkey, getAGold());
        recipe.shape(
            " G ",
            "LPL",
            " G "
        );
        recipe.setIngredient('G', Material.GLOWSTONE_DUST);
        recipe.setIngredient('L', Material.LAPIS_LAZULI);
        recipe.setIngredient('P', RecipeChoice.exactChoice(
            new PHGold().getpHGold()));

        Bukkit.removeRecipe(angelkey);
        Bukkit.addRecipe(recipe);
        
    }
}