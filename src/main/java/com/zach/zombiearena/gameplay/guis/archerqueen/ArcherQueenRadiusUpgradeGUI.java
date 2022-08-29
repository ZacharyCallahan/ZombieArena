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

public class ArcherQueenRadiusUpgradeGUI {
    UpgradeGUIHandler upgradeGUIHandler = new UpgradeGUIHandler();
    Config config = new Config();
    ConfigurationSection section;
    public Menu ArcherQueenRadiusUpgradeGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27,
                ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.display-name") + ": "
                        + config.getArcherQueenRadiusUpgradeGuiDisplayName())));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getArcherQueenUpgradeRadiusGui(keys),
                        config.getArcherQueenUpgradeRadiusGuiMaterialSection(keys));
        }
        menu.setButton(config.getArcherQueenRadiusUpgradeItemStatsPlaceHolderSlot(), new Button(
                ItemBuilder.createItem(config.getArcherQueenRadiusUpgradeItemStatsPlaceHolder(),
                        config.getArcherQueenRadiusUpgradeItemStatsPlaceHolderDisplayName(),
                        ZombieArena.getInstance().archerQueenGUI.getArcherQueenRadiusStatsLore(player),
                        null,
                        null,
                        config.getArcherQueenRadiusUpgradeItemStatsPlaceHolderEnchanted())) {
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
        createUpgrades(player, menu);
        return menu;
    }
    public Integer getPlayersArcherQueenRadiusUpgradeLevel(Player player) {
        return ZombieArena.getInstance().archerQueen.archerQueenRadiusUpgradeLevel.get(player.getUniqueId());
    }
    public Integer getPlayersArcherQueenRadius(Player player) {
        if (getPlayersArcherQueenRadiusUpgradeLevel(player) == 1) {
            return config.getArcherQueenRadiusUpgradeLevelOneRadius();
        }
        if (getPlayersArcherQueenRadiusUpgradeLevel(player) == 2) {
            return config.getArcherQueenRadiusUpgradeLevelTwoRadius();
        }
        if (getPlayersArcherQueenRadiusUpgradeLevel(player) == 3) {
            return config.getArcherQueenRadiusUpgradeLevelThreeRadius();
        }
        if (getPlayersArcherQueenRadiusUpgradeLevel(player) == 4) {
            return config.getArcherQueenRadiusUpgradeLevelFourRadius();
        }
        return config.getArcherQueenRadius();
    }
    public void refreshMenu(Player player) {
        ZombieArena.getMenuHandler().closeMenu(player);
        ZombieArena.getMenuHandler().openMenu(player, ArcherQueenRadiusUpgradeGUI(player));
    }
    public void createUpgrades(Player player, Menu menu) {
        if (getPlayersArcherQueenRadiusUpgradeLevel(player) == 0) {
            menu.setButton(config.getArcherQueenRadiusUpgradeLevelOneSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getArcherQueenRadiusUpgradeLevelOneDisplayName(),
                            config.getArcherQueenRadiusUpgradeLevelOneLore(),
                            null,
                            null,
                            false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getArcherQueenRadiusUpgradeLevelOneCost())) {
                        upgradeGUIHandler.upgradeSuccessArcherQueen(player, null, 1, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getArcherQueenRadiusUpgradeLevelOneCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenRadiusUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenRadiusUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenRadiusUpgradeLevelFourSlot());
        }
        if (getPlayersArcherQueenRadiusUpgradeLevel(player) == 1) {
            menu.setButton(config.getArcherQueenRadiusUpgradeLevelTwoSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getArcherQueenRadiusUpgradeLevelTwoDisplayName(),
                            config.getArcherQueenRadiusUpgradeLevelTwoLore(),
                            null,
                            null,
                            false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getArcherQueenRadiusUpgradeLevelTwoCost())) {
                        upgradeGUIHandler.upgradeSuccessArcherQueen(player, null, 2, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getArcherQueenRadiusUpgradeLevelTwoCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenRadiusUpgradeLevelOneSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenRadiusUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenRadiusUpgradeLevelFourSlot());
        }
        if (getPlayersArcherQueenRadiusUpgradeLevel(player) == 2) {
            menu.setButton(config.getArcherQueenRadiusUpgradeLevelThreeSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getArcherQueenRadiusUpgradeLevelThreeDisplayName(),
                            config.getArcherQueenRadiusUpgradeLevelThreeLore(),
                            null,
                            null,
                            false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getArcherQueenRadiusUpgradeLevelThreeCost())) {
                        upgradeGUIHandler.upgradeSuccessArcherQueen(player, null, 3, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getArcherQueenRadiusUpgradeLevelThreeCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenRadiusUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenRadiusUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenRadiusUpgradeLevelFourSlot());
        }
        if (getPlayersArcherQueenRadiusUpgradeLevel(player) == 3) {
            menu.setButton(config.getArcherQueenRadiusUpgradeLevelFourSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getArcherQueenRadiusUpgradeLevelFourDisplayName(),
                            config.getArcherQueenRadiusUpgradeLevelFourLore(),
                            null,
                            null,
                            false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getArcherQueenRadiusUpgradeLevelFourCost())) {
                        upgradeGUIHandler.upgradeSuccessArcherQueen(player, null, 4, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getArcherQueenRadiusUpgradeLevelFourCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenRadiusUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenRadiusUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenRadiusUpgradeLevelThreeSlot());
        }
        if (getPlayersArcherQueenRadiusUpgradeLevel(player) == 4) {
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenRadiusUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenRadiusUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenRadiusUpgradeLevelThreeSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenRadiusUpgradeLevelFourSlot());
        }
    }
}
