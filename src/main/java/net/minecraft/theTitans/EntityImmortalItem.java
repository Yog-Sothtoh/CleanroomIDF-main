//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityImmortalItem extends EntityItem {
    public EntityImmortalItem(World world, Entity original, ItemStack stack) {
        this(world, original.field_70165_t, original.field_70163_u, original.field_70161_v, stack);
        this.field_145804_b = 20;
        this.field_70159_w = original.field_70159_w;
        this.field_70181_x = original.field_70181_x;
        this.field_70179_y = original.field_70179_y;
        this.func_92058_a(stack);
        this.field_70158_ak = true;
    }

    public EntityImmortalItem(World world, double x, double y, double z, ItemStack stack) {
        super(world, x, y, z);
        this.func_92058_a(stack);
    }

    public EntityImmortalItem(World world, double x, double y, double z) {
        super(world, x, y, z);
        this.field_70178_ae = true;
    }

    public EntityImmortalItem(World world) {
        super(world);
        this.field_70178_ae = true;
    }

    protected void func_70081_e(int damage) {
    }

    public boolean func_85032_ar() {
        return true;
    }

    public boolean func_70097_a(DamageSource source, float damage) {
        EntityPlayer player = this.field_70170_p.func_72890_a(this, (double)-1.0F);
        if (player != null) {
            this.field_145804_b = 0;
            this.func_82149_j(player);
        }

        return false;
    }

    public void func_70071_h_() {
        ItemStack stack = this.func_70096_w().func_82710_f(10);
        if (stack == null || stack.func_77973_b() == null || !stack.func_77973_b().onEntityItemUpdate(this)) {
            if (this.func_92059_d() == null) {
                this.func_70106_y();
            } else {
                this.func_70030_z();
                if (this.field_145804_b > 0) {
                    --this.field_145804_b;
                }

                this.field_70169_q = this.field_70165_t;
                this.field_70167_r = this.field_70163_u;
                this.field_70166_s = this.field_70161_v;
                this.field_70181_x -= (double)0.04F;
                this.field_70145_X = this.func_145771_j(this.field_70165_t, (this.field_70121_D.field_72338_b + this.field_70121_D.field_72337_e) / (double)2.0F, this.field_70161_v);
                this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
                boolean flag = (int)this.field_70169_q != (int)this.field_70165_t || (int)this.field_70167_r != (int)this.field_70163_u || (int)this.field_70166_s != (int)this.field_70161_v;
                if (flag || this.field_70173_aa % 25 == 0) {
                    if (this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)).func_149688_o() == Material.field_151587_i) {
                        this.field_70181_x = (double)0.2F;
                        this.field_70159_w = (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F);
                        this.field_70179_y = (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F);
                        this.func_85030_a("random.fizz", 0.4F, 2.0F + this.field_70146_Z.nextFloat() * 0.4F);
                    }

                    if (!this.field_70170_p.field_72995_K) {
                        this.searchForOtherItemsNearby2();
                    }
                }

                float f = 0.98F;
                if (this.field_70122_E) {
                    f = this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v)).field_149765_K * 0.98F;
                }

                this.field_70159_w *= (double)f;
                this.field_70181_x *= (double)0.98F;
                this.field_70179_y *= (double)f;
                if (this.field_70122_E) {
                    this.field_70181_x *= (double)-0.5F;
                }

                ++this.field_70292_b;
                ItemStack item = this.func_70096_w().func_82710_f(10);
                if (!this.field_70170_p.field_72995_K && this.field_70292_b >= this.lifespan && item == null) {
                    this.func_70106_y();
                }

                if (item != null && item.field_77994_a <= 0) {
                    this.func_70106_y();
                }
            }

        }
    }

    private void searchForOtherItemsNearby2() {
        for(EntityItem entityitem : this.field_70170_p.func_72872_a(EntityItem.class, this.field_70121_D.func_72314_b((double)0.5F, (double)0.0F, (double)0.5F))) {
            this.func_70289_a(entityitem);
        }

    }
}
