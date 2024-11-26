//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.world;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.TitanBlocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenSpikes;

public class BiomeNowhereDecorator extends BiomeDecorator {
    protected World worldObj;

    public BiomeNowhereDecorator() {
    }

    protected void func_150513_a(BiomeGenBase p_150513_1_) {
        this.func_76797_b();
        if (this.field_76813_b.nextInt(4) == 0) {
            int i = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            int j = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            int k = this.field_76815_a.func_72825_h(i, j);
            (new WorldGenSpikes(Blocks.field_150343_Z)).func_76484_a(this.field_76815_a, this.field_76813_b, i, k, j);
        }

        if (this.field_76813_b.nextInt(4) == 0) {
            int i = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            int j = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            int k = this.field_76815_a.func_72825_h(i, j);
            (new WorldGenObsidianSpike()).func_76484_a(this.field_76815_a, this.field_76813_b, i, k, j);
        }

        if (this.field_76813_b.nextInt(10) == 0) {
            int i = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            int j = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            int k = this.field_76815_a.func_72825_h(i, j);
            this.generateMelons(this.field_76815_a, this.field_76813_b, i, k, j);
        }

        if (this.field_76813_b.nextInt(10) == 0) {
            int i = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            int j = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            int k = this.field_76815_a.func_72825_h(i, j);
            this.generatePumpkins(this.field_76815_a, this.field_76813_b, i, k, j);
        }

        if (this.field_76813_b.nextInt(1000) == 0) {
            int i = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            int j = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            int k = this.field_76815_a.func_72825_h(i, j);
            this.generateDesertWell(this.field_76815_a, this.field_76813_b, i, k, j);
        }

        if (this.field_76814_c == 0 && this.field_76811_d == 0) {
            int k = this.field_76815_a.func_72825_h(this.field_76814_c, this.field_76811_d);
            this.field_76815_a.func_147465_d(0, k, 0, TitanBlocks.adamantium_ore, 0, 3);
            this.field_76815_a.func_147465_d(0, k + 1, 0, TitanBlocks.adamantium_ore, 0, 3);
        }

    }

    public boolean generateMelons(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        for(int l = 0; l < 64; ++l) {
            int i1 = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
            int j1 = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
            int k1 = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
            if (p_76484_1_.func_147437_c(i1, j1, k1) && Blocks.field_150440_ba.func_149742_c(p_76484_1_, i1, j1, k1) && p_76484_1_.func_147439_a(i1, j1 - 1, k1).func_149688_o().func_76220_a()) {
                p_76484_1_.func_147465_d(i1, j1, k1, Blocks.field_150440_ba, 0, 2);
            }
        }

        return true;
    }

    public boolean generatePumpkins(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        for(int l = 0; l < 64; ++l) {
            int i1 = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
            int j1 = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
            int k1 = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
            if (p_76484_1_.func_147437_c(i1, j1, k1) && Blocks.field_150423_aK.func_149742_c(p_76484_1_, i1, j1, k1) && p_76484_1_.func_147439_a(i1, j1 - 1, k1).func_149688_o().func_76220_a()) {
                p_76484_1_.func_147465_d(i1, j1, k1, Blocks.field_150423_aK, p_76484_2_.nextInt(4), 2);
            }
        }

        return true;
    }

    public boolean generateDesertWell(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        for(int l = -2; l <= 2; ++l) {
            for(int i1 = -2; i1 <= 2; ++i1) {
                if (p_76484_1_.func_147437_c(p_76484_3_ + l, p_76484_4_ - 1, p_76484_5_ + i1) && p_76484_1_.func_147437_c(p_76484_3_ + l, p_76484_4_ - 2, p_76484_5_ + i1)) {
                    return false;
                }
            }
        }

        for(int var9 = -1; var9 <= 0; ++var9) {
            for(int i1 = -2; i1 <= 2; ++i1) {
                for(int j1 = -2; j1 <= 2; ++j1) {
                    p_76484_1_.func_147465_d(p_76484_3_ + i1, p_76484_4_ + var9, p_76484_5_ + j1, Blocks.field_150322_A, 0, 2);
                }
            }
        }

        p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_, p_76484_5_, Blocks.field_150358_i, 0, 2);
        p_76484_1_.func_147465_d(p_76484_3_ - 1, p_76484_4_, p_76484_5_, Blocks.field_150358_i, 0, 2);
        p_76484_1_.func_147465_d(p_76484_3_ + 1, p_76484_4_, p_76484_5_, Blocks.field_150358_i, 0, 2);
        p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_, p_76484_5_ - 1, Blocks.field_150358_i, 0, 2);
        p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_, p_76484_5_ + 1, Blocks.field_150358_i, 0, 2);

        for(int var10 = -2; var10 <= 2; ++var10) {
            for(int i1 = -2; i1 <= 2; ++i1) {
                if (var10 == -2 || var10 == 2 || i1 == -2 || i1 == 2) {
                    p_76484_1_.func_147465_d(p_76484_3_ + var10, p_76484_4_ + 1, p_76484_5_ + i1, Blocks.field_150322_A, 0, 2);
                }
            }
        }

        p_76484_1_.func_147465_d(p_76484_3_ + 2, p_76484_4_ + 1, p_76484_5_, Blocks.field_150333_U, 1, 2);
        p_76484_1_.func_147465_d(p_76484_3_ - 2, p_76484_4_ + 1, p_76484_5_, Blocks.field_150333_U, 1, 2);
        p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_ + 1, p_76484_5_ + 2, Blocks.field_150333_U, 1, 2);
        p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_ + 1, p_76484_5_ - 2, Blocks.field_150333_U, 1, 2);

        for(int var11 = -1; var11 <= 1; ++var11) {
            for(int i1 = -1; i1 <= 1; ++i1) {
                if (var11 == 0 && i1 == 0) {
                    p_76484_1_.func_147465_d(p_76484_3_ + var11, p_76484_4_ + 4, p_76484_5_ + i1, Blocks.field_150322_A, 0, 2);
                } else {
                    p_76484_1_.func_147465_d(p_76484_3_ + var11, p_76484_4_ + 4, p_76484_5_ + i1, Blocks.field_150333_U, 1, 2);
                }
            }
        }

        for(int var12 = 1; var12 <= 3; ++var12) {
            p_76484_1_.func_147465_d(p_76484_3_ - 1, p_76484_4_ + var12, p_76484_5_ - 1, Blocks.field_150322_A, 0, 2);
            p_76484_1_.func_147465_d(p_76484_3_ - 1, p_76484_4_ + var12, p_76484_5_ + 1, Blocks.field_150322_A, 0, 2);
            p_76484_1_.func_147465_d(p_76484_3_ + 1, p_76484_4_ + var12, p_76484_5_ - 1, Blocks.field_150322_A, 0, 2);
            p_76484_1_.func_147465_d(p_76484_3_ + 1, p_76484_4_ + var12, p_76484_5_ + 1, Blocks.field_150322_A, 0, 2);
        }

        return true;
    }
}
