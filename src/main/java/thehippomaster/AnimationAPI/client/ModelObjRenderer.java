//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package thehippomaster.AnimationAPI.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelObjRenderer extends ModelRenderer {
    public IModelCustom model;
    private float theScale;
    private int displayList;
    private boolean compiled;

    public ModelObjRenderer(ModelBase bass) {
        this(bass, (IModelCustom)null, 1.0F);
    }

    public ModelObjRenderer(ModelBase bass, IModelCustom shape) {
        this(bass, shape, 1.0F);
    }

    public ModelObjRenderer(ModelBase bass, IModelCustom shape, float scale) {
        super(bass);
        this.theScale = scale;
        this.model = shape;
    }

    public void setScale(float scale) {
        this.theScale = scale;
    }

    public void func_78785_a(float scale) {
        if (!this.field_78807_k && this.field_78806_j) {
            if (!this.compiled) {
                this.func_78788_d(scale);
            }

            GL11.glTranslatef(this.field_82906_o, this.field_82908_p, this.field_82907_q);
            if (this.field_78795_f == 0.0F && this.field_78796_g == 0.0F && this.field_78808_h == 0.0F) {
                if (this.field_78800_c == 0.0F && this.field_78797_d == 0.0F && this.field_78798_e == 0.0F) {
                    GL11.glPushMatrix();
                    GL11.glScalef(this.theScale, this.theScale, this.theScale);
                    GL11.glCallList(this.displayList);
                    GL11.glPopMatrix();
                    if (this.field_78805_m != null) {
                        for(int i = 0; i < this.field_78805_m.size(); ++i) {
                            ((ModelRenderer)this.field_78805_m.get(i)).func_78785_a(scale);
                        }
                    }
                } else {
                    GL11.glTranslatef(this.field_78800_c * scale, this.field_78797_d * scale, this.field_78798_e * scale);
                    GL11.glPushMatrix();
                    GL11.glScalef(this.theScale, this.theScale, this.theScale);
                    GL11.glCallList(this.displayList);
                    GL11.glPopMatrix();
                    if (this.field_78805_m != null) {
                        for(int i = 0; i < this.field_78805_m.size(); ++i) {
                            ((ModelRenderer)this.field_78805_m.get(i)).func_78785_a(scale);
                        }
                    }

                    GL11.glTranslatef(-this.field_78800_c * scale, -this.field_78797_d * scale, -this.field_78798_e * scale);
                }
            } else {
                GL11.glPushMatrix();
                GL11.glTranslatef(this.field_78800_c * scale, this.field_78797_d * scale, this.field_78798_e * scale);
                if (this.field_78808_h != 0.0F) {
                    GL11.glRotatef(this.field_78808_h * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
                }

                if (this.field_78796_g != 0.0F) {
                    GL11.glRotatef(this.field_78796_g * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
                }

                if (this.field_78795_f != 0.0F) {
                    GL11.glRotatef(this.field_78795_f * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
                }

                GL11.glPushMatrix();
                GL11.glScalef(this.theScale, this.theScale, this.theScale);
                GL11.glCallList(this.displayList);
                GL11.glPopMatrix();
                if (this.field_78805_m != null) {
                    for(int i = 0; i < this.field_78805_m.size(); ++i) {
                        ((ModelRenderer)this.field_78805_m.get(i)).func_78785_a(scale);
                    }
                }

                GL11.glPopMatrix();
            }

            GL11.glTranslatef(-this.field_82906_o, -this.field_82908_p, -this.field_82907_q);
        }

    }

    public void func_78791_b(float scale) {
        if (!this.field_78807_k && this.field_78806_j) {
            if (!this.compiled) {
                this.func_78788_d(scale);
            }

            GL11.glPushMatrix();
            GL11.glTranslatef(this.field_78800_c * scale, this.field_78797_d * scale, this.field_78798_e * scale);
            if (this.field_78796_g != 0.0F) {
                GL11.glRotatef(this.field_78796_g * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
            }

            if (this.field_78795_f != 0.0F) {
                GL11.glRotatef(this.field_78795_f * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
            }

            if (this.field_78808_h != 0.0F) {
                GL11.glRotatef(this.field_78808_h * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
            }

            GL11.glPushMatrix();
            GL11.glScalef(this.theScale, this.theScale, this.theScale);
            GL11.glCallList(this.displayList);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        }

    }

    protected void func_78788_d(float scale) {
        this.displayList = GLAllocation.func_74526_a(1);
        GL11.glNewList(this.displayList, 4864);
        GL11.glPushMatrix();
        GL11.glScalef(0.76F, 0.76F, 0.76F);
        GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
        this.model.renderAll();
        GL11.glPopMatrix();
        GL11.glEndList();
        this.compiled = true;
    }
}
