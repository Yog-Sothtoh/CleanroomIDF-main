//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.World;

public class ItemPleasantBladeBrew extends Item {
    public ItemPleasantBladeBrew() {
        this.func_77655_b("pleasant_blade_brew");
        this.func_111206_d("thetitans:pleasant_blade_brew");
        this.func_77637_a(TheTitans.titansTab);
    }

    public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
        if (!p_77654_3_.field_71075_bZ.field_75098_d) {
            --p_77654_1_.field_77994_a;
        }

        if (!p_77654_2_.field_72995_K) {
            p_77654_3_.func_82170_o(Potion.field_76436_u.field_76415_H);
            p_77654_3_.func_82170_o(Potion.field_76438_s.field_76415_H);
            p_77654_3_.func_82170_o(Potion.field_76431_k.field_76415_H);
            p_77654_3_.func_82170_o(Potion.field_82731_v.field_76415_H);
        }

        return p_77654_1_.field_77994_a <= 0 ? new ItemStack(Items.field_151069_bo) : p_77654_1_;
    }

    public int func_77626_a(ItemStack p_77626_1_) {
        return 32;
    }

    public EnumAction func_77661_b(ItemStack p_77661_1_) {
        return EnumAction.drink;
    }

    public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
        p_77659_3_.func_71008_a(p_77659_1_, this.func_77626_a(p_77659_1_));
        return p_77659_1_;
    }
}
