//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import cpw.mods.fml.common.Loader;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
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
import net.minecraft.entity.titanminion.IMinion;
import thehippomaster.MutantCreatures.MutantCreeper;
import thehippomaster.MutantCreatures.MutantEnderman;
import thehippomaster.MutantCreatures.MutantSkeleton;
import thehippomaster.MutantCreatures.MutantZombie;

public interface ITitan {
    IEntitySelector SearchForAThingToKill = new IEntitySelector() {
        public boolean func_82704_a(Entity p_179983_1_) {
            if (p_179983_1_ == null) {
                return false;
            } else if (p_179983_1_ instanceof EntityTitanSpirit) {
                return false;
            } else if (p_179983_1_ instanceof EntityTitan && !(p_179983_1_ instanceof EntitySnowGolemTitan) && !(p_179983_1_ instanceof EntityIronGolemTitan) && !(p_179983_1_ instanceof EntityGargoyleTitan) && !(p_179983_1_ instanceof EntityWitherzilla)) {
                return false;
            } else if (p_179983_1_ instanceof IMinion) {
                return false;
            } else if (p_179983_1_ instanceof EntityPlayer && ((EntityPlayer)p_179983_1_).field_71075_bZ.field_75098_d) {
                return false;
            } else {
                return p_179983_1_.getClass() != (Class)EntityList.field_75625_b.get("MutantCreatures.MutantCreeper") && p_179983_1_.getClass() != (Class)EntityList.field_75625_b.get("MutantCreatures.MutantEnderman") && p_179983_1_.getClass() != (Class)EntityList.field_75625_b.get("MutantCreatures.MutantSkeleton") && p_179983_1_.getClass() != (Class)EntityList.field_75625_b.get("MutantCreatures.MutantZombie") && !(p_179983_1_ instanceof EntityZombie) && !(p_179983_1_ instanceof EntitySkeleton) && !(p_179983_1_ instanceof EntitySpider) && !(p_179983_1_ instanceof EntityCreeper) && !(p_179983_1_ instanceof EntityEnderman) && !(p_179983_1_ instanceof EntityBlaze) && !(p_179983_1_ instanceof EntityGhast) && !(p_179983_1_ instanceof EntityWither) && !(p_179983_1_ instanceof EntityDragon) && !(p_179983_1_ instanceof EntitySilverfish) && !(p_179983_1_ instanceof EntitySlime) && !(p_179983_1_ instanceof EntityGiantZombieBetter) ? p_179983_1_.func_70089_S() : false;
            }
        }
    };
    IEntitySelector BlazeTitanSorter = new IEntitySelector() {
        public boolean func_82704_a(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityBlazeMinion) && !(p_179983_1_ instanceof EntityBlazeTitan);
        }
    };
    IEntitySelector CaveSpiderTitanSorter = new IEntitySelector() {
        public boolean func_82704_a(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityCaveSpiderMinion) && !(p_179983_1_ instanceof EntityCaveSpiderTitan);
        }
    };
    IEntitySelector CreeperTitanSorter = new IEntitySelector() {
        public boolean func_82704_a(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityCreeperMinion) && !(p_179983_1_ instanceof EntityCreeperTitan) || Loader.isModLoaded("MutantCreatures") && !(p_179983_1_ instanceof MutantCreeper);
        }
    };
    IEntitySelector EnderColossusSorter = new IEntitySelector() {
        public boolean func_82704_a(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityEndermanMinion) && !(p_179983_1_ instanceof EntityEnderColossus) && !(p_179983_1_ instanceof EntityDragon) && !(p_179983_1_ instanceof EntityDragonMinion) && !(p_179983_1_ instanceof EntityEnderColossusCrystal) || Loader.isModLoaded("MutantCreatures") && !(p_179983_1_ instanceof MutantEnderman);
        }
    };
    IEntitySelector GhastTitanSorter = new IEntitySelector() {
        public boolean func_82704_a(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityGhastMinion) && !(p_179983_1_ instanceof EntityGhastTitan);
        }
    };
    IEntitySelector MagmaCubeTitanSorter = new IEntitySelector() {
        public boolean func_82704_a(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityMagmaCube) && (!(p_179983_1_ instanceof EntityMagmaCubeTitan) || p_179983_1_ instanceof EntitySlimeTitan);
        }
    };
    IEntitySelector PigZombieTitanSorter = new IEntitySelector() {
        public boolean func_82704_a(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityPigZombieMinion) && !(p_179983_1_ instanceof EntityGhastGuard) && !(p_179983_1_ instanceof EntityPigZombieTitan);
        }
    };
    IEntitySelector SilverfishTitanSorter = new IEntitySelector() {
        public boolean func_82704_a(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntitySilverfishMinion) && !(p_179983_1_ instanceof EntitySilverfishTitan);
        }
    };
    IEntitySelector SkeletonTitanSorter = new IEntitySelector() {
        public boolean func_82704_a(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntitySkeletonMinion) && !(p_179983_1_ instanceof EntitySkeletonTitan) && !(p_179983_1_ instanceof EntityWitherMinion) || Loader.isModLoaded("MutantCreatures") && !(p_179983_1_ instanceof MutantSkeleton);
        }
    };
    IEntitySelector SlimeTitanSorter = new IEntitySelector() {
        public boolean func_82704_a(Entity p_179983_1_) {
            return (!(p_179983_1_ instanceof EntitySlime) || p_179983_1_ instanceof EntityMagmaCube) && (!(p_179983_1_ instanceof EntitySlimeTitan) || p_179983_1_ instanceof EntityMagmaCubeTitan);
        }
    };
    IEntitySelector SpiderTitanSorter = new IEntitySelector() {
        public boolean func_82704_a(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntitySpiderMinion) && (!(p_179983_1_ instanceof EntitySpiderTitan) || p_179983_1_ instanceof EntityCaveSpiderTitan);
        }
    };
    IEntitySelector ZombieTitanSorter = new IEntitySelector() {
        public boolean func_82704_a(Entity p_179983_1_) {
            return !(p_179983_1_ instanceof EntityZombieMinion) && !(p_179983_1_ instanceof EntityZombieTitan) && !(p_179983_1_ instanceof EntityGiantZombieBetter) || Loader.isModLoaded("MutantCreatures") && !(p_179983_1_ instanceof MutantZombie);
        }
    };

    EnumTitanStatus getTitanStatus();
}
