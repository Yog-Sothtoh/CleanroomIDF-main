//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderGiantZombie;
import net.minecraft.client.renderer.entity.RenderSnowball;
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
import net.minecraft.potion.Potion;
import net.minecraft.theTitans.models.ModelSlimeTitan;
import net.minecraft.theTitans.render.RenderBlazeTitan;
import net.minecraft.theTitans.render.RenderCaveSpiderTitan;
import net.minecraft.theTitans.render.RenderChaff;
import net.minecraft.theTitans.render.RenderCreeperTitan;
import net.minecraft.theTitans.render.RenderDragonMinion;
import net.minecraft.theTitans.render.RenderEnderColossus;
import net.minecraft.theTitans.render.RenderEnderColossusCrystal;
import net.minecraft.theTitans.render.RenderGammaLightning;
import net.minecraft.theTitans.render.RenderGargoyleTitanFireball;
import net.minecraft.theTitans.render.RenderGhastGuard;
import net.minecraft.theTitans.render.RenderGhastTitan;
import net.minecraft.theTitans.render.RenderGiantArrow;
import net.minecraft.theTitans.render.RenderHarcadiumArrow;
import net.minecraft.theTitans.render.RenderLavaSpit;
import net.minecraft.theTitans.render.RenderLightningBall;
import net.minecraft.theTitans.render.RenderMagmaCubeTitan;
import net.minecraft.theTitans.render.RenderMethuselahKraken;
import net.minecraft.theTitans.render.RenderOmegafish;
import net.minecraft.theTitans.render.RenderOverlordScorpion;
import net.minecraft.theTitans.render.RenderProtoBall;
import net.minecraft.theTitans.render.RenderSkeletonTitan;
import net.minecraft.theTitans.render.RenderSlimeTitan;
import net.minecraft.theTitans.render.RenderSnowGolemTitan;
import net.minecraft.theTitans.render.RenderSpiderTitan;
import net.minecraft.theTitans.render.RenderTitanFireball;
import net.minecraft.theTitans.render.RenderTitanPart;
import net.minecraft.theTitans.render.RenderTitanSpirit;
import net.minecraft.theTitans.render.RenderUltimaIronGolemTitan;
import net.minecraft.theTitans.render.RenderWebShot;
import net.minecraft.theTitans.render.RenderWitherMinion;
import net.minecraft.theTitans.render.RenderWitherTurret;
import net.minecraft.theTitans.render.RenderWitherTurretGround;
import net.minecraft.theTitans.render.RenderWitherTurretMortar;
import net.minecraft.theTitans.render.RenderWitherzilla;
import net.minecraft.theTitans.render.RenderWitherzillaMinion;
import net.minecraft.theTitans.render.RenderXPBomb;
import net.minecraft.theTitans.render.RenderZombiePigmanTitan;
import net.minecraft.theTitans.render.RenderZombieTitan;
import net.minecraft.theTitans.render.items.RenderBlazeTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderCaveSpiderTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderChargedCreeperTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderCreeperTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderEnderColossusSpawnEgg;
import net.minecraft.theTitans.render.items.RenderGhastTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderMagmaCubeTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderOmegafishSpawnEgg;
import net.minecraft.theTitans.render.items.RenderOptimaAxe;
import net.minecraft.theTitans.render.items.RenderSkeletonTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderSlimeTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderSnowGolemTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderSpiderJockeyTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderSpiderTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderUltimaBlade;
import net.minecraft.theTitans.render.items.RenderUltimaIronGolemTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderWitherJockeyTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderWitherSkeletonTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderWitherzillaSpawnEgg;
import net.minecraft.theTitans.render.items.RenderZombiePigmanTitanSpawnEgg;
import net.minecraft.theTitans.render.items.RenderZombieTitanSpawnEgg;
import net.minecraft.theTitans.render.minions.RenderBlazeMinion;
import net.minecraft.theTitans.render.minions.RenderCaveSpiderMinion;
import net.minecraft.theTitans.render.minions.RenderCreeperMinion;
import net.minecraft.theTitans.render.minions.RenderEndermanMinion;
import net.minecraft.theTitans.render.minions.RenderGhastMinion;
import net.minecraft.theTitans.render.minions.RenderPigZombieMinion;
import net.minecraft.theTitans.render.minions.RenderSilverfishMinion;
import net.minecraft.theTitans.render.minions.RenderSkeletonMinion;
import net.minecraft.theTitans.render.minions.RenderSpiderMinion;
import net.minecraft.theTitans.render.minions.RenderZombieMinion;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {
    public static Potion electricJudgment;
    public static Potion creeperTitanRadiation;
    public static Potion advancedWither;
    public static Potion death;

    public ClientProxy() {
    }

    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    public void init(FMLInitializationEvent e) {
        super.init(e);
        death = (new TitanPotions(28, true, 0)).func_76399_b(1, 2).func_76390_b("potion.death");
        electricJudgment = (new TitanPotions(29, true, 14270531)).func_76399_b(2, 2).func_76390_b("potion.electricJudgment");
        creeperTitanRadiation = (new TitanPotions(30, true, 28165)).func_76399_b(6, 0).func_76390_b("potion.radiation");
        advancedWither = (new TitanPotions(31, true, 0)).func_76399_b(1, 2).func_76390_b("potion.advancedWither");
    }

    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    public void registerItemRenderers() {
        MinecraftForgeClient.registerItemRenderer(TitanItems.ultimaBlade, new RenderUltimaBlade());
        MinecraftForgeClient.registerItemRenderer(TitanItems.optimaAxe, new RenderOptimaAxe());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggOmegafish, new RenderOmegafishSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggCaveSpiderTitan, new RenderCaveSpiderTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggSpiderTitan, new RenderSpiderTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggSlimeTitan, new RenderSlimeTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggMagmaCubeTitan, new RenderMagmaCubeTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggSpiderJockeyTitan, new RenderSpiderJockeyTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggSkeletonTitan, new RenderSkeletonTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggZombieTitan, new RenderZombieTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggCreeperTitan, new RenderCreeperTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggChargedCreeperTitan, new RenderChargedCreeperTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggZombiePigmanTitan, new RenderZombiePigmanTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggBlazeTitan, new RenderBlazeTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggWitherJockeyTitan, new RenderWitherJockeyTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggWitherSkeletonTitan, new RenderWitherSkeletonTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggSnowGolemTitan, new RenderSnowGolemTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggUltimaIronGolemTitan, new RenderUltimaIronGolemTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggGhastTitan, new RenderGhastTitanSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggEnderColossus, new RenderEnderColossusSpawnEgg());
        MinecraftForgeClient.registerItemRenderer(TitanItems.eggWitherzilla, new RenderWitherzillaSpawnEgg());
    }

    public void registerRenderThings() {
        MinecraftForge.EVENT_BUS.register(new TitanBossBarGui(Minecraft.func_71410_x()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySilverfishMinion.class, new RenderSilverfishMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityCaveSpiderMinion.class, new RenderCaveSpiderMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntitySpiderMinion.class, new RenderSpiderMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieMinion.class, new RenderZombieMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonMinion.class, new RenderSkeletonMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityCreeperMinion.class, new RenderCreeperMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityPigZombieMinion.class, new RenderPigZombieMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityBlazeMinion.class, new RenderBlazeMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityGhastMinion.class, new RenderGhastMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityEndermanMinion.class, new RenderEndermanMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityGhastGuard.class, new RenderGhastGuard());
        RenderingRegistry.registerEntityRenderingHandler(EntityGiantZombieBetter.class, new RenderGiantZombie(new ModelZombie(), 0.5F, 6.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherMinion.class, new RenderWitherMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityDragonMinion.class, new RenderDragonMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherzillaMinion.class, new RenderWitherzillaMinion());
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherTurret.class, new RenderWitherTurret());
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherTurretGround.class, new RenderWitherTurretGround());
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherTurretMortar.class, new RenderWitherTurretMortar());
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderColossusCrystal.class, new RenderEnderColossusCrystal());
        RenderingRegistry.registerEntityRenderingHandler(EntityHarcadiumArrow.class, new RenderHarcadiumArrow());
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonTitanGiantArrow.class, new RenderGiantArrow());
        RenderingRegistry.registerEntityRenderingHandler(EntityChaff.class, new RenderChaff());
        RenderingRegistry.registerEntityRenderingHandler(EntityXPBomb.class, new RenderXPBomb());
        RenderingRegistry.registerEntityRenderingHandler(EntityTitanPart.class, new RenderTitanPart());
        RenderingRegistry.registerEntityRenderingHandler(EntityGammaLightning.class, new RenderGammaLightning());
        RenderingRegistry.registerEntityRenderingHandler(EntityProtoBall.class, new RenderProtoBall());
        RenderingRegistry.registerEntityRenderingHandler(EntityLightningBall.class, new RenderLightningBall(8.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityTitanFireball.class, new RenderTitanFireball());
        RenderingRegistry.registerEntityRenderingHandler(EntityGargoyleTitanFireball.class, new RenderGargoyleTitanFireball());
        RenderingRegistry.registerEntityRenderingHandler(EntityLavaSpit.class, new RenderLavaSpit());
        RenderingRegistry.registerEntityRenderingHandler(EntityTitanSpirit.class, new RenderTitanSpirit());
        RenderingRegistry.registerEntityRenderingHandler(EntityWebShot.class, new RenderWebShot(4.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGrowthSerum.class, new RenderSnowball(TitanItems.growthSerum));
        if (Loader.isModLoaded("OreSpawn")) {
            RenderingRegistry.registerEntityRenderingHandler(EntityOverlordScorpion.class, new RenderOverlordScorpion());
            RenderingRegistry.registerEntityRenderingHandler(EntityMethuselahKraken.class, new RenderMethuselahKraken());
        }

        RenderingRegistry.registerEntityRenderingHandler(EntitySnowGolemTitan.class, new RenderSnowGolemTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntitySlimeTitan.class, new RenderSlimeTitan(new ModelSlimeTitan(16), new ModelSlimeTitan(0), 0.25F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMagmaCubeTitan.class, new RenderMagmaCubeTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntitySilverfishTitan.class, new RenderOmegafish());
        RenderingRegistry.registerEntityRenderingHandler(EntityCaveSpiderTitan.class, new RenderCaveSpiderTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntitySpiderTitan.class, new RenderSpiderTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieTitan.class, new RenderZombieTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonTitan.class, new RenderSkeletonTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntityCreeperTitan.class, new RenderCreeperTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntityPigZombieTitan.class, new RenderZombiePigmanTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntityBlazeTitan.class, new RenderBlazeTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntityGhastTitan.class, new RenderGhastTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderColossus.class, new RenderEnderColossus());
        RenderingRegistry.registerEntityRenderingHandler(EntityIronGolemTitan.class, new RenderUltimaIronGolemTitan());
        RenderingRegistry.registerEntityRenderingHandler(EntityWitherzilla.class, new RenderWitherzilla());
    }
}
