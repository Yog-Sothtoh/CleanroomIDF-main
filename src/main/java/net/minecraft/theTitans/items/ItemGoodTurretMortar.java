//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityWitherTurretMortar;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.world.World;

public class ItemGoodTurretMortar extends ItemSword {
    public ItemGoodTurretMortar(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
        this.func_111206_d("thetitans:mortar_good");
    }

    public boolean func_77616_k(ItemStack p_77616_1_) {
        return true;
    }

    public boolean func_77645_m() {
        return false;
    }

    public boolean func_150894_a(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {
        return true;
    }

    public boolean func_77648_a(ItemStack stack, EntityPlayer playerIn, World worldIn, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        EntityWitherTurretMortar entity = new EntityWitherTurretMortar(worldIn);
        worldIn.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
        double d0 = (double)1.0F;
        int a = EnchantmentHelper.func_77506_a(TheTitans.turretEnchant1.field_77352_x, stack);
        int b = EnchantmentHelper.func_77506_a(TheTitans.turretEnchant2.field_77352_x, stack);
        int c = EnchantmentHelper.func_77506_a(TheTitans.turretEnchant3.field_77352_x, stack);
        int d = EnchantmentHelper.func_77506_a(TheTitans.turretEnchant4.field_77352_x, stack);
        int e = EnchantmentHelper.func_77506_a(TheTitans.turretEnchant5.field_77352_x, stack);
        int f = EnchantmentHelper.func_77506_a(Enchantment.field_77347_r.field_77352_x, stack);
        entity.setPlayerCreated(true);
        entity.func_110161_a((IEntityLivingData)null);
        entity.field_70170_p.func_82739_e(1013, p_77648_4_, p_77648_5_, p_77648_6_, 0);
        Random rand = new Random();
        if (a > 0) {
            entity.durabilityLevel = a;
        }

        if (b > 0) {
            entity.ferocityLevel = b;
        }

        if (c > 0) {
            entity.maniacLevel = c;
        }

        if (d > 0) {
            entity.unstabilityLevel = d;
        }

        if (e > 0) {
            entity.shurakinLevel = e;
        }

        if (f > 0) {
            entity.unbreakingLevel = f;
        }

        entity.func_70012_b((double)p_77648_4_ + (double)0.5F, (double)p_77648_5_ + d0, (double)p_77648_6_ + (double)0.5F, 0.0F, 0.0F);

        for(int i = 0; i < 500; ++i) {
            entity.field_70170_p.func_72869_a("largesmoke", entity.field_70165_t + (rand.nextDouble() - (double)0.5F) * (double)entity.field_70130_N * (double)3.0F, entity.field_70163_u + rand.nextDouble() * ((double)entity.field_70131_O + (double)1.0F), entity.field_70161_v + (rand.nextDouble() - (double)0.5F) * (double)entity.field_70130_N * (double)3.0F, (double)0.0F, (double)0.0F, (double)0.0F);
        }

        if (!worldIn.field_72995_K) {
            worldIn.func_72838_d(entity);
        }

        if (entity != null && !playerIn.field_71075_bZ.field_75098_d) {
            --stack.field_77994_a;
        }

        return true;
    }

    public EnumRarity func_77613_e(ItemStack stack) {
        return EnumRarity.rare;
    }

    public boolean func_77644_a(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if (target instanceof EntityWitherTurretMortar) {
            if (((EntityWitherTurretMortar)target).isPlayerCreated()) {
                ItemStack itemstack = ((EntityPlayer)attacker).func_71045_bC();
                if (attacker != null && itemstack != null && itemstack.func_77973_b() == TitanItems.goodTurret3 && !((EntityWitherTurretMortar)target).field_70170_p.field_72995_K) {
                    ((EntityWitherTurretMortar)target).func_70106_y();
                    ItemStack goodTurret = new ItemStack(TitanItems.goodTurret3);
                    if (((EntityWitherTurretMortar)target).durabilityLevel > 0) {
                        goodTurret.func_77966_a(TheTitans.turretEnchant1, ((EntityWitherTurretMortar)target).durabilityLevel);
                    }

                    if (((EntityWitherTurretMortar)target).ferocityLevel > 0) {
                        goodTurret.func_77966_a(TheTitans.turretEnchant2, ((EntityWitherTurretMortar)target).ferocityLevel);
                    }

                    if (((EntityWitherTurretMortar)target).maniacLevel > 0) {
                        goodTurret.func_77966_a(TheTitans.turretEnchant3, ((EntityWitherTurretMortar)target).maniacLevel);
                    }

                    if (((EntityWitherTurretMortar)target).unstabilityLevel > 0) {
                        goodTurret.func_77966_a(TheTitans.turretEnchant4, ((EntityWitherTurretMortar)target).unstabilityLevel);
                    }

                    if (((EntityWitherTurretMortar)target).shurakinLevel > 0) {
                        goodTurret.func_77966_a(TheTitans.turretEnchant5, ((EntityWitherTurretMortar)target).shurakinLevel);
                    }

                    if (((EntityWitherTurretMortar)target).unbreakingLevel > 0) {
                        goodTurret.func_77966_a(Enchantment.field_77347_r, ((EntityWitherTurretMortar)target).unbreakingLevel);
                    }

                    if (!((EntityPlayer)attacker).field_71075_bZ.field_75098_d) {
                        ((EntityWitherTurretMortar)target).func_70099_a(goodTurret, 1.0F);
                    }
                }
            }

            return false;
        } else {
            return true;
        }
    }
}
