package com.zach.zombiearena.gameplay.guis.healerqueen;

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

public class HealerQueenGUI {
    private final HealerQueenHealthUpgradeGUI healerQueenHealthUpgradeGUI = new HealerQueenHealthUpgradeGUI();
    private final HealerQueenRadiusUpgradeGUI healerQueenRadiusUpgradeGUI = new HealerQueenRadiusUpgradeGUI();
    private final HealerQueenHealUpgradeGUI healerQueenHealUpgradeGUI = new HealerQueenHealUpgradeGUI();

    Config config = new Config();

    private ConfigurationSection section;

    public Menu HealerQueenGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27,
                ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.display-name") + ": " + "&7&lUpgrades")));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.healer-queen-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getHealerQueenPlaceHolderSlots(keys),
                        config.getHealerQueenPlaceHolderMaterialSection(keys));
        }
        menu.setButton(config.getHealerQueenPlaceHolderStatsSlots(), new Button(
                ItemBuilder.createItem(config.getHealerQueenGuiMaterial(),
                        config.getHealerQueenPlaceHolderStatsDisplayName(),
                        getHealerQueenStatsLore(player),
                        null,
                        null,
                        config.getHealerQueenPlaceHolderStatsEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });
        menu.setButton(config.getHealerQueenHealthUpgradeGuiSlot(), new Button(
                ItemBuilder.createItem(config.getHealerQueenHealthUpgradeGuiMaterial(),
                        config.getHealerQueenHealthUpgradeGuiDisplayName(),
                        config.getHealerQueenHealthUpgradeGuiLore(),
                        null,
                        null,
                        config.getHealerQueenHealthUpgradeGuiEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                Player player = (Player) event.getWhoClicked();
                ZombieArena.getMenuHandler().closeMenu(player);
                ZombieArena.getMenuHandler().openMenu(player, healerQueenHealthUpgradeGUI.HealerQueenHealthUpgradeGUI(player));
                event.setCancelled(true);
            }
        });
        menu.setButton(config.getHealerQueenRadiusUpgradeGuiSlot(), new Button(
                ItemBuilder.createItem(config.getHealerQueenRadiusUpgradeGuiMaterial(),
                        config.getHealerQueenRadiusUpgradeGuiDisplayName(),
                        config.getHealerQueenRadiusUpgradeGuiLore(),
                        null,
                        null,
                        config.getHealerQueenRadiusUpgradeGuiEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                Player player = (Player) event.getWhoClicked();
                ZombieArena.getMenuHandler().closeMenu(player);
                ZombieArena.getMenuHandler().openMenu(player, healerQueenRadiusUpgradeGUI.HealerQueenRadiusUpgradeGUI(player));
                event.setCancelled(true);
            }
        });
        menu.setButton(config.getHealerQueenHealUpgradeGuiSlot(), new Button(
                ItemBuilder.createItem(config.getHealerQueenHealUpgradeGuiMaterial(),
                        config.getHealerQueenHealUpgradeGuiDisplayName(),
                        config.getHealerQueenHealUpgradeGuiLore(),
                        null,
                        null,
                        config.getHealerQueenHealUpgradeGuiEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                Player player = (Player) event.getWhoClicked();
                ZombieArena.getMenuHandler().closeMenu(player);
                ZombieArena.getMenuHandler().openMenu(player, healerQueenHealUpgradeGUI.HealerQueenHealUpgradeGUI(player));
                event.setCancelled(true);
            }
        });
        return menu;
    }

    public List<String> getHealerQueenHealthStatsLore(Player player) {
        List<String> itemStatsPlaceHolderLore = new ArrayList<>();
        itemStatsPlaceHolderLore.add(ZombieArena.color(" "));
        itemStatsPlaceHolderLore.add(ZombieArena.color("&7&lHealth: &f&l" + healerQueenHealthUpgradeGUI.getPlayersHealerQueenHealth(player)));
        if (healerQueenHealthUpgradeGUI.getPlayersHealerQueenHealthUpgradeLevel(player) > 0)
            itemStatsPlaceHolderLore.add(ZombieArena.color("&7&lLevel: &f&l" + healerQueenHealthUpgradeGUI.getPlayersHealerQueenHealthUpgradeLevel(player)));
        return itemStatsPlaceHolderLore;
    }

    public List<String> getHealerQueenStatsLore(Player player) {
        //TODO add other stats
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("&7&lHealth: &f&l" + healerQueenHealthUpgradeGUI.getPlayersHealerQueenHealth(player));
        lore.add("&7&lRadius: &f&l" + healerQueenRadiusUpgradeGUI.getPlayersHealerQueenRadius(player));
        lore.add("&7&lHeal-Amount: &f&l" + healerQueenHealUpgradeGUI.getPlayersHealerQueenHeal(player));
        return lore;
    }

    public List<String> getHealerQueenRadiusStatsLore(Player player) {
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("&7&lRadius: &f&l" + healerQueenRadiusUpgradeGUI.getPlayersHealerQueenRadius(player));
        lore.add("&7&lLevel: &f&l" + healerQueenRadiusUpgradeGUI.getPlayersHealerQueenRadiusUpgradeLevel(player));
        return lore;
    }

    public List<String> getHealerQueenHealStatsLore(Player player) {
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("&7&lHeal-Amount: &f&l" + healerQueenHealUpgradeGUI.getPlayersHealerQueenHeal(player));
        lore.add("&7&lLevel: &f&l" + healerQueenHealUpgradeGUI.getPlayersHealerQueenHealUpgradeLevel(player));
        return lore;
    }

}
