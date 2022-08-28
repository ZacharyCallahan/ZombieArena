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

public class ArcherQueenHealthUpgradeGUI {
    UpgradeGUIHandler upgradeGUIHandler = new UpgradeGUIHandler();

    Config config = new Config();

    private ConfigurationSection section;

    public Menu ArcherQueenHealthUpgradeGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27, ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.display-name") + ": "
                + config.getArcherQueenHealthUpgradeGuiDisplayName())));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getArcherQueenUpgradeHealthGui(keys),
                        config.getArcherQueenUpgradeHealthGuiMaterialSection(keys));
        }
        menu.setButton(config.getArcherQueenHealthUpgradeItemStatsPlaceHolderSlot(), new Button(
                ItemBuilder.createItem(
                        config.getArcherQueenHealthUpgradeItemStatsPlaceHolder(),
                        config.getArcherQueenHealthUpgradeItemStatsPlaceHolderDisplayName(),
                        ZombieArena.getInstance().archerQueenGUI.getArcherQueenHealthStatsLore(player),
                        null,
                        null,
                        config.getArcherQueenHealthUpgradeItemStatsPlaceHolderEnchanted())) {
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 0) {
            menu.setButton(config.getArcherQueenHealthUpgradeLevelOneSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getArcherQueenHealthUpgradeLevelOneDisplayName(), config
                                    .getArcherQueenHealthUpgradeLevelOneLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getArcherQueenhealthUpgradeLevelOneCost())) {
                        upgradeGUIHandler.upgradeSuccess(player, 1, null, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getArcherQueenhealthUpgradeLevelOneCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenHealthUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenHealthUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenHealthUpgradeLevelFourSlot());
        }
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 1) {
            menu.setButton(config.getArcherQueenHealthUpgradeLevelTwoSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getArcherQueenHealthUpgradeLevelTwoDisplayName(), config
                                    .getArcherQueenHealthUpgradeLevelTwoLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getArcherQueenhealthUpgradeLevelTwoCost())) {
                        upgradeGUIHandler.upgradeSuccess(player, 2, null, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getArcherQueenhealthUpgradeLevelTwoCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelOneSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenHealthUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenHealthUpgradeLevelFourSlot());
        }
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 2) {
            menu.setButton(config.getArcherQueenHealthUpgradeLevelThreeSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getArcherQueenHealthUpgradeLevelThreeDisplayName(), config
                                    .getArcherQueenHealthUpgradeLevelThreeLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getArcherQueenhealthUpgradeLevelThreeCost())) {
                        upgradeGUIHandler.upgradeSuccess(player, 3, null, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getArcherQueenhealthUpgradeLevelThreeCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenHealthUpgradeLevelFourSlot());
        }
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 3) {
            menu.setButton(config.getArcherQueenHealthUpgradeLevelFourSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getArcherQueenHealthUpgradeLevelFourDisplayName(), config
                                    .getArcherQueenHealthUpgradeLevelFourLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getArcherQueenhealthUpgradeLevelFourCost())) {
                        upgradeGUIHandler.upgradeSuccess(player, 4, null, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getArcherQueenhealthUpgradeLevelFourCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelThreeSlot());
        }
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 4) {
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelThreeSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelFourSlot());
        }
        return menu;
    }

    public Integer getPlayersArcherQueenHealthUpgradeLevel(Player player) {
        return (ZombieArena.getInstance()).archerQueen.archerQueenHealthUpgradeLevel.get(player.getUniqueId());
    }

    public Integer getPlayersArcherQueenHealth(Player player) {
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 1)
            return config.getArcherQueenHealthLevelOne();
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 2)
            return config.getArcherQueenHealthLevelTwo();
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 3)
            return config.getArcherQueenHealthLevelThree();
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 4)
            return config.getArcherQueenHealthLevelFour();
        return config.getArcherQueenDefaultHealth();
    }

    public void refreshMenu(Player player) {
        ZombieArena.getMenuHandler().closeMenu(player);
        ZombieArena.getMenuHandler().openMenu(player, ArcherQueenHealthUpgradeGUI(player));
    }

}
