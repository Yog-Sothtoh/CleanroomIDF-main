//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import java.util.List;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.theTitans.world.WorldProviderNowhere;
import net.minecraft.theTitans.world.WorldProviderVoid;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;

public class ItemTeleporter2 extends Item {
    public ItemTeleporter2(String unlocalizedName) {
        this.field_77777_bU = 1;
        this.func_111206_d("thetitans:teleporter2");
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
    }

    public ItemStack func_77659_a(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if (!worldIn.field_72995_K) {
            if (playerIn.field_70170_p.field_73011_w instanceof WorldProviderEnd) {
                List list = playerIn.field_70170_p.func_72872_a(EntityDragon.class, playerIn.field_70121_D.func_72314_b((double)256.0F, (double)256.0F, (double)256.0F));
                if (list != null && playerIn.field_71088_bW <= 0) {
                    if (!list.isEmpty()) {
                        playerIn.func_145747_a(new ChatComponentText("(The Ender Dragon is blocking the use of the Item)"));
                        playerIn.field_71088_bW = 20;
                    } else if (playerIn.field_70165_t > (double)5.0F && playerIn.field_70165_t < (double)-5.0F && playerIn.field_70161_v > (double)5.0F && playerIn.field_70161_v < (double)-5.0F) {
                        playerIn.func_145747_a(new ChatComponentText("(The item resinates, but nothing happens)"));
                        playerIn.field_71088_bW = 20;
                    } else if (list.isEmpty() && playerIn.field_70165_t < (double)5.0F && playerIn.field_70165_t > (double)-5.0F && playerIn.field_70161_v < (double)5.0F && playerIn.field_70161_v > (double)-5.0F) {
                        playerIn.func_145747_a(new ChatComponentText("(A rush of energy surges through you as you are sent to another realm.)"));
                        playerIn.field_70181_x = (double)3.0F;
                        playerIn.func_71027_c(201);
                        playerIn.field_71088_bW = 300;
                        playerIn.func_71029_a(TitansAchievments.nowhereTime);
                        return itemStackIn;
                    }
                }
            } else if (playerIn.field_70170_p.field_73011_w instanceof WorldProviderHell) {
                playerIn.func_145747_a(new ChatComponentText("(All you hear is the sounds of the Nether.)"));
            } else if (playerIn.field_70170_p.field_73011_w instanceof WorldProviderVoid) {
                playerIn.func_145747_a(new ChatComponentText("(Some great all-powerful force stops you from leaving.)"));
            } else if (playerIn.field_70170_p.field_73011_w instanceof WorldProviderNowhere) {
                playerIn.func_145747_a(new ChatComponentText("(The item fails to function.)"));
            } else if (!(playerIn.field_70170_p.field_73011_w instanceof WorldProviderVoid) && !(playerIn.field_70170_p.field_73011_w instanceof WorldProviderHell) && !(playerIn.field_70170_p.field_73011_w instanceof WorldProviderEnd)) {
                playerIn.func_145747_a(new ChatComponentText("(The item appears to resinate with quantum energy.)"));
            }
        }

        itemStackIn.func_77942_o();
        playerIn.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
        return itemStackIn;
    }
}
