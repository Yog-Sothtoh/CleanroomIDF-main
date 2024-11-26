//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class ModelSlimeTitan extends ModelBase {
    ModelRenderer slimeBodies;
    ModelRenderer slimeRightEye;
    ModelRenderer slimeLeftEye;
    ModelRenderer slimeMouth;

    public ModelSlimeTitan(int p_i1157_1_) {
        this.slimeBodies = new ModelRenderer(this, 0, p_i1157_1_);
        this.slimeBodies.func_78789_a(-4.0F, 16.0F, -4.0F, 8, 8, 8);
        if (p_i1157_1_ > 0) {
            this.slimeBodies = new ModelRenderer(this, 0, p_i1157_1_);
            this.slimeBodies.func_78789_a(-3.0F, 17.0F, -3.0F, 6, 6, 6);
            this.slimeRightEye = new ModelRenderer(this, 32, 0);
            this.slimeRightEye.func_78789_a(-1.0F, -1.0F, -1.0F, 2, 2, 2);
            this.slimeRightEye.func_78793_a(-2.25F, 19.0F, -2.5F);
            this.slimeLeftEye = new ModelRenderer(this, 32, 4);
            this.slimeLeftEye.func_78789_a(-1.0F, -1.0F, -1.0F, 2, 2, 2);
            this.slimeLeftEye.func_78793_a(2.25F, 19.0F, -2.5F);
            this.slimeMouth = new ModelRenderer(this, 32, 8);
            this.slimeMouth.func_78789_a(0.0F, 21.0F, -3.5F, 1, 1, 1);
        }

    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
        this.func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        this.slimeBodies.func_78785_a(p_78088_7_);
        if (this.slimeRightEye != null) {
            this.slimeRightEye.func_78785_a(p_78088_7_);
            this.slimeLeftEye.func_78785_a(p_78088_7_);
            this.slimeMouth.func_78785_a(p_78088_7_);
        }

    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        if (this.slimeRightEye != null) {
            this.slimeRightEye.field_78796_g = p_78087_4_ / (180F / (float)Math.PI);
            this.slimeRightEye.field_78795_f = p_78087_5_ / (180F / (float)Math.PI);
        }

        if (this.slimeLeftEye != null) {
            this.slimeLeftEye.field_78796_g = p_78087_4_ / (180F / (float)Math.PI);
            this.slimeLeftEye.field_78795_f = p_78087_5_ / (180F / (float)Math.PI);
        }

    }
}
