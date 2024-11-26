//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOptimaAxe extends ModelBase {
    public ModelRenderer Grip;
    public ModelRenderer Handle;
    public ModelRenderer Blade1;
    public ModelRenderer Blade2;

    public ModelOptimaAxe() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.Grip = new ModelRenderer(this, 0, 0);
        this.Grip.func_78793_a(0.0F, 24.0F, 0.0F);
        this.Grip.func_78790_a(-8.0F, -48.0F, -8.0F, 16, 48, 16, 0.0F);
        this.Handle = new ModelRenderer(this, 96, 0);
        this.Handle.func_78793_a(0.0F, -48.0F, 0.0F);
        this.Handle.func_78790_a(-4.0F, -120.0F, -4.0F, 8, 120, 8, 0.0F);
        this.Blade2 = new ModelRenderer(this, 0, 16);
        this.Blade2.field_78809_i = true;
        this.Blade2.func_78793_a(0.0F, -116.0F, 0.0F);
        this.Blade2.func_78790_a(0.0F, -32.0F, 4.0F, 0, 64, 48, 0.0F);
        this.setRotateAngle(this.Blade2, 0.0F, (float)Math.PI, 0.0F);
        this.Blade1 = new ModelRenderer(this, 0, 16);
        this.Blade1.func_78793_a(0.0F, -116.0F, 0.0F);
        this.Blade1.func_78790_a(0.0F, -32.0F, 4.0F, 0, 64, 48, 0.0F);
        this.Grip.func_78792_a(this.Handle);
        this.Handle.func_78792_a(this.Blade2);
        this.Handle.func_78792_a(this.Blade1);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Grip.func_78785_a(f5);
    }

    public void render(float f5) {
        this.Grip.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
