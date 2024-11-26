//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusAntiTitanAttack;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusAttack1;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusAttack2;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusAttack3;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusChainLightning;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusDeath;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusDragonLightningBall;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusLightningAttack;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusLightningBall;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusMeteorRain;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusScream;
import net.minecraft.entity.titan.animation.endercolossus.AnimationEnderColossusStun;
import net.minecraft.entity.titanminion.EntityDragonMinion;
import net.minecraft.entity.titanminion.EntityEndermanMinion;
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
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraftforge.common.ForgeHooks;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityEnderColossus extends EntityTitan implements IAnimatedEntity, IEntityMultiPartTitan {
    private int roarcooldownTimer;
    public boolean isRevealed;
    public EntityEnderColossusCrystal healingEnderCrystal;
    public int numOfCrystals;
    public int maxNumOfCrystals = 20;
    public EntityTitanPart[] partArray;
    public EntityTitanPart head;
    public EntityTitanPart body;
    public EntityTitanPart rightEye;
    public EntityTitanPart leftEye;
    public EntityTitanPart rightArm;
    public EntityTitanPart leftArm;
    public EntityTitanPart rightLeg;
    public EntityTitanPart leftLeg;
    public boolean isStunned;
    public int destroyedCrystals;

    public EntityEnderColossus(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 12.0F, 12.0F);
        this.body = new EntityTitanPart(worldIn, this, "body", 10.0F, 18.0F);
        this.rightEye = new EntityTitanPart(worldIn, this, "righteye", 3.0F, 2.0F);
        this.leftEye = new EntityTitanPart(worldIn, this, "lefteye", 3.0F, 2.0F);
        this.rightArm = new EntityTitanPart(worldIn, this, "rightarm", 4.0F, 4.0F);
        this.leftArm = new EntityTitanPart(worldIn, this, "leftarm", 4.0F, 4.0F);
        this.rightLeg = new EntityTitanPart(worldIn, this, "rightleg", 4.0F, 42.0F);
        this.leftLeg = new EntityTitanPart(worldIn, this, "leftleg", 4.0F, 42.0F);
        this.maxNumOfCrystals = 20;
        this.partArray = new EntityTitanPart[]{this.head, this.body, this.rightEye, this.leftEye, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg};
        this.func_70105_a(12.0F, 72.0F);
        this.field_70728_aV = 1000000;
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        worldIn.func_72838_d(this.head);
        worldIn.func_72838_d(this.body);
        worldIn.func_72838_d(this.rightArm);
        worldIn.func_72838_d(this.leftArm);
        worldIn.func_72838_d(this.rightLeg);
        worldIn.func_72838_d(this.leftLeg);
        worldIn.func_72838_d(this.rightEye);
        worldIn.func_72838_d(this.leftEye);
    }

    protected void applyEntityAI() {
        this.field_70714_bg.func_75776_a(1, new AnimationEnderColossusDeath(this));
        this.field_70714_bg.func_75776_a(1, new AnimationEnderColossusStun(this));
        this.field_70714_bg.func_75776_a(1, new AnimationEnderColossusScream(this));
        this.field_70714_bg.func_75776_a(1, new AnimationEnderColossusDragonLightningBall(this));
        this.field_70714_bg.func_75776_a(1, new AnimationEnderColossusChainLightning(this));
        this.field_70714_bg.func_75776_a(1, new AnimationEnderColossusLightningBall(this));
        this.field_70714_bg.func_75776_a(1, new AnimationEnderColossusLightningAttack(this));
        this.field_70714_bg.func_75776_a(1, new AnimationEnderColossusAntiTitanAttack(this));
        this.field_70714_bg.func_75776_a(1, new AnimationEnderColossusMeteorRain(this));
        this.field_70714_bg.func_75776_a(1, new AnimationEnderColossusAttack2(this));
        this.field_70714_bg.func_75776_a(1, new AnimationEnderColossusAttack3(this));
        this.field_70714_bg.func_75776_a(1, new AnimationEnderColossusAttack1(this));
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.EnderColossusSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

    }

    public int getEyeLaserTime() {
        return this.field_70180_af.func_75679_c(25);
    }

    public void setEyeLaserTime(int p_82215_1_) {
        this.field_70180_af.func_75692_b(25, p_82215_1_);
    }

    public boolean alreadyHasAName() {
        return this.isRevealed;
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
        return 30;
    }

    public int getTemplarCap() {
        return 20;
    }

    public int getSpecialMinionCap() {
        return 10;
    }

    public int func_70627_aG() {
        return 100;
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        this.isRevealed = tagCompund.func_74767_n("Musmu");
        this.setEyeLaserTime(tagCompund.func_74762_e("ShootTimer"));
        this.setCanCallBackUp(tagCompund.func_74767_n("CallHelp"));
        if (tagCompund.func_150297_b("DestroyedCrystals", 99)) {
            this.destroyedCrystals = tagCompund.func_74762_e("DestroyedCrystals");
        }

        this.isStunned = tagCompund.func_74767_n("Stunned");
    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        tagCompound.func_74768_a("ShootTimer", this.getEyeLaserTime());
        tagCompound.func_74757_a("CallHelp", this.getCanCallBackUp());
        tagCompound.func_74757_a("Musmu", this.isRevealed);
        tagCompound.func_74768_a("DestroyedCrystals", this.destroyedCrystals);
        tagCompound.func_74757_a("Stunned", this.isStunned);
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != this.head.getClass() && p_70686_1_ != this.body.getClass() && p_70686_1_ != this.rightEye.getClass() && p_70686_1_ != this.leftEye.getClass() && p_70686_1_ != this.rightArm.getClass() && p_70686_1_ != this.leftArm.getClass() && p_70686_1_ != this.rightLeg.getClass() && p_70686_1_ != this.leftLeg.getClass() && p_70686_1_ != EntityEnderman.class && p_70686_1_ != EntityEndermanMinion.class && p_70686_1_ != EntityEnderColossus.class && p_70686_1_ != EntityDragon.class && p_70686_1_ != EntityDragonMinion.class && p_70686_1_ != EntityEnderColossusCrystal.class;
    }

    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(500) == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }

    public int getMinionSpawnRate() {
        return TheTitans.EnderColossusMinionSpawnrate;
    }

    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.GREATER;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(18, new Byte((byte)0));
        this.field_70180_af.func_75682_a(19, new Byte((byte)0));
        this.field_70180_af.func_75682_a(25, new Integer(0));
    }

    public boolean getCanCallBackUp() {
        return this.field_70180_af.func_75683_a(19) == 1;
    }

    public void setCanCallBackUp(boolean p_82201_1_) {
        this.field_70180_af.func_75692_b(19, (byte)(p_82201_1_ ? 1 : 0));
    }

    public int getParticleCount() {
        return 60;
    }

    public String getParticles() {
        return "portal";
    }

    protected void func_70069_a(float p_70069_1_) {
        this.field_70122_E = true;
        this.field_70160_al = false;
        p_70069_1_ = ForgeHooks.onLivingFall(this, p_70069_1_);
        if (!(p_70069_1_ <= 0.0F)) {
            PotionEffect potioneffect = this.func_70660_b(Potion.field_76430_j);
            float f1 = potioneffect != null ? (float)(potioneffect.func_76458_c() + 1) : 0.0F;
            int i = MathHelper.func_76123_f(p_70069_1_ - 24.0F - f1);
            if (i > 0) {
                this.shakeNearbyPlayerCameras((double)400000.0F);
                this.func_85030_a("thetitans:groundSmash", 20.0F, 0.9F);
                this.func_85030_a("thetitans:titanland", 10000.0F, 1.0F);
                this.destroyBlocksInAABBTopless(this.field_70121_D.func_72314_b((double)24.0F, (double)1.0F, (double)24.0F));
                List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)48.0F, (double)4.0F, (double)48.0F));
                if (list11 != null && !list11.isEmpty()) {
                    for(int i1 = 0; i1 < list11.size(); ++i1) {
                        Entity entity = (Entity)list11.get(i1);
                        if (entity instanceof EntityLivingBase && !(entity instanceof EntityDragonPart) && this.func_70686_a(entity.getClass()) && !(entity instanceof EntityTitan)) {
                            float smash = 100.0F - this.func_70032_d(entity);
                            if (smash <= 1.0F) {
                                smash = 1.0F;
                            }

                            entity.func_70097_a(DamageSource.func_76358_a(this), smash * 4.0F);
                            double d0 = this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d;
                            double d1 = this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f;
                            double d2 = entity.field_70165_t - d0;
                            double d3 = entity.field_70161_v - d1;
                            double d4 = d2 * d2 + d3 * d3;
                            entity.func_70024_g(d2 / d4 * (double)8.0F, (double)1.0F, d3 / d4 * (double)8.0F);
                        }
                    }
                }
            }

        }
    }

    protected void func_70076_C() {
        this.func_85030_a("mob.endermen.portal", 100.0F, 0.6F);
        if (!(this.field_70170_p.field_73011_w instanceof WorldProviderEnd) && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
            if (!(this.field_70170_p.field_73011_w instanceof WorldProviderEnd) && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
                this.func_70107_b(this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)48.0F, (double)128.0F, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)48.0F);
            }
        } else {
            this.func_70107_b((double)0.0F, (double)128.0F, (double)0.0F);
        }

    }

    protected int func_70682_h(int p_70682_1_) {
        return p_70682_1_;
    }

    protected Entity findPlayerToLookAt() {
        EntityPlayer entityplayer = this.field_70170_p.func_72890_a(this, (double)-1.0F);
        if (entityplayer != null && !this.field_70170_p.field_72995_K && entityplayer.func_70089_S() && this.func_70089_S() && (this.isPlayerRegistered(entityplayer, this.rightEye) || this.isPlayerRegistered(entityplayer, this.leftEye)) && entityplayer.func_70089_S()) {
            this.func_70671_ap().func_75651_a(entityplayer, 180.0F, 30.0F);
            this.func_70624_b(entityplayer);
            if (entityplayer.func_70694_bm() != null && entityplayer.func_70694_bm().func_77973_b() == TitanItems.ultimaBlade) {
                this.func_70097_a(DamageSourceExtra.causeArmorPiercingMobDamage(entityplayer), 600.0F);
            } else {
                this.attackChoosenEntity(entityplayer, 20.0F, 100);
                entityplayer.field_70181_x = (double)1.0F;
                entityplayer.func_70690_d(new PotionEffect(Potion.field_76431_k.field_76415_H, 400, 1));
                entityplayer.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 400, 99));
                entityplayer.func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 400, 1));
                this.func_70624_b(entityplayer);
                this.field_70170_p.func_72885_a(this, entityplayer.field_70165_t, entityplayer.field_70163_u, entityplayer.field_70161_v, 8.0F, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                this.func_85030_a("thetitans:titanEnderColossusStare", Float.MAX_VALUE, 1.0F);
            }
        }

        return null;
    }

    protected boolean isPlayerRegistered(EntityPlayer p_70821_1_, EntityTitanPart part) {
        Vec3 vec3 = p_70821_1_.func_70676_i(1.0F).func_72432_b();
        Vec3 vec31 = Vec3.func_72443_a(part.field_70165_t + (this.field_70146_Z.nextDouble() * (double)part.field_70130_N - (double)part.field_70130_N * (double)0.5F) - p_70821_1_.field_70165_t, part.field_70121_D.field_72338_b + this.field_70146_Z.nextDouble() * (double)part.field_70131_O - (p_70821_1_.field_70163_u + (double)p_70821_1_.func_70047_e()), part.field_70161_v + (this.field_70146_Z.nextDouble() * (double)part.field_70130_N - (double)part.field_70130_N * (double)0.5F) - p_70821_1_.field_70161_v);
        double d0 = vec31.func_72433_c();
        vec31 = vec31.func_72432_b();
        double d1 = vec3.func_72430_b(vec31);
        return d1 > (double)1.0F - 0.025 / d0 ? p_70821_1_.func_70685_l(this) : false;
    }

    public boolean canBeHurtByPlayer() {
        return this.isStunned && this.animID != 5 && !this.func_85032_ar();
    }

    public double getSpeed() {
        return 0.4 + (double)this.getExtraPower() * 0.001;
    }

    public boolean shouldMove() {
        return this.animID == 0 && !this.isStunned && this.func_70638_az() != null ? super.shouldMove() : false;
    }

    public boolean func_70652_k(Entity p_70652_1_) {
        return false;
    }

    public double getMeleeRange() {
        return (double)(this.field_70130_N * this.field_70130_N + (this.func_70638_az().field_70130_N > 48.0F ? 2304.0F : this.func_70638_az().field_70130_N * this.func_70638_az().field_70130_N)) + (double)2000.0F;
    }

    public int func_70646_bf() {
        return this.getEyeLaserTime() >= 0 ? 180 : 40;
    }

    public void func_70636_d() {
        this.setEyeLaserTime(this.getEyeLaserTime() - 1);
        if (this.func_70638_az() != null && this.getEyeLaserTime() <= -400 && this.animID == 0 && !this.isStunned && !this.getWaiting() && this.field_70146_Z.nextInt(40) == 0) {
            this.setEyeLaserTime(200);
        }

        if (!this.field_70170_p.field_72995_K && this.func_70638_az() != null && this.func_70638_az() instanceof EntityWitherzilla && this.getCanCallBackUp()) {
            for(int i = 0; i < 24; ++i) {
                EntityEnderColossus entitylargefireball = new EntityEnderColossus(this.field_70170_p);
                entitylargefireball.setWaiting(false);
                entitylargefireball.func_82149_j(this);
                entitylargefireball.func_70624_b(this.func_70638_az());
                this.field_70170_p.func_72838_d(entitylargefireball);
                this.func_85030_a(this.getRoarSound(), this.func_70599_aP(), this.func_70647_i());
            }

            this.setCanCallBackUp(false);
        }

        if (this.destroyedCrystals < 0) {
            this.destroyedCrystals = 0;
        }

        if (this.destroyedCrystals > 12) {
            this.destroyedCrystals = 0;
            this.isStunned = true;
        }

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
                float f = (this.field_70146_Z.nextFloat() - 0.5F) * 16.0F;
                float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 5.0F;
                float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 16.0F;
                this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + (double)15.0F + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
            }
        }

        EntityPlayer player = this.field_70170_p.func_72890_a(this, (double)-1.0F);
        if (player != null && this.func_70638_az() != null && player == this.func_70638_az()) {
            if (this.field_70146_Z.nextInt(200) == 0 && this.func_110143_aJ() <= this.func_110138_aP() / 100.0F) {
                player.func_70097_a(DamageSourceExtra.mindCrush, Float.MAX_VALUE);
            }

            if (player.func_110139_bj() <= 0.0F && this.field_70173_aa % 5 == 0) {
                player.field_70172_ad = 0;
                player.func_70097_a(DamageSourceExtra.mindCrush, 12.0F);
                player.func_70690_d(new PotionEffect(Potion.field_76431_k.field_76415_H, 400, 1));
                if (player.func_110143_aJ() <= 15.0F) {
                    player.field_70181_x = (double)1.0F;
                    player.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 400, 9));
                }

                if (player.func_110143_aJ() <= 5.0F) {
                    player.func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 400, 1));
                }
            } else if (player.func_110139_bj() >= 0.0F && this.field_70173_aa % 20 == 0) {
                player.func_70097_a(DamageSourceExtra.mindCrush, 12.0F);
            }
        }

        if (this.animID == 10) {
            if (this.animTick == 30 || this.animTick == 70) {
                this.func_145780_a(0, 0, 0, Blocks.field_150348_b);
            }

            if (this.animTick == 150 || this.animTick == 230) {
                this.func_85030_a("thetitans:titanFall", 20.0F, 1.0F);
                this.func_85030_a("thetitans:groundSmash", 20.0F, 1.0F);
                this.shakeNearbyPlayerCameras((double)10000.0F);
                this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
                this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
                this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
                this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
                this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
                this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
                this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
                this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
            }

            if (this.animTick == 240) {
                this.func_85030_a("thetitans:distantLargeFall", 10000.0F, 1.0F);
            }
        }

        if (this.field_70173_aa % 120 == 0 && this.func_70089_S()) {
            this.func_85030_a("thetitans:titanEnderColossusLiving", this.func_70599_aP(), this.func_70647_i());
        }

        if (this.numOfCrystals < 0) {
            this.numOfCrystals = 0;
        }

        for(int i = 0; i < this.getParticleCount() * 5; ++i) {
            this.findPlayerToLookAt();
            this.field_70170_p.func_72869_a(this.getParticles(), this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N * (double)3.0F, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N * (double)3.0F, (double)0.0F, (double)0.25F, (double)0.0F);
        }

        if (this.field_70173_aa > 5) {
            float f = this.field_70761_aq * (float)Math.PI / 180.0F;
            float f1 = MathHelper.func_76126_a(f);
            float f2 = MathHelper.func_76134_b(f);
            this.head.func_70012_b(this.field_70165_t, this.field_70163_u + (double)60.0F, this.field_70161_v, 0.0F, 0.0F);
            this.body.func_70012_b(this.field_70165_t, this.field_70163_u + (double)42.0F, this.field_70161_v, 0.0F, 0.0F);
            this.rightEye.func_70012_b(this.field_70165_t + (double)(MathHelper.func_76134_b(this.field_70759_as * (float)Math.PI / 180.0F) * 4.0F) - (double)(MathHelper.func_76126_a(this.field_70759_as * (float)Math.PI / 180.0F) * 7.0F), this.field_70163_u + (double)this.func_70047_e() - (double)1.0F, this.field_70161_v + (double)(MathHelper.func_76126_a(this.field_70759_as * (float)Math.PI / 180.0F) * 4.0F) + (double)(MathHelper.func_76134_b(this.field_70759_as * (float)Math.PI / 180.0F) * 8.0F), 0.0F, 0.0F);
            this.leftEye.func_70012_b(this.field_70165_t - (double)(MathHelper.func_76134_b(this.field_70759_as * (float)Math.PI / 180.0F) * 4.0F) - (double)(MathHelper.func_76126_a(this.field_70759_as * (float)Math.PI / 180.0F) * 7.0F), this.field_70163_u + (double)this.func_70047_e() - (double)1.0F, this.field_70161_v - (double)(MathHelper.func_76126_a(this.field_70759_as * (float)Math.PI / 180.0F) * 4.0F) + (double)(MathHelper.func_76134_b(this.field_70759_as * (float)Math.PI / 180.0F) * 8.0F), 0.0F, 0.0F);
            this.rightArm.func_70012_b(this.field_70165_t + (double)(f2 * 8.0F), this.field_70163_u + (double)56.0F, this.field_70161_v + (double)(f1 * 8.0F), 0.0F, 0.0F);
            this.leftArm.func_70012_b(this.field_70165_t - (double)(f2 * 8.0F), this.field_70163_u + (double)56.0F, this.field_70161_v - (double)(f1 * 8.0F), 0.0F, 0.0F);
            this.rightLeg.func_70012_b(this.field_70165_t + (double)(f2 * 3.0F), this.field_70163_u, this.field_70161_v + (double)(f1 * 3.0F), 0.0F, 0.0F);
            this.leftLeg.func_70012_b(this.field_70165_t - (double)(f2 * 3.0F), this.field_70163_u, this.field_70161_v - (double)(f1 * 3.0F), 0.0F, 0.0F);
            this.head.field_70131_O = this.isScreaming() ? 22.0F : 12.0F;
            this.head.field_70130_N = 12.0F;
            this.body.field_70131_O = 18.0F;
            this.body.field_70130_N = 10.0F;
            this.rightEye.field_70131_O = this.leftEye.field_70131_O = 2.0F;
            this.rightEye.field_70130_N = this.leftEye.field_70130_N = 3.0F;
            this.leftLeg.field_70131_O = this.rightLeg.field_70131_O = 42.0F;
            this.leftLeg.field_70130_N = this.rightLeg.field_70130_N = 4.0F;
            this.rightArm.field_70130_N = this.leftArm.field_70130_N = this.rightArm.field_70131_O = this.leftArm.field_70131_O = 4.0F;
            this.rightEye.field_70177_z = this.field_70759_as;
            this.leftEye.field_70177_z = this.field_70759_as;
            this.rightEye.field_70125_A = this.field_70125_A;
            this.leftEye.field_70125_A = this.field_70125_A;
            if (!this.field_70170_p.field_72995_K && this.func_70089_S()) {
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

        float fl = this.func_70013_c(1.0F);
        if (fl > 0.5F && !this.field_70170_p.field_73011_w.field_76576_e && this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K && this.field_70173_aa % 1 == 0) {
            this.field_70125_A = this.field_70759_as / 6.0F;
            this.field_70759_as = -90.0F;
        }

        this.meleeTitan = true;
        if (this.isStunned || this.deathTicks > 0) {
            this.field_70159_w *= (double)0.0F;
            this.field_70179_y *= (double)0.0F;
        }

        for(int i = 0; i < 3; ++i) {
            if (this.getAnimID() == 2 && this.getAnimTick() >= 40 && this.getAnimTick() <= 80 && this.func_70638_az() != null && !this.field_70170_p.field_72995_K) {
                for(int it = 0; it < 2; ++it) {
                    double d2 = this.func_70638_az().field_70165_t + this.func_70681_au().nextGaussian() * (double)64.0F;
                    double d3 = this.func_70638_az().field_70163_u + (double)150.0F + this.func_70681_au().nextGaussian() * (double)32.0F;
                    double d4 = this.func_70638_az().field_70161_v + this.func_70681_au().nextGaussian() * (double)64.0F;
                    double d5 = this.func_70638_az().field_70165_t - d2;
                    double d6 = this.func_70638_az().field_70163_u - d3;
                    double d7 = this.func_70638_az().field_70161_v - d4;
                    EntityTitanFireball entitylargefireball1 = new EntityTitanFireball(this.field_70170_p, this, d5, d6, d7, 4);
                    entitylargefireball1.field_70165_t = d2;
                    entitylargefireball1.field_70163_u = d3;
                    entitylargefireball1.field_70161_v = d4;
                    this.field_70170_p.func_72838_d(entitylargefireball1);
                    entitylargefireball1.setFireballID(4);
                }
            }
        }

        if (this.getAnimID() == 3 && this.getAnimTick() == 20 || this.getAnimID() == 4 && this.getAnimTick() == 10 || this.getAnimID() == 11 && this.getAnimTick() == 10) {
            this.func_85030_a("thetitans:lightningCharge", 100.0F, 1.0F);
        }

        if (this.getAnimID() == 3 && this.getAnimTick() == 64) {
            this.func_85030_a("thetitans:lightningThrow", 100.0F, 1.0F);
            double d8 = (double)24.0F;
            Vec3 vec3 = this.func_70676_i(1.0F);
            double dx = vec3.field_72450_a * d8;
            double dz = vec3.field_72449_c * d8;
            float da = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
            int i1 = this.getKnockbackAmount();
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + (this.func_70631_g_() ? (double)9.0F : (double)18.0F), this.field_70161_v + dz, 1.0F, 0.0F, 1.0F));
            if (this.func_70638_az() != null) {
                this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 1.0F, 0.0F, 1.0F));
                this.attackChoosenEntity(this.func_70638_az(), da * 3.0F, i1);
                EntityLivingBase var10000 = this.func_70638_az();
                var10000.field_70181_x += (double)(1.0F + this.field_70146_Z.nextFloat());
                this.field_70170_p.func_72885_a(this, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 2.0F, false, false);
                this.field_70170_p.func_72885_a(this, this.field_70165_t + dx, this.field_70163_u + (double)26.0F, this.field_70161_v + dz, 1.0F, false, false);
                this.func_70638_az().func_70097_a(DamageSourceExtra.lightningBolt, da);
                List list1 = this.field_70170_p.func_72839_b(this.func_70638_az(), this.func_70638_az().field_70121_D.func_72314_b((double)4.0F, (double)4.0F, (double)4.0F));
                if (list1 != null && !list1.isEmpty()) {
                    for(int i11 = 0; i11 < list1.size(); ++i11) {
                        Entity entity1 = (Entity)list1.get(i11);
                        if (entity1 instanceof EntityLivingBase && this.func_70686_a(entity1.getClass())) {
                            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, entity1.field_70165_t, entity1.field_70163_u, entity1.field_70161_v, 1.0F, 0.0F, 1.0F));
                            this.attackChoosenEntity(entity1, da, 0);
                            if (!(entity1 instanceof EntityTitan)) {
                                entity1.field_70181_x += (double)(1.0F + this.field_70146_Z.nextFloat());
                            }

                            List list11 = this.field_70170_p.func_72839_b(entity1, entity1.field_70121_D.func_72314_b((double)4.0F, (double)4.0F, (double)4.0F));
                            if (list11 != null && !list11.isEmpty()) {
                                for(int i111 = 0; i111 < list11.size(); ++i111) {
                                    Entity entity11 = (Entity)list11.get(i111);
                                    if (entity11 != entity1 && entity11 instanceof EntityLivingBase && this.func_70686_a(entity11.getClass())) {
                                        this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, entity11.field_70165_t, entity11.field_70163_u, entity11.field_70161_v, 1.0F, 0.0F, 1.0F));
                                        this.attackChoosenEntity(entity11, da, 0);
                                        if (!(entity11 instanceof EntityTitan)) {
                                            entity11.field_70181_x += (double)(1.0F + this.field_70146_Z.nextFloat());
                                        }

                                        List list111 = this.field_70170_p.func_72839_b(entity11, entity11.field_70121_D.func_72314_b((double)4.0F, (double)4.0F, (double)4.0F));
                                        if (list111 != null && !list111.isEmpty()) {
                                            for(int i1111 = 0; i1111 < list111.size(); ++i1111) {
                                                Entity entity111 = (Entity)list111.get(i1111);
                                                if (entity111 != entity11 && entity111 instanceof EntityLivingBase && this.func_70686_a(entity111.getClass())) {
                                                    this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, entity111.field_70165_t, entity111.field_70163_u, entity111.field_70161_v, 1.0F, 0.0F, 1.0F));
                                                    this.attackChoosenEntity(entity111, da, 0);
                                                    if (!(entity111 instanceof EntityTitan)) {
                                                        entity111.field_70181_x += (double)(1.0F + this.field_70146_Z.nextFloat());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (this.getAnimID() == 4 && this.getAnimTick() == 50 && this.func_70638_az() != null) {
            this.func_85030_a("thetitans:lightningThrow", 100.0F, 1.0F);
            double d8 = (double)24.0F;
            Vec3 vec3 = this.func_70676_i(1.0F);
            double dx = vec3.field_72450_a * d8;
            double dz = vec3.field_72449_c * d8;
            this.field_70170_p.func_72885_a(this, this.field_70165_t + dx, this.field_70163_u + d8, this.field_70161_v + dz, 1.0F, false, false);
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + d8, this.field_70161_v + dz, 1.0F, 0.0F, 1.0F));
            this.field_70170_p.func_72885_a(this, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 2.0F, false, false);
            this.func_70638_az().func_70097_a(DamageSourceExtra.lightningBolt, 100.0F);
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 1.0F, 0.0F, 1.0F));
            double d5 = this.func_70638_az().field_70165_t - this.field_70165_t;
            double d6 = this.func_70638_az().field_70163_u - d8 - this.field_70163_u;
            double d7 = this.func_70638_az().field_70161_v - this.field_70161_v;
            EntityLightningBall entitylargefireball = new EntityLightningBall(this.field_70170_p, this, d5, d6, d7);
            entitylargefireball.field_70165_t = this.field_70165_t + vec3.field_72450_a * d8;
            entitylargefireball.field_70163_u = this.field_70163_u + d8;
            entitylargefireball.field_70161_v = this.field_70161_v + vec3.field_72449_c * d8;
            this.field_70170_p.func_72838_d(entitylargefireball);
        }

        if (this.getAnimID() == 11 && this.getAnimTick() == 50 && this.func_70638_az() != null && !this.field_70170_p.field_72995_K) {
            this.func_85030_a("thetitans:lightningThrow", 100.0F, 1.0F);
            double d8 = (double)24.0F;
            Vec3 vec3 = this.func_70676_i(1.0F);
            double dx = vec3.field_72450_a * d8;
            double dz = vec3.field_72449_c * d8;
            this.field_70170_p.func_72885_a(this, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 2.0F, false, false);
            this.field_70170_p.func_72885_a(this, this.field_70165_t + dx, this.field_70163_u + d8, this.field_70161_v + dz, 1.0F, false, false);
            this.func_70638_az().func_70097_a(DamageSourceExtra.lightningBolt, 100.0F);
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + d8, this.field_70161_v + dz, 1.0F, 0.0F, 1.0F));
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + d8, this.field_70161_v + dz, 1.0F, 0.0F, 1.0F));
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + d8, this.field_70161_v + dz, 1.0F, 0.0F, 1.0F));
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + d8, this.field_70161_v + dz, 1.0F, 0.0F, 1.0F));
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 1.0F, 0.0F, 1.0F));
            EntityDragonMinion entitychicken = new EntityDragonMinion(this.field_70170_p);
            entitychicken.forceNewTarget = false;
            entitychicken.targetX = this.func_70638_az().field_70165_t;
            entitychicken.targetY = this.func_70638_az().field_70163_u;
            entitychicken.targetZ = this.func_70638_az().field_70161_v;
            entitychicken.func_70012_b(this.field_70165_t + dx, this.field_70163_u + d8, this.field_70161_v + dz, this.field_70177_z, 0.0F);
            entitychicken.func_70024_g(vec3.field_72450_a * (double)10.0F, vec3.field_72448_b * (double)10.0F, vec3.field_72449_c * (double)10.0F);
            entitychicken.func_110161_a((IEntityLivingData)null);
            entitychicken.func_70624_b(this.func_70638_az());
            this.field_70170_p.func_72838_d(entitychicken);
            entitychicken.master = this;
            entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            ++this.numSpecialMinions;
        }

        if (this.getAnimID() == 13 && this.getAnimTick() == 50 && this.func_70638_az() != null && !this.field_70170_p.field_72995_K) {
            float da = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
            int i1 = this.getKnockbackAmount();
            this.attackChoosenEntity(this.func_70638_az(), da * 3.0F, i1);
            EntityLivingBase var118 = this.func_70638_az();
            var118.field_70181_x += (double)(1.0F + this.field_70146_Z.nextFloat());
            this.field_70170_p.func_72885_a(this, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 2.0F, false, false);
            this.func_70638_az().func_70097_a(DamageSourceExtra.lightningBolt, da);
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 1.0F, 0.0F, 1.0F));
            List list1 = this.field_70170_p.func_72839_b(this.func_70638_az(), this.func_70638_az().field_70121_D.func_72314_b((double)12.0F, (double)12.0F, (double)12.0F));
            if (list1 != null && !list1.isEmpty()) {
                for(int i11 = 0; i11 < list1.size(); ++i11) {
                    Entity entity1 = (Entity)list1.get(i11);
                    if (entity1 instanceof EntityLivingBase && this.func_70686_a(entity1.getClass())) {
                        this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, entity1.field_70165_t, entity1.field_70163_u, entity1.field_70161_v, 1.0F, 0.0F, 1.0F));
                        this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, entity1.field_70165_t, entity1.field_70163_u, entity1.field_70161_v, 1.0F, 0.0F, 1.0F));
                        this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, entity1.field_70165_t, entity1.field_70163_u, entity1.field_70161_v, 1.0F, 0.0F, 1.0F));
                        this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, entity1.field_70165_t, entity1.field_70163_u, entity1.field_70161_v, 1.0F, 0.0F, 1.0F));
                        this.attackChoosenEntity(entity1, da, 0);
                        if (!(entity1 instanceof EntityTitan)) {
                            entity1.field_70181_x += (double)(1.0F + this.field_70146_Z.nextFloat());
                        }
                    }
                }
            }
        }

        if (!AnimationAPI.isEffectiveClient() && this.getEyeLaserTime() < 0 && this.func_70638_az() != null && !this.isStunned && this.getAnimID() == 0) {
            double d0 = this.func_70068_e(this.func_70638_az());
            if (d0 < this.getMeleeRange()) {
                if (!(this.func_70638_az() instanceof EntityTitan) && !(this.func_70638_az().field_70131_O >= 6.0F) && !(this.func_70638_az().field_70163_u > this.field_70163_u + (double)6.0F)) {
                    switch (this.field_70146_Z.nextInt(3)) {
                        case 0:
                            AnimationAPI.sendAnimPacket(this, 6);
                            this.setAnimID(6);
                            break;
                        case 1:
                            AnimationAPI.sendAnimPacket(this, 7);
                            this.setAnimID(7);
                            break;
                        case 2:
                            AnimationAPI.sendAnimPacket(this, 9);
                            this.setAnimID(9);
                    }
                } else {
                    AnimationAPI.sendAnimPacket(this, 1);
                    this.setAnimID(1);
                    this.setAnimTick(0);
                }
            } else if (this.func_70681_au().nextInt(80) == 0) {
                switch (this.field_70146_Z.nextInt(6)) {
                    case 0:
                        AnimationAPI.sendAnimPacket(this, 4);
                        this.setAnimID(4);
                        break;
                    case 1:
                        if (this.field_70146_Z.nextInt(25) == 0) {
                            AnimationAPI.sendAnimPacket(this, 5);
                            this.setAnimID(5);
                        } else {
                            AnimationAPI.sendAnimPacket(this, 2);
                            this.setAnimID(2);
                        }
                        break;
                    case 2:
                        AnimationAPI.sendAnimPacket(this, 3);
                        this.setAnimID(3);
                        break;
                    case 3:
                        AnimationAPI.sendAnimPacket(this, 11);
                        this.setAnimID(11);
                        break;
                    case 4:
                        AnimationAPI.sendAnimPacket(this, 13);
                        this.setAnimID(13);
                        break;
                    case 5:
                        AnimationAPI.sendAnimPacket(this, 2);
                        this.setAnimID(2);
                }
            }
        }

        if (this.animID == 1) {
            if (this.animTick == 1) {
                this.antiTitanAttackAnimeID = this.func_70681_au().nextInt(4);
            }

            if (this.animTick == 4 && this.antiTitanAttackAnimeID == 0) {
                this.func_85030_a("thetitans:titanEnderColossusChomp", 100.0F, 1.0F);
            }
        }

        if (this.animID == 8) {
            if (this.animTick == 15) {
                this.field_70170_p.func_72908_a(this.head.field_70165_t, this.head.field_70163_u, this.head.field_70161_v, "random.explode", 10.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 0.7F);

                for(int i = 0; i < 50; ++i) {
                    this.field_70170_p.func_72869_a("largeexplode", this.head.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.head.field_70130_N, this.head.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.head.field_70131_O, this.head.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.head.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                    this.field_70170_p.func_72869_a("explode", this.head.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.head.field_70130_N, this.head.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.head.field_70131_O, this.head.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.head.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                }
            }

            if (this.animTick == 20) {
                this.func_85030_a("thetitans:titanEnderColossusScream", this.func_70599_aP(), 1.25F);
            }

            if (this.animTick == 90) {
                this.func_85030_a("thetitans:titanFall", 20.0F, 1.0F);
                this.func_85030_a("thetitans:groundSmash", 20.0F, 1.0F);
                this.shakeNearbyPlayerCameras((double)10000.0F);
                this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
                this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
                this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
                this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F)));
            }

            if (this.animTick >= 360) {
                this.isStunned = false;
            } else {
                this.func_70624_b((EntityLivingBase)null);
                this.isStunned = true;
            }
        }

        if (this.isStunned) {
            this.func_70624_b((EntityLivingBase)null);
            AnimationAPI.sendAnimPacket(this, 8);
        }

        if (TheTitans.NightmareMode) {
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)30000.0F + (double)(this.getExtraPower() * 3000));
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)600000.0F + (double)(this.getExtraPower() * 100000));
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)10000.0F + (double)(this.getExtraPower() * 1000));
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)300000.0F + (double)(this.getExtraPower() * '썐'));
        }

        if (this.field_70170_p.field_72995_K && this.isScreaming()) {
            this.func_70105_a(12.0F, 82.0F);
        } else if (this.field_70170_p.field_72995_K && !this.isScreaming()) {
            this.func_70105_a(12.0F, 72.0F);
        }

        if (this.func_70026_G() && !this.func_70090_H() && this.getAnimID() != 5) {
            AnimationAPI.sendAnimPacket(this, 5);
            this.setAnimID(5);
        }

        this.func_70062_b(0, new ItemStack(Blocks.field_150380_bt));
        if (this.isRevealed) {
            this.func_94058_c(StatCollector.func_74838_a("entity.EndermanTitan.realname"));
        } else {
            this.func_94058_c(StatCollector.func_74838_a("entity.EndermanTitan.name"));
        }

        if (this.field_70154_o != null && this.field_70154_o instanceof EntityDragon) {
            this.field_70761_aq = this.field_70177_z = this.field_70154_o.field_70177_z - 180.0F;
        }

        if (this.field_70146_Z.nextInt(400) == 0 && this.field_70154_o == null && this.func_70638_az() != null && this.func_110143_aJ() <= this.func_110138_aP() / 100.0F) {
            EntityDragon entitydragon = new EntityDragon(this.field_70170_p);
            int i = MathHelper.func_76128_c(this.field_70165_t);
            int j = MathHelper.func_76128_c(this.field_70163_u);
            int k = MathHelper.func_76128_c(this.field_70161_v);
            entitydragon.func_70012_b((double)i + (double)0.5F, (double)j, (double)k + (double)0.5F, this.field_70177_z, 0.0F);
            entitydragon.func_110161_a((IEntityLivingData)null);
            this.field_70170_p.func_72838_d(entitydragon);
            entitydragon.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            entitydragon.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            entitydragon.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            entitydragon.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            entitydragon.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            entitydragon.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            entitydragon.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            entitydragon.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
            this.func_70078_a(entitydragon);
        }

        List list1111 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)256.0F, (double)256.0F, (double)256.0F));
        if (list1111 != null && !list1111.isEmpty()) {
            for(int i1 = 0; i1 < list1111.size(); ++i1) {
                Entity entity1 = (Entity)list1111.get(i1);
                if (entity1 != null && this.func_70638_az() != null && entity1 instanceof EntityDragon) {
                    ((EntityDragon)entity1).field_70980_b = this.func_70638_az().field_70165_t;
                    ((EntityDragon)entity1).field_70981_c = this.func_70638_az().field_70163_u;
                    ((EntityDragon)entity1).field_70978_d = this.func_70638_az().field_70161_v;
                } else if (entity1 != null && this.func_70638_az() == null && entity1 instanceof EntityDragon && entity1.field_70153_n == null) {
                    ((EntityDragon)entity1).field_70980_b = this.field_70165_t;
                    ((EntityDragon)entity1).field_70981_c = this.field_70163_u + (double)60.0F;
                    ((EntityDragon)entity1).field_70978_d = this.field_70161_v;
                }
            }
        }

        if (this.field_70170_p.func_72935_r() && this.roarcooldownTimer < -1) {
            this.roarcooldownTimer = -1;
        }

        if (this.func_70089_S()) {
            ++this.roarcooldownTimer;
        }

        if (this.roarcooldownTimer == 0) {
            this.setScreaming(true);
            if (this.field_70170_p.func_72935_r() && !this.field_70170_p.field_73011_w.field_76576_e && !this.field_70170_p.field_72995_K) {
                this.field_70170_p.func_72877_b(this.field_70170_p.func_72820_D() + 14000L);
            }
        }

        if (this.roarcooldownTimer >= 60 || !this.func_70089_S()) {
            this.roarcooldownTimer = -(400 - this.field_70146_Z.nextInt(200));
            this.setScreaming(false);
        }

        if (!this.getWaiting() && this.animID != 13) {
            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0) {
                    EntityDragonMinion entitychicken = new EntityDragonMinion(this.field_70170_p);
                    int i = MathHelper.func_76128_c(this.field_70165_t) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int k = MathHelper.func_76128_c(this.field_70161_v) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int j = this.field_70170_p.func_72825_h(i, k) - 8;
                    entitychicken.func_70012_b((double)i + (double)0.5F, (double)j, (double)k + (double)0.5F, this.field_70177_z, 0.0F);
                    entitychicken.func_70024_g((double)0.0F, (double)1.0F, (double)0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    ++this.numSpecialMinions;
                } else if (this.numMinions < this.getMinionCap()) {
                    EntityEndermanMinion entitychicken = new EntityEndermanMinion(this.field_70170_p);
                    int i = MathHelper.func_76128_c(this.field_70165_t) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int k = MathHelper.func_76128_c(this.field_70161_v) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int j = this.field_70170_p.func_72825_h(i, k);
                    entitychicken.func_70012_b((double)i + (double)0.5F, (double)j, (double)k + (double)0.5F, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(0);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("mob.endermen.portal", 1.0F, 1.0F);
                    ++this.numMinions;
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0) {
                    EntityDragonMinion entitychicken = new EntityDragonMinion(this.field_70170_p);
                    int i = MathHelper.func_76128_c(this.field_70165_t) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int k = MathHelper.func_76128_c(this.field_70161_v) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int j = this.field_70170_p.func_72825_h(i, k) - 8;
                    entitychicken.func_70012_b((double)i + (double)0.5F, (double)j, (double)k + (double)0.5F, this.field_70177_z, 0.0F);
                    entitychicken.func_70024_g((double)0.0F, (double)1.0F, (double)0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    ++this.numSpecialMinions;
                } else if (this.numPriests < this.getPriestCap()) {
                    EntityEndermanMinion entitychicken = new EntityEndermanMinion(this.field_70170_p);
                    int i = MathHelper.func_76128_c(this.field_70165_t) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int k = MathHelper.func_76128_c(this.field_70161_v) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int j = this.field_70170_p.func_72825_h(i, k);
                    entitychicken.func_70012_b((double)i + (double)0.5F, (double)j, (double)k + (double)0.5F, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(1);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("mob.endermen.portal", 1.0F, 1.0F);
                    ++this.numPriests;
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0) {
                    EntityDragonMinion entitychicken = new EntityDragonMinion(this.field_70170_p);
                    int i = MathHelper.func_76128_c(this.field_70165_t) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int k = MathHelper.func_76128_c(this.field_70161_v) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int j = this.field_70170_p.func_72825_h(i, k) - 8;
                    entitychicken.func_70012_b((double)i + (double)0.5F, (double)j, (double)k + (double)0.5F, this.field_70177_z, 0.0F);
                    entitychicken.func_70024_g((double)0.0F, (double)1.0F, (double)0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    ++this.numSpecialMinions;
                } else if (this.numZealots < this.getZealotCap()) {
                    EntityEndermanMinion entitychicken = new EntityEndermanMinion(this.field_70170_p);
                    int i = MathHelper.func_76128_c(this.field_70165_t) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int k = MathHelper.func_76128_c(this.field_70161_v) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int j = this.field_70170_p.func_72825_h(i, k);
                    entitychicken.func_70012_b((double)i + (double)0.5F, (double)j, (double)k + (double)0.5F, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(2);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("mob.endermen.portal", 1.0F, 1.0F);
                    ++this.numZealots;
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0) {
                    EntityDragonMinion entitychicken = new EntityDragonMinion(this.field_70170_p);
                    int i = MathHelper.func_76128_c(this.field_70165_t) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int k = MathHelper.func_76128_c(this.field_70161_v) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int j = this.field_70170_p.func_72825_h(i, k) - 8;
                    entitychicken.func_70012_b((double)i + (double)0.5F, (double)j, (double)k + (double)0.5F, this.field_70177_z, 0.0F);
                    entitychicken.func_70024_g((double)0.0F, (double)1.0F, (double)0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    ++this.numSpecialMinions;
                } else if (this.numBishop < this.getBishopCap()) {
                    EntityEndermanMinion entitychicken = new EntityEndermanMinion(this.field_70170_p);
                    int i = MathHelper.func_76128_c(this.field_70165_t) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int k = MathHelper.func_76128_c(this.field_70161_v) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int j = this.field_70170_p.func_72825_h(i, k);
                    entitychicken.func_70012_b((double)i + (double)0.5F, (double)j, (double)k + (double)0.5F, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(3);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("mob.endermen.portal", 1.0F, 1.0F);
                    ++this.numBishop;
                }
            }

            if ((this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.numSpecialMinions < this.getSpecialMinionCap() && this.field_70146_Z.nextInt(100) == 0) {
                    EntityDragonMinion entitychicken = new EntityDragonMinion(this.field_70170_p);
                    int i = MathHelper.func_76128_c(this.field_70165_t) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int k = MathHelper.func_76128_c(this.field_70161_v) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int j = this.field_70170_p.func_72825_h(i, k) - 8;
                    entitychicken.func_70012_b((double)i + (double)0.5F, (double)j, (double)k + (double)0.5F, this.field_70177_z, 0.0F);
                    entitychicken.func_70024_g((double)0.0F, (double)1.0F, (double)0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.master = this;
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    entitychicken.func_85030_a("mob.enderdragon.growl", 10.0F, 1.0F);
                    ++this.numSpecialMinions;
                } else if (this.numTemplar < this.getTemplarCap()) {
                    EntityEndermanMinion entitychicken = new EntityEndermanMinion(this.field_70170_p);
                    int i = MathHelper.func_76128_c(this.field_70165_t) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int k = MathHelper.func_76128_c(this.field_70161_v) + MathHelper.func_76136_a(this.field_70146_Z, 15, 30) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int j = this.field_70170_p.func_72825_h(i, k);
                    entitychicken.func_70012_b((double)i + (double)0.5F, (double)j, (double)k + (double)0.5F, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(4);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("mob.endermen.portal", 1.0F, 1.0F);
                    ++this.numTemplar;
                }
            }
        }

        super.func_70636_d();
    }

    protected void func_70619_bc() {
        if (this.getEyeLaserTime() >= 0 && !this.field_70170_p.field_72995_K && this.field_70173_aa % 5 == 0) {
            for(int i = 0; i < 2; ++i) {
                Vec3 vec3 = this.func_70040_Z();
                double x = i == 1 ? this.leftEye.field_70165_t : this.rightEye.field_70165_t;
                double y = (i == 1 ? this.leftEye.field_70163_u : this.rightEye.field_70163_u) + (double)1.0F;
                double z = i == 1 ? this.leftEye.field_70161_v : this.rightEye.field_70161_v;
                double dx = x + vec3.field_72450_a * (double)300.0F;
                double dy = y + vec3.field_72448_b * (double)300.0F;
                double dz = z + vec3.field_72449_c * (double)300.0F;
                double d0 = dx - x;
                double d1 = dy - y;
                double d2 = dz - z;
                if (this.func_70638_az() != null) {
                    d0 = this.func_70638_az().field_70165_t - x;
                    d1 = this.func_70638_az().field_70163_u - y;
                    d2 = this.func_70638_az().field_70161_v - z;
                }

                EntitySkeletonTitanGiantArrow entityarrow = new EntitySkeletonTitanGiantArrow(this.field_70170_p, this, d0, d1, d2);
                entityarrow.field_70165_t = x;
                entityarrow.field_70163_u = y;
                entityarrow.field_70161_v = z;
                this.field_70170_p.func_72838_d(entityarrow);
                entityarrow.func_82142_c(true);
            }
        }

        List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D);
        if (list11 != null && !list11.isEmpty()) {
            for(int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (entity instanceof EntityLivingBase && entity.field_70122_E && !(entity instanceof EntityTitan)) {
                    float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                    entity.func_70097_a(DamageSourceExtra.causeSquishingDamage(this), f);
                }
            }
        }

        if (this.field_70173_aa % 20 == 0 && this.numOfCrystals < this.maxNumOfCrystals && !this.field_70170_p.field_72995_K) {
            EntityEnderColossusCrystal entitychicken = new EntityEnderColossusCrystal(this.field_70170_p);
            entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u + (double)92.0F, this.field_70161_v, this.field_70759_as, 0.0F);
            entitychicken.func_110161_a((IEntityLivingData)null);
            this.field_70170_p.func_72838_d(entitychicken);
            ++this.numOfCrystals;
            entitychicken.owner = this;
            entitychicken.field_70181_x = (double)2.0F;
            this.field_70170_p.func_72876_a(entitychicken, entitychicken.field_70165_t, entitychicken.field_70163_u, entitychicken.field_70161_v, 6.0F, false);
        }

        super.func_70619_bc();
    }

    protected String getRoarSound() {
        return "thetitans:titanEnderColossusRoar";
    }

    protected String func_70639_aQ() {
        return null;
    }

    protected String func_70621_aR() {
        return "thetitans:titanEnderColossusGrunt";
    }

    protected String func_70673_aS() {
        return "thetitans:titanEnderColossusDeath";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.func_85030_a("thetitans:titanStep", 10.0F, 0.85F);
        this.shakeNearbyPlayerCameras((double)6000.0F);
        float f3 = this.field_70177_z * (float)Math.PI / 180.0F;
        float f11 = MathHelper.func_76126_a(f3);
        float f4 = MathHelper.func_76134_b(f3);
        this.collideWithEntities(this.leftLeg, this.field_70170_p.func_72839_b(this, this.leftLeg.field_70121_D.func_72314_b((double)1.0F, (double)1.0F, (double)1.0F).func_72317_d((double)(f11 * 10.0F), (double)0.0F, (double)(f4 * 10.0F))));
        this.collideWithEntities(this.rightLeg, this.field_70170_p.func_72839_b(this, this.rightLeg.field_70121_D.func_72314_b((double)1.0F, (double)1.0F, (double)1.0F).func_72317_d((double)(f11 * 10.0F), (double)0.0F, (double)(f4 * 10.0F))));
    }

    protected Item func_146068_u() {
        return Items.field_151061_bv;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            for(int x = 0; x < 90; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                entitylargefireball.func_70107_b(this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                ++entitylargefireball.field_70181_x;
                entitylargefireball.setXPCount(26000);
                this.field_70170_p.func_72838_d(entitylargefireball);
            }

            for(int l = 0; l < 512 + this.field_70146_Z.nextInt(512 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151061_bv));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 128 + this.field_70146_Z.nextInt(128 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151079_bi));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 256 + this.field_70146_Z.nextInt(256 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151044_h));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 256 + this.field_70146_Z.nextInt(256 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150339_S));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 256 + this.field_70146_Z.nextInt(256 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150340_R));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 128 + this.field_70146_Z.nextInt(128 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150475_bE));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 128 + this.field_70146_Z.nextInt(128 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150484_ah));
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

            for(int l = 0; l < 64 + this.field_70146_Z.nextInt(64 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150380_bt));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 60; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150378_br));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(TitanItems.voidSword));
            entityitem.field_145804_b = 40;
            this.field_70170_p.func_72838_d(entityitem);
        }

    }

    protected void func_70600_l(int p_70600_1_) {
        switch (this.field_70146_Z.nextInt(3)) {
            case 0:
                this.func_70099_a(new ItemStack(Items.field_151153_ao, 64, 1), 0.0F);
                break;
            case 1:
                this.func_145779_a(Items.field_151048_u, 64);
                break;
            case 2:
                this.func_145779_a(Items.field_151057_cb, 64);
        }

    }

    public StatBase getAchievement() {
        return TitansAchievments.endercolossus;
    }

    public float func_70047_e() {
        return this.isScreaming() ? 76.0F : 65.0F;
    }

    public boolean isScreaming() {
        return this.field_70180_af.func_75683_a(18) > 0;
    }

    @SideOnly(Side.CLIENT)
    public int func_70070_b(float p_70070_1_) {
        return 15728880;
    }

    public float func_70013_c(float p_70013_1_) {
        return 1.0F;
    }

    public void setScreaming(boolean p_70819_1_) {
        if (!this.field_70170_p.field_72995_K) {
            this.field_70180_af.func_75692_b(18, (byte)(p_70819_1_ ? 1 : 0));
        }

        if (p_70819_1_) {
            this.func_85030_a(this.getRoarSound(), this.func_70599_aP(), 1.0F);
        }

    }

    public IEntityLivingData func_110161_a(IEntityLivingData p_180482_2_) {
        Object p_180482_2_1 = super.func_110161_a(p_180482_2_);
        this.func_85030_a(this.getRoarSound(), this.func_70599_aP(), 1.0F);
        this.setScreaming(true);
        this.setCanCallBackUp(true);
        this.setRoarCooldownTimer(-20 - this.field_70146_Z.nextInt(20));
        List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)256.0F, (double)256.0F, (double)256.0F));
        if (list11 != null && !list11.isEmpty()) {
            for(int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (entity != null && entity instanceof EntityWitherzilla) {
                    List list111 = this.field_70170_p.func_72839_b(entity, entity.field_70121_D.func_72314_b((double)256.0F, (double)256.0F, (double)256.0F));
                    if (list111 != null && !list111.isEmpty()) {
                        for(int i11 = 0; i11 < list111.size(); ++i11) {
                            Entity entity1 = (Entity)list111.get(i11);
                            if (entity1 != null && entity1 instanceof EntityPlayer) {
                                ((EntityPlayer)entity1).func_145747_a(new ChatComponentText(StatCollector.func_74838_a("dialog.witherzilla.endercolossus")));
                            }
                        }
                    }
                }
            }
        }

        return (IEntityLivingData)p_180482_2_1;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    public double func_70033_W() {
        return super.func_70033_W() - (double)1.0F;
    }

    protected void inactDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            this.func_85030_a("mob.endermen.death", this.func_70599_aP(), this.func_70647_i());
            if (this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
                this.func_70628_a(true, 0);
                this.func_82160_b(true, 0);
                this.func_70600_l(1);
            }

            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.field_70170_p);
            entitytitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitytitan);
            entitytitan.setVesselHunting(false);
            entitytitan.setSpiritType(10);
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
            float f = (this.field_70146_Z.nextFloat() - 0.5F) * 12.0F;
            float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 3.0F;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 12.0F;
            this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + (double)2.0F + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
        }

        if (this.getInvulTime() >= this.getThreashHold()) {
            this.func_70106_y();
        }

    }

    public int getRoarCooldownTimer() {
        return this.roarcooldownTimer;
    }

    public void setRoarCooldownTimer(int roarcooldownTimer) {
        this.roarcooldownTimer = roarcooldownTimer;
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

    public boolean func_70067_L() {
        return false;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (source.func_76346_g() instanceof EntityPlayer && !this.field_70170_p.field_72995_K) {
            this.func_70624_b((EntityLivingBase)source.func_76346_g());
            this.func_70604_c((EntityLivingBase)source.func_76346_g());
        }

        if (!this.func_85032_ar() && this.animID != 5) {
            return !(source.func_76346_g() instanceof EntityEndermanMinion) && !(source.func_76346_g() instanceof EntityEnderColossus) && !(source.func_76346_g() instanceof EntityDragon) && !(source.func_76346_g() instanceof EntityDragonMinion) ? super.func_70097_a(source, amount) : false;
        } else {
            return false;
        }
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
}
