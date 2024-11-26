//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelUltimaBlade extends ModelBase {
    public ModelRenderer Handle;
    public ModelRenderer Guard;
    public ModelRenderer BladeLower;
    public ModelRenderer BladeTip;

    public ModelUltimaBlade() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.BladeTip = new ModelRenderer(this, 16, 48);
        this.BladeTip.func_78793_a(0.0F, -72.0F, 0.0F);
        this.BladeTip.func_78790_a(0.0F, -72.0F, -4.0F, 0, 72, 8, 0.0F);
        this.setRotateAngle(this.BladeTip, -0.017453292F, 0.0F, 0.0F);
        this.Guard = new ModelRenderer(this, 48, 0);
        this.Guard.func_78793_a(0.0F, -48.0F, 0.0F);
        this.Guard.func_78790_a(-10.0F, -2.0F, -10.0F, 20, 2, 20, 0.0F);
        this.Handle = new ModelRenderer(this, 0, 0);
        this.Handle.func_78793_a(0.0F, 24.0F, 0.0F);
        this.Handle.func_78790_a(-4.0F, -48.0F, -4.0F, 8, 48, 8, 0.0F);
        this.BladeLower = new ModelRenderer(this, 0, 48);
        this.BladeLower.func_78793_a(0.0F, 0.0F, 0.0F);
        this.BladeLower.func_78790_a(0.0F, -72.0F, -4.0F, 0, 72, 8, 0.0F);
        this.BladeLower.func_78792_a(this.BladeTip);
        this.Handle.func_78792_a(this.Guard);
        this.Guard.func_78792_a(this.BladeLower);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Handle.func_78785_a(f5);
    }

    public void render(float f5) {
        this.Handle.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
