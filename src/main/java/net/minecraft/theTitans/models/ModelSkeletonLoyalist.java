//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntitySkeletonMinion;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelSkeletonLoyalist extends ModelBiped {
    public boolean raiseArms;

    public ModelSkeletonLoyalist() {
        this(0.0F, false);
    }

    public ModelSkeletonLoyalist(float p_i46303_1_, boolean p_i46303_2_) {
        super(p_i46303_1_, 0.0F, 64, 32);
        if (!p_i46303_2_) {
            this.field_78112_f = new ModelRenderer(this, 40, 16);
            this.field_78112_f.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 12, 2, p_i46303_1_);
            this.field_78112_f.func_78793_a(-5.0F, 2.0F, 0.0F);
            this.field_78113_g = new ModelRenderer(this, 40, 16);
            this.field_78113_g.field_78809_i = true;
            this.field_78113_g.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 12, 2, p_i46303_1_);
            this.field_78113_g.func_78793_a(5.0F, 2.0F, 0.0F);
            this.field_78123_h = new ModelRenderer(this, 0, 16);
            this.field_78123_h.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 12, 2, p_i46303_1_);
            this.field_78123_h.func_78793_a(-2.0F, 12.0F, 0.0F);
            this.field_78124_i = new ModelRenderer(this, 0, 16);
            this.field_78124_i.field_78809_i = true;
            this.field_78124_i.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 12, 2, p_i46303_1_);
            this.field_78124_i.func_78793_a(2.0F, 12.0F, 0.0F);
        }

    }

    public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
        EntitySkeletonMinion entityskeleton = (EntitySkeletonMinion)p_78086_1_;
        if (entityskeleton.field_70173_aa % 1 == 0) {
            ItemStack itemstack = entityskeleton.func_70694_bm();
            this.field_78118_o = itemstack != null && itemstack.func_77973_b() == Items.field_151031_f;
            this.raiseArms = entityskeleton.func_70638_az() != null && entityskeleton.func_70068_e(entityskeleton.func_70638_az()) < (double)36.0F && (itemstack != null && itemstack.func_77973_b() != Items.field_151031_f || itemstack == null);
        }

        super.func_78086_a(entityskeleton, p_78086_2_, p_78086_3_, p_78086_4_);
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
        if (this.raiseArms) {
            float f6 = MathHelper.func_76126_a(this.field_78095_p * (float)Math.PI);
            float f7 = MathHelper.func_76126_a((1.0F - (1.0F - this.field_78095_p) * (1.0F - this.field_78095_p)) * (float)Math.PI);
            this.field_78112_f.field_78808_h = 0.0F;
            this.field_78113_g.field_78808_h = 0.0F;
            this.field_78112_f.field_78796_g = -(0.1F - f6 * 0.6F);
            this.field_78113_g.field_78796_g = 0.1F - f6 * 0.6F;
            this.field_78112_f.field_78795_f = (-(float)Math.PI / 2F);
            this.field_78113_g.field_78795_f = (-(float)Math.PI / 2F);
            ModelRenderer var10000 = this.field_78112_f;
            var10000.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
            var10000 = this.field_78113_g;
            var10000.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
            var10000 = this.field_78112_f;
            var10000.field_78808_h += MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
            var10000 = this.field_78113_g;
            var10000.field_78808_h -= MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
            var10000 = this.field_78112_f;
            var10000.field_78795_f += MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
            var10000 = this.field_78113_g;
            var10000.field_78795_f -= MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
        }

    }
}
