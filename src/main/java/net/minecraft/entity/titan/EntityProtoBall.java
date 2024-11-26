//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.entity.titanminion.EntityGhastGuard;
import net.minecraft.entity.titanminion.EntityGiantZombieBetter;
import net.minecraft.entity.titanminion.EntityPigZombieMinion;
import net.minecraft.entity.titanminion.EntityZombieMinion;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityProtoBall extends EntityThrowable {
    public EntityProtoBall(World worldIn) {
        super(worldIn);
        this.func_70105_a(3.0F, 3.0F);
        this.field_70181_x += (double)0.25F;
    }

    public EntityProtoBall(World worldIn, EntityLivingBase p_i1780_2_) {
        super(worldIn, p_i1780_2_);
        this.func_70105_a(3.0F, 3.0F);
        this.field_70181_x += (double)0.25F;
    }

    public EntityProtoBall(World worldIn, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_) {
        super(worldIn, p_i1781_2_, p_i1781_4_, p_i1781_6_);
        this.func_70105_a(3.0F, 3.0F);
        this.field_70181_x += (double)0.25F;
    }

    public void func_70071_h_() {
        super.func_70071_h_();

        for(int i = 0; i < 15; ++i) {
            float f = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70130_N;
            float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70131_O;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70130_N;
            this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t + (double)f, this.field_70163_u + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
            this.field_70170_p.func_72869_a("explode", this.field_70165_t + (double)f, this.field_70163_u + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
            this.field_70170_p.func_72869_a("fire", this.field_70165_t + (double)f, this.field_70163_u + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
            this.field_70170_p.func_72869_a("smoke", this.field_70165_t + (double)f, this.field_70163_u + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
            this.field_70170_p.func_72869_a("lava", this.field_70165_t + (double)f, this.field_70163_u + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
        }

    }

    protected void func_70184_a(MovingObjectPosition p_70184_1_) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_85052_h() != null && this.func_85052_h() instanceof EntityTitan && p_70184_1_.field_72308_g != null && p_70184_1_.field_72308_g instanceof EntityLivingBase) {
                ((EntityTitan)this.func_85052_h()).attackChoosenEntity(p_70184_1_.field_72308_g, 75.0F, 2);
            }

            if (this.func_85052_h() != null && this.func_85052_h() instanceof EntityPigZombieTitan) {
                if (this.field_70146_Z.nextInt(5) == 0) {
                    EntityGhastGuard entitychicken = new EntityGhastGuard(this.field_70170_p);
                    entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, -this.field_70177_z, -this.field_70125_A);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    ++entitychicken.field_70181_x;
                    boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
                    this.field_70170_p.func_72885_a(entitychicken, entitychicken.field_70165_t, entitychicken.field_70163_u + (double)6.0F, entitychicken.field_70161_v, 12.0F, false, flag);
                    entitychicken.master = (EntityPigZombieTitan)this.func_85052_h();
                } else {
                    switch (this.field_70146_Z.nextInt(4)) {
                        case 0:
                            for(int l1 = 0; l1 <= 5; ++l1) {
                                EntityPigZombieMinion entitychicken = new EntityPigZombieMinion(this.field_70170_p);
                                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, -this.field_70177_z, -this.field_70125_A);
                                this.field_70170_p.func_72838_d(entitychicken);
                                entitychicken.func_110161_a((IEntityLivingData)null);
                                entitychicken.setMinionType(3);
                                boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
                                this.field_70170_p.func_72885_a(entitychicken, entitychicken.field_70165_t, entitychicken.field_70163_u + (double)2.0F, entitychicken.field_70161_v, 6.0F, false, flag);
                                entitychicken.master = (EntityPigZombieTitan)this.func_85052_h();
                            }
                            break;
                        case 1:
                            for(int l1 = 0; l1 <= 10; ++l1) {
                                EntityPigZombieMinion entitychicken = new EntityPigZombieMinion(this.field_70170_p);
                                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, -this.field_70177_z, -this.field_70125_A);
                                this.field_70170_p.func_72838_d(entitychicken);
                                entitychicken.func_110161_a((IEntityLivingData)null);
                                entitychicken.setMinionType(2);
                                boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
                                this.field_70170_p.func_72885_a(entitychicken, entitychicken.field_70165_t, entitychicken.field_70163_u + (double)2.0F, entitychicken.field_70161_v, 4.0F, false, flag);
                                entitychicken.master = (EntityPigZombieTitan)this.func_85052_h();
                            }
                            break;
                        case 2:
                            for(int l1 = 0; l1 <= 20; ++l1) {
                                EntityPigZombieMinion entitychicken = new EntityPigZombieMinion(this.field_70170_p);
                                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, -this.field_70177_z, -this.field_70125_A);
                                this.field_70170_p.func_72838_d(entitychicken);
                                entitychicken.func_110161_a((IEntityLivingData)null);
                                entitychicken.setMinionType(1);
                                boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
                                this.field_70170_p.func_72885_a(entitychicken, entitychicken.field_70165_t, entitychicken.field_70163_u + (double)2.0F, entitychicken.field_70161_v, 3.0F, false, flag);
                                entitychicken.master = (EntityPigZombieTitan)this.func_85052_h();
                            }
                            break;
                        case 3:
                            for(int l1 = 0; l1 <= 40; ++l1) {
                                EntityPigZombieMinion entitychicken = new EntityPigZombieMinion(this.field_70170_p);
                                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, -this.field_70177_z, -this.field_70125_A);
                                this.field_70170_p.func_72838_d(entitychicken);
                                entitychicken.func_110161_a((IEntityLivingData)null);
                                entitychicken.setMinionType(0);
                                boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
                                this.field_70170_p.func_72885_a(entitychicken, entitychicken.field_70165_t, entitychicken.field_70163_u + (double)2.0F, entitychicken.field_70161_v, 2.0F, false, flag);
                                entitychicken.master = (EntityPigZombieTitan)this.func_85052_h();
                            }
                    }
                }
            }

            if (this.func_85052_h() != null && this.func_85052_h() instanceof EntityZombieTitan) {
                if (this.field_70146_Z.nextInt(5) == 0) {
                    EntityGiantZombieBetter entitychicken = new EntityGiantZombieBetter(this.field_70170_p);
                    entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, -this.field_70177_z, -this.field_70125_A);
                    this.field_70170_p.func_72838_d(entitychicken);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
                    this.field_70170_p.func_72885_a(entitychicken, entitychicken.field_70165_t, entitychicken.field_70163_u + (double)6.0F, entitychicken.field_70161_v, 12.0F, false, flag);
                    entitychicken.master = (EntityZombieTitan)this.func_85052_h();
                } else {
                    switch (this.field_70146_Z.nextInt(4)) {
                        case 0:
                            for(int l1 = 0; l1 <= 5; ++l1) {
                                EntityZombieMinion entitychicken = new EntityZombieMinion(this.field_70170_p);
                                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, -this.field_70177_z, -this.field_70125_A);
                                this.field_70170_p.func_72838_d(entitychicken);
                                entitychicken.func_110161_a((IEntityLivingData)null);
                                entitychicken.setMinionType(3);
                                boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
                                this.field_70170_p.func_72885_a(entitychicken, entitychicken.field_70165_t, entitychicken.field_70163_u + (double)2.0F, entitychicken.field_70161_v, 6.0F, false, flag);
                                entitychicken.master = (EntityZombieTitan)this.func_85052_h();
                            }
                            break;
                        case 1:
                            for(int l1 = 0; l1 <= 10; ++l1) {
                                EntityZombieMinion entitychicken = new EntityZombieMinion(this.field_70170_p);
                                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, -this.field_70177_z, -this.field_70125_A);
                                this.field_70170_p.func_72838_d(entitychicken);
                                entitychicken.func_110161_a((IEntityLivingData)null);
                                entitychicken.setMinionType(2);
                                boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
                                this.field_70170_p.func_72885_a(entitychicken, entitychicken.field_70165_t, entitychicken.field_70163_u + (double)2.0F, entitychicken.field_70161_v, 4.0F, false, flag);
                                entitychicken.master = (EntityZombieTitan)this.func_85052_h();
                            }
                            break;
                        case 2:
                            for(int l1 = 0; l1 <= 20; ++l1) {
                                EntityZombieMinion entitychicken = new EntityZombieMinion(this.field_70170_p);
                                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, -this.field_70177_z, -this.field_70125_A);
                                this.field_70170_p.func_72838_d(entitychicken);
                                entitychicken.func_110161_a((IEntityLivingData)null);
                                entitychicken.setMinionType(1);
                                boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
                                this.field_70170_p.func_72885_a(entitychicken, entitychicken.field_70165_t, entitychicken.field_70163_u + (double)2.0F, entitychicken.field_70161_v, 3.0F, false, flag);
                                entitychicken.master = (EntityZombieTitan)this.func_85052_h();
                            }
                            break;
                        case 3:
                            for(int l1 = 0; l1 <= 40; ++l1) {
                                EntityZombieMinion entitychicken = new EntityZombieMinion(this.field_70170_p);
                                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, -this.field_70177_z, -this.field_70125_A);
                                this.field_70170_p.func_72838_d(entitychicken);
                                entitychicken.func_110161_a((IEntityLivingData)null);
                                entitychicken.setMinionType(0);
                                boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
                                this.field_70170_p.func_72885_a(entitychicken, entitychicken.field_70165_t, entitychicken.field_70163_u + (double)2.0F, entitychicken.field_70161_v, 2.0F, false, flag);
                                entitychicken.master = (EntityZombieTitan)this.func_85052_h();
                            }
                    }
                }
            }
        }

        this.func_70106_y();
    }
}
