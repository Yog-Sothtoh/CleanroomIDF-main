//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityChaff;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.World;

public class ItemChaff extends Item {
    public ItemChaff(String unlocalizedName) {
        this.func_77655_b(unlocalizedName);
        this.field_77777_bU = 20;
        this.func_77637_a(TheTitans.titansTab);
        this.func_111206_d("thetitans:chaff");
    }

    public boolean func_77648_a(ItemStack stack, EntityPlayer playerIn, World worldIn, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (!playerIn.field_71075_bZ.field_75098_d) {
            --stack.field_77994_a;
        }

        EntityChaff entity1 = new EntityChaff(worldIn);
        EntityChaff entity2 = new EntityChaff(worldIn);
        if (!worldIn.field_72995_K) {
            entity1.func_70012_b(playerIn.field_70165_t + (double)6.0F, playerIn.field_70163_u + (double)3.0F, playerIn.field_70161_v + (double)6.0F, 0.0F, 0.0F);
            entity2.func_70012_b(playerIn.field_70165_t - (double)6.0F, playerIn.field_70163_u + (double)3.0F, playerIn.field_70161_v - (double)6.0F, 0.0F, 0.0F);
            worldIn.func_72838_d(entity1);
            worldIn.func_72838_d(entity2);
        }

        return true;
    }
}
