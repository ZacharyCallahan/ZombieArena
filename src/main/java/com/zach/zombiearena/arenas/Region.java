package com.zach.zombiearena.arenas;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Region {
    public final String world;
    protected final int x1;
    protected final int y1;
    protected final int z1;
    protected final int x2;
    protected final int y2;
    protected final int z2;

    public Region(Location l1, Location l2) {
        if (!l1.getWorld().equals(l2.getWorld())) {
            throw new IllegalArgumentException("Locations must be in the same world");
        } else {
            this.world = l1.getWorld().getName();
            this.x1 = Math.min(l1.getBlockX(), l2.getBlockX());
            this.y1 = Math.min(l1.getBlockY(), l2.getBlockY());
            this.z1 = Math.min(l1.getBlockZ(), l2.getBlockZ());
            this.x2 = Math.max(l1.getBlockX(), l2.getBlockX());
            this.y2 = Math.max(l1.getBlockY(), l2.getBlockY());
            this.z2 = Math.max(l1.getBlockZ(), l2.getBlockZ());
        }
    }

    public Location getCenter() {
        int x1 = this.getUpperX();
        int y1 = this.getUpperY();
        int z1 = this.getUpperZ();
        return new Location(this.getWorld(), (double) this.getLowerX() + (double) (x1 - this.getLowerX()) / 2.0D,
                (double) this.getLowerY() + (double) (y1 - this.getLowerY()) / 2.0D,
                (double) this.getLowerZ() + (double) (z1 - this.getLowerZ()) / 2.0D);
    }

    public int getLowerX() {
        return this.x1;
    }

    public int getLowerY() {
        return this.y1;
    }

    public int getLowerZ() {
        return this.z1;
    }

    public int getUpperX() {
        return this.x2;
    }

    public int getUpperY() {
        return this.y2;
    }

    public int getUpperZ() {
        return this.z2;
    }

    public World getWorld() {
        World world = Bukkit.getWorld(this.world);
        if (world == null) {
            throw new IllegalStateException("World '" + this.world + "' is not loaded!");
        } else {
            return world;
        }
    }

    public boolean contains(int x, int y, int z) {
        return x >= this.x1 && x <= this.x2 && y >= this.y1 && y <= this.y2 && z >= this.z1 && z <= this.z2;
    }
    public boolean containsLocation(Location loc) {
        return world.equals(loc.getWorld().getName()) && this.contains(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
    }

    public void setCenter() {
        this.getCenter().getBlock().setType(Material.SPONGE);
    }

    public List<Block> getBlocks() {
        Iterator<Block> blockI = this.iterator();
        ArrayList copy = new ArrayList();

        while (blockI.hasNext()) {
            copy.add(blockI.next());
        }

        return copy;
    }

    public Iterator<Block> iterator() {
        return new CuboidIterator(this.getWorld(), this.x1, this.y1, this.z1, this.x2, this.y2, this.z2);
    }
}
