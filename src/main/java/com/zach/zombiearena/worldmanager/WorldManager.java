package com.zach.zombiearena.worldmanager;

import com.zach.zombiearena.ZombieArena;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;

public class WorldManager {
    ZombieArena instance = ZombieArena.getInstance();

    public WorldManager() {
    }

    public void setGameRules() {
        World world = Bukkit.getWorld(this.instance.config.getWorldName());
        if (world != null) {
            world.setTime(18000L);
            world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
            world.setGameRule(GameRule.DO_MOB_SPAWNING, false);
            world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
            world.setGameRule(GameRule.FREEZE_DAMAGE, true);
            world.setGameRule(GameRule.MOB_GRIEFING, false);
        }

    }
}