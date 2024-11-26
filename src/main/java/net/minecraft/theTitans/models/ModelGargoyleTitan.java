//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityGargoyleTitan;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.client.Animator;

public class ModelGargoyleTitan extends ModelBase {
    public ModelRenderer Torso;
    public ModelRenderer Body;
    public ModelRenderer LeftLeg;
    public ModelRenderer RightLeg;
    public ModelRenderer Head;
    public ModelRenderer RightArm;
    public ModelRenderer LeftArm;
    public ModelRenderer RightWing1;
    public ModelRenderer LeftWing1;
    public ModelRenderer RightHorn1;
    public ModelRenderer Nose;
    public ModelRenderer LeftHorn1;
    public ModelRenderer RightHorn2;
    public ModelRenderer RightHorn3;
    public ModelRenderer LeftHorn2;
    public ModelRenderer LeftHorn3;
    public ModelRenderer RightArmShoulder;
    public ModelRenderer RightForearm;
    public ModelRenderer LeftArmShoulder;
    public ModelRenderer LeftForearm;
    public ModelRenderer RightWing2;
    public ModelRenderer RightWingSkin1;
    public ModelRenderer RightWingSkin2;
    public ModelRenderer LeftWing2;
    public ModelRenderer LeftWingSkin1;
    public ModelRenderer LeftWingSkin2;
    public ModelRenderer LeftFoot;
    public ModelRenderer RightFoot;
    private Animator animator;

    public ModelGargoyleTitan() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.LeftForearm = new ModelRenderer(this, 68, 16);
        this.LeftForearm.field_78809_i = true;
        this.LeftForearm.func_78793_a(2.0F, 8.0F, 0.0F);
        this.LeftForearm.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 10, 6, 0.0F);
        this.RightHorn3 = new ModelRenderer(this, 0, 0);
        this.RightHorn3.func_78793_a(0.0F, -3.0F, -0.5F);
        this.RightHorn3.func_78790_a(-1.0F, -4.0F, -1.5F, 2, 4, 2, 0.0F);
        this.setRotateAngle(this.RightHorn3, -0.8651597F, 0.0F, -0.091106184F);
        this.LeftLeg = new ModelRenderer(this, 46, 0);
        this.LeftLeg.field_78809_i = true;
        this.LeftLeg.func_78793_a(5.0F, 0.0F, 0.0F);
        this.LeftLeg.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 7, 5, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.func_78793_a(0.0F, -10.0F, -2.0F);
        this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.LeftArmShoulder = new ModelRenderer(this, 68, 0);
        this.LeftArmShoulder.field_78809_i = true;
        this.LeftArmShoulder.func_78793_a(0.0F, 0.0F, 0.0F);
        this.LeftArmShoulder.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(this.LeftArmShoulder, 0.0F, (-(float)Math.PI / 3F), (-(float)Math.PI / 3F));
        this.Torso = new ModelRenderer(this, 0, 36);
        this.Torso.func_78793_a(0.0F, 10.0F, 0.0F);
        this.Torso.func_78790_a(-5.0F, -5.0F, -3.0F, 10, 5, 6, 0.5F);
        this.RightArm = new ModelRenderer(this, 68, 0);
        this.RightArm.func_78793_a(-9.0F, -7.0F, 0.0F);
        this.RightArm.func_78790_a(-5.0F, -2.0F, -3.0F, 6, 10, 6, 0.0F);
        this.Nose = new ModelRenderer(this, 0, 0);
        this.Nose.func_78793_a(0.0F, 0.0F, 0.0F);
        this.Nose.func_78790_a(-1.0F, -3.0F, -6.0F, 2, 4, 2, 0.0F);
        this.Body = new ModelRenderer(this, 0, 16);
        this.Body.func_78793_a(0.0F, -5.0F, 0.0F);
        this.Body.func_78790_a(-9.0F, -10.0F, -5.0F, 18, 10, 10, 0.0F);
        this.LeftWing2 = new ModelRenderer(this, 0, 47);
        this.LeftWing2.field_78809_i = true;
        this.LeftWing2.func_78793_a(-18.0F, 0.0F, 0.0F);
        this.LeftWing2.func_78790_a(-18.0F, -1.5F, -1.5F, 18, 3, 3, 0.0F);
        this.setRotateAngle(this.LeftWing2, 0.0F, 0.0F, -0.17453292F);
        this.LeftFoot = new ModelRenderer(this, 46, 12);
        this.LeftFoot.field_78809_i = true;
        this.LeftFoot.func_78793_a(0.0F, 7.0F, 0.0F);
        this.LeftFoot.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 7, 5, 0.0F);
        this.RightHorn1 = new ModelRenderer(this, 0, 0);
        this.RightHorn1.func_78793_a(-2.0F, -7.5F, -1.5F);
        this.RightHorn1.func_78790_a(-1.0F, -4.0F, -1.5F, 2, 4, 2, 0.0F);
        this.setRotateAngle(this.RightHorn1, 0.22759093F, 0.0F, -0.27314404F);
        this.RightWingSkin1 = new ModelRenderer(this, 0, 53);
        this.RightWingSkin1.field_78809_i = true;
        this.RightWingSkin1.func_78793_a(0.0F, 0.0F, 0.0F);
        this.RightWingSkin1.func_78790_a(-18.0F, 0.0F, 0.0F, 18, 12, 0, 0.0F);
        this.LeftWingSkin2 = new ModelRenderer(this, 0, 65);
        this.LeftWingSkin2.field_78809_i = true;
        this.LeftWingSkin2.func_78793_a(0.0F, 0.0F, 0.0F);
        this.LeftWingSkin2.func_78790_a(-18.0F, 0.0F, 0.0F, 18, 12, 0, 0.0F);
        this.RightForearm = new ModelRenderer(this, 68, 16);
        this.RightForearm.func_78793_a(-2.0F, 8.0F, 0.0F);
        this.RightForearm.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 10, 6, 0.0F);
        this.LeftHorn1 = new ModelRenderer(this, 0, 0);
        this.LeftHorn1.field_78809_i = true;
        this.LeftHorn1.func_78793_a(2.0F, -7.5F, -1.5F);
        this.LeftHorn1.func_78790_a(-1.0F, -4.0F, -1.5F, 2, 4, 2, 0.0F);
        this.setRotateAngle(this.LeftHorn1, 0.22759093F, 0.0F, 0.27314404F);
        this.RightWing2 = new ModelRenderer(this, 0, 47);
        this.RightWing2.func_78793_a(-18.0F, 0.0F, 0.0F);
        this.RightWing2.func_78790_a(-18.0F, -1.5F, -1.5F, 18, 3, 3, 0.0F);
        this.setRotateAngle(this.RightWing2, 0.0F, 0.0F, -0.17453292F);
        this.LeftWingSkin1 = new ModelRenderer(this, 0, 53);
        this.LeftWingSkin1.field_78809_i = true;
        this.LeftWingSkin1.func_78793_a(0.0F, 0.0F, 0.0F);
        this.LeftWingSkin1.func_78790_a(-18.0F, 0.0F, 0.0F, 18, 12, 0, 0.0F);
        this.RightLeg = new ModelRenderer(this, 46, 0);
        this.RightLeg.func_78793_a(-5.0F, 0.0F, 0.0F);
        this.RightLeg.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 7, 5, 0.0F);
        this.LeftWing1 = new ModelRenderer(this, 0, 47);
        this.LeftWing1.field_78809_i = true;
        this.LeftWing1.func_78793_a(6.0F, -8.0F, 3.0F);
        this.LeftWing1.func_78790_a(-18.0F, -1.5F, -1.5F, 18, 3, 3, 0.0F);
        this.setRotateAngle(this.LeftWing1, -0.34906584F, 2.7925267F, -0.34906584F);
        this.RightFoot = new ModelRenderer(this, 46, 12);
        this.RightFoot.func_78793_a(0.0F, 7.0F, 0.0F);
        this.RightFoot.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 7, 5, 0.0F);
        this.LeftArm = new ModelRenderer(this, 68, 0);
        this.LeftArm.field_78809_i = true;
        this.LeftArm.func_78793_a(9.0F, -7.0F, 0.0F);
        this.LeftArm.func_78790_a(-1.0F, -2.0F, -3.0F, 6, 10, 6, 0.0F);
        this.RightWing1 = new ModelRenderer(this, 0, 47);
        this.RightWing1.func_78793_a(-6.0F, -8.0F, 3.0F);
        this.RightWing1.func_78790_a(-18.0F, -1.5F, -1.5F, 18, 3, 3, 0.0F);
        this.setRotateAngle(this.RightWing1, 0.34906584F, 0.34906584F, 0.34906584F);
        this.RightHorn2 = new ModelRenderer(this, 0, 0);
        this.RightHorn2.func_78793_a(0.0F, -3.0F, -0.5F);
        this.RightHorn2.func_78790_a(-1.0F, -4.0F, -1.5F, 2, 4, 2, 0.0F);
        this.setRotateAngle(this.RightHorn2, -0.68294734F, 0.0F, -0.091106184F);
        this.RightArmShoulder = new ModelRenderer(this, 68, 0);
        this.RightArmShoulder.func_78793_a(0.0F, 0.0F, 0.0F);
        this.RightArmShoulder.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(this.RightArmShoulder, -0.0F, ((float)Math.PI / 3F), ((float)Math.PI / 3F));
        this.LeftHorn2 = new ModelRenderer(this, 0, 0);
        this.LeftHorn2.field_78809_i = true;
        this.LeftHorn2.func_78793_a(0.0F, -3.0F, -0.5F);
        this.LeftHorn2.func_78790_a(-1.0F, -4.0F, -1.5F, 2, 4, 2, 0.0F);
        this.setRotateAngle(this.LeftHorn2, -0.68294734F, 0.0F, 0.091106184F);
        this.LeftHorn3 = new ModelRenderer(this, 0, 0);
        this.LeftHorn3.field_78809_i = true;
        this.LeftHorn3.func_78793_a(0.0F, -3.0F, -0.5F);
        this.LeftHorn3.func_78790_a(-1.0F, -4.0F, -1.5F, 2, 4, 2, 0.0F);
        this.setRotateAngle(this.LeftHorn3, -0.8651597F, 0.0F, 0.091106184F);
        this.RightWingSkin2 = new ModelRenderer(this, 0, 65);
        this.RightWingSkin2.field_78809_i = true;
        this.RightWingSkin2.func_78793_a(0.0F, 0.0F, 0.0F);
        this.RightWingSkin2.func_78790_a(-18.0F, 0.0F, 0.0F, 18, 12, 0, 0.0F);
        this.LeftArm.func_78792_a(this.LeftForearm);
        this.RightHorn2.func_78792_a(this.RightHorn3);
        this.Torso.func_78792_a(this.LeftLeg);
        this.Body.func_78792_a(this.Head);
        this.LeftArm.func_78792_a(this.LeftArmShoulder);
        this.Body.func_78792_a(this.RightArm);
        this.Head.func_78792_a(this.Nose);
        this.Torso.func_78792_a(this.Body);
        this.LeftWing1.func_78792_a(this.LeftWing2);
        this.LeftLeg.func_78792_a(this.LeftFoot);
        this.Head.func_78792_a(this.RightHorn1);
        this.RightWing1.func_78792_a(this.RightWingSkin1);
        this.LeftWing2.func_78792_a(this.LeftWingSkin2);
        this.RightArm.func_78792_a(this.RightForearm);
        this.Head.func_78792_a(this.LeftHorn1);
        this.RightWing1.func_78792_a(this.RightWing2);
        this.LeftWing1.func_78792_a(this.LeftWingSkin1);
        this.Torso.func_78792_a(this.RightLeg);
        this.Body.func_78792_a(this.LeftWing1);
        this.RightLeg.func_78792_a(this.RightFoot);
        this.Body.func_78792_a(this.LeftArm);
        this.Body.func_78792_a(this.RightWing1);
        this.RightHorn1.func_78792_a(this.RightHorn2);
        this.RightArm.func_78792_a(this.RightArmShoulder);
        this.LeftHorn1.func_78792_a(this.LeftHorn2);
        this.LeftHorn2.func_78792_a(this.LeftHorn3);
        this.RightWing2.func_78792_a(this.RightWingSkin2);
        this.animator = new Animator(this);
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

    public void setAngles() {
        this.Torso.func_78793_a(0.0F, 10.0F, 0.0F);
        this.RightLeg.func_78793_a(-5.0F, 0.0F, 0.0F);
        this.LeftLeg.func_78793_a(5.0F, 0.0F, 0.0F);
        this.setRotateAngle(this.LeftArmShoulder, 0.0F, (-(float)Math.PI / 3F), (-(float)Math.PI / 3F));
        this.setRotateAngle(this.RightArmShoulder, -0.0F, ((float)Math.PI / 3F), ((float)Math.PI / 3F));
        this.setRotateAngle(this.RightWing1, 0.34906584F, 0.34906584F, 0.34906584F);
        this.setRotateAngle(this.LeftWing1, -0.34906584F, 2.7925267F, -0.34906584F);
        this.setRotateAngle(this.RightWing2, 0.0F, 0.0F, -0.17453292F);
        this.setRotateAngle(this.LeftWing2, 0.0F, 0.0F, -0.17453292F);
        this.setRotateAngle(this.RightHorn1, 0.22759093F, 0.0F, -0.27314404F);
        this.setRotateAngle(this.RightHorn2, -0.68294734F, 0.0F, -0.091106184F);
        this.setRotateAngle(this.RightHorn3, -0.8651597F, 0.0F, -0.091106184F);
        this.setRotateAngle(this.LeftHorn1, 0.22759093F, 0.0F, 0.27314404F);
        this.setRotateAngle(this.LeftHorn2, -0.68294734F, 0.0F, 0.091106184F);
        this.setRotateAngle(this.LeftHorn3, -0.8651597F, 0.0F, 0.091106184F);
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        EntityGargoyleTitan entitytitan = (EntityGargoyleTitan)p_78087_7_;
        this.animator.update(entitytitan);
        this.setAngles();
        if (entitytitan.deathTicks <= 0) {
            this.Head.field_78796_g = p_78087_4_ / (180F / (float)Math.PI);
            this.Head.field_78795_f = p_78087_5_ / (180F / (float)Math.PI);
            if (entitytitan.animID == 0) {
                ModelRenderer var10000 = this.RightWing1;
                var10000.field_78796_g += MathHelper.func_76134_b(p_78087_3_ * 0.05F) * 0.1F;
                var10000 = this.LeftWing1;
                var10000.field_78796_g -= MathHelper.func_76134_b(p_78087_3_ * 0.05F) * 0.1F;
                var10000 = this.RightWing2;
                var10000.field_78796_g += MathHelper.func_76134_b(p_78087_3_ * 0.05F - 0.2F) * 0.2F;
                var10000 = this.LeftWing2;
                var10000.field_78796_g -= MathHelper.func_76134_b(p_78087_3_ * 0.05F - 0.2F) * 0.2F;
                var10000 = this.RightWing1;
                var10000.field_78796_g += MathHelper.func_76134_b(p_78087_3_ * 0.3331F) * 0.2F * p_78087_2_;
                var10000 = this.LeftWing1;
                var10000.field_78796_g -= MathHelper.func_76134_b(p_78087_3_ * 0.3331F) * 0.2F * p_78087_2_;
                var10000 = this.RightWing2;
                var10000.field_78796_g += MathHelper.func_76134_b(p_78087_3_ * 0.3331F - 0.2F) * 0.2F * p_78087_2_;
                var10000 = this.LeftWing2;
                var10000.field_78796_g -= MathHelper.func_76134_b(p_78087_3_ * 0.3331F - 0.2F) * 0.2F * p_78087_2_;
                this.RightLeg.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.3331F - 0.5F) * 1.25F * p_78087_2_;
                this.LeftLeg.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.3331F + 2.6415927F) * 1.25F * p_78087_2_;
                this.RightFoot.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.3331F + (float)Math.PI) * 1.25F * p_78087_2_;
                this.LeftFoot.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.3331F) * 1.25F * p_78087_2_;
                this.RightArm.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.25F + (float)Math.PI) * 1.0F * p_78087_2_;
                this.LeftArm.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.25F) * 1.0F * p_78087_2_;
                this.RightForearm.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.25F + 2.1415927F) * 1.0F * p_78087_2_;
                this.LeftForearm.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.25F - 1.0F) * 1.0F * p_78087_2_;
            }

            if (this.RightFoot.field_78795_f < 0.0F) {
                this.RightFoot.field_78795_f = 0.0F;
            }

            if (this.LeftFoot.field_78795_f < 0.0F) {
                this.LeftFoot.field_78795_f = 0.0F;
            }

            if (this.RightForearm.field_78795_f > 0.0F) {
                this.RightForearm.field_78795_f = 0.0F;
            }

            if (this.LeftForearm.field_78795_f > 0.0F) {
                this.LeftForearm.field_78795_f = 0.0F;
            }

            if (!entitytitan.field_70122_E) {
                ModelRenderer var16 = this.RightWing1;
                var16.field_78796_g += MathHelper.func_76134_b(p_78087_3_ * 0.2F);
                var16 = this.LeftWing1;
                var16.field_78796_g -= MathHelper.func_76134_b(p_78087_3_ * 0.2F);
                var16 = this.RightWing2;
                var16.field_78796_g += MathHelper.func_76134_b(p_78087_3_ * 0.2F - 2.0F);
                var16 = this.LeftWing2;
                var16.field_78796_g -= MathHelper.func_76134_b(p_78087_3_ * 0.2F - 2.0F);
                ++this.Torso.field_78795_f;
                --this.Head.field_78795_f;
                this.RightArm.field_78795_f = -0.5F;
                this.LeftArm.field_78795_f = -0.5F;
                this.RightForearm.field_78795_f = -0.5F;
                this.LeftForearm.field_78795_f = -0.5F;
                this.RightLeg.field_78795_f = 0.5F;
                this.LeftLeg.field_78795_f = 0.5F;
                this.RightFoot.field_78795_f = 0.5F;
                this.LeftFoot.field_78795_f = 0.5F;
            }

            this.animateAntiTitanAttack();
            this.animateWingBuffet();
            this.animateSlam();
            this.animateMeteor();
            this.animateWaterSpout();
            this.animateLavaSpit();
            this.animateStomp();
            this.animateSwat();
            this.animatePunch();
        }

    }

    private void animateAntiTitanAttack() {
        this.animator.setAnim(1);
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, 0.0F, 1.0F, 0.5F);
        this.animator.rotate(this.LeftWing1, 0.0F, -1.0F, -0.5F);
        this.animator.rotate(this.RightWing2, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, -1.0F, 0.0F);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftArm, 2.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, 0.0F, -1.0F, -1.0F);
        this.animator.rotate(this.LeftWing1, 0.0F, 1.0F, 1.0F);
        this.animator.rotate(this.RightWing2, 0.0F, -1.0F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.Head, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, -2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftArm, -2.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(10);
    }

    private void animateWingBuffet() {
        this.animator.setAnim(2);
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.LeftWing1, 0.0F, -1.0F, 0.0F);
        this.animator.rotate(this.RightWing2, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, -1.0F, 0.0F);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, -1.0F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftArm, -1.0F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForearm, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -1.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, -0.25F, -1.0F, 0.5F);
        this.animator.rotate(this.LeftWing1, 0.25F, 1.0F, -0.5F);
        this.animator.rotate(this.RightWing2, 0.0F, -1.0F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, -1.0F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftArm, -1.0F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForearm, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -1.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, 0.0F, -0.75F, -0.5F);
        this.animator.rotate(this.LeftWing1, 0.0F, 0.75F, 0.5F);
        this.animator.rotate(this.RightWing2, 0.0F, -0.75F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, 0.75F, 0.0F);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, 0.8F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftArm, 0.8F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForearm, -1.6F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -1.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, 0.0F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftWing1, 0.0F, -0.5F, -0.5F);
        this.animator.rotate(this.RightWing2, 0.0F, 0.5F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.Head, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.Body, 0.0F, 0.5F, 0.0F);
        this.animator.rotate(this.RightArm, -2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForearm, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(60);
        this.animator.resetPhase(20);
    }

    private void animateSlam() {
        this.animator.setAnim(3);
        this.animator.startPhase(10);
        this.animator.move(this.Torso, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.RightWing1, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftWing1, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightLeg, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftLeg, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFoot, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFoot, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, 0.8F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftArm, 0.8F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForearm, -1.6F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -1.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(15);
        this.animator.move(this.Torso, 0.0F, -1.0F, 0.0F);
        this.animator.rotate(this.RightWing1, 0.0F, -0.5F, 0.25F);
        this.animator.rotate(this.LeftWing1, 0.0F, 0.5F, -0.25F);
        this.animator.rotate(this.RightWing2, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, 0.5F, 0.0F);
        this.animator.rotate(this.RightLeg, -1.6F, 0.2F, 0.0F);
        this.animator.rotate(this.LeftLeg, 0.0F, 0.2F, 0.0F);
        this.animator.rotate(this.RightFoot, 0.9F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFoot, 0.1F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, 0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, -2.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftArm, -2.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForearm, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -1.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(15);
        this.animator.move(this.Torso, 0.0F, 4.0F, -1.0F);
        this.animator.rotate(this.RightWing1, 0.0F, 0.5F, -0.5F);
        this.animator.rotate(this.LeftWing1, 0.0F, -0.5F, 0.5F);
        this.animator.rotate(this.RightWing2, 0.0F, 0.5F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.RightLeg, -1.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftLeg, -1.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFoot, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFoot, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, -2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Torso, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, -1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftArm, -1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForearm, -0.5F, 0.0F, -0.5F);
        this.animator.rotate(this.LeftForearm, -0.5F, 0.0F, 0.5F);
        this.animator.endPhase();
        this.animator.resetPhase(30);
    }

    private void animateMeteor() {
        this.animator.setAnim(4);
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, 0.0F, -0.75F, -0.5F);
        this.animator.rotate(this.LeftWing1, 0.0F, 0.75F, 0.5F);
        this.animator.rotate(this.RightWing2, 0.0F, -0.75F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, 0.75F, 0.0F);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, 0.8F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftArm, 0.8F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForearm, -1.6F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -1.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.RightWing1, 0.0F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftWing1, 0.0F, -0.5F, -0.5F);
        this.animator.rotate(this.RightWing2, 0.0F, 0.5F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.Head, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.Body, 0.0F, 0.5F, 0.0F);
        this.animator.rotate(this.RightArm, -2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForearm, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(60);
        this.animator.resetPhase(20);
    }

    private void animateWaterSpout() {
        this.animator.setAnim(5);
        this.animator.startPhase(20);
        this.animator.rotate(this.RightWing1, 0.0F, -0.75F, -0.5F);
        this.animator.rotate(this.LeftWing1, 0.0F, 0.75F, 0.5F);
        this.animator.rotate(this.RightWing2, 0.0F, -0.75F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, 0.75F, 0.0F);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, 0.8F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftArm, 0.8F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForearm, -1.6F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -1.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.RightWing1, 0.0F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftWing1, 0.0F, -0.5F, -0.5F);
        this.animator.rotate(this.RightWing2, 0.0F, 0.5F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.Nose, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, 0.5F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftArm, 0.5F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForearm, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -1.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(20);
    }

    private void animateLavaSpit() {
        this.animator.setAnim(6);
        this.animator.startPhase(20);
        this.animator.rotate(this.RightWing1, 0.0F, -0.75F, -0.5F);
        this.animator.rotate(this.LeftWing1, 0.0F, 0.75F, 0.5F);
        this.animator.rotate(this.RightWing2, 0.0F, -0.75F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, 0.75F, 0.0F);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, 0.8F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftArm, 0.8F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForearm, -1.6F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -1.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.RightWing1, 0.0F, -0.75F, -0.5F);
        this.animator.rotate(this.LeftWing1, 0.0F, 0.75F, 0.5F);
        this.animator.rotate(this.RightWing2, 0.0F, -0.75F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, 0.75F, 0.0F);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, 0.8F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftArm, 0.8F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForearm, -1.6F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -1.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.RightWing1, 0.0F, -0.75F, -0.5F);
        this.animator.rotate(this.LeftWing1, 0.0F, 0.75F, 0.5F);
        this.animator.rotate(this.RightWing2, 0.0F, -0.75F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, 0.75F, 0.0F);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, 0.8F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftArm, 0.8F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForearm, -1.6F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -1.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(10);
        this.animator.resetPhase(20);
    }

    private void animateStomp() {
        this.animator.setAnim(7);
        this.animator.startPhase(25);
        this.animator.rotate(this.RightLeg, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftLeg, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFoot, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFoot, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, 0.8F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftArm, 0.8F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForearm, -1.6F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -1.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(25);
        this.animator.rotate(this.RightLeg, -2.0F, 0.2F, 0.75F);
        this.animator.rotate(this.LeftLeg, 0.0F, 0.2F, 0.0F);
        this.animator.rotate(this.RightFoot, 1.5F, 0.0F, -0.5F);
        this.animator.rotate(this.LeftFoot, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, 1.0F, 0.0F, 0.5F);
        this.animator.rotate(this.Body, -1.0F, 0.0F, 0.25F);
        this.animator.rotate(this.RightArm, -0.75F, 0.0F, 0.5F);
        this.animator.rotate(this.LeftArm, -0.75F, 0.0F, -0.5F);
        this.animator.rotate(this.RightForearm, -0.3F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -0.3F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.RightWing1, -0.25F, -1.0F, 0.5F);
        this.animator.rotate(this.LeftWing1, 0.25F, 1.0F, -0.5F);
        this.animator.rotate(this.RightWing2, 0.0F, -1.0F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.RightLeg, -0.5F, 0.5F, 0.0F);
        this.animator.rotate(this.LeftLeg, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFoot, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFoot, 0.1F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, 0.5F, 0.0F, 0.5F);
        this.animator.rotate(this.Body, 0.5F, 0.0F, -0.4F);
        this.animator.rotate(this.RightArm, -0.75F, 0.0F, 0.5F);
        this.animator.rotate(this.LeftArm, -0.75F, 0.0F, -0.5F);
        this.animator.rotate(this.RightForearm, -0.3F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -0.3F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(5);
        this.animator.startPhase(20);
        this.animator.rotate(this.RightLeg, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftLeg, -2.0F, 0.0F, -0.75F);
        this.animator.rotate(this.RightFoot, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFoot, 1.5F, 0.0F, 0.5F);
        this.animator.rotate(this.Head, 1.0F, 0.0F, -0.5F);
        this.animator.rotate(this.Body, -1.0F, 0.0F, -0.25F);
        this.animator.rotate(this.RightArm, 0.8F, 0.0F, 0.5F);
        this.animator.rotate(this.LeftArm, 0.8F, 0.0F, -0.5F);
        this.animator.rotate(this.RightForearm, -0.8F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -0.8F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.RightWing1, -0.25F, -1.0F, 0.5F);
        this.animator.rotate(this.LeftWing1, 0.25F, 1.0F, -0.5F);
        this.animator.rotate(this.RightWing2, 0.0F, -1.0F, 0.0F);
        this.animator.rotate(this.LeftWing2, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.RightLeg, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftLeg, -0.5F, -0.5F, 0.0F);
        this.animator.rotate(this.RightFoot, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFoot, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, 0.5F, 0.0F, -0.5F);
        this.animator.rotate(this.Body, 0.5F, 0.0F, 0.4F);
        this.animator.rotate(this.RightArm, 0.75F, 0.0F, 0.5F);
        this.animator.rotate(this.LeftArm, 0.75F, 0.0F, -0.5F);
        this.animator.rotate(this.RightForearm, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -0.75F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.resetPhase(20);
    }

    private void animateSwat() {
        this.animator.setAnim(8);
        this.animator.startPhase(20);
        this.animator.move(this.Torso, 0.0F, 2.0F, 0.0F);
        this.animator.rotate(this.RightLeg, -0.5F, 0.25F, 0.0F);
        this.animator.rotate(this.LeftLeg, -0.5F, -0.25F, 0.0F);
        this.animator.rotate(this.RightFoot, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFoot, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, -1.5F, 1.0F, 0.0F);
        this.animator.rotate(this.LeftArm, -2.0F, 0.75F, 1.5F);
        this.animator.rotate(this.LeftForearm, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 1.5F, -1.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.move(this.Torso, 0.0F, 6.0F, 0.0F);
        this.animator.rotate(this.RightLeg, -1.0F, 0.5F, 0.0F);
        this.animator.rotate(this.LeftLeg, -1.0F, -0.5F, 0.0F);
        this.animator.rotate(this.RightFoot, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFoot, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, -2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftArm, -2.0F, -1.25F, -1.5F);
        this.animator.rotate(this.LeftForearm, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 2.25F, 1.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(20);
    }

    private void animatePunch() {
        this.animator.setAnim(9);
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 0.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Body, 0.0F, 0.0F, 0.5F);
        this.animator.rotate(this.Head, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftArm, -2.5F, 0.0F, 0.5F);
        this.animator.rotate(this.LeftForearm, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, 0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForearm, -1.5F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.move(this.Torso, 0.0F, 4.0F, 0.0F);
        this.animator.rotate(this.RightLeg, -1.0F, 0.5F, 0.0F);
        this.animator.rotate(this.LeftLeg, -1.0F, -0.5F, 0.0F);
        this.animator.rotate(this.RightFoot, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFoot, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Body, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightArm, -2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForearm, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftArm, -1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForearm, -0.5F, 0.0F, 0.5F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.resetPhase(20);
    }
}
