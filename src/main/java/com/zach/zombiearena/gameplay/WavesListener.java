//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.zach.zombiearena.gameplay;

import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.arenas.Region;
import io.papermc.paper.event.entity.EntityMoveEvent;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCDeathEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.UUID;

import static com.zach.zombiearena.utils.ItemManager.moneyItem;

public class WavesListener implements Listener {

    @EventHandler
    public void zombieDeath(NPCDeathEvent e) {
        Player player = e.getEvent().getEntity().getKiller();
        NPC npc = e.getNPC();
        if (ZombieArena.getInstance().healerQueen.tasks.containsKey(player)) {
            Bukkit.getScheduler().cancelTask(ZombieArena.getInstance().healerQueen.tasks.get(player));
            ZombieArena.getInstance().healerQueen.tasks.remove(player);
        }
        if (ZombieArena.getInstance().barbarianKing.tasks.containsKey(player)) {
            Bukkit.getScheduler().cancelTask(ZombieArena.getInstance().barbarianKing.tasks.get(player));
            ZombieArena.getInstance().barbarianKing.tasks.remove(player);
        }
        if (ZombieArena.getInstance().archerQueen.tasks.containsKey(player)) {
            Bukkit.getScheduler().cancelTask(ZombieArena.getInstance().archerQueen.tasks.get(player));
            ZombieArena.getInstance().archerQueen.tasks.remove(player);
        }
        if (npc.getName().contains("Zombie")) {
            npc.destroy();
            if (player == null) return;
            player.getInventory().addItem(moneyItem);
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1, 1);

        }

    }

    @EventHandler
    public void zombieMove(EntityMoveEvent e) {
        NPC npc = CitizensAPI.getNPCRegistry().getNPC(e.getEntity());
        Region cancelRegion = null;
        if (npc == null) return;
        if (npc.getEntity() == null) return;
        if (npc.getName().contains("Zombie")) {
            for (UUID defenderUUID : ZombieArena.getInstance().matchMaking.playersInGame.values()) {
                if (ZombieArena.getInstance().regionHandler.cancelRegion.containsKey(defenderUUID)) {
                    cancelRegion = ZombieArena.getInstance().regionHandler.cancelRegion.get(defenderUUID);
                }
                if (cancelRegion != null && cancelRegion.containsLocation(npc.getEntity().getLocation())) {
                    ZombieArena.getInstance().waves.looseLife(npc);
                }
            }
        }
    }
}
