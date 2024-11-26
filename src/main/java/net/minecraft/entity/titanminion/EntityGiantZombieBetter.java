//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titanminion;

import cpw.mods.fml.common.Loader;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.theTitans.TargetingSorter;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import thehippomaster.MutantCreatures.MutantZombie;

public class EntityGiantZombieBetter extends EntityGiantZombie implements IMinion {
    public EntityLiving master;
    private TargetingSorter TargetSorter = null;

    public EntityGiantZombieBetter(World worldIn) {
        super(worldIn);
        this.func_70105_a(3.0F, 12.0F);
        this.field_70138_W = 3.0F;
        this.func_110163_bv();
        this.TargetSorter = new TargetingSorter(this);
        this.field_70178_ae = true;
        this.field_70728_aV = 1000;
        this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.ZombieTitanSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

    }

    public boolean func_70650_aV() {
        return true;
    }

    public int func_70658_aO() {
        return 20;
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
        return p_70686_1_ != EntityZombieMinion.class && p_70686_1_ != EntityGiantZombieBetter.class && p_70686_1_ != EntityZombieTitan.class || Loader.isModLoaded("MutantCreatures") && p_70686_1_ == MutantZombie.class;
    }

    protected void func_70623_bb() {
        this.field_70708_bq = 0;
    }

    public float func_70047_e() {
        return 10.440001F;
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a((double)48.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)4000.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
    }

    private EntityLivingBase doJumpDamage(double X, double Y, double Z, double dist, double damage, int knock) {
        AxisAlignedBB bb = AxisAlignedBB.func_72330_a(X - dist, Y - (double)10.0F, Z - dist, X + dist, Y + (double)10.0F, Z + dist);
        List var5 = this.field_70170_p.func_82733_a(EntityLivingBase.class, bb, ITitan.ZombieTitanSorter);
        Collections.sort(var5, this.TargetSorter);
        Iterator var2 = var5.iterator();
        Entity var3 = null;
        EntityLivingBase var4 = null;

        while(var2.hasNext()) {
            var3 = (Entity)var2.next();
            var4 = (EntityLivingBase)var3;
            if (var4 != null && var4 != this && var4.func_70089_S() && !(var4 instanceof EntityZombieTitan) && !(var4 instanceof EntityGiantZombieBetter) && !(var4 instanceof EntityZombieMinion)) {
                DamageSource var21 = null;
                var21 = DamageSource.func_94539_a((Explosion)null);
                var21.func_94540_d();
                if (this.field_70146_Z.nextInt(2) == 0) {
                    var21.func_76348_h();
                }

                var4.func_70097_a(var21, (float)damage);
                var4.func_70097_a(DamageSource.field_76379_h, (float)damage / 4.0F);
                this.field_70170_p.func_72956_a(var4, "random.explode", 0.85F, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5F);
                if (knock != 0) {
                    double ks = (double)0.75F + this.field_70146_Z.nextDouble() + this.field_70146_Z.nextDouble();
                    double inair = (double)0.75F;
                    float f3 = (float)Math.atan2(var4.field_70161_v - this.field_70161_v, var4.field_70165_t - this.field_70165_t);
                    var4.func_70024_g(Math.cos((double)f3) * ks, inair, Math.sin((double)f3) * ks);
                    if (this.field_70146_Z.nextInt(5) == 0) {
                        var4.field_70172_ad = 0;
                    }
                }
            }
        }

        return null;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70173_aa % 20 == 0 && (!this.field_70170_p.func_72935_r() || this.field_70146_Z.nextInt(5) == 0)) {
            this.func_70691_i(this.field_70170_p.func_72935_r() ? 1.0F + this.field_70146_Z.nextFloat() * 4.0F : 5.0F + this.field_70146_Z.nextFloat() * 15.0F);
        }

        if (this.field_70170_p.field_72995_K) {
            this.func_70105_a(3.0F, 12.0F);
        } else {
            this.func_70105_a(1.5F, 6.0F);
        }

        this.field_70158_ak = true;
        if (this.field_70159_w != (double)0.0F && this.field_70179_y != (double)0.0F && this.field_70146_Z.nextInt(5) == 0) {
            int i = MathHelper.func_76128_c(this.field_70165_t);
            int j = MathHelper.func_76128_c(this.field_70163_u - (double)0.2F - (double)this.field_70129_M);
            int k = MathHelper.func_76128_c(this.field_70161_v);
            Block block = this.field_70170_p.func_147439_a(i, j, k);
            if (block.func_149688_o() != Material.field_151579_a) {
                this.field_70170_p.func_72869_a("blockcrack_" + Block.func_149682_b(block) + "_" + this.field_70170_p.func_72805_g(i, j, k), this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, this.field_70121_D.field_72338_b + 0.1, this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, (double)4.0F * ((double)this.field_70146_Z.nextFloat() - (double)0.5F), (double)0.5F, ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)4.0F);
            }
        }

    }

    public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
        return 0.5F - this.field_70170_p.func_72801_o(p_70783_1_, p_70783_2_, p_70783_3_);
    }

    protected String func_70639_aQ() {
        return "mob.zombie.say";
    }

    protected String func_70621_aR() {
        return "mob.zombie.hurt";
    }

    protected String func_70673_aS() {
        return "mob.zombie.death";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.func_85030_a("mob.irongolem.walk", 2.0F, 0.9F);
        double dx = this.field_70165_t + (double)4.0F * -Math.sin(Math.toRadians((double)this.field_70761_aq));
        double dz = this.field_70161_v - (double)4.0F * -Math.cos(Math.toRadians((double)this.field_70761_aq));
        this.doJumpDamage(dx, this.field_70163_u, dz, (double)6.0F, (double)(10 + this.field_70146_Z.nextInt(90)), 1);
    }

    protected float func_70599_aP() {
        return 7.0F;
    }

    protected Item func_146068_u() {
        return Items.field_151078_bh;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        int j = this.field_70146_Z.nextInt(13) + this.field_70146_Z.nextInt(1 + p_70628_2_);

        for(int k = 0; k < j; ++k) {
            this.func_145779_a(Items.field_151008_G, 1);
        }

        j = this.field_70146_Z.nextInt(13) + this.field_70146_Z.nextInt(2 + p_70628_2_);

        for(int k = 0; k < j; ++k) {
            this.func_145779_a(Items.field_151078_bh, 1);
        }

        if (p_70628_1_ && (this.field_70146_Z.nextInt(5) == 0 || this.field_70146_Z.nextInt(1 + p_70628_2_) > 0)) {
            this.func_145779_a(Items.field_151042_j, 1);
        }

        if (p_70628_1_ && (this.field_70146_Z.nextInt(5) == 0 || this.field_70146_Z.nextInt(1 + p_70628_2_) > 0)) {
            this.func_145779_a(Items.field_151172_bF, 1);
        }

        if (p_70628_1_ && (this.field_70146_Z.nextInt(5) == 0 || this.field_70146_Z.nextInt(1 + p_70628_2_) > 0)) {
            this.func_145779_a(Items.field_151174_bG, 1);
        }

    }

    protected void func_82164_bB() {
        switch (this.field_70146_Z.nextInt(3)) {
            case 0:
                this.func_145779_a(Items.field_151037_a, 1);
                break;
            case 1:
                this.func_145779_a(Items.field_151040_l, 1);
                break;
            case 2:
                this.func_145779_a(Items.field_151028_Y, 1);
        }

    }

    protected float func_70647_i() {
        return this.func_70631_g_() ? (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1F + 1.0F : (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1F + 0.5F;
    }

    public void func_70074_a(EntityLivingBase entityLivingIn) {
        super.func_70074_a(entityLivingIn);
        if ((double)entityLivingIn.func_110138_aP() <= (double)100.0F) {
            entityLivingIn.field_70181_x += (double)15.0F;
        }

        this.func_70691_i(this.field_70170_p.func_72935_r() ? 5.0F + this.field_70146_Z.nextFloat() * 15.0F : 15.0F + this.field_70146_Z.nextFloat() * 30.0F);
        if (entityLivingIn instanceof EntityVillager) {
            EntityZombieMinion entityzombie = new EntityZombieMinion(this.field_70170_p);
            entityzombie.func_82149_j(entityLivingIn);
            this.field_70170_p.func_72900_e(entityLivingIn);
            entityzombie.func_110161_a((IEntityLivingData)null);
            entityzombie.func_82229_g(true);
            if (entityLivingIn.func_70631_g_()) {
                entityzombie.func_82227_f(true);
            }

            this.field_70170_p.func_72838_d(entityzombie);
            this.field_70170_p.func_72889_a((EntityPlayer)null, 1016, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
        }

    }

    public boolean func_70652_k(Entity par1Entity) {
        if (super.func_70652_k(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                if (par1Entity.field_70122_E) {
                    double ks = (double)1.25F;
                    double inair = (double)1.25F;
                    float f3 = (float)Math.atan2(par1Entity.field_70161_v - this.field_70161_v, par1Entity.field_70165_t - this.field_70165_t);
                    par1Entity.func_70024_g(Math.cos((double)f3) * ks, inair, Math.sin((double)f3) * ks);
                } else {
                    double ks = (double)3.0F;
                    double inair = (double)0.25F;
                    int var2 = 6;
                    float f3 = (float)Math.atan2(par1Entity.field_70161_v - this.field_70161_v, par1Entity.field_70165_t - this.field_70165_t);
                    par1Entity.func_70024_g(Math.cos((double)f3) * ks, inair, Math.sin((double)f3) * ks);
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public void func_70024_g(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
        this.field_70159_w += p_70024_1_ * 0.1;
        this.field_70181_x += p_70024_3_ * 0.1;
        this.field_70179_y += p_70024_5_ * 0.1;
    }

    protected void func_70619_bc() {
        if (this.func_70638_az() != null && this.field_70122_E) {
            this.func_70605_aq().func_75642_a(this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, (double)1.0F);
        }

        if (this.field_70123_F && this.master != null) {
            this.field_70181_x = 0.2;
        }

        if (this.field_70181_x < -0.95) {
            double df = (double)1.0F;
            if (this.field_70181_x < (double)-1.5F) {
                df = (double)1.5F;
            }

            this.doJumpDamage(this.field_70165_t, this.field_70163_u, this.field_70161_v, (double)12.0F, (double)100.0F * df, 0);
            this.doJumpDamage(this.field_70165_t, this.field_70163_u, this.field_70161_v, (double)14.0F, (double)50.0F * df, 0);
            this.doJumpDamage(this.field_70165_t, this.field_70163_u, this.field_70161_v, (double)16.0F, (double)25.0F * df, 0);
        }

        if (!this.field_70170_p.field_72995_K && this.func_70638_az() != null && this.field_70173_aa % 30 == 0 && this.field_70170_p.field_73012_v.nextInt(3) == 0) {
            this.field_70761_aq = this.field_70177_z = this.field_70759_as;
            ++this.field_70181_x;
            ++this.field_70163_u;
            double d1 = this.func_70638_az().field_70165_t - this.field_70165_t;
            double d2 = this.func_70638_az().field_70161_v - this.field_70161_v;
            float d = (float)Math.atan2(d2, d1);
            this.func_70625_a(this.func_70638_az(), 10.0F, (float)this.func_70646_bf());
            d1 = Math.sqrt(d1 * d1 + d2 * d2);
            if (this.func_70068_e(this.func_70638_az()) > (double)((10.0F + this.func_70638_az().field_70130_N / 2.0F) * (10.0F + this.func_70638_az().field_70130_N / 2.0F)) + (double)45.0F) {
                this.field_70159_w += d1 * 0.05 * Math.cos((double)d);
                this.field_70179_y += d1 * 0.05 * Math.sin((double)d);
            }
        }

        if (this.func_70638_az() != null) {
            this.func_70671_ap().func_75651_a(this.func_70638_az(), 10.0F, 40.0F);
        }

        if (this.func_70638_az() != null && this.field_70173_aa % 20 == 0 && this.func_70068_e(this.func_70638_az()) <= (double)((14.0F + this.func_70638_az().field_70130_N / 2.0F) * (14.0F + this.func_70638_az().field_70130_N / 2.0F))) {
            this.func_70652_k(this.func_70638_az());
        }

        if (this.master != null) {
            if (this.master.func_70638_az() != null) {
                this.func_70624_b(this.master.func_70638_az());
            } else if (this.func_70068_e(this.master) > (double)5000.0F) {
                this.func_70605_aq().func_75642_a(this.master.field_70165_t, this.master.field_70163_u, this.master.field_70161_v, (double)2.0F);
            }
        } else {
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)100.0F, (double)100.0F, (double)100.0F));
            if (list != null && !list.isEmpty()) {
                for(int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity != null && entity instanceof EntityZombieTitan) {
                        this.master = (EntityZombieTitan)entity;
                    }
                }
            }
        }

        super.func_70619_bc();
    }

    protected void func_70069_a(float par1) {
    }

    protected void func_70064_a(double par1, boolean par3) {
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (this.func_85032_ar()) {
            return false;
        } else if (!(source.func_76346_g() instanceof EntityZombieMinion) && !(source.func_76346_g() instanceof EntityZombieTitan) && !(source.func_76346_g() instanceof EntityGiantZombieBetter)) {
            Entity entity = source.func_76346_g();
            if (source.func_76346_g() instanceof EntityLivingBase) {
                this.func_70624_b((EntityLivingBase)entity);
                this.func_70604_c((EntityLivingBase)entity);
                if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73012_v.nextInt(4) == 0) {
                    this.field_70761_aq = this.field_70177_z = this.field_70759_as;
                    ++this.field_70181_x;
                    ++this.field_70163_u;
                    double d1 = ((EntityLivingBase)entity).field_70165_t - this.field_70165_t;
                    double d2 = ((EntityLivingBase)entity).field_70161_v - this.field_70161_v;
                    float d = (float)Math.atan2(d2, d1);
                    this.func_70625_a((EntityLivingBase)entity, 10.0F, (float)this.func_70646_bf());
                    d1 = Math.sqrt(d1 * d1 + d2 * d2);
                    if (this.func_70068_e((EntityLivingBase)entity) > (double)((10.0F + ((EntityLivingBase)entity).field_70130_N / 2.0F) * (10.0F + ((EntityLivingBase)entity).field_70130_N / 2.0F)) + (double)45.0F) {
                        this.field_70159_w += d1 * 0.1 * Math.cos((double)d);
                        this.field_70179_y += d1 * 0.1 * Math.sin((double)d);
                    }
                }
            }

            return super.func_70097_a(source, amount);
        } else {
            return false;
        }
    }
}
