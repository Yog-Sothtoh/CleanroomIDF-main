//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titanminion;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSilverfish;
import net.minecraft.block.material.Material;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.titan.EntityEnderColossusCrystal;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.entity.titan.EntityWitherzillaMinion;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAIBreakDoorMinion;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.ClientProxy;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.ImmutablePair;

public class EntitySilverfishMinion extends EntitySilverfish implements IRangedAttackMob, ITemplar {
    public EntityLiving master;
    public boolean isMasterSubdued;
    public int randomSoundDelay;
    private int attackPattern;
    private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, (double)1.0F, 10, 64.0F);
    private float heightOffset = 0.5F;
    private int heightOffsetUpdateTime;
    public EntityLiving entityToHeal;
    public IEntitySelector allowPlayerPresence = new IEntitySelector() {
        public boolean func_82704_a(Entity p_179983_1_) {
            return p_179983_1_ instanceof EntityWitherzilla || p_179983_1_ instanceof EntityWitherzillaMinion || p_179983_1_ instanceof EntityAnimal || p_179983_1_ instanceof EntityGolem || p_179983_1_ instanceof EntityAgeable || p_179983_1_ instanceof EntityPlayer || p_179983_1_ instanceof EntityAmbientCreature || p_179983_1_ instanceof EntityWaterMob || p_179983_1_ instanceof EntityTameable || !(p_179983_1_ instanceof EntityDragon) && !(p_179983_1_ instanceof EntityBlaze) && !(p_179983_1_ instanceof EntityCaveSpider) && !(p_179983_1_ instanceof EntityCreeper) && !(p_179983_1_ instanceof EntityEnderman) && !(p_179983_1_ instanceof EntityPigZombie) && !(p_179983_1_ instanceof EntitySilverfish) && !(p_179983_1_ instanceof EntitySkeleton) && !(p_179983_1_ instanceof EntitySpider) && !(p_179983_1_ instanceof EntityWither) && !(p_179983_1_ instanceof EntityZombie) && !(p_179983_1_ instanceof EntityTitan) && !(p_179983_1_ instanceof EntityGhast) && !(p_179983_1_ instanceof EntityMagmaCube) && !(p_179983_1_ instanceof EntitySlime) && !(p_179983_1_ instanceof IMinion) && !(p_179983_1_ instanceof EntityTitanSpirit) && !(p_179983_1_ instanceof EntityEnderColossusCrystal) && !(p_179983_1_ instanceof EntityPlayer);
        }
    };
    public int deathTicks;

    public EntitySilverfishMinion(World worldIn) {
        super(worldIn);
        this.func_70661_as().func_75498_b(true);
        this.func_70661_as().func_75490_c(true);
        this.func_70661_as().func_75495_e(true);
        this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
        this.field_70714_bg.func_75776_a(0, new EntityAIAvoidEntity(this, EntityWitherSkull.class, 2.0F, 1.2, (double)1.75F));
        this.field_70714_bg.func_75776_a(0, new EntityAIAvoidEntity(this, EntityTitanSpirit.class, 48.0F, (double)1.5F, (double)1.5F));
        this.field_70714_bg.func_75776_a(0, new EntityAIBreakDoorMinion(this));
        this.field_70714_bg.func_75776_a(1, new EntityAIMoveTowardsRestriction(this, 1.2));
        this.field_70714_bg.func_75776_a(0, new EntityAIFindEntityNearestInjuredAlly(this));
        this.field_70714_bg.func_75776_a(4, new EntityAIAttackOnCollide(this, EntityLivingBase.class, (double)1.0F, true));
        this.field_70714_bg.func_75776_a(7, new EntityAIWander(this, 0.8));
        this.field_70714_bg.func_75776_a(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.field_70714_bg.func_75776_a(9, new EntityAILookIdle(this));
        if (this.isMasterSubdued) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, true, this.allowPlayerPresence));
        } else if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SilverfishTitanSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
    }

    public void func_70106_y() {
        super.func_70106_y();
        if (this.master != null && this.master instanceof EntityTitan) {
            ((EntityTitan)this.master).retractMinionNumFromType(this.getMinionType());
        }

    }

    public boolean func_70650_aV() {
        return true;
    }

    public boolean func_70687_e(PotionEffect p_70687_1_) {
        return p_70687_1_.func_76456_a() == Potion.field_76436_u.field_76415_H ? false : super.func_70687_e(p_70687_1_);
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)10.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.25F);
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != EntitySilverfishMinion.class && p_70686_1_ != EntitySilverfishTitan.class;
    }

    protected void func_70069_a(float p_70069_1_) {
        if (this.getMinionTypeInt() != 4) {
            super.func_70069_a(p_70069_1_);
        }

        this.field_70701_bs = 0.0F;
        this.field_70702_br = 0.0F;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(19, 0);
    }

    public void setCombatTask() {
        this.field_70714_bg.func_85156_a(this.aiArrowAttack);
        if (this.attackPattern == 0 && this.getMinionTypeInt() == 4) {
            this.field_70714_bg.func_75776_a(0, this.aiArrowAttack);
        }

    }

    protected String func_70639_aQ() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanSilverfishLiving" : "mob.silverfish.say";
    }

    protected String func_70621_aR() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanSilverfishGrunt" : "mob.silverfish.hit";
    }

    protected String func_70673_aS() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanSilverfishDeath" : "mob.silverfish.kill";
    }

    protected float func_70647_i() {
        return this.getMinionTypeInt() == 4 ? super.func_70647_i() + 0.3F : super.func_70647_i();
    }

    protected float func_70672_c(DamageSource p_70672_1_, float p_70672_2_) {
        if (this.getMinionTypeInt() == 4) {
            p_70672_2_ = super.func_70672_c(p_70672_1_, p_70672_2_);
            if (p_70672_1_.func_76346_g() == this) {
                p_70672_2_ = 0.0F;
            }

            if (p_70672_1_.func_82725_o()) {
                p_70672_2_ = (float)((double)p_70672_2_ * 0.15);
            }

            return p_70672_2_;
        } else {
            return super.func_70672_c(p_70672_1_, p_70672_2_);
        }
    }

    public int func_70658_aO() {
        switch (this.getMinionTypeInt()) {
            case 1:
                return 2;
            case 2:
                return 15;
            case 3:
                return 18;
            case 4:
                return 22;
            default:
                return 0;
        }
    }

    public int getMinionTypeInt() {
        return this.field_70180_af.func_75679_c(19);
    }

    public EnumMinionType getMinionType() {
        switch (this.getMinionTypeInt()) {
            case 1:
                return EnumMinionType.PRIEST;
            case 2:
                return EnumMinionType.ZEALOT;
            case 3:
                return EnumMinionType.BISHOP;
            case 4:
                return EnumMinionType.TEMPLAR;
            default:
                return EnumMinionType.LOYALIST;
        }
    }

    public void setMinionType(int miniontype) {
        this.field_70180_af.func_75692_b(19, miniontype);
        if (miniontype == 1) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)16.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)2.0F);
            this.func_70606_j(16.0F);
            this.field_70728_aV = 15;
        } else if (miniontype == 2) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)60.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)7.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.5F);
            this.func_70606_j(60.0F);
            this.field_70728_aV = 100;
        } else if (miniontype == 3) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)200.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)15.0F);
            this.field_70178_ae = true;
            this.func_70606_j(200.0F);
            this.field_70728_aV = 200;
        } else if (miniontype == 4) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)1000.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)30.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
            this.field_70178_ae = true;
            this.func_70606_j(1000.0F);
            this.field_70728_aV = 1000;
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)10.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)1.0F);
            this.func_70606_j(10.0F);
            this.field_70728_aV = 6;
        }

    }

    public boolean func_70652_k(Entity p_70652_1_) {
        if (super.func_70652_k(p_70652_1_)) {
            if (p_70652_1_ instanceof EntityLivingBase && this.getMinionTypeInt() >= 3) {
                byte b0 = 10;
                if (this.field_70170_p.field_73013_u == EnumDifficulty.NORMAL) {
                    b0 = 20;
                } else if (this.field_70170_p.field_73013_u == EnumDifficulty.HARD) {
                    b0 = 30;
                }

                if (b0 > 0) {
                    ((EntityLivingBase)p_70652_1_).func_70690_d(new PotionEffect(ClientProxy.electricJudgment.field_76415_H, b0 * 20, 0));
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public void func_70636_d() {
        if (this.getMinionTypeInt() == 1) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)16.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)2.0F);
            this.field_70728_aV = 15;
        } else if (this.getMinionTypeInt() == 2) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)60.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)7.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.5F);
            this.field_70728_aV = 100;
        } else if (this.getMinionTypeInt() == 3) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)200.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)15.0F);
            this.field_70178_ae = true;
            this.field_70728_aV = 200;
        } else if (this.getMinionTypeInt() == 4) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)1000.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)30.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
            this.field_70178_ae = true;
            this.field_70728_aV = 1000;
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)10.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)1.0F);
            this.field_70728_aV = 6;
        }

        if (this.func_70089_S() || this.getMinionTypeInt() != 4) {
            super.func_70636_d();
        }

        if (this.getMinionTypeInt() == 3) {
            if (this.field_70146_Z.nextInt(120) == 0 && this.master == null && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntitySilverfishMinion entitychicken = new EntitySilverfishMinion(this.field_70170_p);
                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(0);
                this.field_70170_p.func_72838_d(entitychicken);
            }

            if (this.field_70146_Z.nextInt(240) == 0 && this.master == null && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntitySilverfishMinion entitychicken = new EntitySilverfishMinion(this.field_70170_p);
                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(1);
                this.field_70170_p.func_72838_d(entitychicken);
            }
        }

        if (this.field_70122_E && this.field_70123_F) {
            this.func_70664_aZ();
        }

        if (this.getMinionTypeInt() == 4) {
            if (this.field_70173_aa % 40 == 0) {
                this.func_70691_i(1.0F);
            }

            if (this.field_70170_p.field_73012_v.nextInt(150) == 1) {
                this.func_70691_i(2.0F);
            }

            if (this.field_70170_p.field_73012_v.nextInt(100) == 1 && (double)this.func_110143_aJ() < (double)this.func_110138_aP() * (double)0.75F) {
                this.func_70691_i(2.0F);
            }

            if (this.field_70170_p.field_73012_v.nextInt(35) == 1 && (double)this.func_110143_aJ() < (double)this.func_110138_aP() * (double)0.5F) {
                this.func_70691_i(5.0F);
            }

            if (this.field_70170_p.field_73012_v.nextInt(30) == 1 && (double)this.func_110143_aJ() < (double)this.func_110138_aP() * (double)0.25F) {
                this.func_70691_i(5.0F);
            }

            if (this.field_70170_p.field_73012_v.nextInt(30) == 1 && (double)this.func_110143_aJ() < (double)this.func_110138_aP() * 0.05) {
                this.func_70691_i(200.0F);
            }

            if (!this.field_70122_E && this.field_70181_x < (double)0.0F) {
                this.field_70181_x *= 0.6;
            }

            if (this.master == null && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.field_70146_Z.nextInt(60) == 0) {
                    EntitySilverfishMinion entitychicken = new EntitySilverfishMinion(this.field_70170_p);
                    entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(0);
                    this.field_70170_p.func_72838_d(entitychicken);
                }

                if (this.field_70146_Z.nextInt(120) == 0) {
                    EntitySilverfishMinion entitychicken = new EntitySilverfishMinion(this.field_70170_p);
                    entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(1);
                    this.field_70170_p.func_72838_d(entitychicken);
                }

                if (this.field_70146_Z.nextInt(240) == 0) {
                    EntitySilverfishMinion entitychicken = new EntitySilverfishMinion(this.field_70170_p);
                    entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(2);
                    this.field_70170_p.func_72838_d(entitychicken);
                }
            }

            if (this.field_70170_p.field_72995_K && !this.field_70122_E) {
                for(int i = 0; i < 3; ++i) {
                    this.field_70170_p.func_72869_a("explode", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                }
            }

            if (this.field_70146_Z.nextInt(60) == 0 && this.func_70638_az() != null) {
                this.setCombatTask();
                if (!this.field_70122_E) {
                    this.attackPattern = 0;
                } else {
                    this.attackPattern = 1;
                }
            }

            --this.heightOffsetUpdateTime;
            if (this.heightOffsetUpdateTime <= 0) {
                this.func_70664_aZ();
                this.heightOffsetUpdateTime = 100;
                this.heightOffset = 0.5F + (float)this.field_70146_Z.nextGaussian() * 3.0F;
                this.attackPattern = 0;
            }

            EntityLivingBase entitylivingbase = this.func_70638_az();
            if (this.attackPattern == 0 && entitylivingbase != null && !this.field_70170_p.field_72995_K) {
                if (entitylivingbase.field_70163_u + (double)entitylivingbase.func_70047_e() > this.field_70163_u + (double)this.func_70047_e() + (double)this.heightOffset) {
                    this.field_70181_x += 0.4 - this.field_70181_x;
                    this.field_70160_al = true;
                }

                this.func_70671_ap().func_75651_a(entitylivingbase, 180.0F, 40.0F);
                double d0 = entitylivingbase.field_70165_t - this.field_70165_t;
                double d1 = entitylivingbase.field_70161_v - this.field_70161_v;
                double d3 = d0 * d0 + d1 * d1;
                if (d3 > (double)(entitylivingbase.field_70130_N * entitylivingbase.field_70130_N + this.field_70130_N * this.field_70130_N) + (double)16.0F) {
                    double d5 = (double)MathHelper.func_76133_a(d3);
                    this.field_70159_w += d0 / d5 * 0.6 - this.field_70159_w;
                    this.field_70179_y += d1 / d5 * 0.6 - this.field_70179_y;
                }
            }

            if (this.func_70089_S() && !this.field_70170_p.field_72995_K && this.field_70146_Z.nextInt(1000) == 0 && this.func_70638_az() != null && this.func_110143_aJ() < this.func_110138_aP() / 2.0F && this.master == null) {
                for(int i = 0; i < 16; ++i) {
                    this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                    this.field_70170_p.func_72869_a("flame", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                }

                this.func_85030_a("thetitans:titanland", 10000.0F, 1.0F);
                this.TransformEntity(this);
            }

            if (this.field_70122_E) {
                this.field_70160_al = false;
            }

            List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)8.0F, (double)8.0F, (double)8.0F));
            if (!this.field_70170_p.field_72995_K && list11 != null && !list11.isEmpty() && this.field_70173_aa % (this.func_110143_aJ() < this.func_110138_aP() / 2.0F ? 40 : 160) == 0) {
                this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 8.0F, false);

                for(int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity = (Entity)list11.get(i1);
                    if (entity != null && entity instanceof EntityLivingBase && this.func_70686_a(entity.getClass())) {
                        entity.field_70181_x += this.field_70146_Z.nextDouble();
                        ((EntityLivingBase)entity).func_70690_d(new PotionEffect(ClientProxy.electricJudgment.field_76415_H, 10, 1));
                        this.field_70170_p.func_72889_a((EntityPlayer)null, 1017, (int)entity.field_70165_t, (int)entity.field_70163_u, (int)entity.field_70161_v, 0);
                    }
                }
            }
        }

        if (this.getMinionTypeInt() == 2 && this.func_70638_az() != null) {
            double d0 = this.func_70068_e(this.func_70638_az());
            if (d0 < (double)4.0F) {
                this.func_71038_i();
                this.func_70652_k(this.func_70638_az());
            }

            if (this.field_70146_Z.nextInt(40) == 0 && this.field_70122_E && d0 < (double)256.0F && this.func_70638_az().field_70163_u > this.field_70163_u + (double)3.0F) {
                this.func_70690_d(new PotionEffect(Potion.field_76430_j.field_76415_H, 60, 7));
                this.func_70625_a(this.func_70638_az(), 180.0F, 180.0F);
                double d01 = this.func_70638_az().field_70165_t - this.field_70165_t;
                double d1 = this.func_70638_az().field_70161_v - this.field_70161_v;
                float f2 = MathHelper.func_76133_a(d01 * d01 + d1 * d1);
                this.func_70664_aZ();
                this.field_70159_w = d01 / (double)f2 * (double)0.75F * (double)0.75F + this.field_70159_w * (double)0.75F;
                this.field_70179_y = d1 / (double)f2 * (double)0.75F * (double)0.75F + this.field_70179_y * (double)0.75F;
            }
        }

        if (this.getMinionTypeInt() == 1 && this.field_70173_aa % 40 == 0 && this.entityToHeal != null) {
            if (this.entityToHeal.func_110143_aJ() < this.entityToHeal.func_110138_aP()) {
                this.func_71038_i();
                this.func_70625_a(this.entityToHeal, 180.0F, (float)this.func_70646_bf());
                this.entityToHeal.func_70691_i(4.0F);
                this.func_85030_a("mob.wither.shoot", 1.0F, 3.0F);
            } else {
                this.entityToHeal = null;
            }
        }

        if (this.func_70638_az() != null && !this.func_70638_az().func_70089_S()) {
            this.func_70624_b((EntityLivingBase)null);
        }

        if (this.master != null) {
            if (this.func_70068_e(this.master) > (double)2304.0F) {
                this.func_70605_aq().func_75642_a(this.master.field_70165_t, this.master.field_70163_u, this.master.field_70161_v, (double)2.0F);
            }

            if (this.master.func_70638_az() != null) {
                if (this.master.func_70638_az().field_70131_O < 6.0F) {
                    this.func_70624_b(this.master.func_70638_az());
                } else {
                    this.func_70671_ap().func_75651_a(this.master.func_70638_az(), 10.0F, 40.0F);
                }
            }

            if (((EntitySilverfishTitan)this.master).isSubdued && this.func_70638_az() instanceof EntityPlayer) {
                this.func_70624_b((EntityLivingBase)null);
                this.isMasterSubdued = true;
            }
        } else {
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)100.0F, (double)100.0F, (double)100.0F));
            if (list != null && !list.isEmpty()) {
                for(int i11 = 0; i11 < list.size(); ++i11) {
                    Entity entity = (Entity)list.get(i11);
                    if (entity != null && entity instanceof EntitySilverfishTitan) {
                        this.master = (EntitySilverfishTitan)entity;
                    }
                }
            }
        }

    }

    public void TransformEntity(Entity entity) {
        entity.field_70170_p.func_72885_a(entity, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 18.0F, true, entity.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
        EntitySilverfishTitan entitytitan = new EntitySilverfishTitan(entity.field_70170_p);
        entitytitan.func_70012_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, entity.field_70177_z, 0.0F);
        entity.func_70106_y();
        entitytitan.func_82206_m();
        entity.field_70170_p.func_72838_d(entitytitan);
    }

    public String func_70005_c_() {
        switch (this.getMinionTypeInt()) {
            case 1:
                return StatCollector.func_74838_a("entity.SilverfishPriest.name");
            case 2:
                return StatCollector.func_74838_a("entity.SilverfishZealot.name");
            case 3:
                return StatCollector.func_74838_a("entity.SilverfishBishop.name");
            case 4:
                return StatCollector.func_74838_a("entity.SilverfishTemplar.name");
            default:
                return StatCollector.func_74838_a("entity.SilverfishLoyalist.name");
        }
    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        tagCompound.func_74768_a("MinionType", this.getMinionTypeInt());
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        this.setMinionType(tagCompund.func_74762_e("MinionType"));
    }

    protected Item func_146068_u() {
        return Items.field_151121_aF;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        Item item = this.func_146068_u();
        int j = this.field_70146_Z.nextInt(2);
        if (p_70628_2_ > 0) {
            j += this.field_70146_Z.nextInt(p_70628_2_ + 1);
        }

        for(int k = 0; k < j; ++k) {
            this.func_145779_a(item, 1);
        }

        if (this.field_70146_Z.nextInt(30) == 0 || this.field_70146_Z.nextInt(1 + p_70628_2_) > 0) {
            this.func_70099_a(new ItemStack(Blocks.field_150348_b), 0.0F);
        }

        if (this.getMinionTypeInt() >= 1) {
            j = this.field_70146_Z.nextInt(2);
            if (p_70628_2_ > 0) {
                j += this.field_70146_Z.nextInt(p_70628_2_ + 1);
            }

            for(int k = 0; k < j; ++k) {
                this.func_145779_a(Items.field_151062_by, 1);
            }

            if (this.getMinionTypeInt() >= 2) {
                j = this.field_70146_Z.nextInt(2);
                if (p_70628_2_ > 0) {
                    j += this.field_70146_Z.nextInt(p_70628_2_ + 1);
                }

                for(int k = 0; k < j; ++k) {
                    this.func_145779_a(Items.field_151153_ao, 1);
                }

                if (this.getMinionTypeInt() >= 3) {
                    j = this.field_70146_Z.nextInt(2);
                    if (p_70628_2_ > 0) {
                        j += this.field_70146_Z.nextInt(p_70628_2_ + 1);
                    }

                    for(int k = 0; k < j; ++k) {
                        switch (this.field_70146_Z.nextInt(5)) {
                            case 0:
                                this.func_145779_a(Items.field_151166_bC, 1);
                                break;
                            case 1:
                                this.func_145779_a(Items.field_151045_i, 1);
                                break;
                            case 2:
                                this.func_145779_a(Items.field_151043_k, 1);
                                break;
                            case 3:
                                this.func_145779_a(Items.field_151043_k, 1);
                                break;
                            case 4:
                                this.func_145779_a(Items.field_151043_k, 1);
                        }
                    }

                    if (this.getMinionTypeInt() >= 4) {
                        if (this.field_70146_Z.nextInt(5) == 0) {
                            this.func_70099_a(new ItemStack(TitanItems.pleasantBladeSeed), 0.0F);
                        }

                        if (this.field_70146_Z.nextInt(100) == 0) {
                            this.func_70099_a(new ItemStack(TitanItems.malgrumSeeds), 0.0F);
                        }

                        j = 2 + this.field_70146_Z.nextInt(5);
                        if (p_70628_2_ > 0) {
                            j += this.field_70146_Z.nextInt(p_70628_2_ + 1);
                        }

                        for(int k = 0; k < j; ++k) {
                            switch (this.field_70146_Z.nextInt(3)) {
                                case 0:
                                    this.func_145779_a(Items.field_151166_bC, 1);
                                    break;
                                case 1:
                                    this.func_145779_a(Items.field_151045_i, 1);
                                    break;
                                case 2:
                                    this.func_145779_a(Items.field_151043_k, 1);
                            }
                        }
                    }
                }
            }
        }

    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (!this.func_85032_ar() && (this.getMinionTypeInt() < 4 || source != DamageSourceExtra.radiation)) {
            if (!(source.func_76346_g() instanceof EntitySilverfishMinion) && !(source.func_76346_g() instanceof EntitySilverfishTitan)) {
                if (source.func_76346_g() != null && this.field_70702_br == 0.0F && this.getMinionType() == EnumMinionType.ZEALOT) {
                    this.field_70761_aq = this.field_70177_z = this.field_70759_as;
                    this.func_85030_a("thetitans:titanSwing", 1.0F, 2.0F);
                    switch (this.field_70146_Z.nextInt(3)) {
                        case 0:
                            this.field_70701_bs = -2.0F;
                            this.func_70060_a(0.0F, -2.0F, 0.99F);
                            this.field_70702_br = 0.01F;
                            break;
                        case 1:
                            this.field_70702_br = 1.0F;
                            this.func_70060_a(1.0F, 0.0F, 0.25F);
                            break;
                        case 2:
                            this.field_70702_br = -1.0F;
                            this.func_70060_a(-1.0F, 0.0F, 0.25F);
                    }

                    this.func_70664_aZ();
                    return false;
                } else {
                    Entity entity = source.func_76346_g();
                    if (entity instanceof EntityLivingBase) {
                        List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)32.0F, (double)32.0F, (double)32.0F));

                        for(int i = 0; i < list.size(); ++i) {
                            Entity entity1 = (Entity)list.get(i);
                            if (entity1 instanceof EntitySilverfishMinion) {
                                EntitySilverfishMinion entitypigzombie = (EntitySilverfishMinion)entity1;
                                entitypigzombie.func_70624_b((EntityLivingBase)entity);
                                entitypigzombie.func_70604_c((EntityLivingBase)entity);
                                entitypigzombie.randomSoundDelay = this.field_70146_Z.nextInt(40);
                            }

                            this.func_70624_b((EntityLivingBase)entity);
                            this.func_70604_c((EntityLivingBase)entity);
                            this.randomSoundDelay = this.field_70146_Z.nextInt(40);
                        }
                    }

                    return super.func_70097_a(source, amount);
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.func_71038_i();
        if (this.func_70068_e(p_82196_1_) < (double)(p_82196_1_.field_70130_N * p_82196_1_.field_70130_N) + (double)36.0F) {
            this.func_70652_k(p_82196_1_);
        } else {
            switch (this.field_70146_Z.nextInt(4)) {
                case 0:
                    EntityArrow entityarrow = new EntityArrow(this.field_70170_p, this, p_82196_1_, 1.6F, 1.0F);
                    entityarrow.func_70243_d(true);
                    entityarrow.func_70239_b((double)(p_82196_2_ * 2.0F) + this.field_70146_Z.nextGaussian() * (double)0.25F + (double)((float)this.field_70170_p.field_73013_u.func_151525_a() * 0.11F));
                    this.func_85030_a("random.bow", 1.0F, 1.0F / (this.func_70681_au().nextFloat() * 0.4F + 0.8F));
                    this.field_70170_p.func_72838_d(entityarrow);
                    break;
                case 1:
                    EntityPotion entitypotion = new EntityPotion(this.field_70170_p, this, 32732);
                    if (p_82196_1_.func_70662_br()) {
                        entitypotion.func_82340_a(32725);
                    }

                    double d0 = p_82196_1_.field_70163_u + (double)0.5F;
                    entitypotion.field_70125_A -= -20.0F;
                    double d1 = p_82196_1_.field_70165_t + p_82196_1_.field_70159_w - this.field_70165_t;
                    double d2 = d0 - this.field_70163_u;
                    double d3 = p_82196_1_.field_70161_v + p_82196_1_.field_70179_y - this.field_70161_v;
                    float f1 = MathHelper.func_76133_a(d1 * d1 + d3 * d3);
                    entitypotion.func_70186_c(d1, d2 + (double)(f1 * 0.2F), d3, 1.0F, f1 / 20.0F);
                    this.field_70170_p.func_72838_d(entitypotion);
                    break;
                case 2:
                    double d01 = this.func_70068_e(p_82196_1_);
                    double d11 = p_82196_1_.field_70165_t - this.field_70165_t;
                    double d21 = p_82196_1_.field_70121_D.field_72338_b + (double)(p_82196_1_.field_70131_O / 2.0F) - (this.field_70163_u + (double)(p_82196_1_.field_70131_O / 2.0F));
                    double d31 = p_82196_1_.field_70161_v - this.field_70161_v;
                    float f = MathHelper.func_76129_c(MathHelper.func_76133_a(d01)) * 0.1F;
                    this.field_70170_p.func_72889_a((EntityPlayer)null, 1009, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                    EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.field_70170_p, this, d11 + this.func_70681_au().nextGaussian() * (double)f, d21, d31 + this.func_70681_au().nextGaussian() * (double)f);
                    entitysmallfireball.field_70163_u = this.field_70163_u + (double)this.field_70131_O + 0.4;
                    this.field_70170_p.func_72838_d(entitysmallfireball);
                    break;
                case 3:
                    p_82196_1_.func_70097_a(DamageSource.field_76376_m, 10.0F);
                    this.func_85030_a("mob.wither.shoot", 1.0F, 3.0F);
                    int i = MathHelper.func_76128_c(p_82196_1_.field_70165_t + this.field_70146_Z.nextDouble());
                    int j = MathHelper.func_76128_c(p_82196_1_.field_70163_u + this.field_70146_Z.nextDouble());
                    int k = MathHelper.func_76128_c(p_82196_1_.field_70161_v + this.field_70146_Z.nextDouble());
                    Block block = this.field_70170_p.func_147439_a(i, j, k);
                    if (block.func_149688_o() == Material.field_151579_a) {
                        this.field_70170_p.func_147449_b(i, j, k, Blocks.field_150418_aU);
                    }
            }
        }

    }

    public IEntityLivingData func_110161_a(IEntityLivingData p_180482_2_) {
        Object p_180482_2_1 = super.func_110161_a(p_180482_2_);
        if (!this.field_70170_p.field_72995_K) {
            this.setMinionType(0);
            if (this.field_70146_Z.nextInt(2) == 0) {
                this.setMinionType(1);
                if (this.field_70146_Z.nextInt(2) == 0) {
                    this.setMinionType(2);
                    if (this.field_70146_Z.nextInt(2) == 0) {
                        this.setMinionType(3);
                        if (this.field_70146_Z.nextInt(2) == 0) {
                            this.setMinionType(4);
                        }
                    }
                }
            }
        }

        return (IEntityLivingData)p_180482_2_1;
    }

    protected void func_70619_bc() {
        this.field_70761_aq = this.field_70177_z = this.field_70759_as;
        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
            this.func_85030_a(this.func_70621_aR(), this.func_70599_aP(), this.func_70647_i() + 0.25F);
        }

        if (this.func_70638_az() != null && this.field_70170_p.field_73012_v.nextInt(5) == 1) {
            EntityLivingBase e = this.func_70638_az();
            if (e != null && this.func_70068_e(e) < (double)(this.field_70130_N * this.field_70130_N + e.field_70130_N * e.field_70130_N) + (double)4.0F && (this.field_70170_p.field_73012_v.nextInt(3) == 0 || this.field_70170_p.field_73012_v.nextInt(2) == 1)) {
                this.func_70652_k(e);
            }
        }

        if (this.field_70172_ad == 1) {
            int i = MathHelper.func_76128_c(this.field_70165_t);
            int j = MathHelper.func_76128_c(this.field_70163_u);
            int k = MathHelper.func_76128_c(this.field_70161_v);
            boolean flag = false;

            for(int l = 0; !flag && l <= 10 && l >= -10; l = l <= 0 ? 1 - l : 0 - l) {
                for(int i1 = 0; !flag && i1 <= 10 && i1 >= -10; i1 = i1 <= 0 ? 1 - i1 : 0 - i1) {
                    for(int j1 = 0; !flag && j1 <= 10 && j1 >= -10; j1 = j1 <= 0 ? 1 - j1 : 0 - j1) {
                        if (this.field_70170_p.func_147439_a(i + i1, j + l, k + j1) == Blocks.field_150418_aU) {
                            if (!this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                                int k1 = this.field_70170_p.func_72805_g(i + i1, j + l, k + j1);
                                ImmutablePair immutablepair = BlockSilverfish.func_150197_b(k1);
                                this.field_70170_p.func_147465_d(i + i1, j + l, k + j1, (Block)immutablepair.getLeft(), (Integer)immutablepair.getRight(), 3);
                            } else {
                                this.field_70170_p.func_147480_a(i + i1, j + l, k + j1, false);
                            }

                            EntitySilverfishMinion entitysilverfish = new EntitySilverfishMinion(this.field_70170_p);
                            entitysilverfish.func_70012_b((double)(i + i1) + (double)0.5F, (double)(j + l), (double)(k + j1) + (double)0.5F, 0.0F, 0.0F);
                            entitysilverfish.func_110161_a((IEntityLivingData)null);
                            if (!this.field_70170_p.field_72995_K) {
                                this.field_70170_p.func_72838_d(entitysilverfish);
                            }

                            this.field_70170_p.func_72876_a(entitysilverfish, entitysilverfish.field_70165_t, entitysilverfish.field_70163_u, entitysilverfish.field_70161_v, 2.0F, false);
                            entitysilverfish.func_70656_aK();
                            this.field_70170_p.func_147468_f(i + i1, j + l, k + j1);
                            if (this.field_70146_Z.nextBoolean()) {
                                flag = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        if (this.field_70123_F && this.master != null) {
            this.field_70181_x = 0.2;
        }

        super.func_70619_bc();
    }

    public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
        if (this.deathTicks > 0) {
            super.func_70091_d((double)0.0F, (double)0.1F, (double)0.0F);
        } else {
            super.func_70091_d(p_70091_1_, p_70091_3_, p_70091_5_);
        }

    }

    protected void func_70609_aI() {
        if (this.getMinionTypeInt() == 4) {
            --this.field_70173_aa;
            ++this.deathTicks;
            if (this.master != null) {
                double mx = this.field_70165_t - this.master.field_70165_t;
                double my = this.field_70163_u + (double)this.func_70047_e() - (this.master.field_70163_u + (double)this.master.func_70047_e());
                double mz = this.field_70161_v - this.master.field_70161_v;
                short short1 = (short)((int)(this.func_70032_d(this.master) * 2.0F));

                for(int f = 0; f < short1; ++f) {
                    double d9 = (double)f / ((double)short1 - (double)1.0F);
                    double d6 = this.field_70165_t + mx * -d9;
                    double d7 = this.field_70163_u + (double)this.func_70047_e() + my * -d9;
                    double d8 = this.field_70161_v + mz * -d9;
                    this.field_70170_p.func_72869_a("fireworksSpark", d6, d7, d8, this.master.field_70159_w, this.master.field_70181_x + 0.2, this.master.field_70179_y);
                }
            }

            if (!this.field_70170_p.field_72995_K) {
                if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
                    this.func_70628_a(true, 0);
                }

                if (this.deathTicks == 1) {
                    this.field_70170_p.func_82739_e(1018, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                }
            }

            if (this.deathTicks >= 180 && this.deathTicks <= 200) {
                float f = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70130_N;
                float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70131_O;
                float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70130_N;
                this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + (double)this.func_70047_e() + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
            }

            this.func_70091_d((double)0.0F, (double)0.1F, (double)0.0F);
            float f = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70130_N;
            float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70131_O;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70130_N;
            this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t + (double)f, this.field_70163_u + (double)this.func_70047_e() + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
            this.field_70170_p.func_72869_a("lava", this.field_70165_t + (double)f, this.field_70163_u + (double)this.func_70047_e() + (double)f1, this.field_70161_v + (double)f2, this.field_70146_Z.nextGaussian(), this.field_70146_Z.nextGaussian(), this.field_70146_Z.nextGaussian());
            if (this.deathTicks == 200 && !this.field_70170_p.field_72995_K) {
                if (this.master != null) {
                    this.master.func_70691_i(this.master.func_110138_aP() / 100.0F);

                    for(int i = 0; i < 100; ++i) {
                        double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                        double d0 = this.field_70146_Z.nextGaussian() * 0.02;
                        double d1 = this.field_70146_Z.nextGaussian() * 0.02;
                        this.field_70170_p.func_72869_a("largeexplode", this.master.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.master.field_70130_N * 2.0F) - (double)this.master.field_70130_N, this.master.field_70163_u + (double)(this.field_70146_Z.nextFloat() * this.master.field_70131_O), this.master.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.master.field_70130_N * 2.0F) - (double)this.master.field_70130_N, d2, d0, d1);
                    }
                }

                int i = this.field_70728_aV;

                while(i > 0) {
                    int j = EntityXPOrb.func_70527_a(i);
                    i -= j;
                    this.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, j));
                }

                this.func_70106_y();
            }
        } else {
            super.func_70609_aI();
        }

    }

    public class EntityAIFindEntityNearestInjuredAlly extends EntityAIBase {
        private EntitySilverfishMinion field_179434_b;
        private EntityLivingBase field_179433_e;

        public EntityAIFindEntityNearestInjuredAlly(EntitySilverfishMinion entityCaveSpiderPriest) {
            this.field_179434_b = entityCaveSpiderPriest;
        }

        public boolean func_75250_a() {
            if (!this.field_179434_b.func_70089_S()) {
                return false;
            } else if (this.field_179434_b.getMinionType() != EnumMinionType.PRIEST) {
                return false;
            } else if (this.field_179433_e != null) {
                return false;
            } else {
                double d0 = this.func_179431_f();
                List list = this.field_179434_b.field_70170_p.func_72872_a(EntitySilverfishMinion.class, this.field_179434_b.field_70121_D.func_72314_b(d0, d0, d0));
                if (list.isEmpty()) {
                    return false;
                } else {
                    for(int i = 0; i < list.size(); ++i) {
                        EntitySilverfishMinion entity = (EntitySilverfishMinion)list.get(i);
                        if (entity.func_110143_aJ() < entity.func_110138_aP() && entity.func_70089_S()) {
                            this.field_179433_e = entity;
                        }
                    }

                    return true;
                }
            }
        }

        public boolean func_75253_b() {
            EntityLivingBase entitylivingbase = this.field_179434_b.entityToHeal;
            if (entitylivingbase == null) {
                return false;
            } else if (!entitylivingbase.func_70089_S()) {
                return false;
            } else if (entitylivingbase.func_110143_aJ() >= entitylivingbase.func_110138_aP()) {
                return false;
            } else {
                double d0 = this.func_179431_f();
                return this.field_179434_b.func_70068_e(entitylivingbase) <= d0 * d0;
            }
        }

        public void func_75249_e() {
            this.field_179434_b.entityToHeal = (EntityLiving)this.field_179433_e;
            super.func_75249_e();
        }

        public void func_75251_c() {
            this.field_179434_b.entityToHeal = null;
            this.field_179433_e = null;
            super.func_75251_c();
        }

        public void func_75246_d() {
            if (this.field_179434_b.entityToHeal != null && (double)this.field_179434_b.func_70032_d(this.field_179434_b.entityToHeal) > (double)16.0F) {
                this.field_179434_b.func_70661_as().func_75497_a(this.field_179434_b.entityToHeal, (double)1.0F);
                this.field_179434_b.func_70671_ap().func_75651_a(this.field_179434_b.entityToHeal, 10.0F, (float)this.field_179434_b.func_70646_bf());
            }

        }

        protected double func_179431_f() {
            return (double)24.0F;
        }
    }

    public class EntityAIWander extends EntityAIBase {
        private EntityCreature entity;
        private double xPosition;
        private double yPosition;
        private double zPosition;
        private double speed;

        public EntityAIWander(EntityCreature p_i1648_1_, double p_i1648_2_) {
            this.entity = p_i1648_1_;
            this.speed = p_i1648_2_;
            this.func_75248_a(1);
        }

        public boolean func_75250_a() {
            if (this.entity.func_70654_ax() >= 100) {
                return false;
            } else if (this.entity.func_70681_au().nextInt(10) != 0) {
                return false;
            } else {
                Vec3 vec3 = RandomPositionGenerator.func_75463_a(this.entity, 10, 7);
                if (vec3 == null) {
                    return false;
                } else {
                    this.xPosition = vec3.field_72450_a;
                    this.yPosition = vec3.field_72448_b;
                    this.zPosition = vec3.field_72449_c;
                    return true;
                }
            }
        }

        public boolean func_75253_b() {
            return !this.entity.func_70661_as().func_75500_f();
        }

        public void func_75249_e() {
            this.entity.func_70661_as().func_75492_a(this.xPosition, this.yPosition, this.zPosition, this.speed);
        }
    }
}
