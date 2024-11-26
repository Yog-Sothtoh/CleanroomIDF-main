//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.blocks;

import net.minecraft.block.BlockOre;
import net.minecraft.theTitans.TheTitans;

public class BlockCustomOre extends BlockOre {
    public BlockCustomOre(int harvestLevel, String name, float hardness, float resistance) {
        this.setHarvestLevel("pickaxe", harvestLevel);
        this.func_149647_a(TheTitans.titansTab);
        this.func_149663_c(name);
        this.func_149658_d("thetitans:" + name);
        this.func_149672_a(field_149780_i);
        this.func_149711_c(hardness);
        this.func_149752_b(resistance);
    }
}
