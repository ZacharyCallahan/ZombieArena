package com.zach.zombiearena.gameplay.defenseupgrades;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.citizensnpcs.api.trait.trait.Equipment;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;

public class MobHandler {

    public void mobCreator(Player attacker, EntityType entityType, int health, double speed, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots) {
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(entityType, "Zombie " + attacker.getUniqueId());
        //npc.spawn(ZombieArena.getInstance().wavesHandler.ranSpawn.get(attacker.getUniqueId()).get(ZombieArena.getInstance().wavesHandler.random.nextInt(ZombieArena.getInstance().wavesHandler.maxNum)));

        npc.spawn(attacker.getLocation());
        if (npc.isSpawned()) {
            LivingEntity entity = (LivingEntity) npc.getEntity();
            npc.getNavigator().setTarget(attacker, true);
            npc.data().set("nameplate-visible", false);
            npc.setProtected(false);
            entity.setMaxHealth(health);
            npc.getNavigator().getLocalParameters().speed((float) speed);
            npc.getOrAddTrait(Equipment.class).set(Equipment.EquipmentSlot.HELMET, helmet);
            npc.getOrAddTrait(Equipment.class).set(Equipment.EquipmentSlot.CHESTPLATE, chestplate);
            npc.getOrAddTrait(Equipment.class).set(Equipment.EquipmentSlot.LEGGINGS, leggings);
            npc.getOrAddTrait(Equipment.class).set(Equipment.EquipmentSlot.BOOTS, boots);


        }

    }

    public NPC getMobType(Player attacker, EntityType entityType) {
        for (NPCRegistry npcRegistry : CitizensAPI.getNPCRegistries()) {
            Iterator npcIter = npcRegistry.sorted().iterator();
            for (Iterator it = npcIter; it.hasNext(); ) {
                NPC npc = (NPC) it.next();
                if (npc.getEntity().getType() == entityType
                        && npc.getName().contains(attacker.getUniqueId().toString())) {
                    return npc;
                }
            }
        }
        return null;
    }

    public Entity[] getNearbyEntities(Player attacker, int radius, EntityType entityType) {
        //interate through all npc's
        for (NPCRegistry npcRegistry : CitizensAPI.getNPCRegistries()) {
            Iterator npcIter = npcRegistry.sorted().iterator();
            for (Iterator it = npcIter; it.hasNext(); ) {
                NPC npc = (NPC) it.next();
                //if npc is a specific type and contains attackers uuid
                if (npc.getEntity().getType() == entityType
                        && npc.getName().contains(attacker.getUniqueId().toString())) {
                    //return all entities within the radius
                    return npc.getEntity().getNearbyEntities(radius, radius, radius).toArray(new Entity[0]);
                }
            }
        }
        return null;
    }

    //spawn particles on the entities that are being healed
    public void spawnParticles(Entity entity) {
        int x = entity.getLocation().getBlockX();
        int y = entity.getLocation().getBlockY();
        int z = entity.getLocation().getBlockZ();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    entity.getWorld().spawnParticle(Particle.SLIME, x + i, y + j, z + k, 5, 0, 0, 0, 0);
                }
            }
        }
    }


}