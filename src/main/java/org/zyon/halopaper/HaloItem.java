
package org.zyon.halopaper;

import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Equippable;
import io.papermc.paper.datacomponent.item.ItemAttributeModifiers;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component; 

import org.bukkit.Bukkit;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class HaloItem {

    private final JavaPlugin plugin;

    public HaloItem(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public ItemStack getHalo() {

        ItemStack halo = new ItemStack(Material.STICK);

        ItemAttributeModifiers.Builder builder =
            ItemAttributeModifiers.itemAttributes();

        builder.addModifier(
            Attribute.MAX_HEALTH,
            new AttributeModifier(
                new NamespacedKey(plugin, "max_health"),
                10.0,
                Operation.ADD_NUMBER,
                EquipmentSlotGroup.HEAD
            )
        );

        builder.addModifier(
            Attribute.GRAVITY,
            new AttributeModifier(
                new NamespacedKey(plugin, "gravity"),
                -0.04,
                Operation.ADD_NUMBER,
                EquipmentSlotGroup.HEAD
            )
        );

        builder.addModifier(
            Attribute.SAFE_FALL_DISTANCE,
            new AttributeModifier(
                new NamespacedKey(plugin, "SAFE_FALL_DISTANCE"),
                9.5,
                Operation.ADD_NUMBER,
                EquipmentSlotGroup.HEAD
            )
        );

        halo.setData(
            DataComponentTypes.ATTRIBUTE_MODIFIERS,
            builder.build()
        );

        halo.setData(
            DataComponentTypes.ITEM_MODEL,
            Key.key("zyon", "halo")
        );

        halo.setData(
            DataComponentTypes.ITEM_NAME,
            Component.text("Halo", NamedTextColor.GOLD)
        );

        halo.setData(
            DataComponentTypes.EQUIPPABLE,
            Equippable.equippable(EquipmentSlot.HEAD).build()
        );

        halo.setData(DataComponentTypes.MAX_STACK_SIZE, 1);

        return halo;
    }
    public void registerRecipe() {

    NamespacedKey halokey = new NamespacedKey(plugin, "halo");

    ShapedRecipe recipe = new ShapedRecipe(halokey, getHalo());

    recipe.shape(
        "AAA",
        "A A",
        "AAA"
    );

    recipe.setIngredient(
        'A',
        RecipeChoice.exactChoice(new AngelicGold().getAGold())
    );

    Bukkit.removeRecipe(halokey);
    Bukkit.addRecipe(recipe);

    }
}
