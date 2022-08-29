package com.zach.zombiearena.gameplay.guis.barbarianking;

import com.zach.zombiearena.Config;
import com.zach.zombiearena.EconomyHandler;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.gameplay.guis.UpgradeGUIHandler;
import com.zach.zombiearena.utils.Button;
import com.zach.zombiearena.utils.ItemBuilder;
import com.zach.zombiearena.utils.Menu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BarbarianKingArmorUpgradeGUI {
    UpgradeGUIHandler upgradeGUIHandler = new UpgradeGUIHandler();

    Config config = new Config();

    private ConfigurationSection section;

    public Menu BarbarianKingArmorUpgradeGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27, ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.display-name") + ": "
                + config.getBarbarianKingArmorUpgradeGuiDisplayName())));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getBarbarianKingUpgradeArmorGui(keys),
                        config.getBarbarianKingUpgradeArmorGuiMaterialSection(keys));
        }
        menu.setButton(config.getBarbarianKingArmorUpgradeItemStatsPlaceHolderSlot(), new Button(
                ItemBuilder.createItem(
                        config.getBarbarianKingArmorUpgradeItemStatsPlaceHolder(),
                        config.getBarbarianKingArmorUpgradeItemStatsPlaceHolderDisplayName(),
                        ZombieArena.getInstance().barbarianKingGUI.getBarbarianKingArmorStatsLore(player),
                        null,
                        null,
                        config.getBarbarianKingArmorUpgradeItemStatsPlaceHolderEnchanted())) {
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
        if (getPlayersBarbarianKingArmorUpgradeLevel(player) == 0) {
            menu.setButton(config.getBarbarianKingArmorUpgradeLevelOneSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getBarbarianKingArmorUpgradeLevelOneDisplayName(), config
                                    .getBarbarianKingArmorUpgradeLevelOneLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getBarbarianKingArmorUpgradeLevelOneCost())) {
                        upgradeGUIHandler.upgradeSuccessBarbarianKing(player, null, null, 1);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getBarbarianKingArmorUpgradeLevelOneCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingArmorUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingArmorUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingArmorUpgradeLevelFourSlot());
        }
        if (getPlayersBarbarianKingArmorUpgradeLevel(player) == 1) {
            menu.setButton(config.getBarbarianKingArmorUpgradeLevelTwoSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getBarbarianKingArmorUpgradeLevelTwoDisplayName(), config
                                    .getBarbarianKingArmorUpgradeLevelTwoLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getBarbarianKingArmorUpgradeLevelTwoCost())) {
                        upgradeGUIHandler.upgradeSuccessBarbarianKing(player, null, null, 2);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getBarbarianKingArmorUpgradeLevelTwoCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingArmorUpgradeLevelOneSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingArmorUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingArmorUpgradeLevelFourSlot());
        }
        if (getPlayersBarbarianKingArmorUpgradeLevel(player) == 2) {
            menu.setButton(config.getBarbarianKingArmorUpgradeLevelThreeSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getBarbarianKingArmorUpgradeLevelThreeDisplayName(), config
                                    .getBarbarianKingArmorUpgradeLevelThreeLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getBarbarianKingArmorUpgradeLevelThreeCost())) {
                        upgradeGUIHandler.upgradeSuccessBarbarianKing(player, null, null, 3);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getBarbarianKingArmorUpgradeLevelThreeCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingArmorUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingArmorUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingArmorUpgradeLevelFourSlot());
        }
        if (getPlayersBarbarianKingArmorUpgradeLevel(player) == 3) {
            menu.setButton(config.getBarbarianKingArmorUpgradeLevelFourSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getBarbarianKingArmorUpgradeLevelFourDisplayName(), config
                                    .getBarbarianKingArmorUpgradeLevelFourLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getBarbarianKingArmorUpgradeLevelFourCost())) {
                        upgradeGUIHandler.upgradeSuccessBarbarianKing(player, null, null, 4);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getBarbarianKingArmorUpgradeLevelFourCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingArmorUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingArmorUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingArmorUpgradeLevelThreeSlot());
        }
        if (getPlayersBarbarianKingArmorUpgradeLevel(player) == 4) {
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingArmorUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingArmorUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingArmorUpgradeLevelThreeSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingArmorUpgradeLevelFourSlot());
        }
        return menu;
    }

    public Integer getPlayersBarbarianKingArmorUpgradeLevel(Player player) {
        return (ZombieArena.getInstance()).barbarianKing.barbarianKingArmorUpgradeLevel.get(player.getUniqueId());
    }

    public String getPlayersBarbarianKingArmor(Player player) {
        if (getPlayersBarbarianKingArmorUpgradeLevel(player) == 1)
            return config.getBarbarianKingArmorLevelOne();
        if (getPlayersBarbarianKingArmorUpgradeLevel(player) == 2)
            return config.getBarbarianKingArmorLevelTwo();
        if (getPlayersBarbarianKingArmorUpgradeLevel(player) == 3)
            return config.getBarbarianKingArmorLevelThree();
        if (getPlayersBarbarianKingArmorUpgradeLevel(player) == 4)
            return config.getBarbarianKingArmorLevelFour();
        return config.getBarbarianKingArmor();
    }

    public void refreshMenu(Player player) {
        ZombieArena.getMenuHandler().closeMenu(player);
        ZombieArena.getMenuHandler().openMenu(player, BarbarianKingArmorUpgradeGUI(player));
    }
}
