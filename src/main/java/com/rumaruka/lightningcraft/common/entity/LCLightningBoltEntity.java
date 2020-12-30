package com.rumaruka.lightningcraft.common.entity;

import com.rumaruka.lightningcraft.init.LCEntites;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;

import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.List;

public class LCLightningBoltEntity extends LightningBoltEntity {
    /** Declares which state the lightning bolt is in. Whether it's in the air, hit the ground, etc. */
    private int lightningState;
    /** A random long that is used to change the vertex of the lightning rendered in RenderLightningBolt */
    public long boltVertex;
    /** Determines the time before the EntityLightningBolt is destroyed. It is a random integer decremented over time. */
    private int boltLivingTime;

    private boolean doSetFire;

    public LCLightningBoltEntity(EntityType<? extends LCLightningBoltEntity> p_i50382_1_, World entity) {
        super(p_i50382_1_, entity);
    }
    public LCLightningBoltEntity(World world, double x, double y, double z, boolean setFire)
    {
        super(LCEntites.lightning_bolt.get(),world);
        this.absMoveTo(x, y, z, 0.0F, 0.0F);
        setPos(x,y,z);
        this.lightningState = 2;
        this.boltVertex = this.random.nextLong();
        this.boltLivingTime = this.random.nextInt(3) + 1;
        this.doSetFire = setFire;
        BlockPos blockpos = this.blockPosition();

        if (setFire && !level.isClientSide && level.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK) &&
                (world.getDifficulty() == Difficulty.NORMAL || world.getDifficulty() == Difficulty.HARD) && world.isAreaLoaded(blockpos, 10)) {
            int i = MathHelper.floor(x);
            int j = MathHelper.floor(y);
            int k = MathHelper.floor(z);

            BlockState state1 = world.getBlockState(new BlockPos(i, j, k));
            if (state1.getMaterial() == Material.AIR && Blocks.FIRE.canSurvive(state1,world, new BlockPos(i, j, k)))
            {
                world.setBlockAndUpdate(new BlockPos(i, j, k), Blocks.FIRE.defaultBlockState());
            }

            for (i = 0; i < 4; ++i)
            {
                j = MathHelper.floor(x) + this.random.nextInt(3) - 1;
                k = MathHelper.floor(y) + this.random.nextInt(3) - 1;
                int l = MathHelper.floor(z) + this.random.nextInt(3) - 1;

                BlockState state2 = world.getBlockState(new BlockPos(j, k, l));
                if (state2.getMaterial() == Material.AIR && Blocks.FIRE.canSurvive(state2,world, new BlockPos(j, k, l)))
                {
                    world.setBlockAndUpdate(new BlockPos(j, k, l), Blocks.FIRE.defaultBlockState());
                }
            }
        }
    }

    @Override
    public void tick() {
        if (this.lightningState == 2)
        {

            this.level.playSound(null, getOnPos().getX(), getOnPos().getY(), getOnPos().getY(),
                    SoundEvents.LIGHTNING_BOLT_THUNDER, SoundCategory.WEATHER, 3.0F, 2.8F + this.random.nextFloat() * 0.2F);
            this.level.playSound(null, getOnPos().getX(), getOnPos().getY(), getOnPos().getY(),
                    SoundEvents.LIGHTNING_BOLT_THUNDER, SoundCategory.WEATHER, 2.0F, 0.5F + this.random.nextFloat() * 0.2F);
        }

        --this.lightningState;

        if (this.lightningState < 0)
        {
            if (this.boltLivingTime == 0)
            {
                this.remove();
            }
            else if (this.lightningState < -this.random.nextInt(10))
            {
                --this.boltLivingTime;
                this.lightningState = 1;
                this.boltVertex = this.random.nextLong();
                BlockPos blockpos = this.blockPosition();

                if (doSetFire && !level.isClientSide && level.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK) &&
                        (level.getDifficulty() == Difficulty.NORMAL || level.getDifficulty() == Difficulty.HARD) && level.isAreaLoaded(blockpos, 10)) {
                    int i = MathHelper.floor(this.getOnPos().getX());
                    int j = MathHelper.floor(this.getOnPos().getY());
                    int k = MathHelper.floor(this. getOnPos().getY());

                    BlockState state = level.getBlockState(new BlockPos(i, j, k));
                    if (state.getMaterial() == Material.AIR && Blocks.FIRE.canSurvive(state,this.level, new BlockPos(i, j, k)))
                    {
                        level.setBlockAndUpdate(new BlockPos(i, j, k), Blocks.FIRE.defaultBlockState());

                    }
                }
            }
        }

        if (this.lightningState >= 0)
        {
            if (this.level.isClientSide)
            {
                this.level.setSkyFlashTime(2);
            }
            else
            {
                double d0 = 3.0D;
                List<Entity> list = this.level.getEntities(this, new AxisAlignedBB(this.getX() - 3.0D, this.getY() - 3.0D, this.getZ() - 3.0D, this.getX() + 3.0D, this.getY() + 6.0D + 3.0D, this.getZ() + 3.0D), Entity::isAlive);

                for (int l = 0; l < list.size(); ++l)
                {
                    Entity entity = (Entity)list.get(l);
                    if (!ForgeEventFactory.onEntityStruckByLightning(entity, this))
                        entity.thunderHit((ServerWorld) level,this);
                }
            }
        }
    }
}
