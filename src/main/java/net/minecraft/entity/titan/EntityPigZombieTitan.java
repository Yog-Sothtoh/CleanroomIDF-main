//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanAntiTitanAttack;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanAttack1;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanAttack2;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanAttack3;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanAttack4;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanAttack5;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanAttack6;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanCreation;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanDeath;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanLightningAttack;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanRangedAttack;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanRoar;
import net.minecraft.entity.titan.animation.pigzombietitan.AnimationPigZombieTitanStun;
import net.minecraft.entity.titanminion.EntityGhastGuard;
import net.minecraft.entity.titanminion.EntityGhastGuardFireball;
import net.minecraft.entity.titanminion.EntityPigZombieMinion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.theTitans.world.WorldProviderVoid;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityPigZombieTitan extends EntityTitan implements IAnimatedEntity, IEntityMultiPartTitan {
    public boolean isStunned;
    public EntityTitanPart[] partArray;
    public EntityTitanPart head;
    public EntityTitanPart body;
    public EntityTitanPart rightArm;
    public EntityTitanPart leftArm;
    public EntityTitanPart rightLeg;
    public EntityTitanPart leftLeg;

    public EntityPigZombieTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 8.0F, 8.0F);
        this.body = new EntityTitanPart(worldIn, this, "body", 8.0F, 12.0F);
        this.rightArm = new EntityTitanPart(worldIn, this, "rightarm", 4.0F, 4.0F);
        this.leftArm = new EntityTitanPart(worldIn, this, "leftarm", 4.0F, 4.0F);
        this.rightLeg = new EntityTitanPart(worldIn, this, "rightleg", 4.0F, 12.0F);
        this.leftLeg = new EntityTitanPart(worldIn, this, "leftleg", 4.0F, 12.0F);
        this.partArray = new EntityTitanPart[]{this.head, this.body, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg};
        this.shouldParticlesBeUpward = true;
        this.field_70728_aV = 100000;
        this.func_70105_a(8.0F, 32.0F);
        this.meleeTitan = true;
        this.func_70062_b(0, new ItemStack(Items.field_151010_B));
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        this.field_70170_p.func_72838_d(this.head);
        this.field_70170_p.func_72838_d(this.body);
        this.field_70170_p.func_72838_d(this.rightArm);
        this.field_70170_p.func_72838_d(this.leftArm);
        this.field_70170_p.func_72838_d(this.rightLeg);
        this.field_70170_p.func_72838_d(this.leftLeg);
    }

    protected void applyEntityAI() {
        this.field_70714_bg.func_75776_a(1, new AnimationPigZombieTitanCreation(this));
        this.field_70714_bg.func_75776_a(1, new AnimationPigZombieTitanRangedAttack(this));
        this.field_70714_bg.func_75776_a(1, new AnimationPigZombieTitanRoar(this));
        this.field_70714_bg.func_75776_a(1, new AnimationPigZombieTitanDeath(this));
        this.field_70714_bg.func_75776_a(1, new AnimationPigZombieTitanAttack4(this));
        this.field_70714_bg.func_75776_a(1, new AnimationPigZombieTitanStun(this));
        this.field_70714_bg.func_75776_a(1, new AnimationPigZombieTitanAttack3(this));
        this.field_70714_bg.func_75776_a(1, new AnimationPigZombieTitanAttack2(this));
        this.field_70714_bg.func_75776_a(1, new AnimationPigZombieTitanLightningAttack(this));
        this.field_70714_bg.func_75776_a(1, new AnimationPigZombieTitanAntiTitanAttack(this));
        this.field_70714_bg.func_75776_a(1, new AnimationPigZombieTitanAttack1(this));
        this.field_70714_bg.func_75776_a(1, new AnimationPigZombieTitanAttack6(this));
        this.field_70714_bg.func_75776_a(1, new AnimationPigZombieTitanAttack5(this));
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.PigZombieTitanSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.func_70096_w().func_75682_a(12, (byte)0);
    }

    public double getSpeed() {
        return this.func_70631_g_() ? 0.9 + (double)this.getExtraPower() * 0.001 : 0.6 + (double)this.getExtraPower() * 0.001;
    }

    public boolean isArmored() {
        return this.func_110143_aJ() <= this.func_110138_aP() / 4.0F || TheTitans.NightmareMode || TheTitans.TotalDestructionMode;
    }

    public boolean func_70631_g_() {
        return this.func_70096_w().func_75683_a(12) == 1;
    }

    public float func_70603_bj() {
        float f = 16.0F;
        if (this.func_70631_g_()) {
            f *= 0.6F;
        }

        return f;
    }

    public int getMinionCap() {
        return this.animID == 11 && this.animTick > 80 ? 600 : 200;
    }

    public int getPriestCap() {
        return this.animID == 11 && this.animTick > 80 ? 300 : 100;
    }

    public int getZealotCap() {
        return this.animID == 11 && this.animTick > 80 ? 100 : 50;
    }

    public int getBishopCap() {
        return this.animID == 11 && this.animTick > 80 ? 40 : 20;
    }

    public int getTemplarCap() {
        return this.animID == 11 && this.animTick > 80 ? 32 : 16;
    }

    protected int func_70693_a(EntityPlayer player) {
        if (this.func_70631_g_()) {
            this.field_70728_aV = (int)((float)this.field_70728_aV * 2.5F);
        }

        return super.func_70693_a(player);
    }

    public void setChild(boolean childZombie) {
        this.func_70096_w().func_75692_b(12, (byte)(childZombie ? 1 : 0));
    }

    public int getFootStepModifer() {
        return 5;
    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        if (this.func_70631_g_()) {
            tagCompound.func_74757_a("IsBaby", true);
        }

        tagCompound.func_74757_a("Stunned", this.isStunned);
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        if (tagCompund.func_74767_n("IsBaby")) {
            this.setChild(true);
        }

        this.isStunned = tagCompund.func_74767_n("Stunned");
    }

    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.AVERAGE;
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != this.head.getClass() && p_70686_1_ != this.body.getClass() && p_70686_1_ != this.rightArm.getClass() && p_70686_1_ != this.leftArm.getClass() && p_70686_1_ != this.rightLeg.getClass() && p_70686_1_ != this.leftLeg.getClass() && p_70686_1_ != EntityPigZombieMinion.class && p_70686_1_ != EntityGhastGuard.class && p_70686_1_ != EntityPigZombieTitan.class;
    }

    public void func_70636_d() {
        if (!this.func_70115_ae() && !this.getWaiting() && !this.isStunned && this.animID == 0) {
            if (this.func_70638_az() != null && this.func_70068_e(this.func_70638_az()) > this.getMeleeRange() + (!this.func_70638_az().field_70122_E ? (double)1000.0F : (double)8000.0F)) {
                if (this.field_70163_u <= this.func_70638_az().field_70163_u + (double)12.0F && this.field_70163_u < (double)256.0F - (double)this.field_70131_O) {
                    this.field_70143_R = 0.0F;
                    this.field_70181_x += 0.9 - this.field_70181_x;
                    if (this.field_70181_x < (double)0.0F) {
                        this.field_70181_x = (double)0.0F;
                    }
                }

                this.field_70181_x *= 0.6;
            }

            if (!this.field_70122_E) {
                float f = (this.field_70146_Z.nextFloat() - 0.5F) * 10.0F;
                float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 1.0F;
                float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 10.0F;
                this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + (double)5.0F + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
            }
        }

        if (this.getWaiting()) {
            AnimationAPI.sendAnimPacket(this, 0);
            AnimationAPI.sendAnimPacket(this, 13);
            this.setAnimTick(0);
            EntityPlayer player = this.field_70170_p.func_72890_a(this, (double)24.0F);
            if (player != null) {
                this.setWaiting(false);
                this.func_70625_a(player, 180.0F, 0.0F);
                player.func_71029_a(TitansAchievments.locateTitan);
            }
        } else {
            if (this.getAnimID() == 13) {
                this.field_70159_w = (double)0.0F;
                this.field_70179_y = (double)0.0F;
                if (this.field_70181_x > (double)0.0F) {
                    this.field_70181_x = (double)0.0F;
                }
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 1) {
                this.func_85030_a("thetitans:titanBirth", 1000.0F, 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 10) {
                this.func_85030_a("thetitans:titanPigZombieLiving", this.func_70599_aP(), 0.8F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 40) {
                this.func_85030_a("thetitans:titanRumble", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 240) {
                this.func_85030_a("thetitans:titanZombieRoar", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 130) {
                this.func_85030_a("thetitans:titanSkeletonGetUp", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && (this.getAnimTick() == 110 || this.getAnimTick() == 150 || this.getAnimTick() == 170)) {
                this.func_145780_a(0, 0, 0, Blocks.field_150348_b);
                this.func_85030_a("thetitans:titanPress", this.func_70599_aP(), 1.0F);
            }
        }

        if (this.field_70170_p.field_72995_K && this.deathTicks < this.getThreashHold() && this.func_70026_G()) {
            for(int i = 0; i < this.getParticleCount() * 50; ++i) {
                this.field_70170_p.func_72869_a(this.getParticles(), this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.25F, (double)0.0F);
            }
        }

        if (this.field_70146_Z.nextInt(40) == 0 && this.func_70026_G()) {
            this.func_85030_a("random.fizz", 20.0F, 1.5F);
        }

        if (this.animID == 8) {
            if (this.animTick == 140 || this.animTick == 300 || this.animTick == 330) {
                this.func_85030_a("thetitans:slashFlesh", 20.0F, 1.0F);
                this.attackEntityFromPart(this.head, (new DamageSource("other")).func_76348_h().func_151518_m(), 1000.0F);
            }

            if (this.animTick == 400) {
                this.func_85030_a("thetitans:titanZombieRoar", 1000.0F, 0.95F);
            }

            if (this.animTick == 530) {
                this.isStunned = false;
            } else {
                this.func_70624_b((EntityLivingBase)null);
            }
        }

        if (this.isStunned) {
            this.func_70624_b((EntityLivingBase)null);
            AnimationAPI.sendAnimPacket(this, 8);
            this.setAnimID(8);
        }

        if (this.animID == 10) {
            if (this.animTick == 30 || this.animTick == 70) {
                this.func_145780_a(0, 0, 0, Blocks.field_150348_b);
            }

            if (this.animTick == 190) {
                this.func_85030_a("thetitans:titanFall", 20.0F, 1.0F);
                this.func_85030_a("thetitans:groundSmash", 20.0F, 1.0F);
                this.shakeNearbyPlayerCameras((double)10000.0F);
                this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
                this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
                this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
                this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
            }

            if (this.animTick == 200) {
                this.func_85030_a("thetitans:distantLargeFall", 10000.0F, 1.0F);
            }
        }

        if (this.field_70146_Z.nextInt(200) == 0 && this.animID == 0 && this.func_70638_az() != null && this.field_70122_E && this.func_70068_e(this.func_70638_az()) > (double)512.0F) {
            this.func_70664_aZ();
            this.func_85030_a(this.func_70621_aR(), this.func_70599_aP(), this.func_70647_i());
        }

        if (this.getAnimID() == 7 && this.getAnimTick() == 122) {
            double d8 = (double)32.0F;
            Vec3 vec3 = this.func_70676_i(1.0F);
            double dx = vec3.field_72450_a * d8;
            double dz = vec3.field_72449_c * d8;
            int y = MathHelper.func_76128_c(this.field_70163_u);
            int x = MathHelper.func_76128_c(this.field_70165_t + dx);
            int z = MathHelper.func_76128_c(this.field_70161_v + dz);
            if (this.field_70170_p.func_147439_a(x, y - 1, z).func_149688_o() != Material.field_151579_a) {
                this.func_85030_a("thetitans:titanStrike", 20.0F, 1.0F);
                this.func_85030_a("thetitans:titanSlam", 20.0F, 1.0F);
            }

            for(int l1 = -4; l1 <= 4; ++l1) {
                for(int i2 = -4; i2 <= 4; ++i2) {
                    for(int j = -1; j <= 1; ++j) {
                        int j2 = x + l1;
                        int k = y + j;
                        int l = z + i2;
                        Block block = this.field_70170_p.func_147439_a(j2, k, l);
                        if (!block.isAir(this.field_70170_p, j2, k, l)) {
                            this.field_70170_p.func_72926_e(2001, j2, k, l, Block.func_149682_b(block));
                            if (block == Blocks.field_150349_c) {
                                this.field_70170_p.func_147449_b(j2, k, l, Blocks.field_150346_d);
                            }
                        }

                        if (block.func_149638_a(this) <= 1.5F && block.func_149662_c() && block != Blocks.field_150350_a && block != Blocks.field_150424_aL && block != Blocks.field_150346_d && block != Blocks.field_150349_c && block != Blocks.field_150359_w && block != Blocks.field_150410_aZ) {
                            AnimationAPI.sendAnimPacket(this, 8);
                            this.setAnimID(8);
                            this.setAnimTick(0);
                            this.func_85030_a("random.anvil_land", 20.0F, 0.5F);
                            if (!this.field_70170_p.field_72995_K) {
                                this.isStunned = true;
                            }
                        }
                    }
                }
            }
        }

        float f = this.field_70761_aq * (float)Math.PI / 180.0F;
        float f1 = MathHelper.func_76126_a(f);
        float f2 = MathHelper.func_76134_b(f);
        if (this.func_70631_g_()) {
            this.func_70105_a(6.0F, 18.0F);
        } else {
            this.func_70105_a(8.0F, 32.0F);
        }

        if (this.field_70173_aa > 5) {
            this.head.field_70131_O = this.head.field_70130_N = this.func_70631_g_() ? 6.0F : 8.0F;
            this.body.field_70131_O = this.func_70631_g_() ? 6.0F : 12.0F;
            this.body.field_70130_N = this.func_70631_g_() ? 3.5F : 7.0F;
            this.leftLeg.field_70131_O = this.rightLeg.field_70131_O = this.func_70631_g_() ? 6.0F : 12.0F;
            this.leftLeg.field_70130_N = this.rightLeg.field_70130_N = this.func_70631_g_() ? 2.0F : 4.0F;
            this.rightArm.field_70130_N = this.leftArm.field_70130_N = this.rightArm.field_70131_O = this.leftArm.field_70131_O = this.func_70631_g_() ? 2.0F : 4.0F;
            this.head.func_70012_b(this.field_70165_t, this.field_70163_u + (this.func_70631_g_() ? (double)12.0F : (double)24.0F), this.field_70161_v, 0.0F, 0.0F);
            this.body.func_70012_b(this.field_70165_t, this.field_70163_u + (this.func_70631_g_() ? (double)6.0F : (double)12.0F), this.field_70161_v, 0.0F, 0.0F);
            this.rightArm.func_70012_b(this.field_70165_t + (double)f2 * (this.func_70631_g_() ? (double)3.0F : (double)6.0F), this.field_70163_u + (this.func_70631_g_() ? (double)10.0F : (double)20.0F), this.field_70161_v + (double)f1 * (this.func_70631_g_() ? (double)3.0F : (double)6.0F), 0.0F, 0.0F);
            this.leftArm.func_70012_b(this.field_70165_t - (double)f2 * (this.func_70631_g_() ? (double)3.0F : (double)6.0F), this.field_70163_u + (this.func_70631_g_() ? (double)10.0F : (double)20.0F), this.field_70161_v - (double)f1 * (this.func_70631_g_() ? (double)3.0F : (double)6.0F), 0.0F, 0.0F);
            this.rightLeg.func_70012_b(this.field_70165_t + (double)f2 * (this.func_70631_g_() ? (double)1.0F : (double)2.0F), this.field_70163_u, this.field_70161_v + (double)f1 * (this.func_70631_g_() ? (double)1.0F : (double)2.0F), 0.0F, 0.0F);
            this.leftLeg.func_70012_b(this.field_70165_t - (double)f2 * (this.func_70631_g_() ? (double)1.0F : (double)2.0F), this.field_70163_u, this.field_70161_v - (double)f1 * (this.func_70631_g_() ? (double)1.0F : (double)2.0F), 0.0F, 0.0F);
            if (this.func_70089_S() && !this.isStunned) {
                this.collideWithEntities(this.head, this.field_70170_p.func_72839_b(this, this.head.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.body, this.field_70170_p.func_72839_b(this, this.body.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.rightArm, this.field_70170_p.func_72839_b(this, this.rightArm.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.leftArm, this.field_70170_p.func_72839_b(this, this.leftArm.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
            }

            this.destroyBlocksInAABB(this.head.field_70121_D);
            this.destroyBlocksInAABB(this.body.field_70121_D);
            this.destroyBlocksInAABB(this.rightArm.field_70121_D);
            this.destroyBlocksInAABB(this.leftArm.field_70121_D);
            this.destroyBlocksInAABB(this.leftLeg.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F));
            this.destroyBlocksInAABB(this.rightLeg.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F));

            for(int i = 0; i < this.partArray.length; ++i) {
                List list = this.field_70170_p.func_72839_b(this, this.partArray[i].field_70121_D.func_72314_b((double)0.5F, (double)0.5F, (double)0.5F));
                if (list != null && !list.isEmpty()) {
                    for(int j = 0; j < list.size(); ++j) {
                        Entity entity = (Entity)list.get(j);
                        if (entity instanceof EntityFireball && ((EntityFireball)entity).field_70235_a != this && !(entity instanceof EntityLightningBall) && !(entity instanceof EntityGargoyleTitanFireball) && !(entity instanceof EntityWebShot)) {
                            ((EntityFireball)entity).func_70097_a(DamageSource.func_92087_a(this), 0.0F);
                        }

                        if (entity instanceof EntityTitanFireball && ((EntityTitanFireball)entity).field_70235_a != null && ((EntityTitanFireball)entity).field_70235_a != this) {
                            ((EntityTitanFireball)entity).onImpactPublic(this);
                        }

                        if (entity instanceof EntityGargoyleTitanFireball) {
                            this.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                            this.field_70170_p.func_72885_a((Entity)(((EntityGargoyleTitanFireball)entity).field_70235_a != null ? ((EntityGargoyleTitanFireball)entity).field_70235_a : (EntityGargoyleTitanFireball)entity), ((EntityGargoyleTitanFireball)entity).field_70165_t, ((EntityGargoyleTitanFireball)entity).field_70163_u, ((EntityGargoyleTitanFireball)entity).field_70161_v, 8.0F, false, false);
                            this.attackEntityFromPart(this.partArray[i], DamageSource.func_76362_a((EntityGargoyleTitanFireball)entity, (Entity)(((EntityGargoyleTitanFireball)entity).field_70235_a != null ? ((EntityGargoyleTitanFireball)entity).field_70235_a : (EntityGargoyleTitanFireball)entity)), 1000.0F);
                            entity.func_70106_y();
                        }

                        if (entity instanceof EntityHarcadiumArrow) {
                            this.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                            this.attackEntityFromPart(this.partArray[i], DamageSourceExtra.causeHarcadiumArrowDamage((EntityHarcadiumArrow)entity, (Entity)(((EntityHarcadiumArrow)entity).field_70250_c != null ? ((EntityHarcadiumArrow)entity).field_70250_c : (EntityHarcadiumArrow)entity)), 500.0F);
                            entity.func_70106_y();
                        }

                        if (entity instanceof EntityWebShot && ((EntityWebShot)entity).field_70235_a != this) {
                            this.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                            this.attackEntityFromPart(this.partArray[i], DamageSourceExtra.causeAntiTitanDamage((Entity)(((EntityWebShot)entity).field_70235_a != this ? ((EntityWebShot)entity).field_70235_a : (EntityWebShot)entity)), 300.0F);
                            int i1 = MathHelper.func_76128_c(this.partArray[i].field_70163_u);
                            int i11 = MathHelper.func_76128_c(this.partArray[i].field_70165_t);
                            int j1 = MathHelper.func_76128_c(this.partArray[i].field_70161_v);
                            boolean flag = false;

                            for(int l1 = -2 - this.field_70146_Z.nextInt(4); l1 <= 2 + this.field_70146_Z.nextInt(4); ++l1) {
                                for(int i2 = -2 - this.field_70146_Z.nextInt(4); i2 <= 2 + this.field_70146_Z.nextInt(4); ++i2) {
                                    for(int h = -2; h <= 2 + this.field_70146_Z.nextInt(5); ++h) {
                                        int j2 = i11 + l1;
                                        int k = i1 + h;
                                        int l = j1 + i2;
                                        Block block1 = this.field_70170_p.func_147439_a(j2, k, l);
                                        if (!block1.func_149662_c()) {
                                            this.field_70170_p.func_147449_b(j2, k, l, Blocks.field_150321_G);
                                        }
                                    }
                                }
                            }

                            entity.func_70106_y();
                        }
                    }
                }
            }
        }

        this.meleeTitan = true;
        if (this.getAnimID() == 5) {
            if (this.getAnimTick() == 34) {
                this.func_85030_a("thetitans:lightningCharge", 100.0F, 1.0F);
            }

            if (this.getAnimTick() <= 50 && this.getAnimTick() >= 20) {
                float ex = this.func_70631_g_() ? 4.5F : 9.5F;
                float fl = this.field_70761_aq * (float)Math.PI / 180.0F;
                float fl1 = MathHelper.func_76126_a(fl);
                float fl2 = MathHelper.func_76134_b(fl);
                this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t - (double)(fl2 * ex), this.field_70163_u + (this.func_70631_g_() ? (double)12.0F : (double)24.0F), this.field_70161_v - (double)(fl1 * ex), 1.0F, 0.0F, 0.0F));
                this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + (double)(fl2 * ex), this.field_70163_u + (this.func_70631_g_() ? (double)12.0F : (double)24.0F), this.field_70161_v + (double)(fl1 * ex), 1.0F, 0.0F, 0.0F));
                if (this.func_70638_az() == null && !this.field_70170_p.field_72995_K) {
                    this.func_70691_i(50.0F);
                }
            }

            if (this.getAnimTick() == 64) {
                this.func_85030_a("thetitans:lightningThrow", 100.0F, 1.0F);
                double d8 = this.func_70631_g_() ? (double)6.0F : (double)12.0F;
                Vec3 vec3 = this.func_70676_i(1.0F);
                double dx = vec3.field_72450_a * d8;
                double dz = vec3.field_72449_c * d8;
                float da = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                int i1 = this.getKnockbackAmount();
                this.field_70170_p.func_72885_a(this, this.field_70165_t + dx, this.field_70163_u + (double)26.0F, this.field_70161_v + dz, 1.0F, false, false);
                this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + (this.func_70631_g_() ? (double)9.0F : (double)18.0F), this.field_70161_v + dz, 1.0F, 0.0F, 0.0F));
                if (this.func_70638_az() != null) {
                    this.attackChoosenEntity(this.func_70638_az(), da, i1);
                    this.attackChoosenEntity(this.func_70638_az(), da, i1);
                    this.attackChoosenEntity(this.func_70638_az(), da, i1);
                    EntityLivingBase var10000 = this.func_70638_az();
                    var10000.field_70181_x += (double)(1.0F + this.field_70146_Z.nextFloat());
                    this.field_70170_p.func_72885_a(this, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 2.0F, false, false);
                    this.func_70638_az().func_70097_a(DamageSourceExtra.lightningBolt, f);
                    this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 1.0F, 0.0F, 0.0F));
                    List list1 = this.field_70170_p.func_72839_b(this.func_70638_az(), this.func_70638_az().field_70121_D.func_72314_b((double)12.0F, (double)12.0F, (double)12.0F));
                    if (list1 != null && !list1.isEmpty()) {
                        for(int i11 = 0; i11 < list1.size(); ++i11) {
                            Entity entity1 = (Entity)list1.get(i11);
                            if (entity1 instanceof EntityLivingBase && this.func_70686_a(entity1.getClass())) {
                                this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, entity1.field_70165_t, entity1.field_70163_u, entity1.field_70161_v, 1.0F, 0.0F, 0.0F));
                                this.attackChoosenEntity(entity1, da, i1);
                                this.attackChoosenEntity(entity1, da, i1);
                                if (!(entity1 instanceof EntityTitan)) {
                                    entity1.field_70181_x += (double)(1.0F + this.field_70146_Z.nextFloat());
                                }
                            }
                        }
                    }

                    for(int it = 0; it < 300; ++it) {
                        Vec3 vec31 = this.func_70676_i(1.0F);
                        double d5 = this.func_70638_az().field_70165_t + this.field_70146_Z.nextGaussian() * (double)8.0F - (this.head.field_70165_t + vec31.field_72450_a * ((double)16.0F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 16.0F)));
                        double d6 = this.func_70638_az().field_70163_u + this.field_70146_Z.nextGaussian() * (double)8.0F - (this.head.field_70163_u + (double)32.0F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 16.0F));
                        double d7 = this.func_70638_az().field_70161_v + this.field_70146_Z.nextGaussian() * (double)8.0F - (this.head.field_70161_v + vec31.field_72449_c * ((double)16.0F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 16.0F)));
                        EntityGhastGuardFireball entitylargefireball = new EntityGhastGuardFireball(this.field_70170_p, this, d5, d6, d7);
                        entitylargefireball.field_70165_t = this.head.field_70165_t + vec31.field_72450_a * ((double)16.0F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 16.0F));
                        entitylargefireball.field_70163_u = this.head.field_70163_u + (double)32.0F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 16.0F);
                        entitylargefireball.field_70161_v = this.head.field_70161_v + vec31.field_72449_c * ((double)16.0F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 16.0F));
                        this.field_70170_p.func_72838_d(entitylargefireball);
                        EntityTitanFireball entitylargefireball1 = new EntityTitanFireball(this.field_70170_p, this, d5, d6, d7, 3);
                        entitylargefireball1.field_70165_t = this.head.field_70165_t + vec31.field_72450_a * ((double)16.0F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 16.0F));
                        entitylargefireball1.field_70163_u = this.head.field_70163_u + (double)32.0F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 16.0F);
                        entitylargefireball1.field_70161_v = this.head.field_70161_v + vec31.field_72449_c * ((double)16.0F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 16.0F));
                        this.field_70170_p.func_72838_d(entitylargefireball1);
                        entitylargefireball1.setFireballID(3);
                        EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.field_70170_p, this, d5, d6, d7);
                        entitysmallfireball.field_70165_t = this.head.field_70165_t + vec31.field_72450_a * ((double)16.0F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 16.0F));
                        entitysmallfireball.field_70163_u = this.head.field_70163_u + (double)32.0F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 16.0F);
                        entitysmallfireball.field_70161_v = this.head.field_70161_v + vec31.field_72449_c * ((double)16.0F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 16.0F));
                        this.field_70170_p.func_72838_d(entitysmallfireball);
                    }
                }
            }
        }

        if (this.isStunned || this.deathTicks > 0) {
            this.field_70159_w *= (double)0.0F;
            this.field_70179_y *= (double)0.0F;
        }

        if (!AnimationAPI.isEffectiveClient() && this.func_70638_az() != null && !this.isStunned && this.getAnimID() == 0) {
            double d0 = this.func_70068_e(this.func_70638_az());
            if (d0 < this.getMeleeRange()) {
                if (!(this.func_70638_az() instanceof EntityTitan) && !(this.func_70638_az().field_70131_O >= 6.0F) && !(this.func_70638_az().field_70163_u > this.field_70163_u + (double)6.0F)) {
                    switch (this.field_70146_Z.nextInt(7)) {
                        case 0:
                            AnimationAPI.sendAnimPacket(this, 11);
                            this.setAnimID(11);
                            break;
                        case 1:
                            AnimationAPI.sendAnimPacket(this, 3);
                            this.setAnimID(3);
                            break;
                        case 2:
                            AnimationAPI.sendAnimPacket(this, 4);
                            this.setAnimID(4);
                            break;
                        case 3:
                            AnimationAPI.sendAnimPacket(this, 6);
                            this.setAnimID(6);
                            break;
                        case 4:
                            AnimationAPI.sendAnimPacket(this, 7);
                            this.setAnimID(7);
                            break;
                        case 5:
                            AnimationAPI.sendAnimPacket(this, 9);
                            this.setAnimID(9);
                            break;
                        case 6:
                            AnimationAPI.sendAnimPacket(this, 2);
                            this.setAnimID(2);
                    }
                } else {
                    AnimationAPI.sendAnimPacket(this, 1);
                    this.setAnimID(1);
                }
            } else if (this.getAnimID() == 0 && this.func_70681_au().nextInt(100) == 0) {
                switch (this.field_70146_Z.nextInt(3)) {
                    case 0:
                        AnimationAPI.sendAnimPacket(this, 5);
                        this.setAnimID(5);
                        break;
                    case 1:
                        AnimationAPI.sendAnimPacket(this, 12);
                        this.setAnimID(12);
                        break;
                    case 2:
                        if (this.func_70681_au().nextInt(4) == 0) {
                            AnimationAPI.sendAnimPacket(this, 11);
                            this.setAnimID(11);
                        } else {
                            AnimationAPI.sendAnimPacket(this, 5);
                            this.setAnimID(5);
                        }
                }
            }
        }

        if (this.animID == 1 && this.animTick == 1) {
            this.antiTitanAttackAnimeID = this.func_70681_au().nextInt(4);
        }

        if (this.getAnimID() == 12 && this.func_70638_az() != null && this.getAnimTick() == 55) {
            for(int i = 0; i < 4 + 2 * this.field_70170_p.field_73013_u.func_151525_a(); ++i) {
                this.attackEntityWithRangedAttack(this.func_70638_az(), 0.0F);
            }
        }

        if (this.field_70146_Z.nextInt(20) == 0 && this.func_70638_az() != null) {
            this.func_85030_a("mob.zombiepig.zpigangry", 10000.0F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F) * (0.6F + this.field_70146_Z.nextFloat()));
        }

        if (this.func_70631_g_()) {
            this.func_94058_c(StatCollector.func_74838_a("entity.PigZombieTitan.name.baby"));
        } else {
            this.func_94058_c(StatCollector.func_74838_a("entity.PigZombieTitan.name"));
        }

        if (TheTitans.NightmareMode) {
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)1800.0F + (double)(this.getExtraPower() * 180));
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)40000.0F + (double)(this.getExtraPower() * 2000));
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)600.0F + (double)(this.getExtraPower() * 60));
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)20000.0F + (double)(this.getExtraPower() * 1000));
        }

        if (!this.getWaiting() && this.animID != 13 && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0) {
                    EntityGhastGuard entitychicken = new EntityGhastGuard(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70024_g((double)0.0F, (double)1.5F, (double)0.0F);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.5F);
                    ++this.numSpecialMinions;
                } else if (this.numMinions < this.getMinionCap()) {
                    EntityPigZombieMinion entitychicken = new EntityPigZombieMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(0);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    entitychicken.func_70024_g((double)0.0F, 0.8, (double)0.0F);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, Integer.MAX_VALUE, 0, false));
                    if (this.func_70631_g_()) {
                        entitychicken.func_82227_f(true);
                    }

                    ++this.numMinions;
                    Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v);
                    this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                    if (block == Blocks.field_150349_c) {
                        this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                    }
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0) {
                    EntityGhastGuard entitychicken = new EntityGhastGuard(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70024_g((double)0.0F, (double)1.5F, (double)0.0F);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.5F);
                    ++this.numSpecialMinions;
                } else if (this.numPriests < this.getPriestCap()) {
                    EntityPigZombieMinion entitychicken = new EntityPigZombieMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(1);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    entitychicken.func_70024_g((double)0.0F, 0.8, (double)0.0F);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, Integer.MAX_VALUE, 0, false));
                    if (this.func_70631_g_()) {
                        entitychicken.func_82227_f(true);
                    }

                    ++this.numPriests;
                    Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v);
                    this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                    if (block == Blocks.field_150349_c) {
                        this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                    }
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0) {
                    EntityGhastGuard entitychicken = new EntityGhastGuard(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70024_g((double)0.0F, (double)1.5F, (double)0.0F);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.5F);
                    ++this.numSpecialMinions;
                } else if (this.numZealots < this.getZealotCap()) {
                    EntityPigZombieMinion entitychicken = new EntityPigZombieMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(2);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    entitychicken.func_70024_g((double)0.0F, 0.8, (double)0.0F);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, Integer.MAX_VALUE, 0, false));
                    if (this.func_70631_g_()) {
                        entitychicken.func_82227_f(true);
                    }

                    ++this.numZealots;
                    Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v);
                    this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                    if (block == Blocks.field_150349_c) {
                        this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                    }
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0) {
                    EntityGhastGuard entitychicken = new EntityGhastGuard(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70024_g((double)0.0F, (double)1.5F, (double)0.0F);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.5F);
                    ++this.numSpecialMinions;
                } else if (this.numBishop < this.getBishopCap()) {
                    EntityPigZombieMinion entitychicken = new EntityPigZombieMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(3);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    entitychicken.func_70024_g((double)0.0F, 0.8, (double)0.0F);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, Integer.MAX_VALUE, 0, false));
                    if (this.func_70631_g_()) {
                        entitychicken.func_82227_f(true);
                    }

                    ++this.numBishop;
                    Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v);
                    this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                    if (block == Blocks.field_150349_c) {
                        this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                    }
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0) {
                    EntityGhastGuard entitychicken = new EntityGhastGuard(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70024_g((double)0.0F, (double)1.5F, (double)0.0F);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.5F);
                    ++this.numSpecialMinions;
                } else if (this.numTemplar < this.getTemplarCap()) {
                    EntityPigZombieMinion entitychicken = new EntityPigZombieMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(4);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    entitychicken.func_70024_g((double)0.0F, 0.8, (double)0.0F);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, Integer.MAX_VALUE, 0, false));
                    if (this.func_70631_g_()) {
                        entitychicken.func_82227_f(true);
                    }

                    ++this.numTemplar;
                    Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v);
                    this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                    if (block == Blocks.field_150349_c) {
                        this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                    }
                }
            }
        }

        super.func_70636_d();
    }

    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.field_70761_aq = this.field_70177_z = this.field_70759_as;
        this.func_70625_a(p_82196_1_, 180.0F, 30.0F);
        double d8 = (double)12.0F;
        Vec3 vec3 = this.func_70676_i(1.0F);
        double dx = vec3.field_72450_a * d8;
        double dz = vec3.field_72449_c * d8;
        EntityProtoBall entityarrow = new EntityProtoBall(this.field_70170_p, this);
        double d0 = p_82196_1_.field_70165_t + p_82196_1_.field_70159_w - (this.head.field_70165_t + dx);
        double d1 = p_82196_1_.field_70163_u + (double)p_82196_1_.func_70047_e() - (double)8.0F - this.head.field_70163_u;
        double d2 = p_82196_1_.field_70161_v + p_82196_1_.field_70179_y - (this.head.field_70161_v + dz);
        float f1 = MathHelper.func_76133_a(d0 * d0 + d2 * d2);
        entityarrow.func_70186_c(d0, d1 + (double)f1, d2, 0.95F, (float)(45 - this.field_70170_p.field_73013_u.func_151525_a() * 5));
        entityarrow.field_70165_t = this.head.field_70165_t + dx;
        entityarrow.field_70163_u = this.head.field_70163_u;
        entityarrow.field_70161_v = this.head.field_70161_v + dz;
        if (!this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_72838_d(entityarrow);
        }

        entityarrow.field_70159_w *= (double)1.5F;
        entityarrow.field_70179_y *= (double)1.5F;
        this.field_70170_p.func_72889_a((EntityPlayer)null, 1008, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
        if (this.func_70068_e(p_82196_1_) < (double)400.0F) {
            this.attackChoosenEntity(p_82196_1_, 10.0F, 5);
        }

    }

    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(100) == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL;
    }

    public int getMinionSpawnRate() {
        return TheTitans.PigZombieTitanMinionSpawnrate;
    }

    public int getRegenTime() {
        return 5;
    }

    public boolean shouldMove() {
        return this.animID == 0 && !this.isStunned && this.func_70638_az() != null ? super.shouldMove() : false;
    }

    public boolean func_70652_k(Entity p_70652_1_) {
        return false;
    }

    public boolean canBeHurtByPlayer() {
        return this.isStunned && !this.func_85032_ar();
    }

    public String getParticles() {
        return (double)this.field_70170_p.field_73012_v.nextFloat() < (double)0.25F ? "explode" : "smoke";
    }

    public boolean func_70662_br() {
        return true;
    }

    protected void func_70069_a(float p_70069_1_) {
        super.func_70069_a(p_70069_1_);
        if (!this.field_70170_p.field_72995_K) {
            this.func_82164_bB();
        }

    }

    public float func_70047_e() {
        float f = 27.6F;
        if (this.func_70631_g_()) {
            f = 14.8F;
        }

        return f;
    }

    protected String func_70639_aQ() {
        return !this.isStunned && !this.getWaiting() && this.animID != 13 ? "thetitans:titanPigZombieLiving" : null;
    }

    protected String func_70621_aR() {
        return "thetitans:titanPigZombieGrunt";
    }

    protected String func_70673_aS() {
        return "thetitans:titanPigZombieDeath";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.func_85030_a("thetitans:titanStep", 10.0F, 1.0F);
        this.shakeNearbyPlayerCameras((double)4000.0F);
        if (!this.getWaiting() && this.animID != 13) {
            float f3 = this.field_70177_z * (float)Math.PI / 180.0F;
            float f11 = MathHelper.func_76126_a(f3);
            float f4 = MathHelper.func_76134_b(f3);
            if (this.footID == 0) {
                this.destroyBlocksInAABB(this.leftLeg.field_70121_D.func_72317_d((double)0.0F, (double)-1.0F, (double)0.0F));
                this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)1.0F, (double)1.0F, (double)1.0F).func_72317_d((double)(f11 * 4.0F), (double)0.0F, (double)(f4 * 4.0F))));
                ++this.footID;
            } else {
                this.destroyBlocksInAABB(this.rightLeg.field_70121_D.func_72317_d((double)0.0F, (double)-1.0F, (double)0.0F));
                this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)1.0F, (double)1.0F, (double)1.0F).func_72317_d((double)(f11 * 4.0F), (double)0.0F, (double)(f4 * 4.0F))));
                this.footID = 0;
            }
        }

    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            for(int x = 0; x < 24; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                entitylargefireball.func_70107_b(this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                ++entitylargefireball.field_70181_x;
                entitylargefireball.setXPCount(20000);
                this.field_70170_p.func_72838_d(entitylargefireball);
            }

            for(int l = 0; l < 16; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151055_y));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 32; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151043_k));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 128 + this.field_70146_Z.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151078_bh));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 128 + this.field_70146_Z.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151074_bl));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 32 + this.field_70146_Z.nextInt(32 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151103_aS));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 32 + this.field_70146_Z.nextInt(32 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151044_h));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 32 + this.field_70146_Z.nextInt(32 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151043_k));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 12 + this.field_70146_Z.nextInt(12 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151166_bC));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 12 + this.field_70146_Z.nextInt(12 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151045_i));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 0 + this.field_70146_Z.nextInt(8 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(TitanItems.harcadium));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            if (this.field_70146_Z.nextInt(5) == 0) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150357_h));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            if (this.field_70146_Z.nextInt(5) == 0) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150357_h));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }
        }

    }

    public StatBase getAchievement() {
        return TitansAchievments.pigzombietitan;
    }

    public double func_70033_W() {
        return super.func_70033_W() - (double)8.0F;
    }

    protected void func_70600_l(int p_70600_1_) {
        this.func_70099_a(new ItemStack(Blocks.field_150340_R, 64, 1), 0.0F);
    }

    protected void func_82164_bB() {
        super.func_82164_bB();
        this.func_70062_b(0, new ItemStack(Items.field_151010_B));

        for(int i = 0; i < 2; ++i) {
            EntityGhastGuard entitychicken = new EntityGhastGuard(this.field_70170_p);
            entitychicken.master = this;
            entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            entitychicken.func_110161_a((IEntityLivingData)null);
            this.field_70170_p.func_72838_d(entitychicken);
            entitychicken.func_70024_g((double)0.0F, (double)1.5F, (double)0.0F);
            entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.5F);
        }

    }

    public boolean attackZombieFrom(DamageSource source, float amount) {
        if (this.isArmored()) {
            amount /= 3.0F;
        }

        if (this.func_85032_ar()) {
            return false;
        } else if (!this.isStunned && source.func_76346_g() instanceof EntityPlayer) {
            return false;
        } else if (!(source.func_76346_g() instanceof EntityPigZombieMinion) && !(source.func_76346_g() instanceof EntityPigZombieTitan) && !(source.func_76346_g() instanceof EntityGhastGuard)) {
            Entity entity = source.func_76346_g();
            if (entity instanceof EntityLivingBase && !this.func_85032_ar() && amount > 25.0F) {
                List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)256.0F, (double)256.0F, (double)256.0F));

                for(int i = 0; i < list.size(); ++i) {
                    Entity entity1 = (Entity)list.get(i);
                    if (entity1 instanceof EntityPigZombieTitan) {
                        EntityPigZombieTitan entitypigzombie = (EntityPigZombieTitan)entity1;
                        entitypigzombie.func_70624_b((EntityLivingBase)entity);
                        entitypigzombie.func_70604_c((EntityLivingBase)entity);
                    }

                    this.func_70624_b((EntityLivingBase)entity);
                    this.func_70604_c((EntityLivingBase)entity);
                }
            }

            return super.func_70097_a(source, amount);
        } else {
            return false;
        }
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        return this.attackZombieFrom(source, amount);
    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean attackEntityFromPart(EntityTitanPart p_70965_1_, DamageSource source, float amount) {
        this.func_82195_e(source, amount);
        return true;
    }

    protected boolean func_82195_e(DamageSource p_82195_1_, float p_82195_2_) {
        return this.attackZombieFrom(p_82195_1_, p_82195_2_);
    }

    public World func_82194_d() {
        return this.field_70170_p;
    }

    public IEntityLivingData func_110161_a(IEntityLivingData p_180482_2_) {
        Object p_180482_2_1 = super.func_110161_a(p_180482_2_);
        this.func_98053_h(true);
        this.setWaiting(true);
        if (this.field_70170_p.field_73012_v.nextFloat() < 0.05F) {
            this.setChild(true);
        }

        this.func_82164_bB();
        this.func_82162_bC();
        if (this.func_71124_b(4) == null) {
            Calendar calendar = this.field_70170_p.func_83015_S();
            if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.field_70146_Z.nextFloat() < 0.25F) {
                this.func_70062_b(4, new ItemStack(this.field_70146_Z.nextFloat() < 0.1F ? Blocks.field_150428_aP : Blocks.field_150423_aK));
                this.field_82174_bp[4] = 0.0F;
            }
        }

        return (IEntityLivingData)p_180482_2_1;
    }

    public void setAnimID(int id) {
        this.animID = id;
    }

    public void setAnimTick(int tick) {
        this.animTick = tick;
    }

    public int getAnimID() {
        return this.animID;
    }

    public int getAnimTick() {
        return this.animTick;
    }

    protected void inactDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            this.func_85030_a("mob.zombiepig.zpigdeath", this.func_70599_aP(), this.func_70647_i());
            if (this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
                this.func_70628_a(true, 0);
                this.func_82160_b(true, 0);
                this.func_70600_l(1);
            }

            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.field_70170_p);
            entitytitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitytitan);
            entitytitan.setVesselHunting(false);
            entitytitan.setSpiritType(8);
        }

    }

    protected void onTitanDeathUpdate() {
        this.field_70180_af.func_75692_b(6, MathHelper.func_76131_a(this.field_70180_af.func_111145_d(5), 0.0F, this.func_110138_aP()));
        if (this.field_70180_af.func_111145_d(5) <= 0.0F) {
            ++this.deathTicks;
            AnimationAPI.sendAnimPacket(this, 10);
            this.setAnimID(10);
            this.setTitanHealth(0.0F);
        } else {
            this.func_70097_a(DamageSource.field_76380_i, 25.0F);
            this.setTitanHealth(this.field_70180_af.func_111145_d(5));
            this.func_70606_j(this.field_70180_af.func_111145_d(5));
            this.deathTicks = 0;
            if (this.animID == 10) {
                AnimationAPI.sendAnimPacket(this, 0);
            }
        }

        this.field_70159_w *= (double)0.0F;
        this.field_70179_y *= (double)0.0F;
        this.func_70624_b((EntityLivingBase)null);
        if (this.deathTicks == 1 && !this.field_70170_p.field_72995_K) {
            this.func_85030_a(this.func_70673_aS(), this.func_70599_aP(), this.func_70647_i());
            ArrayList listp = Lists.newArrayList(this.field_70170_p.field_73010_i);
            if (listp != null && !listp.isEmpty()) {
                for(int i1 = 0; i1 < listp.size(); ++i1) {
                    Entity entity = (Entity)listp.get(i1);
                    if (entity != null && entity instanceof EntityPlayer) {
                        ((EntityPlayer)entity).func_71029_a(this.getAchievement());
                    }
                }
            }
        }

        if (this.deathTicks == 1) {
            this.setAnimTick(1);
        }

        if (this.deathTicks >= 500) {
            this.setInvulTime(this.getInvulTime() + 8);
            --this.animTick;
            float f = (this.field_70146_Z.nextFloat() - 0.5F) * 12.0F;
            float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 3.0F;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 12.0F;
            this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + (double)2.0F + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
        }

        if (this.getInvulTime() >= this.getThreashHold()) {
            this.func_70106_y();
        }

    }
}
