//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.models;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.titanminion.EntityDragonMinion;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelDragonMinion extends ModelBase {
    private ModelRenderer head;
    private ModelRenderer spine;
    private ModelRenderer jaw;
    private ModelRenderer body;
    private ModelRenderer rearLeg;
    private ModelRenderer frontLeg;
    private ModelRenderer rearLegTip;
    private ModelRenderer frontLegTip;
    private ModelRenderer rearFoot;
    private ModelRenderer frontFoot;
    private ModelRenderer wing;
    private ModelRenderer wingTip;
    private float partialTicks;
    private static final String __OBFID = "CL_00000870";

    public ModelDragonMinion(float p_i1169_1_) {
        this.field_78090_t = 256;
        this.field_78089_u = 256;
        this.func_78085_a("body.body", 0, 0);
        this.func_78085_a("wing.skin", -56, 88);
        this.func_78085_a("wingtip.skin", -56, 144);
        this.func_78085_a("rearleg.main", 0, 0);
        this.func_78085_a("rearfoot.main", 112, 0);
        this.func_78085_a("rearlegtip.main", 196, 0);
        this.func_78085_a("head.upperhead", 112, 30);
        this.func_78085_a("wing.bone", 112, 88);
        this.func_78085_a("head.upperlip", 176, 44);
        this.func_78085_a("jaw.jaw", 176, 65);
        this.func_78085_a("frontleg.main", 112, 104);
        this.func_78085_a("wingtip.bone", 112, 136);
        this.func_78085_a("frontfoot.main", 144, 104);
        this.func_78085_a("neck.box", 192, 104);
        this.func_78085_a("frontlegtip.main", 226, 138);
        this.func_78085_a("body.scale", 220, 53);
        this.func_78085_a("head.scale", 0, 0);
        this.func_78085_a("neck.scale", 48, 0);
        this.func_78085_a("head.nostril", 112, 0);
        float f1 = -16.0F;
        this.head = new ModelRenderer(this, "head");
        this.head.func_78786_a("upperlip", -6.0F, -1.0F, -8.0F + f1, 12, 5, 16);
        this.head.func_78786_a("upperhead", -8.0F, -8.0F, 6.0F + f1, 16, 16, 16);
        this.head.field_78809_i = true;
        this.head.func_78786_a("scale", -5.0F, -12.0F, 12.0F + f1, 2, 4, 6);
        this.head.func_78786_a("nostril", -5.0F, -3.0F, -6.0F + f1, 2, 2, 4);
        this.head.field_78809_i = false;
        this.head.func_78786_a("scale", 3.0F, -12.0F, 12.0F + f1, 2, 4, 6);
        this.head.func_78786_a("nostril", 3.0F, -3.0F, -6.0F + f1, 2, 2, 4);
        this.jaw = new ModelRenderer(this, "jaw");
        this.jaw.func_78793_a(0.0F, 4.0F, 8.0F + f1);
        this.jaw.func_78786_a("jaw", -6.0F, 0.0F, -16.0F, 12, 4, 16);
        this.head.func_78792_a(this.jaw);
        this.spine = new ModelRenderer(this, "neck");
        this.spine.func_78786_a("box", -5.0F, -5.0F, -5.0F, 10, 10, 10);
        this.spine.func_78786_a("scale", -1.0F, -9.0F, -3.0F, 2, 4, 6);
        this.body = new ModelRenderer(this, "body");
        this.body.func_78793_a(0.0F, 4.0F, 8.0F);
        this.body.func_78786_a("body", -12.0F, 0.0F, -16.0F, 24, 24, 64);
        this.body.func_78786_a("scale", -1.0F, -6.0F, -10.0F, 2, 6, 12);
        this.body.func_78786_a("scale", -1.0F, -6.0F, 10.0F, 2, 6, 12);
        this.body.func_78786_a("scale", -1.0F, -6.0F, 30.0F, 2, 6, 12);
        this.wing = new ModelRenderer(this, "wing");
        this.wing.func_78793_a(-12.0F, 5.0F, 2.0F);
        this.wing.func_78786_a("bone", -56.0F, -4.0F, -4.0F, 56, 8, 8);
        this.wing.func_78786_a("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
        this.wingTip = new ModelRenderer(this, "wingtip");
        this.wingTip.func_78793_a(-56.0F, 0.0F, 0.0F);
        this.wingTip.func_78786_a("bone", -56.0F, -2.0F, -2.0F, 56, 4, 4);
        this.wingTip.func_78786_a("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
        this.wing.func_78792_a(this.wingTip);
        this.frontLeg = new ModelRenderer(this, "frontleg");
        this.frontLeg.func_78793_a(-12.0F, 20.0F, 2.0F);
        this.frontLeg.func_78786_a("main", -4.0F, -4.0F, -4.0F, 8, 24, 8);
        this.frontLegTip = new ModelRenderer(this, "frontlegtip");
        this.frontLegTip.func_78793_a(0.0F, 20.0F, -1.0F);
        this.frontLegTip.func_78786_a("main", -3.0F, -1.0F, -3.0F, 6, 24, 6);
        this.frontLeg.func_78792_a(this.frontLegTip);
        this.frontFoot = new ModelRenderer(this, "frontfoot");
        this.frontFoot.func_78793_a(0.0F, 23.0F, 0.0F);
        this.frontFoot.func_78786_a("main", -4.0F, 0.0F, -12.0F, 8, 4, 16);
        this.frontLegTip.func_78792_a(this.frontFoot);
        this.rearLeg = new ModelRenderer(this, "rearleg");
        this.rearLeg.func_78793_a(-16.0F, 16.0F, 42.0F);
        this.rearLeg.func_78786_a("main", -8.0F, -4.0F, -8.0F, 16, 32, 16);
        this.rearLegTip = new ModelRenderer(this, "rearlegtip");
        this.rearLegTip.func_78793_a(0.0F, 32.0F, -4.0F);
        this.rearLegTip.func_78786_a("main", -6.0F, -2.0F, 0.0F, 12, 32, 12);
        this.rearLeg.func_78792_a(this.rearLegTip);
        this.rearFoot = new ModelRenderer(this, "rearfoot");
        this.rearFoot.func_78793_a(0.0F, 31.0F, 4.0F);
        this.rearFoot.func_78786_a("main", -9.0F, 0.0F, -20.0F, 18, 6, 24);
        this.rearLegTip.func_78792_a(this.rearFoot);
    }

    public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
        this.partialTicks = p_78086_4_;
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
        GL11.glPushMatrix();
        EntityDragonMinion entitydragon = (EntityDragonMinion)p_78088_1_;
        float f6 = entitydragon.prevAnimTime + (entitydragon.animTime - entitydragon.prevAnimTime) * this.partialTicks;
        this.jaw.field_78795_f = (float)(Math.sin((double)(f6 * (float)Math.PI * 2.0F)) + (double)1.0F) * 0.2F;
        float f7 = (float)(Math.sin((double)(f6 * (float)Math.PI * 2.0F - 1.0F)) + (double)1.0F);
        f7 = (f7 * f7 * 1.0F + f7 * 2.0F) * 0.05F;
        GL11.glTranslatef(0.0F, f7 - 2.0F, -3.0F);
        GL11.glRotatef(f7 * 2.0F, 1.0F, 0.0F, 0.0F);
        float f8 = -30.0F;
        float f10 = 0.0F;
        float f11 = 1.5F;
        double[] adouble = entitydragon.getMovementOffsets(6, this.partialTicks);
        float f12 = this.updateRotations(entitydragon.getMovementOffsets(5, this.partialTicks)[0] - entitydragon.getMovementOffsets(10, this.partialTicks)[0]);
        float f13 = this.updateRotations(entitydragon.getMovementOffsets(5, this.partialTicks)[0] + (double)(f12 / 2.0F));
        f8 += 2.0F;
        float f14 = f6 * (float)Math.PI * 2.0F;
        f8 = 20.0F;
        float f9 = -12.0F;

        for(int i = 0; i < 5; ++i) {
            double[] adouble1 = entitydragon.getMovementOffsets(5 - i, this.partialTicks);
            float f15 = (float)Math.cos((double)((float)i * 0.45F + f14)) * 0.15F;
            this.spine.field_78796_g = this.updateRotations(adouble1[0] - adouble[0]) * (float)Math.PI / 180.0F * f11;
            this.spine.field_78795_f = f15 + (float)(adouble1[1] - adouble[1]) * (float)Math.PI / 180.0F * f11 * 5.0F;
            this.spine.field_78808_h = -this.updateRotations(adouble1[0] - (double)f13) * (float)Math.PI / 180.0F * f11;
            this.spine.field_78797_d = f8;
            this.spine.field_78798_e = f9;
            this.spine.field_78800_c = f10;
            f8 = (float)((double)f8 + Math.sin((double)this.spine.field_78795_f) * (double)10.0F);
            f9 = (float)((double)f9 - Math.cos((double)this.spine.field_78796_g) * Math.cos((double)this.spine.field_78795_f) * (double)10.0F);
            f10 = (float)((double)f10 - Math.sin((double)this.spine.field_78796_g) * Math.cos((double)this.spine.field_78795_f) * (double)10.0F);
            this.spine.func_78785_a(p_78088_7_);
        }

        this.head.field_78797_d = f8;
        this.head.field_78798_e = f9;
        this.head.field_78800_c = f10;
        double[] adouble2 = entitydragon.getMovementOffsets(0, this.partialTicks);
        this.head.field_78796_g = this.updateRotations(adouble2[0] - adouble[0]) * (float)Math.PI / 180.0F * 1.0F;
        this.head.field_78808_h = -this.updateRotations(adouble2[0] - (double)f13) * (float)Math.PI / 180.0F * 1.0F;
        this.head.func_78785_a(p_78088_7_);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-f12 * f11 * 1.0F, 0.0F, 0.0F, 1.0F);
        GL11.glTranslatef(0.0F, -1.0F, 0.0F);
        this.body.field_78808_h = 0.0F;
        this.body.func_78785_a(p_78088_7_);

        for(int j = 0; j < 2; ++j) {
            GL11.glEnable(2884);
            float f15 = f6 * (float)Math.PI * 2.0F;
            this.wing.field_78795_f = 0.125F - (float)Math.cos((double)f15) * 0.2F;
            this.wing.field_78796_g = 0.25F;
            this.wing.field_78808_h = (float)(Math.sin((double)f15) + (double)0.125F) * 0.8F;
            this.wingTip.field_78808_h = -((float)(Math.sin((double)(f15 + 2.0F)) + (double)0.5F)) * 0.75F;
            this.rearLeg.field_78795_f = 1.0F + f7 * 0.1F;
            this.rearLegTip.field_78795_f = 0.5F + f7 * 0.1F;
            this.rearFoot.field_78795_f = 0.75F + f7 * 0.1F;
            this.frontLeg.field_78795_f = 1.3F + f7 * 0.1F;
            this.frontLegTip.field_78795_f = -0.5F - f7 * 0.1F;
            this.frontFoot.field_78795_f = 0.75F + f7 * 0.1F;
            this.wing.func_78785_a(p_78088_7_);
            this.frontLeg.func_78785_a(p_78088_7_);
            this.rearLeg.func_78785_a(p_78088_7_);
            GL11.glScalef(-1.0F, 1.0F, 1.0F);
            if (j == 0) {
                GL11.glCullFace(1028);
            }
        }

        GL11.glPopMatrix();
        GL11.glCullFace(1029);
        GL11.glDisable(2884);
        float f16 = -((float)Math.sin((double)(f6 * (float)Math.PI * 2.0F))) * 0.0F;
        f14 = f6 * (float)Math.PI * 2.0F;
        f8 = 10.0F;
        f9 = 60.0F;
        f10 = 0.0F;
        adouble = entitydragon.getMovementOffsets(11, this.partialTicks);

        for(int k = 0; k < 12; ++k) {
            adouble2 = entitydragon.getMovementOffsets(12 + k, this.partialTicks);
            f16 = (float)((double)f16 + Math.sin((double)((float)k * 0.45F + f14)) * (double)0.05F);
            this.spine.field_78796_g = (this.updateRotations(adouble2[0] - adouble[0]) * f11 + 180.0F) * (float)Math.PI / 180.0F;
            this.spine.field_78795_f = f16 + (float)(adouble2[1] - adouble[1]) * (float)Math.PI / 180.0F * f11 * 5.0F;
            this.spine.field_78808_h = this.updateRotations(adouble2[0] - (double)f13) * (float)Math.PI / 180.0F * f11;
            this.spine.field_78797_d = f8;
            this.spine.field_78798_e = f9;
            this.spine.field_78800_c = f10;
            f8 = (float)((double)f8 + Math.sin((double)this.spine.field_78795_f) * (double)10.0F);
            f9 = (float)((double)f9 - Math.cos((double)this.spine.field_78796_g) * Math.cos((double)this.spine.field_78795_f) * (double)10.0F);
            f10 = (float)((double)f10 - Math.sin((double)this.spine.field_78796_g) * Math.cos((double)this.spine.field_78795_f) * (double)10.0F);
            this.spine.func_78785_a(p_78088_7_);
        }

        GL11.glPopMatrix();
    }

    private float updateRotations(double p_78214_1_) {
        while(p_78214_1_ >= (double)180.0F) {
            p_78214_1_ -= (double)360.0F;
        }

        while(p_78214_1_ < (double)-180.0F) {
            p_78214_1_ += (double)360.0F;
        }

        return (float)p_78214_1_;
    }
}
