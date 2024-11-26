//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import danger.orespawn.ModelKraken;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.orespawnaddon.EntityMethuselahKraken;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderMethuselahKraken extends RenderLiving {
    protected ModelKraken model;
    private float scale = 2.0F;
    private static final ResourceLocation texture = new ResourceLocation("thetitans", "textures/entities/methuselahkraken.png");

    public RenderMethuselahKraken() {
        super(new ModelKraken(1.0F), 2.0F);
        this.model = (ModelKraken)this.field_77045_g;
    }

    public void renderKraken(EntityMethuselahKraken par1EntityKraken, double par2, double par4, double par6, float par8, float par9) {
        super.func_76986_a(par1EntityKraken, par2, par4, par6, par8, par9);
    }

    public void func_76986_a(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderKraken((EntityMethuselahKraken)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderKraken((EntityMethuselahKraken)par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(EntityMethuselahKraken par1Entity, float par2) {
        if (par1Entity != null && par1Entity.getPlayNicely() != 0) {
            GL11.glScalef(this.scale / 3.0F, this.scale / 3.0F, this.scale / 3.0F);
        } else {
            GL11.glScalef(this.scale, this.scale, this.scale);
        }
    }

    protected void func_77041_b(EntityLivingBase par1EntityLiving, float par2) {
        this.preRenderScale((EntityMethuselahKraken)par1EntityLiving, par2);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return texture;
    }
}
