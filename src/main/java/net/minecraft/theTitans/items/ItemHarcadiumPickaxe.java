//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;

public class ItemHarcadiumPickaxe extends ItemPickaxe {
    public ItemHarcadiumPickaxe(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.func_111206_d("thetitans:harcadium_pickaxe");
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
    }

    public boolean func_77644_a(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.func_77972_a(1, attacker);
        if (target != null && (target.field_70131_O >= 6.0F || target instanceof EntityTitan || !target.field_70122_E)) {
            target.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(attacker), 400.0F);
            target.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
        }

        return true;
    }
}
