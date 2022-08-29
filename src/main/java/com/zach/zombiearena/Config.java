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

}
