package com.zach.zombiearena.gameplay;

import com.zach.zombiearena.DataManager;
import com.zach.zombiearena.Messages;
import com.zach.zombiearena.ZombieArena;
import com.zach.zombiearena.utils.ProbabilityUntilities;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.*;

public class Waves {
    private DataManager dataManager = new DataManager();
    int sectionNumber = 0;
    ConfigurationSection section;
    HashMap<UUID, Integer> waveTimer = new HashMap<>();
    HashMap<UUID, Integer> gracePeriod = new HashMap<>();
    HashMap<UUID, Integer> waveNumber = new HashMap<>();
    public HashMap<UUID, Integer> regularMobUpgradeLevel = new HashMap<>();
    public HashMap<UUID, Integer> endOfWaveAttackLevel = new HashMap<>();
    public HashMap<UUID, Integer> waveManagerRunnables = new HashMap<>();
    public HashMap<UUID, Integer> waveSpawningRunnables = new HashMap<>();
    ProbabilityUntilities probabilities = new ProbabilityUntilities();


    public void startGame(Player attacker, UUID defender) {

        section = ZombieArena.getInstance().getConfig().getConfigurationSection("waves");
        if (section == null) return;

        for (String keys : section.getKeys(false)) {
            sectionNumber = Integer.parseInt(keys);
        }
        setGracePeriod(attacker.getUniqueId(), ZombieArena.getInstance().getConfig().getInt("waves-grace-period"));
        setWaveTimer(attacker.getUniqueId(), ZombieArena.getInstance().getConfig().getInt("waves." + 0 + ".wave-length"));
        final int[] waveTimerCountDown = {getWaveTimer(attacker.getUniqueId())};
        final int[] gracePeriodNumber = {getGracePeriod(attacker.getUniqueId())};
        startWaveManagerRunnable(attacker, defender, waveTimerCountDown, gracePeriodNumber);


    }

    public void startWaveManagerRunnable(Player attacker, UUID defender, int[] waveTimerCountDown, int[] gracePeriodNumber) {
        if (!waveManagerRunnables.containsKey(attacker.getUniqueId())) {
            setWaveNumber(attacker.getUniqueId(), 0);
            int taskID = Bukkit.getScheduler().runTaskTimer(ZombieArena.getInstance(), () -> {
                waveTimerCountDown[0]--;
                if (waveTimerCountDown[0] == 0) {
                    cancelSpawning(attacker);
                }
                if (waveTimerCountDown[0] <= 0) {
                    if (getWaveNumber(attacker.getUniqueId()) == null) return;
                    if (getWaveNumber(attacker.getUniqueId()) < sectionNumber) {
                        if (gracePeriodNumber[0] <= 30 && (gracePeriodNumber[0] % 5 == 0 || gracePeriodNumber[0] <= 5)) {
                            if (gracePeriodNumber[0] == 0) return;
                            if (!zombiesRemain(attacker.getUniqueId()))
                                Messages.sendMessage(attacker, gracePeriodNumber[0], "waveNextWaveCountDown");
                        }
                        endOfWaveAttack(attacker, defender);
                        if (!zombiesRemain(attacker.getUniqueId()))
                            gracePeriodNumber[0]--;

                        if (gracePeriodNumber[0] <= 0) {
                            startNextWave(attacker, defender, waveTimerCountDown, gracePeriodNumber);
                            spawnHealerQueenOnRoundFive(attacker);
                            spawnArcherQueenOnRoundTen(attacker);
                            spawnBarbarianKingOnRoundfifteen(attacker);
                            waveTimerCountDown[0] = getWaveTimer(attacker.getUniqueId());
                        }

                    }
                }

            }, 0, 20).getTaskId();
            waveManagerRunnables.put(attacker.getUniqueId(), taskID);
            startFirstWave(attacker, defender, waveTimerCountDown, gracePeriodNumber);
            waveTimerCountDown[0] = getWaveTimer(attacker.getUniqueId());
        }

    }

    public void endOfWaveAttack(Player attacker, UUID defenderUUID) {
        if (getWaveNumber(attacker.getUniqueId()) == null) return;
        if (getWaveNumber(attacker.getUniqueId()) % 5 == 0) {
            endOfWaveAttackerLevelCheck(attacker, defenderUUID);
        }
    }

    public void endOfWaveAttackerLevelCheck(Player attacker, UUID defenderUUID) {
        switch (endOfWaveAttackLevel.get(defenderUUID)) {
            case 0:
                for (int i = 0; i < ZombieArena.getInstance().getConfig().getInt("end-of-wave-attack.default"); i++) {
                    spawnRandomMob(attacker);
                }
                break;
            case 1:
                for (int i = 0; i < ZombieArena.getInstance().getConfig().getInt("end-of-wave-attack.upgrade-one"); i++) {
                    spawnRandomMob(attacker);
                }
                break;
            case 2:
                for (int i = 0; i < ZombieArena.getInstance().getConfig().getInt("end-of-wave-attack.upgrade-two"); i++) {
                    spawnRandomMob(attacker);
                }
                break;
            case 3:
                for (int i = 0; i < ZombieArena.getInstance().getConfig().getInt("end-of-wave-attack.upgrade-three"); i++) {
                    spawnRandomMob(attacker);
                }
                break;
            case 4:
                for (int i = 0; i < ZombieArena.getInstance().getConfig().getInt("end-of-wave-attack.upgrade-four"); i++) {
                    spawnRandomMob(attacker);
                }
                break;
        }
    }
    public void spawnHealerQueenOnRoundFive(Player attacker) {
        if (getWaveNumber(attacker.getUniqueId()) == null) return;
        if (getWaveNumber(attacker.getUniqueId()) == 5) {
            ZombieArena.getInstance().healerQueen.spawnHealerQueen(attacker);
        }
    }

    public void spawnArcherQueenOnRoundTen(Player attacker) {
        if (getWaveNumber(attacker.getUniqueId()) == null) return;
        if (getWaveNumber(attacker.getUniqueId()) == 5) {
            ZombieArena.getInstance().archerQueen.spawnArcherQueen(attacker);
        }
    }

    public void spawnBarbarianKingOnRoundfifteen(Player attacker) {
        if (getWaveNumber(attacker.getUniqueId()) == null) return;
        if (getWaveNumber(attacker.getUniqueId()) == 5) {
            ZombieArena.getInstance().barbarianKing.spawnBarbarianKing(attacker);
        }
    }

    public void startFirstWave(Player attacker, UUID defender, int[] waveTimerCountDown, int[] gracePeriodNumber) {
        setWaveTimer(attacker.getUniqueId(), ZombieArena.getInstance().getConfig().getInt("waves." + getWaveNumber(attacker.getUniqueId()) + ".wave-length"));
        wavesManager(attacker, defender, waveTimerCountDown, gracePeriodNumber);
    }

    public void startNextWave(Player attacker, UUID defender, int[] waveTimerCountDown, int[] gracePeriodNumber) {
        int i = getWaveNumber(attacker.getUniqueId());
        i++;
        setWaveTimer(attacker.getUniqueId(), ZombieArena.getInstance().getConfig().getInt("waves." + getWaveNumber(attacker.getUniqueId()) + ".wave-length"));
        removeWaveNumber(attacker.getUniqueId());
        setWaveNumber(attacker.getUniqueId(), i);
        Messages.sendMessage(attacker, "waveStarted");
        wavesManager(attacker, defender, waveTimerCountDown, gracePeriodNumber);

    }

    private void wavesManager(Player attacker, UUID defender, int[] waveTimerCountDown, int[] gracePeriodNumber) {
        startSpawningRunnable(attacker, defender, getWaveNumber(attacker.getUniqueId()));
        setWaveTimer(attacker.getUniqueId(), ZombieArena.getInstance().getConfig().getInt("waves." + getWaveNumber(attacker.getUniqueId()) + ".wave-length"));
        removeGracePeriod(attacker.getUniqueId());
        setGracePeriod(attacker.getUniqueId(), ZombieArena.getInstance().getConfig().getInt("waves-grace-period"));
        waveTimerCountDown[0] = getWaveNumber(attacker.getUniqueId());
        gracePeriodNumber[0] = getGracePeriod(attacker.getUniqueId());
    }

    public void startSpawningRunnable(Player attacker, UUID defender, Integer waveNumber) {
        if (!waveSpawningRunnables.containsKey(attacker.getUniqueId())) {
            ZombieArena.getInstance().wavesHandler.addSpawns(defender, attacker.getUniqueId(), ZombieArena.getInstance().wavesHandler.ranSpawn);
            int taskID = Bukkit.getScheduler().runTaskTimer(ZombieArena.getInstance(), () -> {
                        addSpawnChances(defender);
                        spawnRandomMob(attacker);
                    }, 0,
                    getSpawnRate(waveNumber) * 20).getTaskId();
            waveSpawningRunnables.put(attacker.getUniqueId(), taskID);
        }
    }

    public void cancelWaveManager(Player attacker) {
        if (waveManagerRunnables.containsKey(attacker.getUniqueId())) {
            Bukkit.getScheduler().cancelTask(waveManagerRunnables.get(attacker.getUniqueId()));
            waveManagerRunnables.remove(attacker.getUniqueId());
        }
    }

    public void cancelSpawning(Player attacker) {
        if (waveSpawningRunnables.containsKey(attacker.getUniqueId())) {
            Bukkit.getScheduler().cancelTask(waveSpawningRunnables.get(attacker.getUniqueId()));
            waveSpawningRunnables.remove(attacker.getUniqueId());
        }
    }

    public void cancelRunnables(Player attacker) {
        cancelSpawning(attacker);
        cancelWaveManager(attacker);
    }

    public void addSpawnChances(UUID defenderUUID) {
        probabilities.clearChances();

        switch (regularMobUpgradeLevel.get(defenderUUID)) {
            case 0 ->
                    probabilities.addChance("Regular", ZombieArena.getInstance().getConfig().getInt("regular-mob.spawn-chance"));
            case 1 -> {
                probabilities.addChance("Regular", ZombieArena.getInstance().getConfig().getInt("regular-mob.spawn-chance") - ZombieArena.getInstance().getConfig().getInt("regular-mob.upgrade-one.spawn-chance"));
                probabilities.addChance("Regular-Level-One", ZombieArena.getInstance().getConfig().getInt("regular-mob.upgrade-one.spawn-chance"));
            }
            case 2 -> {
                probabilities.addChance("Regular", ZombieArena.getInstance().getConfig().getInt("regular-mob.spawn-chance") - ZombieArena.getInstance().getConfig().getInt("regular-mob.upgrade-two.spawn-chance"));
                probabilities.addChance("Regular-Level-Two", ZombieArena.getInstance().getConfig().getInt("regular-mob.upgrade-two.spawn-chance"));
            }
            case 3 -> {
                probabilities.addChance("Regular", ZombieArena.getInstance().getConfig().getInt("regular-mob.spawn-chance") - ZombieArena.getInstance().getConfig().getInt("regular-mob.upgrade-three.spawn-chance"));
                probabilities.addChance("Regular-Level-Three", ZombieArena.getInstance().getConfig().getInt("regular-mob.upgrade-three.spawn-chance"));
            }
            case 4 -> {
                probabilities.addChance("Regular", ZombieArena.getInstance().getConfig().getInt("regular-mob.spawn-chance") - ZombieArena.getInstance().getConfig().getInt("regular-mob.upgrade-four.spawn-chance"));
                probabilities.addChance("Regular-Level-Four", ZombieArena.getInstance().getConfig().getInt("regular-mob.upgrade-four.spawn-chance"));
            }
        }
    }

    public void spawnRandomMob(Player attacker) {
        Object random = probabilities.getRandomElement();
        if (random.equals("Regular")) ZombieArena.getInstance().regularMob.spawnRegularMob(attacker);
        if (random.equals("Regular-Level-One"))
            ZombieArena.getInstance().regularMob.spawnRegularMobUpgradeOne(attacker);
        if (random.equals("Regular-Level-Two"))
            ZombieArena.getInstance().regularMob.spawnRegularMobUpgradeTwo(attacker);
        if (random.equals("Regular-Level-Three"))
            ZombieArena.getInstance().regularMob.spawnRegularMobUpgradeThree(attacker);
        if (random.equals("Regular-Level-Four"))
            ZombieArena.getInstance().regularMob.spawnRegularMobUpgradeFour(attacker);
    }

    public void looseLife(NPC npc) {
        npc.destroy();
        for (UUID attackerUUID : ZombieArena.getInstance().matchMaking.playersInGame.keySet()) {
            Player player = Bukkit.getPlayer(attackerUUID);
            int lives = ZombieArena.getInstance().matchMaking.playersLifes.get(attackerUUID);
            lives--;
            ZombieArena.getInstance().matchMaking.playersLifes.remove(attackerUUID);
            ZombieArena.getInstance().matchMaking.playersLifes.put(attackerUUID, lives);
            Messages.sendMessage(player, "waveLooseLife");
            if (lives == 0) {
                endGame(player);
            }

        }

    }

    public void endGame(Player attacker) {
        if (getLives(attacker.getUniqueId()) <= 0) {
            ZombieArena.getInstance().trophiesHandler.removeTrophies(attacker);
        } else {
            ZombieArena.getInstance().trophiesHandler.addTrophies(attacker);
        }
        cancelRunnables(attacker);
        attacker.teleport(ZombieArena.getInstance().regionHandler.arenaSpawns.get(attacker.getUniqueId()));
        ZombieArena.getInstance().wavesHandler.ranSpawn.remove(attacker.getUniqueId());
        gameEndingManager(attacker);
    }

    private void gameEndingManager(Player attacker) {
        removeWaveTimer(attacker.getUniqueId());
        removeGracePeriod(attacker.getUniqueId());
        removeWaveNumber(attacker.getUniqueId());
        resetLives(attacker.getUniqueId());
        ZombieArena.getInstance().npcsHandler.destroyRemainingNPCs(attacker.getUniqueId().toString());
        ZombieArena.getInstance().npcsHandler.destroyTraderNPC(attacker.getUniqueId());
        ZombieArena.getInstance().barrier.resetBarriers(ZombieArena.getInstance().matchMaking.playersInGame.get(attacker.getUniqueId()));
        ZombieArena.getInstance().dataManager.saveAllPlayerData(attacker.getUniqueId());
        ZombieArena.getInstance().matchMaking.playersInGame.remove(attacker.getUniqueId());
    }

    public void endGamePlayerLeft(Player attacker) {
        cancelRunnables(attacker);
        ZombieArena.getInstance().wavesHandler.ranSpawn.remove(attacker.getUniqueId());
        ZombieArena.getInstance().trophiesHandler.removeTrophies(attacker);
        gameEndingManager(attacker);
    }

    public void resetLives(UUID uuid) {
        ZombieArena.getInstance().dataManager.loadLives(uuid);
    }

    public void setWaveTimer(UUID attackerUUID, int waveLength) {
        waveTimer.put(attackerUUID, waveLength);
    }

    public void removeWaveTimer(UUID attackerUUID) {
        waveTimer.remove(attackerUUID);
    }

    public int getWaveTimer(UUID attackerUUID) {
        return waveTimer.get(attackerUUID);
    }

    public Long getSpawnRate(Integer waveNumber) {
        return ZombieArena.getInstance().getConfig().getLong("waves." + waveNumber + ".wave-spawn-rate");
    }

    public void setWaveNumber(UUID attackerUUID, int waveNumber) {
        this.waveNumber.put(attackerUUID, waveNumber);
    }

    public void removeWaveNumber(UUID attackerUUID) {
        waveNumber.remove(attackerUUID);
    }

    public Integer getWaveNumber(UUID attackerUUID) {
        if (waveNumber.containsKey(attackerUUID)) {
            return waveNumber.get(attackerUUID);
        }
        return null;
    }


    public void setGracePeriod(UUID attackerUUID, int gracePeriod) {
        this.gracePeriod.put(attackerUUID, gracePeriod);
    }

    public void removeGracePeriod(UUID attackerUUID) {
        gracePeriod.remove(attackerUUID);
    }

    public int getGracePeriod(UUID attackerUUID) {
        return gracePeriod.get(attackerUUID);
    }

    public int getLives(UUID attackerUUID) {
        return ZombieArena.getInstance().matchMaking.playersLifes.get(attackerUUID);
    }

    public boolean zombiesRemain(UUID attackerUUID) {
        for (NPCRegistry npcReg : CitizensAPI.getNPCRegistries()) {
            Iterator npcIter = npcReg.sorted().iterator();
            for (Iterator it = npcIter; it.hasNext(); ) {
                NPC npc = (NPC) it.next();
                if (npc.getName().contains(attackerUUID.toString())) return true;
            }
        }
        return false;
    }

}