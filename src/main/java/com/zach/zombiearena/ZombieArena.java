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
import com.zach.zombiearena.gameplay.guis.barbarianking.BarbarianKingGUI;
import com.zach.zombiearena.gameplay.guis.healerqueen.HealerQueenGUI;
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
    private static final Logger log = Logger.getLogger("Minecraft");

    private static ZombieArena instance;

    private static Economy economy = null;

    private static MenuHandler menuHandler;
    private final VoidChunkGenerator voidChunkGenerator;
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
    public HealerQueenGUI healerQueenGUI;
    public BarbarianKing barbarianKing;
    public ArcherQueen archerQueen;
    public ArcherQueenGUI archerQueenGUI;
    public BarbarianKingGUI barbarianKingGUI;
    public WavesHandler wavesHandler;
    public DataManager dataManager;
    public Messages messages;
    public List<Player> toggle = new ArrayList<>();
    public HashMap<Player, Long> cooldown = new HashMap<>();
    public BarrierHandler barrier;
    public ItemManager itemManager;

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
        this.healerQueenGUI = new HealerQueenGUI();
        this.barbarianKing = new BarbarianKing();
        this.barbarianKingGUI = new BarbarianKingGUI();
        this.archerQueen = new ArcherQueen();
        this.archerQueenGUI = new ArcherQueenGUI();
        this.barrier = new BarrierHandler();
        this.npcsHandler = new NpcHandler();
        this.matchMaking = new MatchMaking();
        this.worldManager = new WorldManager();
        this.wavesHandler = new WavesHandler();
        this.itemManager = new ItemManager();
    }

    public static String color(String string) {
        if (string.contains("&"))
            return ChatColor.translateAlternateColorCodes('&', string);
        return string;
    }

    public static ZombieArena getInstance() {
        return instance;
    }

    public static Economy getEconomy() {
        return economy;
    }

    public static MenuHandler getMenuHandler() {
        return menuHandler;
    }

    public void onDisable() {
        kickAllPlayers();
        menuHandler.closeAll();
    }

    public void noPermission(Player player) {
        Messages.sendMessage(player, "noPermission");
    }

    public void kickAllPlayers() {
        for (Player player : Bukkit.getOnlinePlayers())
            player.kickPlayer(color("&f[&6Prison&bEvolved&f] &7The server is being reloaded. To prevent &nData Corruption&7, you have been kicked!"));
    }

    public boolean isBentoBoxPresent() {
        return (getServer().getPluginManager().getPlugin("BentoBox") != null);
    }

    public void onEnable() {
        this.voidChunkGenerator.createVoidWorld();
        this.worldManager.setGameRules();
        this.dataManager.createData();
        this.dataManager.loadLastCreatedArenaData();
        this.dataManager.saveFile(getDataFolder(), "README.txt");
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
        (new BukkitRunnable() {
            public void run() {
                ZombieArena.this.npcsHandler.destroyRemainingNPCs("Zombie");
            }
        }).runTaskLater(this, 60L);
        this.dataManager.loadOfflinePlayerData();
        if (!setupEconomy()) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null)
            return false;
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null)
            return false;
        economy = rsp.getProvider();
        return true;
    }
}
