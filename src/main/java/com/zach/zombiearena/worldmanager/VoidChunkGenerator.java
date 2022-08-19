package com.zach.zombiearena.worldmanager;

import com.zach.zombiearena.ZombieArena;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;

public class VoidChunkGenerator extends ChunkGenerator {
    public VoidChunkGenerator() {
    }

    public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
        return this.createChunkData(world);
    }

    public void createVoidWorld() {
        WorldCreator wc = new WorldCreator(ZombieArena.getInstance().config.getWorldName());
        wc.generator(new VoidChunkGenerator());
        wc.createWorld();
    }
}