//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.ench;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.util.ResourceLocation;

public class EnchantmentFerocity extends Enchantment {
    public EnchantmentFerocity(int p_i45768_1_, ResourceLocation p_i45768_2_, int p_i45768_3_, EnumEnchantmentType weapon) {
        super(p_i45768_1_, p_i45768_3_, weapon);
        this.func_77322_b("ferocity");
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
        return "enchantment.turretferocity";
    }

    public float func_152376_a(int level, EnumCreatureAttribute creatureType) {
        return (float)level * 2.0F;
    }
}
