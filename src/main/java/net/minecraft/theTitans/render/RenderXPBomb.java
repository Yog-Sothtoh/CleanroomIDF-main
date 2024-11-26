//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityXPBomb;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderXPBomb extends Render {
    private static final ResourceLocation experienceOrbTextures = new ResourceLocation("textures/entity/experience_orb.png");

    public RenderXPBomb() {
        this.field_76989_e = 1.5F;
    }

    public void doRender(EntityXPBomb p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
        this.func_110777_b(p_76986_1_);
        int i = 10;
        float f2 = (float)(i % 4 * 16 + 0) / 64.0F;
        float f3 = (float)(i % 4 * 16 + 16) / 64.0F;
        float f4 = (float)(i / 4 * 16 + 0) / 64.0F;
        float f5 = (float)(i / 4 * 16 + 16) / 64.0F;
        float f6 = 1.0F;
        float f7 = 0.5F;
        float f8 = 0.125F;
        int j = p_76986_1_.func_70070_b(p_76986_9_);
        int k = j % 65536;
        int l = j / 65536;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)k / 1.0F, (float)l / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f10 = 255.0F;
        float f11 = ((float)p_76986_1_.xpColor + p_76986_9_) / 2.0F;
        l = (int)((MathHelper.func_76126_a(f11 + 0.0F) + 1.0F) * 0.5F * f10);
        int i1 = (int)f10;
        int j1 = (int)((MathHelper.func_76126_a(f11 + 4.1887903F) + 1.0F) * 0.1F * f10);
        int k1 = l << 16 | i1 << 8 | j1;
        GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
        float f9 = 4.0F;
        GL11.glScalef(f9, f9, f9);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78384_a(k1, 128);
        tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
        tessellator.func_78374_a((double)(0.0F - f7), (double)(0.0F - f8), (double)0.0F, (double)f2, (double)f5);
        tessellator.func_78374_a((double)(f6 - f7), (double)(0.0F - f8), (double)0.0F, (double)f3, (double)f5);
        tessellator.func_78374_a((double)(f6 - f7), (double)(1.0F - f8), (double)0.0F, (double)f3, (double)f4);
        tessellator.func_78374_a((double)(0.0F - f7), (double)(1.0F - f8), (double)0.0F, (double)f2, (double)f4);
        tessellator.func_78381_a();
        GL11.glDisable(3042);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    protected ResourceLocation getEntityTexture(EntityXPBomb p_110775_1_) {
        return experienceOrbTextures;
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_) {
        return this.getEntityTexture((EntityXPBomb)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityXPBomb)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
