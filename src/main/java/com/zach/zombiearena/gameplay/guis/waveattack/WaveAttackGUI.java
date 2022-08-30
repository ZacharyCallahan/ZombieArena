package com.zach.zombiearena.gameplay.guis.waveattack;

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

public class WaveAttackGUI {
    private final WaveAttackUpgradeGUI waveAttackUpgradeGUI = new WaveAttackUpgradeGUI();

    Config config = new Config();

    private ConfigurationSection section;

    public Menu WaveAttackGUI(Player player) {
        Menu menu = new Menu(Bukkit.createInventory(null, 27,
                ZombieArena.color(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.display-name") + ": " + "&7&lUpgrades")));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.wave-attack-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null)
                ZombieArena.getMenuHandler().createPlaceholders(menu, section,
                        config.getWaveAttackPlaceHolderSlots(keys),
                        config.getWaveAttackPlaceHolderMaterialSection(keys));
        }
        menu.setButton(config.getWaveAttackPlaceHolderStatsSlots(), new Button(
                ItemBuilder.createItem(config.getWaveAttackGuiMaterial(),
                        config.getWaveAttackPlaceHolderStatsDisplayName(),
                        getWaveAttackStatsLore(player),
                        null,
                        null,
                        config.getWaveAttackPlaceHolderStatsEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                event.setCancelled(true);
            }
        });

        menu.setButton(config.getWaveAttackUpgradeGuiSlot(), new Button(
                ItemBuilder.createItem(config.getWaveAttackUpgradeGuiMaterial(),
                        config.getWaveAttackUpgradeGuiDisplayName(),
                        config.getWaveAttackUpgradeGuiLore(),
                        null,
                        null,
                        config.getWaveAttackUpgradeGuiEnchanted())) {
            @Override
            public void onClick(Menu menu, InventoryClickEvent event) {
                Player player = (Player) event.getWhoClicked();
                ZombieArena.getMenuHandler().closeMenu(player);
                ZombieArena.getMenuHandler().openMenu(player, waveAttackUpgradeGUI.WaveAttackUpgradeGUI(player));
                event.setCancelled(true);
            }
        });

        return menu;
    }


    public List<String> getWaveAttackStatsLore(Player player) {
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("&7&lAmount: &f&l" + waveAttackUpgradeGUI.getPlayersWaveAttack(player));
        lore.add("&7&lLevel: &f&l" + waveAttackUpgradeGUI.getPlayersWaveAttackUpgradeLevel(player));
        return lore;
    }
}
