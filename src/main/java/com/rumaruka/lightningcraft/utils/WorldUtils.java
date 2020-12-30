package com.rumaruka.lightningcraft.utils;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class WorldUtils {
    private static final Block[] blacklist = new Block[]{Blocks.LAVA, Blocks.FIRE, Blocks.LAVA, Blocks.CACTUS};
    static final Random random = new Random();
    public static Block getBlock(World world, int x, int y, int z) {
        return world.getBlockState(new BlockPos(x, y, z)).getBlock();
    }
        public static Integer getOpenSurface(World world, int x, int z, int starty, int distance, boolean onSolidBlock) {
        starty += 2;
        for(int y = starty + distance; y >= starty - distance; y--) {
            Block block;
            if(getBlock(world, x, y + 2, z) == Blocks.AIR && getBlock(world, x, y + 1, z) == Blocks.AIR && (block = getBlock(world, x, y, z)) != Blocks.AIR) {
                if(!LCMisc.inArray(block, blacklist) && (!onSolidBlock)) {
                    if(y < Math.max(world.getHeight() - 1, starty)) { // stay off the bedrock ceiling
                        return y + 1;
                    }
                }
            }
        }
        return null;
    }

    /** gets the area height near your position */
    public static Integer getOpenSurfaceReverse(World world, int x, int z, int starty, int distance, boolean onSolidBlock) {
        starty += 2;
        for(int y = starty - distance; y <= starty + distance; y++) {
            Block block;
            if(getBlock(world, x, y + 2, z) == Blocks.AIR && getBlock(world, x, y + 1, z) == Blocks.AIR && (block = getBlock(world, x, y, z)) != Blocks.AIR) {
                if(!LCMisc.inArray(block, blacklist) && (!onSolidBlock)) {
                    if(y < Math.max(world.getHeight() - 1, starty)) { // stay off the bedrock ceiling
                        return y + 1;
                    }
                }
            }
        }
        return null;
    }

    /** gets the area height near your position */
    public static Integer getOpenSurfaceCentered(World world, int x, int z, int starty, int distance, boolean onSolidBlock) {
        Integer y;
        y = getOpenSurfaceReverse(world, x, z, starty - distance / 2, distance / 2, onSolidBlock);
        if(y == null) y = getOpenSurface(world, x, z, starty + distance / 2, distance / 2, onSolidBlock);
        return y;
    }

    /** gets the area height near your position */
    public static Integer getOpenSurface(World world, int x, int z, int starty, int distance) {
        return getOpenSurface(world, x, z, starty, distance, false);
    }

    /** gets the area height near your position */
    public static Integer getOpenCeiling(World world, int x, int z, int starty, int endy, int airBlocks) {
        for(int y = endy; y >= starty; y--) {
            if(canSpawnAtCeilingPosition(world, x, y - 1, z, airBlocks)) {
                if(!LCMisc.inArray(getBlock(world, x, y, z), blacklist)) {
                    if(y < Math.max(world.getHeight() - 1, starty)) { // stay off the bedrock ceiling
                        return y - 1;
                    }
                }
            }
        }
        return null;
    }
    public static boolean canSpawnAtCeilingPosition(World world, int x, int y, int z, int airBelow) {
        if(getBlock(world, x, y + 1, z) != Blocks.AIR) {
            for(int i = 0; i < airBelow; i++) {
                if(getBlock(world, x, y - i, z) != Blocks.AIR) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
