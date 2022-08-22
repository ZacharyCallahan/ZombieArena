package com.zach.zombiearena;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashMap;

public class Messages {

    private static final HashMap<String, String> messageData = new HashMap<>();

    public Messages() {
        ZombieArena.getInstance().dataManager.saveFile(ZombieArena.getInstance().getDataFolder(), "messages.yml");
        File file = new File(ZombieArena.getInstance().getDataFolder() + File.separator, "messages.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        for (String message : config.getConfigurationSection("").getKeys(false)) {
            messageData.put(message, config.getString(message));
        }

    }

    public static void sendMessage(Player receiver, Player placeHolder, String messageName) {
        receiver.sendMessage(ZombieArena.color(messageData.get(messageName).replace("%player%", placeHolder.getDisplayName())));
    }

    public static void sendMessage(Player receiver, String messageName) {
        receiver.sendMessage(ZombieArena.color(messageData.get(messageName)));
    }

    public static void sendMessage(Player receiver, Integer countdown, String messageName) {
        receiver.sendMessage(ZombieArena.color(messageData.get(messageName).replace("%seconds%", String.valueOf(countdown))));
    }

    public static void sendTrophyGainMessage(Player receiver, Integer trophies, String messageName) {
        receiver.sendMessage(ZombieArena.color(messageData.get(messageName).replace("%trophies%", String.valueOf(trophies))));
    }

    public static void sendCoolDownMessage(Player receiver, Long cooldown, String messageName) {
        receiver.sendMessage(ZombieArena.color(messageData.get(messageName).replace("%cooldown%", String.valueOf(cooldown))));
    }

    public static void sendNotEnoughMoneyMessage(Player receiver, Double money, String messageName) {
        receiver.sendMessage(ZombieArena.color(messageData.get(messageName).replace("%money%", String.valueOf(money))));
    }

    public static void sendDefensePurchasedMessage(Player receiver, String defenseName, String messageName) {
        receiver.sendMessage(ZombieArena.color(messageData.get(messageName).replace("%defense%", defenseName)));
    }
}