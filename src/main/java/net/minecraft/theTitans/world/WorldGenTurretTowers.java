//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.world;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.titan.EntityWitherTurret;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTurretTowers extends WorldGenerator {
    private Block field_150520_a;

    public WorldGenTurretTowers(Block p_i45464_1_) {
        this.field_150520_a = p_i45464_1_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        if (p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_) && p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_) == this.field_150520_a) {
            int l = p_76484_2_.nextInt(2) + 4;
            int i1 = p_76484_2_.nextInt(1) + 1;

            for(int j1 = p_76484_3_ - i1; j1 <= p_76484_3_ + i1; ++j1) {
                for(int k1 = p_76484_5_ - i1; k1 <= p_76484_5_ + i1; ++k1) {
                    int l1 = j1 - p_76484_3_;
                    int i2 = k1 - p_76484_5_;
                    if (l1 * l1 + i2 * i2 <= i1 * i1 + 1 && p_76484_1_.func_147439_a(j1, p_76484_4_ - 1, k1) != this.field_150520_a) {
                        return false;
                    }
                }
            }

            for(int j1 = p_76484_4_; j1 < p_76484_4_ + l && j1 < 256; ++j1) {
                for(int k1 = p_76484_3_ - i1; k1 <= p_76484_3_ + i1; ++k1) {
                    for(int l1 = p_76484_5_ - i1; l1 <= p_76484_5_ + i1; ++l1) {
                        int i2 = k1 - p_76484_3_;
                        int j2 = l1 - p_76484_5_;
                        if (i2 * i2 + j2 * j2 <= i1 * i1 + 1) {
                            p_76484_1_.func_147465_d(k1, j1, l1, Blocks.field_150357_h, 0, 2);
                        }
                    }
                }
            }

            EntityWitherTurret entityendercrystal = new EntityWitherTurret(p_76484_1_);
            entityendercrystal.func_70012_b((double)((float)p_76484_3_ + 0.5F), (double)(p_76484_4_ + l), (double)((float)p_76484_5_ + 0.5F), p_76484_2_.nextFloat() * 360.0F, 0.0F);
            p_76484_1_.func_72838_d(entityendercrystal);
            return true;
        } else {
            return false;
        }
    }
}
