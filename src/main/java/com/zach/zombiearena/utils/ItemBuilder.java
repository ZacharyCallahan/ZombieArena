package com.zach.zombiearena.utils;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
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

public class ItemBuilder {
    private static ItemStack item;
    private static ItemMeta meta;

    public static ItemStack createItem(Material material, String materialSection, String displayname, List<String> guilore, List<String> lore, List<String> enchantments, boolean enchanted) {
        List<String> itemLore = new ArrayList<>();

        String customSkull = materialSection.split(":")[0];
        if (customSkull.equals("CUSTOM_SKULL")) {
            String skullId = materialSection.split(":")[1];

            item = new ItemStack(Material.PLAYER_HEAD);
            meta = item.getItemMeta();

            SkullMeta skullMeta = (SkullMeta) item.getItemMeta();
            PlayerProfile profile = skullMeta.getPlayerProfile();
            profile.getProperties().add(new ProfileProperty("textures", skullId));
            Field profileField = null;
            try {
                profileField = skullMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(skullMeta, profile);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                e.printStackTrace();
            }
            item.setItemMeta(skullMeta);

        } else {
            item = new ItemStack(material);
            meta = item.getItemMeta();
            meta.setDisplayName(ZombieArena.color(displayname));
        }
        if (lore != null) {
            for (String strings : lore) {
                itemLore.add(ZombieArena.color(strings));
            }
            meta.setLore(itemLore);
        } else {
            meta.setLore(guilore);
        }
        if (enchantments != null) {
            for (String enchants : enchantments) {
                if (enchants != null) {
                    String enchantname = enchants.split(":")[0];
                    int enchantlvl = Integer.parseInt(enchants.split(":")[1]);
                    meta.addEnchant(Enchantment.getByName(enchantname), enchantlvl, true);
                    item.setItemMeta(meta);
                }
            }
        }
        if (enchanted) {
            meta.addEnchant(Enchantment.OXYGEN, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(meta);

        return item;
    }
}
