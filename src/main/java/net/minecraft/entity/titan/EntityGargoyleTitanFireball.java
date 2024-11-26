//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGargoyleTitanFireball extends EntityFireball {
    public EntityGargoyleTitanFireball(World worldIn) {
        super(worldIn);
        this.func_70105_a(3.0F, 3.0F);
        this.setModelVarient(this.field_70146_Z.nextInt(6));
        int i = this.field_70146_Z.nextInt(100);
        if (i >= 40) {
            this.setBlockType(0);
        } else if (i < 40 && i >= 20) {
            this.setBlockType(1);
        } else if (i < 20 && i >= 10) {
            this.setBlockType(2);
        } else if (i < 10 && i >= 5) {
            this.setBlockType(3);
        } else if (i < 5 && i >= 2) {
            this.setBlockType(4);
        } else if (i == 1) {
            this.setBlockType(5);
        } else if (i == 0) {
            this.setBlockType(6);
        }

    }

    public EntityGargoyleTitanFireball(World worldIn, EntityLivingBase p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_) {
        super(worldIn, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
        this.func_70105_a(3.0F, 3.0F);
        this.setModelVarient(this.field_70146_Z.nextInt(6));
        int i = this.field_70146_Z.nextInt(100);
        if (i >= 40) {
            this.setBlockType(0);
        } else if (i < 40 && i >= 20) {
            this.setBlockType(1);
        } else if (i < 20 && i >= 10) {
            this.setBlockType(2);
        } else if (i < 10 && i >= 5) {
            this.setBlockType(3);
        } else if (i < 5 && i >= 2) {
            this.setBlockType(4);
        } else if (i == 1) {
            this.setBlockType(5);
        } else if (i == 0) {
            this.setBlockType(6);
        }

    }

    public EntityGargoyleTitanFireball(World worldIn, double p_i1772_2_, double p_i1772_4_, double p_i1772_6_, double p_i1772_8_, double p_i1772_10_, double p_i1772_12_) {
        super(worldIn, p_i1772_2_, p_i1772_4_, p_i1772_6_, p_i1772_8_, p_i1772_10_, p_i1772_12_);
        this.func_70105_a(3.0F, 3.0F);
        this.setModelVarient(this.field_70146_Z.nextInt(6));
        int i = this.field_70146_Z.nextInt(100);
        if (i >= 40) {
            this.setBlockType(0);
        } else if (i < 40 && i >= 20) {
            this.setBlockType(1);
        } else if (i < 20 && i >= 10) {
            this.setBlockType(2);
        } else if (i < 10 && i >= 5) {
            this.setBlockType(3);
        } else if (i < 5 && i >= 2) {
            this.setBlockType(4);
        } else if (i == 1) {
            this.setBlockType(5);
        } else if (i == 0) {
            this.setBlockType(6);
        }

    }

    public boolean func_70027_ad() {
        return false;
    }

    protected void func_70227_a(MovingObjectPosition movingObject) {
        if (!this.field_70170_p.field_72995_K) {
            float f;
            if (TheTitans.NightmareMode) {
                f = 9000.0F;
            } else {
                f = 3000.0F;
            }

            if (movingObject.field_72308_g != null && !(movingObject.field_72308_g instanceof EntityGargoyleTitan)) {
                this.func_70097_a(DamageSource.func_76362_a(this, (Entity)(this.field_70235_a != null ? this.field_70235_a : this)), f);
            }

            if (movingObject.field_72308_g == null) {
                int i = MathHelper.func_76128_c(this.field_70163_u);
                int i1 = MathHelper.func_76128_c(this.field_70165_t);
                int j1 = MathHelper.func_76128_c(this.field_70161_v);

                for(int l1 = -1; l1 <= 1; ++l1) {
                    for(int i2 = -1; i2 <= 1; ++i2) {
                        for(int j = 0; j <= 2; ++j) {
                            int j2 = i1 + l1;
                            int k = i + j;
                            int l = j1 + i2;
                            Block block = this.field_70170_p.func_147439_a(j2, k, l);
                            if (!block.func_149662_c()) {
                                switch (this.getBlockType()) {
                                    case 0:
                                        this.field_70170_p.func_147465_d(j2, k, l, Blocks.field_150348_b, 0, 3);
                                        break;
                                    case 1:
                                        this.field_70170_p.func_147465_d(j2, k, l, Blocks.field_150365_q, 0, 3);
                                        break;
                                    case 2:
                                        this.field_70170_p.func_147465_d(j2, k, l, Blocks.field_150366_p, 0, 3);
                                        break;
                                    case 3:
                                        this.field_70170_p.func_147465_d(j2, k, l, Blocks.field_150450_ax, 0, 3);
                                        break;
                                    case 4:
                                        this.field_70170_p.func_147465_d(j2, k, l, Blocks.field_150352_o, 0, 3);
                                        break;
                                    case 5:
                                        this.field_70170_p.func_147465_d(j2, k, l, Blocks.field_150482_ag, 0, 3);
                                        break;
                                    case 6:
                                        this.field_70170_p.func_147465_d(j2, k, l, Blocks.field_150412_bA, 0, 3);
                                }
                            }
                        }
                    }
                }

                this.field_70170_p.func_72885_a((Entity)(this.field_70235_a != null ? this.field_70235_a : this), this.field_70165_t, this.field_70163_u + (double)3.0F, this.field_70161_v, 8.0F, true, false);
            }

            this.func_70106_y();
        }

    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        return false;
    }

    protected void func_70088_a() {
        this.field_70180_af.func_75682_a(10, (byte)0);
        this.field_70180_af.func_75682_a(11, (byte)0);
    }

    public int getBlockType() {
        return this.field_70180_af.func_75683_a(10);
    }

    public void setBlockType(int p_82201_1_) {
        this.field_70180_af.func_75692_b(10, (byte)p_82201_1_);
    }

    public int getModelVarient() {
        return this.field_70180_af.func_75683_a(11);
    }

    public void setModelVarient(int p_82201_1_) {
        this.field_70180_af.func_75692_b(11, (byte)p_82201_1_);
    }
}
