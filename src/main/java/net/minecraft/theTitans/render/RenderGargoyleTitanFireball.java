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
import net.minecraft.entity.titan.EntityGargoyleTitanFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGargoyleTitanFireball extends Render {
    public RenderGargoyleTitanFireball() {
        this.field_76989_e = 0.0F;
    }

    protected ResourceLocation getTextures(EntityGargoyleTitanFireball p_180554_1_) {
        return null;
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.getTextures((EntityGargoyleTitanFireball)entity);
    }

    public void doRender(EntityGargoyleTitanFireball p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        GL11.glEnable(32826);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_ + 1.5F, (float)p_76986_6_);
        GL11.glScalef(3.0F, 3.0F, 3.0F);
        GL11.glRotatef(((float)p_76986_1_.field_70173_aa + p_76986_9_) * 10.0F, 1.0F, 1.0F, 1.0F);
        int i = 15728880;
        int j = i % 65536;
        int k = i / 65536;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.func_110776_a(TextureMap.field_110575_b);
        switch (p_76986_1_.getModelVarient()) {
            case 0:
                this.renderBlock(p_76986_1_);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(0.5F, -0.25F, -0.5F);
                GL11.glRotatef(30.0F, 1.0F, 1.0F, 1.0F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(-0.5F, 0.0F, 0.25F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(-0.25F, 0.5F, 0.0F);
                GL11.glRotatef(-40.0F, 1.0F, 1.0F, 1.0F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(0.0F, -0.25F, 0.5F);
                GL11.glRotatef(-50.0F, 1.0F, 1.0F, 1.0F);
                break;
            case 1:
                this.renderBlock(p_76986_1_);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(-0.5F, 0.25F, -0.5F);
                GL11.glRotatef(60.0F, 1.0F, 1.0F, 1.0F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(-0.5F, 1.0F, 0.25F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(-0.25F, -0.5F, 0.0F);
                GL11.glRotatef(-40.0F, 1.0F, 1.0F, 1.0F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(0.25F, -0.25F, -0.5F);
                GL11.glRotatef(-50.0F, 1.0F, 1.0F, 1.0F);
                break;
            case 2:
                this.renderBlock(p_76986_1_);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(0.5F, 0.5F, -0.25F);
                GL11.glRotatef(15.0F, 1.0F, 1.0F, 1.0F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(0.5F, -1.0F, -1.0F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(-0.5F, 0.5F, 0.5F);
                GL11.glRotatef(30.0F, 1.0F, 1.0F, 1.0F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(0.0F, -0.25F, -1.5F);
                GL11.glRotatef(60.0F, 1.0F, 1.0F, 1.0F);
                break;
            case 3:
                this.renderBlock(p_76986_1_);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(-0.5F, 0.25F, 0.5F);
                GL11.glRotatef(-30.0F, 1.0F, 1.0F, 1.0F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(0.5F, 0.0F, -0.25F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(-0.25F, 0.5F, 0.0F);
                GL11.glRotatef(40.0F, 1.0F, 1.0F, 1.0F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(0.0F, 0.25F, -0.5F);
                GL11.glRotatef(50.0F, 1.0F, 1.0F, 1.0F);
                break;
            case 4:
                this.renderBlock(p_76986_1_);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(1.5F, -0.25F, -0.5F);
                GL11.glRotatef(30.0F, 1.0F, 1.0F, 1.0F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(-1.5F, 0.5F, 0.25F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(-0.25F, 0.5F, 0.0F);
                GL11.glRotatef(80.0F, 1.0F, 1.0F, 1.0F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(0.0F, -0.25F, 0.5F);
                GL11.glRotatef(30.0F, 1.0F, 1.0F, 1.0F);
                break;
            case 5:
                this.renderBlock(p_76986_1_);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(0.5F, -0.75F, 0.5F);
                GL11.glRotatef(30.0F, 1.0F, 1.0F, 1.0F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(-0.5F, 0.0F, -0.25F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(-0.25F, -0.5F, 0.0F);
                GL11.glRotatef(-40.0F, 1.0F, 1.0F, 1.0F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(-0.25F, -0.25F, 0.5F);
                GL11.glRotatef(-50.0F, 1.0F, 1.0F, 1.0F);
                break;
            case 6:
                this.renderBlock(p_76986_1_);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(0.5F, -0.25F, -0.5F);
                GL11.glRotatef(-60.0F, 1.0F, 1.0F, 1.0F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(-0.5F, 0.0F, 0.25F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(-0.25F, 0.5F, 0.0F);
                GL11.glRotatef(90.0F, 1.0F, 1.0F, 1.0F);
                this.renderBlock(p_76986_1_);
                GL11.glTranslatef(0.0F, -0.25F, 0.5F);
                GL11.glRotatef(-30.0F, 1.0F, 1.0F, 1.0F);
        }

        GL11.glPopMatrix();
    }

    private void renderBlock(EntityGargoyleTitanFireball p_76986_1_) {
        switch (p_76986_1_.getBlockType()) {
            case 0:
                this.field_147909_c.func_147800_a(Blocks.field_150348_b, 0, 1.0F);
                break;
            case 1:
                this.field_147909_c.func_147800_a(Blocks.field_150365_q, 0, 1.0F);
                break;
            case 2:
                this.field_147909_c.func_147800_a(Blocks.field_150366_p, 0, 1.0F);
                break;
            case 3:
                this.field_147909_c.func_147800_a(Blocks.field_150450_ax, 0, 1.0F);
                break;
            case 4:
                this.field_147909_c.func_147800_a(Blocks.field_150352_o, 0, 1.0F);
                break;
            case 5:
                this.field_147909_c.func_147800_a(Blocks.field_150482_ag, 0, 1.0F);
                break;
            case 6:
                this.field_147909_c.func_147800_a(Blocks.field_150412_bA, 0, 1.0F);
        }

    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityGargoyleTitanFireball)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
