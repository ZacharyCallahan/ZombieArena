package com.zach.zombiearena.gameplay.guis;

import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.gameplay.guis.archerqueen.ArcherQueenGUI;
import com.zach.zombiearena.utils.Button;
import com.zach.zombiearena.utils.ItemBuilder;
import com.zach.zombiearena.utils.Menu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class DefenseGUI implements Listener {
    private final ArcherQueenGUI archerQueenGUI = new ArcherQueenGUI();
    ConfigurationSection section;

    public Menu DefenseGUI() {
        Menu menu = new Menu(Bukkit.createInventory(null, 27, "Defense GUI"));
        //placeholders
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.placeholders");

        for (String keys : section.getKeys(false)) {
            if (keys != null) {
                ZombieArena.getMenuHandler().createPlaceholders(
                        menu,
                        section,
                        ZombieArena.getInstance().getConfig().getIntegerList("defensegui.placeholders." + keys + ".slots"),
                        ZombieArena.getInstance().getConfig().getString("defensegui.placeholders." + keys + ".material"));

            }
        }

        //purchasable Upgrades

        //TODO add other upgrades Barb King, Healer queen, etc

        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades");

        if (section != null) {
            //archerqueen upgrade
            menu.setButton(ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.slot"),
                    new Button(
                            ItemBuilder.createItem(Material.valueOf(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.material")),
                                    ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.material"),
                                    null,
                                    ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.lore"),
                                    null,
                                    ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.archer-queen-gui.enchanted"))) {
                        @Override
                        public void onClick(Menu menu, InventoryClickEvent event) {
                            Player player = (Player) event.getWhoClicked();
                            ZombieArena.getMenuHandler().closeMenu(player);
                            ZombieArena.getMenuHandler().openMenu(player, archerQueenGUI.ArcherQueenGUI());
                            event.setCancelled(true);
                        }
                    });
        }


        return menu;
    }

}
