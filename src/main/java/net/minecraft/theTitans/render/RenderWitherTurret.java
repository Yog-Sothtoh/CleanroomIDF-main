//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntityWitherTurret;
import net.minecraft.theTitans.models.ModelWitherTurret;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderWitherTurret extends RenderLiving {
    private static final ResourceLocation witherTextures = new ResourceLocation("textures/entity/wither/wither.png");
    private ModelWitherTurret modelTurret;

    public RenderWitherTurret() {
        super(new ModelWitherTurret(0.0F), 1.0F);
    }

    protected void func_180592_a(EntityWitherTurret p_180592_1_, float p_180592_2_) {
        GL11.glScalef(2.0F, 2.0F, 2.0F);
    }

    protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.func_180592_a((EntityWitherTurret)p_77041_1_, p_77041_2_);
    }

    protected ResourceLocation getEntityTexture(EntityWitherTurret entity) {
        return witherTextures;
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.getEntityTexture((EntityWitherTurret)entity);
    }
}
