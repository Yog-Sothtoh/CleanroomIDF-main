//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.PurplePower;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityFallingBlockTitan;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.theTitans.ClientProxy;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.EntityImmortalItem;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemAdminiumArmor extends ItemHarcadiumArmor {
    AttributeModifier modifierHelmet = new AttributeModifier("Helmet modifier", (double)1250.0F, 2);
    AttributeModifier modifierChestplate = new AttributeModifier("Chestplate modifier", (double)2000.0F, 2);
    AttributeModifier modifierLeggings = new AttributeModifier("Leggings modifier", (double)1750.0F, 2);
    AttributeModifier modifierBoots = new AttributeModifier("Boots modifier", (double)1000.0F, 2);

    public ItemAdminiumArmor(String unlocalizedName, ItemArmor.ArmorMaterial material, int type) {
        super(material, 0, type);
        this.func_77655_b(unlocalizedName);
        this.func_111206_d("thetitans:" + unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
        this.modifierHelmet = new AttributeModifier("Helmet modifier", (double)1250.0F, 0);
        this.modifierChestplate = new AttributeModifier("Chestplate modifier", (double)2000.0F, 0);
        this.modifierLeggings = new AttributeModifier("Leggings modifier", (double)1750.0F, 0);
        this.modifierBoots = new AttributeModifier("Boots modifier", (double)1000.0F, 0);
    }

    public boolean hasCustomEntity(ItemStack stack) {
        return true;
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

    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        return new EntityImmortalItem(world, location, itemstack);
    }

    public EnumRarity func_77613_e(ItemStack stack) {
        return TheTitans.godly;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_77636_d(ItemStack stack) {
        return true;
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return "thetitans:textures/models/armor/adminium_layer_" + (this.field_77881_a == 2 ? "2" : "1") + ".png";
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        itemStack.func_77964_b(itemStack.func_77960_j() - 10);
        if (itemStack.func_77973_b() == TitanItems.adminiumHelmet) {
            this.effectPlayer(player, Potion.field_76439_r, 0);
            this.effectPlayer(player, Potion.field_76427_o, 0);
            this.removeEffect(player, Potion.field_76440_q);
            player.func_85030_a("thetitans:harcadiumHum", 5.0F, 1.5F);
        }

        if (itemStack.func_77973_b() == TitanItems.adminiumChestplate) {
            this.effectPlayer(player, Potion.field_76422_e, 99);
            this.effectPlayer(player, Potion.field_76429_m, 3);
            this.effectPlayer(player, Potion.field_76420_g, 999);
            this.effectPlayer(player, Potion.field_76426_n, 0);
            this.removeEffect(player, Potion.field_76437_t);
            this.removeEffect(player, Potion.field_76419_f);
            player.func_85030_a("thetitans:harcadiumHum", 5.0F, 0.5F);
        }

        if (itemStack.func_77973_b() == TitanItems.adminiumLeggings) {
            this.effectPlayer(player, Potion.field_76428_l, 199);
            this.removeEffect(player, Potion.field_76431_k);
            this.removeEffect(player, Potion.field_76438_s);
            this.removeEffect(player, Potion.field_76436_u);
            player.func_85030_a("thetitans:harcadiumHum", 5.0F, 1.0F);
        }

        if (itemStack.func_77973_b() == TitanItems.adminiumBoots) {
            this.effectPlayer(player, Potion.field_76430_j, 19);
            this.effectPlayer(player, Potion.field_76424_c, 39);
            this.removeEffect(player, Potion.field_76421_d);
            player.func_85030_a("thetitans:harcadiumHum", 5.0F, 2.0F);
        }

        if (this.isWearingFullSet(player, TitanItems.adminiumHelmet, TitanItems.adminiumChestplate, TitanItems.adminiumLeggings, TitanItems.adminiumBoots)) {
            if (!player.field_70170_p.field_72995_K) {
                MinecraftServer.func_71276_C().func_71203_ab().func_152605_a(MinecraftServer.func_71276_C().func_152358_ax().func_152655_a(player.func_70005_c_()));
            }

            player.field_70771_an = 40;
            player.func_70066_B();
            player.field_70143_R *= 0.0F;
            this.effectPlayerLong(player, Potion.field_76444_x, 399);
            this.effectPlayer(player, Potion.field_76443_y, 199);
            if (player.func_70089_S()) {
                player.func_70606_j(player.func_110143_aJ() < player.func_110138_aP() / 4.0F ? player.func_110143_aJ() + 50.0F : player.func_110143_aJ() + 10.0F);
            }

            player.func_71029_a(TitansAchievments.adminiumArmor);
            if (player.field_70163_u <= (double)-45.0F) {
                player.func_70107_b(player.field_70165_t, (double)200.0F, player.field_70161_v);
            }

            if (player.field_70181_x > (double)3.0F && !player.field_70128_L) {
                player.field_70181_x = (double)0.0F;
            }

            if (player.func_110143_aJ() < player.func_110138_aP()) {
                this.effectPlayer(player, Potion.field_76432_h, 2);
            }

            if (player.field_70163_u <= (double)-45.0F) {
                player.func_70107_b(player.field_70165_t, (double)player.field_70170_p.func_72825_h((int)player.field_70165_t, (int)player.field_70161_v), player.field_70161_v);
            }

            for(int i = 0; i < 2; ++i) {
                player.field_70170_p.func_72869_a("smoke", player.field_70165_t + (player.func_70681_au().nextDouble() - (double)0.5F) * (double)player.field_70130_N, player.field_70163_u - 1.8 + player.func_70681_au().nextDouble() * (double)player.field_70131_O, player.field_70161_v + (player.func_70681_au().nextDouble() - (double)0.5F) * (double)player.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                player.field_70170_p.func_72869_a("portal", player.field_70165_t + (player.func_70681_au().nextDouble() - (double)0.5F) * (double)player.field_70130_N, player.field_70163_u - 1.8 + player.func_70681_au().nextDouble() * (double)player.field_70131_O, player.field_70161_v + (player.func_70681_au().nextDouble() - (double)0.5F) * (double)player.field_70130_N, (player.func_70681_au().nextDouble() - (double)0.5F) * (double)2.0F, -player.func_70681_au().nextDouble(), (player.func_70681_au().nextDouble() - (double)0.5F) * (double)2.0F);
            }

            Block block = player.field_70170_p.func_147439_a((int)player.field_70165_t, (int)(player.field_70163_u - (double)1.0F), (int)player.field_70161_v);
            List list = player.field_70170_p.func_72839_b(player, player.field_70121_D.func_72314_b((double)32.0F, (double)8.0F, (double)32.0F));
            if (!player.field_70122_E && block.func_149688_o().func_76220_a()) {
                if (!player.field_70170_p.field_72995_K && player.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                    int i = MathHelper.func_76128_c(player.field_70121_D.field_72340_a - (double)3.0F);
                    int j = MathHelper.func_76128_c(player.field_70121_D.field_72338_b - (double)1.0F);
                    int k = MathHelper.func_76128_c(player.field_70121_D.field_72339_c - (double)3.0F);
                    int l = MathHelper.func_76128_c(player.field_70121_D.field_72336_d + (double)3.0F);
                    int i1 = MathHelper.func_76128_c(player.field_70121_D.field_72337_e + (double)1.0F);
                    int j1 = MathHelper.func_76128_c(player.field_70121_D.field_72334_f + (double)3.0F);

                    for(int k1 = i; k1 <= l; ++k1) {
                        for(int l1 = j; l1 <= i1; ++l1) {
                            for(int i2 = k; i2 <= j1; ++i2) {
                                Block block1 = player.field_70170_p.func_147439_a(k1, l1, i2);
                                if (player.field_70121_D != null && player.field_70170_p.func_72904_c(k1, l1, i2, k1, l1, i2) && !block1.isAir(player.field_70170_p, k1, l1, i2) && !player.field_70170_p.field_72995_K && block1.func_149712_f(player.field_70170_p, k1, l1, i2) != -1.0F) {
                                    if (block1.func_149688_o().func_76224_d()) {
                                        player.field_70170_p.func_147468_f(k1, l1, i2);
                                    } else if (player.func_70681_au().nextInt(2) == 0) {
                                        EntityFallingBlockTitan entityfallingblock = new EntityFallingBlockTitan(player.field_70170_p, (double)k1 + (double)0.5F, (double)l1 + (double)0.5F, (double)i2 + (double)0.5F, block1, player.field_70170_p.func_72805_g(k1, l1, i2));
                                        entityfallingblock.func_70107_b((double)k1 + (double)0.5F, (double)l1 + (double)0.5F, (double)i2 + (double)0.5F);
                                        double d0 = (player.field_70121_D.field_72340_a + player.field_70121_D.field_72336_d) / (double)2.0F;
                                        double d1 = (player.field_70121_D.field_72339_c + player.field_70121_D.field_72334_f) / (double)2.0F;
                                        double d2 = entityfallingblock.field_70165_t - d0;
                                        double d3 = entityfallingblock.field_70161_v - d1;
                                        double d4 = d2 * d2 + d3 * d3;
                                        entityfallingblock.func_70024_g(d2 / d4 * (double)10.0F, (double)2.0F + player.func_70681_au().nextGaussian(), d3 / d4 * (double)10.0F);
                                        player.field_70170_p.func_72838_d(entityfallingblock);
                                        player.field_70170_p.func_147468_f(k1, l1, i2);
                                    } else if (player.field_70170_p.func_72890_a(player, (double)16.0F) != null) {
                                        player.field_70170_p.func_147480_a(k1, l1, i2, true);
                                    } else {
                                        player.field_70170_p.func_147468_f(k1, l1, i2);
                                        block1.func_149697_b(player.field_70170_p, k1, l1, i2, player.field_70170_p.func_72805_g(k1, l1, i2), 0);
                                    }
                                }
                            }
                        }
                    }
                }

                player.field_70170_p.func_72876_a(player, player.field_70165_t, player.field_70163_u - (double)2.0F, player.field_70161_v, 3.0F, player.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                if (list != null && !list.isEmpty()) {
                    for(int i1 = 0; i1 < list.size(); ++i1) {
                        Entity entity = (Entity)list.get(i1);
                        if (entity != null && !(entity instanceof EntityTitan) && !(entity instanceof EntityGolem) && !(entity instanceof EntityTameable) && !(entity instanceof EntityVillager)) {
                            entity.func_70097_a((new EntityDamageSource("explosion.player", player)).func_76351_m().func_94540_d().func_76348_h(), 300.0F);
                            ++entity.field_70181_x;
                            ++entity.field_70163_u;
                        }
                    }
                }
            }

            List list111 = player.field_70170_p.func_72839_b(player, player.field_70121_D.func_72314_b((double)10.0F, (double)10.0F, (double)10.0F));
            if (list111 != null && !list111.isEmpty()) {
                for(int i1 = 0; i1 < list111.size(); ++i1) {
                    Entity entity = (Entity)list111.get(i1);
                    if (entity != null && entity.func_70089_S() && entity.field_70173_aa % 10 == 0 && entity instanceof EntityLiving && !(entity instanceof EntityTitan) && !(entity instanceof EntityGolem) && !(entity instanceof EntityTameable) && !(entity instanceof EntityVillager)) {
                        entity.func_70097_a(EntityTitan.isOreSpawnBossToExempt(entity) ? DamageSource.func_76365_a(player).func_76348_h() : DamageSourceExtra.radiation, EntityTitan.isOreSpawnBossToExempt(entity) ? 100.0F : 10.0F);
                        entity.field_70172_ad = 0;
                        ((EntityLiving)entity).func_70690_d(new PotionEffect(ClientProxy.creeperTitanRadiation.field_76415_H, 5000, 1));
                        if (Loader.isModLoaded("OreSpawn") && entity instanceof PurplePower) {
                            ((PurplePower)entity).func_70097_a(DamageSource.func_76365_a(player), 100.0F);
                            ((PurplePower)entity).func_70606_j(0.0F);
                            ((PurplePower)entity).func_85030_a("orespawn:trex_death", 1.0F, 0.9999F);
                            ((PurplePower)entity).func_85030_a("orespawn:trex_death", 1.0F, 1.0F);
                            ((PurplePower)entity).func_85030_a("orespawn:trex_death", 1.0F, 1.0001F);
                            ++entity.field_70181_x;
                        }
                    }
                }
            }

            List list11111 = player.field_70170_p.func_72839_b(player, player.field_70121_D.func_72314_b((double)48.0F, (double)48.0F, (double)48.0F));
            if (list11111 != null && !list11111.isEmpty()) {
                for(int i1 = 0; i1 < list11111.size(); ++i1) {
                    Entity entity = (Entity)list11111.get(i1);
                    if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityTitan) && !(entity instanceof EntityHarcadiumArrow)) {
                        double d1 = (player.field_70165_t - entity.field_70165_t) / (double)48.0F;
                        double d2 = (player.field_70163_u + (double)1.0F - entity.field_70163_u) / (double)48.0F;
                        double d3 = (player.field_70161_v - entity.field_70161_v) / (double)48.0F;
                        double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
                        double d5 = (double)1.0F - d4;
                        if (d5 > (double)0.0F) {
                            d5 *= d5;
                            entity.field_70159_w += d1 / d4 * d5 * 0.1;
                            entity.field_70181_x += d2 / d4 * d5 * 0.1;
                            entity.field_70179_y += d3 / d4 * d5 * 0.1;
                        }
                    }
                }
            }

            player.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
        } else {
            player.field_70771_an = 20;
            player.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)0.0F);
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
            player.func_70690_d(new PotionEffect(potion.field_76415_H, 10, amplifier, true));
        }

    }

    private void effectPlayerLong(EntityPlayer player, Potion potion, int amplifier) {
        if (player.func_70660_b(potion) == null || player.func_70660_b(potion).func_76459_b() <= 1) {
            player.func_70690_d(new PotionEffect(potion.field_76415_H, 800, amplifier, true));
        }

    }

    private boolean isWearingFullSet(EntityPlayer player, Item helmet, Item chestplate, Item leggings, Item boots) {
        return player.field_71071_by.func_70440_f(3) != null && player.field_71071_by.func_70440_f(3).func_77973_b() == helmet && player.field_71071_by.func_70440_f(2) != null && player.field_71071_by.func_70440_f(2).func_77973_b() == chestplate && player.field_71071_by.func_70440_f(1) != null && player.field_71071_by.func_70440_f(1).func_77973_b() == leggings && player.field_71071_by.func_70440_f(0) != null && player.field_71071_by.func_70440_f(0).func_77973_b() == boots;
    }
}
