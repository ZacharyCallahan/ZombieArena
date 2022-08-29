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

public class HealerQueenHealUpgradeGUI {
    UpgradeGUIHandler upgradeGUIHandler = new UpgradeGUIHandler();
    ConfigurationSection section;
    Config config = new Config();

    public Menu HealerQueenHealUpgradeGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27,
                ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.display-name") + ": "
                        + config.getHealerQueenHealUpgradeGuiDisplayName())));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getHealerQueenUpgradeHealGui(keys),
                        config.getHealerQueenUpgradeHealGuiMaterialSection(keys));
        }
        menu.setButton(config.getHealerQueenHealUpgradeItemStatsPlaceHolderSlot(), new Button(
                ItemBuilder.createItem(config.getHealerQueenHealUpgradeItemStatsPlaceHolder(),
                        config.getHealerQueenHealUpgradeItemStatsPlaceHolderDisplayName(),
                        ZombieArena.getInstance().healerQueenGUI.getHealerQueenHealStatsLore(player),
                        null,
                        null,
                        config.getHealerQueenHealUpgradeItemStatsPlaceHolderEnchanted())) {
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
        createUpgrades(player, menu);
        return menu;
    }

    public Integer getPlayersHealerQueenHealUpgradeLevel(Player player) {
        return ZombieArena.getInstance().healerQueen.healerQueenHealUpgradeLevel.get(player.getUniqueId());
    }

    public double getPlayersHealerQueenHeal(Player player) {
        if (getPlayersHealerQueenHealUpgradeLevel(player) == 1) {
            return config.getHealerQueenHealUpgradeLevelOneHeal();
        }
        if (getPlayersHealerQueenHealUpgradeLevel(player) == 2) {
            return config.getHealerQueenHealUpgradeLevelTwoHeal();
        }
        if (getPlayersHealerQueenHealUpgradeLevel(player) == 3) {
            return config.getHealerQueenHealUpgradeLevelThreeHeal();
        }
        if (getPlayersHealerQueenHealUpgradeLevel(player) == 4) {
            return config.getHealerQueenHealUpgradeLevelFourHeal();
        }
        player.hasPermission("zombiearena.healer-queen.heal-upgrade.1");
        return config.getHealerQueenHeal();

    }


    public void refreshMenu(Player player) {
        ZombieArena.getMenuHandler().closeMenu(player);
        ZombieArena.getMenuHandler().openMenu(player, HealerQueenHealUpgradeGUI(player));
    }

    public void createUpgrades(Player player, Menu menu) {
        if (getPlayersHealerQueenHealUpgradeLevel(player) == 0) {
            menu.setButton(config.getHealerQueenHealUpgradeLevelOneSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getHealerQueenHealUpgradeLevelOneDisplayName(),
                            config.getHealerQueenHealUpgradeLevelOneLore(),
                            null,
                            null,
                            false)) {
                @Override
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getHealerQueenHealUpgradeLevelOneCost())) {
                        upgradeGUIHandler.upgradeSuccessHealerQueen(player.getPlayer(), null, null, 1);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getHealerQueenHealUpgradeLevelOneCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenHealUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenHealUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenHealUpgradeLevelFourSlot());
        }
        if (getPlayersHealerQueenHealUpgradeLevel(player) == 1) {
            menu.setButton(config.getHealerQueenHealUpgradeLevelTwoSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getHealerQueenHealUpgradeLevelTwoDisplayName(),
                            config.getHealerQueenHealUpgradeLevelTwoLore(),
                            null,
                            null,
                            false)) {
                @Override
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getHealerQueenHealUpgradeLevelTwoCost())) {
                        upgradeGUIHandler.upgradeSuccessHealerQueen(player.getPlayer(), null, null, 2);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getHealerQueenHealUpgradeLevelTwoCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealUpgradeLevelOneSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenHealUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenHealUpgradeLevelFourSlot());
        }
        if (getPlayersHealerQueenHealUpgradeLevel(player) == 2) {
            menu.setButton(config.getHealerQueenHealUpgradeLevelThreeSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getHealerQueenHealUpgradeLevelThreeDisplayName(),
                            config.getHealerQueenHealUpgradeLevelThreeLore(),
                            null,
                            null,
                            false)) {
                @Override
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getHealerQueenHealUpgradeLevelThreeCost())) {
                        upgradeGUIHandler.upgradeSuccessHealerQueen(player.getPlayer(), null, null, 3);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getHealerQueenHealUpgradeLevelThreeCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenHealUpgradeLevelFourSlot());
        }
        if (getPlayersHealerQueenHealUpgradeLevel(player) == 3) {
            menu.setButton(config.getHealerQueenHealUpgradeLevelFourSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                            config.getHealerQueenHealUpgradeLevelFourDisplayName(),
                            config.getHealerQueenHealUpgradeLevelFourLore(),
                            null,
                            null,
                            false)) {
                @Override
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getHealerQueenHealUpgradeLevelFourCost())) {
                        upgradeGUIHandler.upgradeSuccessHealerQueen(player.getPlayer(), null, null, 4);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getHealerQueenHealUpgradeLevelFourCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealUpgradeLevelThreeSlot());
        }
        if (getPlayersHealerQueenHealUpgradeLevel(player) == 4) {
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealUpgradeLevelThreeSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealUpgradeLevelFourSlot());
        }
    }
}
