//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans;

import net.minecraft.entity.Entity;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class DamageSourceExtra extends DamageSource {
    public static DamageSource wip = (new DamageSource("wip")).func_76348_h().func_76359_i().func_151518_m();
    public static DamageSource destroy = (new DamageSource("outOfWorld")).func_76348_h().func_76359_i().func_151518_m().func_76351_m();
    public static DamageSource lightningBolt = (new DamageSource("lightningBolt")).func_76361_j().func_76348_h().func_151518_m();
    public static DamageSource mindCrush = (new DamageSource("mindcrush")).func_76348_h().func_151518_m().func_76359_i();
    public static DamageSource radiation = (new DamageSource("radiation")).func_76348_h().func_151518_m();

    public DamageSourceExtra(String damageTypeIn) {
        super(damageTypeIn);
    }

    public static DamageSource causeSoulStealingDamage(Entity p_92087_0_) {
        return (new EntityDamageSource("soulSucking", p_92087_0_)).func_76348_h().func_151518_m().func_76359_i().func_82726_p();
    }

    public static DamageSource causeSquishingDamage(Entity p_92087_0_) {
        return (new EntityDamageSource("squash", p_92087_0_)).func_76348_h().func_76351_m();
    }

    public static DamageSource causeArmorPiercingMobDamage(Entity p_92087_0_) {
        return (new EntityDamageSource("mob", p_92087_0_)).func_76348_h().func_151518_m();
    }

    public static DamageSource causeAntiTitanDamage(Entity p_92087_0_) {
        return (new EntityDamageSource("mob", p_92087_0_)).func_76348_h();
    }

    public static DamageSource causeHarcadiumArrowDamage(EntityHarcadiumArrow arrow, Entity p_76353_1_) {
        return (new EntityDamageSourceIndirect("arrow", arrow, p_76353_1_)).func_76359_i().func_76348_h();
    }

    public static DamageSource causeHomingSkullDamage(Entity p_92087_0_) {
        return (new EntityDamageSource("arrow", p_92087_0_)).func_76348_h();
    }

    public static DamageSource causeHomingSkullDamageVSEnderDragon(Entity p_92087_0_) {
        return (new EntityDamageSource("arrow", p_92087_0_)).func_76348_h().func_94540_d();
    }

    public static DamageSource causeVaroizationDamage(Entity p_92087_0_) {
        return (new EntityDamageSource("vaporize", p_92087_0_)).func_76348_h().func_82726_p();
    }

    public static DamageSource causeCreeperTitanExplosionDamage(Entity p_92087_0_) {
        return (new EntityDamageSource("explosion.player", p_92087_0_)).func_76351_m().func_76348_h().func_94540_d();
    }
}
