//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityIronGolemTitan;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.World;

public class ItemEggReinforcedIronGolem extends Item {
    public ItemEggReinforcedIronGolem(String unlocalizedName) {
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
        this.func_111206_d("thetitans:eggultimairongolemtitan");
    }

    public boolean func_77648_a(ItemStack stack, EntityPlayer playerIn, World worldIn, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        Block block = worldIn.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
        double d0 = (double)1.0F;
        if (p_77648_7_ == 1 && block.func_149645_b() == 11) {
            d0 = (double)1.5F;
        }

        if (playerIn.func_70093_af()) {
            for(int i = 0; i <= 49; ++i) {
                EntityIronGolem entity = new EntityIronGolem(worldIn);
                entity.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)2000.0F);
                entity.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
                entity.func_70606_j(2000.0F);
                entity.field_70159_w = entity.func_70681_au().nextDouble() * (double)2.0F - (double)1.0F;
                entity.field_70179_y = entity.func_70681_au().nextDouble() * (double)2.0F - (double)1.0F;
                entity.func_94058_c("Reinforced Iron Golem");
                entity.func_110161_a((IEntityLivingData)null);
                entity.func_70012_b((double)p_77648_4_ + (double)0.5F, (double)p_77648_5_ + d0, (double)p_77648_6_ + (double)0.5F, 0.0F, 0.0F);
                EntityIronGolemTitan.addTitanTargetingTaskToEntity(entity);
                if (!worldIn.field_72995_K) {
                    worldIn.func_72838_d(entity);
                }

                if (entity != null && entity instanceof EntityLivingBase && stack.func_82837_s()) {
                    entity.func_94058_c(stack.func_82833_r());
                }
            }
        } else {
            EntityIronGolem entity = new EntityIronGolem(worldIn);
            entity.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)2000.0F);
            entity.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
            entity.func_70606_j(2000.0F);
            entity.func_94058_c("Reinforced Iron Golem");
            entity.func_110161_a((IEntityLivingData)null);
            entity.func_70012_b((double)p_77648_4_ + (double)0.5F, (double)p_77648_5_ + d0, (double)p_77648_6_ + (double)0.5F, 0.0F, 0.0F);
            EntityIronGolemTitan.addTitanTargetingTaskToEntity(entity);
            if (!worldIn.field_72995_K) {
                worldIn.func_72838_d(entity);
            }

            if (entity != null && entity instanceof EntityLivingBase && stack.func_82837_s()) {
                entity.func_94058_c(stack.func_82833_r());
            }
        }

        if (!playerIn.field_71075_bZ.field_75098_d) {
            --stack.field_77994_a;
        }

        return true;
    }
}
