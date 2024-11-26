//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGammaLightning extends Render {
    public RenderGammaLightning() {
        this.field_76989_e = 0.0F;
    }

    public void doRender(EntityGammaLightning p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glDisable(3553);
        GL11.glDisable(2896);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 1);
        double[] adouble = new double[8];
        double[] adouble1 = new double[8];
        double d3 = (double)0.0F;
        double d4 = (double)0.0F;
        Random random = new Random(p_76986_1_.field_70264_a);

        for(int i = 7; i >= 0; --i) {
            adouble[i] = d3;
            adouble1[i] = d4;
            d3 += (double)(random.nextInt(11) - 5);
            d4 += (double)(random.nextInt(11) - 5);
        }

        for(int k1 = 0; k1 < 4; ++k1) {
            Random random1 = new Random(p_76986_1_.field_70264_a);

            for(int j = 0; j < 3; ++j) {
                int k = 7;
                int l = 0;
                if (j > 0) {
                    k = 7 - j;
                }

                if (j > 0) {
                    l = k - 2;
                }

                double d5 = adouble[k] - d3;
                double d6 = adouble1[k] - d4;

                for(int i1 = k; i1 >= l; --i1) {
                    double d7 = d5;
                    double d8 = d6;
                    if (j == 0) {
                        d5 += (double)(random1.nextInt(11) - 5);
                        d6 += (double)(random1.nextInt(11) - 5);
                    } else {
                        d5 += (double)(random1.nextInt(31) - 15);
                        d6 += (double)(random1.nextInt(31) - 15);
                    }

                    tessellator.func_78371_b(5);
                    tessellator.func_78369_a(p_76986_1_.getRed(), p_76986_1_.getGreen(), p_76986_1_.getBlue(), 0.5F);
                    double d9 = 0.1 + (double)k1 * 0.2;
                    if (j == 0) {
                        d9 *= (double)i1 * 0.1 + (double)1.0F;
                    }

                    double d10 = 0.1 + (double)k1 * 0.2;
                    if (j == 0) {
                        d10 *= (double)(i1 - 1) * 0.1 + (double)1.0F;
                    }

                    for(int j1 = 0; j1 < 5; ++j1) {
                        double d11 = p_76986_2_ + (double)0.5F - d9;
                        double d12 = p_76986_6_ + (double)0.5F - d9;
                        if (j1 == 1 || j1 == 2) {
                            d11 += d9 * (double)2.0F;
                        }

                        if (j1 == 2 || j1 == 3) {
                            d12 += d9 * (double)2.0F;
                        }

                        double d13 = p_76986_2_ + (double)0.5F - d10;
                        double d14 = p_76986_6_ + (double)0.5F - d10;
                        if (j1 == 1 || j1 == 2) {
                            d13 += d10 * (double)2.0F;
                        }

                        if (j1 == 2 || j1 == 3) {
                            d14 += d10 * (double)2.0F;
                        }

                        tessellator.func_78377_a(d13 + d5, p_76986_4_ + (double)(i1 * 16), d14 + d6);
                        tessellator.func_78377_a(d11 + d7, p_76986_4_ + (double)((i1 + 1) * 16), d12 + d8);
                    }

                    tessellator.func_78381_a();
                }
            }
        }

        GL11.glDisable(3042);
        GL11.glEnable(2896);
        GL11.glEnable(3553);
        GL11.glPopMatrix();
    }

    protected ResourceLocation getEntityTexture(EntityGammaLightning p_110775_1_) {
        return null;
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_) {
        return this.getEntityTexture((EntityGammaLightning)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityGammaLightning)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
