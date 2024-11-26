//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titanminion;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.titan.EntityGhastTitan;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.theTitans.ClientProxy;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGhastMinion extends EntityCreature implements IMob, IRangedAttackMob, ITemplar {
    public EntityLiving master;
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    protected int explosionStrength = 1;
    public EntityLiving entityToHeal;
    private int attackPattern;
    private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, (double)1.0F, 5, 64.0F);
    public int deathTicks;

    public EntityGhastMinion(World worldIn) {
        super(worldIn);
        this.func_70105_a(4.5F, 4.5F);
        this.field_70178_ae = true;
        this.field_70728_aV = 20;
        this.field_70714_bg.func_75776_a(0, new EntityAIFindEntityNearestInjuredAlly(this));
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.GhastTitanSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

    }

    public boolean func_70650_aV() {
        return true;
    }

    public void func_70106_y() {
        super.func_70106_y();
        if (this.master != null && this.master instanceof EntityTitan) {
            ((EntityTitan)this.master).retractMinionNumFromType(this.getMinionType());
        }

    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != EntityGhastMinion.class && p_70686_1_ != EntityGhastTitan.class;
    }

    protected void func_70069_a(float p_70069_1_) {
    }

    protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {
    }

    public boolean func_70652_k(Entity p_70652_1_) {
        float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
        int i = 0;
        if (p_70652_1_ instanceof EntityLivingBase) {
            f += EnchantmentHelper.func_77512_a(this, (EntityLivingBase)p_70652_1_);
            i += EnchantmentHelper.func_77507_b(this, (EntityLivingBase)p_70652_1_);
        }

        boolean flag = p_70652_1_.func_70097_a(DamageSource.func_76358_a(this), f);
        if (flag) {
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

            if (i > 0) {
                p_70652_1_.func_70024_g((double)(-MathHelper.func_76126_a(this.field_70177_z * (float)Math.PI / 180.0F) * (float)i * 0.5F), 0.1, (double)(MathHelper.func_76134_b(this.field_70177_z * (float)Math.PI / 180.0F) * (float)i * 0.5F));
                this.field_70159_w *= 0.6;
                this.field_70179_y *= 0.6;
            }

            int j = EnchantmentHelper.func_90036_a(this);
            if (j > 0) {
                p_70652_1_.func_70015_d(j * 4);
            }

            if (p_70652_1_ instanceof EntityLivingBase) {
                EnchantmentHelper.func_151384_a((EntityLivingBase)p_70652_1_, this);
            }

            EnchantmentHelper.func_151385_b(this, p_70652_1_);
        }

        return flag;
    }

    public void func_70612_e(float p_70612_1_, float p_70612_2_) {
        if (this.func_70090_H()) {
            this.func_70060_a(p_70612_1_, p_70612_2_, 0.02F);
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= (double)0.8F;
            this.field_70181_x *= (double)0.8F;
            this.field_70179_y *= (double)0.8F;
        } else if (this.func_70058_J()) {
            this.func_70060_a(p_70612_1_, p_70612_2_, 0.02F);
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= (double)0.5F;
            this.field_70181_x *= (double)0.5F;
            this.field_70179_y *= (double)0.5F;
        } else {
            float f2 = 0.91F;
            if (this.field_70122_E) {
                f2 = this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v)).field_149765_K * 0.91F;
            }

            float f3 = 0.16277136F / (f2 * f2 * f2);
            this.func_70060_a(p_70612_1_, p_70612_2_, this.field_70122_E ? 0.1F * f3 : 0.02F);
            f2 = 0.91F;
            if (this.field_70122_E) {
                f2 = this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v)).field_149765_K * 0.91F;
            }

            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= (double)f2;
            this.field_70181_x *= (double)f2;
            this.field_70179_y *= (double)f2;
        }

        this.field_70722_aY = this.field_70721_aZ;
        double d1 = this.field_70165_t - this.field_70169_q;
        double d0 = this.field_70161_v - this.field_70166_s;
        float f4 = MathHelper.func_76133_a(d1 * d1 + d0 * d0) * 4.0F;
        if (f4 > 1.0F) {
            f4 = 1.0F;
        }

        this.field_70721_aZ += (f4 - this.field_70721_aZ) * 0.4F;
        this.field_70754_ba += this.field_70721_aZ;
    }

    public boolean func_70617_f_() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_110182_bF() {
        return this.field_70180_af.func_75683_a(16) != 0;
    }

    public void func_175454_a(boolean p_175454_1_) {
        this.field_70180_af.func_75692_b(16, (byte)(p_175454_1_ ? 1 : 0));
    }

    public int func_175453_cd() {
        return this.explosionStrength;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.func_70638_az() != null) {
            this.func_70671_ap().func_75650_a(this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u + (double)this.func_70638_az().func_70047_e(), this.func_70638_az().field_70161_v, 180.0F, 180.0F);
        }

    }

    protected void func_70619_bc() {
        if (this.field_70146_Z.nextInt(60) == 0 && this.func_70638_az() != null) {
            this.setCombatTask();
            if (!this.field_70122_E) {
                this.attackPattern = 0;
            } else {
                this.attackPattern = 1;
            }
        }

        if (this.func_70638_az() != null && this.field_70170_p.field_73012_v.nextInt(5) == 1) {
            EntityLivingBase e = this.func_70638_az();
            if (e != null && this.func_70068_e(e) < (double)(this.field_70130_N * this.field_70130_N + e.field_70130_N * e.field_70130_N) + (double)36.0F && (this.field_70170_p.field_73012_v.nextInt(3) == 0 || this.field_70170_p.field_73012_v.nextInt(2) == 1)) {
                this.func_70652_k(e);
            }
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
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)100.0F, (double)100.0F, (double)100.0F));
            if (list != null && !list.isEmpty()) {
                for(int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity != null && entity instanceof EntityGhastTitan) {
                        this.master = (EntityGhastTitan)entity;
                    }
                }
            }
        }

        if (this.func_70638_az() != null && !this.func_70685_l(this.func_70638_az()) && this.field_70146_Z.nextInt(150) == 0) {
            this.func_70624_b((EntityLivingBase)null);
        }

        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
            this.func_70106_y();
        }

        this.func_70623_bb();
        this.prevAttackCounter = this.attackCounter;
        double d0 = this.waypointX - this.field_70165_t;
        double d1 = this.waypointY - this.field_70163_u;
        double d2 = this.waypointZ - this.field_70161_v;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;
        if (d3 < (double)1.0F || d3 > (double)10000.0F) {
            if (this.master != null) {
                double extra = (double)0.0F;
                if (this.func_70638_az() != null && this.func_70638_az().field_70131_O > 4.0F) {
                    extra = (double)64.0F;
                }

                double x = this.master.field_70165_t;
                double y = this.master.field_70163_u + (double)32.0F + extra;
                double z = this.master.field_70161_v;
                d0 += this.field_70146_Z.nextDouble() * (double)96.0F - (double)48.0F;
                d1 += this.field_70146_Z.nextDouble() * (double)96.0F - (double)48.0F;
                d2 += this.field_70146_Z.nextDouble() * (double)96.0F - (double)48.0F;
                this.waypointX = x + d0;
                this.waypointY = y + d1;
                this.waypointZ = z + d2;
            } else if (this.func_70638_az() != null) {
                this.waypointX = this.func_70638_az().field_70165_t + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)16.0F;
                this.waypointY = this.func_70638_az().field_70163_u + (double)32.0F + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)16.0F;
                this.waypointZ = this.func_70638_az().field_70161_v + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)16.0F;
            } else {
                EntityPlayer player = this.field_70170_p.func_72890_a(this, (double)512.0F);
                if (player != null) {
                    this.waypointX = player.field_70165_t + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)16.0F;
                    this.waypointY = player.field_70163_u + (double)32.0F + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)16.0F;
                    this.waypointZ = player.field_70161_v + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)16.0F;
                } else {
                    this.waypointX = this.field_70165_t + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)16.0F;
                    this.waypointY = this.field_70163_u + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)16.0F;
                    this.waypointZ = this.field_70161_v + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)16.0F;
                }
            }
        }

        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.field_70146_Z.nextInt(5) + 2;
            d3 = (double)MathHelper.func_76133_a(d3);
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3)) {
                if (this.master != null && this.func_70068_e(this.master) > (double)4096.0F) {
                    this.field_70159_w += d0 / d3 * (this.getMinionType() == EnumMinionType.ZEALOT ? 0.8 : 0.2);
                    this.field_70181_x += d1 / d3 * (this.getMinionType() == EnumMinionType.ZEALOT ? 0.8 : 0.2);
                    this.field_70179_y += d2 / d3 * (this.getMinionType() == EnumMinionType.ZEALOT ? 0.8 : 0.2);
                } else {
                    this.field_70159_w += d0 / d3 * (this.getMinionType() == EnumMinionType.ZEALOT ? 0.4 : 0.1);
                    this.field_70181_x += d1 / d3 * (this.getMinionType() == EnumMinionType.ZEALOT ? 0.4 : 0.1);
                    this.field_70179_y += d2 / d3 * (this.getMinionType() == EnumMinionType.ZEALOT ? 0.4 : 0.1);
                }
            } else {
                this.waypointX = this.field_70165_t;
                this.waypointY = this.field_70163_u;
                this.waypointZ = this.field_70161_v;
            }
        }

        if (this.targetedEntity != null && this.targetedEntity.field_70128_L) {
            this.targetedEntity = null;
        }

        if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = this.func_70638_az();
            if (this.targetedEntity != null) {
                this.aggroCooldown = 20;
            }
        }

        double d4 = (double)100.0F;
        if (this.targetedEntity != null && this.targetedEntity.func_70068_e(this) < d4 * d4) {
            double d8 = (double)2.0F;
            Vec3 vec3 = this.func_70676_i(1.0F);
            double d5 = this.targetedEntity.field_70165_t + this.targetedEntity.field_70159_w - (this.field_70165_t + vec3.field_72450_a * d8);
            double d6 = this.targetedEntity.field_70163_u + (double)1.0F - (this.field_70163_u + vec3.field_72448_b * d8 + (double)1.0F);
            double d7 = this.targetedEntity.field_70161_v + this.targetedEntity.field_70179_y - (this.field_70161_v + vec3.field_72449_c * d8);
            this.field_70761_aq = this.field_70177_z = -((float)Math.atan2(d5, d7)) * 180.0F / (float)Math.PI;
            if (this.func_70685_l(this.targetedEntity)) {
                if (this.attackCounter == 10) {
                    this.field_70170_p.func_72889_a((EntityPlayer)null, 1007, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                }

                ++this.attackCounter;
                if (this.attackCounter > 20 && this.getMinionType() == EnumMinionType.TEMPLAR) {
                    this.field_70170_p.func_72889_a((EntityPlayer)null, 1008, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                    EntityGhastMinionFireball entitylargefireball = new EntityGhastMinionFireball(this.field_70170_p, this, d5, d6, d7);
                    entitylargefireball.field_92057_e = this.explosionStrength;
                    entitylargefireball.field_70165_t = this.field_70165_t + vec3.field_72450_a * d8;
                    entitylargefireball.field_70163_u = this.field_70163_u + vec3.field_72448_b * d8 + (double)1.0F;
                    entitylargefireball.field_70161_v = this.field_70161_v + vec3.field_72449_c * d8;
                    this.field_70170_p.func_72838_d(entitylargefireball);
                }

                if (this.attackCounter >= (this.getMinionType() == EnumMinionType.TEMPLAR ? 40 : 20)) {
                    this.field_70170_p.func_72889_a((EntityPlayer)null, 1008, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                    EntityGhastMinionFireball entitylargefireball = new EntityGhastMinionFireball(this.field_70170_p, this, d5, d6, d7);
                    entitylargefireball.field_92057_e = this.explosionStrength;
                    entitylargefireball.field_70165_t = this.field_70165_t + vec3.field_72450_a * d8;
                    entitylargefireball.field_70163_u = this.field_70163_u + vec3.field_72448_b * d8 + (double)1.0F;
                    entitylargefireball.field_70161_v = this.field_70161_v + vec3.field_72449_c * d8;
                    this.field_70170_p.func_72838_d(entitylargefireball);
                    this.attackCounter = this.getMinionType() == EnumMinionType.ZEALOT ? 0 : -40;
                }
            } else if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        } else {
            this.field_70761_aq = this.field_70177_z = -((float)Math.atan2(this.field_70159_w, this.field_70179_y)) * 180.0F / (float)Math.PI;
            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }

        if (!this.field_70170_p.field_72995_K) {
            byte b1 = this.field_70180_af.func_75683_a(16);
            byte b0 = (byte)(this.attackCounter > 10 ? 1 : 0);
            if (b1 != b0) {
                this.field_70180_af.func_75692_b(16, b0);
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

    private boolean isCourseTraversable(double p_70790_1_, double p_70790_3_, double p_70790_5_, double p_70790_7_) {
        double d4 = (this.waypointX - this.field_70165_t) / p_70790_7_;
        double d5 = (this.waypointY - this.field_70163_u) / p_70790_7_;
        double d6 = (this.waypointZ - this.field_70161_v) / p_70790_7_;
        AxisAlignedBB axisalignedbb = this.field_70121_D.func_72329_c();

        for(int i = 1; (double)i < p_70790_7_; ++i) {
            axisalignedbb.func_72317_d(d4, d5, d6);
            if (!this.field_70170_p.func_72945_a(this, axisalignedbb).isEmpty()) {
                return false;
            }
        }

        return true;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, (byte)0);
        this.field_70180_af.func_75682_a(19, 0);
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)6.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)1.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a((double)100.0F);
    }

    protected String func_70639_aQ() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanGhastLiving" : "mob.ghast.moan";
    }

    protected String func_70621_aR() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanGhastGrunt" : "mob.ghast.scream";
    }

    protected String func_70673_aS() {
        return this.getMinionTypeInt() == 4 ? "thetitans:titanGhastDeath" : "mob.ghast.death";
    }

    protected float func_70647_i() {
        return this.getMinionTypeInt() == 4 ? super.func_70647_i() + 0.3F : super.func_70647_i();
    }

    protected Item func_146068_u() {
        return Items.field_151016_H;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        int j = this.field_70146_Z.nextInt(2) + this.field_70146_Z.nextInt(1 + p_70628_2_);

        for(int k = 0; k < j; ++k) {
            this.func_145779_a(Items.field_151073_bk, 1);
        }

        j = this.field_70146_Z.nextInt(3) + this.field_70146_Z.nextInt(1 + p_70628_2_);

        for(int k = 0; k < j; ++k) {
            this.func_145779_a(Items.field_151016_H, 1);
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

    protected float func_70599_aP() {
        return 10.0F;
    }

    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(20) == 0 && super.func_70601_bi() && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL;
    }

    public int func_70641_bl() {
        return 1;
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

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        tagCompound.func_74768_a("ExplosionPower", this.explosionStrength);
        tagCompound.func_74768_a("MinionType", this.getMinionTypeInt());
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        if (tagCompund.func_150297_b("ExplosionPower", 99)) {
            this.explosionStrength = tagCompund.func_74762_e("ExplosionPower");
        }

        this.setMinionType(tagCompund.func_74762_e("MinionType"));
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
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)60.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)8.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.45);
            this.explosionStrength = 2;
            this.func_70606_j(90.0F);
            this.field_70728_aV = 30;
        } else if (miniontype == 2) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)400.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)20.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.5F);
            this.explosionStrength = 4;
            this.func_70606_j(700.0F);
            this.field_70728_aV = 200;
        } else if (miniontype == 3) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)1200.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)40.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.6);
            this.explosionStrength = 6;
            this.func_70606_j(1600.0F);
            this.field_70728_aV = 500;
        } else if (miniontype == 4) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)3000.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)100.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.75F);
            this.explosionStrength = 9;
            this.func_70606_j(3000.0F);
            this.field_70728_aV = 3000;
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)40.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)6.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.4);
            this.func_70606_j(60.0F);
            this.explosionStrength = 1;
            this.field_70728_aV = 15;
        }

    }

    public float func_70047_e() {
        return 3.0F;
    }

    public void func_70636_d() {
        if (this.getMinionTypeInt() == 1) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)60.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)8.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.45);
            this.explosionStrength = 2;
            this.field_70728_aV = 30;
        } else if (this.getMinionTypeInt() == 2) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)400.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)20.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.5F);
            this.explosionStrength = 4;
            this.field_70728_aV = 200;
        } else if (this.getMinionTypeInt() == 3) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)1200.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)40.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.6);
            this.explosionStrength = 6;
            this.field_70728_aV = 500;
        } else if (this.getMinionTypeInt() == 4) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)3000.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)100.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.75F);
            this.explosionStrength = 9;
            this.field_70728_aV = 3000;
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)40.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)6.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.4);
            this.explosionStrength = 1;
            this.field_70728_aV = 15;
        }

        if (this.func_70089_S() || this.getMinionTypeInt() != 4) {
            super.func_70636_d();
        }

        if (this.getMinionTypeInt() == 3) {
            if (this.field_70146_Z.nextInt(120) == 0 && this.master == null && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntityGhastMinion entitychicken = new EntityGhastMinion(this.field_70170_p);
                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(0);
                this.field_70170_p.func_72838_d(entitychicken);
            }

            if (this.field_70146_Z.nextInt(240) == 0 && this.master == null && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntityGhastMinion entitychicken = new EntityGhastMinion(this.field_70170_p);
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
                    EntityGhastMinion entitychicken = new EntityGhastMinion(this.field_70170_p);
                    entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(0);
                    this.field_70170_p.func_72838_d(entitychicken);
                }

                if (this.field_70146_Z.nextInt(120) == 0) {
                    EntityGhastMinion entitychicken = new EntityGhastMinion(this.field_70170_p);
                    entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(1);
                    this.field_70170_p.func_72838_d(entitychicken);
                }

                if (this.field_70146_Z.nextInt(240) == 0) {
                    EntityGhastMinion entitychicken = new EntityGhastMinion(this.field_70170_p);
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

    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (!this.func_85032_ar() && source.func_76355_l() != "thorns" && (this.getMinionTypeInt() < 4 || source != DamageSourceExtra.radiation)) {
            if (!(source.func_76346_g() instanceof EntityGhastMinion) && !(source.func_76346_g() instanceof EntityGhastTitan)) {
                if ("fireball".equals(source.func_76355_l()) && source.func_76346_g() instanceof EntityPlayer) {
                    super.func_70097_a(source, 1000.0F);
                    ((EntityPlayer)source.func_76346_g()).func_71029_a(AchievementList.field_76028_y);
                    return true;
                } else {
                    Entity entity = source.func_76346_g();
                    if (source.func_76346_g() instanceof EntityLivingBase) {
                        this.func_70624_b((EntityLivingBase)entity);
                        this.func_70604_c((EntityLivingBase)entity);
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

    public void TransformEntity(Entity entity) {
        entity.field_70170_p.func_72885_a(entity, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 8.0F, true, entity.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
        EntityGhastTitan entitytitan = new EntityGhastTitan(entity.field_70170_p);
        entitytitan.func_70012_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, entity.field_70177_z, 0.0F);
        entity.func_70106_y();
        entitytitan.func_82206_m();
        entity.field_70170_p.func_72838_d(entitytitan);
        entitytitan.func_85030_a("thetitans:titanGhastLiving", 10000.0F, 0.8F);
    }

    public void setCombatTask() {
        this.field_70714_bg.func_85156_a(this.aiArrowAttack);
        if (this.attackPattern == 0 && this.getMinionTypeInt() == 4) {
            this.field_70714_bg.func_75776_a(0, this.aiArrowAttack);
        }

    }

    public IEntityLivingData func_110161_a(IEntityLivingData p_110161_1_) {
        super.func_110161_a(p_110161_1_);
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

        return p_110161_1_;
    }

    public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.attackCounter = 10;
        this.func_71038_i();
        this.field_70170_p.func_72889_a((EntityPlayer)null, 1007, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
        if (this.func_70068_e(p_82196_1_) < (double)(p_82196_1_.field_70130_N * p_82196_1_.field_70130_N) + (double)36.0F) {
            this.func_70652_k(p_82196_1_);
        } else {
            switch (this.field_70146_Z.nextInt(4)) {
                case 0:
                    for(int i = 0; i < 100; ++i) {
                        EntityHarcadiumArrow entityarrow = new EntityHarcadiumArrow(this.field_70170_p, this, p_82196_1_, 4.0F, 16.0F);
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
                        EntityPotion entitypotion = new EntityPotion(this.field_70170_p, this, this.field_70146_Z.nextInt(5) == 0 ? 32660 : (this.field_70146_Z.nextInt(4) == 0 ? 32696 : (this.field_70146_Z.nextInt(3) == 0 ? 32698 : 32732)));
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
                        double d8 = (double)4.0F;
                        Vec3 vec3 = this.func_70676_i(1.0F);
                        entitypotion.field_70165_t = this.field_70165_t + vec3.field_72450_a * d8;
                        entitypotion.field_70163_u = this.field_70163_u + vec3.field_72448_b * d8 + (double)1.0F;
                        entitypotion.field_70161_v = this.field_70161_v + vec3.field_72449_c * d8;
                    }
                    break;
                case 2:
                    this.field_70170_p.func_72885_a(this, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u + (double)1.0F, p_82196_1_.field_70161_v, 2.0F, false, false);
                    p_82196_1_.func_70097_a(DamageSourceExtra.lightningBolt, 100.0F);
                    this.field_70170_p.func_72942_c(new EntityLightningBolt(this.field_70170_p, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v));
                    this.field_70170_p.func_72942_c(new EntityLightningBolt(this.field_70170_p, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v));
                    this.field_70170_p.func_72942_c(new EntityLightningBolt(this.field_70170_p, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v));
                    this.field_70170_p.func_72942_c(new EntityLightningBolt(this.field_70170_p, p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v));
                    break;
                case 3:
                    for(int i = 0; i < 50; ++i) {
                        double d8 = (double)4.0F;
                        Vec3 vec3 = this.func_70676_i(1.0F);
                        this.field_70170_p.func_72889_a((EntityPlayer)null, 1008, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                        this.func_70068_e(p_82196_1_);
                        double d11 = p_82196_1_.field_70165_t + p_82196_1_.field_70159_w - (this.field_70165_t + vec3.field_72450_a * d8);
                        double d21 = p_82196_1_.field_70163_u + (double)1.0F - (this.field_70163_u + vec3.field_72448_b * d8 + (double)1.0F);
                        double d31 = p_82196_1_.field_70161_v + p_82196_1_.field_70179_y - (this.field_70161_v + vec3.field_72449_c * d8);
                        EntityGhastMinionFireball entityfireball = new EntityGhastMinionFireball(this.field_70170_p, this, d11 + this.func_70681_au().nextGaussian() * (double)9.0F, d21, d31 + this.func_70681_au().nextGaussian() * (double)9.0F);
                        entityfireball.field_92057_e = this.explosionStrength;
                        this.field_70170_p.func_72838_d(entityfireball);
                        entityfireball.field_70165_t = this.field_70165_t + vec3.field_72450_a * d8;
                        entityfireball.field_70163_u = this.field_70163_u + vec3.field_72448_b * d8 + (double)1.0F;
                        entityfireball.field_70161_v = this.field_70161_v + vec3.field_72449_c * d8;
                    }
            }
        }

    }

    public class EntityAIFindEntityNearestInjuredAlly extends EntityAIBase {
        private EntityGhastMinion field_179434_b;
        private EntityLivingBase field_179433_e;

        public EntityAIFindEntityNearestInjuredAlly(EntityGhastMinion entityCaveSpiderPriest) {
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
                List list = this.field_179434_b.field_70170_p.func_72872_a(EntityGhastMinion.class, this.field_179434_b.field_70121_D.func_72314_b(d0, d0, d0));
                if (list.isEmpty()) {
                    return false;
                } else {
                    for(int i = 0; i < list.size(); ++i) {
                        EntityGhastMinion entity = (EntityGhastMinion)list.get(i);
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

        protected double func_179431_f() {
            return (double)100.0F;
        }
    }
}
