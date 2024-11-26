//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderTitanPart extends Render {
    public RenderTitanPart() {
        this.field_76989_e = 0.1F;
    }

    protected ResourceLocation getTextures(EntityTitanPart p_180554_1_) {
        return null;
    }

    protected ResourceLocation func_110775_a(Entity entity) {
        return this.getTextures((EntityTitanPart)entity);
    }

    private void renderEntityOnFire(Entity p_76977_1_, double p_76977_2_, double p_76977_4_, double p_76977_6_, float p_76977_8_) {
        GL11.glDisable(2896);
        IIcon iicon = Blocks.field_150480_ab.func_149840_c(0);
        IIcon iicon1 = Blocks.field_150480_ab.func_149840_c(1);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76977_2_, (float)p_76977_4_, (float)p_76977_6_);
        float f1 = p_76977_1_.field_70130_N * 1.4F;
        GL11.glScalef(f1, f1, f1);
        Tessellator tessellator = Tessellator.field_78398_a;
        float f2 = 0.5F;
        float f3 = 0.0F;
        float f4 = p_76977_1_.field_70131_O / f1;
        float f5 = (float)(p_76977_1_.field_70163_u - p_76977_1_.field_70121_D.field_72338_b);
        GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0F, 0.0F, -0.3F + (float)((int)f4) * 0.02F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f6 = 0.0F;
        int i = 0;
        tessellator.func_78382_b();

        while(f4 > 0.0F) {
            IIcon iicon2 = i % 2 == 0 ? iicon : iicon1;
            this.func_110776_a(TextureMap.field_110575_b);
            float f7 = iicon2.func_94209_e();
            float f8 = iicon2.func_94206_g();
            float f9 = iicon2.func_94212_f();
            float f10 = iicon2.func_94210_h();
            if (i / 2 % 2 == 0) {
                float f11 = f9;
                f9 = f7;
                f7 = f11;
            }

            tessellator.func_78374_a((double)(f2 - f3), (double)(0.0F - f5), (double)f6, (double)f9, (double)f10);
            tessellator.func_78374_a((double)(-f2 - f3), (double)(0.0F - f5), (double)f6, (double)f7, (double)f10);
            tessellator.func_78374_a((double)(-f2 - f3), (double)(1.4F - f5), (double)f6, (double)f7, (double)f8);
            tessellator.func_78374_a((double)(f2 - f3), (double)(1.4F - f5), (double)f6, (double)f9, (double)f8);
            f4 -= 0.45F;
            f5 -= 0.45F;
            f2 *= 0.9F;
            f6 += 0.03F;
            ++i;
        }

        tessellator.func_78381_a();
        GL11.glPopMatrix();
        GL11.glEnable(2896);
    }

    private void func_147907_a(Block p_147907_1_, double p_147907_2_, double p_147907_4_, double p_147907_6_, int p_147907_8_, int p_147907_9_, int p_147907_10_, float p_147907_11_, float p_147907_12_, double p_147907_13_, double p_147907_15_, double p_147907_17_) {
        Tessellator tessellator = Tessellator.field_78398_a;
        if (p_147907_1_.func_149686_d()) {
            double d6 = ((double)p_147907_11_ - (p_147907_4_ - ((double)p_147907_9_ + p_147907_15_)) / (double)2.0F) * (double)0.5F * (double)this.field_76990_c.field_78722_g.func_72801_o(p_147907_8_, p_147907_9_, p_147907_10_);
            if (d6 >= (double)0.0F) {
                if (d6 > (double)1.0F) {
                    d6 = (double)1.0F;
                }

                tessellator.func_78369_a(1.0F, 1.0F, 1.0F, (float)d6);
                double d7 = (double)p_147907_8_ + p_147907_1_.func_149704_x() + p_147907_13_;
                double d8 = (double)p_147907_8_ + p_147907_1_.func_149753_y() + p_147907_13_;
                double d9 = (double)p_147907_9_ + p_147907_1_.func_149665_z() + p_147907_15_ + (double)0.015625F;
                double d10 = (double)p_147907_10_ + p_147907_1_.func_149706_B() + p_147907_17_;
                double d11 = (double)p_147907_10_ + p_147907_1_.func_149693_C() + p_147907_17_;
                float f2 = (float)((p_147907_2_ - d7) / (double)2.0F / (double)p_147907_12_ + (double)0.5F);
                float f3 = (float)((p_147907_2_ - d8) / (double)2.0F / (double)p_147907_12_ + (double)0.5F);
                float f4 = (float)((p_147907_6_ - d10) / (double)2.0F / (double)p_147907_12_ + (double)0.5F);
                float f5 = (float)((p_147907_6_ - d11) / (double)2.0F / (double)p_147907_12_ + (double)0.5F);
                tessellator.func_78374_a(d7, d9, d10, (double)f2, (double)f4);
                tessellator.func_78374_a(d7, d9, d11, (double)f2, (double)f5);
                tessellator.func_78374_a(d8, d9, d11, (double)f3, (double)f5);
                tessellator.func_78374_a(d8, d9, d10, (double)f3, (double)f4);
            }
        }

    }

    private void renderShadow(Entity p_76975_1_, double p_76975_2_, double p_76975_4_, double p_76975_6_, float p_76975_8_, float p_76975_9_) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        this.field_76990_c.field_78724_e.func_110577_a(new ResourceLocation("textures/misc/shadow.png"));
        World world = this.field_76990_c.field_78722_g;
        GL11.glDepthMask(false);
        float f2 = this.field_76989_e;
        if (p_76975_1_ instanceof EntityLiving) {
            EntityLiving entityliving = (EntityLiving)p_76975_1_;
            f2 *= entityliving.func_70603_bj();
            if (entityliving.func_70631_g_()) {
                f2 *= 0.5F;
            }
        }

        double d8 = p_76975_1_.field_70142_S + (p_76975_1_.field_70165_t - p_76975_1_.field_70142_S) * (double)p_76975_9_;
        double d3 = p_76975_1_.field_70137_T + (p_76975_1_.field_70163_u - p_76975_1_.field_70137_T) * (double)p_76975_9_ + (double)p_76975_1_.func_70053_R();
        double d4 = p_76975_1_.field_70136_U + (p_76975_1_.field_70161_v - p_76975_1_.field_70136_U) * (double)p_76975_9_;
        int i = MathHelper.func_76128_c(d8 - (double)f2);
        int j = MathHelper.func_76128_c(d8 + (double)f2);
        int k = MathHelper.func_76128_c(d3 - (double)f2);
        int l = MathHelper.func_76128_c(d3);
        int i1 = MathHelper.func_76128_c(d4 - (double)f2);
        int j1 = MathHelper.func_76128_c(d4 + (double)f2);
        double d5 = p_76975_2_ - d8;
        double d6 = p_76975_4_ - d3;
        double d7 = p_76975_6_ - d4;
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();

        for(int k1 = i; k1 <= j; ++k1) {
            for(int l1 = k; l1 <= l; ++l1) {
                for(int i2 = i1; i2 <= j1; ++i2) {
                    Block block = world.func_147439_a(k1, l1 - 1, i2);
                    if (block.func_149688_o() != Material.field_151579_a) {
                        this.func_147907_a(block, p_76975_2_, p_76975_4_ + (double)p_76975_1_.func_70053_R(), p_76975_6_, k1, l1, i2, p_76975_8_, f2, d5, d6 + (double)p_76975_1_.func_70053_R(), d7);
                    }
                }
            }
        }

        tessellator.func_78381_a();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
    }

    public void func_76979_b(Entity p_76979_1_, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {
        if (this.field_76989_e > 0.0F && !p_76979_1_.func_82150_aj()) {
            double d3 = this.field_76990_c.func_78714_a(p_76979_1_.field_70165_t, p_76979_1_.field_70163_u, p_76979_1_.field_70161_v);
            float f2 = (float)((double)1.0F - d3 / (double)40000.0F);
            if (f2 > 0.0F) {
                this.renderShadow(p_76979_1_, p_76979_2_, p_76979_4_, p_76979_6_, f2, p_76979_9_);
            }
        }

        if (p_76979_1_.func_90999_ad() && !p_76979_1_.func_82150_aj()) {
            this.renderEntityOnFire(p_76979_1_, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_9_);
        }

    }

    public void doRender(EntityTitanPart p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.field_76989_e = p_76986_1_.entityDragonObj != null && p_76986_1_.entityDragonObj instanceof EntityTitan && ((EntityTitan)p_76986_1_.entityDragonObj).getWaiting() ? 0.0F : 1.0F + p_76986_1_.field_70130_N / 2.0F;
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityTitanPart)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
