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

public class EnchantmentUnstablility extends Enchantment {
    public EnchantmentUnstablility(int p_i45768_1_, ResourceLocation p_i45768_2_, int p_i45768_3_, EnumEnchantmentType weapon) {
        super(p_i45768_1_, p_i45768_3_, weapon);
        this.func_77322_b("unstablility");
    }

    public int func_77321_a(int enchantmentLevel) {
        return enchantmentLevel * 15;
    }

    public int func_77317_b(int enchantmentLevel) {
        return super.func_77321_a(enchantmentLevel) + 50;
    }

    public int func_77325_b() {
        return 2;
    }

    public String func_77320_a() {
        return "enchantment.turretunstable";
    }

    public void func_151368_a(EntityLivingBase user, Entity target, int level) {
        boolean flag = user.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
        user.field_70170_p.func_72876_a(user, target.field_70165_t, target.field_70163_u, target.field_70161_v, 1.0F + 0.75F * (float)level, flag);
    }
}
