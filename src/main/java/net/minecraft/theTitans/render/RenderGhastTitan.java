//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityGhastTitan;
import net.minecraft.theTitans.models.ModelGhastTitan;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGhastTitan extends RenderLiving {
    private static final ResourceLocation ghastTextures = new ResourceLocation("thetitans", "textures/entities/titans/ghast_titan.png");
    private static final ResourceLocation ghastShootingTextures = new ResourceLocation("thetitans", "textures/entities/titans/ghast_titan_shooting.png");

    public RenderGhastTitan() {
        super(new ModelGhastTitan(), 4.0F);
    }

    protected ResourceLocation func_180576_a(EntityGhastTitan p_180576_1_) {
        return p_180576_1_.func_110182_bF() ? ghastShootingTextures : ghastTextures;
    }

    protected void preRenderCallback(EntityGhastTitan p_77041_1_, float p_77041_2_) {
        float f1 = ((float)p_77041_1_.prevAttackCounter + (float)(p_77041_1_.attackCounter - p_77041_1_.prevAttackCounter) * p_77041_2_) / 20.0F;
        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        f1 = 1.0F / (f1 * f1 * f1 * f1 * f1 * 2.0F + 1.0F);
        float f2 = (8.0F + f1) / 2.0F;
        float f3 = (8.0F + 1.0F / f1) / 2.0F;
        GL11.glScalef(f3, f2, f3);
        float f11 = 24.0F;
        int i = p_77041_1_.getInvulTime();
        if (i > 0) {
            f11 -= ((float)i - p_77041_2_) / 440.0F * 7.75F;
        }

        int i2 = p_77041_1_.getExtraPower();
        if (i2 > 0) {
            float var10000 = f1 + (float)i2 * 0.5F;
        }

        GL11.glScalef(f11, f11, f11);
        if (p_77041_1_.field_70737_aN > 0) {
            GL11.glDepthFunc(514);
            GL11.glDisable(3553);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.5F);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
            GL11.glDepthFunc(515);
        }

    }

    protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntityGhastTitan)p_77041_1_, p_77041_2_);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.func_180576_a((EntityGhastTitan)entity);
    }

    public void func_180579_a(EntityGhastTitan p_180579_1_, double p_180579_2_, double p_180579_4_, double p_180579_6_, float p_180579_8_, float p_180579_9_) {
        super.func_76986_a(p_180579_1_, p_180579_2_, p_180579_4_, p_180579_6_, p_180579_8_, p_180579_9_);
    }

    public void func_76986_a(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityGhastTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void func_76986_a(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityGhastTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void func_76986_a(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityGhastTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }
}
