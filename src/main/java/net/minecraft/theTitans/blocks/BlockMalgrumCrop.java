//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.blocks;

import java.util.Random;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.world.World;

public class BlockMalgrumCrop extends BlockCrops {
    public BlockMalgrumCrop() {
        this.func_149676_a(0.375F, 0.0F, 0.375F, 0.625F, 1.0F, 0.625F);
    }

    protected Item func_149866_i() {
        return TitanItems.malgrumSeeds;
    }

    protected Item func_149865_P() {
        return TitanItems.malgrum;
    }

    public int func_149645_b() {
        return 1;
    }

    public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
        super.func_149674_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
        int l = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
        if (l < 7 && p_149674_5_.nextInt(2 * (1 + l)) == 0) {
            ++l;
            p_149674_1_.func_72921_c(p_149674_2_, p_149674_3_, p_149674_4_, l, 2);
        }

    }
}
