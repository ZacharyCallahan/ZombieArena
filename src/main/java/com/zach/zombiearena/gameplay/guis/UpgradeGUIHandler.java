package com.zach.zombiearena.gameplay.guis;

import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.utils.Button;
import com.zach.zombiearena.utils.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import static com.zach.zombiearena.EconomyHandler.withDrawMoney;
import static com.zach.zombiearena.utils.ItemManager.upgradeUnavailable;

public class UpgradeGUIHandler {


    public void setLevelToLow(Menu menu, int slot) {
        menu.setButton(slot, new Button(upgradeUnavailable) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
    }

    public void setUpgradePurchased(Menu menu, int slot) {
        menu.setButton(slot, new Button(upgradeUnavailable) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
    }

    public void upgradeSuccess(Player player, Menu menu) {
        ZombieArena.getInstance().dataManager.saveArcherQueenHealthUpgradeLevel(player.getUniqueId());
        ZombieArena.getMenuHandler().refreshMenu(player, menu);
        withDrawMoney(player, ZombieArena.getInstance().config.getArcherQueenhealthUpgradeLevelOneCost());
        //TODO send message to player
        player.sendMessage("You have successfully purchased the Archer Queen Health Upgrade");
    }

    public void upgradeFailed(Player player) {
        //TODO send message to player
        player.sendMessage("You do not have enough money to purchase this upgrade");
    }
}
