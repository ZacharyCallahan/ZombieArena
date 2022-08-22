package com.zach.zombiearena.gameplay.guis;

import com.zach.zombiearena.EconomyHandler;
import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.utils.Button;
import com.zach.zombiearena.utils.ItemBuilder;
import com.zach.zombiearena.utils.ItemManager;
import com.zach.zombiearena.utils.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.HashMap;
import java.util.List;
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

    public void upgradeSuccess(Player player, Integer healthLevel, Integer radiusLevel) {
        if (healthLevel != null)
            ZombieArena.getInstance().dataManager.updateArcherQueenHealthUpgradeLevel(player, healthLevel);
        if (radiusLevel != null)
            ZombieArena.getInstance().dataManager.updateArcherQueenRadiusUpgradeLevel(player, radiusLevel);

        EconomyHandler.withDrawMoney(player, (ZombieArena.getInstance()).config.getArcherQueenhealthUpgradeLevelOneCost());

        Messages.sendMessage(player, "defenseUpgradeSuccess");
    }

    public void upgradeFailed(Player player, Double cost) {
        Messages.sendNotEnoughMoneyMessage(player, cost, "defenseUpgradeFail");
    }

    public void defensePurchased(Player player, HashMap<UUID, Boolean> defense, Double cost, String defenseName) {
        if (defense.equals(ZombieArena.getInstance().waves.purchasedArcherQueen))
            ZombieArena.getInstance().dataManager.updatePurchasedArcherQueen(player, true);
        //TODO add other if statements for the other defenses

        EconomyHandler.withDrawMoney(player, cost);

        Messages.sendDefensePurchasedMessage(player, defenseName, "defensePurchased");

    }

    public void createUpgrades(Menu menu, Menu refreshMenu, Integer upgradeLevel, Integer radiusLevel, Integer healthLevel, Integer slot, Integer levelOneSlot, Integer levelTwoSlot,
                               Integer levelThreeSlot, Integer levelFourSlot, String material, String dislayName, List<String> guiLore, List<String> lore, List<String> enchantments, Boolean enchanted, Double cost) {
        menu.setButton(slot, new Button(
                ItemBuilder.createItem(material, dislayName, guiLore, lore, enchantments, enchanted)
        ) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                Player player = (Player) event.getWhoClicked();
                if (EconomyHandler.hasEnoughMoney(player, cost)) {
                    upgradeSuccess(player, healthLevel, radiusLevel);
                    refreshMenu(player, refreshMenu);
                } else {
                    upgradeFailed(player, cost);
                }
                event.setCancelled(true);

            }
        });

        if (upgradeLevel == 0) {
            setLevelToLow(menu, levelTwoSlot);
            setLevelToLow(menu, levelThreeSlot);
            setLevelToLow(menu, levelFourSlot);
        } else if (upgradeLevel == 1) {
            setUpgradePurchased(menu, levelOneSlot);
            setLevelToLow(menu, levelThreeSlot);
            setUpgradePurchased(menu, levelFourSlot);
        } else if (upgradeLevel == 2) {
            setUpgradePurchased(menu, levelOneSlot);
            setUpgradePurchased(menu, levelTwoSlot);
            setLevelToLow(menu, levelFourSlot);
        } else if (upgradeLevel == 3) {
            setUpgradePurchased(menu, levelOneSlot);
            setUpgradePurchased(menu, levelTwoSlot);
            setUpgradePurchased(menu, levelThreeSlot);
        } else if (upgradeLevel == 4) {
            setUpgradePurchased(menu, levelOneSlot);
            setUpgradePurchased(menu, levelTwoSlot);
            setUpgradePurchased(menu, levelThreeSlot);
            setUpgradePurchased(menu, levelFourSlot);
        }
    }

    public void refreshMenu(Player player, Menu menu) {
        ZombieArena.getMenuHandler().closeMenu(player);
        ZombieArena.getMenuHandler().openMenu(player, menu);
    }
}
