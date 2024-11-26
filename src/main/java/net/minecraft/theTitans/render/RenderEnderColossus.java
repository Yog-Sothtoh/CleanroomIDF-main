//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.theTitans.models.ModelEnderColossus;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderEnderColossus extends RenderLiving {
    private static final ResourceLocation endermanEyeBeamTexture = new ResourceLocation("thetitans", "textures/entities/titans/ender_colossus_beam.png");
    private static final ResourceLocation endermanEyesTexture = new ResourceLocation("thetitans", "textures/entities/titans/ender_colossus_eyes.png");
    private static final ResourceLocation endermanTextures = new ResourceLocation("thetitans", "textures/entities/titans/ender_colossus.png");
    private static final ResourceLocation endermanEyesDeadTexture = new ResourceLocation("thetitans", "textures/entities/titans/ender_colossus_eyes_dead.png");
    private static final ResourceLocation endermanDeadTextures = new ResourceLocation("thetitans", "textures/entities/titans/ender_colossus_dead.png");
    private ModelEnderColossus endermanModel;
    private Random rnd = new Random();

    public RenderEnderColossus() {
        super(new ModelEnderColossus(), 0.5F);
        this.endermanModel = (ModelEnderColossus)this.field_77045_g;
        this.func_77042_a(this.endermanModel);
    }

    protected void func_180592_a(EntityEnderColossus p_180592_1_, float p_180592_2_) {
        float f1 = 24.0F;
        int i = p_180592_1_.getInvulTime();
        if (i > 0) {
            f1 -= ((float)i - p_180592_2_) / 440.0F * 7.75F;
        }

        int i2 = p_180592_1_.getExtraPower();
        if (i2 > 0) {
            f1 += (float)i2 * 0.5F;
        }

        GL11.glScalef(f1, f1, f1);
        GL11.glTranslatef(0.0F, 0.015F, 0.0F);
        if (p_180592_1_.field_70154_o != null) {
            GL11.glTranslatef(0.0F, 0.1F, 0.0F);
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
        }

    }

    protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.func_180592_a((EntityEnderColossus)p_77041_1_, p_77041_2_);
    }

    public void doRender(EntityEnderColossus entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.endermanModel.isAttacking = entity.isScreaming();
        super.func_76986_a(entity, x, y, z, p_76986_8_, partialTicks);
        if (entity.getEyeLaserTime() >= 0 && entity.func_110143_aJ() > 0.0F) {
            Tessellator tessellator = Tessellator.field_78398_a;
            this.func_110776_a(endermanEyeBeamTexture);
            GL11.glTexParameterf(3553, 10242, 10497.0F);
            GL11.glTexParameterf(3553, 10243, 10497.0F);
            GL11.glDisable(2896);
            GL11.glDisable(2884);
            GL11.glDisable(3042);
            GL11.glDepthMask(true);
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
            OpenGlHelper.func_148821_a(770, 1, 1, 0);
            float f4 = (float)entity.field_70170_p.func_82737_E() + partialTicks;
            float f5 = f4 * 0.5F % 1.0F;
            float f6 = entity.func_70047_e();
            GL11.glPushMatrix();
            float f = entity.field_70759_as * (float)Math.PI / 180.0F;
            float f1 = MathHelper.func_76126_a(f);
            float f2 = MathHelper.func_76134_b(f);
            GL11.glTranslatef((float)x, (float)y + f6 + (0.02F + 0.02F * MathHelper.func_76134_b(partialTicks * 0.05F)) * (float)Math.PI, (float)z);
            GL11.glScalef(32.0F, 32.0F, 32.0F);
            Vec3 vec3 = this.func_177110_b(entity, (double)f6, partialTicks);
            Vec3 vec31 = this.func_177110_a(entity, (double)f6, partialTicks);
            Vec3 vec32 = vec3.func_72444_a(vec31);
            double d3 = vec32.func_72433_c() + 0.1;
            vec32 = vec32.func_72432_b();
            float f7 = (float)Math.acos(vec32.field_72448_b);
            float f8 = (float)Math.atan2(vec32.field_72449_c, vec32.field_72450_a);
            GL11.glRotatef((((float)Math.PI / 2F) + -f8) * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(f7 * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
            double d4 = (double)f4 * 0.005 * (double)-1.5F;
            tessellator.func_78382_b();
            tessellator.func_78370_a(255, 0, 255, 255);
            double d15 = Math.cos(d4 * (double)0.0F + Math.PI) * 0.2;
            double d16 = Math.sin(d4 * (double)0.0F + Math.PI) * 0.2;
            double d17 = Math.cos(d4 * (double)0.0F + (double)0.0F) * 0.2;
            double d18 = Math.sin(d4 * (double)0.0F + (double)0.0F) * 0.2;
            double d25 = (double)(-1.0F + f5);
            double d26 = d3 * (double)2.5F + d25;
            tessellator.func_78374_a(d15, -d3, d16, (double)0.5F, d26);
            tessellator.func_78374_a(d15, (double)0.0F, d16, (double)0.5F, d25);
            tessellator.func_78374_a(d17, (double)0.0F, d18, (double)0.0F, d25);
            tessellator.func_78374_a(d17, -d3, d18, (double)0.0F, d26);
            tessellator.func_78381_a();
            GL11.glPopMatrix();
        }

    }

    private Vec3 func_177110_a(EntityLivingBase p_177110_1_, double p_177110_2_, float p_177110_4_) {
        double d1 = p_177110_1_.field_70142_S + (p_177110_1_.field_70165_t - p_177110_1_.field_70142_S) * (double)p_177110_4_;
        double d2 = p_177110_2_ + p_177110_1_.field_70137_T + (p_177110_1_.field_70163_u - p_177110_1_.field_70137_T) * (double)p_177110_4_;
        double d3 = p_177110_1_.field_70136_U + (p_177110_1_.field_70161_v - p_177110_1_.field_70136_U) * (double)p_177110_4_;
        return Vec3.func_72443_a(d1, d2, d3);
    }

    private Vec3 func_177110_b(EntityLivingBase p_177110_1_, double p_177110_2_, float p_177110_4_) {
        Vec3 vec3 = p_177110_1_.func_70040_Z();
        double dx = vec3.field_72450_a * (double)300.0F;
        double dy = vec3.field_72448_b * (double)300.0F;
        double dz = vec3.field_72449_c * (double)300.0F;
        double d1 = p_177110_1_.field_70142_S + (p_177110_1_.field_70165_t + dx - p_177110_1_.field_70142_S) * (double)p_177110_4_;
        double d2 = p_177110_2_ + p_177110_1_.field_70137_T + (p_177110_1_.field_70163_u + dy - p_177110_1_.field_70137_T) * (double)p_177110_4_;
        double d3 = p_177110_1_.field_70136_U + (p_177110_1_.field_70161_v + dz - p_177110_1_.field_70136_U) * (double)p_177110_4_;
        return Vec3.func_72443_a(d1, d2, d3);
    }

    protected int shouldRenderPass(EntityEnderColossus p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_2_ != 0) {
            return -1;
        } else {
            if (p_77032_1_.getAnimID() == 10 && p_77032_1_.deathTicks > 160) {
                this.func_110776_a(endermanEyesDeadTexture);
            } else {
                this.func_110776_a(p_77032_1_.getEyeLaserTime() >= 0 ? endermanEyesDeadTexture : endermanEyesTexture);
            }

            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(1, 1);
            GL11.glDisable(2896);
            if (p_77032_1_.func_82150_aj()) {
                GL11.glDepthMask(false);
            } else {
                GL11.glDepthMask(true);
            }

            int c0 = 15728880;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glEnable(2896);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            return 1;
        }
    }

    protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityEnderColossus)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected ResourceLocation func_180573_a(EntityEnderColossus p_180573_1_) {
        return p_180573_1_.getAnimID() == 10 && p_180573_1_.deathTicks > 200 ? endermanDeadTextures : endermanTextures;
    }

    public void func_76986_a(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntityEnderColossus)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void func_76986_a(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntityEnderColossus)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.func_180573_a((EntityEnderColossus)entity);
    }

    public void func_76986_a(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntityEnderColossus)entity, x, y, z, p_76986_8_, partialTicks);
    }
}
