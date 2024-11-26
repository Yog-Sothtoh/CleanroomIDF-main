//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titanminion;

import java.util.Calendar;
import java.util.List;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanSpirit;
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
import net.minecraft.world.WorldProviderHell;

public class EntitySkeletonMinion extends EntitySkeleton implements IRangedAttackMob, ITemplar {
    public EntityAIArrowAttack field_85037_d = new EntityAIArrowAttack(this, 1.2, 10, 40, 24.0F);
    public EntityAIAttackOnCollide field_85038_e = new EntityAIAttackOnCollide(this, 1.2, true);
    public EntityLiving master;
    public boolean isReadyToAttack;
    public int randomSoundDelay;
    private int attackPattern;
    private float heightOffset = 0.5F;
    private int heightOffsetUpdateTime;
    public EntityLiving entityToHeal;
    public int deathTicks;

    public EntitySkeletonMinion(World worldIn) {
        super(worldIn);

        for(int i = 0; i < this.field_82174_bp.length; ++i) {
            this.field_82174_bp[i] = 0.2F;
        }

        this.func_70105_a(0.5F, 1.95F);
        this.func_70661_as().func_75498_b(true);
        this.func_70661_as().func_75490_c(true);
        this.field_70714_bg.func_75776_a(0, new EntityAIAvoidEntity(this, EntityWitherSkull.class, 2.0F, 1.2, (double)1.75F));
        this.field_70714_bg.func_75776_a(0, new EntityAIAvoidEntity(this, EntityTitanSpirit.class, 48.0F, (double)1.5F, (double)1.5F));
        this.field_70714_bg.func_75776_a(0, new EntityAIBreakDoorMinion(this));
        this.field_70714_bg.func_75776_a(1, new EntityAIMoveTowardsRestriction(this, 1.2));
        this.field_70714_bg.func_75776_a(1, new EntityAIRestrictSun(this));
        this.field_70714_bg.func_75776_a(1, new EntityAIFleeSun(this, 1.2));
        this.field_70714_bg.func_75776_a(0, new EntityAIFindEntityNearestInjuredAlly(this));
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SkeletonTitanSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

        if (worldIn != null && !worldIn.field_72995_K) {
            this.setAttackTask();
        }

    }

    protected int func_70693_a(EntityPlayer p_70693_1_) {
        if (this.func_82202_m() == 1) {
            this.field_70728_aV = (int)((float)this.field_70728_aV * 2.5F);
        }

        return super.func_70693_a(p_70693_1_);
    }

    public void func_70106_y() {
        super.func_70106_y();
        if (this.master != null && this.master instanceof EntityTitan) {
            ((EntityTitan)this.master).retractMinionNumFromType(this.getMinionType());
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

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != EntitySkeletonMinion.class && p_70686_1_ != EntitySkeletonTitan.class && p_70686_1_ != EntityWitherMinion.class;
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)50.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.25F);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)4.0F);
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

    protected String func_70639_aQ() {
        return this.getMinionTypeInt() == 4 ? (this.func_82202_m() == 1 ? "thetitans:titanWitherSkeletonLiving" : "thetitans:titanSkeletonLiving") : "mob.skeleton.say";
    }

    protected String func_70621_aR() {
        return this.getMinionTypeInt() == 4 ? (this.func_82202_m() == 1 ? "thetitans:titanWitherSkeletonGrunt" : "thetitans:titanSkeletonGrunt") : "mob.skeleton.hurt";
    }

    protected String func_70673_aS() {
        return this.getMinionTypeInt() == 4 ? (this.func_82202_m() == 1 ? "thetitans:titanWitherSkeletonDeath" : "thetitans:titanSkeletonDeath") : "mob.skeleton.death";
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
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)80.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)6.0F);
            this.field_70714_bg.func_75776_a(0, new EntityAIFindEntityNearestInjuredAlly(this));
            this.func_70606_j(80.0F);
            this.field_70728_aV = 15;
        } else if (miniontype == 2) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)300.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)10.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.5F);
            this.func_70606_j(300.0F);
            this.field_70728_aV = 100;
        } else if (miniontype == 3) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)1000.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)20.0F);
            this.field_70178_ae = true;
            this.func_70606_j(1000.0F);
            this.field_70728_aV = 200;
        } else if (miniontype == 4) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)4000.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)50.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
            this.field_70178_ae = true;
            this.func_70606_j(4000.0F);
            this.field_70728_aV = 1000;
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)40.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)4.0F);
            this.func_70606_j(40.0F);
            this.field_70728_aV = 6;
        }

        this.func_82201_a(this.func_82202_m());
    }

    public void TransformEntity(Entity entity) {
        entity.field_70170_p.func_72885_a(entity, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 18.0F, true, entity.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
        EntitySkeletonTitan entitytitan = new EntitySkeletonTitan(entity.field_70170_p);
        entitytitan.func_70012_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, entity.field_70177_z, 0.0F);
        entity.func_70106_y();
        entitytitan.func_82206_m();
        entity.field_70170_p.func_72838_d(entitytitan);
        if (this.func_82202_m() == 1) {
            entitytitan.becomeWitherSkeleton(true);
        } else {
            entitytitan.setSkeletonType(0);
            entitytitan.func_70062_b(0, new ItemStack(Items.field_151031_f));
        }

    }

    public void func_70636_d() {
        if (this.func_110143_aJ() > this.func_110138_aP()) {
            this.func_70606_j(this.func_110138_aP());
        }

        if (this.func_82202_m() == 1) {
            if (this.getMinionTypeInt() == 1) {
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)80.0F);
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)6.0F);
                this.field_70728_aV = 15;
            } else if (this.getMinionTypeInt() == 2) {
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)300.0F);
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)10.0F);
                this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.5F);
                this.field_70728_aV = 100;
            } else if (this.getMinionTypeInt() == 3) {
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)1000.0F);
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)20.0F);
                this.field_70178_ae = true;
                this.field_70728_aV = 200;
            } else if (this.getMinionTypeInt() == 4) {
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)4000.0F);
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)50.0F);
                this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
                this.field_70178_ae = true;
                this.field_70728_aV = 1000;
            } else {
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)40.0F);
                this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)4.0F);
                this.field_70728_aV = 6;
            }
        } else if (this.getMinionTypeInt() == 1) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)40.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)4.0F);
            this.field_70728_aV = 15;
        } else if (this.getMinionTypeInt() == 2) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)180.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)10.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.5F);
            this.field_70728_aV = 100;
        } else if (this.getMinionTypeInt() == 3) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)400.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)15.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.375F);
            this.field_70178_ae = true;
            this.field_70728_aV = 200;
        } else if (this.getMinionTypeInt() == 4) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)1800.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)30.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
            this.field_70178_ae = true;
            this.field_70728_aV = 1000;
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)26.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)3.0F);
            this.field_70728_aV = 7;
        }

        this.field_70714_bg.func_85156_a(new EntityAIArrowAttack(this, (double)1.0F, 20, 60, 15.0F));
        this.field_70714_bg.func_85156_a(new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2, false));
        if (this.func_70638_az() != null && this.func_70068_e(this.func_70638_az()) > (double)256.0F) {
            this.func_70605_aq().func_75642_a(this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, (double)1.0F);
        }

        if (this.func_70638_az() != null) {
            this.func_70604_c(this.func_70638_az());
        }

        if (this.field_70170_p.field_72995_K && this.func_82202_m() == 1) {
            this.func_70105_a(0.6F, 2.39F);
        }

        if (this.func_70089_S() || this.getMinionTypeInt() != 4) {
            super.func_70636_d();
        }

        if (this.getMinionTypeInt() == 3) {
            if (this.field_70146_Z.nextInt(120) == 0 && this.master == null && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntitySkeletonMinion entitychicken = new EntitySkeletonMinion(this.field_70170_p);
                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(0);
                entitychicken.func_82201_a(this.func_82202_m());
                this.field_70170_p.func_72838_d(entitychicken);
            }

            if (this.field_70146_Z.nextInt(240) == 0 && this.master == null && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntitySkeletonMinion entitychicken = new EntitySkeletonMinion(this.field_70170_p);
                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(1);
                entitychicken.func_82201_a(this.func_82202_m());
                this.field_70170_p.func_72838_d(entitychicken);
            }
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
                    EntitySkeletonMinion entitychicken = new EntitySkeletonMinion(this.field_70170_p);
                    entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(0);
                    entitychicken.func_82201_a(this.func_82202_m());
                    this.field_70170_p.func_72838_d(entitychicken);
                }

                if (this.field_70146_Z.nextInt(120) == 0) {
                    EntitySkeletonMinion entitychicken = new EntitySkeletonMinion(this.field_70170_p);
                    entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(1);
                    entitychicken.func_82201_a(this.func_82202_m());
                    this.field_70170_p.func_72838_d(entitychicken);
                }

                if (this.field_70146_Z.nextInt(240) == 0) {
                    EntitySkeletonMinion entitychicken = new EntitySkeletonMinion(this.field_70170_p);
                    entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(2);
                    entitychicken.func_82201_a(this.func_82202_m());
                    this.field_70170_p.func_72838_d(entitychicken);
                }
            }

            if (this.field_70170_p.field_72995_K && !this.field_70122_E) {
                for(int i = 0; i < 3; ++i) {
                    this.field_70170_p.func_72869_a("explode", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                }
            }

            if (this.field_70146_Z.nextInt(60) == 0 && this.func_70638_az() != null) {
                this.func_85036_m();
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
        } else {
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)100.0F, (double)100.0F, (double)100.0F));
            if (list != null && !list.isEmpty()) {
                for(int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity != null && entity instanceof EntitySkeletonTitan && this.func_82202_m() == ((EntitySkeletonTitan)entity).getSkeletonType()) {
                        this.master = (EntitySkeletonTitan)entity;
                    }
                }
            }
        }

    }

    protected void func_70619_bc() {
        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
            this.func_85030_a(this.func_70621_aR(), this.func_70599_aP(), this.func_70647_i() + 0.25F);
        }

        if (this.field_70123_F && this.master != null) {
            this.field_70181_x = 0.2;
        }

        if (this.func_70638_az() != null && this.field_70170_p.field_73012_v.nextInt(5) == 1) {
            EntityLivingBase e = this.func_70638_az();
            if (e != null && this.func_70068_e(e) < (double)(this.field_70130_N * this.field_70130_N + e.field_70130_N * e.field_70130_N) + (double)16.0F && (this.field_70170_p.field_73012_v.nextInt(3) == 0 || this.field_70170_p.field_73012_v.nextInt(2) == 1)) {
                this.func_70652_k(e);
            }
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

    public void func_70098_U() {
        super.func_70098_U();
        if (this.field_70154_o instanceof EntitySpiderMinion) {
            EntitySpiderMinion entitycreature = (EntitySpiderMinion)this.field_70154_o;
            entitycreature.field_70761_aq = this.field_70761_aq;
            entitycreature.field_70177_z = this.field_70177_z;
            entitycreature.field_70759_as = this.field_70759_as;
            if (this.func_70638_az() != null) {
                entitycreature.func_70624_b(this.func_70638_az());
            }

            if (this.func_70638_az() == entitycreature) {
                this.field_70154_o = null;
            }
        }

    }

    public String func_70005_c_() {
        if (this.func_82202_m() == 1) {
            switch (this.getMinionTypeInt()) {
                case 1:
                    return StatCollector.func_74838_a("entity.WitherSkeletonPriest.name");
                case 2:
                    return StatCollector.func_74838_a("entity.WitherSkeletonZealot.name");
                case 3:
                    return StatCollector.func_74838_a("entity.WitherSkeletonBishop.name");
                case 4:
                    return StatCollector.func_74838_a("entity.WitherSkeletonTemplar.name");
                default:
                    return StatCollector.func_74838_a("entity.WitherSkeletonLoyalist.name");
            }
        } else {
            switch (this.getMinionTypeInt()) {
                case 1:
                    return StatCollector.func_74838_a("entity.SkeletonPriest.name");
                case 2:
                    return StatCollector.func_74838_a("entity.SkeletonZealot.name");
                case 3:
                    return StatCollector.func_74838_a("entity.SkeletonBishop.name");
                case 4:
                    return StatCollector.func_74838_a("entity.SkeletonTemplar.name");
                default:
                    return StatCollector.func_74838_a("entity.SkeletonLoyalist.name");
            }
        }
    }

    protected Item getDefaultEquipment() {
        switch (this.getMinionTypeInt()) {
            case 1:
                return Items.field_151036_c;
            case 2:
                return Items.field_151040_l;
            case 3:
                return Items.field_151056_x;
            case 4:
                return Items.field_151048_u;
            default:
                return Items.field_151052_q;
        }
    }

    protected Item func_146068_u() {
        return Items.field_151032_g;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        int j = this.field_70146_Z.nextInt(3 + p_70628_2_);

        for(int k = 0; k < j; ++k) {
            this.func_145779_a(Items.field_151103_aS, 1);
        }

        j = this.field_70146_Z.nextInt(5 + p_70628_2_);

        for(int k = 0; k < j; ++k) {
            this.func_70099_a(new ItemStack(Items.field_151100_aR, 1, 15), 0.0F);
        }

        if (this.func_82202_m() == 1) {
            j = this.field_70146_Z.nextInt(3 + p_70628_2_) - 1;

            for(int k = 0; k < j; ++k) {
                this.func_145779_a(Items.field_151044_h, 1);
            }

            if (this.getMinionTypeInt() >= 1) {
                j = 1 + this.field_70146_Z.nextInt(4);
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
                        if (this.field_70146_Z.nextInt(10) == 0) {
                            this.func_70099_a(new ItemStack(Items.field_151153_ao, 1, 1), 0.0F);
                        } else {
                            this.func_145779_a(Items.field_151153_ao, 1);
                        }
                    }

                    if (this.getMinionTypeInt() >= 3) {
                        j = this.field_70146_Z.nextInt(2);
                        if (p_70628_2_ > 0) {
                            j += this.field_70146_Z.nextInt(p_70628_2_ + 1);
                        }

                        for(int k = 0; k < j; ++k) {
                            switch (this.field_70146_Z.nextInt(5)) {
                                case 0:
                                    this.func_70099_a(new ItemStack(Blocks.field_150475_bE, 1, 0), 0.0F);
                                    break;
                                case 1:
                                    this.func_70099_a(new ItemStack(Blocks.field_150484_ah, 1, 0), 0.0F);
                                    break;
                                case 2:
                                    this.func_70099_a(new ItemStack(Blocks.field_150340_R, 1, 0), 0.0F);
                                    break;
                                case 3:
                                    this.func_70099_a(new ItemStack(Blocks.field_150340_R, 1, 0), 0.0F);
                                    break;
                                case 4:
                                    this.func_70099_a(new ItemStack(Blocks.field_150340_R, 1, 0), 0.0F);
                            }
                        }

                        this.func_70099_a(new ItemStack(Blocks.field_150343_Z), 0.0F);
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
                                        this.func_70099_a(new ItemStack(Blocks.field_150475_bE, 1, 0), 0.0F);
                                        break;
                                    case 1:
                                        this.func_70099_a(new ItemStack(Blocks.field_150484_ah, 1, 0), 0.0F);
                                        break;
                                    case 2:
                                        this.func_70099_a(new ItemStack(Blocks.field_150340_R, 1, 0), 0.0F);
                                }
                            }

                            this.func_70099_a(new ItemStack(Blocks.field_150343_Z), 0.0F);
                        }
                    }
                }
            }
        } else {
            j = this.field_70146_Z.nextInt(3 + p_70628_2_);

            for(int k = 0; k < j; ++k) {
                this.func_145779_a(Items.field_151032_g, 1);
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

    }

    protected void func_70600_l(int p_70600_1_) {
        if (this.func_82202_m() == 1) {
            this.func_70099_a(new ItemStack(Items.field_151144_bL, 1, 1), 0.0F);
        } else {
            this.func_70099_a(new ItemStack(Items.field_151144_bL, 1, 0), 0.0F);
        }

    }

    protected void func_82164_bB() {
        if (this.field_70146_Z.nextFloat() < (this.field_70170_p.field_73013_u == EnumDifficulty.NORMAL ? 0.25F : (this.field_70170_p.field_73013_u == EnumDifficulty.HARD ? 0.95F : 0.05F))) {
            int i = this.field_70146_Z.nextInt(2);
            float f = this.field_70170_p.field_73013_u == EnumDifficulty.HARD ? 0.75F : 0.05F;
            if (this.field_70146_Z.nextFloat() < 0.25F) {
                ++i;
            }

            if (this.field_70146_Z.nextFloat() < 0.25F) {
                ++i;
            }

            if (this.field_70146_Z.nextFloat() < 0.25F) {
                ++i;
            }

            for(int j = 3; j >= 0; --j) {
                ItemStack itemstack = this.func_130225_q(j);
                if (j < 3 && this.field_70146_Z.nextFloat() < f) {
                    break;
                }

                if (itemstack == null) {
                    Item item = func_82161_a(j + 1, i);
                    if (item != null) {
                        this.func_70062_b(j + 1, new ItemStack(item));
                    }
                }
            }
        }

        this.func_70062_b(0, new ItemStack(Items.field_151031_f));
    }

    public IEntityLivingData func_110161_a(IEntityLivingData p_180482_2_) {
        this.func_82164_bB();
        this.func_82162_bC();
        if ((!(this.field_70170_p.field_73011_w instanceof WorldProviderHell) || this.func_70681_au().nextInt(5) <= 0) && this.func_82202_m() != 1) {
            this.field_70714_bg.func_75776_a(3, this.field_85037_d);
            this.func_82201_a(0);
            this.func_70062_b(0, new ItemStack(Items.field_151031_f));
        } else {
            this.field_70714_bg.func_75776_a(3, this.field_85038_e);
            this.func_82201_a(1);
            this.func_70062_b(0, new ItemStack(this.getDefaultEquipment()));
        }

        float f = this.field_70170_p.func_147462_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.func_98053_h(true);
        Calendar calendar = this.field_70170_p.func_83015_S();
        if (!this.func_70631_g_() && calendar.get(2) + 1 == 10 && calendar.get(5) >= 1 && calendar.get(5) <= 31 && this.field_70146_Z.nextFloat() < 0.5F) {
            this.func_70062_b(4, new ItemStack(this.field_70146_Z.nextFloat() < 0.1F ? Blocks.field_150428_aP : Blocks.field_150423_aK));
            this.field_82174_bp[4] = 0.0F;
        }

        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111121_a(new AttributeModifier("Random spawn bonus", this.field_70146_Z.nextDouble() * 0.1, 0));
        double d0 = this.field_70146_Z.nextDouble() * (double)1.5F * (double)f;
        if (d0 > (double)1.0F) {
            this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111121_a(new AttributeModifier("Random zombie-spawn bonus", d0, 2));
        }

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

        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111121_a(new AttributeModifier("Random spawn bonus", this.field_70146_Z.nextGaussian() * 0.05, 1));
        return p_180482_2_;
    }

    public void func_85036_m() {
    }

    public void setAttackTask() {
        this.field_70714_bg.func_85156_a(this.field_85038_e);
        this.field_70714_bg.func_85156_a(this.field_85037_d);
        ItemStack itemstack = this.func_70694_bm();
        if (itemstack != null && itemstack.func_77973_b() == Items.field_151031_f) {
            this.field_70714_bg.func_75776_a(3, this.field_85037_d);
        } else {
            this.field_70714_bg.func_75776_a(3, this.field_85038_e);
        }

    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        tagCompound.func_74768_a("MinionType", this.getMinionTypeInt());
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        this.setMinionType(tagCompund.func_74762_e("MinionType"));
        this.setAttackTask();
    }

    public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {
        super.func_70062_b(p_70062_1_, p_70062_2_);
        if (!this.field_70170_p.field_72995_K && p_70062_1_ == 0) {
            this.setAttackTask();
        }

    }

    public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
        if (this.getMinionTypeInt() == 4) {
            if (this.func_70068_e(p_82196_1_) < (double)(p_82196_1_.field_70130_N * p_82196_1_.field_70130_N) + (double)36.0F) {
                this.func_70652_k(p_82196_1_);
            } else if (this.func_82202_m() == 1) {
                switch (this.field_70146_Z.nextInt(5)) {
                    case 0:
                        for(int i = 0; i < 100; ++i) {
                            EntityHarcadiumArrow entityarrow = new EntityHarcadiumArrow(this.field_70170_p, this, p_82196_1_, 4.0F, 45.0F);
                            entityarrow.func_70243_d(true);
                            entityarrow.func_70239_b((double)(p_82196_2_ * 2.0F) + this.field_70146_Z.nextGaussian() * (double)0.25F + (double)((float)this.field_70170_p.field_73013_u.func_151525_a() * 0.11F));
                            this.field_70170_p.func_72838_d(entityarrow);
                            double d8 = (double)4.0F;
                            Vec3 vec3 = this.func_70676_i(1.0F);
                            entityarrow.field_70165_t = this.field_70165_t + vec3.field_72450_a * d8;
                            entityarrow.field_70163_u = this.field_70163_u + vec3.field_72448_b * d8 + (double)1.0F;
                            entityarrow.field_70161_v = this.field_70161_v + vec3.field_72449_c * d8;
                        }
                        break;
                    case 1:
                        for(int i = 0; i < 200; ++i) {
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
                            entitypotion.func_70186_c(d1, d2 + (double)(f1 * 0.2F), d3, 2.0F, 25.0F);
                            this.field_70170_p.func_72838_d(entitypotion);
                        }
                        break;
                    case 2:
                        for(int i = 0; i < 50; ++i) {
                            this.func_70068_e(p_82196_1_);
                            double d11 = p_82196_1_.field_70165_t - this.field_70165_t;
                            double d21 = p_82196_1_.field_70121_D.field_72338_b + (double)(p_82196_1_.field_70131_O / 2.0F) - (this.field_70163_u + (double)(p_82196_1_.field_70131_O / 2.0F));
                            double d31 = p_82196_1_.field_70161_v - this.field_70161_v;
                            EntityGhastMinionFireball entitysmallfireball = new EntityGhastMinionFireball(this.field_70170_p, this, d11 + this.func_70681_au().nextGaussian() * (double)9.0F, d21, d31 + this.func_70681_au().nextGaussian() * (double)9.0F);
                            double d8 = (double)2.0F;
                            Vec3 vec3 = this.func_70676_i(1.0F);
                            entitysmallfireball.field_70165_t = this.field_70165_t + vec3.field_72450_a * d8;
                            entitysmallfireball.field_70163_u = this.field_70163_u + vec3.field_72448_b * d8 + (double)1.0F;
                            entitysmallfireball.field_70161_v = this.field_70161_v + vec3.field_72449_c * d8;
                            entitysmallfireball.field_92057_e = 2;
                            this.field_70170_p.func_72838_d(entitysmallfireball);
                        }
                        break;
                    case 3:
                        this.field_70170_p.func_72885_a(this, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v, 2.0F * p_82196_1_.field_70130_N, false, false);
                        p_82196_1_.func_70097_a(DamageSourceExtra.lightningBolt, 100.0F);
                        this.field_70170_p.func_72942_c(new EntityLightningBolt(this.field_70170_p, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v));
                        this.field_70170_p.func_72942_c(new EntityLightningBolt(this.field_70170_p, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v));
                        this.field_70170_p.func_72942_c(new EntityLightningBolt(this.field_70170_p, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v));
                        this.field_70170_p.func_72942_c(new EntityLightningBolt(this.field_70170_p, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v));
                        break;
                    case 4:
                        this.func_85030_a("mob.skeleton.death", 1.0F, 0.5F);
                        this.field_70170_p.func_72908_a(p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v, "random.explode", 4.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 0.7F);

                        for(int i1 = 0; i1 < 256; ++i1) {
                            EntityItem entityitem = p_82196_1_.func_145779_a(Items.field_151103_aS, 1);
                            entityitem.field_70181_x = (double)1.0F;
                            entityitem.field_145804_b = 6000;
                            entityitem.lifespan = 40 + this.field_70146_Z.nextInt(20);
                        }

                        p_82196_1_.func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 400, 3));
                        p_82196_1_.func_70097_a(DamageSource.field_82727_n, 20.0F);
                        p_82196_1_.field_70172_ad = 1;
                }
            } else {
                switch (this.field_70146_Z.nextInt(5)) {
                    case 0:
                        EntityArrow entityarrow = new EntityArrow(this.field_70170_p, this, p_82196_1_, 1.6F, (float)(14 - this.field_70170_p.field_73013_u.func_151525_a() * 4));
                        int i = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, this.func_70694_bm());
                        int j = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, this.func_70694_bm());
                        entityarrow.func_70239_b((double)(p_82196_2_ * 2.0F) + this.field_70146_Z.nextGaussian() * (double)0.25F + (double)((float)this.field_70170_p.field_73013_u.func_151525_a() * 0.11F));
                        entityarrow.func_70243_d(true);
                        if (i > 0) {
                            entityarrow.func_70239_b(entityarrow.func_70242_d() + (double)i * (double)0.5F + (double)0.5F);
                        }

                        if (j > 0) {
                            entityarrow.func_70240_a(j);
                        }

                        if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, this.func_70694_bm()) > 0 || this.func_82202_m() == 1) {
                            entityarrow.func_70015_d(100);
                        }

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
                        entitypotion.func_70186_c(d1, d2 + (double)(f1 * 0.2F), d3, 1.6F, f1 / 20.0F);
                        this.field_70170_p.func_72838_d(entitypotion);
                        break;
                    case 2:
                        double d011 = this.func_70068_e(p_82196_1_);
                        double d111 = p_82196_1_.field_70165_t - this.field_70165_t;
                        double d211 = p_82196_1_.field_70121_D.field_72338_b + (double)(p_82196_1_.field_70131_O / 2.0F) - (this.field_70163_u + (double)(p_82196_1_.field_70131_O / 2.0F));
                        double d311 = p_82196_1_.field_70161_v - this.field_70161_v;
                        float f = MathHelper.func_76129_c(MathHelper.func_76133_a(d011)) * 0.1F;
                        this.field_70170_p.func_72889_a((EntityPlayer)null, 1009, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                        EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.field_70170_p, this, d111 + this.func_70681_au().nextGaussian() * (double)f, d211, d311 + this.func_70681_au().nextGaussian() * (double)f);
                        entitysmallfireball.field_70163_u = this.field_70163_u + 1.6;
                        this.field_70170_p.func_72838_d(entitysmallfireball);
                        break;
                    case 3:
                        this.func_85030_a("mob.skeleton.death", 1.0F, 0.5F);
                        this.field_70170_p.func_72908_a(p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v, "random.explode", 4.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 0.7F);

                        for(int i1 = 0; i1 < 256; ++i1) {
                            EntityItem entityitem = p_82196_1_.func_145779_a(Items.field_151103_aS, 1);
                            entityitem.field_70181_x = (double)1.0F;
                            entityitem.field_145804_b = 6000;
                            entityitem.lifespan = 40 + this.field_70146_Z.nextInt(20);
                        }

                        p_82196_1_.func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 100, 2));
                        p_82196_1_.func_70097_a(DamageSource.field_82727_n, 5.0F);
                        p_82196_1_.field_70172_ad = 1;
                        break;
                    case 4:
                        EntityHarcadiumArrow entityarrow1 = new EntityHarcadiumArrow(this.field_70170_p, this, p_82196_1_, 1.6F, 1.0F);
                        entityarrow1.func_70243_d(true);
                        this.func_85030_a("random.bow", 1.0F, 1.0F / (this.func_70681_au().nextFloat() * 0.4F + 0.8F));
                        this.field_70170_p.func_72838_d(entityarrow1);
                }
            }
        } else {
            EntityArrow entityarrow = new EntityArrow(this.field_70170_p, this, p_82196_1_, 1.6F, (float)(14 - this.field_70170_p.field_73013_u.func_151525_a() * 4));
            int i = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, this.func_70694_bm());
            int j = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, this.func_70694_bm());
            entityarrow.func_70239_b((double)(p_82196_2_ * 2.0F) + this.field_70146_Z.nextGaussian() * (double)0.25F + (double)((float)this.field_70170_p.field_73013_u.func_151525_a() * 0.11F) + (double)(this.getMinionTypeInt() * 3));
            if (i > 0) {
                entityarrow.func_70239_b(entityarrow.func_70242_d() + (double)i * (double)0.5F + (double)0.5F);
            }

            if (j > 0) {
                entityarrow.func_70240_a(j);
            }

            if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, this.func_70694_bm()) > 0 || this.func_82202_m() == 1) {
                entityarrow.func_70015_d(100);
            }

            this.func_85030_a("random.bow", 1.0F, 1.0F / (this.func_70681_au().nextFloat() * 0.4F + 0.8F));
            this.field_70170_p.func_72838_d(entityarrow);
        }

    }

    public int func_82202_m() {
        return this.field_70180_af.func_75683_a(13);
    }

    public void func_82201_a(int p_82201_1_) {
        this.field_70180_af.func_75692_b(13, (byte)p_82201_1_);
        this.field_70178_ae = p_82201_1_ == 1 || this.getMinionTypeInt() >= 3;
        if (p_82201_1_ == 1) {
            this.func_70105_a(0.6F, 2.39F);
            this.func_70062_b(0, new ItemStack(this.getDefaultEquipment()));
        } else {
            this.func_70105_a(0.5F, 1.95F);
            this.func_70062_b(0, new ItemStack(Items.field_151031_f));
        }

    }

    public float func_70047_e() {
        return this.func_82202_m() == 1 ? 2.088F : 1.74F;
    }

    public double func_70033_W() {
        return this.func_82202_m() == 1 ? super.func_70033_W() - 0.28 : super.func_70033_W() - 0.15;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (!this.func_85032_ar() && (this.getMinionTypeInt() < 4 || source != DamageSourceExtra.radiation)) {
            if (source == DamageSource.field_82727_n && this.func_82202_m() == 1) {
                return false;
            } else if (!(source.func_76346_g() instanceof EntitySkeletonMinion) && !(source.func_76346_g() instanceof EntitySkeletonTitan) && !(source.func_76346_g() instanceof EntityWitherMinion)) {
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
                            if (entity1 instanceof EntitySkeletonMinion) {
                                EntitySkeletonMinion entitypigzombie = (EntitySkeletonMinion)entity1;
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

    public class EntityAIFindEntityNearestInjuredAlly extends EntityAIBase {
        private EntitySkeletonMinion field_179434_b;
        private EntityLivingBase field_179433_e;

        public EntityAIFindEntityNearestInjuredAlly(EntitySkeletonMinion entityCaveSpiderPriest) {
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
                List list = this.field_179434_b.field_70170_p.func_72872_a(EntitySkeletonMinion.class, this.field_179434_b.field_70121_D.func_72314_b(d0, d0, d0));
                if (list.isEmpty()) {
                    return false;
                } else {
                    for(int i = 0; i < list.size(); ++i) {
                        EntitySkeletonMinion entity = (EntitySkeletonMinion)list.get(i);
                        if (entity.func_110143_aJ() < entity.func_110138_aP() && entity.func_70089_S() && entity.func_82202_m() == this.field_179434_b.func_82202_m()) {
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
            return (double)32.0F;
        }
    }
}
