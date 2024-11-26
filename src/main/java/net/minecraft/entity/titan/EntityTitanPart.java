//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityTitanPart extends Entity {
    public IEntityMultiPartTitan entityDragonObj;
    public String field_146032_b;
    public int numberOfTimesHit;

    public EntityTitanPart(World p_i1698_1_) {
        super(p_i1698_1_);
        this.field_70156_m = true;
    }

    public EntityTitanPart(World p_i1698_1_, IEntityMultiPartTitan p_i1697_1_, String p_i1697_2_, float p_i1697_3_, float p_i1697_4_) {
        this(p_i1698_1_);
        this.func_70105_a(p_i1697_3_, p_i1697_4_);
        this.entityDragonObj = p_i1697_1_;
        this.field_146032_b = p_i1697_2_;
        if (p_i1697_1_ instanceof Entity) {
            this.func_70107_b(((Entity)p_i1697_1_).field_70165_t, ((Entity)p_i1697_1_).field_70163_u, ((Entity)p_i1697_1_).field_70161_v);
        }

    }

    protected boolean func_70041_e_() {
        return false;
    }

    public float getRenderSizeModifier() {
        return this.field_70130_N;
    }

    @SideOnly(Side.CLIENT)
    public float func_70053_R() {
        return this.entityDragonObj != null && this.entityDragonObj instanceof EntityLivingBase && this.field_70163_u > ((EntityLivingBase)this.entityDragonObj).field_70163_u ? (float)(((EntityLivingBase)this.entityDragonObj).field_70163_u - this.field_70163_u) : 0.0F;
    }

    public boolean func_70027_ad() {
        return this.entityDragonObj != null && this.entityDragonObj instanceof EntityLivingBase ? ((EntityLivingBase)this.entityDragonObj).func_70027_ad() : false;
    }

    protected void func_70088_a() {
    }

    protected void func_70037_a(NBTTagCompound p_70037_1_) {
    }

    protected void func_70014_b(NBTTagCompound p_70014_1_) {
    }

    public boolean func_70067_L() {
        return this.entityDragonObj != null;
    }

    public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
        return this.func_85032_ar() ? false : (this.entityDragonObj != null ? this.entityDragonObj.attackEntityFromPart(this, p_70097_1_, p_70097_2_) : false);
    }

    public AxisAlignedBB func_70114_g(Entity entityIn) {
        return this.field_70121_D;
    }

    public AxisAlignedBB func_70046_E() {
        return this.field_70121_D;
    }

    public void func_70012_b(double p_70012_1_, double p_70012_3_, double p_70012_5_, float p_70012_7_, float p_70012_8_) {
        if (this.entityDragonObj != null && this.entityDragonObj instanceof EntityLivingBase) {
            p_70012_1_ += ((EntityLivingBase)this.entityDragonObj).field_70159_w;
            p_70012_5_ += ((EntityLivingBase)this.entityDragonObj).field_70179_y;
        }

        super.func_70012_b(p_70012_1_, p_70012_3_, p_70012_5_, p_70012_7_, p_70012_8_);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.entityDragonObj != null && this.entityDragonObj instanceof EntityLivingBase) {
            this.field_70177_z = ((EntityLivingBase)this.entityDragonObj).field_70761_aq;
            this.func_82142_c(((EntityLivingBase)this.entityDragonObj).func_82150_aj());
            this.field_70159_w = ((EntityLivingBase)this.entityDragonObj).field_70159_w;
            this.field_70181_x = ((EntityLivingBase)this.entityDragonObj).field_70181_x;
            this.field_70179_y = ((EntityLivingBase)this.entityDragonObj).field_70179_y;
        }

        if (this.entityDragonObj == null || this.field_70170_p == null || this.entityDragonObj != null && this.entityDragonObj instanceof EntityLivingBase && !((EntityLiving)this.entityDragonObj).func_70089_S()) {
            for(int i = 0; i < 50; ++i) {
                this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                this.field_70170_p.func_72869_a("explode", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
            }

            this.func_70106_y();
        }

    }
}
