package com.zach.zombiearena.arenas;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldedit.world.World;
import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class RegionHandler {
    public final List<Integer> minX = new ArrayList();
    public final List<Integer> minY = new ArrayList();
    public final List<Integer> minZ = new ArrayList();
    public final List<Integer> maxX = new ArrayList();
    public final List<Integer> maxY = new ArrayList();
    public final List<Integer> maxZ = new ArrayList();
    final String worldName;
    final int arenaSize;
    final int distanceAway;
    public HashMap<UUID, Region> playersArena;
    public HashMap<UUID, Region> cancelRegion;
    public HashMap<UUID, Location> arenaSpawns;
    public HashMap<UUID, Boolean> partOfTeam;
    private Region region;
    private Region noMoveRegion;

    public RegionHandler() {
        worldName = ZombieArena.getInstance().config.getWorldName();
        arenaSize = ZombieArena.getInstance().config.getArenaSize();
        distanceAway = ZombieArena.getInstance().config.getDistanceAway();
        playersArena = new HashMap();
        cancelRegion = new HashMap();
        arenaSpawns = new HashMap();
        partOfTeam = new HashMap();
    }

    public void regionCreate(Player player) {
        UUID uuid = player.getUniqueId();
        if (player.hasPermission("zombiearena.commands.arena.create")) {
            if (!playersArena.containsKey(player.getUniqueId())) {
                if (ZombieArena.getInstance().config.getArenaSize() > ZombieArena.getInstance().config.getDistanceAway()) {
                    throw new IllegalStateException("It looks like '" + distanceAway + "' (distance-away) is smaller than '"
                            + arenaSize + "'(arena-size). Check 'arena-size:' within the config.yml");
                }
                ZombieArena.getInstance().trophiesHandler.trophies.put(player.getUniqueId(), 0);
                ZombieArena.getInstance().matchMaking.playersLifes.put(player.getUniqueId(), ZombieArena.getInstance().getConfig().getInt("number-of-lives.default"));
                minX.add(1 + arenaSize / 2);
                minY.add(70);
                minZ.add(1 + arenaSize / 2);
                maxX.add(50 + arenaSize);
                maxY.add(120);
                maxZ.add(50 + arenaSize);
                int newMinX = minX.get(0);
                int newMinY = minY.get(0);
                int newMinZ = minZ.get(0) + distanceAway;
                int newMaxX = maxX.get(0);
                int newMaxY = maxY.get(0);
                int newMaxZ = maxZ.get(0) + distanceAway;
                region = new Region(new Location(Bukkit.getWorld(worldName), newMinX, newMinY, newMinZ),
                        new Location(Bukkit.getWorld(worldName), newMaxX, newMaxY, newMaxZ));
                Location lowerCorner = region.getCenter().add(23.0D, -1.0D, 10.0D);
                Location uppperCorner = region.getCenter().add(23.0D, 12.0D, -9.0D);
                addArenaSpawns(uuid, region.getCenter().add(27.0D, 4.0D, 0.0D).setDirection(new Vector(-90, 0, 0)));
                loadSchematics(player);
                player.teleport(arenaSpawns.get(player.getUniqueId()));
                addPlayersArena(uuid, region);
                noMoveRegion = new Region(new Location(Bukkit.getWorld(worldName),
                        lowerCorner.getBlockX(), lowerCorner.getBlockY(), lowerCorner.getBlockZ()),
                        new Location(Bukkit.getWorld(worldName),
                                uppperCorner.getBlockX(), uppperCorner.getBlockY(), uppperCorner.getBlockZ()));
                addCancelRegion(uuid, noMoveRegion);
                minX.clear();
                minY.clear();
                minZ.clear();
                maxX.clear();
                maxZ.clear();
                maxY.clear();
                minX.add(newMinX);
                minY.add(newMinY);
                minZ.add(newMinZ);
                maxX.add(newMaxX);
                maxY.add(newMaxY);
                maxZ.add(newMaxZ);
                ZombieArena.getInstance().dataManager.saveLastCreatedArenaData();
                ZombieArena.getInstance().dataManager.create(player);
            } else {
                Messages.sendMessage(player, "arenaHasArenaError");
            }
        } else {
            ZombieArena.getInstance().noPermission(player);
        }

    }

    public void regionDeleteConfirm(Player player) {
        if (player.hasPermission("zombiearena.commands.arena.delete")) {
            Region playerRegion = null;
            if (!partOfTeam.containsKey(player.getUniqueId())) {
                if (ZombieArena.getInstance().toggle.contains(player)
                        && ZombieArena.getInstance().cooldown.containsKey(player)
                        && ZombieArena.getInstance().cooldown.get(player) > System.currentTimeMillis()) {
                    if (playersArena.containsKey(player.getUniqueId())) {
                        playerRegion = playersArena.get(player.getUniqueId());
                    }

                    if (playerRegion != null) {

                        for (Block block : playerRegion.getBlocks()) {
                            block.setType(Material.AIR);
                        }

                        Messages.sendMessage(player, "arenaDeletion");
                        playersArena.remove(player.getUniqueId());
                        cancelRegion.remove(player.getUniqueId());
                        arenaSpawns.remove(player.getUniqueId());
                        ZombieArena.getInstance().dataManager.deletePlayerDataFile(player);
                    }

                    ZombieArena.getInstance().toggle.remove(player);
                } else if (!playersArena.containsKey(player.getUniqueId())) {
                    Messages.sendMessage(player, "arenaNoArenaError");
                } else {
                    ZombieArena.getInstance().toggle.add(player);
                    ZombieArena.getInstance().cooldown.put(player, System.currentTimeMillis() + 10000L);
                    Messages.sendMessage(player, "arenaDeletionConfirm");
                }
            } else {
                Messages.sendMessage(player, "arenaNotOwnerError");
            }
        } else {
            ZombieArena.getInstance().noPermission(player);
        }

    }

    public void resetArena(Player player) {
        partOfTeam.remove(player.getUniqueId());
        ZombieArena.getInstance().dataManager.deletePlayerDataFile(player);
        arenaSpawns.remove(player.getUniqueId());
        playersArena.remove(player.getUniqueId());
        cancelRegion.remove(player.getUniqueId());
    }

    public void restartArenaCommand(Player player) {
        Region playerRegion = null;
        if (player.hasPermission("zombiearena.commands.arena.restart")) {
            if (ZombieArena.getInstance().toggle.contains(player) && ZombieArena.getInstance().cooldown.containsKey(player) && ZombieArena.getInstance().cooldown.get(player) > System.currentTimeMillis()) {
                if (playersArena.containsKey(player.getUniqueId())) {
                    Region var10000 = playersArena.get(player.getUniqueId());
                }
                Messages.sendMessage(player, "arenaCreation");
                regionDelete(player);
                ZombieArena.getInstance().dataManager.deletePlayerDataFile(player);
                arenaSpawns.remove(player.getUniqueId());
                playersArena.remove(player.getUniqueId());
                cancelRegion.remove(player.getUniqueId());
                regionCreate(player);
            } else {
                ZombieArena.getInstance().toggle.add(player);
                ZombieArena.getInstance().cooldown.put(player, System.currentTimeMillis() + 10000L);
                Messages.sendMessage(player, "arenaRestartConfirm");
            }
        }

    }

    public void regionDelete(Player player) {
        Region playerRegion = null;
        if (playersArena.containsKey(player.getUniqueId())) {
            playerRegion = playersArena.get(player.getUniqueId());
        }

        if (playerRegion != null) {
            Iterator var3 = playerRegion.getBlocks().iterator();

            while (var3.hasNext()) {
                Block block = (Block) var3.next();
                block.setType(Material.AIR);
            }

            playersArena.remove(player.getUniqueId());
            cancelRegion.remove(player.getUniqueId());
            arenaSpawns.remove(player.getUniqueId());
            ZombieArena.getInstance().dataManager.create(player);
        }

    }

    public void loadSchematics(Player player) {
        World adaptedWorld = BukkitAdapter.adapt(Bukkit.getWorld(ZombieArena.getInstance().config.getWorldName()));
        File myfile = new File(ZombieArena.getInstance().getDataFolder().getAbsolutePath() + "/schematics/ZombieArena.schem");
        ClipboardFormat format = ClipboardFormats.findByFile(myfile);

        try {
            ClipboardReader reader = format.getReader(new FileInputStream(myfile));

            try {
                Clipboard clipboard = reader.read();
                EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(adaptedWorld, -1);

                try {
                    Operation operation = (new ClipboardHolder(clipboard)).createPaste(editSession).to(BlockVector3.at(region.getCenter().getBlockX(),
                            region.getCenter().getBlockY(), region.getCenter().getBlockZ())).ignoreAirBlocks(true).build();

                    try {
                        Operations.complete(operation);
                        editSession.flushSession();
                    } catch (WorldEditException var12) {
                        player.sendMessage(ChatColor.RED + "OOPS! Something went wrong, please contact an administrator");
                        var12.printStackTrace();
                    }
                } catch (Throwable var13) {
                    if (editSession != null) {
                        try {
                            editSession.close();
                        } catch (Throwable var11) {
                            var13.addSuppressed(var11);
                        }
                    }

                    throw var13;
                }

                if (editSession != null) {
                    editSession.close();
                }
            } catch (Throwable var14) {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Throwable var10) {
                        var14.addSuppressed(var10);
                    }
                }

                throw var14;
            }

            if (reader != null) {
                reader.close();
            }
        } catch (IOException var15) {
            var15.printStackTrace();
        }

    }

    public void tpArenaSpawnCommand(Player player) {
        if (player.hasPermission("zombiearena.commands.arena.tp")) {
            if (arenaSpawns.containsKey(player.getUniqueId())) {
                player.teleport(arenaSpawns.get(player.getUniqueId()));
                Messages.sendMessage(player, "arenaTeleport");
            } else {
                Messages.sendMessage(player, "arenaNoArenaToTeleportError");
            }
        } else {
            ZombieArena.getInstance().noPermission(player);
        }

    }

    public void tpArenaSpawn(Player player) {
        if (arenaSpawns.containsKey(player.getUniqueId())) {
            player.teleport(arenaSpawns.get(player.getUniqueId()));
            Messages.sendMessage(player, "arenaAccessDeny");
        }

    }

    public void addPlayersArena(UUID uuid, Region region) {
        playersArena.putIfAbsent(uuid, region);
    }

    public void addArenaSpawns(UUID uuid, Location location) {
        arenaSpawns.put(uuid, location);
    }

    public void addCancelRegion(UUID uuid, Region region) {
        cancelRegion.put(uuid, region);
    }
}