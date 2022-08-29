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

public class BarbarianKingHealthUpgradeGUI {
    UpgradeGUIHandler upgradeGUIHandler = new UpgradeGUIHandler();

    Config config = new Config();

    private ConfigurationSection section;

    public Menu BarbarianKingHealthUpgradeGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27, ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.display-name") + ": "
                + config.getBarbarianKingHealthUpgradeGuiDisplayName())));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getBarbarianKingUpgradeHealthGui(keys),
                        config.getBarbarianKingUpgradeHealthGuiMaterialSection(keys));
        }
        menu.setButton(config.getBarbarianKingHealthUpgradeItemStatsPlaceHolderSlot(), new Button(
                ItemBuilder.createItem(
                        config.getBarbarianKingHealthUpgradeItemStatsPlaceHolder(),
                        config.getBarbarianKingHealthUpgradeItemStatsPlaceHolderDisplayName(),
                        ZombieArena.getInstance().barbarianKingGUI.getBarbarianKingHealthStatsLore(player),
                        null,
                        null,
                        config.getBarbarianKingHealthUpgradeItemStatsPlaceHolderEnchanted())) {
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
        if (getPlayersBarbarianKingHealthUpgradeLevel(player) == 0) {
            menu.setButton(config.getBarbarianKingHealthUpgradeLevelOneSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getBarbarianKingHealthUpgradeLevelOneDisplayName(), config
                                    .getBarbarianKingHealthUpgradeLevelOneLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getBarbarianKinghealthUpgradeLevelOneCost())) {
                        upgradeGUIHandler.upgradeSuccessBarbarianKing(player, 1, null, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getBarbarianKinghealthUpgradeLevelOneCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingHealthUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingHealthUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingHealthUpgradeLevelFourSlot());
        }
        if (getPlayersBarbarianKingHealthUpgradeLevel(player) == 1) {
            menu.setButton(config.getBarbarianKingHealthUpgradeLevelTwoSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getBarbarianKingHealthUpgradeLevelTwoDisplayName(), config
                                    .getBarbarianKingHealthUpgradeLevelTwoLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getBarbarianKinghealthUpgradeLevelTwoCost())) {
                        upgradeGUIHandler.upgradeSuccessBarbarianKing(player, 2, null, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getBarbarianKinghealthUpgradeLevelTwoCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingHealthUpgradeLevelOneSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingHealthUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingHealthUpgradeLevelFourSlot());
        }
        if (getPlayersBarbarianKingHealthUpgradeLevel(player) == 2) {
            menu.setButton(config.getBarbarianKingHealthUpgradeLevelThreeSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getBarbarianKingHealthUpgradeLevelThreeDisplayName(), config
                                    .getBarbarianKingHealthUpgradeLevelThreeLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getBarbarianKinghealthUpgradeLevelThreeCost())) {
                        upgradeGUIHandler.upgradeSuccessBarbarianKing(player, 3, null, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getBarbarianKinghealthUpgradeLevelThreeCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingHealthUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingHealthUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getBarbarianKingHealthUpgradeLevelFourSlot());
        }
        if (getPlayersBarbarianKingHealthUpgradeLevel(player) == 3) {
            menu.setButton(config.getBarbarianKingHealthUpgradeLevelFourSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getBarbarianKingHealthUpgradeLevelFourDisplayName(), config
                                    .getBarbarianKingHealthUpgradeLevelFourLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getBarbarianKinghealthUpgradeLevelFourCost())) {
                        upgradeGUIHandler.upgradeSuccessBarbarianKing(player, 4, null, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getBarbarianKinghealthUpgradeLevelFourCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingHealthUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingHealthUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingHealthUpgradeLevelThreeSlot());
        }
        if (getPlayersBarbarianKingHealthUpgradeLevel(player) == 4) {
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingHealthUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingHealthUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingHealthUpgradeLevelThreeSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getBarbarianKingHealthUpgradeLevelFourSlot());
        }
        return menu;
    }

    public Integer getPlayersBarbarianKingHealthUpgradeLevel(Player player) {
        return (ZombieArena.getInstance()).barbarianKing.barbarianKingHealthUpgradeLevel.get(player.getUniqueId());
    }

    public Integer getPlayersBarbarianKingHealth(Player player) {
        if (getPlayersBarbarianKingHealthUpgradeLevel(player) == 1)
            return config.getBarbarianKingHealthLevelOne();
        if (getPlayersBarbarianKingHealthUpgradeLevel(player) == 2)
            return config.getBarbarianKingHealthLevelTwo();
        if (getPlayersBarbarianKingHealthUpgradeLevel(player) == 3)
            return config.getBarbarianKingHealthLevelThree();
        if (getPlayersBarbarianKingHealthUpgradeLevel(player) == 4)
            return config.getBarbarianKingHealthLevelFour();
        return config.getBarbarianKingDefaultHealth();
    }

    public void refreshMenu(Player player) {
        ZombieArena.getMenuHandler().closeMenu(player);
        ZombieArena.getMenuHandler().openMenu(player, BarbarianKingHealthUpgradeGUI(player));
    }
}
