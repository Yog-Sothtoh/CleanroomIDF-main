//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans;

import java.util.Comparator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;

public class TargetingSorter implements Comparator {
    private Entity theEntity;

    public TargetingSorter(Entity par2Entity) {
        this.theEntity = par2Entity;
    }

    public int compareDistanceSq(Entity par1Entity, Entity par2Entity) {
        double weight = (double)0.0F;
        double var3 = this.theEntity.func_70068_e(par1Entity);
        if (par1Entity instanceof EntityCreeper) {
            var3 /= (double)2.0F;
        }

        weight = (double)(par1Entity.field_70131_O * par1Entity.field_70130_N);
        if (weight > (double)1.0F) {
            var3 /= weight;
        }

        double var5 = this.theEntity.func_70068_e(par2Entity);
        if (par2Entity instanceof EntityCreeper) {
            var5 /= (double)2.0F;
        }

        weight = (double)(par2Entity.field_70131_O * par2Entity.field_70130_N);
        if (weight > (double)1.0F) {
            var5 /= weight;
        }

        return var3 > var5 ? 1 : (var3 < var5 ? -1 : 0);
    }

    public int compare(Object par1Obj, Object par2Obj) {
        return this.compareDistanceSq((Entity)par1Obj, (Entity)par2Obj);
    }
}
