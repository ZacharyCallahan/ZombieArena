package com.zach.zombiearena.utils;

import com.zach.zombiearena.ZombieArena;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemManager {
    public static ItemStack moneyItem;
    public static ItemStack starterBow;

    public static ItemStack upgradePurchased;

    public static ItemStack upgradeUnavailable;

    public ItemManager() {
        moneyItem = ItemBuilder.createItem(Material.valueOf(ZombieArena.getInstance().getConfig().getString("tradergui.money-item.material")),
                ZombieArena.color(ZombieArena.getInstance().getConfig().getString("tradergui.money-item.display-name")),
                null,
                ZombieArena.getInstance().getConfig().getStringList("tradergui.money-item.lore"),
                null,
                ZombieArena.getInstance().getConfig().getBoolean("tradergui.money-item.enchanted"));


        starterBow = ItemBuilder.createItem(Material.valueOf(ZombieArena.getInstance().getConfig().getString("starter-item.material")),
                ZombieArena.getInstance().getConfig().getString("starter-item.display-name"),
                null,
                ZombieArena.getInstance().getConfig().getStringList("starter-item.lore"),
                ZombieArena.getInstance().getConfig().getStringList("starter-item.enchants"),
                false);


        upgradePurchased = ItemBuilder.createItem(ZombieArena.getInstance().config.getPurchasedUpgradeItemMaterial(),
                ZombieArena.getInstance().config.getPurchasedUpgradeItemDisplayName(),
                ZombieArena.getInstance().config.getPurchasedUpgradeItemLore(),
                null,
                null,
                ZombieArena.getInstance().config.getPurchasedUpgradeItemEnchanted());


        upgradeUnavailable = ItemBuilder.createItem(ZombieArena.getInstance().config.getUpgradeUnavailableItemMaterial(),
                ZombieArena.getInstance().config.getUpgradeUnavailableItemDisplayName(),
                ZombieArena.getInstance().config.getUpgradeUnavailableItemLore(),
                null,
                null,
                ZombieArena.getInstance().config.getUpgradeUnavailableItemEnchanted());
    }

    public static Material getMoneyItemMaterial() {

        return moneyItem.getType();
    }
}
