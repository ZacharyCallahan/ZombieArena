package com.zach.zombiearena.gameplay.guis.archerqueen;

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

public class ArcherQueenSpeedUpgradeGUI {
    UpgradeGUIHandler upgradeGUIHandler = new UpgradeGUIHandler();
    ConfigurationSection section;
    Config config = new Config();

    public Menu ArcherQueenSpeedUpgradeGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27,
                ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.display-name") + ": "
                        + config.getArcherQueenSpeedUpgradeGuiDisplayName())));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getArcherQueenUpgradeSpeedGui(keys),
                        config.getArcherQueenUpgradeSpeedGuiMaterialSection(keys));
        }
        menu.setButton(config.getArcherQueenSpeedUpgradeItemStatsPlaceHolderSlot(), new Button(
                ItemBuilder.createItem(config.getArcherQueenSpeedUpgradeItemStatsPlaceHolder(),
                        config.getArcherQueenSpeedUpgradeItemStatsPlaceHolderDisplayName(),
                        ZombieArena.getInstance().archerQueenGUI.getArcherQueenSpeedStatsLore(player),
                        null,
                        null,
                        config.getArcherQueenSpeedUpgradeItemStatsPlaceHolderEnchanted())) {
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
        createUpgrades(player, menu);
        return menu;
    }

    public Integer getPlayersArcherQueenSpeedUpgradeLevel(Player player) {
        return ZombieArena.getInstance().archerQueen.archerQueenSpeedUpgradeLevel.get(player.getUniqueId());
    }

    public double getPlayersArcherQueenSpeed(Player player) {
        if (getPlayersArcherQueenSpeedUpgradeLevel(player) == 1) {
            return config.getArcherQueenSpeedUpgradeLevelOneSpeed();
        }
        if (getPlayersArcherQueenSpeedUpgradeLevel(player) == 2) {
            return config.getArcherQueenSpeedUpgradeLevelTwoSpeed();
        }
        if (getPlayersArcherQueenSpeedUpgradeLevel(player) == 3) {
            return config.getArcherQueenSpeedUpgradeLevelThreeSpeed();
        }
        if (getPlayersArcherQueenSpeedUpgradeLevel(player) == 4) {
            return config.getArcherQueenSpeedUpgradeLevelFourSpeed();
        }
        return config.getArcherQueenSpeed();
    }

    public void refreshMenu(Player player) {
        ZombieArena.getMenuHandler().closeMenu(player);
        ZombieArena.getMenuHandler().openMenu(player, ArcherQueenSpeedUpgradeGUI(player));
    }

    public void createUpgrades(Player player, Menu menu) {
        if (getPlayersArcherQueenSpeedUpgradeLevel(player) == 0) {
            menu.setButton(config.getArcherQueenSpeedUpgradeLevelOneSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getArcherQueenSpeedUpgradeLevelOneDisplayName(),
                            config.getArcherQueenSpeedUpgradeLevelOneLore(),
                            null,
                            null,
                            false)) {
                @Override
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getArcherQueenSpeedUpgradeLevelOneCost())) {
                        upgradeGUIHandler.upgradeSuccessArcherQueen(player.getPlayer(), null, null, 1);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getArcherQueenSpeedUpgradeLevelOneCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenSpeedUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenSpeedUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenSpeedUpgradeLevelFourSlot());
        }
        if (getPlayersArcherQueenSpeedUpgradeLevel(player) == 1) {
            menu.setButton(config.getArcherQueenSpeedUpgradeLevelTwoSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getArcherQueenSpeedUpgradeLevelTwoDisplayName(),
                            config.getArcherQueenSpeedUpgradeLevelTwoLore(),
                            null,
                            null,
                            false)) {
                @Override
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getArcherQueenSpeedUpgradeLevelTwoCost())) {
                        upgradeGUIHandler.upgradeSuccessArcherQueen(player.getPlayer(), null, null, 2);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getArcherQueenSpeedUpgradeLevelTwoCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenSpeedUpgradeLevelOneSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenSpeedUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenSpeedUpgradeLevelFourSlot());
        }
        if (getPlayersArcherQueenSpeedUpgradeLevel(player) == 2) {
            menu.setButton(config.getArcherQueenSpeedUpgradeLevelThreeSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getArcherQueenSpeedUpgradeLevelThreeDisplayName(),
                            config.getArcherQueenSpeedUpgradeLevelThreeLore(),
                            null,
                            null,
                            false)) {
                @Override
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getArcherQueenSpeedUpgradeLevelThreeCost())) {
                        upgradeGUIHandler.upgradeSuccessArcherQueen(player.getPlayer(), null, null, 3);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getArcherQueenSpeedUpgradeLevelThreeCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenSpeedUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenSpeedUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenSpeedUpgradeLevelFourSlot());
        }
        if (getPlayersArcherQueenSpeedUpgradeLevel(player) == 3) {
            menu.setButton(config.getArcherQueenSpeedUpgradeLevelFourSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getArcherQueenSpeedUpgradeLevelFourDisplayName(),
                            config.getArcherQueenSpeedUpgradeLevelFourLore(),
                            null,
                            null,
                            false)) {
                @Override
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getArcherQueenSpeedUpgradeLevelFourCost())) {
                        upgradeGUIHandler.upgradeSuccessArcherQueen(player.getPlayer(), null, null, 4);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getArcherQueenSpeedUpgradeLevelFourCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenSpeedUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenSpeedUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenSpeedUpgradeLevelThreeSlot());
        }
        if (getPlayersArcherQueenSpeedUpgradeLevel(player) == 4) {
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenSpeedUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenSpeedUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenSpeedUpgradeLevelThreeSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenSpeedUpgradeLevelFourSlot());
        }
    }
}
