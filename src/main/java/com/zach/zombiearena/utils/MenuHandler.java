package com.zach.zombiearena.utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MenuHandler {
    private final ConcurrentHashMap<UUID, Menu> openMenus = new ConcurrentHashMap<>();

    public void refreshMenu(Player player, Menu menu) {

        closeMenu(player);
        openMenu(player, menu);

    }

    public void openMenu(Player player, Menu menu) {
        this.openMenus.put(player.getUniqueId(), menu);
        menu.open(player);
    }

    public void closeMenu(Player player) {
        if (!openedMenu(player))
            return;
        this.openMenus.remove(player.getUniqueId());
        player.closeInventory();
    }

    public boolean openedMenu(Player player) {
        if (!this.openMenus.isEmpty())
            return this.openMenus.containsKey(player.getUniqueId());
        return false;
    }

    public Menu getMenu(Player player) {
        return this.openMenus.get(player.getUniqueId());
    }

    public void closeAll() {
        for (UUID uuid : this.openMenus.keySet()) {
            Player player = Bukkit.getPlayer(uuid);
            closeMenu(player);
            player.closeInventory();
        }
    }

    public Listener getListeners() {
        return new Listener() {
            @EventHandler
            public void onInventoryClick(InventoryClickEvent e) {
                if (e.getClickedInventory() == null)
                    return;
                Player player = (Player) e.getWhoClicked();
                if (!MenuHandler.this.openedMenu(player))
                    return;
                Menu menu = MenuHandler.this.openMenus.get(player.getUniqueId());
                if (e.getClickedInventory().equals(e.getView().getTopInventory()))
                    menu.performClick(menu, e);
            }

            @EventHandler
            public void onInventoryClose(InventoryCloseEvent e) {
                Player player = (Player) e.getPlayer();
                if (MenuHandler.this.openedMenu((Player) e.getPlayer()))
                    MenuHandler.this.closeMenu(player);
            }

            @EventHandler
            public void onPlayerLeave(PlayerQuitEvent e) {
                if (MenuHandler.this.openedMenu(e.getPlayer()))
                    MenuHandler.this.closeMenu(e.getPlayer());
            }

            @EventHandler
            public void onPlayerDeath(PlayerDeathEvent e) {
                if (MenuHandler.this.openedMenu(e.getEntity()))
                    MenuHandler.this.closeMenu(e.getEntity());
            }
        };
    }

    public void createPlaceholders(Menu menu, ConfigurationSection section, List<Integer> slots, String materialSection) {
        if (section != null)
            menu.setButtons(slots, new Button(ItemBuilder.createItem(materialSection, " ", null, null, null, false)) {
                public void onClick(Menu menu, InventoryClickEvent event) {
                    event.setCancelled(true);
                }
            });
    }
}
