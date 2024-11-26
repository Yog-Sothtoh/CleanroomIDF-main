//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.orespawnaddon.EntityOverlordScorpion;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityTitanFireball extends EntityFireball {
    public float explosionRadius;
    public float impactDamage;
    public boolean canCauseFires;

    public EntityTitanFireball(World worldIn) {
        super(worldIn);
    }

    public EntityTitanFireball(World worldIn, EntityLivingBase p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_) {
        super(worldIn, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
    }

    public EntityTitanFireball(World worldIn, double p_i1772_2_, double p_i1772_4_, double p_i1772_6_, double p_i1772_8_, double p_i1772_10_, double p_i1772_12_) {
        super(worldIn, p_i1772_2_, p_i1772_4_, p_i1772_6_, p_i1772_8_, p_i1772_10_, p_i1772_12_);
    }

    public EntityTitanFireball(World worldIn, EntityLivingBase p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_, int id) {
        this(worldIn, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
        this.setFireballID(id);
    }

    public void onImpactPublic(EntityLivingBase movingObject) {
        float f;
        if (TheTitans.NightmareMode) {
            f = this.impactDamage * 3.0F;
        } else {
            f = this.impactDamage;
        }

        if (movingObject != null && this.field_70235_a != null && this.field_70235_a instanceof EntityLiving && ((EntityLiving)this.field_70235_a).func_70686_a(movingObject.getClass())) {
            if (this.field_70235_a instanceof EntityTitan) {
                ((EntityTitan)this.field_70235_a).attackChoosenEntity(movingObject, f, 3);
                ((EntityTitan)this.field_70235_a).destroyBlocksInAABB(this.field_70121_D.func_72314_b((double)(this.explosionRadius - this.field_70130_N) + (double)1.0F, (double)(this.explosionRadius - this.field_70130_N) + (double)1.0F, (double)(this.explosionRadius - this.field_70130_N) + (double)1.0F));
            } else if ((EntityLiving)this.field_70235_a instanceof EntityOverlordScorpion && movingObject.getClass() != (Class)EntityList.field_75625_b.get("Emperor Scorpion")) {
                ((EntityLiving)this.field_70235_a).func_70652_k(movingObject);
            }

            this.func_85030_a("random.explode", 4.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 0.7F);
            this.func_70106_y();
        }

    }

    protected void func_70227_a(MovingObjectPosition movingObject) {
        float f;
        if (TheTitans.NightmareMode) {
            f = this.impactDamage * 3.0F;
        } else {
            f = this.impactDamage;
        }

        if (!this.field_70170_p.field_72995_K) {
            if (movingObject.field_72308_g != null && movingObject.field_72308_g instanceof EntityFireball) {
                return;
            }

            if (movingObject.field_72308_g != null) {
                if (this.field_70235_a != null && this.field_70235_a instanceof EntityLiving && ((EntityLiving)this.field_70235_a).func_70686_a(movingObject.field_72308_g.getClass())) {
                    if (this.field_70235_a instanceof EntityTitan) {
                        ((EntityTitan)this.field_70235_a).attackChoosenEntity(movingObject.field_72308_g, f, 3);
                        ((EntityTitan)this.field_70235_a).destroyBlocksInAABB(this.field_70121_D.func_72314_b((double)(this.explosionRadius - this.field_70130_N) + (double)1.0F, (double)(this.explosionRadius - this.field_70130_N) + (double)1.0F, (double)(this.explosionRadius - this.field_70130_N) + (double)1.0F));
                    } else {
                        if ((EntityLiving)this.field_70235_a instanceof EntityOverlordScorpion && movingObject.field_72308_g.getClass() != (Class)EntityList.field_75625_b.get("Emperor Scorpion")) {
                            ((EntityLiving)this.field_70235_a).func_70652_k(movingObject.field_72308_g);
                        }

                        if (movingObject.field_72308_g instanceof EntityTitanPart) {
                            movingObject.field_72308_g.func_70097_a(DamageSource.func_76358_a(this.field_70235_a), f);
                        }
                    }

                    this.func_85030_a("random.explode", 4.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 0.7F);
                    this.func_70106_y();
                }
            } else {
                if (this.field_70235_a != null && this.field_70235_a instanceof EntityTitan && this.getFireballID() != 6) {
                    ((EntityTitan)this.field_70235_a).destroyBlocksInAABB(this.field_70121_D.func_72314_b((double)(this.explosionRadius - this.field_70130_N) + (double)1.0F, (double)(this.explosionRadius - this.field_70130_N) + (double)1.0F, (double)(this.explosionRadius - this.field_70130_N) + (double)1.0F));
                }

                if (!this.field_70170_p.field_72995_K && this.getFireballID() == 6) {
                    for(int l = 0; l < 128; ++l) {
                        int i = MathHelper.func_76128_c(this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N);
                        int j = MathHelper.func_76128_c(this.field_70163_u);
                        int k = MathHelper.func_76128_c(this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N);
                        if (this.field_70170_p.func_147439_a(i, j, k).func_149688_o() == Material.field_151579_a && Blocks.field_150431_aC.func_149742_c(this.field_70170_p, i, j, k)) {
                            this.field_70170_p.func_147449_b(i, j, k, Blocks.field_150431_aC);
                        }
                    }
                }

                this.field_70170_p.func_72885_a((Entity)(this.field_70235_a != null ? this.field_70235_a : this), this.field_70165_t, this.field_70163_u, this.field_70161_v, this.explosionRadius, this.canCauseFires ? this.field_70170_p.func_82736_K().func_82766_b("mobGriefing") : false, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                this.func_70106_y();
            }
        }

    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        return false;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(21, new Integer(0));
    }

    public int getFireballID() {
        return this.field_70180_af.func_75679_c(21);
    }

    public void setFireballID(int p_82215_1_) {
        this.field_70180_af.func_75692_b(21, p_82215_1_);
    }

    public void func_70014_b(NBTTagCompound p_70014_1_) {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74768_a("FireballID", this.getFireballID());
    }

    public void func_70037_a(NBTTagCompound p_70037_1_) {
        super.func_70037_a(p_70037_1_);
        if (p_70037_1_.func_150297_b("FireballID", 99)) {
            this.setFireballID(p_70037_1_.func_74762_e("FireballID"));
        }

    }

    public boolean func_70027_ad() {
        return this.canCauseFires;
    }

    public void func_70015_d(int p_70015_1_) {
        if (this.canCauseFires) {
            super.func_70015_d(p_70015_1_);
        }

    }

    public void func_70071_h_() {
        if (this.field_70235_a != null) {
            if (this.field_70235_a instanceof EntityGhastTitan) {
                this.setFireballID(0);
            }

            if (this.field_70235_a instanceof EntityCreeperTitan) {
                this.setFireballID(1);
            }

            if (this.field_70235_a instanceof EntityBlazeTitan) {
                this.setFireballID(2);
            }

            if (this.field_70235_a instanceof EntityPigZombieTitan) {
                this.setFireballID(3);
            }

            if (this.field_70235_a instanceof EntityEnderColossus) {
                this.setFireballID(4);
            }

            if (this.field_70235_a instanceof EntityIronGolemTitan) {
                this.setFireballID(5);
            }

            if (this.field_70235_a instanceof EntitySnowGolemTitan) {
                this.setFireballID(6);
            }
        }

        switch (this.getFireballID()) {
            case 1:
                this.func_70105_a(1.5F, 1.5F);
                this.impactDamage = 200.0F;
                this.canCauseFires = false;
                this.explosionRadius = 3.0F;
                break;
            case 2:
                this.func_70105_a(2.0F, 2.0F);
                this.impactDamage = 600.0F;
                this.canCauseFires = true;
                this.explosionRadius = 3.0F;
                break;
            case 3:
                this.func_70105_a(1.5F, 1.5F);
                this.impactDamage = 300.0F;
                this.canCauseFires = true;
                this.explosionRadius = 4.0F;
                break;
            case 4:
                this.func_70105_a(4.0F, 4.0F);
                this.impactDamage = 1500.0F;
                this.canCauseFires = false;
                this.explosionRadius = 8.0F;
                break;
            case 5:
                this.func_70105_a(6.0F, 6.0F);
                this.impactDamage = 10000.0F;
                this.canCauseFires = false;
                this.explosionRadius = 12.0F;
                break;
            case 6:
                this.func_70105_a(2.0F, 2.0F);
                this.impactDamage = 60.0F;
                this.canCauseFires = false;
                this.explosionRadius = 1.0F;
                break;
            default:
                this.func_70105_a(6.0F, 6.0F);
                this.impactDamage = 10000.0F;
                this.canCauseFires = true;
                this.explosionRadius = 12.0F;
        }

        super.func_70071_h_();
    }
}
