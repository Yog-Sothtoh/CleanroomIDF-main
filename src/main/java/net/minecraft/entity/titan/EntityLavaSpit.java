//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLavaSpit extends EntityFireball {
    public EntityLavaSpit(World worldIn) {
        super(worldIn);
        this.func_70105_a(3.0F, 3.0F);
    }

    public EntityLavaSpit(World worldIn, EntityLivingBase p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_) {
        super(worldIn, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
        this.func_70105_a(3.0F, 3.0F);
    }

    public EntityLavaSpit(World worldIn, double p_i1772_2_, double p_i1772_4_, double p_i1772_6_, double p_i1772_8_, double p_i1772_10_, double p_i1772_12_) {
        super(worldIn, p_i1772_2_, p_i1772_4_, p_i1772_6_, p_i1772_8_, p_i1772_10_, p_i1772_12_);
        this.func_70105_a(3.0F, 3.0F);
    }

    protected void func_70227_a(MovingObjectPosition movingObject) {
        if (!this.field_70170_p.field_72995_K) {
            float f;
            if (TheTitans.NightmareMode) {
                f = 3000.0F;
            } else {
                f = 1000.0F;
            }

            if (movingObject.field_72308_g != null) {
                if (this.field_70235_a instanceof EntityTitan) {
                    ((EntityTitan)this.field_70235_a).attackChoosenEntity(movingObject.field_72308_g, f, 3);
                }

                this.func_85030_a("random.explode", 4.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 0.7F);
            } else {
                this.func_85030_a("random.explode", 4.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 0.7F);
            }

            int i1 = MathHelper.func_76128_c(this.field_70165_t);
            int i = MathHelper.func_76128_c(this.field_70163_u);
            int j1 = MathHelper.func_76128_c(this.field_70161_v);

            for(int l1 = -2; l1 <= 2; ++l1) {
                for(int i2 = -2; i2 <= 2; ++i2) {
                    for(int j = 0; j < 1; ++j) {
                        int j2 = i1 + l1;
                        int var10000 = i + j;
                        int l = j1 + i2;

                        for(int y = 0; y <= 256 && this.field_70170_p.func_147439_a(j2, i - 1, l).func_149688_o() == Material.field_151579_a; ++y) {
                            --i;
                        }

                        Block block = this.field_70170_p.func_147439_a(j2, i, l);
                        if (block.isAir(this.field_70170_p, j2, i, l)) {
                            this.field_70170_p.func_147465_d(j2, i, l, Blocks.field_150356_k, 3, 3);
                        }
                    }
                }
            }

            this.func_70106_y();
        }

    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean func_70027_ad() {
        return false;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        return false;
    }

    public boolean func_70090_H() {
        return false;
    }

    protected float func_82341_c() {
        return 0.975F;
    }
}
