//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package thehippomaster.AnimationAPI.client;


import java.util.HashMap;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

@SideOnly(Side.CLIENT)
public class Animator {
    private int tempTick = 0;
    private int prevTempTick;
    private boolean correctAnim = false;
    private ModelBase mainModel;
    private IAnimatedEntity animEntity;
    private HashMap<ModelRenderer, Transform> transformMap;
    private HashMap<ModelRenderer, Transform> prevTransformMap;
    public static final float PI = (float)Math.PI;

    public Animator(ModelBase model) {
        this.mainModel = model;
        this.transformMap = new HashMap();
        this.prevTransformMap = new HashMap();
    }

    public IAnimatedEntity getEntity() {
        return this.animEntity;
    }

    public void update(IAnimatedEntity entity) {
        this.tempTick = this.prevTempTick = 0;
        this.correctAnim = false;
        this.animEntity = entity;
        this.transformMap.clear();
        this.prevTransformMap.clear();

        for(int i = 0; i < this.mainModel.field_78092_r.size(); ++i) {
            ModelRenderer box = (ModelRenderer)this.mainModel.field_78092_r.get(i);
            box.field_78795_f = 0.0F;
            box.field_78796_g = 0.0F;
            box.field_78808_h = 0.0F;
        }

    }

    public boolean setAnim(int animID) {
        this.tempTick = this.prevTempTick = 0;
        this.correctAnim = this.animEntity.getAnimID() == animID;
        return this.correctAnim;
    }

    public void startPhase(int duration) {
        if (this.correctAnim) {
            this.prevTempTick = this.tempTick;
            this.tempTick += duration;
        }
    }

    public void setStationaryPhase(int duration) {
        this.startPhase(duration);
        this.endPhase(true);
    }

    public void resetPhase(int duration) {
        this.startPhase(duration);
        this.endPhase();
    }

    public void rotate(ModelRenderer box, float x, float y, float z) {
        if (this.correctAnim) {
            if (!this.transformMap.containsKey(box)) {
                this.transformMap.put(box, new Transform(x, y, z));
            } else {
                ((Transform)this.transformMap.get(box)).addRot(x, y, z);
            }

        }
    }

    public void move(ModelRenderer box, float x, float y, float z) {
        if (this.correctAnim) {
            if (!this.transformMap.containsKey(box)) {
                this.transformMap.put(box, new Transform(x, y, z, 0.0F, 0.0F, 0.0F));
            } else {
                ((Transform)this.transformMap.get(box)).addOffset(x, y, z);
            }

        }
    }

    public void endPhase() {
        this.endPhase(false);
    }

    private void endPhase(boolean stationary) {
        if (this.correctAnim) {
            int animTick = this.animEntity.getAnimTick();
            if (animTick >= this.prevTempTick && animTick < this.tempTick) {
                if (stationary) {
                    for(ModelRenderer box : this.prevTransformMap.keySet()) {
                        Transform transform = (Transform)this.prevTransformMap.get(box);
                        box.field_78795_f += transform.rotX;
                        box.field_78796_g += transform.rotY;
                        box.field_78808_h += transform.rotZ;
                        box.field_78800_c += transform.offsetX;
                        box.field_78797_d += transform.offsetY;
                        box.field_78798_e += transform.offsetZ;
                    }
                } else {
                    float tick = ((float)(animTick - this.prevTempTick) + AnimationAPI.proxy.getPartialTick()) / (float)(this.tempTick - this.prevTempTick);
                    float inc = MathHelper.func_76126_a(tick * (float)Math.PI / 2.0F);
                    float dec = 1.0F - inc;

                    for(ModelRenderer box : this.prevTransformMap.keySet()) {
                        Transform transform = (Transform)this.prevTransformMap.get(box);
                        box.field_78795_f += dec * transform.rotX;
                        box.field_78796_g += dec * transform.rotY;
                        box.field_78808_h += dec * transform.rotZ;
                        box.field_78800_c += dec * transform.offsetX;
                        box.field_78797_d += dec * transform.offsetY;
                        box.field_78798_e += dec * transform.offsetZ;
                    }

                    for(ModelRenderer box : this.transformMap.keySet()) {
                        Transform transform = (Transform)this.transformMap.get(box);
                        box.field_78795_f += inc * transform.rotX;
                        box.field_78796_g += inc * transform.rotY;
                        box.field_78808_h += inc * transform.rotZ;
                        box.field_78800_c += inc * transform.offsetX;
                        box.field_78797_d += inc * transform.offsetY;
                        box.field_78798_e += inc * transform.offsetZ;
                    }
                }
            }

            if (!stationary) {
                this.prevTransformMap.clear();
                this.prevTransformMap.putAll(this.transformMap);
                this.transformMap.clear();
            }

        }
    }
}
