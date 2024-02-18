package org.kisten.dragonslayer;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.*;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.DARK_PURPLE;
import static net.kyori.adventure.text.format.NamedTextColor.GOLD;
import static net.kyori.adventure.text.format.TextColor.color;

public final class Dragonslayer extends JavaPlugin {

    private static Dragonslayer instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        SumCrafts();
        instance = this;
        registerGlow();
    }

    public static Dragonslayer getInstance() {
        return instance;
    }

    public void registerGlow() {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Glow glow = new Glow();
            Enchantment.registerEnchantment(glow);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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

        Component LongySwordyName = text().content("Длинный").color(color(DARK_PURPLE)).append(text("меч", GOLD)).build();
        Component LongySwordyLore = text("Меч из тёмного металла").color(NamedTextColor.DARK_GRAY);
        ItemStack LongySwordy = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta GatsuSwordo = LongySwordy.getItemMeta();
        Objects.requireNonNull(GatsuSwordo).displayName(LongySwordyName);
        List glist2 = new ArrayList();
        glist2.add(LongySwordyLore);
        Objects.requireNonNull(GatsuSwordo).lore(glist2);
        AttributeModifier M = new AttributeModifier(UUID.randomUUID(), "pipiN", 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        GatsuSwordo.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, M);
        GatsuSwordo.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "pipiN", -3.2,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        GatsuSwordo.addEnchant(Enchantment.SWEEPING_EDGE, 4, true);
        LongySwordy.setItemMeta(GatsuSwordo);
        NamespacedKey LongySwordyKey = new NamespacedKey(this, "LongySwordy");
        SmithingTransformRecipe LongSword = new SmithingTransformRecipe(LongySwordyKey, LongySwordy, new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                new RecipeChoice.MaterialChoice(Material.NETHERITE_SWORD), new  RecipeChoice.ExactChoice(DarkMetal), false);
        Bukkit.addRecipe(LongSword);

        Component eughName = text("§5Ицо");
        Component eughLore = text("§4Правое §8или §1левое?");
        ItemStack eugh = new ItemStack(Material.DRAGON_EGG, 1);
        ItemMeta eughMeta = eugh.getItemMeta();
        Objects.requireNonNull(eughMeta).displayName(eughName);
        List glist3 = new ArrayList();
        glist3.add(eughLore);
        Objects.requireNonNull(eughMeta).lore(glist3);
        /*
        Glow glow = new Glow();
        eughMeta.addEnchant(glow, 1, true);
         */
        eugh.setItemMeta(eughMeta);
        NamespacedKey eughKey = new NamespacedKey(this, "eugh");
        ShapedRecipe eughRecipe = new ShapedRecipe(eughKey, eugh);
        eughRecipe.shape("XXX", "ABC", "XXX");
        eughRecipe.setIngredient('A', Material.TURTLE_EGG);
        eughRecipe.setIngredient('B', Material.SNIFFER_EGG);
        eughRecipe.setIngredient('C', Material.EGG);
        eughRecipe.setIngredient('X', Material.PHANTOM_MEMBRANE);
        Bukkit.addRecipe(eughRecipe);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        SumCrafts();
    }
}
