//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFoodMalgrum extends ItemFood {
    public ItemFoodMalgrum(int p_i45341_1_, float p_i45341_2_, boolean p_i45341_3_) {
        super(p_i45341_1_, p_i45341_2_, p_i45341_3_);
    }

    @SideOnly(Side.CLIENT)
    public boolean func_77636_d(ItemStack p_77636_1_) {
        return true;
    }

    public EnumRarity func_77613_e(ItemStack p_77613_1_) {
        return EnumRarity.epic;
    }

    protected void func_77849_c(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_) {
        if (!p_77849_2_.field_72995_K) {
            EntityXPOrb orb = new EntityXPOrb(p_77849_2_, p_77849_3_.field_70165_t, p_77849_3_.field_70163_u + (double)0.5F, p_77849_3_.field_70161_v, 5 + p_77849_3_.func_70681_au().nextInt(10) + (int)p_77849_3_.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b());
            p_77849_2_.func_72838_d(orb);
            p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76444_x.field_76415_H, 6000, p_77849_3_.func_70644_a(Potion.field_76444_x) && p_77849_3_.func_70660_b(Potion.field_76444_x).func_76458_c() > 9 ? p_77849_3_.func_70660_b(Potion.field_76444_x).func_76458_c() + 9 : 9));
            p_77849_3_.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(p_77849_3_.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() + (double)40.0F);
            p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 2400, 9));
            p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, 18000, 0));
            if (p_77849_3_.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() > (double)100.0F) {
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 18000, 1));
            }

            if (p_77849_3_.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() > (double)200.0F) {
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76439_r.field_76415_H, 18000, 0));
            }

            if (p_77849_3_.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() > (double)300.0F) {
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76424_c.field_76415_H, 18000, 3));
            }

            if (p_77849_3_.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() > (double)400.0F) {
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76430_j.field_76415_H, 18000, 1));
            }

            if (p_77849_3_.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() > (double)600.0F) {
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76422_e.field_76415_H, 18000, 1));
            }

            if (p_77849_3_.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() > (double)800.0F) {
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76427_o.field_76415_H, 18000, 1));
            }

            if (p_77849_3_.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() > (double)1000.0F) {
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, 18000, 1));
            }

            if (p_77849_3_.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() > (double)1500.0F) {
                p_77849_3_.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(p_77849_3_.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111125_b() + (double)1.0F);
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 18000, 3));
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 18000, 99));
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, 18000, 99));
            }
        }

    }
}
