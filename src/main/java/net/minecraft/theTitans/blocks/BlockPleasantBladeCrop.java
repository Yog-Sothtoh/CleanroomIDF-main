//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.blocks;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.BlockCrops;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.world.World;

public class BlockPleasantBladeCrop extends BlockCrops {
    public BlockPleasantBladeCrop() {
        this.func_149676_a(0.375F, 0.0F, 0.375F, 0.625F, 1.0F, 0.625F);
    }

    protected Item func_149866_i() {
        return TitanItems.pleasantBladeSeed;
    }

    protected Item func_149865_P() {
        return TitanItems.pleasantBladeFlower;
    }

    public int func_149645_b() {
        return 1;
    }

    public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
        int l = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
        if (l >= 7 && p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) <= 7) {
            --l;
            p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, l, 3);
            this.func_149855_e(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
        } else {
            super.func_149674_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
        }

    }

    public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        this.func_150036_b(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_);
        return super.func_149727_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
    }

    public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {
        this.func_150036_b(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_, p_149699_5_);
        super.func_149699_a(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_, p_149699_5_);
    }

    private void func_150036_b(World p_150036_1_, int p_150036_2_, int p_150036_3_, int p_150036_4_, EntityPlayer p_150036_5_) {
        int l = p_150036_1_.func_72805_g(p_150036_2_, p_150036_3_, p_150036_4_);
        if (l >= 7) {
            p_150036_5_.func_71038_i();
            if (!p_150036_1_.field_72995_K) {
                EntityItem entityitem = new EntityItem(p_150036_1_, p_150036_5_.field_70165_t, p_150036_5_.field_70163_u + (double)1.0F, p_150036_5_.field_70161_v, new ItemStack(this.func_149865_P()));
                p_150036_1_.func_72838_d(entityitem);
                p_150036_1_.func_72921_c(p_150036_2_, p_150036_3_, p_150036_4_, 6, 2);
            }
        }

    }

    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);
        if (metadata >= 6) {
            for(int i = 0; i < 1 + world.field_73012_v.nextInt(3) + fortune; ++i) {
                ret.add(new ItemStack(TitanItems.pleasantBladeLeaf, 1, 0));
            }
        }

        if (metadata >= 7) {
            ret.add(new ItemStack(TitanItems.pleasantBladeSeed, 1, 0));
        }

        return ret;
    }
}
