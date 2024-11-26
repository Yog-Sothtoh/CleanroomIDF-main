//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.IBlockAccess;

public class BlockCompactBedrock extends Block {
    public BlockCompactBedrock(Material materialIn, String name) {
        super(materialIn);
        this.setHarvestLevel("pickaxe", 10000);
        this.func_149711_c(-1.0F);
        this.func_149752_b(1.8E8F);
        this.func_149647_a(TheTitans.titansTab);
        this.func_149663_c(name);
        this.func_149658_d("thetitans:" + name);
        this.func_149672_a(field_149769_e);
    }

    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
        return false;
    }
}
