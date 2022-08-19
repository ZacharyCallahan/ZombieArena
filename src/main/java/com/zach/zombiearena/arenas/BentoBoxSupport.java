package com.zach.zombiearena.arenas;

import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import world.bentobox.bentobox.api.events.island.IslandCreateEvent;
import world.bentobox.bentobox.api.events.island.IslandResetEvent;
import world.bentobox.bentobox.api.events.team.TeamDeleteEvent;
import world.bentobox.bentobox.api.events.team.TeamJoinedEvent;
import world.bentobox.bentobox.api.events.team.TeamKickEvent;
import world.bentobox.bentobox.api.events.team.TeamLeaveEvent;

import java.util.HashMap;
import java.util.UUID;

public class BentoBoxSupport implements Listener {
    ZombieArena instance = ZombieArena.getInstance();
    HashMap<UUID, Region> playersArena;

    public BentoBoxSupport() {
        this.playersArena = this.instance.regionHandler.playersArena;
    }

    private static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    @EventHandler
    public void onTeamJoin(TeamJoinedEvent e) {
        UUID ownerUuid = e.getOwner();
        UUID uuid = e.getPlayerUUID();
        Player ownerPlayer = Bukkit.getPlayer(ownerUuid);
        Player player = Bukkit.getPlayer(uuid);
        if (this.playersArena.containsKey(uuid) && player != null) {
            this.instance.regionHandler.regionDelete(player);
        }

        this.instance.dataManager.addTeamMemberDataFile(ownerPlayer, player);
    }

    @EventHandler
    public void onTeamLeave(TeamLeaveEvent e) {
        UUID uuid = e.getPlayerUUID();
        Player player = Bukkit.getPlayer(uuid);
        if (player != null) {
            this.instance.regionHandler.resetArena(player);
        }

    }

    @EventHandler
    public void onTeamDelete(TeamDeleteEvent e) {
        UUID uuid = e.getPlayerUUID();
        Player player = Bukkit.getPlayer(uuid);
        if (player != null) {
            this.instance.regionHandler.resetArena(player);
        }

    }

    @EventHandler
    public void onTeamKick(TeamKickEvent e) {
        UUID uuid = e.getPlayerUUID();
        Player player = Bukkit.getPlayer(uuid);
        if (player != null) {
            this.instance.regionHandler.resetArena(player);
        }

    }

    @EventHandler
    public void onIslandCreate(IslandCreateEvent e) {
        UUID uuid = e.getPlayerUUID();
        Player player = Bukkit.getPlayer(uuid);
        if (player != null && !this.playersArena.containsKey(player.getUniqueId())) {
            this.instance.regionHandler.regionCreate(player);
            Messages.sendMessage(player, "arenaCreation");
        }

    }

    @EventHandler
    public void onIslandReset(IslandResetEvent e) {
        UUID uuid = e.getPlayerUUID();
        Player player = Bukkit.getPlayer(uuid);
        if (player != null) {
            if (this.playersArena.containsKey(player.getUniqueId())) {
                this.instance.regionHandler.resetArena(player);
            }

            this.instance.regionHandler.regionCreate(player);
        }

    }
}