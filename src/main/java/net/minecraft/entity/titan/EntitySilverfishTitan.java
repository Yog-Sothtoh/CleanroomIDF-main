//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishAntiTitanAttack;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishAttack1;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishAttack2;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishAttack3;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishBodySlam;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishBurrow;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishCreation;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishDeath;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishLightningAttack;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishStunned;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishTailSmash;
import net.minecraft.entity.titan.animation.omegafish.AnimationOmegafishUnburrow;
import net.minecraft.entity.titanminion.EntitySilverfishMinion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.theTitans.world.WorldProviderVoid;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntitySilverfishTitan extends EntityTitan implements IAnimatedEntity, IEntityMultiPartTitan {
    public boolean isSubdued;
    public boolean isBurrowing;
    public boolean isStunned;
    public EntityTitanPart[] partArray;
    public EntityTitanPart head;
    public EntityTitanPart body;
    public EntityTitanPart tailbase;
    public EntityTitanPart tail1;
    public EntityTitanPart tail2;
    public EntityTitanPart tailtip;

    public EntitySilverfishTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 3.0F, 2.0F);
        this.body = new EntityTitanPart(worldIn, this, "body", 5.0F, 4.0F);
        this.tailbase = new EntityTitanPart(worldIn, this, "tailbase", 3.0F, 3.0F);
        this.tail1 = new EntityTitanPart(worldIn, this, "tail1", 3.0F, 2.0F);
        this.tail2 = new EntityTitanPart(worldIn, this, "tail2", 2.0F, 1.0F);
        this.tailtip = new EntityTitanPart(worldIn, this, "tailtip", 2.0F, 1.0F);
        this.partArray = new EntityTitanPart[]{this.head, this.body, this.tailbase, this.tail1, this.tail2, this.tailtip};
        this.func_70105_a(9.0F, 6.0F);
        this.field_70728_aV = 6000 + this.getExtraPower() * 200;
        this.field_70170_p.func_72838_d(this.head);
        this.field_70170_p.func_72838_d(this.body);
        this.field_70170_p.func_72838_d(this.tailbase);
        this.field_70170_p.func_72838_d(this.tail1);
        this.field_70170_p.func_72838_d(this.tail2);
        this.field_70170_p.func_72838_d(this.tailtip);
    }

    protected void applyEntityAI() {
        this.field_70714_bg.func_75776_a(1, new AnimationOmegafishCreation(this));
        this.field_70714_bg.func_75776_a(1, new AnimationOmegafishDeath(this));
        this.field_70714_bg.func_75776_a(1, new AnimationOmegafishStunned(this));
        this.field_70714_bg.func_75776_a(1, new AnimationOmegafishAntiTitanAttack(this));
        this.field_70714_bg.func_75776_a(1, new AnimationOmegafishBodySlam(this));
        this.field_70714_bg.func_75776_a(1, new AnimationOmegafishTailSmash(this));
        this.field_70714_bg.func_75776_a(1, new AnimationOmegafishLightningAttack(this));
        this.field_70714_bg.func_75776_a(1, new AnimationOmegafishAttack2(this));
        this.field_70714_bg.func_75776_a(1, new AnimationOmegafishAttack3(this));
        this.field_70714_bg.func_75776_a(1, new AnimationOmegafishAttack1(this));
        this.field_70714_bg.func_75776_a(1, new AnimationOmegafishUnburrow(this));
        this.field_70714_bg.func_75776_a(1, new AnimationOmegafishBurrow(this));
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (!this.isSubdued) {
            if (TheTitans.TitansFFAMode) {
                this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SilverfishTitanSorter));
            } else {
                this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
            }

            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        }

    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        this.isStunned = tagCompund.func_74767_n("Stunned");
        this.isBurrowing = tagCompund.func_74767_n("Burrowing");
        this.isSubdued = tagCompund.func_74767_n("Subdued");
    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        tagCompound.func_74757_a("Stunned", this.isStunned);
        tagCompound.func_74757_a("Burrowing", this.isBurrowing);
        tagCompound.func_74757_a("Subdued", this.isSubdued);
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != this.head.getClass() && p_70686_1_ != this.body.getClass() && p_70686_1_ != this.tailbase.getClass() && p_70686_1_ != this.tail1.getClass() && p_70686_1_ != this.tail2.getClass() && p_70686_1_ != this.tailtip.getClass() && p_70686_1_ != EntitySilverfishMinion.class && p_70686_1_ != EntitySilverfishTitan.class;
    }

    public boolean isArmored() {
        return this.func_110143_aJ() <= this.func_110138_aP() / 4.0F || TheTitans.NightmareMode || TheTitans.TotalDestructionMode;
    }

    public int getMinionCap() {
        return 240;
    }

    public int getPriestCap() {
        return 120;
    }

    public int getZealotCap() {
        return 60;
    }

    public int getTemplarCap() {
        return 8;
    }

    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(10) == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }

    public int getMinionSpawnRate() {
        return TheTitans.OmegafishMinionSpawnrate;
    }

    public float func_70047_e() {
        return 2.0F;
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.25F);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
    }

    protected String func_70639_aQ() {
        return !this.isStunned && !this.getWaiting() && this.animID != 2 ? "thetitans:titanSilverfishLiving" : null;
    }

    protected String func_70621_aR() {
        return "thetitans:titanSilverfishGrunt";
    }

    protected String func_70673_aS() {
        return "thetitans:titanSilverfishDeath";
    }

    protected Item func_146068_u() {
        return Items.field_151121_aF;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            for(int x = 0; x < 6; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                entitylargefireball.func_70107_b(this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                ++entitylargefireball.field_70181_x;
                entitylargefireball.setXPCount(3000);
                this.field_70170_p.func_72838_d(entitylargefireball);
            }

            for(int l = 0; l < 96 + this.field_70146_Z.nextInt(96 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151121_aF));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 32 + this.field_70146_Z.nextInt(32 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151044_h));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 4 + this.field_70146_Z.nextInt(8 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151166_bC));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 4 + this.field_70146_Z.nextInt(8 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151045_i));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 16 + this.field_70146_Z.nextInt(48 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150347_e));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 16 + this.field_70146_Z.nextInt(48 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150348_b));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 0 + this.field_70146_Z.nextInt(48 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150341_Y));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 0 + this.field_70146_Z.nextInt(32 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150417_aV));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 4 + this.field_70146_Z.nextInt(8 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150418_aU));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 0 + this.field_70146_Z.nextInt(4 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(TitanItems.harcadiumNugget));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }
        }

    }

    public EnumCreatureAttribute func_70668_bt() {
        return EnumCreatureAttribute.ARTHROPOD;
    }

    public boolean canBeHurtByPlayer() {
        return this.isStunned && !this.isBurrowing && !this.func_85032_ar();
    }

    public boolean func_70652_k(Entity p_70652_1_) {
        return false;
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
    }

    public boolean canAttack() {
        return false;
    }

    public boolean shouldMove() {
        return this.getAnimID() == 0 && !this.isStunned && this.func_70638_az() != null ? super.shouldMove() : false;
    }

    public double getSpeed() {
        return this.isBurrowing ? 0.9 + (double)this.getExtraPower() * 0.001 : 0.7 + (double)this.getExtraPower() * 0.001;
    }

    public double getMeleeRange() {
        return (double)(this.field_70130_N * this.field_70130_N + (this.func_70638_az().field_70130_N > 48.0F ? 2304.0F : this.func_70638_az().field_70130_N * this.func_70638_az().field_70130_N)) + (double)100.0F;
    }

    public void func_70636_d() {
        if (!this.getWaiting() && this.animID != 0 && this.deathTicks < this.getThreashHold() && this.isArmored() && this.func_70089_S()) {
            ++this.animTick;
        }

        if (!this.func_70115_ae() && !this.isBurrowing && !this.getWaiting() && !this.isStunned && this.animID == 0) {
            if (this.func_70638_az() != null && this.func_70068_e(this.func_70638_az()) > this.getMeleeRange() + (!this.func_70638_az().field_70122_E ? (double)1000.0F : (double)8000.0F)) {
                if (this.field_70163_u <= this.func_70638_az().field_70163_u + (double)12.0F && this.field_70163_u < (double)256.0F - (double)this.field_70131_O) {
                    this.field_70143_R = 0.0F;
                    this.field_70181_x += 0.9 - this.field_70181_x;
                    if (this.field_70181_x < (double)0.0F) {
                        this.field_70181_x = (double)0.0F;
                    }
                }

                this.field_70181_x *= 0.6;
            }

            if (!this.field_70122_E) {
                float f = (this.field_70146_Z.nextFloat() - 0.5F) * 10.0F;
                float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 1.0F;
                float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 10.0F;
                this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + (double)5.0F + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
            }
        }

        if (this.getWaiting()) {
            AnimationAPI.sendAnimPacket(this, 0);
            AnimationAPI.sendAnimPacket(this, 13);
            this.setAnimTick(0);
            EntityPlayer player = this.field_70170_p.func_72890_a(this, (double)24.0F);
            if (player != null) {
                this.setWaiting(false);
                this.func_70625_a(player, 180.0F, 0.0F);
                player.func_71029_a(TitansAchievments.locateTitan);
            }
        } else {
            if (this.getAnimID() == 13) {
                this.field_70159_w = (double)0.0F;
                this.field_70179_y = (double)0.0F;
                if (this.field_70181_x > (double)0.0F) {
                    this.field_70181_x = (double)0.0F;
                }
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 1) {
                this.func_85030_a("thetitans:titanBirth", 100.0F, 1.25F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 10) {
                this.func_85030_a("thetitans:titanSilverfishLiving", this.func_70599_aP(), 0.7F);
            }

            if (this.getAnimID() == 13 && this.getAnimTick() == 150) {
                this.func_85030_a("thetitans:titanPress", this.func_70599_aP(), 1.0F);
                this.shakeNearbyPlayerCameras((double)4000.0F);
            }
        }

        if (!this.isBurrowing && !this.isStunned && this.animID != 2 && this.animID != 9 && this.func_70638_az() != null && this.func_70068_e(this.func_70638_az()) > (double)4000.0F) {
            if (this.field_70163_u <= this.func_70638_az().field_70163_u + (double)24.0F) {
                this.field_70181_x += 0.9 - this.field_70181_x;
                if (this.field_70181_x < (double)0.0F) {
                    this.field_70181_x = (double)0.0F;
                }
            }

            this.field_70181_x *= 0.9;
        }

        if (!this.isBurrowing && !this.field_70122_E) {
            float f = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
            float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 1.0F;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
            this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t + (double)f, this.field_70163_u + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
        }

        if (this.isSubdued) {
            this.field_70761_aq = this.field_70177_z = this.field_70759_as;
        }

        EntityPlayer player = this.field_70170_p.func_72890_a(this.head, (double)4.0F);
        if (player != null && this.head.field_70163_u < player.field_70163_u - (double)2.0F) {
            this.field_70759_as += MathHelper.func_76126_a((float)this.field_70173_aa) * 40.0F;
            this.field_70125_A -= MathHelper.func_76134_b((float)this.field_70173_aa) * 40.0F;
        }

        if (this.animID == 1) {
            this.isBurrowing = true;
        } else if (this.animID == 2) {
            this.isBurrowing = false;
        }

        if (this.isBurrowing) {
            this.destroyBlocksInAABB(this.field_70121_D.func_72314_b((double)2.0F, (double)0.0F, (double)2.0F));
            this.field_70170_p.func_72926_e(2006, MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u - (double)0.2F - (double)this.field_70129_M), MathHelper.func_76128_c(this.field_70161_v), MathHelper.func_76123_f(128.0F));
            if (this.field_70173_aa % 40 == 0) {
                this.func_85030_a("thetitans:titanRumble", 10.0F, 1.0F);
                this.func_85030_a("thetitans:titanRumble", 9.0F, 1.0F);
                this.func_85030_a("thetitans:titanRumble", 8.0F, 1.0F);
                this.func_85030_a("thetitans:titanRumble", 7.0F, 1.0F);
                this.func_85030_a("thetitans:titanRumble", 6.0F, 1.0F);
                this.func_85030_a("thetitans:titanQuake", 5.0F, 1.0F);
                this.func_85030_a("thetitans:titanQuake", 4.0F, 1.0F);
                this.func_85030_a("thetitans:titanQuake", 3.0F, 1.0F);
                this.func_85030_a("thetitans:titanQuake", 2.0F, 1.0F);
                this.func_85030_a("thetitans:titanQuake", 1.0F, 1.0F);
            }
        }

        if (this.isSubdued && this.field_70173_aa % 40 == 0) {
            this.field_70715_bh.func_85156_a(new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
            this.field_70715_bh.func_85156_a(new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
            this.field_70715_bh.func_85156_a(new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        }

        this.func_70105_a(9.0F, 6.0F);
        if (this.getAnimID() == 7 && this.getAnimTick() == 20) {
            double d8 = (double)-3.0F;
            Vec3 vec3 = this.func_70676_i(1.0F);
            double dx = vec3.field_72450_a * d8;
            double dz = vec3.field_72449_c * d8;
            float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
            int i = this.getKnockbackAmount();
            this.field_70170_p.func_72885_a(this, this.field_70165_t + dx, this.field_70163_u + (double)8.0F, this.field_70161_v + dz, 1.0F, false, false);
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t + dx, this.field_70163_u + (double)8.0F, this.field_70161_v + dz, 0.5F, 0.5F, 0.5F));
            if (this.func_70638_az() != null) {
                this.attackChoosenEntity(this.func_70638_az(), f, i);
                EntityLivingBase var10000 = this.func_70638_az();
                var10000.field_70181_x += (double)2.0F;
                this.field_70170_p.func_72885_a(this, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 2.0F, false, false);
                this.func_70638_az().func_70097_a(DamageSourceExtra.lightningBolt, f);
                this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 0.25F, 0.25F, 0.25F));
                List list1 = this.field_70170_p.func_72839_b(this.func_70638_az(), this.func_70638_az().field_70121_D.func_72314_b((double)2.0F, (double)2.0F, (double)2.0F));
                if (list1 != null && !list1.isEmpty()) {
                    for(int i1 = 0; i1 < list1.size(); ++i1) {
                        Entity entity1 = (Entity)list1.get(i1);
                        if (entity1 instanceof EntityLivingBase && !(entity1 instanceof EntitySilverfishMinion) && !(entity1 instanceof EntitySilverfishTitan)) {
                            this.attackChoosenEntity(entity1, f, i);
                            ++entity1.field_70181_x;
                        }
                    }
                }
            }
        }

        this.meleeTitan = true;
        if (this.isBurrowing) {
            this.destroyBlocksInAABB(this.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F));
        }

        if (this.field_70173_aa > 5) {
            float f = this.field_70761_aq * (float)Math.PI / 180.0F;
            float f1 = MathHelper.func_76126_a(f);
            float f2 = MathHelper.func_76134_b(f);
            this.head.func_70012_b(this.field_70165_t - (double)(MathHelper.func_76126_a(this.field_70759_as * (float)Math.PI / 180.0F) * 3.0F), this.field_70163_u - (double)(MathHelper.func_76126_a(this.field_70125_A * (float)Math.PI / 180.0F) * 2.0F), this.field_70161_v + (double)(MathHelper.func_76134_b(this.field_70759_as * (float)Math.PI / 180.0F) * 3.0F), 0.0F, 0.0F);
            this.body.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
            this.tailbase.func_70012_b(this.field_70165_t + (double)f1 * (double)4.0F, this.field_70163_u, this.field_70161_v - (double)f2 * (double)4.0F, 0.0F, 0.0F);
            this.tail1.func_70012_b(this.field_70165_t + (double)f1 * (double)7.0F, this.field_70163_u, this.field_70161_v - (double)f2 * (double)7.0F, 0.0F, 0.0F);
            this.tail2.func_70012_b(this.field_70165_t + (double)f1 * (double)9.5F, this.field_70163_u, this.field_70161_v - (double)f2 * (double)9.5F, 0.0F, 0.0F);
            this.tailtip.func_70012_b(this.field_70165_t + (double)f1 * (double)11.5F, this.field_70163_u, this.field_70161_v - (double)f2 * (double)11.5F, 0.0F, 0.0F);
            if (this.func_70089_S() && !this.isStunned) {
                this.collideWithEntities(this.head, this.field_70170_p.func_72839_b(this, this.head.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.body, this.field_70170_p.func_72839_b(this, this.head.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.tailbase, this.field_70170_p.func_72839_b(this, this.tailbase.field_70121_D));
                this.collideWithEntities(this.tail1, this.field_70170_p.func_72839_b(this, this.tail1.field_70121_D));
                this.collideWithEntities(this.tail2, this.field_70170_p.func_72839_b(this, this.tail2.field_70121_D));
                this.collideWithEntities(this.tailtip, this.field_70170_p.func_72839_b(this, this.tailtip.field_70121_D));
            }

            this.destroyBlocksInAABB(this.head.field_70121_D);
            this.destroyBlocksInAABB(this.body.field_70121_D);
            this.destroyBlocksInAABB(this.tailbase.field_70121_D);
            this.destroyBlocksInAABB(this.tail1.field_70121_D);
            this.destroyBlocksInAABB(this.tail2.field_70121_D);
            this.destroyBlocksInAABB(this.tailtip.field_70121_D);

            for(int i = 0; i < this.partArray.length; ++i) {
                List list = this.field_70170_p.func_72839_b(this, this.partArray[i].field_70121_D.func_72314_b((double)0.5F, (double)0.5F, (double)0.5F));
                if (list != null && !list.isEmpty()) {
                    for(int j = 0; j < list.size(); ++j) {
                        Entity entity = (Entity)list.get(j);
                        if (entity instanceof EntityFireball && ((EntityFireball)entity).field_70235_a != this && !(entity instanceof EntityLightningBall) && !(entity instanceof EntityGargoyleTitanFireball) && !(entity instanceof EntityWebShot)) {
                            ((EntityFireball)entity).func_70097_a(DamageSource.func_92087_a(this), 0.0F);
                        }

                        if (entity instanceof EntityTitanFireball && ((EntityTitanFireball)entity).field_70235_a != null && ((EntityTitanFireball)entity).field_70235_a != this) {
                            ((EntityTitanFireball)entity).onImpactPublic(this);
                        }

                        if (entity instanceof EntityGargoyleTitanFireball) {
                            this.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                            this.field_70170_p.func_72885_a((Entity)(((EntityGargoyleTitanFireball)entity).field_70235_a != null ? ((EntityGargoyleTitanFireball)entity).field_70235_a : (EntityGargoyleTitanFireball)entity), ((EntityGargoyleTitanFireball)entity).field_70165_t, ((EntityGargoyleTitanFireball)entity).field_70163_u, ((EntityGargoyleTitanFireball)entity).field_70161_v, 8.0F, false, false);
                            this.attackEntityFromPart(this.partArray[i], DamageSource.func_76362_a((EntityGargoyleTitanFireball)entity, (Entity)(((EntityGargoyleTitanFireball)entity).field_70235_a != null ? ((EntityGargoyleTitanFireball)entity).field_70235_a : (EntityGargoyleTitanFireball)entity)), 1000.0F);
                            entity.func_70106_y();
                        }

                        if (entity instanceof EntityHarcadiumArrow) {
                            this.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                            this.attackEntityFromPart(this.partArray[i], DamageSourceExtra.causeHarcadiumArrowDamage((EntityHarcadiumArrow)entity, (Entity)(((EntityHarcadiumArrow)entity).field_70250_c != null ? ((EntityHarcadiumArrow)entity).field_70250_c : (EntityHarcadiumArrow)entity)), 500.0F);
                            entity.func_70106_y();
                        }

                        if (entity instanceof EntityWebShot && ((EntityWebShot)entity).field_70235_a != this) {
                            this.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                            this.attackEntityFromPart(this.partArray[i], DamageSourceExtra.causeAntiTitanDamage((Entity)(((EntityWebShot)entity).field_70235_a != this ? ((EntityWebShot)entity).field_70235_a : (EntityWebShot)entity)), 300.0F);
                            int i1 = MathHelper.func_76128_c(this.partArray[i].field_70163_u);
                            int i11 = MathHelper.func_76128_c(this.partArray[i].field_70165_t);
                            int j1 = MathHelper.func_76128_c(this.partArray[i].field_70161_v);
                            boolean flag = false;

                            for(int l1 = -2 - this.field_70146_Z.nextInt(4); l1 <= 2 + this.field_70146_Z.nextInt(4); ++l1) {
                                for(int i2 = -2 - this.field_70146_Z.nextInt(4); i2 <= 2 + this.field_70146_Z.nextInt(4); ++i2) {
                                    for(int h = -2; h <= 2 + this.field_70146_Z.nextInt(5); ++h) {
                                        int j2 = i11 + l1;
                                        int k = i1 + h;
                                        int l = j1 + i2;
                                        Block block1 = this.field_70170_p.func_147439_a(j2, k, l);
                                        if (!block1.func_149662_c()) {
                                            this.field_70170_p.func_147449_b(j2, k, l, Blocks.field_150321_G);
                                        }
                                    }
                                }
                            }

                            entity.func_70106_y();
                        }
                    }
                }
            }
        }

        if (this.isStunned) {
            this.func_70624_b((EntityLivingBase)null);
            AnimationAPI.sendAnimPacket(this, 8);
        }

        if (this.animID == 11 && this.animTick == 1) {
            this.antiTitanAttackAnimeID = this.func_70681_au().nextInt(4);
        }

        if (!AnimationAPI.isEffectiveClient() && this.func_70638_az() != null && !this.isStunned && this.animID == 0) {
            if (!this.isBurrowing && this.func_70685_l(this.func_70638_az())) {
                AnimationAPI.sendAnimPacket(this, 1);
            }

            double d0 = this.func_70068_e(this.func_70638_az());
            if (d0 < this.getMeleeRange()) {
                if (this.isBurrowing) {
                    AnimationAPI.sendAnimPacket(this, 2);
                    this.setAnimID(2);
                } else if (!(this.func_70638_az() instanceof EntityTitan) && !(this.func_70638_az().field_70131_O >= 6.0F) && !(this.func_70638_az().field_70163_u > this.field_70163_u + (double)6.0F)) {
                    switch (this.field_70146_Z.nextInt(5)) {
                        case 0:
                            AnimationAPI.sendAnimPacket(this, 6);
                            this.setAnimID(6);
                            break;
                        case 1:
                            AnimationAPI.sendAnimPacket(this, 5);
                            this.setAnimID(5);
                            break;
                        case 2:
                            AnimationAPI.sendAnimPacket(this, 4);
                            this.setAnimID(4);
                    }
                } else {
                    AnimationAPI.sendAnimPacket(this, 11);
                    this.setAnimID(11);
                }
            } else {
                int i = 60;
                if (this.isArmored()) {
                    i = 20;
                }

                if (this.animID == 0 && !this.isBurrowing && this.func_70681_au().nextInt(i) == 0) {
                    if (this.func_70638_az().field_70163_u > this.field_70163_u + (double)12.0F) {
                        AnimationAPI.sendAnimPacket(this, 7);
                        this.setAnimID(7);
                    } else {
                        switch (this.field_70146_Z.nextInt(4)) {
                            case 0:
                                AnimationAPI.sendAnimPacket(this, 3);
                                this.setAnimID(3);
                                break;
                            case 1:
                                AnimationAPI.sendAnimPacket(this, 7);
                                this.setAnimID(7);
                                break;
                            case 2:
                                if (!this.isBurrowing) {
                                    AnimationAPI.sendAnimPacket(this, 1);
                                    this.setAnimID(1);
                                } else {
                                    AnimationAPI.sendAnimPacket(this, 3);
                                    this.setAnimID(3);
                                }
                                break;
                            case 3:
                                if (this.func_70681_au().nextInt(3) == 0) {
                                    AnimationAPI.sendAnimPacket(this, 9);
                                    this.setAnimID(9);
                                } else {
                                    AnimationAPI.sendAnimPacket(this, 3);
                                    this.setAnimID(3);
                                }
                        }
                    }
                }
            }
        }

        if (this.isStunned || this.deathTicks > 0) {
            this.field_70159_w *= (double)0.0F;
            this.field_70179_y *= (double)0.0F;
        }

        if (this.animID == 8) {
            this.func_70624_b((EntityLivingBase)null);
        }

        if (this.animID == 8) {
            if (this.animTick == 37) {
                this.func_85030_a("thetitans:largeFall", 4.0F, 1.0F);
            }

            if (this.animTick == 37) {
                this.func_85030_a("thetitans:distantLargeFall", 10000.0F, 1.0F);
            }

            if (this.animTick == 380) {
                this.isStunned = false;
            } else {
                this.func_70624_b((EntityLivingBase)null);
            }
        }

        if (this.animID == 10) {
            if (this.animTick == 74 || this.animTick == 216) {
                this.func_85030_a("thetitans:titanFall", 10.0F, 1.0F);
            }

            if (this.animTick == 76) {
                this.func_85030_a("thetitans:distantLargeFall", 10000.0F, 1.0F);
            }
        }

        if (TheTitans.NightmareMode) {
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)150.0F + (double)(this.getExtraPower() * 15));
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)16000.0F + (double)(this.getExtraPower() * 1000));
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)50.0F + (double)(this.getExtraPower() * 5));
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)8000.0F + (double)(this.getExtraPower() * 500));
        }

        this.func_94058_c("§oOmegafish");
        if (this.field_70146_Z.nextInt(100) == 0 && this.func_70638_az() != null && this.animID == 0) {
            this.func_70625_a(this.func_70638_az(), 180.0F, 180.0F);
            double d0 = this.func_70638_az().field_70165_t - this.field_70165_t;
            double d1 = this.func_70638_az().field_70161_v - this.field_70161_v;
            float f21 = MathHelper.func_76133_a(d0 * d0 + d1 * d1);
            this.field_70159_w = d0 / (double)f21 * (double)2.0F * (double)2.0F + this.field_70159_w * (double)2.0F;
            this.field_70179_y = d1 / (double)f21 * (double)2.0F * (double)2.0F + this.field_70179_y * (double)2.0F;
        }

        if (this.func_70089_S() && this.field_70146_Z.nextInt(40) == 0 && this.func_70638_az() != null && this.isArmored() && !(this.func_70638_az() instanceof EntityTitan)) {
            this.field_70125_A = -90.0F;
            this.field_70170_p.func_72885_a(this, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 2.0F, false, false);
        }

        if (!this.getWaiting() && this.animID != 13 && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
            if (this.numMinions < this.getMinionCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntitySilverfishMinion entitychicken = new EntitySilverfishMinion(this.field_70170_p);
                this.teleportEntityRandomly(entitychicken);
                entitychicken.master = this;
                entitychicken.func_85030_a("thetitans:titansummonminion", 1.0F, 1.0F);
                entitychicken.func_70024_g((double)0.0F, (double)0.5F, (double)0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(0);
                this.field_70170_p.func_72838_d(entitychicken);
                entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v);
                this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                ++this.numMinions;
                if (block == Blocks.field_150349_c) {
                    this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                }

                ++this.numMinions;
                if (this.isSubdued) {
                    entitychicken.isMasterSubdued = true;
                }

                if (this.isSubdued) {
                    entitychicken.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(entitychicken, EntityLivingBase.class, 0, false, true, entitychicken.allowPlayerPresence));
                } else {
                    entitychicken.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(entitychicken, EntityLivingBase.class, 0, false, true, ITitan.SearchForAThingToKill));
                }
            }

            if (this.numPriests < this.getPriestCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntitySilverfishMinion entitychicken = new EntitySilverfishMinion(this.field_70170_p);
                this.teleportEntityRandomly(entitychicken);
                entitychicken.master = this;
                entitychicken.func_85030_a("thetitans:titansummonminion", 1.0F, 1.0F);
                entitychicken.func_70024_g((double)0.0F, (double)0.5F, (double)0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(1);
                this.field_70170_p.func_72838_d(entitychicken);
                entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v);
                this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                ++this.numMinions;
                if (block == Blocks.field_150349_c) {
                    this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                }

                ++this.numPriests;
                if (this.isSubdued) {
                    entitychicken.isMasterSubdued = true;
                }

                if (this.isSubdued) {
                    entitychicken.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(entitychicken, EntityLivingBase.class, 0, false, true, entitychicken.allowPlayerPresence));
                } else {
                    entitychicken.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(entitychicken, EntityLivingBase.class, 0, false, true, ITitan.SearchForAThingToKill));
                }
            }

            if (this.numZealots < this.getZealotCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntitySilverfishMinion entitychicken = new EntitySilverfishMinion(this.field_70170_p);
                this.teleportEntityRandomly(entitychicken);
                entitychicken.master = this;
                entitychicken.func_85030_a("thetitans:titansummonminion", 1.0F, 1.0F);
                entitychicken.func_70024_g((double)0.0F, (double)0.5F, (double)0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(2);
                this.field_70170_p.func_72838_d(entitychicken);
                entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v);
                this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                ++this.numMinions;
                if (block == Blocks.field_150349_c) {
                    this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                }

                ++this.numZealots;
                if (this.isSubdued) {
                    entitychicken.isMasterSubdued = true;
                }

                if (this.isSubdued) {
                    entitychicken.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(entitychicken, EntityLivingBase.class, 0, false, true, entitychicken.allowPlayerPresence));
                } else {
                    entitychicken.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(entitychicken, EntityLivingBase.class, 0, false, true, ITitan.SearchForAThingToKill));
                }
            }

            if (this.numBishop < this.getBishopCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntitySilverfishMinion entitychicken = new EntitySilverfishMinion(this.field_70170_p);
                this.teleportEntityRandomly(entitychicken);
                entitychicken.master = this;
                entitychicken.func_85030_a("thetitans:titansummonminion", 1.0F, 1.0F);
                entitychicken.func_70024_g((double)0.0F, (double)0.5F, (double)0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(3);
                this.field_70170_p.func_72838_d(entitychicken);
                entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v);
                this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                ++this.numMinions;
                if (block == Blocks.field_150349_c) {
                    this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                }

                ++this.numBishop;
                if (this.isSubdued) {
                    entitychicken.isMasterSubdued = true;
                }

                if (this.isSubdued) {
                    entitychicken.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(entitychicken, EntityLivingBase.class, 0, false, true, entitychicken.allowPlayerPresence));
                } else {
                    entitychicken.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(entitychicken, EntityLivingBase.class, 0, false, true, ITitan.SearchForAThingToKill));
                }
            }

            if (this.numTemplar < this.getTemplarCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntitySilverfishMinion entitychicken = new EntitySilverfishMinion(this.field_70170_p);
                this.teleportEntityRandomly(entitychicken);
                entitychicken.master = this;
                entitychicken.func_85030_a("thetitans:titansummonminion", 1.0F, 1.0F);
                entitychicken.func_70024_g((double)0.0F, (double)0.5F, (double)0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(4);
                this.field_70170_p.func_72838_d(entitychicken);
                entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                Block block = this.field_70170_p.func_147439_a((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v);
                this.field_70170_p.func_72926_e(2001, (int)entitychicken.field_70165_t, (int)entitychicken.field_70163_u, (int)entitychicken.field_70161_v, Block.func_149682_b(block));
                if (block == Blocks.field_150349_c) {
                    this.field_70170_p.func_147449_b((int)entitychicken.field_70165_t, (int)(entitychicken.field_70163_u + (double)1.0F), (int)entitychicken.field_70161_v, Blocks.field_150346_d);
                }

                ++this.numTemplar;
                if (this.isSubdued) {
                    entitychicken.isMasterSubdued = true;
                }

                if (this.isSubdued) {
                    entitychicken.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(entitychicken, EntityLivingBase.class, 0, false, true, entitychicken.allowPlayerPresence));
                } else {
                    entitychicken.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(entitychicken, EntityLivingBase.class, 0, false, true, ITitan.SearchForAThingToKill));
                }
            }
        }

        if (!this.field_70170_p.field_72995_K && !this.isStunned && !this.getWaiting() && this.animID != 13) {
            int i = MathHelper.func_76128_c(this.field_70165_t);
            int j = MathHelper.func_76128_c(this.field_70163_u);
            int k = MathHelper.func_76128_c(this.field_70161_v);
            boolean flag = false;

            for(int l = 0; !flag && l <= 20 && l >= -20; l = l <= 0 ? 1 - l : 0 - l) {
                for(int i1 = 0; !flag && i1 <= 20 && i1 >= -20; i1 = i1 <= 0 ? 1 - i1 : 0 - i1) {
                    for(int j1 = 0; !flag && j1 <= 20 && j1 >= -20; j1 = j1 <= 0 ? 1 - j1 : 0 - j1) {
                        if (this.field_70170_p.func_147439_a(i + i1, j + l, k + j1) == Blocks.field_150418_aU) {
                            this.field_70170_p.func_147480_a(i + i1, j + l, k + j1, false);
                            EntitySilverfishMinion entitysilverfish = new EntitySilverfishMinion(this.field_70170_p);
                            entitysilverfish.func_70012_b((double)(i + i1) + (double)0.5F, (double)(j + l), (double)(k + j1) + (double)0.5F, 0.0F, 0.0F);
                            entitysilverfish.func_110161_a((IEntityLivingData)null);
                            if (!this.field_70170_p.field_72995_K) {
                                this.field_70170_p.func_72838_d(entitysilverfish);
                            }

                            this.field_70170_p.func_72876_a(entitysilverfish, entitysilverfish.field_70165_t, entitysilverfish.field_70163_u, entitysilverfish.field_70161_v, 2.0F, false);
                            entitysilverfish.func_70656_aK();
                            this.field_70170_p.func_147468_f(i + i1, j + l, k + j1);
                            if (this.field_70146_Z.nextBoolean()) {
                                flag = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        super.func_70636_d();
    }

    public StatBase getAchievement() {
        return TitansAchievments.omegafish;
    }

    public boolean attackOmegafishFrom(DamageSource source, float amount) {
        if (this.isArmored()) {
            amount /= 2.0F;
        }

        if (source.func_76346_g() != null && source.func_76346_g() instanceof EntityPlayer && source.func_76357_e()) {
            this.func_85030_a(this.func_70621_aR(), this.func_70599_aP(), this.func_70647_i());
            this.isStunned = true;
            this.func_70624_b((EntityLivingBase)null);
        }

        if (!this.func_85032_ar() && !this.isBurrowing) {
            if (!this.isStunned && source.func_76346_g() instanceof EntityPlayer) {
                return false;
            } else if (!(source.func_76346_g() instanceof EntitySilverfishMinion) && !(source.func_76346_g() instanceof EntitySilverfishTitan)) {
                this.field_70718_bc = 200;
                Entity entity = source.func_76346_g();
                if (entity instanceof EntityLivingBase && !this.func_85032_ar() && amount > 25.0F) {
                    List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)100.0F, (double)100.0F, (double)100.0F));

                    for(int i = 0; i < list.size(); ++i) {
                        Entity entity1 = (Entity)list.get(i);
                        if (entity1 instanceof EntitySilverfishTitan) {
                            EntitySilverfishTitan entitypigzombie = (EntitySilverfishTitan)entity1;
                            entitypigzombie.func_70624_b((EntityLivingBase)entity);
                            entitypigzombie.func_70604_c((EntityLivingBase)entity);
                        }

                        this.func_70624_b((EntityLivingBase)entity);
                        this.func_70604_c((EntityLivingBase)entity);
                    }
                }

                return super.func_70097_a(source, amount);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean func_70067_L() {
        return true;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        return this.attackOmegafishFrom(source, amount);
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

    protected boolean func_70610_aX() {
        return this.isSubdued && this.field_70153_n == null ? true : super.func_70610_aX();
    }

    public void func_70043_V() {
        if (this.field_70153_n != null) {
            double d8 = 0.4 + (double)this.getExtraPower() * 0.05;
            Vec3 vec3 = this.func_70676_i(1.0F);
            double dx = vec3.field_72450_a * d8;
            double dz = vec3.field_72449_c * d8;
            this.field_70153_n.func_70107_b(this.field_70165_t + dx, this.field_70163_u + (this.isBurrowing ? (double)0.5F + (double)this.getExtraPower() * 0.05 : (double)5.0F + (double)this.getExtraPower() * 0.05), this.field_70161_v + dz);
        }

    }

    public boolean func_70085_c(EntityPlayer p_70085_1_) {
        ItemStack itemstack = p_70085_1_.field_71071_by.func_70448_g();
        p_70085_1_.func_71038_i();
        if (this.isStunned && !this.isSubdued) {
            if (itemstack != null && itemstack.func_77973_b() == Items.field_151153_ao) {
                this.isSubdued = true;
                this.field_70170_p.func_72956_a(this, "random.levelup", 10.0F, 1.0F);
                p_70085_1_.func_145747_a(new ChatComponentText(this.func_94057_bL() + " has been subdued by " + p_70085_1_.func_70005_c_()));
                return super.func_70085_c(p_70085_1_);
            }
        } else if (this.isSubdued) {
            if (itemstack == null && p_70085_1_.field_70154_o == null) {
                p_70085_1_.func_70078_a(this);
            } else if (itemstack != null) {
                if (itemstack.func_77973_b() == Items.field_151045_i) {
                    AnimationAPI.sendAnimPacket(this, 9);
                    this.setAnimID(9);
                }

                if (itemstack.func_77973_b() == Items.field_151037_a) {
                    if (this.isBurrowing) {
                        AnimationAPI.sendAnimPacket(this, 2);
                        this.setAnimID(2);
                    } else {
                        AnimationAPI.sendAnimPacket(this, 1);
                        this.setAnimID(1);
                    }
                }

                if (itemstack.func_77973_b() == Items.field_151077_bg) {
                    AnimationAPI.sendAnimPacket(this, 3);
                    this.setAnimID(3);
                }

                if (itemstack.func_77973_b() == Items.field_151103_aS) {
                    switch (this.field_70146_Z.nextInt(2)) {
                        case 0:
                            AnimationAPI.sendAnimPacket(this, 5);
                            this.setAnimID(5);
                            break;
                        case 1:
                            AnimationAPI.sendAnimPacket(this, 6);
                            this.setAnimID(6);
                    }
                }
            }
        }

        return false;
    }

    protected void inactDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            this.func_85030_a("mob.silverfish.death", this.func_70599_aP(), this.func_70647_i());
            if (this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
                this.func_70628_a(true, 0);
                this.func_82160_b(true, 0);
                this.func_70600_l(1);
            }

            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.field_70170_p);
            entitytitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitytitan);
            entitytitan.setVesselHunting(false);
            entitytitan.setSpiritType(1);
        }

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
        this.isBurrowing = false;
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

        if (this.deathTicks >= 300) {
            this.setInvulTime(this.getInvulTime() + 8);
            --this.animTick;
            float f = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
            float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 4.0F;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
            this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + (double)2.0F + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
        }

        if (this.getInvulTime() >= this.getThreashHold()) {
            this.func_70106_y();
        }

    }

    public boolean attackEntityFromPart(EntityTitanPart p_70965_1_, DamageSource source, float amount) {
        this.func_82195_e(source, amount);
        return true;
    }

    protected boolean func_82195_e(DamageSource p_82195_1_, float p_82195_2_) {
        return this.attackOmegafishFrom(p_82195_1_, p_82195_2_);
    }

    public World func_82194_d() {
        return this.field_70170_p;
    }

    protected void func_70619_bc() {
        super.func_70619_bc();
        List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D);
        if (list11 != null && !list11.isEmpty()) {
            for(int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (entity instanceof EntityLivingBase && entity.field_70122_E && !(entity instanceof EntityTitan)) {
                    float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                    entity.func_70097_a(DamageSourceExtra.causeSquishingDamage(this), f / 2.0F);
                }
            }
        }

    }

    public IEntityLivingData func_110161_a(IEntityLivingData p_180482_2_) {
        Object p_180482_2_1 = super.func_110161_a(p_180482_2_);
        this.setWaiting(true);
        return (IEntityLivingData)p_180482_2_1;
    }

    public void func_70612_e(float p_70612_1_, float p_70612_2_) {
        if (this.field_70153_n != null && this.field_70153_n instanceof EntityLivingBase && this.isSubdued) {
            this.func_70624_b((EntityLivingBase)null);
            this.field_70125_A = this.field_70153_n.field_70125_A;
            this.field_70759_as = ((EntityLivingBase)this.field_70153_n).field_70759_as;
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
            p_70612_1_ = ((EntityLivingBase)this.field_70153_n).field_70702_br;
            p_70612_2_ = ((EntityLivingBase)this.field_70153_n).field_70701_bs;
            if (((EntityLivingBase)this.field_70153_n).field_70701_bs > 0.0F) {
                this.func_70024_g((double)(-MathHelper.func_76126_a(((EntityLivingBase)this.field_70153_n).field_70759_as * (float)Math.PI / 180.0F)) * this.getSpeed(), (double)0.0F, (double)MathHelper.func_76134_b(((EntityLivingBase)this.field_70153_n).field_70759_as * (float)Math.PI / 180.0F) * this.getSpeed());
            }

            if (((EntityLivingBase)this.field_70153_n).field_70701_bs < 0.0F) {
                this.func_70024_g((double)(-MathHelper.func_76126_a(((EntityLivingBase)this.field_70153_n).field_70759_as * (float)Math.PI / 180.0F)) * -this.getSpeed(), (double)0.0F, (double)MathHelper.func_76134_b(((EntityLivingBase)this.field_70153_n).field_70759_as * (float)Math.PI / 180.0F) * -this.getSpeed());
            }

            if (this.field_70122_E && ((EntityLivingBase)this.field_70153_n).field_70125_A < -80.0F) {
                this.func_70664_aZ();
            }

            if (!this.field_70170_p.field_72995_K) {
                super.func_70612_e(p_70612_1_, p_70612_2_);
            }

            this.field_70722_aY = this.field_70721_aZ;
            double do1 = this.field_70165_t - this.field_70169_q;
            double do0 = this.field_70161_v - this.field_70166_s;
            float f4 = MathHelper.func_76133_a(do1 * do1 + do0 * do0) * 4.0F;
            if (f4 > 1.0F) {
                f4 = 1.0F;
            }

            this.field_70721_aZ += (f4 - this.field_70721_aZ) * 0.4F;
            this.field_70754_ba += this.field_70721_aZ;
        } else {
            super.func_70612_e(p_70612_1_, p_70612_2_);
        }

    }
}
