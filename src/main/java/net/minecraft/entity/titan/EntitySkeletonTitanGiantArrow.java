//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySkeletonTitanGiantArrow extends Entity {
    public EntityLivingBase shootingEntity;
    public double accelerationX;
    public double accelerationY;
    public double accelerationZ;

    @SideOnly(Side.CLIENT)
    public boolean func_70112_a(double p_70112_1_) {
        double d1 = this.field_70121_D.func_72320_b() * (double)8.0F;
        d1 *= (double)64.0F;
        return p_70112_1_ < d1 * d1;
    }

    protected void func_70088_a() {
    }

    public EntitySkeletonTitanGiantArrow(World worldIn) {
        super(worldIn);
        this.func_70105_a(4.0F, 4.0F);
    }

    public EntitySkeletonTitanGiantArrow(World p_i1761_1_, EntityLivingBase p_i1761_2_, double p_i1761_3_, double p_i1761_5_, double p_i1761_7_) {
        super(p_i1761_1_);
        this.shootingEntity = p_i1761_2_;
        this.func_70012_b(p_i1761_2_.field_70165_t, p_i1761_2_.field_70163_u, p_i1761_2_.field_70161_v, p_i1761_2_.field_70177_z, p_i1761_2_.field_70125_A);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70129_M = 0.0F;
        this.field_70159_w = this.field_70181_x = this.field_70179_y = (double)0.0F;
        p_i1761_3_ += this.field_70146_Z.nextGaussian() * 0.4;
        p_i1761_5_ += this.field_70146_Z.nextGaussian() * 0.4;
        p_i1761_7_ += this.field_70146_Z.nextGaussian() * 0.4;
        double d3 = (double)MathHelper.func_76133_a(p_i1761_3_ * p_i1761_3_ + p_i1761_5_ * p_i1761_5_ + p_i1761_7_ * p_i1761_7_);
        this.accelerationX = p_i1761_3_ / d3 * 0.1;
        this.accelerationY = p_i1761_5_ / d3 * 0.1;
        this.accelerationZ = p_i1761_7_ / d3 * 0.1;
        this.func_70105_a(4.0F, 4.0F);
    }

    public EntitySkeletonTitanGiantArrow(World p_i1760_1_, double p_i1760_2_, double p_i1760_4_, double p_i1760_6_, double p_i1760_8_, double p_i1760_10_, double p_i1760_12_) {
        super(p_i1760_1_);
        this.func_70105_a(4.0F, 4.0F);
        this.func_70012_b(p_i1760_2_, p_i1760_4_, p_i1760_6_, this.field_70177_z, this.field_70125_A);
        this.func_70107_b(p_i1760_2_, p_i1760_4_, p_i1760_6_);
        double d6 = (double)MathHelper.func_76133_a(p_i1760_8_ * p_i1760_8_ + p_i1760_10_ * p_i1760_10_ + p_i1760_12_ * p_i1760_12_);
        this.accelerationX = p_i1760_8_ / d6 * 0.1;
        this.accelerationY = p_i1760_10_ / d6 * 0.1;
        this.accelerationZ = p_i1760_12_ / d6 * 0.1;
    }

    public void onImpact(MovingObjectPosition movingObject) {
        if (!this.field_70170_p.field_72995_K) {
            float f;
            if (TheTitans.NightmareMode) {
                f = 6000.0F;
            } else {
                f = 2000.0F;
            }

            if (movingObject.field_72308_g != null && this.shootingEntity != null && this.shootingEntity instanceof EntityLiving && movingObject.field_72308_g instanceof EntityLivingBase && ((EntityLiving)this.shootingEntity).func_70686_a(movingObject.field_72308_g.getClass())) {
                if (this.shootingEntity instanceof EntityTitan) {
                    ((EntityTitan)this.shootingEntity).attackChoosenEntity(movingObject.field_72308_g, f, 10);
                } else {
                    movingObject.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, this.shootingEntity), f);
                }

                this.func_85030_a("thetitans:slashFlesh", 2.0F, 1.5F);
                if (movingObject.field_72308_g instanceof EntityTitan || movingObject.field_72308_g instanceof EntityTitanPart) {
                    if (this.shootingEntity instanceof EntityTitan) {
                        ((EntityTitan)this.shootingEntity).attackChoosenEntity(movingObject.field_72308_g, f, 10);
                        ((EntityTitan)this.shootingEntity).attackChoosenEntity(movingObject.field_72308_g, f, 10);
                        ((EntityTitan)this.shootingEntity).attackChoosenEntity(movingObject.field_72308_g, f, 10);
                        ((EntityTitan)this.shootingEntity).destroyBlocksInAABB(this.field_70121_D.func_72314_b((double)5.0F, (double)5.0F, (double)5.0F));
                    }

                    this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 10.0F, false);
                    this.func_70106_y();
                }
            }
        }

    }

    public void func_70014_b(NBTTagCompound p_70014_1_) {
        p_70014_1_.func_74782_a("direction", this.func_70087_a(new double[]{this.field_70159_w, this.field_70181_x, this.field_70179_y}));
    }

    public void func_70037_a(NBTTagCompound p_70037_1_) {
        if (p_70037_1_.func_150297_b("direction", 9)) {
            NBTTagList nbttaglist = p_70037_1_.func_150295_c("direction", 6);
            this.field_70159_w = nbttaglist.func_150309_d(0);
            this.field_70181_x = nbttaglist.func_150309_d(1);
            this.field_70179_y = nbttaglist.func_150309_d(2);
        } else {
            this.func_70106_y();
        }

    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        return false;
    }

    protected float getMotionFactor() {
        return 0.99F;
    }

    public boolean func_70027_ad() {
        return false;
    }

    public void func_70071_h_() {
        this.func_70030_z();
        if (!this.field_70170_p.field_72995_K && (this.field_70163_u <= (double)-100.0F || this.field_70173_aa > 300 || this.shootingEntity == null || this.shootingEntity != null && !this.shootingEntity.func_70089_S())) {
            this.func_70106_y();
        }

        if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
            float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * (double)180.0F / Math.PI);
            this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, (double)f) * (double)180.0F / Math.PI);
        }

        this.field_70165_t += this.field_70159_w;
        this.field_70163_u += this.field_70181_x;
        this.field_70161_v += this.field_70179_y;
        float f1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
        this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * (double)180.0F / Math.PI);

        for(this.field_70125_A = (float)(Math.atan2(this.field_70181_x, (double)f1) * (double)180.0F / Math.PI); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {
        }

        while(this.field_70125_A - this.field_70127_C >= 180.0F) {
            this.field_70127_C += 360.0F;
        }

        while(this.field_70177_z - this.field_70126_B < -180.0F) {
            this.field_70126_B -= 360.0F;
        }

        while(this.field_70177_z - this.field_70126_B >= 180.0F) {
            this.field_70126_B += 360.0F;
        }

        this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
        this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
        float f2 = this.getMotionFactor();
        this.field_70159_w += this.accelerationX * (double)5.0F;
        this.field_70181_x += this.accelerationY * (double)5.0F;
        this.field_70179_y += this.accelerationZ * (double)5.0F;
        this.field_70159_w *= (double)f2;
        this.field_70181_x *= (double)f2;
        this.field_70179_y *= (double)f2;
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        if (this.shootingEntity != null && this.shootingEntity instanceof EntityTitan) {
            ((EntityTitan)this.shootingEntity).destroyBlocksInAABB(this.field_70121_D);
        }

        if (this.shootingEntity != null && this.shootingEntity instanceof EntityEnderColossus) {
            this.func_82142_c(true);
        }

        this.field_70145_X = true;
        if (this.shootingEntity != null && this.shootingEntity instanceof EntityTitan) {
            ((EntityTitan)this.shootingEntity).destroyBlocksInAABB(this.field_70121_D);
        }

        ArrayList list = Lists.newArrayList(this.field_70170_p.field_72996_f);
        if (list != null && !list.isEmpty()) {
            for(int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                if (this.func_70089_S() && this.func_70068_e(entity) <= (double)(this.field_70130_N * this.field_70130_N + entity.field_70130_N * entity.field_70130_N) + (double)9.0F) {
                    this.onImpact(new MovingObjectPosition(entity));
                }
            }
        }

    }
}
