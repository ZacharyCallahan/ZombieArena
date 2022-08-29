package com.zach.zombiearena.gameplay.guis.healerqueen;

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

public class HealerQueenRadiusUpgradeGUI {
    UpgradeGUIHandler upgradeGUIHandler = new UpgradeGUIHandler();
    Config config = new Config();
    ConfigurationSection section;

    public Menu HealerQueenRadiusUpgradeGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27,
                ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.display-name") + ": "
                        + config.getHealerQueenRadiusUpgradeGuiDisplayName())));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getHealerQueenUpgradeRadiusGui(keys),
                        config.getHealerQueenUpgradeRadiusGuiMaterialSection(keys));
        }
        menu.setButton(config.getHealerQueenRadiusUpgradeItemStatsPlaceHolderSlot(), new Button(
                ItemBuilder.createItem(config.getHealerQueenRadiusUpgradeItemStatsPlaceHolder(),
                        config.getHealerQueenRadiusUpgradeItemStatsPlaceHolderDisplayName(),
                        ZombieArena.getInstance().healerQueenGUI.getHealerQueenRadiusStatsLore(player),
                        null,
                        null,
                        config.getHealerQueenRadiusUpgradeItemStatsPlaceHolderEnchanted())) {
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
        createUpgrades(player, menu);
        return menu;
    }

    public Integer getPlayersHealerQueenRadiusUpgradeLevel(Player player) {
        return ZombieArena.getInstance().healerQueen.healerQueenRadiusUpgradeLevel.get(player.getUniqueId());
    }

    public Integer getPlayersHealerQueenRadius(Player player) {
        if (getPlayersHealerQueenRadiusUpgradeLevel(player) == 1) {
            return config.getHealerQueenRadiusUpgradeLevelOneRadius();
        }
        if (getPlayersHealerQueenRadiusUpgradeLevel(player) == 2) {
            return config.getHealerQueenRadiusUpgradeLevelTwoRadius();
        }
        if (getPlayersHealerQueenRadiusUpgradeLevel(player) == 3) {
            return config.getHealerQueenRadiusUpgradeLevelThreeRadius();
        }
        if (getPlayersHealerQueenRadiusUpgradeLevel(player) == 4) {
            return config.getHealerQueenRadiusUpgradeLevelFourRadius();
        }
        return config.getHealerQueenRadius();
    }

    public void refreshMenu(Player player) {
        ZombieArena.getMenuHandler().closeMenu(player);
        ZombieArena.getMenuHandler().openMenu(player, HealerQueenRadiusUpgradeGUI(player));
    }

    public void createUpgrades(Player player, Menu menu) {
        if (getPlayersHealerQueenRadiusUpgradeLevel(player) == 0) {
            menu.setButton(config.getHealerQueenRadiusUpgradeLevelOneSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getHealerQueenRadiusUpgradeLevelOneDisplayName(),
                            config.getHealerQueenRadiusUpgradeLevelOneLore(),
                            null,
                            null,
                            false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getHealerQueenRadiusUpgradeLevelOneCost())) {
                        upgradeGUIHandler.upgradeSuccessHealerQueen(player, null, 1, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getHealerQueenRadiusUpgradeLevelOneCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenRadiusUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenRadiusUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenRadiusUpgradeLevelFourSlot());
        }
        if (getPlayersHealerQueenRadiusUpgradeLevel(player) == 1) {
            menu.setButton(config.getHealerQueenRadiusUpgradeLevelTwoSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getHealerQueenRadiusUpgradeLevelTwoDisplayName(),
                            config.getHealerQueenRadiusUpgradeLevelTwoLore(),
                            null,
                            null,
                            false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getHealerQueenRadiusUpgradeLevelTwoCost())) {
                        upgradeGUIHandler.upgradeSuccessHealerQueen(player, null, 2, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getHealerQueenRadiusUpgradeLevelTwoCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenRadiusUpgradeLevelOneSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenRadiusUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenRadiusUpgradeLevelFourSlot());
        }
        if (getPlayersHealerQueenRadiusUpgradeLevel(player) == 2) {
            menu.setButton(config.getHealerQueenRadiusUpgradeLevelThreeSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getHealerQueenRadiusUpgradeLevelThreeDisplayName(),
                            config.getHealerQueenRadiusUpgradeLevelThreeLore(),
                            null,
                            null,
                            false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getHealerQueenRadiusUpgradeLevelThreeCost())) {
                        upgradeGUIHandler.upgradeSuccessHealerQueen(player, null, 3, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getHealerQueenRadiusUpgradeLevelThreeCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenRadiusUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenRadiusUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenRadiusUpgradeLevelFourSlot());
        }
        if (getPlayersHealerQueenRadiusUpgradeLevel(player) == 3) {
            menu.setButton(config.getHealerQueenRadiusUpgradeLevelFourSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getHealerQueenRadiusUpgradeLevelFourDisplayName(),
                            config.getHealerQueenRadiusUpgradeLevelFourLore(),
                            null,
                            null,
                            false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getHealerQueenRadiusUpgradeLevelFourCost())) {
                        upgradeGUIHandler.upgradeSuccessHealerQueen(player, null, 4, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getHealerQueenRadiusUpgradeLevelFourCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenRadiusUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenRadiusUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenRadiusUpgradeLevelThreeSlot());
        }
        if (getPlayersHealerQueenRadiusUpgradeLevel(player) == 4) {
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenRadiusUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenRadiusUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenRadiusUpgradeLevelThreeSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenRadiusUpgradeLevelFourSlot());
        }
    }
}
