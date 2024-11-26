//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.blocks;

import java.util.Random;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockNetherStoneOre extends BlockOre {
    private Random rand = new Random();

    public BlockNetherStoneOre(Material materialIn) {
        this.setHarvestLevel("pickaxe", 0);
        this.func_149711_c(1.5F);
        this.func_149752_b(10.0F);
        this.func_149647_a(TheTitans.titansTab);
        this.func_149663_c("nether_stone_ore");
        this.func_149658_d("thetitans:nether_stone_ore");
        this.func_149672_a(field_149780_i);
    }

    public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.func_150898_a(Blocks.field_150347_e);
    }

    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) {
        return MathHelper.func_76136_a(this.rand, 0, 1);
    }
}
