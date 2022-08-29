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

public class BarbarianKingRadiusUpgradeGUI {
    UpgradeGUIHandler upgradeGUIHandler = new UpgradeGUIHandler();
    Config config = new Config();
    ConfigurationSection section;

    public Menu BarbarianKingRadiusUpgradeGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27,
                ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.display-name") + ": "
                        + config.getBarbarianKingRadiusUpgradeGuiDisplayName())));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getBarbarianKingUpgradeRadiusGui(keys),
                        config.getBarbarianKingUpgradeRadiusGuiMaterialSection(keys));
        }
        menu.setButton(config.getBarbarianKingRadiusUpgradeItemStatsPlaceHolderSlot(), new Button(
                ItemBuilder.createItem(config.getBarbarianKingRadiusUpgradeItemStatsPlaceHolder(),
                        config.getBarbarianKingRadiusUpgradeItemStatsPlaceHolderDisplayName(),
                        ZombieArena.getInstance().barbarianKingGUI.getBarbarianKingRadiusStatsLore(player),
                        null,
                        null,
                        config.getBarbarianKingRadiusUpgradeItemStatsPlaceHolderEnchanted())) {
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
        createUpgrades(player, menu);
        return menu;
    }

    public Integer getPlayersBarbarianKingRadiusUpgradeLevel(Player player) {
        return ZombieArena.getInstance().barbarianKing.barbarianKingRadiusUpgradeLevel.get(player.getUniqueId());
    }

    public Integer getPlayersBarbarianKingRadius(Player player) {
        if (getPlayersBarbarianKingRadiusUpgradeLevel(player) == 1) {
            return config.getBarbarianKingRadiusUpgradeLevelOneRadius();
        }
        if (getPlayersBarbarianKingRadiusUpgradeLevel(player) == 2) {
            return config.getBarbarianKingRadiusUpgradeLevelTwoRadius();
        }
        if (getPlayersBarbarianKingRadiusUpgradeLevel(player) == 3) {
            return config.getBarbarianKingRadiusUpgradeLevelThreeRadius();
        }
        if (getPlayersBarbarianKingRadiusUpgradeLevel(player) == 4) {
            return config.getBarbarianKingRadiusUpgradeLevelFourRadius();
        }
        return config.getBarbarianKingRadius();
    }

    public void refreshMenu(Player player) {
        ZombieArena.getMenuHandler().closeMenu(player);
        ZombieArena.getMenuHandler().openMenu(player, BarbarianKingRadiusUpgradeGUI(player));
    }

    public void createUpgrades(Player player, Menu menu) {
        if (getPlayersBarbarianKingRadiusUpgradeLevel(player) == 0) {
            menu.setButton(config.getBarbarianKingRadiusUpgradeLevelOneSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getBarbarianKingRadiusUpgradeLevelOneDisplayName(),
                            config.getBarbarianKingRadiusUpgradeLevelOneLore(),
                            null,
                            null,
                            false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getBarbarianKingRadiusUpgradeLevelOneCost())) {
                        upgradeGUIHandler.upgradeSuccessBarbarianKing(player, null, 1, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getBarbarianKingRadiusUpgradeLevelOneCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingRadiusUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingRadiusUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingRadiusUpgradeLevelFourSlot());
        }
        if (getPlayersBarbarianKingRadiusUpgradeLevel(player) == 1) {
            menu.setButton(config.getBarbarianKingRadiusUpgradeLevelTwoSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getBarbarianKingRadiusUpgradeLevelTwoDisplayName(),
                            config.getBarbarianKingRadiusUpgradeLevelTwoLore(),
                            null,
                            null,
                            false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getBarbarianKingRadiusUpgradeLevelTwoCost())) {
                        upgradeGUIHandler.upgradeSuccessBarbarianKing(player, null, 2, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getBarbarianKingRadiusUpgradeLevelTwoCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingRadiusUpgradeLevelOneSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingRadiusUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingRadiusUpgradeLevelFourSlot());
        }
        if (getPlayersBarbarianKingRadiusUpgradeLevel(player) == 2) {
            menu.setButton(config.getBarbarianKingRadiusUpgradeLevelThreeSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getBarbarianKingRadiusUpgradeLevelThreeDisplayName(),
                            config.getBarbarianKingRadiusUpgradeLevelThreeLore(),
                            null,
                            null,
                            false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getBarbarianKingRadiusUpgradeLevelThreeCost())) {
                        upgradeGUIHandler.upgradeSuccessBarbarianKing(player, null, 3, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getBarbarianKingRadiusUpgradeLevelThreeCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingRadiusUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingRadiusUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingRadiusUpgradeLevelFourSlot());
        }
        if (getPlayersBarbarianKingRadiusUpgradeLevel(player) == 3) {
            menu.setButton(config.getBarbarianKingRadiusUpgradeLevelFourSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getBarbarianKingRadiusUpgradeLevelFourDisplayName(),
                            config.getBarbarianKingRadiusUpgradeLevelFourLore(),
                            null,
                            null,
                            false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getBarbarianKingRadiusUpgradeLevelFourCost())) {
                        upgradeGUIHandler.upgradeSuccessBarbarianKing(player, null, 4, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getBarbarianKingRadiusUpgradeLevelFourCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingRadiusUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingRadiusUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingRadiusUpgradeLevelThreeSlot());
        }
        if (getPlayersBarbarianKingRadiusUpgradeLevel(player) == 4) {
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingRadiusUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingRadiusUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingRadiusUpgradeLevelThreeSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingRadiusUpgradeLevelFourSlot());
        }
    }
}
