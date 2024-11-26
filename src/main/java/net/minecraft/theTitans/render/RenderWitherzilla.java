//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.models.ModelWitherzilla;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderWitherzilla extends RenderLiving {
    private static final ResourceLocation enderDragonExplodingTextures = new ResourceLocation("textures/entity/enderdragon/dragon_exploding.png");
    private static final ResourceLocation witherzillaSheild = new ResourceLocation("thetitans", "textures/entities/wither_aura.png");
    private static final ResourceLocation witherzillaOmegaTextures = new ResourceLocation("thetitans", "textures/entities/titans/witherzilla_omega.png");
    private static final ResourceLocation witherzillaTextures = new ResourceLocation("thetitans", "textures/entities/titans/witherzilla.png");
    private int field_82419_a;
    private ModelWitherzilla model;

    public RenderWitherzilla() {
        super(new ModelWitherzilla(), 1.0F);
        this.model = (ModelWitherzilla)this.field_77045_g;
        this.field_82419_a = ((ModelWitherzilla)this.field_77045_g).func_82903_a();
    }

    protected void renderEquippedItems(EntityWitherzilla p_77029_1_, float p_77029_2_) {
        super.func_77029_c(p_77029_1_, p_77029_2_);
        GL11.glEnable(32826);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, -2.0F, 0.0F);
        GL11.glScalef(0.05F, 0.05F, 0.05F);
        int i = p_77029_1_.func_70070_b(p_77029_2_);
        int j = i % 65536;
        int k = i / 65536;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.func_110776_a(TextureMap.field_110575_b);
        this.field_147909_c.func_147800_a(Blocks.field_150426_aN, 0, 1.0F);
        GL11.glPopMatrix();
        GL11.glDisable(32826);
        Tessellator tessellator = Tessellator.field_78398_a;
        if (p_77029_1_.affectTicks > 0 && p_77029_1_.getInvulTime() < 1) {
            RenderHelper.func_74518_a();
            float f111 = ((float)p_77029_1_.affectTicks + p_77029_2_) / 1000.0F;
            float f211 = 0.0F;
            if (f111 > 0.8F) {
                f211 = (f111 - 0.8F) / 0.2F;
            }

            Random random11 = new Random(432L);
            GL11.glDisable(3553);
            GL11.glShadeModel(7425);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 1);
            GL11.glDisable(3008);
            GL11.glEnable(2884);
            GL11.glDepthMask(false);
            GL11.glTranslatef(0.0F, -2.0F, 0.0F);
            GL11.glPushMatrix();

            for(int i1 = 0; (float)i1 < (f111 + f111 * f111) / 2.0F * 100.0F; ++i1) {
                GL11.glRotatef(random11.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(random11.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(random11.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(random11.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(random11.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(random11.nextFloat() * 360.0F + f111 * 90.0F, 0.0F, 0.0F, 1.0F);
                tessellator.func_78371_b(6);
                float f3 = random11.nextFloat() * 10.0F + 5.0F + f211 * 20.0F;
                float f4 = random11.nextFloat() * 2.0F + 1.0F + f211 * 2.0F;
                tessellator.func_78384_a(14809319, (int)(255.0F * (1.0F - f211)));
                tessellator.func_78377_a((double)0.0F, (double)0.0F, (double)0.0F);
                tessellator.func_78384_a(14809319, 0);
                tessellator.func_78377_a(-0.866 * (double)f4, (double)f3, (double)(-0.5F * f4));
                tessellator.func_78377_a(0.866 * (double)f4, (double)f3, (double)(-0.5F * f4));
                tessellator.func_78377_a((double)0.0F, (double)f3, (double)(1.0F * f4));
                tessellator.func_78377_a(-0.866 * (double)f4, (double)f3, (double)(-0.5F * f4));
                tessellator.func_78381_a();
            }

            GL11.glPopMatrix();
            GL11.glDepthMask(true);
            GL11.glDisable(2884);
            GL11.glDisable(3042);
            GL11.glShadeModel(7424);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(3553);
            GL11.glEnable(3008);
            RenderHelper.func_74519_b();
        } else if (p_77029_1_.deathTicks > 0) {
            RenderHelper.func_74518_a();
            float f111 = ((float)p_77029_1_.deathTicks + p_77029_2_) / 300.0F;
            float f211 = 0.0F;
            if (f111 > 0.8F) {
                f211 = (f111 - 0.8F) / 0.2F;
            }

            Random random11 = new Random(432L);
            GL11.glDisable(3553);
            GL11.glShadeModel(7425);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 1);
            GL11.glDisable(3008);
            GL11.glEnable(2884);
            GL11.glDepthMask(false);
            GL11.glPushMatrix();

            for(int i1 = 0; (float)i1 < (f111 + f111 * f111) / 2.0F * 800.0F; ++i1) {
                GL11.glRotatef(random11.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(random11.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(random11.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(random11.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(random11.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(random11.nextFloat() * 360.0F + f111 * 90.0F, 0.0F, 0.0F, 1.0F);
                tessellator.func_78371_b(6);
                float f3 = random11.nextFloat() * 2.0F + 1.0F + f211 * 20.0F;
                float f4 = random11.nextFloat() * 4.0F + 2.0F + f211 * 4.0F;
                tessellator.func_78384_a(14809319, (int)(255.0F * (1.0F - f211)));
                tessellator.func_78377_a((double)0.0F, (double)0.0F, (double)0.0F);
                tessellator.func_78384_a(14809319, 0);
                tessellator.func_78377_a(-0.866 * (double)f4, (double)f3, (double)(-0.5F * f4));
                tessellator.func_78377_a(0.866 * (double)f4, (double)f3, (double)(-0.5F * f4));
                tessellator.func_78377_a((double)0.0F, (double)f3, (double)(1.0F * f4));
                tessellator.func_78377_a(-0.866 * (double)f4, (double)f3, (double)(-0.5F * f4));
                tessellator.func_78381_a();
            }

            GL11.glPopMatrix();
            GL11.glDepthMask(true);
            GL11.glDisable(2884);
            GL11.glDisable(3042);
            GL11.glShadeModel(7424);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(3553);
            GL11.glEnable(3008);
            RenderHelper.func_74519_b();
        }

    }

    protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_) {
        this.renderEquippedItems((EntityWitherzilla)p_77029_1_, p_77029_2_);
    }

    protected int shouldRenderPass(EntityWitherzilla p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_1_.isArmored() || p_77032_1_.isInOmegaForm()) {
            if (p_77032_1_.func_82150_aj()) {
                GL11.glDepthMask(false);
            } else {
                GL11.glDepthMask(true);
            }

            if (p_77032_2_ == 1) {
                float f1 = (float)p_77032_1_.field_70173_aa + p_77032_3_;
                int i = p_77032_1_.getInvulTime();
                this.func_110776_a(i <= 0 || i <= 300 && i / 10 % 2 == 1 ? witherzillaSheild : TheTitans.genericTitanWhiteTexture64x64);
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                float f2 = f1 * 0.015F;
                float f3 = f1 * 0.01F;
                GL11.glTranslatef(f2, f3, 0.0F);
                this.func_77042_a(this.field_77045_g);
                GL11.glMatrixMode(5888);
                GL11.glEnable(3042);
                float f4 = 0.5F;
                GL11.glColor4f(f4, f4, f4, 1.0F);
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

        return -1;
    }

    protected int inheritRenderPass(EntityWitherzilla p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return -1;
    }

    protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityWitherzilla)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected int func_77035_b(EntityLivingBase p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return this.inheritRenderPass((EntityWitherzilla)p_77035_1_, p_77035_2_, p_77035_3_);
    }

    protected void renderModel(EntityWitherzilla p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
        this.func_110777_b(p_77036_1_);
        if (!p_77036_1_.func_82150_aj()) {
            this.field_77045_g.func_78088_a(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
        } else if (!p_77036_1_.func_98034_c(Minecraft.func_71410_x().field_71439_g)) {
            if (p_77036_1_.deathTicks > 0) {
                float f6 = (float)p_77036_1_.deathTicks / 220.0F;
                GL11.glDepthFunc(514);
                GL11.glDisable(3553);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                this.func_110776_a(TheTitans.genericTitanWhiteTexture64x64);
                this.field_77045_g.func_78088_a(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
                GL11.glEnable(3553);
                GL11.glDisable(3042);
                GL11.glDepthFunc(515);
            }

            if (p_77036_1_.field_70737_aN > 0) {
                GL11.glDepthFunc(514);
                GL11.glDisable(3553);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.5F);
                this.field_77045_g.func_78088_a(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
                GL11.glEnable(3553);
                GL11.glDisable(3042);
                GL11.glDepthFunc(515);
            }
        } else {
            this.field_77045_g.func_78087_a(p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_, p_77036_1_);
        }

    }

    protected void func_77036_a(EntityLivingBase p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
        this.renderModel((EntityWitherzilla)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
    }

    public void func_180591_a(EntityWitherzilla p_180591_1_, double p_180591_2_, double p_180591_4_, double p_180591_6_, float p_180591_8_, float p_180591_9_) {
        int i = ((ModelWitherzilla)this.field_77045_g).func_82903_a();
        if (i != this.field_82419_a) {
            this.field_82419_a = i;
            this.field_77045_g = new ModelWitherzilla();
        }

        super.func_76986_a(p_180591_1_, p_180591_2_, p_180591_4_, p_180591_6_, p_180591_8_, p_180591_9_);
    }

    protected ResourceLocation getEntityTexture(EntityWitherzilla entity) {
        int i = entity.getInvulTime();
        return i <= 0 || i <= 300 && i / 10 % 2 == 1 ? (!entity.func_85032_ar() && !entity.isInOmegaForm() ? witherzillaTextures : witherzillaOmegaTextures) : TheTitans.genericTitanWhiteTexture64x64;
    }

    protected void func_180592_a(EntityWitherzilla p_180592_1_, float p_180592_2_) {
        float f1 = p_180592_1_.isInOmegaForm() ? 256.0F : 128.0F;
        int i = p_180592_1_.getInvulTime();
        if (i > 0) {
            f1 -= ((float)i - p_180592_2_) / 440.0F * 7.75F;
        }

        int i2 = p_180592_1_.getExtraPower();
        if (i2 > 0) {
            f1 += (float)i2 * 0.5F;
        }

        GL11.glScalef(f1, f1, f1);
        if (p_180592_1_.isArmored()) {
            GL11.glTranslatef(0.0F, 2.0F, 0.0F);
        }

    }

    public void func_76986_a(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180591_a((EntityWitherzilla)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.func_180592_a((EntityWitherzilla)p_77041_1_, p_77041_2_);
    }

    public void func_76986_a(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180591_a((EntityWitherzilla)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.getEntityTexture((EntityWitherzilla)entity);
    }

    public void func_76986_a(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180591_a((EntityWitherzilla)entity, x, y, z, p_76986_8_, partialTicks);
    }
}
