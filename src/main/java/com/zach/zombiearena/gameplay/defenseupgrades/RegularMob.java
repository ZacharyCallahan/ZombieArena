package com.zach.zombiearena.gameplay.defenseupgrades;

import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.gameplay.guis.regularmob.RegularMobArmorUpgradeGUI;
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
    private final RegularMobArmorUpgradeGUI regularMobArmorUpgradeGUI = new RegularMobArmorUpgradeGUI();
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

    public void spawnRegularMobUpgraded(Player attacker, UUID defenderUUID) {
        ZombieArena.getInstance().mobHandler.mobCreator(
                attacker,
                EntityType.valueOf(ZombieArena.getInstance().config.getRegularMobType()),
                ZombieArena.getInstance().config.getRegularMobHealth(),
                ZombieArena.getInstance().config.getRegularMobSpeed(),
                new ItemStack(Material.valueOf(regularMobArmorUpgradeGUI.getPlayersRegularMobArmor(defenderUUID) + "_HELMET")),
                new ItemStack(Material.valueOf(regularMobArmorUpgradeGUI.getPlayersRegularMobArmor(defenderUUID) + "_CHESTPLATE")),
                new ItemStack(Material.valueOf(regularMobArmorUpgradeGUI.getPlayersRegularMobArmor(defenderUUID) + "_LEGGINGS")),
                new ItemStack(Material.valueOf(regularMobArmorUpgradeGUI.getPlayersRegularMobArmor(defenderUUID) + "_BOOTS")));
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
