package com.zach.zombiearena.gameplay;

import com.zach.zombiearena.ZombieArena;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

public class NpcHandler {

    HashMap<UUID, NPC> traders = new HashMap<>();

    public void spawnTrader(UUID defender, Player attacker) {
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.VILLAGER, ChatColor.translateAlternateColorCodes('&', "&6&lTrader"));
        npc.spawn(ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(33.0D, 4.0D, 5.0D));
        npc.faceLocation(ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(32.0D, 4.0D, 5.0D));
        traders.put(attacker.getUniqueId(), npc);
    }

    public void destroyRemainingNPCs(String npcName) {
        for (NPCRegistry npcReg : CitizensAPI.getNPCRegistries()) {
            Iterator npcIter = npcReg.sorted().iterator();
            for (Iterator it = npcIter; it.hasNext(); ) {
                NPC npc = (NPC) it.next();
                if (npc.getName().contains(npcName)) npc.destroy();
            }
        }
    }

    public void destroyTraderNPC(UUID attackerUUID) {
        traders.get(attackerUUID).destroy();
    }
}
