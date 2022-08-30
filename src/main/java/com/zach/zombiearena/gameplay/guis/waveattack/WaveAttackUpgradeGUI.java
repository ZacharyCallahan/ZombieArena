package com.zach.zombiearena.gameplay.guis.waveattack;

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

public class WaveAttackUpgradeGUI {
    UpgradeGUIHandler upgradeGUIHandler = new UpgradeGUIHandler();

    Config config = new Config();

    private ConfigurationSection section;

    public Menu WaveAttackUpgradeGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27, ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.display-name") + ": "
                + config.getWaveAttackUpgradeGuiDisplayName())));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.wave-attack-gui.upgrade-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getWaveAttackUpgradeGui(keys),
                        config.getWaveAttackUpgradeGuiMaterialSection(keys));
        }
        menu.setButton(config.getWaveAttackUpgradeItemStatsPlaceHolderSlot(), new Button(
                ItemBuilder.createItem(
                        config.getWaveAttackUpgradeItemStatsPlaceHolder(),
                        config.getWaveAttackUpgradeItemStatsPlaceHolderDisplayName(),
                        ZombieArena.getInstance().waveAttackGUI.getWaveAttackStatsLore(player),
                        null,
                        null,
                        config.getWaveAttackUpgradeItemStatsPlaceHolderEnchanted())) {
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
        if (getPlayersWaveAttackUpgradeLevel(player) == 0) {
            menu.setButton(config.getWaveAttackUpgradeLevelOneSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getWaveAttackUpgradeLevelOneDisplayName(), config
                                    .getWaveAttackUpgradeLevelOneLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getWaveAttackUpgradeLevelOneCost())) {
                        upgradeGUIHandler.upgradeSuccessWaveAttack(player, 1);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getWaveAttackUpgradeLevelOneCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setLevelToLow(menu, config.getWaveAttackUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getWaveAttackUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getWaveAttackUpgradeLevelFourSlot());
        }
        if (getPlayersWaveAttackUpgradeLevel(player) == 1) {
            menu.setButton(config.getWaveAttackUpgradeLevelTwoSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getWaveAttackUpgradeLevelTwoDisplayName(), config
                                    .getWaveAttackUpgradeLevelTwoLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getWaveAttackUpgradeLevelTwoCost())) {
                        upgradeGUIHandler.upgradeSuccessWaveAttack(player, 2);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getWaveAttackUpgradeLevelTwoCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getWaveAttackUpgradeLevelOneSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getWaveAttackUpgradeLevelThreeSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getWaveAttackUpgradeLevelFourSlot());
        }
        if (getPlayersWaveAttackUpgradeLevel(player) == 2) {
            menu.setButton(config.getWaveAttackUpgradeLevelThreeSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getWaveAttackUpgradeLevelThreeDisplayName(), config
                                    .getWaveAttackUpgradeLevelThreeLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getWaveAttackUpgradeLevelThreeCost())) {
                        upgradeGUIHandler.upgradeSuccessWaveAttack(player, 3);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getWaveAttackUpgradeLevelThreeCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getWaveAttackUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getWaveAttackUpgradeLevelTwoSlot());
            upgradeGUIHandler.setLevelToLow(menu, config.getWaveAttackUpgradeLevelFourSlot());
        }
        if (getPlayersWaveAttackUpgradeLevel(player) == 3) {
            menu.setButton(config.getWaveAttackUpgradeLevelFourSlot(), new Button(
                    ItemBuilder.createItem(
                            String.valueOf(Material.LIME_STAINED_GLASS_PANE), config
                                    .getWaveAttackUpgradeLevelFourDisplayName(), config
                                    .getWaveAttackUpgradeLevelFourLore(), null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (EconomyHandler.hasEnoughMoney(player, config.getWaveAttackUpgradeLevelFourCost())) {
                        upgradeGUIHandler.upgradeSuccessWaveAttack(player, 4);
                        refreshMenu(player);
                    } else {
                        upgradeGUIHandler.upgradeFailed(player, config.getWaveAttackUpgradeLevelFourCost());
                    }
                    event.setCancelled(true);
                }
            });
            upgradeGUIHandler.setUpgradePurchased(menu, config.getWaveAttackUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getWaveAttackUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getWaveAttackUpgradeLevelThreeSlot());
        }
        if (getPlayersWaveAttackUpgradeLevel(player) == 4) {
            upgradeGUIHandler.setUpgradePurchased(menu, config.getWaveAttackUpgradeLevelOneSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getWaveAttackUpgradeLevelTwoSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getWaveAttackUpgradeLevelThreeSlot());
            upgradeGUIHandler.setUpgradePurchased(menu, config.getWaveAttackUpgradeLevelFourSlot());
        }
        return menu;
    }

    public Integer getPlayersWaveAttackUpgradeLevel(Player player) {
        return ZombieArena.getInstance().waveAttack.waveAttackUpgradeLevel.get(player.getUniqueId());
    }

    public String getPlayersWaveAttack(Player player) {
        if (getPlayersWaveAttackUpgradeLevel(player) == 1)
            return config.getWaveAttackLevelOne();
        if (getPlayersWaveAttackUpgradeLevel(player) == 2)
            return config.getWaveAttackLevelTwo();
        if (getPlayersWaveAttackUpgradeLevel(player) == 3)
            return config.getWaveAttackLevelThree();
        if (getPlayersWaveAttackUpgradeLevel(player) == 4)
            return config.getWaveAttackLevelFour();
        return config.getWaveAttack();
    }

    public void refreshMenu(Player player) {
        ZombieArena.getMenuHandler().closeMenu(player);
        ZombieArena.getMenuHandler().openMenu(player, WaveAttackUpgradeGUI(player));
    }
}
