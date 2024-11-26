//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.world.World;

public class ItemVoid extends Item {
    public ItemVoid(String unlocalizedName) {
        this.func_111206_d("thetitans:" + unlocalizedName);
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
    }

    public void func_77663_a(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof EntityPlayer) {
            ((EntityPlayer)entityIn).func_71029_a(TitansAchievments.voidEssence);
        }

        super.func_77663_a(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
