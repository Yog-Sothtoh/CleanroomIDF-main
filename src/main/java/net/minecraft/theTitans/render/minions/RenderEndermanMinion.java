//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render.minions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntityEndermanMinion;
import net.minecraft.entity.titanminion.EnumMinionType;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderEndermanMinion extends RenderLiving {
    private static final ResourceLocation endermanEyesTexture = new ResourceLocation("textures/entity/enderman/enderman_eyes.png");
    private static final ResourceLocation endermanTextures = new ResourceLocation("textures/entity/enderman/enderman.png");
    private static final ResourceLocation endermanPriestTextures = new ResourceLocation("thetitans", "textures/entities/minions/endermen/enderman_priest.png");
    private static final ResourceLocation endermanZealotTextures = new ResourceLocation("thetitans", "textures/entities/minions/endermen/enderman_zealot.png");
    private static final ResourceLocation endermanBishopTextures = new ResourceLocation("thetitans", "textures/entities/minions/endermen/enderman_bishop.png");
    private static final ResourceLocation endermanTemplarTextures = new ResourceLocation("thetitans", "textures/entities/minions/endermen/enderman_templar.png");
    private ModelEnderman endermanModel;
    private Random rnd = new Random();

    public RenderEndermanMinion() {
        super(new ModelEnderman(), 0.5F);
        this.endermanModel = (ModelEnderman)this.field_77045_g;
        this.func_77042_a(this.endermanModel);
    }

    public void doRender(EntityEndermanMinion entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.endermanModel.field_78126_a = entity.func_146080_bZ().func_149688_o() != Material.field_151579_a;
        this.endermanModel.field_78125_b = entity.func_70823_r();
        double d3 = 0.01;
        if (entity.func_70823_r()) {
            x += this.rnd.nextGaussian() * d3;
            z += this.rnd.nextGaussian() * d3;
        }

        super.func_76986_a(entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected ResourceLocation func_180573_a(EntityEndermanMinion p_180573_1_) {
        switch (p_180573_1_.getMinionTypeInt()) {
            case 1:
                return endermanPriestTextures;
            case 2:
                return endermanZealotTextures;
            case 3:
                return endermanBishopTextures;
            case 4:
                return endermanTemplarTextures;
            default:
                return endermanTextures;
        }
    }

    protected void renderEquippedItems(EntityEndermanMinion p_77029_1_, float p_77029_2_) {
        super.func_77029_c(p_77029_1_, p_77029_2_);
        if (p_77029_1_.func_146080_bZ().func_149688_o() != Material.field_151579_a) {
            GL11.glEnable(32826);
            GL11.glPushMatrix();
            float f1 = 0.5F;
            GL11.glTranslatef(0.0F, 0.6875F, -0.75F);
            f1 *= 1.0F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(-f1, -f1, f1);
            int i = p_77029_1_.func_70070_b(p_77029_2_);
            int j = i % 65536;
            int k = i / 65536;
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.func_110776_a(TextureMap.field_110575_b);
            this.field_147909_c.func_147800_a(p_77029_1_.func_146080_bZ(), p_77029_1_.func_70824_q(), 1.0F);
            GL11.glPopMatrix();
            GL11.glDisable(32826);
        }

    }

    protected int shouldRenderPass(EntityEndermanMinion p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_2_ != 0) {
            return -1;
        } else {
            this.func_110776_a(endermanEyesTexture);
            if (p_77032_1_.getMinionType() == EnumMinionType.TEMPLAR) {
                this.func_110776_a(endermanEyesTexture);
            }

            float f1 = 1.0F;
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(1, 1);
            GL11.glDisable(2896);
            if (p_77032_1_.func_82150_aj()) {
                GL11.glDepthMask(false);
            } else {
                GL11.glDepthMask(true);
            }

            char c0 = '\uf0f0';
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glEnable(2896);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
            return 1;
        }
    }

    public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityEndermanMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityEndermanMinion)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_) {
        this.renderEquippedItems((EntityEndermanMinion)p_77029_1_, p_77029_2_);
    }

    public void func_76986_a(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntityEndermanMinion)entity, x, y, z, p_76986_8_, partialTicks);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.func_180573_a((EntityEndermanMinion)entity);
    }

    public void func_76986_a(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.doRender((EntityEndermanMinion)entity, x, y, z, p_76986_8_, partialTicks);
    }
}
