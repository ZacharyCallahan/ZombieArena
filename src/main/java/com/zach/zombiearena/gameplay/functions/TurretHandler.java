package com.zach.zombiearena.gameplay.functions;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TurretHandler extends FunctionHandler{

    private Cache<UUID, Long> cooldown = CacheBuilder.newBuilder().expireAfterWrite(ZombieArena.getInstance().getConfig().getLong("functions.turrets.cooldown"), TimeUnit.SECONDS).build();
    public void turretShoot(Player attacker, UUID defender, Location buttonLocation) {

        int cost = ZombieArena.getInstance().getConfig().getInt("functions.turrets.cost");
        List<Dispenser> dispensers = new ArrayList<>();

        for (Block blocks : ZombieArena.getInstance().regionHandler.playersArena.get(defender).getBlocks()) {
            if (blocks.getType().equals(Material.DISPENSER)) {
                BlockState blockState = blocks.getState();
                Dispenser dispenser = (Dispenser) blockState;
                dispensers.add(dispenser);
            }

        }
        if (ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(24.5, 5, -0.5).equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                if (!cooldown.asMap().containsKey(attacker.getUniqueId())) {
                    cooldown.put(attacker.getUniqueId(), System.currentTimeMillis() + (ZombieArena.getInstance().getConfig().getLong("functions.turrets.cooldown") * 1000));
                    purchaseSuccess(attacker, cost);
                    for (Dispenser dispenser : dispensers) {
                        dispenser.getInventory().addItem(new ItemStack(Material.ARROW, ZombieArena.getInstance().getConfig().getInt("functions.turrets.dispense-amount")));
                        for (int i = 0; i < ZombieArena.getInstance().getConfig().getInt("functions.turrets.dispense-amount"); i++) {
                            dispenser.dispense();
                        }
                    }
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
