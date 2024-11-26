//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titanminion;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEndPortal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityDragonMinion extends EntityLiving implements IEntityMultiPart, IMinion {
    public EntityLiving master;
    public double targetX;
    public double targetY;
    public double targetZ;
    public double[][] ringBuffer = new double[64][3];
    public int ringBufferIndex = -1;
    public EntityDragonPart[] dragonPartArray;
    public EntityDragonPart dragonPartHead;
    public EntityDragonPart dragonPartBody;
    public EntityDragonPart dragonPartTail1;
    public EntityDragonPart dragonPartTail2;
    public EntityDragonPart dragonPartTail3;
    public EntityDragonPart dragonPartWing1;
    public EntityDragonPart dragonPartWing2;
    public float prevAnimTime;
    public float animTime;
    public boolean forceNewTarget;
    public boolean slowed;
    private EntityLivingBase target;
    public int deathTicks;
    public EntityEnderCrystal healingEnderCrystal;

    public EntityDragonMinion(World p_i1700_1_) {
        super(p_i1700_1_);
        this.func_110163_bv();
        this.dragonPartArray = new EntityDragonPart[]{this.dragonPartHead = new EntityDragonPart(this, "head", 6.0F, 6.0F), this.dragonPartBody = new EntityDragonPart(this, "body", 8.0F, 8.0F), this.dragonPartTail1 = new EntityDragonPart(this, "tail", 4.0F, 4.0F), this.dragonPartTail2 = new EntityDragonPart(this, "tail", 4.0F, 4.0F), this.dragonPartTail3 = new EntityDragonPart(this, "tail", 4.0F, 4.0F), this.dragonPartWing1 = new EntityDragonPart(this, "wing", 4.0F, 4.0F), this.dragonPartWing2 = new EntityDragonPart(this, "wing", 4.0F, 4.0F)};
        this.func_70606_j(this.func_110138_aP());
        this.func_70105_a(14.0F, 3.6F);
        this.field_70145_X = true;
        this.field_70178_ae = true;
        this.targetY = (double)100.0F;
        this.field_70158_ak = true;
        if (this.func_70638_az() != null) {
            this.target = this.func_70638_az();
        }

    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)8000.0F);
    }

    protected void func_70088_a() {
        super.func_70088_a();
    }

    public void func_70106_y() {
        super.func_70106_y();
        if (this.master != null && this.master instanceof EntityTitan) {
            ((EntityTitan)this.master).retractMinionNumFromType(this.getMinionType());
        }

    }

    public EnumMinionType getMinionType() {
        return EnumMinionType.SPECIAL;
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != EntityEndermanMinion.class && p_70686_1_ != EntityDragonMinion.class && p_70686_1_ != EntityEnderColossus.class;
    }

    public double[] getMovementOffsets(int p_70974_1_, float p_70974_2_) {
        if (this.func_110143_aJ() <= 0.0F) {
            p_70974_2_ = 0.0F;
        }

        p_70974_2_ = 1.0F - p_70974_2_;
        int j = this.ringBufferIndex - p_70974_1_ * 1 & 63;
        int k = this.ringBufferIndex - p_70974_1_ * 1 - 1 & 63;
        double[] adouble = new double[3];
        double d0 = this.ringBuffer[j][0];
        double d1 = MathHelper.func_76138_g(this.ringBuffer[k][0] - d0);
        adouble[0] = d0 + d1 * (double)p_70974_2_;
        d0 = this.ringBuffer[j][1];
        d1 = this.ringBuffer[k][1] - d0;
        adouble[1] = d0 + d1 * (double)p_70974_2_;
        adouble[2] = this.ringBuffer[j][2] + (this.ringBuffer[k][2] - this.ringBuffer[j][2]) * (double)p_70974_2_;
        return adouble;
    }

    public void func_70636_d() {
        this.func_70105_a(14.0F, 3.6F);
        if (this.field_70173_aa == 20 || this.field_70173_aa == 40) {
            this.func_70965_a(this.dragonPartHead, new DamageSource("none"), 0.0F);
        }

        this.field_70158_ak = true;
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
            this.func_70106_y();
        }

        if (this.field_70170_p.field_72995_K) {
            float f = MathHelper.func_76134_b(this.animTime * (float)Math.PI * 2.0F);
            float f1 = MathHelper.func_76134_b(this.prevAnimTime * (float)Math.PI * 2.0F);
            if (f1 <= -0.3F && f >= -0.3F) {
                this.field_70170_p.func_72980_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, "mob.enderdragon.wings", 5.0F, 0.8F + this.field_70146_Z.nextFloat() * 0.3F, false);
            }
        }

        this.prevAnimTime = this.animTime;
        if (this.func_110143_aJ() <= 0.0F) {
            float f = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
            float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 4.0F;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
            this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t + (double)f, this.field_70163_u + (double)2.0F + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
        } else {
            this.updateDragonEnderCrystal();
            float f = 0.2F / (MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y) * 10.0F + 1.0F);
            f *= (float)Math.pow((double)2.0F, this.field_70181_x);
            if (this.slowed) {
                this.animTime += f * 0.5F;
            } else {
                this.animTime += f;
            }
        }

        if (this.func_70638_az() != null && !this.func_70638_az().func_70089_S()) {
            this.func_70624_b((EntityLivingBase)null);
        }

        if (this.master != null) {
            if (this.func_70068_e(this.master) > (double)10000.0F) {
                this.forceNewTarget = true;
            }

            if (this.master.func_70638_az() != null) {
                this.func_70624_b(this.master.func_70638_az());
            }
        } else {
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)100.0F, (double)100.0F, (double)100.0F));
            if (list != null && !list.isEmpty()) {
                for(int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity != null && entity instanceof EntityEnderColossus) {
                        this.master = (EntityEnderColossus)entity;
                    }
                }
            }
        }

        this.field_70177_z = MathHelper.func_76142_g(this.field_70177_z);
        if (this.ringBufferIndex < 0) {
            for(int i = 0; i < this.ringBuffer.length; ++i) {
                this.ringBuffer[i][0] = (double)this.field_70177_z;
                this.ringBuffer[i][1] = this.field_70163_u;
            }
        }

        if (++this.ringBufferIndex == this.ringBuffer.length) {
            this.ringBufferIndex = 0;
        }

        this.ringBuffer[this.ringBufferIndex][0] = (double)this.field_70177_z;
        this.ringBuffer[this.ringBufferIndex][1] = this.field_70163_u;
        if (this.field_70170_p.field_72995_K) {
            if (this.field_70716_bi > 0) {
                double d10 = this.field_70165_t + (this.field_70709_bj - this.field_70165_t) / (double)this.field_70716_bi;
                double d0 = this.field_70163_u + (this.field_70710_bk - this.field_70163_u) / (double)this.field_70716_bi;
                double d1 = this.field_70161_v + (this.field_110152_bk - this.field_70161_v) / (double)this.field_70716_bi;
                double d2 = MathHelper.func_76138_g(this.field_70712_bm - (double)this.field_70177_z);
                this.field_70177_z = (float)((double)this.field_70177_z + d2 / (double)this.field_70716_bi);
                this.field_70125_A = (float)((double)this.field_70125_A + (this.field_70705_bn - (double)this.field_70125_A) / (double)this.field_70716_bi);
                --this.field_70716_bi;
                this.func_70107_b(d10, d0, d1);
                this.func_70101_b(this.field_70177_z, this.field_70125_A);
            }
        } else {
            double d10 = this.targetX - this.field_70165_t;
            double d0 = this.targetY - this.field_70163_u;
            double d1 = this.targetZ - this.field_70161_v;
            double d2 = d10 * d10 + d0 * d0 + d1 * d1;
            if (this.target != null) {
                this.targetX = this.target.field_70165_t;
                this.targetZ = this.target.field_70161_v;
                double d3 = this.targetX - this.field_70165_t;
                double d5 = this.targetZ - this.field_70161_v;
                double d7 = Math.sqrt(d3 * d3 + d5 * d5);
                double d8 = (double)0.5F + d7 / (double)80.0F - (double)1.0F;
                if (d8 > (double)10.0F) {
                    d8 = (double)10.0F;
                }

                this.targetY = this.target.field_70163_u + d8 + (double)1.0F;
            } else {
                this.targetX += this.field_70146_Z.nextGaussian() * (double)2.0F;
                this.targetZ += this.field_70146_Z.nextGaussian() * (double)2.0F;
            }

            if (this.forceNewTarget || d2 < (double)64.0F || d2 > (double)22500.0F || this.field_70123_F || this.field_70124_G) {
                this.setNewTarget();
            }

            d0 /= (double)MathHelper.func_76133_a(d10 * d10 + d1 * d1);
            float f12 = 0.6F;
            if (d0 < (double)(-f12)) {
                d0 = (double)(-f12);
            }

            if (d0 > (double)f12) {
                d0 = (double)f12;
            }

            this.field_70181_x += d0 * (double)0.1F;
            this.field_70177_z = MathHelper.func_76142_g(this.field_70177_z);
            double d4 = (double)180.0F - Math.atan2(d10, d1) * (double)180.0F / Math.PI;
            double d6 = MathHelper.func_76138_g(d4 - (double)this.field_70177_z);
            if (d6 > (double)50.0F) {
                d6 = (double)50.0F;
            }

            if (d6 < (double)-50.0F) {
                d6 = (double)-50.0F;
            }

            Vec3 vec3 = Vec3.func_72443_a(this.targetX - this.field_70165_t, this.targetY - this.field_70163_u, this.targetZ - this.field_70161_v).func_72432_b();
            Vec3 vec32 = Vec3.func_72443_a((double)MathHelper.func_76126_a(this.field_70177_z * (float)Math.PI / 180.0F), this.field_70181_x, (double)(-MathHelper.func_76134_b(this.field_70177_z * (float)Math.PI / 180.0F))).func_72432_b();
            float f5 = (float)(vec32.func_72430_b(vec3) + (double)0.5F) / 1.5F;
            if (f5 < 0.0F) {
                f5 = 0.0F;
            }

            this.field_70704_bt *= 0.8F;
            float f6 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y) * 1.0F + 1.0F;
            double d9 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y) * (double)1.0F + (double)1.0F;
            if (d9 > (double)40.0F) {
                d9 = (double)40.0F;
            }

            this.field_70704_bt = (float)((double)this.field_70704_bt + d6 * ((double)0.7F / d9 / (double)f6));
            this.field_70177_z += this.field_70704_bt * 0.1F;
            float f7 = (float)((double)2.0F / (d9 + (double)1.0F));
            float f8 = 0.06F;
            this.func_70060_a(0.0F, -1.0F, f8 * (f5 * f7 + (1.0F - f7)));
            if (this.func_70089_S()) {
                if (this.target != null) {
                    this.func_70091_d(this.field_70159_w * (double)5.0F, this.field_70181_x * (double)5.0F, this.field_70179_y * (double)5.0F);
                } else if (this.func_70638_az() != null) {
                    this.func_70091_d(this.field_70159_w * (double)2.0F, this.field_70181_x * (double)2.0F, this.field_70179_y * (double)2.0F);
                } else if (this.slowed) {
                    this.func_70091_d(this.field_70159_w * (double)0.75F, this.field_70181_x * (double)0.75F, this.field_70179_y * (double)0.75F);
                } else {
                    this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
                }
            }

            Vec3 vec31 = Vec3.func_72443_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72432_b();
            float f9 = (float)(vec31.func_72430_b(vec32) + (double)1.0F) / 2.0F;
            f9 = 0.8F + 0.15F * f9;
            this.field_70159_w *= (double)f9;
            this.field_70179_y *= (double)f9;
            this.field_70181_x *= (double)0.91F;
        }

        this.field_70761_aq = this.field_70177_z;
        this.dragonPartHead.field_70130_N = this.dragonPartHead.field_70131_O = 3.0F;
        this.dragonPartTail1.field_70130_N = this.dragonPartTail1.field_70131_O = 2.0F;
        this.dragonPartTail2.field_70130_N = this.dragonPartTail2.field_70131_O = 2.0F;
        this.dragonPartTail3.field_70130_N = this.dragonPartTail3.field_70131_O = 2.0F;
        this.dragonPartBody.field_70131_O = 3.0F;
        this.dragonPartBody.field_70130_N = 5.0F;
        this.dragonPartWing1.field_70131_O = 2.0F;
        this.dragonPartWing1.field_70130_N = 4.0F;
        this.dragonPartWing2.field_70131_O = 3.0F;
        this.dragonPartWing2.field_70130_N = 4.0F;
        float f1 = (float)(this.getMovementOffsets(5, 1.0F)[1] - this.getMovementOffsets(10, 1.0F)[1]) * 10.0F / 180.0F * (float)Math.PI;
        float f2 = MathHelper.func_76134_b(f1);
        float f10 = -MathHelper.func_76126_a(f1);
        float f3 = this.field_70177_z * (float)Math.PI / 180.0F;
        float f11 = MathHelper.func_76126_a(f3);
        float f4 = MathHelper.func_76134_b(f3);
        this.dragonPartBody.func_70071_h_();
        this.dragonPartBody.func_70012_b(this.field_70165_t + (double)(f11 * 0.5F), this.field_70163_u, this.field_70161_v - (double)(f4 * 0.5F), 0.0F, 0.0F);
        this.dragonPartWing1.func_70071_h_();
        this.dragonPartWing1.func_70012_b(this.field_70165_t + (double)(f4 * 4.5F), this.field_70163_u + (double)2.0F, this.field_70161_v + (double)(f11 * 4.5F), 0.0F, 0.0F);
        this.dragonPartWing2.func_70071_h_();
        this.dragonPartWing2.func_70012_b(this.field_70165_t - (double)(f4 * 4.5F), this.field_70163_u + (double)2.0F, this.field_70161_v - (double)(f11 * 4.5F), 0.0F, 0.0F);
        this.collideWithEntities(this.field_70170_p.func_72839_b(this, this.dragonPartTail1.field_70121_D.func_72314_b((double)1.0F, (double)1.0F, (double)1.0F)));
        this.collideWithEntities(this.field_70170_p.func_72839_b(this, this.dragonPartTail2.field_70121_D.func_72314_b((double)1.0F, (double)1.0F, (double)1.0F)));
        this.collideWithEntities(this.field_70170_p.func_72839_b(this, this.dragonPartTail3.field_70121_D.func_72314_b((double)1.0F, (double)1.0F, (double)1.0F)));
        this.collideWithEntities(this.field_70170_p.func_72839_b(this, this.dragonPartWing1.field_70121_D.func_72314_b((double)1.0F, (double)1.0F, (double)1.0F)));
        this.collideWithEntities(this.field_70170_p.func_72839_b(this, this.dragonPartWing2.field_70121_D.func_72314_b((double)1.0F, (double)1.0F, (double)1.0F)));
        this.collideWithEntities(this.field_70170_p.func_72839_b(this, this.dragonPartBody.field_70121_D.func_72314_b((double)1.0F, (double)1.0F, (double)1.0F)));
        this.attackEntitiesInList(this.field_70170_p.func_72839_b(this, this.dragonPartHead.field_70121_D.func_72314_b((double)2.0F, (double)2.0F, (double)2.0F)));
        double[] adouble1 = this.getMovementOffsets(5, 1.0F);
        double[] adouble = this.getMovementOffsets(0, 1.0F);
        float f12 = MathHelper.func_76126_a(this.field_70177_z * (float)Math.PI / 180.0F - this.field_70704_bt * 0.01F);
        float f13 = MathHelper.func_76134_b(this.field_70177_z * (float)Math.PI / 180.0F - this.field_70704_bt * 0.01F);
        this.dragonPartHead.func_70071_h_();
        this.dragonPartHead.func_70012_b(this.field_70165_t + (double)(f12 * 5.5F * f2), this.field_70163_u + (adouble[1] - adouble1[1]) * (double)1.0F + (double)(f10 * 5.5F), this.field_70161_v - (double)(f13 * 5.5F * f2), 0.0F, 0.0F);

        for(int j = 0; j < 3; ++j) {
            EntityDragonPart entitydragonpart = null;
            if (j == 0) {
                entitydragonpart = this.dragonPartTail1;
            }

            if (j == 1) {
                entitydragonpart = this.dragonPartTail2;
            }

            if (j == 2) {
                entitydragonpart = this.dragonPartTail3;
            }

            double[] adouble2 = this.getMovementOffsets(12 + j * 2, 1.0F);
            float f14 = this.field_70177_z * (float)Math.PI / 180.0F + this.simplifyAngle(adouble2[0] - adouble1[0]) * (float)Math.PI / 180.0F * 1.0F;
            float f15 = MathHelper.func_76126_a(f14);
            float f16 = MathHelper.func_76134_b(f14);
            float f17 = 1.5F;
            float f18 = (float)(j + 1) * 2.0F;
            entitydragonpart.func_70071_h_();
            entitydragonpart.func_70012_b(this.field_70165_t - (double)((f11 * f17 + f15 * f18) * f2), this.field_70163_u + (adouble2[1] - adouble1[1]) * (double)1.0F - (double)((f18 + f17) * f10) + (double)1.5F, this.field_70161_v + (double)((f4 * f17 + f16 * f18) * f2), 0.0F, 0.0F);
        }

        if (!this.field_70170_p.field_72995_K) {
            this.slowed = this.destroyBlocksInAABB(this.dragonPartHead.field_70121_D) | this.destroyBlocksInAABB(this.dragonPartBody.field_70121_D) | this.destroyBlocksInAABB(this.dragonPartTail1.field_70121_D) | this.destroyBlocksInAABB(this.dragonPartTail2.field_70121_D) | this.destroyBlocksInAABB(this.dragonPartTail3.field_70121_D);
        }

        if (this.targetY >= (double)240.0F) {
            this.targetY = (double)240.0F;
        }

    }

    private void updateDragonEnderCrystal() {
        if (this.healingEnderCrystal != null) {
            if (this.healingEnderCrystal.field_70128_L) {
                if (!this.field_70170_p.field_72995_K) {
                    this.func_70965_a(this.dragonPartHead, DamageSource.func_94539_a((Explosion)null), 10.0F);
                }

                this.healingEnderCrystal = null;
            } else if (this.field_70173_aa % 10 == 0 && this.func_110143_aJ() < this.func_110138_aP()) {
                this.func_70606_j(this.func_110143_aJ() + 1.0F);
            }
        }

        if (this.field_70146_Z.nextInt(10) == 0) {
            float f = 32.0F;
            List list = this.field_70170_p.func_72872_a(EntityEnderCrystal.class, this.field_70121_D.func_72314_b((double)f, (double)f, (double)f));
            EntityEnderCrystal entityendercrystal = null;
            double d0 = Double.MAX_VALUE;

            for(EntityEnderCrystal entityendercrystal1 : list) {
                double d1 = entityendercrystal1.func_70068_e(this);
                if (d1 < d0) {
                    d0 = d1;
                    entityendercrystal = entityendercrystal1;
                }
            }

            this.healingEnderCrystal = entityendercrystal;
        }

    }

    private void collideWithEntities(List p_70970_1_) {
        double d0 = (this.dragonPartBody.field_70121_D.field_72340_a + this.dragonPartBody.field_70121_D.field_72336_d) / (double)2.0F;
        double d1 = (this.dragonPartBody.field_70121_D.field_72339_c + this.dragonPartBody.field_70121_D.field_72334_f) / (double)2.0F;
        Iterator iterator = p_70970_1_.iterator();

        while(iterator.hasNext() && this.field_70173_aa > 20) {
            Entity entity = (Entity)iterator.next();
            if (entity instanceof EntityLivingBase && this.func_70686_a(entity.getClass()) && !(entity instanceof EntityTitan) && entity.func_70067_L()) {
                double d2 = entity.field_70165_t - d0;
                double d3 = entity.field_70161_v - d1;
                double d4 = d2 * d2 + d3 * d3;
                double d5 = (double)5.0F;
                if (this.target != null) {
                    d5 = (double)25.0F;
                } else if (this.func_70638_az() != null) {
                    d5 = (double)10.0F;
                } else if (this.slowed) {
                    d5 = (double)3.75F;
                }

                entity.func_70024_g(d2 / d4 * d5, 0.33, d3 / d4 * d5);
            }
        }

    }

    private void attackEntitiesInList(List p_70971_1_) {
        for(int i = 0; i < p_70971_1_.size(); ++i) {
            Entity entity = (Entity)p_70971_1_.get(i);
            if (entity instanceof EntityLivingBase && this.func_70686_a(entity.getClass())) {
                ++this.animTime;
                this.func_70642_aH();
                entity.func_70097_a(DamageSource.func_76358_a(this), 200.0F);
                entity.field_70172_ad = 0;
            }
        }

        this.collideWithEntities(p_70971_1_);
    }

    private void setNewTarget() {
        this.forceNewTarget = false;
        if (this.func_70638_az() != null) {
            if (this.field_70146_Z.nextInt(2) == 0) {
                this.target = this.func_70638_az();
            } else {
                boolean flag = false;

                do {
                    this.targetX = this.func_70638_az().field_70165_t;
                    this.targetY = (double)this.field_70170_p.func_72825_h((int)this.func_70638_az().field_70165_t, (int)this.func_70638_az().field_70161_v) + (double)(40.0F + this.field_70146_Z.nextFloat() * 30.0F);
                    this.targetZ = this.func_70638_az().field_70161_v;
                    this.targetX += (double)MathHelper.func_76134_b((float)(this.field_70173_aa / 20 + this.func_145782_y())) * (double)60.0F;
                    this.targetZ += (double)MathHelper.func_76126_a((float)(this.field_70173_aa / 20 + this.func_145782_y())) * (double)60.0F;
                    double d0 = this.field_70165_t - this.targetX;
                    double d1 = this.field_70163_u - this.targetY;
                    double d2 = this.field_70161_v - this.targetZ;
                    flag = d0 * d0 + d1 * d1 + d2 * d2 > (double)100.0F;
                } while(!flag);

                this.target = null;
            }
        } else if (this.master != null) {
            boolean flag = false;

            do {
                this.targetX = this.master.field_70165_t;
                this.targetY = this.master.field_70163_u + (double)(70.0F + this.field_70146_Z.nextFloat() * 30.0F);
                this.targetZ = this.master.field_70161_v;
                this.targetX += (double)(this.field_70146_Z.nextFloat() * 100.0F - 50.0F);
                this.targetZ += (double)(this.field_70146_Z.nextFloat() * 100.0F - 50.0F);
                double d0 = this.field_70165_t - this.targetX;
                double d1 = this.field_70163_u - this.targetY;
                double d2 = this.field_70161_v - this.targetZ;
                flag = d0 * d0 + d1 * d1 + d2 * d2 > (double)100.0F;
            } while(!flag);

            this.target = null;
        } else {
            EntityPlayer player = this.field_70170_p.func_72890_a(this, (double)256.0F);
            if (player != null) {
                boolean flag = false;

                do {
                    this.targetX = player.field_70165_t;
                    this.targetY = (double)this.field_70170_p.func_72825_h((int)player.field_70165_t, (int)player.field_70161_v) + (double)(40.0F + this.field_70146_Z.nextFloat() * 30.0F);
                    this.targetZ = player.field_70161_v;
                    this.targetX += (double)(this.field_70146_Z.nextFloat() * 100.0F - 50.0F);
                    this.targetZ += (double)(this.field_70146_Z.nextFloat() * 100.0F - 50.0F);
                    double d0 = this.field_70165_t - this.targetX;
                    double d1 = this.field_70163_u - this.targetY;
                    double d2 = this.field_70161_v - this.targetZ;
                    flag = d0 * d0 + d1 * d1 + d2 * d2 > (double)100.0F;
                } while(!flag);

                this.target = null;
            } else {
                boolean flag = false;

                do {
                    this.targetX = (double)0.0F;
                    this.targetY = (double)(110.0F + this.field_70146_Z.nextFloat() * 30.0F);
                    this.targetZ = (double)0.0F;
                    this.targetX += (double)(this.field_70146_Z.nextFloat() * 100.0F - 50.0F);
                    this.targetZ += (double)(this.field_70146_Z.nextFloat() * 100.0F - 50.0F);
                    double d0 = this.field_70165_t - this.targetX;
                    double d1 = this.field_70163_u - this.targetY;
                    double d2 = this.field_70161_v - this.targetZ;
                    flag = d0 * d0 + d1 * d1 + d2 * d2 > (double)100.0F;
                } while(!flag);

                this.target = null;
            }
        }

    }

    private float simplifyAngle(double p_70973_1_) {
        return (float)MathHelper.func_76138_g(p_70973_1_);
    }

    private boolean destroyBlocksInAABB(AxisAlignedBB p_70972_1_) {
        int i = MathHelper.func_76128_c(p_70972_1_.field_72340_a);
        int j = MathHelper.func_76128_c(p_70972_1_.field_72338_b);
        int k = MathHelper.func_76128_c(p_70972_1_.field_72339_c);
        int l = MathHelper.func_76128_c(p_70972_1_.field_72336_d);
        int i1 = MathHelper.func_76128_c(p_70972_1_.field_72337_e);
        int j1 = MathHelper.func_76128_c(p_70972_1_.field_72334_f);
        boolean flag = false;
        boolean flag1 = false;

        for(int k1 = i; k1 <= l; ++k1) {
            for(int l1 = j; l1 <= i1; ++l1) {
                for(int i2 = k; i2 <= j1; ++i2) {
                    Block block = this.field_70170_p.func_147439_a(k1, l1, i2);
                    if (!block.isAir(this.field_70170_p, k1, l1, i2) && this.func_70089_S()) {
                        if (block != Blocks.field_150343_Z && block != Blocks.field_150377_bs && block != Blocks.field_150357_h && block.canEntityDestroy(this.field_70170_p, k1, l1, i2, this) && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                            flag1 = this.field_70170_p.func_147468_f(k1, l1, i2) || flag1;
                        } else {
                            flag = true;
                        }
                    }
                }
            }
        }

        if (flag1) {
            double d1 = p_70972_1_.field_72340_a + (p_70972_1_.field_72336_d - p_70972_1_.field_72340_a) * (double)this.field_70146_Z.nextFloat();
            double d2 = p_70972_1_.field_72338_b + (p_70972_1_.field_72337_e - p_70972_1_.field_72338_b) * (double)this.field_70146_Z.nextFloat();
            double d0 = p_70972_1_.field_72339_c + (p_70972_1_.field_72334_f - p_70972_1_.field_72339_c) * (double)this.field_70146_Z.nextFloat();
            this.field_70170_p.func_72869_a("largeexplode", d1, d2, d0, (double)0.0F, (double)0.0F, (double)0.0F);
        }

        return flag;
    }

    public boolean func_70965_a(EntityDragonPart p_70965_1_, DamageSource source, float p_70965_3_) {
        if (p_70965_1_ != this.dragonPartHead) {
            p_70965_3_ = p_70965_3_ / 4.0F + 1.0F;
        }

        float f1 = this.field_70177_z * (float)Math.PI / 180.0F;
        float f2 = MathHelper.func_76126_a(f1);
        float f3 = MathHelper.func_76134_b(f1);
        this.targetX = this.field_70165_t + (double)(f2 * 5.0F) + (double)((this.field_70146_Z.nextFloat() - 0.5F) * 2.0F);
        this.targetY = this.field_70163_u + (double)(this.field_70146_Z.nextFloat() * 3.0F) + (double)1.0F;
        this.targetZ = this.field_70161_v - (double)(f3 * 5.0F) + (double)((this.field_70146_Z.nextFloat() - 0.5F) * 2.0F);
        this.target = null;
        if (source.func_76346_g() != null && source.func_76346_g() instanceof EntityLivingBase && this.func_70686_a(source.func_76346_g().getClass())) {
            this.func_70624_b((EntityLivingBase)source.func_76346_g());
            if (this.field_70146_Z.nextInt(3) == 0) {
                this.forceNewTarget = true;
            }

            return this.func_70097_a(source, p_70965_3_);
        } else {
            return false;
        }
    }

    public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
        if (!(p_70097_1_.func_76346_g() instanceof EntityEndermanMinion) && !(p_70097_1_.func_76346_g() instanceof EntityEnderColossus) && !(p_70097_1_.func_76346_g() instanceof EntityDragon) && !(p_70097_1_.func_76346_g() instanceof EntityDragonMinion)) {
            if (p_70097_1_.func_76355_l() != "inFire" && p_70097_1_.func_76355_l() != "onFire" && p_70097_1_.func_76355_l() != "lava" && p_70097_1_.func_76355_l() != "inWall" && p_70097_1_.func_76355_l() != "drown" && p_70097_1_.func_76355_l() != "starve" && p_70097_1_.func_76355_l() != "cactus" && p_70097_1_.func_76355_l() != "fall" && p_70097_1_.func_76355_l() != "outOfWorld" && p_70097_1_.func_76355_l() != "generic" && p_70097_1_.func_76355_l() != "outOfWorld" && p_70097_1_.func_76355_l() != "magic" && p_70097_1_.func_76355_l() != "wither" && p_70097_1_.func_76355_l() != "anvil" && p_70097_1_.func_76355_l() != "fallingBlock" && p_70097_1_.func_76355_l() != "explosion" && p_70097_1_.func_76355_l() != "indirectMagic") {
                Entity entity = p_70097_1_.func_76346_g();
                if (entity instanceof EntityLivingBase) {
                    List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)256.0F, (double)256.0F, (double)256.0F));

                    for(int i = 0; i < list.size(); ++i) {
                        Entity entity1 = (Entity)list.get(i);
                        if (entity1 instanceof EntityDragonMinion) {
                            EntityDragonMinion entitypigzombie = (EntityDragonMinion)entity1;
                            entitypigzombie.func_70624_b((EntityLivingBase)entity);
                            entitypigzombie.func_70604_c((EntityLivingBase)entity);
                        }

                        this.func_70624_b((EntityLivingBase)entity);
                        this.func_70604_c((EntityLivingBase)entity);
                    }
                }

                return super.func_70097_a(p_70097_1_, p_70097_2_);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    protected boolean func_82195_e(DamageSource p_82195_1_, float p_82195_2_) {
        return true;
    }

    protected void func_70609_aI() {
        ++this.deathTicks;
        if (this.deathTicks >= 180 && this.deathTicks <= 200) {
            float f = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
            float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 4.0F;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
            this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + (double)2.0F + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
        }

        this.func_70091_d(this.field_70159_w * 0.2, this.field_70181_x * 0.2 + 0.15, this.field_70179_y * 0.2);
        this.field_70761_aq = this.field_70177_z = this.field_70759_as += 10.0F;
        if (!this.field_70170_p.field_72995_K) {
            if (this.deathTicks == 1) {
                this.field_70170_p.func_82739_e(1018, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
            }

            if (this.deathTicks >= 200) {
                if (this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
                    int i = 500;

                    while(i > 0) {
                        int j = EntityXPOrb.func_70527_a(i);
                        i -= j;
                        this.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, j));
                    }

                    this.field_70170_p.func_147449_b((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, Blocks.field_150380_bt);
                }

                this.func_70106_y();
            }
        }

    }

    private void createEnderPortal(int p_70975_1_, int p_70975_2_) {
        byte b0 = 64;
        BlockEndPortal.field_149948_a = true;
        byte b1 = 4;

        for(int k = b0 - 1; k <= b0 + 32; ++k) {
            for(int l = p_70975_1_ - b1; l <= p_70975_1_ + b1; ++l) {
                for(int i1 = p_70975_2_ - b1; i1 <= p_70975_2_ + b1; ++i1) {
                    double d0 = (double)(l - p_70975_1_);
                    double d1 = (double)(i1 - p_70975_2_);
                    double d2 = d0 * d0 + d1 * d1;
                    if (d2 <= ((double)b1 - (double)0.5F) * ((double)b1 - (double)0.5F)) {
                        if (k < b0) {
                            if (d2 <= ((double)(b1 - 1) - (double)0.5F) * ((double)(b1 - 1) - (double)0.5F)) {
                                this.field_70170_p.func_147449_b(l, k, i1, Blocks.field_150357_h);
                            }
                        } else if (k > b0) {
                            this.field_70170_p.func_147449_b(l, k, i1, Blocks.field_150350_a);
                        } else if (d2 > ((double)(b1 - 1) - (double)0.5F) * ((double)(b1 - 1) - (double)0.5F)) {
                            this.field_70170_p.func_147449_b(l, k, i1, Blocks.field_150357_h);
                        } else {
                            this.field_70170_p.func_147449_b(l, k, i1, Blocks.field_150384_bq);
                        }
                    }
                }
            }
        }

        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 0, p_70975_2_, Blocks.field_150357_h);
        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 1, p_70975_2_, Blocks.field_150357_h);
        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 2, p_70975_2_, Blocks.field_150357_h);
        this.field_70170_p.func_147449_b(p_70975_1_ - 1, b0 + 2, p_70975_2_, Blocks.field_150478_aa);
        this.field_70170_p.func_147449_b(p_70975_1_ + 1, b0 + 2, p_70975_2_, Blocks.field_150478_aa);
        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 2, p_70975_2_ - 1, Blocks.field_150478_aa);
        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 2, p_70975_2_ + 1, Blocks.field_150478_aa);
        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 3, p_70975_2_, Blocks.field_150357_h);
        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 4, p_70975_2_, Blocks.field_150380_bt);
        BlockEndPortal.field_149948_a = false;
    }

    protected void func_70623_bb() {
        this.field_70708_bq = 0;
    }

    public Entity[] func_70021_al() {
        return this.dragonPartArray;
    }

    public boolean func_70067_L() {
        return false;
    }

    public World func_82194_d() {
        return this.field_70170_p;
    }

    protected String func_70639_aQ() {
        return "mob.enderdragon.growl";
    }

    protected String func_70621_aR() {
        return "mob.enderdragon.hit";
    }

    protected float func_70599_aP() {
        return 5.0F;
    }
}
