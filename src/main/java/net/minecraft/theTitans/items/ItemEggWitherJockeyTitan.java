//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import net.minecraft.block.Block;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntitySkeletonTitan;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

public class ItemEggWitherJockeyTitan extends Item {
    public ItemEggWitherJockeyTitan(String unlocalizedName) {
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
        this.func_111206_d("thetitans:eggwitherjockeytitan");
    }

    public boolean func_77648_a(ItemStack stack, EntityPlayer playerIn, World worldIn, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        EntitySpiderTitan entity = new EntitySpiderTitan(worldIn);
        Block block = worldIn.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
        p_77648_4_ += Facing.field_71586_b[p_77648_7_];
        p_77648_5_ += Facing.field_71587_c[p_77648_7_];
        p_77648_6_ += Facing.field_71585_d[p_77648_7_];
        double d0 = (double)0.0F;
        if (p_77648_7_ == 1 && block.func_149645_b() == 11) {
            d0 = (double)0.5F;
        }

        entity.func_110161_a((IEntityLivingData)null);
        entity.func_70012_b((double)p_77648_4_ + (double)0.5F, (double)p_77648_5_ + d0, (double)p_77648_6_ + (double)0.5F, 0.0F, 0.0F);
        if (!worldIn.field_72995_K) {
            worldIn.func_72838_d(entity);
            EntitySkeletonTitan entityskeleton = new EntitySkeletonTitan(entity.field_70170_p);
            entityskeleton.setSkeletonType(1);
            entityskeleton.func_70062_b(0, new ItemStack(Items.field_151052_q));
            entityskeleton.func_70012_b((double)p_77648_4_ + (double)0.5F, (double)p_77648_5_ + d0, (double)p_77648_6_ + (double)0.5F, 0.0F, 0.0F);
            entity.field_70170_p.func_72838_d(entityskeleton);
            entityskeleton.func_70078_a(entity);
            entityskeleton.func_70642_aH();
        }

        if (entity != null) {
            entity.func_70642_aH();
            if (!playerIn.field_71075_bZ.field_75098_d) {
                --stack.field_77994_a;
            }
        }

        return true;
    }

    public EnumRarity func_77613_e(ItemStack stack) {
        return EnumRarity.rare;
    }
}
