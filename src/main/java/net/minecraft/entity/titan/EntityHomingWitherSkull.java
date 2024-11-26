//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityHomingWitherSkull extends EntityWitherSkull {
    public int lifetime;
    public int explosivePower;
    public int extraDamage;
    public float speedFactor;
    public Entity assginedEntity;

    public EntityHomingWitherSkull(World worldIn) {
        super(worldIn);
        this.func_70105_a(0.5F, 0.5F);
    }

    public EntityHomingWitherSkull(World worldIn, EntityLivingBase p_i1794_2_, double p_i1794_3_, double p_i1794_5_, double p_i1794_7_) {
        super(worldIn, p_i1794_2_, p_i1794_3_, p_i1794_5_, p_i1794_7_);
        this.func_70105_a(0.5F, 0.5F);
    }

    @SideOnly(Side.CLIENT)
    public EntityHomingWitherSkull(World worldIn, double p_i1795_2_, double p_i1795_4_, double p_i1795_6_, double p_i1795_8_, double p_i1795_10_, double p_i1795_12_) {
        super(worldIn, p_i1795_2_, p_i1795_4_, p_i1795_6_, p_i1795_8_, p_i1795_10_, p_i1795_12_);
        this.func_70105_a(0.5F, 0.5F);
    }

    protected void func_70227_a(MovingObjectPosition movingObject) {
        if (!this.field_70170_p.field_72995_K) {
            if (movingObject.field_72308_g != null) {
                if (this.field_70235_a != null) {
                    if (movingObject.field_72308_g instanceof EntityLivingBase) {
                        ((EntityLivingBase)movingObject.field_72308_g).func_70604_c(this.field_70235_a);
                        movingObject.field_72308_g.field_70172_ad = 5;
                        if ((movingObject.field_72308_g.field_70131_O >= 6.0F || ((EntityLivingBase)movingObject.field_72308_g).func_70658_aO() > 24) && !(movingObject.field_72308_g instanceof EntityTitan) && !(movingObject.field_72308_g instanceof EntityDragon) && !(movingObject.field_72308_g instanceof EntityDragonPart) && !(movingObject.field_72308_g instanceof EntityPlayer)) {
                            movingObject.field_72308_g.func_70097_a(DamageSourceExtra.destroy, Float.MAX_VALUE);
                        }
                    }

                    if (!(movingObject.field_72308_g instanceof EntityDragon) && !(movingObject.field_72308_g instanceof EntityDragonPart)) {
                        if (movingObject.field_72308_g instanceof EntityLivingBase && ((EntityLivingBase)movingObject.field_72308_g).func_70668_bt() == EnumCreatureAttribute.UNDEAD) {
                            if (!(movingObject.field_72308_g.field_70131_O >= 6.0F) && ((EntityLivingBase)movingObject.field_72308_g).func_70658_aO() <= 24) {
                                movingObject.field_72308_g.func_70097_a(DamageSourceExtra.radiation, 20.0F + (float)this.extraDamage);
                            } else {
                                movingObject.field_72308_g.func_70097_a(DamageSourceExtra.radiation, 300.0F + (float)(this.extraDamage * 30));
                                movingObject.field_72308_g.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                            }
                        } else if (movingObject.field_72308_g.field_70131_O >= 6.0F) {
                            movingObject.field_72308_g.func_70097_a(DamageSourceExtra.causeHomingSkullDamage(this.field_70235_a), 100.0F + (float)(this.extraDamage * 10));
                            movingObject.field_72308_g.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                        } else {
                            movingObject.field_72308_g.func_70097_a(DamageSourceExtra.causeHomingSkullDamage(this.field_70235_a), 20.0F + (float)this.extraDamage);
                        }
                    } else if (movingObject.field_72308_g.field_70131_O >= 6.0F) {
                        movingObject.field_72308_g.func_70097_a(DamageSourceExtra.causeHomingSkullDamageVSEnderDragon(this.field_70235_a), 200.0F + (float)(this.extraDamage * 20));
                        movingObject.field_72308_g.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                    } else {
                        movingObject.field_72308_g.func_70097_a(DamageSourceExtra.causeHomingSkullDamageVSEnderDragon(this.field_70235_a), 20.0F + (float)this.extraDamage);
                    }
                } else {
                    movingObject.field_72308_g.func_70097_a(DamageSource.field_76376_m, 20.0F);
                }

                if (movingObject.field_72308_g instanceof EntityLivingBase) {
                    byte b0 = 20;
                    if (this.field_70170_p.field_73013_u == EnumDifficulty.NORMAL) {
                        b0 = 40;
                    } else if (this.field_70170_p.field_73013_u == EnumDifficulty.HARD) {
                        b0 = 80;
                    }

                    if (b0 > 0) {
                        ((EntityLivingBase)movingObject.field_72308_g).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 20 * b0, 1));
                    }
                }
            }

            this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 2.0F + (float)this.explosivePower, false, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
            this.func_70106_y();
        }

    }

    public boolean func_70067_L() {
        return false;
    }

    public void func_70071_h_() {
        ++this.lifetime;
        if (this.assginedEntity != null && this.assginedEntity.func_70089_S()) {
            double d0 = this.assginedEntity.field_70165_t - this.field_70165_t;
            double d1 = this.assginedEntity.field_70163_u + (this.assginedEntity instanceof EntityTitan ? (double)this.assginedEntity.field_70131_O * (double)0.5F : (double)this.assginedEntity.func_70047_e()) - this.field_70163_u;
            double d2 = this.assginedEntity.field_70161_v - this.field_70161_v;
            float f2 = MathHelper.func_76133_a(d0 * d0 + d1 * d1 + d2 * d2);
            this.field_70159_w = d0 / (double)f2 * (double)(this.func_82341_c() * 0.75F) * (double)(this.func_82341_c() * 0.75F) + this.field_70159_w * (double)0.75F;
            this.field_70181_x = d1 / (double)f2 * (double)(this.func_82341_c() * 0.75F) * (double)(this.func_82341_c() * 0.75F) + this.field_70181_x * (double)0.75F;
            this.field_70179_y = d2 / (double)f2 * (double)(this.func_82341_c() * 0.75F) * (double)(this.func_82341_c() * 0.75F) + this.field_70179_y * (double)0.75F;
            if (this.func_70092_e(this.assginedEntity.field_70165_t, this.assginedEntity.field_70163_u + (this.assginedEntity instanceof EntityTitan ? (double)this.assginedEntity.field_70131_O * (double)0.5F : (double)this.assginedEntity.func_70047_e()), this.assginedEntity.field_70161_v) < (double)9.0F) {
                this.func_70227_a(new MovingObjectPosition(this.assginedEntity));
                this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 2.0F + (float)this.explosivePower, false, false);
                this.func_70106_y();
            }
        }

        if (this.lifetime >= 200) {
            this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 2.0F + (float)this.explosivePower, false, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
            this.func_70106_y();
        }

        super.func_70071_h_();
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }
}
