//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class TitansAchievments {
    public static Achievement harcadium;
    public static Achievement harcadiumArmor;
    public static Achievement harcadiumSword;
    public static Achievement harcadiumBow;
    public static Achievement harcadiumArrows;
    public static Achievement locateTitan;
    public static Achievement voidEssence;
    public static Achievement voidArmor;
    public static Achievement omegafish;
    public static Achievement cavespidertitan;
    public static Achievement slimetitan;
    public static Achievement magmacubetitan;
    public static Achievement spidertitan;
    public static Achievement spiderjockeytitan;
    public static Achievement zombietitan;
    public static Achievement skeletontitan;
    public static Achievement creepertitan;
    public static Achievement pigzombietitan;
    public static Achievement blazetitan;
    public static Achievement witherskeletontitan;
    public static Achievement ghasttitan;
    public static Achievement endercolossus;
    public static Achievement adminiumArmor;
    public static Achievement adamantium;
    public static Achievement adamantiumSword;
    public static Achievement voidTime;
    public static Achievement witherzilla;
    public static Achievement witherzilla2;
    public static Achievement nowhereTime;
    public static Achievement executorDragon;
    public static Achievement executorDragon2;
    public static Achievement ultimaBlade;

    public TitansAchievments() {
    }

    public static void addAchievments() {
        AchievementPage.registerAchievementPage(new AchievementPage("The Titans", new Achievement[]{harcadium, harcadiumArmor, harcadiumSword, harcadiumBow, harcadiumArrows, locateTitan, voidEssence, voidArmor, omegafish, cavespidertitan, slimetitan, magmacubetitan, spidertitan, spiderjockeytitan, zombietitan, skeletontitan, creepertitan, pigzombietitan, blazetitan, witherskeletontitan, ghasttitan, endercolossus, adminiumArmor, adamantium, adamantiumSword, voidTime, witherzilla, witherzilla2, nowhereTime, executorDragon, executorDragon2, ultimaBlade}));
    }

    static {
        harcadium = (new Achievement("achievement.harcadium", "harcadium", -4, 0, TitanItems.harcadium, (Achievement)null)).func_75966_h().func_75971_g();
        harcadiumArmor = (new Achievement("achievement.harcadiumArmor", "harcadiumArmor", -3, 0, TitanItems.harcadiumChestplate, harcadium)).func_75971_g();
        harcadiumSword = (new Achievement("achievement.harcadiumSword", "harcadiumSword", -2, 0, TitanItems.harcadiumSword, harcadiumArmor)).func_75971_g();
        harcadiumBow = (new Achievement("achievement.harcadiumBow", "harcadiumBow", -1, 0, TitanItems.harcadiumBow, harcadiumSword)).func_75971_g();
        harcadiumArrows = (new Achievement("achievement.harcadiumArrows", "harcadiumArrows", 0, 0, TitanItems.harcadiumArrow, harcadiumBow)).func_75971_g();
        locateTitan = (new Achievement("achievement.locateTitan", "locateTitan", 1, 0, TitanItems.growthSerum, harcadiumArrows)).func_75971_g();
        voidEssence = (new Achievement("achievement.voidEssence", "voidEssence", 0, -2, TitanItems.voidItem, locateTitan)).func_75971_g();
        voidArmor = (new Achievement("achievement.voidArmor", "voidArmor", 0, -3, TitanItems.voidChestplate, voidEssence)).func_75971_g();
        omegafish = (new Achievement("achievement.omegafish", "omegafish", 2, 0, TitanItems.eggOmegafish, locateTitan)).func_75971_g().func_75987_b();
        cavespidertitan = (new Achievement("achievement.cavespidertitan", "cavespidertitan", 2, 1, TitanItems.eggCaveSpiderTitan, locateTitan)).func_75971_g().func_75987_b();
        slimetitan = (new Achievement("achievement.slimetitan", "slimetitan", 2, 2, TitanItems.eggSlimeTitan, locateTitan)).func_75971_g().func_75987_b();
        magmacubetitan = (new Achievement("achievement.magmacubetitan", "magmacubetitan", 2, 3, TitanItems.eggMagmaCubeTitan, locateTitan)).func_75971_g().func_75987_b();
        spidertitan = (new Achievement("achievement.spidertitan", "spidertitan", 2, 4, TitanItems.eggSpiderTitan, locateTitan)).func_75971_g().func_75987_b();
        spiderjockeytitan = (new Achievement("achievement.spiderjockeytitan", "spiderjockeytitan", 2, 5, TitanItems.eggSpiderJockeyTitan, locateTitan)).func_75971_g().func_75987_b();
        zombietitan = (new Achievement("achievement.zombietitan", "zombietitan", 2, -1, TitanItems.eggZombieTitan, locateTitan)).func_75971_g().func_75987_b();
        skeletontitan = (new Achievement("achievement.skeletontitan", "skeletontitan", 2, -2, TitanItems.eggSkeletonTitan, locateTitan)).func_75971_g().func_75987_b();
        creepertitan = (new Achievement("achievement.creepertitan", "creepertitan", 2, -3, TitanItems.eggCreeperTitan, locateTitan)).func_75971_g().func_75987_b();
        pigzombietitan = (new Achievement("achievement.pigzombietitan", "pigzombietitan", 2, -4, TitanItems.eggZombiePigmanTitan, locateTitan)).func_75971_g().func_75987_b();
        blazetitan = (new Achievement("achievement.blazetitan", "blazetitan", 2, -5, TitanItems.eggBlazeTitan, locateTitan)).func_75971_g().func_75987_b();
        witherskeletontitan = (new Achievement("achievement.witherskeletontitan", "witherskeletontitan", 2, -6, TitanItems.eggWitherSkeletonTitan, locateTitan)).func_75971_g().func_75987_b();
        ghasttitan = (new Achievement("achievement.ghasttitan", "ghasttitan", 2, -7, TitanItems.eggGhastTitan, locateTitan)).func_75971_g().func_75987_b();
        endercolossus = (new Achievement("achievement.endercolossus", "endercolossus", 3, 0, TitanItems.eggEnderColossus, locateTitan)).func_75971_g().func_75987_b();
        adminiumArmor = (new Achievement("achievement.adminiumArmor", "adminiumArmor", 4, 0, TitanItems.adminiumChestplate, endercolossus)).func_75971_g().func_75987_b();
        adamantium = (new Achievement("achievement.adamantium", "adamantium", 4, 1, TitanItems.voidItem, adminiumArmor)).func_75971_g().func_75987_b();
        adamantiumSword = (new Achievement("achievement.adamantiumSword", "adamantiumSword", 5, 2, TitanItems.voidChestplate, adamantium)).func_75971_g().func_75987_b();
        voidTime = (new Achievement("achievement.voidTime", "voidTime", 6, 2, TitanItems.teleporter, adminiumArmor)).func_75971_g().func_75987_b();
        witherzilla = (new Achievement("achievement.witherzilla", "witherzilla", 8, 2, TitanItems.malgrum, voidTime)).func_75971_g().func_75987_b();
        witherzilla2 = (new Achievement("achievement.witherzilla2", "witherzilla2", 10, 2, TitanItems.eggWitherzilla, witherzilla)).func_75971_g().func_75987_b();
        nowhereTime = (new Achievement("achievement.nowhereTime", "nowhereTime", 6, -2, TitanItems.teleporter2, adminiumArmor)).func_75971_g().func_75987_b();
        executorDragon = (new Achievement("achievement.executorDragon", "executorDragon", 8, -2, TitanItems.malgrum, nowhereTime)).func_75971_g().func_75987_b();
        executorDragon2 = (new Achievement("achievement.executorDragon2", "executorDragon2", 10, -2, TitanItems.eggWitherzilla, executorDragon)).func_75971_g().func_75987_b();
        ultimaBlade = (new Achievement("achievement.ultimaBlade", "ultimaBlade", 9, 0, TitanItems.ultimaBlade, (Achievement)null)).func_75966_h().func_75971_g().func_75987_b();
    }
}
