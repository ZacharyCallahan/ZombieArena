package com.zach.zombiearena.gameplay.guis;

import com.zach.zombiearena.Config;
import com.zach.zombiearena.EconomyHandler;
import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.gameplay.guis.archerqueen.ArcherQueenGUI;
import com.zach.zombiearena.utils.Button;
import com.zach.zombiearena.utils.ItemBuilder;
import com.zach.zombiearena.utils.Menu;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class DefenseGUI implements Listener {
    private final ArcherQueenGUI archerQueenGUI = new ArcherQueenGUI();

    Config config = new Config();
    UpgradeGUIHandler upgradeGUIHandler = new UpgradeGUIHandler();
    ConfigurationSection section;

    public Menu DefenseGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27, ZombieArena.color("&7&lDefense Upgrades")));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,

                        ZombieArena.getInstance().getConfig().getIntegerList("defensegui.placeholders." + keys + ".slots"),
                        ZombieArena.getInstance().getConfig().getString("defensegui.placeholders." + keys + ".material"));
        }

        //if they have purchased the Archer Queen
        if (ZombieArena.getInstance().archerQueen.purchasedArcherQueen.get(player.getUniqueId()) != null) {
            if (ZombieArena.getInstance().archerQueen.purchasedArcherQueen.get(player.getUniqueId())) {
                menu.setButton(ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.slot"), new Button(
                        ItemBuilder.createItem(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.material"),
                                ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.display-name"),
                                ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.lore"),
                                null,
                                null,
                                ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.archer-queen-gui.enchanted"))) {
                    public void onClick(Menu menu, InventoryClickEvent event) {
                        Player player = (Player) event.getWhoClicked();
                        ZombieArena.getMenuHandler().closeMenu(player);
                        ZombieArena.getMenuHandler().openMenu(player, archerQueenGUI.ArcherQueenGUI(player));
                        event.setCancelled(true);
                    }
                });

                //if they havent purchased the Archer Queen
            } else {
                menu.setButton(ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.slot"), new Button(

                        ItemBuilder.createItem(config.getArcherQueenPurchaseMaterial(),
                                ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.display-name"),
                                null,
                                config.getArcherQueenPurchaseLore(),
                                null,
                                config.getArcherQueenPurchaseEnchanted())) {
                    @Override
                    public void onClick(Menu menu, InventoryClickEvent event) {
                        Player player = (Player) event.getWhoClicked();
                        if (EconomyHandler.hasEnoughMoney(player, config.getArcherQueenPurchaseCost())) {
                            upgradeGUIHandler.defensePurchased(player,
                                    ZombieArena.getInstance().archerQueen.purchasedArcherQueen,
                                    config.getArcherQueenPurchaseCost(),
                                    ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.display-name"));
                            refreshMenu(player);
                        } else {
                            upgradeGUIHandler.upgradeFailed(player, config.getArcherQueenPurchaseCost());
                        }
                        event.setCancelled(true);
                    }
                });
            }
        } else {
            Messages.sendMessage(player, "arenaNoArena");
        }

        return menu;
    }

    public void refreshMenu(Player player) {
        ZombieArena.getMenuHandler().closeMenu(player);
        ZombieArena.getMenuHandler().openMenu(player, DefenseGUI(player));
    }
}
