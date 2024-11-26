//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityGammaLightning extends EntityLightningBolt {
    private int lightningState;
    public long field_70264_a;
    private int boltLivingTime;

    public EntityGammaLightning(World p_i1703_1_, float red, float green, float blue) {
        super(p_i1703_1_, (double)red, (double)green, (double)blue);
        this.func_70105_a(3.0F, 3.0F);
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
        this.lightningState = 2;
        this.field_70264_a = this.field_70146_Z.nextLong();
        this.boltLivingTime = this.field_70146_Z.nextInt(3) + 1;
    }

    public EntityGammaLightning(World p_i1703_1_, double p_i1703_2_, double p_i1703_4_, double p_i1703_6_, float red, float green, float blue) {
        this(p_i1703_1_, red, green, blue);
        this.func_70107_b(p_i1703_2_, p_i1703_4_, p_i1703_6_);
    }

    public void func_70071_h_() {
        if (this.lightningState == 2) {
            float volume = 0.5F + this.field_70146_Z.nextFloat();
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "ambient.weather.thunder", 10000.0F, volume);
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "ambient.weather.thunder", 10000.0F, volume + 0.1F);
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "ambient.weather.thunder", 10000.0F, volume + 0.2F);
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "ambient.weather.thunder", 10000.0F, volume + 0.3F);
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "random.explode", 10.0F, 0.7F);
        }

        --this.lightningState;
        if (this.lightningState < 0) {
            if (this.boltLivingTime == 0) {
                if (!this.field_70170_p.field_72995_K && this.field_70170_p.func_82736_K().func_82766_b("doFireTick") && this.field_70170_p.func_72873_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v), 10)) {
                    int i = MathHelper.func_76128_c(this.field_70165_t);
                    int j = MathHelper.func_76128_c(this.field_70163_u);
                    int k = MathHelper.func_76128_c(this.field_70161_v);
                    if (this.field_70170_p.func_147439_a(i, j, k).func_149688_o() == Material.field_151579_a && Blocks.field_150480_ab.func_149742_c(this.field_70170_p, i, j, k)) {
                        this.field_70170_p.func_147449_b(i, j, k, Blocks.field_150480_ab);
                    }

                    for(int var7 = 0; var7 < 16; ++var7) {
                        j = MathHelper.func_76128_c(this.field_70165_t) + this.field_70146_Z.nextInt(6) - 3;
                        k = MathHelper.func_76128_c(this.field_70163_u) + this.field_70146_Z.nextInt(6) - 3;
                        int l = MathHelper.func_76128_c(this.field_70161_v) + this.field_70146_Z.nextInt(6) - 3;
                        if (this.field_70170_p.func_147439_a(j, k, l).func_149688_o() == Material.field_151579_a && Blocks.field_150480_ab.func_149742_c(this.field_70170_p, j, k, l)) {
                            this.field_70170_p.func_147449_b(j, k, l, Blocks.field_150480_ab);
                        }
                    }
                }

                this.func_70106_y();
            } else if (this.lightningState < -this.field_70146_Z.nextInt(10)) {
                --this.boltLivingTime;
                this.lightningState = 1;
                this.field_70264_a = this.field_70146_Z.nextLong();
                if (!this.field_70170_p.field_72995_K && this.field_70170_p.func_82736_K().func_82766_b("doFireTick") && this.field_70170_p.func_72873_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v), 10)) {
                    int i = MathHelper.func_76128_c(this.field_70165_t);
                    int j = MathHelper.func_76128_c(this.field_70163_u);
                    int k = MathHelper.func_76128_c(this.field_70161_v);
                    if (this.field_70170_p.func_147439_a(i, j, k).func_149688_o() == Material.field_151579_a && Blocks.field_150480_ab.func_149742_c(this.field_70170_p, i, j, k)) {
                        this.field_70170_p.func_147449_b(i, j, k, Blocks.field_150480_ab);
                    }
                }
            }
        }

        if (this.lightningState >= 0) {
            this.field_70170_p.field_73016_r = 2;
            double d0 = (double)10.0F;
            List list = this.field_70170_p.func_72839_b(this, AxisAlignedBB.func_72330_a(this.field_70165_t - d0, this.field_70163_u - d0, this.field_70161_v - d0, this.field_70165_t + d0, this.field_70163_u + d0, this.field_70161_v + d0));

            for(int l = 0; l < list.size(); ++l) {
                Entity entity = (Entity)list.get(l);
                if (entity != null && !(entity instanceof EntityTitanPart) && !(entity instanceof EntityTitan) && !entity.func_70045_F()) {
                    entity.func_70077_a((EntityLightningBolt)null);
                    entity.func_70015_d(100);
                    entity.func_70097_a(DamageSourceExtra.lightningBolt, 49.0F);
                    entity.field_70172_ad = 0;
                }
            }
        }

        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.func_70030_z();
    }

    @SideOnly(Side.CLIENT)
    public boolean func_70112_a(double p_70112_1_) {
        return true;
    }

    protected void func_70088_a() {
        this.field_70180_af.func_75682_a(15, 1.0F);
        this.field_70180_af.func_75682_a(16, 1.0F);
        this.field_70180_af.func_75682_a(17, 1.0F);
    }

    public final float getRed() {
        return this.field_70180_af.func_111145_d(15);
    }

    public void setRed(float p_70606_1_) {
        this.field_70180_af.func_75692_b(15, MathHelper.func_76131_a(p_70606_1_, 0.0F, 1.0F));
    }

    public final float getGreen() {
        return this.field_70180_af.func_111145_d(16);
    }

    public void setGreen(float p_70606_1_) {
        this.field_70180_af.func_75692_b(16, MathHelper.func_76131_a(p_70606_1_, 0.0F, 1.0F));
    }

    public final float getBlue() {
        return this.field_70180_af.func_111145_d(17);
    }

    public void setBlue(float p_70606_1_) {
        this.field_70180_af.func_75692_b(17, MathHelper.func_76131_a(p_70606_1_, 0.0F, 1.0F));
    }

    protected void func_70037_a(NBTTagCompound p_70037_1_) {
        this.setRed(p_70037_1_.func_74760_g("R"));
        this.setGreen(p_70037_1_.func_74760_g("G"));
        this.setBlue(p_70037_1_.func_74760_g("B"));
    }

    protected void func_70014_b(NBTTagCompound p_70014_1_) {
        p_70014_1_.func_74776_a("R", this.getRed());
        p_70014_1_.func_74776_a("G", this.getGreen());
        p_70014_1_.func_74776_a("B", this.getBlue());
    }
}
