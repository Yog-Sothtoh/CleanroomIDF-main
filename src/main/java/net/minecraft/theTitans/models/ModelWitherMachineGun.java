//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWitherMachineGun extends ModelBase {
    public ModelRenderer pole;
    public ModelRenderer head2;
    public ModelRenderer support;
    public ModelRenderer base;
    public ModelRenderer head1;

    public ModelWitherMachineGun() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.head1 = new ModelRenderer(this, 32, 0);
        this.head1.func_78793_a(-10.0F, 14.0F, 0.0F);
        this.head1.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.base = new ModelRenderer(this, 0, 0);
        this.base.func_78793_a(0.0F, 26.0F, 0.0F);
        this.base.func_78790_a(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.head2 = new ModelRenderer(this, 32, 0);
        this.head2.func_78793_a(10.0F, 14.0F, 0.0F);
        this.head2.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.support = new ModelRenderer(this, 0, 16);
        this.support.func_78793_a(0.0F, 13.0F, 0.0F);
        this.support.func_78790_a(-10.0F, 0.0F, -1.5F, 20, 3, 3, 0.0F);
        this.pole = new ModelRenderer(this, 12, 22);
        this.pole.func_78793_a(0.0F, 16.0F, 0.0F);
        this.pole.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.head1.func_78785_a(f5);
        this.base.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.support.func_78785_a(f5);
        this.pole.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.head1.field_78795_f = f4 / (180F / (float)Math.PI);
        this.head2.field_78795_f = f4 / (180F / (float)Math.PI);
        this.head1.field_78796_g = f3 / (180F / (float)Math.PI);
        this.head2.field_78796_g = f3 / (180F / (float)Math.PI);
        this.support.field_78795_f = f4 / (180F / (float)Math.PI);
        this.pole.field_78796_g = f3 / (180F / (float)Math.PI) / 2.0F;
    }
}
