//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanAntiTitanAttack;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanAttack1;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanAttack2;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanAttack3;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanAttack4;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanCreation;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanDeath;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanShootLightning;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanShootWeb;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanSpit;
import net.minecraft.entity.titan.animation.spidertitan.AnimationSpiderTitanStunned;
import net.minecraft.entity.titanminion.EntityCaveSpiderMinion;
import net.minecraft.entity.titanminion.EntitySkeletonMinion;
import net.minecraft.entity.titanminion.EntitySpiderMinion;
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
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntitySpiderTitan extends EntityTitan implements IAnimatedEntity, IEntityMultiPartTitan {
    public int damageToLegs;
    public boolean isStunned;
    public EntityTitanPart[] partArray;
    public EntityTitanPart head;
    public EntityTitanPart thorax;
    public EntityTitanPart abdomen;
    public EntityTitanPart rightlegs;
    public EntityTitanPart leftlegs;

    public EntitySpiderTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 8.0F, 8.0F);
        this.thorax = new EntityTitanPart(worldIn, this, "thorax", 6.0F, 6.0F);
        this.abdomen = new EntityTitanPart(worldIn, this, "abdomen", 12.0F, 8.0F);
        this.rightlegs = new EntityTitanPart(worldIn, this, "rightleg", 12.0F, 8.0F);
        this.leftlegs = new EntityTitanPart(worldIn, this, "leftleg", 12.0F, 8.0F);
        this.partArray = new EntityTitanPart[]{this.head, this.thorax, this.abdomen, this.rightlegs, this.leftlegs};
        this.func_70105_a(28.0F, 14.0F);
        this.field_70728_aV = 12000 + this.getExtraPower() * 500;
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        this.field_70714_bg.func_75776_a(1, new AnimationSpiderTitanCreation(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSpiderTitanDeath(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSpiderTitanAttack3(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSpiderTitanStunned(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSpiderTitanShootWeb(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSpiderTitanShootLightning(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSpiderTitanAntiTitanAttack(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSpiderTitanAttack2(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSpiderTitanAttack1(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSpiderTitanSpit(this));
        this.field_70714_bg.func_75776_a(1, new AnimationSpiderTitanAttack4(this));
        worldIn.func_72838_d(this.head);
        worldIn.func_72838_d(this.thorax);
        worldIn.func_72838_d(this.abdomen);
        worldIn.func_72838_d(this.rightlegs);
        worldIn.func_72838_d(this.leftlegs);
    }

    protected void applyEntityAI() {
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SpiderTitanSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

    }

    public boolean isArmored() {
        return this.func_110143_aJ() <= this.func_110138_aP() / 4.0F || TheTitans.NightmareMode || TheTitans.TotalDestructionMode;
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != this.head.getClass() && p_70686_1_ != this.thorax.getClass() && p_70686_1_ != this.abdomen.getClass() && p_70686_1_ != this.rightlegs.getClass() && p_70686_1_ != this.leftlegs.getClass() && p_70686_1_ != EntityWebShot.class && p_70686_1_ != EntitySpiderMinion.class && (p_70686_1_ == EntityCaveSpiderTitan.class || p_70686_1_ != EntitySpiderTitan.class);
    }

    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(25) == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }

    public int getMinionSpawnRate() {
        return TheTitans.SpiderTitanMinionSpawnrate;
    }

    public int getMinionCap() {
        return 160;
    }

    public int getPriestCap() {
        return 80;
    }

    public int getZealotCap() {
        return 40;
    }

    public int getBishopCap() {
        return 20;
    }

    public int getTemplarCap() {
        return 7;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, new Byte((byte)0));
        this.field_70180_af.func_75682_a(17, (byte)0);
    }

    public int getBonusID() {
        return this.field_70180_af.func_75683_a(17);
    }

    public void setBonusID(int p_70829_1_) {
        this.field_70180_af.func_75692_b(17, (byte)p_70829_1_);
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        if (tagCompund.func_150297_b("DamageToLegs", 99)) {
            this.damageToLegs = tagCompund.func_74762_e("DamageToLegs");
        }

        if (tagCompund.func_150297_b("SpawnedBonusID", 99)) {
            this.setBonusID(tagCompund.func_74762_e("SpawnedBonusID"));
        }

        this.isStunned = tagCompund.func_74767_n("Stunned");
    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        tagCompound.func_74768_a("DamageToLegs", this.damageToLegs);
        tagCompound.func_74768_a("SpawnedBonusID", this.getBonusID());
        tagCompound.func_74757_a("Stunned", this.isStunned);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.getWaiting() && this.animID != 0 && this.deathTicks < this.getThreashHold() && this.isArmored() && this.func_70089_S()) {
            ++this.animTick;
        }

        if (!this.field_70170_p.field_72995_K) {
            this.setBesideClimbableBlock(this.field_70123_F);
        }

    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.25F);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)60.0F);
    }

    public boolean canBeHurtByPlayer() {
        return this.isStunned && !this.func_85032_ar();
    }

    public boolean canAttack() {
        return false;
    }

    protected String func_70639_aQ() {
        return !this.isStunned && !this.getWaiting() && this.animID != 13 ? "thetitans:titanSpiderLiving" : null;
    }

    protected String func_70621_aR() {
        return "thetitans:titanSpiderGrunt";
    }

    protected String func_70673_aS() {
        return "thetitans:titanSpiderDeath";
    }

    public boolean func_70652_k(Entity p_70652_1_) {
        return false;
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.func_85030_a("thetitans:titanStep", 10.0F, 1.5F);
        this.func_85030_a("thetitans:titanStep", 10.0F, 1.5F);
        this.shakeNearbyPlayerCameras((double)4000.0F);
        this.shakeNearbyPlayerCameras((double)4000.0F);
    }

    public boolean shouldMove() {
        return this.animID == 0 && !this.isStunned && this.func_70638_az() != null ? super.shouldMove() : false;
    }

    public double getSpeed() {
        return (this.getBonusID() == 1 ? 0.6 : 0.55) + (double)this.getExtraPower() * 0.001;
    }

    public boolean func_82150_aj() {
        return this.getBonusID() == 4;
    }

    public void attackChoosenEntity(Entity damagedEntity, float damage, int knockbackAmount) {
        if (this.getBonusID() == 2) {
            damage *= 2.3F;
            knockbackAmount += 2;
            damagedEntity.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
        }

        super.attackChoosenEntity(damagedEntity, damage, knockbackAmount);
    }

    public double getMeleeRange() {
        return (double)(this.field_70130_N * this.field_70130_N + (this.func_70638_az().field_70130_N > 48.0F ? 2304.0F : this.func_70638_az().field_70130_N * this.func_70638_az().field_70130_N)) + (double)100.0F;
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
            EntityPlayer player = this.field_70170_p.func_72890_a(this, (double)32.0F);
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
                this.func_85030_a("thetitans:titanBirth", 100.0F, 1.25F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 40) {
                this.func_85030_a("thetitans:titanRumble", 10.0F, 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 30) {
                this.func_85030_a("thetitans:titanSpiderLiving", this.func_70599_aP(), 0.8F);
            }

            if (this.getAnimID() == 13 && (this.getAnimTick() == 135 || this.getAnimTick() == 155)) {
                this.func_145780_a(0, 0, 0, Blocks.field_150348_b);
                this.func_85030_a("thetitans:titanPress", this.func_70599_aP(), 1.0F);
            }
        }

        if (this.getAnimID() == 6 && this.getAnimTick() <= 100 && this.getAnimTick() >= 30 && this.getAnimTick() % 5 == 0 && this.func_70638_az() != null) {
            this.func_85030_a("mob.wither.shoot", 5.0F, 1.0F);
            double d8 = (double)2.0F;
            float xfac = MathHelper.func_76126_a(this.field_70761_aq * (float)Math.PI / 180.0F);
            float zfac = MathHelper.func_76134_b(this.field_70761_aq * (float)Math.PI / 180.0F);
            double var10001 = this.field_70165_t - (double)xfac * d8;
            double d0 = this.func_70638_az().field_70165_t - var10001;
            double d1 = this.func_70638_az().field_70163_u - (double)1.0F - (this.field_70163_u + (double)1.0F);
            var10001 = this.field_70161_v + (double)zfac * d8;
            double d2 = this.func_70638_az().field_70161_v - var10001;
            MathHelper.func_76133_a(d0 * d0 + d2 * d2);
            EntityWebShot entitysnowball = new EntityWebShot(this.field_70170_p, this, d0, d1, d2);
            entitysnowball.field_70165_t = this.field_70165_t - (double)xfac * d8;
            entitysnowball.field_70163_u = this.field_70163_u + (double)1.0F;
            entitysnowball.field_70161_v = this.field_70161_v + (double)zfac * d8;
            this.field_70170_p.func_72838_d(entitysnowball);
        }

        if (!this.field_70170_p.field_72995_K && this.getAnimID() == 2 && this.func_70638_az() != null) {
            List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)64.0F, (double)64.0F, (double)64.0F));
            if (list11 != null && !list11.isEmpty()) {
                for(int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity1 = (Entity)list11.get(i1);
                    if (entity1 instanceof EntityLivingBase && this.func_70686_a(entity1.getClass())) {
                        entity1.field_70172_ad = 0;
                        ((EntityLivingBase)entity1).func_70690_d(new PotionEffect(Potion.field_76437_t.field_76415_H, 100, 1));
                    }
                }
            }
        }

        if (!this.field_70170_p.field_72995_K && this.getAnimID() == 2 && this.getAnimTick() <= 70 && this.getAnimTick() >= 60 && this.func_70638_az() != null) {
            this.func_85030_a("mob.wither.shoot", 5.0F, 1.0F);
            this.attackChoosenEntity(this.func_70638_az(), 25.0F, 0);

            for(int j = 0; j < 300; ++j) {
                EntityPotion entitypotion = new EntityPotion(this.field_70170_p, this, this instanceof EntityCaveSpiderTitan ? 16484 : (this.field_70146_Z.nextInt(10) == 0 ? 16452 : 16490));
                double d8 = (double)5.0F;
                float xfac = MathHelper.func_76126_a(this.field_70761_aq * (float)Math.PI / 180.0F);
                float zfac = MathHelper.func_76134_b(this.field_70761_aq * (float)Math.PI / 180.0F);
                double var85 = this.head.field_70165_t - (double)xfac * d8;
                double d0 = this.func_70638_az().field_70165_t - var85;
                double d1 = this.func_70638_az().field_70163_u - (this.head.field_70163_u + (double)4.0F);
                var85 = this.head.field_70161_v + (double)zfac * d8;
                double d2 = this.func_70638_az().field_70161_v - var85;
                float f1 = MathHelper.func_76133_a(d0 * d0 + d2 * d2);
                entitypotion.func_70186_c(d0, d1 + (double)(f1 * 0.2F), d2, 1.6F, 1.0F + (float)(this.getAnimTick() * 2 - 60));
                entitypotion.field_70165_t = this.head.field_70165_t - (double)xfac * d8;
                entitypotion.field_70163_u = this.head.field_70163_u + (double)4.0F;
                entitypotion.field_70161_v = this.head.field_70161_v + (double)zfac * d8;
                this.field_70170_p.func_72838_d(entitypotion);
            }
        }

        if (this.getAnimID() == 7 && this.getAnimTick() == 68) {
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)3.0F, this.field_70161_v, 0.6F, 0.1F, 0.2F));
        }

        EntityPlayer player = this.field_70170_p.func_72890_a(this.head, (double)9.0F);
        if (player != null && this.head.field_70163_u < player.field_70163_u - (double)7.0F) {
            this.field_70759_as += MathHelper.func_76126_a((float)this.field_70173_aa) * 40.0F;
            this.field_70125_A -= MathHelper.func_76134_b((float)this.field_70173_aa) * 40.0F;
        }

        this.meleeTitan = true;
        if (this.animID == 10) {
            if (this.animTick == 80 || this.animTick == 210 || this.animTick == 250 || this.animTick == 260) {
                this.shakeNearbyPlayerCameras((double)10000.0F);
                this.func_85030_a("thetitans:titanFall", 20.0F, 1.0F);
                this.func_85030_a("thetitans:distantLargeFall", 10000.0F, 1.0F);
                this.collideWithEntities(this.leftlegs, this.field_70170_p.func_72839_b(this, this.leftlegs.field_70121_D.func_72314_b((double)24.0F, (double)1.0F, (double)24.0F)));
                this.collideWithEntities(this.rightlegs, this.field_70170_p.func_72839_b(this, this.rightlegs.field_70121_D.func_72314_b((double)24.0F, (double)1.0F, (double)24.0F)));
            }

            if (this.animTick == 420) {
                this.isStunned = false;
            } else {
                this.func_70624_b((EntityLivingBase)null);
            }
        }

        if (this.animID == 8) {
            if (this.animTick == 58) {
                this.func_85030_a("thetitans:largeFall", 8.0F, 0.9F);
                this.func_85030_a("thetitans:titanFall", 10.0F, 1.0F);
            }

            if (this.animTick == 60) {
                this.func_85030_a("thetitans:distantLargeFall", 10000.0F, 1.0F);
            }

            if (this.animTick == 420) {
                this.isStunned = false;
            } else {
                this.func_70624_b((EntityLivingBase)null);
            }
        }

        if (this.isStunned) {
            this.func_70624_b((EntityLivingBase)null);
            AnimationAPI.sendAnimPacket(this, 8);
        }

        if (this.field_70173_aa > 5) {
            float f = this.field_70761_aq * (float)Math.PI / 180.0F;
            float f1 = MathHelper.func_76126_a(f);
            float f2 = MathHelper.func_76134_b(f);
            this.head.func_70012_b(this.field_70165_t - (double)(MathHelper.func_76126_a(this.field_70759_as * (float)Math.PI / 180.0F) * 7.0F * (this instanceof EntityCaveSpiderTitan ? 0.7F : 1.0F)), this.field_70163_u + (this.animID == 8 ? (double)0.0F : (double)5.0F) * (double)(this instanceof EntityCaveSpiderTitan ? 0.7F : 1.0F) - (double)(MathHelper.func_76126_a(this.field_70125_A * (float)Math.PI / 180.0F) * 4.0F * (this instanceof EntityCaveSpiderTitan ? 0.7F : 1.0F)), this.field_70161_v + (double)(MathHelper.func_76134_b(this.field_70759_as * (float)Math.PI / 180.0F) * 7.0F * (this instanceof EntityCaveSpiderTitan ? 0.7F : 1.0F)), 0.0F, 0.0F);
            this.thorax.func_70012_b(this.field_70165_t, this.field_70163_u + (this.animID == 8 ? (double)1.0F : (double)6.25F) * (double)(this instanceof EntityCaveSpiderTitan ? 0.7F : 1.0F), this.field_70161_v, 0.0F, 0.0F);
            this.abdomen.func_70012_b(this.field_70165_t + (double)(f1 * 9.0F * (this instanceof EntityCaveSpiderTitan ? 0.7F : 1.0F)), this.field_70163_u + (this.animID == 8 ? (double)1.0F : (double)5.0F) * (double)(this instanceof EntityCaveSpiderTitan ? 0.7F : 1.0F), this.field_70161_v - (double)(f2 * 9.0F * (this instanceof EntityCaveSpiderTitan ? 0.7F : 1.0F)), 0.0F, 0.0F);
            this.rightlegs.func_70012_b(this.field_70165_t + (double)(f2 * 10.0F * (this instanceof EntityCaveSpiderTitan ? 0.7F : 1.0F)), this.field_70163_u, this.field_70161_v + (double)(f1 * 10.0F * (this instanceof EntityCaveSpiderTitan ? 0.7F : 1.0F)), 0.0F, 0.0F);
            this.leftlegs.func_70012_b(this.field_70165_t - (double)(f2 * 10.0F * (this instanceof EntityCaveSpiderTitan ? 0.7F : 1.0F)), this.field_70163_u, this.field_70161_v - (double)(f1 * 10.0F * (this instanceof EntityCaveSpiderTitan ? 0.7F : 1.0F)), 0.0F, 0.0F);
            if (this.func_70089_S() && !this.isStunned) {
                this.collideWithEntities(this.rightlegs, this.field_70170_p.func_72839_b(this, this.rightlegs.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.leftlegs, this.field_70170_p.func_72839_b(this, this.leftlegs.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.head, this.field_70170_p.func_72839_b(this, this.head.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.thorax, this.field_70170_p.func_72839_b(this, this.thorax.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.abdomen, this.field_70170_p.func_72839_b(this, this.abdomen.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                if (this.isArmored()) {
                    this.collideWithEntities(this.rightlegs, this.field_70170_p.func_72839_b(this, this.rightlegs.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                    this.collideWithEntities(this.leftlegs, this.field_70170_p.func_72839_b(this, this.leftlegs.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                    this.collideWithEntities(this.rightlegs, this.field_70170_p.func_72839_b(this, this.rightlegs.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                    this.collideWithEntities(this.leftlegs, this.field_70170_p.func_72839_b(this, this.leftlegs.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                    this.collideWithEntities(this.rightlegs, this.field_70170_p.func_72839_b(this, this.rightlegs.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                    this.collideWithEntities(this.leftlegs, this.field_70170_p.func_72839_b(this, this.leftlegs.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                }
            }

            this.destroyBlocksInAABB(this.head.field_70121_D);
            this.destroyBlocksInAABB(this.thorax.field_70121_D);
            this.destroyBlocksInAABB(this.abdomen.field_70121_D);
            this.destroyBlocksInAABB(this.rightlegs.field_70121_D);
            this.destroyBlocksInAABB(this.leftlegs.field_70121_D);

            for(int i = 0; i < this.partArray.length; ++i) {
                if (this.getBonusID() > 0) {
                    double red = 0.4862745098039216;
                    double green = 0.6862745098039216;
                    double blue = 0.7764705882352941;
                    if (this.getBonusID() == 2) {
                        red = 0.5764705882352941;
                        green = 0.1411764705882353;
                        blue = 0.1372549019607843;
                    }

                    if (this.getBonusID() == 3) {
                        red = 0.803921568627451;
                        green = 0.3607843137254902;
                        blue = 0.6705882352941176;
                    }

                    if (this.getBonusID() == 4) {
                        red = 0.4980392156862745;
                        green = 0.5137254901960784;
                        blue = 0.5764705882352941;
                    }

                    for(int i1 = 0; i1 < 50; ++i1) {
                        this.field_70170_p.func_72869_a("mobSpell", this.partArray[i].field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.partArray[i].field_70130_N, this.partArray[i].field_70163_u + this.field_70146_Z.nextDouble() * (double)this.partArray[i].field_70131_O, this.partArray[i].field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.partArray[i].field_70130_N, red, green, blue);
                    }
                }

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

                        if (entity instanceof EntityWebShot && entity.field_70173_aa > 25 && ((EntityWebShot)entity).field_70235_a != this) {
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

        if (!AnimationAPI.isEffectiveClient() && this.func_70638_az() != null && !this.isStunned && this.getAnimID() == 0) {
            double d0 = this.func_70068_e(this.func_70638_az());
            if (d0 < this.getMeleeRange()) {
                if (this.getAnimID() == 0) {
                    if (!(this.func_70638_az() instanceof EntityTitan) && !(this.func_70638_az().field_70131_O >= 6.0F) && !(this.field_70163_u + (double)this.func_70047_e() < this.func_70638_az().field_70163_u + (double)this.func_70638_az().func_70047_e())) {
                        switch (this.field_70146_Z.nextInt(4)) {
                            case 0:
                                AnimationAPI.sendAnimPacket(this, 3);
                                this.setAnimID(3);
                                break;
                            case 1:
                                AnimationAPI.sendAnimPacket(this, 9);
                                this.setAnimID(9);
                                break;
                            case 2:
                                AnimationAPI.sendAnimPacket(this, 5);
                                this.setAnimID(5);
                                break;
                            case 3:
                                AnimationAPI.sendAnimPacket(this, 6);
                                this.setAnimID(6);
                        }
                    } else {
                        AnimationAPI.sendAnimPacket(this, 1);
                        this.setAnimID(1);
                    }
                }
            } else if (this.getAnimID() == 0 && this.func_70681_au().nextInt(100) == 0) {
                switch (this.field_70146_Z.nextInt(3)) {
                    case 0:
                        AnimationAPI.sendAnimPacket(this, 2);
                        this.setAnimID(2);
                        break;
                    case 1:
                        AnimationAPI.sendAnimPacket(this, 7);
                        this.setAnimID(7);
                        break;
                    case 2:
                        AnimationAPI.sendAnimPacket(this, 6);
                        this.setAnimID(6);
                }
            }
        }

        if (this.animID == 1 && this.animTick == 1) {
            this.antiTitanAttackAnimeID = this.func_70681_au().nextInt(4);
        }

        if (this.field_70146_Z.nextInt(100) == 0 && this.func_70638_az() != null && !this.isStunned && this.field_70122_E && this.getAnimID() == 0) {
            this.func_70625_a(this.func_70638_az(), 180.0F, 180.0F);
            double d01 = this.func_70638_az().field_70165_t - this.field_70165_t;
            double d11 = this.func_70638_az().field_70161_v - this.field_70161_v;
            float f21 = MathHelper.func_76133_a(d01 * d01 + d11 * d11);
            double hor = (double)2.0F;
            double ver = (double)2.0F;
            this.field_70159_w = d01 / (double)f21 * hor * hor + this.field_70159_w * hor;
            this.field_70179_y = d11 / (double)f21 * hor * hor + this.field_70179_y * hor;
            this.field_70181_x = ver;
            this.collideWithEntities(this.rightlegs, this.field_70170_p.func_72839_b(this, this.rightlegs.field_70121_D.func_72314_b((double)6.0F, (double)6.0F, (double)6.0F)));
            this.collideWithEntities(this.leftlegs, this.field_70170_p.func_72839_b(this, this.leftlegs.field_70121_D.func_72314_b((double)6.0F, (double)6.0F, (double)6.0F)));
            this.collideWithEntities(this.rightlegs, this.field_70170_p.func_72839_b(this, this.rightlegs.field_70121_D.func_72314_b((double)6.0F, (double)6.0F, (double)6.0F)));
            this.collideWithEntities(this.leftlegs, this.field_70170_p.func_72839_b(this, this.leftlegs.field_70121_D.func_72314_b((double)6.0F, (double)6.0F, (double)6.0F)));
            this.collideWithEntities(this.rightlegs, this.field_70170_p.func_72839_b(this, this.rightlegs.field_70121_D.func_72314_b((double)6.0F, (double)6.0F, (double)6.0F)));
            this.collideWithEntities(this.leftlegs, this.field_70170_p.func_72839_b(this, this.leftlegs.field_70121_D.func_72314_b((double)6.0F, (double)6.0F, (double)6.0F)));
            if (this.func_70068_e(this.func_70638_az()) < (double)2000.0F) {
                float f11 = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                int i = this.getKnockbackAmount() * 2;
                this.attackChoosenEntity(this.func_70638_az(), f11, i);
            }
        }

        if (this.func_70638_az() != null && this.field_70146_Z.nextInt(60) == 0 && this.func_70685_l(this.func_70638_az())) {
            int i = MathHelper.func_76128_c(this.func_70638_az().field_70165_t + this.field_70146_Z.nextDouble() * (double)2.0F);
            int j = MathHelper.func_76128_c(this.func_70638_az().field_70163_u + this.field_70146_Z.nextDouble() * (double)2.0F);
            int k = MathHelper.func_76128_c(this.func_70638_az().field_70161_v + this.field_70146_Z.nextDouble() * (double)2.0F);
            Block block1 = this.field_70170_p.func_147439_a(i, j, k);
            if (block1.func_149688_o() == Material.field_151579_a && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                this.field_70170_p.func_147449_b(i, j, k, Blocks.field_150321_G);
            } else {
                this.func_70638_az().func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 100, 2));
            }
        }

        if (this instanceof EntityCaveSpiderTitan) {
            if (!this.getWaiting() && this.animID != 13 && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
                if (this.numMinions < this.getMinionCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                    EntityCaveSpiderMinion entitychicken = new EntityCaveSpiderMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70024_g((double)0.0F, (double)0.75F, (double)0.0F);
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
                }

                if (this.numPriests < this.getPriestCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                    EntityCaveSpiderMinion entitychicken = new EntityCaveSpiderMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70024_g((double)0.0F, (double)0.75F, (double)0.0F);
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
                }

                if (this.numZealots < this.getZealotCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                    EntityCaveSpiderMinion entitychicken = new EntityCaveSpiderMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70024_g((double)0.0F, (double)0.75F, (double)0.0F);
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
                }

                if (this.numBishop < this.getBishopCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                    EntityCaveSpiderMinion entitychicken = new EntityCaveSpiderMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70024_g((double)0.0F, (double)0.75F, (double)0.0F);
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
                }

                if (this.numTemplar < this.getTemplarCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                    EntityCaveSpiderMinion entitychicken = new EntityCaveSpiderMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70024_g((double)0.0F, (double)0.75F, (double)0.0F);
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
                }
            }

            this.func_94058_c(StatCollector.func_74838_a("entity.CaveSpiderTitan.name"));
            if (TheTitans.NightmareMode) {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)225.0F + (double)(this.getExtraPower() * 30));
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)24000.0F + (double)(this.getExtraPower() * 1600));
            } else {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)75.0F + (double)(this.getExtraPower() * 10));
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)12000.0F + (double)(this.getExtraPower() * 800));
            }

            this.func_70105_a(20.0F, 10.0F);
        } else {
            if (!this.getWaiting() && this.animID != 13 && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
                if (this.numMinions < this.getMinionCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                    EntitySpiderMinion entitychicken = new EntitySpiderMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70024_g((double)0.0F, (double)0.75F, (double)0.0F);
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

                    if (!(this instanceof EntityCaveSpiderTitan) && this.field_70153_n != null && this.field_70153_n instanceof EntitySkeletonTitan && this.field_70146_Z.nextInt(2) == 0) {
                        EntitySkeletonMinion entitychicken1 = new EntitySkeletonMinion(this.field_70170_p);
                        entitychicken1.func_70012_b(entitychicken.field_70165_t, entitychicken.field_70163_u, entitychicken.field_70161_v, entitychicken.field_70177_z, 0.0F);
                        this.field_70170_p.func_72838_d(entitychicken1);
                        entitychicken1.func_110161_a((IEntityLivingData)null);
                        entitychicken1.func_70078_a(entitychicken);
                        entitychicken1.setMinionType(0);
                        if (((EntitySkeletonTitan)this.field_70153_n).getSkeletonType() == 1) {
                            entitychicken1.func_82201_a(1);
                            entitychicken1.func_70062_b(0, new ItemStack(Items.field_151052_q));
                            entitychicken1.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)4.0F);
                        }
                    }
                }

                if (this.numPriests < this.getPriestCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                    EntitySpiderMinion entitychicken = new EntitySpiderMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70024_g((double)0.0F, (double)0.75F, (double)0.0F);
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

                    if (this.field_70153_n != null && this.field_70153_n instanceof EntitySkeletonTitan && this.field_70146_Z.nextInt(2) == 0) {
                        EntitySkeletonMinion entitychicken1 = new EntitySkeletonMinion(this.field_70170_p);
                        entitychicken1.func_70012_b(entitychicken.field_70165_t, entitychicken.field_70163_u, entitychicken.field_70161_v, entitychicken.field_70177_z, 0.0F);
                        this.field_70170_p.func_72838_d(entitychicken1);
                        entitychicken1.func_110161_a((IEntityLivingData)null);
                        entitychicken1.func_70078_a(entitychicken);
                        entitychicken1.setMinionType(1);
                        if (((EntitySkeletonTitan)this.field_70153_n).getSkeletonType() == 1) {
                            entitychicken1.func_82201_a(1);
                            entitychicken1.func_70062_b(0, new ItemStack(Items.field_151052_q));
                            entitychicken1.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)4.0F);
                        }
                    }
                }

                if (this.numZealots < this.getZealotCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                    EntitySpiderMinion entitychicken = new EntitySpiderMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70024_g((double)0.0F, (double)0.75F, (double)0.0F);
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

                    if (this.field_70153_n != null && this.field_70153_n instanceof EntitySkeletonTitan && this.field_70146_Z.nextInt(2) == 0) {
                        EntitySkeletonMinion entitychicken1 = new EntitySkeletonMinion(this.field_70170_p);
                        entitychicken1.func_70012_b(entitychicken.field_70165_t, entitychicken.field_70163_u, entitychicken.field_70161_v, entitychicken.field_70177_z, 0.0F);
                        this.field_70170_p.func_72838_d(entitychicken1);
                        entitychicken1.func_110161_a((IEntityLivingData)null);
                        entitychicken1.func_70078_a(entitychicken);
                        if (((EntitySkeletonTitan)this.field_70153_n).getSkeletonType() == 1) {
                            entitychicken1.func_82201_a(1);
                        }

                        entitychicken1.setMinionType(2);
                    }
                }

                if (this.numBishop < this.getBishopCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                    EntitySpiderMinion entitychicken = new EntitySpiderMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70024_g((double)0.0F, (double)0.75F, (double)0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(3);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                    Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v);
                    this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                    ++this.numTemplar;
                    if (block == Blocks.field_150349_c) {
                        this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                    }

                    if (this.field_70153_n != null && this.field_70153_n instanceof EntitySkeletonTitan && this.field_70146_Z.nextInt(2) == 0) {
                        EntitySkeletonMinion entitychicken1 = new EntitySkeletonMinion(this.field_70170_p);
                        entitychicken1.func_70012_b(entitychicken.field_70165_t, entitychicken.field_70163_u, entitychicken.field_70161_v, entitychicken.field_70177_z, 0.0F);
                        this.field_70170_p.func_72838_d(entitychicken1);
                        entitychicken1.func_110161_a((IEntityLivingData)null);
                        entitychicken1.func_70078_a(entitychicken);
                        if (((EntitySkeletonTitan)this.field_70153_n).getSkeletonType() == 1) {
                            entitychicken1.func_82201_a(1);
                            entitychicken1.func_70062_b(0, new ItemStack(Items.field_151052_q));
                            entitychicken1.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)4.0F);
                        }
                    }
                }

                if (this.numTemplar < this.getTemplarCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                    EntitySpiderMinion entitychicken = new EntitySpiderMinion(this.field_70170_p);
                    this.teleportEntityRandomly(entitychicken);
                    entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                    entitychicken.func_70024_g((double)0.0F, (double)0.75F, (double)0.0F);
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

                    if (this.field_70153_n != null && this.field_70153_n instanceof EntitySkeletonTitan && this.field_70146_Z.nextInt(2) == 0) {
                        EntitySkeletonMinion entitychicken1 = new EntitySkeletonMinion(this.field_70170_p);
                        entitychicken1.func_70012_b(entitychicken.field_70165_t, entitychicken.field_70163_u, entitychicken.field_70161_v, entitychicken.field_70177_z, 0.0F);
                        this.field_70170_p.func_72838_d(entitychicken1);
                        entitychicken1.func_110161_a((IEntityLivingData)null);
                        entitychicken1.func_70078_a(entitychicken);
                        if (((EntitySkeletonTitan)this.field_70153_n).getSkeletonType() == 1) {
                            entitychicken1.func_82201_a(1);
                            entitychicken1.func_70062_b(0, new ItemStack(Items.field_151052_q));
                            entitychicken1.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)4.0F);
                        }
                    }
                }
            }

            this.func_94058_c(StatCollector.func_74838_a("entity.SpiderTitan.name"));
            if (TheTitans.NightmareMode) {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)270.0F + (double)(this.getExtraPower() * 30));
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)32000.0F + (double)(this.getExtraPower() * 2000));
            } else {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)90.0F + (double)(this.getExtraPower() * 10));
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)16000.0F + (double)(this.getExtraPower() * 1000));
            }

            this.func_70105_a(28.0F, 14.0F);
        }

        if (this.getBonusID() > 4) {
            this.setBonusID(4);
        }

        if (this.getBonusID() < 0) {
            this.setBonusID(0);
        }

        super.func_70636_d();
    }

    protected Item func_146068_u() {
        return Items.field_151007_F;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            for(int x = 0; x < 8; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                entitylargefireball.func_70107_b(this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                ++entitylargefireball.field_70181_x;
                entitylargefireball.setXPCount(this instanceof EntityCaveSpiderTitan ? 3000 : 4000);
                this.field_70170_p.func_72838_d(entitylargefireball);
            }

            for(int l = 0; l < 256 + this.field_70146_Z.nextInt(256 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151007_F));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 32 + this.field_70146_Z.nextInt(32 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151044_h));
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

            for(int l = 0; l < 48 + this.field_70146_Z.nextInt(48 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151042_j));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 24 + this.field_70146_Z.nextInt(24 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150321_G));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 24 + this.field_70146_Z.nextInt(24 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150341_Y));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 36 + this.field_70146_Z.nextInt(36 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151116_aA));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 64 + this.field_70146_Z.nextInt(64 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151070_bp));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 24 + this.field_70146_Z.nextInt(24 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151071_bq));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 0 + this.field_70146_Z.nextInt(4 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(TitanItems.harcadiumNugget));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }
        }

    }

    public boolean func_70617_f_() {
        return this.isBesideClimbableBlock();
    }

    public void func_70110_aj() {
    }

    public EnumCreatureAttribute func_70668_bt() {
        return EnumCreatureAttribute.ARTHROPOD;
    }

    public boolean func_70687_e(PotionEffect p_70687_1_) {
        return p_70687_1_.func_76456_a() == Potion.field_76436_u.field_76415_H ? false : super.func_70687_e(p_70687_1_);
    }

    public boolean isBesideClimbableBlock() {
        return (this.field_70180_af.func_75683_a(16) & 1) != 0;
    }

    public void setBesideClimbableBlock(boolean p_70839_1_) {
        byte b0 = this.field_70180_af.func_75683_a(16);
        if (p_70839_1_) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.field_70180_af.func_75692_b(16, b0);
    }

    public IEntityLivingData func_110161_a(IEntityLivingData p_180482_2_) {
        Object p_180482_2_1 = super.func_110161_a(p_180482_2_);
        this.setWaiting(true);
        if (this.field_70170_p.field_73012_v.nextInt(10) == 0 || TheTitans.NightmareMode) {
            this.setBonusID(this.field_70146_Z.nextInt(5));
        }

        return (IEntityLivingData)p_180482_2_1;
    }

    public float func_70047_e() {
        return 10.4F;
    }

    protected void func_70619_bc() {
        List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D);
        if (list11 != null && !list11.isEmpty()) {
            for(int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (entity instanceof EntityLivingBase && entity.field_70122_E && !(entity instanceof EntityTitan)) {
                    float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                    entity.func_70097_a(DamageSourceExtra.causeSquishingDamage(this), f / 2.0F);
                }
            }
        }

        if (this.getBonusID() == 2) {
            this.func_70691_i(2.0F);

            for(int u = 0; u < 1 + this.field_70146_Z.nextInt(10); ++u) {
                this.func_70691_i(2.0F);
            }
        }

        super.func_70619_bc();
    }

    public StatBase getAchievement() {
        if (this instanceof EntityCaveSpiderTitan) {
            return TitansAchievments.cavespidertitan;
        } else {
            return this.field_70153_n != null && this.field_70153_n instanceof EntitySkeletonTitan ? TitansAchievments.spiderjockeytitan : TitansAchievments.spidertitan;
        }
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
        this.setTitanHealth(0.0F);
        this.func_70606_j(0.0F);
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
            float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 12.0F;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 24.0F;
            this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + (double)2.0F + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
        }

        if (this.getInvulTime() >= this.getThreashHold()) {
            this.func_70106_y();
        }

    }

    protected void inactDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            this.func_85030_a("mob.spider.death", this.func_70599_aP(), this.func_70647_i());
            if (this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
                this.func_70628_a(true, 0);
                this.func_82160_b(true, 0);
                this.func_70600_l(1);
            }

            if (this instanceof EntityCaveSpiderTitan) {
                EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.field_70170_p);
                entitytitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                this.field_70170_p.func_72838_d(entitytitan);
                entitytitan.setVesselHunting(false);
                entitytitan.setSpiritType(2);
            } else {
                EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.field_70170_p);
                entitytitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                this.field_70170_p.func_72838_d(entitytitan);
                entitytitan.setVesselHunting(false);
                entitytitan.setSpiritType(3);
            }
        }

    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (this.isArmored()) {
            amount /= 2.0F;
        }

        if (this.func_85032_ar()) {
            return false;
        } else if (!this.isStunned && source.func_76346_g() instanceof EntityPlayer) {
            return false;
        } else {
            if (this instanceof EntityCaveSpiderTitan) {
                if (source.func_76346_g() instanceof EntityCaveSpiderMinion || source.func_76346_g() instanceof EntityCaveSpiderTitan) {
                    return false;
                }
            } else if (source.func_76346_g() instanceof EntitySpiderMinion || source.func_76346_g() instanceof EntitySpiderTitan && !(source.func_76346_g() instanceof EntityCaveSpiderTitan)) {
                return false;
            }

            return super.func_70097_a(source, amount);
        }
    }

    public boolean attackEntityFromPart(EntityTitanPart p_70965_1_, DamageSource source, float amount) {
        if (p_70965_1_ == this.head) {
            amount *= 2.0F;
        }

        if (source.func_76346_g() != null && source.func_76346_g() instanceof EntityPlayer && source.func_76357_e() && this.damageToLegs < 8 && !this.isStunned && (p_70965_1_ == this.leftlegs || p_70965_1_ == this.rightlegs)) {
            ++this.damageToLegs;
            this.func_70097_a((new DamageSource("other")).func_76348_h().func_151518_m(), 100.0F);
            this.func_70624_b((EntityLivingBase)source.func_76346_g());
            this.func_70604_c((EntityLivingBase)source.func_76346_g());
            if (this.damageToLegs >= 8) {
                this.func_85030_a(this.func_70673_aS(), this.func_70599_aP(), this.func_70647_i());
                this.isStunned = true;
                this.damageToLegs = 0;
            }
        }

        this.func_82195_e(source, amount);
        return true;
    }

    protected boolean func_82195_e(DamageSource p_82195_1_, float p_82195_2_) {
        return this.func_70097_a(p_82195_1_, p_82195_2_);
    }

    public World func_82194_d() {
        return this.field_70170_p;
    }
}
