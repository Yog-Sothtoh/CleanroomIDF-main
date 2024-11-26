//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.World;

public class ItemForTheChallengeGames1 extends Item {
    public ItemForTheChallengeGames1(String unlocalizedName) {
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
        this.func_111206_d("thetitans:witherskeletonspawn");
    }

    public boolean func_77648_a(ItemStack stack, EntityPlayer playerIn, World worldIn, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        playerIn.func_85030_a("thetitans:OMG", 10.0F, 0.25F + playerIn.func_70681_au().nextFloat() * 2.0F);

        for(int i = 0; i <= 9; ++i) {
            new Random();
            EntitySkeleton entity = new EntitySkeleton(worldIn);
            Block block = worldIn.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
            double d0 = (double)1.0F;
            if (p_77648_7_ == 1 && block.func_149645_b() == 11) {
                d0 = (double)1.5F;
            }

            entity.field_70159_w = entity.func_70681_au().nextDouble() * (double)2.0F - (double)1.0F;
            entity.field_70179_y = entity.func_70681_au().nextDouble() * (double)2.0F - (double)1.0F;
            entity.func_110161_a((IEntityLivingData)null);
            entity.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)4.0F);
            entity.func_70012_b((double)p_77648_4_ + (double)0.5F, (double)p_77648_5_ + d0, (double)p_77648_6_ + (double)0.5F, 0.0F, 0.0F);
            entity.func_82201_a(1);
            entity.func_70062_b(0, new ItemStack(Items.field_151052_q));
            entity.field_70714_bg.func_75776_a(4, new EntityAIAttackOnCollide(entity, 1.2, true));
            entity.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(entity, EntityIronGolem.class, 0, true));
            if (!worldIn.field_72995_K) {
                worldIn.func_72838_d(entity);
            }
        }

        if (!playerIn.field_71075_bZ.field_75098_d) {
            --stack.field_77994_a;
        }

        return true;
    }

    public EnumRarity func_77613_e(ItemStack stack) {
        return EnumRarity.rare;
    }
}
