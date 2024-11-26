//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPerch extends BlockDragonEgg {
    public BlockPerch(String blockname, String texture, float hardness, float resistance) {
        this.func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
        this.func_149711_c(hardness);
        this.func_149752_b(resistance);
        this.func_149672_a(field_149780_i);
        this.func_149663_c(blockname);
        this.func_149658_d(texture);
        this.func_149647_a(TheTitans.titansTab);
    }

    public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
    }

    public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
    }

    public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
    }

    public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        return true;
    }

    public void func_149699_a(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {
    }

    public int func_149738_a(World p_149738_1_) {
        return 10;
    }

    public boolean func_149662_c() {
        return false;
    }

    public boolean func_149686_d() {
        return false;
    }

    public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
        int l = MathHelper.func_76128_c((double)(p_149689_5_.field_70177_z * 4.0F / 360.0F) + (double)0.5F) & 3;
        int i1 = p_149689_1_.func_72805_g(p_149689_2_, p_149689_3_, p_149689_4_) >> 2;
        ++l;
        l %= 4;
        if (l == 0) {
            p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 2 | i1 << 2, 2);
        }

        if (l == 1) {
            p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 3 | i1 << 2, 2);
        }

        if (l == 2) {
            p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 0 | i1 << 2, 2);
        }

        if (l == 3) {
            p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, 1 | i1 << 2, 2);
        }

    }

    @SideOnly(Side.CLIENT)
    public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
        return true;
    }

    public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
        return super.func_149718_j(p_149718_1_, p_149718_2_, p_149718_3_, p_149718_4_);
    }

    public int func_149645_b() {
        return 27;
    }

    @SideOnly(Side.CLIENT)
    public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
        return Item.func_150899_d(0);
    }
}
