//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package thehippomaster.AnimationAPI.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public class ModelJoint extends ModelRenderer {
    private ModelRenderer model;

    public ModelJoint(ModelBase base) {
        this(base, (String)null);
        super.func_78792_a(this.model = new ModelRenderer(base));
    }

    public ModelJoint(ModelBase base, int x, int y) {
        this(base);
        this.model = new ModelRenderer(base, x, y);
        this.model.func_78784_a(x, y);
        super.func_78792_a(this.model);
    }

    public ModelJoint(ModelBase base, String name) {
        super(base, name);
        this.model = new ModelRenderer(base, name);
        this.model.func_78784_a(0, 0);
        this.model.func_78787_b(base.field_78090_t, base.field_78089_u);
        super.func_78792_a(this.model);
    }

    public ModelRenderer setModel(ModelRenderer newModel) {
        this.field_78805_m.remove(this.model);
        this.model = newModel;
        super.func_78792_a(newModel);
        return this;
    }

    public ModelRenderer func_78784_a(int x, int y) {
        if (this.model != null) {
            this.model.func_78784_a(x, y);
        }

        return this;
    }

    public ModelRenderer func_78787_b(int w, int h) {
        if (this.model != null) {
            this.model.func_78787_b(w, h);
        }

        return this;
    }

    public ModelRenderer func_78786_a(String name, float x, float y, float z, int w, int h, int d) {
        this.model.func_78786_a(name, x, y, z, w, h, d);
        return this;
    }

    public ModelRenderer func_78789_a(float x, float y, float z, int w, int h, int d) {
        this.model.func_78789_a(x, y, z, w, h, d);
        return this;
    }

    public void func_78790_a(float x, float y, float z, int w, int h, int d, float offset) {
        this.model.func_78790_a(x, y, z, w, h, d, offset);
    }

    public void func_78792_a(ModelRenderer child) {
        this.model.func_78792_a(child);
    }

    public ModelRenderer getModel() {
        return this.model;
    }
}
