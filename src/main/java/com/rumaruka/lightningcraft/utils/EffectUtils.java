package com.rumaruka.lightningcraft.utils;

import com.rumaruka.lightningcraft.common.entity.LCLightningBoltEntity;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import java.util.Random;

public class EffectUtils {
    private static Random random = new Random();
    public static boolean lightning(World world, double x, double y, double z, boolean isRandom, double range)
    {
        if(!world.isClientSide) {
            double xoff;
            double zoff;
            if(isRandom) {
                xoff = random.nextDouble() * range * 2 - range; // 16 block range (default)
                zoff = random.nextDouble() * range * 2 - range;
            } else {
                xoff = 0;
                zoff = 0;
            }

            x += xoff;
            z += zoff;

            // seek a surface?
            if(isRandom) {
                Integer yy = WorldUtils.getOpenSurface(world, (int)x, (int)z, (int)y, 10);
                if(yy == null) return false;
                y = yy;
            }

            LCLightningBoltEntity lightning = new LCLightningBoltEntity(world, x, y, z, true);
            lightning.setPos(x, y - 0.5, z);
            world.addFreshEntity(lightning);
            return true;
        }
        return false;
    }

    /** lightning summon code! (within +/-10 blocks Y) */
    public static boolean lightning(World world, double x, double y, double z){
        return lightning(world, x, y, z, false, 0);
    }

    /** lightning summon code! (within +/-10 blocks Y) */
    public static boolean lightning(Entity entity, boolean isRandom, double range)
    {
        if(!entity.level.isClientSide) {
            double xoff;
            double zoff;
            if(isRandom) {
                xoff = random.nextDouble() * range*2 - range; // 16 block range (default)
                zoff = random.nextDouble() * range*2 - range;
            } else {
                xoff = 0;
                zoff = 0;
            }

            World world = entity.level;
            double x = entity.position().x + xoff;
            double z = entity.position().z + zoff;
            double y;

            // seek a surface?
            if(isRandom) {
                Integer yy = WorldUtils.getOpenSurface(world, (int)x, (int)z, (int)entity.position().y, 10);
                if(yy == null) return false;
                y = yy;
            } else {
                y = entity.position().y;
            }

            LCLightningBoltEntity lightning = new LCLightningBoltEntity(world, x, y, z, true);
            lightning.setPos(x, y - 0.5, z);
            world.addFreshEntity(lightning);
            return true;
        }
        return false;
    }

    /** lightning summon code! (within +/-10 blocks Y) */
    public static boolean lightning(Entity entity, boolean isRandom){
        return lightning(entity, isRandom, 16);
    }
}
