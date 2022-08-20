package com.zach.zombiearena.gameplay.guis.archerqueen;

import com.zach.zombiearena.Config;
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

import static com.zach.zombiearena.EconomyHandler.hasEnoughMoney;

public class ArcherQueenHealthUpgradeGUI {

    UpgradeGUIHandler upgradeGUIHandler = new UpgradeGUIHandler();
    Config config = new Config();
    private ConfigurationSection section;

    public Menu ArcherQueenHealthUpgradeGUI(Player player) {

        Menu menu = new Menu(Bukkit.createInventory(null, 27, "Archer Queen Health Upgrade GUI"));

        //placeholders
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.archer-queen-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null) {
                ZombieArena.getMenuHandler().createPlaceholders(
                        menu,
                        section,
                        config.getArcherQueenPlaceHolderSlots(keys),
                        config.getArcherQueenPlaceHolderMaterialSection(keys));

            }
        }


        menu.setButton(4, new Button(
                ItemBuilder.createItem(
                        config.getArcherQueenHealthUpgradeItemStatsPlaceHolder(),
                        "&6Archer Queen Health Stats",
                        ZombieArena.getInstance().archerQueenGUI.getArcherQueenHealthStatsLore(player),
                        null,
                        null,
                        config.getArcherQueenHealthUpgradeItemStatsPlaceHolderEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });


        //level one upgrade
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 0) {
            menu.setButton(config.getArcherQueenHealthUpgradeLevelOneSlot(), new Button(
                    ItemBuilder.createItem(
                            Material.LIME_STAINED_GLASS_PANE,
                            config.getArcherQueenHealthUpgradeLevelOneDisplayName(),
                            config.getArcherQueenHealthUpgradeLevelOneLore(),
                            null,
                            null,
                            false)) {
                @Override
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (hasEnoughMoney(player, config.getArcherQueenhealthUpgradeLevelOneCost())) {
                        upgradeGUIHandler.upgradeSuccess(player, menu);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player);
                    }

                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenHealthUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenHealthUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenHealthUpgradeLevelFourSlot());
        }


        //TODO add other upgrade Levels

        //level two upgrade
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 1) {
            menu.setButton(config.getArcherQueenHealthUpgradeLevelTwoSlot(), new Button(
                    ItemBuilder.createItem(
                            Material.LIME_STAINED_GLASS_PANE,
                            config.getArcherQueenHealthUpgradeLevelTwoDisplayName(),
                            config.getArcherQueenHealthUpgradeLevelTwoLore(),
                            null,
                            null,
                            false)) {
                @Override
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (hasEnoughMoney(player, config.getArcherQueenhealthUpgradeLevelTwoCost())) {
                        upgradeGUIHandler.upgradeSuccess(player, menu);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player);
                    }

                    event.setCancelled(true);
                }
            });


            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelOneSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenHealthUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenHealthUpgradeLevelFourSlot());
        }

        //level three upgrade
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 2) {
            menu.setButton(config.getArcherQueenHealthUpgradeLevelThreeSlot(), new Button(
                    ItemBuilder.createItem(
                            Material.LIME_STAINED_GLASS_PANE,
                            config.getArcherQueenHealthUpgradeLevelThreeDisplayName(),
                            config.getArcherQueenHealthUpgradeLevelThreeLore(),
                            null,
                            null,
                            false)) {
                @Override
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (hasEnoughMoney(player, config.getArcherQueenhealthUpgradeLevelThreeCost())) {
                        upgradeGUIHandler.upgradeSuccess(player, menu);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player);
                    }

                    event.setCancelled(true);
                }
            });

            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getArcherQueenHealthUpgradeLevelFourSlot());
        }

        //level four upgrade
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 3) {

            menu.setButton(config.getArcherQueenHealthUpgradeLevelFourSlot(), new Button(
                    ItemBuilder.createItem(
                            Material.LIME_STAINED_GLASS_PANE,
                            config.getArcherQueenHealthUpgradeLevelFourDisplayName(),
                            config.getArcherQueenHealthUpgradeLevelFourLore(),
                            null,
                            null,
                            false)) {
                @Override
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (hasEnoughMoney(player, config.getArcherQueenhealthUpgradeLevelFourCost())) {
                        upgradeGUIHandler.upgradeSuccess(player, menu);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player);
                    }

                    event.setCancelled(true);
                }
            });

            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getArcherQueenHealthUpgradeLevelThreeSlot());
        }


        return menu;
    }

    public Integer getPlayersArcherQueenHealthUpgradeLevel(Player player) {
        return ZombieArena.getInstance().waves.archerQueenHealthUpgradeLevel.get(player.getUniqueId());
    }

    public Integer getPlayersArcherQueenHealth(Player player) {
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 1) {
            return config.getArcherQueenHealthLevelOne();
        }
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 2) {
            return config.getArcherQueenHealthLevelTwo();
        }
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 3) {
            return config.getArcherQueenHealthLevelThree();
        }
        if (getPlayersArcherQueenHealthUpgradeLevel(player) == 4) {
            return config.getArcherQueenHealthLevelFour();
        }
        return config.getArcherQueenDefaultHealth();
    }

}
