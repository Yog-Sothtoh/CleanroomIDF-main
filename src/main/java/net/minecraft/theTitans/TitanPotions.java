//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

public class TitanPotions extends Potion {
    protected TitanPotions(int p_i1573_1_, boolean p_i1573_2_, int p_i1573_3_) {
        super(p_i1573_1_, p_i1573_2_, p_i1573_3_);
    }

    public Potion func_76399_b(int p_76399_1_, int p_76399_2_) {
        super.func_76399_b(p_76399_1_, p_76399_2_);
        return this;
    }

    public boolean func_76398_f() {
        return true;
    }

    public boolean func_76397_a(int p_76397_1_, int p_76397_2_) {
        if (this.field_76415_H == ClientProxy.creeperTitanRadiation.field_76415_H) {
            int k = 20 >> p_76397_2_;
            return k > 0 ? p_76397_1_ % k == 0 : true;
        } else if (this.field_76415_H == ClientProxy.advancedWither.field_76415_H) {
            int k = 20 >> p_76397_2_;
            return k > 0 ? p_76397_1_ % k == 0 : true;
        } else if (this.field_76415_H == ClientProxy.electricJudgment.field_76415_H) {
            int k = 60 >> p_76397_2_;
            return k > 0 ? p_76397_1_ % k == 0 : true;
        } else if (this.field_76415_H == ClientProxy.death.field_76415_H) {
            int k = 40 >> p_76397_2_;
            return k > 0 ? p_76397_1_ % k == 0 : true;
        } else {
            return super.func_76397_a(p_76397_1_, p_76397_2_);
        }
    }

    public void func_76394_a(EntityLivingBase p_76394_1_, int p_76394_2_) {
        if (p_76394_1_.func_70089_S() && this.field_76415_H == ClientProxy.electricJudgment.field_76415_H) {
            if (!p_76394_1_.field_70170_p.field_72995_K && p_76394_1_.func_70089_S()) {
                p_76394_1_.field_70170_p.func_72942_c(new EntityLightningBolt(p_76394_1_.field_70170_p, p_76394_1_.field_70165_t - (double)0.5F, p_76394_1_.field_70163_u, p_76394_1_.field_70161_v - (double)0.5F));
            }

            p_76394_1_.func_70097_a(DamageSourceExtra.lightningBolt, 5.0F * (float)p_76394_2_);
            p_76394_1_.func_70015_d(20);
            if (p_76394_1_.func_110138_aP() > 1.0E9F && !(p_76394_1_ instanceof EntityTitanSpirit) && !(p_76394_1_ instanceof EntityTitan) && !(p_76394_1_ instanceof EntityPlayer)) {
                p_76394_1_.func_85030_a("random.explode", 2.0F, 1.0F + p_76394_1_.func_70681_au().nextFloat());
                p_76394_1_.func_70606_j(p_76394_1_.func_110143_aJ() / 2.0F);
                if (p_76394_1_.func_110143_aJ() <= 1.0F) {
                    p_76394_1_.field_70170_p.func_72876_a((Entity)null, p_76394_1_.field_70165_t, p_76394_1_.field_70163_u, p_76394_1_.field_70161_v, 7.0F, false);
                    p_76394_1_.func_70106_y();
                }
            }
        }

        if (p_76394_1_.func_70089_S() && this.field_76415_H == ClientProxy.death.field_76415_H) {
            p_76394_1_.func_70097_a(DamageSourceExtra.field_76380_i, 4.0F * (float)p_76394_2_);
            p_76394_1_.func_70015_d(20);
            if (p_76394_1_.field_70725_aQ > 0) {
                ++p_76394_1_.field_70725_aQ;
                if (p_76394_1_.field_70725_aQ > 20) {
                    p_76394_1_.func_70106_y();
                }
            }

            if (p_76394_1_.func_110138_aP() > 1.0E9F && !(p_76394_1_ instanceof EntityTitanSpirit) && !(p_76394_1_ instanceof EntityTitan) && !(p_76394_1_ instanceof EntityPlayer)) {
                p_76394_1_.func_85030_a("random.explode", 2.0F, 1.0F + p_76394_1_.func_70681_au().nextFloat());
                p_76394_1_.func_70606_j(p_76394_1_.func_110143_aJ() / 2.0F);
                if (p_76394_1_.func_110143_aJ() <= 1.0F) {
                    p_76394_1_.field_70170_p.func_72876_a((Entity)null, p_76394_1_.field_70165_t, p_76394_1_.field_70163_u, p_76394_1_.field_70161_v, 7.0F, false);
                    p_76394_1_.func_70106_y();
                }
            }
        }

        if (this.field_76415_H == ClientProxy.creeperTitanRadiation.field_76415_H) {
            p_76394_1_.func_70097_a(DamageSourceExtra.radiation, 2.0F * (float)p_76394_2_);
            p_76394_1_.field_70170_p.func_72980_b(p_76394_1_.field_70165_t, p_76394_1_.field_70163_u, p_76394_1_.field_70161_v, "game.player.hurt", 2.0F, 2.0F, false);
        }

        if (this.field_76415_H == ClientProxy.advancedWither.field_76415_H) {
            p_76394_1_.field_70172_ad = 0;
            p_76394_1_.func_70097_a((new DamageSource("advancedwither")).func_76348_h().func_151518_m().func_76359_i(), 2.0F * (float)p_76394_2_);
        }

        super.func_76394_a(p_76394_1_, p_76394_2_);
    }
}
