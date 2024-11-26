//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render.minions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntityGhastMinion;
import net.minecraft.theTitans.models.ModelGhastGuard;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGhastMinion extends RenderLiving {
    private static final ResourceLocation ghastTextures = new ResourceLocation("textures/entity/ghast/ghast.png");
    private static final ResourceLocation ghastShootingTextures = new ResourceLocation("textures/entity/ghast/ghast_shooting.png");
    private static final ResourceLocation ghastPriestTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_priest.png");
    private static final ResourceLocation ghastPriestShootingTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_priest_shooting.png");
    private static final ResourceLocation ghastZealotTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_zealot.png");
    private static final ResourceLocation ghastZealotShootingTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_zealot_shooting.png");
    private static final ResourceLocation ghastBishopTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_bishop.png");
    private static final ResourceLocation ghastBishopShootingTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_bishop_shooting.png");
    private static final ResourceLocation ghastTemplarTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_templar.png");
    private static final ResourceLocation ghastTemplarShootingTextures = new ResourceLocation("thetitans", "textures/entities/minions/ghast/ghast_templar_shooting.png");

    public RenderGhastMinion() {
        super(new ModelGhastGuard(), 3.0F);
    }

    protected ResourceLocation func_180576_a(EntityGhastMinion p_180576_1_) {
        switch (p_180576_1_.getMinionTypeInt()) {
            case 1:
                return p_180576_1_.func_110182_bF() ? ghastPriestShootingTextures : ghastPriestTextures;
            case 2:
                return p_180576_1_.func_110182_bF() ? ghastZealotShootingTextures : ghastZealotTextures;
            case 3:
                return p_180576_1_.func_110182_bF() ? ghastBishopShootingTextures : ghastBishopTextures;
            case 4:
                return p_180576_1_.func_110182_bF() ? ghastTemplarShootingTextures : ghastTemplarTextures;
            default:
                return p_180576_1_.func_110182_bF() ? ghastShootingTextures : ghastTextures;
        }
    }

    protected void preRenderCallback(EntityGhastMinion p_77041_1_, float p_77041_2_) {
        float f1 = ((float)p_77041_1_.prevAttackCounter + (float)(p_77041_1_.attackCounter - p_77041_1_.prevAttackCounter) * p_77041_2_) / 20.0F;
        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        f1 = 1.0F / (f1 * f1 * f1 * f1 * f1 * 2.0F + 1.0F);
        float f2 = (8.0F + f1) / 2.0F;
        float f3 = (8.0F + 1.0F / f1) / 2.0F;
        GL11.glScalef(f3, f2, f3);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef(0.0F, 0.5F, 0.0F);
    }

    protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.preRenderCallback((EntityGhastMinion)p_77041_1_, p_77041_2_);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.func_180576_a((EntityGhastMinion)entity);
    }
}
