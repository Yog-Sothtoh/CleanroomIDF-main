//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.Loader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanAntiTitanAttack;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanAttack1;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanAttack2;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanAttack3;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanAttack4;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanAttack5;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanCreation;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanDeath;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanLightningHand;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanLightningSword;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanRangedAttack1;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanRangedAttack2;
import net.minecraft.entity.titan.animation.skeletontitan.AnimationSkeletonTitanStun;
import net.minecraft.entity.titanminion.EntitySkeletonMinion;
import net.minecraft.entity.titanminion.EntityWitherMinion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.ClientProxy;
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
import net.minecraft.world.WorldProviderHell;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import thehippomaster.MutantCreatures.MutantSkeleton;

public class EntitySkeletonTitan extends EntityTitan implements IRangedAttackMob, IAnimatedEntity, IEntityMultiPartTitan {
    public boolean shouldBeWitherSkeleton;
    public int attackTimer;
    public boolean isStunned;
    public EntityTitanPart[] partArray;
    public EntityTitanPart head;
    public EntityTitanPart pelvis;
    public EntityTitanPart spine;
    public EntityTitanPart ribCage;
    public EntityTitanPart rightArm;
    public EntityTitanPart leftArm;
    public EntityTitanPart rightLeg;
    public EntityTitanPart leftLeg;

    public EntitySkeletonTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 8.0F, 8.0F);
        this.pelvis = new EntityTitanPart(worldIn, this, "pelvis", 8.0F, 6.0F);
        this.spine = new EntityTitanPart(worldIn, this, "spine", 2.0F, 12.0F);
        this.ribCage = new EntityTitanPart(worldIn, this, "ribcage", 8.0F, 8.0F);
        this.rightArm = new EntityTitanPart(worldIn, this, "rightarm", 2.0F, 2.0F);
        this.leftArm = new EntityTitanPart(worldIn, this, "leftarm", 2.0F, 2.0F);
        this.rightLeg = new EntityTitanPart(worldIn, this, "rightleg", 2.0F, 12.0F);
        this.leftLeg = new EntityTitanPart(worldIn, this, "leftleg", 2.0F, 12.0F);
        this.partArray = new EntityTitanPart[]{this.head, this.pelvis, this.spine, this.ribCage, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg};
        if (this.getSkeletonType() == 1) {
            this.func_70105_a(14.0F, 56.0F);
            this.field_70728_aV = 50000;
        }

        this.func_70105_a(8.0F, 32.0F);
        this.field_70728_aV = 20000;
        if (worldIn != null && !worldIn.field_72995_K) {
            this.setCombatTask();
        }

        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        worldIn.func_72838_d(this.head);
        worldIn.func_72838_d(this.pelvis);
        worldIn.func_72838_d(this.spine);
        worldIn.func_72838_d(this.ribCage);
        worldIn.func_72838_d(this.rightArm);
        worldIn.func_72838_d(this.leftArm);
        worldIn.func_72838_d(this.rightLeg);
        worldIn.func_72838_d(this.leftLeg);
    }

    protected void applyEntityAI() {
        this.field_70714_bg.func_75776_a(1, new AnimationSkeletonTitanCreation(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSkeletonTitanDeath(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSkeletonTitanLightningHand(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSkeletonTitanLightningSword(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSkeletonTitanStun(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSkeletonTitanAttack3(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSkeletonTitanAttack2(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSkeletonTitanRangedAttack1(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSkeletonTitanRangedAttack2(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSkeletonTitanAttack5(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSkeletonTitanAttack1(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSkeletonTitanAttack4(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSkeletonTitanAntiTitanAttack(this));
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SkeletonTitanSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

    }

    public boolean isArmored() {
        return this.func_110143_aJ() <= this.func_110138_aP() / 4.0F || TheTitans.NightmareMode || TheTitans.TotalDestructionMode;
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != this.head.getClass() && p_70686_1_ != this.pelvis.getClass() && p_70686_1_ != this.rightArm.getClass() && p_70686_1_ != this.leftArm.getClass() && p_70686_1_ != this.rightLeg.getClass() && p_70686_1_ != this.leftLeg.getClass() && p_70686_1_ != EntitySkeletonMinion.class && p_70686_1_ != EntitySkeletonTitan.class && p_70686_1_ != EntitySkeletonTitanGiantArrow.class && p_70686_1_ != EntityWitherMinion.class || Loader.isModLoaded("MutantCreatures") && p_70686_1_ == MutantSkeleton.class;
    }

    public int getMinionCap() {
        return 160;
    }

    public int getPriestCap() {
        return 90;
    }

    public int getZealotCap() {
        return 40;
    }

    public int getBishopCap() {
        return 20;
    }

    public int getTemplarCap() {
        return 10;
    }

    public int getSpecialMinionCap() {
        return 6;
    }

    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(100) == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }

    public int getMinionSpawnRate() {
        return this.getSkeletonType() == 1 ? TheTitans.WitherSkeletonTitanMinionSpawnrate : TheTitans.SkeletonTitanMinionSpawnrate;
    }

    public float func_70603_bj() {
        float f = 16.0F;
        if (this.getSkeletonType() == 1) {
            f *= 1.2F;
        }

        return f;
    }

    public int getParticleCount() {
        return this.getSkeletonType() == 1 ? 48 : super.getParticleCount();
    }

    public String getParticles() {
        if (this.getSkeletonType() == 1) {
            this.shouldParticlesBeUpward = true;
            return "largesmoke";
        } else {
            return super.getParticles();
        }
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.2);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)140.0F);
    }

    public boolean canBeHurtByPlayer() {
        return this.isStunned && !this.func_85032_ar();
    }

    public boolean func_70662_br() {
        return true;
    }

    public EnumTitanStatus getTitanStatus() {
        return this.getSkeletonType() == 1 ? EnumTitanStatus.GREATER : EnumTitanStatus.AVERAGE;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(13, new Byte((byte)0));
    }

    public int getFootStepModifer() {
        return this.getSkeletonType() == 1 ? 2 : 3;
    }

    protected String func_70639_aQ() {
        return !this.isStunned && !this.getWaiting() && this.animID != 13 ? (this.getSkeletonType() == 1 ? "thetitans:titanWitherSkeletonLiving" : "thetitans:titanSkeletonLiving") : null;
    }

    protected String func_70621_aR() {
        return this.getSkeletonType() == 1 ? "thetitans:titanWitherSkeletonGrunt" : "thetitans:titanSkeletonGrunt";
    }

    protected String func_70673_aS() {
        return this.getSkeletonType() == 1 ? "thetitans:titanWitherSkeletonDeath" : "thetitans:titanSkeletonDeath";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.func_85030_a("thetitans:titanStep", 10.0F, 1.0F);
        this.func_85030_a("mob.skeleton.step", 10.0F, 0.5F);
        this.shakeNearbyPlayerCameras((double)4000.0F);
        if (!this.getWaiting() && this.animID != 13) {
            float f3 = this.field_70177_z * (float)Math.PI / 180.0F;
            float f11 = MathHelper.func_76126_a(f3);
            float f4 = MathHelper.func_76134_b(f3);
            if (this.footID == 0) {
                this.destroyBlocksInAABB(this.rightLeg.field_70121_D.func_72317_d((double)0.0F, (double)-1.0F, (double)0.0F));
                this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)1.0F, (double)1.0F, (double)1.0F).func_72317_d((double)(f11 * 4.0F), (double)0.0F, (double)(f4 * 4.0F))));
                ++this.footID;
            } else {
                this.destroyBlocksInAABB(this.leftLeg.field_70121_D.func_72317_d((double)0.0F, (double)-1.0F, (double)0.0F));
                this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)1.0F, (double)1.0F, (double)1.0F).func_72317_d((double)(f11 * 4.0F), (double)0.0F, (double)(f4 * 4.0F))));
                this.footID = 0;
            }
        }

    }

    public boolean func_70652_k(Entity p_70652_1_) {
        return false;
    }

    public double getSpeed() {
        return this.getSkeletonType() == 1 ? 0.4 + (double)this.getExtraPower() * 0.001 : 0.3 + (double)this.getExtraPower() * 0.001;
    }

    public EnumCreatureAttribute func_70668_bt() {
        return EnumCreatureAttribute.UNDEAD;
    }

    public void becomeWitherSkeleton(boolean skelly) {
        if (skelly) {
            this.setSkeletonType(1);
            this.func_70062_b(0, new ItemStack(Items.field_151052_q));
        }

    }

    public boolean canAttack() {
        return false;
    }

    public boolean shouldMove() {
        return this.animID == 0 && !this.isStunned && !this.getWaiting() && this.func_70638_az() != null ? super.shouldMove() : false;
    }

    public double getMeleeRange() {
        return (double)(this.field_70130_N * this.field_70130_N + (this.func_70638_az().field_70130_N > 48.0F ? 2304.0F : this.func_70638_az().field_70130_N * this.func_70638_az().field_70130_N)) + (this.getSkeletonType() == 1 ? (double)2000.0F : (double)800.0F);
    }

    public void func_70636_d() {
        this.setCombatTask();
        if (this.field_70173_aa == 1) {
            this.setSkeletonType(this.getSkeletonType());
        }

        float dis = this.getSkeletonType() == 1 ? 32.0F : 16.0F;
        float xfac = MathHelper.func_76126_a(this.field_70761_aq * (float)Math.PI / 180.0F);
        float zfac = MathHelper.func_76134_b(this.field_70761_aq * (float)Math.PI / 180.0F);
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
                float f = (this.field_70146_Z.nextFloat() - 0.5F) * (this.getSkeletonType() == 1 ? 30.0F : 10.0F);
                float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 1.0F;
                float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * (this.getSkeletonType() == 1 ? 30.0F : 10.0F);
                this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + (this.getSkeletonType() == 1 ? (double)15.0F : (double)5.0F) + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
            }
        }

        if (this.getWaiting()) {
            AnimationAPI.sendAnimPacket(this, 0);
            AnimationAPI.sendAnimPacket(this, 13);
            this.setAnimTick(0);
            EntityPlayer player = this.field_70170_p.func_72890_a(this, (double)16.0F);
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
                this.func_85030_a("thetitans:titanBirth", 1000.0F, this.getSkeletonType() == 1 ? 0.875F : 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 10) {
                this.func_85030_a("thetitans:titanSkeletonAwaken", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 100) {
                this.func_85030_a("thetitans:titanRumble", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 160) {
                this.func_85030_a("thetitans:titanSkeletonBeginMove", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 280) {
                this.func_85030_a("thetitans:titanQuake", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 300) {
                this.func_85030_a("thetitans:titanRumble", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 520) {
                this.func_85030_a("thetitans:titanSkeletonGetUp", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && (this.getAnimTick() == 230 || this.getAnimTick() == 550 || this.getAnimTick() == 590 || this.getAnimTick() == 610)) {
                this.func_145780_a(0, 0, 0, Blocks.field_150348_b);
                this.func_85030_a("thetitans:titanPress", this.func_70599_aP(), 1.0F);
            }
        }

        EntityPlayer player = this.field_70170_p.func_72890_a(this, (double)-1.0F);
        if (player instanceof EntityPlayer && player != null && this.func_70638_az() != null && player == this.func_70638_az() && this.getSkeletonType() == 1) {
            if (this.field_70146_Z.nextInt(200) == 0 && this.func_110143_aJ() <= this.func_110138_aP() / 100.0F) {
                player.func_70097_a(DamageSourceExtra.field_82727_n.func_151518_m().func_76359_i(), Float.MAX_VALUE);
            }

            if (player.func_110139_bj() <= 0.0F && this.field_70173_aa % 10 == 0) {
                player.func_70097_a(DamageSourceExtra.field_82727_n.func_151518_m().func_76359_i(), 12.0F);
                player.func_70690_d(new PotionEffect(ClientProxy.advancedWither.field_76415_H, 1200));
                player.func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 1200, 3));
                player.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 400, 9));
                if (player.func_110143_aJ() <= 5.0F) {
                    player.func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 400, 1));
                }
            } else if (player.func_110139_bj() >= 0.0F && this.field_70173_aa % 40 == 0) {
                player.func_70097_a(DamageSourceExtra.field_82727_n.func_151518_m().func_76359_i(), 12.0F);
            }
        }

        if (this.isStunned) {
            this.func_70624_b((EntityLivingBase)null);
            AnimationAPI.sendAnimPacket(this, 8);
            this.setAnimID(8);
        }

        if (this.animID == 8) {
            if (this.animTick == 70) {
                this.func_85030_a("thetitans:groundSmash", 8.0F, 0.9F);
                this.func_85030_a("thetitans:titanFall", 10.0F, 1.0F);
            }

            if (this.animTick == 74) {
                this.func_85030_a("thetitans:distantLargeFall", 10000.0F, 1.0F);
                this.func_85030_a(this.func_70621_aR(), this.func_70599_aP(), this.func_70647_i());
            }

            if (this.animTick == 480) {
                this.func_85030_a("thetitans:titanFall", 10.0F, 1.0F);
                this.func_85030_a("thetitans:titanStep", 10.0F, 1.0F);
                this.func_85030_a("mob.skeleton.step", 10.0F, 0.5F);
                this.func_85030_a("thetitans:titanStep", 10.0F, 1.0F);
                this.func_85030_a("mob.skeleton.step", 10.0F, 0.5F);
                this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)16.0F, (double)1.0F, (double)16.0F)));
                this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)16.0F, (double)1.0F, (double)16.0F)));
                this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)16.0F, (double)1.0F, (double)16.0F)));
                this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)16.0F, (double)1.0F, (double)16.0F)));
            }

            if (this.animTick == 450) {
                this.isStunned = false;
            } else {
                this.func_70624_b((EntityLivingBase)null);
            }
        }

        if (this.animID == 10) {
            if (this.animTick == 30 || this.animTick == 70) {
                this.func_85030_a("thetitans:titanStep", 10.0F, 1.0F);
            }

            if (this.animTick == 190) {
                this.func_85030_a("thetitans:titanFall", 20.0F, 1.0F);
                this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)16.0F, (double)1.0F, (double)16.0F)));
                this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)16.0F, (double)1.0F, (double)16.0F)));
            }

            if (this.animTick == 200) {
                this.func_85030_a("thetitans:distantLargeFall", 10000.0F, 1.0F);
            }
        }

        if (this.getAnimID() == 9 && this.getAnimTick() <= 50 && this.getAnimTick() >= 26) {
            this.field_70761_aq = this.field_70177_z = this.field_70759_as;
            double d8 = (double)(this.getAnimTick() - 4);
            Vec3 vec3 = this.func_70676_i(1.0F);
            double dx = vec3.field_72450_a * d8;
            double dz = vec3.field_72449_c * d8;
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + (double)dis + (double)4.0F, this.field_70161_v + dz, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F));
        }

        if ((this.getAnimID() == 9 && this.getAnimTick() == 48 || this.getAnimID() == 5 && this.getAnimTick() == 230 + this.field_70146_Z.nextInt(100)) && this.func_70638_az() != null) {
            double d8 = (double)46.0F;
            Vec3 vec3 = this.func_70676_i(1.0F);
            double dx = vec3.field_72450_a * d8;
            double dz = vec3.field_72449_c * d8;
            float da = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
            int i = this.getKnockbackAmount();
            this.attackChoosenEntity(this.func_70638_az(), da * 3.0F, i);
            EntityLivingBase var10000 = this.func_70638_az();
            var10000.field_70181_x += (double)(2.0F + this.field_70146_Z.nextFloat());
            this.field_70170_p.func_72885_a(this, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 6.0F, false, false);
            this.field_70170_p.func_72885_a(this, this.field_70165_t + dx, this.field_70163_u + (double)dis + (double)4.0F, this.field_70161_v + dz, 3.0F, false, false);
            this.func_70638_az().func_70097_a(DamageSourceExtra.lightningBolt, da);
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + (double)dis + (double)4.0F, this.field_70161_v + dz, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F));
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + (double)dis + (double)4.0F, this.field_70161_v + dz, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F));
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + (double)dis + (double)4.0F, this.field_70161_v + dz, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F));
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + (double)dis + (double)4.0F, this.field_70161_v + dz, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F));
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F));

            for(int i1 = 0; i1 < 3; ++i1) {
                List list1 = this.field_70170_p.func_72839_b(this.func_70638_az(), this.func_70638_az().field_70121_D.func_72314_b((double)16.0F, (double)16.0F, (double)16.0F));
                if (list1 != null && !list1.isEmpty()) {
                    for(int i11 = 0; i11 < list1.size(); ++i11) {
                        Entity entity1 = (Entity)list1.get(i11);
                        if (entity1 instanceof EntityLivingBase && this.func_70686_a(entity1.getClass())) {
                            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, entity1.field_70165_t, entity1.field_70163_u, entity1.field_70161_v, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F));
                            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, entity1.field_70165_t, entity1.field_70163_u, entity1.field_70161_v, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F));
                            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, entity1.field_70165_t, entity1.field_70163_u, entity1.field_70161_v, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F));
                            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, entity1.field_70165_t, entity1.field_70163_u, entity1.field_70161_v, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F));
                            this.attackChoosenEntity(entity1, da, i);
                            entity1.field_70181_x += (double)2.0F + this.field_70146_Z.nextDouble();
                        }
                    }
                }
            }
        }

        if (this.getAnimID() == 12 && this.getAnimTick() == 40) {
            this.func_85030_a("random.explode", 20.0F, 2.0F);
            this.func_85030_a("mob.wither.shoot", 20.0F, 1.0F);
            float da = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
            int i = this.getKnockbackAmount();
            this.field_70170_p.func_72885_a(this, this.field_70165_t - (double)xfac * (double)dis * 0.9, this.field_70163_u + (double)dis * (double)1.25F, this.field_70161_v + (double)zfac * (double)dis * 0.9, 3.0F, false, false);
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t - (double)xfac * (double)dis * 0.9, this.field_70163_u + (double)dis * (double)1.25F, this.field_70161_v + (double)zfac * (double)dis * 0.9, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F));
            if (this.func_70638_az() != null) {
                this.attackChoosenEntity(this.func_70638_az(), da * 5.0F, i);
                this.func_70638_az().func_70097_a(DamageSourceExtra.lightningBolt, da);
                EntityLivingBase var72 = this.func_70638_az();
                var72.field_70181_x += (double)1.0F + this.field_70146_Z.nextDouble();
                this.field_70170_p.func_72885_a(this, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 3.0F, false, false);
                this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F, this.getSkeletonType() == 1 ? 0.0F : 0.5F));
            }
        }

        if (this.getAnimID() == 7 && this.getAnimTick() == 92 && !AnimationAPI.isEffectiveClient()) {
            int y = MathHelper.func_76128_c(this.field_70163_u);
            int x = MathHelper.func_76128_c(this.field_70165_t - (double)(xfac * dis * 2.0F));
            int z = MathHelper.func_76128_c(this.field_70161_v + (double)(zfac * dis * 2.0F));
            if (this.field_70170_p.func_147439_a(x, y - 1, z).func_149688_o() != Material.field_151579_a) {
                this.func_85030_a("thetitans:titanStrike", 20.0F, 1.0F);
                this.func_85030_a("thetitans:titanSlam", 20.0F, 1.0F);
                this.func_85030_a("thetitans:titanPress", 100.0F, 1.0F);
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

                        if (block.func_149638_a(this) > 500.0F && block.func_149662_c()) {
                            AnimationAPI.sendAnimPacket(this, 8);
                            this.setAnimID(8);
                            this.setAnimTick(0);
                            this.func_85030_a("random.anvil_land", 20.0F, 0.5F);
                            this.isStunned = true;
                        }
                    }
                }
            }
        }

        if (this.getSkeletonType() == 1) {
            this.func_70105_a(14.0F, 56.0F);
        } else {
            this.func_70105_a(8.0F, 32.0F);
        }

        float f = this.field_70761_aq * (float)Math.PI / 180.0F;
        float f1 = MathHelper.func_76126_a(f);
        float f2 = MathHelper.func_76134_b(f);
        if (this.field_70173_aa > 5) {
            this.head.func_70012_b(this.field_70165_t, this.field_70163_u + (this.getSkeletonType() == 1 ? (double)42.0F : (double)24.0F), this.field_70161_v, 0.0F, 0.0F);
            this.pelvis.func_70012_b(this.field_70165_t, this.field_70163_u + (this.getSkeletonType() == 1 ? (double)21.0F : (double)12.0F), this.field_70161_v, 0.0F, 0.0F);
            this.spine.func_70012_b(this.field_70165_t + (double)f1 * (this.getSkeletonType() == 1 ? (double)3.5F : (double)2.0F), this.field_70163_u + (this.getSkeletonType() == 1 ? (double)21.0F : (double)12.0F), this.field_70161_v - (double)f2 * (this.getSkeletonType() == 1 ? (double)3.5F : (double)2.0F), 0.0F, 0.0F);
            this.ribCage.func_70012_b(this.field_70165_t, this.field_70163_u + (this.getSkeletonType() == 1 ? (double)33.25F : (double)19.0F), this.field_70161_v, 0.0F, 0.0F);
            this.rightArm.func_70012_b(this.field_70165_t + (double)f2 * (this.getSkeletonType() == 1 ? (double)8.75F : (double)5.0F), this.field_70163_u + (this.getSkeletonType() == 1 ? (double)20.125F : (double)11.5F), this.field_70161_v + (double)f1 * (this.getSkeletonType() == 1 ? (double)8.75F : (double)5.0F), 0.0F, 0.0F);
            this.leftArm.func_70012_b(this.field_70165_t - (double)f2 * (this.getSkeletonType() == 1 ? (double)8.75F : (double)5.0F), this.field_70163_u + (this.getSkeletonType() == 1 ? (double)20.125F : (double)11.5F), this.field_70161_v - (double)f1 * (this.getSkeletonType() == 1 ? (double)8.75F : (double)5.0F), 0.0F, 0.0F);
            this.rightLeg.func_70012_b(this.field_70165_t + (double)f2 * (this.getSkeletonType() == 1 ? (double)3.5F : (double)2.0F), this.field_70163_u, this.field_70161_v + (double)f1 * (this.getSkeletonType() == 1 ? (double)3.5F : (double)2.0F), 0.0F, 0.0F);
            this.leftLeg.func_70012_b(this.field_70165_t - (double)f2 * (this.getSkeletonType() == 1 ? (double)3.5F : (double)2.0F), this.field_70163_u, this.field_70161_v - (double)f1 * (this.getSkeletonType() == 1 ? (double)3.5F : (double)2.0F), 0.0F, 0.0F);
            if (this.func_70089_S() && !this.isStunned) {
                this.collideWithEntities(this.head, this.field_70170_p.func_72839_b(this, this.head.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.pelvis, this.field_70170_p.func_72839_b(this, this.pelvis.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.spine, this.field_70170_p.func_72839_b(this, this.spine.field_70121_D));
                this.collideWithEntities(this.ribCage, this.field_70170_p.func_72839_b(this, this.ribCage.field_70121_D));
                this.collideWithEntities(this.rightArm, this.field_70170_p.func_72839_b(this, this.rightArm.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.leftArm, this.field_70170_p.func_72839_b(this, this.leftArm.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
            }

            this.destroyBlocksInAABB(this.head.field_70121_D);
            this.destroyBlocksInAABB(this.pelvis.field_70121_D);
            this.destroyBlocksInAABB(this.spine.field_70121_D);
            this.destroyBlocksInAABB(this.ribCage.field_70121_D);
            this.destroyBlocksInAABB(this.rightArm.field_70121_D);
            this.destroyBlocksInAABB(this.leftArm.field_70121_D);
            this.destroyBlocksInAABB(this.leftLeg.field_70121_D);
            this.destroyBlocksInAABB(this.rightLeg.field_70121_D);

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

        if (this.isStunned || this.deathTicks > 0) {
            this.field_70159_w *= (double)0.0F;
            this.field_70179_y *= (double)0.0F;
        }

        List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)256.0F, (double)256.0F, (double)256.0F));
        if (list != null && !list.isEmpty() && this.field_70173_aa % 400 == 0) {
            for(int i1 = 0; i1 < list.size(); ++i1) {
                Entity entity1 = (Entity)list.get(i1);
                if (entity1 != null && entity1 instanceof EntityArrow) {
                    entity1.func_70106_y();
                }
            }
        }

        if ((this.getAnimID() == 5 || this.getAnimID() == 11) && this.getAnimTick() >= 40) {
            ++this.attackTimer;
        } else if (this.getAnimID() != 5 && this.getAnimID() != 11) {
            this.attackTimer = 0;
        }

        if (this.attackTimer < 0) {
            this.attackTimer = 0;
        }

        if (!this.field_70170_p.field_72995_K && this.func_70638_az() != null && this.getAnimID() == 5 && this.getAnimTick() >= 100 && this.getAnimTick() <= 300) {
            this.func_82196_d(this.func_70638_az(), 1.0F);
            this.func_82196_d(this.func_70638_az(), 1.0F);
            this.func_82196_d(this.func_70638_az(), 1.0F);
            this.func_82196_d(this.func_70638_az(), 1.0F);
            this.func_82196_d(this.func_70638_az(), 1.0F);
            this.func_82196_d(this.func_70638_az(), 1.0F);
            this.func_82196_d(this.func_70638_az(), 1.0F);
            this.func_82196_d(this.func_70638_az(), 1.0F);
        }

        if (!this.field_70170_p.field_72995_K && this.func_70638_az() != null && this.getAnimID() == 11 && this.getAnimTick() == 78) {
            this.attackEntityWithEnlargedRangedAttack(this.func_70638_az(), 1.0F);
        }

        if (!AnimationAPI.isEffectiveClient() && this.func_70638_az() != null && !this.isStunned && this.getAnimID() == 0) {
            double d0 = this.func_70068_e(this.func_70638_az());
            if (d0 < this.getMeleeRange()) {
                if (!(this.func_70638_az() instanceof EntityTitan) && !(this.func_70638_az().field_70131_O >= 6.0F) && !(this.func_70638_az().field_70163_u > this.field_70163_u + (double)6.0F)) {
                    switch (this.field_70146_Z.nextInt(5)) {
                        case 0:
                            AnimationAPI.sendAnimPacket(this, 6);
                            this.setAnimID(6);
                            break;
                        case 1:
                            AnimationAPI.sendAnimPacket(this, 3);
                            this.setAnimID(3);
                            break;
                        case 2:
                            AnimationAPI.sendAnimPacket(this, 7);
                            this.setAnimID(7);
                            break;
                        case 3:
                            AnimationAPI.sendAnimPacket(this, 2);
                            this.setAnimID(2);
                            break;
                        case 4:
                            AnimationAPI.sendAnimPacket(this, 4);
                            this.setAnimID(4);
                    }
                } else {
                    AnimationAPI.sendAnimPacket(this, 1);
                    this.setAnimID(1);
                }
            } else if (this.animID == 0 && this.func_70681_au().nextInt(80) == 0) {
                switch (this.field_70146_Z.nextInt(6)) {
                    case 0:
                        if (this.getSkeletonType() != 1) {
                            AnimationAPI.sendAnimPacket(this, 5);
                            this.setAnimID(5);
                        } else {
                            AnimationAPI.sendAnimPacket(this, 9);
                            this.setAnimID(9);
                        }
                        break;
                    case 1:
                        AnimationAPI.sendAnimPacket(this, 12);
                        this.setAnimID(12);
                        break;
                    case 2:
                        if (this.getSkeletonType() != 1) {
                            AnimationAPI.sendAnimPacket(this, 11);
                            this.setAnimID(11);
                        } else {
                            AnimationAPI.sendAnimPacket(this, 12);
                            this.setAnimID(12);
                        }
                }
            }
        }

        if (this.animID == 1 && this.animTick == 1) {
            this.antiTitanAttackAnimeID = this.func_70681_au().nextInt(4);
        }

        if (this.getSkeletonType() == 1) {
            this.func_94058_c(StatCollector.func_74838_a("entity.WitherSkeletonTitan.name"));
            if (TheTitans.NightmareMode) {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)15000.0F + (double)(this.getExtraPower() * 750));
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)400000.0F + (double)(this.getExtraPower() * '鱀'));
            } else {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)5000.0F + (double)(this.getExtraPower() * 250));
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)200000.0F + (double)(this.getExtraPower() * 20000));
            }
        } else {
            this.func_94058_c(StatCollector.func_74838_a("entity.SkeletonTitan.name"));
            if (TheTitans.NightmareMode) {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)360.0F + (double)(this.getExtraPower() * 60));
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)40000.0F + (double)(this.getExtraPower() * 2000));
            } else {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)120.0F + (double)(this.getExtraPower() * 30));
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)20000.0F + (double)(this.getExtraPower() * 1000));
            }
        }

        if (this.field_70146_Z.nextInt(2) == 0 && this.getSkeletonType() == 1 && this.func_70026_G()) {
            this.func_85030_a("random.fizz", 10.0F, 1.0F);
        }

        if (!this.getWaiting() && this.animID != 13 && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0 && this.getSkeletonType() == 1) {
                    EntityWitherMinion entitychicken = new EntityWitherMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_70024_g((double)0.0F, (double)0.25F, (double)0.0F);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.6F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    ++this.numSpecialMinions;
                } else if (this.numMinions < this.getMinionCap()) {
                    EntitySkeletonMinion entitychicken = new EntitySkeletonMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70024_g((double)0.0F, 0.9, (double)0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(0);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v);
                    this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                    ++this.numMinions;
                    if (block == Blocks.field_150349_c) {
                        this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                    }

                    if (this.getSkeletonType() == 1) {
                        entitychicken.func_82201_a(1);
                    } else {
                        entitychicken.func_82201_a(0);
                        entitychicken.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, Integer.MAX_VALUE, 0, false));
                    }
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0 && this.getSkeletonType() == 1) {
                    EntityWitherMinion entitychicken = new EntityWitherMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_70024_g((double)0.0F, (double)0.25F, (double)0.0F);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.6F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    ++this.numSpecialMinions;
                } else if (this.numPriests < this.getPriestCap()) {
                    EntitySkeletonMinion entitychicken = new EntitySkeletonMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70024_g((double)0.0F, 0.9, (double)0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(1);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v);
                    this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                    ++this.numPriests;
                    if (block == Blocks.field_150349_c) {
                        this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                    }

                    if (this.getSkeletonType() == 1) {
                        entitychicken.func_82201_a(1);
                    } else {
                        entitychicken.func_82201_a(0);
                        entitychicken.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, Integer.MAX_VALUE, 0, false));
                    }
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0 && this.getSkeletonType() == 1) {
                    EntityWitherMinion entitychicken = new EntityWitherMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_70024_g((double)0.0F, (double)0.25F, (double)0.0F);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.6F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    ++this.numSpecialMinions;
                } else if (this.numZealots < this.getZealotCap()) {
                    EntitySkeletonMinion entitychicken = new EntitySkeletonMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70024_g((double)0.0F, 0.9, (double)0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(2);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v);
                    this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                    ++this.numZealots;
                    if (block == Blocks.field_150349_c) {
                        this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                    }

                    if (this.getSkeletonType() == 1) {
                        entitychicken.func_82201_a(1);
                    } else {
                        entitychicken.func_82201_a(0);
                        entitychicken.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, Integer.MAX_VALUE, 0, false));
                    }
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0 && this.getSkeletonType() == 1) {
                    EntityWitherMinion entitychicken = new EntityWitherMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_70024_g((double)0.0F, (double)0.25F, (double)0.0F);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.6F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    ++this.numSpecialMinions;
                } else if (this.numBishop < this.getBishopCap()) {
                    EntitySkeletonMinion entitychicken = new EntitySkeletonMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70024_g((double)0.0F, 0.9, (double)0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(3);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v);
                    this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                    ++this.numBishop;
                    if (block == Blocks.field_150349_c) {
                        this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                    }

                    if (this.getSkeletonType() == 1) {
                        entitychicken.func_82201_a(1);
                    } else {
                        entitychicken.func_82201_a(0);
                        entitychicken.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, Integer.MAX_VALUE, 0, false));
                    }
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0 && this.getSkeletonType() == 1) {
                    EntityWitherMinion entitychicken = new EntityWitherMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_70024_g((double)0.0F, (double)0.25F, (double)0.0F);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.6F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    ++this.numSpecialMinions;
                } else if (this.numTemplar < this.getTemplarCap()) {
                    EntitySkeletonMinion entitychicken = new EntitySkeletonMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70024_g((double)0.0F, 0.9, (double)0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(4);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v);
                    this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                    ++this.numTemplar;
                    if (block == Blocks.field_150349_c) {
                        this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                    }

                    if (this.getSkeletonType() == 1) {
                        entitychicken.func_82201_a(1);
                    } else {
                        entitychicken.func_82201_a(0);
                        entitychicken.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, Integer.MAX_VALUE, 0, false));
                    }
                }
            }
        }

        super.func_70636_d();
    }

    public void attackChoosenEntity(Entity damagedEntity, float damage, int knockbackAmount) {
        if (this.getSkeletonType() == 1 && this.func_70089_S()) {
            damage += (float)this.numSpecialMinions * 150.0F;
            knockbackAmount += this.numSpecialMinions;
        }

        if (this.isArmored()) {
            damage *= 2.0F;
        }

        super.attackChoosenEntity(damagedEntity, damage, knockbackAmount);
        if (this.getSkeletonType() == 1 && damagedEntity instanceof EntityLivingBase) {
            ((EntityLivingBase)damagedEntity).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 800, 3));
            ((EntityLivingBase)damagedEntity).func_70690_d(new PotionEffect(ClientProxy.advancedWither.field_76415_H, 100, 3));
        }

    }

    public void func_70098_U() {
        super.func_70098_U();
        if (this.field_70154_o instanceof EntitySpiderTitan) {
            EntitySpiderTitan entitycreature = (EntitySpiderTitan)this.field_70154_o;
            this.field_70761_aq = entitycreature.field_70761_aq;
            if (this.func_70638_az() != null) {
                entitycreature.func_70624_b(this.func_70638_az());
            }

            if (!entitycreature.func_70089_S()) {
                this.field_70154_o = null;
            }
        }

    }

    public StatBase getAchievement() {
        if (this.field_70154_o != null && this.field_70154_o instanceof EntitySpiderTitan) {
            return TitansAchievments.spiderjockeytitan;
        } else {
            return this.getSkeletonType() == 1 ? TitansAchievments.witherskeletontitan : TitansAchievments.skeletontitan;
        }
    }

    protected Item func_146068_u() {
        return Items.field_151032_g;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            if (this.getSkeletonType() == 1) {
                for(int x = 0; x < 70; ++x) {
                    EntityXPBomb entitylargefireball = new EntityXPBomb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                    entitylargefireball.func_70107_b(this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                    ++entitylargefireball.field_70181_x;
                    entitylargefireball.setXPCount(24000);
                    this.field_70170_p.func_72838_d(entitylargefireball);
                }

                for(int l = 0; l < 16; ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151045_i));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 32; ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151042_j));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 128 + this.field_70146_Z.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151103_aS));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 128 + this.field_70146_Z.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151044_h));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 256 + this.field_70146_Z.nextInt(256 + p_70628_2_) + p_70628_2_; ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151100_aR, 1, 15));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 128 + this.field_70146_Z.nextInt(128 + p_70628_2_); ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151166_bC));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 128 + this.field_70146_Z.nextInt(128 + p_70628_2_); ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151045_i));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 64 + this.field_70146_Z.nextInt(64 + p_70628_2_); ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(TitanItems.harcadium));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 32 + this.field_70146_Z.nextInt(32 + p_70628_2_); ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(TitanItems.voidItem));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 16 + this.field_70146_Z.nextInt(16 + p_70628_2_); ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150357_h));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }
            } else {
                for(int x = 0; x < 16; ++x) {
                    EntityXPBomb entitylargefireball = new EntityXPBomb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                    entitylargefireball.func_70107_b(this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                    ++entitylargefireball.field_70181_x;
                    entitylargefireball.setXPCount(14000);
                    this.field_70170_p.func_72838_d(entitylargefireball);
                }

                for(int l = 0; l < 48; ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151055_y));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 48; ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151007_F));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 128 + this.field_70146_Z.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151032_g));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 0 + this.field_70146_Z.nextInt(16 + p_70628_2_); ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151166_bC));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 0 + this.field_70146_Z.nextInt(16 + p_70628_2_); ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151045_i));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 0 + this.field_70146_Z.nextInt(4 + p_70628_2_); ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(TitanItems.harcadium));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }
            }

            for(int l = 0; l < 128 + this.field_70146_Z.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151103_aS));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 128 + this.field_70146_Z.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151044_h));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 256 + this.field_70146_Z.nextInt(256 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151100_aR, 1, 15));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }
        }

    }

    protected void func_70600_l(int p_70600_1_) {
        if (this.getSkeletonType() == 1) {
            this.func_70099_a(new ItemStack(Items.field_151144_bL, 256, 1), 0.0F);
        } else {
            this.func_70099_a(new ItemStack(Items.field_151144_bL, 256, 0), 0.0F);
        }

    }

    protected void func_82164_bB() {
        super.func_82164_bB();
        if (this.getSkeletonType() == 1) {
            this.func_70062_b(0, new ItemStack(Items.field_151052_q));
        } else {
            this.func_70062_b(0, new ItemStack(Items.field_151031_f));
        }

    }

    public IEntityLivingData func_110161_a(IEntityLivingData p_180482_2_) {
        p_180482_2_ = super.func_110161_a(p_180482_2_);
        this.func_98053_h(true);
        this.func_82162_bC();
        this.setWaiting(true);
        if ((!(this.field_70170_p.field_73011_w instanceof WorldProviderHell) || this.func_70681_au().nextInt(5) <= 0 || this.field_70170_p.field_72995_K) && (!this.shouldBeWitherSkeleton || this.field_70170_p.field_72995_K)) {
            this.setSkeletonType(0);
        } else {
            this.setSkeletonType(1);
        }

        if (this.func_71124_b(4) == null) {
            Calendar calendar = this.field_70170_p.func_83015_S();
            if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.field_70146_Z.nextFloat() < 0.25F) {
                this.func_70062_b(4, new ItemStack(this.field_70146_Z.nextFloat() < 0.1F ? Blocks.field_150428_aP : Blocks.field_150423_aK));
                this.field_82174_bp[4] = 0.0F;
            }
        }

        this.func_82164_bB();
        return p_180482_2_;
    }

    public void setCombatTask() {
        this.meleeTitan = true;
    }

    public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.field_70761_aq = this.field_70177_z = this.field_70759_as;
        this.func_70625_a(p_82196_1_, 180.0F, 30.0F);
        float dis = 10.0F;
        float xfac = MathHelper.func_76126_a(this.field_70761_aq * (float)Math.PI / 180.0F);
        float zfac = MathHelper.func_76134_b(this.field_70761_aq * (float)Math.PI / 180.0F);
        EntityHarcadiumArrow entityarrow = new EntityHarcadiumArrow(this.field_70170_p, this, p_82196_2_);
        double d0 = p_82196_1_.field_70165_t - (this.field_70165_t - (double)(xfac * dis));
        double d1 = p_82196_1_.field_70163_u - (this.field_70163_u + (double)18.0F);
        double d2 = p_82196_1_.field_70161_v - (this.field_70161_v + (double)(zfac * dis));
        float f1 = MathHelper.func_76133_a(d0 * d0 + d2 * d2);
        entityarrow.func_70186_c(d0, d1 + (double)f1, d2, f1 / (180F / (float)Math.PI) * 1.6F, 36.0F);
        entityarrow.field_70165_t = this.field_70165_t - (double)(xfac * dis);
        entityarrow.field_70163_u = this.field_70163_u + (double)18.0F;
        entityarrow.field_70161_v = this.field_70161_v + (double)(zfac * dis);
        int i = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, this.func_70694_bm());
        int j = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, this.func_70694_bm());
        int f = EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, this.func_70694_bm());
        if (TheTitans.NightmareMode) {
            entityarrow.func_70239_b((double)90.0F);
        } else {
            entityarrow.func_70239_b((double)30.0F);
        }

        entityarrow.func_70243_d(true);
        if (i > 0) {
            entityarrow.func_70239_b(entityarrow.func_70242_d() + (double)i * (double)10.0F + (double)1.0F);
        }

        if (j > 1) {
            entityarrow.func_70240_a(j);
        } else {
            entityarrow.func_70240_a(2);
        }

        if (f > 0 || this.getSkeletonType() == 1) {
            entityarrow.func_70015_d(10000);
        }

        this.field_70170_p.func_72838_d(entityarrow);
        this.func_85030_a("random.bow", 3.0F, 1.9F / (this.func_70681_au().nextFloat() * 0.4F + 0.8F));
        if (this.func_70068_e(p_82196_1_) <= this.getMeleeRange()) {
            this.attackChoosenEntity(p_82196_1_, 10.0F, 5);
        }

    }

    public void attackEntityWithEnlargedRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.field_70761_aq = this.field_70177_z = this.field_70759_as;
        this.func_70625_a(p_82196_1_, 180.0F, 30.0F);
        float dis = 10.0F;
        float xfac = MathHelper.func_76126_a(this.field_70761_aq * (float)Math.PI / 180.0F);
        float zfac = MathHelper.func_76134_b(this.field_70761_aq * (float)Math.PI / 180.0F);
        double d0 = p_82196_1_.field_70165_t - (this.field_70165_t - (double)(xfac * dis));
        double d1 = p_82196_1_.field_70163_u - (this.field_70163_u + (double)17.0F);
        double d2 = p_82196_1_.field_70161_v - (this.field_70161_v + (double)(zfac * dis));
        EntitySkeletonTitanGiantArrow entityarrow = new EntitySkeletonTitanGiantArrow(this.field_70170_p, this, d0, d1, d2);
        MathHelper.func_76133_a(d0 * d0 + d2 * d2);
        entityarrow.field_70165_t = this.field_70165_t - (double)(xfac * dis);
        entityarrow.field_70163_u = this.field_70163_u + (double)17.0F;
        entityarrow.field_70161_v = this.field_70161_v + (double)(zfac * dis);
        this.field_70170_p.func_72838_d(entityarrow);
        this.func_85030_a("random.bow", 10.0F, 1.0F / (this.func_70681_au().nextFloat() * 0.4F + 0.8F));
        if (this.func_70068_e(p_82196_1_) <= this.getMeleeRange()) {
            this.attackChoosenEntity(p_82196_1_, 10.0F, 5);
        }

    }

    public int getSkeletonType() {
        return this.field_70180_af.func_75683_a(13);
    }

    public void setSkeletonType(int p_82201_1_) {
        this.field_70180_af.func_75692_b(13, (byte)p_82201_1_);
        if (p_82201_1_ == 1) {
            this.func_70105_a(14.0F, 56.0F);
            this.field_70728_aV = 50000;
            this.head.field_70130_N = this.head.field_70131_O = 14.0F;
            this.pelvis.field_70130_N = 10.5F;
            this.spine.field_70131_O = 21.0F;
            this.ribCage.field_70131_O = 8.75F;
            this.ribCage.field_70130_N = 12.25F;
            this.pelvis.field_70131_O = this.spine.field_70130_N = this.rightLeg.field_70130_N = this.leftLeg.field_70130_N = this.leftArm.field_70130_N = this.rightArm.field_70130_N = 3.5F;
            this.rightLeg.field_70131_O = this.leftLeg.field_70131_O = this.leftArm.field_70131_O = this.rightArm.field_70131_O = 21.0F;
            this.leftArm.field_70131_O = this.rightArm.field_70131_O = 21.0F;
        } else {
            this.func_70105_a(8.0F, 32.0F);
            this.field_70728_aV = 20000;
            this.head.field_70130_N = this.head.field_70131_O = 8.0F;
            this.pelvis.field_70130_N = 6.0F;
            this.spine.field_70131_O = 12.0F;
            this.ribCage.field_70131_O = 5.0F;
            this.ribCage.field_70130_N = 7.0F;
            this.pelvis.field_70131_O = this.spine.field_70130_N = this.rightLeg.field_70130_N = this.leftLeg.field_70130_N = this.leftArm.field_70130_N = this.rightArm.field_70130_N = 2.0F;
            this.rightLeg.field_70131_O = this.leftLeg.field_70131_O = this.leftArm.field_70131_O = this.rightArm.field_70131_O = 12.0F;
        }

    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        if (tagCompund.func_150297_b("SkeletonType", 99)) {
            byte b0 = tagCompund.func_74771_c("SkeletonType");
            this.setSkeletonType(b0);
        }

        this.setCombatTask();
    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        tagCompound.func_74774_a("SkeletonType", (byte)this.getSkeletonType());
    }

    public void func_70062_b(int slotIn, ItemStack stack) {
        super.func_70062_b(slotIn, stack);
        if (!this.field_70170_p.field_72995_K && slotIn == 0) {
            this.setCombatTask();
        }

    }

    public float func_70047_e() {
        return this.getSkeletonType() == 1 ? 46.68F : 28.0F;
    }

    protected void func_70619_bc() {
        super.func_70619_bc();
        List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D);
        if (list11 != null && !list11.isEmpty()) {
            for(int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (entity instanceof EntityLivingBase && entity.field_70122_E && !(entity instanceof EntityTitan)) {
                    float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                    entity.func_70097_a(DamageSourceExtra.causeSquishingDamage(this), f / 2.0F);
                    if (this.getSkeletonType() == 1) {
                        ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 1500, 3));
                    }
                }
            }
        }

    }

    public double func_70033_W() {
        return this.getSkeletonType() == 1 ? super.func_70033_W() - 12.48 : super.func_70033_W() - 10.4;
    }

    protected void inactDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            this.func_85030_a("mob.skeleton.death", this.func_70599_aP(), this.func_70647_i());
            if (this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
                this.func_70628_a(true, 0);
                this.func_82160_b(true, 0);
                this.func_70600_l(1);
            }

            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.field_70170_p);
            entitytitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitytitan);
            entitytitan.setVesselHunting(false);
            if (this.getSkeletonType() == 1) {
                entitytitan.setSpiritType(5);
            } else {
                entitytitan.setSpiritType(4);
            }
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
                this.animID = 0;
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
            float f = (this.field_70146_Z.nextFloat() - 0.5F) * 24.0F;
            float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 24.0F;
            this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + (double)2.0F + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
        }

        if (this.getInvulTime() >= this.getThreashHold()) {
            this.func_70106_y();
        }

    }

    public boolean attackSkeletonFrom(DamageSource source, float amount) {
        if (this.isArmored()) {
            amount /= 2.0F;
        }

        if (this.func_85032_ar()) {
            return false;
        } else if (!this.isStunned && source.func_76346_g() instanceof EntityPlayer) {
            return false;
        } else if (!(source.func_76346_g() instanceof EntitySkeletonMinion) && (this.field_70154_o == null || source.func_76346_g() != this.field_70154_o || !(this.field_70154_o instanceof EntitySpiderTitan)) && !(source.func_76346_g() instanceof EntitySkeletonTitan) && !(source.func_76346_g() instanceof EntityWitherMinion)) {
            this.field_70718_bc = 200;
            Entity entity = source.func_76346_g();
            if (entity instanceof EntityLivingBase && !this.func_85032_ar() && amount > 25.0F) {
                List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)256.0F, (double)256.0F, (double)256.0F));

                for(int i = 0; i < list.size(); ++i) {
                    Entity entity1 = (Entity)list.get(i);
                    if (entity1 instanceof EntitySkeletonTitan) {
                        EntitySkeletonTitan entitypigzombie = (EntitySkeletonTitan)entity1;
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
        if (source.func_76346_g() instanceof EntityPlayer && !this.field_70170_p.field_72995_K) {
            this.func_70624_b((EntityLivingBase)source.func_76346_g());
            this.func_70604_c((EntityLivingBase)source.func_76346_g());
        }

        if (this.func_85032_ar()) {
            return false;
        } else if (!this.isStunned && source.func_76346_g() instanceof EntityPlayer) {
            return false;
        } else if (!(source.func_76346_g() instanceof EntitySkeletonMinion) && (this.field_70154_o == null || source.func_76346_g() != this.field_70154_o || !(this.field_70154_o instanceof EntitySpiderTitan)) && !(source.func_76346_g() instanceof EntitySkeletonTitan) && !(source.func_76346_g() instanceof EntityWitherMinion)) {
            if (this.getSkeletonType() == 1 && source.func_76347_k()) {
                this.func_70691_i(amount);
                return false;
            } else {
                this.field_70718_bc = 200;
                Entity entity = source.func_76346_g();
                if (entity instanceof EntityLivingBase && !this.func_85032_ar() && amount > 25.0F) {
                    List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)256.0F, (double)256.0F, (double)256.0F));

                    for(int i = 0; i < list.size(); ++i) {
                        Entity entity1 = (Entity)list.get(i);
                        if (entity1 instanceof EntitySkeletonTitan) {
                            EntitySkeletonTitan entitypigzombie = (EntitySkeletonTitan)entity1;
                            entitypigzombie.func_70624_b((EntityLivingBase)entity);
                            entitypigzombie.func_70604_c((EntityLivingBase)entity);
                        }

                        this.func_70624_b((EntityLivingBase)entity);
                        this.func_70604_c((EntityLivingBase)entity);
                    }
                }

                return super.func_70097_a(source, amount);
            }
        } else {
            return false;
        }
    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean attackEntityFromPart(EntityTitanPart p_70965_1_, DamageSource source, float amount) {
        this.func_82195_e(source, amount);
        return true;
    }

    protected boolean func_82195_e(DamageSource p_82195_1_, float p_82195_2_) {
        return this.func_70097_a(p_82195_1_, p_82195_2_);
    }

    public World func_82194_d() {
        return this.field_70170_p;
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
}
