//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemPleasantBladeFlower extends ItemFood {
    public ItemPleasantBladeFlower(int p_i45341_1_, float p_i45341_2_, boolean p_i45341_3_) {
        super(p_i45341_1_, p_i45341_2_, p_i45341_3_);
    }

    public EnumRarity func_77613_e(ItemStack p_77613_1_) {
        return EnumRarity.rare;
    }

    public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
        if (!p_77654_2_.field_72995_K) {
            p_77654_3_.func_82170_o(Potion.field_76440_q.field_76415_H);
            p_77654_3_.func_82170_o(Potion.field_76431_k.field_76415_H);
            p_77654_3_.func_82170_o(Potion.field_76421_d.field_76415_H);
            p_77654_3_.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 1000, 1));
            p_77654_3_.func_70691_i(2.0F);
        }

        return super.func_77654_b(p_77654_1_, p_77654_2_, p_77654_3_);
    }

    public int func_77626_a(ItemStack p_77626_1_) {
        return 16;
    }

    public EnumAction func_77661_b(ItemStack p_77661_1_) {
        return EnumAction.eat;
    }
}
