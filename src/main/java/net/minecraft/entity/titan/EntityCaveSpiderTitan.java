//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titanminion.EntityCaveSpiderMinion;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;

public class EntityCaveSpiderTitan extends EntitySpiderTitan {
    public boolean isSubdued;

    public EntityCaveSpiderTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 5.6F, 5.6F);
        this.thorax = new EntityTitanPart(worldIn, this, "thorax", 4.2F, 4.2F);
        this.abdomen = new EntityTitanPart(worldIn, this, "abdomen", 8.4F, 5.6F);
        this.rightlegs = new EntityTitanPart(worldIn, this, "rightleg", 8.4F, 5.6F);
        this.leftlegs = new EntityTitanPart(worldIn, this, "leftleg", 8.4F, 5.6F);
        this.partArray = new EntityTitanPart[]{this.head, this.thorax, this.abdomen, this.rightlegs, this.leftlegs};
        this.func_70105_a(16.0F, 10.0F);
        this.field_70728_aV = 9000 + this.getExtraPower() * 350;
        worldIn.func_72838_d(this.head);
        worldIn.func_72838_d(this.thorax);
        worldIn.func_72838_d(this.abdomen);
        worldIn.func_72838_d(this.rightlegs);
        worldIn.func_72838_d(this.leftlegs);
    }

    protected void applyEntityAI() {
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.CaveSpiderTitanSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

    }

    public void func_70043_V() {
        if (this.field_70153_n != null) {
            this.field_70153_n.func_70107_b(this.field_70165_t, this.field_70163_u + 8.8 + (double)this.getExtraPower() * 0.1, this.field_70161_v);
        }

    }

    public int getMinionCap() {
        return 180;
    }

    public int getPriestCap() {
        return 80;
    }

    public int getZealotCap() {
        return 20;
    }

    public int getTemplarCap() {
        return 4;
    }

    protected boolean func_70610_aX() {
        return this.isSubdued && this.field_70153_n == null ? true : super.func_70610_aX();
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        this.isSubdued = tagCompund.func_74767_n("Subdued");
    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        tagCompound.func_74757_a("Subdued", this.isSubdued);
    }

    public boolean func_70067_L() {
        return this.isStunned || this.isSubdued;
    }

    public boolean shouldMove() {
        return this.animID == 0 && !this.isStunned && this.func_70638_az() != null ? super.shouldMove() : false;
    }

    public double getSpeed() {
        return (this.getBonusID() == 1 ? 0.65 : 0.6) + (double)this.getExtraPower() * 0.001;
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != this.head.getClass() && p_70686_1_ != this.thorax.getClass() && p_70686_1_ != this.abdomen.getClass() && p_70686_1_ != this.rightlegs.getClass() && p_70686_1_ != this.leftlegs.getClass() && p_70686_1_ != EntityWebShot.class && p_70686_1_ != EntityCaveSpiderMinion.class && p_70686_1_ != EntityCaveSpiderTitan.class;
    }

    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(50) == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.isValidLightLevel();
    }

    public int getMinionSpawnRate() {
        return TheTitans.CaveSpiderTitanMinionSpawnrate;
    }

    public void attackChoosenEntity(Entity damagedEntity, float damage, int knockbackAmount) {
        super.attackChoosenEntity(damagedEntity, damage, knockbackAmount);
        if (damagedEntity instanceof EntityLivingBase) {
            ((EntityLivingBase)damagedEntity).func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, 800, 3));
        }

    }

    public float func_70047_e() {
        return 7.28F;
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
                if (itemstack.func_77973_b() == Items.field_151077_bg) {
                    AnimationAPI.sendAnimPacket(this, 3);
                    this.setAnimID(3);
                }

                if (itemstack.func_77973_b() == Items.field_151103_aS) {
                    AnimationAPI.sendAnimPacket(this, 9);
                    this.setAnimID(9);
                }
            }
        }

        return false;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        return this.func_85032_ar() ? false : super.func_70097_a(source, amount);
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
            double d1 = this.field_70165_t - this.field_70169_q;
            double d0 = this.field_70161_v - this.field_70166_s;
            float f4 = MathHelper.func_76133_a(d1 * d1 + d0 * d0) * 4.0F;
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
