//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntitySlimeTitan;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSlimeTitan extends RenderLiving {
    private static final ResourceLocation slimeTextures = new ResourceLocation("textures/entity/slime/slime.png");
    private ModelBase scaleAmount;

    public RenderSlimeTitan(ModelBase p_i1267_1_, ModelBase p_i1267_2_, float p_i1267_3_) {
        super(p_i1267_1_, p_i1267_3_);
        this.scaleAmount = p_i1267_2_;
    }

    protected int shouldRenderPass(EntitySlimeTitan p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_1_.func_82150_aj()) {
            return 0;
        } else if (p_77032_2_ == 0) {
            this.func_77042_a(this.scaleAmount);
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            return 1;
        } else {
            if (p_77032_2_ == 1) {
                GL11.glDisable(3042);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }

            return -1;
        }
    }

    protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntitySlimeTitan)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    public void doRender(EntitySlimeTitan p_177124_1_, double p_177124_2_, double p_177124_4_, double p_177124_6_, float p_177124_8_, float p_177124_9_) {
        this.field_76989_e = 0.25F * (float)p_177124_1_.getSlimeSize();
        super.func_76986_a(p_177124_1_, p_177124_2_, p_177124_4_, p_177124_6_, p_177124_8_, p_177124_9_);
    }

    protected void func_77043_a(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
        GL11.glRotatef(180.0F - p_77043_3_, 0.0F, 1.0F, 0.0F);
        if (p_77043_1_.field_70725_aQ > 0) {
            float f3 = ((float)p_77043_1_.field_70725_aQ + p_77043_4_ - 1.0F) / 20.0F * 1.6F;
            f3 = MathHelper.func_76129_c(f3);
            if (f3 > 1.0F) {
                f3 = 1.0F;
            }

            GL11.glScalef(1.0F + f3 * 2.0F, 1.0F - f3 * 0.99F, 1.0F + f3 * 2.0F);
        }

    }

    protected void preRenderCallback(EntitySlimeTitan p_77041_1_, float p_77041_2_) {
        float f1 = (float)p_77041_1_.getSlimeSize();
        float f2 = (p_77041_1_.prevSquishFactor + (p_77041_1_.squishFactor - p_77041_1_.prevSquishFactor) * p_77041_2_) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
        float fl = 16.0F;
        int i = p_77041_1_.getInvulTime();
        if (i > 0) {
            fl -= ((float)i - p_77041_2_) / 10.0F;
        }

        GL11.glScalef(fl, fl, fl);
        float f4 = 0.025F + (p_77041_1_.func_70096_w().func_111145_d(5) - p_77041_1_.func_110138_aP()) / p_77041_1_.func_110138_aP() * 0.5F;
        float f5 = 1.0F + MathHelper.func_76134_b(((float)(p_77041_1_.field_70173_aa + p_77041_1_.func_145782_y()) + p_77041_2_) * f4) * f4;
        float f6 = 1.0F + MathHelper.func_76126_a(((float)(p_77041_1_.field_70173_aa + p_77041_1_.func_145782_y()) + p_77041_2_) * f4 + 0.785F) * f4;
        if (p_77041_1_.field_70725_aQ <= 0) {
            GL11.glScalef(f5, f6, f5);
        }

        GL11.glTranslatef(0.0F, 0.0075F, 0.0F);
    }

    protected ResourceLocation getEntityTexture(EntitySlimeTitan entity) {
        return slimeTextures;
    }

    public void func_76986_a(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntitySlimeTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntitySlimeTitan)p_77041_1_, p_77041_2_);
    }

    public void func_76986_a(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntitySlimeTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.getEntityTexture((EntitySlimeTitan)entity);
    }

    public void func_76986_a(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntitySlimeTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }
}
