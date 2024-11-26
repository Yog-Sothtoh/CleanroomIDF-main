//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntitySnowGolemTitan extends EntityTitan implements IRangedAttackMob {
    public EntitySnowGolemTitan(World worldIn) {
        super(worldIn);
        this.func_70105_a(10.0F, 30.0F);
        this.func_70661_as().func_75491_a(true);
        this.field_70715_bh.func_75776_a(2, new EntityAIHurtByTarget(this, true));
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, IMob.field_82192_a));
        EntityIronGolemTitan.addTitanTargetingTaskToEntity(this);
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.25F);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)60.0F);
    }

    public void onKillCommand() {
        this.func_85030_a(this.func_70673_aS(), this.func_70599_aP(), this.func_70647_i());
        this.func_70106_y();
    }

    public boolean func_70652_k(Entity p_70652_1_) {
        double doub = this.func_70068_e(p_70652_1_);
        return doub < (double)600.0F ? super.func_70652_k(p_70652_1_) : false;
    }

    public int getMinionSpawnRate() {
        return TheTitans.SnowGolemMinionSpawnrate;
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != EntityPlayer.class && p_70686_1_ != EntitySnowman.class && p_70686_1_ != EntitySnowGolemTitan.class;
    }

    public void func_70636_d() {
        if (this.func_70638_az() != null && this.field_70173_aa % 30 == 0) {
            double d0 = this.func_70068_e(this.func_70638_az());
            if (d0 <= this.getMeleeRange()) {
                this.func_71038_i();
                this.func_70671_ap().func_75651_a(this.func_70638_az(), 180.0F, 30.0F);
                this.func_70652_k(this.func_70638_az());
            }
        }

        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)4000.0F);
        this.func_94058_c(StatCollector.func_74838_a("entity.SnowManTitan.name"));
        List list1 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)128.0F, (double)128.0F, (double)128.0F));
        if (list1 != null && !list1.isEmpty() && !this.field_70170_p.field_72995_K) {
            for(int i1 = 0; i1 < list1.size(); ++i1) {
                Entity entity = (Entity)list1.get(i1);
                if (entity != null && entity instanceof EntitySnowman && this.func_70638_az() != null) {
                    if (!this.func_70638_az().func_70685_l(entity)) {
                        ((EntitySnowman)entity).func_70605_aq().func_75642_a(this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, (double)2.0F);
                    }

                    ((EntitySnowman)entity).func_70624_b(this.func_70638_az());
                    ((EntitySnowman)entity).func_70671_ap().func_75651_a(this.func_70638_az(), 40.0F, 40.0F);
                    if (((EntitySnowman)entity).field_70123_F) {
                        ((EntitySnowman)entity).field_70181_x = (double)0.25F;
                    }

                    if ((entity.field_70173_aa + entity.func_145782_y()) % 20 == 0) {
                        ((EntitySnowman)entity).func_82196_d(this.func_70638_az(), 1.0F);
                    }
                }
            }
        }

        if (this.func_70638_az() != null && (this.field_70173_aa + this.func_145782_y()) % 20 == 0 && !this.field_70170_p.field_72995_K) {
            this.func_82196_d(this.func_70638_az(), 0.0F);
        }

        if (this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K) {
            EntitySnowman entitychicken = new EntitySnowman(this.field_70170_p);
            entitychicken.func_70012_b(this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitychicken);
            entitychicken.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)20.0F);
            entitychicken.func_70606_j(20.0F);
            entitychicken.func_94058_c("Reinforced Snow Golem");
        }

        if (!this.field_70170_p.field_72995_K) {
            int i = MathHelper.func_76128_c(this.field_70165_t);
            int j = MathHelper.func_76128_c(this.field_70163_u);
            int k = MathHelper.func_76128_c(this.field_70161_v);
            if (this.func_70026_G() && this.field_70173_aa % 40 == 0) {
                this.func_70097_a(DamageSource.field_76369_e, 1.0F);
            }

            if (this.field_70170_p.func_72807_a(i, k).func_150564_a(i, j, k) > 1.5F) {
                this.func_70097_a(DamageSource.field_76370_b, 1.0F);
            }

            for(int l = 0; l < 1024; ++l) {
                i = MathHelper.func_76128_c(this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N);
                j = MathHelper.func_76128_c(this.field_70163_u);
                k = MathHelper.func_76128_c(this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N);
                if (this.field_70170_p.func_147439_a(i, j, k).func_149688_o() == Material.field_151579_a && this.field_70170_p.func_72807_a(i, k).func_150564_a(i, j, k) < 1.3F && Blocks.field_150431_aC.func_149742_c(this.field_70170_p, i, j, k)) {
                    this.field_70170_p.func_147449_b(i, j, k, Blocks.field_150431_aC);
                }
            }
        }

        super.func_70636_d();
    }

    protected Item func_146068_u() {
        return Items.field_151126_ay;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        this.func_70099_a(new ItemStack(Blocks.field_150428_aP), 12.0F);
        Item item = this.func_146068_u();

        for(int l = 0; l < 256 + this.field_70146_Z.nextInt(256 + p_70628_2_); ++l) {
            this.func_70099_a(new ItemStack(item), 12.0F);
        }

        for(int l = 0; l < 0 + this.field_70146_Z.nextInt(4 + p_70628_2_); ++l) {
            this.func_70099_a(new ItemStack(Items.field_151166_bC), 12.0F);
        }

        for(int l = 0; l < 0 + this.field_70146_Z.nextInt(4 + p_70628_2_); ++l) {
            this.func_70099_a(new ItemStack(Items.field_151045_i), 12.0F);
        }

    }

    protected String func_70621_aR() {
        return "step.snow";
    }

    protected String func_70673_aS() {
        return "dig.snow";
    }

    public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
        if (this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K) {
            EntitySnowman entitychicken = new EntitySnowman(this.field_70170_p);
            entitychicken.func_70012_b(this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitychicken);
            entitychicken.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)20.0F);
            entitychicken.func_70606_j(20.0F);
            entitychicken.func_94058_c("Reinforced Snow Golem");
        }

        this.func_70625_a(p_82196_1_, 180.0F, 30.0F);
        double doub = (double)this.func_70032_d(p_82196_1_);
        double d8 = (double)6.0F;
        Vec3 vec3 = this.func_70676_i(1.0F);
        double d1 = p_82196_1_.field_70165_t - (this.field_70165_t + vec3.field_72450_a * d8);
        double d2 = p_82196_1_.field_70163_u + (double)p_82196_1_.field_70131_O * 0.33 - (this.field_70163_u + (double)20.0F + vec3.field_72448_b * d8);
        double d3 = p_82196_1_.field_70161_v - (this.field_70161_v + vec3.field_72449_c * d8);
        EntityTitanFireball entitylargefireball = new EntityTitanFireball(this.field_70170_p, this, d1, d2, d3, 6);
        entitylargefireball.field_70165_t = this.field_70165_t + vec3.field_72450_a * d8;
        entitylargefireball.field_70163_u = this.field_70163_u + (double)20.0F + vec3.field_72448_b * d8;
        entitylargefireball.field_70161_v = this.field_70161_v + vec3.field_72449_c * d8;
        this.field_70170_p.func_72838_d(entitylargefireball);
        entitylargefireball.setFireballID(6);
        this.func_85030_a("random.bow", 10.0F, 0.5F);
        this.func_85030_a("random.bow", 10.0F, 0.5F);
    }

    public int func_70658_aO() {
        return 15;
    }

    public float func_70047_e() {
        return 27.2F;
    }

    protected void func_70619_bc() {
        super.func_70619_bc();
        List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D);
        if (list11 != null && !list11.isEmpty()) {
            for(int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (entity instanceof EntityLivingBase && entity.field_70122_E && !(entity instanceof EntityTitan) && !(entity instanceof EntitySnowman)) {
                    float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                    entity.func_70097_a(DamageSourceExtra.causeSquishingDamage(this), f / 2.0F);
                }
            }
        }

    }
}
