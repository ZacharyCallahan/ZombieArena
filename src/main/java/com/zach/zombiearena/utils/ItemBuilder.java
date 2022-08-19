package com.zach.zombiearena.utils;

import com.zach.zombiearena.ZombieArena;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    public static ItemStack createItem(Material material, String displayname, List<String> guilore, List<String> lore, List<String> enchantments, boolean enchanted) {
        List<String> itemLore = new ArrayList<>();
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ZombieArena.color(displayname));
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
