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

    public Material getPurchasedUpgradeItemMaterial() {
        return Material.valueOf(ZombieArena.getInstance().getConfig().getString("purchase-upgrade-item.material"));
    }

    public String getPurchasedUpgradeItemDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("purchase-upgrade-item.display-name");
    }

    public List<String> getPurchasedUpgradeItemLore() {
        return ZombieArena.getInstance().getConfig().getStringList("purchase-upgrade-item.lore");
    }

    public Boolean getPurchasedUpgradeItemEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("purchase-upgrade-item.enchanted");
    }

    public Material getUpgradeUnavailableItemMaterial() {
        return Material.valueOf(ZombieArena.getInstance().getConfig().getString("upgrade-unavailable-item.material"));
    }

    public String getUpgradeUnavailableItemDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("upgrade-unavailable-item.display-name");
    }

    public List<String> getUpgradeUnavailableItemLore() {
        return ZombieArena.getInstance().getConfig().getStringList("upgrade-unavailable-item.lore");
    }

    public Boolean getUpgradeUnavailableItemEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("upgrade-unavailable-item.enchanted");
    }

    public Integer getArcherQueenDefaultHealth() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.health");
    }

    public List<Integer> getArcherQueenPlaceHolderSlots(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.archer-queen-gui.placeholders." + keys + ".slots");
    }

    public Integer getArcherQueenHealthLevelOne() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.health-upgrade-level-one");
    }

    public Integer getArcherQueenHealthLevelTwo() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.health-upgrade-level-two");
    }

    public Integer getArcherQueenHealthLevelThree() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.health-upgrade-level-three");
    }

    public Integer getArcherQueenHealthLevelFour() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.health-upgrade-level-four");
    }

    public Material getArcherQueenHealthUpgradeGuiMaterial() {
        return Material.valueOf(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.material"));
    }

    public String getArcherQueenHealthUpgradeGuiDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.display-name");
    }

    public List<String> getArcherQueenHealthUpgradeGuiLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.lore");
    }

    public Boolean getArcherQueenHealthUpgradeGuiEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.enchanted");
    }

    public Integer getArcherQueenHealthUpgradeGuiSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.slot");
    }

    public String getArcherQueenHealthUpgradeLevelOneDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-one.display-name");
    }

    public List<String> getArcherQueenHealthUpgradeLevelOneLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-one.lore");
    }

    public Integer getArcherQueenHealthUpgradeLevelOneSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-one.slot");
    }

    public Double getArcherQueenhealthUpgradeLevelOneCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-one.cost");
    }

    public Material getArcherQueenHealthUpgradeItemStatsPlaceHolder() {
        return Material.valueOf(ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-item-stats-placeholder.material"));
    }

    public Integer getArcherQueenHealthUpgradeItemStatsPlaceHolderSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-item-stats-placeholder.slot");
    }

    public Boolean getArcherQueenHealthUpgradeItemStatsPlaceHolderEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-item-stats-placeholder.enchanted");
    }

    public String getArcherQueenPlaceHolderMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.placeholders." + keys + ".material");
    }

    public String getArcherQueenHealthUpgradeLevelTwoDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-two.display-name");
    }

    public List<String> getArcherQueenHealthUpgradeLevelTwoLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-two.lore");
    }

    public Integer getArcherQueenHealthUpgradeLevelTwoSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-two.slot");
    }

    public Double getArcherQueenhealthUpgradeLevelTwoCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-two.cost");
    }

    public String getArcherQueenHealthUpgradeLevelThreeDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-three.display-name");
    }

    public List<String> getArcherQueenHealthUpgradeLevelThreeLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-three.lore");
    }

    public Integer getArcherQueenHealthUpgradeLevelThreeSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-three.slot");
    }

    public Double getArcherQueenhealthUpgradeLevelThreeCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-three.cost");
    }

    public String getArcherQueenHealthUpgradeLevelFourDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-four.display-name");
    }

    public List<String> getArcherQueenHealthUpgradeLevelFourLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-four.lore");
    }

    public Integer getArcherQueenHealthUpgradeLevelFourSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-four.slot");
    }

    public Double getArcherQueenhealthUpgradeLevelFourCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-level-four.cost");
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
