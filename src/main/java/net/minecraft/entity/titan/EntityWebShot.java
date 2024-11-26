//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityWebShot extends EntityFireball {
    private int field_145795_e = -1;
    private int field_145793_f = -1;
    private int field_145794_g = -1;
    private Block field_145796_h;
    private boolean inGround;
    private int ticksAlive;
    private int ticksInAir;

    public EntityWebShot(World worldIn) {
        super(worldIn);
        this.func_70105_a(3.0F, 3.0F);
    }

    public EntityWebShot(World worldIn, EntityLivingBase p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_) {
        super(worldIn, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
        this.func_70105_a(3.0F, 3.0F);
    }

    public EntityWebShot(World worldIn, double p_i1772_2_, double p_i1772_4_, double p_i1772_6_, double p_i1772_8_, double p_i1772_10_, double p_i1772_12_) {
        super(worldIn, p_i1772_2_, p_i1772_4_, p_i1772_6_, p_i1772_8_, p_i1772_10_, p_i1772_12_);
        this.func_70105_a(3.0F, 3.0F);
    }

    protected void func_70227_a(MovingObjectPosition movingObject) {
        if (!this.field_70170_p.field_72995_K) {
            if (movingObject.field_72308_g != null) {
                if (this.field_70235_a != null && this.field_70235_a instanceof EntitySpiderTitan && ((EntitySpiderTitan)this.field_70235_a).func_70686_a(movingObject.field_72308_g.getClass())) {
                    ((EntitySpiderTitan)this.field_70235_a).attackChoosenEntity(movingObject.field_72308_g, (float)((EntitySpiderTitan)this.field_70235_a).func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e(), ((EntitySpiderTitan)this.field_70235_a).getKnockbackAmount());
                    int i1 = MathHelper.func_76128_c(this.field_70163_u + (double)1.0F);
                    int i11 = MathHelper.func_76128_c(this.field_70165_t);
                    int j1 = MathHelper.func_76128_c(this.field_70161_v);
                    boolean flag = false;

                    for(int l1 = -2 - this.field_70146_Z.nextInt(4); l1 <= 2 + this.field_70146_Z.nextInt(4); ++l1) {
                        for(int i2 = -2 - this.field_70146_Z.nextInt(4); i2 <= 2 + this.field_70146_Z.nextInt(4); ++i2) {
                            for(int j = -2 - this.field_70146_Z.nextInt(4); j <= 2 + this.field_70146_Z.nextInt(4); ++j) {
                                int j2 = i11 + l1;
                                int k = i1 + j;
                                int l = j1 + i2;
                                Block block1 = this.field_70170_p.func_147439_a(j2, k, l);
                                if (!block1.func_149662_c()) {
                                    this.field_70170_p.func_147449_b(j2, k, l, Blocks.field_150321_G);
                                }
                            }
                        }
                    }

                    this.func_70106_y();
                }
            } else {
                int x = movingObject.field_72311_b;
                int y = movingObject.field_72312_c;
                int z = movingObject.field_72309_d;
                if (this.field_70170_p.func_147439_a(x, y, z) != Blocks.field_150321_G) {
                    switch (movingObject.field_72310_e) {
                        case 0:
                            --y;
                            break;
                        case 1:
                            ++y;
                            break;
                        case 2:
                            --z;
                            break;
                        case 3:
                            ++z;
                            break;
                        case 4:
                            --x;
                            break;
                        case 5:
                            ++x;
                    }

                    if (this.field_70170_p.func_147437_c(x, y, z)) {
                        int i1 = x;
                        int i11 = y;
                        int j1 = z;
                        boolean flag = false;

                        for(int l1 = -2 - this.field_70146_Z.nextInt(4); l1 <= 2 + this.field_70146_Z.nextInt(4); ++l1) {
                            for(int i2 = -2 - this.field_70146_Z.nextInt(4); i2 <= 2 + this.field_70146_Z.nextInt(4); ++i2) {
                                for(int j = -2 - this.field_70146_Z.nextInt(4); j <= 2 + this.field_70146_Z.nextInt(4); ++j) {
                                    int j2 = i11 + l1;
                                    int k = i1 + j;
                                    int l = j1 + i2;
                                    Block block1 = this.field_70170_p.func_147439_a(j2, k, l);
                                    if (!block1.func_149662_c()) {
                                        this.field_70170_p.func_147449_b(j2, k, l, Blocks.field_150321_G);
                                    }
                                }
                            }
                        }

                        this.func_70106_y();
                    }
                }
            }
        }

    }

    public void func_70071_h_() {
        this.field_70145_X = true;
        if ((this.field_70235_a == null || !this.field_70235_a.field_70128_L) && this.field_70170_p.func_72899_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v)) {
            this.func_70030_z();
            if (this.inGround) {
                if (this.field_70170_p.func_147439_a(this.field_145795_e, this.field_145793_f, this.field_145794_g) == this.field_145796_h) {
                    ++this.ticksAlive;
                    if (this.ticksAlive == 600) {
                        this.func_70106_y();
                    }

                    return;
                }

                this.inGround = false;
                this.field_70159_w *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
                this.field_70181_x *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
                this.field_70179_y *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
                this.ticksAlive = 0;
                this.ticksInAir = 0;
            } else {
                ++this.ticksInAir;
            }

            Vec3 vec3 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + (double)1.5F, this.field_70161_v);
            Vec3 vec31 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + (double)1.5F + this.field_70181_x, this.field_70161_v + this.field_70179_y);
            MovingObjectPosition movingobjectposition = this.field_70170_p.func_72933_a(vec3, vec31);
            vec3 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + (double)1.5F, this.field_70161_v);
            vec31 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + (double)1.5F + this.field_70181_x, this.field_70161_v + this.field_70179_y);
            if (movingobjectposition != null) {
                vec31 = Vec3.func_72443_a(movingobjectposition.field_72307_f.field_72450_a, movingobjectposition.field_72307_f.field_72448_b, movingobjectposition.field_72307_f.field_72449_c);
            }

            Entity entity = null;
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b((double)2.0F, (double)2.0F, (double)2.0F));
            if (list != null && !list.isEmpty()) {
                for(int i = 0; i < list.size(); ++i) {
                    Entity entity1 = (Entity)list.get(i);
                    if (entity1.func_70067_L() && this.ticksInAir >= 5) {
                        float f = entity1.field_70130_N;
                        AxisAlignedBB axisalignedbb = entity1.field_70121_D.func_72314_b((double)f, (double)f, (double)f);
                        MovingObjectPosition movingobjectposition1 = axisalignedbb.func_72327_a(vec3, vec31);
                        if (movingobjectposition1 != null) {
                            entity = entity1;
                        }
                    }
                }
            }

            if (entity != null) {
                movingobjectposition = new MovingObjectPosition(entity);
            }

            if (movingobjectposition != null) {
                this.func_70227_a(movingobjectposition);
            }

            ArrayList list1 = Lists.newArrayList(this.field_70170_p.field_72996_f);
            if (list1 != null && !list1.isEmpty() && this.field_70235_a != null && this.field_70235_a instanceof EntityTitan) {
                for(int i = 0; i < list1.size(); ++i) {
                    Entity entity1 = (Entity)list1.get(i);
                    if (this.func_70089_S() && entity1 instanceof EntityLivingBase && !(entity1 instanceof EntityTitanPart) && !(entity1 instanceof EntityTitan) && ((EntityTitan)this.field_70235_a).func_70686_a(entity1.getClass()) && this.func_70068_e(entity1) <= (double)(this.field_70130_N * this.field_70130_N + entity1.field_70130_N * entity1.field_70130_N) + (double)4.0F) {
                        this.func_70227_a(new MovingObjectPosition(entity1));
                    }
                }
            }

            this.field_70165_t += this.field_70159_w;
            this.field_70163_u += this.field_70181_x;
            this.field_70161_v += this.field_70179_y;
            float f1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            this.field_70177_z = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * (double)180.0F / Math.PI) + 90.0F;

            for(this.field_70125_A = (float)(Math.atan2((double)f1, this.field_70181_x) * (double)180.0F / Math.PI) - 90.0F; this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {
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
            float f2 = 0.99F;
            if (this.func_70090_H()) {
                for(int j = 0; j < 4; ++j) {
                    float f3 = 0.25F;
                    this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * (double)f3, this.field_70163_u - this.field_70181_x * (double)f3, this.field_70161_v - this.field_70179_y * (double)f3, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                }
            }

            this.field_70159_w += this.field_70232_b;
            this.field_70181_x += this.field_70233_c;
            this.field_70179_y += this.field_70230_d;
            this.field_70159_w *= (double)f2;
            this.field_70181_x *= (double)f2;
            this.field_70179_y *= (double)f2;
            this.field_70170_p.func_72869_a("explode", this.field_70165_t, this.field_70163_u + (double)1.5F, this.field_70161_v, (double)0.0F, (double)0.0F, (double)0.0F);
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        } else {
            this.func_70106_y();
        }

        for(int l1 = -1; l1 <= 1; ++l1) {
            for(int i2 = -1; i2 <= 1; ++i2) {
                for(int j = -1; j <= 1; ++j) {
                    int j2 = (int)this.field_70165_t + l1;
                    int k = (int)this.field_70163_u + 1 + j;
                    int l = (int)this.field_70161_v + i2;
                    Block block1 = this.field_70170_p.func_147439_a(j2, k, l);
                    if (!block1.func_149662_c() && this.field_70173_aa > 10) {
                        this.field_70170_p.func_147449_b(j2, k, l, Blocks.field_150321_G);
                    }
                }
            }
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
}
