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
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.util.ResourceLocation;

public class EnchantmentTitanSlayer extends Enchantment {
    public EnchantmentTitanSlayer(int enchID, ResourceLocation enchName, int enchWeight) {
        super(enchID, enchWeight, EnumEnchantmentType.weapon);
    }

    public int func_77321_a(int enchantmentLevel) {
        return 1 + (enchantmentLevel - 1) * 3;
    }

    public int func_77317_b(int enchantmentLevel) {
        return super.func_77321_a(enchantmentLevel) + 30;
    }

    public int func_77325_b() {
        return 10;
    }

    public String func_77320_a() {
        return "enchantment.damage.titanSlayer";
    }

    public boolean func_92089_a(ItemStack stack) {
        return stack.func_77973_b() instanceof ItemAxe ? true : super.func_92089_a(stack);
    }

    public float func_152376_a(int level, EnumCreatureAttribute creatureType) {
        return 25.0F;
    }

    public void func_151368_a(EntityLivingBase user, Entity target, int level) {
        float f = (float)user.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
        if (target instanceof EntityLivingBase) {
            EntityLivingBase entitylivingbase1 = (EntityLivingBase)target;
            if (target.field_70131_O >= 6.0F || target instanceof EntityTitan || !target.field_70122_E) {
                entitylivingbase1.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(user), f + (float)level * 100.0F);
                entitylivingbase1.func_85030_a("thetitans:titanpunch", 2.0F, 1.0F);
            }
        }

    }
}
