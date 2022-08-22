package com.zach.zombiearena.gameplay;

import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.gameplay.timers.GracePeriod;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

import static com.zach.zombiearena.utils.ItemManager.starterBow;

public class MatchMaking {

    private final int timeTillStart = (ZombieArena.getInstance()).getConfig().getInt("waves-grace-period");
    public int gracePeriodTimerTracker;
    public HashMap<UUID, Integer> bronzeLeague = (ZombieArena.getInstance()).trophiesHandler.trophies;

    public HashMap<UUID, Integer> silverLeague = new HashMap<>();

    public HashMap<UUID, Integer> goldLeague = new HashMap<>();

    public HashMap<UUID, Integer> crystalLeague = new HashMap<>();

    public HashMap<UUID, Integer> masterLeague = new HashMap<>();

    public HashMap<UUID, Integer> championLeague = new HashMap<>();

    public HashMap<UUID, UUID> playersInGame = new HashMap<>();

    public HashMap<UUID, Integer> playersLifes = new HashMap<>();

    public HashMap<UUID, ItemStack[]> playersInventoryContents = new HashMap<>();

    public void startSearch(Player player) {
        if (bronzeLeague.containsKey(player.getUniqueId())) {
            getBronzeLeague(player);
        } else if (silverLeague.containsKey(player.getUniqueId())) {
            getSilverLeague(player);
        } else if (goldLeague.containsKey(player.getUniqueId())) {
            getGoldLeague(player);
        } else if (crystalLeague.containsKey(player.getUniqueId())) {
            getCrystalLeague(player);
        } else if (masterLeague.containsKey(player.getUniqueId())) {
            getMasterLeague(player);
        } else if (championLeague.containsKey(player.getUniqueId())) {
            getChampionLeague(player);
        }
    }

    public void getBronzeLeague(Player player) {
        if (bronzeLeague.size() == 1) {
            Messages.sendMessage(player, "matchmakingLeagueEmpty");
        } else {
            UUID defender = (UUID) bronzeLeague.keySet().toArray()[(new Random()).nextInt((bronzeLeague.keySet().toArray()).length)];
            while (Objects.equals(defender.toString(), player.getUniqueId().toString()))
                defender = (UUID) bronzeLeague.keySet().toArray()[(new Random()).nextInt((bronzeLeague.keySet().toArray()).length)];

            startGame(player, defender);

        }
    }

    public void getSilverLeague(Player player) {
        if (silverLeague.size() <= 1) {
            UUID defender = (UUID) silverLeague.keySet().toArray()[(new Random()).nextInt((silverLeague.keySet().toArray()).length)];
            while (Objects.equals(defender.toString(), player.getUniqueId().toString()))
                defender = (UUID) silverLeague.keySet().toArray()[(new Random()).nextInt((silverLeague.keySet().toArray()).length)];
            startGame(player, defender);
        }
    }

    public void getGoldLeague(Player player) {
        if (goldLeague.size() <= 1) {
            UUID defender = (UUID) goldLeague.keySet().toArray()[(new Random()).nextInt((goldLeague.keySet().toArray()).length)];
            while (Objects.equals(defender.toString(), player.getUniqueId().toString()))
                defender = (UUID) goldLeague.keySet().toArray()[(new Random()).nextInt((goldLeague.keySet().toArray()).length)];
            startGame(player, defender);
        }
    }

    public void getCrystalLeague(Player player) {
        if (crystalLeague.size() <= 1) {
            UUID defender = (UUID) crystalLeague.keySet().toArray()[(new Random()).nextInt((crystalLeague.keySet().toArray()).length)];
            while (Objects.equals(defender.toString(), player.getUniqueId().toString()))
                defender = (UUID) crystalLeague.keySet().toArray()[(new Random()).nextInt((crystalLeague.keySet().toArray()).length)];
            startGame(player, defender);
        }
    }

    public void getMasterLeague(Player player) {
        if (masterLeague.size() <= 1) {
            getCrystalLeague(player);
        } else {
            UUID defender = (UUID) masterLeague.keySet().toArray()[(new Random()).nextInt((masterLeague.keySet().toArray()).length)];
            while (Objects.equals(defender.toString(), player.getUniqueId().toString()))
                defender = (UUID) masterLeague.keySet().toArray()[(new Random()).nextInt((masterLeague.keySet().toArray()).length)];
            startGame(player, defender);
            if (masterLeague.size() == 1)
                getCrystalLeague(player);
        }
    }

    public void getChampionLeague(Player player) {
        if (championLeague.size() == 1) {
            getMasterLeague(player);
        } else {
            UUID defender = (UUID) championLeague.keySet().toArray()[(new Random()).nextInt((championLeague.keySet().toArray()).length)];
            while (Objects.equals(defender.toString(), player.getUniqueId().toString()))
                defender = (UUID) championLeague.keySet().toArray()[(new Random()).nextInt((championLeague.keySet().toArray()).length)];
            startGame(player, defender);
        }
    }

    public void startGame(Player attacker, UUID defender) {
        playersInGame.put(attacker.getUniqueId(), defender);
        attacker.teleport((ZombieArena.getInstance()).regionHandler.arenaSpawns.get(defender));
        saveInventory(attacker);

        (ZombieArena.getInstance()).npcsHandler.spawnTrader(defender, attacker);
        (new GracePeriod(timeTillStart, ZombieArena.getInstance()) {
            public void count(int gracePeriodTimer) {
                gracePeriodTimerTracker = gracePeriodTimer;
                if (gracePeriodTimer == MatchMaking.this.timeTillStart)
                    Messages.sendMessage(attacker, gracePeriodTimer, "waveTimeTillStart");
                if (gracePeriodTimer == 0) {
                    ZombieArena.getInstance().waves.startGame(attacker, defender);
                    Messages.sendMessage(attacker, gracePeriodTimer, "waveStarted");
                }
                if (gracePeriodTimer <= 30 && (gracePeriodTimer % 5 == 0 || gracePeriodTimer <= 5)) {
                    if (gracePeriodTimer == 0) return;
                    Messages.sendMessage(attacker, gracePeriodTimer, "waveCountDown");

                }
            }
        }).start();
    }

    public void saveInventory(Player attacker) {
        playersInventoryContents.put(attacker.getUniqueId(), attacker.getInventory().getContents());
        ZombieArena.getInstance().dataManager.saveInventoryData(attacker.getUniqueId());
        attacker.getInventory().clear();
        attacker.getInventory().addItem(starterBow);
        attacker.getInventory().addItem(new ItemStack(Material.ARROW, ZombieArena.getInstance().getConfig().getInt("starter-item.amount-of-arrows")));
    }
}
