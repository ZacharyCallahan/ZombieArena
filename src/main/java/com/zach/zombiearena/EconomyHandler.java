package com.zach.zombiearena;

import org.bukkit.entity.Player;

import static com.zach.zombiearena.ZombieArena.getEconomy;

public class EconomyHandler {
    private static Double getPlayerBalance(Player player) {
        return getEconomy().getBalance(player);
    }

    public static boolean hasEnoughMoney(Player player, double cost) {
        return getPlayerBalance(player) >= cost;
    }

    public static void withDrawMoney(Player player, Double amount) {
        getEconomy().withdrawPlayer(player, amount);
    }
}
