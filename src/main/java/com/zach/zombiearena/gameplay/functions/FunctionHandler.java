package com.zach.zombiearena.gameplay.functions;

import com.zach.zombiearena.Messages;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import static com.zach.zombiearena.utils.ItemManager.moneyItem;

public class FunctionHandler {
    public boolean containsAtleast(Player attacker, Integer cost) {
        return attacker.getInventory().containsAtLeast(moneyItem, cost);
    }

    public void purchaseSuccess(Player attacker, Integer cost) {
        for (int i = 0; i < cost; i++) {
            attacker.getInventory().removeItem(moneyItem);
        }
        attacker.playSound(attacker.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
    }

    public void purchaseFail(Player attacker) {
        attacker.playSound(attacker.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
        Messages.sendMessage(attacker, "functionPurchaseFail");
    }
}
