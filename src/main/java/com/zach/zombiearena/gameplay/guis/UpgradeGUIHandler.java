package com.zach.zombiearena.gameplay.guis;

import com.zach.zombiearena.EconomyHandler;
import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.utils.Button;
import com.zach.zombiearena.utils.ItemManager;
import com.zach.zombiearena.utils.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.HashMap;
import java.util.UUID;

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

    public void upgradeSuccess(Player player, Integer healthLevel, Integer radiusLevel, Integer speedLevel) {
        if (healthLevel != null)
            ZombieArena.getInstance().dataManager.updateArcherQueenHealthUpgradeLevel(player, healthLevel);
        if (radiusLevel != null)
            ZombieArena.getInstance().dataManager.updateArcherQueenRadiusUpgradeLevel(player, radiusLevel);
        if (speedLevel != null)
            ZombieArena.getInstance().dataManager.updateArcherQueenSpeedUpgradeLevel(player, speedLevel);

        EconomyHandler.withDrawMoney(player, (ZombieArena.getInstance()).config.getArcherQueenhealthUpgradeLevelOneCost());

        Messages.sendMessage(player, "defenseUpgradeSuccess");
    }

    public void upgradeFailed(Player player, Double cost) {
        Messages.sendNotEnoughMoneyMessage(player, cost, "defenseUpgradeFail");
    }

    public void defensePurchased(Player player, HashMap<UUID, Boolean> defense, Double cost, String defenseName) {
        if (defense.equals(ZombieArena.getInstance().archerQueen.purchasedArcherQueen))
            ZombieArena.getInstance().dataManager.updatePurchasedArcherQueen(player, true);
        //TODO add other if statements for the other defenses

        EconomyHandler.withDrawMoney(player, cost);

        Messages.sendDefensePurchasedMessage(player, defenseName, "defensePurchased");

    }
}
