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
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.models.ModelSpiderTitan;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSpiderTitan extends RenderLiving {
    private static final ResourceLocation spiderEyesTextures = new ResourceLocation("thetitans", "textures/entities/titans/spider_titan_eyes.png");
    private static final ResourceLocation spiderTextures = new ResourceLocation("thetitans", "textures/entities/titans/spider_titan.png");
    private ModelBase overlayingModel = new ModelSpiderTitan(0.1F);

    public RenderSpiderTitan() {
        super(new ModelSpiderTitan(), 1.0F);
        this.func_77042_a(new ModelSpiderTitan());
    }

    protected float getDeathMaxRotation(EntitySpiderTitan p_77037_1_) {
        return 180.0F;
    }

    protected ResourceLocation getEntityTexture(EntitySpiderTitan entity) {
        return spiderTextures;
    }

    protected int shouldRenderPass(EntitySpiderTitan p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_1_.isArmored() && p_77032_1_.func_70089_S()) {
            if (p_77032_1_.func_82150_aj()) {
                GL11.glDepthMask(false);
            } else {
                GL11.glDepthMask(true);
            }

            if (p_77032_2_ == 1) {
                float f1 = (float)p_77032_1_.field_70173_aa + p_77032_3_;
                this.func_110776_a(TheTitans.genericTitanWhiteTexture64x64);
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                float f2 = MathHelper.func_76134_b(f1 * 0.02F) * 5.0F;
                float f3 = f1 * 0.01F;
                GL11.glTranslatef(MathHelper.func_76134_b(f1 * 0.2F), f3, f2);
                this.func_77042_a(this.overlayingModel);
                GL11.glMatrixMode(5888);
                GL11.glEnable(3042);
                GL11.glColor4f(0.6F + MathHelper.func_76134_b(f1 * 0.05F) * 0.3F, 0.0F, 0.0F, 1.0F);
                GL11.glDisable(2896);
                GL11.glBlendFunc(1, 1);
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

        if (p_77032_2_ != 0) {
            return -1;
        } else {
            this.func_110776_a(spiderEyesTextures);
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(1, 1);
            if (p_77032_1_.func_82150_aj()) {
                GL11.glDepthMask(false);
            } else {
                GL11.glDepthMask(true);
            }

            int c0 = 15728880;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.func_77042_a(this.field_77045_g);
            if (p_77032_1_.getAnimID() == 10 && p_77032_1_.deathTicks > 200) {
                GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
            }

            return 1;
        }
    }

    protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntitySpiderTitan)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected float func_77037_a(EntityLivingBase p_77037_1_) {
        return this.getDeathMaxRotation((EntitySpiderTitan)p_77037_1_);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.getEntityTexture((EntitySpiderTitan)entity);
    }

    protected void func_180592_a(EntitySpiderTitan p_180592_1_, float p_180592_2_) {
        int i = p_180592_1_.getInvulTime();
        int i2 = p_180592_1_.getExtraPower();
        float f1 = 16.0F;
        if (i > 0) {
            f1 -= ((float)i - p_180592_2_) / 440.0F * 7.75F;
        }

        if (i2 > 0) {
            f1 += (float)i2 * 0.5F;
        }

        GL11.glScalef(f1, f1, f1);
    }

    protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.func_180592_a((EntitySpiderTitan)p_77041_1_, p_77041_2_);
    }

    public void func_180579_a(EntitySpiderTitan p_180579_1_, double p_180579_2_, double p_180579_4_, double p_180579_6_, float p_180579_8_, float p_180579_9_) {
        super.func_76986_a(p_180579_1_, p_180579_2_, p_180579_4_, p_180579_6_, p_180579_8_, p_180579_9_);
    }

    public void func_76986_a(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySpiderTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void func_76986_a(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySpiderTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void func_76986_a(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySpiderTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }
}
