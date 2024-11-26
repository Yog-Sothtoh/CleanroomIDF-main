//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderWebShot extends Render {
    private float field_77002_a;

    public RenderWebShot(float p_i1254_1_) {
        this.field_77002_a = p_i1254_1_;
    }

    public void doRender(EntityFireball p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        GL11.glEnable(32826);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_ + 1.5F, (float)p_76986_6_);
        GL11.glScalef(this.field_77002_a, this.field_77002_a, this.field_77002_a);
        GL11.glRotatef(((float)p_76986_1_.field_70173_aa + p_76986_9_) * MathHelper.func_76134_b(p_76986_9_ * 0.05F) * 10.0F, 0.0F, 1.0F, 0.0F);
        this.func_110776_a(TextureMap.field_110575_b);
        this.field_147909_c.func_147800_a(Blocks.field_150321_G, 0, 1.0F);
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
