//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class BlockOreEgg extends Block {
    public BlockOreEgg(String name) {
        super(Material.field_151578_c);
        this.func_149711_c(0.5F);
        this.func_149752_b(1.0F);
        this.func_149672_a(Block.field_149767_g);
        this.func_149647_a(CreativeTabs.field_78030_b);
        this.func_149663_c(name);
        this.func_149658_d("thetitans:" + name);
    }

    public void func_149690_a(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
        super.func_149690_a(par1World, par2, par3, par4, par5, par6, par7);
        int j1 = 5 + par1World.field_73012_v.nextInt(3) + par1World.field_73012_v.nextInt(3);
        if (par1World.field_73012_v.nextInt(2) == 1) {
            this.func_149657_c(par1World, par2, par3, par4, j1);
        }

    }

    public boolean func_149662_c() {
        return true;
    }

    public boolean func_149686_d() {
        return true;
    }
}
