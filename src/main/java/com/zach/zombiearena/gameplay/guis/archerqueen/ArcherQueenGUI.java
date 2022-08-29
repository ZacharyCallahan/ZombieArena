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
    private final ArcherQueenRadiusUpgradeGUI archerQueenRadiusUpgradeGUI = new ArcherQueenRadiusUpgradeGUI();
    private final ArcherQueenSpeedUpgradeGUI archerQueenSpeedUpgradeGUI = new ArcherQueenSpeedUpgradeGUI();

    Config config = new Config();

    private ConfigurationSection section;

    public Menu ArcherQueenGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27,
                ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.display-name") + ": " + "&7&lUpgrades")));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.archer-queen-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getArcherQueenPlaceHolderSlots(keys),
                        config.getArcherQueenPlaceHolderMaterialSection(keys));
        }
        menu.setButton(config.getArcherQueenPlaceHolderStatsSlots(), new Button(
                ItemBuilder.createItem(config.getArcherQueenGuiMaterial(),
                        config.getArcherQueenPlaceHolderStatsDisplayName(),
                        getArcherQueenStatsLore(player),
                        null,
                        null,
                        config.getArcherQueenPlaceHolderStatsEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
        menu.setButton(config.getArcherQueenHealthUpgradeGuiSlot(), new Button(
                ItemBuilder.createItem(config.getArcherQueenHealthUpgradeGuiMaterial(),
                        config.getArcherQueenHealthUpgradeGuiDisplayName(),
                        config.getArcherQueenHealthUpgradeGuiLore(),
                        null,
                        null,
                        config.getArcherQueenHealthUpgradeGuiEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                Player player = (Player) event.getWhoClicked();
                ZombieArena.getMenuHandler().closeMenu(player);
                ZombieArena.getMenuHandler().openMenu(player, archerQueenHealthUpgradeGUI.ArcherQueenHealthUpgradeGUI(player));
                event.setCancelled(true);
            }
        });
        menu.setButton(config.getArcherQueenRadiusUpgradeGuiSlot(), new Button(
                ItemBuilder.createItem(config.getArcherQueenRadiusUpgradeGuiMaterial(),
                        config.getArcherQueenRadiusUpgradeGuiDisplayName(),
                        config.getArcherQueenRadiusUpgradeGuiLore(),
                        null,
                        null,
                        config.getArcherQueenRadiusUpgradeGuiEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                Player player = (Player) event.getWhoClicked();
                ZombieArena.getMenuHandler().closeMenu(player);
                ZombieArena.getMenuHandler().openMenu(player, archerQueenRadiusUpgradeGUI.ArcherQueenRadiusUpgradeGUI(player));
                event.setCancelled(true);
            }
        });
        menu.setButton(config.getArcherQueenSpeedUpgradeGuiSlot(), new Button(
                ItemBuilder.createItem(config.getArcherQueenSpeedUpgradeGuiMaterial(),
                        config.getArcherQueenSpeedUpgradeGuiDisplayName(),
                        config.getArcherQueenSpeedUpgradeGuiLore(),
                        null,
                        null,
                        config.getArcherQueenSpeedUpgradeGuiEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                Player player = (Player) event.getWhoClicked();
                ZombieArena.getMenuHandler().closeMenu(player);
                ZombieArena.getMenuHandler().openMenu(player, archerQueenSpeedUpgradeGUI.ArcherQueenSpeedUpgradeGUI(player));
                event.setCancelled(true);
            }
        });
        return menu;
    }

    public List<String> getArcherQueenHealthStatsLore(Player player) {
        List<String> itemStatsPlaceHolderLore = new ArrayList<>();
        itemStatsPlaceHolderLore.add(ZombieArena.color(" "));
        itemStatsPlaceHolderLore.add(ZombieArena.color("&7&lHealth: &f&l" + archerQueenHealthUpgradeGUI.getPlayersArcherQueenHealth(player)));
        if (archerQueenHealthUpgradeGUI.getPlayersArcherQueenHealthUpgradeLevel(player) > 0)
            itemStatsPlaceHolderLore.add(ZombieArena.color("&7&lLevel: &f&l" + archerQueenHealthUpgradeGUI.getPlayersArcherQueenHealthUpgradeLevel(player)));
        return itemStatsPlaceHolderLore;
    }

    public List<String> getArcherQueenStatsLore(Player player) {
        //TODO add other stats
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("&7&lHealth: &f&l" + archerQueenHealthUpgradeGUI.getPlayersArcherQueenHealth(player));
        lore.add("&7&lRadius: &f&l" + archerQueenRadiusUpgradeGUI.getPlayersArcherQueenRadius(player));
        lore.add("&7&lSpeed: &f&l" + archerQueenSpeedUpgradeGUI.getPlayersArcherQueenSpeed(player));
        return lore;
    }

    public List<String> getArcherQueenRadiusStatsLore(Player player) {
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("&7&lRadius: &f&l" + archerQueenRadiusUpgradeGUI.getPlayersArcherQueenRadius(player));
        lore.add("&7&lLevel: &f&l" + archerQueenRadiusUpgradeGUI.getPlayersArcherQueenRadiusUpgradeLevel(player));
        return lore;
    }

    public List<String> getArcherQueenSpeedStatsLore(Player player) {
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("&7&lSpeed: &f&l" + archerQueenSpeedUpgradeGUI.getPlayersArcherQueenSpeed(player));
        lore.add("&7&lLevel: &f&l" + archerQueenSpeedUpgradeGUI.getPlayersArcherQueenSpeedUpgradeLevel(player));
        return lore;
    }
}
