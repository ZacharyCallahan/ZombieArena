package com.zach.zombiearena.gameplay.functions;

import com.zach.zombiearena.ZombieArena;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class BarrierHandler extends FunctionHandler {

    public void buyBarrier(Player attacker, UUID defender, Location buttonLocation) {
        int cost = ZombieArena.getInstance().getConfig().getInt("functions.barriers.cost");
        HashMap<Player, Boolean> yellow = new HashMap<>();
        HashMap<Player, Boolean> cyan = new HashMap<>();
        HashMap<Player, Boolean> limeGreen = new HashMap<>();
        HashMap<Player, Boolean> pink = new HashMap<>();
        HashMap<Player, Boolean> lightBlue = new HashMap<>();
        HashMap<Player, Boolean> green = new HashMap<>();
        HashMap<Player, Boolean> red = new HashMap<>();
        HashMap<Player, Boolean> blue = new HashMap<>();

        Location yellowButtonLocation = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(26.5, 6, 9.5);
        Location cyanButtonLocation = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(26.5, 4, 9.5);
        Location limeGreenButtonLocation = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(26.5, 8, 9.5);
        Location pinkButtonLocation = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(28.5, 7, 9.5);
        Location lightBlueButtonLocation = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(24.5, 7, 9.5);
        Location purpleButtonLocation = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(28.5, 5, 9.5);
        Location greenButtonLocation = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(24.5, 5, 9.5);
        Location redButtonLocation = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(25.5, 6, 9.5);
        Location blueButtonLocation = ZombieArena.getInstance().regionHandler.playersArena.get(defender).getCenter().add(27.5, 6, 9.5);

        if (yellowButtonLocation.equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                createYellowBarrier(attacker);
                purchaseSuccess(attacker, cost);
            } else {
                purchaseFail(attacker);
            }

        } else if (cyanButtonLocation.equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                createCyanBarrier(attacker);
                purchaseSuccess(attacker, cost);
            } else {
                purchaseFail(attacker);
            }
        } else if (limeGreenButtonLocation.equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                createLimeGreenBarrier(attacker);
                purchaseSuccess(attacker, cost);
            } else {
                purchaseFail(attacker);
            }

        } else if (pinkButtonLocation.equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                createPinkBarrier(attacker);
                purchaseSuccess(attacker, cost);
            } else {
                purchaseFail(attacker);
            }

        } else if (lightBlueButtonLocation.equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                createLightBlueBarrier(attacker);
                purchaseSuccess(attacker, cost);
            } else {
                purchaseFail(attacker);
            }

        } else if (purpleButtonLocation.equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                createPurpleBarrier(attacker);
                purchaseSuccess(attacker, cost);
            } else {
                purchaseFail(attacker);
            }

        } else if (greenButtonLocation.equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                createGreenBarrier(attacker);
                purchaseSuccess(attacker, cost);
            } else {
                purchaseFail(attacker);
            }

        } else if (redButtonLocation.equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                createRedBarrier(attacker);
                purchaseSuccess(attacker, cost);
            } else {
                purchaseFail(attacker);
            }

        } else if (blueButtonLocation.equals(buttonLocation)) {
            if (containsAtleast(attacker, cost)) {
                createBlueBarrier(attacker);
                purchaseSuccess(attacker, cost);
            } else {
                purchaseFail(attacker);
            }

        }
    }

    public void createYellowBarrier(Player attacker) {
        Location centerOne = ZombieArena.getInstance().regionHandler.playersArena.get(ZombieArena.getInstance().matchMaking.playersInGame.get(attacker.getUniqueId())).getCenter();
        Location centerTwo = ZombieArena.getInstance().regionHandler.playersArena.get(ZombieArena.getInstance().matchMaking.playersInGame.get(attacker.getUniqueId())).getCenter();
        centerOne.add(11, 0, 0).getBlock().setType(Material.OAK_FENCE);
        for (int i = 0; i <= 21; i++) {
            centerOne.subtract(1, 0, 0).getBlock().setType(Material.OAK_FENCE);
        }
        centerTwo.add(11, 0, 1).getBlock().setType(Material.OAK_FENCE);
        for (int i = 0; i <= 21; i++) {
            centerTwo.subtract(1, 0, 0).getBlock().setType(Material.OAK_FENCE);
        }


    }

    public void createCyanBarrier(Player attacker) {
        Location center = ZombieArena.getInstance().regionHandler.playersArena.get(ZombieArena.getInstance().matchMaking.playersInGame.get(attacker.getUniqueId())).getCenter();
        center.subtract(-12, 0, 6).getBlock().setType(Material.OAK_FENCE);
        for (int i = 0; i <= 12; i++) {
            center.add(0, 0, 1).getBlock().setType(Material.OAK_FENCE);
        }
    }

    public void createLimeGreenBarrier(Player attacker) {
        Location center = ZombieArena.getInstance().regionHandler.playersArena.get(ZombieArena.getInstance().matchMaking.playersInGame.get(attacker.getUniqueId())).getCenter();
        center.subtract(12, 0, 6).getBlock().setType(Material.OAK_FENCE);
        for (int i = 0; i <= 12; i++) {
            center.add(0, 0, 1).getBlock().setType(Material.OAK_FENCE);
        }
    }

    public void createPinkBarrier(Player attacker) {
        Location center = ZombieArena.getInstance().regionHandler.playersArena.get(ZombieArena.getInstance().matchMaking.playersInGame.get(attacker.getUniqueId())).getCenter();
        center.subtract(6, 0, -4).getBlock().setType(Material.OAK_FENCE);
        for (int i = 0; i <= 5; i++) {
            center.add(0, 0, 1).getBlock().setType(Material.OAK_FENCE);
        }
    }

    public void createLightBlueBarrier(Player attacker) {
        Location center = ZombieArena.getInstance().regionHandler.playersArena.get(ZombieArena.getInstance().matchMaking.playersInGame.get(attacker.getUniqueId())).getCenter();
        center.subtract(6, 0, 3).getBlock().setType(Material.OAK_FENCE);
        for (int i = 0; i <= 5; i++) {
            center.subtract(0, 0, 1).getBlock().setType(Material.OAK_FENCE);
        }
    }

    public void createPurpleBarrier(Player attacker) {
        Location center = ZombieArena.getInstance().regionHandler.playersArena.get(ZombieArena.getInstance().matchMaking.playersInGame.get(attacker.getUniqueId())).getCenter();
        center.add(6, 0, 4).getBlock().setType(Material.OAK_FENCE);
        for (int i = 0; i <= 5; i++) {
            center.add(0, 0, 1).getBlock().setType(Material.OAK_FENCE);
        }
    }

    public void createGreenBarrier(Player attacker) {
        Location center = ZombieArena.getInstance().regionHandler.playersArena.get(ZombieArena.getInstance().matchMaking.playersInGame.get(attacker.getUniqueId())).getCenter();
        center.add(6, 0, -3).getBlock().setType(Material.OAK_FENCE);
        for (int i = 0; i <= 5; i++) {
            center.subtract(0, 0, 1).getBlock().setType(Material.OAK_FENCE);
        }
    }

    public void createRedBarrier(Player attacker) {
        Location center = ZombieArena.getInstance().regionHandler.playersArena.get(ZombieArena.getInstance().matchMaking.playersInGame.get(attacker.getUniqueId())).getCenter();
        center.subtract(0, 0, 1).getBlock().setType(Material.OAK_FENCE);
        for (int i = 0; i <= 5; i++) {
            center.subtract(0, 0, 1).getBlock().setType(Material.OAK_FENCE);
        }
    }

    public void createBlueBarrier(Player attacker) {
        Location center = ZombieArena.getInstance().regionHandler.playersArena.get(ZombieArena.getInstance().matchMaking.playersInGame.get(attacker.getUniqueId())).getCenter();
        center.add(0, 0, 2).getBlock().setType(Material.OAK_FENCE);
        for (int i = 0; i <= 5; i++) {
            center.add(0, 0, 1).getBlock().setType(Material.OAK_FENCE);
        }
    }

    public void resetBarriers(UUID defender) {
        for (Block blocks : ZombieArena.getInstance().regionHandler.playersArena.get(defender).getBlocks()) {
            if (blocks.getType().equals(Material.OAK_FENCE)) {
                blocks.setType(Material.AIR);
            }
        }
    }
}
