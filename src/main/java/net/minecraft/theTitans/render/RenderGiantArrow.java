//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntitySkeletonTitanGiantArrow;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGiantArrow extends Render {
    private static final ResourceLocation arrowTextures = new ResourceLocation("textures/entity/arrow.png");

    public RenderGiantArrow() {
    }

    public void doRender(EntitySkeletonTitanGiantArrow p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        if (!p_76986_1_.func_82150_aj()) {
            GL11.glPushMatrix();
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            this.func_110777_b(p_76986_1_);
            GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
            GL11.glRotatef(p_76986_1_.field_70126_B + (p_76986_1_.field_70177_z - p_76986_1_.field_70126_B) * p_76986_9_ - 90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(p_76986_1_.field_70127_C + (p_76986_1_.field_70125_A - p_76986_1_.field_70127_C) * p_76986_9_, 0.0F, 0.0F, 1.0F);
            Tessellator tessellator = Tessellator.field_78398_a;
            byte b0 = 0;
            float f2 = 0.0F;
            float f3 = 0.5F;
            float f4 = (float)(0 + b0 * 10) / 32.0F;
            float f5 = (float)(5 + b0 * 10) / 32.0F;
            float f6 = 0.0F;
            float f7 = 0.15625F;
            float f8 = (float)(5 + b0 * 10) / 32.0F;
            float f9 = (float)(10 + b0 * 10) / 32.0F;
            float f10 = 0.9F;
            GL11.glEnable(32826);
            GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
            GL11.glScalef(f10, f10, f10);
            GL11.glTranslatef(-4.0F, 1.5F, -1.5F);
            GL11.glNormal3f(f10, 0.0F, 0.0F);
            tessellator.func_78382_b();
            tessellator.func_78374_a((double)-7.0F, (double)-2.0F, (double)-2.0F, (double)f6, (double)f8);
            tessellator.func_78374_a((double)-7.0F, (double)-2.0F, (double)2.0F, (double)f7, (double)f8);
            tessellator.func_78374_a((double)-7.0F, (double)2.0F, (double)2.0F, (double)f7, (double)f9);
            tessellator.func_78374_a((double)-7.0F, (double)2.0F, (double)-2.0F, (double)f6, (double)f9);
            tessellator.func_78381_a();
            GL11.glNormal3f(-f10, 0.0F, 0.0F);
            tessellator.func_78382_b();
            tessellator.func_78374_a((double)-7.0F, (double)2.0F, (double)-2.0F, (double)f6, (double)f8);
            tessellator.func_78374_a((double)-7.0F, (double)2.0F, (double)2.0F, (double)f7, (double)f8);
            tessellator.func_78374_a((double)-7.0F, (double)-2.0F, (double)2.0F, (double)f7, (double)f9);
            tessellator.func_78374_a((double)-7.0F, (double)-2.0F, (double)-2.0F, (double)f6, (double)f9);
            tessellator.func_78381_a();

            for(int i = 0; i < 4; ++i) {
                GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glNormal3f(0.0F, 0.0F, f10);
                tessellator.func_78382_b();
                tessellator.func_78374_a((double)-8.0F, (double)-2.0F, (double)0.0F, (double)f2, (double)f4);
                tessellator.func_78374_a((double)8.0F, (double)-2.0F, (double)0.0F, (double)f3, (double)f4);
                tessellator.func_78374_a((double)8.0F, (double)2.0F, (double)0.0F, (double)f3, (double)f5);
                tessellator.func_78374_a((double)-8.0F, (double)2.0F, (double)0.0F, (double)f2, (double)f5);
                tessellator.func_78381_a();
            }

            GL11.glDisable(3042);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
        }

    }

    protected ResourceLocation getEntityTexture(EntitySkeletonTitanGiantArrow p_110775_1_) {
        return arrowTextures;
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_) {
        return this.getEntityTexture((EntitySkeletonTitanGiantArrow)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntitySkeletonTitanGiantArrow)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
