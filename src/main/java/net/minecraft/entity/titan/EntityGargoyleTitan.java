//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanAntiTitanAttack;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanAttack1;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanAttack2;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanAttack3;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanAttack4;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanLavaSpit;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanMeteorRain;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanWaterSpout;
import net.minecraft.entity.titan.animation.gargoyletitan.AnimationGargoyleTitanWingBuffet;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityGargoyleTitan extends EntityTitan implements IAnimatedEntity {
    private static final IEntitySelector attackEntitySelector = new IEntitySelector() {
        public boolean func_82704_a(Entity p_180027_1_) {
            return !(p_180027_1_ instanceof EntityGargoyleTitan) && !(p_180027_1_ instanceof EntityIronGolemTitan) && !(p_180027_1_ instanceof EntitySnowGolemTitan) && !(p_180027_1_ instanceof EntityWitherTurret) && !(p_180027_1_ instanceof EntityWitherTurretGround);
        }
    };

    public int getMinionCap() {
        return 30;
    }

    public EntityGargoyleTitan(World worldIn) {
        super(worldIn);
        this.meleeTitan = true;
        this.func_70105_a(16.0F, 37.0F);
        this.func_70661_as().func_75491_a(true);
        this.field_70715_bh.func_75776_a(2, new EntityAIHurtByTarget(this, true));
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, IMob.field_82192_a));
        addTitanTargetingTaskToEntity(this);
        this.field_70714_bg.func_75776_a(1, new AnimationGargoyleTitanLavaSpit(this));
        this.field_70714_bg.func_75776_a(1, new AnimationGargoyleTitanWaterSpout(this));
        this.field_70714_bg.func_75776_a(1, new AnimationGargoyleTitanWingBuffet(this));
        this.field_70714_bg.func_75776_a(1, new AnimationGargoyleTitanMeteorRain(this));
        this.field_70714_bg.func_75776_a(1, new AnimationGargoyleTitanAttack4(this));
        this.field_70714_bg.func_75776_a(1, new AnimationGargoyleTitanAttack3(this));
        this.field_70714_bg.func_75776_a(1, new AnimationGargoyleTitanAttack2(this));
        this.field_70714_bg.func_75776_a(1, new AnimationGargoyleTitanAttack1(this));
        this.field_70714_bg.func_75776_a(1, new AnimationGargoyleTitanAntiTitanAttack(this));
    }

    @SideOnly(Side.CLIENT)
    public int func_70070_b(float p_70070_1_) {
        return 15728880;
    }

    public float func_70013_c(float p_70013_1_) {
        return 1.0F;
    }

    public static void addTitanTargetingTaskToEntity(EntityCreature entity) {
        entity.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(entity, EntityTitan.class, 0, false, false, attackEntitySelector));
    }

    public float func_70047_e() {
        return 34.0F;
    }

    public void onKillCommand() {
        this.func_85030_a(this.func_70673_aS(), this.func_70599_aP(), this.func_70647_i());
        this.func_70106_y();
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, (byte)0);
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.25F);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)1000.0F);
    }

    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.GREATER;
    }

    protected int func_70682_h(int p_70682_1_) {
        return p_70682_1_;
    }

    public int getMinionSpawnRate() {
        return TheTitans.GargoyleKingMinionSpawnrate;
    }

    protected void func_70069_a(float p_70069_1_) {
        p_70069_1_ = ForgeHooks.onLivingFall(this, p_70069_1_);
        if (!(p_70069_1_ <= 0.0F)) {
            super.func_70069_a(p_70069_1_);
            PotionEffect potioneffect = this.func_70660_b(Potion.field_76430_j);
            float f1 = potioneffect != null ? (float)(potioneffect.func_76458_c() + 1) : 0.0F;
            int i = MathHelper.func_76123_f(p_70069_1_ - 20.0F - f1);
            if (i > 0) {
                this.func_145780_a(0, 0, 0, Blocks.field_150348_b);
                List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)48.0F, (double)2.0F, (double)48.0F));
                if (list11 != null && !list11.isEmpty()) {
                    for(int i1 = 0; i1 < list11.size(); ++i1) {
                        Entity entity = (Entity)list11.get(i1);
                        if (entity instanceof EntityLivingBase && this.func_70686_a(entity.getClass()) && !(entity instanceof EntityTitan)) {
                            float smash = 100.0F - this.func_70032_d(entity);
                            if (smash <= 1.0F) {
                                smash = 1.0F;
                            }

                            entity.func_70097_a(DamageSource.func_76358_a(this), smash);
                            double d0 = this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d;
                            double d1 = this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f;
                            double d2 = entity.field_70165_t - d0;
                            double d3 = entity.field_70161_v - d1;
                            double d4 = d2 * d2 + d3 * d3;
                            entity.func_70024_g(d2 / d4 * (double)8.0F, (double)1.0F, d3 / d4 * (double)8.0F);
                        }
                    }
                }
            }

        }
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)100000.0F);
        if (!this.field_70122_E && this.field_70181_x < (double)0.0F) {
            this.field_70181_x *= (double)0.75F;
        }

        if (this.func_70638_az() != null && this.animID == 0 && this.field_70163_u <= this.func_70638_az().field_70163_u + (double)16.0F && this.func_70068_e(this.func_70638_az()) > (!this.func_70638_az().field_70122_E ? this.getMeleeRange() : (double)6400.0F)) {
            this.field_70181_x += 0.42 - this.field_70181_x;
        }

        if (!this.field_70170_p.field_72995_K && this.getAnimID() == 5 && this.getAnimTick() == 30 && this.func_70638_az() != null) {
            int i1 = MathHelper.func_76128_c(this.func_70638_az().field_70165_t);
            int i = MathHelper.func_76128_c(this.func_70638_az().field_70163_u);
            int j1 = MathHelper.func_76128_c(this.func_70638_az().field_70161_v);

            for(int l1 = -16; l1 <= 16; ++l1) {
                for(int i2 = -16; i2 <= 16; ++i2) {
                    for(int j = 0; j <= 1; ++j) {
                        int j2 = i1 + l1;
                        int k = i + j;
                        int l = j1 + i2;

                        for(int y = 0; y <= 256 && this.field_70170_p.func_147439_a(j2, k - 1, l).func_149688_o() == Material.field_151579_a; ++y) {
                            --k;
                        }

                        Block block = this.field_70170_p.func_147439_a(j2, k, l);
                        if (block.func_149688_o() == Material.field_151579_a) {
                            this.field_70170_p.func_147465_d(j2, k, l, Blocks.field_150358_i, 7, 3);
                        }
                    }
                }
            }

            this.attackChoosenEntity(this.func_70638_az(), 200.0F, 3);
        }

        if (!this.field_70170_p.field_72995_K && this.getAnimID() == 6 && this.getAnimTick() == 20 && this.func_70638_az() != null) {
            double d8 = (double)10.0F;
            Vec3 vec3 = this.func_70676_i(1.0F);
            double dx = vec3.field_72450_a * d8;
            double dz = vec3.field_72449_c * d8;
            double var10001 = this.field_70165_t + dx;
            double d5 = this.func_70638_az().field_70165_t - var10001;
            double d6 = this.func_70638_az().field_70163_u - (this.field_70163_u + (double)28.0F);
            var10001 = this.field_70161_v + dz;
            double d7 = this.func_70638_az().field_70161_v - var10001;
            EntityLavaSpit entitylargefireball = new EntityLavaSpit(this.field_70170_p, this, d5, d6, d7);
            entitylargefireball.func_70107_b(this.field_70165_t + dx, this.field_70163_u + (double)28.0F, this.field_70161_v + dz);
            this.field_70170_p.func_72838_d(entitylargefireball);
        }

        if (!this.field_70170_p.field_72995_K && this.getAnimID() == 2 && this.getAnimTick() > 60 && this.func_70638_az() != null) {
            for(int i = 0; i < 2; ++i) {
                double ranX = this.field_70146_Z.nextGaussian() * (double)100.0F;
                double ranZ = this.field_70146_Z.nextGaussian() * (double)100.0F;
                double ranTargetX = this.field_70146_Z.nextGaussian() * (double)16.0F;
                double ranTargetZ = this.field_70146_Z.nextGaussian() * (double)16.0F;
                double d5 = this.func_70638_az().field_70165_t + ranTargetX - (this.field_70165_t + ranX);
                double d6 = this.func_70638_az().field_70163_u - (double)200.0F;
                double d7 = this.func_70638_az().field_70161_v + ranTargetZ - (this.field_70161_v + ranZ);
                EntityGargoyleTitanFireball entitylargefireball = new EntityGargoyleTitanFireball(this.field_70170_p, this, d5, d6, d7);
                entitylargefireball.func_70107_b(this.field_70165_t + ranX, (double)200.0F, this.field_70161_v + ranZ);
                this.field_70170_p.func_72838_d(entitylargefireball);
            }
        }

        if (!this.field_70170_p.field_72995_K && this.getAnimID() == 4 && this.getAnimTick() > 20 && this.func_70638_az() != null) {
            for(int i = 0; i < 2; ++i) {
                double ranX = this.field_70146_Z.nextGaussian() * (double)100.0F;
                double ranZ = this.field_70146_Z.nextGaussian() * (double)100.0F;
                double ranTargetX = this.field_70146_Z.nextGaussian() * (double)16.0F;
                double ranTargetZ = this.field_70146_Z.nextGaussian() * (double)16.0F;
                double d5 = this.func_70638_az().field_70165_t + ranTargetX - (this.field_70165_t + ranX);
                double d6 = this.func_70638_az().field_70163_u - (double)200.0F;
                double d7 = this.func_70638_az().field_70161_v + ranTargetZ - (this.field_70161_v + ranZ);
                EntityGargoyleTitanFireball entitylargefireball = new EntityGargoyleTitanFireball(this.field_70170_p, this, d5, d6, d7);
                entitylargefireball.func_70107_b(this.field_70165_t + ranX, (double)200.0F, this.field_70161_v + ranZ);
                this.field_70170_p.func_72838_d(entitylargefireball);
            }
        }

        if (!AnimationAPI.isEffectiveClient() && this.func_70638_az() != null && this.getAnimID() == 0) {
            double d0 = this.func_70068_e(this.func_70638_az());
            if (d0 < (double)(this.field_70130_N * this.field_70130_N + this.func_70638_az().field_70130_N * this.func_70638_az().field_70130_N) + (double)1500.0F) {
                if (!(this.func_70638_az() instanceof EntityTitan) && !(this.func_70638_az().field_70131_O >= 6.0F) && !(this.func_70638_az().field_70163_u > this.field_70163_u + (double)6.0F)) {
                    switch (this.field_70146_Z.nextInt(6)) {
                        case 0:
                            AnimationAPI.sendAnimPacket(this, 3);
                            this.setAnimID(3);
                            break;
                        case 1:
                            AnimationAPI.sendAnimPacket(this, 7);
                            this.setAnimID(7);
                            break;
                        case 2:
                            AnimationAPI.sendAnimPacket(this, 8);
                            this.setAnimID(8);
                            break;
                        case 3:
                            AnimationAPI.sendAnimPacket(this, 9);
                            this.setAnimID(9);
                    }
                } else if (this.field_70146_Z.nextInt(7) == 0) {
                    AnimationAPI.sendAnimPacket(this, 2);
                    this.setAnimID(2);
                } else {
                    AnimationAPI.sendAnimPacket(this, 1);
                    this.setAnimID(1);
                }
            } else if (this.getAnimID() == 0 && this.func_70681_au().nextInt(60) == 0) {
                switch (this.field_70146_Z.nextInt(2)) {
                    case 0:
                        if (this.func_70638_az() instanceof EntityTitan) {
                            AnimationAPI.sendAnimPacket(this, 4);
                            this.setAnimID(4);
                        } else {
                            AnimationAPI.sendAnimPacket(this, 5);
                            this.setAnimID(5);
                        }
                        break;
                    case 1:
                        AnimationAPI.sendAnimPacket(this, 6);
                        this.setAnimID(6);
                }
            }
        }

        this.func_94058_c("§7§lGargoyle King");
        List list1 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)256.0F, (double)256.0F, (double)256.0F));
        if (list1 != null && !list1.isEmpty() && this.field_70146_Z.nextInt(60) == 0) {
            for(int i1 = 0; i1 < list1.size(); ++i1) {
                Entity entity = (Entity)list1.get(i1);
                if (entity != null && entity instanceof EntityGargoyle && this.func_70638_az() != null && this.func_70638_az().field_70131_O <= 6.0F) {
                    ((EntityGargoyle)entity).func_70624_b(this.func_70638_az());
                    ((EntityGargoyle)entity).func_70671_ap().func_75651_a(this.func_70638_az(), 30.0F, 30.0F);
                    ((EntityGargoyle)entity).func_70605_aq().func_75642_a(this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, (double)1.0F);
                    ((EntityGargoyle)entity).func_70661_as().func_75492_a(this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, (double)1.0F);
                }
            }
        }

        if (this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K) {
            EntityGargoyle entitychicken = new EntityGargoyle(this.field_70170_p);
            entitychicken.func_70012_b(this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + (double)100.0F, this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitychicken);
            entitychicken.setGargoyleType(1);
            if (this.field_70146_Z.nextInt(2) == 0) {
                entitychicken.setGargoyleType(0);
                if (this.field_70146_Z.nextInt(2) == 0) {
                    entitychicken.setGargoyleType(6);
                    if (this.field_70146_Z.nextInt(2) == 0) {
                        entitychicken.setGargoyleType(5);
                        if (this.field_70146_Z.nextInt(2) == 0) {
                            entitychicken.setGargoyleType(4);
                            if (this.field_70146_Z.nextInt(2) == 0) {
                                entitychicken.setGargoyleType(2);
                                if (this.field_70146_Z.nextInt(2) == 0) {
                                    entitychicken.setGargoyleType(3);
                                }
                            }
                        }
                    }
                }
            }

            addTitanTargetingTaskToEntity(entitychicken);
            entitychicken.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
        }

        if (this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K) {
            EntityGargoyle entitychicken = new EntityGargoyle(this.field_70170_p);
            entitychicken.func_70012_b(this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + (double)100.0F, this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitychicken);
            entitychicken.setGargoyleType(1);
            if (this.field_70146_Z.nextInt(2) == 0) {
                entitychicken.setGargoyleType(0);
                if (this.field_70146_Z.nextInt(2) == 0) {
                    entitychicken.setGargoyleType(6);
                    if (this.field_70146_Z.nextInt(2) == 0) {
                        entitychicken.setGargoyleType(5);
                        if (this.field_70146_Z.nextInt(2) == 0) {
                            entitychicken.setGargoyleType(4);
                            if (this.field_70146_Z.nextInt(2) == 0) {
                                entitychicken.setGargoyleType(2);
                                if (this.field_70146_Z.nextInt(2) == 0) {
                                    entitychicken.setGargoyleType(3);
                                }
                            }
                        }
                    }
                }
            }

            addTitanTargetingTaskToEntity(entitychicken);
            entitychicken.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
        }

    }

    protected void func_70619_bc() {
        List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D);
        if (list11 != null && !list11.isEmpty()) {
            for(int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (entity instanceof EntityLivingBase && entity.field_70122_E && !(entity instanceof EntityTitan) && !(entity instanceof EntityGargoyle)) {
                    float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                    entity.func_70097_a(DamageSourceExtra.causeSquishingDamage(this), f / 2.0F);
                }
            }
        }

        super.func_70619_bc();
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != EntityGargoyle.class && p_70686_1_ != EntityGargoyleTitan.class ? (this.isPlayerCreated() && EntityPlayer.class.isAssignableFrom(p_70686_1_) ? false : super.func_70686_a(p_70686_1_)) : false;
    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        tagCompound.func_74757_a("PlayerCreated", this.isPlayerCreated());
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        this.setPlayerCreated(tagCompund.func_74767_n("PlayerCreated"));
    }

    public boolean func_70652_k(Entity p_70652_1_) {
        return false;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (this.func_85032_ar()) {
            return false;
        } else if (source.func_94541_c()) {
            return false;
        } else {
            return source.func_76346_g() != null && source.func_76346_g() instanceof EntityPlayer && this.isPlayerCreated() ? false : super.func_70097_a(source, amount);
        }
    }

    protected String func_70639_aQ() {
        return "thetitans:gargoyleLiving";
    }

    protected String func_70621_aR() {
        return "thetitans:gargoyleGrunt";
    }

    protected String func_70673_aS() {
        return "thetitans:gargoyleDeath";
    }

    protected float func_70647_i() {
        return this.func_70631_g_() ? (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F : (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 0.5F;
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        if (this.field_70122_E) {
            this.func_85030_a("mob.irongolem.walk", 10.0F, 0.5F);
            this.func_85030_a("mob.irongolem.walk", 10.0F, 0.5F);
            this.func_85030_a("mob.irongolem.walk", 10.0F, 0.5F);
            this.func_85030_a("mob.irongolem.walk", 10.0F, 0.5F);
            this.func_85030_a("mob.irongolem.walk", 10.0F, 0.5F);
            this.func_85030_a("mob.irongolem.walk", 10.0F, 0.5F);
            this.func_85030_a("mob.irongolem.walk", 10.0F, 0.5F);
            this.func_85030_a("mob.irongolem.walk", 10.0F, 0.5F);
            this.func_85030_a("thetitans:titanStep", 10.0F, 1.0F);
            this.shakeNearbyPlayerCameras((double)6000.0F);
        }

    }

    protected float func_70599_aP() {
        return 100.0F;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        for(int l = 0; l < 512 + this.field_70146_Z.nextInt(512 + p_70628_2_); ++l) {
            this.func_70099_a(new ItemStack(Blocks.field_150348_b), 12.0F);
        }

        for(int l = 0; l < 32 + this.field_70146_Z.nextInt(96 + p_70628_2_); ++l) {
            this.func_70099_a(new ItemStack(Items.field_151166_bC), 12.0F);
        }

        for(int l = 0; l < 32 + this.field_70146_Z.nextInt(96 + p_70628_2_); ++l) {
            this.func_70099_a(new ItemStack(Items.field_151045_i), 12.0F);
        }

        for(int l = 0; l < 0 + this.field_70146_Z.nextInt(16 + p_70628_2_); ++l) {
            this.func_70099_a(new ItemStack(TitanItems.harcadium), 12.0F);
        }

        for(int l = 0; l < 0 + this.field_70146_Z.nextInt(8); ++l) {
            this.func_70099_a(new ItemStack(Blocks.field_150357_h), 12.0F);
        }

    }

    public boolean isPlayerCreated() {
        return (this.field_70180_af.func_75683_a(16) & 1) != 0;
    }

    public void setPlayerCreated(boolean p_70849_1_) {
        byte b0 = this.field_70180_af.func_75683_a(16);
        if (p_70849_1_) {
            this.field_70180_af.func_75692_b(16, (byte)(b0 | 1));
        } else {
            this.field_70180_af.func_75692_b(16, (byte)(b0 & -2));
        }

    }

    public void setAnimID(int id) {
        this.animID = id;
    }

    public void setAnimTick(int tick) {
        this.animTick = tick;
    }

    public int getAnimID() {
        return this.animID;
    }

    public int getAnimTick() {
        return this.animTick;
    }
}
