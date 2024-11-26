//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntityWitherMinion;
import net.minecraft.theTitans.models.ModelWitherMinion;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderWitherMinion extends RenderLiving {
    private static final ResourceLocation witherEmpowermentBeamTextures = new ResourceLocation("thetitans", "textures/entities/wither_empowerment_beam.png");
    private static final ResourceLocation invulnerableWitherTextures = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
    private static final ResourceLocation witherTextures = new ResourceLocation("textures/entity/wither/wither.png");
    private int field_82419_a;

    public RenderWitherMinion() {
        super(new ModelWitherMinion(), 1.0F);
        this.field_82419_a = ((ModelWitherMinion)this.field_77045_g).func_82903_a();
    }

    public void doRender(EntityWitherMinion entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        int e = ((ModelWitherMinion)this.field_77045_g).func_82903_a();
        if (e != this.field_82419_a) {
            this.field_82419_a = e;
            this.field_77045_g = new ModelWitherMinion();
        }

        super.func_76986_a(entity, x, y, z, p_76986_8_, partialTicks);
        if (entity.master != null && entity.func_70089_S()) {
            float f1 = (float)entity.field_70173_aa + partialTicks;
            float f4 = (float)(entity.master.field_70165_t - entity.field_70165_t - (entity.field_70169_q - entity.field_70165_t) * (double)(1.0F - partialTicks));
            float f5 = (float)(entity.master.field_70163_u + (double)entity.master.func_70047_e() - entity.field_70163_u - (entity.field_70167_r - entity.field_70163_u) * (double)(1.0F - partialTicks));
            float f6 = (float)(entity.master.field_70161_v - entity.field_70161_v - (entity.field_70166_s - entity.field_70161_v) * (double)(1.0F - partialTicks));
            float f7 = MathHelper.func_76129_c(f4 * f4 + f6 * f6);
            float f8 = MathHelper.func_76129_c(f4 * f4 + f5 * f5 + f6 * f6);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)x, (float)y + entity.func_70047_e(), (float)z);
            GL11.glRotatef((float)(-Math.atan2((double)f6, (double)f4)) * 180.0F / (float)Math.PI - 90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef((float)(-Math.atan2((double)f7, (double)f5)) * 180.0F / (float)Math.PI - 90.0F, 1.0F, 0.0F, 0.0F);
            Tessellator tessellator = Tessellator.field_78398_a;
            RenderHelper.func_74518_a();
            GL11.glDisable(2884);
            this.func_110776_a(witherEmpowermentBeamTextures);
            GL11.glShadeModel(7425);
            float f9 = f1 * 0.005F;
            float f10 = MathHelper.func_76129_c(f4 * f4 + f5 * f5 + f6 * f6) / 32.0F + f9;
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

    protected ResourceLocation getEntityTexture(EntityWitherMinion entity) {
        int i = entity.getInvulTime();
        return i <= 0 || i <= 80 && i / 5 % 2 == 1 ? witherTextures : invulnerableWitherTextures;
    }

    protected void preRenderCallback(EntityWitherMinion p_180592_1_, float p_180592_2_) {
        float f1 = 2.0F;
        int i = p_180592_1_.getInvulTime();
        if (i > 0) {
            f1 -= ((float)i - p_180592_2_) / 220.0F * 0.5F;
        }

        GL11.glScalef(f1, f1, f1);
    }

    protected int shouldRenderPass(EntityWitherMinion p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_1_.isArmored()) {
            if (p_77032_1_.func_82150_aj()) {
                GL11.glDepthMask(false);
            } else {
                GL11.glDepthMask(true);
            }

            if (p_77032_2_ == 1) {
                float f1 = (float)p_77032_1_.field_70173_aa + p_77032_3_;
                this.func_110776_a(invulnerableWitherTextures);
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                float f2 = MathHelper.func_76134_b(f1 * 0.02F) * 3.0F;
                float f3 = f1 * 0.01F;
                GL11.glTranslatef(f2, f3, 0.0F);
                this.func_77042_a(this.field_77045_g);
                GL11.glMatrixMode(5888);
                GL11.glEnable(3042);
                float f4 = 0.5F;
                GL11.glColor4f(f4, f4, f4, 1.0F);
                GL11.glDisable(2896);
                GL11.glBlendFunc(1, 1);
                GL11.glTranslatef(0.0F, -0.01F, 0.0F);
                GL11.glScalef(1.1F, 1.1F, 1.1F);
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

    protected int inheritRenderPass(EntityWitherMinion p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return -1;
    }

    public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityWitherMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntityWitherMinion)p_77041_1_, p_77041_2_);
    }

    protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityWitherMinion)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected int func_77035_b(EntityLivingBase p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return this.inheritRenderPass((EntityWitherMinion)p_77035_1_, p_77035_2_, p_77035_3_);
    }

    public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityWitherMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_) {
        return this.getEntityTexture((EntityWitherMinion)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityWitherMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
