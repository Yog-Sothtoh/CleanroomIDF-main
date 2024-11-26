//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHarcadiumBlock extends Block {
    public BlockHarcadiumBlock(Material materialIn, String name) {
        super(materialIn);
        this.setHarvestLevel("pickaxe", 3);
        this.func_149711_c(100.0F);
        this.func_149752_b(18000.0F);
        this.func_149715_a(1.0F);
        this.func_149647_a(TheTitans.titansTab);
        this.func_149663_c(name);
        this.func_149658_d("thetitans:" + name);
        this.func_149672_a(field_149777_j);
    }

    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
        return !(entity instanceof EntityDragon);
    }

    public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
        return true;
    }

    public int func_149738_a(World p_149738_1_) {
        return 30;
    }

    public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
        this.func_149734_b(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
    }

    @SideOnly(Side.CLIENT)
    public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
        this.func_150186_m(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_);
        if (p_149734_5_.nextInt(10) == 0) {
            p_149734_1_.func_72980_b((double)((float)p_149734_2_ + 0.5F), (double)((float)p_149734_3_ + 0.5F), (double)((float)p_149734_4_ + 0.5F), "thetitans:harcadiumBlockHum", 2.0F, 1.0F, false);
        }

    }

    private void func_150186_m(World p_150186_1_, int p_150186_2_, int p_150186_3_, int p_150186_4_) {
        Random random = p_150186_1_.field_73012_v;
        double d0 = (double)0.0625F;

        for(int l = 0; l < 6; ++l) {
            double d1 = (double)((float)p_150186_2_ + random.nextFloat());
            double d2 = (double)((float)p_150186_3_ + random.nextFloat());
            double d3 = (double)((float)p_150186_4_ + random.nextFloat());
            if (l == 0 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_ + 1, p_150186_4_).func_149662_c()) {
                d2 = (double)(p_150186_3_ + 1) + d0;
            }

            if (l == 1 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_ - 1, p_150186_4_).func_149662_c()) {
                d2 = (double)(p_150186_3_ + 0) - d0;
            }

            if (l == 2 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_, p_150186_4_ + 1).func_149662_c()) {
                d3 = (double)(p_150186_4_ + 1) + d0;
            }

            if (l == 3 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_, p_150186_4_ - 1).func_149662_c()) {
                d3 = (double)(p_150186_4_ + 0) - d0;
            }

            if (l == 4 && !p_150186_1_.func_147439_a(p_150186_2_ + 1, p_150186_3_, p_150186_4_).func_149662_c()) {
                d1 = (double)(p_150186_2_ + 1) + d0;
            }

            if (l == 5 && !p_150186_1_.func_147439_a(p_150186_2_ - 1, p_150186_3_, p_150186_4_).func_149662_c()) {
                d1 = (double)(p_150186_2_ + 0) - d0;
            }

            if (d1 < (double)p_150186_2_ || d1 > (double)(p_150186_2_ + 1) || d2 < (double)0.0F || d2 > (double)(p_150186_3_ + 1) || d3 < (double)p_150186_4_ || d3 > (double)(p_150186_4_ + 1)) {
                p_150186_1_.func_72869_a("portal", d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
                p_150186_1_.func_72869_a("portal", d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
                p_150186_1_.func_72869_a("portal", d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
                p_150186_1_.func_72869_a("portal", d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
                p_150186_1_.func_72869_a("portal", d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
                p_150186_1_.func_72869_a("portal", d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
                p_150186_1_.func_72869_a("portal", d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
                p_150186_1_.func_72869_a("portal", d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
                p_150186_1_.func_72869_a("portal", d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
            }
        }

    }
}
