package com.zach.zombiearena.gameplay.functions;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.util.Vector;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class CannonHandler extends FunctionHandler {

    private Cache<UUID, Long> redButtonCooldown = CacheBuilder.newBuilder().expireAfterWrite(ZombieArena.getInstance().getConfig().getLong("functions.barrack.cooldown"), TimeUnit.SECONDS).build();
    private Cache<UUID, Long> orangeButtonCooldown = CacheBuilder.newBuilder().expireAfterWrite(ZombieArena.getInstance().getConfig().getLong("functions.barrack.cooldown"), TimeUnit.SECONDS).build();
    private Cache<UUID, Long> yellowButtonCooldown = CacheBuilder.newBuilder().expireAfterWrite(ZombieArena.getInstance().getConfig().getLong("functions.barrack.cooldown"), TimeUnit.SECONDS).build();
    private Cache<UUID, Long> greenButtonCooldown = CacheBuilder.newBuilder().expireAfterWrite(ZombieArena.getInstance().getConfig().getLong("functions.barrack.cooldown"), TimeUnit.SECONDS).build();
    private Cache<UUID, Long> blueButtonCooldown = CacheBuilder.newBuilder().expireAfterWrite(ZombieArena.getInstance().getConfig().getLong("functions.barrack.cooldown"), TimeUnit.SECONDS).build();
    private Cache<UUID, Long> prupleButtonCooldown = CacheBuilder.newBuilder().expireAfterWrite(ZombieArena.getInstance().getConfig().getLong("functions.barrack.cooldown"), TimeUnit.SECONDS).build();
    public void cannonShoot(Player attacker, UUID defender, Location buttonLocation) {
        int cost = ZombieArena.getInstance().getConfig().getInt("functions.cannons.cost");

        Location redCannon = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(-12, 12, 11);
        Location orangeCannon = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(-12, 12, -10);
        Location yellowCannon = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(0, 12, 11);
        Location greenCannon = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(0, 12, -10);
        Location blueCannon = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(12, 12, 11);
        Location purpleCannon = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(12, 12, -10);

        Location redButton = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(24.5, 8, -9.5);
        Location orangeButton = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(28.5, 8, -9.5);
        Location yellowButton = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(24.5, 6, -9.5);
        Location greenButton = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(28.5, 6, -9.5);
        Location blueButton = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(24.5, 4, -9.5);
        Location purpleButton = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(28.5, 4, -9.5);

        if (redButton.equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                if (!redButtonCooldown.asMap().containsKey(attacker.getUniqueId())) {
                    redButtonCooldown.put(attacker.getUniqueId(), System.currentTimeMillis() + (ZombieArena.getInstance().getConfig().getLong("functions.barrack.cooldown") * 1000));
                    purchaseSuccess(attacker, cost);
                    TNTPrimed tnt = (TNTPrimed) redCannon.getWorld().spawn(redCannon.getBlock().getLocation(), TNTPrimed.class);
                    tnt.setVelocity(new Vector(0, 0.2, -0.6));
                } else {
                    long timeLeft = redButtonCooldown.asMap().get(attacker.getUniqueId()) - System.currentTimeMillis();
                    Messages.sendCoolDownMessage(attacker, TimeUnit.MILLISECONDS.toSeconds(timeLeft), "functionIsOnCooldown");
                }
            } else {
                purchaseFail(attacker);
            }

        } else if (orangeButton.equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                if (!orangeButtonCooldown.asMap().containsKey(attacker.getUniqueId())) {
                    orangeButtonCooldown.put(attacker.getUniqueId(), System.currentTimeMillis() + (ZombieArena.getInstance().getConfig().getLong("functions.barrack.cooldown") * 1000));
                    purchaseSuccess(attacker, cost);
                    TNTPrimed tnt = (TNTPrimed) orangeCannon.getWorld().spawn(orangeCannon.getBlock().getLocation(), TNTPrimed.class);
                    tnt.setVelocity(new Vector(0, 0.2, 0.6));
                }else {
                    long timeLeft = orangeButtonCooldown.asMap().get(attacker.getUniqueId()) - System.currentTimeMillis();
                    Messages.sendCoolDownMessage(attacker, TimeUnit.MILLISECONDS.toSeconds(timeLeft), "functionIsOnCooldown");
                }
            } else {
                purchaseFail(attacker);
            }

        } else if (yellowButton.equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                if (!yellowButtonCooldown.asMap().containsKey(attacker.getUniqueId())) {
                    yellowButtonCooldown.put(attacker.getUniqueId(), System.currentTimeMillis() + (ZombieArena.getInstance().getConfig().getLong("functions.barrack.cooldown") * 1000));
                    purchaseSuccess(attacker, cost);
                    TNTPrimed tnt = (TNTPrimed) yellowCannon.getWorld().spawn(yellowCannon.getBlock().getLocation(), TNTPrimed.class);
                    tnt.setVelocity(new Vector(0, 0.2, -0.6));
                }else {
                    long timeLeft = yellowButtonCooldown.asMap().get(attacker.getUniqueId()) - System.currentTimeMillis();
                    Messages.sendCoolDownMessage(attacker, TimeUnit.MILLISECONDS.toSeconds(timeLeft), "functionIsOnCooldown");
                }
            } else {
                purchaseFail(attacker);
            }

        } else if (greenButton.equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                if (!greenButtonCooldown.asMap().containsKey(attacker.getUniqueId())) {
                    greenButtonCooldown.put(attacker.getUniqueId(), System.currentTimeMillis() + (ZombieArena.getInstance().getConfig().getLong("functions.barrack.cooldown") * 1000));
                    purchaseSuccess(attacker, cost);
                    TNTPrimed tnt = (TNTPrimed) greenCannon.getWorld().spawn(greenCannon.getBlock().getLocation(), TNTPrimed.class);
                    tnt.setVelocity(new Vector(0, 0.2, 0.6));
                }else {
                    long timeLeft = greenButtonCooldown.asMap().get(attacker.getUniqueId()) - System.currentTimeMillis();
                    Messages.sendCoolDownMessage(attacker, TimeUnit.MILLISECONDS.toSeconds(timeLeft), "functionIsOnCooldown");
                }
            } else {
                purchaseFail(attacker);
            }

        } else if (blueButton.equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                if (!blueButtonCooldown.asMap().containsKey(attacker.getUniqueId())) {
                    blueButtonCooldown.put(attacker.getUniqueId(), System.currentTimeMillis() + (ZombieArena.getInstance().getConfig().getLong("functions.barrack.cooldown") * 1000));
                    purchaseSuccess(attacker, cost);
                    TNTPrimed tnt = (TNTPrimed) blueCannon.getWorld().spawn(blueCannon.getBlock().getLocation(), TNTPrimed.class);
                    tnt.setVelocity(new Vector(0, 0.2, -0.6));
                }else {
                    long timeLeft = blueButtonCooldown.asMap().get(attacker.getUniqueId()) - System.currentTimeMillis();
                    Messages.sendCoolDownMessage(attacker, TimeUnit.MILLISECONDS.toSeconds(timeLeft), "functionIsOnCooldown");
                }
            } else {
                purchaseFail(attacker);
            }

        } else if (purpleButton.equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                if (!prupleButtonCooldown.asMap().containsKey(attacker.getUniqueId())) {
                    prupleButtonCooldown.put(attacker.getUniqueId(), System.currentTimeMillis() + (ZombieArena.getInstance().getConfig().getLong("functions.barrack.cooldown") * 1000));
                    purchaseSuccess(attacker, cost);
                    TNTPrimed tnt = (TNTPrimed) purpleCannon.getWorld().spawn(purpleCannon.getBlock().getLocation(), TNTPrimed.class);
                    tnt.setVelocity(new Vector(0, 0.2, 0.6));
                }else {
                    long timeLeft = prupleButtonCooldown.asMap().get(attacker.getUniqueId()) - System.currentTimeMillis();
                    Messages.sendCoolDownMessage(attacker, TimeUnit.MILLISECONDS.toSeconds(timeLeft), "functionIsOnCooldown");
                }
            } else {
                purchaseFail(attacker);
            }

        }

    }
}
