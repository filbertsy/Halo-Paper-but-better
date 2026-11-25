package org.zyon.halopaper;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import net.kyori.adventure.key.Key;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.papermc.paper.datacomponent.DataComponentTypes;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class HellishGold {
    
    public ItemStack getHGold() {
        ItemStack HGold = new ItemStack(Material.GOLD_INGOT);

        HGold.setData(DataComponentTypes.ITEM_MODEL, Key.key("zyon", "hellish_gold"));

        HGold.setData(DataComponentTypes.ITEM_NAME, Component.text("Hellish Gold", NamedTextColor.DARK_RED));
        
        return HGold;
    }
    public void registerRecipe() {
        NamespacedKey hellkey = new NamespacedKey("zyon", "hellish_gold");
        ShapedRecipe recipe = new ShapedRecipe(hellkey, getHGold());
        recipe.shape(
            " D ",
            "DGD",
            " D "
        );

        recipe.setIngredient('D', Material.ANCIENT_DEBRIS);
        recipe.setIngredient('G', Material.GOLD_INGOT);

        Bukkit.removeRecipe(hellkey);
        Bukkit.addRecipe(recipe);
    }
}
