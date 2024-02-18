package org.kisten.dragonslayer;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.SmithingTransformRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static net.kyori.adventure.text.Component.text;

public final class Dragonslayer extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        SumCrafts();
    }

    public void SumCrafts() {

        Component EchoDustName = text("Эхо пыль").color(NamedTextColor.DARK_RED);
        Component EchoDustLore = text("Эта пыль вибрирует тусклым светом").color(NamedTextColor.DARK_AQUA);
        ItemStack EchoDust = new ItemStack(Material.REDSTONE);
        ItemMeta EchoDustMeta = EchoDust.getItemMeta();
        Objects.requireNonNull(EchoDustMeta).displayName(EchoDustName);
        List glist = new ArrayList();
        glist.add(EchoDustLore);
        Objects.requireNonNull(EchoDustMeta).lore(glist);
        EchoDust.setItemMeta(EchoDustMeta);
        NamespacedKey EchoDustyKey = new NamespacedKey(this, "EchoDust");
        SmithingTransformRecipe EchoDustRecipe = new SmithingTransformRecipe(EchoDustyKey, EchoDust, new RecipeChoice.MaterialChoice(Material.AIR), new RecipeChoice.MaterialChoice(Material.ECHO_SHARD),
                new RecipeChoice.MaterialChoice(Material.GLOWSTONE_DUST));
        Bukkit.addRecipe(EchoDustRecipe);

        Component DarkMetalName = text("Тёмный металл").color(NamedTextColor.DARK_GRAY);
        Component DarkMetaLore = text("Закалённый металл в великой кузне").color(NamedTextColor.DARK_AQUA);
        ItemStack DarkMetal = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta DarkMetalMeta = DarkMetal.getItemMeta();
        Objects.requireNonNull(DarkMetalMeta).displayName(DarkMetalName);
        List glist1 = new ArrayList();
        glist1.add(DarkMetaLore);
        Objects.requireNonNull(DarkMetalMeta).lore(glist1);
        DarkMetal.setItemMeta(DarkMetalMeta);
        NamespacedKey DarkMetalyKey = new NamespacedKey(this, "DarkMetal");
        ShapedRecipe DarkMetalRecipe = new ShapedRecipe(DarkMetalyKey, DarkMetal);
        DarkMetalRecipe.shape("IXI", "XOX", "IXI");
        DarkMetalRecipe.setIngredient('I', Material.IRON_INGOT);
        DarkMetalRecipe.setIngredient('X', Material.ANCIENT_DEBRIS);
        DarkMetalRecipe.setIngredient('O', EchoDust);
        Bukkit.addRecipe(DarkMetalRecipe);

        Component LongySwordyName = text("Длинный меч").color(NamedTextColor.DARK_PURPLE);
        Component LongySwordyLore = text("Меч из тёмного металла").color(NamedTextColor.DARK_GRAY);
        ItemStack LongySwordy = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta GatsuSwordo = LongySwordy.getItemMeta();
        Objects.requireNonNull(GatsuSwordo).displayName(LongySwordyName);
        List glist2 = new ArrayList();
        glist2.add(LongySwordyLore);
        Objects.requireNonNull(GatsuSwordo).lore(glist2);
        LongySwordy.setItemMeta(GatsuSwordo);
        NamespacedKey LongySwordyKey = new NamespacedKey(this, "LongySwordy");
        AttributeModifier M = new AttributeModifier("pipiska", 10, AttributeModifier.Operation.ADD_NUMBER);
        GatsuSwordo.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, M);
        GatsuSwordo.addEnchant(Enchantment.SWEEPING_EDGE, 4, true);
        LongySwordy.setItemMeta(GatsuSwordo);
        SmithingTransformRecipe LongSword = new SmithingTransformRecipe(LongySwordyKey, LongySwordy, new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                new RecipeChoice.MaterialChoice(Material.NETHERITE_SWORD), new  RecipeChoice.ExactChoice(DarkMetal));
        Bukkit.addRecipe(LongSword);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        SumCrafts();
    }
}
