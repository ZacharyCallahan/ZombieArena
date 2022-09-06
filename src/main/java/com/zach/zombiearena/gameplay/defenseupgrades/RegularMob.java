package com.zach.zombiearena.gameplay.defenseupgrades;

import com.zach.zombiearena.ZombieArena;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class RegularMob {

    public HashMap<UUID, Integer> regularMobArmorUpgradeLevel = new HashMap<>();
    public HashMap<UUID, Integer> regularMobChanceUpgradeLevel = new HashMap<>();
    private ItemStack itemStack;

    private ItemMeta itemMeta;

    public void spawnRegularMob(Player attacker) {
        ZombieArena.getInstance().mobHandler.mobCreator(
                attacker,
                EntityType.valueOf(ZombieArena.getInstance().config.getRegularMobType()),
                ZombieArena.getInstance().config.getRegularMobHealth(),
                ZombieArena.getInstance().config.getRegularMobSpeed(),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.armor.helmet.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.armor.helmet.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.armor.helmet.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.armor.helmet.enchants")),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.armor.chestplate.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.armor.chestplate.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.armor.chestplate.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.armor.chestplate.enchants")),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.armor.leggings.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.armor.leggings.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.armor.leggings.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.armor.leggings.enchants")),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.armor.boots.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.armor.boots.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.armor.boots.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.armor.boots.enchants")));
    }

    public void spawnRegularMobUpgradeOne(Player attacker) {
        ZombieArena.getInstance().mobHandler.mobCreator(
                attacker,
                EntityType.valueOf(ZombieArena.getInstance().config.getRegularMobType()),
                ZombieArena.getInstance().config.getRegularMobHealth(),
                ZombieArena.getInstance().config.getRegularMobSpeed(),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-one.armor.helmet.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-one.armor.helmet.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-one.armor.helmet.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-one.armor.helmet.enchants")),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-one.armor.chestplate.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-one.armor.chestplate.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-one.armor.chestplate.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-one.armor.chestplate.enchants")),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-one.armor.leggings.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-one.armor.leggings.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-one.armor.leggings.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-one.armor.leggings.enchants")),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-one.armor.boots.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-one.armor.boots.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-one.armor.boots.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-one.armor.boots.enchants")));
    }

    public void spawnRegularMobUpgradeTwo(Player attacker) {
        ZombieArena.getInstance().mobHandler.mobCreator(
                attacker,
                EntityType.valueOf(ZombieArena.getInstance().config.getRegularMobType()),
                ZombieArena.getInstance().config.getRegularMobHealth(),
                ZombieArena.getInstance().config.getRegularMobSpeed(),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-two.armor.helmet.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-two.armor.helmet.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-two.armor.helmet.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-two.armor.helmet.enchants")),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-two.armor.chestplate.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-two.armor.chestplate.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-two.armor.chestplate.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-two.armor.chestplate.enchants")),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-two.armor.leggings.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-two.armor.leggings.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-two.armor.leggings.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-two.armor.leggings.enchants")),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-two.armor.boots.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-two.armor.boots.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-two.armor.boots.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-two.armor.boots.enchants")));
    }

    public void spawnRegularMobUpgradeThree(Player attacker) {
        ZombieArena.getInstance().mobHandler.mobCreator(
                attacker,
                EntityType.valueOf(ZombieArena.getInstance().config.getRegularMobType()),
                ZombieArena.getInstance().config.getRegularMobHealth(),
                ZombieArena.getInstance().config.getRegularMobSpeed(),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-three.armor.helmet.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-three.armor.helmet.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-three.armor.helmet.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-three.armor.helmet.enchants")),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-three.armor.chestplate.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-three.armor.chestplate.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-three.armor.chestplate.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-three.armor.chestplate.enchants")),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-three.armor.leggings.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-three.armor.leggings.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-three.armor.leggings.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-three.armor.leggings.enchants")),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-three.armor.boots.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-three.armor.boots.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-three.armor.boots.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-three.armor.boots.enchants")));
    }

    public void spawnRegularMobUpgradeFour(Player attacker) {
        ZombieArena.getInstance().mobHandler.mobCreator(
                attacker,
                EntityType.valueOf(ZombieArena.getInstance().config.getRegularMobType()),
                ZombieArena.getInstance().config.getRegularMobHealth(),
                ZombieArena.getInstance().config.getRegularMobSpeed(),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-four.armor.helmet.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-four.armor.helmet.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-four.armor.helmet.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-four.armor.helmet.enchants")),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-four.armor.chestplate.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-four.armor.chestplate.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-four.armor.chestplate.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-four.armor.chestplate.enchants")),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-four.armor.leggings.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-four.armor.leggings.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-four.armor.leggings.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-four.armor.leggings.enchants")),
                regularMobArmor(ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-four.armor.boots.equip"),
                        ZombieArena.getInstance().getConfig().getString("regular-mob.upgrade-four.armor.boots.item"),
                        ZombieArena.getInstance().getConfig().getBoolean("regular-mob.upgrade-four.armor.boots.enable-enchants"),
                        ZombieArena.getInstance().getConfig().getStringList("regular-mob.upgrade-four.armor.boots.enchants")));
    }


    public ItemStack regularMobArmor(Boolean armorTypeEquip, String armorTypeItem, Boolean armorTypeEnableEnchants, List<String> armorTypeEnchants) {
        itemStack = new ItemStack(Material.AIR);
        if (armorTypeEquip) {
            itemStack = new ItemStack(Material.valueOf(armorTypeItem));
            itemMeta = itemStack.getItemMeta();
            if (armorTypeEnableEnchants) {
                for (String enchants : armorTypeEnchants) {
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
