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

public class HealerQueenHealthUpgradeGUI {
    UpgradeGUIHandler upgradeGUIHandler = new UpgradeGUIHandler();

    Config config = new Config();

    private ConfigurationSection section;

    public Menu HealerQueenHealthUpgradeGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27, ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.display-name") + ": "
                + config.getHealerQueenHealthUpgradeGuiDisplayName())));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getHealerQueenUpgradeHealthGui(keys),
                        config.getHealerQueenUpgradeHealthGuiMaterialSection(keys));
        }
        menu.setButton(config.getHealerQueenHealthUpgradeItemStatsPlaceHolderSlot(), new Button(
                ItemBuilder.createItem(
                        config.getHealerQueenHealthUpgradeItemStatsPlaceHolder(),
                        config.getHealerQueenHealthUpgradeItemStatsPlaceHolderDisplayName(),
                        ZombieArena.getInstance().healerQueenGUI.getHealerQueenHealthStatsLore(player),
                        null,
                        null,
                        config.getHealerQueenHealthUpgradeItemStatsPlaceHolderEnchanted())) {
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
        if (getPlayersHealerQueenHealthUpgradeLevel(player) == 0) {
            menu.setButton(config.getHealerQueenHealthUpgradeLevelOneSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getHealerQueenHealthUpgradeLevelOneDisplayName(), config
                                    .getHealerQueenHealthUpgradeLevelOneLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getHealerQueenhealthUpgradeLevelOneCost())) {
                        upgradeGUIHandler.upgradeSuccessHealerQueen(player, 1, null, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getHealerQueenhealthUpgradeLevelOneCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenHealthUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenHealthUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenHealthUpgradeLevelFourSlot());
        }
        if (getPlayersHealerQueenHealthUpgradeLevel(player) == 1) {
            menu.setButton(config.getHealerQueenHealthUpgradeLevelTwoSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getHealerQueenHealthUpgradeLevelTwoDisplayName(), config
                                    .getHealerQueenHealthUpgradeLevelTwoLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getHealerQueenhealthUpgradeLevelTwoCost())) {
                        upgradeGUIHandler.upgradeSuccessHealerQueen(player, 2, null, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getHealerQueenhealthUpgradeLevelTwoCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealthUpgradeLevelOneSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenHealthUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenHealthUpgradeLevelFourSlot());
        }
        if (getPlayersHealerQueenHealthUpgradeLevel(player) == 2) {
            menu.setButton(config.getHealerQueenHealthUpgradeLevelThreeSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getHealerQueenHealthUpgradeLevelThreeDisplayName(), config
                                    .getHealerQueenHealthUpgradeLevelThreeLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getHealerQueenhealthUpgradeLevelThreeCost())) {
                        upgradeGUIHandler.upgradeSuccessHealerQueen(player, 3, null, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getHealerQueenhealthUpgradeLevelThreeCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealthUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealthUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getHealerQueenHealthUpgradeLevelFourSlot());
        }
        if (getPlayersHealerQueenHealthUpgradeLevel(player) == 3) {
            menu.setButton(config.getHealerQueenHealthUpgradeLevelFourSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getHealerQueenHealthUpgradeLevelFourDisplayName(), config
                                    .getHealerQueenHealthUpgradeLevelFourLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getHealerQueenhealthUpgradeLevelFourCost())) {
                        upgradeGUIHandler.upgradeSuccessHealerQueen(player, 4, null, null);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getHealerQueenhealthUpgradeLevelFourCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealthUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealthUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealthUpgradeLevelThreeSlot());
        }
        if (getPlayersHealerQueenHealthUpgradeLevel(player) == 4) {
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealthUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealthUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealthUpgradeLevelThreeSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getHealerQueenHealthUpgradeLevelFourSlot());
        }
        return menu;
    }

    public Integer getPlayersHealerQueenHealthUpgradeLevel(Player player) {
        return (ZombieArena.getInstance()).healerQueen.healerQueenHealthUpgradeLevel.get(player.getUniqueId());
    }

    public Integer getPlayersHealerQueenHealth(Player player) {
        if (getPlayersHealerQueenHealthUpgradeLevel(player) == 1)
            return config.getHealerQueenHealthLevelOne();
        if (getPlayersHealerQueenHealthUpgradeLevel(player) == 2)
            return config.getHealerQueenHealthLevelTwo();
        if (getPlayersHealerQueenHealthUpgradeLevel(player) == 3)
            return config.getHealerQueenHealthLevelThree();
        if (getPlayersHealerQueenHealthUpgradeLevel(player) == 4)
            return config.getHealerQueenHealthLevelFour();
        return config.getHealerQueenDefaultHealth();
    }

    public void refreshMenu(Player player) {
        ZombieArena.getMenuHandler().closeMenu(player);
        ZombieArena.getMenuHandler().openMenu(player, HealerQueenHealthUpgradeGUI(player));
    }
}
