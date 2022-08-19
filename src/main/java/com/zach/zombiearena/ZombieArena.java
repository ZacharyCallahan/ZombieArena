//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.zach.zombiearena;

import com.zach.zombiearena.arenas.BentoBoxSupport;
import com.zach.zombiearena.arenas.RegionHandler;
import com.zach.zombiearena.arenas.RegionListener;
import com.zach.zombiearena.commands.ArenaCommand;
import com.zach.zombiearena.commands.ArenaTabCompleter;
import com.zach.zombiearena.gameplay.*;
import com.zach.zombiearena.gameplay.defenseupgrades.*;
import com.zach.zombiearena.gameplay.functions.*;
import com.zach.zombiearena.gameplay.guis.DefenseGUI;
import com.zach.zombiearena.gameplay.guis.TraderGUI;
import com.zach.zombiearena.gameplay.guis.archerqueen.ArcherQueenGUI;
import com.zach.zombiearena.utils.ItemManager;
import com.zach.zombiearena.utils.MenuHandler;
import com.zach.zombiearena.utils.ProbabilityUntilities;
import com.zach.zombiearena.worldmanager.VoidChunkGenerator;
import com.zach.zombiearena.worldmanager.WorldManager;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public final class ZombieArena extends JavaPlugin {
    private static ZombieArena instance;
    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy economy = null;

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public WorldManager worldManager;
    public RegionHandler regionHandler;
    public TrophiesHandler trophiesHandler;
    public Config config;
    public Waves waves;
    public MobHandler mobHandler;
    public NpcHandler npcsHandler;
    public MatchMaking matchMaking;
    public ProbabilityUntilities probabilityUntilities;
    public RegularMob regularMob;
    public HealerQueen healerQueen;
    public BarbarianKing barbarianKing;
    public ArcherQueen archerQueen;
    public WavesHandler wavesHandler;
    public DataManager dataManager;
    public Messages messages;
    public List<Player> toggle = new ArrayList();
    public HashMap<Player, Long> cooldown = new HashMap();
    private VoidChunkGenerator voidChunkGenerator;
    public BarrierHandler barrier;
    private static MenuHandler menuHandler;
    public ItemManager itemManager;

    public static ZombieArena getInstance() {
        return instance;
    }

    public ZombieArena() {
        instance = this;
        menuHandler = new MenuHandler();
        this.config = new Config();
        this.waves = new Waves();
        this.regionHandler = new RegionHandler();
        this.trophiesHandler = new TrophiesHandler();
        this.dataManager = new DataManager();
        this.messages = new Messages();
        this.voidChunkGenerator = new VoidChunkGenerator();
        this.probabilityUntilities = new ProbabilityUntilities();
        this.mobHandler = new MobHandler();
        this.regularMob = new RegularMob();
        this.healerQueen = new HealerQueen();
        this.barbarianKing = new BarbarianKing();
        this.archerQueen = new ArcherQueen();
        this.barrier = new BarrierHandler();
        this.npcsHandler = new NpcHandler();
        this.matchMaking = new MatchMaking();
        this.worldManager = new WorldManager();
        this.wavesHandler = new WavesHandler();
        this.itemManager = new ItemManager();
    }

    public static Economy getEconomy() {
        return economy;
    }

    public static MenuHandler getMenuHandler() {
        return menuHandler;
    }

    public void onDisable() {
        this.kickAllPlayers();
        menuHandler.closeAll();
    }

    public void noPermission(Player player) {
        Messages.sendMessage(player, "noPermission");
    }

    public void kickAllPlayers() {

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.kickPlayer(color("&f[&6Prison&bEvolved&f] &7The server is being reloaded. To prevent &nData Corruption&7, you have been kicked!"));
        }

    }

    public boolean isBentoBoxPresent() {
        if (getServer().getPluginManager().getPlugin("BentoBox") != null) {
            return true;
        }
        return false;
    }

    public void onEnable() {

        this.voidChunkGenerator.createVoidWorld();
        this.worldManager.setGameRules();
        this.dataManager.createData();
        this.dataManager.loadLastCreatedArenaData();
        this.dataManager.saveFile(this.getDataFolder(), "README.txt");
        this.dataManager.saveSchematics();
        Bukkit.getPluginCommand("arena").setExecutor(new ArenaCommand());
        Bukkit.getPluginCommand("arena").setTabCompleter(new ArenaTabCompleter());
        Bukkit.getPluginManager().registerEvents(new RegionListener(), this);
        Bukkit.getPluginManager().registerEvents(new DataManager(), this);
        if (isBentoBoxPresent()) {
            Bukkit.getPluginManager().registerEvents(new BentoBoxSupport(), this);
            getLogger().info("Hooking into BentoBox!");
        }
        Bukkit.getPluginManager().registerEvents(new WavesListener(), this);
        Bukkit.getPluginManager().registerEvents(menuHandler.getListeners(), this);
        Bukkit.getPluginManager().registerEvents(new TraderGUI(), this);
        Bukkit.getPluginManager().registerEvents(new DefenseGUI(), this);
        Bukkit.getPluginManager().registerEvents(new ArcherQueenGUI(), this);
        Bukkit.getPluginManager().registerEvents(new BarrierListener(), this);
        Bukkit.getPluginManager().registerEvents(new TurretListener(), this);
        Bukkit.getPluginManager().registerEvents(new CannonListener(), this);
        Bukkit.getPluginManager().registerEvents(new BarrackListener(), this);
        new BukkitRunnable() {
            @Override
            public void run() {
                npcsHandler.destroyRemainingNPCs("Zombie");
            }
        }.runTaskLater(this, 60L);
        dataManager.loadOfflinePlayerData();
        if (!setupEconomy()) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }

}
