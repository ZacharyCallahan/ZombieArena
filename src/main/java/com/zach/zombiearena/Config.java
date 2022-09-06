package com.zach.zombiearena;

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

    public String getPurchasedUpgradeItemMaterial() {
        return ZombieArena.getInstance().getConfig().getString("purchase-upgrade-item.material");
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

    public String getUpgradeUnavailableItemMaterial() {
        return ZombieArena.getInstance().getConfig().getString("upgrade-unavailable-item.material");
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

    public String getArcherQueenGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.material");
    }

    public Integer getArcherQueenDefaultHealth() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.health");
    }

    public List<Integer> getArcherQueenUpgradeHealthGui(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.placeholders." + keys + ".slots");
    }

    public String getArcherQueenUpgradeHealthGuiMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.placeholders." + keys + ".material");
    }

    public List<Integer> getArcherQueenPlaceHolderSlots(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.archer-queen-gui.placeholders." + keys + ".slots");
    }

    public String getArcherQueenPlaceHolderStatsDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.archer-queen-stats-placeholder.display-name");
    }

    public Integer getArcherQueenPlaceHolderStatsSlots() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.archer-queen-stats-placeholder.slot");
    }

    public Boolean getArcherQueenPlaceHolderStatsEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.archer-queen-gui.archer-queen-stats-placeholder.enchanted");
    }

    public Integer getArcherQueenHealthLevelOne() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.health-upgrade-level-one.health");
    }

    public Integer getArcherQueenHealthLevelTwo() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.health-upgrade-level-two.health");
    }

    public Integer getArcherQueenHealthLevelThree() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.health-upgrade-level-three.health");
    }

    public Integer getArcherQueenHealthLevelFour() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.health-upgrade-level-four.health");
    }

    public Integer getArcherQueenImproveRadiusLevelOne() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.improve-radius-upgrade-level-one.radius");
    }

    public Integer getArcherQueenImproveRadiusLevelTwo() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.improve-radius-upgrade-level-two.radius");
    }

    public Integer getArcherQueenImproveRadiusLevelThree() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.improve-radius-upgrade-level-three.radius");
    }

    public Integer getArcherQueenImproveRadiusLevelFour() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.improve-radius-upgrade-level-four.radius");
    }

    public Integer getArcherQueenImproveSpeedAmountLevelOne() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.improve-speed-amount-upgrade-level-one.amount");
    }

    public Integer getArcherQueenImproveSpeedAmountLevelTwo() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.improve-speed-amount-upgrade-level-two.amount");
    }

    public Integer getArcherQueenImproveSpeedAmountLevelThree() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.improve-speed-amount-upgrade-level-three.amount");
    }

    public Integer getArcherQueenImproveSpeedAmountLevelFour() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.improve-speed-amount-upgrade-level-four.amount");
    }

    public String getArcherQueenHealthUpgradeGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.material");
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

    public List<String> getArcherQueenPurchaseLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.archer-queen-purchase.lore");
    }

    public Boolean getArcherQueenPurchaseEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.archer-queen-gui.archer-queen-purchase.enchanted");
    }

    public Double getArcherQueenPurchaseCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.archer-queen-gui.archer-queen-purchase.cost");
    }

    public String getArcherQueenPurchaseMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.archer-queen-purchase.material");
    }

    public String getArcherQueenHealthUpgradeItemStatsPlaceHolderDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-item-stats-placeholder.display-name");
    }

    public String getArcherQueenHealthUpgradeItemStatsPlaceHolder() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.health-upgrade-gui.health-upgrade-item-stats-placeholder.material");
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

    public Double getArcherQueenRadiusUpgradeLevelOneCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-one.cost");
    }

    public String getArcherQueenRadiusUpgradeLevelOneDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-one.display-name");
    }

    public int getArcherQueenRadiusUpgradeLevelOneSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-one.slot");
    }

    public List<String> getArcherQueenRadiusUpgradeLevelOneLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-one.lore");
    }

    public int getArcherQueenRadiusUpgradeLevelTwoSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-two.slot");
    }

    public int getArcherQueenRadiusUpgradeLevelThreeSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-three.slot");
    }

    public int getArcherQueenRadiusUpgradeLevelFourSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-four.slot");
    }

    public Integer getArcherQueenRadiusUpgradeLevelOneRadius() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.radius-upgrade-level-one.radius");
    }

    public Integer getArcherQueenRadiusUpgradeLevelTwoRadius() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.radius-upgrade-level-two.radius");
    }

    public Integer getArcherQueenRadiusUpgradeLevelThreeRadius() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.radius-upgrade-level-three.radius");
    }

    public Integer getArcherQueenRadiusUpgradeLevelFourRadius() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.radius-upgrade-level-four.radius");
    }

    public Integer getArcherQueenRadius() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.radius");
    }

    public String getArcherQueenRadiusUpgradeGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.material");
    }

    public String getArcherQueenRadiusUpgradeGuiDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.display-name");
    }

    public List<String> getArcherQueenRadiusUpgradeGuiLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.lore");
    }

    public boolean getArcherQueenRadiusUpgradeGuiEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.enchanted");
    }

    public int getArcherQueenRadiusUpgradeGuiSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.slot");
    }

    public String getArcherQueenUpgradeRadiusGuiMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.placeholders." + keys + ".material");
    }

    public List<Integer> getArcherQueenUpgradeRadiusGui(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.placeholders." + keys + ".slots");
    }

    public Integer getArcherQueenRadiusUpgradeItemStatsPlaceHolderSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-item-stats-placeholder.slot");
    }

    public String getArcherQueenRadiusUpgradeItemStatsPlaceHolderDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-item-stats-placeholder.display-name");
    }

    public String getArcherQueenRadiusUpgradeItemStatsPlaceHolder() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-item-stats-placeholder.material");
    }

    public Boolean getArcherQueenRadiusUpgradeItemStatsPlaceHolderEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-item-stats-placeholder.enchanted");
    }

    public Double getArcherQueenSpeedUpgradeLevelOneCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-one.cost");
    }

    public String getArcherQueenSpeedUpgradeLevelOneDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-one.display-name");
    }

    public int getArcherQueenSpeedUpgradeLevelOneSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-one.slot");
    }

    public List<String> getArcherQueenSpeedUpgradeLevelOneLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-one.lore");
    }

    public int getArcherQueenSpeedUpgradeLevelTwoSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-two.slot");
    }

    public int getArcherQueenSpeedUpgradeLevelThreeSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-three.slot");
    }

    public int getArcherQueenSpeedUpgradeLevelFourSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-four.slot");
    }

    public Double getArcherQueenSpeedUpgradeLevelOneSpeed() {
        return ZombieArena.getInstance().getConfig().getDouble("archer-queen.speed-amount-upgrade-level-one.speed");
    }

    public Double getArcherQueenSpeedUpgradeLevelTwoSpeed() {
        return ZombieArena.getInstance().getConfig().getDouble("archer-queen.speed-amount-upgrade-level-two.speed");
    }

    public Double getArcherQueenSpeedUpgradeLevelThreeSpeed() {
        return ZombieArena.getInstance().getConfig().getDouble("archer-queen.speed-amount-upgrade-level-three.speed");
    }

    public Double getArcherQueenSpeedUpgradeLevelFourSpeed() {
        return ZombieArena.getInstance().getConfig().getDouble("archer-queen.speed-amount-upgrade-level-four.speed");
    }

    public Integer getArcherQueenSpeed() {
        return ZombieArena.getInstance().getConfig().getInt("archer-queen.speed");
    }

    public String getArcherQueenSpeedUpgradeGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.material");
    }

    public String getArcherQueenSpeedUpgradeGuiDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.display-name");
    }

    public List<String> getArcherQueenSpeedUpgradeGuiLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.lore");
    }

    public boolean getArcherQueenSpeedUpgradeGuiEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.enchanted");
    }

    public int getArcherQueenSpeedUpgradeGuiSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.slot");
    }

    public String getArcherQueenUpgradeSpeedGuiMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.placeholders." + keys + ".material");
    }

    public List<Integer> getArcherQueenUpgradeSpeedGui(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.placeholders." + keys + ".slots");
    }

    public Integer getArcherQueenSpeedUpgradeItemStatsPlaceHolderSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-item-stats-placeholder.slot");
    }

    public String getArcherQueenSpeedUpgradeItemStatsPlaceHolderDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-item-stats-placeholder.display-name");
    }

    public String getArcherQueenSpeedUpgradeItemStatsPlaceHolder() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-item-stats-placeholder.material");
    }

    public Boolean getArcherQueenSpeedUpgradeItemStatsPlaceHolderEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-item-stats-placeholder.enchanted");
    }

    public String getArcherQueenRadiusUpgradeLevelTwoDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-two.display-name");
    }

    public List<String> getArcherQueenRadiusUpgradeLevelTwoLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-two.lore");
    }

    public Double getArcherQueenRadiusUpgradeLevelTwoCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-two.cost");
    }

    public String getArcherQueenRadiusUpgradeLevelThreeDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-three.display-name");
    }

    public List<String> getArcherQueenRadiusUpgradeLevelThreeLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-three.lore");
    }

    public Double getArcherQueenRadiusUpgradeLevelThreeCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-three.cost");
    }

    public String getArcherQueenRadiusUpgradeLevelFourDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-four.display-name");
    }

    public List<String> getArcherQueenRadiusUpgradeLevelFourLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-four.lore");
    }

    public Double getArcherQueenRadiusUpgradeLevelFourCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.archer-queen-gui.radius-upgrade-gui.radius-upgrade-level-four.cost");
    }

    public String getArcherQueenSpeedUpgradeLevelTwoDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-two.display-name");
    }

    public List<String> getArcherQueenSpeedUpgradeLevelTwoLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-two.lore");
    }

    public Double getArcherQueenSpeedUpgradeLevelTwoCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-two.cost");
    }

    public String getArcherQueenSpeedUpgradeLevelThreeDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-three.display-name");
    }

    public List<String> getArcherQueenSpeedUpgradeLevelThreeLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-three.lore");
    }

    public Double getArcherQueenSpeedUpgradeLevelThreeCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-three.cost");
    }

    public String getArcherQueenSpeedUpgradeLevelFourDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-four.display-name");
    }

    public List<String> getArcherQueenSpeedUpgradeLevelFourLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-four.lore");
    }

    public Double getArcherQueenSpeedUpgradeLevelFourCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.archer-queen-gui.speed-upgrade-gui.speed-upgrade-level-four.cost");
    }

    public String getBarbarianKingGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.material");
    }

    public Integer getBarbarianKingDefaultHealth() {
        return ZombieArena.getInstance().getConfig().getInt("barbarian-king.health");
    }

    public List<Integer> getBarbarianKingUpgradeHealthGui(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.placeholders." + keys + ".slots");
    }

    public String getBarbarianKingUpgradeHealthGuiMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.placeholders." + keys + ".material");
    }

    public List<Integer> getBarbarianKingPlaceHolderSlots(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.barbarian-king-gui.placeholders." + keys + ".slots");
    }

    public String getBarbarianKingPlaceHolderStatsDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.barbarian-king-stats-placeholder.display-name");
    }

    public Integer getBarbarianKingPlaceHolderStatsSlots() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.barbarian-king-stats-placeholder.slot");
    }

    public Boolean getBarbarianKingPlaceHolderStatsEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.barbarian-king-gui.barbarian-king-stats-placeholder.enchanted");
    }

    public Integer getBarbarianKingHealthLevelOne() {
        return ZombieArena.getInstance().getConfig().getInt("barbarian-king.health-upgrade-level-one.health");
    }

    public Integer getBarbarianKingHealthLevelTwo() {
        return ZombieArena.getInstance().getConfig().getInt("barbarian-king.health-upgrade-level-two.health");
    }

    public Integer getBarbarianKingHealthLevelThree() {
        return ZombieArena.getInstance().getConfig().getInt("barbarian-king.health-upgrade-level-three.health");
    }

    public Integer getBarbarianKingHealthLevelFour() {
        return ZombieArena.getInstance().getConfig().getInt("barbarian-king.health-upgrade-level-four.health");
    }

    public String getBarbarianKingHealthUpgradeGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.material");
    }

    public String getBarbarianKingHealthUpgradeGuiDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.display-name");
    }

    public List<String> getBarbarianKingHealthUpgradeGuiLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.lore");
    }

    public Boolean getBarbarianKingHealthUpgradeGuiEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.enchanted");
    }

    public Integer getBarbarianKingHealthUpgradeGuiSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.slot");
    }

    public String getBarbarianKingHealthUpgradeLevelOneDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-one.display-name");
    }

    public List<String> getBarbarianKingHealthUpgradeLevelOneLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-one.lore");
    }

    public Integer getBarbarianKingHealthUpgradeLevelOneSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-one.slot");
    }

    public Double getBarbarianKinghealthUpgradeLevelOneCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-one.cost");
    }

    public List<String> getBarbarianKingPurchaseLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.barbarian-king-purchase.lore");
    }

    public Boolean getBarbarianKingPurchaseEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.barbarian-king-gui.barbarian-king-purchase.enchanted");
    }

    public Double getBarbarianKingPurchaseCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.barbarian-king-gui.barbarian-king-purchase.cost");
    }

    public String getBarbarianKingPurchaseMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.barbarian-king-purchase.material");
    }

    public String getBarbarianKingHealthUpgradeItemStatsPlaceHolderDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-item-stats-placeholder.display-name");
    }

    public String getBarbarianKingHealthUpgradeItemStatsPlaceHolder() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-item-stats-placeholder.material");
    }

    public Integer getBarbarianKingHealthUpgradeItemStatsPlaceHolderSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-item-stats-placeholder.slot");
    }

    public Boolean getBarbarianKingHealthUpgradeItemStatsPlaceHolderEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-item-stats-placeholder.enchanted");
    }

    public String getBarbarianKingPlaceHolderMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.placeholders." + keys + ".material");
    }

    public String getBarbarianKingHealthUpgradeLevelTwoDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-two.display-name");
    }

    public List<String> getBarbarianKingHealthUpgradeLevelTwoLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-two.lore");
    }

    public Integer getBarbarianKingHealthUpgradeLevelTwoSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-two.slot");
    }

    public Double getBarbarianKinghealthUpgradeLevelTwoCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-two.cost");
    }

    public String getBarbarianKingHealthUpgradeLevelThreeDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-three.display-name");
    }

    public List<String> getBarbarianKingHealthUpgradeLevelThreeLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-three.lore");
    }

    public Integer getBarbarianKingHealthUpgradeLevelThreeSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-three.slot");
    }

    public Double getBarbarianKinghealthUpgradeLevelThreeCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-three.cost");
    }

    public String getBarbarianKingHealthUpgradeLevelFourDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-four.display-name");
    }

    public List<String> getBarbarianKingHealthUpgradeLevelFourLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-four.lore");
    }

    public Integer getBarbarianKingHealthUpgradeLevelFourSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-four.slot");
    }

    public Double getBarbarianKinghealthUpgradeLevelFourCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.barbarian-king-gui.health-upgrade-gui.health-upgrade-level-four.cost");
    }

    public Double getBarbarianKingRadiusUpgradeLevelOneCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-one.cost");
    }

    public String getBarbarianKingRadiusUpgradeLevelOneDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-one.display-name");
    }

    public int getBarbarianKingRadiusUpgradeLevelOneSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-one.slot");
    }

    public List<String> getBarbarianKingRadiusUpgradeLevelOneLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-one.lore");
    }

    public int getBarbarianKingRadiusUpgradeLevelTwoSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-two.slot");
    }

    public int getBarbarianKingRadiusUpgradeLevelThreeSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-three.slot");
    }

    public int getBarbarianKingRadiusUpgradeLevelFourSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-four.slot");
    }

    public Integer getBarbarianKingRadiusUpgradeLevelOneRadius() {
        return ZombieArena.getInstance().getConfig().getInt("barbarian-king.radius-upgrade-level-one.radius");
    }

    public Integer getBarbarianKingRadiusUpgradeLevelTwoRadius() {
        return ZombieArena.getInstance().getConfig().getInt("barbarian-king.radius-upgrade-level-two.radius");
    }

    public Integer getBarbarianKingRadiusUpgradeLevelThreeRadius() {
        return ZombieArena.getInstance().getConfig().getInt("barbarian-king.radius-upgrade-level-three.radius");
    }

    public Integer getBarbarianKingRadiusUpgradeLevelFourRadius() {
        return ZombieArena.getInstance().getConfig().getInt("barbarian-king.radius-upgrade-level-four.radius");
    }

    public Integer getBarbarianKingRadius() {
        return ZombieArena.getInstance().getConfig().getInt("barbarian-king.radius");
    }

    public String getBarbarianKingRadiusUpgradeGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.material");
    }

    public String getBarbarianKingRadiusUpgradeGuiDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.display-name");
    }

    public List<String> getBarbarianKingRadiusUpgradeGuiLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.lore");
    }

    public boolean getBarbarianKingRadiusUpgradeGuiEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.enchanted");
    }

    public int getBarbarianKingRadiusUpgradeGuiSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.slot");
    }

    public String getBarbarianKingUpgradeRadiusGuiMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.placeholders." + keys + ".material");
    }

    public List<Integer> getBarbarianKingUpgradeRadiusGui(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.placeholders." + keys + ".slots");
    }

    public Integer getBarbarianKingRadiusUpgradeItemStatsPlaceHolderSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-item-stats-placeholder.slot");
    }

    public String getBarbarianKingRadiusUpgradeItemStatsPlaceHolderDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-item-stats-placeholder.display-name");
    }

    public String getBarbarianKingRadiusUpgradeItemStatsPlaceHolder() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-item-stats-placeholder.material");
    }

    public Boolean getBarbarianKingRadiusUpgradeItemStatsPlaceHolderEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-item-stats-placeholder.enchanted");
    }

    public String getBarbarianKingRadiusUpgradeLevelTwoDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-two.display-name");
    }

    public List<String> getBarbarianKingRadiusUpgradeLevelTwoLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-two.lore");
    }

    public Double getBarbarianKingRadiusUpgradeLevelTwoCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-two.cost");
    }

    public String getBarbarianKingRadiusUpgradeLevelThreeDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-three.display-name");
    }

    public List<String> getBarbarianKingRadiusUpgradeLevelThreeLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-three.lore");
    }

    public Double getBarbarianKingRadiusUpgradeLevelThreeCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-three.cost");
    }

    public String getBarbarianKingRadiusUpgradeLevelFourDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-four.display-name");
    }

    public List<String> getBarbarianKingRadiusUpgradeLevelFourLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-four.lore");
    }

    public Double getBarbarianKingRadiusUpgradeLevelFourCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.barbarian-king-gui.radius-upgrade-gui.radius-upgrade-level-four.cost");
    }

    public Double getBarbarianKingArmorUpgradeLevelOneCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-one.cost");
    }

    public String getBarbarianKingArmorUpgradeLevelOneDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-one.display-name");
    }

    public int getBarbarianKingArmorUpgradeLevelOneSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-one.slot");
    }

    public List<String> getBarbarianKingArmorUpgradeLevelOneLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-one.lore");
    }

    public int getBarbarianKingArmorUpgradeLevelTwoSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-two.slot");
    }

    public int getBarbarianKingArmorUpgradeLevelThreeSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-three.slot");
    }

    public int getBarbarianKingArmorUpgradeLevelFourSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-four.slot");
    }

    public String getBarbarianKingArmorLevelOne() {
        return ZombieArena.getInstance().getConfig().getString("barbarian-king.armor-upgrade-level-one.armor");
    }

    public String getBarbarianKingArmorLevelTwo() {
        return ZombieArena.getInstance().getConfig().getString("barbarian-king.armor-upgrade-level-two.armor");
    }

    public String getBarbarianKingArmorLevelThree() {
        return ZombieArena.getInstance().getConfig().getString("barbarian-king.armor-upgrade-level-three.armor");
    }

    public String getBarbarianKingArmorLevelFour() {
        return ZombieArena.getInstance().getConfig().getString("barbarian-king.armor-upgrade-level-four.armor");
    }

    public String getBarbarianKingArmor() {
        return ZombieArena.getInstance().getConfig().getString("barbarian-king.armor");
    }

    public String getBarbarianKingArmorUpgradeGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.material");
    }

    public String getBarbarianKingArmorUpgradeGuiDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.display-name");
    }

    public List<String> getBarbarianKingArmorUpgradeGuiLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.lore");
    }

    public boolean getBarbarianKingArmorUpgradeGuiEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.enchanted");
    }

    public int getBarbarianKingArmorUpgradeGuiSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.slot");
    }

    public String getBarbarianKingUpgradeArmorGuiMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.placeholders." + keys + ".material");
    }

    public List<Integer> getBarbarianKingUpgradeArmorGui(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.placeholders." + keys + ".slots");
    }

    public Integer getBarbarianKingArmorUpgradeItemStatsPlaceHolderSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-item-stats-placeholder.slot");
    }

    public String getBarbarianKingArmorUpgradeItemStatsPlaceHolderDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-item-stats-placeholder.display-name");
    }

    public String getBarbarianKingArmorUpgradeItemStatsPlaceHolder() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-item-stats-placeholder.material");
    }

    public Boolean getBarbarianKingArmorUpgradeItemStatsPlaceHolderEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-item-stats-placeholder.enchanted");
    }

    public String getBarbarianKingArmorUpgradeLevelTwoDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-two.display-name");
    }

    public List<String> getBarbarianKingArmorUpgradeLevelTwoLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-two.lore");
    }

    public Double getBarbarianKingArmorUpgradeLevelTwoCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-two.cost");
    }

    public String getBarbarianKingArmorUpgradeLevelThreeDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-three.display-name");
    }

    public List<String> getBarbarianKingArmorUpgradeLevelThreeLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-three.lore");
    }

    public Double getBarbarianKingArmorUpgradeLevelThreeCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-three.cost");
    }

    public String getBarbarianKingArmorUpgradeLevelFourDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-four.display-name");
    }

    public List<String> getBarbarianKingArmorUpgradeLevelFourLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-four.lore");
    }

    public Double getBarbarianKingArmorUpgradeLevelFourCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.barbarian-king-gui.armor-upgrade-gui.armor-upgrade-level-four.cost");
    }

    public String getHealerQueenGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.material");
    }

    public Integer getHealerQueenDefaultHealth() {
        return ZombieArena.getInstance().getConfig().getInt("healer-queen.health");
    }

    public List<Integer> getHealerQueenUpgradeHealthGui(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.placeholders." + keys + ".slots");
    }

    public String getHealerQueenUpgradeHealthGuiMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.placeholders." + keys + ".material");
    }

    public List<Integer> getHealerQueenPlaceHolderSlots(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.healer-queen-gui.placeholders." + keys + ".slots");
    }

    public String getHealerQueenPlaceHolderStatsDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.healer-queen-stats-placeholder.display-name");
    }

    public Integer getHealerQueenPlaceHolderStatsSlots() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.healer-queen-stats-placeholder.slot");
    }

    public Boolean getHealerQueenPlaceHolderStatsEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.healer-queen-gui.healer-queen-stats-placeholder.enchanted");
    }

    public Integer getHealerQueenHealthLevelOne() {
        return ZombieArena.getInstance().getConfig().getInt("healer-queen.health-upgrade-level-one.health");
    }

    public Integer getHealerQueenHealthLevelTwo() {
        return ZombieArena.getInstance().getConfig().getInt("healer-queen.health-upgrade-level-two.health");
    }

    public Integer getHealerQueenHealthLevelThree() {
        return ZombieArena.getInstance().getConfig().getInt("healer-queen.health-upgrade-level-three.health");
    }

    public Integer getHealerQueenHealthLevelFour() {
        return ZombieArena.getInstance().getConfig().getInt("healer-queen.health-upgrade-level-four.health");
    }

    public String getHealerQueenHealthUpgradeGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.material");
    }

    public String getHealerQueenHealthUpgradeGuiDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.display-name");
    }

    public List<String> getHealerQueenHealthUpgradeGuiLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.lore");
    }

    public Boolean getHealerQueenHealthUpgradeGuiEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.enchanted");
    }

    public Integer getHealerQueenHealthUpgradeGuiSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.slot");
    }

    public String getHealerQueenHealthUpgradeLevelOneDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-one.display-name");
    }

    public List<String> getHealerQueenHealthUpgradeLevelOneLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-one.lore");
    }

    public Integer getHealerQueenHealthUpgradeLevelOneSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-one.slot");
    }

    public Double getHealerQueenhealthUpgradeLevelOneCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-one.cost");
    }

    public List<String> getHealerQueenPurchaseLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.healer-queen-purchase.lore");
    }

    public Boolean getHealerQueenPurchaseEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.healer-queen-gui.healer-queen-purchase.enchanted");
    }

    public Double getHealerQueenPurchaseCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.healer-queen-gui.healer-queen-purchase.cost");
    }

    public String getHealerQueenPurchaseMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.healer-queen-purchase.material");
    }

    public String getHealerQueenHealthUpgradeItemStatsPlaceHolderDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-item-stats-placeholder.display-name");
    }

    public String getHealerQueenHealthUpgradeItemStatsPlaceHolder() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-item-stats-placeholder.material");
    }

    public Integer getHealerQueenHealthUpgradeItemStatsPlaceHolderSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-item-stats-placeholder.slot");
    }

    public Boolean getHealerQueenHealthUpgradeItemStatsPlaceHolderEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-item-stats-placeholder.enchanted");
    }

    public String getHealerQueenPlaceHolderMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.placeholders." + keys + ".material");
    }

    public String getHealerQueenHealthUpgradeLevelTwoDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-two.display-name");
    }

    public List<String> getHealerQueenHealthUpgradeLevelTwoLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-two.lore");
    }

    public Integer getHealerQueenHealthUpgradeLevelTwoSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-two.slot");
    }

    public Double getHealerQueenhealthUpgradeLevelTwoCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-two.cost");
    }

    public String getHealerQueenHealthUpgradeLevelThreeDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-three.display-name");
    }

    public List<String> getHealerQueenHealthUpgradeLevelThreeLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-three.lore");
    }

    public Integer getHealerQueenHealthUpgradeLevelThreeSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-three.slot");
    }

    public Double getHealerQueenhealthUpgradeLevelThreeCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-three.cost");
    }

    public String getHealerQueenHealthUpgradeLevelFourDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-four.display-name");
    }

    public List<String> getHealerQueenHealthUpgradeLevelFourLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-four.lore");
    }

    public Integer getHealerQueenHealthUpgradeLevelFourSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-four.slot");
    }

    public Double getHealerQueenhealthUpgradeLevelFourCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.healer-queen-gui.health-upgrade-gui.health-upgrade-level-four.cost");
    }

    public Double getHealerQueenRadiusUpgradeLevelOneCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-one.cost");
    }

    public String getHealerQueenRadiusUpgradeLevelOneDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-one.display-name");
    }

    public int getHealerQueenRadiusUpgradeLevelOneSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-one.slot");
    }

    public List<String> getHealerQueenRadiusUpgradeLevelOneLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-one.lore");
    }

    public int getHealerQueenRadiusUpgradeLevelTwoSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-two.slot");
    }

    public int getHealerQueenRadiusUpgradeLevelThreeSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-three.slot");
    }

    public int getHealerQueenRadiusUpgradeLevelFourSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-four.slot");
    }

    public Integer getHealerQueenRadiusUpgradeLevelOneRadius() {
        return ZombieArena.getInstance().getConfig().getInt("healer-queen.radius-upgrade-level-one.radius");
    }

    public Integer getHealerQueenRadiusUpgradeLevelTwoRadius() {
        return ZombieArena.getInstance().getConfig().getInt("healer-queen.radius-upgrade-level-two.radius");
    }

    public Integer getHealerQueenRadiusUpgradeLevelThreeRadius() {
        return ZombieArena.getInstance().getConfig().getInt("healer-queen.radius-upgrade-level-three.radius");
    }

    public Integer getHealerQueenRadiusUpgradeLevelFourRadius() {
        return ZombieArena.getInstance().getConfig().getInt("healer-queen.radius-upgrade-level-four.radius");
    }

    public Integer getHealerQueenRadius() {
        return ZombieArena.getInstance().getConfig().getInt("healer-queen.radius");
    }

    public String getHealerQueenRadiusUpgradeGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.material");
    }

    public String getHealerQueenRadiusUpgradeGuiDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.display-name");
    }

    public List<String> getHealerQueenRadiusUpgradeGuiLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.lore");
    }

    public boolean getHealerQueenRadiusUpgradeGuiEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.enchanted");
    }

    public int getHealerQueenRadiusUpgradeGuiSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.slot");
    }

    public String getHealerQueenUpgradeRadiusGuiMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.placeholders." + keys + ".material");
    }

    public List<Integer> getHealerQueenUpgradeRadiusGui(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.placeholders." + keys + ".slots");
    }

    public Integer getHealerQueenRadiusUpgradeItemStatsPlaceHolderSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-item-stats-placeholder.slot");
    }

    public String getHealerQueenRadiusUpgradeItemStatsPlaceHolderDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-item-stats-placeholder.display-name");
    }

    public String getHealerQueenRadiusUpgradeItemStatsPlaceHolder() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-item-stats-placeholder.material");
    }

    public Boolean getHealerQueenRadiusUpgradeItemStatsPlaceHolderEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-item-stats-placeholder.enchanted");
    }

    public String getHealerQueenRadiusUpgradeLevelTwoDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-two.display-name");
    }

    public List<String> getHealerQueenRadiusUpgradeLevelTwoLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-two.lore");
    }

    public Double getHealerQueenRadiusUpgradeLevelTwoCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-two.cost");
    }

    public String getHealerQueenRadiusUpgradeLevelThreeDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-three.display-name");
    }

    public List<String> getHealerQueenRadiusUpgradeLevelThreeLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-three.lore");
    }

    public Double getHealerQueenRadiusUpgradeLevelThreeCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-three.cost");
    }

    public String getHealerQueenRadiusUpgradeLevelFourDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-four.display-name");
    }

    public List<String> getHealerQueenRadiusUpgradeLevelFourLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-four.lore");
    }

    public Double getHealerQueenRadiusUpgradeLevelFourCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.healer-queen-gui.radius-upgrade-gui.radius-upgrade-level-four.cost");
    }

    public Double getHealerQueenHealUpgradeLevelOneCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-one.cost");
    }

    public String getHealerQueenHealUpgradeLevelOneDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-one.display-name");
    }

    public int getHealerQueenHealUpgradeLevelOneSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-one.slot");
    }

    public List<String> getHealerQueenHealUpgradeLevelOneLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-one.lore");
    }

    public int getHealerQueenHealUpgradeLevelTwoSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-two.slot");
    }

    public int getHealerQueenHealUpgradeLevelThreeSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-three.slot");
    }

    public int getHealerQueenHealUpgradeLevelFourSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-four.slot");
    }

    public Double getHealerQueenHealUpgradeLevelOneHeal() {
        return ZombieArena.getInstance().getConfig().getDouble("healer-queen.heal-upgrade-level-one.heal");
    }

    public Double getHealerQueenHealUpgradeLevelTwoHeal() {
        return ZombieArena.getInstance().getConfig().getDouble("healer-queen.heal-upgrade-level-two.heal");
    }

    public Double getHealerQueenHealUpgradeLevelThreeHeal() {
        return ZombieArena.getInstance().getConfig().getDouble("healer-queen.heal-upgrade-level-three.heal");
    }

    public Double getHealerQueenHealUpgradeLevelFourHeal() {
        return ZombieArena.getInstance().getConfig().getDouble("healer-queen.heal-upgrade-level-four.heal");
    }

    public Double getHealerQueenHeal() {
        return ZombieArena.getInstance().getConfig().getDouble("healer-queen.heal");
    }

    public String getHealerQueenHealUpgradeGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.material");
    }

    public String getHealerQueenHealUpgradeGuiDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.display-name");
    }

    public List<String> getHealerQueenHealUpgradeGuiLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.lore");
    }

    public boolean getHealerQueenHealUpgradeGuiEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.enchanted");
    }

    public int getHealerQueenHealUpgradeGuiSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.slot");
    }

    public String getHealerQueenUpgradeHealGuiMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.placeholders." + keys + ".material");
    }

    public List<Integer> getHealerQueenUpgradeHealGui(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.placeholders." + keys + ".slots");
    }

    public Integer getHealerQueenHealUpgradeItemStatsPlaceHolderSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-item-stats-placeholder.slot");
    }

    public String getHealerQueenHealUpgradeItemStatsPlaceHolderDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-item-stats-placeholder.display-name");
    }

    public String getHealerQueenHealUpgradeItemStatsPlaceHolder() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-item-stats-placeholder.material");
    }

    public Boolean getHealerQueenHealUpgradeItemStatsPlaceHolderEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-item-stats-placeholder.enchanted");
    }

    public String getHealerQueenHealUpgradeLevelTwoDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-two.display-name");
    }

    public List<String> getHealerQueenHealUpgradeLevelTwoLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-two.lore");
    }

    public Double getHealerQueenHealUpgradeLevelTwoCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-two.cost");
    }

    public String getHealerQueenHealUpgradeLevelThreeDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-three.display-name");
    }

    public List<String> getHealerQueenHealUpgradeLevelThreeLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-three.lore");
    }

    public Double getHealerQueenHealUpgradeLevelThreeCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-three.cost");
    }

    public String getHealerQueenHealUpgradeLevelFourDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-four.display-name");
    }

    public List<String> getHealerQueenHealUpgradeLevelFourLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-four.lore");
    }

    public Double getHealerQueenHealUpgradeLevelFourCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.healer-queen-gui.heal-upgrade-gui.heal-upgrade-level-four.cost");
    }

    public String getRegularMobGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.material");
    }

    public List<Integer> getRegularMobPlaceHolderSlots(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.regular-mob-gui.placeholders." + keys + ".slots");
    }

    public String getRegularMobPlaceHolderStatsDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.regular-mob-stats-placeholder.display-name");
    }

    public Integer getRegularMobPlaceHolderStatsSlots() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.regular-mob-gui.regular-mob-stats-placeholder.slot");
    }

    public Boolean getRegularMobPlaceHolderStatsEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.regular-mob-gui.regular-mob-stats-placeholder.enchanted");
    }


    public List<String> getRegularMobPurchaseLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.regular-mob-gui.regular-mob-purchase.lore");
    }

    public Boolean getRegularMobPurchaseEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.regular-mob-gui.regular-mob-purchase.enchanted");
    }

    public Double getRegularMobPurchaseCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.regular-mob-gui.regular-mob-purchase.cost");
    }

    public String getRegularMobPurchaseMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.regular-mob-purchase.material");
    }

    public String getRegularMobPlaceHolderMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.placeholders." + keys + ".material");
    }

    public Double getRegularMobArmorUpgradeLevelOneCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-one.cost");
    }

    public String getRegularMobArmorUpgradeLevelOneDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-one.display-name");
    }

    public int getRegularMobArmorUpgradeLevelOneSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-one.slot");
    }

    public List<String> getRegularMobArmorUpgradeLevelOneLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-one.lore");
    }

    public int getRegularMobArmorUpgradeLevelTwoSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-two.slot");
    }

    public int getRegularMobArmorUpgradeLevelThreeSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-three.slot");
    }

    public int getRegularMobArmorUpgradeLevelFourSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-four.slot");
    }

    public String getRegularMobArmorLevelOne() {
        return ZombieArena.getInstance().getConfig().getString("regular-mob.armor-upgrade-level-one.armor");
    }

    public String getRegularMobArmorLevelTwo() {
        return ZombieArena.getInstance().getConfig().getString("regular-mob.armor-upgrade-level-two.armor");
    }

    public String getRegularMobArmorLevelThree() {
        return ZombieArena.getInstance().getConfig().getString("regular-mob.armor-upgrade-level-three.armor");
    }

    public String getRegularMobArmorLevelFour() {
        return ZombieArena.getInstance().getConfig().getString("regular-mob.armor-upgrade-level-four.armor");
    }

    public String getRegularMobArmor() {
        return ZombieArena.getInstance().getConfig().getString("regular-mob.armor");
    }

    public String getRegularMobArmorUpgradeGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.material");
    }

    public String getRegularMobArmorUpgradeGuiDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.display-name");
    }

    public List<String> getRegularMobArmorUpgradeGuiLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.lore");
    }

    public boolean getRegularMobArmorUpgradeGuiEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.enchanted");
    }

    public int getRegularMobArmorUpgradeGuiSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.slot");
    }

    public String getRegularMobUpgradeArmorGuiMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.placeholders." + keys + ".material");
    }

    public List<Integer> getRegularMobUpgradeArmorGui(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.placeholders." + keys + ".slots");
    }

    public Integer getRegularMobArmorUpgradeItemStatsPlaceHolderSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-item-stats-placeholder.slot");
    }

    public String getRegularMobArmorUpgradeItemStatsPlaceHolderDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-item-stats-placeholder.display-name");
    }

    public String getRegularMobArmorUpgradeItemStatsPlaceHolder() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-item-stats-placeholder.material");
    }

    public Boolean getRegularMobArmorUpgradeItemStatsPlaceHolderEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-item-stats-placeholder.enchanted");
    }

    public String getRegularMobArmorUpgradeLevelTwoDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-two.display-name");
    }

    public List<String> getRegularMobArmorUpgradeLevelTwoLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-two.lore");
    }

    public Double getRegularMobArmorUpgradeLevelTwoCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-two.cost");
    }

    public String getRegularMobArmorUpgradeLevelThreeDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-three.display-name");
    }

    public List<String> getRegularMobArmorUpgradeLevelThreeLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-three.lore");
    }

    public Double getRegularMobArmorUpgradeLevelThreeCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-three.cost");
    }

    public String getRegularMobArmorUpgradeLevelFourDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-four.display-name");
    }

    public List<String> getRegularMobArmorUpgradeLevelFourLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-four.lore");
    }

    public Double getRegularMobArmorUpgradeLevelFourCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.regular-mob-gui.armor-upgrade-gui.armor-upgrade-level-four.cost");
    }

    public String getWaveAttackGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.material");
    }

    public List<Integer> getWaveAttackPlaceHolderSlots(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.wave-attack-gui.placeholders." + keys + ".slots");
    }

    public String getWaveAttackPlaceHolderStatsDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.wave-attack-stats-placeholder.display-name");
    }

    public Integer getWaveAttackPlaceHolderStatsSlots() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.wave-attack-gui.wave-attack-stats-placeholder.slot");
    }

    public Boolean getWaveAttackPlaceHolderStatsEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.wave-attack-gui.wave-attack-stats-placeholder.enchanted");
    }


    public List<String> getWaveAttackPurchaseLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.wave-attack-gui.wave-attack-purchase.lore");
    }

    public Boolean getWaveAttackPurchaseEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.wave-attack-gui.wave-attack-purchase.enchanted");
    }

    public Double getWaveAttackPurchaseCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.wave-attack-gui.wave-attack-purchase.cost");
    }

    public String getWaveAttackPurchaseMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.wave-attack-purchase.material");
    }

    public String getWaveAttackPlaceHolderMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.placeholders." + keys + ".material");
    }

    public Double getWaveAttackUpgradeLevelOneCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-one.cost");
    }

    public String getWaveAttackUpgradeLevelOneDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-one.display-name");
    }

    public int getWaveAttackUpgradeLevelOneSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-one.slot");
    }

    public List<String> getWaveAttackUpgradeLevelOneLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-one.lore");
    }

    public int getWaveAttackUpgradeLevelTwoSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-two.slot");
    }

    public int getWaveAttackUpgradeLevelThreeSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-three.slot");
    }

    public int getWaveAttackUpgradeLevelFourSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-four.slot");
    }

    public String getWaveAttackLevelOne() {
        return ZombieArena.getInstance().getConfig().getString("wave-attack.upgrade-level-one.amount");
    }

    public String getWaveAttackLevelTwo() {
        return ZombieArena.getInstance().getConfig().getString("wave-attack.upgrade-level-two.amount");
    }

    public String getWaveAttackLevelThree() {
        return ZombieArena.getInstance().getConfig().getString("wave-attack.upgrade-level-three.amount");
    }

    public String getWaveAttackLevelFour() {
        return ZombieArena.getInstance().getConfig().getString("wave-attack.upgrade-level-four.amount");
    }

    public String getWaveAttack() {
        return ZombieArena.getInstance().getConfig().getString("wave-attack.amount");
    }

    public String getWaveAttackUpgradeGuiMaterial() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.upgrade-gui.material");
    }

    public String getWaveAttackUpgradeGuiDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.upgrade-gui.display-name");
    }

    public List<String> getWaveAttackUpgradeGuiLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.wave-attack-gui.upgrade-gui.lore");
    }

    public boolean getWaveAttackUpgradeGuiEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.wave-attack-gui.upgrade-gui.enchanted");
    }

    public int getWaveAttackUpgradeGuiSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.wave-attack-gui.upgrade-gui.slot");
    }

    public String getWaveAttackUpgradeGuiMaterialSection(String keys) {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.upgrade-gui.placeholders." + keys + ".material");
    }

    public List<Integer> getWaveAttackUpgradeGui(String keys) {
        return ZombieArena.getInstance().getConfig().getIntegerList("defensegui.upgrades.wave-attack-gui.upgrade-gui.placeholders." + keys + ".slots");
    }

    public Integer getWaveAttackUpgradeItemStatsPlaceHolderSlot() {
        return ZombieArena.getInstance().getConfig().getInt("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-item-stats-placeholder.slot");
    }

    public String getWaveAttackUpgradeItemStatsPlaceHolderDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-item-stats-placeholder.display-name");
    }

    public String getWaveAttackUpgradeItemStatsPlaceHolder() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-item-stats-placeholder.material");
    }

    public Boolean getWaveAttackUpgradeItemStatsPlaceHolderEnchanted() {
        return ZombieArena.getInstance().getConfig().getBoolean("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-item-stats-placeholder.enchanted");
    }

    public String getWaveAttackUpgradeLevelTwoDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-two.display-name");
    }

    public List<String> getWaveAttackUpgradeLevelTwoLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-two.lore");
    }

    public Double getWaveAttackUpgradeLevelTwoCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-two.cost");
    }

    public String getWaveAttackUpgradeLevelThreeDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-three.display-name");
    }

    public List<String> getWaveAttackUpgradeLevelThreeLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-three.lore");
    }

    public Double getWaveAttackUpgradeLevelThreeCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-three.cost");
    }

    public String getWaveAttackUpgradeLevelFourDisplayName() {
        return ZombieArena.getInstance().getConfig().getString("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-four.display-name");
    }

    public List<String> getWaveAttackUpgradeLevelFourLore() {
        return ZombieArena.getInstance().getConfig().getStringList("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-four.lore");
    }

    public Double getWaveAttackUpgradeLevelFourCost() {
        return ZombieArena.getInstance().getConfig().getDouble("defensegui.upgrades.wave-attack-gui.upgrade-gui.upgrade-level-four.cost");
    }

    public Integer getRegularMobChanceLevelOne(Integer level) {
        if (level == 1) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-one.spawn-chance-level-one");
        }
        if (level == 2) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-one.spawn-chance-level-two");
        }
        if (level == 3) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-one.spawn-chance-level-three");
        }
        if (level == 4) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-one.spawn-chance-level-four");
        }
        return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-one.default-spawn-chance");

    }

    public Integer getRegularMobChanceLevelTwo(Integer level) {
        if (level == 1) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-two.spawn-chance-level-one");
        }
        if (level == 2) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-two.spawn-chance-level-two");
        }
        if (level == 3) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-two.spawn-chance-level-three");
        }
        if (level == 4) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-two.spawn-chance-level-four");
        }
        return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-two.default-spawn-chance");
    }

    public Integer getRegularMobChanceLevelThree(Integer level) {
        if (level == 1) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-three.spawn-chance-level-one");
        }
        if (level == 2) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-three.spawn-chance-level-two");
        }
        if (level == 3) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-three.spawn-chance-level-three");
        }
        if (level == 4) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-three.spawn-chance-level-four");
        }
        return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-three.default-spawn-chance");
    }

    public Integer getRegularMobChanceLevelFour(Integer level) {
        if (level == 1) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-four.spawn-chance-level-one");
        }
        if (level == 2) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-four.spawn-chance-level-two");
        }
        if (level == 3) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-four.spawn-chance-level-three");
        }
        if (level == 4) {
            return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-four.spawn-chance-level-four");
        }
        return ZombieArena.getInstance().getConfig().getInt("regular-mob.armor-upgrade-level-four.default-spawn-chance");
    }

}
