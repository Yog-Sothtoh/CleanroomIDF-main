//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGhastTitan extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer tentacle1;
    public ModelRenderer tentacle2;
    public ModelRenderer tentacle3;
    public ModelRenderer tentacle4;
    public ModelRenderer tentacle5;
    public ModelRenderer tentacle6;
    public ModelRenderer tentacle7;
    public ModelRenderer tentacle8;
    public ModelRenderer tentacle9;
    public ModelRenderer tentacle11;
    public ModelRenderer tentacle111;
    public ModelRenderer tentacle22;
    public ModelRenderer tentacle222;
    public ModelRenderer tentacle2222;
    public ModelRenderer tentacle33;
    public ModelRenderer tentacle333;
    public ModelRenderer tentacle44;
    public ModelRenderer tentacle444;
    public ModelRenderer tentacle55;
    public ModelRenderer tentacle555;
    public ModelRenderer tentacle66;
    public ModelRenderer tentacle666;
    public ModelRenderer tentacle77;
    public ModelRenderer tentacle777;
    public ModelRenderer tentacle7777;
    public ModelRenderer tentacle88;
    public ModelRenderer tentacle888;
    public ModelRenderer tentacle99;
    public ModelRenderer tentacle999;
    public ModelRenderer tentacle9999;

    public ModelGhastTitan() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.tentacle55 = new ModelRenderer(this, 0, 3);
        this.tentacle55.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle55.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle666 = new ModelRenderer(this, 0, 6);
        this.tentacle666.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle666.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.tentacle2222 = new ModelRenderer(this, 0, 10);
        this.tentacle2222.func_78793_a(0.0F, 4.0F, 0.0F);
        this.tentacle2222.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.tentacle111 = new ModelRenderer(this, 0, 6);
        this.tentacle111.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle111.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.tentacle9999 = new ModelRenderer(this, 0, 10);
        this.tentacle9999.func_78793_a(0.0F, 4.0F, 0.0F);
        this.tentacle9999.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.tentacle4 = new ModelRenderer(this, 0, 0);
        this.tentacle4.func_78793_a(-5.0F, 7.0F, 0.0F);
        this.tentacle4.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle7777 = new ModelRenderer(this, 0, 10);
        this.tentacle7777.func_78793_a(0.0F, 4.0F, 0.0F);
        this.tentacle7777.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.tentacle333 = new ModelRenderer(this, 0, 6);
        this.tentacle333.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle333.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle77 = new ModelRenderer(this, 0, 3);
        this.tentacle77.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle77.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle66 = new ModelRenderer(this, 0, 3);
        this.tentacle66.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle66.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle555 = new ModelRenderer(this, 0, 6);
        this.tentacle555.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle555.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.tentacle88 = new ModelRenderer(this, 0, 3);
        this.tentacle88.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle88.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle6 = new ModelRenderer(this, 0, 0);
        this.tentacle6.func_78793_a(5.0F, 7.0F, 0.0F);
        this.tentacle6.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle1 = new ModelRenderer(this, 0, 0);
        this.tentacle1.func_78793_a(5.0F, 7.0F, -5.0F);
        this.tentacle1.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle11 = new ModelRenderer(this, 0, 3);
        this.tentacle11.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle11.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle444 = new ModelRenderer(this, 0, 6);
        this.tentacle444.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle444.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.func_78793_a(0.0F, 16.0F, 0.0F);
        this.body.func_78790_a(-8.0F, -8.0F, -8.0F, 16, 16, 16, 0.0F);
        this.tentacle777 = new ModelRenderer(this, 0, 6);
        this.tentacle777.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle777.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.tentacle7 = new ModelRenderer(this, 0, 0);
        this.tentacle7.func_78793_a(5.0F, 7.0F, 5.0F);
        this.tentacle7.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle8 = new ModelRenderer(this, 0, 0);
        this.tentacle8.func_78793_a(0.0F, 7.0F, 5.0F);
        this.tentacle8.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle888 = new ModelRenderer(this, 0, 6);
        this.tentacle888.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle888.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.tentacle222 = new ModelRenderer(this, 0, 6);
        this.tentacle222.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle222.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.tentacle33 = new ModelRenderer(this, 0, 3);
        this.tentacle33.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle33.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle2 = new ModelRenderer(this, 0, 0);
        this.tentacle2.func_78793_a(0.0F, 7.0F, -5.0F);
        this.tentacle2.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle3 = new ModelRenderer(this, 0, 0);
        this.tentacle3.func_78793_a(-5.0F, 7.0F, -5.0F);
        this.tentacle3.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle44 = new ModelRenderer(this, 0, 3);
        this.tentacle44.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle44.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle22 = new ModelRenderer(this, 0, 3);
        this.tentacle22.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle22.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle99 = new ModelRenderer(this, 0, 3);
        this.tentacle99.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle99.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle5 = new ModelRenderer(this, 0, 0);
        this.tentacle5.func_78793_a(0.0F, 7.0F, 0.0F);
        this.tentacle5.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle9 = new ModelRenderer(this, 0, 0);
        this.tentacle9.func_78793_a(-5.0F, 7.0F, 5.0F);
        this.tentacle9.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tentacle999 = new ModelRenderer(this, 0, 6);
        this.tentacle999.func_78793_a(0.0F, 3.0F, 0.0F);
        this.tentacle999.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.tentacle5.func_78792_a(this.tentacle55);
        this.tentacle66.func_78792_a(this.tentacle666);
        this.tentacle222.func_78792_a(this.tentacle2222);
        this.tentacle11.func_78792_a(this.tentacle111);
        this.tentacle999.func_78792_a(this.tentacle9999);
        this.body.func_78792_a(this.tentacle4);
        this.tentacle777.func_78792_a(this.tentacle7777);
        this.tentacle33.func_78792_a(this.tentacle333);
        this.tentacle7.func_78792_a(this.tentacle77);
        this.tentacle6.func_78792_a(this.tentacle66);
        this.tentacle55.func_78792_a(this.tentacle555);
        this.tentacle8.func_78792_a(this.tentacle88);
        this.body.func_78792_a(this.tentacle6);
        this.body.func_78792_a(this.tentacle1);
        this.tentacle1.func_78792_a(this.tentacle11);
        this.tentacle44.func_78792_a(this.tentacle444);
        this.tentacle77.func_78792_a(this.tentacle777);
        this.body.func_78792_a(this.tentacle7);
        this.body.func_78792_a(this.tentacle8);
        this.tentacle88.func_78792_a(this.tentacle888);
        this.tentacle22.func_78792_a(this.tentacle222);
        this.tentacle3.func_78792_a(this.tentacle33);
        this.body.func_78792_a(this.tentacle2);
        this.body.func_78792_a(this.tentacle3);
        this.tentacle4.func_78792_a(this.tentacle44);
        this.tentacle2.func_78792_a(this.tentacle22);
        this.tentacle9.func_78792_a(this.tentacle99);
        this.body.func_78792_a(this.tentacle5);
        this.body.func_78792_a(this.tentacle9);
        this.tentacle99.func_78792_a(this.tentacle999);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.func_78785_a(f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        this.body.field_78796_g = p_78087_4_ / (180F / (float)Math.PI);
        this.body.field_78795_f = p_78087_5_ / (180F / (float)Math.PI);
        this.tentacle1.field_78795_f = 0.1F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 1.0F) + 0.5F;
        this.tentacle11.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 2.0F) + 0.2F;
        this.tentacle111.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 3.0F) + 0.2F;
        this.tentacle2.field_78795_f = 0.1F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 1.5F) + 0.5F;
        this.tentacle22.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 2.5F) + 0.2F;
        this.tentacle222.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 3.5F) + 0.2F;
        this.tentacle2222.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 4.5F) + 0.2F;
        this.tentacle3.field_78795_f = 0.1F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 2.0F) + 0.5F;
        this.tentacle33.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 3.0F) + 0.2F;
        this.tentacle333.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 4.0F) + 0.2F;
        this.tentacle4.field_78795_f = 0.1F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 2.5F) + 0.5F;
        this.tentacle44.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 3.5F) + 0.2F;
        this.tentacle444.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 4.5F) + 0.2F;
        this.tentacle5.field_78795_f = 0.1F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 3.0F) + 0.5F;
        this.tentacle55.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 4.0F) + 0.2F;
        this.tentacle555.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 5.0F) + 0.2F;
        this.tentacle6.field_78795_f = 0.1F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 3.5F) + 0.5F;
        this.tentacle66.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 4.5F) + 0.2F;
        this.tentacle666.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 5.5F) + 0.2F;
        this.tentacle7.field_78795_f = 0.1F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 4.0F) + 0.5F;
        this.tentacle77.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 5.0F) + 0.2F;
        this.tentacle777.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 6.0F) + 0.2F;
        this.tentacle7777.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 7.0F) + 0.2F;
        this.tentacle8.field_78795_f = 0.1F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 4.5F) + 0.5F;
        this.tentacle88.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 5.5F) + 0.2F;
        this.tentacle888.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 6.5F) + 0.2F;
        this.tentacle9.field_78795_f = 0.1F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 5.0F) + 0.5F;
        this.tentacle99.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 6.0F) + 0.2F;
        this.tentacle999.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 7.0F) + 0.2F;
        this.tentacle9999.field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.075F - 8.0F) + 0.2F;
    }
}
