//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public final class CraftingRecipes {
    public CraftingRecipes() {
    }

    public static void initCrafting() {
        GameRegistry.addSmelting(TitanBlocks.copper_ore, new ItemStack(TitanItems.copperIngot), 2.0F);
        GameRegistry.addSmelting(TitanBlocks.tin_ore, new ItemStack(TitanItems.tinIngot), 2.0F);
        GameRegistry.addSmelting(TitanBlocks.chromium_ore, new ItemStack(TitanItems.chromiumIngot), 3.0F);
        GameRegistry.addSmelting(TitanBlocks.magnesium_ore, new ItemStack(TitanItems.magnesiumIngot), 3.0F);
        GameRegistry.addSmelting(TitanBlocks.lead_ore, new ItemStack(TitanItems.leadIngot), 3.0F);
        GameRegistry.addSmelting(TitanBlocks.silver_ore, new ItemStack(TitanItems.silverIngot), 5.0F);
        GameRegistry.addSmelting(TitanBlocks.platinum_ore, new ItemStack(TitanItems.platinumIngot), 10.0F);
        GameRegistry.addShapelessRecipe(new ItemStack(TitanItems.pleasantBladeBrew, 1), new Object[]{TitanItems.pleasantBladeLeaf, Items.field_151069_bo, Items.field_151172_bF, Items.field_151071_bq});
        GameRegistry.addShapelessRecipe(new ItemStack(TitanItems.steelIngot, 1), new Object[]{TitanItems.chromiumIngot, TitanItems.magnesiumIngot, Items.field_151042_j, Items.field_151044_h});
        GameRegistry.addShapelessRecipe(new ItemStack(TitanItems.bronzeIngot, 1), new Object[]{TitanItems.copperIngot, TitanItems.tinIngot});
        GameRegistry.addShapelessRecipe(new ItemStack(TitanItems.diamondString, 4), new Object[]{Items.field_151045_i, Items.field_151045_i});
        GameRegistry.addShapelessRecipe(new ItemStack(TitanItems.harcadiumWaflet, 9), new Object[]{TitanItems.harcadiumWafer});
        GameRegistry.addShapelessRecipe(new ItemStack(TitanItems.harcadiumWafer, 9), new Object[]{TitanItems.harcadiumNugget});
        GameRegistry.addShapelessRecipe(new ItemStack(TitanItems.harcadiumNugget, 9), new Object[]{TitanItems.harcadium});
        GameRegistry.addShapelessRecipe(new ItemStack(TitanItems.harcadium, 9), new Object[]{TitanBlocks.harcadium_block});
        GameRegistry.addShapelessRecipe(new ItemStack(TitanItems.voidItem, 9), new Object[]{TitanBlocks.void_block});
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.field_150357_h, 9), new Object[]{TitanBlocks.bedrock_block});
        GameRegistry.addShapedRecipe(new ItemStack(Items.field_151079_bi, 64), new Object[]{"HHH", "H H", "HHH", 'H', TitanItems.harcadiumWaflet});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.harcadiumWafer), new Object[]{"HHH", "HHH", "HHH", 'H', TitanItems.harcadiumWaflet});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.harcadiumNugget), new Object[]{"HHH", "HHH", "HHH", 'H', TitanItems.harcadiumWafer});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.harcadium), new Object[]{"HHH", "HHH", "HHH", 'H', TitanItems.harcadiumNugget});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.goldenCookie, 1, 0), new Object[]{"GGG", "GPG", "GGG", 'G', Items.field_151043_k, 'P', Items.field_151106_aX});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.goldenCookie, 1, 1), new Object[]{"GGG", "GPG", "GGG", 'G', Blocks.field_150340_R, 'P', Items.field_151106_aX});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.goldenBread, 1, 0), new Object[]{"GGG", "GPG", "GGG", 'G', Items.field_151043_k, 'P', Items.field_151025_P});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.goldenBread, 1, 1), new Object[]{"GGG", "GPG", "GGG", 'G', Blocks.field_150340_R, 'P', Items.field_151025_P});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.goldenPotatoe, 1, 0), new Object[]{"GGG", "GPG", "GGG", 'G', Items.field_151043_k, 'P', Items.field_151168_bH});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.goldenPotatoe, 1, 1), new Object[]{"GGG", "GPG", "GGG", 'G', Blocks.field_150340_R, 'P', Items.field_151168_bH});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.goldenMelon, 1, 0), new Object[]{"GGG", "GPG", "GGG", 'G', Items.field_151043_k, 'P', Items.field_151127_ba});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.goldenMelon, 1, 1), new Object[]{"GGG", "GPG", "GGG", 'G', Blocks.field_150340_R, 'P', Items.field_151127_ba});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.goldenPumpkinPie, 1, 0), new Object[]{"GGG", "GPG", "GGG", 'G', Items.field_151043_k, 'P', Items.field_151158_bO});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.goldenPumpkinPie, 1, 1), new Object[]{"GGG", "GPG", "GGG", 'G', Blocks.field_150340_R, 'P', Items.field_151158_bO});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.diamondApple, 1, 0), new Object[]{"GGG", "GPG", "GGG", 'G', Items.field_151045_i, 'P', Items.field_151034_e});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.diamondApple, 1, 1), new Object[]{"GGG", "GPG", "GGG", 'G', Blocks.field_150484_ah, 'P', Items.field_151034_e});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.diamondCookie, 1, 0), new Object[]{"GGG", "GPG", "GGG", 'G', Items.field_151045_i, 'P', Items.field_151106_aX});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.diamondCookie, 1, 1), new Object[]{"GGG", "GPG", "GGG", 'G', Blocks.field_150484_ah, 'P', Items.field_151106_aX});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.diamondBread, 1, 0), new Object[]{"GGG", "GPG", "GGG", 'G', Items.field_151045_i, 'P', Items.field_151025_P});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.diamondBread, 1, 1), new Object[]{"GGG", "GPG", "GGG", 'G', Blocks.field_150484_ah, 'P', Items.field_151025_P});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.diamondPotatoe, 1, 0), new Object[]{"GGG", "GPG", "GGG", 'G', Items.field_151045_i, 'P', Items.field_151168_bH});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.diamondPotatoe, 1, 1), new Object[]{"GGG", "GPG", "GGG", 'G', Blocks.field_150484_ah, 'P', Items.field_151168_bH});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.diamondMelon, 1, 0), new Object[]{"GGG", "GPG", "GGG", 'G', Items.field_151045_i, 'P', Items.field_151127_ba});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.diamondMelon, 1, 1), new Object[]{"GGG", "GPG", "GGG", 'G', Blocks.field_150484_ah, 'P', Items.field_151127_ba});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.diamondPumpkinPie, 1, 0), new Object[]{"GGG", "GPG", "GGG", 'G', Items.field_151045_i, 'P', Items.field_151158_bO});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.diamondPumpkinPie, 1, 1), new Object[]{"GGG", "GPG", "GGG", 'G', Blocks.field_150484_ah, 'P', Items.field_151158_bO});
        GameRegistry.addShapedRecipe(new ItemStack(TitanBlocks.harcadium_block), new Object[]{"HHH", "HHH", "HHH", 'H', TitanItems.harcadium});
        GameRegistry.addShapedRecipe(new ItemStack(TitanBlocks.void_block), new Object[]{"HHH", "HHH", "HHH", 'H', TitanItems.voidItem});
        GameRegistry.addShapedRecipe(new ItemStack(TitanBlocks.bedrock_block), new Object[]{"HHH", "HHH", "HHH", 'H', Blocks.field_150357_h});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.copperAxe), new Object[]{"HH ", "HD ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.copperIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.copperPickaxe), new Object[]{"HHH", " D ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.copperIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.copperSpade), new Object[]{" H ", " D ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.copperIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.copperHoe), new Object[]{"HH ", " D ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.copperIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.copperSword), new Object[]{" H ", " H ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.copperIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.copperHelmet), new Object[]{"HHH", "H H", 'H', TitanItems.copperIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.copperChestplate), new Object[]{"H H", "HHH", "HHH", 'H', TitanItems.copperIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.copperLeggings), new Object[]{"HHH", "H H", "H H", 'H', TitanItems.copperIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.copperBoots), new Object[]{"H H", "H H", 'H', TitanItems.copperIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.tinAxe), new Object[]{"HH ", "HD ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.tinIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.tinPickaxe), new Object[]{"HHH", " D ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.tinIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.tinSpade), new Object[]{" H ", " D ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.tinIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.tinHoe), new Object[]{"HH ", " D ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.tinIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.tinSword), new Object[]{" H ", " H ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.tinIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.tinHelmet), new Object[]{"HHH", "H H", 'H', TitanItems.tinIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.tinChestplate), new Object[]{"H H", "HHH", "HHH", 'H', TitanItems.tinIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.tinLeggings), new Object[]{"HHH", "H H", "H H", 'H', TitanItems.tinIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.tinBoots), new Object[]{"H H", "H H", 'H', TitanItems.tinIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.bronzeAxe), new Object[]{"HH ", "HD ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.bronzePickaxe), new Object[]{"HHH", " D ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.bronzeSpade), new Object[]{" H ", " D ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.bronzeHoe), new Object[]{"HH ", " D ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.bronzeSword), new Object[]{" H ", " H ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.bronzeHelmet), new Object[]{"HHH", "H H", 'H', TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.bronzeChestplate), new Object[]{"H H", "HHH", "HHH", 'H', TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.bronzeLeggings), new Object[]{"HHH", "H H", "H H", 'H', TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.bronzeBoots), new Object[]{"H H", "H H", 'H', TitanItems.bronzeIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.steelAxe), new Object[]{"HH ", "HD ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.steelIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.steelPickaxe), new Object[]{"HHH", " D ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.steelIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.steelSpade), new Object[]{" H ", " D ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.steelIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.steelHoe), new Object[]{"HH ", " D ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.steelIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.steelSword), new Object[]{" H ", " H ", " D ", 'D', Items.field_151055_y, 'H', TitanItems.steelIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.steelHelmet), new Object[]{"HHH", "H H", 'H', TitanItems.steelIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.steelChestplate), new Object[]{"H H", "HHH", "HHH", 'H', TitanItems.steelIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.steelLeggings), new Object[]{"HHH", "H H", "H H", 'H', TitanItems.steelIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.steelBoots), new Object[]{"H H", "H H", 'H', TitanItems.steelIngot});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.harcadiumAxe), new Object[]{"HH ", "HD ", " D ", 'D', Items.field_151045_i, 'H', TitanItems.harcadium});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.harcadiumPickaxe), new Object[]{"HHH", " D ", " D ", 'D', Items.field_151045_i, 'H', TitanItems.harcadium});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.harcadiumSpade), new Object[]{" H ", " D ", " D ", 'D', Items.field_151045_i, 'H', TitanItems.harcadium});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.harcadiumHoe), new Object[]{"HH ", " D ", " D ", 'D', Items.field_151045_i, 'H', TitanItems.harcadium});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.harcadiumSword), new Object[]{" H ", " H ", " D ", 'D', Items.field_151045_i, 'H', TitanItems.harcadium});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.harcadiumHelmet), new Object[]{"HHH", "H H", 'H', TitanItems.harcadium});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.harcadiumChestplate), new Object[]{"H H", "HHH", "HHH", 'H', TitanItems.harcadium});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.harcadiumLeggings), new Object[]{"HHH", "H H", "H H", 'H', TitanItems.harcadium});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.harcadiumBoots), new Object[]{"H H", "H H", 'H', TitanItems.harcadium});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.growthSerum, 2), new Object[]{"RNR", "FBF", "GRG", 'R', Items.field_151078_bh, 'N', Items.field_151156_bN, 'F', Items.field_151059_bz, 'B', Items.field_151069_bo, 'G', Items.field_151073_bk});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.teleporter), new Object[]{"WWW", "SSS", " S ", 'W', new ItemStack(Items.field_151144_bL, 1, 1), 'S', Blocks.field_150425_aM});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.teleporter2), new Object[]{"GOG", "ONO", "GOG", 'G', Blocks.field_150340_R, 'O', Blocks.field_150343_Z, 'N', Items.field_151156_bN});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.goodTurret), new Object[]{"S", "O", "B", 'S', new ItemStack(Items.field_151144_bL, 1, 1), 'O', Blocks.field_150343_Z, 'B', Blocks.field_150357_h});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.goodTurret2), new Object[]{"SOS", " B ", 'S', new ItemStack(Items.field_151144_bL, 1, 1), 'O', Blocks.field_150343_Z, 'B', Blocks.field_150357_h});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.goodTurret3), new Object[]{" A ", "NBN", " G ", 'A', TitanItems.goodTurret, 'G', TitanItems.goodTurret2, 'B', Blocks.field_150461_bJ, 'N', Items.field_151156_bN});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.chaff, 8), new Object[]{"PWP", "WPW", "PWP", 'P', Items.field_151121_aF, 'W', Items.field_151015_O});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.harcadiumBow), new Object[]{" HS", "H S", " HS", 'S', TitanItems.diamondString, 'H', TitanItems.harcadium});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.harcadiumArrow, 4), new Object[]{"H", "D", "F", 'H', TitanItems.harcadium, 'D', Items.field_151045_i, 'F', Items.field_151008_G});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.adminiumAxe), new Object[]{"HH ", "HD ", " D ", 'D', Blocks.field_150357_h, 'H', TitanBlocks.bedrock_block});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.adminiumPickaxe), new Object[]{"HHH", " D ", " D ", 'D', Blocks.field_150357_h, 'H', TitanBlocks.bedrock_block});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.adminiumSpade), new Object[]{" H ", " D ", " D ", 'D', Blocks.field_150357_h, 'H', TitanBlocks.bedrock_block});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.adminiumHoe), new Object[]{"HH ", " D ", " D ", 'D', Blocks.field_150357_h, 'H', TitanBlocks.bedrock_block});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.adminiumSword), new Object[]{" H ", " H ", " D ", 'D', Blocks.field_150357_h, 'H', TitanBlocks.bedrock_block});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.adminiumHelmet), new Object[]{"BBB", "B B", 'B', new ItemStack(TitanBlocks.bedrock_block)});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.adminiumChestplate), new Object[]{"H H", "BVB", "BBB", 'B', new ItemStack(TitanBlocks.bedrock_block), 'V', TitanBlocks.void_block, 'H', TitanBlocks.harcadium_block});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.adminiumLeggings), new Object[]{"BHB", "B B", "B B", 'B', new ItemStack(TitanBlocks.bedrock_block), 'H', TitanBlocks.harcadium_block});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.adminiumBoots), new Object[]{"B B", "B B", 'B', new ItemStack(TitanBlocks.bedrock_block)});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.voidAxe), new Object[]{"HH ", "HD ", " D ", 'D', TitanItems.harcadium, 'H', TitanItems.voidItem});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.voidPickaxe), new Object[]{"HHH", " D ", " D ", 'D', TitanItems.harcadium, 'H', TitanItems.voidItem});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.voidSpade), new Object[]{" H ", " D ", " D ", 'D', TitanItems.harcadium, 'H', TitanItems.voidItem});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.voidHoe), new Object[]{"HH ", " D ", " D ", 'D', TitanItems.harcadium, 'H', TitanItems.voidItem});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.voidSword), new Object[]{" H ", " H ", " D ", 'D', TitanItems.harcadium, 'H', TitanItems.voidItem});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.voidHelmet), new Object[]{"HHH", "H H", 'H', TitanItems.voidItem});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.voidChestplate), new Object[]{"H H", "HHH", "HHH", 'H', TitanItems.voidItem});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.voidLeggings), new Object[]{"HHH", "H H", "H H", 'H', TitanItems.voidItem});
        GameRegistry.addShapedRecipe(new ItemStack(TitanItems.voidBoots), new Object[]{"H H", "H H", 'H', TitanItems.voidItem});
        if (Loader.isModLoaded("OreSpawn")) {
            GameRegistry.addShapelessRecipe(new ItemStack(TitanItems.OverlordScorpionEgg), new Object[]{TitanBlocks.MyOverlordScorpionSpawnBlock, Items.field_151131_as});
            GameRegistry.addShapelessRecipe(new ItemStack(TitanItems.MethuselahKrakenEgg), new Object[]{TitanBlocks.MyMethuselahKrakenSpawnBlock, Items.field_151131_as});
            GameRegistry.addShapedRecipe(new ItemStack(TitanBlocks.MyMethuselahKrakenSpawnBlock), new Object[]{"HHH", "HHH", "HHH", 'H', TitanBlocks.MyMethuselahKrakenPartSpawnBlock});
            GameRegistry.addShapedRecipe(new ItemStack(TitanBlocks.MyOverlordScorpionSpawnBlock), new Object[]{"HHH", "HHH", "HHH", 'H', TitanBlocks.MyOverlordScorpionPartSpawnBlock});
        }

    }
}
