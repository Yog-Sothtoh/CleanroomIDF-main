//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import danger.orespawn.OreSpawnMain;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class SpawnEggOreGeneration implements IWorldGenerator {
    public SpawnEggOreGeneration() {
    }

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        int dimensionId = world.field_73011_w.field_76574_g;
        if (Loader.isModLoaded("OreSpawn") && dimensionId != -1 && dimensionId != 1 && dimensionId != 200 && dimensionId != 201 && TitanBlocks.MyOverlordScorpionPartSpawnBlock != null) {
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.MyOverlordScorpionPartSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.MyOverlordScorpionSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.MyMethuselahKrakenPartSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, TitanBlocks.MyMethuselahKrakenSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyBrutalflySpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyNastysaurusSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyPointysaurusSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCricketSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyFrogSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MySpiderDriverSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCrabSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MySpiderSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyBatSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCowSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyPigSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MySquidSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyChickenSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCreeperSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MySkeletonSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyZombieSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MySlimeSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyGhastSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyZombiePigmanSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyEndermanSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCaveSpiderSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MySilverfishSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyMagmaCubeSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyWitchSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MySheepSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyWolfSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyMooshroomSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyOcelotSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyBlazeSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyWitherSkeletonSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyEnderDragonSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MySnowGolemSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyIronGolemSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyWitherBossSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyGirlfriendSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyRedCowSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyGoldCowSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyEnchantedCowSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyMOTHRASpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyAloSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCryoSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCamaSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyVeloSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyHydroSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyBasilSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyDragonflySpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyEmperorScorpionSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyScorpionSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCaveFisherSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MySpyroSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyBaryonyxSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyGammaMetroidSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCockateilSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyKyuubiSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyAlienSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyAttackSquidSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyWaterDragonSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyKrakenSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyLizardSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCephadromeSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyDragonSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyBeeSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyHorseSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyTrooperBugSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MySpitBugSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyStinkBugSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyOstrichSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyGazelleSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyChipmunkSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCreepingHorrorSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyTerribleTerrorSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCliffRacerSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyTriffidSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyPitchBlackSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyLurkingTerrorSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyGodzillaPartSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyGodzillaSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MySmallWormSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyMediumWormSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyLargeWormSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCassowarySpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCloudSharkSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyGoldFishSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyLeafMonsterSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyTshirtSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyEnderKnightSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyEnderReaperSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyBeaverSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyTRexSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyHerculesSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyMantisSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyStinkySpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyBoyfriendSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyTheKingPartSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyTheKingSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyEasterBunnySpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCaterKillerSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyMolenoidSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MySeaMonsterSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MySeaViperSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyLeonSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyHammerheadSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyRubberDuckySpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyVillagerSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyCriminalSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyTheQueenPartSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
            this.generateOre(random, world, chunkX * 16, chunkZ * 16, OreSpawnMain.MyTheQueenSpawnBlock, Blocks.field_150348_b, OreSpawnMain.SpawnOres_stats.clumpsize, 1, OreSpawnMain.SpawnOres_stats.maxdepth);
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
