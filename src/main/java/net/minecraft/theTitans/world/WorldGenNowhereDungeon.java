//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.world;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;

public class WorldGenNowhereDungeon extends WorldGenerator {
    public WorldGenNowhereDungeon() {
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        byte b0 = 6;
        int l = 6;
        int i1 = 6;
        int j1 = 0;

        for(int k1 = p_76484_3_ - l - 1; k1 <= p_76484_3_ + l + 1; ++k1) {
            for(int l1 = p_76484_4_ - 1; l1 <= p_76484_4_ + b0 + 1; ++l1) {
                for(int i2 = p_76484_5_ - i1 - 1; i2 <= p_76484_5_ + i1 + 1; ++i2) {
                    Material material = p_76484_1_.func_147439_a(k1, l1, i2).func_149688_o();
                    if (l1 == p_76484_4_ - 1 && !material.func_76220_a()) {
                        return false;
                    }

                    if (l1 == p_76484_4_ + b0 + 1 && !material.func_76220_a()) {
                        return false;
                    }

                    if ((k1 == p_76484_3_ - l - 1 || k1 == p_76484_3_ + l + 1 || i2 == p_76484_5_ - i1 - 1 || i2 == p_76484_5_ + i1 + 1) && l1 == p_76484_4_ && p_76484_1_.func_147437_c(k1, l1, i2) && p_76484_1_.func_147437_c(k1, l1 + 1, i2)) {
                        ++j1;
                    }
                }
            }
        }

        if (j1 >= 1 && j1 <= 5) {
            for(int var16 = p_76484_3_ - l - 1; var16 <= p_76484_3_ + l + 1; ++var16) {
                for(int l1 = p_76484_4_ + b0; l1 >= p_76484_4_ - 1; --l1) {
                    for(int i2 = p_76484_5_ - i1 - 1; i2 <= p_76484_5_ + i1 + 1; ++i2) {
                        if (var16 != p_76484_3_ - l - 1 && l1 != p_76484_4_ - 1 && i2 != p_76484_5_ - i1 - 1 && var16 != p_76484_3_ + l + 1 && l1 != p_76484_4_ + b0 + 1 && i2 != p_76484_5_ + i1 + 1) {
                            p_76484_1_.func_147468_f(var16, l1, i2);
                        } else if (l1 >= 0 && !p_76484_1_.func_147439_a(var16, l1 - 1, i2).func_149688_o().func_76220_a()) {
                            p_76484_1_.func_147468_f(var16, l1, i2);
                        } else if (p_76484_1_.func_147439_a(var16, l1, i2).func_149688_o().func_76220_a()) {
                            p_76484_1_.func_147465_d(var16, l1, i2, Blocks.field_150343_Z, 0, 2);
                        }
                    }
                }
            }

            for(int var17 = 0; var17 < 2; ++var17) {
                for(int l1 = 0; l1 < 3; ++l1) {
                    int i2 = p_76484_3_ + p_76484_2_.nextInt(l * 2 + 1) - l;
                    int j2 = p_76484_5_ + p_76484_2_.nextInt(i1 * 2 + 1) - i1;
                    if (p_76484_1_.func_147437_c(i2, p_76484_4_, j2)) {
                        int k2 = 0;
                        if (p_76484_1_.func_147439_a(i2 - 1, p_76484_4_, j2).func_149688_o().func_76220_a()) {
                            ++k2;
                        }

                        if (p_76484_1_.func_147439_a(i2 + 1, p_76484_4_, j2).func_149688_o().func_76220_a()) {
                            ++k2;
                        }

                        if (p_76484_1_.func_147439_a(i2, p_76484_4_, j2 - 1).func_149688_o().func_76220_a()) {
                            ++k2;
                        }

                        if (p_76484_1_.func_147439_a(i2, p_76484_4_, j2 + 1).func_149688_o().func_76220_a()) {
                            ++k2;
                        }

                        if (p_76484_1_.func_147439_a(i2 - 1, p_76484_4_, j2 - 1).func_149688_o().func_76220_a()) {
                            ++k2;
                        }

                        if (p_76484_1_.func_147439_a(i2 + 1, p_76484_4_, j2 - 1).func_149688_o().func_76220_a()) {
                            ++k2;
                        }

                        if (p_76484_1_.func_147439_a(i2 - 1, p_76484_4_, j2 - 1).func_149688_o().func_76220_a()) {
                            ++k2;
                        }

                        if (p_76484_1_.func_147439_a(i2 - 1, p_76484_4_, j2 + 1).func_149688_o().func_76220_a()) {
                            ++k2;
                        }

                        if (p_76484_1_.func_147439_a(i2 - 1, p_76484_4_, j2 + 1).func_149688_o().func_76220_a()) {
                            ++k2;
                        }

                        if (p_76484_1_.func_147439_a(i2 + 1, p_76484_4_, j2 + 1).func_149688_o().func_76220_a()) {
                            ++k2;
                        }

                        if (p_76484_1_.func_147439_a(i2 + 1, p_76484_4_, j2 - 1).func_149688_o().func_76220_a()) {
                            ++k2;
                        }

                        if (p_76484_1_.func_147439_a(i2 + 1, p_76484_4_, j2 + 1).func_149688_o().func_76220_a()) {
                            ++k2;
                        }

                        if (k2 == 1) {
                            p_76484_1_.func_147465_d(i2, p_76484_4_, j2, Blocks.field_150486_ae, 0, 2);
                            TileEntityChest tileentitychest = (TileEntityChest)p_76484_1_.func_147438_o(i2, p_76484_4_, j2);
                            if (tileentitychest != null) {
                                WeightedRandomChestContent.func_76293_a(p_76484_2_, ChestGenHooks.getItems("pyramidDesertyChest", p_76484_2_), tileentitychest, ChestGenHooks.getCount("pyramidDesertyChest", p_76484_2_));
                            }
                            break;
                        }
                    }
                }
            }

            p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_, p_76484_5_, Blocks.field_150474_ac, 0, 2);
            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_76484_1_.func_147438_o(p_76484_3_, p_76484_4_, p_76484_5_);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a().func_98272_a("Enderman");
            } else {
                System.err.println("Failed to fetch mob spawner entity at (" + p_76484_3_ + ", " + p_76484_4_ + ", " + p_76484_5_ + ")");
            }

            p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_ + 1, p_76484_5_, Blocks.field_150474_ac, 0, 2);
            TileEntityMobSpawner tileentitymobspawner1 = (TileEntityMobSpawner)p_76484_1_.func_147438_o(p_76484_3_, p_76484_4_ + 1, p_76484_5_);
            if (tileentitymobspawner1 != null) {
                tileentitymobspawner1.func_145881_a().func_98272_a("Enderman");
            } else {
                System.err.println("Failed to fetch mob spawner entity at (" + p_76484_3_ + ", " + p_76484_4_ + 1 + ", " + p_76484_5_ + ")");
            }

            p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_ + 2, p_76484_5_, Blocks.field_150474_ac, 0, 2);
            TileEntityMobSpawner tileentitymobspawner11 = (TileEntityMobSpawner)p_76484_1_.func_147438_o(p_76484_3_, p_76484_4_ + 2, p_76484_5_);
            if (tileentitymobspawner11 != null) {
                tileentitymobspawner11.func_145881_a().func_98272_a("Enderman");
            } else {
                System.err.println("Failed to fetch mob spawner entity at (" + p_76484_3_ + ", " + p_76484_4_ + 2 + ", " + p_76484_5_ + ")");
            }

            return true;
        } else {
            return false;
        }
    }
}
