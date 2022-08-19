//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.zach.zombiearena;

import org.bukkit.Material;

import java.util.List;

public class Config {
    public Config() {
        ZombieArena.getInstance().saveDefaultConfig();
    }

    public Integer getBronzeMin() {
        return ZombieArena.getInstance().getConfig().getInt("leagues.bronze.min-trophies");
    }

    public Integer getBronzeMax() {
        return ZombieArena.getInstance().getConfig().getInt("leagues.bronze.max-trophies");
    }

    public Integer getSilverMin() {
        return ZombieArena.getInstance().getConfig().getInt("leagues.silver.min-trophies");
    }

    public Integer getSilverMax() {
        return ZombieArena.getInstance().getConfig().getInt("leagues.silver.max-trophies");
    }

    public Integer getGoldMin() {
        return ZombieArena.getInstance().getConfig().getInt("leagues.gold.min-trophies");
    }

    public Integer getGoldMax() {
        return ZombieArena.getInstance().getConfig().getInt("leagues.gold.max-trophies");
    }

    public Integer getCrystalMin() {

        return ZombieArena.getInstance().getConfig().getInt("leagues.crystal.min-trophies");
    }

    public Integer getCrystalMax() {
        return ZombieArena.getInstance().getConfig().getInt("leagues.crystal.max-trophies");
    }

    public Integer getMasterMin() {
        return ZombieArena.getInstance().getConfig().getInt("leagues.master.min-trophies");
    }

    public Integer getMasterMax() {
        return ZombieArena.getInstance().getConfig().getInt("leagues.master.max-trophies");
    }

    public Integer getChampionMin() {
        return ZombieArena.getInstance().getConfig().getInt("leagues.champion.min-trophies");
    }

    public Integer getChampionMax() {
        return ZombieArena.getInstance().getConfig().getInt("leagues.champion.max-trophies");
    }

    public String getWorldName() {
        return ZombieArena.getInstance().getConfig().getString("world-name");
    }

    public Integer getArenaSize() {
        return ZombieArena.getInstance().getConfig().getInt("arena-size");
    }

    public Integer getDistanceAway() {
        return ZombieArena.getInstance().getConfig().getInt("distance-away");
    }

    public List<Integer> getArcherQueenPlaceHolderSlots(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.archer-queen-gui.placeholders." + keys + ".slots");
    }

    public Material getArcherQueenHealthUpgradeDisplayItem() {
        return Material.valueOf(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-display-item.material"));
    }

    public String getArcherQueenHealthUpgradeDisplayItemSection() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-display-item.material");
    }

    public String getArcherQueenHealthUpgradeDisplayItemDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-display-item.display-name");
    }

    public List<String> getArcherQueenHealthUpgradeDisplayItemLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.health-upgrade-display-item.lore");
    }

    public Boolean getArcherQueenHealthUpgradeDisplayItemEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.archer-queen-gui.health-upgrade-display-item.enchanted");
    }

    public Integer getArcherQueenHealthUpgradeDisplayItemSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.health-upgrade-display-item.slot");
    }

    public Material getArcherQueenHealthUpgradeLevelOneMaterial() {
        return Material.getMaterial(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-level-one-gui.material"));
    }

    public String getArcherQueenHealthUpgradeLevelOneDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-level-one-gui.display-name");
    }

    public List<String> getArcherQueenHealthUpgradeLevelOneLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.health-upgrade-level-one-gui.lore");
    }

    public Integer getArcherQueenHealthUpgradeLevelOneSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.health-upgrade-level-one-gui.slot");
    }

    public Double getArcherQueenhealthUpgradeLevelOneCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.archer-queen-gui.health-upgrade-level-one-gui.cost");
    }

    public String getArcherQueenHealthUpgradeLevelOneMaterialSection() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-level-one-gui.material");
    }

    public Material getArcherQueenHealthUpgradeLevelTwoMaterial() {
        return Material.getMaterial(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-level-two-gui.material"));
    }

    public String getArcherQueenHealthUpgradeLevelTwoDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-level-two-gui.display-name");
    }

    public List<String> getArcherQueenHealthUpgradeLevelTwoLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.health-upgrade-level-two-gui.lore");
    }

    public Integer getArcherQueenHealthUpgradeLevelTwoSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.health-upgrade-level-two-gui.slot");
    }

    public Integer getArcherQueenHealthUpgradeLevelTwoCost() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.health-upgrade-level-two-gui.cost");
    }

    public String getArcherQueenHealthUpgradeLevelTwoMaterialSection() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-level-two-gui.material");
    }

    public Material getArcherQueenHealthUpgradeLevelThreeMaterial() {
        return Material.getMaterial(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-level-three-gui.material"));
    }

    public String getArcherQueenHealthUpgradeLevelThreeDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-level-three-gui.display-name");
    }

    public List<String> getArcherQueenHealthUpgradeLevelThreeLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.health-upgrade-level-three-gui.lore");
    }

    public Integer getArcherQueenHealthUpgradeLevelThreeSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.health-upgrade-level-three-gui.slot");
    }

    public Integer getArcherQueenHealthUpgradeLevelThreeCost() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.health-upgrade-level-three-gui.cost");
    }

    public String getArcherQueenHealthUpgradeLevelThreeMaterialSection() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-level-three-gui.material");
    }

    public Material getArcherQueenHealthUpgradeLevelFourMaterial() {
        return Material.getMaterial(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-level-four-gui.material"));
    }

    public String getArcherQueenHealthUpgradeLevelFourDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-level-four-gui.display-name");
    }

    public List<String> getArcherQueenHealthUpgradeLevelFourLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.health-upgrade-level-four-gui.lore");
    }

    public Integer getArcherQueenHealthUpgradeLevelFourSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.health-upgrade-level-four-gui.slot");
    }

    public Integer getArcherQueenHealthUpgradeLevelFourCost() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.health-upgrade-level-four-gui.cost");
    }

    public String getArcherQueenHealthUpgradeLevelFourMaterialSection() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-level-four-gui.material");
    }


    public String getArcherQueenPlaceHolderMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.placeholders." + keys + ".material");
    }

    public Boolean getArcherQueenPlaceHolderEnchanted(String keys) {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.archer-queen-gui.placeholders." + keys + ".enchanted");
    }

    public String getArcherQueenType() {
        return ZombieArena.getInstance().getConfig().getString("archer-queen.entity-type");
    }

    public Integer getArcherQueenHealth() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.health");
    }

    public Integer getArcherQueenSpeed() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.speed");
    }

    public String getBarbarianKingType() {
        return ZombieArena.getInstance().getConfig().getString("barbarian-king.entity-type");
    }

    public Integer getBarbarianKingHealth() {
        return ZombieArena.getInstance().getConfig().getInt("barbarian-king.health");
    }

    public Integer getBarbarianKingSpeed() {
        return ZombieArena.getInstance().getConfig().getInt("barbarian-king.speed");
    }

    public String getHealerQueenType() {
        return ZombieArena.getInstance().getConfig().getString("healer-queen.entity-type");
    }

    public Integer getHealerQueenHealth() {
        return ZombieArena.getInstance().getConfig().getInt("healer-queen.health");
    }

    public Integer getHealerQueenSpeed() {
        return ZombieArena.getInstance().getConfig().getInt("healer-queen.default-speed");
    }

    public Integer getRegularMobHealth() {
        return ZombieArena.getInstance().getConfig().getInt("regular-mob.default-health");
    }

    public Double getRegularMobSpeed() {
        return ZombieArena.getInstance().getConfig().getDouble("regular-mob.default-speed");
    }

    public String getRegularMobType() {
        return ZombieArena.getInstance().getConfig().getString("regular-mob.entity-type");
    }

    public String getTankMobType() {
        return ZombieArena.getInstance().getConfig().getString("tank-mob.entity-type");
    }

    public int getTankMobHealth() {
        return ZombieArena.getInstance().getConfig().getInt("tank-mob.default-health");
    }

    public Double getTankMobSpeed() {
        return ZombieArena.getInstance().getConfig().getDouble("tank-mob-level-one.default-speed");
    }

}
