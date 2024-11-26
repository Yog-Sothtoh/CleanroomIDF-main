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
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.models.ModelSkeletonTitan;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSkeletonTitan extends RenderLiving {
    private static final ResourceLocation skeletonTitanTextures = new ResourceLocation("thetitans", "textures/entities/titans/skeleton_titan.png");
    private static final ResourceLocation skeletonTitanPull1Textures = new ResourceLocation("thetitans", "textures/entities/titans/skeleton_titan_pulling_0.png");
    private static final ResourceLocation skeletonTitanPull2Textures = new ResourceLocation("thetitans", "textures/entities/titans/skeleton_titan_pulling_1.png");
    private static final ResourceLocation skeletonTitanPull3Textures = new ResourceLocation("thetitans", "textures/entities/titans/skeleton_titan_pulling_2.png");
    private static final ResourceLocation skeletonTitanBrokenBowTextures = new ResourceLocation("thetitans", "textures/entities/titans/skeleton_titan_broken_bow.png");
    private static final ResourceLocation witherSkeletonTextures = new ResourceLocation("thetitans", "textures/entities/titans/wither_skeleton_titan.png");
    private ModelSkeletonTitan skeletonModel;
    private ModelBase overlayingModel = new ModelSkeletonTitan(0.1F);

    public RenderSkeletonTitan() {
        super(new ModelSkeletonTitan(), 0.5F);
        this.skeletonModel = (ModelSkeletonTitan)this.field_77045_g;
    }

    public void doRender(EntitySkeletonTitan entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        if (entity.getSkeletonType() == 1) {
            this.skeletonModel.isWither = true;
        } else {
            this.skeletonModel.isWither = false;
        }

        super.func_76986_a(entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected void preRenderCallback(EntitySkeletonTitan p_77041_1_, float p_77041_2_) {
        float f1 = p_77041_1_.getSkeletonType() == 1 ? 28.0F : 16.0F;
        int i = p_77041_1_.getInvulTime();
        if (i > 0) {
            f1 -= ((float)i - p_77041_2_) / 440.0F * 7.75F;
        }

        int i2 = p_77041_1_.getExtraPower();
        if (i2 > 0) {
            f1 += (float)i2 * 0.5F;
        }

        GL11.glScalef(f1, f1, f1);
        GL11.glTranslatef(0.0F, 0.0075F, 0.0F);
    }

    protected ResourceLocation func_180577_a(EntitySkeletonTitan p_180577_1_) {
        return p_180577_1_.getSkeletonType() == 1 ? witherSkeletonTextures : (p_180577_1_.attackTimer < 20 && p_180577_1_.attackTimer >= 10 ? skeletonTitanPull1Textures : (p_180577_1_.attackTimer < 30 && p_180577_1_.attackTimer >= 20 ? skeletonTitanPull2Textures : (p_180577_1_.attackTimer >= 30 ? skeletonTitanPull3Textures : (p_180577_1_.isStunned ? skeletonTitanBrokenBowTextures : skeletonTitanTextures))));
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return this.func_180577_a((EntitySkeletonTitan)entity);
    }

    protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntitySkeletonTitan)p_77041_1_, p_77041_2_);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.func_180577_a((EntitySkeletonTitan)entity);
    }

    protected int shouldRenderPass(EntitySkeletonTitan p_77032_1_, int p_77032_2_, float p_77032_3_) {
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
                ((ModelSkeletonTitan)this.overlayingModel).HeldItem.field_78806_j = false;
                ((ModelSkeletonTitan)this.overlayingModel).HeldItem2.field_78806_j = false;
                GL11.glMatrixMode(5888);
                GL11.glEnable(3042);
                GL11.glColor4f(p_77032_1_.getSkeletonType() == 1 ? 0.1F : 0.0F, p_77032_1_.getSkeletonType() == 1 ? 0.1F : 0.6F + MathHelper.func_76134_b(f1 * 0.05F) * 0.1F, p_77032_1_.getSkeletonType() == 1 ? 0.1F : 0.7F + MathHelper.func_76134_b(f1 * 0.05F) * 0.1F, 1.0F);
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

    protected int inheritRenderPass(EntitySkeletonTitan p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return -1;
    }

    protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntitySkeletonTitan)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected int func_77035_b(EntityLivingBase p_77035_1_, int p_77035_2_, float p_77035_3_) {
        return this.inheritRenderPass((EntitySkeletonTitan)p_77035_1_, p_77035_2_, p_77035_3_);
    }

    public void func_180579_a(EntitySkeletonTitan p_180579_1_, double p_180579_2_, double p_180579_4_, double p_180579_6_, float p_180579_8_, float p_180579_9_) {
        super.func_76986_a(p_180579_1_, p_180579_2_, p_180579_4_, p_180579_6_, p_180579_8_, p_180579_9_);
    }

    public void func_76986_a(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySkeletonTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void func_76986_a(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySkeletonTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void func_76986_a(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySkeletonTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }
}
