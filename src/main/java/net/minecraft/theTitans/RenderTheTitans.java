//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.orespawnaddon.EntityMethuselahKraken;
import net.minecraft.entity.orespawnaddon.EntityOverlordScorpion;
import net.minecraft.entity.titan.EntityBlazeTitan;
import net.minecraft.entity.titan.EntityCaveSpiderTitan;
import net.minecraft.entity.titan.EntityChaff;
import net.minecraft.entity.titan.EntityCreeperTitan;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titan.EntityEnderColossusCrystal;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.entity.titan.EntityGargoyleTitanFireball;
import net.minecraft.entity.titan.EntityGhastTitan;
import net.minecraft.entity.titan.EntityGrowthSerum;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityLavaSpit;
import net.minecraft.entity.titan.EntityLightningBall;
import net.minecraft.entity.titan.EntityMagmaCubeTitan;
import net.minecraft.entity.titan.EntityPigZombieTitan;
import net.minecraft.entity.titan.EntityProtoBall;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.entity.titan.EntitySkeletonTitanGiantArrow;
import net.minecraft.entity.titan.EntitySlimeTitan;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.entity.titan.EntityTitanFireball;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityWebShot;
import net.minecraft.entity.titan.EntityWitherTurret;
import net.minecraft.entity.titan.EntityWitherTurretGround;
import net.minecraft.entity.titan.EntityWitherTurretMortar;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.entity.titan.EntityWitherzillaMinion;
import net.minecraft.entity.titan.EntityXPBomb;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.entity.titanminion.EntityBlazeMinion;
import net.minecraft.entity.titanminion.EntityCaveSpiderMinion;
import net.minecraft.entity.titanminion.EntityCreeperMinion;
import net.minecraft.entity.titanminion.EntityDragonMinion;
import net.minecraft.entity.titanminion.EntityEndermanMinion;
import net.minecraft.entity.titanminion.EntityGhastGuard;
import net.minecraft.entity.titanminion.EntityGhastMinion;
import net.minecraft.entity.titanminion.EntityGiantZombieBetter;
import net.minecraft.entity.titanminion.EntityPigZombieMinion;
import net.minecraft.entity.titanminion.EntitySilverfishMinion;
import net.minecraft.entity.titanminion.EntitySkeletonMinion;
import net.minecraft.entity.titanminion.EntitySpiderMinion;
import net.minecraft.entity.titanminion.EntityWitherMinion;
import net.minecraft.entity.titanminion.EntityZombieMinion;
import net.minecraft.world.biome.BiomeGenBase;

public class RenderTheTitans {
    public RenderTheTitans() {
    }

    public static void TheTitans() {
    }

    public static void registerEntity() {
        createEntityWithEgg(EntitySilverfishMinion.class, "SilverfishMinion", 7237230, 3158064);
        createEntityWithEgg(EntityCaveSpiderMinion.class, "CaveSpiderMinion", 803406, 11013646);
        createEntityWithEgg(EntitySpiderMinion.class, "SpiderMinion", 3419431, 11013646);
        createEntityWithEgg(EntityZombieMinion.class, "ZombieMinion", 44975, 7969893);
        createEntityWithEgg(EntityGiantZombieBetter.class, "GiantMinion", 44975, 5870909);
        createEntityWithEgg(EntitySkeletonMinion.class, "SkeletonMinion", 12698049, 4802889);
        createEntityWithEgg(EntityWitherMinion.class, "WitherMinion", 1315860, 1842204);
        createEntityWithEgg(EntityCreeperMinion.class, "CreeperMinion", 894731, 0);
        createEntityWithEgg(EntityPigZombieMinion.class, "PigZombieMinion", 15373203, 5009705);
        createEntityWithEgg(EntityGhastGuard.class, "GhastGuard", 16382457, 12369084);
        createEntityWithEgg(EntityBlazeMinion.class, "BlazeMinion", 16167425, 16775294);
        createEntityWithEgg(EntityGhastMinion.class, "GhastMinion", 16382457, 12369084);
        createEntityWithEgg(EntityEndermanMinion.class, "EndermanMinion", 1447446, 0);
        createEntityWithEgg(EntityDragonMinion.class, "EnderDragonMinion", 1447446, 13369594);
        createEntityWithEgg(EntityEnderColossusCrystal.class, "EnderColossusCrystal", 15658734, 13369594);
        createEntityWithEgg(EntityWitherTurret.class, "WitherTurret", 1315860, 1842204);
        createEntityWithEgg(EntityWitherTurretGround.class, "WitherTurretGround", 1315860, 1842204);
        createEntityWithEgg(EntityWitherTurretMortar.class, "WitherTurretMortar", 1315860, 1842204);
        createEntityWithEgg(EntityWitherzillaMinion.class, "WitherBossMinion", 1315860, 1842204);
        createEgg(53, 44975, 5870909);
        createEgg(63, 1447446, 13369594);
        createEgg(64, 1315860, 1842204);
        if (Loader.isModLoaded("OreSpawn")) {
            createEntity(EntityOverlordScorpion.class, "OverlordScorpion");
            createEntity(EntityMethuselahKraken.class, "MethuselahKraken");
        }

        createProjectile(EntityGrowthSerum.class, "GrowthSerum");
        createEntity(EntityChaff.class, "Chaff");
        createProjectile(EntityTitanFireball.class, "TitanFireball");
        createProjectile(EntityGargoyleTitanFireball.class, "GargoyleTitanFireball");
        createProjectile(EntityLavaSpit.class, "LavaSpit");
        createEntity(EntityGammaLightning.class, "GammaLightning");
        createEntity(EntityTitanPart.class, "TitanPart");
        createProjectile(EntityWebShot.class, "WebShot");
        createProjectile(EntityXPBomb.class, "XPBomb");
        createProjectile(EntityLightningBall.class, "LightningBall");
        createProjectile(EntityProtoBall.class, "ProtoBall");
        createEntity(EntityTitanSpirit.class, "TitanSpirit");
        createProjectile(EntityHarcadiumArrow.class, "ArrowHarcadium");
        createProjectile(EntitySkeletonTitanGiantArrow.class, "ArrowGiant");
        createTitan(EntitySnowGolemTitan.class, "SnowManTitan");
        createTitan(EntitySlimeTitan.class, "SlimeTitan");
        createTitan(EntityMagmaCubeTitan.class, "LavaSlimeTitan");
        createTitan(EntitySilverfishTitan.class, "SilverfishTitan");
        createTitan(EntityCaveSpiderTitan.class, "CaveSpiderTitan");
        createTitan(EntitySpiderTitan.class, "SpiderTitan");
        createTitan(EntitySkeletonTitan.class, "SkeletonTitan");
        createTitan(EntityZombieTitan.class, "ZombieTitan");
        createTitan(EntityCreeperTitan.class, "CreeperTitan");
        createTitan(EntityPigZombieTitan.class, "PigZombieTitan");
        createTitan(EntityBlazeTitan.class, "BlazeTitan");
        createTitan(EntityGhastTitan.class, "GhastTitan");
        createTitan(EntityEnderColossus.class, "EndermanTitan");
        createTitan(EntityIronGolemTitan.class, "VillagerGolemTitan");
        createTitan(EntityWitherzilla.class, "WitherBossTitan");
        EntityRegistry.addSpawn(EntityBlaze.class, 50, 2, 2, EnumCreatureType.monster, new BiomeGenBase[]{BiomeGenBase.field_76778_j});
        EntityRegistry.addSpawn(EntitySkeleton.class, 20, 1, 4, EnumCreatureType.monster, new BiomeGenBase[]{BiomeGenBase.field_76778_j});
        EntityRegistry.addSpawn(EntityWither.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[]{BiomeGenBase.field_76778_j});
        EntityRegistry.addSpawn(EntityIronGolem.class, 1, 1, 1, EnumCreatureType.creature, new BiomeGenBase[]{BiomeGenBase.field_76772_c, BiomeGenBase.field_76769_d, BiomeGenBase.field_150588_X});
        EntityRegistry.addSpawn(EntitySilverfish.class, 100, 4, 4, EnumCreatureType.monster, getSpawnBiomes());
        EntityRegistry.addSpawn(EntityCaveSpider.class, 100, 4, 4, EnumCreatureType.monster, getSpawnBiomes());
        EntityRegistry.addSpawn(EntityGiantZombieBetter.class, 1, 1, 1, EnumCreatureType.monster, getSpawnBiomes());
        EntityRegistry.addSpawn(EntityZombieMinion.class, 100, 4, 4, EnumCreatureType.monster, getSpawnBiomes());
        EntityRegistry.addSpawn(EntitySpiderMinion.class, 100, 4, 4, EnumCreatureType.monster, getSpawnBiomes());
        EntityRegistry.addSpawn(EntitySkeletonMinion.class, 100, 4, 4, EnumCreatureType.monster, getSpawnBiomePlusHell());
        EntityRegistry.addSpawn(EntityCreeperMinion.class, 100, 4, 4, EnumCreatureType.monster, getSpawnBiomes());
        EntityRegistry.addSpawn(EntitySilverfishMinion.class, 100, 4, 4, EnumCreatureType.monster, getSpawnBiomes());
        EntityRegistry.addSpawn(EntityCaveSpiderMinion.class, 100, 4, 4, EnumCreatureType.monster, getSpawnBiomes());
        EntityRegistry.addSpawn(EntityEndermanMinion.class, 10, 4, 4, EnumCreatureType.monster, getSpawnBiomesPlusEnd());
        EntityRegistry.addSpawn(EntityBlazeMinion.class, 100, 4, 4, EnumCreatureType.monster, new BiomeGenBase[]{BiomeGenBase.field_76778_j});
        EntityRegistry.addSpawn(EntityPigZombieMinion.class, 100, 4, 4, EnumCreatureType.monster, new BiomeGenBase[]{BiomeGenBase.field_76778_j});
        EntityRegistry.addSpawn(EntityGhastMinion.class, 100, 4, 4, EnumCreatureType.monster, new BiomeGenBase[]{BiomeGenBase.field_76778_j});
        EntityRegistry.addSpawn(EntityGhastGuard.class, 100, 1, 1, EnumCreatureType.monster, new BiomeGenBase[]{BiomeGenBase.field_76778_j});
    }

    public static void createEntityWithEgg(Class entityClass, String entityName, int solidColor, int spotColor) {
        int randomId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
        EntityRegistry.registerModEntity(entityClass, entityName, randomId, TheTitans.modInstance, 128, 1, false);
        createEgg(randomId, solidColor, spotColor);
    }

    public static void createEntity(Class entityClass, String entityName) {
        int randomId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
        EntityRegistry.registerModEntity(entityClass, entityName, randomId, TheTitans.modInstance, 128, 1, false);
    }

    public static void createProjectile(Class entityClass, String entityName) {
        int randomId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
        EntityRegistry.registerModEntity(entityClass, entityName, randomId, TheTitans.modInstance, 256, 1, true);
    }

    public static void createTitan(Class entityClass, String entityName) {
        int randomId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
        EntityRegistry.registerModEntity(entityClass, entityName, randomId, TheTitans.modInstance, 1024, 1, true);
    }

    private static void createEgg(int randomId, int solidColor, int spotColor) {
        EntityList.field_75627_a.put(randomId, new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
    }

    public static BiomeGenBase[] getSpawnBiomes() {
        return new BiomeGenBase[]{BiomeGenBase.field_76771_b, BiomeGenBase.field_76772_c, BiomeGenBase.field_76769_d, BiomeGenBase.field_76770_e, BiomeGenBase.field_76767_f, BiomeGenBase.field_76768_g, BiomeGenBase.field_76780_h, BiomeGenBase.field_76781_i, BiomeGenBase.field_76776_l, BiomeGenBase.field_76777_m, BiomeGenBase.field_76774_n, BiomeGenBase.field_76775_o, BiomeGenBase.field_76787_r, BiomeGenBase.field_76786_s, BiomeGenBase.field_76785_t, BiomeGenBase.field_76784_u, BiomeGenBase.field_76783_v, BiomeGenBase.field_76782_w, BiomeGenBase.field_76792_x, BiomeGenBase.field_150574_L, BiomeGenBase.field_150575_M, BiomeGenBase.field_150576_N, BiomeGenBase.field_150577_O, BiomeGenBase.field_150583_P, BiomeGenBase.field_150582_Q, BiomeGenBase.field_150585_R, BiomeGenBase.field_150584_S, BiomeGenBase.field_150579_T, BiomeGenBase.field_150578_U, BiomeGenBase.field_150581_V, BiomeGenBase.field_150580_W, BiomeGenBase.field_150588_X, BiomeGenBase.field_150587_Y, BiomeGenBase.field_150589_Z, BiomeGenBase.field_150607_aa, BiomeGenBase.field_150608_ab};
    }

    public static BiomeGenBase[] getSpawnBiomePlusHell() {
        return new BiomeGenBase[]{BiomeGenBase.field_76771_b, BiomeGenBase.field_76772_c, BiomeGenBase.field_76769_d, BiomeGenBase.field_76770_e, BiomeGenBase.field_76767_f, BiomeGenBase.field_76768_g, BiomeGenBase.field_76780_h, BiomeGenBase.field_76781_i, BiomeGenBase.field_76776_l, BiomeGenBase.field_76777_m, BiomeGenBase.field_76774_n, BiomeGenBase.field_76775_o, BiomeGenBase.field_76787_r, BiomeGenBase.field_76786_s, BiomeGenBase.field_76785_t, BiomeGenBase.field_76784_u, BiomeGenBase.field_76783_v, BiomeGenBase.field_76782_w, BiomeGenBase.field_76792_x, BiomeGenBase.field_150574_L, BiomeGenBase.field_150575_M, BiomeGenBase.field_150576_N, BiomeGenBase.field_150577_O, BiomeGenBase.field_150583_P, BiomeGenBase.field_150582_Q, BiomeGenBase.field_150585_R, BiomeGenBase.field_150584_S, BiomeGenBase.field_150579_T, BiomeGenBase.field_150578_U, BiomeGenBase.field_150581_V, BiomeGenBase.field_150580_W, BiomeGenBase.field_150588_X, BiomeGenBase.field_150587_Y, BiomeGenBase.field_150589_Z, BiomeGenBase.field_150607_aa, BiomeGenBase.field_150608_ab, BiomeGenBase.field_76778_j};
    }

    public static BiomeGenBase[] getSpawnBiomesPlusEnd() {
        return new BiomeGenBase[]{BiomeGenBase.field_76771_b, BiomeGenBase.field_76772_c, BiomeGenBase.field_76769_d, BiomeGenBase.field_76770_e, BiomeGenBase.field_76767_f, BiomeGenBase.field_76768_g, BiomeGenBase.field_76780_h, BiomeGenBase.field_76781_i, BiomeGenBase.field_76776_l, BiomeGenBase.field_76777_m, BiomeGenBase.field_76774_n, BiomeGenBase.field_76775_o, BiomeGenBase.field_76787_r, BiomeGenBase.field_76786_s, BiomeGenBase.field_76785_t, BiomeGenBase.field_76784_u, BiomeGenBase.field_76783_v, BiomeGenBase.field_76782_w, BiomeGenBase.field_76792_x, BiomeGenBase.field_150574_L, BiomeGenBase.field_150575_M, BiomeGenBase.field_150576_N, BiomeGenBase.field_150577_O, BiomeGenBase.field_150583_P, BiomeGenBase.field_150582_Q, BiomeGenBase.field_150585_R, BiomeGenBase.field_150584_S, BiomeGenBase.field_150579_T, BiomeGenBase.field_150578_U, BiomeGenBase.field_150581_V, BiomeGenBase.field_150580_W, BiomeGenBase.field_150588_X, BiomeGenBase.field_150587_Y, BiomeGenBase.field_150589_Z, BiomeGenBase.field_150607_aa, BiomeGenBase.field_150608_ab, BiomeGenBase.field_76779_k};
    }
}
