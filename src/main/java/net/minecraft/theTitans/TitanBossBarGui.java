//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityBlazeTitan;
import net.minecraft.entity.titan.EntityCaveSpiderTitan;
import net.minecraft.entity.titan.EntityCreeperTitan;
import net.minecraft.entity.titan.EntityEnderColossus;
import net.minecraft.entity.titan.EntityGhastTitan;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.entity.titan.EntityMagmaCubeTitan;
import net.minecraft.entity.titan.EntityPigZombieTitan;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.entity.titan.EntitySlimeTitan;
import net.minecraft.entity.titan.EntitySnowGolemTitan;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.entity.titan.EnumTitanStatus;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

public class TitanBossBarGui extends Gui {
    private Minecraft mc;
    private static ResourceLocation texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/witherzilla.png");

    public TitanBossBarGui(Minecraft mc) {
        this.mc = mc;
    }

    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent event) {
        if (!event.isCancelable()) {
            int u = 0;
            int v = 0;
            String outstring = null;
            int color = 16382457;
            FontRenderer fr = this.mc.field_71466_p;
            int barWidth = 182;
            int namey = 10;
            int barHeight = 5;
            int y = 0;
            float fade = 1.0F;
            float gfHealth = 0.0F;
            boolean flag = true;
            Entity entity = null;
            EntityPlayer player = null;
            if (!this.mc.field_71442_b.func_78747_a()) {
                EntityPlayer var28 = this.mc.field_71439_g;
                if (var28 != null) {
                    List list = var28.field_70170_p.field_72996_f;
                    if (list != null && !list.isEmpty()) {
                        for(int j = 0; j < list.size(); ++j) {
                            entity = (Entity)list.get(j);
                            if (entity != null && !entity.field_70128_L && entity instanceof EntityTitan) {
                                EntityTitan e = (EntityTitan)entity;
                                outstring = e.func_70005_c_();
                                gfHealth = e.func_110143_aJ() / e.func_110138_aP();
                                if (!e.getWaiting() && !e.func_82150_aj()) {
                                    flag = true;
                                } else {
                                    flag = false;
                                }

                                if (!e.func_70089_S()) {
                                    fade = 0.25F;
                                } else {
                                    fade = 1.0F;
                                }

                                if (e instanceof EntitySnowGolemTitan) {
                                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/snow_golem_titan.png");
                                    barWidth = 185;
                                    barHeight = 27;
                                    color = 12369084;
                                    y = 0;
                                    namey = y + 20;
                                    ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                                    int width = res.func_78326_a();
                                    int barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    int x = width / 2 - barWidth / 2;
                                    if (flag) {
                                        fr.func_78261_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP(), width / 2 - fr.func_78256_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP()) / 2, namey + 10, 16382457);
                                    }
                                }

                                if (e instanceof EntitySlimeTitan) {
                                    if (e instanceof EntityMagmaCubeTitan) {
                                        barWidth = 193;
                                        barHeight = 19;
                                        y = 17;
                                        namey = y + 12;
                                        color = 16579584;
                                        texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/magma_cube_titan.png");
                                    } else {
                                        barWidth = 189;
                                        barHeight = 22;
                                        y = 14;
                                        namey = y + 9;
                                        color = 5349438;
                                        texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/slime_titan.png");
                                    }

                                    ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                                    int width = res.func_78326_a();
                                    int barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    int x = width / 2 - barWidth / 2;
                                    if (flag) {
                                        fr.func_78261_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP(), width / 2 - fr.func_78256_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP()) / 2, namey + 10, 16382457);
                                    }
                                }

                                if (e instanceof EntitySilverfishTitan) {
                                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/omegafish.png");
                                    barWidth = 185;
                                    barHeight = 33;
                                    color = 3158064;
                                    y = 7;
                                    namey = y + 26;
                                    ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                                    int width = res.func_78326_a();
                                    int barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    int x = width / 2 - barWidth / 2;
                                    if (flag) {
                                        fr.func_78261_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP(), width / 2 - fr.func_78256_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP()) / 2, namey + 10, 16382457);
                                    }
                                }

                                if (e instanceof EntitySpiderTitan) {
                                    barWidth = 187;
                                    barHeight = 23;
                                    color = 11013646;
                                    if (e instanceof EntityCaveSpiderTitan) {
                                        y = 21;
                                        namey = y + 16;
                                        texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/cave_spider_titan.png");
                                    } else {
                                        y = 26;
                                        namey = y + 16;
                                        texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/spider_titan.png");
                                    }

                                    ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                                    int width = res.func_78326_a();
                                    int barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    int x = width / 2 - barWidth / 2;
                                    if (flag) {
                                        fr.func_78261_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP(), width / 2 - fr.func_78256_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP()) / 2, namey + 10, 16382457);
                                    }
                                }

                                if (e instanceof EntitySkeletonTitan && ((EntitySkeletonTitan)e).getSkeletonType() != 1) {
                                    barWidth = 185;
                                    barHeight = 24;
                                    color = 12698049;
                                    y = 31;
                                    namey = y + 17;
                                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/skeleton_titan.png");
                                    ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                                    int width = res.func_78326_a();
                                    int barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    int x = width / 2 - barWidth / 2;
                                    if (flag) {
                                        fr.func_78261_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP(), width / 2 - fr.func_78256_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP()) / 2, namey + 10, 16382457);
                                    }
                                }

                                if (e instanceof EntityZombieTitan) {
                                    barWidth = 185;
                                    barHeight = 22;
                                    color = 7969893;
                                    y = 40;
                                    namey = y + 17;
                                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/zombie_titan.png");
                                    ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                                    int width = res.func_78326_a();
                                    int barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    int x = width / 2 - barWidth / 2;
                                    if (flag) {
                                        fr.func_78261_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP(), width / 2 - fr.func_78256_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP()) / 2, namey + 10, 16382457);
                                    }
                                }

                                if (e instanceof EntityCreeperTitan) {
                                    barWidth = 216;
                                    barHeight = 33;
                                    color = 894731;
                                    y = 44;
                                    namey = y + 17;
                                    if (((EntityCreeperTitan)e).getPowered()) {
                                        texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/charged_creeper_titan.png");
                                    } else {
                                        texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/creeper_titan.png");
                                    }

                                    ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                                    int width = res.func_78326_a();
                                    int barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    int x = width / 2 - barWidth / 2;
                                    if (flag) {
                                        fr.func_78261_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP(), width / 2 - fr.func_78256_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP()) / 2, namey + 10, 16382457);
                                    }
                                }

                                if (e instanceof EntityPigZombieTitan) {
                                    barWidth = 185;
                                    barHeight = 27;
                                    color = 15373203;
                                    y = 47;
                                    namey = y + 20;
                                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/zombie_pigman_titan.png");
                                    ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                                    int width = res.func_78326_a();
                                    int barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    int x = width / 2 - barWidth / 2;
                                    if (flag) {
                                        fr.func_78261_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP(), width / 2 - fr.func_78256_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP()) / 2, namey + 10, 16382457);
                                    }
                                }

                                if (e instanceof EntityBlazeTitan) {
                                    barWidth = 185;
                                    barHeight = 34;
                                    color = 16167425;
                                    y = 50;
                                    namey = y + 25;
                                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/blaze_titan.png");
                                    ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                                    int width = res.func_78326_a();
                                    int barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    int x = width / 2 - barWidth / 2;
                                    if (flag) {
                                        fr.func_78261_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP(), width / 2 - fr.func_78256_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP()) / 2, namey + 10, 16382457);
                                    }
                                }

                                if (e instanceof EntitySkeletonTitan && ((EntitySkeletonTitan)e).getSkeletonType() == 1) {
                                    barWidth = 185;
                                    barHeight = 24;
                                    color = 4802889;
                                    y = 48;
                                    namey = y + 33;
                                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/wither_skeleton_titan.png");
                                    ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                                    int width = res.func_78326_a();
                                    int barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    int x = width / 2 - barWidth / 2;
                                    if (flag) {
                                        fr.func_78261_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP(), width / 2 - fr.func_78256_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP()) / 2, namey + 10, 16382457);
                                    }
                                }

                                if (e instanceof EntityGhastTitan) {
                                    barWidth = 185;
                                    barHeight = 32;
                                    color = 12369084;
                                    y = 46;
                                    namey = y + 43;
                                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/ghast_titan.png");
                                    ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                                    int width = res.func_78326_a();
                                    int barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    int x = width / 2 - barWidth / 2;
                                    if (flag) {
                                        fr.func_78261_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP(), width / 2 - fr.func_78256_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP()) / 2, namey + 10, 16382457);
                                    }
                                }

                                if (e instanceof EntityIronGolemTitan) {
                                    barWidth = 191;
                                    barHeight = 26;
                                    color = 7237230;
                                    y = 55;
                                    namey = y + 40;
                                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/ultima_iron_golem_titan.png");
                                    ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                                    int width = res.func_78326_a();
                                    int barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    int x = width / 2 - barWidth / 2;
                                    if (flag) {
                                        fr.func_78261_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP(), width / 2 - fr.func_78256_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP()) / 2, namey + 10, 16382457);
                                    }
                                }

                                if (e instanceof EntityEnderColossus) {
                                    barWidth = 193;
                                    barHeight = 23;
                                    color = 13369594;
                                    y = 62;
                                    namey = y + 36;
                                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/ender_colossus.png");
                                    ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                                    int width = res.func_78326_a();
                                    int barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    int x = width / 2 - barWidth / 2;
                                    if (flag) {
                                        fr.func_78261_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP(), width / 2 - fr.func_78256_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP()) / 2, namey + 10, 16382457);
                                    }
                                }

                                if (e instanceof EntityWitherzilla) {
                                    barWidth = 185;
                                    barHeight = 32;
                                    color = 15728880 - (int)(MathHelper.func_76134_b((float)e.field_70173_aa * 0.05F) * 1.572888E7F);
                                    y = 46;
                                    namey = y + 61;
                                    fade = 1.0F + MathHelper.func_76134_b((float)e.field_70173_aa * 0.2F) * 0.3F;
                                    texture = new ResourceLocation("thetitans", "textures/entities/titans/bossbars/witherzilla.png");
                                    ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                                    int width = res.func_78326_a();
                                    int barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    int x = width / 2 - barWidth / 2;
                                    if (flag) {
                                        fr.func_78261_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP(), width / 2 - fr.func_78256_a((int)e.func_110143_aJ() + "/" + (int)e.func_110138_aP()) / 2, namey + 10, color);
                                    }
                                }

                                if (outstring == null) {
                                    return;
                                }

                                if (flag) {
                                    ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
                                    int width = res.func_78326_a();
                                    int barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    int x = width / 2 - barWidth / 2;
                                    this.mc.field_71446_o.func_110577_a(texture);
                                    GL11.glColor4f(fade, fade, fade, 1.0F);
                                    if (e.getTitanStatus() == EnumTitanStatus.GREATER) {
                                        GL11.glScalef(1.25F, 1.25F, 1.25F);
                                        x = width / 3 - barWidth / 3 - 6;
                                        barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    }

                                    if (e.getTitanStatus() == EnumTitanStatus.GOD) {
                                        GL11.glScalef(1.5F, 1.5F, 1.5F);
                                        x = width / 4 - barWidth / 4 - 12;
                                        barWidthFilled = (int)(gfHealth * (float)(barWidth + 1));
                                    }

                                    GL11.glEnable(2977);
                                    GL11.glEnable(3042);
                                    GL11.glBlendFunc(770, 771);
                                    this.func_73729_b(x, y, u, v, barWidth, barHeight);
                                    if (barWidthFilled > 0) {
                                        this.func_73729_b(x, y, u, v + barHeight, barWidthFilled, barHeight);
                                    }

                                    GL11.glDisable(3042);
                                    if (e.getTitanStatus() == EnumTitanStatus.GREATER) {
                                        GL11.glScalef(0.8F, 0.8F, 0.8F);
                                    }

                                    if (e.getTitanStatus() == EnumTitanStatus.GOD) {
                                        GL11.glScalef(0.6666667F, 0.6666667F, 0.6666667F);
                                    }

                                    fr.func_78261_a(outstring, width / 2 - fr.func_78256_a(outstring) / 2, namey, color);
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}
