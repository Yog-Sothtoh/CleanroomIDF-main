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
import net.minecraft.entity.titan.EntityCreeperTitan;
import net.minecraft.theTitans.models.ModelCreeperTitan;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderCreeperTitan extends RenderLiving {
    private static final ResourceLocation armoredCreeperTextures = new ResourceLocation("thetitans", "textures/entities/titans/creeper_titan_charge.png");
    private static final ResourceLocation creeperTextures = new ResourceLocation("thetitans", "textures/entities/titans/creeper_titan.png");
    private ModelBase creeperModel = new ModelCreeperTitan(1.6F);

    public RenderCreeperTitan() {
        super(new ModelCreeperTitan(), 0.75F);
    }

    protected void preRenderCallback(EntityCreeperTitan p_180570_1_, float p_180570_2_) {
        float f1 = p_180570_1_.getCreeperFlashIntensity(p_180570_2_);
        float f2 = 1.0F + MathHelper.func_76126_a(f1 * 100.0F) * f1 * 0.01F;
        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        if (f1 > 1.0F) {
            f1 = 1.0F;
        }

        f1 *= f1;
        f1 *= f1;
        float f3 = (1.0F + f1 * 0.4F) * f2;
        float f4 = (1.0F + f1 * 0.1F) / f2;
        GL11.glScalef(f3, f4, f3);
        float fl = 16.0F;
        int i = p_180570_1_.getInvulTime();
        if (i > 0) {
            fl -= ((float)i - p_180570_2_) / 440.0F * 7.75F;
        }

        if (i > 900) {
            GL11.glScalef(1.0F, -1.0F, 1.0F);
        }

        int i2 = p_180570_1_.getExtraPower();
        if (i2 > 0) {
            float var10000 = f1 + (float)i2 * 0.5F;
        }

        GL11.glScalef(fl, fl, fl);
    }

    protected int func_180571_a(EntityCreeperTitan p_180571_1_, float p_180571_2_, float p_180571_3_) {
        float f2 = p_180571_1_.getCreeperFlashIntensity(p_180571_3_);
        if ((int)(f2 * 10.0F) % 2 == 0) {
            return 0;
        } else {
            int i = (int)(f2 * 0.2F * 255.0F);
            if (i < 0) {
                i = 0;
            }

            if (i > 255) {
                i = 255;
            }

            short short1 = 255;
            short short2 = 255;
            short short3 = 255;
            return i << 24 | short1 << 16 | short2 << 8 | short3;
        }
    }

    protected ResourceLocation getEntityTexture(EntityCreeperTitan entity) {
        return creeperTextures;
    }

    protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntityCreeperTitan)p_77041_1_, p_77041_2_);
    }

    protected int func_77030_a(EntityLivingBase p_77030_1_, float p_77030_2_, float p_77030_3_) {
        return this.func_180571_a((EntityCreeperTitan)p_77030_1_, p_77030_2_, p_77030_3_);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.getEntityTexture((EntityCreeperTitan)entity);
    }

    public void func_180579_a(EntityCreeperTitan p_180579_1_, double p_180579_2_, double p_180579_4_, double p_180579_6_, float p_180579_8_, float p_180579_9_) {
        super.func_76986_a(p_180579_1_, p_180579_2_, p_180579_4_, p_180579_6_, p_180579_8_, p_180579_9_);
    }

    public void func_76986_a(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityCreeperTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void func_76986_a(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityCreeperTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void func_76986_a(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntityCreeperTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected int shouldRenderPass(EntityCreeperTitan p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_1_.getPowered()) {
            if (p_77032_1_.func_82150_aj()) {
                GL11.glDepthMask(false);
            } else {
                GL11.glDepthMask(true);
            }

            if (p_77032_2_ == 1) {
                float f1 = (float)p_77032_1_.field_70173_aa + p_77032_3_;
                this.func_110776_a(armoredCreeperTextures);
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                float f3 = f1 * 0.01F;
                GL11.glTranslatef(0.0F, f3, f3);
                this.func_77042_a(this.creeperModel);
                GL11.glMatrixMode(5888);
                GL11.glEnable(3042);
                float f4 = 0.75F;
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

    protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityCreeperTitan)p_77032_1_, p_77032_2_, p_77032_3_);
    }
}
