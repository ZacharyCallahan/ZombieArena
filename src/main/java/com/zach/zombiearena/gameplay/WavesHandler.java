//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.zach.zombiearena.gameplay;

import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.arenas.Region;
import org.bukkit.Location;

import java.util.*;

public class WavesHandler {
    public HashMap<UUID, List<Location>> ranSpawn;
    public Random random;
    public int maxNum;
    HashMap<UUID, Region> playersArena;

    public WavesHandler() {
        this.playersArena = ZombieArena.getInstance().regionHandler.playersArena;
        this.ranSpawn = new HashMap<>();
        this.random = new Random();
        this.maxNum = 5;
    }


    public void addSpawns(UUID defender, UUID attacker, HashMap<UUID, List<Location>> ranSpawn) {
        ranSpawn.put(attacker, Arrays.asList(playersArena.get(defender).getCenter().add(-24.0D, 0.0D, -5.0D),
                playersArena.get(defender).getCenter().add(-29.0D, -2.0D, -2.0D),
                playersArena.get(defender).getCenter().add(-28.0D, -2.0D, 2.0D),
                playersArena.get(defender).getCenter().add(-28.0D, -2.0D, 8.0D),
                playersArena.get(defender).getCenter().add(-24.0D, -1.0D, 7.0D))
        );
    }



}
