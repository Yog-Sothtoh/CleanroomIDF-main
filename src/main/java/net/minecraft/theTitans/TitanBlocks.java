//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.theTitans.blocks.BlockCompactBedrock;
import net.minecraft.theTitans.blocks.BlockCustomNonSmeltingOre;
import net.minecraft.theTitans.blocks.BlockCustomOre;
import net.minecraft.theTitans.blocks.BlockHarcadiumBlock;
import net.minecraft.theTitans.blocks.BlockHarcadiumOre;
import net.minecraft.theTitans.blocks.BlockMalgrumCrop;
import net.minecraft.theTitans.blocks.BlockNetherCoalOre;
import net.minecraft.theTitans.blocks.BlockNetherDiamondOre;
import net.minecraft.theTitans.blocks.BlockNetherGoldOre;
import net.minecraft.theTitans.blocks.BlockNetherStoneOre;
import net.minecraft.theTitans.blocks.BlockOreEgg;
import net.minecraft.theTitans.blocks.BlockPleasantBladeCrop;
import net.minecraft.theTitans.blocks.BlockVoidBlock;
import net.minecraft.theTitans.blocks.BlockVoidOre;

public class TitanBlocks {
    public static Block copper_ore;
    public static Block tin_ore;
    public static Block chromium_ore;
    public static Block magnesium_ore;
    public static Block lead_ore;
    public static Block silver_ore;
    public static Block platinum_ore;
    public static Block harcadium_ore;
    public static Block harcadium_ore_end_stone;
    public static Block harcadium_ore_obsidian;
    public static Block void_ore;
    public static Block void_ore_end_stone;
    public static Block void_ore_obsidian;
    public static Block adamantium_ore;
    public static Block nether_stone_ore;
    public static Block nether_coal_ore;
    public static Block nether_gold_ore;
    public static Block nether_diamond_ore;
    public static Block harcadium_block;
    public static Block void_block;
    public static Block bedrock_block;
    public static Block malgrumCrop;
    public static Block pleasantBladeCrop;
    public static Block magic_pumpkin;
    public static Block stoneperch;
    public static Block sandstoneperch;
    public static Block obsidianperch;
    public static Block goldperch;
    public static Block ironperch;
    public static Block endstoneperch;
    public static Block netherbrickperch;
    public static Block MyOverlordScorpionPartSpawnBlock;
    public static Block MyOverlordScorpionSpawnBlock;
    public static Block MyMethuselahKrakenPartSpawnBlock;
    public static Block MyMethuselahKrakenSpawnBlock;

    public TitanBlocks() {
    }

    public static void init() {
        copper_ore = new BlockCustomOre(0, "copper_ore", 3.0F, 5.0F);
        tin_ore = new BlockCustomOre(0, "tin_ore", 3.0F, 5.0F);
        chromium_ore = new BlockCustomOre(1, "chromium_ore", 3.0F, 5.0F);
        magnesium_ore = new BlockCustomOre(1, "magnesium_ore", 3.0F, 5.0F);
        lead_ore = new BlockCustomOre(1, "lead_ore", 5.0F, 5.0F);
        silver_ore = new BlockCustomOre(1, "silver_ore", 5.0F, 10.0F);
        platinum_ore = new BlockCustomOre(2, "platinum_ore", 5.0F, 15.0F);
        nether_stone_ore = new BlockNetherStoneOre(Material.field_151576_e);
        nether_coal_ore = new BlockNetherCoalOre(Material.field_151576_e);
        nether_gold_ore = new BlockNetherGoldOre(Material.field_151576_e);
        nether_diamond_ore = new BlockNetherDiamondOre(Material.field_151576_e);
        harcadium_ore = new BlockHarcadiumOre(Material.field_151576_e, "harcadium_ore");
        harcadium_ore_end_stone = new BlockHarcadiumOre(Material.field_151576_e, "harcadium_ore_end_stone");
        harcadium_ore_obsidian = new BlockHarcadiumOre(Material.field_151576_e, "harcadium_ore_obsidian");
        harcadium_block = new BlockHarcadiumBlock(Material.field_151573_f, "harcadium_block");
        void_ore = new BlockVoidOre(Material.field_151576_e, "void_ore");
        void_ore_end_stone = new BlockVoidOre(Material.field_151576_e, "void_ore_end_stone");
        void_ore_obsidian = new BlockVoidOre(Material.field_151576_e, "void_ore_obsidian");
        void_block = new BlockVoidBlock(Material.field_151573_f, "void_block");
        bedrock_block = new BlockCompactBedrock(Material.field_151576_e, "bedrock_compact");
        adamantium_ore = new BlockCustomNonSmeltingOre(0, "adamantium_ore", -1.0F, 1.0E9F, TitanItems.adamantium, 1000000000, 1000000000);
        malgrumCrop = (new BlockMalgrumCrop()).func_149663_c("malgrum").func_149658_d("thetitans:malgrum");
        pleasantBladeCrop = (new BlockPleasantBladeCrop()).func_149663_c("pleasant_blade").func_149658_d("thetitans:pleasant_blade");
        registerBlock(nether_stone_ore);
        registerBlock(nether_coal_ore);
        registerBlock(nether_gold_ore);
        registerBlock(nether_diamond_ore);
        registerBlock(copper_ore);
        registerBlock(tin_ore);
        registerBlock(chromium_ore);
        registerBlock(magnesium_ore);
        registerBlock(lead_ore);
        registerBlock(silver_ore);
        registerBlock(platinum_ore);
        registerBlock(harcadium_ore);
        registerBlock(harcadium_ore_end_stone);
        registerBlock(harcadium_ore_obsidian);
        registerBlock(harcadium_block);
        registerBlock(void_ore);
        registerBlock(void_ore_end_stone);
        registerBlock(void_ore_obsidian);
        registerBlock(void_block);
        registerBlock(bedrock_block);
        registerBlock(adamantium_ore);
        registerBlock(malgrumCrop);
        registerBlock(pleasantBladeCrop);
        if (Loader.isModLoaded("OreSpawn")) {
            MyOverlordScorpionPartSpawnBlock = new BlockOreEgg("oreoverlordscorpionpart");
            MyOverlordScorpionSpawnBlock = new BlockOreEgg("oreoverlordscorpion");
            MyMethuselahKrakenPartSpawnBlock = new BlockOreEgg("oreelderkrakenpart");
            MyMethuselahKrakenSpawnBlock = new BlockOreEgg("oreelderkraken");
            registerBlock(MyOverlordScorpionPartSpawnBlock);
            registerBlock(MyOverlordScorpionSpawnBlock);
            registerBlock(MyMethuselahKrakenPartSpawnBlock);
            registerBlock(MyMethuselahKrakenSpawnBlock);
        }

    }

    private static void registerBlock(Block block) {
        GameRegistry.registerBlock(block, block.func_149739_a().substring(5));
    }
}
