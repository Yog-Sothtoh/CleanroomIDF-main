//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.AntRobot;
import danger.orespawn.Basilisk;
import danger.orespawn.CaterKiller;
import danger.orespawn.Cephadrome;
import danger.orespawn.EmperorScorpion;
import danger.orespawn.GiantRobot;
import danger.orespawn.Godzilla;
import danger.orespawn.GodzillaHead;
import danger.orespawn.Hammerhead;
import danger.orespawn.HerculesBeetle;
import danger.orespawn.KingHead;
import danger.orespawn.Kraken;
import danger.orespawn.Leon;
import danger.orespawn.Nastysaurus;
import danger.orespawn.PitchBlack;
import danger.orespawn.PurplePower;
import danger.orespawn.QueenHead;
import danger.orespawn.Robot2;
import danger.orespawn.Robot3;
import danger.orespawn.Robot4;
import danger.orespawn.SpiderRobot;
import danger.orespawn.TRex;
import danger.orespawn.TheKing;
import danger.orespawn.ThePrince;
import danger.orespawn.ThePrinceAdult;
import danger.orespawn.ThePrinceTeen;
import danger.orespawn.ThePrincess;
import danger.orespawn.TheQueen;
import danger.orespawn.TrooperBug;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.orespawnaddon.EntityMethuselahKraken;
import net.minecraft.entity.orespawnaddon.EntityOverlordScorpion;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.titan.ai.EntityAITitanLookIdle;
import net.minecraft.entity.titan.ai.EntityAITitanWatchClosest;
import net.minecraft.entity.titanminion.EntityDragonMinion;
import net.minecraft.entity.titanminion.EntityGiantZombieBetter;
import net.minecraft.entity.titanminion.EntityWitherMinion;
import net.minecraft.entity.titanminion.EnumMinionType;
import net.minecraft.entity.titanminion.IMinion;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.ClientProxy;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.items.ItemHarcadiumArmor;
import net.minecraft.theTitans.world.WorldProviderVoid;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import thehippomaster.AnimationAPI.AnimationAPI;

public abstract class EntityTitan extends EntityCreature implements ITitan, IBossDisplayData {
    public boolean shouldParticlesBeUpward;
    public int deathTicks;
    public boolean isRejuvinating;
    public int animID;
    public int animTick;
    public boolean meleeTitan;
    protected int nextStepDistanceTitan;
    public int antiTitanAttackAnimeID;
    protected int numMinions;
    protected int numPriests;
    protected int numZealots;
    protected int numBishop;
    protected int numTemplar;
    protected int numSpecialMinions;
    public int footID;

    public EntityTitan(World worldIn) {
        super(worldIn);
        this.field_70130_N = 1.0F;
        this.field_70131_O = 6.0F;
        this.func_110163_bv();
        this.applyEntityAI();
        this.field_70178_ae = true;
        this.field_70158_ak = true;
        this.field_70771_an = 30;
        this.field_70714_bg.func_75776_a(7, new EntityAITitanWatchClosest(this, EntityTitanSpirit.class, 128.0F, 0.25F));
        this.field_70714_bg.func_75776_a(8, new EntityAITitanWatchClosest(this, EntityTitan.class, 128.0F, 0.5F));
        this.field_70714_bg.func_75776_a(9, new EntityAITitanWatchClosest(this, EntityPlayer.class, 128.0F));
        this.field_70714_bg.func_75776_a(10, new EntityAITitanLookIdle(this));
        this.field_70155_l = (double)1000.0F;
    }

    public boolean alreadyHasAName() {
        return false;
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(Double.MAX_VALUE);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a((double)512.0F);
    }

    public void func_70015_d(int p_70015_1_) {
    }

    public boolean func_110164_bC() {
        return false;
    }

    public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
        if (this.field_70145_X) {
            this.field_70121_D.func_72317_d(p_70091_1_, p_70091_3_, p_70091_5_);
            this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / (double)2.0F;
            this.field_70163_u = this.field_70121_D.field_72338_b + (double)this.field_70129_M - (double)this.field_70139_V;
            this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / (double)2.0F;
        } else {
            this.field_70170_p.field_72984_F.func_76320_a("move");
            this.field_70139_V *= 0.4F;
            double d3 = this.field_70165_t;
            double d4 = this.field_70163_u;
            double d5 = this.field_70161_v;
            double d6 = p_70091_1_;
            double d7 = p_70091_3_;
            double d8 = p_70091_5_;
            AxisAlignedBB axisalignedbb = this.field_70121_D.func_72329_c();
            List list = this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72321_a(p_70091_1_, p_70091_3_, p_70091_5_));

            for(int i = 0; i < list.size(); ++i) {
                p_70091_3_ = ((AxisAlignedBB)list.get(i)).func_72323_b(this.field_70121_D, p_70091_3_);
            }

            this.field_70121_D.func_72317_d((double)0.0F, p_70091_3_, (double)0.0F);
            if (!this.field_70135_K && d7 != p_70091_3_) {
                p_70091_5_ = (double)0.0F;
                p_70091_3_ = (double)0.0F;
                p_70091_1_ = (double)0.0F;
            }

            boolean flag1 = this.field_70122_E || d7 != p_70091_3_ && d7 < (double)0.0F;

            for(int j = 0; j < list.size(); ++j) {
                p_70091_1_ = ((AxisAlignedBB)list.get(j)).func_72316_a(this.field_70121_D, p_70091_1_);
            }

            this.field_70121_D.func_72317_d(p_70091_1_, (double)0.0F, (double)0.0F);
            if (!this.field_70135_K && d6 != p_70091_1_) {
                p_70091_5_ = (double)0.0F;
                p_70091_3_ = (double)0.0F;
                p_70091_1_ = (double)0.0F;
            }

            for(int var38 = 0; var38 < list.size(); ++var38) {
                p_70091_5_ = ((AxisAlignedBB)list.get(var38)).func_72322_c(this.field_70121_D, p_70091_5_);
            }

            this.field_70121_D.func_72317_d((double)0.0F, (double)0.0F, p_70091_5_);
            if (!this.field_70135_K && d8 != p_70091_5_) {
                p_70091_5_ = (double)0.0F;
                p_70091_3_ = (double)0.0F;
                p_70091_1_ = (double)0.0F;
            }

            if (this.field_70138_W > 0.0F && flag1 && this.field_70139_V < 0.05F && (d6 != p_70091_1_ || d8 != p_70091_5_)) {
                double d12 = p_70091_1_;
                double d10 = p_70091_3_;
                double d11 = p_70091_5_;
                p_70091_1_ = d6;
                p_70091_3_ = (double)this.field_70138_W;
                p_70091_5_ = d8;
                AxisAlignedBB axisalignedbb1 = this.field_70121_D.func_72329_c();
                this.field_70121_D.func_72328_c(axisalignedbb);
                list = this.field_70170_p.func_72945_a(this, this.field_70121_D.func_72321_a(d6, p_70091_3_, d8));

                for(int k = 0; k < list.size(); ++k) {
                    p_70091_3_ = ((AxisAlignedBB)list.get(k)).func_72323_b(this.field_70121_D, p_70091_3_);
                }

                this.field_70121_D.func_72317_d((double)0.0F, p_70091_3_, (double)0.0F);
                if (!this.field_70135_K && d7 != p_70091_3_) {
                    p_70091_5_ = (double)0.0F;
                    p_70091_3_ = (double)0.0F;
                    p_70091_1_ = (double)0.0F;
                }

                for(int var41 = 0; var41 < list.size(); ++var41) {
                    p_70091_1_ = ((AxisAlignedBB)list.get(var41)).func_72316_a(this.field_70121_D, p_70091_1_);
                }

                this.field_70121_D.func_72317_d(p_70091_1_, (double)0.0F, (double)0.0F);
                if (!this.field_70135_K && d6 != p_70091_1_) {
                    p_70091_5_ = (double)0.0F;
                    p_70091_3_ = (double)0.0F;
                    p_70091_1_ = (double)0.0F;
                }

                for(int var42 = 0; var42 < list.size(); ++var42) {
                    p_70091_5_ = ((AxisAlignedBB)list.get(var42)).func_72322_c(this.field_70121_D, p_70091_5_);
                }

                this.field_70121_D.func_72317_d((double)0.0F, (double)0.0F, p_70091_5_);
                if (!this.field_70135_K && d8 != p_70091_5_) {
                    p_70091_5_ = (double)0.0F;
                    p_70091_3_ = (double)0.0F;
                    p_70091_1_ = (double)0.0F;
                }

                if (!this.field_70135_K && d7 != p_70091_3_) {
                    p_70091_5_ = (double)0.0F;
                    p_70091_3_ = (double)0.0F;
                    p_70091_1_ = (double)0.0F;
                } else {
                    p_70091_3_ = (double)(-this.field_70138_W);

                    for(int var43 = 0; var43 < list.size(); ++var43) {
                        p_70091_3_ = ((AxisAlignedBB)list.get(var43)).func_72323_b(this.field_70121_D, p_70091_3_);
                    }

                    this.field_70121_D.func_72317_d((double)0.0F, p_70091_3_, (double)0.0F);
                }

                if (d12 * d12 + d11 * d11 >= p_70091_1_ * p_70091_1_ + p_70091_5_ * p_70091_5_) {
                    p_70091_1_ = d12;
                    p_70091_3_ = d10;
                    p_70091_5_ = d11;
                    this.field_70121_D.func_72328_c(axisalignedbb1);
                }
            }

            this.field_70170_p.field_72984_F.func_76319_b();
            this.field_70170_p.field_72984_F.func_76320_a("rest");
            this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / (double)2.0F;
            this.field_70163_u = this.field_70121_D.field_72338_b + (double)this.field_70129_M - (double)this.field_70139_V;
            this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / (double)2.0F;
            this.field_70123_F = d6 != p_70091_1_ || d8 != p_70091_5_;
            this.field_70124_G = d7 != p_70091_3_;
            this.field_70122_E = d7 != p_70091_3_ && d7 < (double)0.0F || this.field_70163_u <= (double)0.0F;
            this.field_70132_H = this.field_70123_F || this.field_70124_G;
            this.func_70064_a(p_70091_3_, this.field_70122_E);
            if (d6 != p_70091_1_) {
                this.field_70159_w = (double)0.0F;
            }

            if (d7 != p_70091_3_) {
                this.field_70181_x = (double)0.0F;
            }

            if (d8 != p_70091_5_) {
                this.field_70179_y = (double)0.0F;
            }

            double d12 = this.field_70165_t - d3;
            double d10 = this.field_70163_u - d4;
            double d11 = this.field_70161_v - d5;
            if (this.field_70154_o == null && this.field_70122_E) {
                int j1 = MathHelper.func_76128_c(this.field_70165_t);
                int k = MathHelper.func_76128_c(this.field_70163_u - (double)0.5F - (double)this.field_70129_M);
                int l = MathHelper.func_76128_c(this.field_70161_v);
                Block block = this.field_70170_p.func_147439_a(j1, k, l);
                int i1 = this.field_70170_p.func_147439_a(j1, k - 1, l).func_149645_b();
                if (i1 == 11 || i1 == 32 || i1 == 21) {
                    block = this.field_70170_p.func_147439_a(j1, k - 1, l);
                }

                if (block != Blocks.field_150468_ap) {
                    d10 = (double)0.0F;
                }

                this.field_70140_Q = (float)((double)this.field_70140_Q + (double)MathHelper.func_76133_a(d12 * d12 + d11 * d11) * 0.6);
                this.field_82151_R = (float)((double)this.field_82151_R + (double)MathHelper.func_76133_a(d12 * d12 + d10 * d10 + d11 * d11) * 0.6);
                if (this.field_82151_R > (float)this.nextStepDistanceTitan) {
                    this.nextStepDistanceTitan = (int)this.field_82151_R + this.getFootStepModifer();
                    this.func_145780_a(j1, k, l, block);
                    block.func_149724_b(this.field_70170_p, j1, k, l, this);
                }
            } else if (this.field_70154_o != null || !this.field_70122_E) {
                this.nextStepDistanceTitan = this.getFootStepModifer();
                this.field_70140_Q = 0.0F;
                this.field_82151_R = 0.0F;
                this.footID = 0;
            }

            try {
                this.func_145775_I();
            } catch (Throwable throwable) {
                CrashReport crashreport = CrashReport.func_85055_a(throwable, "Checking entity block collision");
                CrashReportCategory crashreportcategory = crashreport.func_85058_a("Entity being checked for collision");
                this.func_85029_a(crashreportcategory);
                throw new ReportedException(crashreport);
            }

            this.field_70170_p.field_72984_F.func_76319_b();
        }

    }

    public int getFootStepModifer() {
        return 2;
    }

    public double func_70068_e(Entity p_70068_1_) {
        double d0 = this.field_70165_t - p_70068_1_.field_70165_t;
        double d1 = this.field_70163_u + (double)(this.field_70131_O * 0.5F) - p_70068_1_.field_70163_u;
        double d2 = this.field_70161_v - p_70068_1_.field_70161_v;
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    protected void func_85033_bc() {
        List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(0.1, 0.1, 0.1));
        if (list != null && !list.isEmpty() && !this.getWaiting() && this.animID != 13) {
            for(int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                if (this.func_70089_S() && entity.func_70089_S() && (entity.func_70104_M() || entity instanceof EntityTitan || entity instanceof EntityThrowable && ((EntityThrowable)entity).func_85052_h() != this || entity instanceof EntityFireball && ((EntityFireball)entity).field_70235_a != this) && entity.field_70131_O > 6.0F && !(entity instanceof EntityPlayer)) {
                    this.func_82167_n(entity);
                }
            }
        }

    }

    public void func_70108_f(Entity p_70108_1_) {
        if (this.func_70686_a(p_70108_1_.getClass()) && !this.getWaiting() && this.animID != 13 && !(p_70108_1_ instanceof EntitySkeletonTitanGiantArrow) && !(p_70108_1_ instanceof EntityHarcadiumArrow) && !(p_70108_1_ instanceof EntityFireball) && !(p_70108_1_ instanceof EntityThrowable) && !(p_70108_1_ instanceof EntityTitanPart) && this.func_70089_S() && p_70108_1_.field_70153_n != this && p_70108_1_.field_70154_o != this) {
            double d0 = p_70108_1_.field_70165_t - this.field_70165_t;
            double d1 = p_70108_1_.field_70161_v - this.field_70161_v;
            double d2 = MathHelper.func_76132_a(d0, d1);
            if (d2 >= (double)0.01F) {
                d2 = (double)MathHelper.func_76133_a(d2);
                d0 /= d2;
                d1 /= d2;
                double d3 = (double)1.0F / d2;
                if (d3 > (double)1.0F) {
                    d3 = (double)1.0F;
                }

                d0 *= d3;
                d1 *= d3;
                d0 *= (double)0.25F;
                d1 *= (double)0.25F;
                d0 *= (double)(1.0F - this.field_70144_Y);
                d1 *= (double)(1.0F - this.field_70144_Y);
                if (p_70108_1_.field_70131_O >= 6.0F || p_70108_1_ instanceof EntityTitan) {
                    this.addTitanVelocity(-d0, (double)0.0F, -d1);
                }

                d0 *= (double)4.0F;
                d1 *= (double)4.0F;
                p_70108_1_.func_70024_g(d0, (double)0.75F, d1);
            }
        }

    }

    public void setTitanHealth(float p_70606_1_) {
        if (!this.field_70170_p.field_72995_K) {
            this.field_70180_af.func_75692_b(6, MathHelper.func_76131_a(p_70606_1_, 0.0F, this.func_110138_aP()));
            this.field_70180_af.func_75692_b(5, MathHelper.func_76131_a(p_70606_1_, 0.0F, this.func_110138_aP()));
        }

    }

    @SideOnly(Side.CLIENT)
    public float func_70053_R() {
        return 0.0F;
    }

    public boolean func_70089_S() {
        return !this.field_70128_L && this.field_70180_af.func_111145_d(5) > 0.0F;
    }

    public void func_70606_j(float p_70606_1_) {
        this.field_70180_af.func_75692_b(6, MathHelper.func_76131_a(this.field_70180_af.func_111145_d(5), 0.0F, this.func_110138_aP()));
    }

    public Vec3 func_70676_i(float p_70676_1_) {
        if (p_70676_1_ == 1.0F) {
            float f1 = MathHelper.func_76134_b(-this.field_70759_as * ((float)Math.PI / 180F) - (float)Math.PI);
            float f2 = MathHelper.func_76126_a(-this.field_70759_as * ((float)Math.PI / 180F) - (float)Math.PI);
            float f3 = -MathHelper.func_76134_b(-this.field_70125_A * ((float)Math.PI / 180F));
            float f4 = MathHelper.func_76126_a(-this.field_70125_A * ((float)Math.PI / 180F));
            return Vec3.func_72443_a((double)(f2 * f3), (double)f4, (double)(f1 * f3));
        } else {
            float f1 = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * p_70676_1_;
            float f2 = this.field_70758_at + (this.field_70759_as - this.field_70758_at) * p_70676_1_;
            float f3 = MathHelper.func_76134_b(-f2 * ((float)Math.PI / 180F) - (float)Math.PI);
            float f4 = MathHelper.func_76126_a(-f2 * ((float)Math.PI / 180F) - (float)Math.PI);
            float f5 = -MathHelper.func_76134_b(-f1 * ((float)Math.PI / 180F));
            float f6 = MathHelper.func_76126_a(-f1 * ((float)Math.PI / 180F));
            return Vec3.func_72443_a((double)(f4 * f5), (double)f6, (double)(f3 * f5));
        }
    }

    public void func_70691_i(float p_70691_1_) {
        float f1 = this.func_110143_aJ();
        if (f1 > 0.0F && this.field_70180_af.func_111145_d(5) > 0.0F) {
            this.setTitanHealth(f1 + p_70691_1_);
        }

    }

    protected void func_70665_d(DamageSource p_70665_1_, float p_70665_2_) {
        if (p_70665_2_ > (TheTitans.NightmareMode ? 400.0F : 800.0F) && !(this instanceof EntitySlimeTitan)) {
            p_70665_2_ = TheTitans.NightmareMode ? 400.0F : 800.0F;
        }

        if (!this.func_85032_ar()) {
            p_70665_2_ = ForgeHooks.onLivingHurt(this, p_70665_1_, p_70665_2_);
            if (p_70665_2_ <= 0.0F) {
                return;
            }

            p_70665_2_ = this.func_70655_b(p_70665_1_, p_70665_2_);
            p_70665_2_ = this.func_70672_c(p_70665_1_, p_70665_2_);
            float f1 = p_70665_2_;
            p_70665_2_ = Math.max(p_70665_2_ - this.func_110139_bj(), 0.0F);
            this.func_110149_m(this.func_110139_bj() - (f1 - p_70665_2_));
            if (p_70665_2_ != 0.0F) {
                float f2 = this.func_110143_aJ();
                this.setTitanHealth(f2 - p_70665_2_);
                this.func_110142_aN().func_94547_a(p_70665_1_, f2, p_70665_2_);
                this.func_110149_m(this.func_110139_bj() - p_70665_2_);
            }
        }

    }

    @SideOnly(Side.CLIENT)
    public void func_70103_a(byte p_70103_1_) {
        if (p_70103_1_ == 2) {
            this.field_70721_aZ = 1.5F;
            this.field_70172_ad = this.field_70771_an;
            this.field_70737_aN = this.field_70738_aO = 10;
            this.field_70739_aP = 0.0F;
            this.func_85030_a(this.func_70621_aR(), this.func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
            this.func_70097_a(DamageSource.field_76377_j, 0.0F);
        }

    }

    public void func_70106_y() {
        if (this.deathTicks > 0 || this instanceof EntitySlimeTitan || this.field_70180_af.func_111145_d(5) <= 0.0F) {
            this.inactDeathAction();
            ArrayList listp = Lists.newArrayList(this.field_70170_p.field_73010_i);
            if (listp != null && !listp.isEmpty() && !this.field_70170_p.field_72995_K && !(this instanceof EntitySlimeTitan) && !(this instanceof EntityGargoyleTitan) && !(this instanceof EntityIronGolemTitan) && !(this instanceof EntitySnowGolemTitan)) {
                for(int i1 = 0; i1 < listp.size(); ++i1) {
                    Entity entity = (Entity)listp.get(i1);
                    if (entity != null && entity instanceof EntityPlayer) {
                        this.func_70642_aH();
                        ((EntityPlayer)entity).func_145747_a(new ChatComponentText(this.func_70005_c_() + ": I will return, " + entity.func_70005_c_()));
                    }
                }
            }

            super.func_70106_y();
        }

    }

    protected void inactDeathAction() {
        this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u + (double)3.0F, this.field_70161_v, 0.0F, false, false);
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
            this.func_70628_a(true, 0);
            this.func_82160_b(true, 0);
            this.func_70600_l(1);
        }

    }

    public void func_82206_m() {
        this.setInvulTime(this.getTitanStatus() == EnumTitanStatus.GOD ? 7100 : (this.getTitanStatus() == EnumTitanStatus.GREATER ? 1310 : (!(this instanceof EntitySnowGolemTitan) && !(this instanceof EntitySlimeTitan) ? 850 : 150)));
        this.setWaiting(false);
    }

    protected void applyEntityAI() {
    }

    public boolean func_70650_aV() {
        return true;
    }

    public void func_70624_b(EntityLivingBase p_70624_1_) {
        if (p_70624_1_ != EntityList.func_75620_a("MobzillaHead", this.field_70170_p) && p_70624_1_ != EntityList.func_75620_a("KingHead", this.field_70170_p) && p_70624_1_ != EntityList.func_75620_a("QueenHead", this.field_70170_p) && !this.getWaiting() && this.animID != 13 && p_70624_1_ != null && p_70624_1_.field_70163_u < (double)256.0F && p_70624_1_.func_70089_S() && this.func_70686_a(p_70624_1_.getClass()) && p_70624_1_ != this.field_70154_o && p_70624_1_ != this.field_70153_n) {
            super.func_70624_b(p_70624_1_);
            if (!this.field_70170_p.field_72995_K && p_70624_1_ instanceof EntityPlayer && p_70624_1_.field_70173_aa > 100 && !((EntityPlayer)p_70624_1_).field_71071_by.func_146028_b(TitanItems.ultimaBlade) && ((EntityPlayer)p_70624_1_).func_70089_S() && ((EntityPlayer)p_70624_1_).field_70172_ad <= 10) {
                if (this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
                    MinecraftServer.func_71276_C().func_147139_a(EnumDifficulty.EASY);
                }

                if (!((EntityPlayer)p_70624_1_).func_70097_a((new DamageSource("other")).func_76348_h().func_151518_m().func_76359_i(), 1.0F)) {
                    ((EntityPlayer)p_70624_1_).field_71071_by.func_70436_m();
                    ((EntityPlayer)p_70624_1_).func_70606_j(0.0F);
                    MinecraftServer.func_71276_C().func_71203_ab().func_152612_a(((EntityPlayer)p_70624_1_).func_70005_c_()).field_71135_a.func_147360_c(this.func_70005_c_() + " has kicked you for cheating.");
                }
            }
        } else if (p_70624_1_ instanceof EntityTitan && (this.field_70170_p.field_73011_w instanceof WorldProviderVoid || ((EntityTitan)p_70624_1_).getInvulTime() > 0 || ((EntityTitan)p_70624_1_).getWaiting() || ((EntityTitan)p_70624_1_).animID == 13) && !(p_70624_1_ instanceof EntityWitherzilla)) {
            super.func_70624_b((EntityLivingBase)null);
        } else {
            super.func_70624_b((EntityLivingBase)null);
        }

    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(5, Float.MAX_VALUE);
        this.field_70180_af.func_75682_a(20, new Integer(0));
        this.field_70180_af.func_75682_a(21, new Integer(0));
        this.field_70180_af.func_75682_a(22, new Integer(0));
        this.field_70180_af.func_75682_a(23, new Byte((byte)0));
    }

    protected void jumpAtEntity(EntityLivingBase e) {
        ++this.field_70181_x;
        ++this.field_70163_u;
        double d1 = e.field_70165_t - this.field_70165_t;
        double d2 = e.field_70161_v - this.field_70161_v;
        float d = (float)Math.atan2(d2, d1);
        float f2 = (float)((double)d * (double)180.0F / Math.PI) - 90.0F;
        this.field_70177_z = f2;
        d1 = Math.sqrt(d1 * d1 + d2 * d2);
        this.field_70159_w += d1 * 0.05 * Math.cos((double)d);
        this.field_70179_y += d1 * 0.05 * Math.sin((double)d);
        this.field_70160_al = true;
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        this.setInvulTime(tagCompund.func_74762_e("Invul"));
        this.setExtraPower(tagCompund.func_74762_e("ExtraPower"));
        this.setWaiting(tagCompund.func_74767_n("Waiting"));
    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        tagCompound.func_74768_a("Invul", this.getInvulTime());
        tagCompound.func_74768_a("ExtraPower", this.getExtraPower());
        tagCompound.func_74757_a("Waiting", this.getWaiting());
    }

    public void func_70078_a(Entity p_70078_1_) {
        if (p_70078_1_ instanceof EntityLivingBase) {
            super.func_70078_a(p_70078_1_);
        }

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
        return 6;
    }

    public int getSpecialMinionCap() {
        return 6;
    }

    public int getExtraPower() {
        return this.field_70180_af.func_75679_c(21);
    }

    public void setExtraPower(int p_82215_1_) {
        this.field_70180_af.func_75692_b(21, p_82215_1_);
    }

    public int getRandomName() {
        return this.field_70180_af.func_75679_c(21);
    }

    public void setRandomName(int p_82215_1_) {
        this.field_70180_af.func_75692_b(21, p_82215_1_);
    }

    public boolean getWaiting() {
        return this.field_70180_af.func_75683_a(23) == 1;
    }

    public void setWaiting(boolean p_82215_1_) {
        this.field_70180_af.func_75692_b(23, Byte.valueOf((byte)(p_82215_1_ ? 1 : 0)));
    }

    public int getInvulTime() {
        return this.field_70180_af.func_75679_c(20);
    }

    public void setInvulTime(int p_82215_1_) {
        if (!this.field_70170_p.field_72995_K) {
            if (p_82215_1_ < 0) {
                this.field_70180_af.func_75692_b(20, 0);
            } else {
                this.field_70180_af.func_75692_b(20, p_82215_1_);
                this.field_70127_C = this.field_70125_A = 0.0F + (float)p_82215_1_ / ((float)this.getThreashHold() / 180.0F);
            }
        }

    }

    public boolean destroyBlocksInAABBGriefingBypass(AxisAlignedBB p_70972_1_) {
        int i = MathHelper.func_76128_c(p_70972_1_.field_72340_a);
        int j = MathHelper.func_76128_c(p_70972_1_.field_72338_b);
        int k = MathHelper.func_76128_c(p_70972_1_.field_72339_c);
        int l = MathHelper.func_76128_c(p_70972_1_.field_72336_d);
        int i1 = MathHelper.func_76128_c(p_70972_1_.field_72337_e);
        int j1 = MathHelper.func_76128_c(p_70972_1_.field_72334_f);
        boolean flag = false;
        boolean flag1 = false;

        for(int k1 = i; k1 <= l; ++k1) {
            for(int l1 = j; l1 <= i1; ++l1) {
                for(int i2 = k; i2 <= j1; ++i2) {
                    Block block = this.field_70170_p.func_147439_a(k1, l1, i2);
                    if (!block.isAir(this.field_70170_p, k1, l1, i2) && !this.field_70170_p.field_72995_K && block.func_149712_f(this.field_70170_p, k1, l1, i2) != -1.0F) {
                        flag1 = this.field_70170_p.func_147468_f(k1, l1, i2) || flag1;
                    }
                }
            }
        }

        return flag;
    }

    public void destroyBlocksInAABB(AxisAlignedBB p_70972_1_) {
        int i = MathHelper.func_76128_c(p_70972_1_.field_72340_a);
        int j = MathHelper.func_76128_c(p_70972_1_.field_72338_b);
        int k = MathHelper.func_76128_c(p_70972_1_.field_72339_c);
        int l = MathHelper.func_76128_c(p_70972_1_.field_72336_d);
        int i1 = MathHelper.func_76128_c(p_70972_1_.field_72337_e);
        int j1 = MathHelper.func_76128_c(p_70972_1_.field_72334_f);

        for(int k1 = i; k1 <= l; ++k1) {
            for(int l1 = j; l1 <= i1; ++l1) {
                for(int i2 = k; i2 <= j1; ++i2) {
                    Block block = this.field_70170_p.func_147439_a(k1, l1, i2);
                    if (this.field_70173_aa > 5 && p_70972_1_ != null && this.field_70170_p.func_72904_c(k1, l1, i2, k1, l1, i2) && !block.isAir(this.field_70170_p, k1, l1, i2) && !this.field_70170_p.field_72995_K && block.func_149712_f(this.field_70170_p, k1, l1, i2) != -1.0F) {
                        if (!block.func_149688_o().func_76224_d() && block != Blocks.field_150480_ab && block != Blocks.field_150321_G) {
                            if (this.field_70146_Z.nextInt(3) == 0) {
                                EntityFallingBlockTitan entityfallingblock = new EntityFallingBlockTitan(this.field_70170_p, (double)k1 + (double)0.5F, (double)l1 + (double)0.5F, (double)i2 + (double)0.5F, block, this.field_70170_p.func_72805_g(k1, l1, i2));
                                entityfallingblock.func_70107_b((double)k1 + (double)0.5F, (double)l1 + (double)0.5F, (double)i2 + (double)0.5F);
                                double d0 = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / (double)2.0F;
                                double d1 = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / (double)2.0F;
                                double d2 = entityfallingblock.field_70165_t - d0;
                                double d3 = entityfallingblock.field_70161_v - d1;
                                double d4 = d2 * d2 + d3 * d3;
                                entityfallingblock.func_70015_d(10);
                                entityfallingblock.func_70024_g(d2 / d4 * (double)10.0F, (double)2.0F + this.field_70146_Z.nextGaussian(), d3 / d4 * (double)10.0F);
                                this.field_70170_p.func_72838_d(entityfallingblock);
                                this.field_70170_p.func_147468_f(k1, l1, i2);
                            } else if (this.field_70170_p.func_72890_a(this, (double)16.0F) != null) {
                                this.field_70170_p.func_147480_a(k1, l1, i2, true);
                            } else {
                                this.field_70170_p.func_147468_f(k1, l1, i2);
                                block.func_149697_b(this.field_70170_p, k1, l1, i2, this.field_70170_p.func_72805_g(k1, l1, i2), 0);
                            }
                        } else {
                            this.field_70170_p.func_147468_f(k1, l1, i2);
                        }
                    }
                }
            }
        }

    }

    public void destroyBlocksInAABBTopless(AxisAlignedBB p_70972_1_) {
        int i = MathHelper.func_76128_c(p_70972_1_.field_72340_a);
        int j = MathHelper.func_76128_c(p_70972_1_.field_72338_b);
        int k = MathHelper.func_76128_c(p_70972_1_.field_72339_c);
        int l = MathHelper.func_76128_c(p_70972_1_.field_72336_d);
        int i1 = MathHelper.func_76128_c(p_70972_1_.field_72337_e);
        int j1 = MathHelper.func_76128_c(p_70972_1_.field_72334_f);

        for(int k1 = i; k1 <= l; ++k1) {
            for(int l1 = j; l1 <= i1; ++l1) {
                for(int i2 = k; i2 <= j1; ++i2) {
                    Block block = this.field_70170_p.func_147439_a(k1, l1, i2);
                    Block block1 = this.field_70170_p.func_147439_a(k1, l1 + 1, i2);
                    if (this.field_70173_aa > 5 && p_70972_1_ != null && this.field_70170_p.func_72904_c(k1, l1, i2, k1, l1, i2) && block.func_149662_c() && !block1.func_149662_c() && !this.field_70170_p.field_72995_K && block.func_149712_f(this.field_70170_p, k1, l1, i2) != -1.0F) {
                        if (!block.func_149688_o().func_76224_d() && block != Blocks.field_150480_ab && block != Blocks.field_150321_G) {
                            if (this.field_70146_Z.nextInt(3) == 0) {
                                EntityFallingBlockTitan entityfallingblock = new EntityFallingBlockTitan(this.field_70170_p, (double)k1 + (double)0.5F, (double)l1 + (double)0.5F, (double)i2 + (double)0.5F, block, this.field_70170_p.func_72805_g(k1, l1, i2));
                                entityfallingblock.func_70107_b((double)k1 + (double)0.5F, (double)l1 + (double)0.5F, (double)i2 + (double)0.5F);
                                double d0 = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / (double)2.0F;
                                double d1 = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / (double)2.0F;
                                double d2 = entityfallingblock.field_70165_t - d0;
                                double d3 = entityfallingblock.field_70161_v - d1;
                                double d4 = d2 * d2 + d3 * d3;
                                entityfallingblock.func_70015_d(10);
                                entityfallingblock.func_70024_g(d2 / d4 * (double)10.0F, (double)2.0F + this.field_70146_Z.nextGaussian(), d3 / d4 * (double)10.0F);
                                this.field_70170_p.func_72838_d(entityfallingblock);
                                this.field_70170_p.func_147468_f(k1, l1, i2);
                            } else if (this.field_70170_p.func_72890_a(this, (double)16.0F) != null) {
                                this.field_70170_p.func_147480_a(k1, l1, i2, true);
                            } else {
                                this.field_70170_p.func_147468_f(k1, l1, i2);
                                block.func_149697_b(this.field_70170_p, k1, l1, i2, this.field_70170_p.func_72805_g(k1, l1, i2), 0);
                            }
                        } else {
                            this.field_70170_p.func_147468_f(k1, l1, i2);
                        }
                    }
                }
            }
        }

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
                this.destroyBlocksInAABBTopless(this.field_70121_D.func_72314_b(this.getTitanStatus() == EnumTitanStatus.LESSER ? (double)6.0F : (double)12.0F, (double)1.0F, this.getTitanStatus() == EnumTitanStatus.LESSER ? (double)6.0F : (double)12.0F));
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
                        }
                    }
                }
            }

        }
    }

    public boolean func_70104_M() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_90999_ad() {
        return false;
    }

    public int func_70658_aO() {
        switch (this.getTitanStatus()) {
            case GOD:
                return 24;
            case GREATER:
                return 23;
            case AVERAGE:
                return 22;
            default:
                return 21;
        }
    }

    public int func_70641_bl() {
        return 1;
    }

    public int getTitanExperienceDropAmount() {
        return 1;
    }

    public float func_70603_bj() {
        return this.getTitanStatus() == EnumTitanStatus.GREATER ? 20.0F : 16.0F;
    }

    public void func_70690_d(PotionEffect p_70690_1_) {
    }

    protected float func_70599_aP() {
        return 100.0F;
    }

    protected void func_70623_bb() {
        this.field_70708_bq = 0;
    }

    public int func_70627_aG() {
        return 120;
    }

    public int getMaxFallHeight() {
        return this.field_70170_p.func_72800_K();
    }

    public void func_70110_aj() {
    }

    public int getMinionSpawnRate() {
        return 0;
    }

    public boolean func_70072_I() {
        return false;
    }

    public boolean func_70058_J() {
        return false;
    }

    protected int func_70682_h(int p_70682_1_) {
        return p_70682_1_;
    }

    public double getSpeed() {
        return 0.3 + (double)this.getExtraPower() * 0.001;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.getWaiting() && this.animID != 0 && this.deathTicks < this.getThreashHold()) {
            ++this.animTick;
            if (this.func_70631_g_() && this.func_70089_S()) {
                ++this.animTick;
            }
        }

    }

    public double getMeleeRange() {
        return (double)(this.field_70130_N * this.field_70130_N + (this.func_70638_az().field_70130_N > 48.0F ? 2304.0F : this.func_70638_az().field_70130_N * this.func_70638_az().field_70130_N)) + (double)800.0F;
    }

    public void func_70024_g(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
    }

    public void addTitanVelocity(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
        if (!this.getWaiting() && this.animID != 13) {
            this.field_70159_w += p_70024_1_;
            this.field_70181_x += p_70024_3_;
            this.field_70179_y += p_70024_5_;
        }

    }

    public void func_70636_d() {
        if (this.func_70638_az() != null && this.func_70638_az() instanceof EntityLiving && isOreSpawnBossToExempt(this.func_70638_az())) {
            ((EntityLiving)this.func_70638_az()).func_70624_b(this);
            ((EntityLiving)this.func_70638_az()).func_70671_ap().func_75651_a(this, 180.0F, 180.0F);
        }

        if (this.animID == 13 && this.animTick == 4 && this.field_70170_p.func_72890_a(this, (double)32.0F) != null) {
            this.func_70671_ap().func_75651_a(this.field_70170_p.func_72890_a(this, (double)32.0F), 180.0F, 0.0F);
        }

        this.field_70160_al = !this.field_70122_E;
        if (this.field_70159_w > (double)1.5F) {
            this.field_70159_w = (double)1.5F;
        }

        if (this.field_70179_y > (double)1.5F) {
            this.field_70179_y = (double)1.5F;
        }

        if (this.field_70159_w < (double)-1.5F) {
            this.field_70159_w = (double)-1.5F;
        }

        if (this.field_70179_y < (double)-1.5F) {
            this.field_70179_y = (double)-1.5F;
        }

        Calendar calendar = this.field_70170_p.func_83015_S();
        if (!this.getWaiting() && this.field_70170_p.func_72820_D() < 14000L && !this.isRejuvinating && !(this instanceof EntitySlimeTitan) && !(this instanceof EntitySnowGolemTitan) && !(this instanceof EntityIronGolemTitan) && !(this instanceof EntityGargoyleTitan) && (this.animID == 13 && !this.getWaiting() || calendar.get(2) + 1 == 10 && calendar.get(5) >= 1 && calendar.get(5) <= 31)) {
            this.field_70170_p.func_72877_b(this.field_70170_p.func_72820_D() + 50L);
        }

        if (this.field_70170_p.func_72820_D() > 24000L) {
            this.field_70170_p.func_72877_b(0L);
        }

        if (this.func_70638_az() != null && (!this.func_70638_az().func_70089_S() || this.func_70638_az().field_70163_u > (double)256.0F || this.func_70638_az().field_70163_u < (double)-45.0F)) {
            this.func_70624_b((EntityLivingBase)null);
        }

        if (this.func_70638_az() != null && this.func_70638_az() instanceof EntityLiving && !(this.func_70638_az() instanceof EntityTitanSpirit) && !(this.func_70638_az() instanceof EntityTitan) && this.func_70638_az().func_110138_aP() > 1.0E9F) {
            this.func_70638_az().func_85030_a("random.explode", 2.0F, 1.0F + this.field_70146_Z.nextFloat());
            this.damageBypassEntity(this.func_70638_az(), (new DamageSource("infinity")).func_76348_h().func_76359_i().func_151518_m(), this.func_70638_az().func_110143_aJ() / 2.0F);
            if (this.func_70638_az().func_110143_aJ() <= 1.0F) {
                this.field_70170_p.func_72876_a(this, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 7.0F, false);
                this.func_70638_az().func_70106_y();
            }
        }

        if (this != null && !this.field_70170_p.field_72995_K && this.func_70638_az() != null && this.func_70638_az() instanceof EntityPlayer && ((EntityPlayer)this.func_70638_az()).field_71075_bZ.field_75102_a && !((EntityPlayer)this.func_70638_az()).field_71075_bZ.field_75098_d) {
            MinecraftServer.func_71276_C().func_71203_ab().func_152612_a(((EntityPlayer)this.func_70638_az()).func_70005_c_()).field_71135_a.func_147360_c(this.func_70005_c_() + " has detected you not taking normal damage out of creative, and kicked you for it.");
        }

        if (this.field_70154_o != null) {
            this.field_70761_aq = this.field_70177_z = this.field_70154_o.field_70177_z;
        }

        if (this.animID == 0) {
            this.animTick = 0;
        } else {
            this.field_70761_aq = this.field_70177_z = this.field_70759_as;
        }

        if (this.getWaiting()) {
            this.field_70159_w = (double)0.0F;
            this.field_70179_y = (double)0.0F;
            if (this.field_70181_x > (double)0.0F) {
                this.field_70181_x = (double)0.0F;
            }
        }

        if (this.animID == 0 && !this.field_70170_p.field_72995_K && this.func_70638_az() != null && this.shouldMove() && !(this instanceof EntityGhastTitan)) {
            double d0 = this.func_70638_az().field_70165_t - this.field_70165_t;
            double d1 = this.func_70638_az().field_70161_v - this.field_70161_v;
            float f2 = MathHelper.func_76133_a(d0 * d0 + d1 * d1);
            this.field_70761_aq = this.field_70177_z = this.field_70759_as;
            this.field_70159_w += d0 / (double)f2 * this.getSpeed() * this.getSpeed();
            this.field_70179_y += d1 / (double)f2 * this.getSpeed() * this.getSpeed();
        }

        if (this.field_70725_aQ == 1) {
            this.func_85030_a(this.func_70673_aS(), this.func_70599_aP(), this.func_70647_i());
        }

        this.field_70180_af.func_75692_b(6, MathHelper.func_76131_a(this.field_70180_af.func_111145_d(5), 0.0F, this.func_110138_aP()));
        if (TheTitans.TitansFFAMode && this.field_70154_o != null) {
            this.field_70154_o = null;
        }

        if (this.animID < 0) {
            this.animID = 0;
        }

        if (this.field_70180_af.func_111145_d(5) <= 0.0F) {
            if (this instanceof EntityWitherzilla && this.getExtraPower() > 5) {
                this.field_70180_af.func_75692_b(5, MathHelper.func_76131_a(this.func_110138_aP(), 0.0F, this.func_110138_aP()));
            }

            this.onTitanDeathUpdate();
        } else {
            this.field_70180_af.func_75692_b(6, MathHelper.func_76131_a(this.field_70180_af.func_111145_d(5), 0.0F, this.func_110138_aP()));
            this.deathTicks = 0;
            if (this.animID == 10) {
                this.animID = 0;
            }
        }

        if (this.field_70163_u > (double)300.0F) {
            this.field_70181_x = (double)0.0F;
            this.func_70107_b(this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 32.0F - 16.0F), (double)60.0F, this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 32.0F - 16.0F));
        }

        if (this.field_70163_u <= (double)0.0F) {
            this.func_70107_b(this.field_70165_t, (double)0.0F, this.field_70161_v);
            this.field_70122_E = true;
            this.field_70160_al = false;
            this.field_70143_R = 0.0F;
            if (this.field_70181_x < (double)0.0F) {
                this.field_70181_x = (double)0.0F;
            }
        }

        if (this.numMinions < 0) {
            this.numMinions = 0;
        }

        if (this.numPriests < 0) {
            this.numPriests = 0;
        }

        if (this.numZealots < 0) {
            this.numZealots = 0;
        }

        if (this.numTemplar < 0) {
            this.numTemplar = 0;
        }

        if (this.numSpecialMinions < 0) {
            this.numSpecialMinions = 0;
        }

        if (this.func_110143_aJ() <= 0.0F && this.field_70181_x > (double)0.0F) {
            this.field_70181_x = (double)0.0F;
        }

        if (this.animTick < 0) {
            this.animTick = 0;
        }

        this.field_70134_J = false;
        this.field_110153_bc = (float)Integer.MAX_VALUE;
        this.field_70138_W = this.field_70131_O / 2.0F;
        this.func_82168_bl();
        this.field_70158_ak = true;
        if (this.func_70638_az() != null && this.animID == 0) {
            this.func_70671_ap().func_75651_a(this.func_70638_az(), 5.0F, (float)this.func_70646_bf());
        }

        for(int u = 0; u < 30; ++u) {
            if (this.field_70159_w != (double)0.0F && this.field_70179_y != (double)0.0F && this.field_70122_E) {
                int i = MathHelper.func_76128_c(this.field_70165_t + (this.field_70146_Z.nextDouble() * (double)this.field_70130_N - (double)(this.field_70130_N / 2.0F)));
                int j = MathHelper.func_76128_c(this.field_70163_u - (double)0.2F);
                int k = MathHelper.func_76128_c(this.field_70161_v + (this.field_70146_Z.nextDouble() * (double)this.field_70130_N - (double)(this.field_70130_N / 2.0F)));
                Block block = this.field_70170_p.func_147439_a(i, j, k);
                if (block.func_149688_o() != Material.field_151579_a) {
                    this.field_70170_p.func_72869_a("blockcrack_" + Block.func_149682_b(block) + "_" + this.field_70170_p.func_72805_g(i, j, k), this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, this.field_70121_D.field_72338_b + 0.1, this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, (double)4.0F * ((double)this.field_70146_Z.nextFloat() - (double)0.5F), (double)0.5F, ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)4.0F);
                }
            }
        }

        super.func_70606_j(this.field_70180_af.func_111145_d(5));
        super.func_70636_d();
        if (this.func_70638_az() != null && this.animID == 0 && this.field_70173_aa % 30 == 0 && this.canAttack()) {
            double d0 = this.func_70068_e(this.func_70638_az());
            if (d0 < this.getMeleeRange()) {
                this.func_71038_i();
                this.func_70671_ap().func_75651_a(this.func_70638_az(), 5.0F, (float)this.func_70646_bf());
                this.field_70761_aq = this.field_70177_z = this.field_70759_as;
                this.func_70652_k(this.func_70638_az());
            }
        }

        if (this.func_70638_az() != null && this.func_70638_az() == this.field_70154_o || this.func_70638_az() != null && this.func_70638_az() == this.field_70153_n) {
            this.func_70624_b((EntityLivingBase)null);
        }

        if (this.field_70170_p.field_72995_K && this.deathTicks < this.getThreashHold() && !(this instanceof EntityWitherzilla)) {
            for(int i = 0; i < this.getParticleCount(); ++i) {
                if (this.shouldParticlesBeUpward) {
                    this.field_70170_p.func_72869_a(this.getParticles(), this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.25F, (double)0.0F);
                } else {
                    this.field_70170_p.func_72869_a(this.getParticles(), this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                }
            }

            if (TheTitans.TotalDestructionMode && this.field_70146_Z.nextInt(5) == 0) {
                for(int i = 0; i < 5; ++i) {
                    this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                }
            }

            if (TheTitans.NightmareMode && this.field_70146_Z.nextInt(20) == 0) {
                for(int i = 0; i < 5; ++i) {
                    this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                    this.field_70170_p.func_72869_a("flame", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                    this.field_70170_p.func_72869_a("flame", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                    this.field_70170_p.func_72869_a("lava", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                    this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                    this.field_70170_p.func_72869_a("smoke", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                }
            }
        }

    }

    public boolean func_104002_bU() {
        return true;
    }

    public boolean canAttack() {
        return this.meleeTitan;
    }

    public boolean shouldMove() {
        return !(this instanceof EntityWitherzilla) && this.func_70638_az() != null && this.func_70068_e(this.func_70638_az()) > this.getMeleeRange() + (this.meleeTitan ? (double)0.0F : (double)10000.0F);
    }

    public int getFootID() {
        return this.footID;
    }

    protected void func_70619_bc() {
        List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D);
        if (list11 != null && !list11.isEmpty()) {
            for(int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                this.func_70108_f(entity);
            }
        }

        if (this.field_70146_Z.nextInt(1000) == 0 && this.func_110143_aJ() < this.func_110138_aP() / 20.0F && this.deathTicks <= 0 || this.func_110143_aJ() < this.func_110138_aP() / 2.0F && this.deathTicks <= 0 && this.func_70638_az() != null && this.func_70638_az() instanceof EntityTitan && !this.isRejuvinating && ((EntityTitan)this.func_70638_az()).isRejuvinating && !(this instanceof EntitySlimeTitan) && !(this instanceof EntitySnowGolemTitan) && !(this instanceof EntityIronGolemTitan) && !(this instanceof EntityGargoyleTitan)) {
            this.isRejuvinating = true;
            this.field_70170_p.func_82739_e(1013, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
            this.setExtraPower(this.getExtraPower() + 1);
            this.func_70664_aZ();
        }

        if (this.isRejuvinating) {
            this.setInvulTime(this.getInvulTime() + 5);
            this.func_70057_ab();
            if (this.getInvulTime() > this.getThreashHold()) {
                this.isRejuvinating = false;
            }
        }

        if (this.getInvulTime() > 0) {
            this.field_70159_w *= (double)0.0F;
            this.field_70179_y *= (double)0.0F;
            int i = this.getInvulTime() - 1;
            if (i <= 0) {
                if (!(this instanceof EntitySnowGolemTitan) && !(this instanceof EntityIronGolemTitan) && !(this instanceof EntityGargoyleTitan)) {
                    this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u + (double)(this.field_70131_O / 2.0F), this.field_70161_v, this.field_70131_O, false, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                }

                this.field_70170_p.func_82739_e(1013, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                this.destroyBlocksInAABB(this.field_70121_D);
                if (this instanceof EntityZombieTitan && !((EntityZombieTitan)this).isArmed()) {
                    AnimationAPI.sendAnimPacket((EntityZombieTitan)this, 2);
                }
            }

            this.setInvulTime(i);
            if (this.field_70173_aa % 1 == 0) {
                this.func_70691_i(this.func_110138_aP() / 1000.0F);
            }
        } else {
            super.func_70619_bc();
            if (!(this instanceof EntitySlimeTitan)) {
                float at;
                if (this.getTitanStatus() == EnumTitanStatus.AVERAGE) {
                    at = 3.0F;
                } else if (this.getTitanStatus() == EnumTitanStatus.GREATER) {
                    at = 6.0F;
                } else if (this.getTitanStatus() == EnumTitanStatus.GOD) {
                    at = 20.0F;
                } else {
                    at = 1.0F;
                }

                if ((this instanceof EntityZombieTitan || this instanceof EntitySkeletonTitan) && this.field_70170_p.func_72935_r()) {
                    at /= 3.0F;
                }

                if (this instanceof EntitySnowGolemTitan || this instanceof EntityIronGolemTitan || this instanceof EntityGargoyleTitan) {
                    at = 0.1F;
                }

                this.func_70691_i(at);

                for(int u = 0; u < 1 + this.field_70146_Z.nextInt(10); ++u) {
                    this.func_70691_i(at);
                }
            }

            if (this.func_70638_az() != null && !(this instanceof EntitySlimeTitan) && (this.func_70638_az() instanceof EntityAmbientCreature || this.func_70638_az() instanceof EntityAnimal || this.func_70638_az() instanceof EntityWaterMob)) {
                this.func_70638_az().func_70106_y();
            }
        }

    }

    public IEntityLivingData func_110161_a(IEntityLivingData p_110161_1_) {
        this.setTitanHealth(this.func_110138_aP());
        return super.func_110161_a(p_110161_1_);
    }

    public void func_70645_a(DamageSource p_70645_1_) {
        Entity entity = p_70645_1_.func_76346_g();
        ArrayList listp = Lists.newArrayList(this.field_70170_p.field_73010_i);
        if (listp != null && !listp.isEmpty() && !this.field_70170_p.field_72995_K && entity != null && entity instanceof EntityLivingBase) {
            for(int i1 = 0; i1 < listp.size(); ++i1) {
                EntityPlayer entityplayer = (EntityPlayer)listp.get(i1);
                if (this.field_70180_af.func_111145_d(5) > 0.0F) {
                    entityplayer.func_145747_a(new ChatComponentText(this.func_94057_bL() + " has refused to let " + entity.func_70005_c_() + " cheat..."));
                } else {
                    entityplayer.func_145747_a(new ChatComponentText(this.func_94057_bL() + " has been defeated by " + entity.func_70005_c_()));
                }
            }
        }

        if (this.field_70180_af.func_111145_d(5) <= 0.0F) {
            EntityLivingBase entitylivingbase = this.func_94060_bK();
            if (this.field_70744_aE >= 0 && entitylivingbase != null) {
                entitylivingbase.func_70084_c(this, this.field_70744_aE);
            }

            if (entity != null) {
                entity.func_70074_a(this);
            }

            this.field_70729_aU = true;
            this.func_110142_aN().func_94549_h();
            if (!this.field_70170_p.field_72995_K) {
                int i = 0;
                if (entity instanceof EntityPlayer) {
                    i = EnchantmentHelper.func_77519_f((EntityLivingBase)entity);
                }

                this.captureDrops = true;
                this.capturedDrops.clear();
                int j = 0;
                if (this.func_146066_aG() && this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
                    this.func_70628_a(this.field_70718_bc > 0, i);
                    this.func_82160_b(this.field_70718_bc > 0, i);
                    if (this.field_70718_bc > 0) {
                        j = this.field_70146_Z.nextInt(200) - i;
                        if (j < 5) {
                            this.func_70600_l(j <= 0 ? 1 : 0);
                        }
                    }
                }

                this.captureDrops = false;
                if (!ForgeHooks.onLivingDrops(this, p_70645_1_, this.capturedDrops, i, this.field_70718_bc > 0, j)) {
                    for(EntityItem item : this.capturedDrops) {
                        this.field_70170_p.func_72838_d(item);
                    }
                }
            }

            this.field_70170_p.func_72960_a(this, (byte)3);
        }

    }

    protected void func_70664_aZ() {
        super.func_70664_aZ();
        this.func_85030_a("thetitans:titanSwing", 5.0F, 2.0F);
        ++this.field_70181_x;
        ++this.field_70181_x;
    }

    public int getParticleCount() {
        return 6;
    }

    public String getParticles() {
        switch (this.getTitanStatus()) {
            case GOD:
                return "fireworksSpark";
            case GREATER:
                return "magicCrit";
            case AVERAGE:
                return "crit";
            default:
                return "enchantmenttable";
        }
    }

    public int getThreashHold() {
        return this.getTitanStatus() == EnumTitanStatus.GOD ? 7100 : (this.getTitanStatus() == EnumTitanStatus.GREATER ? 1310 : (!(this instanceof EntitySnowGolemTitan) && !(this instanceof EntitySlimeTitan) ? 850 : 150));
    }

    public void collideWithEntities(EntityTitanPart part, List p_70970_1_) {
        if (part != null && part.field_70170_p != null && !this.getWaiting()) {
            double d0 = (part.field_70121_D.field_72340_a + part.field_70121_D.field_72336_d) / (double)2.0F;
            double d1 = (part.field_70121_D.field_72339_c + part.field_70121_D.field_72334_f) / (double)2.0F;

            for(Entity entity : p_70970_1_) {
                boolean leg = part.field_146032_b == "rightleg" || part.field_146032_b == "leftleg" || part.field_146032_b == "leg1" || part.field_146032_b == "leg2" || part.field_146032_b == "leg3" || part.field_146032_b == "leg4";
                if (this.func_70686_a(entity.getClass()) && entity != null && !(entity instanceof EntityWebShot) && !(entity instanceof EntitySkeletonTitanGiantArrow) && !(entity instanceof EntityWitherSkull) && !(entity instanceof EntityTitanFireball) && !(entity instanceof EntityProtoBall) && !(entity instanceof EntityLightningBall) && !(entity instanceof EntityTitanPart) && !(entity instanceof EntityHarcadiumArrow) && !(entity instanceof EntityTitan) && !(entity instanceof EntityTitanSpirit)) {
                    double d2 = entity.field_70165_t - d0;
                    double d3 = entity.field_70161_v - d1;
                    double d4 = d2 * d2 + d3 * d3;
                    entity.func_70024_g(d2 / d4 * (leg ? (double)5.0F : (double)1.5F), leg ? (double)1.75F : (double)0.5F, d3 / d4 * (leg ? (double)5.0F : (double)1.5F));
                    if (!this.field_70170_p.field_72995_K && this.func_70686_a(entity.getClass()) && entity.field_70163_u <= part.field_70163_u - (double)part.field_70131_O - 0.01) {
                        entity.func_70097_a(DamageSource.func_92087_a(this), 20.0F);
                    }

                    if (this instanceof EntitySkeletonTitan && ((EntitySkeletonTitan)this).getSkeletonType() == 1 && entity instanceof EntityLivingBase) {
                        ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 1200, 3));
                    }
                }
            }
        }

    }

    public int getRegenTime() {
        return 20;
    }

    public int getKnockbackAmount() {
        switch (this.getTitanStatus()) {
            case GOD:
                return 24;
            case GREATER:
                return 16;
            case AVERAGE:
                return 8;
            default:
                return 4;
        }
    }

    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.LESSER;
    }

    protected String func_145776_H() {
        return "game.hostile.swim";
    }

    protected String func_145777_O() {
        return "game.hostile.swim.splash";
    }

    public boolean func_70687_e(PotionEffect p_70687_1_) {
        return false;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        Entity entity = source.func_76346_g();
        if (amount > (TheTitans.NightmareMode ? 500.0F : 1000.0F) && !(this instanceof EntitySlimeTitan)) {
            amount = TheTitans.NightmareMode ? 500.0F : 1000.0F;
        }

        if (isOreSpawnBossToExempt(source.func_76346_g()) || source.func_76346_g() instanceof EntityIronGolem || source.func_76346_g() instanceof EntityGiantZombieBetter || source.func_76346_g() instanceof EntityDragon || source.func_76346_g() instanceof EntityWither || source.func_76346_g() instanceof EntityDragonMinion || source.func_76346_g() instanceof EntityWitherMinion) {
            this.func_85030_a("thetitans:titanpunch", 50.0F, this.func_70631_g_() ? 1.5F : 1.0F);
            amount *= 10.0F;
        }

        if (!this.func_85032_ar() && source.func_76346_g() != null && !(amount <= 20.0F)) {
            if (source.func_76346_g() instanceof EntitySnowGolemTitan && this instanceof EntitySnowGolemTitan) {
                return false;
            } else if (source.func_76346_g() instanceof EntityPlayer && !this.canBeHurtByPlayer()) {
                return false;
            } else if (entity != null && entity instanceof EntityLivingBase && (this.field_70153_n != null && source.func_76346_g() == this.field_70153_n || entity.func_85032_ar() || entity.field_70131_O >= 6.0F || ((EntityLivingBase)entity).func_70658_aO() > 24 && !((EntityLivingBase)entity).func_70644_a(Potion.field_76444_x) || ((EntityLivingBase)entity).func_85032_ar() || ((EntityLivingBase)entity).func_70644_a(Potion.field_76420_g) && ((EntityLivingBase)entity).func_70660_b(Potion.field_76420_g).func_76458_c() > 255) && !whiteListNoDamage(entity) && !(entity instanceof EntityTameable)) {
                return false;
            } else if ((source.func_82725_o() || source.func_94541_c() || source.func_76347_k() || source.func_76355_l() == "inFire" || source.func_76355_l() == "onFire" || source.func_76355_l() == "lava" || source.func_76355_l() == "inWall" || source.func_76355_l() == "drown" || source.func_76355_l() == "starve" || source.func_76355_l() == "cactus" || source.func_76355_l() == "fall" || source.func_76355_l() == "generic" || source.func_76355_l() == "outOfWorld" || source.func_76355_l() == "magic" || source.func_76355_l() == "wither" || source.func_76355_l() == "anvil" || source.func_76355_l() == "fallingBlock" || source.func_76355_l() == "explosion.player" || source.func_76355_l() == "explosion" || source.func_76355_l() == "indirectMagic") && !(this instanceof EntitySlimeTitan)) {
                return false;
            } else if (super.func_70097_a(source, amount)) {
                if (entity != null && entity instanceof EntityLivingBase && this.animTick <= 12 && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
                    this.func_70624_b((EntityLivingBase)entity);
                    this.func_70604_c((EntityLivingBase)entity);
                }

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    protected String func_70621_aR() {
        return "game.hostile.hurt";
    }

    protected String func_70673_aS() {
        return "game.hostile.die";
    }

    protected String getFallSoundString(int damageValue) {
        return "thetitans:titanStep";
    }

    @SideOnly(Side.CLIENT)
    public void shakeNearbyPlayerCameras(double distance) {
        if (!this.field_70170_p.field_73010_i.isEmpty()) {
            for(int l1 = 0; l1 < this.field_70170_p.field_73010_i.size(); ++l1) {
                Entity entity = (Entity)this.field_70170_p.field_73010_i.get(l1);
                if (entity instanceof EntityPlayer && entity.func_70068_e(this) < distance) {
                    this.field_70170_p.func_72960_a((EntityPlayer)entity, (byte)2);
                    ((EntityPlayer)entity).field_70172_ad = 0;
                }
            }
        }

        if (!this.field_70170_p.field_72996_f.isEmpty()) {
            for(int l1 = 0; l1 < this.field_70170_p.field_72996_f.size(); ++l1) {
                Entity entity = (Entity)this.field_70170_p.field_72996_f.get(l1);
                if (entity instanceof EntityLiving && !(entity instanceof EntityTitan) && entity.func_70068_e(this) < distance) {
                    try {
                        ReflectionHelper.findField(entity.getClass(), new String[]{"hurt_timer"}).setInt((EntityLiving)entity, 0);
                    } catch (Exception var6) {
                        ((EntityLiving)entity).field_70172_ad = 0;
                    }

                    ((EntityLiving)entity).field_70172_ad = 0;
                    this.field_70170_p.func_72960_a((EntityLiving)entity, (byte)2);
                }
            }
        }

    }

    public static boolean isOreSpawnBossToExempt(Entity entity) {
        if (!(entity instanceof EntityLivingBase)) {
            return false;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof EntityOverlordScorpion) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof EntityMethuselahKraken) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Kraken) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof PitchBlack) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Godzilla) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof GodzillaHead) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof TheKing) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof TheQueen) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof KingHead) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof QueenHead) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof ThePrinceAdult) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof GiantRobot) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof AntRobot) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Basilisk) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof CaterKiller) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Cephadrome) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof EmperorScorpion) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof HerculesBeetle) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Hammerhead) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Leon) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Robot2) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Robot3) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Robot4) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof ThePrince) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof ThePrinceTeen) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof ThePrincess) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof SpiderRobot) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof TrooperBug) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Nastysaurus) {
            return true;
        } else {
            return Loader.isModLoaded("OreSpawn") && entity instanceof TRex;
        }
    }

    public static boolean whiteListNoDamage(Entity entity) {
        if (entity instanceof EntityPlayer) {
            return true;
        } else if (entity instanceof EntityTitan) {
            return true;
        } else if (entity instanceof EntityGiantZombieBetter) {
            return true;
        } else if (entity instanceof EntityDragonMinion) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof EntityOverlordScorpion) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof EntityMethuselahKraken) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Kraken) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof PitchBlack) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Godzilla) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof GodzillaHead) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof TheKing) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof TheQueen) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof KingHead) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof QueenHead) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof ThePrinceAdult) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof GiantRobot) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof AntRobot) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Basilisk) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof CaterKiller) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Cephadrome) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof EmperorScorpion) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof HerculesBeetle) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Hammerhead) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Leon) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Robot2) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Robot3) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Robot4) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof ThePrince) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof ThePrinceTeen) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof ThePrincess) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof SpiderRobot) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof TrooperBug) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof Nastysaurus) {
            return true;
        } else if (Loader.isModLoaded("OreSpawn") && entity instanceof TRex) {
            return true;
        } else if (entity instanceof EntityLivingBase && entity.field_70131_O > 6.0F) {
            return false;
        } else {
            return entity instanceof EntityLivingBase || entity instanceof EntityFireball || entity instanceof EntityArrow || entity instanceof EntityThrowable;
        }
    }

    public void attackChoosenEntity(Entity damagedEntity, float damage, int knockbackAmount) {
        float at;
        if (this.getTitanStatus() == EnumTitanStatus.AVERAGE) {
            at = 20.0F;
        } else if (this.getTitanStatus() == EnumTitanStatus.GREATER) {
            at = 50.0F;
        } else if (this.getTitanStatus() == EnumTitanStatus.GOD) {
            at = 200.0F;
        } else {
            at = 10.0F;
        }

        if (this.field_70170_p.field_73013_u == EnumDifficulty.EASY) {
            at *= 0.5F;
        }

        if (this.field_70170_p.field_73013_u == EnumDifficulty.HARD) {
            at *= 2.0F;
        }

        if (TheTitans.TotalDestructionMode) {
            at = Float.MAX_VALUE;
            damage = Float.MAX_VALUE;
        }

        damagedEntity.field_70172_ad = 0;
        if (!(damagedEntity instanceof EntityTitan) && damagedEntity.field_70131_O < 6.0F && this.func_70686_a(damagedEntity.getClass())) {
            damagedEntity.field_70181_x += this.field_70146_Z.nextDouble();
            if (knockbackAmount > 0) {
                damagedEntity.func_70024_g((double)(-MathHelper.func_76126_a(this.field_70761_aq * (float)Math.PI / 180.0F) * (float)knockbackAmount) * 0.2, (double)knockbackAmount * 0.2, (double)(MathHelper.func_76134_b(this.field_70761_aq * (float)Math.PI / 180.0F) * (float)knockbackAmount) * 0.2);
            }
        }

        if (damagedEntity != null && this.func_70089_S() && (damagedEntity instanceof EntityPlayer && damagedEntity.func_70005_c_() != "Umbrella_Ghast" || !(damagedEntity instanceof EntityFX) && !(damagedEntity instanceof EntityTitanPart) && !(damagedEntity instanceof EntityItem) && !(damagedEntity instanceof EntityXPOrb) && !(damagedEntity instanceof IProjectile) && !(damagedEntity instanceof EntityFireball))) {
            if (damagedEntity instanceof EntityEnderCrystal) {
                damagedEntity.func_70097_a((new DamageSource("other")).func_76348_h().func_151518_m().func_76359_i(), 100.0F);
            }

            if (damagedEntity instanceof EntityDragon) {
                this.field_70170_p.func_72885_a((Entity)null, damagedEntity.field_70165_t, damagedEntity.field_70163_u, damagedEntity.field_70161_v, 6.0F, false, false);
            }

            this.field_70761_aq = this.field_70177_z = this.field_70759_as;
            if (EnchantmentHelper.func_90036_a(this) > 0) {
                damagedEntity.func_70015_d(EnchantmentHelper.func_90036_a(this) * 100);
            }

            if (!(damagedEntity instanceof EntityLivingBase)) {
                damagedEntity.func_70097_a((new DamageSource("other")).func_76348_h().func_151518_m().func_76359_i(), damage);
                damagedEntity.func_70106_y();
            } else if (damagedEntity.func_70089_S()) {
                if (isOreSpawnBossToExempt(damagedEntity)) {
                    damagedEntity.field_70172_ad = 0;

                    try {
                        ReflectionHelper.findField(damagedEntity.getClass(), new String[]{"hurt_timer"}).setInt(damagedEntity, 0);
                    } catch (Exception var8) {
                        damagedEntity.field_70172_ad = 0;
                    }

                    try {
                        ReflectionHelper.findField(damagedEntity.getClass(), new String[]{"large_unknown_detected"}).setInt(this, 0);
                    } catch (Exception var7) {
                        damagedEntity.field_70172_ad = 0;
                    }

                    try {
                        ReflectionHelper.findField(damagedEntity.getClass(), new String[]{"player_hit_count"}).setInt(this, 10);
                    } catch (Exception var6) {
                        damagedEntity.field_70172_ad = 0;
                    }
                }

                if (damagedEntity.field_70131_O >= 6.0F || damagedEntity instanceof EntityTitan) {
                    damage *= isOreSpawnBossToExempt(damagedEntity) ? 2.0F : 10.0F;
                    damagedEntity.func_85030_a("thetitans:titanpunch", 50.0F, this.func_70631_g_() ? 1.5F : 1.0F);
                }

                if (damagedEntity instanceof EntityPlayer && ((EntityPlayer)damagedEntity).func_70005_c_() == "SuperGirlyGamer") {
                    damage *= 100.0F;
                    damagedEntity.field_70181_x += (double)10.0F;
                    damagedEntity.func_85030_a("thetitans:titanpunch", 50.0F, 1.0F);
                }

                if (damagedEntity instanceof EntityLivingBase && this.func_70686_a(damagedEntity.getClass()) && !(this instanceof EntitySlimeTitan) && !(this instanceof EntitySnowGolemTitan) && !(this instanceof EntityGargoyleTitan) && !(this instanceof EntityIronGolemTitan)) {
                    this.damageBypassEntity((EntityLivingBase)damagedEntity, DamageSourceExtra.causeSoulStealingDamage(this), at);
                    int b0 = 1 + this.field_70170_p.field_73013_u.func_151525_a();
                    ((EntityLivingBase)damagedEntity).func_70690_d(new PotionEffect(ClientProxy.electricJudgment.field_76415_H, b0 * 20, 2));
                }

                damage += EnchantmentHelper.func_152377_a(this.func_70694_bm(), ((EntityLivingBase)damagedEntity).func_70668_bt());
                knockbackAmount += EnchantmentHelper.func_77507_b(this, (EntityLivingBase)damagedEntity);
                if (damagedEntity instanceof EntityLivingBase && Loader.isModLoaded("OreSpawn") && ((EntityLivingBase)damagedEntity).func_110143_aJ() <= 2050.0F && (damagedEntity instanceof TheKing || damagedEntity instanceof TheQueen)) {
                    ((EntityLivingBase)damagedEntity).func_70096_w().func_75692_b(6, MathHelper.func_76131_a(1.0F, 0.0F, ((EntityLivingBase)damagedEntity).func_110138_aP()));
                    damagedEntity.func_70097_a(DamageSource.func_76365_a(this.field_70170_p.func_72890_a(this, (double)-1.0F)), damage);
                    this.damageBypassEntity((EntityLivingBase)damagedEntity, DamageSourceExtra.destroy, damage);
                    damagedEntity.func_85030_a("orespawn:trex_death", 5.0F, 1.0F);
                }

                if (damagedEntity instanceof EntityLivingBase && Loader.isModLoaded("OreSpawn") && damagedEntity instanceof PurplePower) {
                    ((EntityLivingBase)damagedEntity).func_70096_w().func_75692_b(6, MathHelper.func_76131_a(0.0F, 0.0F, ((EntityLivingBase)damagedEntity).func_110138_aP()));
                    damagedEntity.func_70097_a(DamageSource.func_76365_a(this.field_70170_p.func_72890_a(this, (double)-1.0F)), damage);
                    ((PurplePower)damagedEntity).func_70606_j(0.0F);
                    ((PurplePower)damagedEntity).func_85030_a("orespawn:trex_death", 2.0F, 0.9999F);
                    ((PurplePower)damagedEntity).func_85030_a("orespawn:trex_death", 2.0F, 1.0F);
                    ((PurplePower)damagedEntity).func_85030_a("orespawn:trex_death", 2.0F, 1.0001F);
                }

                if (!(damagedEntity instanceof EntityTitan) && this.func_70686_a(damagedEntity.getClass())) {
                    damagedEntity.field_70181_x += this.field_70146_Z.nextDouble();
                    if (knockbackAmount > 0) {
                        damagedEntity.func_70024_g((double)(-MathHelper.func_76126_a(this.field_70761_aq * (float)Math.PI / 180.0F) * (float)knockbackAmount) * 0.2, (double)knockbackAmount * 0.2, (double)(MathHelper.func_76134_b(this.field_70761_aq * (float)Math.PI / 180.0F) * (float)knockbackAmount) * 0.2);
                    }
                }

                if (damagedEntity instanceof EntityPlayer) {
                    if (!this.field_70170_p.field_72995_K && ((EntityPlayer)damagedEntity).func_70694_bm() != null && ((EntityPlayer)damagedEntity).func_70694_bm().func_77948_v() && ((EntityPlayer)damagedEntity).func_70694_bm().func_77973_b() != TitanItems.ultimaBlade) {
                        ((EntityPlayer)damagedEntity).func_70694_bm().func_77982_d(new NBTTagCompound());
                        this.func_70624_b((EntityPlayer)damagedEntity);
                    }

                    for(int i = 0; i < ((EntityPlayer)damagedEntity).field_71071_by.field_70460_b.length; ++i) {
                        if (((EntityPlayer)damagedEntity).field_71071_by.field_70460_b[i] != null) {
                            if (!(((EntityPlayer)damagedEntity).field_71071_by.field_70460_b[i].func_77973_b() instanceof ItemHarcadiumArmor)) {
                                ((EntityPlayer)damagedEntity).field_71071_by.field_70460_b[i].field_77994_a = 0;
                                ((EntityPlayer)damagedEntity).field_71071_by.field_70460_b[i] = null;
                                ((EntityPlayer)damagedEntity).func_85030_a("random.break", 0.8F, 0.8F + this.field_70170_p.field_73012_v.nextFloat() * 0.4F);
                                this.damageBypassEntity((EntityPlayer)damagedEntity, (new DamageSource("infinity")).func_76348_h().func_76359_i().func_151518_m(), at);
                            } else {
                                ((EntityPlayer)damagedEntity).field_71071_by.field_70460_b[i].func_77964_b((int)((float)((EntityPlayer)damagedEntity).field_71071_by.field_70460_b[i].func_77960_j() + damage));
                            }
                        }
                    }

                    if (((EntityPlayer)damagedEntity).field_71075_bZ.field_75102_a || this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
                        damagedEntity.func_70097_a(DamageSourceExtra.causeArmorPiercingMobDamage(this).func_151518_m().func_76359_i(), at);
                        this.damageBypassEntity((EntityPlayer)damagedEntity, (new DamageSource("infinity")).func_76348_h().func_76359_i().func_151518_m(), at);
                        this.damageBypassEntity((EntityPlayer)damagedEntity, (new DamageSource("other")).func_76348_h().func_151518_m().func_76359_i(), at);
                        this.damageBypassEntity((EntityPlayer)damagedEntity, DamageSource.field_76380_i.func_151518_m(), at);
                    }
                }

                if ((((EntityLivingBase)damagedEntity).func_85032_ar() && !(damagedEntity instanceof EntityTitan) || ((EntityLivingBase)damagedEntity).func_70658_aO() > 19 || (EntityLivingBase)damagedEntity instanceof EntityPlayer && ((EntityPlayer)damagedEntity).field_71075_bZ.field_75102_a || ((EntityLivingBase)damagedEntity).func_70644_a(Potion.field_76429_m) && ((EntityLivingBase)damagedEntity).func_70660_b(Potion.field_76429_m).func_76458_c() > 4) && !(damagedEntity instanceof EntityTitan) && !(damagedEntity instanceof IMinion) && !(damagedEntity instanceof EntityTameable)) {
                    if ((EntityLivingBase)damagedEntity instanceof EntityPlayer) {
                        if (this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
                            MinecraftServer.func_71276_C().func_147139_a(EnumDifficulty.HARD);
                        }

                        damagedEntity.func_70097_a(DamageSource.func_76358_a(this).func_76348_h().func_76359_i().func_151518_m(), at);
                        damagedEntity.func_70097_a((new DamageSource("infinity")).func_76348_h().func_76359_i().func_151518_m(), at);
                    } else {
                        damagedEntity.func_70097_a((new DamageSource("infinity")).func_76348_h().func_76359_i().func_151518_m(), at);
                        this.damageBypassEntity((EntityLivingBase)damagedEntity, (new DamageSource("infinity")).func_76348_h().func_76359_i().func_151518_m(), damage);
                    }
                } else if (this.func_70668_bt() == EnumCreatureAttribute.UNDEAD && ((EntityLivingBase)damagedEntity).func_70668_bt() == EnumCreatureAttribute.UNDEAD && !(damagedEntity instanceof EntityTitan)) {
                    this.damageBypassEntity((EntityLivingBase)damagedEntity, (new DamageSource("infinity")).func_76348_h().func_76359_i().func_151518_m(), damage);
                } else if ((!(damagedEntity.field_70131_O >= 6.0F) || damagedEntity instanceof EntityTameable || damagedEntity instanceof EntityTitan || damagedEntity instanceof EntityDragon || damagedEntity instanceof EntityDragonMinion) && (((EntityLivingBase)damagedEntity).func_70658_aO() <= 9 || damagedEntity instanceof EntityPlayer || damagedEntity instanceof EntityTitan || damagedEntity instanceof EntityDragon || damagedEntity instanceof IMinion)) {
                    damagedEntity.func_70097_a(DamageSource.func_76358_a(this), damage);
                } else {
                    this.damageBypassEntity((EntityLivingBase)damagedEntity, (new DamageSource("infinity")).func_76348_h().func_76359_i().func_151518_m(), damage);
                }
            }
        }

    }

    private void damageBypassEntity(EntityLivingBase entity, DamageSource p_70665_1_, float p_70665_2_) {
        if (entity.func_70089_S()) {
            if (p_70665_2_ <= 0.0F) {
                return;
            }

            float f1 = p_70665_2_;
            p_70665_2_ = Math.max(p_70665_2_ - entity.func_110139_bj(), 0.0F);
            entity.func_110149_m(entity.func_110139_bj() - (f1 - p_70665_2_));
            if (p_70665_2_ != 0.0F) {
                if (entity instanceof EntityCreature) {
                    EntityIronGolemTitan.addTitanTargetingTaskToEntity((EntityCreature)entity);
                }

                float f2 = entity.func_110143_aJ();
                if (!entity.func_70097_a(p_70665_1_, p_70665_2_)) {
                    entity.func_70096_w().func_75692_b(6, MathHelper.func_76131_a(f2 - p_70665_2_, 0.0F, entity.func_110138_aP()));
                }

                entity.func_110142_aN().func_94547_a(p_70665_1_, f2, p_70665_2_);
                entity.func_110149_m(entity.func_110139_bj() - p_70665_2_);
                if (!(entity instanceof EntityTitan)) {
                    if (entity.field_70131_O == 50.0F && entity.field_70130_N == 15.0F) {
                        entity.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)0.0F);
                        entity.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(this).func_76348_h().func_151518_m(), 40.0F);
                        entity.func_70690_d(new PotionEffect(ClientProxy.death.field_76415_H, Integer.MAX_VALUE, 19));
                    }

                    if (!entity.func_70089_S()) {
                        entity.func_70645_a(p_70665_1_);
                    }
                }
            }
        }

    }

    public boolean canBeHurtByPlayer() {
        return !this.func_85032_ar();
    }

    public boolean func_70652_k(Entity p_70652_1_) {
        this.func_71038_i();
        float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
        int i = this.getKnockbackAmount();
        if (TheTitans.TotalDestructionMode) {
            f = Float.MAX_VALUE;
        }

        this.attackChoosenEntity(p_70652_1_, f, i);
        if (p_70652_1_ instanceof EntityMob) {
            ((EntityMob)p_70652_1_).func_70604_c(this);
        }

        this.func_70671_ap().func_75651_a(p_70652_1_, 180.0F, (float)this.func_70646_bf());
        return true;
    }

    protected boolean isValidLightLevel() {
        int i = MathHelper.func_76128_c(this.field_70165_t);
        int j = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
        int k = MathHelper.func_76128_c(this.field_70161_v);
        if (this.field_70170_p.func_72972_b(EnumSkyBlock.Sky, i, j, k) > this.field_70146_Z.nextInt(32)) {
            return false;
        } else {
            int l = this.field_70170_p.func_72957_l(i, j, k);
            if (this.field_70170_p.func_72911_I()) {
                int i1 = this.field_70170_p.field_73008_k;
                this.field_70170_p.field_73008_k = 10;
                l = this.field_70170_p.func_72957_l(i, j, k);
                this.field_70170_p.field_73008_k = i1;
            }

            return l <= this.field_70146_Z.nextInt(8);
        }
    }

    public boolean func_70601_bi() {
        return this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL;
    }

    public void onKillCommand() {
        if (this.getTitanStatus() != EnumTitanStatus.GOD) {
            this.func_85030_a(this.func_70673_aS(), this.func_70599_aP(), this.func_70647_i());
            this.func_70106_y();
        }

    }

    protected boolean func_146066_aG() {
        return false;
    }

    public StatBase getAchievement() {
        return null;
    }

    protected void func_70609_aI() {
    }

    protected void onTitanDeathUpdate() {
        if (this instanceof EntitySnowGolemTitan || this instanceof EntitySlimeTitan) {
            ++this.field_70725_aQ;
            this.destroyBlocksInAABB(this.field_70121_D);
            if (this.field_70725_aQ == 20) {
                this.func_70106_y();

                for(int i = 0; i < 20; ++i) {
                    double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                    double d0 = this.field_70146_Z.nextGaussian() * 0.02;
                    double d1 = this.field_70146_Z.nextGaussian() * 0.02;
                    this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, this.field_70163_u + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, d2, d0, d1);
                }
            }
        }

        this.field_70180_af.func_75692_b(6, MathHelper.func_76131_a(this.field_70180_af.func_111145_d(5), 0.0F, this.func_110138_aP()));
        if (this.field_70180_af.func_111145_d(5) <= 0.0F) {
            ++this.deathTicks;
        } else {
            this.deathTicks = 0;
        }

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

        this.field_70159_w *= (double)0.0F;
        this.field_70179_y *= (double)0.0F;
        if (!(this instanceof EntitySnowGolemTitan) && !(this instanceof EntitySlimeTitan)) {
            this.field_70761_aq = this.field_70177_z = this.field_70759_as += 10.0F;
        }

        this.field_70125_A = 0.0F + (float)this.getInvulTime() / 4.8F + (0.01F + 0.01F * MathHelper.func_76134_b((float)this.field_70173_aa * 0.25F)) * (float)Math.PI;
        this.func_70624_b((EntityLivingBase)null);
        this.func_70057_ab();
        this.func_70656_aK();
        if (this.deathTicks > 200 && !this.field_70170_p.field_72995_K) {
            this.setInvulTime(this.getInvulTime() + 10);
        }

        if (this.getInvulTime() >= this.getThreashHold()) {
            this.func_70106_y();
        }

    }

    public boolean func_85032_ar() {
        return this.getInvulTime() >= 1 || this.getWaiting() || this.animID == 13 || this.deathTicks > 0 || this instanceof EntityWitherzilla && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid) && this.getExtraPower() > 5 || super.func_85032_ar();
    }

    protected boolean teleportEntityRandomly(EntityLivingBase entity) {
        double d0 = this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * ((double)72.0F + (double)this.field_70130_N);
        double d1 = this.field_70163_u - (double)this.field_70131_O + (double)(this.field_70131_O * 2.0F);
        double d2 = this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * ((double)72.0F + (double)this.field_70130_N);
        return this.teleportEntityTo(entity, d0, d1, d2);
    }

    protected boolean teleportEntityTo(EntityLivingBase entity, double p_70825_1_, double p_70825_3_, double p_70825_5_) {
        EnderTeleportEvent event = new EnderTeleportEvent(entity, p_70825_1_, p_70825_3_, p_70825_5_, 0.0F);
        if (MinecraftForge.EVENT_BUS.post(event)) {
            return false;
        } else {
            double d3 = this.field_70165_t;
            double d4 = this.field_70163_u;
            double d5 = this.field_70161_v;
            entity.field_70165_t = event.targetX;
            entity.field_70163_u = event.targetY;
            entity.field_70161_v = event.targetZ;
            boolean flag = false;
            int i = MathHelper.func_76128_c(entity.field_70165_t);
            int j = MathHelper.func_76128_c(entity.field_70163_u);
            int k = MathHelper.func_76128_c(entity.field_70161_v);
            if (this.field_70170_p.func_72899_e(i, j, k)) {
                boolean flag1 = false;

                while(!flag1 && j > 0) {
                    Block block = this.field_70170_p.func_147439_a(i, j - 1, k);
                    if (block.func_149688_o().func_76220_a()) {
                        flag1 = true;
                    } else {
                        --entity.field_70163_u;
                        --j;
                    }
                }

                if (flag1) {
                    entity.func_70012_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, this.field_70177_z, this.field_70125_A);
                    if (this.field_70170_p.func_72945_a(entity, entity.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(entity.field_70121_D)) {
                        flag = true;
                    }
                }
            }

            if (!flag) {
                entity.func_70012_b(d3, d4, d5, this.field_70177_z, this.field_70125_A);
                return false;
            } else {
                return true;
            }
        }
    }

    public void retractMinionNumFromType(EnumMinionType minionType) {
        if (minionType == EnumMinionType.SPECIAL) {
            --this.numSpecialMinions;
        } else if (minionType == EnumMinionType.PRIEST) {
            --this.numPriests;
        } else if (minionType == EnumMinionType.ZEALOT) {
            --this.numZealots;
        } else if (minionType == EnumMinionType.BISHOP) {
            --this.numBishop;
        } else if (minionType == EnumMinionType.TEMPLAR) {
            --this.numTemplar;
        } else if (minionType == EnumMinionType.LOYALIST) {
            --this.numMinions;
        }

    }
}
