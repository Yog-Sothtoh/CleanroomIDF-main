//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityMortarWitherSkull extends EntityWitherSkull {
    public int lifetime;
    public int explosivePower;
    public int extraDamage;
    public float speedFactor;

    public boolean func_82342_d() {
        return true;
    }

    public EntityMortarWitherSkull(World worldIn) {
        super(worldIn);
        this.func_70105_a(0.5F, 0.5F);
    }

    public EntityMortarWitherSkull(World worldIn, EntityLivingBase p_i1794_2_, double p_i1794_3_, double p_i1794_5_, double p_i1794_7_) {
        super(worldIn, p_i1794_2_, p_i1794_3_, p_i1794_5_, p_i1794_7_);
        this.func_70105_a(0.5F, 0.5F);
    }

    @SideOnly(Side.CLIENT)
    public EntityMortarWitherSkull(World worldIn, double p_i1795_2_, double p_i1795_4_, double p_i1795_6_, double p_i1795_8_, double p_i1795_10_, double p_i1795_12_) {
        super(worldIn, p_i1795_2_, p_i1795_4_, p_i1795_6_, p_i1795_8_, p_i1795_10_, p_i1795_12_);
        this.func_70105_a(0.5F, 0.5F);
    }

    public float func_145772_a(Explosion p_145772_1_, World p_145772_2_, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block p_145772_6_) {
        float f = super.func_145772_a(p_145772_1_, p_145772_2_, p_145772_3_, p_145772_4_, p_145772_5_, p_145772_6_);
        if (this.func_82342_d() && p_145772_6_ != Blocks.field_150357_h && p_145772_6_ != Blocks.field_150384_bq && p_145772_6_ != Blocks.field_150378_br && p_145772_6_ != Blocks.field_150483_bI) {
            f = Math.min(0.0F, f);
        }

        return f;
    }

    protected void func_70227_a(MovingObjectPosition movingObject) {
        if (!this.field_70170_p.field_72995_K) {
            if (movingObject.field_72308_g != null) {
                if (this.field_70235_a != null) {
                    if (movingObject.field_72308_g instanceof EntityLivingBase) {
                        ((EntityLivingBase)movingObject.field_72308_g).func_70604_c(this.field_70235_a);
                        movingObject.field_72308_g.field_70172_ad = 0;
                        movingObject.field_72308_g.func_70024_g((double)(-MathHelper.func_76126_a(this.field_70235_a.field_70759_as * (float)Math.PI / 180.0F) * 1.5F), 0.9, (double)(MathHelper.func_76134_b(this.field_70235_a.field_70759_as * (float)Math.PI / 180.0F) * 1.5F));
                        if ((movingObject.field_72308_g.func_85032_ar() || movingObject.field_72308_g.field_70131_O >= 6.0F || ((EntityLivingBase)movingObject.field_72308_g).func_70658_aO() > 24) && !(movingObject.field_72308_g instanceof EntityTitan) && !(movingObject.field_72308_g instanceof EntityDragon) && !(movingObject.field_72308_g instanceof EntityDragonPart) && !(movingObject.field_72308_g instanceof EntityPlayer)) {
                            movingObject.field_72308_g.func_70097_a(DamageSourceExtra.destroy, (float)Integer.MAX_VALUE);
                        }
                    }

                    if (!(movingObject.field_72308_g instanceof EntityDragon) && !(movingObject.field_72308_g instanceof EntityDragonPart)) {
                        if (movingObject.field_72308_g instanceof EntityLivingBase && ((EntityLivingBase)movingObject.field_72308_g).func_70668_bt() == EnumCreatureAttribute.UNDEAD) {
                            if (!(movingObject.field_72308_g.field_70131_O >= 6.0F) && ((EntityLivingBase)movingObject.field_72308_g).func_70658_aO() <= 24) {
                                movingObject.field_72308_g.func_70097_a(DamageSourceExtra.field_76377_j, 500.0F + (float)(this.extraDamage * 100));
                            } else {
                                movingObject.field_72308_g.func_70097_a(DamageSource.field_76377_j, 5000.0F + (float)(this.extraDamage * 1000));
                                movingObject.field_72308_g.func_85030_a("thetitans:titanpunch", 10.0F, 0.9F);
                            }
                        } else if (movingObject.field_72308_g.field_70131_O >= 6.0F) {
                            movingObject.field_72308_g.func_70097_a(DamageSourceExtra.causeHomingSkullDamage(this.field_70235_a), 5000.0F + (float)(this.extraDamage * 1000));
                            movingObject.field_72308_g.func_85030_a("thetitans:titanpunch", 10.0F, 0.9F);
                        } else {
                            movingObject.field_72308_g.func_70097_a(DamageSourceExtra.causeHomingSkullDamage(this.field_70235_a), 500.0F + (float)(this.extraDamage * 100));
                        }
                    } else if (movingObject.field_72308_g.field_70131_O >= 6.0F) {
                        movingObject.field_72308_g.func_70097_a(DamageSourceExtra.causeHomingSkullDamageVSEnderDragon(this.field_70235_a), 5000.0F + (float)(this.extraDamage * 1000));
                        movingObject.field_72308_g.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                    } else {
                        movingObject.field_72308_g.func_70097_a(DamageSourceExtra.causeHomingSkullDamageVSEnderDragon(this.field_70235_a), 500.0F + (float)(this.extraDamage * 100));
                    }
                } else {
                    movingObject.field_72308_g.func_70097_a(DamageSource.field_76376_m, 500.0F);
                }

                if (movingObject.field_72308_g instanceof EntityLivingBase) {
                    byte b0 = 30;
                    if (this.field_70170_p.field_73013_u == EnumDifficulty.NORMAL) {
                        b0 = 60;
                    } else if (this.field_70170_p.field_73013_u == EnumDifficulty.HARD) {
                        b0 = 90;
                    }

                    if (b0 > 0) {
                        ((EntityLivingBase)movingObject.field_72308_g).func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 120, 3));
                        ((EntityLivingBase)movingObject.field_72308_g).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 40 * b0, 3));
                        ((EntityLivingBase)movingObject.field_72308_g).func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 120, 0));
                        ((EntityLivingBase)movingObject.field_72308_g).func_70690_d(new PotionEffect(Potion.field_76431_k.field_76415_H, 120, 0));
                    }
                }
            }

            this.field_70170_p.func_72885_a((Entity)(this.field_70235_a != null ? this.field_70235_a : this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 14.0F, false, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "random.explode", 4.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 0.6F);
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "thetitans:mortarHit", 0.5F, 1.0F);
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "thetitans:mortarHit", 2.0F, 1.0F);
            this.func_70106_y();
        }

    }

    public boolean func_70067_L() {
        return false;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        ++this.lifetime;
        if (this.lifetime >= 1000) {
            this.field_70170_p.func_72885_a((Entity)(this.field_70235_a != null ? this.field_70235_a : this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 14.0F, false, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "random.explode", 4.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 0.6F);
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "thetitans:mortarHit", 0.5F, 1.0F);
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "thetitans:mortarHit", 2.0F, 1.0F);
            this.func_70106_y();
        }

    }
}
