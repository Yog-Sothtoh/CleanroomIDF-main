//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans;

import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.world.WorldGenBlazeTitan;
import net.minecraft.theTitans.world.WorldGenCaveSpiderTitan;
import net.minecraft.theTitans.world.WorldGenCreeperTitan;
import net.minecraft.theTitans.world.WorldGenGhastTitan;
import net.minecraft.theTitans.world.WorldGenMagmaCubeTitan;
import net.minecraft.theTitans.world.WorldGenOmegafish;
import net.minecraft.theTitans.world.WorldGenPigZombieTitan;
import net.minecraft.theTitans.world.WorldGenSkeletonTitan;
import net.minecraft.theTitans.world.WorldGenSlimeTitan;
import net.minecraft.theTitans.world.WorldGenSpiderJockeyTitan;
import net.minecraft.theTitans.world.WorldGenSpiderTitan;
import net.minecraft.theTitans.world.WorldGenWitherSkeletonTitan;
import net.minecraft.theTitans.world.WorldGenZombieTitan;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TitanStructureGenerator implements IWorldGenerator {
    public TitanStructureGenerator() {
    }

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        int dimensionId = world.field_73011_w.field_76574_g;
        if (dimensionId == -1) {
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenMagmaCubeTitan(Blocks.field_150424_aL), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenGhastTitan(Blocks.field_150424_aL), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenWitherSkeletonTitan(Blocks.field_150424_aL), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenBlazeTitan(Blocks.field_150424_aL), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenPigZombieTitan(Blocks.field_150424_aL), 256);
        } else if (dimensionId != 1 && dimensionId != -1 && dimensionId != 200 && dimensionId != 201) {
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenOmegafish(Blocks.field_150348_b), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenCaveSpiderTitan(Blocks.field_150348_b), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenSpiderTitan(Blocks.field_150348_b), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenSpiderJockeyTitan(Blocks.field_150348_b), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenZombieTitan(Blocks.field_150348_b), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenSkeletonTitan(Blocks.field_150348_b), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenCreeperTitan(Blocks.field_150348_b), 256);
            this.generateStructure(random, world, chunkX * 16, chunkZ * 16, new WorldGenSlimeTitan(Blocks.field_150348_b), 256);
        }

    }

    private void generateStructure(Random rand, World world, int chunkX, int chunkZ, WorldGenerator worldgen, int maxY) {
        int x = chunkX * 16 + rand.nextInt(16);
        int z = chunkZ * 16 + rand.nextInt(16);
        int randPosY = rand.nextInt(world.func_72940_L());
        if (world.field_73011_w.field_76574_g != -1) {
            randPosY = world.func_72825_h(x, z);
        }

        if (rand.nextInt(2) == 0) {
            worldgen.func_76484_a(world, rand, x, randPosY, z);
        }

    }
}
