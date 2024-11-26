//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titanminion;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBlazeMinionFireball extends EntitySmallFireball {
    private static final String __OBFID = "CL_00001721";

    public EntityBlazeMinionFireball(World p_i1770_1_) {
        super(p_i1770_1_);
    }

    public EntityBlazeMinionFireball(World p_i1771_1_, EntityLivingBase p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_) {
        super(p_i1771_1_, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
    }

    public EntityBlazeMinionFireball(World p_i1772_1_, double p_i1772_2_, double p_i1772_4_, double p_i1772_6_, double p_i1772_8_, double p_i1772_10_, double p_i1772_12_) {
        super(p_i1772_1_, p_i1772_2_, p_i1772_4_, p_i1772_6_, p_i1772_8_, p_i1772_10_, p_i1772_12_);
    }

    protected void func_70227_a(MovingObjectPosition p_70227_1_) {
        if (!this.field_70170_p.field_72995_K) {
            if (p_70227_1_.field_72308_g != null) {
                if (this.field_70235_a != null && this.field_70235_a instanceof EntityLiving && ((EntityLiving)this.field_70235_a).func_70686_a(p_70227_1_.field_72308_g.getClass())) {
                    p_70227_1_.field_72308_g.field_70172_ad = 0;
                    ((EntityLiving)this.field_70235_a).func_70652_k(p_70227_1_.field_72308_g);
                    p_70227_1_.field_72308_g.func_70015_d((int)((EntityLiving)this.field_70235_a).func_110148_a(SharedMonsterAttributes.field_111264_e).func_111125_b());
                    this.func_70106_y();
                }
            } else {
                int i = p_70227_1_.field_72311_b;
                int j = p_70227_1_.field_72312_c;
                int k = p_70227_1_.field_72309_d;
                switch (p_70227_1_.field_72310_e) {
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
                    this.func_70106_y();
                }
            }
        }

    }
}
