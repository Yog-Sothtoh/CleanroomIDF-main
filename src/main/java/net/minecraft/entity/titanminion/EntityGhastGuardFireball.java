//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titanminion;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGhastGuardFireball extends EntityLargeFireball {
    public EntityGhastGuardFireball(World worldIn) {
        super(worldIn);
    }

    @SideOnly(Side.CLIENT)
    public EntityGhastGuardFireball(World worldIn, double p_i1768_2_, double p_i1768_4_, double p_i1768_6_, double p_i1768_8_, double p_i1768_10_, double p_i1768_12_) {
        super(worldIn, p_i1768_2_, p_i1768_4_, p_i1768_6_, p_i1768_8_, p_i1768_10_, p_i1768_12_);
    }

    public EntityGhastGuardFireball(World worldIn, EntityLivingBase p_i1769_2_, double p_i1769_3_, double p_i1769_5_, double p_i1769_7_) {
        super(worldIn, p_i1769_2_, p_i1769_3_, p_i1769_5_, p_i1769_7_);
    }

    protected void func_70227_a(MovingObjectPosition movingObject) {
        if (!this.field_70170_p.field_72995_K) {
            if (movingObject.field_72308_g != null) {
                if (this.field_70235_a instanceof EntityGhastMinion) {
                    ((EntityGhastMinion)this.field_70235_a).func_70652_k(movingObject.field_72308_g);
                } else {
                    movingObject.field_72308_g.func_70097_a(DamageSource.func_76362_a(this, this.field_70235_a), 17.0F);
                }
            }

            boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
            this.field_70170_p.func_72885_a((Entity)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, (float)this.field_92057_e, flag, flag);
            this.func_70106_y();
        }

    }
}
