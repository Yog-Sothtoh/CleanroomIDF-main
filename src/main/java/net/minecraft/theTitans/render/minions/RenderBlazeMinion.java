//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render.minions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntityBlazeMinion;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderBlazeMinion extends RenderLiving {
    private int field_77068_a;
    private static final ResourceLocation blazeTemplarTextures = new ResourceLocation("thetitans", "textures/entities/minions/blazes/blaze_templar.png");
    private static final ResourceLocation blazeBishopTextures = new ResourceLocation("thetitans", "textures/entities/minions/blazes/blaze_bishop.png");
    private static final ResourceLocation blazeZealotTextures = new ResourceLocation("thetitans", "textures/entities/minions/blazes/blaze_zealot.png");
    private static final ResourceLocation blazePriestTextures = new ResourceLocation("thetitans", "textures/entities/minions/blazes/blaze_priest.png");
    private static final ResourceLocation blazeTextures = new ResourceLocation("textures/entity/blaze.png");

    public RenderBlazeMinion() {
        super(new ModelBlaze(), 0.5F);
        this.field_77068_a = ((ModelBlaze)this.field_77045_g).func_78104_a();
    }

    protected ResourceLocation getEntityTexture(EntityBlazeMinion p_180586_1_) {
        switch (p_180586_1_.getMinionTypeInt()) {
            case 1:
                return blazePriestTextures;
            case 2:
                return blazeZealotTextures;
            case 3:
                return blazeBishopTextures;
            case 4:
                return blazeTemplarTextures;
            default:
                return blazeTextures;
        }
    }

    public void doRender(EntityBlazeMinion p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        int i = ((ModelBlaze)this.field_77045_g).func_78104_a();
        if (i != this.field_77068_a) {
            this.field_77068_a = i;
            this.field_77045_g = new ModelBlaze();
        }

        super.func_76986_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityBlazeMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityBlazeMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_) {
        return this.getEntityTexture((EntityBlazeMinion)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityBlazeMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
