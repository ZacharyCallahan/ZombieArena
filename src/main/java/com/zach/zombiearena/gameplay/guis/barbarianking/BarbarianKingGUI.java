package com.zach.zombiearena.gameplay.guis.barbarianking;

import com.zach.zombiearena.Config;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.utils.Button;
import com.zach.zombiearena.utils.ItemBuilder;
import com.zach.zombiearena.utils.Menu;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.List;

public class BarbarianKingGUI {
    private final BarbarianKingHealthUpgradeGUI barbarianKingHealthUpgradeGUI = new BarbarianKingHealthUpgradeGUI();
    private final BarbarianKingRadiusUpgradeGUI barbarianKingRadiusUpgradeGUI = new BarbarianKingRadiusUpgradeGUI();
    private final BarbarianKingArmorUpgradeGUI barbarianKingArmorUpgradeGUI = new BarbarianKingArmorUpgradeGUI();

    Config config = new Config();

    private ConfigurationSection section;

    public Menu BarbarianKingGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27,
                ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.display-name") + ": " + "&7&lUpgrades")));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.barbarian-king-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getBarbarianKingPlaceHolderSlots(keys),
                        config.getBarbarianKingPlaceHolderMaterialSection(keys));
        }
        menu.setButton(config.getBarbarianKingPlaceHolderStatsSlots(), new Button(
                ItemBuilder.createItem(config.getBarbarianKingGuiMaterial(),
                        config.getBarbarianKingPlaceHolderStatsDisplayName(),
                        getBarbarianKingStatsLore(player),
                        null,
                        null,
                        config.getBarbarianKingPlaceHolderStatsEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
        menu.setButton(config.getBarbarianKingHealthUpgradeGuiSlot(), new Button(
                ItemBuilder.createItem(config.getBarbarianKingHealthUpgradeGuiMaterial(),
                        config.getBarbarianKingHealthUpgradeGuiDisplayName(),
                        config.getBarbarianKingHealthUpgradeGuiLore(),
                        null,
                        null,
                        config.getBarbarianKingHealthUpgradeGuiEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                Player player = (Player) event.getWhoClicked();
                ZombieArena.getMenuHandler().closeMenu(player);
                ZombieArena.getMenuHandler().openMenu(player, barbarianKingHealthUpgradeGUI.BarbarianKingHealthUpgradeGUI(player));
                event.setCancelled(true);
            }
        });
        menu.setButton(config.getBarbarianKingRadiusUpgradeGuiSlot(), new Button(
                ItemBuilder.createItem(config.getBarbarianKingRadiusUpgradeGuiMaterial(),
                        config.getBarbarianKingRadiusUpgradeGuiDisplayName(),
                        config.getBarbarianKingRadiusUpgradeGuiLore(),
                        null,
                        null,
                        config.getBarbarianKingRadiusUpgradeGuiEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                Player player = (Player) event.getWhoClicked();
                ZombieArena.getMenuHandler().closeMenu(player);
                ZombieArena.getMenuHandler().openMenu(player, barbarianKingRadiusUpgradeGUI.BarbarianKingRadiusUpgradeGUI(player));
                event.setCancelled(true);
            }
        });

        menu.setButton(config.getBarbarianKingArmorUpgradeGuiSlot(), new Button(
                ItemBuilder.createItem(config.getBarbarianKingArmorUpgradeGuiMaterial(),
                        config.getBarbarianKingArmorUpgradeGuiDisplayName(),
                        config.getBarbarianKingArmorUpgradeGuiLore(),
                        null,
                        null,
                        config.getBarbarianKingArmorUpgradeGuiEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                Player player = (Player) event.getWhoClicked();
                ZombieArena.getMenuHandler().closeMenu(player);
                ZombieArena.getMenuHandler().openMenu(player, barbarianKingArmorUpgradeGUI.BarbarianKingArmorUpgradeGUI(player));
                event.setCancelled(true);
            }
        });

        return menu;
    }

    public List<String> getBarbarianKingHealthStatsLore(Player player) {
        List<String> itemStatsPlaceHolderLore = new ArrayList<>();
        itemStatsPlaceHolderLore.add(ZombieArena.color(" "));
        itemStatsPlaceHolderLore.add(ZombieArena.color("&7&lHealth: &f&l" + barbarianKingHealthUpgradeGUI.getPlayersBarbarianKingHealth(player)));
        if (barbarianKingHealthUpgradeGUI.getPlayersBarbarianKingHealthUpgradeLevel(player) > 0)
            itemStatsPlaceHolderLore.add(ZombieArena.color("&7&lLevel: &f&l" + barbarianKingHealthUpgradeGUI.getPlayersBarbarianKingHealthUpgradeLevel(player)));
        return itemStatsPlaceHolderLore;
    }

    public List<String> getBarbarianKingStatsLore(Player player) {
        //TODO add other stats
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("&7&lHealth: &f&l" + barbarianKingHealthUpgradeGUI.getPlayersBarbarianKingHealth(player));
        lore.add("&7&lRadius: &f&l" + barbarianKingRadiusUpgradeGUI.getPlayersBarbarianKingRadius(player));
        lore.add("&7&lArmor: &f&l" + barbarianKingArmorUpgradeGUI.getPlayersBarbarianKingArmor(player));
        return lore;
    }

    public List<String> getBarbarianKingRadiusStatsLore(Player player) {
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("&7&lRadius: &f&l" + barbarianKingRadiusUpgradeGUI.getPlayersBarbarianKingRadius(player));
        lore.add("&7&lLevel: &f&l" + barbarianKingRadiusUpgradeGUI.getPlayersBarbarianKingRadiusUpgradeLevel(player));
        return lore;
    }

    public List<String> getBarbarianKingArmorStatsLore(Player player) {
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("&7&lArmor: &f&l" + barbarianKingArmorUpgradeGUI.getPlayersBarbarianKingArmor(player));
        lore.add("&7&lLevel: &f&l" + barbarianKingArmorUpgradeGUI.getPlayersBarbarianKingArmorUpgradeLevel(player));
        return lore;
    }
}
