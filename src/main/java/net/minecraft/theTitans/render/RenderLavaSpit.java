//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityLavaSpit;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderLavaSpit extends Render {
    public RenderLavaSpit() {
        this.field_76989_e = 0.0F;
    }

    protected ResourceLocation getTextures(EntityLavaSpit p_180554_1_) {
        return null;
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.getTextures((EntityLavaSpit)entity);
    }

    public void doRender(EntityLavaSpit p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        GL11.glEnable(32826);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_ + 1.5F, (float)p_76986_6_);
        GL11.glScalef(3.0F, 3.0F, 3.0F);
        int i = 15728880;
        int j = i % 65536;
        int k = i / 65536;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.func_110776_a(TextureMap.field_110575_b);
        this.field_147909_c.func_147800_a(Blocks.field_150424_aL, 0, 1.0F);
        GL11.glPopMatrix();
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityLavaSpit)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
