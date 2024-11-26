//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityProtoBall;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderProtoBall extends Render {
    public RenderProtoBall() {
        this.field_76989_e = 1.0F;
    }

    protected ResourceLocation getTextures(EntityProtoBall p_180554_1_) {
        return null;
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.getTextures((EntityProtoBall)entity);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
    }
}
