//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package thehippomaster.AnimationAPI;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public abstract class AIAnimation extends EntityAIBase {
    private IAnimatedEntity animatedEntity;

    public AIAnimation(IAnimatedEntity entity) {
        this.animatedEntity = entity;
        this.func_75248_a(7);
    }

    public abstract int getAnimID();

    public EntityLiving getEntity() {
        return (EntityLiving)this.animatedEntity;
    }

    public abstract boolean isAutomatic();

    public abstract int getDuration();

    public boolean shouldAnimate() {
        return false;
    }

    public boolean func_75250_a() {
        if (this.isAutomatic()) {
            return this.animatedEntity.getAnimID() == this.getAnimID();
        } else {
            return this.shouldAnimate();
        }
    }

    public void func_75249_e() {
        if (!this.isAutomatic()) {
            AnimationAPI.sendAnimPacket(this.animatedEntity, this.getAnimID());
        }

        this.animatedEntity.setAnimTick(0);
    }

    public boolean func_75253_b() {
        return this.animatedEntity.getAnimTick() < this.getDuration() && this.getEntity().field_70173_aa > 0;
    }

    public void func_75251_c() {
        AnimationAPI.sendAnimPacket(this.animatedEntity, 0);
    }
}
