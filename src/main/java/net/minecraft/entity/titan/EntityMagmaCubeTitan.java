//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityMagmaCubeTitan extends EntitySlimeTitan {
    public EntityMagmaCubeTitan(World worldIn) {
        super(worldIn);
        this.shouldParticlesBeUpward = true;
    }

    protected void applyEntityAI() {
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.MagmaCubeTitanSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

    }

    protected String getSlimeParticle() {
        return "flame";
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != EntityMagmaCube.class && p_70686_1_ != EntityMagmaCubeTitan.class;
    }

    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(50) == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL;
    }

    public int getMinionSpawnRate() {
        return TheTitans.MagmaCubeTitanMinionSpawnrate;
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.5F);
    }

    protected boolean isValidLightLevel() {
        return true;
    }

    public boolean func_70058_J() {
        return false;
    }

    protected boolean makesSoundOnLand() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public int func_70070_b(float p_70070_1_) {
        return 15728880;
    }

    public float func_70013_c(float p_70013_1_) {
        return 1.0F;
    }

    protected String func_180487_n() {
        return "flame";
    }

    protected EntitySlime createProtoInstance() {
        return new EntityMagmaCube(this.field_70170_p);
    }

    protected EntitySlimeTitan createInstance() {
        return new EntityMagmaCubeTitan(this.field_70170_p);
    }

    protected Item func_146068_u() {
        return Items.field_151064_bs;
    }

    public boolean func_70027_ad() {
        return false;
    }

    protected int getJumpDelay() {
        return super.getJumpDelay() * 4;
    }

    protected String func_70673_aS() {
        return "mob.magmacube.jump";
    }

    protected void alterSquishAmount() {
        this.squishAmount *= 0.95F;
    }

    protected void func_70664_aZ() {
        this.field_70181_x = (double)4.0F + (double)((float)this.getSlimeSize() * 0.33F);
        this.field_70160_al = true;
        if (this.func_70638_az() != null) {
            double d01 = this.func_70638_az().field_70165_t - this.field_70165_t;
            double d11 = this.func_70638_az().field_70161_v - this.field_70161_v;
            float f21 = MathHelper.func_76133_a(d01 * d01 + d11 * d11);
            double hor = (double)1.0F + (double)((float)this.getSlimeSize() * 0.25F);
            this.field_70159_w = d01 / (double)f21 * hor * hor + this.field_70159_w * hor;
            this.field_70179_y = d11 / (double)f21 * hor * hor + this.field_70179_y * hor;
        }

    }

    protected void func_180466_bG() {
        this.field_70181_x = (double)(2.5F + (float)this.getSlimeSize() * 0.05F);
        this.field_70160_al = true;
        if (this.func_70638_az() != null) {
            double d01 = this.func_70638_az().field_70165_t - this.field_70165_t;
            double d11 = this.func_70638_az().field_70161_v - this.field_70161_v;
            float f21 = MathHelper.func_76133_a(d01 * d01 + d11 * d11);
            double hor = (double)1.0F + (double)((float)this.getSlimeSize() * 0.25F);
            this.field_70159_w = d01 / (double)f21 * hor * hor + this.field_70159_w * hor;
            this.field_70179_y = d11 / (double)f21 * hor * hor + this.field_70179_y * hor;
        }

    }

    protected boolean canDamagePlayer() {
        return true;
    }

    protected int getAttackStrength() {
        return TheTitans.NightmareMode ? this.getSlimeSize() * 180 : this.getSlimeSize() * 60;
    }

    protected String getJumpSound() {
        return "mob.magmacube.big";
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (this.func_85032_ar()) {
            return false;
        } else if (source.func_76347_k()) {
            this.func_70691_i(amount);
            return false;
        } else {
            return super.func_70097_a(source, amount);
        }
    }
}
