//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import thehippomaster.AnimationAPI.client.Animator;

public class ModelEnderColossus extends ModelBase {
    public boolean isAttacking;
    public ModelRenderer BodyBottom;
    public ModelRenderer LeftThigh;
    public ModelRenderer RightThigh;
    public ModelRenderer BodyMiddle;
    public ModelRenderer BodyTop;
    public ModelRenderer LeftShoulder;
    public ModelRenderer RightShoulder;
    public ModelRenderer Mouth;
    public ModelRenderer LeftForeArm;
    public ModelRenderer RightForeArm;
    public ModelRenderer Head;
    public ModelRenderer Horn1;
    public ModelRenderer Horn2;
    public ModelRenderer Horn3;
    public ModelRenderer Horn4;
    public ModelRenderer LeftFemur;
    public ModelRenderer RightFemur;
    private Animator animator;

    public ModelEnderColossus() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.RightShoulder = new ModelRenderer(this, 32, 0);
        this.RightShoulder.func_78793_a(-5.0F, -2.0F, 0.0F);
        this.RightShoulder.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 15, 2, 0.0F);
        this.LeftShoulder = new ModelRenderer(this, 32, 0);
        this.LeftShoulder.field_78809_i = true;
        this.LeftShoulder.func_78793_a(5.0F, -2.0F, 0.0F);
        this.LeftShoulder.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 15, 2, 0.0F);
        this.Horn1 = new ModelRenderer(this, 24, 38);
        this.Horn1.func_78793_a(4.0F, -4.0F, 0.0F);
        this.Horn1.func_78790_a(0.0F, -1.0F, -1.0F, 4, 2, 2, 0.0F);
        this.Mouth = new ModelRenderer(this, 0, 16);
        this.Mouth.func_78793_a(0.0F, -4.0F, 0.0F);
        this.Mouth.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.25F);
        this.BodyMiddle = new ModelRenderer(this, 0, 40);
        this.BodyMiddle.func_78793_a(0.0F, -4.0F, 0.0F);
        this.BodyMiddle.func_78790_a(-4.0F, -4.0F, -2.0F, 8, 4, 4, 0.0F);
        this.LeftForeArm = new ModelRenderer(this, 32, 17);
        this.LeftForeArm.field_78809_i = true;
        this.LeftForeArm.func_78793_a(0.0F, 13.0F, 0.0F);
        this.LeftForeArm.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 15, 2, 0.0F);
        this.RightForeArm = new ModelRenderer(this, 32, 17);
        this.RightForeArm.func_78793_a(0.0F, 13.0F, 0.0F);
        this.RightForeArm.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 15, 2, 0.0F);
        this.BodyTop = new ModelRenderer(this, 0, 32);
        this.BodyTop.func_78793_a(0.0F, -4.0F, 0.0F);
        this.BodyTop.func_78790_a(-4.0F, -4.0F, -2.0F, 8, 4, 4, 0.0F);
        this.LeftThigh = new ModelRenderer(this, 32, 0);
        this.LeftThigh.field_78809_i = true;
        this.LeftThigh.func_78793_a(2.0F, -6.0F, 0.0F);
        this.LeftThigh.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 15, 2, 0.0F);
        this.BodyBottom = new ModelRenderer(this, 0, 48);
        this.BodyBottom.func_78793_a(0.0F, -6.0F, -0.0F);
        this.BodyBottom.func_78790_a(-4.0F, -4.0F, -2.0F, 8, 4, 4, 0.0F);
        this.RightThigh = new ModelRenderer(this, 32, 0);
        this.RightThigh.func_78793_a(-2.0F, -6.0F, 0.0F);
        this.RightThigh.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 15, 2, 0.0F);
        this.LeftFemur = new ModelRenderer(this, 32, 17);
        this.LeftFemur.field_78809_i = true;
        this.LeftFemur.func_78793_a(0.0F, 15.0F, 0.0F);
        this.LeftFemur.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 15, 2, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
        this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.25F);
        this.Horn2 = new ModelRenderer(this, 24, 38);
        this.Horn2.func_78793_a(-4.0F, -4.0F, 0.0F);
        this.Horn2.func_78790_a(-4.0F, -1.0F, -1.0F, 4, 2, 2, 0.0F);
        this.Horn3 = new ModelRenderer(this, 36, 36);
        this.Horn3.func_78793_a(3.0F, -1.0F, 0.0F);
        this.Horn3.func_78790_a(-1.0F, -4.0F, -1.0F, 2, 4, 2, 0.0F);
        this.RightFemur = new ModelRenderer(this, 32, 17);
        this.RightFemur.func_78793_a(0.0F, 15.0F, 0.0F);
        this.RightFemur.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 15, 2, 0.0F);
        this.Horn4 = new ModelRenderer(this, 36, 36);
        this.Horn4.func_78793_a(-3.0F, -1.0F, 0.0F);
        this.Horn4.func_78790_a(-1.0F, -4.0F, -1.0F, 2, 4, 2, 0.0F);
        this.BodyTop.func_78792_a(this.RightShoulder);
        this.BodyTop.func_78792_a(this.LeftShoulder);
        this.Head.func_78792_a(this.Horn1);
        this.BodyTop.func_78792_a(this.Mouth);
        this.BodyBottom.func_78792_a(this.BodyMiddle);
        this.LeftShoulder.func_78792_a(this.LeftForeArm);
        this.RightShoulder.func_78792_a(this.RightForeArm);
        this.BodyMiddle.func_78792_a(this.BodyTop);
        this.LeftThigh.func_78792_a(this.LeftFemur);
        this.Mouth.func_78792_a(this.Head);
        this.Head.func_78792_a(this.Horn2);
        this.Horn1.func_78792_a(this.Horn3);
        this.RightThigh.func_78792_a(this.RightFemur);
        this.Horn2.func_78792_a(this.Horn4);
        this.animator = new Animator(this);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animate((IAnimatedEntity)entity, f, f1, f2, f3, f4, f5);
        this.LeftThigh.func_78785_a(f5);
        this.BodyBottom.func_78785_a(f5);
        this.RightThigh.func_78785_a(f5);
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animator.update(entity);
        this.setAngles();
        EntityEnderColossus entitytitan = (EntityEnderColossus)entity;
        if (this.isAttacking) {
            this.Head.func_78793_a(0.0F, -7.0F, 0.0F);
        } else {
            this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
        }

        float f6 = MathHelper.func_76134_b(f2 * 0.05F);
        this.RightThigh.field_78795_f = -0.09F;
        this.LeftThigh.field_78795_f = -0.09F;
        this.RightFemur.field_78795_f = 0.18F;
        this.LeftFemur.field_78795_f = 0.18F;
        if (entitytitan.deathTicks <= 0) {
            if (!this.field_78093_q) {
                this.LeftThigh.field_78795_f = -0.09F + MathHelper.func_76134_b(f * 0.33F + 2.6415927F) * 0.75F * f1;
                this.RightThigh.field_78795_f = -0.09F + MathHelper.func_76134_b(f * 0.33F - 0.5F) * 0.75F * f1;
                this.LeftFemur.field_78795_f = 0.18F + MathHelper.func_76134_b(f * 0.33F) * 0.75F * f1;
                this.RightFemur.field_78795_f = 0.18F + MathHelper.func_76134_b(f * 0.33F + (float)Math.PI) * 0.75F * f1;
                if (this.RightFemur.field_78795_f < 0.0F) {
                    this.RightFemur.field_78795_f = 0.0F;
                }

                if (this.LeftFemur.field_78795_f < 0.0F) {
                    this.LeftFemur.field_78795_f = 0.0F;
                }
            }

            float faceYaw = f3 * (float)Math.PI / 180.0F;
            float facePitch = f4 * (float)Math.PI / 180.0F;
            if (entitytitan.getAnimID() == 0) {
                this.BodyMiddle.field_78795_f = (0.0F + -0.01F * f6) * (float)Math.PI;
                this.BodyTop.field_78795_f = (0.0F + -0.01F * f6) * (float)Math.PI;
                this.Head.field_78795_f = (-0.01F + -0.01F * f6) * (float)Math.PI;
                this.Mouth.field_78795_f = (0.01F + 0.01F * f6) * (float)Math.PI;
                this.BodyBottom.field_78808_h = MathHelper.func_76134_b(f * 0.33F) * 0.125F * f1;
                this.BodyMiddle.field_78808_h = MathHelper.func_76134_b(f * 0.33F) * 0.125F * f1;
                this.BodyTop.field_78808_h = MathHelper.func_76134_b(f * 0.33F) * 0.125F * f1;
                this.Mouth.field_78808_h = MathHelper.func_76134_b(f * 0.33F + (float)Math.PI) * 0.375F * f1;
                this.RightForeArm.field_78795_f = MathHelper.func_76134_b(f * 0.33F + (float)Math.PI) * 0.75F * f1 - 0.3F;
                this.LeftForeArm.field_78795_f = MathHelper.func_76134_b(f * 0.33F) * 0.75F * f1 - 0.3F;
            }

            this.RightShoulder.field_78795_f = 0.09F + MathHelper.func_76134_b(f * 0.33F + (float)Math.PI) * 0.75F * f1;
            this.LeftShoulder.field_78795_f = 0.09F + MathHelper.func_76134_b(f * 0.33F) * 0.75F * f1;
            this.RightShoulder.field_78796_g = 0.08F;
            this.LeftShoulder.field_78796_g = -0.08F;
            this.RightShoulder.field_78808_h = 0.10471976F - (0.005F + 0.005F * f6) * (float)Math.PI;
            this.LeftShoulder.field_78808_h = -0.10471976F + (-0.005F + -0.005F * f6) * (float)Math.PI;
            if (entitytitan.animID == 0 && entitytitan.getEyeLaserTime() < 0) {
                ModelRenderer var13 = this.Mouth;
                var13.field_78795_f += facePitch * 0.3F;
                var13 = this.Mouth;
                var13.field_78796_g += faceYaw * 0.3F;
                var13 = this.BodyTop;
                var13.field_78795_f += facePitch * 0.3F;
                var13 = this.BodyTop;
                var13.field_78796_g += faceYaw * 0.3F;
                var13 = this.BodyMiddle;
                var13.field_78795_f += facePitch * 0.3F;
                var13 = this.BodyMiddle;
                var13.field_78796_g += faceYaw * 0.3F;
                var13 = this.RightShoulder;
                var13.field_78795_f -= facePitch * 0.6F;
                var13 = this.LeftShoulder;
                var13.field_78795_f -= facePitch * 0.6F;
            } else {
                ModelRenderer var10000 = this.Mouth;
                var10000.field_78795_f += facePitch * 0.9F;
                var10000 = this.Mouth;
                var10000.field_78796_g += faceYaw * 0.9F;
            }

            if (this.RightForeArm.field_78795_f > -0.3F) {
                this.RightForeArm.field_78795_f = -0.3F;
            }

            if (this.LeftForeArm.field_78795_f > -0.3F) {
                this.LeftForeArm.field_78795_f = -0.3F;
            }

            if (!entitytitan.field_70122_E && !this.field_78093_q) {
                this.BodyTop.field_78808_h = 0.0F;
                this.BodyMiddle.field_78808_h = 0.0F;
                this.BodyBottom.field_78808_h = 0.0F;
                this.Mouth.field_78808_h = 0.0F;
                this.BodyBottom.field_78808_h = 0.0F;
                this.BodyMiddle.field_78808_h = 0.0F;
                this.BodyTop.field_78808_h = 0.0F;
                this.Head.field_78808_h = 0.0F;
                this.RightShoulder.field_78795_f = 0.09F;
                this.LeftShoulder.field_78795_f = 0.09F;
                this.RightForeArm.field_78795_f = 0.09F;
                this.LeftForeArm.field_78795_f = 0.09F;
                ModelRenderer var21 = this.Mouth;
                var21.field_78795_f -= entitytitan.field_70721_aZ;
                var21 = this.BodyBottom;
                var21.field_78795_f += entitytitan.field_70721_aZ;
                this.RightThigh.field_78795_f = MathHelper.func_76134_b(f2 * 0.1F - 0.5F) * 0.25F - (float)(entitytitan.field_70181_x / (double)5.0F) + entitytitan.field_70721_aZ;
                this.LeftThigh.field_78795_f = MathHelper.func_76134_b(f2 * 0.1F - 3.6415927F) * 0.25F - (float)(entitytitan.field_70181_x / (double)5.0F) + entitytitan.field_70721_aZ;
                this.RightFemur.field_78795_f = 0.5F - MathHelper.func_76134_b(f2 * 0.1F) * 0.5F;
                this.LeftFemur.field_78795_f = 0.5F - MathHelper.func_76134_b(f2 * 0.1F - (float)Math.PI) * 0.5F;
            }

            if (entitytitan.getAnimID() == 8 && entitytitan.getAnimTick() > 20 && entitytitan.getAnimTick() < 60) {
                this.BodyTop.field_78796_g = MathHelper.func_76134_b(f2) * 0.5F;
                this.Mouth.field_78796_g = MathHelper.func_76134_b(f2) * 0.25F;
                this.BodyTop.field_78795_f = MathHelper.func_76134_b(f2 * 0.25F - 2.0F) * 0.25F;
                this.BodyMiddle.field_78795_f = MathHelper.func_76134_b(f2 * 0.25F - 1.0F) * 0.25F;
                this.BodyBottom.field_78795_f = MathHelper.func_76134_b(f2 * 0.25F) * 0.25F;
            }

            if (entitytitan.getAnimID() == 8 && entitytitan.getAnimTick() > 100 && entitytitan.getAnimTick() < 340) {
                this.Mouth.field_78796_g = MathHelper.func_76134_b(f2 * 0.05F) * 0.2F;
            }

            if (entitytitan.getAnimID() == 1) {
                switch (entitytitan.antiTitanAttackAnimeID) {
                    case 0:
                        this.animateAntiTitanAttack1();
                        break;
                    case 1:
                        this.animateAntiTitanAttack2();
                        break;
                    case 2:
                        this.animateAntiTitanAttack3();
                        break;
                    case 3:
                        this.animateAntiTitanAttack4();
                }
            }

            this.animateStomp();
            this.animateSwat();
            this.animateSlam();
            this.animateMeteor();
            this.animateChainLightning();
            this.animateLightning();
            this.animateLightningBall();
            this.animateDragonBall();
            this.animateScream();
            this.animateStunned();
            if (this.Head.field_78797_d < -7.0F) {
                this.Head.field_78797_d = -7.0F;
            }

            if (entitytitan.getAnimID() == 3 && entitytitan.getAnimTick() > 30 && entitytitan.getAnimTick() < 50) {
                ModelRenderer var23 = this.RightForeArm;
                var23.field_78795_f += 0.1F * MathHelper.func_76134_b(f2) * (float)Math.PI;
                var23 = this.LeftForeArm;
                var23.field_78795_f -= 0.1F * MathHelper.func_76134_b(f2) * (float)Math.PI;
            }
        } else {
            this.animateDeath();
        }

    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void setAngles() {
        this.RightShoulder.func_78793_a(-5.0F, -2.0F, 0.0F);
        this.LeftShoulder.func_78793_a(5.0F, -2.0F, 0.0F);
        this.Mouth.func_78793_a(0.0F, -4.0F, 0.0F);
        this.BodyBottom.func_78793_a(0.0F, -4.0F, 0.0F);
        this.LeftThigh.func_78793_a(2.0F, -6.0F, 0.0F);
        this.RightThigh.func_78793_a(-2.0F, -6.0F, 0.0F);
        this.Horn1.func_78793_a(4.25F, -4.5F, 0.0F);
        this.Horn2.func_78793_a(-4.25F, -4.5F, 0.0F);
    }

    private void animateAntiTitanAttack1() {
        this.animator.setAnim(1);
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.RightThigh, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.LeftThigh, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.rotate(this.Head, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, 1.0F, -1.0F, 0.0F);
        this.animator.rotate(this.RightForeArm, -1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftShoulder, 1.0F, 1.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.25F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0F, 2.0F, -12.0F);
        this.animator.move(this.RightThigh, 0.0F, 2.0F, -12.0F);
        this.animator.move(this.LeftThigh, 0.0F, 2.0F, -12.0F);
        this.animator.rotate(this.Head, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, -1.0F, 1.0F, 0.0F);
        this.animator.rotate(this.RightForeArm, -1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftShoulder, -1.0F, -1.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.5F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(10);
    }

    private void animateAntiTitanAttack2() {
        this.animator.setAnim(1);
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.RightThigh, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.LeftThigh, 0.0F, 1.0F, 5.0F);
        this.animator.rotate(this.RightThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 0.5F, -0.5F, 0.0F);
        this.animator.rotate(this.BodyMiddle, -0.25F, 0.25F, 0.0F);
        this.animator.rotate(this.BodyTop, -0.25F, 0.25F, 0.0F);
        this.animator.rotate(this.RightShoulder, 1.6F, 0.0F, 2.0F);
        this.animator.rotate(this.RightForeArm, -0.9F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0F, 2.0F, -12.0F);
        this.animator.move(this.RightThigh, 0.0F, 2.0F, -12.0F);
        this.animator.move(this.LeftThigh, 0.0F, 2.0F, -12.0F);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -0.5F, 0.5F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.25F, -0.25F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.25F, -0.25F, 0.0F);
        this.animator.rotate(this.RightShoulder, -2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftShoulder, 0.0F, 0.0F, -0.75F);
        this.animator.rotate(this.RightForeArm, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -0.5F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateAntiTitanAttack3() {
        this.animator.setAnim(1);
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.RightThigh, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.LeftThigh, 0.0F, 1.0F, 5.0F);
        this.animator.rotate(this.RightThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 1.6F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, -0.8F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, -0.8F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, -4.0F, 0.0F, -0.25F);
        this.animator.rotate(this.LeftShoulder, -4.0F, 0.0F, 0.25F);
        this.animator.rotate(this.RightForeArm, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -1.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0F, 2.0F, -12.0F);
        this.animator.move(this.RightThigh, 0.0F, 2.0F, -12.0F);
        this.animator.move(this.LeftThigh, 0.0F, 2.0F, -12.0F);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.rotate(this.RightThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, 1.0F, 0.0F, -0.25F);
        this.animator.rotate(this.LeftShoulder, 1.0F, 0.0F, 0.25F);
        this.animator.rotate(this.RightForeArm, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -1.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateAntiTitanAttack4() {
        this.animator.setAnim(1);
        this.animator.startPhase(10);
        this.animator.rotate(this.RightThigh, 2.0F, 0.2F, 1.5F);
        this.animator.rotate(this.RightFemur, 1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 0.0F, -1.0F, -0.2F);
        this.animator.rotate(this.BodyTop, 0.5F, 0.0F, -0.2F);
        this.animator.rotate(this.BodyMiddle, 0.5F, 0.0F, -0.2F);
        this.animator.rotate(this.BodyBottom, -1.0F, 1.0F, 0.6F);
        this.animator.rotate(this.RightShoulder, -1.5F, 0.0F, 0.75F);
        this.animator.rotate(this.RightForeArm, -1.0F, 0.0F, -0.5F);
        this.animator.rotate(this.LeftShoulder, -1.5F, 0.0F, -0.75F);
        this.animator.rotate(this.LeftForeArm, -1.0F, 0.0F, 0.5F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0F, 2.0F, -12.0F);
        this.animator.move(this.RightThigh, 0.0F, 2.0F, -13.0F);
        this.animator.move(this.LeftThigh, 0.0F, 2.0F, -11.0F);
        this.animator.rotate(this.RightThigh, -3.0F, 0.2F, 1.5F);
        this.animator.rotate(this.LeftThigh, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 0.0F, 0.0F, -0.25F);
        this.animator.rotate(this.BodyTop, 0.5F, 0.5F, -0.25F);
        this.animator.rotate(this.BodyMiddle, 0.5F, 0.5F, -0.25F);
        this.animator.rotate(this.BodyBottom, -1.0F, -1.0F, 0.75F);
        this.animator.rotate(this.RightShoulder, -1.5F, 0.0F, 0.75F);
        this.animator.rotate(this.RightForeArm, -1.0F, 0.0F, -0.5F);
        this.animator.rotate(this.LeftShoulder, -1.5F, 0.0F, -0.75F);
        this.animator.rotate(this.LeftForeArm, -1.0F, 0.0F, 0.5F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateMeteor() {
        this.animator.setAnim(2);
        this.animator.startPhase(30);
        this.animator.move(this.BodyBottom, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.RightThigh, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.LeftThigh, 0.0F, 1.0F, 5.0F);
        this.animator.rotate(this.RightThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -0.25F, 0.25F, 0.0F);
        this.animator.rotate(this.BodyMiddle, -0.25F, 0.25F, 0.0F);
        this.animator.rotate(this.BodyTop, -0.25F, 0.25F, 0.0F);
        this.animator.rotate(this.RightShoulder, -1.5F, 0.0F, 0.5F);
        this.animator.rotate(this.RightForeArm, -1.0F, 0.0F, -0.5F);
        this.animator.rotate(this.LeftShoulder, -1.5F, 0.0F, -0.5F);
        this.animator.rotate(this.LeftForeArm, -1.0F, 0.0F, 0.5F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0F, 1.0F, -8.0F);
        this.animator.move(this.RightThigh, 0.0F, 1.0F, -8.0F);
        this.animator.move(this.LeftThigh, 0.0F, 1.0F, -8.0F);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -0.5F, 0.5F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.25F, -0.25F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.25F, -0.25F, 0.0F);
        this.animator.rotate(this.RightShoulder, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftShoulder, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForeArm, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -1.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(40);
    }

    private void animateLightningBall() {
        this.animator.setAnim(4);
        this.animator.startPhase(30);
        this.animator.move(this.BodyBottom, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.RightThigh, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.LeftThigh, 0.0F, 1.0F, 5.0F);
        this.animator.rotate(this.RightThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -0.25F, 0.25F, 0.0F);
        this.animator.rotate(this.BodyMiddle, -0.25F, 0.25F, 0.0F);
        this.animator.rotate(this.BodyTop, -0.25F, 0.25F, 0.0F);
        this.animator.rotate(this.RightShoulder, -1.5F, 0.0F, 0.5F);
        this.animator.rotate(this.RightForeArm, -1.0F, 0.0F, -0.5F);
        this.animator.rotate(this.LeftShoulder, -1.5F, 0.0F, -0.5F);
        this.animator.rotate(this.LeftForeArm, -1.0F, 0.0F, 0.5F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0F, 1.0F, -8.0F);
        this.animator.move(this.RightThigh, 0.0F, 1.0F, -8.0F);
        this.animator.move(this.LeftThigh, 0.0F, 1.0F, -8.0F);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -0.5F, 0.5F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.25F, -0.25F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.25F, -0.25F, 0.0F);
        this.animator.rotate(this.RightShoulder, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftShoulder, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForeArm, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -1.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(40);
    }

    private void animateChainLightning() {
        this.animator.setAnim(3);
        this.animator.startPhase(30);
        this.animator.rotate(this.Mouth, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, -1.5F, 0.0F, 0.75F);
        this.animator.rotate(this.RightForeArm, -1.0F, 0.0F, -0.25F);
        this.animator.rotate(this.LeftShoulder, -1.5F, 0.0F, -0.75F);
        this.animator.rotate(this.LeftForeArm, -1.0F, 0.0F, 0.25F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(30);
        this.animator.startPhase(10);
        this.animator.rotate(this.Mouth, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, 0.0F, 0.0F, 0.5F);
        this.animator.rotate(this.LeftShoulder, 0.0F, 0.0F, -0.5F);
        this.animator.endPhase();
        this.animator.resetPhase(30);
    }

    private void animateDragonBall() {
        this.animator.setAnim(11);
        this.animator.startPhase(30);
        this.animator.move(this.BodyBottom, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.RightThigh, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.LeftThigh, 0.0F, 1.0F, 5.0F);
        this.animator.rotate(this.RightThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -0.25F, 0.25F, 0.0F);
        this.animator.rotate(this.BodyMiddle, -0.25F, 0.25F, 0.0F);
        this.animator.rotate(this.BodyTop, -0.25F, 0.25F, 0.0F);
        this.animator.rotate(this.RightShoulder, -1.5F, 0.0F, 0.5F);
        this.animator.rotate(this.RightForeArm, -1.0F, 0.0F, -0.5F);
        this.animator.rotate(this.LeftShoulder, -1.5F, 0.0F, -0.5F);
        this.animator.rotate(this.LeftForeArm, -1.0F, 0.0F, 0.5F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0F, 1.0F, -8.0F);
        this.animator.move(this.RightThigh, 0.0F, 1.0F, -8.0F);
        this.animator.move(this.LeftThigh, 0.0F, 1.0F, -8.0F);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -0.5F, 0.5F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.25F, -0.25F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.25F, -0.25F, 0.0F);
        this.animator.rotate(this.RightShoulder, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftShoulder, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForeArm, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -1.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(40);
    }

    private void animateLightning() {
        this.animator.setAnim(13);
        this.animator.startPhase(20);
        this.animator.move(this.BodyBottom, 0.0F, 1.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, 1.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, 0.8F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftShoulder, 0.8F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForeArm, -1.6F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -1.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.move(this.BodyBottom, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, -1.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, -2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForeArm, -1.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Mouth, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForeArm, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(20);
    }

    private void animateScream() {
        this.animator.setAnim(5);
        this.animator.startPhase(25);
        this.animator.move(this.BodyBottom, 0.0F, 2.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, 2.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 2.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, 0.8F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftShoulder, 0.8F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForeArm, -1.6F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -1.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(25);
        this.animator.move(this.BodyBottom, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.RightThigh, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.LeftThigh, 0.0F, 1.0F, 5.0F);
        this.animator.rotate(this.Head, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, 0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, 1.0F, -1.0F, 0.0F);
        this.animator.rotate(this.RightForeArm, -1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftShoulder, 1.0F, 1.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.25F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.startPhase(10);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.rotate(this.Head, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -1.5F, 0.0F, 0.5F);
        this.animator.rotate(this.BodyTop, 0.5F, 0.0F, 0.5F);
        this.animator.rotate(this.BodyMiddle, 0.5F, 0.0F, 0.5F);
        this.animator.rotate(this.BodyBottom, 0.5F, 0.0F, 1.5F);
        this.animator.rotate(this.RightShoulder, 0.0F, 0.0F, 1.0F);
        this.animator.rotate(this.LeftShoulder, 0.0F, 0.0F, -1.0F);
        this.animator.rotate(this.RightThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, -0.5F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(100);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.rotate(this.Head, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -1.5F, 0.0F, -0.5F);
        this.animator.rotate(this.BodyTop, 0.5F, 0.0F, -0.5F);
        this.animator.rotate(this.BodyMiddle, 0.5F, 0.0F, -0.5F);
        this.animator.rotate(this.BodyBottom, 0.5F, 0.0F, -1.5F);
        this.animator.rotate(this.RightShoulder, 0.0F, 0.0F, 1.0F);
        this.animator.rotate(this.LeftShoulder, 0.0F, 0.0F, -1.0F);
        this.animator.rotate(this.RightThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, -0.5F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(20);
    }

    private void animateSlam() {
        this.animator.setAnim(6);
        this.animator.startPhase(15);
        this.animator.move(this.BodyBottom, 0.0F, 1.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, 1.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 1.0F, 0.0F);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, 0.8F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftShoulder, 0.8F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForeArm, -1.6F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -1.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(15);
        this.animator.move(this.BodyBottom, 0.0F, -1.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, -1.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, -1.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -2.0F, 0.2F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.1F, 0.2F, 0.0F);
        this.animator.rotate(this.RightFemur, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.1F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 1.6F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, -0.8F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, -0.8F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, -4.0F, 0.0F, -0.25F);
        this.animator.rotate(this.LeftShoulder, -4.0F, 0.0F, 0.25F);
        this.animator.rotate(this.RightForeArm, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -1.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0F, 16.0F, 1.0F);
        this.animator.move(this.RightThigh, 0.0F, 16.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 16.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -2.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, 1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, -3.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftShoulder, -3.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForeArm, -0.75F, 0.0F, -0.25F);
        this.animator.rotate(this.LeftForeArm, -0.75F, 0.0F, 0.25F);
        this.animator.endPhase();
        this.animator.resetPhase(30);
    }

    private void animateStomp() {
        this.animator.setAnim(7);
        this.animator.startPhase(25);
        this.animator.move(this.BodyBottom, 0.0F, 2.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, 2.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 2.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, 0.8F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftShoulder, 0.8F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForeArm, -1.6F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -1.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(25);
        this.animator.move(this.BodyBottom, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, -2.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -2.0F, 0.2F, 0.75F);
        this.animator.rotate(this.LeftThigh, 0.0F, 0.2F, 0.0F);
        this.animator.rotate(this.RightFemur, 1.0F, 0.0F, -0.5F);
        this.animator.rotate(this.LeftFemur, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 1.0F, 0.0F, 0.5F);
        this.animator.rotate(this.BodyTop, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, 0.0F, 0.0F, 0.25F);
        this.animator.rotate(this.RightShoulder, -0.75F, 0.0F, 0.75F);
        this.animator.rotate(this.LeftShoulder, -0.75F, 0.0F, -0.75F);
        this.animator.rotate(this.RightForeArm, -0.3F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -0.3F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.move(this.BodyBottom, 0.0F, 4.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, 4.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 2.0F, 0.0F);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -0.5F, 0.5F, 0.0F);
        this.animator.rotate(this.LeftThigh, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.1F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -1.0F, 0.0F, 0.5F);
        this.animator.rotate(this.BodyTop, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, 0.0F, 0.0F, -0.4F);
        this.animator.rotate(this.RightShoulder, 0.5F, 0.0F, 0.25F);
        this.animator.rotate(this.LeftShoulder, 0.5F, 0.0F, -0.25F);
        this.animator.rotate(this.RightForeArm, -0.3F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -0.3F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(5);
        this.animator.startPhase(20);
        this.animator.move(this.BodyBottom, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, -2.0F, 0.0F);
        this.animator.move(this.Head, 0.0F, -2.0F, 0.0F);
        this.animator.rotate(this.RightThigh, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -2.0F, 0.0F, -0.75F);
        this.animator.rotate(this.RightFemur, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 1.0F, 0.0F, 0.5F);
        this.animator.rotate(this.Mouth, 1.0F, 0.0F, -0.5F);
        this.animator.rotate(this.BodyTop, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, 0.0F, 0.0F, -0.25F);
        this.animator.rotate(this.RightShoulder, 0.8F, 0.0F, 0.75F);
        this.animator.rotate(this.LeftShoulder, 0.8F, 0.0F, -0.75F);
        this.animator.rotate(this.RightForeArm, -0.8F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -0.8F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.move(this.BodyBottom, 0.0F, 4.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, 2.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 4.0F, 0.0F);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.rotate(this.RightThigh, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.5F, -0.5F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, -1.0F, 0.0F, 0.5F);
        this.animator.rotate(this.BodyTop, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, 0.0F, 0.0F, 0.4F);
        this.animator.rotate(this.RightShoulder, 0.75F, 0.0F, 0.25F);
        this.animator.rotate(this.LeftShoulder, 0.75F, 0.0F, -0.25F);
        this.animator.rotate(this.RightForeArm, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -0.75F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.resetPhase(20);
    }

    private void animateStunned() {
        this.animator.setAnim(8);
        this.animator.startPhase(10);
        this.animator.move(this.BodyBottom, 0.0F, 1.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, 1.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 1.0F, 0.0F);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, 0.8F, 0.5F, 0.5F);
        this.animator.rotate(this.LeftShoulder, 0.8F, -0.5F, -0.5F);
        this.animator.rotate(this.RightForeArm, -1.6F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -1.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.move(this.BodyBottom, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.RightThigh, 0.0F, 1.0F, 5.0F);
        this.animator.move(this.LeftThigh, 0.0F, 1.0F, 5.0F);
        this.animator.rotate(this.RightThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, -2.0F, 0.0F, 0.5F);
        this.animator.rotate(this.RightForeArm, -1.5F, 0.0F, -1.0F);
        this.animator.rotate(this.LeftShoulder, -2.0F, 0.0F, -0.5F);
        this.animator.rotate(this.LeftForeArm, -1.5F, 0.0F, 1.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(40);
        this.animator.startPhase(40);
        this.animator.move(this.BodyBottom, 0.0F, 19.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, 19.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 19.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, 0.9F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 2.2F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.6F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, -2.0F, 0.5F, -0.25F);
        this.animator.rotate(this.RightForeArm, -0.75F, -0.5F, 0.0F);
        this.animator.rotate(this.LeftShoulder, -2.0F, -0.5F, 0.25F);
        this.animator.rotate(this.LeftForeArm, -0.75F, 0.5F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(240);
        this.animator.startPhase(20);
        this.animator.move(this.BodyBottom, 0.0F, 14.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, 14.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 14.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 1.8F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.8F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, -2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForeArm, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftShoulder, -2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, -0.25F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(40);
    }

    private void animateSwat() {
        this.animator.setAnim(9);
        this.animator.startPhase(15);
        this.animator.move(this.BodyBottom, 0.0F, 4.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, 4.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 4.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, 0.125F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.125F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.125F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, 0.375F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, 1.0F, 1.0F, 1.5F);
        this.animator.rotate(this.LeftShoulder, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForeArm, -0.2F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftForeArm, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(25);
        this.animator.move(this.BodyBottom, 0.0F, 16.0F, 0.0F);
        this.animator.move(this.RightThigh, 0.0F, 16.0F, 0.0F);
        this.animator.move(this.LeftThigh, 0.0F, 16.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -1.0F, 0.5F, 0.0F);
        this.animator.rotate(this.LeftThigh, -1.0F, -0.5F, 0.0F);
        this.animator.rotate(this.RightFemur, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, 0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, -2.0F, 0.0F, -0.5F);
        this.animator.rotate(this.LeftShoulder, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForeArm, -0.25F, 0.0F, -1.0F);
        this.animator.rotate(this.LeftForeArm, -0.5F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(20);
    }

    private void animateDeath() {
        this.animator.setAnim(10);
        this.animator.startPhase(40);
        this.animator.move(this.BodyBottom, 0.0F, 4.0F, -6.0F);
        this.animator.move(this.RightThigh, 0.0F, 4.0F, -6.0F);
        this.animator.move(this.LeftThigh, 0.0F, 4.0F, -6.0F);
        this.animator.move(this.Head, 0.0F, -2.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.3F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.3F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, 0.3F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftShoulder, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForeArm, -0.5F, 0.0F, -0.5F);
        this.animator.rotate(this.LeftForeArm, -0.5F, 0.0F, -0.3F);
        this.animator.endPhase();
        this.animator.startPhase(40);
        this.animator.move(this.BodyBottom, 0.0F, 4.0F, -16.0F);
        this.animator.move(this.RightThigh, 0.0F, 4.0F, -16.0F);
        this.animator.move(this.LeftThigh, 0.0F, 4.0F, -16.0F);
        this.animator.move(this.Head, 0.0F, -5.0F, 0.0F);
        this.animator.rotate(this.RightThigh, 0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyTop, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyMiddle, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, 0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, -1.25F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftShoulder, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.RightForeArm, -0.5F, 0.0F, -0.75F);
        this.animator.rotate(this.LeftForeArm, -0.5F, 0.0F, -0.3F);
        this.animator.endPhase();
        this.animator.startPhase(80);
        this.animator.move(this.BodyBottom, 0.0F, 28.0F, 16.0F);
        this.animator.move(this.RightThigh, 0.0F, 28.0F, 16.0F);
        this.animator.move(this.LeftThigh, 0.0F, 28.0F, 16.0F);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -3.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftThigh, -3.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightFemur, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, -1.5F, 0.0F, 0.5F);
        this.animator.rotate(this.LeftShoulder, -1.5F, 0.0F, -0.5F);
        this.animator.rotate(this.RightForeArm, 0.0F, 0.0F, -0.25F);
        this.animator.rotate(this.LeftForeArm, 0.0F, 0.0F, 0.25F);
        this.animator.endPhase();
        this.animator.startPhase(80);
        this.animator.move(this.BodyBottom, 0.0F, 26.0F, 16.0F);
        this.animator.move(this.RightThigh, 0.0F, 28.0F, 16.0F);
        this.animator.move(this.LeftThigh, 0.0F, 28.0F, 16.0F);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -2.0F, 0.25F, 0.0F);
        this.animator.rotate(this.LeftThigh, -2.0F, -0.25F, 0.0F);
        this.animator.rotate(this.RightFemur, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, -1.55F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, 0.0F, 0.0F, 0.5F);
        this.animator.rotate(this.LeftShoulder, 0.0F, 0.0F, -0.5F);
        this.animator.rotate(this.RightForeArm, 0.0F, 0.0F, -0.25F);
        this.animator.rotate(this.LeftForeArm, 0.0F, 0.0F, 0.25F);
        this.animator.endPhase();
        this.animator.startPhase(200);
        this.animator.move(this.BodyBottom, 0.0F, 26.0F, 16.0F);
        this.animator.move(this.RightThigh, 0.0F, 28.0F, 16.0F);
        this.animator.move(this.LeftThigh, 0.0F, 28.0F, 16.0F);
        this.animator.move(this.Head, 0.0F, -7.0F, 0.0F);
        this.animator.rotate(this.RightThigh, -1.55F, 0.25F, 0.0F);
        this.animator.rotate(this.LeftThigh, -1.55F, -0.25F, 0.0F);
        this.animator.rotate(this.RightFemur, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.LeftFemur, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Mouth, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.BodyBottom, -1.55F, 0.0F, 0.0F);
        this.animator.rotate(this.RightShoulder, 0.0F, 0.0F, 0.5F);
        this.animator.rotate(this.LeftShoulder, 0.0F, 0.0F, -0.5F);
        this.animator.rotate(this.RightForeArm, 0.0F, 0.0F, -0.3F);
        this.animator.rotate(this.LeftForeArm, 0.0F, 0.0F, 0.3F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(1520);
        this.animator.resetPhase(0);
    }
}
