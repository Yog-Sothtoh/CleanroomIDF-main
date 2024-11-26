//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans;

import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class TitansOreGeneration implements IWorldGenerator {
    public TitansOreGeneration() {
    }

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        int dimensionId = world.field_73011_w.field_76574_g;
        if (dimensionId != -1 && dimensionId != 1 && dimensionId != 200 && dimensionId != 201) {
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.void_ore, Blocks.field_150348_b, 2, 1, 8);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.harcadium_ore, Blocks.field_150348_b, 4, 1, 12);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.copper_ore, Blocks.field_150348_b, 16, 10, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.tin_ore, Blocks.field_150348_b, 16, 10, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.chromium_ore, Blocks.field_150348_b, 9, 8, 48);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.magnesium_ore, Blocks.field_150348_b, 9, 8, 48);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.lead_ore, Blocks.field_150348_b, 9, 6, 48);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.silver_ore, Blocks.field_150348_b, 8, 4, 32);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.platinum_ore, Blocks.field_150348_b, 7, 2, 28);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150402_ci, Blocks.field_150348_b, 16, 8, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150339_S, Blocks.field_150348_b, 8, 6, 64);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150340_R, Blocks.field_150348_b, 8, 4, 32);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150484_ah, Blocks.field_150348_b, 7, 6, 16);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150475_bE, Blocks.field_150348_b, 7, 6, 16);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150451_bX, Blocks.field_150348_b, 7, 4, 32);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150368_y, Blocks.field_150348_b, 6, 3, 16);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150365_q, Blocks.field_150348_b, 32, 8, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150366_p, Blocks.field_150348_b, 24, 6, 64);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150352_o, Blocks.field_150348_b, 24, 4, 32);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150482_ag, Blocks.field_150348_b, 18, 6, 16);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150412_bA, Blocks.field_150348_b, 18, 6, 16);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150450_ax, Blocks.field_150348_b, 18, 4, 32);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150369_x, Blocks.field_150348_b, 16, 3, 16);
        } else if (dimensionId == -1) {
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.nether_stone_ore, Blocks.field_150424_aL, 24, 20, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.nether_coal_ore, Blocks.field_150424_aL, 16, 20, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.nether_gold_ore, Blocks.field_150424_aL, 16, 2, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.nether_diamond_ore, Blocks.field_150424_aL, 7, 1, 128);
        } else if (dimensionId == 1) {
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.void_ore_end_stone, Blocks.field_150377_bs, 7, 10, 128);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.harcadium_ore_end_stone, Blocks.field_150377_bs, 16, 30, 128);
        } else if (dimensionId == 200) {
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150343_Z, Blocks.field_150357_h, 32, 20, 128);
        } else if (dimensionId == 201) {
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.void_ore_obsidian, Blocks.field_150343_Z, 12, 20, 256);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.harcadium_ore_obsidian, Blocks.field_150343_Z, 24, 60, 256);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150365_q, Blocks.field_150343_Z, 16, 1, 64);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150366_p, Blocks.field_150343_Z, 8, 1, 64);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150352_o, Blocks.field_150343_Z, 8, 1, 64);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150482_ag, Blocks.field_150343_Z, 7, 1, 64);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150450_ax, Blocks.field_150343_Z, 7, 1, 64);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, Blocks.field_150369_x, Blocks.field_150343_Z, 6, 1, 64);
        }

    }

    private void generateOre(Random rand, World world, int chunkX, int chunkZ, Block state, Block generateIn, int veinSize, int veinsPerChunk, int maxY) {
        for(int vein = 0; vein < veinsPerChunk; ++vein) {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(maxY);
            int randPosZ = chunkZ + rand.nextInt(16);
            WorldGenMinable genMinable = new WorldGenMinable(state, veinSize, generateIn);
            genMinable.func_76484_a(world, rand, randPosX, randPosY, randPosZ);
        }

    }
}
