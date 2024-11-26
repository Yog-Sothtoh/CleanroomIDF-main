//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titanminion;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Calendar;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.titan.EntityPigZombieTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.entity.titan.ITitan;
import net.minecraft.entity.titan.ai.EntityAIBreakDoorMinion;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.ClientProxy;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityZombieMinion extends EntityZombie implements IRangedAttackMob, ITemplar {
    public EntityLiving master;
    public int randomSoundDelay;
    public EntityLiving entityToHeal;
    private int attackPattern;
    private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, (double)1.0F, 10, 64.0F);
    private float heightOffset = 0.5F;
    private int heightOffsetUpdateTime;
    public int deathTicks;

    public EntityZombieMinion(World worldIn) {
        super(worldIn);

        for(int i = 0; i < this.field_82174_bp.length; ++i) {
            this.field_82174_bp[i] = 0.2F;
        }

        this.func_70105_a(0.5F, 1.95F);
        this.func_70661_as().func_75498_b(true);
        this.func_70661_as().func_75490_c(true);
        this.field_70714_bg.func_75776_a(0, new EntityAIAvoidEntity(this, EntityWitherSkull.class, 2.0F, 1.2, (double)1.75F));
        this.field_70714_bg.func_75776_a(0, new EntityAIAvoidEntity(this, EntityTitanSpirit.class, 48.0F, (double)1.5F, (double)1.5F));
        this.field_70714_bg.func_75776_a(0, new EntityAIBreakDoorMinion(this));
        this.field_70714_bg.func_75776_a(1, new EntityAIMoveTowardsRestriction(this, 1.2));
        this.field_70714_bg.func_75776_a(1, new EntityAIRestrictSun(this));
        this.field_70714_bg.func_75776_a(1, new EntityAIFleeSun(this, 1.2));
        this.field_70714_bg.func_75776_a(1, new EntityAIAttackOnCollide(this, EntityLivingBase.class, (double)1.0F, true));
        this.field_70714_bg.func_75776_a(0, new EntityAIFindEntityNearestInjuredAlly(this));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.ZombieTitanSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a((double)24.0F);
    }

    public void func_70106_y() {
        super.func_70106_y();
        if (this.master != null && this.master instanceof EntityTitan) {
            ((EntityTitan)this.master).retractMinionNumFromType(this.getMinionType());
        }

    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(19, 0);
    }

    public void setCombatTask() {
        this.field_70714_bg.func_85156_a(this.aiArrowAttack);
        if (this.attackPattern == 0 && this.getMinionTypeInt() == 4) {
            this.field_70714_bg.func_75776_a(0, this.aiArrowAttack);
        }

    }

    protected String func_70639_aQ() {
        if (this.getMinionTypeInt() == 4) {
            this.func_85030_a("mob.zombie.say", this.func_70599_aP(), this.func_70647_i() - 0.5F);
        }

        return this.getMinionTypeInt() == 4 ? "thetitans:titanZombieLiving" : "mob.zombie.say";
    }

    protected String func_70621_aR() {
        if (this.getMinionTypeInt() == 4) {
            this.func_85030_a("mob.zombie.hurt", this.func_70599_aP(), this.func_70647_i() - 0.5F);
        }

        return this.getMinionTypeInt() == 4 ? "thetitans:titanZombieGrunt" : "mob.zombie.hurt";
    }

    protected String func_70673_aS() {
        if (this.getMinionTypeInt() == 4) {
            this.func_85030_a("mob.zombie.death", this.func_70599_aP(), this.func_70647_i() - 0.5F);
        }

        return this.getMinionTypeInt() == 4 ? "thetitans:titanZombieDeath" : "mob.zombie.death";
    }

    protected float func_70647_i() {
        return this.getMinionTypeInt() == 4 ? super.func_70647_i() + 0.2F : super.func_70647_i();
    }

    public int func_70658_aO() {
        int i = 2;

        for(ItemStack itemstack : this.func_70035_c()) {
            if (itemstack != null && itemstack.func_77973_b() instanceof ItemArmor) {
                int l = ((ItemArmor)itemstack.func_77973_b()).field_77879_b;
                i += l;
            }
        }

        switch (this.getMinionTypeInt()) {
            case 1:
                i += 2;
                break;
            case 2:
                i += 15;
                break;
            case 3:
                i += 18;
                break;
            case 4:
                i += 22;
        }

        if (i > 24) {
            i = 24;
        }

        return i;
    }

    protected float func_70672_c(DamageSource p_70672_1_, float p_70672_2_) {
        if (this.getMinionTypeInt() == 4) {
            p_70672_2_ = super.func_70672_c(p_70672_1_, p_70672_2_);
            if (p_70672_1_.func_76346_g() == this) {
                p_70672_2_ = 0.0F;
            }

            if (p_70672_1_.func_82725_o()) {
                p_70672_2_ = (float)((double)p_70672_2_ * 0.15);
            }

            return p_70672_2_;
        } else {
            return super.func_70672_c(p_70672_1_, p_70672_2_);
        }
    }

    public String func_70005_c_() {
        switch (this.getMinionTypeInt()) {
            case 1:
                return StatCollector.func_74838_a("entity.ZombiePriest.name");
            case 2:
                return StatCollector.func_74838_a("entity.ZombieZealot.name");
            case 3:
                return StatCollector.func_74838_a("entity.ZombieBishop.name");
            case 4:
                return StatCollector.func_74838_a("entity.ZombieTemplar.name");
            default:
                return StatCollector.func_74838_a("entity.ZombieLoyalist.name");
        }
    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        tagCompound.func_74768_a("MinionType", this.getMinionTypeInt());
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        this.setMinionType(tagCompund.func_74762_e("MinionType"));
    }

    public int getMinionTypeInt() {
        return this.field_70180_af.func_75679_c(19);
    }

    public EnumMinionType getMinionType() {
        switch (this.getMinionTypeInt()) {
            case 1:
                return EnumMinionType.PRIEST;
            case 2:
                return EnumMinionType.ZEALOT;
            case 3:
                return EnumMinionType.BISHOP;
            case 4:
                return EnumMinionType.TEMPLAR;
            default:
                return EnumMinionType.LOYALIST;
        }
    }

    public void setMinionType(int miniontype) {
        this.field_70180_af.func_75692_b(19, miniontype);
        if (miniontype == 1) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)40.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)4.0F);
            this.field_70714_bg.func_75776_a(0, new EntityAIFindEntityNearestInjuredAlly(this));
            this.func_70606_j(40.0F);
            this.field_70728_aV = 15;
        } else if (miniontype == 2) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)180.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)10.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.5F);
            this.func_70606_j(180.0F);
            this.field_70728_aV = 100;
        } else if (miniontype == 3) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)400.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)15.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.375F);
            this.field_70178_ae = true;
            this.func_70606_j(400.0F);
            this.field_70728_aV = 200;
        } else if (miniontype == 4) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)1800.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)30.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
            this.field_70178_ae = true;
            this.func_70606_j(1800.0F);
            this.field_70728_aV = 1000;
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)26.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)3.0F);
            this.func_70606_j(26.0F);
            this.field_70728_aV = 7;
        }

    }

    @SideOnly(Side.CLIENT)
    public int func_70070_b(float p_70070_1_) {
        return this.getMinionTypeInt() == 4 ? 15728880 : super.func_70070_b(p_70070_1_);
    }

    public float func_70013_c(float p_70013_1_) {
        return this.getMinionTypeInt() == 4 ? 1.0F : super.func_70013_c(p_70013_1_);
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        super.func_70628_a(p_70628_1_, p_70628_2_);
        int j = this.field_70146_Z.nextInt(3);
        if (p_70628_2_ > 0) {
            j += this.field_70146_Z.nextInt(p_70628_2_ + 1);
        }

        for(int k = 0; k < j; ++k) {
            this.func_145779_a(Items.field_151008_G, 1);
        }

        j = this.field_70146_Z.nextInt(2);

        for(int k = 0; k < j; ++k) {
            this.func_145779_a(Items.field_151103_aS, 1);
        }

        if (this.getMinionTypeInt() >= 1) {
            j = this.field_70146_Z.nextInt(2);
            if (p_70628_2_ > 0) {
                j += this.field_70146_Z.nextInt(p_70628_2_ + 1);
            }

            for(int k = 0; k < j; ++k) {
                this.func_145779_a(Items.field_151062_by, 1);
            }

            if (this.getMinionTypeInt() >= 2) {
                j = this.field_70146_Z.nextInt(2);
                if (p_70628_2_ > 0) {
                    j += this.field_70146_Z.nextInt(p_70628_2_ + 1);
                }

                for(int k = 0; k < j; ++k) {
                    this.func_145779_a(Items.field_151153_ao, 1);
                }

                if (this.getMinionTypeInt() >= 3) {
                    j = this.field_70146_Z.nextInt(2);
                    if (p_70628_2_ > 0) {
                        j += this.field_70146_Z.nextInt(p_70628_2_ + 1);
                    }

                    for(int k = 0; k < j; ++k) {
                        switch (this.field_70146_Z.nextInt(5)) {
                            case 0:
                                this.func_145779_a(Items.field_151166_bC, 1);
                                break;
                            case 1:
                                this.func_145779_a(Items.field_151045_i, 1);
                                break;
                            case 2:
                                this.func_145779_a(Items.field_151043_k, 1);
                                break;
                            case 3:
                                this.func_145779_a(Items.field_151043_k, 1);
                                break;
                            case 4:
                                this.func_145779_a(Items.field_151043_k, 1);
                        }
                    }

                    if (this.getMinionTypeInt() >= 4) {
                        if (this.field_70146_Z.nextInt(5) == 0) {
                            this.func_70099_a(new ItemStack(TitanItems.pleasantBladeSeed), 0.0F);
                        }

                        if (this.field_70146_Z.nextInt(100) == 0) {
                            this.func_70099_a(new ItemStack(TitanItems.malgrumSeeds), 0.0F);
                        }

                        j = 2 + this.field_70146_Z.nextInt(5);
                        if (p_70628_2_ > 0) {
                            j += this.field_70146_Z.nextInt(p_70628_2_ + 1);
                        }

                        for(int k = 0; k < j; ++k) {
                            switch (this.field_70146_Z.nextInt(3)) {
                                case 0:
                                    this.func_145779_a(Items.field_151166_bC, 1);
                                    break;
                                case 1:
                                    this.func_145779_a(Items.field_151045_i, 1);
                                    break;
                                case 2:
                                    this.func_145779_a(Items.field_151043_k, 1);
                            }
                        }
                    }
                }
            }
        }

    }

    public boolean func_70652_k(Entity p_70652_1_) {
        if (super.func_70652_k(p_70652_1_)) {
            if (p_70652_1_ instanceof EntityLivingBase && this.getMinionTypeInt() >= 3) {
                byte b0 = 10;
                if (this.field_70170_p.field_73013_u == EnumDifficulty.NORMAL) {
                    b0 = 20;
                } else if (this.field_70170_p.field_73013_u == EnumDifficulty.HARD) {
                    b0 = 30;
                }

                if (b0 > 0) {
                    ((EntityLivingBase)p_70652_1_).func_70690_d(new PotionEffect(ClientProxy.electricJudgment.field_76415_H, b0 * 20, 0));
                }
            }

            return true;
        } else {
            return false;
        }
    }

    protected void func_70600_l(int p_70600_1_) {
        super.func_70600_l(p_70600_1_);
        this.func_70099_a(new ItemStack(Items.field_151144_bL, 1, 2), 0.0F);
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != EntityZombieMinion.class && p_70686_1_ != EntityGiantZombieBetter.class && p_70686_1_ != EntityZombieTitan.class;
    }

    protected void func_70069_a(float p_70069_1_) {
        if (this.getMinionTypeInt() != 4) {
            super.func_70069_a(p_70069_1_);
        }

        this.field_70701_bs = 0.0F;
        this.field_70702_br = 0.0F;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (!this.func_85032_ar() && (this.getMinionTypeInt() < 4 || source != DamageSourceExtra.radiation)) {
            if (!(source.func_76346_g() instanceof EntityZombieMinion) && (!(source.func_76346_g() instanceof EntityZombieTitan) || source.func_76346_g() instanceof EntityPigZombieTitan) && !(source.func_76346_g() instanceof EntityGiantZombieBetter)) {
                if (source.func_76346_g() != null && this.field_70702_br == 0.0F && this.getMinionType() == EnumMinionType.ZEALOT) {
                    this.field_70761_aq = this.field_70177_z = this.field_70759_as;
                    this.func_85030_a("thetitans:titanSwing", 1.0F, 2.0F);
                    switch (this.field_70146_Z.nextInt(3)) {
                        case 0:
                            this.field_70701_bs = -2.0F;
                            this.func_70060_a(0.0F, -2.0F, 0.99F);
                            this.field_70702_br = 0.01F;
                            break;
                        case 1:
                            this.field_70702_br = 1.0F;
                            this.func_70060_a(1.0F, 0.0F, 0.25F);
                            break;
                        case 2:
                            this.field_70702_br = -1.0F;
                            this.func_70060_a(-1.0F, 0.0F, 0.25F);
                    }

                    this.func_70664_aZ();
                    return false;
                } else {
                    Entity entity = source.func_76346_g();
                    if (entity instanceof EntityLivingBase) {
                        List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)32.0F, (double)32.0F, (double)32.0F));

                        for(int i = 0; i < list.size(); ++i) {
                            Entity entity1 = (Entity)list.get(i);
                            if (entity1 instanceof EntityZombieMinion) {
                                EntityZombieMinion entitypigzombie = (EntityZombieMinion)entity1;
                                entitypigzombie.func_70624_b((EntityLivingBase)entity);
                                entitypigzombie.func_70604_c((EntityLivingBase)entity);
                                entitypigzombie.randomSoundDelay = this.field_70146_Z.nextInt(40);
                            }

                            this.func_70624_b((EntityLivingBase)entity);
                            this.func_70604_c((EntityLivingBase)entity);
                            this.randomSoundDelay = this.field_70146_Z.nextInt(40);
                        }
                    }

                    return super.func_70097_a(source, amount);
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    protected void func_82164_bB() {
        if (this.field_70146_Z.nextFloat() < (this.field_70170_p.field_73013_u == EnumDifficulty.NORMAL ? 0.25F : (this.field_70170_p.field_73013_u == EnumDifficulty.HARD ? 0.95F : 0.05F))) {
            int i = this.field_70146_Z.nextInt(2);
            float f = this.field_70170_p.field_73013_u == EnumDifficulty.HARD ? 0.2F : 0.1F;
            if (this.field_70146_Z.nextFloat() < 0.25F) {
                ++i;
            }

            if (this.field_70146_Z.nextFloat() < 0.25F) {
                ++i;
            }

            if (this.field_70146_Z.nextFloat() < 0.25F) {
                ++i;
            }

            for(int j = 3; j >= 0; --j) {
                ItemStack itemstack = this.func_130225_q(j);
                if (j < 3 && this.field_70146_Z.nextFloat() < f) {
                    break;
                }

                if (itemstack == null) {
                    Item item = func_82161_a(j + 1, i);
                    if (item != null) {
                        this.func_70062_b(j + 1, new ItemStack(item));
                    }
                }
            }
        }

        if (this.field_70146_Z.nextFloat() < (this.field_70170_p.field_73013_u == EnumDifficulty.HARD ? 0.75F : 0.1F)) {
            int i = this.field_70146_Z.nextInt(3);
            if (i == 0) {
                this.func_70062_b(0, new ItemStack(Items.field_151040_l));
            } else {
                this.func_70062_b(0, new ItemStack(Items.field_151037_a));
            }
        }

    }

    public IEntityLivingData func_110161_a(IEntityLivingData p_110161_1_) {
        Object p_110161_1_1 = p_110161_1_;
        float f = this.field_70170_p.func_147462_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.func_98053_h(true);
        if (p_110161_1_ == null) {
            p_110161_1_1 = new GroupData(this.field_70170_p.field_73012_v.nextFloat() < (this.field_70170_p.field_73013_u == EnumDifficulty.NORMAL ? 0.05F : (this.field_70170_p.field_73013_u == EnumDifficulty.HARD ? 0.25F : 0.005F)), this.field_70170_p.field_73012_v.nextFloat() < 0.1F, (Object)null);
        }

        if (p_110161_1_1 instanceof GroupData) {
            GroupData groupdata = (GroupData)p_110161_1_1;
            if (groupdata.field_142046_b) {
                this.func_82229_g(true);
            }

            if (groupdata.field_142048_a) {
                this.func_82227_f(true);
            }
        }

        this.func_146070_a(true);
        this.func_82164_bB();
        this.func_82162_bC();
        Calendar calendar = this.field_70170_p.func_83015_S();
        if (!this.func_70631_g_() && !this.func_82231_m() && calendar.get(2) + 1 == 10 && calendar.get(5) >= 1 && calendar.get(5) <= 31 && this.field_70146_Z.nextFloat() < 0.5F) {
            this.func_70062_b(4, new ItemStack(this.field_70146_Z.nextFloat() < 0.1F ? Blocks.field_150428_aP : Blocks.field_150423_aK));
            this.field_82174_bp[4] = 0.0F;
        }

        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111121_a(new AttributeModifier("Random spawn bonus", this.field_70146_Z.nextDouble() * 0.1, 0));
        double d0 = this.field_70146_Z.nextDouble() * (double)1.5F * (double)f;
        if (d0 > (double)1.0F) {
            this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111121_a(new AttributeModifier("Random zombie-spawn bonus", d0, 2));
        }

        if (this.field_70146_Z.nextFloat() < f * ((float)this.getMinionTypeInt() * 0.1F + 0.1F)) {
            this.func_110148_a(field_110186_bp).func_111121_a(new AttributeModifier("Leader zombie bonus", this.field_70146_Z.nextDouble() * (double)0.25F + (double)0.5F, 0));
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111121_a(new AttributeModifier("Leader zombie bonus", this.field_70146_Z.nextDouble() * (double)3.0F + (double)4.0F, 2));
        }

        if (!this.field_70170_p.field_72995_K) {
            this.setMinionType(0);
            if (this.field_70146_Z.nextInt(2) == 0) {
                this.setMinionType(1);
                if (this.field_70146_Z.nextInt(2) == 0) {
                    this.setMinionType(2);
                    if (this.field_70146_Z.nextInt(2) == 0) {
                        this.setMinionType(3);
                        if (this.field_70146_Z.nextInt(2) == 0) {
                            this.setMinionType(4);
                        }
                    }
                }
            }
        }

        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111121_a(new AttributeModifier("Random spawn bonus", this.field_70146_Z.nextGaussian(), 1));
        return p_110161_1_;
    }

    public void func_70636_d() {
        if (this.getMinionTypeInt() == 1) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)40.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)4.0F);
            this.field_70728_aV = 15;
        } else if (this.getMinionTypeInt() == 2) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)180.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)10.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.5F);
            this.field_70728_aV = 100;
        } else if (this.getMinionTypeInt() == 3) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)400.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)15.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.375F);
            this.field_70178_ae = true;
            this.field_70728_aV = 200;
        } else if (this.getMinionTypeInt() == 4) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)1800.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)30.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
            this.field_70178_ae = true;
            this.field_70728_aV = 1000;
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)26.0F);
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)3.0F);
            this.field_70728_aV = 7;
        }

        if (this.func_70089_S() || this.getMinionTypeInt() != 4) {
            super.func_70636_d();
        }

        if (this.getMinionTypeInt() == 3) {
            if (this.field_70146_Z.nextInt(120) == 0 && this.master == null && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntityZombieMinion entitychicken = new EntityZombieMinion(this.field_70170_p);
                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(0);
                entitychicken.func_82227_f(this.func_70631_g_());
                entitychicken.func_82229_g(this.func_82231_m());
                this.field_70170_p.func_72838_d(entitychicken);
            }

            if (this.field_70146_Z.nextInt(240) == 0 && this.master == null && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                EntityZombieMinion entitychicken = new EntityZombieMinion(this.field_70170_p);
                entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                entitychicken.func_110161_a((IEntityLivingData)null);
                entitychicken.setMinionType(1);
                entitychicken.func_82227_f(this.func_70631_g_());
                entitychicken.func_82229_g(this.func_82231_m());
                this.field_70170_p.func_72838_d(entitychicken);
            }
        }

        if (this.getMinionTypeInt() == 4) {
            if (this.field_70173_aa % 40 == 0) {
                this.func_70691_i(1.0F);
            }

            if (this.field_70170_p.field_73012_v.nextInt(150) == 1) {
                this.func_70691_i(2.0F);
            }

            if (this.field_70170_p.field_73012_v.nextInt(100) == 1 && (double)this.func_110143_aJ() < (double)this.func_110138_aP() * (double)0.75F) {
                this.func_70691_i(2.0F);
            }

            if (this.field_70170_p.field_73012_v.nextInt(35) == 1 && (double)this.func_110143_aJ() < (double)this.func_110138_aP() * (double)0.5F) {
                this.func_70691_i(5.0F);
            }

            if (this.field_70170_p.field_73012_v.nextInt(30) == 1 && (double)this.func_110143_aJ() < (double)this.func_110138_aP() * (double)0.25F) {
                this.func_70691_i(5.0F);
            }

            if (this.field_70170_p.field_73012_v.nextInt(30) == 1 && (double)this.func_110143_aJ() < (double)this.func_110138_aP() * 0.05) {
                this.func_70691_i(200.0F);
            }

            if (!this.field_70122_E && this.field_70181_x < (double)0.0F) {
                this.field_70181_x *= 0.6;
            }

            if (this.master == null && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
                if (this.field_70146_Z.nextInt(60) == 0) {
                    EntityZombieMinion entitychicken = new EntityZombieMinion(this.field_70170_p);
                    entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(0);
                    entitychicken.func_82227_f(this.func_70631_g_());
                    entitychicken.func_82229_g(this.func_82231_m());
                    this.field_70170_p.func_72838_d(entitychicken);
                }

                if (this.field_70146_Z.nextInt(120) == 0) {
                    EntityZombieMinion entitychicken = new EntityZombieMinion(this.field_70170_p);
                    entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(1);
                    entitychicken.func_82227_f(this.func_70631_g_());
                    entitychicken.func_82229_g(this.func_82231_m());
                    this.field_70170_p.func_72838_d(entitychicken);
                }

                if (this.field_70146_Z.nextInt(240) == 0) {
                    EntityZombieMinion entitychicken = new EntityZombieMinion(this.field_70170_p);
                    entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    entitychicken.func_110161_a((IEntityLivingData)null);
                    entitychicken.setMinionType(2);
                    entitychicken.func_82227_f(this.func_70631_g_());
                    entitychicken.func_82229_g(this.func_82231_m());
                    this.field_70170_p.func_72838_d(entitychicken);
                }
            }

            if (this.field_70170_p.field_72995_K && !this.field_70122_E) {
                for(int i = 0; i < 3; ++i) {
                    this.field_70170_p.func_72869_a("explode", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                }
            }

            if (this.field_70146_Z.nextInt(60) == 0 && this.func_70638_az() != null) {
                this.setCombatTask();
                if (!this.field_70122_E) {
                    this.attackPattern = 0;
                } else {
                    this.attackPattern = 1;
                }
            }

            --this.heightOffsetUpdateTime;
            if (this.heightOffsetUpdateTime <= 0) {
                this.func_70664_aZ();
                this.heightOffsetUpdateTime = 100;
                this.heightOffset = 0.5F + (float)this.field_70146_Z.nextGaussian() * 3.0F;
                this.attackPattern = 0;
            }

            EntityLivingBase entitylivingbase = this.func_70638_az();
            if (this.attackPattern == 0 && entitylivingbase != null && !this.field_70170_p.field_72995_K) {
                if (entitylivingbase.field_70163_u + (double)entitylivingbase.func_70047_e() > this.field_70163_u + (double)this.func_70047_e() + (double)this.heightOffset) {
                    this.field_70181_x += 0.4 - this.field_70181_x;
                    this.field_70160_al = true;
                }

                this.func_70671_ap().func_75651_a(entitylivingbase, 180.0F, 40.0F);
                double d0 = entitylivingbase.field_70165_t - this.field_70165_t;
                double d1 = entitylivingbase.field_70161_v - this.field_70161_v;
                double d3 = d0 * d0 + d1 * d1;
                if (d3 > (double)(entitylivingbase.field_70130_N * entitylivingbase.field_70130_N + this.field_70130_N * this.field_70130_N) + (double)16.0F) {
                    double d5 = (double)MathHelper.func_76133_a(d3);
                    this.field_70159_w += d0 / d5 * 0.6 - this.field_70159_w;
                    this.field_70179_y += d1 / d5 * 0.6 - this.field_70179_y;
                }
            }

            if (this.func_70089_S() && !this.field_70170_p.field_72995_K && this.field_70146_Z.nextInt(1000) == 0 && this.func_70638_az() != null && this.func_110143_aJ() < this.func_110138_aP() / 2.0F && this.master == null) {
                for(int i = 0; i < 16; ++i) {
                    this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                    this.field_70170_p.func_72869_a("flame", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                }

                this.func_85030_a("thetitans:titanland", 10000.0F, 1.0F);
                this.TransformEntity(this);
            }

            if (this.field_70122_E) {
                this.field_70160_al = false;
            }

            List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)8.0F, (double)8.0F, (double)8.0F));
            if (!this.field_70170_p.field_72995_K && list11 != null && !list11.isEmpty() && (this.field_70173_aa + this.func_145782_y()) % (this.func_110143_aJ() < this.func_110138_aP() / 2.0F ? 40 : 160) == 0) {
                this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 8.0F, false);

                for(int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity = (Entity)list11.get(i1);
                    if (entity != null && entity instanceof EntityLivingBase && this.func_70686_a(entity.getClass())) {
                        entity.field_70181_x += this.field_70146_Z.nextDouble();
                        ((EntityLivingBase)entity).func_70690_d(new PotionEffect(ClientProxy.electricJudgment.field_76415_H, 10, 1));
                        this.field_70170_p.func_72889_a((EntityPlayer)null, 1017, (int)entity.field_70165_t, (int)entity.field_70163_u, (int)entity.field_70161_v, 0);
                    }
                }
            }
        }

        if (this.getMinionTypeInt() == 2 && this.func_70638_az() != null) {
            double d0 = this.func_70068_e(this.func_70638_az());
            if (d0 < 0.8) {
                this.func_70652_k(this.func_70638_az());
            }

            if (this.field_70146_Z.nextInt(40) == 0 && this.field_70122_E && d0 < (double)256.0F && this.func_70638_az().field_70163_u > this.field_70163_u + (double)3.0F) {
                this.func_70690_d(new PotionEffect(Potion.field_76430_j.field_76415_H, 60, 7));
                this.func_70625_a(this.func_70638_az(), 180.0F, 180.0F);
                double d01 = this.func_70638_az().field_70165_t - this.field_70165_t;
                double d1 = this.func_70638_az().field_70161_v - this.field_70161_v;
                float f2 = MathHelper.func_76133_a(d01 * d01 + d1 * d1);
                this.func_70664_aZ();
                this.field_70159_w = d01 / (double)f2 * (double)0.75F * (double)0.75F + this.field_70159_w * (double)0.75F;
                this.field_70179_y = d1 / (double)f2 * (double)0.75F * (double)0.75F + this.field_70179_y * (double)0.75F;
            }
        }

        if (this.getMinionTypeInt() == 1 && this.field_70173_aa % 40 == 0 && this.entityToHeal != null) {
            if (this.entityToHeal.func_110143_aJ() < this.entityToHeal.func_110138_aP()) {
                this.func_71038_i();
                this.func_70625_a(this.entityToHeal, 180.0F, (float)this.func_70646_bf());
                this.entityToHeal.func_70691_i(4.0F);
                this.func_85030_a("mob.wither.shoot", 1.0F, 3.0F);
            } else {
                this.entityToHeal = null;
            }
        }

        if (this.func_70638_az() != null && !this.func_70638_az().func_70089_S()) {
            this.func_70624_b((EntityLivingBase)null);
        }

        if (this.master != null) {
            if (this.master.func_70638_az() != null && this.master instanceof EntityZombieTitan && ((EntityZombieTitan)this.master).animID == 11 && ((EntityZombieTitan)this.master).animTick > 80) {
                this.func_70605_aq().func_75642_a(this.master.func_70638_az().field_70165_t, this.master.func_70638_az().field_70163_u, this.master.func_70638_az().field_70161_v, (double)10.0F);
            }

            if (this.master.func_70638_az() != null) {
                if (this.master.func_70638_az().field_70131_O < 6.0F) {
                    this.func_70624_b(this.master.func_70638_az());
                } else {
                    this.func_70671_ap().func_75651_a(this.master.func_70638_az(), 10.0F, 40.0F);
                }
            }

            if (this.field_70173_aa % 10 == 0 && this.master.func_70638_az() != null && this.master.func_70638_az() instanceof EntityVillager) {
                if (this.func_70068_e(this.master.func_70638_az()) > (double)256.0F) {
                    this.func_70605_aq().func_75642_a(this.master.func_70638_az().field_70165_t, this.master.func_70638_az().field_70163_u, this.master.func_70638_az().field_70161_v, (double)1.0F);
                } else {
                    this.func_70661_as().func_75497_a(this.master.func_70638_az(), (double)1.0F);
                }
            } else if (this.func_70068_e(this.master) > (double)2304.0F) {
                this.func_70605_aq().func_75642_a(this.master.field_70165_t, this.master.field_70163_u, this.master.field_70161_v, (double)2.0F);
            }
        } else {
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)100.0F, (double)100.0F, (double)100.0F));
            if (list != null && !list.isEmpty()) {
                for(int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity != null && entity instanceof EntityZombieTitan) {
                        this.master = (EntityZombieTitan)entity;
                    }
                }
            }
        }

    }

    protected void func_70619_bc() {
        if (this.func_70027_ad() && this.field_70170_p.func_147437_c((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) && this.field_70146_Z.nextInt(30) == 0) {
            this.field_70170_p.func_147449_b((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, Blocks.field_150480_ab);
        }

        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
            this.func_85030_a(this.func_70621_aR(), this.func_70599_aP(), this.func_70647_i() + 0.25F);
        }

        if (this.func_70638_az() != null && this.field_70170_p.field_73012_v.nextInt(5) == 1) {
            EntityLivingBase e = this.func_70638_az();
            if (e != null && this.func_70068_e(e) < (double)(this.field_70130_N * this.field_70130_N + e.field_70130_N * e.field_70130_N) + (double)16.0F && (this.field_70170_p.field_73012_v.nextInt(3) == 0 || this.field_70170_p.field_73012_v.nextInt(2) == 1)) {
                this.func_70652_k(e);
            }
        }

        if (this.field_70123_F && this.master != null) {
            this.field_70181_x = 0.2;
        }

        super.func_70619_bc();
    }

    public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
        if (this.deathTicks > 0) {
            super.func_70091_d((double)0.0F, (double)0.1F, (double)0.0F);
        } else {
            super.func_70091_d(p_70091_1_, p_70091_3_, p_70091_5_);
        }

    }

    protected void func_70609_aI() {
        if (this.getMinionTypeInt() == 4) {
            --this.field_70173_aa;
            ++this.deathTicks;
            if (this.master != null) {
                double mx = this.field_70165_t - this.master.field_70165_t;
                double my = this.field_70163_u + (double)this.func_70047_e() - (this.master.field_70163_u + (double)this.master.func_70047_e());
                double mz = this.field_70161_v - this.master.field_70161_v;
                short short1 = (short)((int)(this.func_70032_d(this.master) * 2.0F));

                for(int f = 0; f < short1; ++f) {
                    double d9 = (double)f / ((double)short1 - (double)1.0F);
                    double d6 = this.field_70165_t + mx * -d9;
                    double d7 = this.field_70163_u + (double)this.func_70047_e() + my * -d9;
                    double d8 = this.field_70161_v + mz * -d9;
                    this.field_70170_p.func_72869_a("fireworksSpark", d6, d7, d8, this.master.field_70159_w, this.master.field_70181_x + 0.2, this.master.field_70179_y);
                }
            }

            if (!this.field_70170_p.field_72995_K) {
                if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
                    this.func_70628_a(true, 0);
                }

                if (this.deathTicks == 1) {
                    this.field_70170_p.func_82739_e(1018, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                }
            }

            if (this.deathTicks >= 180 && this.deathTicks <= 200) {
                float f = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70130_N;
                float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70131_O;
                float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70130_N;
                this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + (double)this.func_70047_e() + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
            }

            this.func_70091_d((double)0.0F, (double)0.1F, (double)0.0F);
            float f = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70130_N;
            float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70131_O;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70130_N;
            this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t + (double)f, this.field_70163_u + (double)this.func_70047_e() + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
            this.field_70170_p.func_72869_a("lava", this.field_70165_t + (double)f, this.field_70163_u + (double)this.func_70047_e() + (double)f1, this.field_70161_v + (double)f2, this.field_70146_Z.nextGaussian(), this.field_70146_Z.nextGaussian(), this.field_70146_Z.nextGaussian());
            if (this.deathTicks == 200 && !this.field_70170_p.field_72995_K) {
                if (this.master != null) {
                    this.master.func_70691_i(this.master.func_110138_aP() / 100.0F);

                    for(int i = 0; i < 100; ++i) {
                        double d2 = this.field_70146_Z.nextGaussian() * 0.02;
                        double d0 = this.field_70146_Z.nextGaussian() * 0.02;
                        double d1 = this.field_70146_Z.nextGaussian() * 0.02;
                        this.field_70170_p.func_72869_a("largeexplode", this.master.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.master.field_70130_N * 2.0F) - (double)this.master.field_70130_N, this.master.field_70163_u + (double)(this.field_70146_Z.nextFloat() * this.master.field_70131_O), this.master.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.master.field_70130_N * 2.0F) - (double)this.master.field_70130_N, d2, d0, d1);
                    }
                }

                int i = this.field_70728_aV;

                while(i > 0) {
                    int j = EntityXPOrb.func_70527_a(i);
                    i -= j;
                    this.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, j));
                }

                this.func_70106_y();
            }
        } else {
            super.func_70609_aI();
        }

    }

    public void func_70074_a(EntityLivingBase p_70074_1_) {
        if (p_70074_1_ instanceof EntityVillager) {
            EntityZombieMinion entityzombie = new EntityZombieMinion(this.field_70170_p);
            entityzombie.func_82149_j(p_70074_1_);
            this.field_70170_p.func_72900_e(p_70074_1_);
            entityzombie.func_110161_a((IEntityLivingData)null);
            entityzombie.setMinionType(this.getMinionTypeInt());
            entityzombie.func_82229_g(true);
            if (p_70074_1_.func_70631_g_()) {
                entityzombie.func_82227_f(true);
            }

            this.field_70170_p.func_72838_d(entityzombie);
            this.field_70170_p.func_72889_a((EntityPlayer)null, 1016, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
        }

    }

    public void TransformEntity(Entity entity) {
        entity.field_70170_p.func_72885_a(entity, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 18.0F, true, entity.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
        EntityZombieTitan entitytitan = new EntityZombieTitan(entity.field_70170_p);
        entitytitan.func_70012_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, entity.field_70177_z, 0.0F);
        entitytitan.func_110161_a((IEntityLivingData)null);
        entity.func_70106_y();
        entitytitan.func_82206_m();
        entity.field_70170_p.func_72838_d(entitytitan);
        if (this.func_70631_g_()) {
            entitytitan.setChild(true);
        }

        if (this.func_82231_m()) {
            entitytitan.setVillager(true);
        }

    }

    public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.func_71038_i();
        if (this.func_70068_e(p_82196_1_) < (double)(p_82196_1_.field_70130_N * p_82196_1_.field_70130_N) + (double)36.0F) {
            this.func_70652_k(p_82196_1_);
        } else {
            switch (this.field_70146_Z.nextInt(4)) {
                case 0:
                    EntityArrow entityarrow = new EntityArrow(this.field_70170_p, this, p_82196_1_, 1.6F, 1.0F);
                    entityarrow.func_70243_d(true);
                    entityarrow.func_70239_b((double)(p_82196_2_ * 2.0F) + this.field_70146_Z.nextGaussian() * (double)0.25F + (double)((float)this.field_70170_p.field_73013_u.func_151525_a() * 0.11F));
                    this.func_85030_a("random.bow", 1.0F, 1.0F / (this.func_70681_au().nextFloat() * 0.4F + 0.8F));
                    this.field_70170_p.func_72838_d(entityarrow);
                    break;
                case 1:
                    EntityPotion entitypotion = new EntityPotion(this.field_70170_p, this, 32732);
                    if (p_82196_1_.func_70662_br()) {
                        entitypotion.func_82340_a(32725);
                    }

                    double d0 = p_82196_1_.field_70163_u + (double)0.5F;
                    entitypotion.field_70125_A -= -20.0F;
                    double d1 = p_82196_1_.field_70165_t + p_82196_1_.field_70159_w - this.field_70165_t;
                    double d2 = d0 - this.field_70163_u;
                    double d3 = p_82196_1_.field_70161_v + p_82196_1_.field_70179_y - this.field_70161_v;
                    float f1 = MathHelper.func_76133_a(d1 * d1 + d3 * d3);
                    entitypotion.func_70186_c(d1, d2 + (double)(f1 * 0.2F), d3, 1.6F, f1 / 20.0F);
                    this.field_70170_p.func_72838_d(entitypotion);
                    break;
                case 2:
                    double d011 = this.func_70068_e(p_82196_1_);
                    double d111 = p_82196_1_.field_70165_t - this.field_70165_t;
                    double d211 = p_82196_1_.field_70121_D.field_72338_b + (double)(p_82196_1_.field_70131_O / 2.0F) - (this.field_70163_u + (double)(p_82196_1_.field_70131_O / 2.0F));
                    double d311 = p_82196_1_.field_70161_v - this.field_70161_v;
                    float f = MathHelper.func_76129_c(MathHelper.func_76133_a(d011)) * 0.1F;
                    this.field_70170_p.func_72889_a((EntityPlayer)null, 1009, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                    EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.field_70170_p, this, d111 + this.func_70681_au().nextGaussian() * (double)f, d211, d311 + this.func_70681_au().nextGaussian() * (double)f);
                    entitysmallfireball.field_70163_u = this.field_70163_u + 1.6;
                    this.field_70170_p.func_72838_d(entitysmallfireball);
                    break;
                case 3:
                    this.func_85030_a("mob.zombie.hurt", 1.0F, 0.5F);
                    this.func_85030_a("mob.zombie.hurt", 1.0F, 0.5F);
                    this.func_85030_a("mob.zombie.hurt", 1.0F, 0.5F);
                    this.func_85030_a("mob.zombie.hurt", 1.0F, 0.5F);
                    this.field_70170_p.func_72908_a(p_82196_1_.field_70165_t, p_82196_1_.field_70163_u, p_82196_1_.field_70161_v, "random.explode", 4.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 0.7F);

                    for(int i = 0; i < 256; ++i) {
                        EntityItem entityitem = p_82196_1_.func_145779_a(Items.field_151078_bh, 1);
                        entityitem.field_145804_b = 6000;
                        entityitem.lifespan = 40 + this.field_70146_Z.nextInt(20);
                    }

                    p_82196_1_.func_70690_d(new PotionEffect(Potion.field_76438_s.field_76415_H, 100, 2));
                    p_82196_1_.func_70097_a(DamageSource.field_76366_f, 5.0F);
                    p_82196_1_.field_70172_ad = 0;
            }
        }

    }

    class GroupData implements IEntityLivingData {
        public boolean field_142048_a;
        public boolean field_142046_b;

        private GroupData(boolean p_i2348_2_, boolean p_i2348_3_) {
            this.field_142048_a = false;
            this.field_142046_b = false;
            this.field_142048_a = p_i2348_2_;
            this.field_142046_b = p_i2348_3_;
        }

        GroupData(boolean p_i2349_2_, boolean p_i2349_3_, Object p_i2349_4_) {
            this(p_i2349_2_, p_i2349_3_);
        }
    }

    public class EntityAIFindEntityNearestInjuredAlly extends EntityAIBase {
        private EntityZombieMinion field_179434_b;
        private EntityLivingBase field_179433_e;

        public EntityAIFindEntityNearestInjuredAlly(EntityZombieMinion entityCaveSpiderPriest) {
            this.field_179434_b = entityCaveSpiderPriest;
        }

        public boolean func_75250_a() {
            if (!this.field_179434_b.func_70089_S()) {
                return false;
            } else if (this.field_179434_b.getMinionType() != EnumMinionType.PRIEST) {
                return false;
            } else if (this.field_179433_e != null) {
                return false;
            } else {
                double d0 = this.func_179431_f();
                List list = this.field_179434_b.field_70170_p.func_72872_a(EntityZombieMinion.class, this.field_179434_b.field_70121_D.func_72314_b(d0, d0, d0));
                if (list.isEmpty()) {
                    return false;
                } else {
                    for(int i = 0; i < list.size(); ++i) {
                        EntityZombieMinion entity = (EntityZombieMinion)list.get(i);
                        if (entity.func_110143_aJ() < entity.func_110138_aP() && entity.func_70089_S()) {
                            this.field_179433_e = entity;
                        }
                    }

                    return true;
                }
            }
        }

        public boolean func_75253_b() {
            EntityLivingBase entitylivingbase = this.field_179434_b.entityToHeal;
            if (entitylivingbase == null) {
                return false;
            } else if (!entitylivingbase.func_70089_S()) {
                this.field_179433_e = null;
                return false;
            } else if (entitylivingbase.func_110143_aJ() >= entitylivingbase.func_110138_aP()) {
                this.field_179433_e = null;
                return false;
            } else {
                double d0 = this.func_179431_f();
                return this.field_179434_b.func_70068_e(entitylivingbase) <= d0 * d0;
            }
        }

        public void func_75249_e() {
            this.field_179434_b.entityToHeal = (EntityLiving)this.field_179433_e;
            super.func_75249_e();
        }

        public void func_75251_c() {
            this.field_179434_b.entityToHeal = null;
            this.field_179433_e = null;
            super.func_75251_c();
        }

        public void func_75246_d() {
            if (this.field_179434_b.entityToHeal != null && (double)this.field_179434_b.func_70032_d(this.field_179434_b.entityToHeal) > (double)16.0F) {
                this.field_179434_b.func_70661_as().func_75497_a(this.field_179434_b.entityToHeal, (double)1.0F);
                this.field_179434_b.func_70671_ap().func_75651_a(this.field_179434_b.entityToHeal, 10.0F, (float)this.field_179434_b.func_70646_bf());
            }

        }

        protected double func_179431_f() {
            return (double)32.0F;
        }
    }
}
