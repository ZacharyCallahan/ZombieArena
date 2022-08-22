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

import java.util.ArrayList;
import java.util.List;

public class ArcherQueenGUI implements Listener {
    private final ArcherQueenHealthUpgradeGUI archerQueenHealthUpgradeGUI = new ArcherQueenHealthUpgradeGUI();

    Config config = new Config();

    private ConfigurationSection section;

    public Menu ArcherQueenGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27, "Archer Queen GUI"));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.archer-queen-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section, config

                        .getArcherQueenPlaceHolderSlots(keys), config
                        .getArcherQueenPlaceHolderMaterialSection(keys));
        }
        menu.setButton(config.getArcherQueenPlaceHolderStatsSlots(), new Button(
                ItemBuilder.createItem(config
                                .getArcherQueenGuiMaterial(), config
                                .getArcherQueenPlaceHolderStatsDisplayName(),
                        getArcherQueenStatsLore(player), null, null, config

                                .getArcherQueenPlaceHolderStatsEnchanted())) {
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.archer-queen-gui.health-upgrade-gui");
        if (section != null)
            menu.setButton(config.getArcherQueenHealthUpgradeGuiSlot(), new Button(
                    ItemBuilder.createItem(config.getArcherQueenHealthUpgradeGuiMaterial(), config
                            .getArcherQueenHealthUpgradeGuiDisplayName(), config
                            .getArcherQueenHealthUpgradeGuiLore(), null, null, config

                            .getArcherQueenHealthUpgradeGuiEnchanted())) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    ZombieArena.getMenuHandler().closeMenu(player);
                    ZombieArena.getMenuHandler().openMenu(player, ArcherQueenGUI.this.archerQueenHealthUpgradeGUI.ArcherQueenHealthUpgradeGUI(player));
                    event.setCancelled(true);
                }
            });
        return menu;
    }

    public List<String> getArcherQueenHealthStatsLore(Player player) {
        List<String> itemStatsPlaceHolderLore = new ArrayList<>();
        itemStatsPlaceHolderLore.add(ZombieArena.color(" "));
        itemStatsPlaceHolderLore.add(ZombieArena.color("&7Health: &c" + archerQueenHealthUpgradeGUI.getPlayersArcherQueenHealth(player)));
        if (archerQueenHealthUpgradeGUI.getPlayersArcherQueenHealthUpgradeLevel(player) > 0)
            itemStatsPlaceHolderLore.add(ZombieArena.color("&7Level: &a" + archerQueenHealthUpgradeGUI.getPlayersArcherQueenHealthUpgradeLevel(player)));
        return itemStatsPlaceHolderLore;
    }

    public List<String> getArcherQueenStatsLore(Player player) {
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("&7&lHealth: &c" + archerQueenHealthUpgradeGUI.getPlayersArcherQueenHealth(player));
        return lore;
    }
}
