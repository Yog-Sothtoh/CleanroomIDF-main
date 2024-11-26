//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import danger.orespawn.ModelEmperorScorpion;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.orespawnaddon.EntityOverlordScorpion;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderOverlordScorpion extends RenderLiving {
    protected ModelEmperorScorpion model;
    private float scale = 1.5F;
    private static final ResourceLocation texture = new ResourceLocation("thetitans", "textures/entities/overlordscorpion.png");

    public RenderOverlordScorpion() {
        super(new ModelEmperorScorpion(0.22F), 1.75F);
        this.model = (ModelEmperorScorpion)this.field_77045_g;
    }

    protected void preRenderScale(EntityOverlordScorpion par1Entity, float par2) {
        GL11.glScalef(3.0F, 3.0F, 3.0F);
    }

    protected void func_77041_b(EntityLivingBase par1EntityLiving, float par2) {
        this.preRenderScale((EntityOverlordScorpion)par1EntityLiving, par2);
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return texture;
    }
}
