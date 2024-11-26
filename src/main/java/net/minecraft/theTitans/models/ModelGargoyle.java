//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityGargoyle;
import net.minecraft.util.MathHelper;

public class ModelGargoyle extends ModelBase {
    public ModelRenderer Torso;
    public ModelRenderer Body;
    public ModelRenderer LeftLeg;
    public ModelRenderer RightLeg;
    public ModelRenderer Head;
    public ModelRenderer RightArm;
    public ModelRenderer LeftArm;
    public ModelRenderer RightWing1;
    public ModelRenderer LeftWing1;
    public ModelRenderer RightHorn;
    public ModelRenderer LeftHorn;
    public ModelRenderer Nose;
    public ModelRenderer RightArmShoulder;
    public ModelRenderer LeftArm_1;
    public ModelRenderer RightWing2;
    public ModelRenderer RightWingSkin1;
    public ModelRenderer RightWingSkin2;
    public ModelRenderer LeftWing2;
    public ModelRenderer LeftWingSkin1;
    public ModelRenderer LeftWingSkin2;

    public ModelGargoyle() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.RightArm = new ModelRenderer(this, 68, 0);
        this.RightArm.func_78793_a(-9.0F, -7.0F, 0.0F);
        this.RightArm.func_78790_a(-5.0F, -2.0F, -3.0F, 6, 20, 6, 0.0F);
        this.LeftArm = new ModelRenderer(this, 68, 0);
        this.LeftArm.field_78809_i = true;
        this.LeftArm.func_78793_a(9.0F, -7.0F, 0.0F);
        this.LeftArm.func_78790_a(-1.0F, -2.0F, -3.0F, 6, 20, 6, 0.0F);
        this.RightWing1 = new ModelRenderer(this, 0, 47);
        this.RightWing1.func_78793_a(-6.0F, -8.0F, 3.0F);
        this.RightWing1.func_78790_a(-12.0F, -1.5F, -1.5F, 12, 3, 3, 0.0F);
        this.setRotateAngle(this.RightWing1, 0.34906584F, 0.34906584F, 0.34906584F);
        this.RightArmShoulder = new ModelRenderer(this, 68, 0);
        this.RightArmShoulder.func_78793_a(0.0F, 0.0F, 0.0F);
        this.RightArmShoulder.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(this.RightArmShoulder, -0.0F, ((float)Math.PI / 3F), ((float)Math.PI / 3F));
        this.LeftArm_1 = new ModelRenderer(this, 68, 0);
        this.LeftArm_1.field_78809_i = true;
        this.LeftArm_1.func_78793_a(0.0F, 0.0F, 0.0F);
        this.LeftArm_1.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(this.LeftArm_1, 0.0F, (-(float)Math.PI / 3F), (-(float)Math.PI / 3F));
        this.LeftWingSkin2 = new ModelRenderer(this, 0, 61);
        this.LeftWingSkin2.field_78809_i = true;
        this.LeftWingSkin2.func_78793_a(0.0F, 0.0F, 0.0F);
        this.LeftWingSkin2.func_78790_a(-12.0F, 0.0F, 0.0F, 12, 8, 0, 0.0F);
        this.Torso = new ModelRenderer(this, 0, 36);
        this.Torso.func_78793_a(0.0F, 10.0F, 0.0F);
        this.Torso.func_78790_a(-5.0F, -5.0F, -3.0F, 10, 5, 6, 0.5F);
        this.RightWingSkin2 = new ModelRenderer(this, 0, 61);
        this.RightWingSkin2.field_78809_i = true;
        this.RightWingSkin2.func_78793_a(0.0F, 0.0F, 0.0F);
        this.RightWingSkin2.func_78790_a(-12.0F, 0.0F, 0.0F, 12, 8, 0, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 46, 0);
        this.LeftLeg.field_78809_i = true;
        this.LeftLeg.func_78793_a(5.0F, 0.0F, 0.0F);
        this.LeftLeg.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 14, 5, 0.0F);
        this.RightWing2 = new ModelRenderer(this, 0, 47);
        this.RightWing2.func_78793_a(-12.0F, 0.0F, 0.0F);
        this.RightWing2.func_78790_a(-12.0F, -1.5F, -1.5F, 12, 3, 3, 0.0F);
        this.setRotateAngle(this.RightWing2, 0.0F, 0.0F, -0.17453292F);
        this.LeftHorn = new ModelRenderer(this, 0, 0);
        this.LeftHorn.func_78793_a(0.0F, 0.0F, 0.0F);
        this.LeftHorn.func_78790_a(1.0F, -12.0F, -3.0F, 2, 4, 2, 0.0F);
        this.RightWingSkin1 = new ModelRenderer(this, 0, 53);
        this.RightWingSkin1.field_78809_i = true;
        this.RightWingSkin1.func_78793_a(0.0F, 0.0F, 0.0F);
        this.RightWingSkin1.func_78790_a(-12.0F, 0.0F, 0.0F, 12, 8, 0, 0.0F);
        this.RightLeg = new ModelRenderer(this, 46, 0);
        this.RightLeg.func_78793_a(-5.0F, 0.0F, 0.0F);
        this.RightLeg.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 14, 5, 0.0F);
        this.Nose = new ModelRenderer(this, 0, 0);
        this.Nose.func_78793_a(0.0F, 0.0F, 0.0F);
        this.Nose.func_78790_a(-1.0F, -3.0F, -6.0F, 2, 4, 2, 0.0F);
        this.LeftWingSkin1 = new ModelRenderer(this, 0, 53);
        this.LeftWingSkin1.field_78809_i = true;
        this.LeftWingSkin1.func_78793_a(0.0F, 0.0F, 0.0F);
        this.LeftWingSkin1.func_78790_a(-12.0F, 0.0F, 0.0F, 12, 8, 0, 0.0F);
        this.Body = new ModelRenderer(this, 0, 16);
        this.Body.func_78793_a(0.0F, -5.0F, 0.0F);
        this.Body.func_78790_a(-9.0F, -10.0F, -5.0F, 18, 10, 10, 0.0F);
        this.RightHorn = new ModelRenderer(this, 0, 0);
        this.RightHorn.func_78793_a(0.0F, 0.0F, 0.0F);
        this.RightHorn.func_78790_a(-3.0F, -12.0F, -3.0F, 2, 4, 2, 0.0F);
        this.LeftWing1 = new ModelRenderer(this, 0, 47);
        this.LeftWing1.field_78809_i = true;
        this.LeftWing1.func_78793_a(6.0F, -8.0F, 3.0F);
        this.LeftWing1.func_78790_a(-12.0F, -1.5F, -1.5F, 12, 3, 3, 0.0F);
        this.setRotateAngle(this.LeftWing1, -0.34906584F, 2.7925267F, -0.34906584F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.func_78793_a(0.0F, -10.0F, -2.0F);
        this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.LeftWing2 = new ModelRenderer(this, 0, 47);
        this.LeftWing2.field_78809_i = true;
        this.LeftWing2.func_78793_a(-12.0F, 0.0F, 0.0F);
        this.LeftWing2.func_78790_a(-12.0F, -1.5F, -1.5F, 12, 3, 3, 0.0F);
        this.setRotateAngle(this.LeftWing2, 0.0F, 0.0F, -0.17453292F);
        this.Body.func_78792_a(this.RightArm);
        this.Body.func_78792_a(this.LeftArm);
        this.Body.func_78792_a(this.RightWing1);
        this.RightArm.func_78792_a(this.RightArmShoulder);
        this.LeftArm.func_78792_a(this.LeftArm_1);
        this.LeftWing2.func_78792_a(this.LeftWingSkin2);
        this.RightWing2.func_78792_a(this.RightWingSkin2);
        this.Torso.func_78792_a(this.LeftLeg);
        this.RightWing1.func_78792_a(this.RightWing2);
        this.Head.func_78792_a(this.LeftHorn);
        this.RightWing1.func_78792_a(this.RightWingSkin1);
        this.Torso.func_78792_a(this.RightLeg);
        this.Head.func_78792_a(this.Nose);
        this.LeftWing1.func_78792_a(this.LeftWingSkin1);
        this.Torso.func_78792_a(this.Body);
        this.Head.func_78792_a(this.RightHorn);
        this.Body.func_78792_a(this.LeftWing1);
        this.Body.func_78792_a(this.Head);
        this.LeftWing1.func_78792_a(this.LeftWing2);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.Torso.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
        EntityGargoyle entityirongolem = (EntityGargoyle)p_78086_1_;
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        this.Torso.func_78793_a(0.0F, 10.0F, 0.0F);
        this.setRotateAngle(this.RightWing1, 0.34906584F, 0.34906584F, 0.34906584F);
        this.setRotateAngle(this.LeftWing1, -0.34906584F, 2.7925267F, -0.34906584F);
        this.setRotateAngle(this.RightWing2, 0.0F, 0.0F, -0.17453292F);
        this.setRotateAngle(this.LeftWing2, 0.0F, 0.0F, -0.17453292F);
        float f6 = MathHelper.func_76126_a(this.field_78095_p * (float)Math.PI);
        float f7 = MathHelper.func_76126_a((1.0F - (1.0F - this.field_78095_p) * (1.0F - this.field_78095_p)) * (float)Math.PI);
        this.Head.field_78796_g = p_78087_4_ / (180F / (float)Math.PI);
        this.Head.field_78795_f = p_78087_5_ / (180F / (float)Math.PI);
        this.RightArm.field_78808_h = 0.0F;
        this.LeftArm.field_78808_h = 0.0F;
        this.RightArm.field_78795_f = 0.0F;
        this.LeftArm.field_78795_f = 0.0F;
        this.RightLeg.field_78795_f = -1.5F * this.func_78172_a(p_78087_1_, 13.0F) * p_78087_2_;
        this.LeftLeg.field_78795_f = 1.5F * this.func_78172_a(p_78087_1_, 13.0F) * p_78087_2_;
        EntityGargoyle entityirongolem = (EntityGargoyle)p_78087_7_;
        int i = entityirongolem.getAttackTimer();
        boolean flag = entityirongolem.field_70170_p.func_147439_a(MathHelper.func_76128_c(entityirongolem.field_70165_t), MathHelper.func_76128_c(entityirongolem.field_70121_D.field_72338_b - (double)0.5F), MathHelper.func_76128_c(entityirongolem.field_70161_v)) == entityirongolem.getFavoriteBlockToPerch();
        if (i > 0) {
            this.RightArm.field_78795_f = -2.0F + 1.5F * this.func_78172_a((float)i, 10.0F);
            this.LeftArm.field_78795_f = -2.0F + 1.5F * this.func_78172_a((float)i, 10.0F);
        } else if (entityirongolem.field_70122_E && !entityirongolem.getAggressive()) {
            this.RightArm.field_78795_f = (-0.2F + 1.5F * this.func_78172_a(p_78087_1_, 13.0F)) * p_78087_2_;
            this.LeftArm.field_78795_f = (-0.2F - 1.5F * this.func_78172_a(p_78087_1_, 13.0F)) * p_78087_2_;
        }

        this.RightLeg.field_78796_g = 0.0F;
        this.LeftLeg.field_78796_g = 0.0F;
        if (!entityirongolem.field_70122_E || entityirongolem.getAggressive()) {
            ModelRenderer var10000 = this.RightWing1;
            var10000.field_78796_g += MathHelper.func_76134_b(p_78087_3_ * 0.5F) * 0.5F;
            var10000 = this.LeftWing1;
            var10000.field_78796_g -= MathHelper.func_76134_b(p_78087_3_ * 0.5F) * 0.5F;
            var10000 = this.RightWing2;
            var10000.field_78796_g += MathHelper.func_76134_b(p_78087_3_ * 0.5F - 1.5F);
            var10000 = this.LeftWing2;
            var10000.field_78796_g -= MathHelper.func_76134_b(p_78087_3_ * 0.5F - 1.5F);
            --this.Head.field_78795_f;
            var10000 = this.RightArm;
            var10000.field_78795_f -= 2.5F - (f6 * 1.2F - f7 * 0.4F);
            var10000 = this.LeftArm;
            var10000.field_78795_f -= 2.5F - (f6 * 1.2F - f7 * 0.4F);
            this.RightLeg.field_78795_f = 0.0F;
            this.LeftLeg.field_78795_f = 0.0F;
        }

        if (flag) {
            ModelRenderer var18 = this.RightWing1;
            var18.field_78796_g += 0.5F;
            var18 = this.LeftWing1;
            var18.field_78796_g -= 0.5F;
            var18 = this.RightWing2;
            var18.field_78796_g += -1.5F;
            var18 = this.LeftWing2;
            var18.field_78796_g -= -1.5F;
            var18 = this.RightArm;
            var18.field_78795_f -= 0.75F;
            var18 = this.LeftArm;
            var18.field_78795_f -= 0.75F;
            var18 = this.RightArm;
            var18.field_78808_h -= 0.5F;
            var18 = this.LeftArm;
            var18.field_78808_h += 0.5F;
            this.RightLeg.field_78795_f = -0.75F;
            this.LeftLeg.field_78795_f = -0.75F;
            this.Torso.field_78797_d = 18.0F;
            this.Torso.field_78795_f = 1.25F;
            --this.Head.field_78795_f;
        } else {
            this.Torso.field_78795_f = 0.0F;
        }

    }

    private float func_78172_a(float p_78172_1_, float p_78172_2_) {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }
}
