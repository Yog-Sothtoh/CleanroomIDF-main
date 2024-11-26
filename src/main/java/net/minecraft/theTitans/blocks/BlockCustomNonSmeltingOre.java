//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.blocks;

import java.util.Random;
import net.minecraft.block.BlockOre;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanBlocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockCustomNonSmeltingOre extends BlockOre {
    private Item droppingItem;
    private int minXP;
    private int maxXP;
    private Random rand = new Random();

    public BlockCustomNonSmeltingOre(int harvestLevel, String name, float hardness, float resistance, Item item, int minxp, int maxxp) {
        this.droppingItem = item;
        this.minXP = minxp;
        this.maxXP = maxxp;
        this.setHarvestLevel("pickaxe", harvestLevel);
        this.func_149647_a(TheTitans.titansTab);
        this.func_149663_c(name);
        this.func_149658_d("thetitans:" + name);
        this.func_149672_a(field_149780_i);
        this.func_149711_c(hardness);
        this.func_149752_b(resistance);
    }

    public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return this.droppingItem;
    }

    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
        return this == TitanBlocks.adamantium_ore ? false : super.canEntityDestroy(world, x, y, z, entity);
    }

    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) {
        return MathHelper.func_76136_a(this.rand, this.minXP, this.maxXP);
    }
}
