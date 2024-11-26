//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.ench;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class EnchantmentKnockup extends Enchantment {
    public EnchantmentKnockup(int p_i45768_1_, ResourceLocation p_i45768_2_, int p_i45768_3_) {
        super(p_i45768_1_, p_i45768_3_, EnumEnchantmentType.weapon);
    }

    public String func_77320_a() {
        return "enchantment.knockup";
    }

    public int func_77321_a(int enchantmentLevel) {
        return 5 + 20 * (enchantmentLevel - 1);
    }

    public int func_77317_b(int enchantmentLevel) {
        return super.func_77321_a(enchantmentLevel) + 50;
    }

    public int func_77325_b() {
        return 2;
    }

    public void func_151368_a(EntityLivingBase user, Entity target, int level) {
        target.field_70181_x += (double)(1.0F * (float)level);
    }
}
