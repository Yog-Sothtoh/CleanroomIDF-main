//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.ench;

import java.util.Random;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class EnchantmentDurability extends Enchantment {
    public EnchantmentDurability(int p_i45768_1_, ResourceLocation p_i45768_2_, int p_i45768_3_, EnumEnchantmentType weapon) {
        super(p_i45768_1_, p_i45768_3_, weapon);
        this.func_77322_b("durability");
    }

    public int func_77321_a(int enchantmentLevel) {
        return 5 + (enchantmentLevel - 1) * 8;
    }

    public int func_77317_b(int enchantmentLevel) {
        return super.func_77321_a(enchantmentLevel) + 50;
    }

    public int func_77325_b() {
        return 5;
    }

    public String func_77320_a() {
        return "enchantment.turretdurability";
    }

    public static boolean negateDamage(ItemStack p_92097_0_, int p_92097_1_, Random p_92097_2_) {
        return !(p_92097_0_.func_77973_b() instanceof ItemArmor) || p_92097_2_.nextFloat() >= 0.6F;
    }
}
