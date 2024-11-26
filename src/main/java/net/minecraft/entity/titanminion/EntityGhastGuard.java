//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titanminion;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityPigZombieTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.AchievementList;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGhastGuard extends EntityCreature implements IMob, IMinion {
    public EntityLiving master;
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    private int explosionStrength = 3;

    public EntityGhastGuard(World worldIn) {
        super(worldIn);
        this.func_110163_bv();
        this.func_70105_a(4.5F, 4.5F);
        this.field_70178_ae = true;
        this.field_70728_aV = 20;
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.PigZombieTitanSorter));
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

    public EnumMinionType getMinionType() {
        return EnumMinionType.SPECIAL;
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != EntityPigZombieMinion.class && p_70686_1_ != EntityGhastGuard.class && (p_70686_1_ != EntityPigZombieTitan.class || p_70686_1_ == EntityZombieTitan.class);
    }

    protected void func_70623_bb() {
        this.field_70708_bq = 0;
    }

    protected void func_70069_a(float p_70069_1_) {
    }

    protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {
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
        this.field_70158_ak = true;
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
            this.func_70106_y();
        }

        if (this.func_70638_az() != null) {
            this.func_70671_ap().func_75650_a(this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u + (double)this.func_70638_az().func_70047_e(), this.func_70638_az().field_70161_v, 180.0F, 180.0F);
        }

    }

    protected void func_70619_bc() {
        this.explosionStrength = 3;
        if (this.master != null) {
            if (this.master.func_70638_az() != null) {
                this.func_70624_b(this.master.func_70638_az());
            }
        } else {
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)100.0F, (double)100.0F, (double)100.0F));
            if (list != null && !list.isEmpty()) {
                for(int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity != null && entity instanceof EntityPigZombieTitan) {
                        this.master = (EntityPigZombieTitan)entity;
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
        if (d3 < (double)1.0F || d3 > (double)3600.0F) {
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
                if (this.master != null && this.func_70068_e(this.master) > (double)2304.0F) {
                    this.field_70159_w += d0 / d3 * 0.3;
                    this.field_70181_x += d1 / d3 * 0.3;
                    this.field_70179_y += d2 / d3 * 0.3;
                } else {
                    this.field_70159_w += d0 / d3 * 0.1;
                    this.field_70181_x += d1 / d3 * 0.1;
                    this.field_70179_y += d2 / d3 * 0.1;
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
            double d5 = this.targetedEntity.field_70165_t - (this.field_70165_t + vec3.field_72450_a * d8);
            double d6 = this.targetedEntity.field_70163_u - (this.field_70163_u + vec3.field_72448_b * d8 + (double)1.0F);
            double d7 = this.targetedEntity.field_70161_v - (this.field_70161_v + vec3.field_72449_c * d8);
            this.field_70761_aq = this.field_70177_z = -((float)Math.atan2(d5, d7)) * 180.0F / (float)Math.PI;
            if (this.func_70685_l(this.targetedEntity)) {
                if (this.attackCounter == 10) {
                    this.field_70170_p.func_72889_a((EntityPlayer)null, 1007, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                }

                ++this.attackCounter;
                if (this.attackCounter == 20) {
                    this.field_70170_p.func_72889_a((EntityPlayer)null, 1008, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                    EntityGhastGuardFireball entitylargefireball = new EntityGhastGuardFireball(this.field_70170_p, this, d5, d6, d7);
                    entitylargefireball.field_92057_e = this.explosionStrength;
                    entitylargefireball.field_70165_t = this.field_70165_t + vec3.field_72450_a * d8;
                    entitylargefireball.field_70163_u = this.field_70163_u + vec3.field_72448_b * d8 + (double)1.0F;
                    entitylargefireball.field_70161_v = this.field_70161_v + vec3.field_72449_c * d8;
                    this.field_70170_p.func_72838_d(entitylargefireball);
                    this.attackCounter = -40;
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
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)40.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)1.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a((double)100.0F);
    }

    protected String func_70639_aQ() {
        return "mob.ghast.moan";
    }

    protected String func_70621_aR() {
        return "mob.ghast.scream";
    }

    protected String func_70673_aS() {
        return "mob.ghast.death";
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

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        tagCompound.func_74768_a("ExplosionPower", this.explosionStrength);
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        if (tagCompund.func_150297_b("ExplosionPower", 99)) {
            this.explosionStrength = tagCompund.func_74762_e("ExplosionPower");
        }

    }

    public float func_70047_e() {
        return 3.0F;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (this.func_85032_ar()) {
            return false;
        } else if (!(source.func_76346_g() instanceof EntityPigZombieMinion) && !(source.func_76346_g() instanceof EntityPigZombieTitan) && !(source.func_76346_g() instanceof EntityGhastGuard)) {
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
    }

    class AILookAround extends EntityAIBase {
        private EntityGhastGuard field_179472_a = EntityGhastGuard.this;

        public AILookAround() {
            this.func_75248_a(2);
        }

        public boolean func_75250_a() {
            return true;
        }

        public void func_75246_d() {
            if (this.field_179472_a.func_70638_az() == null) {
                this.field_179472_a.field_70761_aq = this.field_179472_a.field_70177_z = -((float)Math.atan2(this.field_179472_a.field_70159_w, this.field_179472_a.field_70179_y)) * 180.0F / (float)Math.PI;
            } else {
                EntityLivingBase entitylivingbase = this.field_179472_a.func_70638_az();
                double d0 = (double)100.0F;
                if (entitylivingbase.func_70068_e(this.field_179472_a) < d0 * d0) {
                    double d1 = entitylivingbase.field_70165_t - this.field_179472_a.field_70165_t;
                    double d2 = entitylivingbase.field_70161_v - this.field_179472_a.field_70161_v;
                    this.field_179472_a.field_70761_aq = this.field_179472_a.field_70177_z = -((float)Math.atan2(d1, d2)) * 180.0F / (float)Math.PI;
                }
            }

        }
    }
}
