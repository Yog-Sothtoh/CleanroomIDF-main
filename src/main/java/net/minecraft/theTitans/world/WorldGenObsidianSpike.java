//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.world;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenObsidianSpike extends WorldGenerator {
    public WorldGenObsidianSpike() {
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        while(p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_) && p_76484_4_ > 0) {
            --p_76484_4_;
        }

        if (p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_) != Blocks.field_150343_Z) {
            return false;
        } else {
            int l = p_76484_2_.nextInt(15) + 5;
            int i1 = l / 4 + p_76484_2_.nextInt(2);
            if (i1 > 1 && p_76484_2_.nextInt(50) == 0) {
                if (p_76484_2_.nextFloat() > 0.5F) {
                    p_76484_4_ += 30 + p_76484_2_.nextInt(30);
                } else {
                    l += 140;
                }
            }

            for(int j1 = 0; j1 < l; ++j1) {
                float f = (1.0F - (float)j1 / (float)l) * (float)i1;
                int k1 = MathHelper.func_76123_f(f);

                for(int l1 = -k1; l1 <= k1; ++l1) {
                    float f1 = (float)MathHelper.func_76130_a(l1) - 0.25F;

                    for(int i2 = -k1; i2 <= k1; ++i2) {
                        float f2 = (float)MathHelper.func_76130_a(i2) - 0.25F;
                        if ((l1 == 0 && i2 == 0 || f1 * f1 + f2 * f2 <= f * f) && (l1 != -k1 && l1 != k1 && i2 != -k1 && i2 != k1 || p_76484_2_.nextFloat() <= 0.75F)) {
                            Block block = p_76484_1_.func_147439_a(p_76484_3_ + l1, p_76484_4_ + j1, p_76484_5_ + i2);
                            if (block.func_149688_o() == Material.field_151579_a || block == Blocks.field_150343_Z) {
                                this.func_150515_a(p_76484_1_, p_76484_3_ + l1, p_76484_4_ + j1, p_76484_5_ + i2, Blocks.field_150343_Z);
                            }

                            if (j1 != 0 && k1 > 1) {
                                block = p_76484_1_.func_147439_a(p_76484_3_ + l1, p_76484_4_ - j1, p_76484_5_ + i2);
                                if (block.func_149688_o() == Material.field_151579_a || block == Blocks.field_150343_Z) {
                                    this.func_150515_a(p_76484_1_, p_76484_3_ + l1, p_76484_4_ - j1, p_76484_5_ + i2, Blocks.field_150343_Z);
                                }
                            }
                        }
                    }
                }
            }

            int var16 = i1 - 1;
            if (var16 < 0) {
                var16 = 0;
            } else if (var16 > 1) {
                var16 = 1;
            }

            for(int j2 = -var16; j2 <= var16; ++j2) {
                for(int k1 = -var16; k1 <= var16; ++k1) {
                    int l1 = p_76484_4_ - 1;
                    int k2 = 50;
                    if (Math.abs(j2) == 1 && Math.abs(k1) == 1) {
                        k2 = p_76484_2_.nextInt(5);
                    }

                    while(l1 > 50) {
                        Block block1 = p_76484_1_.func_147439_a(p_76484_3_ + j2, l1, p_76484_5_ + k1);
                        if (block1.func_149688_o() != Material.field_151579_a && block1 != Blocks.field_150343_Z) {
                            break;
                        }

                        this.func_150515_a(p_76484_1_, p_76484_3_ + j2, l1, p_76484_5_ + k1, Blocks.field_150343_Z);
                        --l1;
                        --k2;
                        if (k2 <= 0) {
                            l1 -= p_76484_2_.nextInt(5) + 1;
                            k2 = p_76484_2_.nextInt(5);
                        }
                    }
                }
            }

            return true;
        }
    }
}
