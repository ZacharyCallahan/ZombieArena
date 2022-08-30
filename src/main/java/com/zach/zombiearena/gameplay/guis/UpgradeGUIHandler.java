package com.zach.zombiearena.gameplay.guis;

import com.zach.zombiearena.EconomyHandler;
import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.utils.Button;
import com.zach.zombiearena.utils.ItemManager;
import com.zach.zombiearena.utils.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

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

    public void upgradeSuccessRegularMob(Player player, Integer armorlevel) {
        if (armorlevel != null)
            ZombieArena.getInstance().dataManager.updateRegularMobArmorUpgradeLevel(player, armorlevel);
        //TODO withdraw correct amount of money from player
        EconomyHandler.withDrawMoney(player, (ZombieArena.getInstance()).config.getRegularMobArmorUpgradeLevelOneCost());

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
