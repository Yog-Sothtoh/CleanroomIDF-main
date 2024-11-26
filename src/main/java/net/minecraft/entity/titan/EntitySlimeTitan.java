//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class EntitySlimeTitan extends EntityTitan {
    public float squishAmount;
    public float squishFactor;
    public float prevSquishFactor;
    private boolean field_175452_bi;
    private int slimeJumpDelay;
    public boolean doubleJumped;

    public EntitySlimeTitan(World worldIn) {
        super(worldIn);
        this.func_70105_a(8.0F * (float)this.getSlimeSize(), 8.0F * (float)this.getSlimeSize());
        this.slimeJumpDelay = 0;
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
    }

    public boolean canAttack() {
        return true;
    }

    protected void applyEntityAI() {
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SlimeTitanSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

    }

    protected void func_70619_bc() {
        super.func_70619_bc();
        EntityLivingBase entity = this.func_70638_az();
        if (this.field_70122_E && this.slimeJumpDelay-- <= 0 && this.getInvulTime() <= 0) {
            this.slimeJumpDelay = this.getJumpDelay();
            if (entity != null) {
                this.slimeJumpDelay /= 3;
                this.func_70671_ap().func_75651_a(entity, 180.0F, 60.0F);
            }

            this.func_70664_aZ();
            if (this.makesSoundOnJump()) {
                this.func_85030_a(this.getJumpSound(), this.func_70599_aP(), ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F) * 0.8F);
            }

            this.field_70701_bs = (float)(2 * this.getSlimeSize());
            this.func_70612_e(this.field_70702_br, this.field_70701_bs);
        } else {
            this.field_70703_bu = false;
            if (this.field_70122_E) {
                this.field_70702_br = this.field_70701_bs = 0.0F;
            }
        }

    }

    public boolean func_70686_a(Class p_70686_1_) {
        return (p_70686_1_ == EntityMagmaCube.class || p_70686_1_ != EntitySlime.class) && (p_70686_1_ == EntityMagmaCubeTitan.class || p_70686_1_ != EntitySlimeTitan.class);
    }

    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(20) == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL;
    }

    public int getMinionSpawnRate() {
        return TheTitans.SlimeTitanMinionSpawnrate;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, (byte)1);
    }

    protected void setSlimeSize(int p_70799_1_) {
        this.field_70180_af.func_75692_b(16, (byte)p_70799_1_);
        this.func_70105_a(8.0F * (float)p_70799_1_, 8.0F * (float)p_70799_1_);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        if (TheTitans.NightmareMode) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)p_70799_1_ * (double)2000.0F);
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)p_70799_1_ * (double)1000.0F);
        }

        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)this.getAttackStrength());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)(0.5F + 0.1F * (float)p_70799_1_));
        this.setTitanHealth(this.func_110138_aP());
        if (this instanceof EntityMagmaCubeTitan) {
            this.field_70728_aV = p_70799_1_ * 3000;
        } else {
            this.field_70728_aV = p_70799_1_ * 1000;
        }

    }

    public int getParticleCount() {
        return 4;
    }

    public String getParticles() {
        return this.func_180487_n();
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)this.getAttackStrength());
    }

    public int getSlimeSize() {
        return this.field_70180_af.func_75683_a(16);
    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        tagCompound.func_74768_a("Size", this.getSlimeSize() - 1);
        tagCompound.func_74757_a("wasOnGround", this.field_175452_bi);
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        int i = tagCompund.func_74762_e("Size");
        if (i < 0) {
            i = 0;
        }

        this.setSlimeSize(i + 1);
        this.field_175452_bi = tagCompund.func_74767_n("wasOnGround");
    }

    protected String func_180487_n() {
        return "slime";
    }

    protected String getJumpSound() {
        return "mob.slime.big";
    }

    protected String getSlimeParticle() {
        return "slime";
    }

    public void func_70071_h_() {
        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
        this.prevSquishFactor = this.squishFactor;
        boolean flag = this.field_70122_E;
        super.func_70071_h_();
        if (this.field_70122_E && !flag) {
            int i = this.getSlimeSize();

            for(int j = 0; j < i * 32; ++j) {
                float f = this.field_70146_Z.nextFloat() * (float)Math.PI * 2.0F;
                float f1 = this.field_70146_Z.nextFloat() * 8.0F + 8.0F;
                float f2 = MathHelper.func_76126_a(f) * (float)i * 0.5F * f1;
                float f3 = MathHelper.func_76134_b(f) * (float)i * 0.5F * f1;
                this.field_70170_p.func_72869_a(this.getSlimeParticle(), this.field_70165_t + (double)f2, this.field_70121_D.field_72338_b, this.field_70161_v + (double)f3, (double)0.0F, (double)0.0F, (double)0.0F);
            }

            if (this.makesSoundOnLand()) {
                this.func_85030_a(this.getJumpSound(), this.func_70599_aP(), ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            }

            this.squishAmount = -0.5F;
        } else if (!this.field_70122_E && flag) {
            this.squishAmount = 1.0F;
        }

        this.alterSquishAmount();
    }

    public boolean shouldMove() {
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70761_aq = this.field_70177_z;
        if (!this.func_70089_S()) {
            if (this instanceof EntityMagmaCubeTitan) {
                this.squishAmount = 1.0F;
            } else {
                this.squishAmount = -0.5F;
            }
        }

        this.destroyBlocksInAABB(this.field_70121_D.func_72317_d(this.field_70159_w, this.field_70181_x > (double)0.0F ? this.field_70181_x : (double)0.0F, this.field_70179_y));
        List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(0.1, 0.1, 0.1));
        if (list != null && !list.isEmpty() && this.func_70089_S()) {
            for(int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                if (entity != null && entity instanceof EntityLivingBase && this.func_70686_a(entity.getClass())) {
                    this.func_175451_e((EntityLivingBase)entity);
                }
            }
        }

        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)this.getAttackStrength());
        this.meleeTitan = true;
        if (this.createProtoInstance() instanceof EntityMagmaCube) {
            this.func_94058_c(StatCollector.func_74838_a("entity.LavaSlimeTitan.name"));
            this.field_70747_aH = 0.75F;
            List list1 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)128.0F, (double)128.0F, (double)128.0F));
            if (list1 != null && !list1.isEmpty()) {
                for(int i1 = 0; i1 < list1.size(); ++i1) {
                    Entity entity = (Entity)list1.get(i1);
                    if (entity != null && entity instanceof EntityMagmaCube && this.func_70638_az() != null) {
                        ((EntityMagmaCube)entity).func_70625_a(this.func_70638_az(), 180.0F, 180.0F);
                        if (((EntityMagmaCube)entity).field_70122_E || ((EntityMagmaCube)entity).func_70090_H() || ((EntityMagmaCube)entity).func_70058_J()) {
                            ((EntityMagmaCube)entity).field_70181_x = (double)(0.6F + (float)((EntityMagmaCube)entity).func_70809_q() * 0.1F);
                        }

                        ((EntityMagmaCube)entity).func_70657_f(2.0F);
                    }
                }
            }
        } else {
            this.func_94058_c(StatCollector.func_74838_a("entity.SlimeTitan.name"));
            this.field_70747_aH = 0.5F;
            List list1 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)128.0F, (double)128.0F, (double)128.0F));
            if (list1 != null && !list1.isEmpty()) {
                for(int i1 = 0; i1 < list1.size(); ++i1) {
                    Entity entity = (Entity)list1.get(i1);
                    if (entity != null && entity instanceof EntitySlime && !(entity instanceof EntityMagmaCube) && this.func_70638_az() != null) {
                        ((EntitySlime)entity).func_70625_a(this.func_70638_az(), 180.0F, 180.0F);
                        if (((EntitySlime)entity).field_70122_E || ((EntitySlime)entity).func_70090_H() || ((EntitySlime)entity).func_70058_J()) {
                            ((EntitySlime)entity).field_70181_x = (double)0.5F;
                        }

                        ((EntitySlime)entity).func_70657_f(2.0F);
                    }
                }
            }
        }

        if (this.func_70638_az() != null) {
            this.func_70625_a(this.func_70638_az(), 180.0F, 40.0F);
        }

        if (this.func_70638_az() == null && this.doubleJumped || this.field_70122_E) {
            this.doubleJumped = false;
        }

        if (this.func_70638_az() != null && !this.doubleJumped && this.field_70146_Z.nextInt(100) == 0 && !this.field_70122_E) {
            this.squishAmount = 2.0F;
            this.func_70664_aZ();
            this.doubleJumped = true;
            this.func_85030_a(this.getJumpSound(), this.func_70599_aP(), ((this.func_70681_au().nextFloat() - this.func_70681_au().nextFloat()) * 0.2F + 1.0F) * 0.8F);
        }

        if (this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K) {
            EntitySlime entitychicken = this.createProtoInstance();
            entitychicken.func_110161_a((IEntityLivingData)null);
            this.field_70170_p.func_72838_d(entitychicken);
            entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
            entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
        }

    }

    protected void alterSquishAmount() {
        this.squishAmount *= 0.85F;
    }

    protected int getJumpDelay() {
        return this.field_70146_Z.nextInt(40) + 20;
    }

    protected EntitySlimeTitan createInstance() {
        return new EntitySlimeTitan(this.field_70170_p);
    }

    protected EntitySlime createProtoInstance() {
        return new EntitySlime(this.field_70170_p);
    }

    public void func_145781_i(int p_145781_1_) {
        if (p_145781_1_ == 16) {
            int j = this.getSlimeSize();
            this.func_70105_a(8.0F * (float)j, 8.0F * (float)j);
        }

        super.func_145781_i(p_145781_1_);
    }

    public void func_70108_f(Entity entityIn) {
        if (entityIn instanceof EntityTitan) {
            super.func_70108_f(entityIn);
        }

        if (this.func_70686_a(entityIn.getClass())) {
            int i = this.getSlimeSize();
            if (this.field_70173_aa % 5 == 0 && this.func_70089_S()) {
                float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                int i1 = this.getKnockbackAmount();
                this.field_70761_aq = this.field_70177_z = this.field_70759_as;
                this.attackChoosenEntity(entityIn, f, i1);
                if (!entityIn.func_70089_S() && !(entityIn instanceof EntityTitan)) {
                    this.func_85030_a("mob.slime.attack", 100.0F, 0.5F);
                    if (entityIn instanceof EntityLivingBase) {
                        this.func_70691_i(((EntityLivingBase)entityIn).func_110138_aP());
                    }

                    entityIn.field_70128_L = true;
                    if (!this.field_70170_p.field_72995_K) {
                        EntitySlime entitychicken = this.createProtoInstance();
                        entitychicken.func_110161_a((IEntityLivingData)null);
                        entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 100, 4, false));
                        entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                        this.field_70170_p.func_72838_d(entitychicken);
                    }
                }
            }
        }

    }

    public void func_70100_b_(EntityPlayer entityIn) {
        this.func_175451_e(entityIn);
    }

    protected void func_175451_e(EntityLivingBase p_175451_1_) {
    }

    public float func_70047_e() {
        return 0.625F * this.field_70131_O;
    }

    protected int getAttackStrength() {
        return TheTitans.NightmareMode ? this.getSlimeSize() * 90 : this.getSlimeSize() * 30;
    }

    protected String func_70621_aR() {
        return "mob.slime.big";
    }

    protected String func_70673_aS() {
        return "mob.slime.big";
    }

    protected Item func_146068_u() {
        return Items.field_151123_aH;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            for(int x = 0; x < this.getSlimeSize(); ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                entitylargefireball.func_70107_b(this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                entitylargefireball.field_70181_x += (double)0.5F;
                entitylargefireball.setXPCount(this instanceof EntityMagmaCubeTitan ? 2000 : 1000);
                this.field_70170_p.func_72838_d(entitylargefireball);
            }

            if (this.getSlimeSize() <= 1) {
                for(int l = 0; l < 64 + this.field_70146_Z.nextInt(64 + p_70628_2_) + p_70628_2_; ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(this.func_146068_u()));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 16 + this.field_70146_Z.nextInt(16 + p_70628_2_) + p_70628_2_; ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151044_h));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 0 + this.field_70146_Z.nextInt(8 + p_70628_2_); ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151166_bC));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 0 + this.field_70146_Z.nextInt(8 + p_70628_2_); ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151045_i));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }

                for(int l = 0; l < 0 + this.field_70146_Z.nextInt(4 + p_70628_2_); ++l) {
                    EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(TitanItems.harcadiumWaflet));
                    entityitem.field_145804_b = 40;
                    this.field_70170_p.func_72838_d(entityitem);
                }
            }
        }

    }

    protected boolean isValidLightLevel() {
        return true;
    }

    public int func_70646_bf() {
        return 30;
    }

    protected boolean makesSoundOnJump() {
        return true;
    }

    protected boolean makesSoundOnLand() {
        return true;
    }

    protected void func_70664_aZ() {
        this.field_70181_x = (double)1.5F + (double)((float)this.getSlimeSize() * 0.2F);
        this.field_70160_al = true;
        if (this.func_70638_az() != null) {
            double d01 = this.func_70638_az().field_70165_t - this.field_70165_t;
            double d11 = this.func_70638_az().field_70161_v - this.field_70161_v;
            float f21 = MathHelper.func_76133_a(d01 * d01 + d11 * d11);
            double hor = (double)1.5F + (double)((float)this.getSlimeSize() * 0.25F);
            this.field_70159_w = d01 / (double)f21 * hor * hor + this.field_70159_w * hor;
            this.field_70179_y = d11 / (double)f21 * hor * hor + this.field_70179_y * hor;
        }

    }

    protected void func_70069_a(float p_70069_1_) {
        this.field_70122_E = true;
        this.field_70160_al = false;
        if (!this.field_70170_p.field_72995_K && this.field_70146_Z.nextInt(5) == 0 && this.func_70638_az() == null) {
            this.field_70761_aq = this.field_70177_z = this.field_70759_as = this.field_70146_Z.nextFloat() * 360.0F;
        }

        p_70069_1_ = ForgeHooks.onLivingFall(this, p_70069_1_);
        if (!(p_70069_1_ <= 0.0F)) {
            PotionEffect potioneffect = this.func_70660_b(Potion.field_76430_j);
            float f1 = potioneffect != null ? (float)(potioneffect.func_76458_c() + 1) : 0.0F;
            int i = MathHelper.func_76123_f(p_70069_1_ - 12.0F - f1);
            if (i > 0) {
                this.func_85030_a("thetitans:titanSlam", 5.0F * (float)this.getSlimeSize(), 2.0F - (float)(this.getSlimeSize() / 4));
                this.func_85030_a("mob.slime.big", 5.0F * (float)this.getSlimeSize(), 2.0F - (float)(this.getSlimeSize() / 8));
                List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)6.0F * (double)this.getSlimeSize(), (double)6.0F * (double)this.getSlimeSize(), (double)6.0F * (double)this.getSlimeSize()));
                if (list11 != null && !list11.isEmpty()) {
                    for(int i1 = 0; i1 < list11.size(); ++i1) {
                        Entity entity = (Entity)list11.get(i1);
                        if (entity instanceof EntityLivingBase && this.func_70686_a(entity.getClass()) && this.func_70068_e(entity) <= (double)(this.field_70130_N * this.field_70130_N + this.field_70130_N * this.field_70130_N)) {
                            float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                            int i11 = this.getKnockbackAmount();
                            this.attackChoosenEntity(entity, f, i11);
                            double d0 = this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d;
                            double d1 = this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f;
                            double d2 = entity.field_70165_t - d0;
                            double d3 = entity.field_70161_v - d1;
                            double d4 = d2 * d2 + d3 * d3;
                            if (this.doubleJumped) {
                                entity.func_70024_g(d2 / d4 * (double)16.0F, (double)2.0F, d3 / d4 * (double)16.0F);
                            } else {
                                entity.func_70024_g(d2 / d4 * (double)8.0F, (double)1.0F, d3 / d4 * (double)8.0F);
                            }
                        }
                    }
                }
            }

        }
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (!this.field_70170_p.field_72995_K) {
            EntitySlime entitychicken = this.createProtoInstance();
            entitychicken.func_110161_a((IEntityLivingData)null);
            entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 100, 4, false));
            entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitychicken);
        }

        if (this.func_85032_ar()) {
            return false;
        } else {
            if (this instanceof EntityMagmaCubeTitan) {
                if (source.func_76346_g() instanceof EntityMagmaCubeTitan) {
                    return false;
                }
            } else if (source.func_76346_g() instanceof EntitySlimeTitan && !(source.func_76346_g() instanceof EntityMagmaCubeTitan)) {
                return false;
            }

            Entity entity = source.func_76346_g();
            if (entity instanceof EntityLivingBase && !this.func_85032_ar() && amount > 25.0F) {
                List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)100.0F, (double)100.0F, (double)100.0F));

                for(int i = 0; i < list.size(); ++i) {
                    label37: {
                        Entity entity1 = (Entity)list.get(i);
                        if (this instanceof EntityMagmaCubeTitan) {
                            if (!(entity1 instanceof EntityMagmaCubeTitan)) {
                                break label37;
                            }
                        } else if (!(entity1 instanceof EntitySlimeTitan) || entity1 instanceof EntityMagmaCubeTitan) {
                            break label37;
                        }

                        EntitySlimeTitan entitypigzombie = (EntitySlimeTitan)entity1;
                        entitypigzombie.func_70624_b((EntityLivingBase)entity);
                        entitypigzombie.func_70604_c((EntityLivingBase)entity);
                    }

                    this.func_70624_b((EntityLivingBase)entity);
                    this.func_70604_c((EntityLivingBase)entity);
                }
            }

            return super.func_70097_a(source, amount);
        }
    }

    public IEntityLivingData func_110161_a(IEntityLivingData p_180482_2_) {
        int i = this.field_70146_Z.nextInt(3);
        if (i < 2 && this.field_70146_Z.nextFloat() < 0.5F) {
            ++i;
        }

        int j = 1 << i;
        this.setSlimeSize(j);
        return super.func_110161_a(p_180482_2_);
    }

    public StatBase getAchievement() {
        return this.createProtoInstance() instanceof EntityMagmaCube ? TitansAchievments.magmacubetitan : TitansAchievments.slimetitan;
    }

    protected void inactDeathAction() {
        this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u + (double)3.0F, this.field_70161_v, 0.0F, false, false);
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
            this.func_70628_a(true, 0);
            this.func_82160_b(true, 0);
            this.func_70600_l(1);
        }

        int i = this.getSlimeSize();
        if (!this.field_70170_p.field_72995_K) {
            for(int i1 = 0; i1 < 8 * this.getSlimeSize() + this.field_70170_p.field_73012_v.nextInt(8 * this.getSlimeSize()); ++i1) {
                EntitySlime entitychicken = this.createProtoInstance();
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 100, 4, false));
                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                this.field_70170_p.func_72838_d(entitychicken);
            }
        }

        if (!this.field_70170_p.field_72995_K && i > 1) {
            int j = 2 + this.field_70146_Z.nextInt(3);

            for(int k = 0; k < j; ++k) {
                float f = ((float)(k % 2) - 0.5F) * (float)i / 4.0F;
                float f1 = ((float)(k / 2) - 0.5F) * (float)i / 4.0F;
                EntitySlimeTitan entityslime = this.createInstance();
                if (this.func_94056_bM()) {
                    entityslime.func_94058_c(this.func_94057_bL());
                }

                if (this.func_104002_bU()) {
                    entityslime.func_110163_bv();
                }

                entityslime.setSlimeSize(i / 2);
                entityslime.func_70012_b(this.field_70165_t + (double)f, this.field_70163_u + (double)0.5F, this.field_70161_v + (double)f1, this.field_70146_Z.nextFloat() * 360.0F, 0.0F);
                this.field_70170_p.func_72838_d(entityslime);
            }
        }

    }
}
