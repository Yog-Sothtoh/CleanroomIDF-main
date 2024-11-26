//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityEnderColossusCrystal;
import net.minecraft.theTitans.models.ModelEnderColossusCrystal;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderEnderColossusCrystal extends Render {
    private static final ResourceLocation enderColossusCrystalBeamTextures = new ResourceLocation("thetitans", "textures/entities/endercrystal_beam.png");
    private static final ResourceLocation enderCrystalTextures = new ResourceLocation("thetitans", "textures/entities/crystal.png");
    private ModelBase field_76995_b;

    public RenderEnderColossusCrystal() {
        this.field_76989_e = 1.0F;
        this.field_76995_b = new ModelEnderColossusCrystal(0.0F, true);
    }

    public void doRender(EntityEnderColossusCrystal entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        float f2 = (float)entity.innerRotation + partialTicks;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        this.func_110776_a(enderCrystalTextures);
        float f3 = MathHelper.func_76126_a(f2 * 0.2F) / 2.0F + 0.5F;
        f3 += f3 * f3;
        this.field_76995_b.func_78088_a(entity, 0.0F, f2 * 3.0F, f3 * 0.2F, 0.0F, 0.0F, 0.0625F);
        if (entity.field_70737_aN > 0 || !entity.func_70089_S()) {
            GL11.glDepthFunc(514);
            GL11.glDisable(3553);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.5F);
            this.field_76995_b.func_78088_a(entity, 0.0F, f2 * 3.0F, f3 * 0.2F, 0.0F, 0.0F, 0.0625F);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
            GL11.glDepthFunc(515);
        }

        GL11.glPopMatrix();
        if (entity.owner != null && !entity.owner.isStunned && entity.func_70089_S()) {
            float f1 = (float)entity.field_70173_aa + partialTicks;
            float f4 = (float)(entity.owner.field_70165_t - entity.field_70165_t - (entity.field_70169_q - entity.field_70165_t) * (double)(1.0F - partialTicks));
            float f5 = (float)(entity.owner.field_70163_u - entity.field_70163_u + (double)48.0F + (double)f3 - (entity.field_70167_r - entity.field_70163_u) * (double)(1.0F - partialTicks));
            float f6 = (float)(entity.owner.field_70161_v - entity.field_70161_v - (entity.field_70166_s - entity.field_70161_v) * (double)(1.0F - partialTicks));
            float f7 = MathHelper.func_76129_c(f4 * f4 + f6 * f6);
            float f8 = MathHelper.func_76129_c(f4 * f4 + f5 * f5 + f6 * f6);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)x, (float)y + 1.0F, (float)z);
            GL11.glRotatef((float)(-Math.atan2((double)f6, (double)f4)) * 180.0F / (float)Math.PI - 90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef((float)(-Math.atan2((double)f7, (double)f5)) * 180.0F / (float)Math.PI - 90.0F, 1.0F, 0.0F, 0.0F);
            Tessellator tessellator = Tessellator.field_78398_a;
            RenderHelper.func_74518_a();
            GL11.glDisable(2884);
            this.func_110776_a(enderColossusCrystalBeamTextures);
            GL11.glShadeModel(7425);
            float f9 = f1 * 0.005F;
            float f10 = MathHelper.func_76129_c(f4 * f4 + f5 * f5 + f6 * f6) / 32.0F - f9;
            tessellator.func_78371_b(5);
            byte b0 = 64;
            int c0 = 15728880;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glEnable(2896);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 2.0F);

            for(int i = 0; i <= b0; ++i) {
                float f11 = MathHelper.func_76126_a((float)(i % b0) * (float)Math.PI * 2.0F / (float)b0) * 0.75F;
                float f12 = MathHelper.func_76134_b((float)(i % b0) * (float)Math.PI * 2.0F / (float)b0) * 0.75F;
                float f13 = (float)(i % b0) * 1.0F / (float)b0;
                tessellator.func_78378_d(0);
                tessellator.func_78374_a((double)(f11 * 0.2F), (double)(f12 * 0.2F), (double)0.0F, (double)f13, (double)f10);
                tessellator.func_78378_d(16777215);
                tessellator.func_78374_a((double)f11, (double)f12, (double)f8, (double)f13, (double)f9);
            }

            tessellator.func_78381_a();
            GL11.glEnable(2884);
            GL11.glShadeModel(7424);
            RenderHelper.func_74519_b();
            GL11.glPopMatrix();
        }

    }

    protected ResourceLocation getEntityTexture(EntityEnderColossusCrystal p_110775_1_) {
        return enderCrystalTextures;
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_) {
        return this.getEntityTexture((EntityEnderColossusCrystal)p_110775_1_);
    }

    public void doRender(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntityEnderColossusCrystal)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void doRender(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntityEnderColossusCrystal)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityEnderColossusCrystal)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
