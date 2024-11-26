//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.ultimairongolemtitan.AnimationIronGolemTitanAntiTitanAttack;
import net.minecraft.entity.titan.animation.ultimairongolemtitan.AnimationIronGolemTitanAttack1;
import net.minecraft.entity.titan.animation.ultimairongolemtitan.AnimationIronGolemTitanAttack2;
import net.minecraft.entity.titan.animation.ultimairongolemtitan.AnimationIronGolemTitanAttack3;
import net.minecraft.entity.titan.animation.ultimairongolemtitan.AnimationIronGolemTitanAttack4;
import net.minecraft.entity.titan.animation.ultimairongolemtitan.AnimationIronGolemTitanDeath;
import net.minecraft.entity.titan.animation.ultimairongolemtitan.AnimationIronGolemTitanRangedAttack;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.village.Village;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityIronGolemTitan extends EntityTitan implements IAnimatedEntity {
    private int homeCheckTimer;
    Village villageObj;
    private int attackTimer;
    private int holdRoseTick;
    private static final IEntitySelector attackEntitySelector = new IEntitySelector() {
        public boolean func_82704_a(Entity p_180027_1_) {
            return p_180027_1_.func_70089_S() && p_180027_1_ instanceof EntityTitan && !(p_180027_1_ instanceof EntityGargoyleTitan) && !(p_180027_1_ instanceof EntityIronGolemTitan) && !(p_180027_1_ instanceof EntitySnowGolemTitan);
        }
    };

    public int getMinionCap() {
        return 30;
    }

    public EntityIronGolemTitan(World worldIn) {
        super(worldIn);
        this.func_70105_a(24.0F, 64.0F);
        this.func_70661_as().func_75491_a(true);
        this.field_70715_bh.func_75776_a(2, new EntityAIHurtByTarget(this, true));
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, IMob.field_82192_a));
        addTitanTargetingTaskToEntity(this);
        this.field_70714_bg.func_75776_a(1, new AnimationIronGolemTitanDeath(this));
        this.field_70714_bg.func_75776_a(1, new AnimationIronGolemTitanRangedAttack(this));
        this.field_70714_bg.func_75776_a(1, new AnimationIronGolemTitanAntiTitanAttack(this));
        this.field_70714_bg.func_75776_a(1, new AnimationIronGolemTitanAttack4(this));
        this.field_70714_bg.func_75776_a(1, new AnimationIronGolemTitanAttack3(this));
        this.field_70714_bg.func_75776_a(1, new AnimationIronGolemTitanAttack2(this));
        this.field_70714_bg.func_75776_a(1, new AnimationIronGolemTitanAttack1(this));
    }

    public static void addTitanTargetingTaskToEntity(EntityCreature entity) {
        entity.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(entity, EntityTitan.class, 0, false, false, attackEntitySelector));
    }

    public float func_70047_e() {
        return 56.0F;
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
    }

    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.GREATER;
    }

    protected int func_70682_h(int p_70682_1_) {
        return p_70682_1_;
    }

    public int getMinionSpawnRate() {
        return TheTitans.UltimaIronGolemMinionSpawnrate;
    }

    public int func_70658_aO() {
        return 24;
    }

    public boolean shouldMove() {
        return this.animID == 0 && this.func_70638_az() != null ? super.shouldMove() : false;
    }

    public double getMeleeRange() {
        return (double)(this.field_70130_N * this.field_70130_N + (this.func_70638_az().field_70130_N > 48.0F ? 2304.0F : this.func_70638_az().field_70130_N * this.func_70638_az().field_70130_N)) + (double)2000.0F;
    }

    public boolean canBeHurtByPlayer() {
        return !this.isPlayerCreated() && !this.func_85032_ar();
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.func_70105_a(24.0F, 64.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)2000.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)500000.0F);
        if (this.animID == 10) {
            if (this.animTick == 30 || this.animTick == 70) {
                this.func_145780_a(0, 0, 0, Blocks.field_150348_b);
            }

            if (this.animTick == 190) {
                this.func_85030_a("thetitans:titanFall", 20.0F, 0.9F);
                this.func_85030_a("thetitans:groundSmash", 20.0F, 1.0F);
                this.shakeNearbyPlayerCameras((double)40000.0F);
            }

            if (this.animTick == 200) {
                this.func_85030_a("thetitans:distantLargeFall", 10000.0F, 0.5F);
            }
        }

        if (!this.field_70170_p.field_72995_K && this.getAnimID() == 5 && this.getAnimTick() == 34 && this.func_70638_az() != null) {
            this.func_70652_k(this.func_70638_az());
            Vec3 vec3 = this.func_70676_i(1.0F);
            double var10001 = this.field_70165_t + vec3.field_72450_a * (double)30.0F;
            double d5 = this.func_70638_az().field_70165_t - var10001;
            double d6 = this.func_70638_az().field_70163_u - (this.field_70163_u + (double)30.0F);
            var10001 = this.field_70161_v + vec3.field_72449_c * (double)30.0F;
            double d7 = this.func_70638_az().field_70161_v - var10001;
            EntityTitanFireball entitylargefireball = new EntityTitanFireball(this.field_70170_p, this, d5, d6, d7, 1);
            entitylargefireball.field_70165_t = this.field_70165_t + vec3.field_72450_a * (double)30.0F;
            entitylargefireball.field_70163_u = this.field_70163_u + (double)30.0F;
            entitylargefireball.field_70161_v = this.field_70161_v + vec3.field_72449_c * (double)30.0F;
            this.field_70170_p.func_72838_d(entitylargefireball);
            entitylargefireball.setFireballID(5);
            entitylargefireball.func_85030_a("thetitans:titanSwing", 10.0F, 1.0F);
        }

        if (this.deathTicks > 0) {
            this.field_70159_w *= (double)0.0F;
            this.field_70179_y *= (double)0.0F;
        }

        if (!AnimationAPI.isEffectiveClient() && this.func_70638_az() != null && this.getAnimID() == 0 && this.field_70173_aa > 5) {
            double d0 = this.func_70068_e(this.func_70638_az());
            if (d0 < this.getMeleeRange()) {
                if (!(this.func_70638_az() instanceof EntityTitan) && !(this.func_70638_az().field_70131_O >= 6.0F) && !(this.func_70638_az().field_70163_u > this.field_70163_u + (double)6.0F)) {
                    switch (this.field_70146_Z.nextInt(4)) {
                        case 0:
                            AnimationAPI.sendAnimPacket(this, 6);
                            this.setAnimID(6);
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
                } else {
                    AnimationAPI.sendAnimPacket(this, 1);
                    this.setAnimID(1);
                }
            } else if (this.getAnimID() == 0 && this.func_70681_au().nextInt(160) == 0) {
                switch (this.field_70146_Z.nextInt(2)) {
                    case 0:
                        AnimationAPI.sendAnimPacket(this, 5);
                        this.setAnimID(5);
                        break;
                    case 1:
                        AnimationAPI.sendAnimPacket(this, 5);
                        this.setAnimID(5);
                }
            }
        }

        if (this.field_70181_x > (double)1.0F) {
            this.field_70181_x = (double)1.0F;
        }

        this.meleeTitan = true;
        this.func_94058_c("§7§lUltima Iron Golem Titan");
        List list1 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)96.0F, (double)96.0F, (double)96.0F));
        if (list1 != null && !list1.isEmpty()) {
            for(int i1 = 0; i1 < list1.size(); ++i1) {
                Entity entity = (Entity)list1.get(i1);
                if (entity != null && entity instanceof EntityIronGolem) {
                    if (((EntityIronGolem)entity).field_70123_F) {
                        ((EntityIronGolem)entity).field_70181_x = (double)0.25F;
                    }

                    if (((EntityIronGolem)entity).func_70638_az() == null && ((EntityIronGolem)entity).func_70068_e(this) > (double)4096.0F) {
                        ((EntityIronGolem)entity).func_70671_ap().func_75651_a(this, 180.0F, 40.0F);
                        ((EntityIronGolem)entity).func_70605_aq().func_75642_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, (double)1.0F);
                    }

                    if (((EntityIronGolem)entity).field_70173_aa == 20) {
                        addTitanTargetingTaskToEntity(this);
                    }
                }
            }
        }

        if (this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K) {
            EntityIronGolem entitychicken = new EntityIronGolem(this.field_70170_p);
            entitychicken.func_70012_b(this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, this.field_70177_z, 0.0F);
            entitychicken.func_70849_f(this.isPlayerCreated());
            this.field_70170_p.func_72838_d(entitychicken);
            entitychicken.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)2000.0F);
            entitychicken.func_70606_j(2000.0F);
            entitychicken.func_94058_c("Reinforced Iron Golem");
            addTitanTargetingTaskToEntity(entitychicken);
            entitychicken.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a((double)32.0F);
            entitychicken.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
        }

        if (this.attackTimer > 0) {
            --this.attackTimer;
        }

        if (this.holdRoseTick > 0) {
            --this.holdRoseTick;
        }

    }

    protected void func_70619_bc() {
        if (--this.homeCheckTimer <= 0) {
            this.homeCheckTimer = 70 + this.field_70146_Z.nextInt(50);
            this.villageObj = this.field_70170_p.field_72982_D.func_75550_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v), 32);
            if (this.villageObj == null) {
                this.func_110177_bN();
            } else {
                ChunkCoordinates chunkcoordinates = this.villageObj.func_75577_a();
                this.func_110171_b(chunkcoordinates.field_71574_a, chunkcoordinates.field_71572_b, chunkcoordinates.field_71573_c, (int)((float)this.villageObj.func_75568_b() * 0.6F));
            }
        }

        List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D);
        if (list11 != null && !list11.isEmpty()) {
            for(int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if ((entity instanceof EntityLiving || entity instanceof EntityPlayer && !this.isPlayerCreated()) && entity.field_70122_E && !(entity instanceof EntityTitan) && !(entity instanceof EntityIronGolem)) {
                    float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                    entity.func_70097_a(DamageSourceExtra.causeSquishingDamage(this), f / 2.0F);
                }
            }
        }

        super.func_70619_bc();
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != EntityVillager.class && p_70686_1_ != EntityIronGolem.class && p_70686_1_ != EntityIronGolemTitan.class ? !this.isPlayerCreated() || !EntityPlayer.class.isAssignableFrom(p_70686_1_) : false;
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
        float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
        if (p_70652_1_ instanceof EntityWitherzilla) {
            f *= 5.0F;
        }

        if (p_70652_1_ instanceof EntityGhastTitan && p_70652_1_.field_70163_u > this.field_70163_u + (double)32.0F) {
            --p_70652_1_.field_70181_x;
        }

        for(int l = 0; l < 7 + this.field_70146_Z.nextInt(14); ++l) {
            this.attackChoosenEntity(p_70652_1_, f, this.getKnockbackAmount());
        }

        return true;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (this.func_85032_ar()) {
            return false;
        } else if (source.func_76346_g() instanceof EntityPlayer && this.isPlayerCreated()) {
            return false;
        } else {
            return !(source.func_76346_g() instanceof EntityIronGolem) && !(source.func_76346_g() instanceof EntityIronGolemTitan) ? super.func_70097_a(source, amount) : false;
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_70103_a(byte p_70103_1_) {
        if (p_70103_1_ == 4) {
            this.attackTimer = 10;
            this.func_85030_a("mob.irongolem.throw", 100.0F, 0.5F);
        } else if (p_70103_1_ == 11) {
            this.holdRoseTick = 800;
        } else {
            super.func_70103_a(p_70103_1_);
        }

    }

    public Village getVillage() {
        return this.villageObj;
    }

    @SideOnly(Side.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }

    public void setHoldingRose(boolean p_70851_1_) {
        this.holdRoseTick = p_70851_1_ ? 800 : 0;
        this.field_70170_p.func_72960_a(this, (byte)11);
    }

    protected String func_70621_aR() {
        return "mob.irongolem.hit";
    }

    protected String func_70673_aS() {
        return "mob.irongolem.death";
    }

    protected float func_70647_i() {
        return this.func_70631_g_() ? (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F : (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 0.5F;
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
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

    protected float func_70599_aP() {
        return 100.0F;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        for(int l = 0; l < 512 + this.field_70146_Z.nextInt(512 + p_70628_2_); ++l) {
            this.func_70099_a(new ItemStack(Blocks.field_150339_S), 12.0F);
        }

        for(int l = 0; l < 128 + this.field_70146_Z.nextInt(128 + p_70628_2_); ++l) {
            this.func_70099_a(new ItemStack(Blocks.field_150328_O), 12.0F);
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

    public int getHoldRoseTick() {
        return this.holdRoseTick;
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

    public void func_70645_a(DamageSource cause) {
        if (!this.isPlayerCreated() && this.field_70717_bb != null && this.villageObj != null) {
            this.villageObj.func_82688_a(this.field_70717_bb.getDisplayName(), -50000);
        }

        super.func_70645_a(cause);
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

    protected void onTitanDeathUpdate() {
        this.field_70180_af.func_75692_b(6, MathHelper.func_76131_a(this.field_70180_af.func_111145_d(5), 0.0F, this.func_110138_aP()));
        if (this.field_70180_af.func_111145_d(5) <= 0.0F) {
            ++this.deathTicks;
            AnimationAPI.sendAnimPacket(this, 10);
            this.setAnimID(10);
            this.setTitanHealth(0.0F);
        } else {
            this.func_70097_a(DamageSource.field_76380_i, 25.0F);
            this.setTitanHealth(this.field_70180_af.func_111145_d(5));
            this.func_70606_j(this.field_70180_af.func_111145_d(5));
            this.deathTicks = 0;
            if (this.animID == 10) {
                this.animID = 0;
            }
        }

        this.field_70159_w *= (double)0.0F;
        this.field_70179_y *= (double)0.0F;
        this.func_70624_b((EntityLivingBase)null);
        if (this.deathTicks == 1 && !this.field_70170_p.field_72995_K) {
            this.func_85030_a(this.func_70673_aS(), this.func_70599_aP(), this.func_70647_i());
            ArrayList listp = Lists.newArrayList(this.field_70170_p.field_73010_i);
            if (listp != null && !listp.isEmpty()) {
                for(int i1 = 0; i1 < listp.size(); ++i1) {
                    Entity entity = (Entity)listp.get(i1);
                    if (entity != null && entity instanceof EntityPlayer) {
                        ((EntityPlayer)entity).func_71029_a(this.getAchievement());
                    }
                }
            }
        }

        if (this.deathTicks == 1) {
            this.setAnimTick(1);
        }

        if (this.deathTicks >= 500) {
            this.setInvulTime(this.getInvulTime() + 8);
        }

        if (this.getInvulTime() >= this.getThreashHold()) {
            this.func_70106_y();
        }

    }
}
