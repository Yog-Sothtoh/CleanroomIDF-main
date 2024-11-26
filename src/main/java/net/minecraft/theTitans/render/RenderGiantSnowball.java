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
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGiantSnowball extends Render {
    private Item field_94151_a;
    private int field_94150_f;
    private float field_77002_a;
    private boolean customize;

    public RenderGiantSnowball(Item p_i1259_1_, int p_i1259_2_, float p_i1259_3_) {
        this.field_94151_a = p_i1259_1_;
        this.field_94150_f = p_i1259_2_;
        this.field_77002_a = p_i1259_3_;
    }

    public RenderGiantSnowball(Item p_i1260_1_) {
        this(p_i1260_1_, 0, 4.0F);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        IIcon iicon = this.field_94151_a.func_77617_a(this.field_94150_f);
        if (iicon != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
            GL11.glEnable(32826);
            float f1 = this.field_77002_a;
            GL11.glScalef(f1 / 1.0F, f1 / 1.0F, f1 / 1.0F);
            this.func_110777_b(p_76986_1_);
            Tessellator tessellator = Tessellator.field_78398_a;
            if (iicon == ItemPotion.func_94589_d("bottle_splash")) {
                int i = PotionHelper.func_77915_a(((EntityPotion)p_76986_1_).func_70196_i(), false);
                float f2 = (float)(i >> 16 & 255) / 255.0F;
                float f3 = (float)(i >> 8 & 255) / 255.0F;
                float f4 = (float)(i & 255) / 255.0F;
                GL11.glColor3f(f2, f3, f4);
                GL11.glPushMatrix();
                this.func_77026_a(tessellator, ItemPotion.func_94589_d("overlay"));
                GL11.glPopMatrix();
                GL11.glColor3f(1.0F, 1.0F, 1.0F);
            }

            this.func_77026_a(tessellator, iicon);
            GL11.glDisable(32826);
            GL11.glPopMatrix();
        }

    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_) {
        return TextureMap.field_110576_c;
    }

    private void func_77026_a(Tessellator p_77026_1_, IIcon p_77026_2_) {
        float f = p_77026_2_.func_94209_e();
        float f1 = p_77026_2_.func_94212_f();
        float f2 = p_77026_2_.func_94206_g();
        float f3 = p_77026_2_.func_94210_h();
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.25F;
        GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
        p_77026_1_.func_78382_b();
        p_77026_1_.func_78375_b(0.0F, 1.0F, 0.0F);
        p_77026_1_.func_78374_a((double)(0.0F - f5), (double)(0.0F - f6), (double)0.0F, (double)f, (double)f3);
        p_77026_1_.func_78374_a((double)(f4 - f5), (double)(0.0F - f6), (double)0.0F, (double)f1, (double)f3);
        p_77026_1_.func_78374_a((double)(f4 - f5), (double)(f4 - f6), (double)0.0F, (double)f1, (double)f2);
        p_77026_1_.func_78374_a((double)(0.0F - f5), (double)(f4 - f6), (double)0.0F, (double)f, (double)f2);
        p_77026_1_.func_78381_a();
    }
}
