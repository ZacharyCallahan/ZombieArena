package com.zach.zombiearena.gameplay.guis.archerqueen;

import com.zach.zombiearena.Config;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.utils.Button;
import com.zach.zombiearena.utils.ItemBuilder;
import com.zach.zombiearena.utils.Menu;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import static com.zach.zombiearena.EconomyHandler.hasEnoughMoney;
import static com.zach.zombiearena.EconomyHandler.withDrawMoney;

public class ArcherQueenHealthUpgradeGUI {

    Config config = new Config();
    private ConfigurationSection section;

    public Menu ArcherQueenHealthUpgradeGUI() {

        Menu menu = new Menu(Bukkit.createInventory(null, 27, "Archer Queen Health Upgrade GUI"));


        //placeholders
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.archer-queen-gui.placeholders");
        for (String keys : section.getKeys(false)) {
            if (keys != null) {
                ZombieArena.getMenuHandler().createPlaceholders(
                        menu,
                        section,
                        config.getArcherQueenPlaceHolderSlots(keys),
                        config.getArcherQueenPlaceHolderMaterialSection(keys));

            }
        }

        //level one upgrade
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("defensegui.upgrades.archer-queen-gui.health-upgrade-level-one-gui");
        if (section != null) {
            menu.setButton(config.getArcherQueenHealthUpgradeLevelOneSlot(), new Button(
                    ItemBuilder.createItem(
                            config.getArcherQueenHealthUpgradeLevelOneMaterial(),
                            config.getArcherQueenHealthUpgradeLevelOneMaterialSection(),
                            config.getArcherQueenHealthUpgradeLevelOneDisplayName(),
                            config.getArcherQueenHealthUpgradeLevelOneLore(),
                            null,
                            null,
                            false)) {
                @Override
                public void onClick(Menu menu, InventoryClickEvent event) {
                    Player player = (Player) event.getWhoClicked();
                    if (hasEnoughMoney(player, config.getArcherQueenhealthUpgradeLevelOneCost())) {
                        withDrawMoney(player, config.getArcherQueenhealthUpgradeLevelOneCost());
                        ZombieArena.getInstance().waves.archerQueenHealthUpgradeLevel.put(player.getUniqueId(), 1);

                        //TODO send message to player
                    }

                    event.setCancelled(true);
                }
            });

        }

        //TODO add other upgrade Levels

        //level two upgrade

        //level three upgrade

        //level four upgrade

        return menu;
    }
}
