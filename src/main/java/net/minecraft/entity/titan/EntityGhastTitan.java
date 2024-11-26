//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.ai.EntityAITitanLookIdle;
import net.minecraft.entity.titanminion.EntityGhastMinion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGhastTitan extends EntityTitan {
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    private int explosionStrength = 5;

    public EntityGhastTitan(World worldIn) {
        super(worldIn);
        this.shouldParticlesBeUpward = true;
        this.field_70145_X = true;
        this.func_70105_a(110.0F, 110.0F);
        this.field_70728_aV = 750000;
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        this.field_70714_bg.func_85156_a(new EntityAITitanLookIdle(this));
    }

    protected void applyEntityAI() {
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.GhastTitanSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

    }

    public float func_70047_e() {
        return 60.0F;
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

    @SideOnly(Side.CLIENT)
    public boolean func_110182_bF() {
        return this.field_70180_af.func_75683_a(16) != 0;
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != EntityGhastMinion.class && p_70686_1_ != EntityGhastTitan.class && p_70686_1_ != EntityTitanFireball.class;
    }

    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(250) == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && super.func_70601_bi();
    }

    public int getMinionSpawnRate() {
        return TheTitans.GhastTitanMinionSpawnrate;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, new Byte((byte)0));
    }

    public int getParticleCount() {
        return 100;
    }

    public String getParticles() {
        return "largesmoke";
    }

    public int getRegenTime() {
        return 5;
    }

    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.GREATER;
    }

    protected String func_70639_aQ() {
        return "thetitans:titanGhastLiving";
    }

    protected String func_70621_aR() {
        return "thetitans:titanGhastGrunt";
    }

    protected String func_70673_aS() {
        return "thetitans:titanGhastDeath";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
    }

    @SideOnly(Side.CLIENT)
    public int func_70070_b(float p_70070_1_) {
        return 15728880;
    }

    public float func_70013_c(float p_70013_1_) {
        return 1.0F;
    }

    public double getSpeed() {
        return (double)0.5F + (double)this.getExtraPower() * 0.001;
    }

    protected void func_70069_a(float p_70069_1_) {
    }

    protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {
    }

    public void func_70612_e(float p_70612_1_, float p_70612_2_) {
        this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        this.field_70159_w *= (double)0.91F;
        this.field_70181_x *= (double)0.91F;
        this.field_70179_y *= (double)0.91F;
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

    public void func_70636_d() {
        this.func_70105_a(110.0F, 110.0F);

        for(int i = 0; i < 90; ++i) {
            double d0 = this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 90.0F - 45.0F);
            double d1 = this.field_70163_u + (double)(this.field_70146_Z.nextFloat() * 30.0F);
            double d2 = this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 90.0F - 45.0F);
            if (!this.field_70170_p.field_72995_K && this.field_70170_p.func_147439_a((int)d0, (int)d1 + (int)this.func_70047_e(), (int)d2).func_149688_o() != Material.field_151579_a) {
                this.func_70107_b(this.field_70165_t, this.field_70163_u + 0.1, this.field_70161_v);
            }
        }

        EntityPlayer entity = this.field_70170_p.func_72890_a(this, (double)-1.0F);
        if (entity instanceof EntityPlayer && entity != null && entity == this.func_70638_az() && this.func_70638_az() != null) {
            entity.func_70015_d(50);
            if (this.field_70146_Z.nextInt(200) == 0 && this.func_70638_az() != null && this.func_110143_aJ() <= this.func_110138_aP() / 100.0F) {
                entity.func_70097_a(DamageSourceExtra.field_76370_b.func_151518_m().func_76359_i(), Float.MAX_VALUE);
            }

            if (entity.func_110139_bj() <= 0.0F && this.field_70173_aa % 10 == 0) {
                entity.func_70097_a(DamageSourceExtra.field_76370_b.func_151518_m().func_76359_i(), 12.0F);
                entity.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 400, 9));
                if (entity.func_110143_aJ() <= 5.0F) {
                    entity.func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 400, 1));
                }
            } else if (entity.func_110139_bj() >= 0.0F && this.field_70173_aa % 20 == 0) {
                entity.func_70097_a(DamageSourceExtra.field_76370_b.func_151518_m().func_76359_i(), 12.0F);
            }
        }

        if (TheTitans.NightmareMode) {
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)9000.0F + (double)(this.getExtraPower() * 1800));
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)400000.0F + (double)(this.getExtraPower() * '\uea60'));
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)3000.0F + (double)(this.getExtraPower() * 600));
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)200000.0F + (double)(this.getExtraPower() * 30000));
        }

        this.func_94058_c(StatCollector.func_74838_a("entity.GhastTitan.name"));
        if (this.numMinions < this.getMinionCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            EntityGhastMinion entitychicken = new EntityGhastMinion(this.field_70170_p);
            entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            this.teleportEntityRandomly(entitychicken);
            entitychicken.setMinionType(0);
            this.field_70170_p.func_72838_d(entitychicken);
            ++this.numMinions;
        }

        if (this.numPriests < this.getPriestCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            EntityGhastMinion entitychicken = new EntityGhastMinion(this.field_70170_p);
            entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            this.teleportEntityRandomly(entitychicken);
            entitychicken.setMinionType(1);
            this.field_70170_p.func_72838_d(entitychicken);
            ++this.numPriests;
        }

        if (this.numZealots < this.getZealotCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            EntityGhastMinion entitychicken = new EntityGhastMinion(this.field_70170_p);
            entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            this.teleportEntityRandomly(entitychicken);
            entitychicken.setMinionType(2);
            this.field_70170_p.func_72838_d(entitychicken);
            ++this.numZealots;
        }

        if (this.numBishop < this.getBishopCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            EntityGhastMinion entitychicken = new EntityGhastMinion(this.field_70170_p);
            entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            this.teleportEntityRandomly(entitychicken);
            entitychicken.setMinionType(3);
            this.field_70170_p.func_72838_d(entitychicken);
            ++this.numTemplar;
        }

        if (this.numTemplar < this.getTemplarCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            EntityGhastMinion entitychicken = new EntityGhastMinion(this.field_70170_p);
            entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            this.teleportEntityRandomly(entitychicken);
            entitychicken.setMinionType(4);
            this.field_70170_p.func_72838_d(entitychicken);
            ++this.numTemplar;
        }

        if (this.field_70170_p.field_72995_K) {
            for(int i1 = 0; i1 < this.getParticleCount(); ++i1) {
                this.field_70170_p.func_72869_a(this.getParticles(), this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)96.0F, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)96.0F, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)96.0F, (double)0.0F, (double)0.5F, (double)0.0F);
            }
        }

        super.func_70636_d();
    }

    protected void func_70619_bc() {
        this.prevAttackCounter = this.attackCounter;
        double d0 = this.waypointX - this.field_70165_t;
        double d1 = this.waypointY - this.field_70163_u;
        double d2 = this.waypointZ - this.field_70161_v;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;
        if (d3 < (double)36.0F || d3 > (double)40000.0F) {
            if (this.func_70638_az() != null) {
                this.waypointX = this.func_70638_az().field_70165_t + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)96.0F;
                this.waypointY = (double)160.0F + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)32.0F;
                this.waypointZ = this.func_70638_az().field_70161_v + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)96.0F;
            } else {
                EntityPlayer player = this.field_70170_p.func_72890_a(this, (double)512.0F);
                if (player != null) {
                    this.waypointX = player.field_70165_t + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)96.0F;
                    this.waypointY = (double)160.0F + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)32.0F;
                    this.waypointZ = player.field_70161_v + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)96.0F;
                } else {
                    this.waypointX = this.field_70165_t + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)96.0F;
                    this.waypointY = (double)160.0F + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)32.0F;
                    this.waypointZ = this.field_70161_v + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F) * (double)96.0F;
                }
            }
        }

        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.field_70146_Z.nextInt(5) + 2;
            d3 = (double)MathHelper.func_76133_a(d3);
            this.field_70159_w += d0 / d3 * 0.3;
            this.field_70181_x += d1 / d3 * 0.3;
            this.field_70179_y += d2 / d3 * 0.3;
        }

        double d4 = (double)1024.0F;
        this.field_70761_aq = this.field_70177_z = this.field_70759_as;
        if (this.func_70638_az() != null && this.func_70638_az().func_70068_e(this) < d4 * d4) {
            this.func_70671_ap().func_75651_a(this.func_70638_az(), 180.0F, 180.0F);
            double d8 = (double)50.0F;
            Vec3 vec3 = this.func_70676_i(1.0F);
            double px = this.field_70165_t + vec3.field_72450_a * d8;
            double py = this.field_70163_u + vec3.field_72448_b * d8 + (double)10.0F;
            double pz = this.field_70161_v + vec3.field_72449_c * d8;
            double d11 = this.func_70638_az().field_70165_t - px;
            double d21 = this.func_70638_az().field_70163_u - py;
            double d31 = this.func_70638_az().field_70161_v - pz;
            if (this.func_70685_l(this.func_70638_az())) {
                if (this.attackCounter == 10) {
                    this.func_85030_a("thetitans:titanGhastCharge", Float.MAX_VALUE, this.func_70647_i());
                }

                ++this.attackCounter;
                if (this.attackCounter >= 50) {
                    this.func_70625_a(this.func_70638_az(), 180.0F, 180.0F);
                    if (this.func_70638_az() instanceof EntityTitan || this.func_70638_az().field_70131_O >= 6.0F) {
                        this.attackChoosenEntity(this.func_70638_az(), (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e(), this.getKnockbackAmount());
                    }

                    this.func_85030_a("thetitans:titanGhastFireball", Float.MAX_VALUE, 1.0F);
                    EntityTitanFireball entitysmallfireball = new EntityTitanFireball(this.field_70170_p, this, d11 + this.func_70681_au().nextGaussian() * (double)16.0F, d21, d31 + this.func_70681_au().nextGaussian() * (double)16.0F);
                    entitysmallfireball.field_70165_t = px;
                    entitysmallfireball.field_70163_u = py;
                    entitysmallfireball.field_70161_v = pz;
                    this.field_70170_p.func_72838_d(entitysmallfireball);
                    if (this.attackCounter == 100) {
                        this.attackCounter = -80;
                    }
                }
            } else if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        } else {
            if (this.func_70638_az() == null) {
                this.field_70761_aq = this.field_70177_z = this.field_70759_as = -((float)Math.atan2(this.field_70159_w, this.field_70179_y)) * 180.0F / (float)Math.PI;
            }

            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }

        if (!this.field_70170_p.field_72995_K) {
            byte b1 = this.field_70180_af.func_75683_a(16);
            byte b0 = (byte)(this.attackCounter > 20 ? 1 : 0);
            if (b1 != b0) {
                this.field_70180_af.func_75692_b(16, b0);
            }
        }

        super.func_70619_bc();
    }

    public int func_70646_bf() {
        return 180;
    }

    protected Item func_146068_u() {
        return Items.field_151072_bj;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            for(int x = 0; x < 80; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                entitylargefireball.func_70107_b(this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                ++entitylargefireball.field_70181_x;
                entitylargefireball.setXPCount(26000);
                this.field_70170_p.func_72838_d(entitylargefireball);
            }

            for(int l = 0; l < 512 + this.field_70146_Z.nextInt(512 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151016_H));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 512 + this.field_70146_Z.nextInt(512 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151073_bk));
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

            for(int l = 0; l < 64; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150382_bo));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }
        }

    }

    protected void func_82164_bB() {
        this.func_145779_a(Items.field_151067_bt, 64);
    }

    public boolean func_70845_n() {
        return (this.field_70180_af.func_75683_a(16) & 1) != 0;
    }

    public void func_70844_e(boolean p_70844_1_) {
        byte b0 = this.field_70180_af.func_75683_a(16);
        if (p_70844_1_) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.field_70180_af.func_75692_b(16, b0);
    }

    protected boolean isValidLightLevel() {
        return true;
    }

    protected void func_82167_n(Entity p_82167_1_) {
        if (!(p_82167_1_ instanceof EntitySmallFireball) || !(p_82167_1_ instanceof EntityLargeFireball)) {
            p_82167_1_.func_70108_f(this);
        }

    }

    public StatBase getAchievement() {
        return TitansAchievments.ghasttitan;
    }

    public boolean func_70067_L() {
        return true;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (this.func_85032_ar()) {
            return false;
        } else if (!(source.func_76346_g() instanceof EntityGhastMinion) && !(source.func_76346_g() instanceof EntityGhastTitan)) {
            if (source.func_76347_k()) {
                this.func_70691_i(amount);
                return false;
            } else {
                return super.func_70097_a(source, amount);
            }
        } else {
            return false;
        }
    }

    protected void inactDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            this.func_85030_a("mob.ghast.death", this.func_70599_aP(), this.func_70647_i());
            if (this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
                this.func_70628_a(true, 0);
                this.func_82160_b(true, 0);
                this.func_70600_l(1);
            }

            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.field_70170_p);
            entitytitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitytitan);
            entitytitan.setVesselHunting(false);
            entitytitan.setSpiritType(11);
        }

    }
}
