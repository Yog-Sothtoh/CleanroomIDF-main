//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWitherMortar extends ModelBase {
    public ModelRenderer support;
    public ModelRenderer Head;
    public ModelRenderer backTripodLeg;
    public ModelRenderer rightFrontTripodLeg;
    public ModelRenderer leftFrontTripodLeg;
    public ModelRenderer backTripodLegTip;
    public ModelRenderer handle;

    public ModelWitherMortar() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.handle = new ModelRenderer(this, 24, 22);
        this.handle.func_78793_a(0.0F, 12.0F, 0.0F);
        this.handle.func_78790_a(-5.5F, -1.0F, -1.0F, 11, 2, 2, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.func_78793_a(0.0F, 4.0F, 0.0F);
        this.Head.func_78790_a(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.backTripodLeg = new ModelRenderer(this, 0, 22);
        this.backTripodLeg.func_78793_a(0.0F, 16.0F, 0.0F);
        this.backTripodLeg.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
        this.setRotateAngle(this.backTripodLeg, 1.3089969F, 0.0F, 0.0F);
        this.support = new ModelRenderer(this, 0, 22);
        this.support.func_78793_a(0.0F, 8.0F, 0.0F);
        this.support.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 10, 3, 0.0F);
        this.backTripodLegTip = new ModelRenderer(this, 12, 22);
        this.backTripodLegTip.func_78793_a(0.0F, 18.0F, 9.0F);
        this.backTripodLegTip.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
        this.rightFrontTripodLeg = new ModelRenderer(this, 24, 22);
        this.rightFrontTripodLeg.field_78809_i = true;
        this.rightFrontTripodLeg.func_78793_a(0.0F, 16.0F, 0.0F);
        this.rightFrontTripodLeg.func_78790_a(0.0F, -1.0F, -1.0F, 11, 2, 2, 0.0F);
        this.setRotateAngle(this.rightFrontTripodLeg, -0.61086524F, 2.6179938F, -0.87266463F);
        this.leftFrontTripodLeg = new ModelRenderer(this, 24, 22);
        this.leftFrontTripodLeg.func_78793_a(0.0F, 16.0F, 0.0F);
        this.leftFrontTripodLeg.func_78790_a(-11.0F, -1.0F, -1.0F, 11, 2, 2, 0.0F);
        this.setRotateAngle(this.leftFrontTripodLeg, -0.61086524F, -2.6179938F, 0.87266463F);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.handle.func_78785_a(f5);
        this.Head.func_78785_a(f5);
        this.backTripodLeg.func_78785_a(f5);
        this.support.func_78785_a(f5);
        this.backTripodLegTip.func_78785_a(f5);
        this.rightFrontTripodLeg.func_78785_a(f5);
        this.leftFrontTripodLeg.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.Head.field_78796_g = f3 / (180F / (float)Math.PI);
        this.Head.field_78795_f = f4 / (180F / (float)Math.PI);
    }
}
