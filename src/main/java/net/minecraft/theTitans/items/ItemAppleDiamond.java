//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemAppleDiamond extends ItemFood {
    private static final String __OBFID = "CL_00000037";

    public ItemAppleDiamond(int p_i45341_1_, float p_i45341_2_, boolean p_i45341_3_) {
        super(p_i45341_1_, p_i45341_2_, p_i45341_3_);
        this.func_77627_a(true);
    }

    @SideOnly(Side.CLIENT)
    public boolean func_77636_d(ItemStack p_77636_1_) {
        return p_77636_1_.func_77960_j() > 0;
    }

    public EnumRarity func_77613_e(ItemStack p_77613_1_) {
        return p_77613_1_.func_77960_j() == 0 ? EnumRarity.rare : EnumRarity.epic;
    }

    protected void func_77849_c(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_) {
        if (!p_77849_2_.field_72995_K) {
            p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76444_x.field_76415_H, 6000, 9));
        }

        if (p_77849_1_.func_77960_j() > 0) {
            if (!p_77849_2_.field_72995_K) {
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 1200, 9));
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, 3000, 2));
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 6000, 2));
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, 6000, 0));
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76424_c.field_76415_H, 6000, 1));
                p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76422_e.field_76415_H, 6000, 1));
            }
        } else if (!p_77849_2_.field_72995_K) {
            p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 100, 2));
            p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 2000, 0));
            p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76426_n.field_76415_H, 2000, 0));
            p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76424_c.field_76415_H, 2000, 0));
            p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76422_e.field_76415_H, 2000, 0));
        }

    }

    @SideOnly(Side.CLIENT)
    public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_) {
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 0));
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 1));
    }
}
