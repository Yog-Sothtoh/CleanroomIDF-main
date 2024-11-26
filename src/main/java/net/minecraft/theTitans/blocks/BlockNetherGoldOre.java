//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.blocks;

import java.util.Random;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockNetherGoldOre extends BlockOre {
    private Random rand = new Random();

    public BlockNetherGoldOre(Material materialIn) {
        this.setHarvestLevel("pickaxe", 2);
        this.func_149711_c(3.0F);
        this.func_149752_b(5.0F);
        this.func_149647_a(TheTitans.titansTab);
        this.func_149663_c("nether_gold_ore");
        this.func_149658_d("thetitans:nether_gold_ore");
        this.func_149672_a(field_149780_i);
    }

    public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Items.field_151043_k;
    }

    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) {
        return MathHelper.func_76136_a(this.rand, 2, 5);
    }

    public int func_149679_a(int p_149679_1_, Random p_149679_2_) {
        if (p_149679_1_ > 0 && Item.func_150898_a(this) != this.func_149650_a(0, p_149679_2_, p_149679_1_)) {
            int j = p_149679_2_.nextInt(p_149679_1_ + 2) - 1;
            if (j < 0) {
                j = 0;
            }

            return this.func_149745_a(p_149679_2_) * (j + 1);
        } else {
            return this.func_149745_a(p_149679_2_);
        }
    }
}
