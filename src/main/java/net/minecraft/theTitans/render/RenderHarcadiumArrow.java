//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderHarcadiumArrow extends RenderArrow {
    private static final ResourceLocation arrowTextures = new ResourceLocation("thetitans", "textures/entities/harcadium_arrow_entity.png");

    public RenderHarcadiumArrow() {
    }

    protected ResourceLocation func_110775_a(EntityArrow p_180550_1_) {
        return arrowTextures;
    }
}
