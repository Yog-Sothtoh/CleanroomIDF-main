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

public class ItemTeleporter extends Item {
    public ItemTeleporter(String unlocalizedName) {
        this.field_77777_bU = 1;
        this.func_111206_d("thetitans:teleporter");
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
    }

    public ItemStack func_77659_a(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if (!worldIn.field_72995_K) {
            if (playerIn.field_70170_p.field_73011_w instanceof WorldProviderEnd) {
                List list = playerIn.field_70170_p.func_72872_a(EntityDragon.class, playerIn.field_70121_D.func_72314_b((double)256.0F, (double)256.0F, (double)256.0F));
                if (list != null && playerIn.field_71088_bW <= 0) {
                    if (!list.isEmpty()) {
                        playerIn.func_145747_a(new ChatComponentText("I can't do that when the Ender Dragon's still here! Kill it first."));
                        playerIn.field_71088_bW = 20;
                    } else if (playerIn.field_70165_t > (double)5.0F && playerIn.field_70165_t < (double)-5.0F && playerIn.field_70161_v > (double)5.0F && playerIn.field_70161_v < (double)-5.0F) {
                        playerIn.func_145747_a(new ChatComponentText("I can't do that this far away from the center of the island. Get closer."));
                        playerIn.field_71088_bW = 20;
                    } else if (list.isEmpty() && playerIn.field_70165_t < (double)5.0F && playerIn.field_70165_t > (double)-5.0F && playerIn.field_70161_v < (double)5.0F && playerIn.field_70161_v > (double)-5.0F) {
                        playerIn.func_145747_a(new ChatComponentText("Master! More food is coming for you!"));
                        playerIn.field_70181_x = (double)3.0F;
                        playerIn.func_71027_c(200);
                        playerIn.field_71088_bW = 300;
                        playerIn.func_71029_a(TitansAchievments.voidTime);
                        return itemStackIn;
                    }
                }
            } else if (playerIn.field_70170_p.field_73011_w instanceof WorldProviderHell) {
                playerIn.func_145747_a(new ChatComponentText("(You hear the distant crys of a long, forgotten voice. It's very ancient.)"));
            } else if (playerIn.field_70170_p.field_73011_w instanceof WorldProviderVoid) {
                playerIn.func_145747_a(new ChatComponentText("Stop talking to me and feed my Master!"));
            } else if (playerIn.field_70170_p.field_73011_w instanceof WorldProviderNowhere) {
                playerIn.func_145747_a(new ChatComponentText("Why have you brought me here? Get me out!"));
            } else if (!(playerIn.field_70170_p.field_73011_w instanceof WorldProviderVoid) && !(playerIn.field_70170_p.field_73011_w instanceof WorldProviderHell) && !(playerIn.field_70170_p.field_73011_w instanceof WorldProviderEnd)) {
                playerIn.func_145747_a(new ChatComponentText("(The ancient crys still abode. It's as if they are saying 'All things must End')"));
            }
        }

        itemStackIn.func_77942_o();
        playerIn.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
        return itemStackIn;
    }
}
