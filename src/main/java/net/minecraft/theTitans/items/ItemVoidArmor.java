//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemVoidArmor extends ItemHarcadiumArmor {
    AttributeModifier modifierHelmet = new AttributeModifier("Helmet modifier", (double)350.0F, 2);
    AttributeModifier modifierChestplate = new AttributeModifier("Chestplate modifier", (double)400.0F, 2);
    AttributeModifier modifierLeggings = new AttributeModifier("Leggings modifier", (double)350.0F, 2);
    AttributeModifier modifierBoots = new AttributeModifier("Boots modifier", (double)200.0F, 2);

    public ItemVoidArmor(String unlocalizedName, ItemArmor.ArmorMaterial material, int type) {
        super(material, 0, type);
        this.func_77655_b(unlocalizedName);
        this.func_111206_d("thetitans:" + unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
        this.modifierHelmet = new AttributeModifier("Helmet modifier", (double)250.0F, 0);
        this.modifierChestplate = new AttributeModifier("Chestplate modifier", (double)400.0F, 0);
        this.modifierLeggings = new AttributeModifier("Leggings modifier", (double)350.0F, 0);
        this.modifierBoots = new AttributeModifier("Boots modifier", (double)200.0F, 0);
    }

    public boolean func_82789_a(ItemStack p_82789_1_, ItemStack p_82789_2_) {
        return TitanItems.voidItem == p_82789_2_.func_77973_b();
    }

    public ItemVoidArmor(ItemArmor.ArmorMaterial material, int i, int type) {
        super(material, 0, type);
    }

    public Multimap func_111205_h() {
        Multimap multimap = HashMultimap.create();
        switch (this.field_77881_a) {
            case 0:
            default:
                multimap.put(SharedMonsterAttributes.field_111267_a.func_111108_a(), this.modifierHelmet);
                break;
            case 1:
                multimap.put(SharedMonsterAttributes.field_111267_a.func_111108_a(), this.modifierChestplate);
                break;
            case 2:
                multimap.put(SharedMonsterAttributes.field_111267_a.func_111108_a(), this.modifierLeggings);
                break;
            case 3:
                multimap.put(SharedMonsterAttributes.field_111267_a.func_111108_a(), this.modifierBoots);
        }

        return multimap;
    }

    public EnumRarity func_77613_e(ItemStack stack) {
        return EnumRarity.rare;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_77636_d(ItemStack stack) {
        return true;
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "thetitans:textures/models/armor/absence_layer_" + (this.field_77881_a == 2 ? "2" : "1") + ".png";
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (itemStack.func_77973_b() == TitanItems.voidHelmet) {
            this.effectPlayer(player, Potion.field_76439_r, 0);
            this.effectPlayer(player, Potion.field_76427_o, 0);
            this.removeEffect(player, Potion.field_76440_q);
            player.func_85030_a("thetitans:harcadiumHum", 5.0F, 0.5F);
        }

        if (itemStack.func_77973_b() == TitanItems.voidChestplate) {
            this.effectPlayer(player, Potion.field_76422_e, 99);
            this.effectPlayer(player, Potion.field_76429_m, 3);
            this.effectPlayer(player, Potion.field_76420_g, 49);
            this.effectPlayer(player, Potion.field_76426_n, 0);
            this.removeEffect(player, Potion.field_76437_t);
            this.removeEffect(player, Potion.field_76419_f);
            player.func_85030_a("thetitans:harcadiumHum", 5.0F, 0.5F);
            if (player.func_70027_ad()) {
                player.func_70066_B();
            }
        }

        if (itemStack.func_77973_b() == TitanItems.voidLeggings) {
            this.effectPlayer(player, Potion.field_76428_l, 199);
            this.removeEffect(player, Potion.field_76431_k);
            this.removeEffect(player, Potion.field_76438_s);
            this.removeEffect(player, Potion.field_76436_u);
            player.func_85030_a("thetitans:harcadiumHum", 5.0F, 0.0F);
        }

        if (itemStack.func_77973_b() == TitanItems.voidBoots) {
            this.effectPlayer(player, Potion.field_76430_j, 5);
            this.effectPlayer(player, Potion.field_76424_c, 19);
            this.removeEffect(player, Potion.field_76421_d);
            player.func_85030_a("thetitans:harcadiumHum", 5.0F, 0.5F);
        }

        if (this.isWearingFullSet(player, TitanItems.voidHelmet, TitanItems.voidChestplate, TitanItems.voidLeggings, TitanItems.voidBoots)) {
            player.field_70143_R *= 0.0F;
            this.effectPlayerLong(player, Potion.field_76444_x, 199);
            this.effectPlayer(player, Potion.field_76443_y, 99);
            player.func_71029_a(TitansAchievments.voidArmor);

            for(int i = 0; i < 4; ++i) {
                player.field_70170_p.func_72869_a("depthsuspend", player.field_70165_t + (player.func_70681_au().nextDouble() - (double)0.5F) * (double)player.field_70130_N * (double)2.0F, player.field_70163_u - (double)1.75F + player.func_70681_au().nextDouble() * (double)player.field_70131_O, player.field_70161_v + (player.func_70681_au().nextDouble() - (double)0.5F) * (double)player.field_70130_N * (double)2.0F, (double)0.0F, 0.05, (double)0.0F);
            }

            List list11 = player.field_70170_p.func_72839_b(player, player.field_70121_D.func_72314_b((double)4.0F, (double)4.0F, (double)4.0F));
            if (list11 != null && !list11.isEmpty()) {
                for(int i1 = 0; i1 < list11.size(); ++i1) {
                    Entity entity = (Entity)list11.get(i1);
                    if (entity != null && entity instanceof EntityLivingBase && !(entity instanceof EntityTitan) && !(entity instanceof EntityGolem) && !(entity instanceof EntityTameable) && !(entity instanceof EntityVillager)) {
                        entity.func_70097_a(DamageSource.field_76380_i, 4.0F);
                        ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 5000, 1));
                        ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76431_k.field_76415_H, 5000, 1));
                        ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 5000, 9));
                        ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 5000, 3));
                    }
                }
            }
        }

    }

    private void removeEffect(EntityPlayer player, Potion potion) {
        if (player.func_70660_b(potion) != null) {
            player.func_82170_o(potion.field_76415_H);
            player.func_85030_a("random.fizz", 0.5F, 2.0F);
        }

    }

    private void effectPlayer(EntityPlayer player, Potion potion, int amplifier) {
        if (player.func_70660_b(potion) == null || player.func_70660_b(potion).func_76459_b() <= 1) {
            player.func_70690_d(new PotionEffect(potion.field_76415_H, 1, amplifier, false));
        }

    }

    private void effectPlayerLong(EntityPlayer player, Potion potion, int amplifier) {
        if (player.func_70660_b(potion) == null || player.func_70660_b(potion).func_76459_b() <= 1) {
            player.func_70690_d(new PotionEffect(potion.field_76415_H, 800, amplifier, false));
        }

    }

    private boolean isWearingFullSet(EntityPlayer player, Item helmet, Item chestplate, Item leggings, Item boots) {
        return player.field_71071_by.func_70440_f(3) != null && player.field_71071_by.func_70440_f(3).func_77973_b() == helmet && player.field_71071_by.func_70440_f(2) != null && player.field_71071_by.func_70440_f(2).func_77973_b() == chestplate && player.field_71071_by.func_70440_f(1) != null && player.field_71071_by.func_70440_f(1).func_77973_b() == leggings && player.field_71071_by.func_70440_f(0) != null && player.field_71071_by.func_70440_f(0).func_77973_b() == boots;
    }
}
