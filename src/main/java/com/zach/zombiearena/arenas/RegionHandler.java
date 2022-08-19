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
        this.worldName = ZombieArena.getInstance().config.getWorldName();
        this.arenaSize = ZombieArena.getInstance().config.getArenaSize();
        this.distanceAway = ZombieArena.getInstance().config.getDistanceAway();
        this.playersArena = new HashMap();
        this.cancelRegion = new HashMap();
        this.arenaSpawns = new HashMap();
        this.partOfTeam = new HashMap();
    }

    public void regionCreate(Player player) {
        UUID uuid = player.getUniqueId();
        if (player.hasPermission("zombiearena.commands.arena.create")) {
            if (!this.playersArena.containsKey(player.getUniqueId())) {
                if (ZombieArena.getInstance().config.getArenaSize() > ZombieArena.getInstance().config.getDistanceAway()) {
                    throw new IllegalStateException("It looks like '" + this.distanceAway + "' (distance-away) is smaller than '"
                            + this.arenaSize + "'(arena-size). Check 'arena-size:' within the config.yml");
                }
                ZombieArena.getInstance().trophiesHandler.trophies.put(player.getUniqueId(), 0);
                ZombieArena.getInstance().matchMaking.playersLifes.put(player.getUniqueId(), ZombieArena.getInstance().getConfig().getInt("number-of-lives.default"));
                this.minX.add(1 + this.arenaSize / 2);
                this.minY.add(70);
                this.minZ.add(1 + this.arenaSize / 2);
                this.maxX.add(50 + this.arenaSize);
                this.maxY.add(120);
                this.maxZ.add(50 + this.arenaSize);
                int newMinX = this.minX.get(0);
                int newMinY = this.minY.get(0);
                int newMinZ = this.minZ.get(0) + this.distanceAway;
                int newMaxX = this.maxX.get(0);
                int newMaxY = this.maxY.get(0);
                int newMaxZ = this.maxZ.get(0) + this.distanceAway;
                this.region = new Region(new Location(Bukkit.getWorld(this.worldName), newMinX, newMinY, newMinZ),
                        new Location(Bukkit.getWorld(this.worldName), newMaxX, newMaxY, newMaxZ));
                Location lowerCorner = this.region.getCenter().add(23.0D, -1.0D, 10.0D);
                Location uppperCorner = this.region.getCenter().add(23.0D, 12.0D, -9.0D);
                this.addArenaSpawns(uuid, this.region.getCenter().add(27.0D, 4.0D, 0.0D).setDirection(new Vector(-90, 0, 0)));
                this.loadSchematics(player);
                player.teleport(this.arenaSpawns.get(player.getUniqueId()));
                this.addPlayersArena(uuid, this.region);
                this.noMoveRegion = new Region(new Location(Bukkit.getWorld(this.worldName),
                        lowerCorner.getBlockX(), lowerCorner.getBlockY(), lowerCorner.getBlockZ()),
                        new Location(Bukkit.getWorld(this.worldName),
                                uppperCorner.getBlockX(), uppperCorner.getBlockY(), uppperCorner.getBlockZ()));
                this.addCancelRegion(uuid, this.noMoveRegion);
                this.minX.clear();
                this.minY.clear();
                this.minZ.clear();
                this.maxX.clear();
                this.maxZ.clear();
                this.maxY.clear();
                this.minX.add(newMinX);
                this.minY.add(newMinY);
                this.minZ.add(newMinZ);
                this.maxX.add(newMaxX);
                this.maxY.add(newMaxY);
                this.maxZ.add(newMaxZ);
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
            if (!this.partOfTeam.containsKey(player.getUniqueId())) {
                if (ZombieArena.getInstance().toggle.contains(player)
                        && ZombieArena.getInstance().cooldown.containsKey(player)
                        && ZombieArena.getInstance().cooldown.get(player) > System.currentTimeMillis()) {
                    if (this.playersArena.containsKey(player.getUniqueId())) {
                        playerRegion = this.playersArena.get(player.getUniqueId());
                    }

                    if (playerRegion != null) {
                        Iterator playersInRegion = playerRegion.getBlocks().iterator();

                        while (playersInRegion.hasNext()) {
                            Block block = (Block) playersInRegion.next();
                            block.setType(Material.AIR);
                        }

                        Messages.sendMessage(player, "arenaDeletion");
                        this.playersArena.remove(player.getUniqueId());
                        this.cancelRegion.remove(player.getUniqueId());
                        this.arenaSpawns.remove(player.getUniqueId());
                        ZombieArena.getInstance().dataManager.deletePlayerDataFile(player);
                    }

                    ZombieArena.getInstance().toggle.remove(player);
                } else if (!this.playersArena.containsKey(player.getUniqueId())) {
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
        this.partOfTeam.remove(player.getUniqueId());
        ZombieArena.getInstance().dataManager.deletePlayerDataFile(player);
        this.arenaSpawns.remove(player.getUniqueId());
        this.playersArena.remove(player.getUniqueId());
        this.cancelRegion.remove(player.getUniqueId());
    }

    public void restartArenaCommand(Player player) {
        Region playerRegion = null;
        if (player.hasPermission("zombiearena.commands.arena.restart")) {
            if (ZombieArena.getInstance().toggle.contains(player) && ZombieArena.getInstance().cooldown.containsKey(player) && ZombieArena.getInstance().cooldown.get(player) > System.currentTimeMillis()) {
                if (this.playersArena.containsKey(player.getUniqueId())) {
                    Region var10000 = this.playersArena.get(player.getUniqueId());
                }
                Messages.sendMessage(player, "arenaCreation");
                this.regionDelete(player);
                ZombieArena.getInstance().dataManager.deletePlayerDataFile(player);
                this.arenaSpawns.remove(player.getUniqueId());
                this.playersArena.remove(player.getUniqueId());
                this.cancelRegion.remove(player.getUniqueId());
                this.regionCreate(player);
            } else {
                ZombieArena.getInstance().toggle.add(player);
                ZombieArena.getInstance().cooldown.put(player, System.currentTimeMillis() + 10000L);
                Messages.sendMessage(player, "arenaRestartConfirm");
            }
        }

    }

    public void regionDelete(Player player) {
        Region playerRegion = null;
        if (this.playersArena.containsKey(player.getUniqueId())) {
            playerRegion = this.playersArena.get(player.getUniqueId());
        }

        if (playerRegion != null) {
            Iterator var3 = playerRegion.getBlocks().iterator();

            while (var3.hasNext()) {
                Block block = (Block) var3.next();
                block.setType(Material.AIR);
            }

            this.playersArena.remove(player.getUniqueId());
            this.cancelRegion.remove(player.getUniqueId());
            this.arenaSpawns.remove(player.getUniqueId());
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
                    Operation operation = (new ClipboardHolder(clipboard)).createPaste(editSession).to(BlockVector3.at(this.region.getCenter().getBlockX(),
                            this.region.getCenter().getBlockY(), this.region.getCenter().getBlockZ())).ignoreAirBlocks(true).build();

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
            if (this.arenaSpawns.containsKey(player.getUniqueId())) {
                player.teleport(this.arenaSpawns.get(player.getUniqueId()));
                Messages.sendMessage(player, "arenaTeleport");
            } else {
                Messages.sendMessage(player, "arenaNoArenaToTeleportError");
            }
        } else {
            ZombieArena.getInstance().noPermission(player);
        }

    }

    public void tpArenaSpawn(Player player) {
        if (this.arenaSpawns.containsKey(player.getUniqueId())) {
            player.teleport(this.arenaSpawns.get(player.getUniqueId()));
            Messages.sendMessage(player, "arenaAccessDeny");
        }

    }

    public void addPlayersArena(UUID uuid, Region region) {
        this.playersArena.putIfAbsent(uuid, region);
    }

    public void addArenaSpawns(UUID uuid, Location location) {
        this.arenaSpawns.put(uuid, location);
    }

    public void addCancelRegion(UUID uuid, Region region) {
        this.cancelRegion.put(uuid, region);
    }
}