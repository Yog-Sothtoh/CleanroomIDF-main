//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityIceBall extends EntitySnowball {
    public EntityIceBall(World par1World) {
        super(par1World);
    }

    public EntityIceBall(World par1World, EntityLivingBase par3EntityPlayer) {
        super(par1World, par3EntityPlayer);
    }

    public EntityIceBall(World par1World, EntityLivingBase par2EntityLiving, int par3) {
        super(par1World, par2EntityLiving);
    }

    public EntityIceBall(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    protected void func_70184_a(MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.field_72308_g != null && this.func_85052_h() != null) {
            if (!((EntityLiving)this.func_85052_h()).func_70686_a(par1MovingObjectPosition.field_72308_g.getClass())) {
                this.func_70106_y();
                return;
            }

            par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, this.func_85052_h()), 50.0F);
            par1MovingObjectPosition.field_72308_g.func_70097_a(DamageSource.func_76358_a(this.func_85052_h()), 50.0F);
            ++par1MovingObjectPosition.field_72308_g.field_70181_x;
        }

        this.func_85030_a("random.explode", 0.5F, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.5F);
        if (!this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_72876_a((Entity)(this.func_85052_h() != null ? this.func_85052_h() : this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 3.0F, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));

            for(int i = 0; i < 5; ++i) {
                int x = this.field_70170_p.field_73012_v.nextInt(3);
                if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                    x = -x;
                }

                int y = this.field_70170_p.field_73012_v.nextInt(3);
                if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                    y = -y;
                }

                int z = this.field_70170_p.field_73012_v.nextInt(3);
                if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                    z = -z;
                }

                x = (int)((double)x + par1MovingObjectPosition.field_72307_f.field_72450_a);
                y = (int)((double)y + par1MovingObjectPosition.field_72307_f.field_72448_b);
                z = (int)((double)z + par1MovingObjectPosition.field_72307_f.field_72449_c);
                if (!this.field_70170_p.func_147439_a(x, y, z).func_149662_c()) {
                    this.field_70170_p.func_147449_b(x, y, z, Blocks.field_150432_aD);
                }
            }
        }

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
