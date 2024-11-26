//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelGhastGuard extends ModelBase {
    ModelRenderer body;
    ModelRenderer[] tentacles = new ModelRenderer[9];

    public ModelGhastGuard() {
        byte b0 = -16;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.func_78789_a(-8.0F, -8.0F, -8.0F, 16, 16, 16);
        ModelRenderer var10000 = this.body;
        var10000.field_78797_d += (float)(24 + b0);
        Random random = new Random(1660L);

        for(int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i] = new ModelRenderer(this, 0, 0);
            float f = (((float)(i % 3) - (float)(i / 3 % 2) * 0.5F + 0.25F) / 2.0F * 2.0F - 1.0F) * 5.0F;
            float f1 = ((float)(i / 3) / 2.0F * 2.0F - 1.0F) * 5.0F;
            int j = random.nextInt(7) + 8;
            this.tentacles[i].func_78789_a(-1.0F, 0.0F, -1.0F, 2, j, 2);
            this.tentacles[i].field_78800_c = f;
            this.tentacles[i].field_78798_e = f1;
            this.body.func_78792_a(this.tentacles[i]);
        }

    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        for(int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i].field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.3F + (float)i) + 0.4F;
            this.tentacles[i].field_78797_d = 7.0F;
        }

        this.body.field_78796_g = p_78087_4_ / (180F / (float)Math.PI);
        this.body.field_78795_f = p_78087_5_ / (180F / (float)Math.PI);
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
        this.func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        this.body.func_78785_a(p_78088_7_);
    }
}
