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
import net.minecraft.entity.titan.EntityTitanFireball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderTitanFireball extends Render {
    public RenderTitanFireball() {
    }

    public void doRender(EntityTitanFireball fireball, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        Item item = Items.field_151059_bz;
        IIcon iicon = item.func_77617_a(0);
        switch (fireball.getFireballID()) {
            case 1:
                item = Items.field_151016_H;
                iicon = item.func_77617_a(0);
                break;
            case 2:
                item = Items.field_151065_br;
                iicon = item.func_77617_a(0);
                break;
            case 3:
                item = Items.field_151078_bh;
                iicon = item.func_77617_a(0);
                break;
            case 4:
                item = Items.field_151079_bi;
                iicon = item.func_77617_a(0);
                break;
            case 5:
                item = Items.field_151042_j;
                iicon = item.func_77617_a(0);
                break;
            case 6:
                item = Items.field_151126_ay;
                iicon = item.func_77617_a(0);
                break;
            default:
                item = Items.field_151059_bz;
                iicon = item.func_77617_a(0);
        }

        if (iicon != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
            GL11.glEnable(32826);
            float f1 = fireball.field_70130_N * 2.0F;
            GL11.glScalef(f1, f1, f1);
            this.func_110777_b(fireball);
            Tessellator tessellator = Tessellator.field_78398_a;
            this.func_77026_a(tessellator, iicon);
            GL11.glDisable(32826);
            GL11.glPopMatrix();
        }

    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityTitanFireball)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
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
