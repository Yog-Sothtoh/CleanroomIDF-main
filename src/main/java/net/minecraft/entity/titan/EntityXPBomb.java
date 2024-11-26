//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityXPBomb extends EntityThrowable {
    public int xpColor;

    public EntityXPBomb(World p_i1773_1_) {
        super(p_i1773_1_);
        this.func_70105_a(3.0F, 3.0F);
        this.field_70177_z = (float)(Math.random() * (double)360.0F);
        this.field_70159_w = (double)((float)(Math.random() * (double)0.2F - (double)0.1F) * 2.0F);
        this.field_70181_x = (double)((float)(Math.random() * 0.2) * 2.0F) + (double)0.5F;
        this.field_70179_y = (double)((float)(Math.random() * (double)0.2F - (double)0.1F) * 2.0F);
    }

    public EntityXPBomb(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        this(p_i1775_1_);
        this.func_70107_b(p_i1775_2_, p_i1775_4_, p_i1775_6_);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, new Integer(0));
    }

    public int getXPCount() {
        return this.field_70180_af.func_75679_c(20);
    }

    public void setXPCount(int p_82215_1_) {
        this.field_70180_af.func_75692_b(20, p_82215_1_);
    }

    public void func_70014_b(NBTTagCompound p_70014_1_) {
        super.func_70014_b(p_70014_1_);
        p_70014_1_.func_74777_a("Value", (short)this.getXPCount());
    }

    public void func_70037_a(NBTTagCompound p_70037_1_) {
        super.func_70037_a(p_70037_1_);
        this.setXPCount(p_70037_1_.func_74765_d("Value"));
    }

    public boolean func_70027_ad() {
        return false;
    }

    protected float func_70185_h() {
        return 0.05F;
    }

    protected void func_70184_a(MovingObjectPosition movingObject) {
        this.func_85030_a("random.explode", 5.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 0.7F);
        this.func_85030_a("random.orb", 5.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 0.7F);
        if (!this.field_70170_p.field_72995_K) {
            for(int i1 = 0; i1 < 20; ++i1) {
                int i = this.getXPCount() / 20;
                EntityXPOrb orb = new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)0.5F, this.field_70161_v, i);
                orb.field_70181_x += (double)0.5F;
                orb.field_70530_e = i;
                this.field_70170_p.func_72838_d(orb);
            }

            this.func_70106_y();
        }

    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public int func_70070_b(float p_70070_1_) {
        float f1 = 0.5F;
        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        if (f1 > 1.0F) {
            f1 = 1.0F;
        }

        int i = super.func_70070_b(p_70070_1_);
        int j = i & 255;
        int k = i >> 16 & 255;
        j += (int)(f1 * 15.0F * 16.0F);
        if (j > 240) {
            j = 240;
        }

        return j | k << 16;
    }

    public void func_70106_y() {
        super.func_70106_y();
        this.field_70170_p.func_72869_a(this.getXPCount() >= 2000 ? "hugeexplosion" : "largeexplode", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + (double)3.0F + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        ++this.xpColor;
        if (this.getXPCount() <= 100) {
            this.setXPCount(100);
        }

    }
}
