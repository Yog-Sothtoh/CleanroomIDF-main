//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityThunderboltShot extends EntitySnowball {
    public EntityThunderboltShot(World par1World) {
        super(par1World);
    }

    public EntityThunderboltShot(World par1World, EntityLivingBase par3EntityPlayer) {
        super(par1World, par3EntityPlayer);
    }

    public EntityThunderboltShot(World par1World, EntityLivingBase par2EntityLiving, int par3) {
        super(par1World, par2EntityLiving);
    }

    public EntityThunderboltShot(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    protected void func_70184_a(MovingObjectPosition par1MovingObjectPosition) {
        if (!this.field_70170_p.field_72995_K && par1MovingObjectPosition.field_72308_g != null && this.func_85052_h() != null && par1MovingObjectPosition.field_72308_g != this.func_85052_h()) {
            if (!((EntityLiving)this.func_85052_h()).func_70686_a(par1MovingObjectPosition.field_72308_g.getClass())) {
                this.func_70106_y();
                return;
            }

            par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, this.func_85052_h()), 50.0F);
            par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76358_a(this.func_85052_h()), 50.0F);
            par1MovingObjectPosition.field_72308_g.func_70015_d(15);
            ++par1MovingObjectPosition.field_72308_g.field_70181_x;
        }

        this.func_85030_a("random.explode", 0.5F, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5F);
        if (!this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_72876_a((Entity)(this.func_85052_h() != null ? this.func_85052_h() : this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 3.0F, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
        }

        this.field_70170_p.func_72942_c(new EntityLightningBolt(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)1.0F, this.field_70161_v));
        this.func_70106_y();
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        int mx = 4;

        for(int i = 0; i < mx; ++i) {
            this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70170_p.field_73012_v.nextGaussian() / (double)10.0F, this.field_70170_p.field_73012_v.nextGaussian() / (double)10.0F, this.field_70170_p.field_73012_v.nextGaussian() / (double)10.0F);
        }

    }
}
