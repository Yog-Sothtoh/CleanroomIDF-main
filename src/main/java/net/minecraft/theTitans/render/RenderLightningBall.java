//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Items;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderLightningBall extends Render {
    private float field_77002_a;

    public RenderLightningBall(float p_i1254_1_) {
        this.field_77002_a = p_i1254_1_;
    }

    public void doRender(EntityFireball p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        GL11.glPushMatrix();
        this.func_110777_b(p_76986_1_);
        GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
        GL11.glEnable(32826);
        float f2 = this.field_77002_a;
        GL11.glScalef(f2 / 1.0F, f2 / 1.0F, f2 / 1.0F);
        IIcon iicon = Items.field_151126_ay.func_77617_a(0);
        Tessellator tessellator = Tessellator.field_78398_a;
        float f3 = iicon.func_94209_e();
        float f4 = iicon.func_94212_f();
        float f5 = iicon.func_94206_g();
        float f6 = iicon.func_94210_h();
        float f7 = 1.0F;
        float f8 = 0.5F;
        float f9 = 0.25F;
        GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
        tessellator.func_78374_a((double)(0.0F - f8), (double)(0.0F - f9), (double)0.0F, (double)f3, (double)f6);
        tessellator.func_78374_a((double)(f7 - f8), (double)(0.0F - f9), (double)0.0F, (double)f4, (double)f6);
        tessellator.func_78374_a((double)(f7 - f8), (double)(1.0F - f9), (double)0.0F, (double)f4, (double)f5);
        tessellator.func_78374_a((double)(0.0F - f8), (double)(1.0F - f9), (double)0.0F, (double)f3, (double)f5);
        tessellator.func_78381_a();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    protected ResourceLocation getEntityTexture(EntityFireball p_110775_1_) {
        return TextureMap.field_110576_c;
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_) {
        return this.getEntityTexture((EntityFireball)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityFireball)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
