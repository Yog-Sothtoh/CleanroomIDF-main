//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityGrowthSerum;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.World;

public class ItemGrowthSerum extends Item {
    public ItemGrowthSerum(String unlocalizedName) {
        this.func_111206_d("thetitans:growth_serum");
        this.func_77655_b(unlocalizedName);
        this.field_77777_bU = 16;
        this.func_77637_a(TheTitans.titansTab);
    }

    public ItemStack func_77659_a(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if (!playerIn.field_71075_bZ.field_75098_d) {
            --itemStackIn.field_77994_a;
        }

        worldIn.func_72956_a(playerIn, "random.bow", 1.0F, 1.0F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.field_72995_K) {
            worldIn.func_72838_d(new EntityGrowthSerum(worldIn, playerIn));
        }

        playerIn.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
        return itemStackIn;
    }
}
