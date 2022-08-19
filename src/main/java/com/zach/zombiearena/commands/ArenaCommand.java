package com.zach.zombiearena.commands;

import com.zach.zombiearena.DefaultFontInfo;
import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.arenas.Region;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ArenaCommand implements CommandExecutor {
    private final HashMap<Player, Long> cooldown;
    public List<Player> toggle = new ArrayList();
    HashMap<UUID, Region> playersArena;

    public ArenaCommand() {
        this.playersArena = ZombieArena.getInstance().regionHandler.playersArena;
        this.cooldown = new HashMap();
    }

    private static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public void commandList(Player player) {
        player.sendMessage(color("&d" + ChatColor.STRIKETHROUGH + "                                                                               "));
        DefaultFontInfo.sendCenteredMessage(player, "&2&lZombie&c&lArena &f&l- &f&l&nCommand List");
        player.sendMessage("");
        player.sendMessage(color("&6/arena help &7- Shows you this page. Hehe!"));
        if (player.hasPermission("zombiearena.commands.arena.create")) {
            player.sendMessage(color("&6/arena create &7- Provides you with your own arena!"));
        }

        if (player.hasPermission("zombiearena.commands.arena.delete")) {
            player.sendMessage(color("&6/arena delete &7- This will delete your beautiful arena.. Why would you wanna do that?"));
        }

        if (player.hasPermission("zombiearena.commands.arena.restart")) {
            player.sendMessage(color("&6/arena restart &7- Allows you to completely restart your arena!"));
        }

        if (player.hasPermission("zombiearena.commands.arena.tp")) {
            player.sendMessage(color("&6/arena tp &7- Allows you to teleport to your arena!"));
        }

        if (player.hasPermission("zombiearena.commands.arena.invite")) {
            player.sendMessage(color("&6/arena invite <player> &7- Ohh you have some friends.. This will allow you to partner with them!"));
        }

        if (player.hasPermission("zombiearena.commands.arena.join")) {
            player.sendMessage(color("&6/arena join <player> &7- Allows you to join your friends arena!"));
        }

        player.sendMessage(color("&d" + ChatColor.STRIKETHROUGH + "                                                                               "));
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                commandList(player);
                return false;
            }
            Player target;


            switch (args[0]) {
                case "test":
                    ZombieArena.getInstance().healerQueen.spawnHealerQueen(player);
                    ZombieArena.getInstance().barbarianKing.spawnBarbarianKing(player);
                    ZombieArena.getInstance().archerQueen.spawnArcherQueen(player);
                    break;
                case "reload":
                    ZombieArena.getInstance().reloadConfig();
                    break;
                case "help":
                    commandList(player);
                    break;
                case "start":
                   ZombieArena.getInstance().matchMaking.startSearch(player);
                    break;
                case "create":
                    ZombieArena.getInstance().regionHandler.regionCreate(player);
                    if (!this.playersArena.containsKey(player.getUniqueId())) {
                        Messages.sendMessage(player, "arenaTeleport");
                    }
                    break;
                case "delete":
                    ZombieArena.getInstance().regionHandler.regionDeleteConfirm(player);
                    break;
                case "tp":
                    ZombieArena.getInstance().regionHandler.tpArenaSpawnCommand(player);
                    break;
                case "restart":
                    ZombieArena.getInstance().regionHandler.restartArenaCommand(player);
                    break;
                case "invite":
                    if (args.length == 2) {
                        target = Bukkit.getPlayer(args[1]);
                        if (player.hasPermission("zombiearena.commands.arena.invite")) {
                            if (target != null) {
                                if (this.playersArena.containsKey(player.getUniqueId()) && !this.playersArena.containsKey(target.getUniqueId())) {
                                    this.toggle.add(target);
                                    this.cooldown.put(target, System.currentTimeMillis() + 10000L);
                                    this.toggle.add(player);
                                    this.cooldown.put(player, System.currentTimeMillis() + 10000L);
                                    Messages.sendMessage(player, target, "arenaInvite");
                                    Messages.sendMessage(target, player, "arenaInvited");
                                } else {
                                    Messages.sendMessage(player, "arenaInvitedHasArena");
                                }
                            } else {
                                Messages.sendMessage(player, "arenaInviteError");
                            }
                        } else {
                            ZombieArena.getInstance().noPermission(player);
                        }
                    } else {
                        Messages.sendMessage(player, "arenaInviteInvalidCommand");
                    }
                    break;
                case "join":
                    if (args.length == 2) {
                        if (player.hasPermission("zombiearena.commands.arena.join")) {
                            target = Bukkit.getPlayer(args[1]);
                            if (target != null) {
                                if (this.toggle.contains(player) && this.cooldown.containsKey(player) && this.cooldown.get(player) > System.currentTimeMillis()) {
                                    Messages.sendMessage(player, target, "arenaJoined");
                                    this.toggle.remove(player);
                                    this.cooldown.remove(player);
                                    ZombieArena.getInstance().dataManager.addTeamMemberDataFile(target, player);
                                } else {
                                    Messages.sendMessage(player, "arenaNoInvite");
                                }
                            } else {
                                Messages.sendMessage(player, "arenaInviteError");
                            }
                        } else {
                            ZombieArena.getInstance().noPermission(player);
                        }
                    } else {
                       Messages.sendMessage(player, "arenaJoinInvalidCommand");
                    }
            }
        }


        return false;
    }
}