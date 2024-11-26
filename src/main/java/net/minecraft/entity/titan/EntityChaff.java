//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityChaff extends Entity {
    public int lifespan;

    public EntityChaff(World worldIn) {
        super(worldIn);
        this.func_70105_a(1.0F, 1.0F);
        this.field_70156_m = true;
    }

    protected void func_70088_a() {
        this.field_70180_af.func_75682_a(8, this.lifespan);
    }

    protected void func_70037_a(NBTTagCompound tagCompund) {
    }

    protected void func_70014_b(NBTTagCompound tagCompound) {
    }

    public void func_70071_h_() {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.field_70180_af.func_75692_b(8, this.lifespan);
        int i = MathHelper.func_76128_c(this.field_70165_t);
        int j = MathHelper.func_76128_c(this.field_70163_u);
        int k = MathHelper.func_76128_c(this.field_70161_v);
        float f = (this.field_70146_Z.nextFloat() - 0.5F) * 16.0F;
        float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 16.0F;
        float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 16.0F;
        this.field_70170_p.func_72869_a("smoke", this.field_70165_t + (double)f, this.field_70163_u + (double)2.0F + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
        this.field_70170_p.func_72869_a("explode", this.field_70165_t + (double)f, this.field_70163_u + (double)2.0F + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
        ++this.lifespan;
        if (this.lifespan == 1) {
            this.func_85030_a("thetitans:chaffDeployment", 5.0F, 1.0F);
        }

        if (this.lifespan == 300) {
            this.func_70106_y();
        }

        List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)24.0F, (double)24.0F, (double)24.0F));
        if (list != null && !list.isEmpty()) {
            for(int i1 = 0; i1 < list.size(); ++i1) {
                Entity entity = (Entity)list.get(i1);
                if (entity instanceof EntityHomingWitherSkull && entity != null) {
                    ((EntityHomingWitherSkull)entity).assginedEntity = null;
                }
            }
        }

    }

    protected void collideWithNearbyEntities() {
    }
}
