//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import thehippomaster.AnimationAPI.client.Animator;

public class ModelOmegafish extends ModelBase {
    public ModelRenderer BodyCenter;
    public ModelRenderer Tail1;
    public ModelRenderer Fuzz1;
    public ModelRenderer FrontBody;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer Fuzz3;
    public ModelRenderer TailTip;
    public ModelRenderer Head;
    public ModelRenderer Fuzz2;
    private Animator animator;

    public ModelOmegafish() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.TailTip = new ModelRenderer(this, 13, 4);
        this.TailTip.func_78793_a(0.0F, 0.0F, 2.0F);
        this.TailTip.func_78790_a(-0.5F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
        this.Fuzz1 = new ModelRenderer(this, 20, 0);
        this.Fuzz1.func_78793_a(0.0F, 2.0F, 0.0F);
        this.Fuzz1.func_78790_a(-5.0F, -8.0F, -1.5F, 10, 8, 3, 0.0F);
        this.Tail3 = new ModelRenderer(this, 11, 0);
        this.Tail3.func_78793_a(0.0F, 0.5F, 3.0F);
        this.Tail3.func_78790_a(-1.0F, -0.5F, 0.0F, 2, 1, 2, 0.0F);
        this.Fuzz3 = new ModelRenderer(this, 20, 11);
        this.Fuzz3.func_78793_a(0.0F, 1.0F, 1.5F);
        this.Fuzz3.func_78790_a(-3.0F, -4.0F, -1.5F, 6, 4, 3, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.func_78793_a(0.0F, 0.5F, -2.0F);
        this.Head.func_78790_a(-1.5F, -1.0F, -2.0F, 3, 2, 2, 0.0F);
        this.BodyCenter = new ModelRenderer(this, 0, 9);
        this.BodyCenter.func_78793_a(0.0F, 22.0F, 1.0F);
        this.BodyCenter.func_78790_a(-3.0F, -2.0F, -1.5F, 6, 4, 3, 0.0F);
        this.FrontBody = new ModelRenderer(this, 0, 4);
        this.FrontBody.func_78793_a(0.0F, 0.5F, -1.5F);
        this.FrontBody.func_78790_a(-2.0F, -1.5F, -2.0F, 4, 3, 2, 0.0F);
        this.Tail2 = new ModelRenderer(this, 0, 22);
        this.Tail2.func_78793_a(0.0F, 0.5F, 3.0F);
        this.Tail2.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
        this.Tail1 = new ModelRenderer(this, 0, 16);
        this.Tail1.func_78793_a(0.0F, 0.5F, 1.5F);
        this.Tail1.func_78790_a(-1.5F, -1.5F, 0.0F, 3, 3, 3, 0.0F);
        this.Fuzz2 = new ModelRenderer(this, 20, 18);
        this.Fuzz2.func_78793_a(0.0F, 1.5F, -0.5F);
        this.Fuzz2.func_78790_a(-3.0F, -5.0F, -1.5F, 6, 5, 2, 0.0F);
        this.Tail3.func_78792_a(this.TailTip);
        this.BodyCenter.func_78792_a(this.Fuzz1);
        this.Tail2.func_78792_a(this.Tail3);
        this.Tail2.func_78792_a(this.Fuzz3);
        this.FrontBody.func_78792_a(this.Head);
        this.BodyCenter.func_78792_a(this.FrontBody);
        this.Tail1.func_78792_a(this.Tail2);
        this.BodyCenter.func_78792_a(this.Tail1);
        this.FrontBody.func_78792_a(this.Fuzz2);
        this.animator = new Animator(this);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animate((IAnimatedEntity)entity, f, f1, f2, f3, f4, f5);
        this.BodyCenter.func_78785_a(f5);
    }

    public void setAngles() {
        this.BodyCenter.field_78797_d = 22.0F;
        this.BodyCenter.field_78800_c = 0.0F;
        this.BodyCenter.field_78798_e = 1.0F;
        this.FrontBody.field_78797_d = 0.5F;
        this.FrontBody.field_78800_c = 0.0F;
        this.FrontBody.field_78798_e = -1.5F;
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animator.update(entity);
        this.setAngles();
        EntitySilverfishTitan entitytitan = (EntitySilverfishTitan)entity;
        if (entitytitan.deathTicks <= 0) {
            if (entitytitan.getAnimID() == 0) {
                this.FrontBody.field_78795_f = (-0.01F + 0.01F * MathHelper.func_76134_b(f2 * 0.1F)) * (float)Math.PI;
                this.Head.field_78795_f = (0.01F + -0.01F * MathHelper.func_76134_b(f2 * 0.1F)) * (float)Math.PI;
                this.Head.field_78796_g = -(MathHelper.func_76134_b(f * 0.25F) * 0.25F * f1);
                this.FrontBody.field_78796_g = MathHelper.func_76134_b(f * 0.25F - 0.5F) * 0.25F * f1;
                this.BodyCenter.field_78796_g = MathHelper.func_76134_b(f * 0.25F - 1.0F) * 0.25F * f1;
                this.Tail1.field_78796_g = -(f3 * (float)Math.PI / 180.0F / 4.0F) + 0.01F * MathHelper.func_76134_b(f2 * 0.1F - 1.0F) * (float)Math.PI + MathHelper.func_76134_b(f * 0.5F - 1.5F) * 0.25F * f1;
                this.Tail2.field_78796_g = -(f3 * (float)Math.PI / 180.0F / 4.0F) + 0.01F * MathHelper.func_76134_b(f2 * 0.1F - 1.5F) * (float)Math.PI + MathHelper.func_76134_b(f * 0.5F - 2.0F) * 0.25F * f1;
                this.Tail3.field_78796_g = -(f3 * (float)Math.PI / 180.0F / 4.0F) + 0.01F * MathHelper.func_76134_b(f2 * 0.1F - 2.0F) * (float)Math.PI + MathHelper.func_76134_b(f * 0.5F - 2.5F) * 0.25F * f1;
                this.TailTip.field_78796_g = -(f3 * (float)Math.PI / 180.0F / 4.0F) + 0.01F * MathHelper.func_76134_b(f2 * 0.1F - 2.5F) * (float)Math.PI + MathHelper.func_76134_b(f * 0.5F - 3.0F) * 0.25F * f1;
            }

            if (!entitytitan.field_70122_E && !this.field_78093_q && entitytitan.getAnimID() != 2) {
                this.Head.field_78796_g = -(MathHelper.func_76134_b(f * 0.35F) * 0.5F * f1);
                this.FrontBody.field_78796_g = MathHelper.func_76134_b(f * 0.35F - 0.5F) * 0.25F * f1;
                this.BodyCenter.field_78796_g = MathHelper.func_76134_b(f * 0.35F - 1.0F) * 0.25F * f1;
                this.Tail1.field_78796_g = MathHelper.func_76134_b(f * 0.35F - 1.5F) * 0.5F * f1;
                this.Tail2.field_78796_g = MathHelper.func_76134_b(f * 0.35F - 2.0F) * 0.5F * f1;
                this.Tail3.field_78796_g = MathHelper.func_76134_b(f * 0.35F - 2.5F) * 0.5F * f1;
                this.TailTip.field_78796_g = MathHelper.func_76134_b(f * 0.35F - 3.0F) * 0.5F * f1;
                ModelRenderer var10000 = this.Tail1;
                var10000.field_78795_f += MathHelper.func_76134_b(f * 0.35F - 1.5F) * 0.1F * f1 - 0.25F + entitytitan.field_70721_aZ / 4.0F;
                var10000 = this.Tail2;
                var10000.field_78795_f += MathHelper.func_76134_b(f * 0.35F - 2.0F) * 0.1F * f1 - 0.25F + entitytitan.field_70721_aZ / 4.0F;
                var10000 = this.Tail3;
                var10000.field_78795_f += MathHelper.func_76134_b(f * 0.35F - 2.5F) * 0.1F * f1 - 0.25F + entitytitan.field_70721_aZ / 4.0F;
                var10000 = this.TailTip;
                var10000.field_78795_f += MathHelper.func_76134_b(f * 0.35F - 3.0F) * 0.1F * f1 - 0.25F + entitytitan.field_70721_aZ / 4.0F;
            }

            float faceYaw = f3 * (float)Math.PI / 180.0F;
            float facePitch = f4 * (float)Math.PI / 180.0F;
            ModelRenderer var14 = this.Head;
            var14.field_78795_f += facePitch * 0.45F;
            var14 = this.Head;
            var14.field_78796_g += faceYaw * 0.45F;
            var14 = this.FrontBody;
            var14.field_78795_f += facePitch * 0.45F;
            var14 = this.FrontBody;
            var14.field_78796_g += faceYaw * 0.45F;
            if (entitytitan.getAnimID() == 11) {
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

            this.animateBodySlam();
            this.animateIncapacitated();
            this.animateLightningShot();
            this.animateTailSwipeL();
            this.animateTailSwipeR();
            this.animateHeadButt();
            this.animateTailSmash();
            this.animateUnburrow();
            this.animateBurrow();
            this.animateBirth();
        } else {
            this.animateDeath();
        }

    }

    private void animateAntiTitanAttack1() {
        this.animator.setAnim(11);
        this.animator.startPhase(10);
        this.animator.move(this.BodyCenter, 0.0F, 0.0F, 6.0F);
        this.animator.rotate(this.Tail1, -0.05F, -0.6F, 0.0F);
        this.animator.rotate(this.Tail2, -0.05F, -0.6F, 0.0F);
        this.animator.rotate(this.Tail3, -0.05F, -0.6F, 0.0F);
        this.animator.rotate(this.TailTip, -0.05F, -0.6F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, -0.75F, 0.0F);
        this.animator.rotate(this.Head, 0.0F, 0.15F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.15F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyCenter, 0.0F, 0.0F, -12.0F);
        this.animator.rotate(this.Tail1, 1.0F, 0.6F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, 0.6F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, 0.6F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.6F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, 4.0F, 0.0F);
        this.animator.rotate(this.Head, 0.0F, -0.15F, -0.2F);
        this.animator.rotate(this.FrontBody, 0.0F, -0.15F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.BodyCenter, 0.0F, 6.3F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateAntiTitanAttack2() {
        this.animator.setAnim(11);
        this.animator.startPhase(10);
        this.animator.move(this.BodyCenter, 0.0F, 0.0F, 6.0F);
        this.animator.rotate(this.Tail1, -0.05F, 0.6F, 0.0F);
        this.animator.rotate(this.Tail2, -0.05F, 0.6F, 0.0F);
        this.animator.rotate(this.Tail3, -0.05F, 0.6F, 0.0F);
        this.animator.rotate(this.TailTip, -0.05F, 0.6F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, 0.75F, 0.0F);
        this.animator.rotate(this.Head, 0.0F, -0.15F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, -0.15F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyCenter, 0.0F, 0.0F, -12.0F);
        this.animator.rotate(this.Tail1, 1.0F, -0.6F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, -0.6F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, -0.6F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, -0.6F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, -4.0F, 0.0F);
        this.animator.rotate(this.Head, 0.0F, 0.15F, 0.2F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.15F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.BodyCenter, 0.0F, -6.3F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateAntiTitanAttack3() {
        this.animator.setAnim(11);
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.4F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.4F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, 0.4F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.4F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, 1.0F, 0.0F, -0.3F);
        this.animator.rotate(this.FrontBody, 1.0F, 0.0F, -0.5F);
        this.animator.rotate(this.Tail1, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 2.0F, 0.0F, -1.0F);
        this.animator.move(this.BodyCenter, 0.0F, -8.0F, -16.0F);
        this.animator.endPhase();
        this.animator.resetPhase(10);
    }

    private void animateAntiTitanAttack4() {
        this.animator.setAnim(11);
        this.animator.startPhase(10);
        this.animator.rotate(this.Tail1, 0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, -0.6F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.8F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.move(this.BodyCenter, 0.0F, -8.0F, -16.0F);
        this.animator.rotate(this.Tail1, -0.5F, 0.2F, 0.0F);
        this.animator.rotate(this.Tail2, -0.5F, 0.2F, 0.0F);
        this.animator.rotate(this.Tail3, -0.5F, 0.2F, 0.0F);
        this.animator.rotate(this.TailTip, -0.5F, 0.2F, 0.0F);
        this.animator.rotate(this.BodyCenter, 1.5F, -4.0F, 0.0F);
        this.animator.rotate(this.Head, 0.0F, 0.15F, 0.2F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.15F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.BodyCenter, 6.8F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateBurrow() {
        this.animator.setAnim(1);
        this.animator.startPhase(0);
        this.animator.move(this.BodyCenter, 0.0F, -8.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, -2.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, -8.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, -0.4F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, -0.3F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.3F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, -0.4F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, -0.4F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -0.4F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, -0.4F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -0.4F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, -28.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 1.6F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, -6.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Head, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, -0.4F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, -0.3F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, -0.3F, 0.0F);
        this.animator.rotate(this.BodyCenter, 1.6F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, -2.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Head, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.0F, 0.5F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, 0.4F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, 0.3F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.3F, 0.0F);
        this.animator.rotate(this.BodyCenter, 1.6F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 2.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Head, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, -0.4F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, -0.3F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, -0.3F, 0.0F);
        this.animator.rotate(this.BodyCenter, 1.6F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 6.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Head, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.0F, 0.5F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, 0.4F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, 0.3F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.3F, 0.0F);
        this.animator.rotate(this.BodyCenter, 1.6F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 10.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateUnburrow() {
        this.animator.setAnim(2);
        this.animator.startPhase(0);
        this.animator.rotate(this.Head, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 8.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, -0.4F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, -0.3F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.3F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(10);
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -0.4F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, -24.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.BodyCenter, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.5F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(20);
    }

    private void animateTailSmash() {
        this.animator.setAnim(3);
        this.animator.startPhase(30);
        this.animator.rotate(this.Tail1, -0.05F, -0.5F, 0.0F);
        this.animator.rotate(this.Tail2, -0.05F, -0.5F, 0.0F);
        this.animator.rotate(this.Tail3, -0.05F, -0.5F, 0.0F);
        this.animator.rotate(this.TailTip, -0.05F, -0.5F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, -0.75F, 0.0F);
        this.animator.rotate(this.Head, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.25F, 0.75F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Tail1, 0.9F, -0.5F, 0.0F);
        this.animator.rotate(this.Tail2, 0.7F, -0.5F, 0.0F);
        this.animator.rotate(this.Tail3, 0.6F, -0.5F, 0.0F);
        this.animator.rotate(this.TailTip, 0.6F, -0.5F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, -0.8F, 0.0F);
        this.animator.rotate(this.Head, 0.4F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, -0.4F, 0.8F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Tail1, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, -0.75F, 0.0F);
        this.animator.rotate(this.Head, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.8F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(20);
    }

    private void animateHeadButt() {
        this.animator.setAnim(4);
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, -2.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 0.0F, 2.0F);
        this.animator.rotate(this.Tail1, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, -0.4F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, -0.3F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.3F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Head, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 1.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 0.0F, -4.0F);
        this.animator.rotate(this.Tail1, 0.0F, 0.75F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, 0.6F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, 0.5F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.5F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(15);
        this.animator.rotate(this.Head, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(0);
    }

    private void animateTailSwipeR() {
        this.animator.setAnim(5);
        this.animator.startPhase(20);
        this.animator.rotate(this.Tail1, -0.05F, -0.5F, 0.0F);
        this.animator.rotate(this.Tail2, -0.05F, -0.4F, 0.0F);
        this.animator.rotate(this.Tail3, -0.05F, -0.3F, 0.0F);
        this.animator.rotate(this.TailTip, -0.05F, -0.3F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.Head, 0.0F, 0.15F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.15F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Tail1, 0.0F, 0.5F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, 0.4F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, 0.3F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.3F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, 3.0F, 0.0F);
        this.animator.rotate(this.Head, 0.0F, -0.15F, -0.2F);
        this.animator.rotate(this.FrontBody, 0.0F, -0.15F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(30);
    }

    private void animateTailSwipeL() {
        this.animator.setAnim(6);
        this.animator.startPhase(20);
        this.animator.rotate(this.Tail1, -0.05F, 0.5F, 0.0F);
        this.animator.rotate(this.Tail2, -0.05F, 0.4F, 0.0F);
        this.animator.rotate(this.Tail3, -0.05F, 0.3F, 0.0F);
        this.animator.rotate(this.TailTip, -0.05F, 0.3F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, 0.5F, 0.0F);
        this.animator.rotate(this.Head, 0.0F, -0.15F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, -0.15F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Tail1, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, -0.4F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, -0.3F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, -0.3F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, -3.0F, 0.0F);
        this.animator.rotate(this.Head, 0.0F, 0.15F, -0.2F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.15F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(30);
    }

    private void animateLightningShot() {
        this.animator.setAnim(7);
        this.animator.startPhase(20);
        this.animator.rotate(this.Tail1, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.25F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Tail1, 0.2F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.4F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.1F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Tail1, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.25F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(25);
    }

    private void animateIncapacitated() {
        this.animator.setAnim(8);
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.5F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -0.7F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.7F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, 0.0F, -1.25F);
        this.animator.endPhase();
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, 0.5F, 0.5F, -0.3F);
        this.animator.rotate(this.FrontBody, 1.0F, 0.0F, -0.3F);
        this.animator.rotate(this.BodyCenter, 0.0F, 0.0F, -1.25F);
        this.animator.rotate(this.Tail1, 0.1F, -0.1F, 0.1F);
        this.animator.rotate(this.Tail2, 0.0F, -0.2F, -0.2F);
        this.animator.rotate(this.Tail3, 0.0F, 0.1F, 0.2F);
        this.animator.rotate(this.TailTip, 0.0F, 0.2F, 0.3F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(300);
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 3.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.3F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.3F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.3F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.3F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, 0.0F, 0.5F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, 0.0F, -0.5F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(30);
    }

    private void animateBodySlam() {
        this.animator.setAnim(9);
        this.animator.startPhase(30);
        this.animator.rotate(this.Tail1, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, -0.6F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.6F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Tail1, 0.5F, -0.25F, 0.0F);
        this.animator.rotate(this.Tail2, 0.5F, -0.25F, 0.0F);
        this.animator.rotate(this.Tail3, 0.5F, -0.25F, 0.0F);
        this.animator.rotate(this.TailTip, 0.5F, -0.25F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Tail1, 0.5F, 0.25F, 0.0F);
        this.animator.rotate(this.Tail2, 0.5F, 0.25F, 0.0F);
        this.animator.rotate(this.Tail3, 0.5F, 0.25F, 0.0F);
        this.animator.rotate(this.TailTip, 0.5F, 0.25F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Tail1, 0.5F, -0.25F, 0.0F);
        this.animator.rotate(this.Tail2, 0.5F, -0.25F, 0.0F);
        this.animator.rotate(this.Tail3, 0.5F, -0.25F, 0.0F);
        this.animator.rotate(this.TailTip, 0.5F, -0.25F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(5);
        this.animator.rotate(this.Tail1, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.5F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(30);
        this.animator.rotate(this.Tail1, 0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Head, -0.6F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.8F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(60);
        this.animator.rotate(this.Head, 1.0F, 0.0F, -0.3F);
        this.animator.rotate(this.FrontBody, 1.0F, 0.0F, -0.5F);
        this.animator.rotate(this.Tail1, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -0.8F, 0.0F, -1.0F);
        this.animator.move(this.BodyCenter, 0.0F, 1.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(140);
        this.animator.rotate(this.Head, 1.5F, 0.0F, -0.5F);
        this.animator.rotate(this.FrontBody, 1.5F, 0.0F, -0.75F);
        this.animator.rotate(this.Tail1, -1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, -1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, -1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -2.0F, 0.0F, -1.0F);
        this.animator.move(this.BodyCenter, 0.0F, 1.0F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(40);
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, 1.0F, 0.0F, -0.3F);
        this.animator.rotate(this.FrontBody, 1.0F, 0.0F, -0.75F);
        this.animator.rotate(this.Tail1, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 1.0F, 0.0F, -1.0F);
        this.animator.move(this.BodyCenter, 0.0F, 1.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, 1.0F, 0.0F, -0.3F);
        this.animator.rotate(this.FrontBody, 1.0F, 0.0F, -0.75F);
        this.animator.rotate(this.Tail1, -0.75F, 1.0F, 0.0F);
        this.animator.rotate(this.Tail2, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 1.0F, 0.0F, -1.0F);
        this.animator.move(this.BodyCenter, 0.0F, 1.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(40);
        this.animator.rotate(this.Head, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(30);
    }

    private void animateDeath() {
        this.animator.setAnim(10);
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, -1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.5F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -0.7F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -0.25F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -3.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, -12.0F, 0.0F);
        this.animator.rotate(this.Tail1, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, -0.5F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(30);
        this.animator.rotate(this.Head, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -3.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.Tail1, -0.2F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, -0.2F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -0.2F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, -0.2F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -3.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.2F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, -0.1F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -0.1F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(20);
        this.animator.startPhase(40);
        this.animator.rotate(this.Head, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -3.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.Tail1, -0.6F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, -0.3F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -0.3F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, -0.3F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, 1.0F, 0.0F, 0.4F);
        this.animator.rotate(this.FrontBody, 1.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -3.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.Tail1, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.3F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, 0.3F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.3F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, 1.0F, 0.0F, 0.4F);
        this.animator.rotate(this.FrontBody, 2.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -3.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.Tail1, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.5F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(10);
        this.animator.rotate(this.Head, 1.0F, 0.0F, 0.4F);
        this.animator.rotate(this.FrontBody, 0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -3.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.Tail1, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -0.5F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, -0.5F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, -0.6F, 0.0F, 0.5F);
        this.animator.rotate(this.FrontBody, -0.5F, 0.0F, 0.3F);
        this.animator.rotate(this.BodyCenter, -3.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 1.0F, 0.0F);
        this.animator.rotate(this.Tail1, 0.2F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, -0.1F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -0.1F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(1760);
        this.animator.resetPhase(0);
    }

    private void animateBirth() {
        this.animator.setAnim(13);
        this.animator.startPhase(0);
        this.animator.rotate(this.Head, 1.5F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 1.25F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail1, -1.25F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, -1.25F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -1.25F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, -1.25F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -2.0F, 0.0F, -1.5F);
        this.animator.move(this.BodyCenter, 0.0F, 1.0F, 0.0F);
        this.animator.endPhase();
        this.animator.setStationaryPhase(60);
        this.animator.startPhase(40);
        this.animator.rotate(this.Head, 1.25F, 0.0F, -0.5F);
        this.animator.rotate(this.FrontBody, 1.25F, 0.0F, -0.5F);
        this.animator.rotate(this.Tail1, -1.25F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, -1.25F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -1.25F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, -1.25F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, -2.0F, 0.0F, -1.5F);
        this.animator.move(this.BodyCenter, 0.0F, 1.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(40);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.3F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.0F, 0.75F);
        this.animator.rotate(this.Tail1, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail2, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 1.0F, 0.0F, -1.0F);
        this.animator.move(this.BodyCenter, 0.0F, 1.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(20);
        this.animator.rotate(this.Head, -1.0F, 0.0F, 0.3F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.0F, 0.75F);
        this.animator.rotate(this.Tail1, -0.75F, 1.0F, 0.0F);
        this.animator.rotate(this.Tail2, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.Tail3, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.TailTip, -0.75F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 1.0F, 0.0F, -1.0F);
        this.animator.move(this.BodyCenter, 0.0F, 1.0F, 0.0F);
        this.animator.endPhase();
        this.animator.startPhase(40);
        this.animator.rotate(this.Head, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.FrontBody, 0.0F, 0.0F, 0.0F);
        this.animator.rotate(this.BodyCenter, 0.0F, 0.0F, 0.0F);
        this.animator.move(this.BodyCenter, 0.0F, 0.0F, 0.0F);
        this.animator.endPhase();
        this.animator.resetPhase(40);
    }
}
