//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.zach.zombiearena.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArenaTabCompleter implements TabCompleter {
    public ArenaTabCompleter() {
    }

    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> arguments = new ArrayList();
        Player player = (Player) sender;
        if (args.length == 1) {
            if (player.hasPermission("zombiearena.commands.arena.create")) {
                arguments.add("create");
            }

            if (player.hasPermission("zombiearena.commands.arena.delete")) {
                arguments.add("delete");
            }

            if (player.hasPermission("zombiearena.commands.arena.tp")) {
                arguments.add("tp");
            }

            if (player.hasPermission("zombiearena.commands.arena.invite")) {
                arguments.add("invite");
            }

            if (player.hasPermission("zombiearena.commands.arena.join")) {
                arguments.add("join");
            }

            if (player.hasPermission("zombiearena.commands.arena.restart")) {
                arguments.add("restart");
            }

            arguments.add("help");
        } else if (args.length == 2) {
            Iterator var7 = Bukkit.getOnlinePlayers().iterator();

            while (var7.hasNext()) {
                Player onlinePlayers = (Player) var7.next();
                arguments.add(onlinePlayers.getDisplayName());
            }
        }

        return arguments;
    }
}
