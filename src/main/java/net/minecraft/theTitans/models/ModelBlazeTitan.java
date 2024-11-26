//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityBlazeTitan;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelBlazeTitan extends ModelBase {
    private ModelRenderer[] blazeSticks;
    private ModelRenderer blazeHead;

    public ModelBlazeTitan() {
        this(0.0F);
    }

    public ModelBlazeTitan(float p_i1147_1_) {
        this.blazeSticks = new ModelRenderer[12];

        for(int i = 0; i < this.blazeSticks.length; ++i) {
            this.blazeSticks[i] = new ModelRenderer(this, 0, 16);
            this.blazeSticks[i].func_78790_a(-1.0F, -4.0F, -1.0F, 2, 8, 2, p_i1147_1_);
        }

        this.blazeHead = new ModelRenderer(this, 0, 0);
        this.blazeHead.func_78790_a(-4.0F, -4.0F, -4.0F, 8, 8, 8, p_i1147_1_);
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
        this.func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        this.blazeHead.func_78785_a(p_78088_7_);

        for(int i = 0; i < this.blazeSticks.length; ++i) {
            this.blazeSticks[i].func_78785_a(p_78088_7_);
        }

    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        EntityBlazeTitan entitytitan = (EntityBlazeTitan)p_78087_7_;
        float f6 = p_78087_3_ * (float)Math.PI * -0.008F;

        for(int i = 0; i < 4; ++i) {
            this.blazeSticks[i].field_78797_d = 4.0F + MathHelper.func_76134_b(((float)(i * 2) + p_78087_3_) * 0.03F);
            this.blazeSticks[i].field_78800_c = MathHelper.func_76134_b(f6) * 10.0F;
            this.blazeSticks[i].field_78798_e = MathHelper.func_76126_a(f6) * 10.0F;
            this.blazeSticks[i].field_78796_g = MathHelper.func_76126_a(f6) * 8.0F;
            if (entitytitan.func_70845_n()) {
                this.blazeSticks[i].field_78795_f = MathHelper.func_76134_b(p_78087_3_ * 0.1F) * (float)Math.PI;
                this.blazeSticks[i].field_78808_h = MathHelper.func_76126_a(p_78087_3_ * 0.1F) * (float)Math.PI;
            } else {
                this.blazeSticks[i].field_78795_f = 0.0F;
                this.blazeSticks[i].field_78808_h = 0.0F;
            }

            ++f6;
        }

        f6 = ((float)Math.PI / 4F) + p_78087_3_ * (float)Math.PI * 0.005F;

        for(int var13 = 4; var13 < 8; ++var13) {
            this.blazeSticks[var13].field_78797_d = 10.0F + MathHelper.func_76134_b(((float)(var13 * 3) + p_78087_3_) * 0.05F);
            this.blazeSticks[var13].field_78800_c = MathHelper.func_76134_b(f6) * 7.0F;
            this.blazeSticks[var13].field_78798_e = MathHelper.func_76126_a(f6) * 7.0F;
            this.blazeSticks[var13].field_78796_g = MathHelper.func_76126_a(f6) * 12.0F;
            ++f6;
        }

        f6 = 0.47123894F + p_78087_3_ * (float)Math.PI * -0.003F;

        for(int var14 = 8; var14 < 12; ++var14) {
            this.blazeSticks[var14].field_78797_d = 17.0F + MathHelper.func_76134_b(((float)var14 * 1.5F + p_78087_3_) * 0.02F);
            this.blazeSticks[var14].field_78800_c = MathHelper.func_76134_b(f6) * 4.0F;
            this.blazeSticks[var14].field_78798_e = MathHelper.func_76126_a(f6) * 4.0F;
            this.blazeSticks[var14].field_78796_g = MathHelper.func_76126_a(f6) * 20.0F;
            ++f6;
        }

        this.blazeHead.field_78796_g = p_78087_4_ / (180F / (float)Math.PI);
        this.blazeHead.field_78795_f = p_78087_5_ / (180F / (float)Math.PI);
        this.blazeHead.field_78797_d = 0.0F;
    }
}
