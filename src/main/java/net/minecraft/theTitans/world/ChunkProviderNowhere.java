//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.world;

import cpw.mods.fml.common.eventhandler.Event.Result;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenNetherBridge;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.event.terraingen.InitMapGenEvent.EventType;
import org.apache.logging.log4j.LogManager;

public class ChunkProviderNowhere implements IChunkProvider {
    private Random voidRNG;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    public NoiseGeneratorOctaves noiseGen4;
    public NoiseGeneratorOctaves noiseGen5;
    public NoiseGeneratorOctaves noiseGen6;
    private World voidWorld;
    private double[] densities;
    private BiomeGenBase[] biomesForGeneration;
    private final float[] parabolicField;
    double[] noiseData1;
    double[] noiseData2;
    double[] noiseData3;
    double[] noiseData4;
    double[] noiseData5;
    double[] field_147427_d;
    double[] field_147428_e;
    double[] field_147425_f;
    double[] field_147426_g;
    int[][] field_73219_j = new int[32][32];
    private WorldType field_147435_p;
    private MapGenBase caveGenerator = new MapGenCavesNowhere();
    private MapGenVillage villageGenerator = new MapGenVillage();
    private MapGenBase ravineGenerator = new MapGenRavineNowhere();
    public MapGenNetherBridge genNetherBridge = new MapGenNetherBridge();
    private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();

    public ChunkProviderNowhere(World p_i2007_1_, long p_i2007_2_) {
        this.genNetherBridge = (MapGenNetherBridge)TerrainGen.getModdedMapGen(this.genNetherBridge, EventType.NETHER_BRIDGE);
        this.caveGenerator = TerrainGen.getModdedMapGen(this.caveGenerator, EventType.CAVE);
        this.villageGenerator = (MapGenVillage)TerrainGen.getModdedMapGen(this.villageGenerator, EventType.VILLAGE);
        this.mineshaftGenerator = (MapGenMineshaft)TerrainGen.getModdedMapGen(this.mineshaftGenerator, EventType.MINESHAFT);
        this.ravineGenerator = TerrainGen.getModdedMapGen(this.ravineGenerator, EventType.RAVINE);
        this.voidWorld = p_i2007_1_;
        this.voidRNG = new Random(p_i2007_2_);
        this.densities = new double[825];
        this.noiseGen1 = new NoiseGeneratorOctaves(this.voidRNG, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.voidRNG, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.voidRNG, 8);
        this.noiseGen4 = new NoiseGeneratorOctaves(this.voidRNG, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.voidRNG, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.voidRNG, 16);
        this.densities = new double[825];
        NoiseGenerator[] noiseGens = new NoiseGenerator[]{this.noiseGen1, this.noiseGen2, this.noiseGen3, this.noiseGen4, this.noiseGen5, this.noiseGen6};
        noiseGens = TerrainGen.getModdedNoiseGenerators(p_i2007_1_, this.voidRNG, noiseGens);
        this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
        this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
        this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
        this.noiseGen4 = (NoiseGeneratorOctaves)noiseGens[3];
        this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
        this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
        this.parabolicField = new float[25];

        for(int j = -2; j <= 2; ++j) {
            for(int k = -2; k <= 2; ++k) {
                float f = 10.0F / MathHelper.func_76129_c((float)(j * j + k * k) + 0.2F);
                this.parabolicField[j + 2 + (k + 2) * 5] = f;
            }
        }

    }

    private void func_147423_a(int p_147423_1_, int p_147423_2_, int p_147423_3_) {
        double d0 = 684.412;
        double d1 = 684.412;
        double d2 = (double)512.0F;
        double d3 = (double)512.0F;
        this.field_147426_g = this.noiseGen6.func_76305_a(this.field_147426_g, p_147423_1_, p_147423_3_, 5, 5, (double)200.0F, (double)200.0F, (double)0.5F);
        this.field_147427_d = this.noiseGen3.func_76304_a(this.field_147427_d, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001, 4.277575000000001, 8.555150000000001);
        this.field_147428_e = this.noiseGen1.func_76304_a(this.field_147428_e, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412, 684.412, 684.412);
        this.field_147425_f = this.noiseGen2.func_76304_a(this.field_147425_f, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412, 684.412, 684.412);
        boolean flag1 = false;
        boolean flag = false;
        int l = 0;
        int i1 = 0;
        double d4 = (double)8.5F;

        for(int j1 = 0; j1 < 5; ++j1) {
            for(int k1 = 0; k1 < 5; ++k1) {
                float f = 0.0F;
                float f1 = 0.0F;
                float f2 = 0.0F;
                byte b0 = 2;
                BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];

                for(int l1 = -b0; l1 <= b0; ++l1) {
                    for(int i2 = -b0; i2 <= b0; ++i2) {
                        BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
                        float f3 = biomegenbase1.field_76748_D;
                        float f4 = biomegenbase1.field_76749_E;
                        if (this.field_147435_p == WorldType.field_151360_e && f3 > 0.0F) {
                            f3 = 1.0F + f3 * 2.0F;
                            f4 = 1.0F + f4 * 4.0F;
                        }

                        float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);
                        if (biomegenbase1.field_76748_D > biomegenbase.field_76748_D) {
                            f5 /= 2.0F;
                        }

                        f += f4 * f5;
                        f1 += f3 * f5;
                        f2 += f5;
                    }
                }

                f /= f2;
                f1 /= f2;
                f = f * 0.9F + 0.1F;
                f1 = (f1 * 4.0F - 1.0F) / 8.0F;
                double d12 = this.field_147426_g[i1] / (double)8000.0F;
                if (d12 < (double)0.0F) {
                    d12 = -d12 * 0.3;
                }

                d12 = d12 * (double)3.0F - (double)2.0F;
                if (d12 < (double)0.0F) {
                    d12 /= (double)2.0F;
                    if (d12 < (double)-1.0F) {
                        d12 = (double)-1.0F;
                    }

                    d12 /= 1.4;
                    d12 /= (double)2.0F;
                } else {
                    if (d12 > (double)1.0F) {
                        d12 = (double)1.0F;
                    }

                    d12 /= (double)8.0F;
                }

                ++i1;
                double d13 = (double)f1;
                double d14 = (double)f;
                d13 += d12 * 0.2;
                d13 = d13 * (double)8.5F / (double)8.0F;
                double d5 = (double)8.5F + d13 * (double)4.0F;

                for(int j2 = 0; j2 < 33; ++j2) {
                    double d6 = ((double)j2 - d5) * (double)12.0F * (double)128.0F / (double)256.0F / d14;
                    if (d6 < (double)0.0F) {
                        d6 *= (double)4.0F;
                    }

                    double d7 = this.field_147428_e[l] / (double)512.0F;
                    double d8 = this.field_147425_f[l] / (double)512.0F;
                    double d9 = (this.field_147427_d[l] / (double)10.0F + (double)1.0F) / (double)2.0F;
                    double d10 = MathHelper.func_151238_b(d7, d8, d9) - d6;
                    if (j2 > 29) {
                        double d11 = (double)((float)(j2 - 29) / 3.0F);
                        d10 = d10 * ((double)1.0F - d11) + (double)-10.0F * d11;
                    }

                    this.densities[l] = d10;
                    ++l;
                }
            }
        }

    }

    public void func_147424_a(int p_147424_1_, int p_147424_2_, Block[] p_147424_3_, BiomeGenBase[] biomesForGeneration2) {
        byte b0 = 63;
        this.func_147423_a(p_147424_1_ * 4, 0, p_147424_2_ * 4);

        for(int k = 0; k < 4; ++k) {
            int l = k * 5;
            int i1 = (k + 1) * 5;

            for(int j1 = 0; j1 < 4; ++j1) {
                int k1 = (l + j1) * 33;
                int l1 = (l + j1 + 1) * 33;
                int i2 = (i1 + j1) * 33;
                int j2 = (i1 + j1 + 1) * 33;

                for(int k2 = 0; k2 < 32; ++k2) {
                    double d0 = (double)0.125F;
                    double d1 = this.densities[k1 + k2];
                    double d2 = this.densities[l1 + k2];
                    double d3 = this.densities[i2 + k2];
                    double d4 = this.densities[j2 + k2];
                    double d5 = (this.densities[k1 + k2 + 1] - d1) * d0;
                    double d6 = (this.densities[l1 + k2 + 1] - d2) * d0;
                    double d7 = (this.densities[i2 + k2 + 1] - d3) * d0;
                    double d8 = (this.densities[j2 + k2 + 1] - d4) * d0;

                    for(int l2 = 0; l2 < 8; ++l2) {
                        double d9 = (double)0.25F;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;

                        for(int i3 = 0; i3 < 4; ++i3) {
                            int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
                            short short1 = 256;
                            j3 -= short1;
                            double d14 = (double)0.25F;
                            double d16 = (d11 - d10) * d14;
                            double d15 = d10 - d16;

                            for(int k3 = 0; k3 < 4; ++k3) {
                                if ((d15 += d16) > (double)0.0F) {
                                    p_147424_3_[j3 += short1] = Blocks.field_150343_Z;
                                } else {
                                    p_147424_3_[j3 += short1] = null;
                                }
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }

    }

    /** @deprecated */
    @Deprecated
    public void func_147421_b(int p_147421_1_, int p_147421_2_, Block[] p_147421_3_, BiomeGenBase[] p_147421_4_) {
        this.replaceBiomeBlocks(p_147421_1_, p_147421_2_, p_147421_3_, p_147421_4_, new byte[p_147421_3_.length]);
    }

    public void replaceBiomeBlocks(int p_147421_1_, int p_147421_2_, Block[] p_147421_3_, BiomeGenBase[] p_147421_4_, byte[] meta) {
        ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, p_147421_1_, p_147421_2_, p_147421_3_, meta, p_147421_4_, this.voidWorld);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() != Result.DENY) {
            for(int k = 0; k < 16; ++k) {
                for(int l = 0; l < 16; ++l) {
                    byte b0 = 1;
                    int i1 = -1;
                    Block block = Blocks.field_150343_Z;
                    Block block1 = Blocks.field_150343_Z;

                    for(int j1 = 127; j1 >= 0; --j1) {
                        int k1 = (l * 16 + k) * 128 + j1;
                        Block block2 = p_147421_3_[k1];
                        if (block2 != null && block2.func_149688_o() != Material.field_151579_a) {
                            if (block2 == Blocks.field_150348_b) {
                                if (i1 == -1) {
                                    if (b0 <= 0) {
                                        block = null;
                                        block1 = Blocks.field_150343_Z;
                                    }

                                    i1 = b0;
                                    if (j1 >= 0) {
                                        p_147421_3_[k1] = block;
                                    } else {
                                        p_147421_3_[k1] = block1;
                                    }
                                } else if (i1 > 0) {
                                    --i1;
                                    p_147421_3_[k1] = block1;
                                }
                            }
                        } else {
                            i1 = -1;
                        }
                    }
                }
            }

        }
    }

    public Chunk func_73158_c(int p_73158_1_, int p_73158_2_) {
        return this.func_73154_d(p_73158_1_, p_73158_2_);
    }

    public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) {
        this.voidRNG.setSeed((long)p_73154_1_ * 341873128712L + (long)p_73154_2_ * 132897987541L);
        Block[] ablock = new Block[65536];
        byte[] abyte = new byte[65536];
        this.biomesForGeneration = this.voidWorld.func_72959_q().func_76933_b(this.biomesForGeneration, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
        this.func_147424_a(p_73154_1_, p_73154_2_, ablock, this.biomesForGeneration);
        this.caveGenerator.func_151539_a(this, this.voidWorld, p_73154_1_, p_73154_2_, ablock);
        this.ravineGenerator.func_151539_a(this, this.voidWorld, p_73154_1_, p_73154_2_, ablock);
        this.genNetherBridge.func_151539_a(this, this.voidWorld, p_73154_1_, p_73154_2_, ablock);
        this.villageGenerator.func_151539_a(this, this.voidWorld, p_73154_1_, p_73154_2_, ablock);
        this.mineshaftGenerator.func_151539_a(this, this.voidWorld, p_73154_1_, p_73154_2_, ablock);
        this.replaceBiomeBlocks(p_73154_1_, p_73154_2_, ablock, this.biomesForGeneration, abyte);
        Chunk chunk = new Chunk(this.voidWorld, ablock, abyte, p_73154_1_, p_73154_2_);
        byte[] abyte1 = chunk.func_76605_m();

        for(int k = 0; k < abyte1.length; ++k) {
            abyte1[k] = (byte)this.biomesForGeneration[k].field_76756_M;
        }

        chunk.func_76603_b();
        return chunk;
    }

    private double[] initializeNoiseField(double[] p_73187_1_, int p_73187_2_, int p_73187_3_, int p_73187_4_, int p_73187_5_, int p_73187_6_, int p_73187_7_) {
        ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, p_73187_1_, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Result.DENY) {
            return event.noisefield;
        } else {
            if (p_73187_1_ == null) {
                p_73187_1_ = new double[p_73187_5_ * p_73187_6_ * p_73187_7_];
            }

            double d0 = 684.412;
            double d1 = 684.412;
            this.noiseData4 = this.noiseGen4.func_76305_a(this.noiseData4, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 1.121, 1.121, (double)0.5F);
            this.noiseData5 = this.noiseGen5.func_76305_a(this.noiseData5, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, (double)200.0F, (double)200.0F, (double)0.5F);
            d0 *= (double)2.0F;
            this.noiseData1 = this.noiseGen3.func_76304_a(this.noiseData1, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d0 / (double)80.0F, d1 / (double)160.0F, d0 / (double)80.0F);
            this.noiseData2 = this.noiseGen1.func_76304_a(this.noiseData2, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d0, d1, d0);
            this.noiseData3 = this.noiseGen2.func_76304_a(this.noiseData3, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d0, d1, d0);
            int k1 = 0;
            int l1 = 0;

            for(int i2 = 0; i2 < p_73187_5_; ++i2) {
                for(int j2 = 0; j2 < p_73187_7_; ++j2) {
                    double d2 = (this.noiseData4[l1] + (double)256.0F) / (double)512.0F;
                    if (d2 > (double)1.0F) {
                        d2 = (double)1.0F;
                    }

                    double d3 = this.noiseData5[l1] / (double)8000.0F;
                    if (d3 < (double)0.0F) {
                        d3 = -d3 * 0.3;
                    }

                    d3 = d3 * (double)3.0F - (double)2.0F;
                    float f = (float)(i2 + p_73187_2_ - 0) / 1.0F;
                    float f1 = (float)(j2 + p_73187_4_ - 0) / 1.0F;
                    float f2 = 100.0F - MathHelper.func_76129_c(f * f + f1 * f1) * 8.0F;
                    if (f2 > 80.0F) {
                        f2 = 80.0F;
                    }

                    if (f2 < -100.0F) {
                        f2 = -100.0F;
                    }

                    if (d3 > (double)1.0F) {
                        d3 = (double)1.0F;
                    }

                    d3 /= (double)8.0F;
                    d3 = (double)0.0F;
                    if (d2 < (double)0.0F) {
                        d2 = (double)0.0F;
                    }

                    d2 += (double)0.5F;
                    d3 = d3 * (double)p_73187_6_ / (double)16.0F;
                    ++l1;
                    double d4 = (double)p_73187_6_ / (double)2.0F;

                    for(int k2 = 0; k2 < p_73187_6_; ++k2) {
                        double d5 = (double)0.0F;
                        double d6 = ((double)k2 - d4) * (double)8.0F / d2;
                        if (d6 < (double)0.0F) {
                            d6 *= (double)-1.0F;
                        }

                        double d7 = this.noiseData2[k1] / (double)512.0F;
                        double d8 = this.noiseData3[k1] / (double)512.0F;
                        double d9 = (this.noiseData1[k1] / (double)10.0F + (double)1.0F) / (double)2.0F;
                        if (d9 < (double)0.0F) {
                            d5 = d7;
                        } else if (d9 > (double)1.0F) {
                            d5 = d8;
                        } else {
                            d5 = d7 + (d8 - d7) * d9;
                        }

                        d5 -= (double)8.0F;
                        d5 += (double)f2;
                        byte b0 = 2;
                        if (k2 > p_73187_6_ / 2 - b0) {
                            double d10 = (double)((float)(k2 - (p_73187_6_ / 2 - b0)) / 64.0F);
                            if (d10 < (double)0.0F) {
                                d10 = (double)0.0F;
                            }

                            if (d10 > (double)1.0F) {
                                d10 = (double)1.0F;
                            }

                            d5 = d5 * ((double)1.0F - d10) + (double)-3000.0F * d10;
                        }

                        b0 = 8;
                        if (k2 < b0) {
                            double d10 = (double)((float)(b0 - k2) / ((float)b0 - 1.0F));
                            d5 = d5 * ((double)1.0F - d10) + (double)-30.0F * d10;
                        }

                        p_73187_1_[k1] = d5;
                        ++k1;
                    }
                }
            }

            return p_73187_1_;
        }
    }

    public boolean func_73149_a(int p_73149_1_, int p_73149_2_) {
        return true;
    }

    public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
        BlockFalling.field_149832_M = true;
        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(p_73153_1_, this.voidWorld, this.voidWorld.field_73012_v, p_73153_2_, p_73153_3_, false));
        int k = p_73153_2_ * 16;
        int l = p_73153_3_ * 16;
        BiomeGenBase biomegenbase = this.voidWorld.func_72807_a(k + 16, l + 16);
        this.voidRNG.setSeed(this.voidWorld.func_72905_C());
        long i1 = this.voidRNG.nextLong() / 2L * 2L + 1L;
        long j1 = this.voidRNG.nextLong() / 2L * 2L + 1L;
        this.voidRNG.setSeed((long)p_73153_2_ * i1 + (long)p_73153_3_ * j1 ^ this.voidWorld.func_72905_C());
        boolean flag = false;
        this.villageGenerator.func_75051_a(this.voidWorld, this.voidRNG, p_73153_2_, p_73153_3_);
        this.genNetherBridge.func_75051_a(this.voidWorld, this.voidRNG, p_73153_2_, p_73153_3_);
        this.mineshaftGenerator.func_75051_a(this.voidWorld, this.voidRNG, p_73153_2_, p_73153_3_);
        biomegenbase.func_76728_a(this.voidWorld, this.voidRNG, k, l);

        for(int k1 = 0; k1 < 100; ++k1) {
            int l1 = k + this.voidRNG.nextInt(16) + 8;
            int i2 = this.voidRNG.nextInt(256);
            int j2 = l + this.voidRNG.nextInt(16) + 8;
            (new WorldGenNowhereDungeon()).func_76484_a(this.voidWorld, this.voidRNG, l1, i2, j2);
        }

        for(int var17 = 0; var17 < 800; ++var17) {
            int l1 = k + this.voidRNG.nextInt(16) + 8;
            int i2 = this.voidRNG.nextInt(256);
            int j2 = l + this.voidRNG.nextInt(16) + 8;
            (new WorldGenDungeons()).func_76484_a(this.voidWorld, this.voidRNG, l1, i2, j2);
        }

        if (this.voidRNG.nextInt(50000) == 0) {
            int l1 = k + this.voidRNG.nextInt(16) + 8;
            int j2 = l + this.voidRNG.nextInt(16) + 8;
            int i2 = this.voidWorld.func_72825_h(l1, j2);
            EntityEnderColossus witherzilla = new EntityEnderColossus(this.voidWorld);
            witherzilla.func_70012_b((double)l1, (double)i2, (double)j2, 0.0F, 0.0F);
            LogManager.getLogger(TheTitans.class).info("Found a succesfully spawned Ender Colossus at " + l1 + ", " + i2 + ", " + j2 + ", spawning.");
            this.voidWorld.func_72838_d(witherzilla);
        }

        MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(p_73153_1_, this.voidWorld, this.voidWorld.field_73012_v, p_73153_2_, p_73153_3_, false));
        BlockFalling.field_149832_M = false;
    }

    public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
        return true;
    }

    public void func_104112_b() {
    }

    public boolean func_73156_b() {
        return false;
    }

    public boolean func_73157_c() {
        return true;
    }

    public String func_73148_d() {
        return "RandomLevelSource";
    }

    public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
        if (p_73155_1_ == EnumCreatureType.monster) {
            if (this.genNetherBridge.func_75048_a(p_73155_2_, p_73155_3_, p_73155_4_)) {
                return this.genNetherBridge.func_75059_a();
            }

            if (this.genNetherBridge.func_142038_b(p_73155_2_, p_73155_3_, p_73155_4_) && this.voidWorld.func_147439_a(p_73155_2_, p_73155_3_ - 1, p_73155_4_) == Blocks.field_150385_bj) {
                return this.genNetherBridge.func_75059_a();
            }
        }

        BiomeGenBase biomegenbase = this.voidWorld.func_72807_a(p_73155_2_, p_73155_4_);
        return biomegenbase.func_76747_a(p_73155_1_);
    }

    public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
        return null;
    }

    public int func_73152_e() {
        return 0;
    }

    public void func_82695_e(int p_82695_1_, int p_82695_2_) {
        this.villageGenerator.func_151539_a(this, this.voidWorld, p_82695_1_, p_82695_2_, (Block[])null);
        this.genNetherBridge.func_151539_a(this, this.voidWorld, p_82695_1_, p_82695_2_, (Block[])null);
        this.mineshaftGenerator.func_151539_a(this, this.voidWorld, p_82695_1_, p_82695_2_, (Block[])null);
    }
}
