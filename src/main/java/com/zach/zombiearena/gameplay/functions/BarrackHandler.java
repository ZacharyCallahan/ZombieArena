package com.zach.zombiearena.gameplay.functions;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class BarrackHandler extends FunctionHandler {
    private Cache<UUID, Long> cooldown = CacheBuilder.newBuilder().expireAfterWrite(ZombieArena.getInstance().getConfig().getLong("functions.barrack.cooldown"), TimeUnit.SECONDS).build();

    public void spawnBarrack(Player attacker, UUID defender, Location buttonLocation) {
        int cost = ZombieArena.getInstance().getConfig().getInt("functions.turrets.cost");

        if (ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(24.5, 5, 0.5).equals(buttonLocation)) {
            //not on cooldown
            if (containsAtleast(attacker, cost)) {
                if (!cooldown.asMap().containsKey(attacker.getUniqueId())) {
                    cooldown.put(attacker.getUniqueId(), System.currentTimeMillis() + (ZombieArena.getInstance().getConfig().getLong("functions.barrack.cooldown") * 1000));
                    purchaseSuccess(attacker, cost);
                    World world = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().getWorld();
                    Location spawnLocation = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(-3, 0, -4);
                    Entity entity = world.spawnEntity(spawnLocation, EntityType.IRON_GOLEM);
                    IronGolem barrack = (IronGolem) entity;

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            barrack.setHealth(0);

                        }
                    }.runTaskLater(ZombieArena.getInstance(), ZombieArena.getInstance().getConfig().getLong("functions.barrack.duration") * 20);

                    //on cooldown
                } else {
                    long timeLeft = cooldown.asMap().get(attacker.getUniqueId()) - System.currentTimeMillis();
                    Messages.sendCoolDownMessage(attacker, TimeUnit.MILLISECONDS.toSeconds(timeLeft), "functionIsOnCooldown");
                }

            } else {
                purchaseFail(attacker);
            }
        }
    }
}
