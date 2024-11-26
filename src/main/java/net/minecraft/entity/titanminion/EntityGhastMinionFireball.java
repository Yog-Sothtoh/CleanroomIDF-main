//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titanminion;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGhastMinionFireball extends EntityLargeFireball {
    public EntityGhastMinionFireball(World worldIn) {
        super(worldIn);
    }

    @SideOnly(Side.CLIENT)
    public EntityGhastMinionFireball(World worldIn, double p_i1768_2_, double p_i1768_4_, double p_i1768_6_, double p_i1768_8_, double p_i1768_10_, double p_i1768_12_) {
        super(worldIn, p_i1768_2_, p_i1768_4_, p_i1768_6_, p_i1768_8_, p_i1768_10_, p_i1768_12_);
    }

    public EntityGhastMinionFireball(World worldIn, EntityLivingBase p_i1769_2_, double p_i1769_3_, double p_i1769_5_, double p_i1769_7_) {
        super(worldIn, p_i1769_2_, p_i1769_3_, p_i1769_5_, p_i1769_7_);
    }

    public boolean func_70067_L() {
        return false;
    }

    protected void func_70227_a(MovingObjectPosition movingObject) {
        if (!this.field_70170_p.field_72995_K) {
            boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
            if (movingObject.field_72308_g != null) {
                if (this.field_70235_a != null && this.field_70235_a instanceof EntityLiving && ((EntityLiving)this.field_70235_a).func_70686_a(movingObject.field_72308_g.getClass())) {
                    movingObject.field_72308_g.field_70172_ad = 0;
                    ((EntityLiving)this.field_70235_a).func_70652_k(movingObject.field_72308_g);
                    movingObject.field_72308_g.func_70015_d((int)((EntityLiving)this.field_70235_a).func_110148_a(SharedMonsterAttributes.field_111264_e).func_111125_b());
                    this.field_70170_p.func_72885_a(this.field_70235_a, this.field_70165_t, this.field_70163_u, this.field_70161_v, (float)this.field_92057_e, flag, flag);
                    this.func_70106_y();
                }
            } else {
                int i = movingObject.field_72311_b;
                int j = movingObject.field_72312_c;
                int k = movingObject.field_72309_d;
                switch (movingObject.field_72310_e) {
                    case 0:
                        --j;
                        break;
                    case 1:
                        ++j;
                        break;
                    case 2:
                        --k;
                        break;
                    case 3:
                        ++k;
                        break;
                    case 4:
                        --i;
                        break;
                    case 5:
                        ++i;
                }

                if (this.field_70170_p.func_147437_c(i, j, k)) {
                    this.field_70170_p.func_147449_b(i, j, k, Blocks.field_150480_ab);
                    this.field_70170_p.func_72885_a((Entity)(this.field_70235_a != null ? this.field_70235_a : this), (double)i, (double)j, (double)k, (float)this.field_92057_e, flag, flag);
                    this.func_70106_y();
                }
            }
        }

    }
}
