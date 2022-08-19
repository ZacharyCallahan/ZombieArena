package com.zach.zombiearena.gameplay.guis.archerqueen;

import com.zach.zombiearena.Config;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.utils.Button;
import com.zach.zombiearena.utils.ItemBuilder;
import com.zach.zombiearena.utils.Menu;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ArcherQueenGUI implements Listener {
    private final ArcherQueenHealthUpgradeGUI archerQueenHealthUpgradeGUI = new ArcherQueenHealthUpgradeGUI();
    Config config = new Config();
    private ConfigurationSection section;

    public Menu ArcherQueenGUI() {
        Menu menu = new Menu(Bukkit.createInventory(null, 27, "Archer Queen GUI"));

        //placeholders
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.archer-queen-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null) {
                ZombieArena.getMenuHandler().createPlaceholders(
                        menu,
                        section,
                        ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.archer-queen-gui.placeholders." + keys + ".slots"),
                        ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.placeholders." + keys + ".material"));
            }
        }


        //possible upgrades, health, improved radius, improve speed
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.archer-queen-gui.health-upgrade-level-one-gui");
        if (section != null) {
            //upgrade health level one
            menu.setButton(config.getArcherQueenHealthUpgradeDisplayItemSlot(), new Button(
                    ItemBuilder.createItem(
                            config.getArcherQueenHealthUpgradeDisplayItem(),
                            config.getArcherQueenHealthUpgradeDisplayItemSection(),
                            config.getArcherQueenHealthUpgradeDisplayItemDisplayName(),
                            config.getArcherQueenHealthUpgradeDisplayItemLore(),
                            null,
                            null,
                            config.getArcherQueenHealthUpgradeDisplayItemEnchanted())) {
                @Override
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    ZombieArena.getMenuHandler().openMenu(player, archerQueenHealthUpgradeGUI.ArcherQueenHealthUpgradeGUI());
                    event.setCancelled(true);
                }
            });

        }

        //TODO add other upgrades

        return menu;
    }
}
