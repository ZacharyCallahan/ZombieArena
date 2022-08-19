//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.zach.zombiearena.gameplay.timers;

import com.zach.zombiearena.ZombieArena;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public abstract class GracePeriod {
    protected final ZombieArena zombieArena;
    protected BukkitTask task;
    private int time;

    public GracePeriod(int time, ZombieArena zombieArena) {
        this.time = time;
        this.zombieArena = zombieArena;
    }

    public abstract void count(int time);

    public final void start() {
        (new BukkitRunnable() {
            public void run() {
                count(time);
                if (time-- <= 0) {
                    this.cancel();
                }

            }
        }).runTaskTimer(this.zombieArena, 0L, 20L);

    }
}
