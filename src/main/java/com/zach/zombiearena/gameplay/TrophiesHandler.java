package com.zach.zombiearena.gameplay;

import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class TrophiesHandler {

    public HashMap<UUID, Integer> trophies = new HashMap<>();

    public void addTrophies(Player attacker) {
        Random random = new Random();

        int low = ZombieArena.getInstance().getConfig().getInt("trophies.gain-amount.low");
        int high = ZombieArena.getInstance().getConfig().getInt("trophies.gain-amount.high");
        int result = random.nextInt(high-low) + low;
        int playersTrophies = trophies.get(attacker.getUniqueId());

        Messages.sendTrophyGainMessage(attacker, result, "waveGameOverAddTrophies");

        trophies.remove(attacker.getUniqueId());
        trophies.put(attacker.getUniqueId(), result + playersTrophies);
    }

    public void removeTrophies(Player attacker) {
        if (trophies.get(attacker.getUniqueId()) == 0) {
            Messages.sendMessage(attacker, "waveNoTrophiesToLoose");
            return;
        }
        Random random = new Random();

        int low = ZombieArena.getInstance().getConfig().getInt("trophies.loss-amount.low");
        int high = ZombieArena.getInstance().getConfig().getInt("trophies.loss-amount.high");
        int result = random.nextInt(high-low) + low;
        int playersTrophies = trophies.get(attacker.getUniqueId());

        Messages.sendTrophyGainMessage(attacker, result, "waveGameOverLoseTrophies");

        trophies.remove(attacker.getUniqueId());
        trophies.put(attacker.getUniqueId(), result + playersTrophies);
    }

}
