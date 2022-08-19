package com.zach.zombiearena.gameplay.functions;

import com.zach.zombiearena.ZombieArena;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.UUID;

public class CannonListener extends CannonHandler implements Listener {

    @EventHandler
    public void cannonPurchase(PlayerInteractEvent e) {
        Player attacker = e.getPlayer();
        UUID defender = ZombieArena.getInstance().matchMaking.playersInGame.get(attacker.getUniqueId());
        Block clickedBlock = e.getClickedBlock();

        if (clickedBlock == null) return;
        if (defender == null) return;
        cannonShoot(attacker, defender, clickedBlock.getLocation());

    }

}

