package com.zach.zombiearena.gameplay.defenseupgrades;

import com.zach.zombiearena.ZombieArena;
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

public class HealerQueen {
    public HashMap<UUID, Integer> healerQueenHealthUpgradeLevel = new HashMap<>();
    public HashMap<UUID, Integer> healerQueenRadiusUpgradeLevel = new HashMap<>();
    public HashMap<UUID, Boolean> purchasedHealerQueen = new HashMap<>();
    public HashMap<Player, Integer> tasks = new HashMap<>();
    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public void spawnHealerQueen(Player attacker) {
        ZombieArena.getInstance().mobHandler.mobCreator(
                attacker,
                EntityType.valueOf(ZombieArena.getInstance().config.getHealerQueenType()),
                ZombieArena.getInstance().config.getHealerQueenHealth(),
                ZombieArena.getInstance().config.getHealerQueenSpeed(),
                healerQueenHelmet(),
                healerQueenChestplate(),
                healerQueenLeggings(),
                healerQueenBoots()
        );
        int taskID = Bukkit.getScheduler().runTaskTimer(ZombieArena.getInstance(), () -> {

            for (Entity entity : ZombieArena.getInstance().mobHandler.getNearbyEntities(attacker,
                    ZombieArena.getInstance().getConfig().getInt("healer-queen.heal-radius"),
                    EntityType.valueOf(ZombieArena.getInstance().config.getHealerQueenType()))) {
                if (entity instanceof LivingEntity livingEntity) {
                    if (livingEntity.getHealth() <= livingEntity.getMaxHealth() - 1) {
                        livingEntity.setHealth(livingEntity.getHealth() + ZombieArena.getInstance().getConfig().getInt("healer-queen.heal-amount"));
                        ZombieArena.getInstance().mobHandler.spawnParticles(entity);
                        System.out.println("task running");
                    }
                }
            }
        }, 0, 20).getTaskId();
        tasks.put(attacker, taskID);
    }


    public ItemStack healerQueenHelmet() {
        itemStack = new ItemStack(Material.AIR);
        if (ZombieArena.getInstance().getConfig().getBoolean("healer-queen.armor.helmet.equip")) {
            itemStack = new ItemStack(Material.valueOf(String.valueOf(ZombieArena.getInstance().getConfig().get("healer-queen.armor.helmet.item"))));
            itemMeta = itemStack.getItemMeta();
            if (ZombieArena.getInstance().getConfig().getBoolean("healer-queen.armor.helmet.enable-enchants")) {
                for (String enchants : ZombieArena.getInstance().getConfig().getStringList("healer-queen.armor.helmet.enchants")) {
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

    public ItemStack healerQueenChestplate() {
        itemStack = new ItemStack(Material.AIR);
        if (ZombieArena.getInstance().getConfig().getBoolean("healer-queen.armor.chestplate.equip")) {
            itemStack = new ItemStack(Material.valueOf(String.valueOf(ZombieArena.getInstance().getConfig().get("healer-queen.armor.chestplate.item"))));
            itemMeta = itemStack.getItemMeta();
            if (ZombieArena.getInstance().getConfig().getBoolean("healer-queen.armor.chestplate.enable-enchants")) {
                for (String enchants : ZombieArena.getInstance().getConfig().getStringList("healer-queen.armor.chestplate.enchants")) {
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

    public ItemStack healerQueenLeggings() {
        itemStack = new ItemStack(Material.AIR);
        if (ZombieArena.getInstance().getConfig().getBoolean("healer-queen.armor.leggings.equip")) {
            itemStack = new ItemStack(Material.valueOf(String.valueOf(ZombieArena.getInstance().getConfig().get("healer-queen.armor.leggings.item"))));
            itemMeta = itemStack.getItemMeta();
            if (ZombieArena.getInstance().getConfig().getBoolean("healer-queen.armor.leggings.enable-enchants")) {
                for (String enchants : ZombieArena.getInstance().getConfig().getStringList("healer-queen.armor.leggings.enchants")) {
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

    public ItemStack healerQueenBoots() {
        itemStack = new ItemStack(Material.AIR);
        if (ZombieArena.getInstance().getConfig().getBoolean("healer-queen.armor.boots.equip")) {
            itemStack = new ItemStack(Material.valueOf(String.valueOf(ZombieArena.getInstance().getConfig().get("healer-queen.armor.boots.item"))));
            itemMeta = itemStack.getItemMeta();
            if (ZombieArena.getInstance().getConfig().getBoolean("healer-queen.armor.boots.enable-enchants")) {
                for (String enchants : ZombieArena.getInstance().getConfig().getStringList("healer-queen.armor.boots.enchants")) {
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
