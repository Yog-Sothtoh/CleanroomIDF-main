//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

public class ItemEggWitherzilla extends Item {
    public ItemEggWitherzilla(String unlocalizedName) {
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
        this.func_111206_d("thetitans:eggwitherzilla");
    }

    public boolean func_77648_a(ItemStack stack, EntityPlayer playerIn, World worldIn, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        EntityWitherzilla entity = new EntityWitherzilla(worldIn);
        Block block = worldIn.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
        p_77648_4_ += Facing.field_71586_b[p_77648_7_];
        p_77648_5_ += Facing.field_71587_c[p_77648_7_];
        p_77648_6_ += Facing.field_71585_d[p_77648_7_];
        double d0 = (double)0.0F;
        if (p_77648_7_ == 1 && block.func_149645_b() == 11) {
            d0 = (double)0.5F;
        }

        entity.func_110161_a((IEntityLivingData)null);
        entity.func_70012_b((double)p_77648_4_ + (double)0.5F, (double)p_77648_5_ + d0, (double)p_77648_6_ + (double)0.5F, 0.0F, 0.0F);
        if (!worldIn.field_72995_K) {
            worldIn.func_72838_d(entity);
        }

        if (entity != null && !worldIn.field_72995_K) {
            playerIn.func_145747_a(new ChatComponentText("Thank you for breaking the seal..."));
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_85030_a("random.break", 10000.0F, 0.5F);
            entity.func_70642_aH();
            playerIn.field_71071_by.func_146026_a(TitanItems.eggWitherzilla);
        }

        return true;
    }

    public EnumRarity func_77613_e(ItemStack stack) {
        return EnumRarity.epic;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_77636_d(ItemStack stack) {
        return true;
    }
}
