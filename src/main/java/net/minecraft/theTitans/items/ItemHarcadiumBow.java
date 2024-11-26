//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityCaveSpiderTitan;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntitySilverfishTitan;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemHarcadiumBow extends ItemBow {
    public static final String[] bowPullIconNameArray = new String[]{"pulling_0", "pulling_1", "pulling_2"};
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public ItemHarcadiumBow() {
        this.field_77777_bU = 1;
        this.func_77656_e(12000);
        this.func_77637_a(TheTitans.titansTab);
        this.func_77655_b("harcadium_bow");
    }

    public void func_77663_a(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof EntityPlayer) {
            ((EntityPlayer)entityIn).func_71029_a(TitansAchievments.harcadiumBow);
        }

        super.func_77663_a(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    public boolean func_77644_a(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.func_77972_a(1, attacker);
        if (target != null && (target.field_70131_O >= 7.0F || target instanceof EntitySilverfishTitan || target instanceof EntityCaveSpiderTitan)) {
            target.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(attacker), 50.0F);
            target.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
        }

        return true;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        if (usingItem == null) {
            return this.field_77791_bV;
        } else {
            int ticksInUse = stack.func_77988_m() - useRemaining;
            if (ticksInUse > 17) {
                return this.iconArray[2];
            } else if (ticksInUse > 13) {
                return this.iconArray[1];
            } else {
                return ticksInUse > 0 ? this.iconArray[0] : this.field_77791_bV;
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_94581_a(IIconRegister p_94581_1_) {
        this.field_77791_bV = p_94581_1_.func_94245_a("thetitans:harcadium_bow_standby");
        this.iconArray = new IIcon[bowPullIconNameArray.length];

        for(int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = p_94581_1_.func_94245_a("thetitans:harcadium_bow_" + bowPullIconNameArray[i]);
        }

    }

    public void func_77615_a(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft) {
        int j = this.func_77626_a(stack) - timeLeft;
        ArrowLooseEvent event = new ArrowLooseEvent(playerIn, stack, j);
        if (!MinecraftForge.EVENT_BUS.post(event)) {
            j = event.charge;
            boolean flag = playerIn.field_71075_bZ.field_75098_d || EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, stack) > 0;
            if (flag || playerIn.field_71071_by.func_146028_b(TitanItems.harcadiumArrow)) {
                float f = (float)j / 20.0F;
                f = (f * f + f * 2.0F) / 3.0F;
                if ((double)f < 0.1) {
                    return;
                }

                if (f > 1.0F) {
                    f = 1.0F;
                }

                EntityHarcadiumArrow entityarrow = new EntityHarcadiumArrow(worldIn, playerIn, f * 2.0F);
                if (f == 1.0F) {
                    entityarrow.func_70243_d(true);
                }

                int k = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, stack);
                if (k > 0) {
                    entityarrow.func_70239_b(entityarrow.func_70242_d() + (double)k * (double)100.0F);
                }

                int l = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, stack);
                if (l > 0) {
                    entityarrow.func_70240_a(l * 3);
                }

                if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, stack) > 0) {
                    entityarrow.func_70015_d(500);
                }

                stack.func_77972_a(1, playerIn);
                worldIn.func_72956_a(playerIn, "random.bow", 1.0F, 1.0F / (field_77697_d.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                if (flag) {
                    entityarrow.field_70251_a = 2;
                } else {
                    playerIn.field_71071_by.func_146026_a(TitanItems.harcadiumArrow);
                }

                playerIn.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
                if (!worldIn.field_72995_K) {
                    worldIn.func_72838_d(entityarrow);
                    Vec3 vec3 = playerIn.func_70676_i(1.0F);
                    entityarrow.field_70165_t = playerIn.field_70165_t + vec3.field_72450_a;
                    entityarrow.field_70163_u = playerIn.field_70163_u + vec3.field_72448_b + (double)1.0F;
                    entityarrow.field_70161_v = playerIn.field_70161_v + vec3.field_72449_c;
                }
            }

        }
    }

    public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
        return p_77654_1_;
    }

    public int func_77626_a(ItemStack p_77626_1_) {
        return 72000;
    }

    public EnumAction func_77661_b(ItemStack stack) {
        return EnumAction.bow;
    }

    public ItemStack func_77659_a(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        ArrowNockEvent event = new ArrowNockEvent(playerIn, itemStackIn);
        if (MinecraftForge.EVENT_BUS.post(event)) {
            return event.result;
        } else {
            if (playerIn.field_71075_bZ.field_75098_d || playerIn.field_71071_by.func_146028_b(TitanItems.harcadiumArrow)) {
                playerIn.func_71008_a(itemStackIn, this.func_77626_a(itemStackIn));
            }

            return itemStackIn;
        }
    }

    public int func_77619_b() {
        return 30;
    }
}
