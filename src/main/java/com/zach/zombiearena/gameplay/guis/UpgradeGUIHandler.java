package com.zach.zombiearena.gameplay.guis;

import com.zach.zombiearena.EconomyHandler;
import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.gameplay.defenseupgrades.Upgrade;
import com.zach.zombiearena.utils.Button;
import com.zach.zombiearena.utils.ItemBuilder;
import com.zach.zombiearena.utils.ItemManager;
import com.zach.zombiearena.utils.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;

public class UpgradeGUIHandler {
    public void setLevelToLow(Menu menu, int slot) {
        menu.setButton(slot, new Button(ItemManager.upgradeUnavailable) {
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
    }

    public void setUpgradePurchased(Menu menu, int slot) {
        menu.setButton(slot, new Button(ItemManager.upgradePurchased) {
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
    }

    public void refreshMenu(Player player, Menu menu) {
        ZombieArena.getMenuHandler().closeMenu(player);
        ZombieArena.getMenuHandler().openMenu(player, menu);
    }

    public void createUpgradeButtons(Menu menu, Integer slot,
                                     String displayName, List<String> lore, Double cost, Upgrade upgrade,
                                     Integer armorLevel, Integer chanceLevel,
                                     Integer healthLevel, Integer radiusLevel, Integer speedLevel, Integer healLevel, Integer amount) {
        menu.setButton(slot, new Button(
                ItemBuilder.createItem(
                        String.valueOf(Material.LIME_STAINED_GLASS_PANE),
                        displayName,
                        lore,
                        null, null, false)) {
            public void onClick(Menu menu, InventoryClickEvent event) {

                Player player = (Player) event.getWhoClicked();
                if (EconomyHandler.hasEnoughMoney(player, cost)) {
                    upgradeSuccess(player, upgrade, armorLevel, chanceLevel, healthLevel, radiusLevel, speedLevel, healLevel, amount);
                } else {
                    upgradeFailed(player, cost);
                }
                event.setCancelled(true);

            }
        });


    }

    public void upgradeSuccess(Player player, Upgrade upgrade, Integer armorLevel, Integer chanceLevel,
                               Integer healthLevel, Integer radiusLevel, Integer speedLevel, Integer healLevel, Integer amount) {
        switch (upgrade) {
            case ARCHER_QUEEN -> upgradeSuccessArcherQueen(player, healthLevel, radiusLevel, speedLevel);
            case BARBARIAN_KING -> upgradeSuccessBarbarianKing(player, healthLevel, radiusLevel, armorLevel);
            case HEALER_QUEEN -> upgradeSuccessHealerQueen(player, healthLevel, radiusLevel, healLevel);
            case REGULAR_MOB -> upgradeSuccessRegularMob(player, armorLevel, chanceLevel);
            case WAVE_ATTACK -> upgradeSuccessWaveAttack(player, amount);
        }
    }

    public void setUpgradedAndUpgradeable(Menu menu, Integer level, Integer slotOne, Integer slotTwo, Integer slotThree, Integer slotFour) {
        if (level == 0) {
            setLevelToLow(menu, slotTwo);
            setLevelToLow(menu, slotThree);
            setLevelToLow(menu, slotFour);
        }
        if (level == 1) {
            setUpgradePurchased(menu, slotOne);
            setLevelToLow(menu, slotThree);
            setLevelToLow(menu, slotFour);
        }
        if (level == 2) {
            setUpgradePurchased(menu, slotOne);
            setUpgradePurchased(menu, slotTwo);
            setLevelToLow(menu, slotFour);
        }
        if (level == 3) {
            setUpgradePurchased(menu, slotOne);
            setUpgradePurchased(menu, slotTwo);
            setUpgradePurchased(menu, slotThree);
        }
        if (level == 4) {
            setUpgradePurchased(menu, slotOne);
            setUpgradePurchased(menu, slotTwo);
            setUpgradePurchased(menu, slotThree);
            setUpgradePurchased(menu, slotFour);
        }

    }

    public void upgradeSuccessArcherQueen(Player player, Integer healthLevel, Integer radiusLevel, Integer speedLevel) {
        if (healthLevel != null)
            ZombieArena.getInstance().dataManager.updateArcherQueenHealthUpgradeLevel(player, healthLevel);
        if (radiusLevel != null)
            ZombieArena.getInstance().dataManager.updateArcherQueenRadiusUpgradeLevel(player, radiusLevel);
        if (speedLevel != null)
            ZombieArena.getInstance().dataManager.updateArcherQueenSpeedUpgradeLevel(player, speedLevel);
        //TODO withdraw correct amount of money from player
        EconomyHandler.withDrawMoney(player, (ZombieArena.getInstance()).config.getArcherQueenhealthUpgradeLevelOneCost());
        Messages.sendMessage(player, "defenseUpgradeSuccess");
    }

    public void upgradeSuccessBarbarianKing(Player player, Integer healthLevel, Integer radiusLevel, Integer armorlevel) {
        if (healthLevel != null)
            ZombieArena.getInstance().dataManager.updateBarbarianKingHealthUpgradeLevel(player, healthLevel);
        if (radiusLevel != null)
            ZombieArena.getInstance().dataManager.updateBarbarianKingRadiusUpgradeLevel(player, radiusLevel);
        if (armorlevel != null)
            ZombieArena.getInstance().dataManager.updateBarbarianKingArmorUpgradeLevel(player, armorlevel);
        //TODO withdraw correct amount of money from player
        EconomyHandler.withDrawMoney(player, (ZombieArena.getInstance()).config.getBarbarianKinghealthUpgradeLevelOneCost());

        Messages.sendMessage(player, "defenseUpgradeSuccess");
    }

    public void upgradeSuccessHealerQueen(Player player, Integer healthLevel, Integer radiusLevel, Integer healLevel) {
        if (healthLevel != null)
            ZombieArena.getInstance().dataManager.updateHealerQueenHealthUpgradeLevel(player, healthLevel);
        if (radiusLevel != null)
            ZombieArena.getInstance().dataManager.updateHealerQueenRadiusUpgradeLevel(player, radiusLevel);
        if (healLevel != null)
            ZombieArena.getInstance().dataManager.updateHealerQueenHealUpgradeLevel(player, healLevel);
        //TODO withdraw correct amount of money from player
        EconomyHandler.withDrawMoney(player, (ZombieArena.getInstance()).config.getHealerQueenhealthUpgradeLevelOneCost());

        Messages.sendMessage(player, "defenseUpgradeSuccess");
    }

    public void upgradeSuccessRegularMob(Player player, Integer armorlevel, Integer chanceLevel) {
        if (armorlevel != null)
            ZombieArena.getInstance().dataManager.updateRegularMobArmorUpgradeLevel(player, armorlevel);
        if (chanceLevel != null)
            ZombieArena.getInstance().dataManager.updateRegularMobChanceUpgradeLevel(player, chanceLevel);
        //TODO withdraw correct amount of money from player
        EconomyHandler.withDrawMoney(player, (ZombieArena.getInstance()).config.getRegularMobArmorUpgradeLevelOneCost());

        refreshMenu(player, ZombieArena.getInstance().regularMobArmorUpgradeGUI.RegularMobArmorUpgradeGUI(player));

        Messages.sendMessage(player, "defenseUpgradeSuccess");
    }

    public void upgradeSuccessWaveAttack(Player player, Integer amount) {
        if (amount != null)
            ZombieArena.getInstance().dataManager.updateWaveAttackUpgradeLevel(player, amount);
        //TODO withdraw correct amount of money from player
        EconomyHandler.withDrawMoney(player, (ZombieArena.getInstance()).config.getWaveAttackUpgradeLevelOneCost());

        Messages.sendMessage(player, "defenseUpgradeSuccess");
    }

    public void upgradeFailed(Player player, Double cost) {
        Messages.sendNotEnoughMoneyMessage(player, cost, "defenseUpgradeFail");
    }

    public void defensePurchased(Player player, String defense, Double cost, String defenseName) {
        if (defense.equals("archerQueen")) {
            ZombieArena.getInstance().dataManager.updatePurchasedArcherQueen(player, true);
        }
        if (defense.equals("barbarianKing")) {
            ZombieArena.getInstance().dataManager.updatePurchasedBarbarianKing(player, true);
        }
        if (defense.equals("healerQueen")) {
            ZombieArena.getInstance().dataManager.updatePurchasedHealerQueen(player, true);
        }
        if (defense.equals("waveAttack")) {
            ZombieArena.getInstance().dataManager.updatePurchasedWaveAttack(player, true);
        }
        //TODO add other if statements for the other defenses

        EconomyHandler.withDrawMoney(player, cost);

        Messages.sendDefensePurchasedMessage(player, defenseName, "defensePurchased");

    }
}
