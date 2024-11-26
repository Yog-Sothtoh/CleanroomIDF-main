//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.ench;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class EnchantmentManiac extends Enchantment {
    public EnchantmentManiac(int p_i45768_1_, ResourceLocation p_i45768_2_, int p_i45768_3_, EnumEnchantmentType weapon) {
        super(p_i45768_1_, p_i45768_3_, weapon);
        this.func_77322_b("maniac");
    }

    public int func_77321_a(int enchantmentLevel) {
        return 12 + (enchantmentLevel - 1) * 20;
    }

    public int func_77317_b(int enchantmentLevel) {
        return super.func_77321_a(enchantmentLevel) + 50;
    }

    public int func_77325_b() {
        return 3;
    }

    public String func_77320_a() {
        return "enchantment.turretmaniac";
    }

    public float func_152376_a(int level, EnumCreatureAttribute creatureType) {
        return (float)level * 3.0F;
    }

    public void func_151368_a(EntityLivingBase user, Entity target, int level) {
        user.func_70690_d(new PotionEffect(Potion.field_76424_c.field_76415_H, 20 * 10 * level, level));
        user.func_70690_d(new PotionEffect(Potion.field_76422_e.field_76415_H, 20 * 10 * level, level));
    }
}
