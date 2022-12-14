package com.zach.zombiearena.gameplay.defenseupgrades;

import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.gameplay.guis.archerqueen.ArcherQueenHealthUpgradeGUI;
import com.zach.zombiearena.gameplay.guis.archerqueen.ArcherQueenRadiusUpgradeGUI;
import com.zach.zombiearena.gameplay.guis.archerqueen.ArcherQueenSpeedUpgradeGUI;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.UUID;

public class ArcherQueen {
    public HashMap<UUID, Integer> archerQueenHealthUpgradeLevel = new HashMap<>();
    public HashMap<UUID, Integer> archerQueenRadiusUpgradeLevel = new HashMap<>();
    public HashMap<UUID, Integer> archerQueenSpeedUpgradeLevel = new HashMap<>();
    public HashMap<UUID, Boolean> purchasedArcherQueen = new HashMap<>();
    public HashMap<Player, Integer> tasks = new HashMap<>();
    private ItemStack itemStack;
    private ItemMeta itemMeta;

    private final ArcherQueenHealthUpgradeGUI archerQueenHealthUpgradeGUI = new ArcherQueenHealthUpgradeGUI();
    private final ArcherQueenRadiusUpgradeGUI archerQueenRadiusUpgradeGUI = new ArcherQueenRadiusUpgradeGUI();
    private final ArcherQueenSpeedUpgradeGUI archerQueenSpeedUpgradeGUI = new ArcherQueenSpeedUpgradeGUI();


    public void spawnArcherQueen(Player attacker) {
        //if the player purchased the archer queen, spawn the archer queen
        if (purchasedArcherQueen.get(attacker.getUniqueId())) {
            ZombieArena.getInstance().mobHandler.mobCreator(
                    attacker,
                    EntityType.valueOf(ZombieArena.getInstance().config.getArcherQueenType()),
                    archerQueenHealthUpgradeGUI.getPlayersArcherQueenHealth(attacker),
                    ZombieArena.getInstance().config.getArcherQueenSpeed(),
                    archerQueenHelmet(),
                    archerQueenChestplate(),
                    archerQueenLeggings(),
                    archerQueenBoots()
            );
            int taskID = Bukkit.getScheduler().runTaskTimer(ZombieArena.getInstance(), () -> {
                for (Entity entity : ZombieArena.getInstance().mobHandler.getNearbyEntities(attacker,
                        archerQueenRadiusUpgradeGUI.getPlayersArcherQueenRadius(attacker),
                        EntityType.valueOf(ZombieArena.getInstance().config.getArcherQueenType()))) {
                    if (entity instanceof LivingEntity) {
                        NPC npc = CitizensAPI.getNPCRegistry().getNPC(entity);
                        if (npc != null) {
                            npc.getNavigator().getLocalParameters().speed((float) (npc.getNavigator().getLocalParameters().speed()
                                    + archerQueenSpeedUpgradeGUI.getPlayersArcherQueenSpeed(attacker)));
                        }
                    }
                }
            }, 0, 20).getTaskId();
            tasks.put(attacker, taskID);
        }
    }


    public ItemStack archerQueenHelmet() {
        itemStack = new ItemStack(Material.AIR);
        if (ZombieArena.getInstance().getConfig().getBoolean("archer-queen.armor.helmet.equip")) {
            itemStack = new ItemStack(Material.valueOf(String.valueOf(ZombieArena.getInstance().getConfig().get("archer-queen.armor.helmet.item"))));
            itemMeta = itemStack.getItemMeta();
            if (ZombieArena.getInstance().getConfig().getBoolean("archer-queen.armor.helmet.enable-enchants")) {
                for (String enchants : ZombieArena.getInstance().getConfig().getStringList("archer-queen.armor.helmet.enchants")) {
                    if (enchants != null) {
                        String enchantname = enchants.split(":")[0];
                        int enchantlvl = Integer.parseInt(enchants.split(":")[1]);
                        itemMeta.addEnchant(Enchantment.getByName(enchantname), enchantlvl, true);
                        itemStack.setItemMeta(itemMeta);
                    }
                }
            }
        }
        return itemStack;
    }

    public ItemStack archerQueenChestplate() {
        itemStack = new ItemStack(Material.AIR);
        if (ZombieArena.getInstance().getConfig().getBoolean("archer-queen.armor.chestplate.equip")) {
            itemStack = new ItemStack(Material.valueOf(String.valueOf(ZombieArena.getInstance().getConfig().get("archer-queen.armor.chestplate.item"))));
            itemMeta = itemStack.getItemMeta();
            if (ZombieArena.getInstance().getConfig().getBoolean("archer-queen.armor.chestplate.enable-enchants")) {
                for (String enchants : ZombieArena.getInstance().getConfig().getStringList("archer-queen.armor.chestplate.enchants")) {
                    if (enchants != null) {
                        String enchantname = enchants.split(":")[0];
                        int enchantlvl = Integer.parseInt(enchants.split(":")[1]);
                        itemMeta.addEnchant(Enchantment.getByName(enchantname), enchantlvl, true);
                        itemStack.setItemMeta(itemMeta);
                    }
                }
            }
        }
        return itemStack;
    }

    public ItemStack archerQueenLeggings() {
        itemStack = new ItemStack(Material.AIR);
        if (ZombieArena.getInstance().getConfig().getBoolean("archer-queen.armor.leggings.equip")) {
            itemStack = new ItemStack(Material.valueOf(String.valueOf(ZombieArena.getInstance().getConfig().get("archer-queen.armor.leggings.item"))));
            itemMeta = itemStack.getItemMeta();
            if (ZombieArena.getInstance().getConfig().getBoolean("archer-queen.armor.leggings.enable-enchants")) {
                for (String enchants : ZombieArena.getInstance().getConfig().getStringList("archer-queen.armor.leggings.enchants")) {
                    if (enchants != null) {
                        String enchantname = enchants.split(":")[0];
                        int enchantlvl = Integer.parseInt(enchants.split(":")[1]);
                        itemMeta.addEnchant(Enchantment.getByName(enchantname), enchantlvl, true);
                        itemStack.setItemMeta(itemMeta);
                    }
                }
            }
        }
        return itemStack;
    }

    public ItemStack archerQueenBoots() {
        itemStack = new ItemStack(Material.AIR);
        if (ZombieArena.getInstance().getConfig().getBoolean("archer-queen.armor.boots.equip")) {
            itemStack = new ItemStack(Material.valueOf(String.valueOf(ZombieArena.getInstance().getConfig().get("archer-queen.armor.boots.item"))));
            itemMeta = itemStack.getItemMeta();
            if (ZombieArena.getInstance().getConfig().getBoolean("archer-queen.armor.boots.enable-enchants")) {
                for (String enchants : ZombieArena.getInstance().getConfig().getStringList("archer-queen.armor.boots.enchants")) {
                    if (enchants != null) {
                        String enchantname = enchants.split(":")[0];
                        int enchantlvl = Integer.parseInt(enchants.split(":")[1]);
                        itemMeta.addEnchant(Enchantment.getByName(enchantname), enchantlvl, true);
                        itemStack.setItemMeta(itemMeta);
                    }
                }
            }
        }
        return itemStack;
    }
}
