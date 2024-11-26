//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWitherTurret extends ModelBase {
    private ModelRenderer Pole1;
    private ModelRenderer Pole2;
    private ModelRenderer Head;

    public ModelWitherTurret(float f) {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Pole1 = new ModelRenderer(this, 0, 22);
        this.Pole1.func_78790_a(-1.5F, -10.0F, -1.5F, 3, 10, 3, f);
        this.Pole1.func_78793_a(0.0F, 24.0F, 0.0F);
        this.Pole2 = new ModelRenderer(this, 0, 22);
        this.Pole2.func_78790_a(-1.5F, -10.0F, -1.5F, 3, 10, 3, f);
        this.Pole2.func_78793_a(0.0F, 14.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.func_78790_a(-4.0F, -4.0F, -4.0F, 8, 8, 8, f);
        this.Head.func_78793_a(0.0F, 2.0F, 0.0F);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.Pole1.func_78785_a(f5);
        this.Pole2.func_78785_a(f5);
        this.Head.func_78785_a(f5);
    }

    public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.Head.field_78796_g = f3 / (180F / (float)Math.PI);
        this.Head.field_78795_f = f4 / (180F / (float)Math.PI);
    }
}
