//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityGargoyle;
import net.minecraft.theTitans.models.ModelBeam;
import net.minecraft.theTitans.models.ModelGargoyle;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGargoyle extends RenderLiving {
    private static final ResourceLocation stoneGargoyleTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle1.png");
    private static final ResourceLocation sandstoneGargoyleTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle2.png");
    private static final ResourceLocation obsidianGargoyleTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle3.png");
    private static final ResourceLocation goldenGargoyleTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle4.png");
    private static final ResourceLocation ironGargoyleTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle5.png");
    private static final ResourceLocation endstoneGargoyleTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle6.png");
    private static final ResourceLocation nethraticGargoyleTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle7.png");
    private static final ResourceLocation gargoyleBeamTextures = new ResourceLocation("thetitans", "textures/entities/gargoyle_beam.png");

    public RenderGargoyle() {
        super(new ModelGargoyle(), 0.8F);
    }

    protected ResourceLocation getEntityTexture(EntityGargoyle entity) {
        switch (entity.getGargoyleType()) {
            case 0:
            default:
                return stoneGargoyleTextures;
            case 1:
                return sandstoneGargoyleTextures;
            case 2:
                return obsidianGargoyleTextures;
            case 3:
                return goldenGargoyleTextures;
            case 4:
                return ironGargoyleTextures;
            case 5:
                return endstoneGargoyleTextures;
            case 6:
                return nethraticGargoyleTextures;
        }
    }

    protected void func_180588_a(EntityGargoyle p_180588_1_, float p_180588_2_, float p_180588_3_, float p_180588_4_) {
        super.func_77043_a(p_180588_1_, p_180588_2_, p_180588_3_, p_180588_4_);
        if (!p_180588_1_.field_70122_E || p_180588_1_.getAggressive()) {
            GL11.glRotatef(75.0F, -1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(0.0F, -1.0F, 1.0F);
        }

        if (p_180588_1_.getGargoyleType() == 1) {
            GL11.glScalef(0.75F, 1.0F, 0.75F);
        }

        if (p_180588_1_.getGargoyleType() == 2) {
            GL11.glScalef(1.25F, 1.0F, 1.25F);
        }

        if (p_180588_1_.getGargoyleType() == 3) {
            GL11.glScalef(1.1F, 1.0F, 1.1F);
        }

        if (p_180588_1_.getGargoyleType() == 4) {
            GL11.glScalef(1.2F, 1.0F, 1.2F);
        }

        if (p_180588_1_.getGargoyleType() == 5) {
            GL11.glScalef(1.1F, 1.1F, 1.1F);
        }

        if (p_180588_1_.getGargoyleType() == 6) {
            GL11.glScalef(1.05F, 0.95F, 1.05F);
        }

    }

    protected void func_77043_a(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
        this.func_180588_a((EntityGargoyle)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.getEntityTexture((EntityGargoyle)entity);
    }

    protected int shouldRenderPass(EntityGargoyle p_77032_1_, int p_77032_2_, float p_77032_3_) {
        int i1 = MathHelper.func_76128_c(p_77032_1_.field_70165_t);
        int j = MathHelper.func_76128_c(p_77032_1_.field_70121_D.field_72338_b - (double)0.5F);
        int k = MathHelper.func_76128_c(p_77032_1_.field_70161_v);
        boolean flag = p_77032_1_.field_70170_p.func_147439_a(i1, j, k) == p_77032_1_.getFavoriteBlockToPerch();
        if (p_77032_1_.getGargoyleType() == 3) {
            if (p_77032_1_.func_82150_aj()) {
                GL11.glDepthMask(false);
            } else {
                GL11.glDepthMask(true);
            }

            if (p_77032_2_ == 1) {
                ModelBase modelmatter = new ModelBeam();
                ((ModelGargoyle)this.field_77045_g).Torso.func_78794_c(0.020833334F);
                ((ModelGargoyle)this.field_77045_g).Body.func_78794_c(0.020833334F);
                ((ModelGargoyle)this.field_77045_g).Head.func_78794_c(0.020833334F);
                float f1 = (float)p_77032_1_.field_70173_aa + p_77032_3_;
                this.func_110776_a(gargoyleBeamTextures);
                GL11.glTranslatef(0.0F, -0.5F, 0.0F);
                if (!p_77032_1_.field_70122_E) {
                    GL11.glTranslatef(0.0F, 0.25F, 0.0F);
                }

                if (flag) {
                    GL11.glTranslatef(0.0F, 0.3F, -0.65F);
                }

                GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glScalef(0.75F, 10.0F, 0.4F);
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                float f3 = f1 * 0.01F;
                GL11.glTranslatef(0.0F, f3, 0.0F);
                this.func_77042_a(modelmatter);
                GL11.glMatrixMode(5888);
                GL11.glEnable(3042);
                float f4 = 0.5F;
                GL11.glColor4f(f4, f4, f4, f4);
                modelmatter.func_78088_a(p_77032_1_, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glDisable(2896);
                GL11.glBlendFunc(1, 1);
                GL11.glEnable(3042);
                GL11.glDisable(3008);
                GL11.glBlendFunc(1, 1);
                GL11.glDisable(2896);
                char c0 = '\uf0f0';
                int j1 = c0 % 65536;
                int k1 = c0 / 65536;
                OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j1 / 1.0F, (float)k1 / 1.0F);
                GL11.glEnable(2896);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 2.0F);
                return 1;
            }

            if (p_77032_2_ == 2) {
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(5888);
                GL11.glEnable(2896);
                GL11.glDisable(3042);
            }
        }

        return -1;
    }

    protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityGargoyle)p_77032_1_, p_77032_2_, p_77032_3_);
    }
}
