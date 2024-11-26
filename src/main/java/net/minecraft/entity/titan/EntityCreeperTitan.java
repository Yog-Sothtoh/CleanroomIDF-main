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
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titan.ai.EntityAICreeperTitanSwell;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanAntiTitanAttack;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanAttack1;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanAttack2;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanAttack3;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanAttack4;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanCreation;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanDeath;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanSpit;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanStunned;
import net.minecraft.entity.titan.animation.creepertitan.AnimationCreeperTitanThunderClap;
import net.minecraft.entity.titanminion.EntityCreeperMinion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
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
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.ForgeHooks;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityCreeperTitan extends EntityTitan implements IAnimatedEntity, IEntityMultiPartTitan {
    public int damageToLegs;
    private int lastActiveTime;
    private int timeSinceIgnited;
    private int fuseTime = 200;
    private int field_175494_bm = 0;
    public boolean isStunned;
    public EntityTitanPart[] partArray;
    public EntityTitanPart head;
    public EntityTitanPart body;
    public EntityTitanPart leg1;
    public EntityTitanPart leg2;
    public EntityTitanPart leg3;
    public EntityTitanPart leg4;

    public EntityCreeperTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 8.0F, 8.0F);
        this.body = new EntityTitanPart(worldIn, this, "body", 7.0F, 12.0F);
        this.leg1 = new EntityTitanPart(worldIn, this, "leg1", 4.5F, 8.0F);
        this.leg2 = new EntityTitanPart(worldIn, this, "leg2", 4.5F, 8.0F);
        this.leg3 = new EntityTitanPart(worldIn, this, "leg3", 4.5F, 8.0F);
        this.leg4 = new EntityTitanPart(worldIn, this, "leg4", 4.5F, 8.0F);
        this.setTitanHealth(this.func_110138_aP());
        this.partArray = new EntityTitanPart[]{this.head, this.body, this.leg1, this.leg2, this.leg3, this.leg4};
        this.func_70105_a(8.0F, 26.0F);
        this.field_70728_aV = 50000;
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        worldIn.func_72838_d(this.head);
        worldIn.func_72838_d(this.body);
        worldIn.func_72838_d(this.leg1);
        worldIn.func_72838_d(this.leg2);
        worldIn.func_72838_d(this.leg3);
        worldIn.func_72838_d(this.leg4);
    }

    protected void applyEntityAI() {
        this.field_70714_bg.func_75776_a(0, new EntityAICreeperTitanSwell(this));
        this.field_70714_bg.func_75776_a(1, new AnimationCreeperTitanCreation(this));
        this.field_70714_bg.func_75776_a(1, new AnimationCreeperTitanDeath(this));
        this.field_70714_bg.func_75776_a(1, new AnimationCreeperTitanStunned(this));
        this.field_70714_bg.func_75776_a(1, new AnimationCreeperTitanThunderClap(this));
        this.field_70714_bg.func_75776_a(1, new AnimationCreeperTitanSpit(this));
        this.field_70714_bg.func_75776_a(1, new AnimationCreeperTitanAttack4(this));
        this.field_70714_bg.func_75776_a(1, new AnimationCreeperTitanAntiTitanAttack(this));
        this.field_70714_bg.func_75776_a(1, new AnimationCreeperTitanAttack2(this));
        this.field_70714_bg.func_75776_a(1, new AnimationCreeperTitanAttack1(this));
        this.field_70714_bg.func_75776_a(1, new AnimationCreeperTitanAttack3(this));
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.CreeperTitanSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != this.head.getClass() && p_70686_1_ != this.body.getClass() && p_70686_1_ != this.leg1.getClass() && p_70686_1_ != this.leg2.getClass() && p_70686_1_ != this.leg3.getClass() && p_70686_1_ != this.leg4.getClass() && p_70686_1_ != EntityCreeperMinion.class && p_70686_1_ != EntityCreeperTitan.class;
    }

    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(250) == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }

    public int getMinionSpawnRate() {
        return TheTitans.CreeperTitanMinionSpawnrate;
    }

    public int getMinionCap() {
        return 120;
    }

    public int getPriestCap() {
        return 60;
    }

    public int getZealotCap() {
        return 30;
    }

    public int getBishopCap() {
        return 15;
    }

    public int getTemplarCap() {
        return 8;
    }

    public int getParticleCount() {
        return this.getPowered() ? 28 : super.getParticleCount();
    }

    public boolean canBeHurtByPlayer() {
        return this.isStunned && !this.func_85032_ar();
    }

    public float func_70047_e() {
        return 23.6F;
    }

    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.AVERAGE;
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
                this.func_85030_a("thetitans:groundSmash", 20.0F, 1.0F);
                this.func_85030_a("thetitans:titanland", 10000.0F, 1.0F);
                this.func_85030_a("thetitans:titanStrike", 10.0F, 1.0F);
                this.func_85030_a("thetitans:titanSlam", 10.0F, 1.0F);
                this.destroyBlocksInAABBTopless(this.field_70121_D.func_72314_b((double)24.0F, (double)1.0F, (double)24.0F));
                this.collideWithEntities(this.body, this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)24.0F, (double)4.0F, (double)24.0F)));
                List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)48.0F, (double)4.0F, (double)48.0F));
                if (list11 != null && !list11.isEmpty()) {
                    for(int i1 = 0; i1 < list11.size(); ++i1) {
                        Entity entity = (Entity)list11.get(i1);
                        if (entity instanceof EntityLivingBase && this.func_70686_a(entity.getClass()) && !(entity instanceof EntityTitan)) {
                            float smash = 50.0F - this.func_70032_d(entity);
                            if (smash <= 1.0F) {
                                smash = 1.0F;
                            }

                            entity.func_70097_a(DamageSource.func_76358_a(this), smash);
                            double d0 = this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d;
                            double d1 = this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f;
                            double d2 = entity.field_70165_t - d0;
                            double d3 = entity.field_70161_v - d1;
                            double d4 = d2 * d2 + d3 * d3;
                            entity.func_70024_g(d2 / d4 * (double)8.0F, (double)1.0F, d3 / d4 * (double)8.0F);
                            if (!this.field_70170_p.field_72995_K && this.func_70089_S() && !this.isStunned) {
                                this.collideWithEntities(this.body, this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)16.0F, (double)1.0F, (double)16.0F)));
                            }
                        }
                    }
                }
            }

            if (this.getCreeperState() > 0) {
                this.timeSinceIgnited += 20;
            }

        }
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, -1);
        this.field_70180_af.func_75682_a(17, (byte)0);
        this.field_70180_af.func_75682_a(18, (byte)0);
    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        if (this.field_70180_af.func_75683_a(17) == 1) {
            tagCompound.func_74757_a("Charged", true);
        }

        tagCompound.func_74768_a("DamageToLegs", this.damageToLegs);
        tagCompound.func_74777_a("Fuse", (short)this.fuseTime);
        tagCompound.func_74757_a("ignited", this.func_146078_ca());
        tagCompound.func_74757_a("Stunned", this.isStunned);
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        this.field_70180_af.func_75692_b(17, (byte)(tagCompund.func_74767_n("Charged") ? 1 : 0));
        if (tagCompund.func_150297_b("DamageToLegs", 99)) {
            this.damageToLegs = tagCompund.func_74762_e("DamageToLegs");
        }

        this.isStunned = tagCompund.func_74767_n("Stunned");
        if (tagCompund.func_150297_b("Fuse", 99)) {
            this.fuseTime = tagCompund.func_74765_d("Fuse");
        }

        if (tagCompund.func_74767_n("ignited")) {
            this.func_146079_cb();
        }

    }

    public double getSpeed() {
        return this.getPowered() ? 0.35 + (double)this.getExtraPower() * 0.001 : 0.3 + (double)this.getExtraPower() * 0.001;
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

    public void attackChoosenEntity(Entity damagedEntity, float damage, int knockbackAmount) {
        super.attackChoosenEntity(damagedEntity, damage, knockbackAmount);
        if (this.getPowered() && damagedEntity instanceof EntityLivingBase && this.func_70089_S()) {
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "ambient.weather.thunder", 10000.0F, 0.8F + this.field_70146_Z.nextFloat() * 0.2F);
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "ambient.weather.thunder", 10000.0F, 0.8F + this.field_70146_Z.nextFloat() * 0.2F);
            this.field_70170_p.func_72885_a(this, damagedEntity.field_70165_t, damagedEntity.field_70163_u + (double)damagedEntity.func_70047_e(), damagedEntity.field_70161_v, 6.0F, false, false);
            this.field_70170_p.func_72885_a(this, this.field_70165_t, this.head.field_70163_u, this.field_70161_v, 2.0F, false, false);
            damagedEntity.func_70097_a(DamageSourceExtra.lightningBolt, 49.0F);
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v, 0.0F, 0.5F, 1.0F));
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, damagedEntity.field_70165_t, damagedEntity.field_70163_u, damagedEntity.field_70161_v, 0.0F, 0.5F, 1.0F));
        }

    }

    public boolean shouldMove() {
        return this.animID == 0 && !this.isStunned && this.func_70638_az() != null ? super.shouldMove() : false;
    }

    public void doLightningAttackToEntity(Entity p_70652_1_) {
        if (this.getPowered()) {
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "ambient.weather.thunder", 10000.0F, 0.8F + this.field_70146_Z.nextFloat() * 0.2F);
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "ambient.weather.thunder", 10000.0F, 0.8F + this.field_70146_Z.nextFloat() * 0.2F);
            this.field_70170_p.func_72885_a(this, p_70652_1_.field_70165_t, p_70652_1_.field_70163_u + (double)p_70652_1_.func_70047_e(), p_70652_1_.field_70161_v, 8.0F, false, false);
            this.field_70170_p.func_72885_a(this, this.field_70165_t, this.head.field_70163_u + (double)4.0F, this.field_70161_v, 4.0F, false, false);
            p_70652_1_.func_70097_a(DamageSourceExtra.lightningBolt, 49.0F);
            float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e() / 3.0F;
            int i = this.getKnockbackAmount();
            if (p_70652_1_ != this) {
                this.attackChoosenEntity(p_70652_1_, f, i);
            }

            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t, this.head.field_70163_u + (double)4.0F, this.field_70161_v, 0.0F, 0.5F, 1.0F));
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, p_70652_1_.field_70165_t, p_70652_1_.field_70163_u, p_70652_1_.field_70161_v, 0.0F, 0.5F, 1.0F));
        } else if (!this.getPowered()) {
            this.field_70170_p.func_72885_a(this, p_70652_1_.field_70165_t, p_70652_1_.field_70163_u + (double)p_70652_1_.func_70047_e(), p_70652_1_.field_70161_v, 4.0F, false, false);
            this.field_70170_p.func_72885_a(this, this.field_70165_t, this.head.field_70163_u + (double)4.0F, this.field_70161_v, 2.0F, false, false);
            p_70652_1_.func_70097_a(DamageSourceExtra.lightningBolt, 49.0F);
            float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e() / 3.0F;
            int i = this.getKnockbackAmount();
            if (p_70652_1_ != this) {
                this.attackChoosenEntity(p_70652_1_, f, i);
            }

            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t, this.head.field_70163_u + (double)4.0F, this.field_70161_v, 0.0F, 0.5F, 0.25F));
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, p_70652_1_.field_70165_t, p_70652_1_.field_70163_u, p_70652_1_.field_70161_v, 0.0F, 0.5F, 0.25F));
        }

    }

    public boolean func_70652_k(Entity p_70652_1_) {
        return false;
    }

    public double getMeleeRange() {
        return (double)(this.field_70130_N * this.field_70130_N + (this.func_70638_az().field_70130_N > 48.0F ? 2304.0F : this.func_70638_az().field_70130_N * this.func_70638_az().field_70130_N)) + (double)600.0F;
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
                this.func_85030_a("thetitans:titanCreeperAwaken", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 130) {
                this.func_85030_a("thetitans:titanRumble", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 160) {
                this.func_85030_a("thetitans:titanCreeperBeginMove", this.func_70599_aP(), 1.0F);
            }

            if (this.getAnimID() == 13 && (this.getAnimTick() == 260 || this.getAnimTick() == 261 || this.getAnimTick() == 390 || this.getAnimTick() == 410)) {
                this.func_145780_a(0, 0, 0, Blocks.field_150348_b);
                this.func_85030_a("thetitans:titanPress", this.func_70599_aP(), 1.0F);
            }
        }

        if (this.isStunned) {
            this.func_70624_b((EntityLivingBase)null);
            AnimationAPI.sendAnimPacket(this, 8);
        }

        if (this.animID == 10) {
            if (this.animTick == 50 || this.animTick == 70 || this.animTick == 100) {
                this.func_145780_a(0, 0, 0, Blocks.field_150348_b);
            }

            if (this.animTick == 120) {
                this.shakeNearbyPlayerCameras((double)10000.0F);
                this.func_85030_a("thetitans:titanFall", 20.0F, 1.0F);
                this.func_85030_a("thetitans:groundSmash", 20.0F, 1.0F);
            }

            if (this.animTick == 160) {
                this.shakeNearbyPlayerCameras((double)10000.0F);
                this.func_85030_a("thetitans:titanFall", 20.0F, 1.0F);
            }
        }

        if (this.animID == 8) {
            if (this.animTick == 120) {
                this.shakeNearbyPlayerCameras((double)10000.0F);
                this.func_85030_a("thetitans:groundSmash", 8.0F, 0.9F);
                this.func_85030_a("thetitans:titanFall", 10.0F, 1.0F);
            }

            if (this.animTick == 20) {
                this.func_85030_a("thetitans:titanCreeperStun", this.func_70599_aP(), this.func_70647_i());
            }

            if (this.animTick > 500) {
                this.isStunned = false;
            } else {
                this.isStunned = true;
            }

            this.func_70624_b((EntityLivingBase)null);
        }

        if (this.getPowered() && !this.isStunned) {
            WorldServer worldserver = MinecraftServer.func_71276_C().field_71305_c[0];
            WorldInfo worldinfo = worldserver.func_72912_H();
            worldinfo.func_76080_g(9999999);
            worldinfo.func_76090_f(1000000);
            worldinfo.func_76084_b(true);
            worldinfo.func_76069_a(true);
            if (this.field_70146_Z.nextInt(20) == 0) {
                EntityGammaLightning entitylightning = new EntityGammaLightning(this.field_70170_p, this.field_70165_t, this.head.field_70163_u + (double)4.0F, this.field_70161_v, 0.0F, 0.5F, 1.0F);
                this.field_70170_p.func_72942_c(entitylightning);
            }

            if (this.field_70146_Z.nextInt(40) == 0) {
                for(int l = 0; l < 50; ++l) {
                    int i = MathHelper.func_76128_c(this.field_70165_t);
                    int j = MathHelper.func_76128_c(this.field_70163_u);
                    int k = MathHelper.func_76128_c(this.field_70161_v);
                    int i1 = i + MathHelper.func_76136_a(this.field_70146_Z, 10, 100) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int j1 = j + MathHelper.func_76136_a(this.field_70146_Z, 10, 100) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int k1 = k + MathHelper.func_76136_a(this.field_70146_Z, 10, 100) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    EntityGammaLightning entitylightning = new EntityGammaLightning(this.field_70170_p, (double)i1, (double)j1, (double)k1, 0.0F, 0.5F, 1.0F);
                    if (World.func_147466_a(this.field_70170_p, i1, j1 - 1, k1) && this.field_70170_p.func_72855_b(entitylightning.field_70121_D) && this.field_70170_p.func_72945_a(entitylightning, entitylightning.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(entitylightning.field_70121_D)) {
                        this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, (double)i1, (double)j1, (double)k1, 0.0F, 0.5F, 1.0F));
                    }
                }
            }
        }

        if (this.field_70173_aa > 5) {
            float f = this.field_70761_aq * (float)Math.PI / 180.0F;
            float f1 = MathHelper.func_76126_a(f);
            float f2 = MathHelper.func_76134_b(f);
            float offset = (this.animID != 3 || this.animTick <= 30 || this.animTick >= 70) && (this.animID != 7 || this.animTick <= 30 || this.animTick >= 130) ? 0.0F : 6.0F;
            this.head.func_70012_b(this.field_70165_t, this.field_70163_u + (this.animID == 8 ? (double)12.0F : (double)18.0F), this.field_70161_v, 0.0F, 0.0F);
            this.body.func_70012_b(this.field_70165_t, this.field_70163_u + (this.animID == 8 ? (double)0.0F : (double)6.0F), this.field_70161_v, 0.0F, 0.0F);
            this.leg1.func_70012_b(this.field_70165_t - (double)(f1 * 5.5F) + (double)(f2 * 5.5F), this.field_70163_u + (double)offset, this.field_70161_v + (double)(f2 * 5.5F) + (double)(f1 * 5.5F), 0.0F, 0.0F);
            this.leg2.func_70012_b(this.field_70165_t - (double)(f1 * 5.5F) - (double)(f2 * 5.5F), this.field_70163_u + (double)offset, this.field_70161_v + (double)(f2 * 5.5F) - (double)(f1 * 5.5F), 0.0F, 0.0F);
            this.leg3.func_70012_b(this.field_70165_t + (double)(f1 * 5.5F) + (double)(f2 * 5.5F), this.field_70163_u, this.field_70161_v - (double)(f2 * 5.5F) + (double)(f1 * 5.5F), 0.0F, 0.0F);
            this.leg4.func_70012_b(this.field_70165_t + (double)(f1 * 5.5F) - (double)(f2 * 5.5F), this.field_70163_u, this.field_70161_v - (double)(f2 * 5.5F) - (double)(f1 * 5.5F), 0.0F, 0.0F);
            if (this.func_70089_S() && !this.isStunned) {
                this.collideWithEntities(this.head, this.field_70170_p.func_72839_b(this, this.head.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.body, this.field_70170_p.func_72839_b(this, this.body.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.leg1, this.field_70170_p.func_72839_b(this, this.leg1.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.leg2, this.field_70170_p.func_72839_b(this, this.leg2.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.leg3, this.field_70170_p.func_72839_b(this, this.leg3.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.leg4, this.field_70170_p.func_72839_b(this, this.leg4.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
            }

            this.destroyBlocksInAABB(this.head.field_70121_D);
            this.destroyBlocksInAABB(this.body.field_70121_D);
            this.destroyBlocksInAABB(this.leg1.field_70121_D);
            this.destroyBlocksInAABB(this.leg2.field_70121_D);
            this.destroyBlocksInAABB(this.leg3.field_70121_D);
            this.destroyBlocksInAABB(this.leg4.field_70121_D);

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
        if (this.isStunned || this.deathTicks > 0) {
            this.field_70159_w *= (double)0.0F;
            this.field_70179_y *= (double)0.0F;
        }

        if (!AnimationAPI.isEffectiveClient() && this.func_70638_az() != null && !this.isStunned && this.getAnimID() == 0) {
            double d0 = this.func_70068_e(this.func_70638_az());
            if (d0 < this.getMeleeRange()) {
                if (!(this.func_70638_az() instanceof EntityTitan) && !(this.func_70638_az().field_70131_O >= 6.0F) && !(this.func_70638_az().field_70163_u > this.field_70163_u + (double)6.0F)) {
                    switch (this.field_70146_Z.nextInt(4)) {
                        case 0:
                            AnimationAPI.sendAnimPacket(this, 3);
                            this.setAnimID(3);
                            break;
                        case 1:
                            AnimationAPI.sendAnimPacket(this, 2);
                            this.setAnimID(2);
                            break;
                        case 2:
                            AnimationAPI.sendAnimPacket(this, 5);
                            this.setAnimID(5);
                            break;
                        case 3:
                            AnimationAPI.sendAnimPacket(this, 4);
                            this.setAnimID(4);
                    }
                } else {
                    AnimationAPI.sendAnimPacket(this, 1);
                    this.setAnimID(1);
                }
            } else if (this.getAnimID() == 0 && this.func_70681_au().nextInt(100) == 0) {
                switch (this.field_70146_Z.nextInt(2)) {
                    case 0:
                        AnimationAPI.sendAnimPacket(this, 7);
                        this.setAnimID(7);
                        break;
                    case 1:
                        AnimationAPI.sendAnimPacket(this, 6);
                        this.setAnimID(6);
                }
            }
        }

        if (this.animID == 1 && this.animTick == 1) {
            this.antiTitanAttackAnimeID = this.func_70681_au().nextInt(4);
        }

        if (this.getAnimID() == 6 && this.getAnimTick() <= 50 && this.getAnimTick() >= 20 && this.func_70638_az() != null) {
            int it;
            if (this.getPowered()) {
                it = 50 + this.field_70146_Z.nextInt(50);
            } else {
                it = 10 + this.field_70146_Z.nextInt(10);
            }

            for(int i = 0; i < it; ++i) {
                switch (this.field_70146_Z.nextInt(3)) {
                    case 0:
                        Vec3 vec3 = this.func_70676_i(1.0F);
                        double d5 = this.func_70638_az().field_70165_t + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 16.0F) - this.head.field_70165_t + vec3.field_72450_a * (double)6.0F;
                        double d6 = this.func_70638_az().field_70163_u - (double)16.0F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 16.0F) - this.head.field_70163_u + (double)1.0F;
                        double d7 = this.func_70638_az().field_70161_v + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 16.0F) - this.head.field_70161_v + vec3.field_72449_c * (double)6.0F;
                        EntityTitanFireball entitylargefireball = new EntityTitanFireball(this.field_70170_p, this, d5, d6, d7, 1);
                        entitylargefireball.field_70165_t = this.head.field_70165_t + vec3.field_72450_a * (double)6.0F;
                        entitylargefireball.field_70163_u = this.head.field_70163_u + (double)1.0F;
                        entitylargefireball.field_70161_v = this.head.field_70161_v + vec3.field_72449_c * (double)6.0F;
                        this.field_70170_p.func_72838_d(entitylargefireball);
                        entitylargefireball.setFireballID(1);
                        this.func_85030_a("thetitans:titanGhastFireball", 100.0F, 1.25F);
                        break;
                    case 1:
                        if (!this.field_70170_p.field_72995_K) {
                            EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(this.field_70170_p, this.func_70638_az().field_70165_t + (double)0.5F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 32.0F), this.func_70638_az().field_70163_u + (double)32.0F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 32.0F), this.func_70638_az().field_70161_v + (double)0.5F + (double)((this.func_70681_au().nextFloat() * 2.0F - 1.0F) * 32.0F), this);
                            this.field_70170_p.func_72838_d(entitytntprimed);
                            this.func_85030_a("game.tnt.primed", 1.0F, 1.0F);
                            entitytntprimed.field_70516_a = 100 + this.field_70146_Z.nextInt(60);
                        }
                }
            }
        }

        List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)100.0F, (double)100.0F, (double)100.0F));
        if (list != null && !list.isEmpty() && this.field_70173_aa % 20 == 0) {
            for(int i1 = 0; i1 < list.size(); ++i1) {
                Entity entity = (Entity)list.get(i1);
                if (entity != null && this.getPowered() && entity instanceof EntityCreeperMinion) {
                    if (!((EntityCreeperMinion)entity).func_70830_n()) {
                        this.field_70170_p.func_72942_c(new EntityLightningBolt(this.field_70170_p, entity.field_70165_t, entity.field_70163_u + (double)entity.field_70131_O, entity.field_70161_v));
                    } else {
                        ((EntityCreeperMinion)entity).func_70691_i(5.0F);
                    }
                }
            }
        }

        if (this.func_70638_az() != null && this.func_70638_az() instanceof EntityPlayer && ((EntityPlayer)this.func_70638_az()).func_70005_c_() == "Boom337317") {
            this.func_70624_b((EntityLivingBase)null);
        }

        if (this.getPowered()) {
            switch (this.field_70146_Z.nextInt(5)) {
                case 0:
                    this.func_94058_c("§2Charged Creeper Titan");
                    break;
                case 1:
                    this.func_94058_c("§4Charged Creeper Titan");
                    break;
                case 2:
                    this.func_94058_c("§6Charged Creeper Titan");
                    break;
                case 3:
                    this.func_94058_c("§aCharged Creeper Titan");
                    break;
                case 4:
                    this.func_94058_c("§eCharged Creeper Titan");
            }
        } else {
            this.func_94058_c(StatCollector.func_74838_a("entity.CreeperTitan.name"));
        }

        if (this.func_70638_az() != null && this.field_70122_E && !this.isStunned && this.func_70068_e(this.func_70638_az()) > (double)300.0F && this.animID == 0) {
            int in;
            if (this.getPowered()) {
                in = 50;
            } else {
                in = 300;
            }

            if (this.field_70146_Z.nextInt(in) == 0) {
                this.func_70664_aZ();
                this.func_85030_a(this.func_70621_aR(), this.func_70599_aP(), this.func_70647_i());
            }
        }

        if (this.func_70638_az() != null && this.field_70122_E && !this.isStunned && this.animID == 0) {
            int in;
            if (this.getPowered()) {
                in = 50;
            } else {
                in = 600;
            }

            if (this.field_70146_Z.nextInt(in) == 0) {
                if (this.field_70146_Z.nextInt(4) == 0) {
                    this.func_70664_aZ();
                    double d01 = this.func_70638_az().field_70165_t - this.field_70165_t;
                    double d11 = this.func_70638_az().field_70161_v - this.field_70161_v;
                    float f21 = MathHelper.func_76133_a(d01 * d01 + d11 * d11);
                    double hor = (double)(f21 / 16.0F);
                    double ver = (double)2.0F;
                    this.field_70159_w = d01 / (double)f21 * hor * hor + this.field_70159_w * hor;
                    this.field_70179_y = d11 / (double)f21 * hor * hor + this.field_70179_y * hor;
                    this.field_70181_x = ver;
                } else {
                    this.jumpAtEntity(this.func_70638_az());
                }
            }
        }

        if (this.func_70638_az() != null && !(this.func_70638_az() instanceof EntityTitan) && (this.field_70146_Z.nextInt(30) == 0 && this.getPowered() || this.field_70146_Z.nextInt(150) == 0 && !this.getPowered()) && !this.isStunned) {
            this.doLightningAttackToEntity(this);
            this.doLightningAttackToEntity(this.func_70638_az());
        }

        if (!this.getWaiting() && this.animID != 13 && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
            if (this.numMinions < this.getMinionCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntityCreeperMinion entitychicken = new EntityCreeperMinion(this.field_70170_p);
                this.teleportEntityRandomly(entitychicken);
                entitychicken.master = this;
                entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                entitychicken.func_70024_g((double)0.0F, 0.9, (double)0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(0);
                this.field_70170_p.func_72838_d(entitychicken);
                ++this.numMinions;
                entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v);
                this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                if (block == Blocks.field_150349_c) {
                    this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                }

                if (this.field_70146_Z.nextInt(100) == 0 || this.getPowered()) {
                    entitychicken.func_70096_w().func_75692_b(17, (byte)1);
                }
            }

            if (this.numPriests < this.getPriestCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntityCreeperMinion entitychicken = new EntityCreeperMinion(this.field_70170_p);
                this.teleportEntityRandomly(entitychicken);
                entitychicken.master = this;
                entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                entitychicken.func_70024_g((double)0.0F, 0.9, (double)0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(1);
                this.field_70170_p.func_72838_d(entitychicken);
                ++this.numPriests;
                entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v);
                this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                if (block == Blocks.field_150349_c) {
                    this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                }

                if (this.field_70146_Z.nextInt(100) == 0 || this.getPowered()) {
                    entitychicken.func_70096_w().func_75692_b(17, (byte)1);
                }
            }

            if (this.numZealots < this.getZealotCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntityCreeperMinion entitychicken = new EntityCreeperMinion(this.field_70170_p);
                this.teleportEntityRandomly(entitychicken);
                entitychicken.master = this;
                entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                entitychicken.func_70024_g((double)0.0F, 0.9, (double)0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(2);
                this.field_70170_p.func_72838_d(entitychicken);
                ++this.numZealots;
                entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v);
                this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                if (block == Blocks.field_150349_c) {
                    this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                }

                if (this.field_70146_Z.nextInt(100) == 0 || this.getPowered()) {
                    entitychicken.func_70096_w().func_75692_b(17, (byte)1);
                }
            }

            if (this.numBishop < this.getBishopCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntityCreeperMinion entitychicken = new EntityCreeperMinion(this.field_70170_p);
                this.teleportEntityRandomly(entitychicken);
                entitychicken.master = this;
                entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                entitychicken.func_70024_g((double)0.0F, 0.9, (double)0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(3);
                this.field_70170_p.func_72838_d(entitychicken);
                ++this.numBishop;
                entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v);
                this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                if (block == Blocks.field_150349_c) {
                    this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                }

                if (this.field_70146_Z.nextInt(100) == 0 || this.getPowered()) {
                    entitychicken.func_70096_w().func_75692_b(17, (byte)1);
                }
            }

            if (this.numTemplar < this.getTemplarCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntityCreeperMinion entitychicken = new EntityCreeperMinion(this.field_70170_p);
                this.teleportEntityRandomly(entitychicken);
                entitychicken.master = this;
                entitychicken.func_85030_a("thetitans:titansummonminion", 2.0F, 1.0F);
                entitychicken.func_70024_g((double)0.0F, 0.9, (double)0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(4);
                this.field_70170_p.func_72838_d(entitychicken);
                ++this.numTemplar;
                entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v);
                this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                if (block == Blocks.field_150349_c) {
                    this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                }

                if (this.field_70146_Z.nextInt(100) == 0 || this.getPowered()) {
                    entitychicken.func_70096_w().func_75692_b(17, (byte)1);
                }
            }
        }

        if (TheTitans.NightmareMode) {
            if (this.getPowered()) {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)1620.0F + (double)(this.getExtraPower() * 270));
            } else {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)540.0F + (double)(this.getExtraPower() * 90));
            }

            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)50000.0F + (double)(this.getExtraPower() * 2500));
        } else {
            if (this.getPowered()) {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)540.0F + (double)(this.getExtraPower() * 90));
            } else {
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)180.0F + (double)(this.getExtraPower() * 30));
            }

            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)25000.0F + (double)(this.getExtraPower() * 1250));
        }

        super.func_70636_d();
    }

    protected String func_70639_aQ() {
        return !this.isStunned && !this.getWaiting() && this.animID != 13 ? "thetitans:titanCreeperLiving" : null;
    }

    protected String func_70621_aR() {
        return "thetitans:titanCreeperGrunt";
    }

    protected String func_70673_aS() {
        return "thetitans:titanCreeperDeath";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.func_85030_a("thetitans:titanStep", 10.0F, 1.1F);
        this.func_85030_a("thetitans:titanStep", 10.0F, 1.1F);
        this.shakeNearbyPlayerCameras((double)4000.0F);
        this.shakeNearbyPlayerCameras((double)4000.0F);
        if (!this.getWaiting() && this.animID != 13) {
            if (this.footID == 0) {
                this.destroyBlocksInAABB(this.leg1.field_70121_D.func_72317_d((double)0.0F, (double)-1.0F, (double)0.0F));
                this.destroyBlocksInAABB(this.leg4.field_70121_D.func_72317_d((double)0.0F, (double)-1.0F, (double)0.0F));
                ++this.footID;
            } else {
                this.destroyBlocksInAABB(this.leg2.field_70121_D.func_72317_d((double)0.0F, (double)-1.0F, (double)0.0F));
                this.destroyBlocksInAABB(this.leg3.field_70121_D.func_72317_d((double)0.0F, (double)-1.0F, (double)0.0F));
                this.footID = 0;
            }
        }

    }

    public StatBase getAchievement() {
        return TitansAchievments.creepertitan;
    }

    public void setPowered(boolean powered) {
        this.field_70180_af.func_75692_b(17, Byte.valueOf((byte)(powered ? 1 : 0)));
    }

    public boolean getPowered() {
        return this.field_70180_af.func_75683_a(17) == 1;
    }

    @SideOnly(Side.CLIENT)
    public float getCreeperFlashIntensity(float p_70831_1_) {
        return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * p_70831_1_) / (float)(this.fuseTime - 2);
    }

    protected Item func_146068_u() {
        return Items.field_151016_H;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            for(int x = 0; x < (this.getPowered() ? 60 : 16); ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                entitylargefireball.func_70107_b(this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                ++entitylargefireball.field_70181_x;
                entitylargefireball.setXPCount(16000);
                this.field_70170_p.func_72838_d(entitylargefireball);
            }

            for(int l = 0; l < 256 + this.field_70146_Z.nextInt(256 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151016_H));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 64 + this.field_70146_Z.nextInt(64 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150335_W));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 32 + this.field_70146_Z.nextInt(32 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151044_h));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 32 + this.field_70146_Z.nextInt(32 + p_70628_2_) + p_70628_2_; ++l) {
                int t = Item.func_150891_b(Items.field_151096_cd);
                int v = Item.func_150891_b(Items.field_151084_co);
                int q = t + this.field_70146_Z.nextInt(v - t + 1);
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Item.func_150899_d(q)));
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

    public int getCreeperState() {
        return this.field_70180_af.func_75683_a(16);
    }

    public void setCreeperState(int p_70829_1_) {
        this.field_70180_af.func_75692_b(16, (byte)p_70829_1_);
    }

    public void func_70077_a(EntityLightningBolt lightningBolt) {
        if (this.field_70146_Z.nextInt(1000) == 0) {
            this.setPowered(true);
        }

    }

    public int getThreashHold() {
        return this.fuseTime;
    }

    public IEntityLivingData func_110161_a(IEntityLivingData p_180482_2_) {
        Object p_180482_2_1 = super.func_110161_a(p_180482_2_);
        this.setWaiting(true);
        return (IEntityLivingData)p_180482_2_1;
    }

    private void explode() {
        for(int i = 0; i < 1000; ++i) {
            float f = (this.field_70146_Z.nextFloat() - 0.5F) * 16.0F;
            float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 48.0F;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 16.0F;
            this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + (double)f1, this.field_70161_v + (double)f2, this.field_70146_Z.nextDouble() - (double)0.5F, (double)0.0F, this.field_70146_Z.nextDouble() - (double)0.5F);
        }

        this.func_85030_a("thetitans:titanCreeperExplosion", Float.MAX_VALUE, 1.0F);
        this.func_85030_a(this.func_70673_aS(), this.func_70599_aP(), this.func_70647_i());
        boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
        double d1 = this.getPowered() ? (double)256.0F : (double)128.0F;
        double d2 = this.getPowered() ? (double)2048.0F : (double)1024.0F;
        this.destroyBlocksInAABBGriefingBypass(this.field_70121_D.func_72314_b(d1, d1, d1));
        this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u + (double)24.0F, this.field_70161_v, 12.0F, flag);
        this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u + (double)18.0F, this.field_70161_v, 12.0F, flag);
        this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u + (double)12.0F, this.field_70161_v, 12.0F, flag);
        this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u + (double)6.0F, this.field_70161_v, 12.0F, flag);
        this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 12.0F, flag);
        this.func_85030_a("thetitans:titanland", 10000.0F, 1.0F);

        for(int da = 0; da <= 250; ++da) {
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(d1, d1, d1));
            if (list != null && !list.isEmpty()) {
                for(int i = 0; i < list.size(); ++i) {
                    Entity entity = (Entity)list.get(i);
                    if (entity != null && entity instanceof EntityLivingBase) {
                        this.attackChoosenEntity(entity, this.getPowered() ? 400.0F : 200.0F, 0);
                        entity.func_70097_a(DamageSourceExtra.causeCreeperTitanExplosionDamage(this), this.getPowered() ? 400.0F : 200.0F);
                        entity.field_70172_ad = 0;
                        if (entity instanceof EntityCreeperTitan) {
                            ((EntityCreeperTitan)entity).func_70691_i(this.getPowered() ? 400.0F : 200.0F);
                            ((EntityCreeperTitan)entity).setPowered(true);
                        }
                    }
                }
            }
        }

        List list111 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(d2, d2, d2));
        if (list111 != null && !list111.isEmpty()) {
            for(int i = 0; i < list111.size(); ++i) {
                Entity entity = (Entity)list111.get(i);
                if (entity instanceof EntityLivingBase) {
                    ((EntityLivingBase)entity).func_70690_d(new PotionEffect(ClientProxy.creeperTitanRadiation.field_76415_H, 30000, 1));
                }
            }
        }

    }

    public boolean func_146078_ca() {
        return this.field_70180_af.func_75683_a(18) != 0;
    }

    public void func_146079_cb() {
        this.field_70180_af.func_75692_b(18, (byte)1);
    }

    public void func_175493_co() {
        ++this.field_175494_bm;
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
                }
            }
        }

    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (this.getPowered()) {
            amount /= 3.0F;
        }

        if (source.func_76346_g() instanceof EntityPlayer && !this.field_70170_p.field_72995_K) {
            this.func_70624_b((EntityLivingBase)source.func_76346_g());
            this.func_70604_c((EntityLivingBase)source.func_76346_g());
        }

        if (this.func_85032_ar()) {
            return false;
        } else if (source.func_76355_l() != "lightningBolt" && source.func_76355_l() != "explosion" && !(source.func_76346_g() instanceof EntityCreeperMinion) && !(source.func_76346_g() instanceof EntityCreeperTitan) && (!source.func_94541_c() || source.func_76346_g() instanceof EntityWitherTurret)) {
            if (!this.isStunned && source.func_76346_g() instanceof EntityPlayer) {
                return false;
            } else {
                this.field_70718_bc = 200;
                Entity entity = source.func_76346_g();
                if (entity instanceof EntityLivingBase && !this.func_85032_ar() && amount > 25.0F) {
                    List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)256.0F, (double)256.0F, (double)256.0F));

                    for(int i = 0; i < list.size(); ++i) {
                        Entity entity1 = (Entity)list.get(i);
                        if (entity1 instanceof EntityCreeperTitan) {
                            EntityCreeperTitan entitypigzombie = (EntityCreeperTitan)entity1;
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
            this.func_70691_i(amount);
            return false;
        }
    }

    public boolean attackEntityFromPart(EntityTitanPart p_70965_1_, DamageSource source, float amount) {
        this.func_82195_e(source, amount);
        if (source != DamageSourceExtra.lightningBolt && !(source.func_76346_g() instanceof EntityCreeperMinion) && !(source.func_76346_g() instanceof EntityCreeperTitan) && (!source.func_94541_c() || source.func_76346_g() instanceof EntityWitherTurret)) {
            if (source.func_76346_g() != null && source.func_76346_g() instanceof EntityPlayer && source.func_76357_e() && this.damageToLegs < 8 && !this.isStunned && (p_70965_1_ == this.leg1 || p_70965_1_ == this.leg2 || p_70965_1_ == this.leg3 || p_70965_1_ == this.leg4)) {
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

            return true;
        } else {
            this.func_70691_i(amount);
            return false;
        }
    }

    protected boolean func_82195_e(DamageSource p_82195_1_, float p_82195_2_) {
        return this.func_70097_a(p_82195_1_, p_82195_2_);
    }

    public World func_82194_d() {
        return this.field_70170_p;
    }

    protected void inactDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            this.explode();
            this.func_85030_a("mob.creeper.death", this.func_70599_aP(), this.func_70647_i());
            if (this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
                this.func_70628_a(true, 0);
                this.func_82160_b(true, 0);
                this.func_70600_l(1);
            }

            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.field_70170_p);
            entitytitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitytitan);
            entitytitan.setVesselHunting(false);
            entitytitan.setSpiritType(7);
        }

    }

    protected void onTitanDeathUpdate() {
        if (this.timeSinceIgnited >= this.getThreashHold()) {
            this.deathTicks = 200;
            this.func_70106_y();
        } else {
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

            if (this.deathTicks < 300) {
                this.timeSinceIgnited = 0;
            }

            if (this.deathTicks >= 300) {
                if (this.timeSinceIgnited == 1) {
                    this.func_85030_a("thetitans:titanCreeperWarning", Float.MAX_VALUE, 1.0F);
                }

                ++this.timeSinceIgnited;
                --this.animTick;
                this.setCreeperState(1);
                float f = (this.field_70146_Z.nextFloat() - 0.5F) * 16.0F;
                float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 12.0F;
                float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 16.0F;
                this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + (double)2.0F + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
            }

            if (this.timeSinceIgnited >= this.getThreashHold()) {
                this.deathTicks = 200;
                this.func_70106_y();
            }
        }

    }
}
