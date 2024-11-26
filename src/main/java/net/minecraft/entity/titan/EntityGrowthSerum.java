//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrowthSerum extends EntityThrowable {
    public EntityGrowthSerum(World worldIn) {
        super(worldIn);
        this.func_70105_a(0.5F, 0.5F);
    }

    public EntityGrowthSerum(World worldIn, EntityLivingBase p_i1780_2_) {
        super(worldIn, p_i1780_2_);
        this.func_70105_a(0.5F, 0.5F);
    }

    public EntityGrowthSerum(World worldIn, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_) {
        super(worldIn, p_i1781_2_, p_i1781_4_, p_i1781_6_);
        this.func_70105_a(0.5F, 0.5F);
    }

    protected void func_70184_a(MovingObjectPosition p_70184_1_) {
        if (!this.field_70170_p.field_72995_K && p_70184_1_.field_72308_g != null) {
            if (p_70184_1_.field_72308_g instanceof EntityTitan) {
                ((EntityTitan)p_70184_1_.field_72308_g).func_85030_a("random.fizz", 100.0F, 0.5F);
                ((EntityTitan)p_70184_1_.field_72308_g).func_70691_i(50.0F);
                ((EntityTitan)p_70184_1_.field_72308_g).setInvulTime(((EntityTitan)p_70184_1_.field_72308_g).getInvulTime() - 50);
            } else if (p_70184_1_.field_72308_g instanceof EntityZombie) {
                if (p_70184_1_.field_72308_g instanceof EntityPigZombie) {
                    EntityPigZombieTitan entitychicken = new EntityPigZombieTitan(this.field_70170_p);
                    entitychicken.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                    p_70184_1_.field_72308_g.func_70106_y();
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("portal.travel", 10000.0F, 1.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.func_85030_a("thetitans:titanBirth", 1000.0F, 1.0F);
                    entitychicken.func_82206_m();
                    entitychicken.func_70062_b(0, new ItemStack(Items.field_151010_B));
                    entitychicken.setChild(((EntityPigZombie)p_70184_1_.field_72308_g).func_70631_g_());
                } else {
                    EntityZombieTitan entitychicken = new EntityZombieTitan(this.field_70170_p);
                    entitychicken.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                    p_70184_1_.field_72308_g.func_70106_y();
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("portal.travel", 10000.0F, 1.0F);
                    entitychicken.func_85030_a("thetitans:titanBirth", 1000.0F, 1.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.func_82206_m();
                    entitychicken.setChild(((EntityZombie)p_70184_1_.field_72308_g).func_70631_g_());
                    entitychicken.setVillager(((EntityZombie)p_70184_1_.field_72308_g).func_82231_m());
                }
            } else if (p_70184_1_.field_72308_g instanceof EntitySkeleton) {
                EntitySkeletonTitan entitychicken = new EntitySkeletonTitan(this.field_70170_p);
                entitychicken.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                p_70184_1_.field_72308_g.func_70106_y();
                entitychicken.setSkeletonType(((EntitySkeleton)p_70184_1_.field_72308_g).func_82202_m());
                this.field_70170_p.func_72838_d(entitychicken);
                entitychicken.func_85030_a("portal.travel", 10000.0F, 1.0F);
                entitychicken.func_85030_a("thetitans:titanBirth", 1000.0F, 1.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.func_82206_m();
                if (p_70184_1_.field_72308_g.field_70154_o != null && p_70184_1_.field_72308_g.field_70154_o instanceof EntitySpider) {
                    EntitySpiderTitan entitychicken1 = new EntitySpiderTitan(this.field_70170_p);
                    entitychicken1.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                    this.field_70170_p.func_72838_d(entitychicken1);
                    entitychicken.func_70078_a(entitychicken1);
                    p_70184_1_.field_72308_g.field_70154_o.func_70106_y();
                    entitychicken1.func_110161_a((IEntityLivingData)null);
                    entitychicken1.func_82206_m();
                }
            } else if (p_70184_1_.field_72308_g instanceof EntityCreeper) {
                EntityCreeperTitan entitychicken = new EntityCreeperTitan(this.field_70170_p);
                entitychicken.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                p_70184_1_.field_72308_g.func_70106_y();
                this.field_70170_p.func_72838_d(entitychicken);
                entitychicken.func_85030_a("portal.travel", 10000.0F, 1.0F);
                entitychicken.func_85030_a("thetitans:titanBirth", 1000.0F, 1.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.func_82206_m();
                entitychicken.setPowered(((EntityCreeper)p_70184_1_.field_72308_g).func_70830_n());
            } else if (p_70184_1_.field_72308_g instanceof EntityBlaze) {
                EntityBlazeTitan entitychicken = new EntityBlazeTitan(this.field_70170_p);
                entitychicken.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                p_70184_1_.field_72308_g.func_70106_y();
                this.field_70170_p.func_72838_d(entitychicken);
                entitychicken.func_85030_a("portal.travel", 10000.0F, 1.0F);
                entitychicken.func_85030_a("thetitans:titanBirth", 1000.0F, 1.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.func_82206_m();
            } else if (p_70184_1_.field_72308_g instanceof EntitySpider) {
                if (p_70184_1_.field_72308_g instanceof EntityCaveSpider) {
                    EntityCaveSpiderTitan entitychicken = new EntityCaveSpiderTitan(this.field_70170_p);
                    entitychicken.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                    p_70184_1_.field_72308_g.func_70106_y();
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("portal.travel", 10000.0F, 1.0F);
                    entitychicken.func_85030_a("thetitans:titanBirth", 1000.0F, 1.25F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.func_82206_m();
                } else {
                    EntitySpiderTitan entitychicken = new EntitySpiderTitan(this.field_70170_p);
                    entitychicken.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                    p_70184_1_.field_72308_g.func_70106_y();
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("portal.travel", 10000.0F, 1.0F);
                    entitychicken.func_85030_a("thetitans:titanBirth", 1000.0F, 1.25F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.func_82206_m();
                    if (p_70184_1_.field_72308_g.field_70153_n != null && p_70184_1_.field_72308_g.field_70153_n instanceof EntitySkeleton) {
                        EntitySkeletonTitan entitychicken1 = new EntitySkeletonTitan(this.field_70170_p);
                        entitychicken1.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                        entitychicken1.setSkeletonType(((EntitySkeleton)p_70184_1_.field_72308_g.field_70153_n).func_82202_m());
                        this.field_70170_p.func_72838_d(entitychicken1);
                        entitychicken1.func_110161_a((IEntityLivingData)null);
                        entitychicken.func_85030_a("thetitans:titanBirth", 1000.0F, 1.0F);
                        entitychicken1.func_82206_m();
                        entitychicken1.func_70078_a(entitychicken);
                        p_70184_1_.field_72308_g.field_70153_n.func_70106_y();
                    }
                }
            } else if (p_70184_1_.field_72308_g instanceof EntityEnderman) {
                EntityEnderColossus entitychicken = new EntityEnderColossus(this.field_70170_p);
                entitychicken.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                p_70184_1_.field_72308_g.func_70106_y();
                entitychicken.func_110161_a((IEntityLivingData)null);
                this.field_70170_p.func_72838_d(entitychicken);
                entitychicken.func_85030_a("portal.travel", 10000.0F, 1.0F);
                entitychicken.func_85030_a("thetitans:titanBirth", 1000.0F, 0.875F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.func_82206_m();
            } else if (p_70184_1_.field_72308_g instanceof EntityGhast) {
                EntityGhastTitan entitychicken = new EntityGhastTitan(this.field_70170_p);
                entitychicken.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                p_70184_1_.field_72308_g.func_70106_y();
                entitychicken.func_110161_a((IEntityLivingData)null);
                this.field_70170_p.func_72838_d(entitychicken);
                entitychicken.func_85030_a("portal.travel", 10000.0F, 1.0F);
                entitychicken.func_85030_a("thetitans:titanBirth", 1000.0F, 0.875F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.func_82206_m();
            } else if (p_70184_1_.field_72308_g instanceof EntitySnowman) {
                EntitySnowGolemTitan entitychicken = new EntitySnowGolemTitan(this.field_70170_p);
                entitychicken.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                p_70184_1_.field_72308_g.func_70106_y();
                entitychicken.func_110161_a((IEntityLivingData)null);
                this.field_70170_p.func_72838_d(entitychicken);
                entitychicken.func_85030_a("random.break", 10000.0F, 0.5F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.func_82206_m();
            } else if (p_70184_1_.field_72308_g instanceof EntityGargoyle) {
                EntityGargoyleTitan entitychicken = new EntityGargoyleTitan(this.field_70170_p);
                entitychicken.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                p_70184_1_.field_72308_g.func_70106_y();
                entitychicken.func_110161_a((IEntityLivingData)null);
                this.field_70170_p.func_72838_d(entitychicken);
                entitychicken.func_85030_a("random.break", 10000.0F, 0.5F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.func_82206_m();
            } else if (p_70184_1_.field_72308_g instanceof EntityIronGolem) {
                EntityIronGolemTitan entitychicken = new EntityIronGolemTitan(this.field_70170_p);
                entitychicken.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                p_70184_1_.field_72308_g.func_70106_y();
                entitychicken.func_85030_a("random.break", 10000.0F, 0.5F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setPlayerCreated(((EntityIronGolem)p_70184_1_.field_72308_g).func_70850_q());
                entitychicken.func_110161_a((IEntityLivingData)null);
                this.field_70170_p.func_72838_d(entitychicken);
                entitychicken.func_82206_m();
            } else if (p_70184_1_.field_72308_g instanceof EntitySilverfish) {
                EntitySilverfishTitan entitychicken = new EntitySilverfishTitan(this.field_70170_p);
                entitychicken.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                p_70184_1_.field_72308_g.func_70106_y();
                this.field_70170_p.func_72838_d(entitychicken);
                entitychicken.func_85030_a("portal.travel", 10000.0F, 1.0F);
                entitychicken.func_85030_a("thetitans:titanBirth", 1000.0F, 1.25F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.func_82206_m();
            } else if (p_70184_1_.field_72308_g instanceof EntitySlime) {
                if (p_70184_1_.field_72308_g instanceof EntityMagmaCube) {
                    EntityMagmaCubeTitan entitychicken = new EntityMagmaCubeTitan(this.field_70170_p);
                    entitychicken.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                    p_70184_1_.field_72308_g.func_70106_y();
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("portal.travel", 10000.0F, 1.0F);
                    entitychicken.func_85030_a("thetitans:titanBirth", 1000.0F, 1.5F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.func_82206_m();
                    entitychicken.setSlimeSize(((EntityMagmaCube)p_70184_1_.field_72308_g).func_70809_q());
                } else {
                    EntitySlimeTitan entitychicken = new EntitySlimeTitan(this.field_70170_p);
                    entitychicken.func_70012_b(p_70184_1_.field_72308_g.field_70165_t, p_70184_1_.field_72308_g.field_70163_u, p_70184_1_.field_72308_g.field_70161_v, p_70184_1_.field_72308_g.field_70177_z, 0.0F);
                    p_70184_1_.field_72308_g.func_70106_y();
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_85030_a("portal.travel", 10000.0F, 1.0F);
                    entitychicken.func_85030_a("thetitans:titanBirth", 1000.0F, 1.5F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.func_82206_m();
                    entitychicken.setSlimeSize(((EntitySlime)p_70184_1_.field_72308_g).func_70809_q());
                }
            } else if (p_70184_1_.field_72308_g instanceof EntityLivingBase) {
                this.func_85030_a("game.player.hurt", 2.0F, 2.0F);
                ((EntityLivingBase)p_70184_1_.field_72308_g).func_70015_d(20);
                ((EntityLivingBase)p_70184_1_.field_72308_g).func_70097_a(DamageSourceExtra.wip, 2000.0F);
                if (!this.field_70170_p.field_72995_K) {
                    this.func_145779_a(TitanItems.growthSerum, 1);
                }
            }
        }

        if (!this.field_70170_p.field_72995_K) {
            if (p_70184_1_.field_72308_g == null) {
                this.func_145779_a(TitanItems.growthSerum, 1);
            }

            this.func_85030_a("game.player.hurt", 2.0F, 2.0F);
            this.func_70106_y();
        }

    }
}
