//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render.minions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.model.ModelZombieVillager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntityZombieMinion;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderZombieMinion extends RenderBiped {
    private static final ResourceLocation zombieTemplarTextures = new ResourceLocation("thetitans", "textures/entities/minions/zombies/zombie_templar.png");
    private static final ResourceLocation zombieVillagerTemplarTextures = new ResourceLocation("thetitans", "textures/entities/minions/zombies/zombie_villager_templar.png");
    private static final ResourceLocation zombieBishopTextures = new ResourceLocation("thetitans", "textures/entities/minions/zombies/zombie_bishop.png");
    private static final ResourceLocation zombieVillagerBishopTextures = new ResourceLocation("thetitans", "textures/entities/minions/zombies/zombie_villager_bishop.png");
    private static final ResourceLocation zombieZealotTextures = new ResourceLocation("thetitans", "textures/entities/minions/zombies/zombie_zealot.png");
    private static final ResourceLocation zombieVillagerZealotTextures = new ResourceLocation("thetitans", "textures/entities/minions/zombies/zombie_villager_zealot.png");
    private static final ResourceLocation zombiePriestTextures = new ResourceLocation("thetitans", "textures/entities/minions/zombies/zombie_priest.png");
    private static final ResourceLocation zombieVillagerPriestTextures = new ResourceLocation("thetitans", "textures/entities/minions/zombies/zombie_villager_priest.png");
    private static final ResourceLocation zombieTextures = new ResourceLocation("textures/entity/zombie/zombie.png");
    private static final ResourceLocation zombieVillagerTextures = new ResourceLocation("textures/entity/zombie/zombie_villager.png");
    private ModelBiped field_82434_o;
    private ModelZombieVillager zombieVillagerModel;
    protected ModelBiped field_82437_k;
    protected ModelBiped field_82435_l;
    protected ModelBiped field_82436_m;
    protected ModelBiped field_82433_n;
    private int field_82431_q = 1;

    public RenderZombieMinion() {
        super(new ModelZombie(), 0.5F, 1.0F);
        this.field_82434_o = this.field_77071_a;
        this.zombieVillagerModel = new ModelZombieVillager();
        this.func_77042_a(this.field_77045_g);
    }

    protected void func_82421_b() {
        this.field_82423_g = new ModelZombie(1.0F, true);
        this.field_82425_h = new ModelZombie(0.5F, true);
        this.field_82437_k = this.field_82423_g;
        this.field_82435_l = this.field_82425_h;
        this.field_82436_m = new ModelZombieVillager(1.0F, 0.0F, true);
        this.field_82433_n = new ModelZombieVillager(0.5F, 0.0F, true);
    }

    protected int shouldRenderPass(EntityZombieMinion p_77032_1_, int p_77032_2_, float p_77032_3_) {
        this.func_82427_a(p_77032_1_);
        return super.func_77032_a(p_77032_1_, p_77032_2_, p_77032_3_);
    }

    public void doRender(EntityZombieMinion p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.func_82427_a(p_76986_1_);
        super.func_76986_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(EntityZombieMinion p_110775_1_) {
        switch (p_110775_1_.getMinionTypeInt()) {
            case 1:
                return p_110775_1_.func_82231_m() ? zombieVillagerPriestTextures : zombiePriestTextures;
            case 2:
                return p_110775_1_.func_82231_m() ? zombieVillagerZealotTextures : zombieZealotTextures;
            case 3:
                return p_110775_1_.func_82231_m() ? zombieVillagerBishopTextures : zombieBishopTextures;
            case 4:
                return p_110775_1_.func_82231_m() ? zombieVillagerTemplarTextures : zombieTemplarTextures;
            default:
                return p_110775_1_.func_82231_m() ? zombieVillagerTextures : zombieTextures;
        }
    }

    protected void renderEquippedItems(EntityZombieMinion p_77029_1_, float p_77029_2_) {
        this.func_82427_a(p_77029_1_);
        super.func_77029_c(p_77029_1_, p_77029_2_);
    }

    private void func_82427_a(EntityZombieMinion p_82427_1_) {
        if (p_82427_1_.func_82231_m()) {
            if (this.field_82431_q != this.zombieVillagerModel.func_82897_a()) {
                this.zombieVillagerModel = new ModelZombieVillager();
                this.field_82431_q = this.zombieVillagerModel.func_82897_a();
                this.field_82436_m = new ModelZombieVillager(1.0F, 0.0F, true);
                this.field_82433_n = new ModelZombieVillager(0.5F, 0.0F, true);
            }

            this.field_77045_g = this.zombieVillagerModel;
            this.field_82423_g = this.field_82436_m;
            this.field_82425_h = this.field_82433_n;
        } else {
            this.field_77045_g = this.field_82434_o;
            this.field_82423_g = this.field_82437_k;
            this.field_82425_h = this.field_82435_l;
        }

        this.field_77071_a = (ModelBiped)this.field_77045_g;
    }

    protected void rotateCorpse(EntityZombieMinion p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
        if (p_77043_1_.func_82230_o()) {
            p_77043_3_ += (float)(Math.cos((double)p_77043_1_.field_70173_aa * (double)3.25F) * Math.PI * (double)0.25F);
        }

        super.func_77043_a(p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_) {
        this.renderEquippedItems((EntityZombieMinion)p_77029_1_, p_77029_2_);
    }

    protected ResourceLocation func_110775_a(EntityLiving p_110775_1_) {
        return this.getEntityTexture((EntityZombieMinion)p_110775_1_);
    }

    public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityZombieMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((EntityZombieMinion)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_) {
        this.renderEquippedItems((EntityZombieMinion)p_77029_1_, p_77029_2_);
    }

    protected void func_77043_a(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
        this.rotateCorpse((EntityZombieMinion)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityZombieMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_) {
        return this.getEntityTexture((EntityZombieMinion)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityZombieMinion)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
