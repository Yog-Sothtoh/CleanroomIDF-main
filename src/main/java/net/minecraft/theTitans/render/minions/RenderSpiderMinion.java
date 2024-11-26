//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render.minions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntitySpiderMinion;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSpiderMinion extends RenderLiving {
    private static final ResourceLocation spiderTemplarEyesTextures = new ResourceLocation("thetitans", "textures/entities/minions/spiders/spider_templar_overlay.png");
    private static final ResourceLocation spiderEyesTextures = new ResourceLocation("textures/entity/spider_eyes.png");
    private static final ResourceLocation spiderTextures = new ResourceLocation("textures/entity/spider/spider.png");
    private static final ResourceLocation spiderPriestTextures = new ResourceLocation("thetitans", "textures/entities/minions/spiders/spider_priest.png");
    private static final ResourceLocation spiderZealotTextures = new ResourceLocation("thetitans", "textures/entities/minions/spiders/spider_zealot.png");
    private static final ResourceLocation spiderBishopTextures = new ResourceLocation("thetitans", "textures/entities/minions/spiders/spider_bishop.png");
    private static final ResourceLocation spiderTemplarTextures = new ResourceLocation("thetitans", "textures/entities/minions/spiders/spider_templar.png");

    public RenderSpiderMinion() {
        super(new ModelSpider(), 1.0F);
        this.func_77042_a(new ModelSpider());
    }

    protected float getDeathMaxRotation(EntitySpiderMinion p_77037_1_) {
        return 180.0F;
    }

    protected int shouldRenderPass(EntitySpiderMinion p_77032_1_, int p_77032_2_, float p_77032_3_) {
        if (p_77032_2_ != 0) {
            return -1;
        } else {
            this.func_110776_a(p_77032_1_.getMinionTypeInt() == 4 ? spiderTemplarEyesTextures : spiderEyesTextures);
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(1, 1);
            if (p_77032_1_.func_82150_aj()) {
                GL11.glDepthMask(false);
            } else {
                GL11.glDepthMask(true);
            }

            char c0 = '\uf0f0';
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            return 1;
        }
    }

    protected ResourceLocation getEntityTexture(EntitySpiderMinion p_110775_1_) {
        switch (p_110775_1_.getMinionTypeInt()) {
            case 1:
                return spiderPriestTextures;
            case 2:
                return spiderZealotTextures;
            case 3:
                return spiderBishopTextures;
            case 4:
                return spiderTemplarTextures;
            default:
                return spiderTextures;
        }
    }

    protected float func_77037_a(EntityLivingBase p_77037_1_) {
        return this.getDeathMaxRotation((EntitySpiderMinion)p_77037_1_);
    }

    protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntitySpiderMinion)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_) {
        return this.getEntityTexture((EntitySpiderMinion)p_110775_1_);
    }
}
