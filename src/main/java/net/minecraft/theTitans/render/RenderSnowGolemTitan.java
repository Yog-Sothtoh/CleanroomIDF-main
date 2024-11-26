//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Calendar;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSnowGolemTitan extends RenderLiving {
    private static final ResourceLocation snowManTextures = new ResourceLocation("textures/entity/snowman.png");
    private ModelSnowMan snowmanModel;

    public RenderSnowGolemTitan() {
        super(new ModelSnowMan(), 0.5F);
        this.snowmanModel = (ModelSnowMan)this.field_77045_g;
        this.func_77042_a(this.snowmanModel);
    }

    protected void func_77043_a(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
        GL11.glRotatef(180.0F - p_77043_3_, 0.0F, 1.0F, 0.0F);
        if (p_77043_1_.field_70725_aQ > 0) {
            float f3 = ((float)p_77043_1_.field_70725_aQ + p_77043_4_ - 1.0F) / 20.0F * 1.6F;
            f3 = MathHelper.func_76129_c(f3);
            if (f3 > 1.0F) {
                f3 = 1.0F;
            }

            GL11.glScalef(1.0F + f3 * 1.05F, 1.0F - f3 * 0.5F, 1.0F + f3 * 1.05F);
        }

    }

    protected void renderEquippedItems(EntitySnowGolemTitan p_77029_1_, float p_77029_2_) {
        super.func_77029_c(p_77029_1_, p_77029_2_);
        Calendar calendar = Calendar.getInstance();
        ItemStack itemstack;
        if (calendar.get(2) + 1 == 10 && calendar.get(5) >= 29 && calendar.get(5) <= 31) {
            itemstack = new ItemStack(p_77029_1_.func_110143_aJ() <= p_77029_1_.func_110138_aP() / 2.0F ? Blocks.field_150378_br : Blocks.field_150477_bB, 1);
        } else {
            itemstack = new ItemStack(!(p_77029_1_.func_110143_aJ() <= p_77029_1_.func_110138_aP() / 2.0F) && (p_77029_1_.getInvulTime() <= 0 || p_77029_1_.getInvulTime() <= 60 && p_77029_1_.getInvulTime() / 5 % 2 == 1) ? Blocks.field_150428_aP : Blocks.field_150423_aK, 1);
        }

        if (itemstack.func_77973_b() instanceof ItemBlock) {
            GL11.glPushMatrix();
            this.snowmanModel.field_78195_c.func_78794_c(0.0625F);
            IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, ItemRenderType.EQUIPPED);
            boolean is3D = customRenderer != null && customRenderer.shouldUseRenderHelper(ItemRenderType.EQUIPPED, itemstack, ItemRendererHelper.BLOCK_3D);
            if (is3D || RenderBlocks.func_147739_a(Block.func_149634_a(itemstack.func_77973_b()).func_149645_b())) {
                float f1 = 0.625F;
                GL11.glTranslatef(0.0F, -0.3437F, 0.0F);
                GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f1, -f1, f1);
            }

            if (p_77029_1_.func_110143_aJ() > p_77029_1_.func_110138_aP() / 4.0F) {
                this.field_76990_c.field_78721_f.func_78443_a(p_77029_1_, itemstack, 0);
            }

            GL11.glPopMatrix();
        }

    }

    protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_) {
        this.renderEquippedItems((EntitySnowGolemTitan)p_77029_1_, p_77029_2_);
    }

    protected ResourceLocation func_180587_a(EntitySnowGolemTitan p_180587_1_) {
        return snowManTextures;
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.func_180587_a((EntitySnowGolemTitan)entity);
    }

    protected void func_180592_a(EntitySnowGolemTitan p_180592_1_, float p_180592_2_) {
        float f1 = 16.0F;
        int i = p_180592_1_.getInvulTime();
        if (i > 0) {
            f1 -= ((float)i - p_180592_2_) / 10.0F;
        }

        GL11.glScalef(f1, f1, f1);
        GL11.glTranslatef(0.0F, 0.0275F, 0.0F);
    }

    protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
        this.func_180592_a((EntitySnowGolemTitan)p_77041_1_, p_77041_2_);
    }

    public void func_180579_a(EntitySnowGolemTitan p_180579_1_, double p_180579_2_, double p_180579_4_, double p_180579_6_, float p_180579_8_, float p_180579_9_) {
        super.func_76986_a(p_180579_1_, p_180579_2_, p_180579_4_, p_180579_6_, p_180579_8_, p_180579_9_);
    }

    public void func_76986_a(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySnowGolemTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void func_76986_a(EntityLivingBase entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySnowGolemTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }

    public void func_76986_a(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        this.func_180579_a((EntitySnowGolemTitan)entity, x, y, z, p_76986_8_, partialTicks);
    }
}
