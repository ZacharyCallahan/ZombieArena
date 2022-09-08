package com.zach.zombiearena.gameplay.defenseupgrades;

import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.gameplay.guis.barbarianking.BarbarianKingArmorUpgradeGUI;
import com.zach.zombiearena.gameplay.guis.barbarianking.BarbarianKingHealthUpgradeGUI;
import com.zach.zombiearena.gameplay.guis.barbarianking.BarbarianKingRadiusUpgradeGUI;
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

public class BarbarianKing {
    public HashMap<Player, Integer> tasks = new HashMap<>();
    public HashMap<UUID, Integer> barbarianKingRadiusUpgradeLevel = new HashMap<>();
    public HashMap<UUID, Integer> barbarianKingHealthUpgradeLevel = new HashMap<>();
    public HashMap<UUID, Integer> barbarianKingArmorUpgradeLevel = new HashMap<>();
    public HashMap<UUID, Boolean> purchasedBarbarianKing = new HashMap<>();
    private ItemStack itemStack;
    private ItemMeta itemMeta;
    private final BarbarianKingHealthUpgradeGUI barbarianKingHealthUpgradeGUI = new BarbarianKingHealthUpgradeGUI();
    private final BarbarianKingRadiusUpgradeGUI barbarianKingRadiusUpgradeGUI = new BarbarianKingRadiusUpgradeGUI();
    private final BarbarianKingArmorUpgradeGUI barbarianKingArmorUpgradeGUI = new BarbarianKingArmorUpgradeGUI();

    public void spawnBarbarianKing(Player attacker) {
        ZombieArena.getInstance().mobHandler.mobCreator(
                attacker,
                EntityType.valueOf(ZombieArena.getInstance().config.getBarbarianKingType()),
                barbarianKingHealthUpgradeGUI.getPlayersBarbarianKingHealth(attacker),
                ZombieArena.getInstance().config.getBarbarianKingSpeed(),
                barbarianKingHelmet(),
                barbarianKingChest(),
                barbarianKingLegs(),
                barbarianKingBoots()
        );
        int taskID = Bukkit.getScheduler().runTaskTimer(ZombieArena.getInstance(), () -> {
            for (Entity entity : ZombieArena.getInstance().mobHandler.getNearbyEntities(attacker,
                    barbarianKingRadiusUpgradeGUI.getPlayersBarbarianKingRadius(attacker),
                    EntityType.valueOf(ZombieArena.getInstance().config.getBarbarianKingType()))) {
                if (entity instanceof LivingEntity livingEntity) {
                    livingEntity.getEquipment().setHelmet(new ItemStack(Material.valueOf(barbarianKingArmorUpgradeGUI.getPlayersBarbarianKingArmor(attacker) + "_HELMET")));
                    livingEntity.getEquipment().setChestplate(new ItemStack(Material.valueOf(barbarianKingArmorUpgradeGUI.getPlayersBarbarianKingArmor(attacker) + "_CHESTPLATE")));
                    livingEntity.getEquipment().setLeggings(new ItemStack(Material.valueOf(barbarianKingArmorUpgradeGUI.getPlayersBarbarianKingArmor(attacker) + "_LEGGINGS")));
                    livingEntity.getEquipment().setBoots(new ItemStack(Material.valueOf(barbarianKingArmorUpgradeGUI.getPlayersBarbarianKingArmor(attacker) + "_BOOTS")));
                }
            }
        }, 0, 20).getTaskId();
        tasks.put(attacker, taskID);
    }

    public ItemStack barbarianKingHelmet() {
        itemStack = new ItemStack(Material.AIR);
        if (ZombieArena.getInstance().getConfig().getBoolean("barbarian-king.armor.helmet.equip")) {
            itemStack = new ItemStack(Material.valueOf(String.valueOf(ZombieArena.getInstance().getConfig().get("barbarian-king.armor.helmet.item"))));
            itemMeta = itemStack.getItemMeta();
            if (ZombieArena.getInstance().getConfig().getBoolean("barbarian-king.armor.helmet.enable-enchants")) {
                for (String enchants : ZombieArena.getInstance().getConfig().getStringList("barbarian-king.armor.helmet.enchants")) {
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

    public ItemStack barbarianKingChest() {
        itemStack = new ItemStack(Material.AIR);
        if (ZombieArena.getInstance().getConfig().getBoolean("barbarian-king.armor.chestplate.equip")) {
            itemStack = new ItemStack(Material.valueOf(String.valueOf(ZombieArena.getInstance().getConfig().get("barbarian-king.armor.chestplate.item"))));
            itemMeta = itemStack.getItemMeta();
            if (ZombieArena.getInstance().getConfig().getBoolean("barbarian-king.armor.chestplate.enable-enchants")) {
                for (String enchants : ZombieArena.getInstance().getConfig().getStringList("barbarian-king.armor.chestplate.enchants")) {
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

    public ItemStack barbarianKingLegs() {
        itemStack = new ItemStack(Material.AIR);
        if (ZombieArena.getInstance().getConfig().getBoolean("barbarian-king.armor.leggings.equip")) {
            itemStack = new ItemStack(Material.valueOf(String.valueOf(ZombieArena.getInstance().getConfig().get("barbarian-king.armor.leggings.item"))));
            itemMeta = itemStack.getItemMeta();
            if (ZombieArena.getInstance().getConfig().getBoolean("barbarian-king.armor.leggings.enable-enchants")) {
                for (String enchants : ZombieArena.getInstance().getConfig().getStringList("barbarian-king.armor.leggings.enchants")) {
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

    public ItemStack barbarianKingBoots() {
        itemStack = new ItemStack(Material.AIR);
        if (ZombieArena.getInstance().getConfig().getBoolean("barbarian-king.armor.boots.equip")) {
            itemStack = new ItemStack(Material.valueOf(String.valueOf(ZombieArena.getInstance().getConfig().get("barbarian-king.armor.boots.item"))));
            itemMeta = itemStack.getItemMeta();
            if (ZombieArena.getInstance().getConfig().getBoolean("barbarian-king.armor.boots.enable-enchants")) {
                for (String enchants : ZombieArena.getInstance().getConfig().getStringList("barbarian-king.armor.boots.enchants")) {
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
