package com.zach.zombiearena.gameplay.guis;

import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.utils.Button;
import com.zach.zombiearena.utils.ItemBuilder;
import com.zach.zombiearena.utils.Menu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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

import static com.zach.zombiearena.utils.ItemManager.getMoneyItemMaterial;
import static com.zach.zombiearena.utils.ItemManager.moneyItem;

public class TraderGUI implements Listener {
    ConfigurationSection section;

    public Menu traderGUI() {

        Menu menu = new Menu(Bukkit.createInventory(null, 27, "Trader GUI"));

        //PlaceHolders
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("tradergui.placeholders");
        if (section != null) {
            for (String keys : section.getKeys(false)) {
                if (keys != null) {
                    menu.setButtons(ZombieArena.getInstance().getConfig().getIntegerList("tradergui.placeholders." + keys + ".slots"),
                            new Button(ItemBuilder.createItem(Material.valueOf(ZombieArena.getInstance().getConfig().getString("tradergui.placeholders." + keys + ".material")),
                                    ZombieArena.getInstance().getConfig().getString("tradergui.placeholders." + keys + ".displayname"),
                                    null,
                                    null,
                                    null,
                                    false)) {
                        @Override
                        public void onClick(Menu menu, InventoryClickEvent event) {
                            event.setCancelled(true);

                        }
                    });
                }
            }
        }


        //purchasable Items
        section = ZombieArena.getInstance().getConfig().getConfigurationSection("tradergui.purchaseable");
        if (section != null) {
            for (String keys : section.getKeys(false)) {
                if (keys != null) {

                    List<String> guiLore = new ArrayList<>();
                    guiLore.add("");
                    guiLore.add(ZombieArena.color("&eClick to Purchase"));
                    guiLore.add(ZombieArena.color("&2Cost&f: &6 " + ZombieArena.getInstance().getConfig().getInt("tradergui.purchaseable." + keys + ".cost") +  " gold"));

                    menu.setButton(ZombieArena.getInstance().getConfig().getInt("tradergui.purchaseable." + keys + ".slot"), new Button(ItemBuilder.createItem(
                            Material.valueOf(ZombieArena.getInstance().getConfig().getString("tradergui.purchaseable." + keys + ".material")),
                            ZombieArena.getInstance().getConfig().getString("tradergui.purchaseable." + keys + ".displayname"),
                            guiLore,
                            null,
                            ZombieArena.getInstance().getConfig().getStringList("tradergui.purchaseable." + keys + ".enchants"),
                            false)) {
                        @Override
                        public void onClick(Menu menu, InventoryClickEvent event) {
                            Player player = (Player) event.getWhoClicked();
                            if (player.getInventory().containsAtLeast(moneyItem,
                                    ZombieArena.getInstance().getConfig().getInt("tradergui.purchaseable." + keys + ".cost"))) {
                                player.getInventory().removeItem(new ItemStack(getMoneyItemMaterial(),
                                        ZombieArena.getInstance().getConfig().getInt("tradergui.purchaseable." + keys + ".cost")));

                                player.getInventory().addItem(ItemBuilder.createItem(
                                        Material.valueOf(ZombieArena.getInstance().getConfig().getString("tradergui.purchaseable." + keys + ".material")),
                                        ZombieArena.getInstance().getConfig().getString("tradergui.purchaseable." + keys + ".displayname"),
                                        null,
                                        ZombieArena.getInstance().getConfig().getStringList("tradergui.purchaseable." + keys + ".lore"),
                                        ZombieArena.getInstance().getConfig().getStringList("tradergui.purchaseable." + keys + ".enchants"),
                                        false));
                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                            } else {
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
                                Messages.sendMessage(player, "functionPurchaseFail");
                            }
                            event.setCancelled(true);
                        }
                    });
                    guiLore.clear();
                }
            }
        }

        return menu;
    }

    @EventHandler
    public void tradeInteract(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains(ChatColor.translateAlternateColorCodes('&', "&6&lTrader"))) {
            ZombieArena.getMenuHandler().openMenu(e.getPlayer(), traderGUI());
        }
    }

}
