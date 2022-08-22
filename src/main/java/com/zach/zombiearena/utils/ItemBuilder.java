package com.zach.zombiearena.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.zach.zombiearena.ZombieArena;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemBuilder {
    private static ItemStack item;

    private static ItemMeta meta;

    public static ItemStack createItem(String material, String displayname, List<String> guiLore, List<String> lore, List<String> enchantments, boolean enchanted) {
        List<String> itemLore = new ArrayList<>();
        List<String> guiItemLore = new ArrayList<>();
        if (material.contains("PLAYER_HEAD")) {
            String base64ID = material.split(":")[1];
            item = new ItemStack(Material.PLAYER_HEAD);
            if (base64ID.isEmpty())
                return item;
            SkullMeta skullMeta = (SkullMeta) item.getItemMeta();
            GameProfile profile = new GameProfile(UUID.randomUUID(), null);
            profile.getProperties().put("textures", new Property("textures", base64ID));
            try {
                Field field = skullMeta.getClass().getDeclaredField("profile");
                field.setAccessible(true);
                field.set(skullMeta, profile);
            } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }

            item.setItemMeta(skullMeta);
        } else {
            item = new ItemStack(Material.valueOf(material));
        }
        meta = item.getItemMeta();
        meta.setDisplayName(ZombieArena.color(displayname));
        if (lore != null) {
            for (String strings : lore)
                itemLore.add(ZombieArena.color(strings));
            meta.setLore(itemLore);
        }
        if (guiLore != null) {
            for (String strings : guiLore)
                guiItemLore.add(ZombieArena.color(strings));
            meta.setLore(guiItemLore);
        }
        if (enchantments != null)
            for (String enchants : enchantments) {
                if (enchants != null) {
                    String enchantname = enchants.split(":")[0];
                    int enchantlvl = Integer.parseInt(enchants.split(":")[1]);
                    meta.addEnchant(Enchantment.getByName(enchantname), enchantlvl, true);
                    item.setItemMeta(meta);
                }
            }
        if (enchanted) {
            meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        item.setItemMeta(meta);
        return item;
    }
}
