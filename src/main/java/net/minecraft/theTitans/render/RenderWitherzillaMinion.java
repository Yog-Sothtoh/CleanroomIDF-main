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
import net.minecraft.entity.titan.EntityWitherzillaMinion;
import net.minecraft.theTitans.models.ModelWitherzillaMinion;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderWitherzillaMinion extends RenderLiving {
    private static final ResourceLocation invulnerableWitherTextures = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
    private static final ResourceLocation witherTextures = new ResourceLocation("textures/entity/wither/wither.png");
    private int field_82419_a;

    public RenderWitherzillaMinion() {
        super(new ModelWitherzillaMinion(), 1.0F);
        this.field_82419_a = ((ModelWitherzillaMinion)this.field_77045_g).func_82903_a();
    }

    public void doRender(EntityWitherzillaMinion p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        int i = ((ModelWitherzillaMinion)this.field_77045_g).func_82903_a();
        if (i != this.field_82419_a) {
            this.field_82419_a = i;
            this.field_77045_g = new ModelWitherzillaMinion();
        }

        super.func_76986_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(EntityWitherzillaMinion p_110775_1_) {
        int i = p_110775_1_.getInvulTime();
        return i <= 0 || i <= 80 && i / 5 % 2 == 1 ? witherTextures : invulnerableWitherTextures;
    }

    protected void preRenderCallback(EntityWitherzillaMinion p_77041_1_, float p_77041_2_) {
        int i = p_77041_1_.getInvulTime();
        if (i > 0) {
            float f1 = 2.0F - ((float)i - p_77041_2_) / 220.0F * 0.5F;
            GL11.glScalef(f1, f1, f1);
        } else {
            GL11.glScalef(2.0F, 2.0F, 2.0F);
        }

    }

    protected int shouldRenderPass(EntityWitherzillaMinion p_77032_1_, int p_77032_2_, float p_77032_3_) {
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

    protected int inheritRenderPass(EntityWitherzillaMinion p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return -1;
    }

    public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityWitherzillaMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntityWitherzillaMinion)p_77041_1_, p_77041_2_);
    }

    protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityWitherzillaMinion)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected int func_77035_b(EntityLivingBase p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return this.inheritRenderPass((EntityWitherzillaMinion)p_77035_1_, p_77035_2_, p_77035_3_);
    }

    public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityWitherzillaMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_) {
        return this.getEntityTexture((EntityWitherzillaMinion)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityWitherzillaMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
