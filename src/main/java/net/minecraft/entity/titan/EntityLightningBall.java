//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titanminion.EntityDragonMinion;
import net.minecraft.entity.titanminion.EntityEndermanMinion;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLightningBall extends EntityFireball {
    public EntityLightningBall(World worldIn) {
        super(worldIn);
        this.func_70105_a(4.0F, 4.0F);
    }

    public EntityLightningBall(World worldIn, EntityLivingBase p_i1771_2_, double p_i1771_3_, double p_i1771_5_, double p_i1771_7_) {
        super(worldIn, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
        this.func_70105_a(4.0F, 4.0F);
    }

    public EntityLightningBall(World worldIn, double p_i1772_2_, double p_i1772_4_, double p_i1772_6_, double p_i1772_8_, double p_i1772_10_, double p_i1772_12_) {
        super(worldIn, p_i1772_2_, p_i1772_4_, p_i1772_6_, p_i1772_8_, p_i1772_10_, p_i1772_12_);
        this.func_70105_a(4.0F, 4.0F);
    }

    protected void func_70227_a(MovingObjectPosition movingObject) {
        if (!this.field_70170_p.field_72995_K) {
            float f;
            if (TheTitans.NightmareMode) {
                f = 6000.0F;
            } else {
                f = 2000.0F;
            }

            if (movingObject.field_72308_g != null) {
                movingObject.field_72308_g.func_70097_a(DamageSource.func_76362_a(this, this.field_70235_a), f);
                boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
                this.field_70170_p.func_72885_a((Entity)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 7.0F, true, flag);
            } else {
                this.func_85030_a("random.explode", 4.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 0.7F);
            }

            this.func_70106_y();
        }

    }

    public void func_70071_h_() {
        super.func_70071_h_();
        this.func_70015_d(4);
        if (this.field_70173_aa % 600 == 0) {
            boolean flag = this.field_70170_p.func_82736_K().func_82766_b("mobGriefing");
            this.field_70170_p.func_72885_a((Entity)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 7.0F, true, flag);
            this.func_70106_y();
        }

        if (this.field_70146_Z.nextInt(30) == 0) {
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1.0F, 0.0F, 1.0F));
        }

        List list11 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)8.0F, (double)8.0F, (double)8.0F));
        if (list11 != null && !list11.isEmpty() && this.field_70235_a != null) {
            for(int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (entity != null && entity.func_70089_S() && entity instanceof EntityLivingBase && this.field_70235_a instanceof EntityEnderColossus && !(entity instanceof EntityEndermanMinion) && !(entity instanceof EntityEnderColossus) && !(entity instanceof EntityDragon) && !(entity instanceof EntityDragonMinion) && !(entity instanceof EntityEnderColossusCrystal)) {
                    entity.func_70015_d(15);
                    entity.func_70097_a(DamageSourceExtra.lightningBolt, 100.0F);
                    this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1.0F, 0.0F, 1.0F));
                    this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 1.0F, 0.0F, 1.0F));
                    ((EntityEnderColossus)this.field_70235_a).attackChoosenEntity(entity, 5.0F, 1);
                }
            }
        }

    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean func_70027_ad() {
        return false;
    }

    protected float func_82341_c() {
        return 0.75F;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        return false;
    }
}
