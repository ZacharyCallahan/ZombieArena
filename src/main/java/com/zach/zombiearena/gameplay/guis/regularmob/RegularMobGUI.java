package com.zach.zombiearena.gameplay.guis.regularmob;

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

public class RegularMobGUI {
    private final RegularMobArmorUpgradeGUI regularMobArmorUpgradeGUI = new RegularMobArmorUpgradeGUI();

    Config config = new Config();

    private ConfigurationSection section;

    public Menu RegularMobGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27,
                ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.display-name") + ": " + "&7&lUpgrades")));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.regular-mob-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getRegularMobPlaceHolderSlots(keys),
                        config.getRegularMobPlaceHolderMaterialSection(keys));
        }
        menu.setButton(config.getRegularMobPlaceHolderStatsSlots(), new Button(
                ItemBuilder.createItem(config.getRegularMobGuiMaterial(),
                        config.getRegularMobPlaceHolderStatsDisplayName(),
                        getRegularMobStatsLore(player),
                        null,
                        null,
                        config.getRegularMobPlaceHolderStatsEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });

        menu.setButton(config.getRegularMobArmorUpgradeGuiSlot(), new Button(
                ItemBuilder.createItem(config.getRegularMobArmorUpgradeGuiMaterial(),
                        config.getRegularMobArmorUpgradeGuiDisplayName(),
                        config.getRegularMobArmorUpgradeGuiLore(),
                        null,
                        null,
                        config.getRegularMobArmorUpgradeGuiEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                Player player = (Player) event.getWhoClicked();
                ZombieArena.getMenuHandler().closeMenu(player);
                ZombieArena.getMenuHandler().openMenu(player, regularMobArmorUpgradeGUI.RegularMobArmorUpgradeGUI(player));
                event.setCancelled(true);
            }
        });

        return menu;
    }

    public List<String> getRegularMobStatsLore(Player player) {
        //TODO add other stats
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("&7&lArmor: &f&l" + regularMobArmorUpgradeGUI.getPlayersRegularMobArmor(player));
        return lore;
    }

    public List<String> getRegularMobArmorStatsLore(Player player) {
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("&7&lArmor: &f&l" + regularMobArmorUpgradeGUI.getPlayersRegularMobArmor(player));
        lore.add("&7&lLevel: &f&l" + regularMobArmorUpgradeGUI.getPlayersRegularMobArmorUpgradeLevel(player));
        return lore;
    }
}
