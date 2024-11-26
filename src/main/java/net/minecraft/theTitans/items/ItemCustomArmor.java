//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;

public class ItemCustomArmor extends ItemArmor {
    private String armorName;

    public ItemCustomArmor(String unlocalizedName, ItemArmor.ArmorMaterial material, int type, String baseArmorName) {
        super(material, 0, type);
        this.armorName = baseArmorName;
        this.func_77655_b(unlocalizedName);
        this.func_111206_d("thetitans:" + unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
    }

    public ItemCustomArmor(ItemArmor.ArmorMaterial material, int i, int type) {
        super(material, 0, type);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "thetitans:textures/models/armor/" + this.armorName + (this.field_77881_a == 2 ? "2" : "1") + ".png";
    }
}
