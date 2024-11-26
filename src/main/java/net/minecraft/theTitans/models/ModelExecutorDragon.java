//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelExecutorDragon extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer bodyscale1;
    public ModelRenderer bodyscale2;
    public ModelRenderer bodyscale3;
    public ModelRenderer rightupperarm;
    public ModelRenderer neck1;
    public ModelRenderer rightwing;
    public ModelRenderer rightfemur;
    public ModelRenderer tail1;
    public ModelRenderer leftwing;
    public ModelRenderer leftupperarm;
    public ModelRenderer leftfemur;
    public ModelRenderer rightlowerarm;
    public ModelRenderer righthand;
    public ModelRenderer neckscale1;
    public ModelRenderer neck2;
    public ModelRenderer neckscale2;
    public ModelRenderer neck3;
    public ModelRenderer neckscale3;
    public ModelRenderer neck4;
    public ModelRenderer neckscale4;
    public ModelRenderer neck5;
    public ModelRenderer neckscale5;
    public ModelRenderer head;
    public ModelRenderer leftheadscale;
    public ModelRenderer rightheadscale;
    public ModelRenderer upperjaw;
    public ModelRenderer lowerjaw;
    public ModelRenderer rightnostril;
    public ModelRenderer leftnostril;
    public ModelRenderer rightwingtip;
    public ModelRenderer rightwingskin;
    public ModelRenderer rightwingtipskin;
    public ModelRenderer rightlowerleg;
    public ModelRenderer rightfoot;
    public ModelRenderer tailscale1;
    public ModelRenderer tail2;
    public ModelRenderer tailscale2;
    public ModelRenderer tail3;
    public ModelRenderer tailscale3;
    public ModelRenderer tail4;
    public ModelRenderer tailscale4;
    public ModelRenderer tail5;
    public ModelRenderer tailscale5;
    public ModelRenderer tail6;
    public ModelRenderer tailscale6;
    public ModelRenderer tail7;
    public ModelRenderer tailscale7;
    public ModelRenderer tail8;
    public ModelRenderer tailscale8;
    public ModelRenderer tail9;
    public ModelRenderer tailscale9;
    public ModelRenderer tail10;
    public ModelRenderer tailscale10;
    public ModelRenderer tail11;
    public ModelRenderer tailscale11;
    public ModelRenderer tail12;
    public ModelRenderer tailscale12;
    public ModelRenderer leftwingtip;
    public ModelRenderer leftwingskin;
    public ModelRenderer leftwingtipskin;
    public ModelRenderer leftlowerarm;
    public ModelRenderer lefthand;
    public ModelRenderer leftlowerleg;
    public ModelRenderer leftfoot;

    public ModelExecutorDragon() {
        this.field_78090_t = 256;
        this.field_78089_u = 256;
        this.neckscale1 = new ModelRenderer(this, 48, 0);
        this.neckscale1.func_78793_a(0.0F, 0.0F, 0.0F);
        this.neckscale1.func_78790_a(-1.0F, -9.0F, -3.0F, 2, 4, 6, 0.0F);
        this.neck4 = new ModelRenderer(this, 192, 104);
        this.neck4.func_78793_a(0.0F, 0.0F, -10.0F);
        this.neck4.func_78790_a(-5.0F, -5.0F, -10.0F, 10, 10, 10, 0.0F);
        this.leftfemur = new ModelRenderer(this, 0, 0);
        this.leftfemur.field_78809_i = true;
        this.leftfemur.func_78793_a(16.0F, 8.0F, 20.0F);
        this.leftfemur.func_78790_a(-8.0F, -4.0F, -8.0F, 16, 32, 16, 0.0F);
        this.setRotateAngle(this.leftfemur, 1.0016445F, 0.0F, 0.0F);
        this.neckscale3 = new ModelRenderer(this, 48, 0);
        this.neckscale3.func_78793_a(0.0F, 0.0F, 0.0F);
        this.neckscale3.func_78790_a(-1.0F, -9.0F, -8.0F, 2, 4, 6, 0.0F);
        this.lefthand = new ModelRenderer(this, 144, 104);
        this.lefthand.field_78809_i = true;
        this.lefthand.func_78793_a(0.0F, 23.0F, 0.0F);
        this.lefthand.func_78790_a(-4.0F, 0.0F, -12.0F, 8, 4, 16, 0.0F);
        this.setRotateAngle(this.lefthand, 0.75171334F, 0.0F, 0.0F);
        this.leftupperarm = new ModelRenderer(this, 112, 104);
        this.leftupperarm.field_78809_i = true;
        this.leftupperarm.func_78793_a(8.0F, 8.0F, -18.0F);
        this.leftupperarm.func_78790_a(0.0F, -4.0F, -4.0F, 8, 24, 8, 0.0F);
        this.setRotateAngle(this.leftupperarm, 1.3016665F, 0.0F, 0.0F);
        this.neckscale5 = new ModelRenderer(this, 48, 0);
        this.neckscale5.func_78793_a(0.0F, 0.0F, 0.0F);
        this.neckscale5.func_78790_a(-1.0F, -9.0F, -8.0F, 2, 4, 6, 0.0F);
        this.tailscale6 = new ModelRenderer(this, 48, 0);
        this.tailscale6.func_78793_a(0.0F, 0.0F, 0.0F);
        this.tailscale6.func_78790_a(-1.0F, -9.0F, 2.0F, 2, 4, 6, 0.0F);
        this.rightupperarm = new ModelRenderer(this, 112, 104);
        this.rightupperarm.func_78793_a(-8.0F, 8.0F, -18.0F);
        this.rightupperarm.func_78790_a(-8.0F, -4.0F, -4.0F, 8, 24, 8, 0.0F);
        this.setRotateAngle(this.rightupperarm, 1.3016665F, 0.0F, 0.0F);
        this.tailscale11 = new ModelRenderer(this, 48, 0);
        this.tailscale11.func_78793_a(0.0F, 0.0F, 0.0F);
        this.tailscale11.func_78790_a(-1.0F, -9.0F, 2.0F, 2, 4, 6, 0.0F);
        this.tail4 = new ModelRenderer(this, 192, 104);
        this.tail4.func_78793_a(0.0F, 0.0F, 10.0F);
        this.tail4.func_78790_a(-5.0F, -5.0F, 0.0F, 10, 10, 10, 0.0F);
        this.bodyscale1 = new ModelRenderer(this, 220, 53);
        this.bodyscale1.func_78793_a(0.0F, 0.0F, 0.0F);
        this.bodyscale1.func_78790_a(-1.0F, -18.0F, -26.0F, 2, 6, 12, 0.0F);
        this.tail8 = new ModelRenderer(this, 192, 104);
        this.tail8.func_78793_a(0.0F, 0.0F, 10.0F);
        this.tail8.func_78790_a(-5.0F, -5.0F, 0.0F, 10, 10, 10, 0.0F);
        this.leftlowerleg = new ModelRenderer(this, 196, 0);
        this.leftlowerleg.field_78809_i = true;
        this.leftlowerleg.func_78793_a(0.0F, 32.0F, -4.0F);
        this.leftlowerleg.func_78790_a(-6.0F, -2.0F, 0.0F, 12, 32, 12, 0.0F);
        this.setRotateAngle(this.leftlowerleg, 0.5017822F, 0.0F, 0.0F);
        this.leftnostril = new ModelRenderer(this, 112, 0);
        this.leftnostril.func_78793_a(0.0F, 0.0F, 0.0F);
        this.leftnostril.func_78790_a(3.0F, -3.0F, -14.0F, 2, 2, 4, 0.0F);
        this.tail12 = new ModelRenderer(this, 192, 104);
        this.tail12.func_78793_a(0.0F, 0.0F, 10.0F);
        this.tail12.func_78790_a(-5.0F, -5.0F, 0.0F, 10, 10, 10, 0.0F);
        this.rightwing = new ModelRenderer(this, 112, 88);
        this.rightwing.func_78793_a(-12.0F, -12.0F, -22.0F);
        this.rightwing.func_78790_a(-56.0F, -4.0F, -4.0F, 56, 8, 8, 0.0F);
        this.tail11 = new ModelRenderer(this, 192, 104);
        this.tail11.func_78793_a(0.0F, 0.0F, 10.0F);
        this.tail11.func_78790_a(-5.0F, -5.0F, 0.0F, 10, 10, 10, 0.0F);
        this.neck3 = new ModelRenderer(this, 192, 104);
        this.neck3.func_78793_a(0.0F, 0.0F, -10.0F);
        this.neck3.func_78790_a(-5.0F, -5.0F, -10.0F, 10, 10, 10, 0.0F);
        this.neck1 = new ModelRenderer(this, 192, 104);
        this.neck1.func_78793_a(0.0F, 4.0F, -36.0F);
        this.neck1.func_78790_a(-5.0F, -5.0F, -5.0F, 10, 10, 10, 0.0F);
        this.bodyscale3 = new ModelRenderer(this, 220, 53);
        this.bodyscale3.func_78793_a(0.0F, 0.0F, 0.0F);
        this.bodyscale3.func_78790_a(-1.0F, -18.0F, 14.0F, 2, 6, 12, 0.0F);
        this.righthand = new ModelRenderer(this, 144, 104);
        this.righthand.func_78793_a(0.0F, 23.0F, 0.0F);
        this.righthand.func_78790_a(-4.0F, 0.0F, -12.0F, 8, 4, 16, 0.0F);
        this.setRotateAngle(this.righthand, 0.75171334F, 0.0F, 0.0F);
        this.neckscale2 = new ModelRenderer(this, 48, 0);
        this.neckscale2.func_78793_a(0.0F, 0.0F, 0.0F);
        this.neckscale2.func_78790_a(-1.0F, -9.0F, -8.0F, 2, 4, 6, 0.0F);
        this.tailscale2 = new ModelRenderer(this, 48, 0);
        this.tailscale2.func_78793_a(0.0F, 0.0F, 0.0F);
        this.tailscale2.func_78790_a(-1.0F, -9.0F, 2.0F, 2, 4, 6, 0.0F);
        this.bodyscale2 = new ModelRenderer(this, 220, 53);
        this.bodyscale2.func_78793_a(0.0F, 0.0F, 0.0F);
        this.bodyscale2.func_78790_a(-1.0F, -18.0F, -6.0F, 2, 6, 12, 0.0F);
        this.tail1 = new ModelRenderer(this, 192, 104);
        this.tail1.func_78793_a(0.0F, 0.0F, 32.0F);
        this.tail1.func_78790_a(-5.0F, -5.0F, 0.0F, 10, 10, 10, 0.0F);
        this.tailscale5 = new ModelRenderer(this, 48, 0);
        this.tailscale5.func_78793_a(0.0F, 0.0F, 0.0F);
        this.tailscale5.func_78790_a(-1.0F, -9.0F, 2.0F, 2, 4, 6, 0.0F);
        this.rightlowerarm = new ModelRenderer(this, 226, 138);
        this.rightlowerarm.func_78793_a(-4.0F, 20.0F, -1.0F);
        this.rightlowerarm.func_78790_a(-3.0F, -1.0F, -3.0F, 6, 24, 6, 0.0F);
        this.setRotateAngle(this.rightlowerarm, -0.5017822F, 0.0F, 0.0F);
        this.leftwingtipskin = new ModelRenderer(this, -56, 144);
        this.leftwingtipskin.func_78793_a(0.0F, 0.0F, 0.0F);
        this.leftwingtipskin.func_78790_a(-56.0F, 0.0F, 2.0F, 56, 0, 56, 0.0F);
        this.tailscale10 = new ModelRenderer(this, 48, 0);
        this.tailscale10.func_78793_a(0.0F, 0.0F, 0.0F);
        this.tailscale10.func_78790_a(-1.0F, -9.0F, 2.0F, 2, 4, 6, 0.0F);
        this.rightheadscale = new ModelRenderer(this, 0, 0);
        this.rightheadscale.field_78809_i = true;
        this.rightheadscale.func_78793_a(0.0F, 0.0F, 0.0F);
        this.rightheadscale.func_78790_a(-5.0F, -12.0F, -10.0F, 2, 4, 6, 0.0F);
        this.tail10 = new ModelRenderer(this, 192, 104);
        this.tail10.func_78793_a(0.0F, 0.0F, 10.0F);
        this.tail10.func_78790_a(-5.0F, -5.0F, 0.0F, 10, 10, 10, 0.0F);
        this.tailscale7 = new ModelRenderer(this, 48, 0);
        this.tailscale7.func_78793_a(0.0F, 0.0F, 0.0F);
        this.tailscale7.func_78790_a(-1.0F, -9.0F, 2.0F, 2, 4, 6, 0.0F);
        this.rightfemur = new ModelRenderer(this, 0, 0);
        this.rightfemur.func_78793_a(-16.0F, 8.0F, 20.0F);
        this.rightfemur.func_78790_a(-8.0F, -4.0F, -8.0F, 16, 32, 16, 0.0F);
        this.setRotateAngle(this.rightfemur, 1.0016445F, 0.0F, 0.0F);
        this.rightlowerleg = new ModelRenderer(this, 196, 0);
        this.rightlowerleg.func_78793_a(0.0F, 32.0F, -4.0F);
        this.rightlowerleg.func_78790_a(-6.0F, -2.0F, 0.0F, 12, 32, 12, 0.0F);
        this.setRotateAngle(this.rightlowerleg, 0.5017822F, 0.0F, 0.0F);
        this.upperjaw = new ModelRenderer(this, 176, 44);
        this.upperjaw.func_78793_a(0.0F, 0.0F, -16.0F);
        this.upperjaw.func_78790_a(-6.0F, -1.0F, -16.0F, 12, 5, 16, 0.0F);
        this.tail7 = new ModelRenderer(this, 192, 104);
        this.tail7.func_78793_a(0.0F, 0.0F, 10.0F);
        this.tail7.func_78790_a(-5.0F, -5.0F, 0.0F, 10, 10, 10, 0.0F);
        this.leftfoot = new ModelRenderer(this, 112, 0);
        this.leftfoot.field_78809_i = true;
        this.leftfoot.func_78793_a(0.0F, 31.0F, 4.0F);
        this.leftfoot.func_78790_a(-9.0F, 0.0F, -20.0F, 18, 6, 24, 0.0F);
        this.setRotateAngle(this.leftfoot, 0.75171334F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 112, 30);
        this.head.func_78793_a(0.0F, 0.0F, -10.0F);
        this.head.func_78790_a(-8.0F, -8.0F, -16.0F, 16, 16, 16, 0.0F);
        this.leftwingskin = new ModelRenderer(this, -56, 88);
        this.leftwingskin.func_78793_a(0.0F, 0.0F, 0.0F);
        this.leftwingskin.func_78790_a(-56.0F, 0.0F, 2.0F, 56, 0, 56, 0.0F);
        this.tailscale9 = new ModelRenderer(this, 48, 0);
        this.tailscale9.func_78793_a(0.0F, 0.0F, 0.0F);
        this.tailscale9.func_78790_a(-1.0F, -9.0F, 2.0F, 2, 4, 6, 0.0F);
        this.leftlowerarm = new ModelRenderer(this, 226, 138);
        this.leftlowerarm.field_78809_i = true;
        this.leftlowerarm.func_78793_a(4.0F, 20.0F, -1.0F);
        this.leftlowerarm.func_78790_a(-3.0F, -1.0F, -3.0F, 6, 24, 6, 0.0F);
        this.setRotateAngle(this.leftlowerarm, -0.5017822F, 0.0F, 0.0F);
        this.leftheadscale = new ModelRenderer(this, 0, 0);
        this.leftheadscale.func_78793_a(0.0F, 0.0F, 0.0F);
        this.leftheadscale.func_78790_a(3.0F, -12.0F, -10.0F, 2, 4, 6, 0.0F);
        this.rightwingtip = new ModelRenderer(this, 112, 136);
        this.rightwingtip.func_78793_a(-56.0F, 0.0F, 0.0F);
        this.rightwingtip.func_78790_a(-56.0F, -2.0F, -2.0F, 56, 4, 4, 0.0F);
        this.leftwingtip = new ModelRenderer(this, 112, 136);
        this.leftwingtip.field_78809_i = true;
        this.leftwingtip.func_78793_a(-56.0F, 0.0F, 0.0F);
        this.leftwingtip.func_78790_a(-56.0F, -2.0F, -2.0F, 56, 4, 4, 0.0F);
        this.tailscale8 = new ModelRenderer(this, 48, 0);
        this.tailscale8.func_78793_a(0.0F, 0.0F, 0.0F);
        this.tailscale8.func_78790_a(-1.0F, -9.0F, 2.0F, 2, 4, 6, 0.0F);
        this.tailscale1 = new ModelRenderer(this, 48, 0);
        this.tailscale1.func_78793_a(0.0F, 0.0F, 0.0F);
        this.tailscale1.func_78790_a(-1.0F, -9.0F, 2.0F, 2, 4, 6, 0.0F);
        this.tail2 = new ModelRenderer(this, 192, 104);
        this.tail2.func_78793_a(0.0F, 0.0F, 10.0F);
        this.tail2.func_78790_a(-5.0F, -5.0F, 0.0F, 10, 10, 10, 0.0F);
        this.rightwingtipskin = new ModelRenderer(this, -56, 144);
        this.rightwingtipskin.func_78793_a(0.0F, 0.0F, 0.0F);
        this.rightwingtipskin.func_78790_a(-56.0F, 0.0F, 2.0F, 56, 0, 56, 0.0F);
        this.neck2 = new ModelRenderer(this, 192, 104);
        this.neck2.func_78793_a(0.0F, 0.0F, -5.0F);
        this.neck2.func_78790_a(-5.0F, -5.0F, -10.0F, 10, 10, 10, 0.0F);
        this.neck5 = new ModelRenderer(this, 192, 104);
        this.neck5.func_78793_a(0.0F, 0.0F, -10.0F);
        this.neck5.func_78790_a(-5.0F, -5.0F, -10.0F, 10, 10, 10, 0.0F);
        this.tail9 = new ModelRenderer(this, 192, 104);
        this.tail9.func_78793_a(0.0F, 0.0F, 10.0F);
        this.tail9.func_78790_a(-5.0F, -5.0F, 0.0F, 10, 10, 10, 0.0F);
        this.rightwingskin = new ModelRenderer(this, -56, 88);
        this.rightwingskin.func_78793_a(0.0F, 0.0F, 0.0F);
        this.rightwingskin.func_78790_a(-56.0F, 0.0F, 2.0F, 56, 0, 56, 0.0F);
        this.tailscale3 = new ModelRenderer(this, 48, 0);
        this.tailscale3.func_78793_a(0.0F, 0.0F, 0.0F);
        this.tailscale3.func_78790_a(-1.0F, -9.0F, 2.0F, 2, 4, 6, 0.0F);
        this.rightnostril = new ModelRenderer(this, 112, 0);
        this.rightnostril.field_78809_i = true;
        this.rightnostril.func_78793_a(0.0F, 0.0F, 0.0F);
        this.rightnostril.func_78790_a(-5.0F, -3.0F, -14.0F, 2, 2, 4, 0.0F);
        this.tail6 = new ModelRenderer(this, 192, 104);
        this.tail6.func_78793_a(0.0F, 0.0F, 10.0F);
        this.tail6.func_78790_a(-5.0F, -5.0F, 0.0F, 10, 10, 10, 0.0F);
        this.tail5 = new ModelRenderer(this, 192, 104);
        this.tail5.func_78793_a(0.0F, 0.0F, 10.0F);
        this.tail5.func_78790_a(-5.0F, -5.0F, 0.0F, 10, 10, 10, 0.0F);
        this.lowerjaw = new ModelRenderer(this, 176, 65);
        this.lowerjaw.func_78793_a(0.0F, 4.0F, -16.0F);
        this.lowerjaw.func_78790_a(-6.0F, 0.0F, -16.0F, 12, 4, 16, 0.0F);
        this.rightfoot = new ModelRenderer(this, 112, 0);
        this.rightfoot.func_78793_a(0.0F, 31.0F, 4.0F);
        this.rightfoot.func_78790_a(-9.0F, 0.0F, -20.0F, 18, 6, 24, 0.0F);
        this.setRotateAngle(this.rightfoot, 0.75171334F, 0.0F, 0.0F);
        this.tailscale12 = new ModelRenderer(this, 48, 0);
        this.tailscale12.func_78793_a(0.0F, 0.0F, 0.0F);
        this.tailscale12.func_78790_a(-1.0F, -9.0F, 2.0F, 2, 4, 6, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.func_78793_a(0.0F, 0.0F, 0.0F);
        this.body.func_78790_a(-12.0F, -12.0F, -32.0F, 24, 24, 64, 0.0F);
        this.tailscale4 = new ModelRenderer(this, 48, 0);
        this.tailscale4.func_78793_a(0.0F, 0.0F, 0.0F);
        this.tailscale4.func_78790_a(-1.0F, -9.0F, 2.0F, 2, 4, 6, 0.0F);
        this.leftwing = new ModelRenderer(this, 112, 88);
        this.leftwing.field_78809_i = true;
        this.leftwing.func_78793_a(12.0F, -12.0F, -22.0F);
        this.leftwing.func_78790_a(-56.0F, -4.0F, -4.0F, 56, 8, 8, 0.0F);
        this.setRotateAngle(this.leftwing, 0.0F, 0.0F, (float)Math.PI);
        this.tail3 = new ModelRenderer(this, 192, 104);
        this.tail3.func_78793_a(0.0F, 0.0F, 10.0F);
        this.tail3.func_78790_a(-5.0F, -5.0F, 0.0F, 10, 10, 10, 0.0F);
        this.neckscale4 = new ModelRenderer(this, 48, 0);
        this.neckscale4.func_78793_a(0.0F, 0.0F, 0.0F);
        this.neckscale4.func_78790_a(-1.0F, -9.0F, -8.0F, 2, 4, 6, 0.0F);
        this.neck1.func_78792_a(this.neckscale1);
        this.neck3.func_78792_a(this.neck4);
        this.body.func_78792_a(this.leftfemur);
        this.neck3.func_78792_a(this.neckscale3);
        this.leftlowerarm.func_78792_a(this.lefthand);
        this.body.func_78792_a(this.leftupperarm);
        this.neck5.func_78792_a(this.neckscale5);
        this.tail6.func_78792_a(this.tailscale6);
        this.body.func_78792_a(this.rightupperarm);
        this.tail11.func_78792_a(this.tailscale11);
        this.tail3.func_78792_a(this.tail4);
        this.body.func_78792_a(this.bodyscale1);
        this.tail7.func_78792_a(this.tail8);
        this.leftfemur.func_78792_a(this.leftlowerleg);
        this.upperjaw.func_78792_a(this.leftnostril);
        this.tail11.func_78792_a(this.tail12);
        this.body.func_78792_a(this.rightwing);
        this.tail10.func_78792_a(this.tail11);
        this.neck2.func_78792_a(this.neck3);
        this.body.func_78792_a(this.neck1);
        this.body.func_78792_a(this.bodyscale3);
        this.rightlowerarm.func_78792_a(this.righthand);
        this.neck2.func_78792_a(this.neckscale2);
        this.tail2.func_78792_a(this.tailscale2);
        this.body.func_78792_a(this.bodyscale2);
        this.body.func_78792_a(this.tail1);
        this.tail5.func_78792_a(this.tailscale5);
        this.rightupperarm.func_78792_a(this.rightlowerarm);
        this.leftwingtip.func_78792_a(this.leftwingtipskin);
        this.tail10.func_78792_a(this.tailscale10);
        this.head.func_78792_a(this.rightheadscale);
        this.tail9.func_78792_a(this.tail10);
        this.tail7.func_78792_a(this.tailscale7);
        this.body.func_78792_a(this.rightfemur);
        this.rightfemur.func_78792_a(this.rightlowerleg);
        this.head.func_78792_a(this.upperjaw);
        this.tail6.func_78792_a(this.tail7);
        this.leftlowerleg.func_78792_a(this.leftfoot);
        this.neck5.func_78792_a(this.head);
        this.leftwing.func_78792_a(this.leftwingskin);
        this.tail9.func_78792_a(this.tailscale9);
        this.leftupperarm.func_78792_a(this.leftlowerarm);
        this.head.func_78792_a(this.leftheadscale);
        this.rightwing.func_78792_a(this.rightwingtip);
        this.leftwing.func_78792_a(this.leftwingtip);
        this.tail8.func_78792_a(this.tailscale8);
        this.tail1.func_78792_a(this.tailscale1);
        this.tail1.func_78792_a(this.tail2);
        this.rightwingtip.func_78792_a(this.rightwingtipskin);
        this.neck1.func_78792_a(this.neck2);
        this.neck4.func_78792_a(this.neck5);
        this.tail8.func_78792_a(this.tail9);
        this.rightwing.func_78792_a(this.rightwingskin);
        this.tail3.func_78792_a(this.tailscale3);
        this.upperjaw.func_78792_a(this.rightnostril);
        this.tail5.func_78792_a(this.tail6);
        this.tail4.func_78792_a(this.tail5);
        this.head.func_78792_a(this.lowerjaw);
        this.rightlowerleg.func_78792_a(this.rightfoot);
        this.tail12.func_78792_a(this.tailscale12);
        this.tail4.func_78792_a(this.tailscale4);
        this.body.func_78792_a(this.leftwing);
        this.tail2.func_78792_a(this.tail3);
        this.neck4.func_78792_a(this.neckscale4);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.func_78785_a(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}