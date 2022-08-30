package com.zach.zombiearena.gameplay.guis.regularmob;

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

public class RegularMobArmorUpgradeGUI {
    UpgradeGUIHandler upgradeGUIHandler = new UpgradeGUIHandler();

    Config config = new Config();

    private ConfigurationSection section;

    public Menu RegularMobArmorUpgradeGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27, ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.display-name") + ": "
                + config.getRegularMobArmorUpgradeGuiDisplayName())));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getRegularMobUpgradeArmorGui(keys),
                        config.getRegularMobUpgradeArmorGuiMaterialSection(keys));
        }
        menu.setButton(config.getRegularMobArmorUpgradeItemStatsPlaceHolderSlot(), new Button(
                ItemBuilder.createItem(
                        config.getRegularMobArmorUpgradeItemStatsPlaceHolder(),
                        config.getRegularMobArmorUpgradeItemStatsPlaceHolderDisplayName(),
                        ZombieArena.getInstance().regularMobGUI.getRegularMobArmorStatsLore(player),
                        null,
                        null,
                        config.getRegularMobArmorUpgradeItemStatsPlaceHolderEnchanted())) {
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 0) {
            menu.setButton(config.getRegularMobArmorUpgradeLevelOneSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getRegularMobArmorUpgradeLevelOneDisplayName(), config
                                    .getRegularMobArmorUpgradeLevelOneLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getRegularMobArmorUpgradeLevelOneCost())) {
                        upgradeGUIHandler.upgradeSuccessRegularMob(player, 1);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getRegularMobArmorUpgradeLevelOneCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setLevelToLow(menu, config.getRegularMobArmorUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getRegularMobArmorUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getRegularMobArmorUpgradeLevelFourSlot());
        }
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 1) {
            menu.setButton(config.getRegularMobArmorUpgradeLevelTwoSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getRegularMobArmorUpgradeLevelTwoDisplayName(), config
                                    .getRegularMobArmorUpgradeLevelTwoLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getRegularMobArmorUpgradeLevelTwoCost())) {
                        upgradeGUIHandler.upgradeSuccessRegularMob(player, 2);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getRegularMobArmorUpgradeLevelTwoCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getRegularMobArmorUpgradeLevelOneSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getRegularMobArmorUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getRegularMobArmorUpgradeLevelFourSlot());
        }
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 2) {
            menu.setButton(config.getRegularMobArmorUpgradeLevelThreeSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getRegularMobArmorUpgradeLevelThreeDisplayName(), config
                                    .getRegularMobArmorUpgradeLevelThreeLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getRegularMobArmorUpgradeLevelThreeCost())) {
                        upgradeGUIHandler.upgradeSuccessRegularMob(player, 3);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getRegularMobArmorUpgradeLevelThreeCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getRegularMobArmorUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getRegularMobArmorUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getRegularMobArmorUpgradeLevelFourSlot());
        }
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 3) {
            menu.setButton(config.getRegularMobArmorUpgradeLevelFourSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getRegularMobArmorUpgradeLevelFourDisplayName(), config
                                    .getRegularMobArmorUpgradeLevelFourLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getRegularMobArmorUpgradeLevelFourCost())) {
                        upgradeGUIHandler.upgradeSuccessRegularMob(player, 4);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getRegularMobArmorUpgradeLevelFourCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getRegularMobArmorUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getRegularMobArmorUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getRegularMobArmorUpgradeLevelThreeSlot());
        }
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 4) {
            upgradeGUIHandler.setUpgradePurchased(menu, config.getRegularMobArmorUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getRegularMobArmorUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getRegularMobArmorUpgradeLevelThreeSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getRegularMobArmorUpgradeLevelFourSlot());
        }
        return menu;
    }

    public Integer getPlayersRegularMobArmorUpgradeLevel(Player player) {
        return (ZombieArena.getInstance()).regularMob.regularMobArmorUpgradeLevel.get(player.getUniqueId());
    }

    public String getPlayersRegularMobArmor(Player player) {
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 1)
            return config.getRegularMobArmorLevelOne();
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 2)
            return config.getRegularMobArmorLevelTwo();
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 3)
            return config.getRegularMobArmorLevelThree();
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 4)
            return config.getRegularMobArmorLevelFour();
        return config.getRegularMobArmor();
    }

    public void refreshMenu(Player player) {
        ZombieArena.getMenuHandler().closeMenu(player);
        ZombieArena.getMenuHandler().openMenu(player, RegularMobArmorUpgradeGUI(player));
    }

}
