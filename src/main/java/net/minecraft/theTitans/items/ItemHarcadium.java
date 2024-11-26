//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.world.World;

public class ItemHarcadium extends Item {
    public ItemHarcadium(String unlocalizedName) {
        this.func_111206_d("thetitans:" + unlocalizedName);
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
    }

    @SideOnly(Side.CLIENT)
    public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
        super.func_77624_a(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
        p_77624_3_.add("§lElement #753");
        p_77624_3_.add("§lIncredibly durable.");
        p_77624_3_.add("§lThe stuff ender pearls are made of.");
    }

    public void func_77663_a(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof EntityPlayer) {
            ((EntityPlayer)entityIn).func_71029_a(TitansAchievments.harcadium);
        }

        super.func_77663_a(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
