package com.zach.zombiearena.gameplay.guis;

import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.utils.Button;
import com.zach.zombiearena.utils.ItemBuilder;
import com.zach.zombiearena.utils.ItemManager;
import com.zach.zombiearena.utils.Menu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class TraderGUI implements Listener {
    ConfigurationSection section;

    public Menu traderGUI() {
        Menu menu = new Menu(Bukkit.createInventory(null, 27, "Trader GUI"));
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("tradergui.placeholders");
        if (section != null)
            for (String keys : section.getKeys(false)) {
                if (keys != null)
                    menu.setButtons(ZombieArena.getInstance().getConfig().getIntegerList("tradergui.placeholders." + keys + ".slots"), new Button(
                            ItemBuilder.createItem(ZombieArena.getInstance().getConfig().getString("tradergui.placeholders." + keys + ".material"), " ", null, null, null, false)) {
                        public void onClick(Menu menu, InventoryClickEvent event) {
                            event.setCancelled(true);
                        }
                    });
            }
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("tradergui.purchaseable");
        if (section != null)
            for (String keys : section.getKeys(false)) {
                if (keys != null) {
                    List<String> guiLore = new ArrayList<>();
                    guiLore.add("");
                    guiLore.add(ZombieArena.color("&eClick to Purchase"));
                    guiLore.add(ZombieArena.color("&2Cost&f: &6 " + ZombieArena.getInstance().getConfig().getInt("tradergui.purchaseable." + keys + ".cost") + " gold"));
                    menu.setButton(ZombieArena.getInstance().getConfig().getInt("tradergui.purchaseable." + keys + ".slot"), new Button(ItemBuilder.createItem(
                            ZombieArena.getInstance().getConfig().getString("tradergui.purchaseable." + keys + ".material"),
                            ZombieArena.getInstance().getConfig().getString("tradergui.purchaseable." + keys + ".display-name"), guiLore, null,

                            ZombieArena.getInstance().getConfig().getStringList("tradergui.purchaseable." + keys + ".enchants"), false)) {
                        public void onClick(Menu menu, InventoryClickEvent event) {
                            Player player = (Player) event.getWhoClicked();
                            if (player.getInventory().containsAtLeast(ItemManager.moneyItem,
                                    ZombieArena.getInstance().getConfig().getInt("tradergui.purchaseable." + keys + ".cost"))) {
                                player.getInventory().removeItem(new ItemStack(ItemManager.getMoneyItemMaterial(),
                                        ZombieArena.getInstance().getConfig().getInt("tradergui.purchaseable." + keys + ".cost")));
                                player.getInventory().addItem(ItemBuilder.createItem(
                                        ZombieArena.getInstance().getConfig().getString("tradergui.purchaseable." + keys + ".material"),
                                        ZombieArena.getInstance().getConfig().getString("tradergui.purchaseable." + keys + ".display-name"), null,

                                        ZombieArena.getInstance().getConfig().getStringList("tradergui.purchaseable." + keys + ".lore"),
                                        ZombieArena.getInstance().getConfig().getStringList("tradergui.purchaseable." + keys + ".enchants"), false));
                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
                            } else {
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0F, 1.0F);
                                Messages.sendMessage(player, "functionPurchaseFail");
                            }
                            event.setCancelled(true);
                        }
                    });
                    guiLore.clear();
                }
            }
        return menu;
    }

    @EventHandler
    public void tradeInteract(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains(ChatColor.translateAlternateColorCodes('&', "&6&lTrader")))
            ZombieArena.getMenuHandler().openMenu(e.getPlayer(), traderGUI());
    }
}
