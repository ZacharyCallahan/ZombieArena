package com.zach.zombiearena.gameplay.guis;

import com.zach.zombiearena.Config;
import com.zach.zombiearena.EconomyHandler;
import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.gameplay.guis.archerqueen.ArcherQueenGUI;
import com.zach.zombiearena.gameplay.guis.barbarianking.BarbarianKingGUI;
import com.zach.zombiearena.gameplay.guis.healerqueen.HealerQueenGUI;
import com.zach.zombiearena.gameplay.guis.regularmob.RegularMobGUI;
import com.zach.zombiearena.gameplay.guis.waveattack.WaveAttackGUI;
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
    private final BarbarianKingGUI barbarianKingGUI = new BarbarianKingGUI();
    private final HealerQueenGUI healerQueenGUI = new HealerQueenGUI();
    private final RegularMobGUI regularMobGUI = new RegularMobGUI();
    private final WaveAttackGUI waveAttackGUI = new WaveAttackGUI();
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
                                    "archerQueen",
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

        //if they have purchased the Barbarian King
        if (ZombieArena.getInstance().barbarianKing.purchasedBarbarianKing.get(player.getUniqueId()) != null) {
            if (ZombieArena.getInstance().barbarianKing.purchasedBarbarianKing.get(player.getUniqueId())) {
                menu.setButton(ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.slot"), new Button(
                        ItemBuilder.createItem(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.material"),
                                ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.display-name"),
                                ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.lore"),
                                null,
                                null,
                                ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.barbarian-king-gui.enchanted"))) {
                    public void onClick(Menu menu, InventoryClickEvent event) {
                        Player player = (Player) event.getWhoClicked();
                        ZombieArena.getMenuHandler().closeMenu(player);
                        ZombieArena.getMenuHandler().openMenu(player, barbarianKingGUI.BarbarianKingGUI(player));
                        event.setCancelled(true);
                    }
                });

                //if they havent purchased the Barbarian King
            } else {
                menu.setButton(ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.slot"), new Button(

                        ItemBuilder.createItem(config.getBarbarianKingPurchaseMaterial(),
                                ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.display-name"),
                                null,
                                config.getBarbarianKingPurchaseLore(),
                                null,
                                config.getBarbarianKingPurchaseEnchanted())) {
                    @Override
                    public void onClick(Menu menu, InventoryClickEvent event) {
                        Player player = (Player) event.getWhoClicked();
                        if (EconomyHandler.hasEnoughMoney(player, config.getBarbarianKingPurchaseCost())) {
                            upgradeGUIHandler.defensePurchased(player,
                                    "barbarianKing",
                                    config.getBarbarianKingPurchaseCost(),
                                    ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.display-name"));
                            refreshMenu(player);
                        } else {
                            upgradeGUIHandler.upgradeFailed(player, config.getBarbarianKingPurchaseCost());
                        }
                        event.setCancelled(true);
                    }
                });
            }
        } else {
            Messages.sendMessage(player, "arenaNoArena");
        }
        //if they have purchased the Healer Queen
        if (ZombieArena.getInstance().healerQueen.purchasedHealerQueen.get(player.getUniqueId()) != null) {
            if (ZombieArena.getInstance().healerQueen.purchasedHealerQueen.get(player.getUniqueId())) {
                menu.setButton(ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.slot"), new Button(
                        ItemBuilder.createItem(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.material"),
                                ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.display-name"),
                                ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.lore"),
                                null,
                                null,
                                ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.healer-queen-gui.enchanted"))) {
                    public void onClick(Menu menu, InventoryClickEvent event) {
                        Player player = (Player) event.getWhoClicked();
                        ZombieArena.getMenuHandler().closeMenu(player);
                        ZombieArena.getMenuHandler().openMenu(player, healerQueenGUI.HealerQueenGUI(player));
                        event.setCancelled(true);
                    }
                });

                //if they havent purchased the Healer Queen
            } else {
                menu.setButton(ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.slot"), new Button(

                        ItemBuilder.createItem(config.getHealerQueenPurchaseMaterial(),
                                ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.display-name"),
                                null,
                                config.getHealerQueenPurchaseLore(),
                                null,
                                config.getHealerQueenPurchaseEnchanted())) {
                    @Override
                    public void onClick(Menu menu, InventoryClickEvent event) {
                        Player player = (Player) event.getWhoClicked();
                        if (EconomyHandler.hasEnoughMoney(player, config.getHealerQueenPurchaseCost())) {
                            upgradeGUIHandler.defensePurchased(player,
                                    "healerQueen",
                                    config.getHealerQueenPurchaseCost(),
                                    ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.display-name"));
                            refreshMenu(player);
                        } else {
                            upgradeGUIHandler.upgradeFailed(player, config.getHealerQueenPurchaseCost());
                        }
                        event.setCancelled(true);
                    }
                });
            }
        } else {
            Messages.sendMessage(player, "arenaNoArena");
        }
        menu.setButton(ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.regular-mob-gui.slot"), new Button(
                ItemBuilder.createItem(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.material"),
                        ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.display-name"),
                        ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.regular-mob-gui.lore"),
                        null,
                        null,
                        ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.regular-mob-gui.enchanted"))) {
            public void onClick(Menu menu, InventoryClickEvent event) {
                Player player = (Player) event.getWhoClicked();
                ZombieArena.getMenuHandler().closeMenu(player);
                ZombieArena.getMenuHandler().openMenu(player, regularMobGUI.RegularMobGUI(player));
                event.setCancelled(true);
            }
        });
        //if they have purchased the Wave Attack
        if (ZombieArena.getInstance().waveAttack.purchasedWaveAttack.get(player.getUniqueId()) != null) {
            if (ZombieArena.getInstance().waveAttack.purchasedWaveAttack.get(player.getUniqueId())) {
                menu.setButton(ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.wave-attack-gui.slot"), new Button(
                        ItemBuilder.createItem(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.material"),
                                ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.display-name"),
                                ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.wave-attack-gui.lore"),
                                null,
                                null,
                                ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.wave-attack-gui.enchanted"))) {
                    public void onClick(Menu menu, InventoryClickEvent event) {
                        Player player = (Player) event.getWhoClicked();
                        ZombieArena.getMenuHandler().closeMenu(player);
                        ZombieArena.getMenuHandler().openMenu(player, waveAttackGUI.WaveAttackGUI(player));
                        event.setCancelled(true);
                    }
                });

                //if they havent purchased the Wave Attack
            } else {
                menu.setButton(ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.wave-attack-gui.slot"), new Button(

                        ItemBuilder.createItem(config.getWaveAttackPurchaseMaterial(),
                                ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.display-name"),
                                null,
                                config.getWaveAttackPurchaseLore(),
                                null,
                                config.getWaveAttackPurchaseEnchanted())) {
                    @Override
                    public void onClick(Menu menu, InventoryClickEvent event) {
                        Player player = (Player) event.getWhoClicked();
                        if (EconomyHandler.hasEnoughMoney(player, config.getWaveAttackPurchaseCost())) {
                            upgradeGUIHandler.defensePurchased(player,
                                    "waveAttack",
                                    config.getWaveAttackPurchaseCost(),
                                    ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.display-name"));
                            refreshMenu(player);
                        } else {
                            upgradeGUIHandler.upgradeFailed(player, config.getWaveAttackPurchaseCost());
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
