package com.zach.zombiearena.arenas;

import com.zach.zombiearena.ZombieArena;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class RegionListener implements Listener {
    public RegionListener() {
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        Region cancelRegion = null;
        if (!player.hasPermission("zombiearena.region.arena.bypass")) {
            if (ZombieArena.getInstance().regionHandler.cancelRegion.containsKey(player.getUniqueId())) {
                cancelRegion = ZombieArena.getInstance().regionHandler.cancelRegion.get(player.getUniqueId());
            }
            if (cancelRegion != null && cancelRegion.containsLocation(player.getLocation())) {
                ZombieArena.getInstance().regionHandler.tpArenaSpawn(player);
            }

        }

    }

    @EventHandler
    public void inGameMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        Region cancelRegion = null;
        if (!player.hasPermission("zombiearena.region.arena.bypass")) {
            if (ZombieArena.getInstance().regionHandler.cancelRegion.containsKey(ZombieArena.getInstance().matchMaking.playersInGame.get(player.getUniqueId()))) {
                cancelRegion = ZombieArena.getInstance().regionHandler.cancelRegion.get(ZombieArena.getInstance().matchMaking.playersInGame.get(player.getUniqueId()));
            }
            if (cancelRegion != null && cancelRegion.containsLocation(player.getLocation())) {
                player.teleport(player.getLocation().add(4, 0, 0));
            }
        }
    }


}