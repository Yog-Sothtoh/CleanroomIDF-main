//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.theTitans.TheTitans;

public class ItemCustomPickaxe extends ItemPickaxe {
    public ItemCustomPickaxe(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.func_111206_d("thetitans:" + unlocalizedName);
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
    }
}
