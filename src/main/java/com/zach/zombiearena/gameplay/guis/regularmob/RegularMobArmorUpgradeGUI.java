package com.zach.zombiearena.gameplay.guis.regularmob;

import com.zach.zombiearena.Config;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.gameplay.defenseupgrades.Upgrade;
import com.zach.zombiearena.gameplay.guis.UpgradeGUIHandler;
import com.zach.zombiearena.utils.Button;
import com.zach.zombiearena.utils.ItemBuilder;
import com.zach.zombiearena.utils.Menu;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;

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

        createChanceUpgrades(player, menu);
        return menu;
    }

    public void createChanceUpgrades(Player player, Menu menu) {
        if (getPlayersRegularMobArmorUpgradeLevel(player.getUniqueId()) == 1) {
            checkUpgradeChanceLevels(player, menu, 1);
        }
        if (getPlayersRegularMobArmorUpgradeLevel(player.getUniqueId()) == 2) {
            checkUpgradeChanceLevels(player, menu, 2);

        }
        if (getPlayersRegularMobArmorUpgradeLevel(player.getUniqueId()) == 3) {
            checkUpgradeChanceLevels(player, menu, 3);
        }
        if (getPlayersRegularMobArmorUpgradeLevel(player.getUniqueId()) == 4) {
            checkUpgradeChanceLevels(player, menu, 4);
        }
    }

    public void checkUpgradeChanceLevels(Player player, Menu menu, Integer armorLevel) {
        upgradeGUIHandler.setUpgradedAndUpgradeable(menu, getPlayerChanceUpgradeLevel(player.getUniqueId()), config.getRegularMobArmorUpgradeLevelOneSlot(),
                config.getRegularMobArmorUpgradeLevelTwoSlot(), config.getRegularMobArmorUpgradeLevelThreeSlot(), config.getRegularMobArmorUpgradeLevelFourSlot());
        if (getPlayerChanceUpgradeLevel(player.getUniqueId()) == 0) {
            createChanceUpgradeButton(player, menu, armorLevel, 1);
        }
        if (getPlayerChanceUpgradeLevel(player.getUniqueId()) == 1) {
            createChanceUpgradeButton(player, menu, armorLevel, 2);
        }
        if (getPlayerChanceUpgradeLevel(player.getUniqueId()) == 2) {
            createChanceUpgradeButton(player, menu, armorLevel, 3);
        }
        if (getPlayersRegularMobArmorUpgradeLevel(player.getUniqueId()) != 4) {
            if (getPlayerChanceUpgradeLevel(player.getUniqueId()) == 3) {
                upgradeArmorLevel(menu, player, armorLevel);
            }
        } else {
            if (getPlayerChanceUpgradeLevel(player.getUniqueId()) == 3) {
                createChanceUpgradeButton(player, menu, armorLevel, 4);
            }
        }
    }

    public void upgradeArmorLevel(Menu menu, Player player, Integer armorLevel) {
        createChanceUpgradeButton(player, menu, armorLevel + 1, 0);
    }

    public Integer getPlayersRegularMobArmorUpgradeLevel(UUID player) {
        return ZombieArena.getInstance().regularMob.regularMobArmorUpgradeLevel.get(player);
    }

    public Integer getPlayerChanceUpgradeLevel(UUID player) {
        return (ZombieArena.getInstance()).regularMob.regularMobChanceUpgradeLevel.get(player);
    }

    public String getPlayersRegularMobArmor(UUID player) {
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 1)
            return config.getRegularMobArmorLevelOne();
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 2)
            return config.getRegularMobArmorLevelTwo();
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 3)
            return config.getRegularMobArmorLevelThree();
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 4)
            return config.getRegularMobArmorLevelFour();
        return null;
    }

    public Integer getPlayersSpawnChance(UUID player) {
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 1)
            return config.getRegularMobChanceLevelOne(getPlayerChanceUpgradeLevel(player));
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 2)
            return config.getRegularMobChanceLevelTwo(getPlayerChanceUpgradeLevel(player));
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 3)
            return config.getRegularMobChanceLevelThree(getPlayerChanceUpgradeLevel(player));
        if (getPlayersRegularMobArmorUpgradeLevel(player) == 4)
            return config.getRegularMobChanceLevelFour(getPlayerChanceUpgradeLevel(player));
        return null;
    }

    public void createChanceUpgradeButton(Player player, Menu menu, Integer armorLevel, Integer chanceLevel) {
        if (getPlayerChanceUpgradeLevel(player.getUniqueId()) == 0) {
            upgradeGUIHandler.createUpgradeButtons(menu, config.getRegularMobArmorUpgradeLevelOneSlot(), config.getRegularMobArmorUpgradeLevelOneDisplayName(),
                    config.getRegularMobArmorUpgradeLevelOneLore(), config.getRegularMobArmorUpgradeLevelOneCost(), Upgrade.REGULAR_MOB, armorLevel, chanceLevel,
                    null, null, null, null, null);
        }
        if (getPlayerChanceUpgradeLevel(player.getUniqueId()) == 1) {
            upgradeGUIHandler.createUpgradeButtons(menu, config.getRegularMobArmorUpgradeLevelTwoSlot(), config.getRegularMobArmorUpgradeLevelTwoDisplayName(),
                    config.getRegularMobArmorUpgradeLevelTwoLore(), config.getRegularMobArmorUpgradeLevelTwoCost(), Upgrade.REGULAR_MOB, armorLevel, chanceLevel,
                    null, null, null, null, null);
        }
        if (getPlayerChanceUpgradeLevel(player.getUniqueId()) == 2) {
            upgradeGUIHandler.createUpgradeButtons(menu, config.getRegularMobArmorUpgradeLevelThreeSlot(), config.getRegularMobArmorUpgradeLevelThreeDisplayName(),
                    config.getRegularMobArmorUpgradeLevelThreeLore(), config.getRegularMobArmorUpgradeLevelThreeCost(), Upgrade.REGULAR_MOB, armorLevel, chanceLevel,
                    null, null, null, null, null);
        }
        if (getPlayerChanceUpgradeLevel(player.getUniqueId()) == 3) {
            upgradeGUIHandler.createUpgradeButtons(menu, config.getRegularMobArmorUpgradeLevelFourSlot(), config.getRegularMobArmorUpgradeLevelFourDisplayName(),
                    config.getRegularMobArmorUpgradeLevelFourLore(), config.getRegularMobArmorUpgradeLevelFourCost(), Upgrade.REGULAR_MOB, armorLevel, chanceLevel,
                    null, null, null, null, null);
        }
    }

}
