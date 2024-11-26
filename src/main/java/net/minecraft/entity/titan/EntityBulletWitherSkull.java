//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityBulletWitherSkull extends EntityWitherSkull {
    public int lifetime;
    public int explosivePower;
    public int extraDamage;
    public float speedFactor;

    protected float func_82341_c() {
        return 0.95F;
    }

    public EntityBulletWitherSkull(World worldIn) {
        super(worldIn);
        this.func_70105_a(0.3125F, 0.3125F);
    }

    public EntityBulletWitherSkull(World worldIn, EntityLivingBase p_i1794_2_, double p_i1794_3_, double p_i1794_5_, double p_i1794_7_) {
        super(worldIn, p_i1794_2_, p_i1794_3_, p_i1794_5_, p_i1794_7_);
        this.func_70105_a(0.3125F, 0.3125F);
    }

    @SideOnly(Side.CLIENT)
    public EntityBulletWitherSkull(World worldIn, double p_i1795_2_, double p_i1795_4_, double p_i1795_6_, double p_i1795_8_, double p_i1795_10_, double p_i1795_12_) {
        super(worldIn, p_i1795_2_, p_i1795_4_, p_i1795_6_, p_i1795_8_, p_i1795_10_, p_i1795_12_);
        this.func_70105_a(0.3125F, 0.3125F);
    }

    protected void func_70227_a(MovingObjectPosition movingObject) {
        if (!this.field_70170_p.field_72995_K) {
            if (movingObject.field_72308_g != null) {
                if (this.field_70235_a != null) {
                    if (movingObject.field_72308_g instanceof EntityLivingBase) {
                        ((EntityLivingBase)movingObject.field_72308_g).func_70604_c(this.field_70235_a);
                        movingObject.field_72308_g.field_70172_ad = 1;
                        if (((EntityLivingBase)movingObject.field_72308_g).func_70658_aO() > 24 && !(movingObject.field_72308_g instanceof EntityTitan) && !(movingObject.field_72308_g instanceof EntityDragon) && !(movingObject.field_72308_g instanceof EntityDragonPart) && !(movingObject.field_72308_g instanceof EntityPlayer)) {
                            movingObject.field_72308_g.func_70097_a(DamageSourceExtra.destroy, (float)Integer.MAX_VALUE);
                        }
                    }

                    if (!(movingObject.field_72308_g instanceof EntityDragon) && !(movingObject.field_72308_g instanceof EntityDragonPart)) {
                        if (movingObject.field_72308_g instanceof EntityLivingBase && ((EntityLivingBase)movingObject.field_72308_g).func_70668_bt() == EnumCreatureAttribute.UNDEAD) {
                            movingObject.field_72308_g.func_70097_a(DamageSourceExtra.field_76377_j, 10.0F + (float)this.extraDamage);
                        } else {
                            movingObject.field_72308_g.func_70097_a(DamageSourceExtra.causeHomingSkullDamage(this.field_70235_a), 10.0F + (float)this.extraDamage);
                        }
                    } else {
                        movingObject.field_72308_g.func_70097_a(DamageSourceExtra.causeHomingSkullDamageVSEnderDragon(this.field_70235_a), 10.0F + (float)this.extraDamage);
                    }

                    if (!movingObject.field_72308_g.func_70089_S() && !(movingObject.field_72308_g instanceof EntityTitan) && !(movingObject.field_72308_g instanceof EntityDragon) && !(movingObject.field_72308_g instanceof EntityDragonPart) && !(movingObject.field_72308_g instanceof EntityPlayer)) {
                        movingObject.field_72308_g.func_70106_y();
                    }
                } else {
                    movingObject.field_72308_g.func_70097_a(DamageSource.field_76376_m, 5.0F);
                }

                if (movingObject.field_72308_g instanceof EntityLivingBase) {
                    byte b0 = 10;
                    if (this.field_70170_p.field_73013_u == EnumDifficulty.NORMAL) {
                        b0 = 20;
                    } else if (this.field_70170_p.field_73013_u == EnumDifficulty.HARD) {
                        b0 = 40;
                    }

                    if (b0 > 0) {
                        ((EntityLivingBase)movingObject.field_72308_g).func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 40, 3));
                        ((EntityLivingBase)movingObject.field_72308_g).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 20 * b0, 1));
                        if (movingObject.field_72308_g.field_70163_u + (double)movingObject.field_72308_g.func_70047_e() - 0.2 < this.field_70163_u) {
                            ((EntityLivingBase)movingObject.field_72308_g).func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 40, 0));
                        }
                    }
                }
            }

            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "random.explode", 2.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 1.8F);
            this.func_70106_y();
        }

    }

    public boolean func_70067_L() {
        return false;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        ++this.lifetime;
        if (this.lifetime >= 100) {
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "random.explode", 2.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 1.8F);
            this.func_70106_y();
        }

    }
}
