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
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanAntiTitanAttack;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanAttack1;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanAttack2;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanAttack3;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanAttack4;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanAttack5;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanCreation;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanDeath;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanLightningAttack;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanRangedAttack;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanReformSword;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanRoar;
import net.minecraft.entity.titan.animation.zombietitan.AnimationZombieTitanStun;
import net.minecraft.entity.titanminion.EntityGiantZombieBetter;
import net.minecraft.entity.titanminion.EntityZombieMinion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityZombieTitan extends EntityTitan implements IAnimatedEntity, IEntityMultiPartTitan {
    public boolean isStunned;
    public EntityTitanPart[] partArray;
    public EntityTitanPart head;
    public EntityTitanPart body;
    public EntityTitanPart rightArm;
    public EntityTitanPart leftArm;
    public EntityTitanPart rightLeg;
    public EntityTitanPart leftLeg;

    public EntityZombieTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 8.0F, 8.0F);
        this.body = new EntityTitanPart(worldIn, this, "body", 8.0F, 12.0F);
        this.rightArm = new EntityTitanPart(worldIn, this, "rightarm", 4.0F, 4.0F);
        this.leftArm = new EntityTitanPart(worldIn, this, "leftarm", 4.0F, 4.0F);
        this.rightLeg = new EntityTitanPart(worldIn, this, "rightleg", 4.0F, 12.0F);
        this.leftLeg = new EntityTitanPart(worldIn, this, "leftleg", 4.0F, 12.0F);
        this.partArray = new EntityTitanPart[]{this.head, this.body, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg};
        this.func_70105_a(8.0F, 32.0F);
        this.field_70728_aV = 10000;
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        worldIn.func_72838_d(this.head);
        worldIn.func_72838_d(this.body);
        worldIn.func_72838_d(this.rightArm);
        worldIn.func_72838_d(this.leftArm);
        worldIn.func_72838_d(this.rightLeg);
        worldIn.func_72838_d(this.leftLeg);
    }

    protected void applyEntityAI() {
        this.footID = 1;
        this.field_70714_bg.func_75776_a(1, new AnimationZombieTitanCreation(this));
        this.field_70714_bg.func_75776_a(1, new AnimationZombieTitanDeath(this));
        this.field_70714_bg.func_75776_a(1, new AnimationZombieTitanAttack4(this));
        this.field_70714_bg.func_75776_a(1, new AnimationZombieTitanStun(this));
        this.field_70714_bg.func_75776_a(1, new AnimationZombieTitanAttack3(this));
        this.field_70714_bg.func_75776_a(1, new AnimationZombieTitanAttack2(this));
        this.field_70714_bg.func_75776_a(1, new AnimationZombieTitanRangedAttack(this));
        this.field_70714_bg.func_75776_a(1, new AnimationZombieTitanLightningAttack(this));
        this.field_70714_bg.func_75776_a(1, new AnimationZombieTitanRoar(this));
        this.field_70714_bg.func_75776_a(1, new AnimationZombieTitanAntiTitanAttack(this));
        this.field_70714_bg.func_75776_a(1, new AnimationZombieTitanAttack1(this));
        this.field_70714_bg.func_75776_a(1, new AnimationZombieTitanReformSword(this));
        this.field_70714_bg.func_75776_a(1, new AnimationZombieTitanAttack5(this));
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.ZombieTitanSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

    }

    public boolean isArmored() {
        return this.func_110143_aJ() <= this.func_110138_aP() / 4.0F || TheTitans.NightmareMode || TheTitans.TotalDestructionMode;
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != this.head.getClass() && p_70686_1_ != this.body.getClass() && p_70686_1_ != this.rightArm.getClass() && p_70686_1_ != this.leftArm.getClass() && p_70686_1_ != this.rightLeg.getClass() && p_70686_1_ != this.leftLeg.getClass() && p_70686_1_ != EntityZombieMinion.class && p_70686_1_ != EntityGiantZombieBetter.class && p_70686_1_ != EntityZombieTitan.class;
    }

    public float func_70603_bj() {
        float f = 16.0F;
        if (this.func_70631_g_()) {
            f *= 0.6F;
        }

        return f;
    }

    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(50) == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }

    public int getMinionSpawnRate() {
        return TheTitans.ZombieTitanMinionSpawnrate;
    }

    public int getRegenTime() {
        return !this.field_70170_p.func_72935_r() ? 5 : super.getRegenTime();
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
        return this.animID == 11 && this.animTick > 80 ? 20 : 10;
    }

    public int getSpecialMinionCap() {
        return 10;
    }

    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.AVERAGE;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.func_70096_w().func_75682_a(12, (byte)0);
        this.func_70096_w().func_75682_a(13, (byte)0);
        this.func_70096_w().func_75682_a(14, (byte)0);
        this.func_70096_w().func_75682_a(15, (byte)0);
        this.func_70096_w().func_75682_a(16, (byte)0);
    }

    public int getFootStepModifer() {
        return 3;
    }

    public boolean func_70662_br() {
        return true;
    }

    public boolean func_70631_g_() {
        return this.func_70096_w().func_75683_a(12) == 1;
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

    public boolean isVillager() {
        return this.func_70096_w().func_75683_a(13) == 1;
    }

    public void setVillager(boolean villager) {
        this.func_70096_w().func_75692_b(13, (byte)(villager ? 1 : 0));
    }

    public boolean isArmed() {
        return this.func_70096_w().func_75683_a(15) == 1;
    }

    public void setArmed(boolean armed) {
        this.func_70096_w().func_75692_b(15, (byte)(armed ? 1 : 0));
    }

    public boolean isSwordSoft() {
        return this.func_70096_w().func_75683_a(16) == 1;
    }

    public void setSwordSoft(boolean armed) {
        this.func_70096_w().func_75692_b(16, (byte)(armed ? 1 : 0));
    }

    public double getSpeed() {
        return this.func_70631_g_() ? 0.6 + (double)this.getExtraPower() * 0.001 : (this.isArmored() ? 0.45 + (double)this.getExtraPower() * 0.001 : 0.3 + (double)this.getExtraPower() * 0.001);
    }

    public boolean canBeHurtByPlayer() {
        return !this.isArmed() && !this.func_85032_ar();
    }

    public boolean shouldMove() {
        return this.animID == 0 && !this.isStunned && !this.getWaiting() && this.func_70638_az() != null ? super.shouldMove() : false;
    }

    public boolean func_70652_k(Entity p_70652_1_) {
        return false;
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

            if (this.getAnimID() == 13 && this.getAnimTick() > 4 && this.getAnimTick() <= 48) {
                this.destroyBlocksInAABBGriefingBypass(this.body.field_70121_D.func_72317_d((double)0.0F, (double)(-24 + this.getAnimTick()), (double)0.0F).func_72314_b((double)0.0F, (double)8.0F, (double)0.0F));
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 2) {
                this.func_85030_a("thetitans:titanBirth", 1000.0F, 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 10) {
                this.func_85030_a("thetitans:titanRumble", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 360) {
                this.func_85030_a("thetitans:titanQuake", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 160) {
                this.func_85030_a("thetitans:titanZombieCreation", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 440) {
                this.func_85030_a("thetitans:titanSkeletonGetUp", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && (this.getAnimTick() == 80 || this.getAnimTick() == 150 || this.getAnimTick() == 370 || this.getAnimTick() == 430 || this.getAnimTick() == 470 || this.getAnimTick() == 490)) {
                this.func_145780_a(0, 0, 0, Blocks.field_150348_b);
                this.func_85030_a("thetitans:titanPress", this.func_70599_aP(), 1.0F);
            }
        }

        if (this.getAnimID() == 5) {
            if (this.getAnimTick() == 34) {
                this.func_85030_a("thetitans:lightningCharge", 100.0F, 1.0F);
            }

            if (this.getAnimTick() <= 46 && this.getAnimTick() >= 26) {
                float ex = this.func_70631_g_() ? 4.5F : 9.5F;
                float fl = this.field_70761_aq * (float)Math.PI / 180.0F;
                float fl1 = MathHelper.func_76126_a(fl);
                float fl2 = MathHelper.func_76134_b(fl);
                this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t - (double)(fl2 * ex), this.field_70163_u + (this.func_70631_g_() ? (double)13.0F : (double)26.0F), this.field_70161_v - (double)(fl1 * ex), 0.0F, 0.56F, 0.0F));
                this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + (double)(fl2 * ex), this.field_70163_u + (this.func_70631_g_() ? (double)13.0F : (double)26.0F), this.field_70161_v + (double)(fl1 * ex), 0.0F, 0.56F, 0.0F));
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
                this.field_70170_p.func_72885_a(this, this.field_70165_t + dx, this.field_70163_u + (double)26.0F, this.field_70161_v + dz, 1.0F, false, false);
                this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + (this.func_70631_g_() ? (double)9.0F : (double)18.0F), this.field_70161_v + dz, 0.0F, 0.56F, 0.0F));
                this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + (this.func_70631_g_() ? (double)9.0F : (double)18.0F), this.field_70161_v + dz, 0.0F, 0.56F, 0.0F));
                this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + (this.func_70631_g_() ? (double)9.0F : (double)18.0F), this.field_70161_v + dz, 0.0F, 0.56F, 0.0F));
                this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + (this.func_70631_g_() ? (double)9.0F : (double)18.0F), this.field_70161_v + dz, 0.0F, 0.56F, 0.0F));
                if (this.func_70638_az() != null) {
                    this.field_70170_p.func_72885_a(this, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 2.0F, false, false);
                    this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 0.0F, 0.56F, 0.0F));
                    float da = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                    int i = this.getKnockbackAmount();
                    this.attackChoosenEntity(this.func_70638_az(), da * 3.0F, i);
                    EntityLivingBase var10000 = this.func_70638_az();
                    var10000.field_70181_x += (double)(1.0F + this.field_70146_Z.nextFloat());
                    this.func_70638_az().func_70097_a(DamageSourceExtra.lightningBolt, da);
                    List list1 = this.field_70170_p.func_72839_b(this.func_70638_az(), this.func_70638_az().field_70121_D.func_72314_b((double)12.0F, (double)12.0F, (double)12.0F));
                    if (list1 != null && !list1.isEmpty()) {
                        for(int i11 = 0; i11 < list1.size(); ++i11) {
                            Entity entity1 = (Entity)list1.get(i11);
                            if (entity1 instanceof EntityLivingBase && this.func_70686_a(entity1.getClass())) {
                                this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, entity1.field_70165_t, entity1.field_70163_u, entity1.field_70161_v, 0.2F, 1.0F, 0.0F));
                                this.attackChoosenEntity(entity1, da, i);
                                if (!(entity1 instanceof EntityTitan)) {
                                    entity1.field_70181_x += (double)(1.0F + this.field_70146_Z.nextFloat());
                                }
                            }
                        }
                    }
                }
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

        if (this.animID == 8) {
            if (this.animTick > 138) {
                this.isStunned = false;
            } else {
                this.isStunned = true;
            }
        }

        if (this.getAnimID() == 8 && this.getAnimTick() == 4 && !this.field_70170_p.field_72995_K) {
            this.dropSword();
        }

        if (this.getAnimID() == 8 && this.getAnimTick() >= 80 && this.getAnimTick() <= 100) {
            this.func_85030_a(this.func_70639_aQ(), this.func_70599_aP(), 1.1F);
        }

        if (this.getAnimID() == 7 && this.getAnimTick() == 122) {
            double d8 = this.func_70631_g_() ? (double)16.0F : (double)32.0F;
            Vec3 vec3 = this.func_70676_i(1.0F);
            double dx = vec3.field_72450_a * d8;
            double dz = vec3.field_72449_c * d8;
            int y = MathHelper.func_76128_c(this.field_70163_u);
            int x = MathHelper.func_76128_c(this.field_70165_t + dx);
            int z = MathHelper.func_76128_c(this.field_70161_v + dz);
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

                        if (block.func_149638_a(this) > 500.0F && block.func_149662_c() && !this.isSwordSoft()) {
                            this.setAnimTick(0);
                            AnimationAPI.sendAnimPacket(this, 8);
                            this.setAnimID(8);
                            this.func_85030_a("random.anvil_land", 20.0F, 0.5F);
                            this.isStunned = true;
                        } else if (block.func_149638_a(this) <= 1.5F && block.func_149662_c() && this.isSwordSoft() && block != Blocks.field_150350_a && block != Blocks.field_150424_aL && block != Blocks.field_150346_d && block != Blocks.field_150349_c && block != Blocks.field_150359_w && block != Blocks.field_150410_aZ) {
                            this.setAnimTick(0);
                            AnimationAPI.sendAnimPacket(this, 8);
                            this.setAnimID(8);
                            this.func_85030_a("random.anvil_land", 20.0F, 0.5F);
                            this.isStunned = true;
                        }
                    }
                }
            }
        }

        if (this.getAnimID() == 2 && this.getAnimTick() == 160) {
            double d8 = (double)12.0F;
            Vec3 vec3 = this.func_70676_i(1.0F);
            double dx = vec3.field_72450_a * d8;
            double dz = vec3.field_72449_c * d8;
            int y = MathHelper.func_76128_c(this.field_70163_u);
            int x = MathHelper.func_76128_c(this.field_70165_t + dx);
            int z = MathHelper.func_76128_c(this.field_70161_v + dz);

            for(int l1 = -2; l1 <= 2; ++l1) {
                for(int i2 = -2; i2 <= 2; ++i2) {
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

                        if (block.func_149638_a(this) > 500.0F) {
                            this.setSwordSoft(false);
                        } else if (block.func_149638_a(this) <= 500.0F) {
                            this.setSwordSoft(true);
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
        if (this.getAnimID() == 12 && this.func_70638_az() != null && this.getAnimTick() == 55) {
            for(int i = 0; i < 4 + 2 * this.field_70170_p.field_73013_u.func_151525_a(); ++i) {
                this.attackEntityWithRangedAttack(this.func_70638_az(), 0.0F);
            }
        }

        if (this.isStunned || this.deathTicks > 0) {
            this.field_70159_w *= (double)0.0F;
            this.field_70179_y *= (double)0.0F;
        }

        if (!AnimationAPI.isEffectiveClient() && this.func_70638_az() != null && !this.isStunned && this.getAnimID() == 0 && this.field_70173_aa > 5) {
            double d0 = this.func_70068_e(this.func_70638_az());
            if (d0 < this.getMeleeRange()) {
                if (!(this.func_70638_az() instanceof EntityTitan) && !(this.func_70638_az().field_70131_O >= 6.0F) && !(this.func_70638_az().field_70163_u > this.field_70163_u + (double)6.0F)) {
                    switch (this.field_70146_Z.nextInt(6)) {
                        case 0:
                            AnimationAPI.sendAnimPacket(this, 6);
                            this.setAnimID(6);
                            break;
                        case 1:
                            if (this.isArmed()) {
                                AnimationAPI.sendAnimPacket(this, 7);
                                this.setAnimID(7);
                            } else if (this.func_70681_au().nextInt(2) == 0) {
                                AnimationAPI.sendAnimPacket(this, 2);
                                this.setAnimID(2);
                            } else {
                                AnimationAPI.sendAnimPacket(this, 4);
                                this.setAnimID(4);
                            }
                            break;
                        case 2:
                            AnimationAPI.sendAnimPacket(this, 9);
                            this.setAnimID(9);
                            break;
                        case 3:
                            AnimationAPI.sendAnimPacket(this, 4);
                            this.setAnimID(4);
                            break;
                        case 4:
                            AnimationAPI.sendAnimPacket(this, 3);
                            this.setAnimID(3);
                            break;
                        case 5:
                            AnimationAPI.sendAnimPacket(this, 11);
                            this.setAnimID(11);
                    }
                } else {
                    AnimationAPI.sendAnimPacket(this, 1);
                    this.setAnimID(1);
                }
            } else if (this.getAnimID() == 0 && this.func_70681_au().nextInt(100) == 0) {
                switch (this.field_70146_Z.nextInt(4)) {
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
                        break;
                    case 3:
                        if (this.isArmed()) {
                            AnimationAPI.sendAnimPacket(this, 5);
                            this.setAnimID(5);
                        } else if (this.func_70681_au().nextInt(5) == 0) {
                            AnimationAPI.sendAnimPacket(this, 2);
                            this.setAnimID(2);
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

        if (this.isVillager() && this.func_70631_g_()) {
            this.func_94058_c(StatCollector.func_74838_a("entity.ZombieTitan.name.babyvillager"));
        } else if (!this.isVillager() && this.func_70631_g_()) {
            this.func_94058_c(StatCollector.func_74838_a("entity.ZombieTitan.name.baby"));
        } else if (this.isVillager() && !this.func_70631_g_()) {
            this.func_94058_c(StatCollector.func_74838_a("entity.ZombieTitan.name.villager"));
        } else {
            this.func_94058_c(StatCollector.func_74838_a("entity.ZombieTitan.name"));
        }

        if (TheTitans.NightmareMode) {
            if (this.func_70631_g_()) {
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)20000.0F + (double)(this.getExtraPower() * 1000));
                if (this.isArmed()) {
                    this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)480.0F + (double)(this.getExtraPower() * 90));
                } else {
                    this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)240.0F + (double)(this.getExtraPower() * 45));
                }
            } else {
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)40000.0F + (double)(this.getExtraPower() * 2000));
                if (this.isArmed()) {
                    this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)720.0F + (double)(this.getExtraPower() * 180));
                } else {
                    this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)360.0F + (double)(this.getExtraPower() * 90));
                }
            }
        } else if (this.func_70631_g_()) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)10000.0F + (double)(this.getExtraPower() * 500));
            if (this.isArmed()) {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)160.0F + (double)(this.getExtraPower() * 30));
            } else {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)80.0F + (double)(this.getExtraPower() * 15));
            }
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)20000.0F + (double)(this.getExtraPower() * 1000));
            if (this.isArmed()) {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)240.0F + (double)(this.getExtraPower() * 60));
            } else {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)120.0F + (double)(this.getExtraPower() * 30));
            }
        }

        if (this.getAnimID() == 2 && this.field_70181_x > (double)0.0F) {
            this.field_70181_x = (double)0.0F;
        }

        if (!this.isArmed() && this.func_70638_az() != null && this.func_70638_az() instanceof EntityTitan && this.animID == 0) {
            AnimationAPI.sendAnimPacket(this, 2);
        }

        if (this.field_70146_Z.nextInt(120) == 0 && this.func_70638_az() != null && this.func_70068_e(this.func_70638_az()) > (double)512.0F && this.field_70122_E && this.animID == 0) {
            this.func_85030_a(this.func_70621_aR(), this.func_70599_aP(), this.func_70647_i());
            if (this.field_70146_Z.nextInt(4) == 0) {
                this.func_70664_aZ();
                double d01 = this.func_70638_az().field_70165_t - this.field_70165_t;
                double d11 = this.func_70638_az().field_70161_v - this.field_70161_v;
                float f21 = MathHelper.func_76133_a(d01 * d01 + d11 * d11);
                double hor = (double)2.0F;
                this.field_70159_w = d01 / (double)f21 * hor * hor + this.field_70159_w * hor;
                this.field_70179_y = d11 / (double)f21 * hor * hor + this.field_70179_y * hor;
            } else {
                this.jumpAtEntity(this.func_70638_az());
            }
        }

        if (!this.getWaiting() && this.animID != 13 && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0) {
                    EntityGiantZombieBetter entitychicken = new EntityGiantZombieBetter(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70024_g((double)0.0F, (double)1.0F, (double)0.0F);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.5F);
                    ++this.numSpecialMinions;
                } else if (this.numMinions < this.getMinionCap()) {
                    EntityZombieMinion entitychicken = new EntityZombieMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(0);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    entitychicken.func_70024_g((double)0.0F, 0.8, (double)0.0F);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, Integer.MAX_VALUE, 0, false));
                    ++this.numMinions;
                    if (this.isVillager()) {
                        entitychicken.func_82229_g(true);
                    }

                    if (this.func_70631_g_()) {
                        entitychicken.func_82227_f(true);
                    }

                    Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v);
                    this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                    if (block == Blocks.field_150349_c) {
                        this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                    }
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0) {
                    EntityGiantZombieBetter entitychicken = new EntityGiantZombieBetter(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70024_g((double)0.0F, (double)1.0F, (double)0.0F);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.5F);
                    ++this.numSpecialMinions;
                } else if (this.numPriests < this.getPriestCap()) {
                    EntityZombieMinion entitychicken = new EntityZombieMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(1);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    entitychicken.func_70024_g((double)0.0F, 0.8, (double)0.0F);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, Integer.MAX_VALUE, 0, false));
                    ++this.numPriests;
                    if (this.isVillager()) {
                        entitychicken.func_82229_g(true);
                    }

                    if (this.func_70631_g_()) {
                        entitychicken.func_82227_f(true);
                    }

                    Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v);
                    this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                    if (block == Blocks.field_150349_c) {
                        this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                    }
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0) {
                    EntityGiantZombieBetter entitychicken = new EntityGiantZombieBetter(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70024_g((double)0.0F, (double)1.0F, (double)0.0F);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.5F);
                    ++this.numSpecialMinions;
                } else if (this.numZealots < this.getZealotCap()) {
                    EntityZombieMinion entitychicken = new EntityZombieMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(2);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    entitychicken.func_70024_g((double)0.0F, 0.8, (double)0.0F);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, Integer.MAX_VALUE, 0, false));
                    ++this.numZealots;
                    if (this.isVillager()) {
                        entitychicken.func_82229_g(true);
                    }

                    if (this.func_70631_g_()) {
                        entitychicken.func_82227_f(true);
                    }

                    Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v);
                    this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                    if (block == Blocks.field_150349_c) {
                        this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                    }
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0) {
                    EntityGiantZombieBetter entitychicken = new EntityGiantZombieBetter(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70024_g((double)0.0F, (double)1.0F, (double)0.0F);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.5F);
                    ++this.numSpecialMinions;
                } else if (this.numBishop < this.getBishopCap()) {
                    EntityZombieMinion entitychicken = new EntityZombieMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(3);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    entitychicken.func_70024_g((double)0.0F, 0.8, (double)0.0F);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, Integer.MAX_VALUE, 0, false));
                    ++this.numBishop;
                    if (this.isVillager()) {
                        entitychicken.func_82229_g(true);
                    }

                    if (this.func_70631_g_()) {
                        entitychicken.func_82227_f(true);
                    }

                    Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v);
                    this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                    if (block == Blocks.field_150349_c) {
                        this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                    }
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1 || this.animID == 11 && this.animTick > 80) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0) {
                    EntityGiantZombieBetter entitychicken = new EntityGiantZombieBetter(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70024_g((double)0.0F, (double)1.0F, (double)0.0F);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 10.0F, 0.5F);
                    ++this.numSpecialMinions;
                } else if (this.numTemplar < this.getTemplarCap()) {
                    EntityZombieMinion entitychicken = new EntityZombieMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(4);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    entitychicken.func_70024_g((double)0.0F, 0.8, (double)0.0F);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, Integer.MAX_VALUE, 0, false));
                    ++this.numTemplar;
                    if (this.isVillager()) {
                        entitychicken.func_82229_g(true);
                    }

                    if (this.func_70631_g_()) {
                        entitychicken.func_82227_f(true);
                    }

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

    protected void func_70619_bc() {
        List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D);
        if (list11 != null && !list11.isEmpty()) {
            for(int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (entity instanceof EntityLivingBase && entity.field_70122_E && !(entity instanceof EntityTitan) && this.func_70089_S() && !this.isStunned) {
                    float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                    entity.func_70097_a(DamageSourceExtra.causeSquishingDamage(this), f / 2.0F);
                }
            }
        }

        super.func_70619_bc();
    }

    protected String func_70639_aQ() {
        if (!this.getWaiting() && this.animID != 13) {
            this.func_85030_a("mob.zombie.say", this.func_70599_aP(), this.func_70647_i() - 0.6F);
        }

        return !this.getWaiting() && this.animID != 13 ? "thetitans:titanZombieLiving" : null;
    }

    protected String func_70621_aR() {
        this.func_85030_a("mob.zombie.hurt", this.func_70599_aP(), this.func_70647_i() - 0.6F);
        return "thetitans:titanZombieGrunt";
    }

    protected String func_70673_aS() {
        this.func_85030_a("mob.zombie.death", this.func_70599_aP(), this.func_70647_i() - 0.6F);
        return "thetitans:titanZombieDeath";
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

    protected void dropSword() {
        if (this.isArmed() && !this.field_70170_p.field_72995_K) {
            for(int l = 0; l < 16; ++l) {
                this.func_85030_a("random.break", 100.0F, 0.5F);
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 8.0F - 4.0F), this.field_70163_u + (double)32.0F + (double)(this.field_70146_Z.nextFloat() * 8.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 8.0F - 4.0F), new ItemStack(Items.field_151055_y));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 32; ++l) {
                this.func_85030_a("random.break", 100.0F, 0.5F);
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 8.0F - 4.0F), this.field_70163_u + (double)40.0F + (double)(this.field_70146_Z.nextFloat() * 16.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 8.0F - 4.0F), new ItemStack(Items.field_151042_j));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            this.setArmed(false);
        }

    }

    protected Item func_146068_u() {
        return Items.field_151078_bh;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            for(int x = 0; x < 16; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                entitylargefireball.func_70107_b(this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                ++entitylargefireball.field_70181_x;
                entitylargefireball.setXPCount(12000);
                this.field_70170_p.func_72838_d(entitylargefireball);
            }

            if (this.isArmed()) {
                for(int l = 0; l < 16; ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151055_y));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 32; ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151042_j));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }
            }

            for(int l = 0; l < 128 + this.field_70146_Z.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151078_bh));
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
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151042_j));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 8 + this.field_70146_Z.nextInt(8 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151166_bC));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 8 + this.field_70146_Z.nextInt(8 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151045_i));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 0 + this.field_70146_Z.nextInt(4 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(TitanItems.harcadium));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            if (this.field_70146_Z.nextInt(10) == 0) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150357_h));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }
        }

    }

    protected void func_70600_l(int p_70600_1_) {
        switch (this.field_70146_Z.nextInt(3)) {
            case 0:
                this.func_145779_a(Items.field_151042_j, 64);
                break;
            case 1:
                this.func_145779_a(Items.field_151172_bF, 64);
                break;
            case 2:
                this.func_145779_a(Items.field_151174_bG, 64);
        }

    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        if (this.func_70631_g_()) {
            tagCompound.func_74757_a("IsBaby", true);
        }

        if (this.isVillager()) {
            tagCompound.func_74757_a("IsVillager", true);
        }

        if (this.isArmed()) {
            tagCompound.func_74757_a("IsArmed", true);
        }

        tagCompound.func_74757_a("Stunned", this.isStunned);
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        if (tagCompund.func_74767_n("IsBaby")) {
            this.setChild(true);
        }

        if (tagCompund.func_74767_n("IsVillager")) {
            this.setVillager(true);
        }

        if (tagCompund.func_74767_n("IsArmed")) {
            this.setArmed(true);
        }

        this.isStunned = tagCompund.func_74767_n("Stunned");
    }

    public void func_70074_a(EntityLivingBase entityLivingIn) {
        super.func_70074_a(entityLivingIn);
        if (entityLivingIn instanceof EntityVillager) {
            EntityZombieMinion entityzombie = new EntityZombieMinion(this.field_70170_p);
            entityzombie.func_82149_j(entityLivingIn);
            this.field_70170_p.func_72900_e(entityLivingIn);
            entityzombie.func_110161_a((IEntityLivingData)null);
            entityzombie.func_82229_g(true);
            if (entityLivingIn.func_70631_g_()) {
                entityzombie.func_82227_f(true);
            }

            this.field_70170_p.func_72838_d(entityzombie);
            this.field_70170_p.func_72889_a((EntityPlayer)null, 1016, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
        }

    }

    public float func_70047_e() {
        float f = 27.6F;
        if (this.func_70631_g_()) {
            f = 14.8F;
        }

        return f;
    }

    public IEntityLivingData func_110161_a(IEntityLivingData p_180482_2_) {
        Object p_180482_2_1 = super.func_110161_a(p_180482_2_);
        this.func_98053_h(true);
        this.setArmed(true);
        this.setWaiting(true);
        if (p_180482_2_1 == null) {
            p_180482_2_1 = new GroupData(this.field_70170_p.field_73012_v.nextFloat() < ForgeModContainer.zombieBabyChance, this.field_70170_p.field_73012_v.nextFloat() < 0.05F, (Object)null);
        }

        if (p_180482_2_1 instanceof GroupData) {
            GroupData groupdata = (GroupData)p_180482_2_1;
            if (groupdata.field_142046_b) {
                this.setVillager(true);
            }

            if (groupdata.field_142048_a) {
                this.setChild(true);
            }
        }

        if (this.func_71124_b(4) == null) {
            Calendar calendar = this.field_70170_p.func_83015_S();
            if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.field_70146_Z.nextFloat() < 0.25F) {
                this.func_70062_b(4, new ItemStack(this.field_70146_Z.nextFloat() < 0.1F ? Blocks.field_150428_aP : Blocks.field_150423_aK));
                this.field_82174_bp[4] = 0.0F;
            }
        }

        return (IEntityLivingData)p_180482_2_1;
    }

    public double func_70033_W() {
        return super.func_70033_W() - (double)8.0F;
    }

    public StatBase getAchievement() {
        return TitansAchievments.zombietitan;
    }

    protected void inactDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            this.func_85030_a("mob.zombie.death", this.func_70599_aP(), this.func_70647_i());
            if (this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
                this.func_70628_a(true, 0);
                this.func_82160_b(true, 0);
                this.func_70600_l(1);
            }

            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.field_70170_p);
            entitytitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitytitan);
            entitytitan.setVesselHunting(false);
            entitytitan.setSpiritType(6);
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

        if (this.deathTicks >= 80 && this.isArmed()) {
            this.dropSword();
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

    public boolean attackZombieFrom(DamageSource source, float amount) {
        if (this.isArmored()) {
            amount /= 4.0F;
        }

        if (this.func_85032_ar()) {
            return false;
        } else if (this.isArmed() && source.func_76346_g() instanceof EntityPlayer) {
            return false;
        } else if (this.isArmored() && source instanceof EntityDamageSourceIndirect) {
            return false;
        } else if (!(source.func_76346_g() instanceof EntityZombieMinion) && !(source.func_76346_g() instanceof EntityZombieTitan) && !(source.func_76346_g() instanceof EntityGiantZombieBetter)) {
            Entity entity = source.func_76346_g();
            if (entity instanceof EntityLivingBase && !this.func_85032_ar() && amount > 25.0F) {
                List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)100.0F, (double)100.0F, (double)100.0F));

                for(int i = 0; i < list.size(); ++i) {
                    Entity entity1 = (Entity)list.get(i);
                    if (entity1 instanceof EntityZombieTitan) {
                        EntityZombieTitan entitypigzombie = (EntityZombieTitan)entity1;
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

    class GroupData implements IEntityLivingData {
        public boolean field_142048_a;
        public boolean field_142046_b;

        private GroupData(boolean p_i2348_2_, boolean p_i2348_3_) {
            this.field_142048_a = false;
            this.field_142046_b = false;
            this.field_142048_a = p_i2348_2_;
            this.field_142046_b = p_i2348_3_;
        }

        GroupData(boolean p_i2349_2_, boolean p_i2349_3_, Object p_i2349_4_) {
            this(p_i2349_2_, p_i2349_3_);
        }
    }
}
