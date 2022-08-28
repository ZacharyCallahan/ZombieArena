//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.zach.zombiearena;

import com.zach.zombiearena.arenas.Region;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.Map.Entry;

public class DataManager implements Listener {
    static ZombieArena instance = ZombieArena.getInstance();
    static File cfile;
    static File dataFile;
    static FileConfiguration config;
    static FileConfiguration dataConfig;
    static File folder = new File(instance.getDataFolder(), "playerdata" + File.separator);
    static File playerDataFolder = new File(instance.getDataFolder(), "playerdata");
    static File folderData = new File(instance.getDataFolder(), "data" + File.separator);
    static File dataFolder = new File(instance.getDataFolder(), "data");
    private Region region;
    private Region cancelRegionOne;


    public void createData() {
        dataFile = new File(dataFolder, File.separator + "last-created-region-data.yml");
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }

        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile();
            } catch (IOException var9) {
                var9.printStackTrace();
            }

            this.loadDataConfig();
            int arenaSize = ZombieArena.getInstance().config.getArenaSize();
            int distanceAway = ZombieArena.getInstance().config.getDistanceAway();
            this.getDataConfig().set("last-created-min-x", 1 + arenaSize / 2);
            this.getDataConfig().set("last-created-min-y", 70);
            this.getDataConfig().set("last-created-min-z", 1 + arenaSize / 2 + distanceAway);
            this.getDataConfig().set("last-created-max-x", 50 + arenaSize);
            this.getDataConfig().set("last-created-max-y", 120);
            this.getDataConfig().set("last-created-max-z", 50 + arenaSize + distanceAway);
            this.saveDataFile();
        }

    }

    public void create(Player player) {
        String var10003 = File.separator;
        cfile = new File(playerDataFolder, var10003 + player.getUniqueId() + ".yml");
        if (!playerDataFolder.exists()) {
            playerDataFolder.mkdir();
        }

        if (!cfile.exists()) {
            try {
                cfile.createNewFile();
            } catch (IOException var3) {
                var3.printStackTrace();
            }
        }

        config = YamlConfiguration.loadConfiguration(cfile);
        saveArenaData(player.getUniqueId());
        saveTrophies(player.getUniqueId());
        saveLives(player.getUniqueId());
        savePurchasedArcherQueen(player.getUniqueId());
        saveArcherQueenHealthUpgradeLevel(player.getUniqueId());
        saveArcherQueenRadiusUpgradeLevel(player.getUniqueId());
        saveArcherQueenSpeedUpgradeLevel(player.getUniqueId());
    }


    public void savePurchasedArcherQueen(UUID uuid) {
        getConfig().set("archer-queen.purchased", false);
        ZombieArena.getInstance().archerQueen.purchasedArcherQueen.put(uuid, false);
        save();
    }

    public void updatePurchasedArcherQueen(Player player, boolean purchased) {
        loadConfig(player);
        getConfig().set("archer-queen.purchased", purchased);
        ZombieArena.getInstance().archerQueen.purchasedArcherQueen.put(player.getUniqueId(), purchased);
        save();
    }

    public void loadPurchasedArcherQueen(UUID uuid) {
        ZombieArena.getInstance().archerQueen.purchasedArcherQueen.put(uuid, getConfig().getBoolean("archer-queen.purchased"));
    }

    public void saveArcherQueenHealthUpgradeLevel(UUID uuid) {
        getConfig().set("archer-queen.health-upgrade-level", 0);
        ZombieArena.getInstance().archerQueen.archerQueenHealthUpgradeLevel.put(uuid, 0);
        save();
    }

    public void updateArcherQueenHealthUpgradeLevel(Player player, int level) {
        loadConfig(player);
        getConfig().set("archer-queen.health-upgrade-level", level);
        ZombieArena.getInstance().archerQueen.archerQueenHealthUpgradeLevel.put(player.getUniqueId(), level);
        save();
    }

    public void loadPlayersArcherQueenHealthLevel(UUID uuid) {
        ZombieArena.getInstance().archerQueen.archerQueenHealthUpgradeLevel.put(uuid, getConfig().getInt("archer-queen.health-upgrade-level"));
    }

    public void saveArcherQueenRadiusUpgradeLevel(UUID uuid) {
        getConfig().set("archer-queen.radius-upgrade-level", 0);
        ZombieArena.getInstance().archerQueen.archerQueenRadiusUpgradeLevel.put(uuid, 0);
        save();
    }

    public void updateArcherQueenRadiusUpgradeLevel(Player player, int level) {
        loadConfig(player);
        getConfig().set("archer-queen.radius-upgrade-level", level);
        ZombieArena.getInstance().archerQueen.archerQueenRadiusUpgradeLevel.put(player.getUniqueId(), level);
        save();
    }

    public void loadPlayersArcherQueenRadiusLevel(UUID uuid) {
        ZombieArena.getInstance().archerQueen.archerQueenRadiusUpgradeLevel.put(uuid, getConfig().getInt("archer-queen.radius-upgrade-level"));
    }

    public void saveArcherQueenSpeedUpgradeLevel(UUID uuid) {
        getConfig().set("archer-queen.speed-upgrade-level", 0);
        ZombieArena.getInstance().archerQueen.archerQueenSpeedUpgradeLevel.put(uuid, 0);
        save();
    }

    public void updateArcherQueenSpeedUpgradeLevel(Player player, int level) {
        loadConfig(player);
        getConfig().set("archer-queen.speed-upgrade-level", level);
        ZombieArena.getInstance().archerQueen.archerQueenSpeedUpgradeLevel.put(player.getUniqueId(), level);
        save();
    }

    public void loadPlayersArcherQueenSpeedLevel(UUID uuid) {
        ZombieArena.getInstance().archerQueen.archerQueenSpeedUpgradeLevel.put(uuid, getConfig().getInt("archer-queen.speed-upgrade-level"));
    }

    public File getDataFolder() {
        return dataFolder;
    }

    public File getfolder() {
        return folder;
    }

    public File getDataFile() {
        return dataFile;
    }

    public File getfile() {
        return cfile;
    }

    public void loadDataConfig() {
        dataFile = new File(dataFolder, File.separator + "last-created-region-data.yml");
        dataConfig = YamlConfiguration.loadConfiguration(dataFile);
    }

    public void loadConfig(Player player) {
        cfile = new File(playerDataFolder, File.separator + player.getUniqueId() + ".yml");
        config = YamlConfiguration.loadConfiguration(cfile);
    }

    public void loadOfflineConfig(UUID player) {
        cfile = new File(playerDataFolder, File.separator + player + ".yml");
        config = YamlConfiguration.loadConfiguration(cfile);
    }

    public FileConfiguration getDataConfig() {
        return dataConfig;
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void saveDataFile() {
        try {
            dataConfig.save(dataFile);
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public void save() {
        try {
            config.save(cfile);
        } catch (Exception var2) {
            ConsoleCommandSender var10000 = Bukkit.getConsoleSender();
            ChatColor var10001 = ChatColor.RED;
            var10000.sendMessage(var10001 + "Error saving " + cfile.getName() + "!");
        }

    }

    public Boolean isHealerQueenArmorEnabled() {
        return getConfig().get("upgrades.defenes.healer-queen.armor)") != null;
    }


    public void saveTrophies(UUID uuid) {
        for (Map.Entry<UUID, Integer> trophies : instance.trophiesHandler.trophies.entrySet()) {
            if ((trophies.getKey()).equals(uuid))
                getConfig().set("trophies", trophies.getValue());
        }
        save();
    }

    public void loadTrophies(UUID uuid) {
        ZombieArena.getInstance().trophiesHandler.trophies.put(uuid, getConfig().getInt("trophies"));
    }

    public void saveLives(UUID uuid) {
        for (Map.Entry<UUID, Integer> lives : instance.matchMaking.playersLifes.entrySet()) {
            if ((lives.getKey()).equals(uuid))
                getConfig().set("lives", lives.getValue());
        }
        save();
    }

    public void saveInventoryData(UUID attackerUUID) {
        getConfig().set("inventory-contents", ZombieArena.getInstance().matchMaking.playersInventoryContents.get(attackerUUID));
        save();
    }

    public void saveAllPlayerData(UUID uuid) {
        saveLives(uuid);
        saveTrophies(uuid);
        save();
    }

    public void loadPlayersInventoryData(Player player) {
        loadConfig(player);
        if (loadItemStacks() != null) {
            player.getInventory().setContents(loadItemStacks());
            getConfig().set("inventory-contents", null);
        }
        save();
    }

    public ItemStack[] loadItemStacks() {
        Object object = getConfig().get("inventory-contents");
        return object instanceof Collection ? ((Collection<ItemStack>) object).toArray(new ItemStack[0]) : null;
    }

    public void loadLives(UUID uuid) {
        ZombieArena.getInstance().matchMaking.playersLifes.put(uuid, getConfig().getInt("lives"));
    }

    public void saveLastCreatedArenaData() {
        this.loadDataConfig();
        this.getDataConfig().set("last-created-min-x", instance.regionHandler.minX.get(0));
        this.getDataConfig().set("last-created-min-y", instance.regionHandler.minY.get(0));
        this.getDataConfig().set("last-created-min-z", instance.regionHandler.minZ.get(0));
        this.getDataConfig().set("last-created-max-x", instance.regionHandler.maxX.get(0));
        this.getDataConfig().set("last-created-max-y", instance.regionHandler.maxY.get(0));
        this.getDataConfig().set("last-created-max-z", instance.regionHandler.maxZ.get(0));
        this.saveDataFile();
    }


    public void saveArenaData(final UUID uuid) {
        (new BukkitRunnable() {
            public void run() {
                Iterator var1 = ZombieArena.getInstance().regionHandler.arenaSpawns.entrySet().iterator();

                Entry cancelRegionOne;
                while (var1.hasNext()) {
                    cancelRegionOne = (Entry) var1.next();
                    if (cancelRegionOne.getKey().equals(uuid)) {
                        DataManager.this.getConfig().set("spawn-point.world", ((Location) cancelRegionOne.getValue()).getWorld().getName());
                        DataManager.this.getConfig().set("spawn-point.x", ((Location) cancelRegionOne.getValue()).getBlockX());
                        DataManager.this.getConfig().set("spawn-point.y", ((Location) cancelRegionOne.getValue()).getBlockY());
                        DataManager.this.getConfig().set("spawn-point.z", ((Location) cancelRegionOne.getValue()).getBlockZ());
                    }
                }

                var1 = ZombieArena.getInstance().regionHandler.playersArena.entrySet().iterator();

                while (var1.hasNext()) {
                    cancelRegionOne = (Entry) var1.next();
                    if (cancelRegionOne.getKey().equals(uuid)) {
                        DataManager.this.getConfig().set("regions.main-region", cancelRegionOne.getValue().toString());
                        DataManager.this.getConfig().set("regions.main-region.world", ((Region) cancelRegionOne.getValue()).getWorld().getName());
                        DataManager.this.getConfig().set("regions.main-region.lower-block.x", ((Region) cancelRegionOne.getValue()).getLowerX());
                        DataManager.this.getConfig().set("regions.main-region.lower-block.y", ((Region) cancelRegionOne.getValue()).getLowerY());
                        DataManager.this.getConfig().set("regions.main-region.lower-block.z", ((Region) cancelRegionOne.getValue()).getLowerZ());
                        DataManager.this.getConfig().set("regions.main-region.upper-block.x", ((Region) cancelRegionOne.getValue()).getUpperX());
                        DataManager.this.getConfig().set("regions.main-region.upper-block.y", ((Region) cancelRegionOne.getValue()).getUpperY());
                        DataManager.this.getConfig().set("regions.main-region.upper-block.z", ((Region) cancelRegionOne.getValue()).getUpperZ());
                    }
                }

                var1 = ZombieArena.getInstance().regionHandler.cancelRegion.entrySet().iterator();

                while (var1.hasNext()) {
                    cancelRegionOne = (Entry) var1.next();
                    if (cancelRegionOne.getKey().equals(uuid)) {
                        DataManager.this.getConfig().set("regions.cancel-region-one", cancelRegionOne.getValue().toString());
                        DataManager.this.getConfig().set("regions.cancel-region-one.world", ((Region) cancelRegionOne.getValue()).getWorld().getName());
                        DataManager.this.getConfig().set("regions.cancel-region-one.lower-block.x", ((Region) cancelRegionOne.getValue()).getLowerX());
                        DataManager.this.getConfig().set("regions.cancel-region-one.lower-block.y", ((Region) cancelRegionOne.getValue()).getLowerY());
                        DataManager.this.getConfig().set("regions.cancel-region-one.lower-block.z", ((Region) cancelRegionOne.getValue()).getLowerZ());
                        DataManager.this.getConfig().set("regions.cancel-region-one.upper-block.x", ((Region) cancelRegionOne.getValue()).getUpperX());
                        DataManager.this.getConfig().set("regions.cancel-region-one.upper-block.y", ((Region) cancelRegionOne.getValue()).getUpperY());
                        DataManager.this.getConfig().set("regions.cancel-region-one.upper-block.z", ((Region) cancelRegionOne.getValue()).getUpperZ());
                    }
                }

                DataManager.this.save();
            }
        }).runTaskAsynchronously(instance);
    }

    public void loadLastCreatedArenaData() {
        (new BukkitRunnable() {
            public void run() {
                loadDataConfig();
                int lastCreatedMinX = getDataConfig().getInt("last-created-min-x");
                int lastCreatedMinY = getDataConfig().getInt("last-created-min-y");
                int lastCreatedMinZ = getDataConfig().getInt("last-created-min-z");
                int lastCreatedMaxX = getDataConfig().getInt("last-created-max-x");
                int lastCreatedMaxY = getDataConfig().getInt("last-created-max-y");
                int lastCreatedMaxZ = getDataConfig().getInt("last-created-max-z");
                ZombieArena.getInstance().regionHandler.minX.add(lastCreatedMinX);
                ZombieArena.getInstance().regionHandler.minY.add(lastCreatedMinY);
                ZombieArena.getInstance().regionHandler.minZ.add(lastCreatedMinZ);
                ZombieArena.getInstance().regionHandler.maxX.add(lastCreatedMaxX);
                ZombieArena.getInstance().regionHandler.maxY.add(lastCreatedMaxY);
                ZombieArena.getInstance().regionHandler.maxZ.add(lastCreatedMaxZ);
            }
        }).runTaskAsynchronously(instance);
    }

    public void loadAllOfflinePlayerData(UUID player) {
        loadOfflineConfig(player);
        int mainLowerBlockX = getConfig().getInt("regions.main-region.lower-block.x");
        int mainLowerBlockY = getConfig().getInt("regions.main-region.lower-block.y");
        int mainLowerBlockZ = getConfig().getInt("regions.main-region.lower-block.z");
        int mainUpperBlockX = getConfig().getInt("regions.main-region.upper-block.x");
        int mainUpperBlockY = getConfig().getInt("regions.main-region.upper-block.y");
        int mainUpperBlockZ = getConfig().getInt("regions.main-region.upper-block.z");
        region = new Region(new Location(Bukkit.getWorld(ZombieArena.getInstance().config.getWorldName()), mainLowerBlockX, mainLowerBlockY, mainLowerBlockZ),
                new Location(Bukkit.getWorld(ZombieArena.getInstance().config.getWorldName()), mainUpperBlockX, mainUpperBlockY, mainUpperBlockZ));
        ZombieArena.getInstance().regionHandler.addPlayersArena(player, region);
        ZombieArena.getInstance().barrier.resetBarriers(player);
        int cancelOneLowerBlockX = getConfig().getInt("regions.cancel-region-one.lower-block.x");
        int cancelOneLowerBlockY = getConfig().getInt("regions.cancel-region-one.lower-block.y");
        int cancelOneLowerBlockZ = getConfig().getInt("regions.cancel-region-one.lower-block.z");
        int cancelOneUpperBlockX = getConfig().getInt("regions.cancel-region-one.upper-block.x");
        int cancelOneUpperBlockY = getConfig().getInt("regions.cancel-region-one.upper-block.y");
        int cancelOneUpperBlockZ = getConfig().getInt("regions.cancel-region-one.upper-block.z");
        cancelRegionOne = new Region(new Location(Bukkit.getWorld(ZombieArena.getInstance().config.getWorldName()),
                cancelOneLowerBlockX, cancelOneLowerBlockY, cancelOneLowerBlockZ),
                new Location(Bukkit.getWorld(ZombieArena.getInstance().config.getWorldName()), cancelOneUpperBlockX, cancelOneUpperBlockY, cancelOneUpperBlockZ));
        ZombieArena.getInstance().regionHandler.addCancelRegion(player, cancelRegionOne);
        ZombieArena.getInstance().regionHandler.addArenaSpawns(player,
                region.getCenter().add(27.0D, 4.0D, 0.0D).setDirection(new Vector(-90, 0, 0)));
        boolean partOfTeam = getConfig().getBoolean("part-of-team.boolean");
        if (partOfTeam) {
            ZombieArena.getInstance().regionHandler.partOfTeam.put(player, true);
        }
        playersLeague(player);
        loadLives(player);
        loadTrophies(player);
        loadPlayersArcherQueenHealthLevel(player);
        loadPurchasedArcherQueen(player);
        loadPlayersArcherQueenRadiusLevel(player);
        loadPlayersArcherQueenSpeedLevel(player);
    }
    /*@EventHandler
    public void loadPlayerData(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String var10003 = File.separator;
        cfile = new File(playerDataFolder, var10003 + player.getUniqueId() + ".yml");
        if (cfile.exists()) {
            this.loadAllPlayerData(player);
        }
    }
     */

    public void loadOfflinePlayerData() {
        try {
            for (File file : playerDataFolder.listFiles()) {
                UUID uuid = UUID.fromString(file.getName().replace(".yml", ""));
                loadAllOfflinePlayerData(uuid);
            }
        } catch (NullPointerException ignored) {

        }

    }

    public void playersLeague(UUID uuid) {
        if (getConfig().getInt("trophies") >= (ZombieArena.getInstance()).config.getBronzeMin() && getConfig().getInt("trophies") <= (ZombieArena.getInstance()).config.getBronzeMax())
            (ZombieArena.getInstance()).matchMaking.bronzeLeague.put(uuid, getConfig().getInt("trophies"));
        if (getConfig().getInt("trophies") >= (ZombieArena.getInstance()).config.getSilverMin() && getConfig().getInt("trophies") <= (ZombieArena.getInstance()).config.getSilverMax())
            (ZombieArena.getInstance()).matchMaking.silverLeague.put(uuid, getConfig().getInt("trophies"));
        if (getConfig().getInt("trophies") >= (ZombieArena.getInstance()).config.getGoldMin() && getConfig().getInt("trophies") <= (ZombieArena.getInstance()).config.getGoldMax())
            (ZombieArena.getInstance()).matchMaking.goldLeague.put(uuid, getConfig().getInt("trophies"));
        if (getConfig().getInt("trophies") >= (ZombieArena.getInstance()).config.getCrystalMin() && getConfig().getInt("trophies") <= (ZombieArena.getInstance()).config.getCrystalMax())
            (ZombieArena.getInstance()).matchMaking.crystalLeague.put(uuid, getConfig().getInt("trophies"));
        if (getConfig().getInt("trophies") >= (ZombieArena.getInstance()).config.getMasterMin() && getConfig().getInt("trophies") <= (ZombieArena.getInstance()).config.getMasterMax())
            (ZombieArena.getInstance()).matchMaking.masterLeague.put(uuid, getConfig().getInt("trophies"));
        if (getConfig().getInt("trophies") >= (ZombieArena.getInstance()).config.getChampionMin() && getConfig().getInt("trophies") <= (ZombieArena.getInstance()).config.getChampionMax())
            (ZombieArena.getInstance()).matchMaking.championLeague.put(uuid, getConfig().getInt("trophies"));
    }

    public void saveSchematics() {
        File schematicFolder = new File(instance.getDataFolder(), "schematics");
        if (!schematicFolder.exists()) {
            schematicFolder.mkdir();
        }

        if (Objects.requireNonNull(schematicFolder.list()).length == 0) {
            this.saveFile(schematicFolder, "ZombieArena.schem");
        }
    }

    public void saveFile(File parent, String name) {
        File file = new File(parent, name);
        if (!file.exists()) {
            try {
                InputStream source = instance.getResource(name);
                Path target = file.toPath();
                if (source == null) {
                    return;
                }

                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException var6) {
                instance.getLogger().warning("Could not copy " + name + " to " + file.getAbsolutePath());
            }
        }

    }

    public void deletePlayerDataFile(Player player) {
        String var10003 = File.separator;

        cfile = new File(playerDataFolder, var10003 + player.getUniqueId() + ".yml");
        if (cfile.exists()) {
            cfile.delete();

        }

    }

    public void addTeamMemberDataFile(Player ownerPlayer, Player player) {
        this.loadConfig(ownerPlayer);
        int ownerMainLowerX = this.getConfig().getInt("regions.main-region.lower-block.x");
        int ownerMainLowerY = this.getConfig().getInt("regions.main-region.lower-block.y");
        int ownerMainLowerZ = this.getConfig().getInt("regions.main-region.lower-block.z");
        int ownerMainUpperX = this.getConfig().getInt("regions.main-region.upper-block.x");
        int ownerMainUpperY = this.getConfig().getInt("regions.main-region.upper-block.y");
        int ownerMainUpperZ = this.getConfig().getInt("regions.main-region.upper-block.z");
        int ownerCancelOneLowerX = this.getConfig().getInt("regions.cancel-region-one.lower-block.x");
        int ownerCancelOneLowerY = this.getConfig().getInt("regions.cancel-region-one.lower-block.y");
        int ownerCancelOneLowerZ = this.getConfig().getInt("regions.cancel-region-one.lower-block.z");
        int ownerCancelOneUpperX = this.getConfig().getInt("regions.cancel-region-one.upper-block.x");
        int ownerCancelOneUpperY = this.getConfig().getInt("regions.cancel-region-one.upper-block.y");
        int ownerCancelOneUpperZ = this.getConfig().getInt("regions.cancel-region-one.upper-block.z");
        this.create(player);
        this.loadConfig(player);
        this.getConfig().set("part-of-team.owner-uuid", ownerPlayer.getUniqueId().toString());
        this.getConfig().set("part-of-team.boolean", true);
        instance.regionHandler.partOfTeam.put(player.getUniqueId(), true);
        this.getConfig().set("regions.main-region.lower-block.x", ownerMainLowerX);
        this.getConfig().set("regions.main-region.lower-block.y", ownerMainLowerY);
        this.getConfig().set("regions.main-region.lower-block.z", ownerMainLowerZ);
        this.getConfig().set("regions.main-region.upper-block.x", ownerMainUpperX);
        this.getConfig().set("regions.main-region.upper-block.y", ownerMainUpperY);
        this.getConfig().set("regions.main-region.upper-block.z", ownerMainUpperZ);
        this.region = new Region(new Location(Bukkit.getWorld(instance.config.getWorldName()), ownerMainLowerX, ownerMainLowerY, ownerMainLowerZ),
                new Location(Bukkit.getWorld(instance.config.getWorldName()), ownerMainUpperX, ownerMainUpperY, ownerMainUpperZ));
        instance.regionHandler.addPlayersArena(player.getUniqueId(), this.region);
        this.getConfig().set("regions.cancel-region-one.lower-block.x", ownerCancelOneLowerX);
        this.getConfig().set("regions.cancel-region-one.lower-block.y", ownerCancelOneLowerY);
        this.getConfig().set("regions.cancel-region-one.lower-block.z", ownerCancelOneLowerZ);
        this.getConfig().set("regions.cancel-region-one.upper-block.x", ownerCancelOneUpperX);
        this.getConfig().set("regions.cancel-region-one.upper-block.y", ownerCancelOneUpperY);
        this.getConfig().set("regions.cancel-region-one.upper-block.z", ownerCancelOneUpperZ);
        this.cancelRegionOne = new Region(new Location(Bukkit.getWorld(instance.config.getWorldName()), ownerCancelOneLowerX, ownerCancelOneLowerY, ownerCancelOneLowerZ),
                new Location(Bukkit.getWorld(instance.config.getWorldName()), ownerCancelOneUpperX, ownerCancelOneUpperY, ownerCancelOneUpperZ));
        instance.regionHandler.addCancelRegion(player.getUniqueId(), this.cancelRegionOne);
        instance.regionHandler.addArenaSpawns(player.getUniqueId(), this.region.getCenter().add(27.0D, 4.0D, 0.0D).setDirection(new Vector(-90, 0, 0)));
        this.save();
    }

    public boolean isInGame(Player attacker) {
        loadConfig(attacker);
        return ZombieArena.getInstance().matchMaking.playersInGame.containsKey(attacker.getUniqueId()) && getConfig().get("inventory-contents") != null;
    }

    public boolean needsInventoryContent(Player attacker) {
        loadConfig(attacker);
        return getConfig().get("inventory-contents") != null;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player attacker = e.getPlayer();
        if (needsInventoryContent(attacker)) {
            ZombieArena.getInstance().dataManager.loadPlayersInventoryData(attacker);
            attacker.teleport(ZombieArena.getInstance().regionHandler.arenaSpawns.get(attacker.getUniqueId()));
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player attacker = e.getPlayer();
        if (isInGame(attacker)) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    ZombieArena.getInstance().waves.endGamePlayerLeft(attacker);
                }

            }.runTaskLater(ZombieArena.getInstance(), ZombieArena.getInstance().matchMaking.gracePeriodTimerTracker * 20L);
        }
    }
}
