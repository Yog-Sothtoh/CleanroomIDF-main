//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titanminion;

import java.util.IdentityHashMap;
import java.util.List;
import net.minecraft.block.Block;
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
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titan.EntityEnderColossusCrystal;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
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
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityEndermanMinion extends EntityEnderman implements IRangedAttackMob, ITemplar {
    /** @deprecated */
    @Deprecated
    private static boolean[] carriableBlocks = new boolean[256];
    private boolean isAggressive;
    public EntityLiving master;
    public int randomSoundDelay;
    private static IdentityHashMap<Block, Boolean> carriable;
    public EntityLiving entityToHeal;
    private int attackPattern;
    private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, (double)1.0F, 5, 64.0F);
    private float heightOffset = 0.5F;
    private int heightOffsetUpdateTime;
    public int deathTicks;

    public EntityEndermanMinion(World worldIn) {
        super(worldIn);
        this.func_70105_a(0.5F, 2.88F);
        this.field_70138_W = 1.0F;
        this.func_70661_as().func_75498_b(true);
        this.func_70661_as().func_75490_c(true);
        this.func_70661_as().func_75495_e(true);
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
        this.field_70714_bg.func_75776_a(0, new EntityAIAvoidEntity(this, EntityWitherSkull.class, 2.0F, (double)1.0F, (double)1.75F));
        this.field_70714_bg.func_75776_a(0, new EntityAIAvoidEntity(this, EntityTitanSpirit.class, 48.0F, (double)1.5F, (double)1.5F));
        this.field_70714_bg.func_75776_a(0, new EntityAIBreakDoorMinion(this));
        this.field_70714_bg.func_75776_a(1, new EntityAIMoveTowardsRestriction(this, 1.2));
        this.field_70714_bg.func_75776_a(2, new EntityAIAttackOnCollide(this, (double)1.0F, true));
        this.field_70714_bg.func_75776_a(7, new EntityAIWander(this, (double)0.5F));
        this.field_70714_bg.func_75776_a(8, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
        this.field_70714_bg.func_75776_a(8, new EntityAILookIdle(this));
        this.field_70714_bg.func_75776_a(0, new EntityAIFindEntityNearestInjuredAlly(this));
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.EnderColossusSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLiving.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

    }

    public String func_70005_c_() {
        switch (this.getMinionTypeInt()) {
            case 1:
                return StatCollector.func_74838_a("entity.EndermanPriest.name");
            case 2:
                return StatCollector.func_74838_a("entity.EndermanZealot.name");
            case 3:
                return StatCollector.func_74838_a("entity.EndermanBishop.name");
            case 4:
                return StatCollector.func_74838_a("entity.EndermanTemplar.name");
            default:
                return StatCollector.func_74838_a("entity.EndermanLoyalist.name");
        }
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

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a((double)48.0F);
        this.setMinionType(this.getMinionTypeInt());
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != EntityEnderman.class && p_70686_1_ != EntityEndermanMinion.class && p_70686_1_ != EntityEnderColossus.class && p_70686_1_ != EntityDragon.class && p_70686_1_ != EntityDragonMinion.class && p_70686_1_ != EntityEnderColossusCrystal.class;
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
        return this.getMinionTypeInt() == 4 ? (this.func_70823_r() ? "thetitans:titanEnderColossusScreamLong" : "thetitans:titanEnderColossusLiving") : (this.func_70823_r() ? "mob.endermen.scream" : "mob.endermen.idle");
    }

    protected String func_70621_aR() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanEnderColossusGrunt" : "mob.endermen.hit";
    }

    protected String func_70673_aS() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanEnderColossusDeath" : "mob.endermen.death";
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
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)90.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)9.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.45);
            this.func_70606_j(90.0F);
            this.field_70728_aV = 30;
        } else if (miniontype == 2) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)700.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)20.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.5F);
            this.func_70606_j(700.0F);
            this.field_70728_aV = 200;
        } else if (miniontype == 3) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)1600.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)40.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.6);
            this.field_70178_ae = true;
            this.func_70606_j(1600.0F);
            this.field_70728_aV = 500;
        } else if (miniontype == 4) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)3000.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)100.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.75F);
            this.field_70178_ae = true;
            this.func_70606_j(3000.0F);
            this.field_70728_aV = 3000;
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)60.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)7.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.4);
            this.func_70606_j(60.0F);
            this.field_70728_aV = 15;
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

    protected Entity findPlayerToLookAt() {
        EntityPlayer entityplayer = this.field_70170_p.func_72890_a(this, (double)64.0F);
        if (entityplayer != null && this.isPlayerRegistered(entityplayer) && !entityplayer.field_71075_bZ.field_75102_a && this.func_70638_az() == null) {
            this.func_85030_a("mob.endermen.stare", 10.0F, 1.0F);
            this.func_70819_e(true);
            this.func_70624_b(entityplayer);
            this.func_70625_a(entityplayer, 180.0F, 180.0F);
        }

        return null;
    }

    protected boolean isPlayerRegistered(EntityPlayer p_70821_1_) {
        ItemStack itemstack = p_70821_1_.field_71071_by.field_70460_b[3];
        if (itemstack != null && itemstack.func_77973_b() == Item.func_150898_a(Blocks.field_150423_aK)) {
            return false;
        } else {
            Vec3 vec3 = p_70821_1_.func_70676_i(1.0F).func_72432_b();
            Vec3 vec31 = Vec3.func_72443_a(this.field_70165_t - p_70821_1_.field_70165_t, this.field_70121_D.field_72338_b + (double)this.func_70047_e() - (p_70821_1_.field_70163_u + (double)p_70821_1_.func_70047_e()), this.field_70161_v - p_70821_1_.field_70161_v);
            double d0 = vec31.func_72433_c();
            vec31 = vec31.func_72432_b();
            double d1 = vec3.func_72430_b(vec31);
            return d1 > (double)1.0F - 0.025 / d0 ? p_70821_1_.func_70685_l(this) : false;
        }
    }

    public float func_70047_e() {
        return 2.55F;
    }

    public boolean func_70652_k(Entity p_70652_1_) {
        boolean flag = super.func_70652_k(p_70652_1_);
        if (flag) {
            if (p_70652_1_ instanceof EntityMob || p_70652_1_ instanceof EntityGolem || p_70652_1_ instanceof EntityPlayer) {
                this.func_70820_n();
            }

            if (p_70652_1_ instanceof EntityLivingBase && this.getMinionTypeInt() >= 3) {
                byte b0 = 10;
                if (this.field_70170_p.field_73013_u == EnumDifficulty.NORMAL) {
                    b0 = 20;
                } else if (this.field_70170_p.field_73013_u == EnumDifficulty.HARD) {
                    b0 = 30;
                }

                if (b0 > 0) {
                    ((EntityLivingBase)p_70652_1_).func_70690_d(new PotionEffect(ClientProxy.electricJudgment.field_76415_H, b0 * 20, 1));
                }
            }
        }

        return flag;
    }

    public void func_70636_d() {
        this.field_70789_a = null;
        if (this.getMinionTypeInt() == 1) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)90.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)9.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.45);
            this.field_70728_aV = 30;
        } else if (this.getMinionTypeInt() == 2) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)700.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)20.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.5F);
            this.field_70728_aV = 200;
        } else if (this.getMinionTypeInt() == 3) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)1600.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)40.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.6);
            this.field_70178_ae = true;
            this.field_70728_aV = 500;
        } else if (this.getMinionTypeInt() == 4) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)3000.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)100.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.75F);
            this.field_70178_ae = true;
            this.field_70728_aV = 3000;
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)60.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)7.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.4);
            this.field_70728_aV = 15;
        }

        if (this.getMinionTypeInt() == 3) {
            if (this.field_70146_Z.nextInt(120) == 0 && this.master == null && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntityEndermanMinion entitychicken = new EntityEndermanMinion(this.field_70170_p);
                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(0);
                this.field_70170_p.func_72838_d(entitychicken);
            }

            if (this.field_70146_Z.nextInt(240) == 0 && this.master == null && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntityEndermanMinion entitychicken = new EntityEndermanMinion(this.field_70170_p);
                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(1);
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
                    EntityEndermanMinion entitychicken = new EntityEndermanMinion(this.field_70170_p);
                    entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(0);
                    this.field_70170_p.func_72838_d(entitychicken);
                }

                if (this.field_70146_Z.nextInt(120) == 0) {
                    EntityEndermanMinion entitychicken = new EntityEndermanMinion(this.field_70170_p);
                    entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(1);
                    this.field_70170_p.func_72838_d(entitychicken);
                }

                if (this.field_70146_Z.nextInt(240) == 0) {
                    EntityEndermanMinion entitychicken = new EntityEndermanMinion(this.field_70170_p);
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

            if (this.field_70122_E) {
                this.field_70160_al = false;
            }

            if (this.func_70089_S() && !this.field_70170_p.field_72995_K && this.field_70146_Z.nextInt(1000) == 0 && this.func_70638_az() != null && this.func_110143_aJ() < this.func_110138_aP() / 2.0F && this.master == null) {
                for(int i = 0; i < 16; ++i) {
                    this.field_70170_p.func_72869_a("portal", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                    this.field_70170_p.func_72869_a("magicCrit", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                }

                this.func_85030_a("thetitans:titanland", 10000.0F, 1.0F);
                this.TransformEntity(this);
            }

            EntityLivingBase entitylivingbase = this.func_70638_az();
            if (this.attackPattern == 0 && entitylivingbase != null && !this.field_70170_p.field_72995_K) {
                if (this.field_70163_u < entitylivingbase.field_70163_u + (double)entitylivingbase.field_70131_O + (double)4.0F) {
                    if (this.field_70181_x < (double)0.0F) {
                        this.field_70181_x = (double)0.0F;
                    }

                    this.field_70181_x += (double)0.5F - this.field_70181_x;
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

        if (this.func_70638_az() != null && this.field_70170_p.field_73012_v.nextInt(5) == 1) {
            EntityLivingBase e = this.func_70638_az();
            if (e != null && this.func_70068_e(e) < (double)(this.field_70130_N * this.field_70130_N + e.field_70130_N * e.field_70130_N) + (double)25.0F && (this.field_70170_p.field_73012_v.nextInt(3) == 0 || this.field_70170_p.field_73012_v.nextInt(2) == 1) && this.func_70652_k(e) && this.field_70146_Z.nextInt(5) == 0) {
                this.func_70820_n();
            }
        }

        if (this.getMinionTypeInt() == 2 && this.func_70638_az() != null) {
            double d0 = this.func_70068_e(this.func_70638_az());
            if (d0 < (double)4.0F) {
                this.func_71038_i();
                this.func_70652_k(this.func_70638_az());
            }

            if (this.field_70146_Z.nextInt(40) == 0 && this.field_70122_E && d0 < (double)256.0F && this.func_70638_az().field_70163_u > this.field_70163_u + (double)3.0F) {
                this.func_70816_c(this.func_70638_az());
                this.func_70820_n();
                this.func_70652_k(this.func_70638_az());
            }
        }

        if (this.getMinionTypeInt() == 1 && this.field_70173_aa % 40 == 0 && this.entityToHeal != null) {
            if (this.entityToHeal.func_110143_aJ() < this.entityToHeal.func_110138_aP()) {
                this.func_71038_i();
                this.func_70625_a(this.entityToHeal, 180.0F, (float)this.func_70646_bf());
                this.entityToHeal.func_70691_i(5.0F);
                this.entityToHeal.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 200, 1));
                this.func_85030_a("mob.wither.shoot", 1.0F, 3.0F);

                for(int i = 0; i < 10; ++i) {
                    double d0 = this.field_70146_Z.nextGaussian() * 0.02;
                    double d1 = this.field_70146_Z.nextGaussian() * 0.02;
                    double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                    this.field_70170_p.func_72869_a("heart", this.entityToHeal.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.entityToHeal.field_70130_N * 2.0F) - (double)this.entityToHeal.field_70130_N, this.entityToHeal.field_70163_u + (double)0.5F + (double)(this.field_70146_Z.nextFloat() * this.entityToHeal.field_70131_O), this.entityToHeal.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.entityToHeal.field_70130_N * 2.0F) - (double)this.entityToHeal.field_70130_N, d0, d1, d2);
                }
            } else {
                this.entityToHeal = null;
            }
        }

        this.findPlayerToLookAt();
        if (this.func_70638_az() != null && this.func_70638_az().func_70068_e(this) > (double)256.0F && this.field_70173_aa % 30 == 0 && !this.field_70170_p.field_72995_K) {
            this.func_70816_c(this.func_70638_az());
        }

        if (this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K) {
            float f = this.func_70013_c(1.0F);
            if (f > 0.5F && this.field_70170_p.func_72937_j(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)) && this.field_70146_Z.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
                this.field_70789_a = null;
                this.func_70819_e(false);
                this.isAggressive = false;
                this.func_70820_n();
            }
        }

        if ((this.func_70026_G() || this.func_70027_ad()) && this.getMinionType() != EnumMinionType.TEMPLAR) {
            this.func_70624_b((EntityLivingBase)null);
            this.func_70819_e(true);
            this.isAggressive = false;
            this.func_70820_n();
        }

        if (this.func_70026_G() && this.getMinionType() != EnumMinionType.TEMPLAR) {
            this.func_70819_e(true);
            this.func_70820_n();
            this.func_70097_a(DamageSource.field_76370_b, 4.0F);
            this.field_70737_aN = 1;
            this.field_70721_aZ = 1.5F;
            if (this.field_70170_p.field_72995_K) {
                for(int i = 0; i < 15; ++i) {
                    if (this.func_110143_aJ() <= 20.0F) {
                        this.field_70170_p.func_72869_a("lava", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                    } else {
                        this.field_70170_p.func_72869_a("flame", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                    }

                    this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                }
            }

            if (this.field_70146_Z.nextInt(10) == 0) {
                this.func_70015_d(1);
            }

            if ((this.field_70146_Z.nextInt(60) == 0 || this.field_70146_Z.nextInt(10) == 0 && this.func_110143_aJ() <= 15.0F) && !this.field_70170_p.field_72995_K) {
                this.field_70170_p.func_72885_a(this, this.field_70165_t + (this.field_70146_Z.nextDouble() * (double)1.0F - (double)0.5F), this.field_70163_u + this.field_70146_Z.nextDouble() * (double)3.0F, this.field_70161_v + (this.field_70146_Z.nextDouble() * (double)1.0F - (double)0.5F), 0.0F, true, true);
            }

            if ((this.field_70146_Z.nextInt(1000) == 0 || this.func_110143_aJ() <= 1.0F) && !this.field_70170_p.field_72995_K) {
                this.func_85030_a(this.func_70673_aS(), this.func_70599_aP(), this.func_70647_i());
                this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u + (double)1.0F, this.field_70161_v, 2.0F, true, true);
                this.field_70181_x += (double)3.0F;
                this.func_70097_a(DamageSource.field_76370_b, Float.MAX_VALUE);
            }
        }

        if (this.func_70638_az() != null) {
            this.func_70819_e(true);
            this.isAggressive = true;
        } else if (!this.func_70026_G() && !this.func_70027_ad() && this.func_110143_aJ() <= this.func_110138_aP() / 10.0F) {
            this.func_70819_e(false);
            this.isAggressive = false;
        }

        if (this.field_70170_p.field_72995_K) {
            for(int i = 0; i < 2; ++i) {
                this.field_70170_p.func_72869_a("portal", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - (double)0.25F, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)2.0F, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)2.0F);
            }
        }

        this.field_70703_bu = false;
        if (this.func_70638_az() != null && this.func_70681_au().nextInt(20) == 0 && this.func_70638_az().func_70068_e(this) < (double)2.0F && !this.field_70170_p.field_72995_K && this.getMinionType() != EnumMinionType.TEMPLAR) {
            this.func_70820_n();
        }

        if (this.master != null && this.func_70068_e(this.master) > (double)1024.0F && !this.field_70170_p.field_72995_K) {
            this.func_70816_c(this.master);
        }

        super.func_70636_d();
    }

    protected void func_70619_bc() {
        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
            this.func_85030_a("mob.endermen.scream", this.func_70599_aP(), this.func_70647_i() + 0.25F);
        }

        if (this.field_70123_F && this.master != null) {
            this.field_70181_x = 0.2;
        }

        if (this.func_70638_az() != null && !this.func_70638_az().func_70089_S()) {
            this.func_70624_b((EntityLivingBase)null);
        }

        if (this.master != null) {
            if (this.master.func_70638_az() != null) {
                if (this.master.func_70638_az().field_70131_O < 6.0F) {
                    this.func_70624_b(this.master.func_70638_az());
                } else {
                    this.func_70671_ap().func_75651_a(this.master.func_70638_az(), 10.0F, 40.0F);
                }
            }
        } else {
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)256.0F, (double)256.0F, (double)256.0F));
            if (list != null && !list.isEmpty()) {
                for(int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity != null && entity instanceof EntityEnderColossus) {
                        this.master = (EntityEnderColossus)entity;
                    }
                }
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

    protected boolean func_70820_n() {
        double d0 = this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)64.0F;
        double d1 = this.field_70163_u + (double)(this.field_70146_Z.nextInt(64) - 32);
        double d2 = this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)64.0F;
        return this.func_70089_S() && this.func_70825_j(d0, d1, d2);
    }

    protected boolean func_70816_c(Entity p_70816_1_) {
        Vec3 vec3 = Vec3.func_72443_a(this.field_70165_t - p_70816_1_.field_70165_t, this.field_70121_D.field_72338_b + (double)(this.field_70131_O / 2.0F) - p_70816_1_.field_70163_u + (double)p_70816_1_.func_70047_e(), this.field_70161_v - p_70816_1_.field_70161_v);
        vec3 = vec3.func_72432_b();
        double d0 = (double)16.0F;
        double d1 = this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)8.0F - vec3.field_72450_a * d0;
        double d2 = this.field_70163_u + (double)(this.field_70146_Z.nextInt(16) - 8) - vec3.field_72448_b * d0;
        double d3 = this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)8.0F - vec3.field_72449_c * d0;
        return this.func_70089_S() && this.func_70825_j(d1, d2, d3);
    }

    protected boolean func_70825_j(double p_70825_1_, double p_70825_3_, double p_70825_5_) {
        EnderTeleportEvent event = new EnderTeleportEvent(this, p_70825_1_, p_70825_3_, p_70825_5_, 0.0F);
        if (MinecraftForge.EVENT_BUS.post(event)) {
            return false;
        } else {
            double d3 = this.field_70165_t;
            double d4 = this.field_70163_u;
            double d5 = this.field_70161_v;
            this.field_70165_t = event.targetX;
            this.field_70163_u = event.targetY;
            this.field_70161_v = event.targetZ;
            boolean flag = false;
            int i = MathHelper.func_76128_c(this.field_70165_t);
            int j = MathHelper.func_76128_c(this.field_70163_u);
            int k = MathHelper.func_76128_c(this.field_70161_v);
            if (this.field_70170_p.func_72899_e(i, j, k)) {
                boolean flag1 = false;

                while(!flag1 && j > 0) {
                    Block block = this.field_70170_p.func_147439_a(i, j - 1, k);
                    if (block.func_149688_o().func_76230_c()) {
                        flag1 = true;
                    } else {
                        --this.field_70163_u;
                        --j;
                    }
                }

                if (flag1) {
                    this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    if (this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D)) {
                        flag = true;
                    }
                }
            }

            if (!flag) {
                this.func_70107_b(d3, d4, d5);
                return false;
            } else {
                short short1 = 128;

                for(int l = 0; l < short1; ++l) {
                    double d6 = (double)l / ((double)short1 - (double)1.0F);
                    float f = (this.field_70146_Z.nextFloat() - 0.5F) * 0.2F;
                    float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 0.2F;
                    float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 0.2F;
                    double d7 = d3 + (this.field_70165_t - d3) * d6 + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N * (double)2.0F;
                    double d8 = d4 + (this.field_70163_u - d4) * d6 + this.field_70146_Z.nextDouble() * (double)this.field_70131_O;
                    double d9 = d5 + (this.field_70161_v - d5) * d6 + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N * (double)2.0F;
                    this.field_70170_p.func_72869_a("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);
                    if (this.func_70026_G()) {
                        if (this.func_110143_aJ() <= 20.0F) {
                            this.field_70170_p.func_72869_a("lava", d7, d8, d9, (double)f, (double)f1, (double)f2);
                        } else {
                            this.field_70170_p.func_72869_a("flame", d7, d8, d9, (double)f, (double)f1, (double)f2);
                        }

                        this.field_70170_p.func_72869_a("largesmoke", d7, d8, d9, (double)f, (double)f1, (double)f2);
                    }
                }

                this.field_70170_p.func_72908_a(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
                this.func_85030_a("mob.endermen.portal", 1.0F, 1.0F);
                return true;
            }
        }
    }

    protected Item func_146068_u() {
        return Items.field_151079_bi;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        super.func_70628_a(p_70628_1_, p_70628_2_);
        int j = this.field_70146_Z.nextInt(2 + p_70628_2_);

        for(int k = 0; k < j; ++k) {
            this.func_145779_a(Items.field_151061_bv, 1);
        }

        j = this.field_70146_Z.nextInt(3 + p_70628_2_);

        for(int k = 0; k < j; ++k) {
            this.func_145779_a(Items.field_151044_h, 1);
        }

        if (this.field_70146_Z.nextInt(5) == 0 || this.field_70146_Z.nextInt(1 + p_70628_2_) > 0) {
            this.func_70099_a(new ItemStack(Blocks.field_150377_bs), 0.0F);
        }

        if (this.field_70146_Z.nextInt(20) == 0 || this.field_70146_Z.nextInt(1 + p_70628_2_) > 0) {
            this.func_70099_a(new ItemStack(Blocks.field_150343_Z), 0.0F);
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

    }

    protected void func_70069_a(float p_70069_1_) {
        if (this.getMinionTypeInt() != 4) {
            super.func_70069_a(p_70069_1_);
        }

        this.field_70701_bs = 0.0F;
        this.field_70702_br = 0.0F;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (source instanceof EntityDamageSourceIndirect) {
            this.isAggressive = false;
            if (!this.field_70170_p.field_72995_K && this.getMinionType() != EnumMinionType.TEMPLAR) {
                for(int i = 0; i < 64; ++i) {
                    this.func_70820_n();
                }
            }

            return false;
        } else if (!this.func_85032_ar() && (this.getMinionTypeInt() < 4 || source != DamageSourceExtra.radiation)) {
            if (!(source.func_76346_g() instanceof EntityEndermanMinion) && !(source.func_76346_g() instanceof EntityEnderColossus) && !(source.func_76346_g() instanceof EntityDragon)) {
                if (source.func_76346_g() != null && this.field_70702_br == 0.0F && this.getMinionType() == EnumMinionType.ZEALOT) {
                    this.field_70761_aq = this.field_70177_z = this.field_70759_as;
                    this.func_85030_a("thetitans:titanSwing", 1.0F, 2.0F);
                    if (this.field_70146_Z.nextInt(2) == 0) {
                        this.func_70820_n();
                    } else {
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
                    }

                    this.func_70664_aZ();
                    return false;
                } else {
                    if (source.func_76346_g() == null) {
                        if (!this.field_70170_p.field_72995_K) {
                            this.func_70819_e(true);
                        }

                        if (source instanceof EntityDamageSource && source.func_76346_g() instanceof EntityPlayer) {
                            if (source.func_76346_g() instanceof EntityPlayerMP && ((EntityPlayerMP)source.func_76346_g()).field_71134_c.func_73083_d()) {
                                this.func_70819_e(false);
                            } else {
                                this.isAggressive = true;
                            }
                        }
                    }

                    boolean flag = super.func_70097_a(source, amount);
                    if (this.field_70146_Z.nextInt(2) != 0 && this.getMinionType() != EnumMinionType.TEMPLAR) {
                        this.func_70820_n();
                    }

                    Entity entity = source.func_76346_g();
                    if (entity instanceof EntityLivingBase) {
                        List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)64.0F, (double)64.0F, (double)64.0F));

                        for(int i = 0; i < list.size(); ++i) {
                            Entity entity1 = (Entity)list.get(i);
                            if (entity1 instanceof EntityEndermanMinion) {
                                EntityEndermanMinion entitypigzombie = (EntityEndermanMinion)entity1;
                                entitypigzombie.func_70624_b((EntityLivingBase)entity);
                                entitypigzombie.func_70604_c((EntityLivingBase)entity);
                                entitypigzombie.randomSoundDelay = this.field_70146_Z.nextInt(40);
                            }

                            this.func_70624_b((EntityLivingBase)entity);
                            this.func_70604_c((EntityLivingBase)entity);
                            this.randomSoundDelay = this.field_70146_Z.nextInt(40);
                        }
                    }

                    return flag;
                }
            } else {
                return false;
            }
        } else {
            return false;
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

    public static void setCarriable(Block block, boolean canCarry) {
        if (carriable == null) {
            carriable = new IdentityHashMap(4096);
        }

        carriable.put(block, canCarry);
    }

    public static boolean getCarriable(Block block) {
        Boolean ret = (Boolean)carriable.get(block);
        return ret != null ? ret : false;
    }

    public void TransformEntity(Entity entity) {
        entity.field_70170_p.func_72885_a(entity, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 45.0F, true, entity.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
        EntityEnderColossus entitytitan = new EntityEnderColossus(entity.field_70170_p);
        entitytitan.func_70012_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, entity.field_70177_z, 0.0F);
        entity.func_70106_y();
        entitytitan.func_82206_m();
        entity.field_70170_p.func_72838_d(entitytitan);
        entitytitan.func_85030_a("thetitans:titanEnderColossusRoar", 100.0F, 0.5F);
        entitytitan.setRoarCooldownTimer(1310);
        entitytitan.setScreaming(true);
    }

    public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.func_71038_i();
        if (this.func_70068_e(p_82196_1_) < (double)(this.field_70130_N * this.field_70130_N + p_82196_1_.field_70130_N * p_82196_1_.field_70130_N) + (double)45.0F) {
            this.func_70652_k(p_82196_1_);
        } else {
            switch (this.field_70146_Z.nextInt(5)) {
                case 0:
                    this.field_70170_p.func_72885_a(this, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v, 1.0F * p_82196_1_.field_70130_N, false, false);
                    p_82196_1_.func_70097_a(DamageSourceExtra.lightningBolt, 49.0F);
                    this.field_70170_p.func_72942_c(new EntityLightningBolt(this.field_70170_p, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v));
                    break;
                case 1:
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
                case 2:
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
                case 3:
                    for(int i = 0; i < 50; ++i) {
                        this.func_70068_e(p_82196_1_);
                        double d11 = p_82196_1_.field_70165_t - this.field_70165_t;
                        double d21 = p_82196_1_.field_70121_D.field_72338_b + (double)(p_82196_1_.field_70131_O / 2.0F) - (this.field_70163_u + (double)(p_82196_1_.field_70131_O / 2.0F));
                        double d31 = p_82196_1_.field_70161_v - this.field_70161_v;
                        EntityGhastGuardFireball entitysmallfireball = new EntityGhastGuardFireball(this.field_70170_p, this, d11 + this.func_70681_au().nextGaussian() * (double)9.0F, d21, d31 + this.func_70681_au().nextGaussian() * (double)9.0F);
                        entitysmallfireball.field_70163_u = this.field_70163_u + (double)2.0F;
                        this.field_70170_p.func_72838_d(entitysmallfireball);
                    }
                    break;
                case 4:
                    this.field_70170_p.func_72885_a(this, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u + (double)1.0F, p_82196_1_.field_70161_v, 2.0F, false, false);
                    p_82196_1_.func_70097_a(DamageSourceExtra.lightningBolt, 100.0F);
                    this.field_70170_p.func_72942_c(new EntityLightningBolt(this.field_70170_p, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v));
                    this.field_70170_p.func_72942_c(new EntityLightningBolt(this.field_70170_p, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v));
                    this.field_70170_p.func_72942_c(new EntityLightningBolt(this.field_70170_p, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v));
                    this.field_70170_p.func_72942_c(new EntityLightningBolt(this.field_70170_p, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v));
            }
        }

    }

    static {
        carriableBlocks[Block.func_149682_b(Blocks.field_150349_c)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150346_d)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150354_m)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150351_n)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150327_N)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150328_O)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150338_P)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150337_Q)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150335_W)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150434_aF)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150435_aG)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150423_aK)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150440_ba)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150391_bh)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150462_ai)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150484_ah)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150460_al)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150470_am)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150486_ae)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150340_R)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150364_r)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150363_s)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150362_t)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150361_u)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150339_S)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150344_f)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150478_aa)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150467_bQ)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150382_bo)] = true;
        carriableBlocks[Block.func_149682_b(Blocks.field_150342_X)] = true;

        for(int x = 0; x < carriableBlocks.length; ++x) {
            if (carriableBlocks[x]) {
                setCarriable(Block.func_149729_e(x), true);
            }
        }

    }

    public class EntityAIFindEntityNearestInjuredAlly extends EntityAIBase {
        private EntityEndermanMinion field_179434_b;
        private EntityLivingBase field_179433_e;

        public EntityAIFindEntityNearestInjuredAlly(EntityEndermanMinion entityCaveSpiderPriest) {
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
                List list = this.field_179434_b.field_70170_p.func_72872_a(EntityEndermanMinion.class, this.field_179434_b.field_70121_D.func_72314_b(d0, d0, d0));
                if (list.isEmpty()) {
                    return false;
                } else {
                    for(int i = 0; i < list.size(); ++i) {
                        EntityEndermanMinion entity = (EntityEndermanMinion)list.get(i);
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
                this.field_179433_e = null;
                return false;
            } else if (entitylivingbase.func_110143_aJ() >= entitylivingbase.func_110138_aP()) {
                this.field_179433_e = null;
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
            return (double)48.0F;
        }
    }
}
