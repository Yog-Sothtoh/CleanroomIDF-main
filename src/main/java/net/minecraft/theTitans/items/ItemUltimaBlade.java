//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockOre;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.entity.titan.EntityGammaLightning;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.theTitans.ClientProxy;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.EntityImmortalItem;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.util.EnumHelper;

public class ItemUltimaBlade extends ItemSword {
    public static Item.ToolMaterial enumToolMaterialUltima = EnumHelper.addToolMaterial("Ultima", Integer.MAX_VALUE, 2, 9999999.0F, 999996.0F, 0);

    public ItemUltimaBlade(String unlocalizedName) {
        super(enumToolMaterialUltima);
        this.func_111206_d("thetitans:" + unlocalizedName);
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
    }

    public boolean func_77616_k(ItemStack p_77616_1_) {
        return true;
    }

    public boolean func_150897_b(Block p_150897_1_) {
        return true;
    }

    public boolean func_77645_m() {
        return false;
    }

    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        return new EntityImmortalItem(world, location, itemstack);
    }

    @SideOnly(Side.CLIENT)
    public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
        super.func_77624_a(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
        if (p_77624_1_.func_77960_j() > 0) {
            p_77624_3_.add("§3§lThe ultimate weapon.");
            p_77624_3_.add("§3§lCuts through all defences, even hacks.");
            p_77624_3_.add("§3§lNormally owned by Regnator");
        } else {
            p_77624_3_.add("§l§k§3§lThe ultimate weapon.");
            p_77624_3_.add("§l§k§3§lCuts through all defences, even hacks.");
            p_77624_3_.add("§l§k§3§lNormally owned by Regnator");
        }

    }

    public boolean func_150894_a(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {
        return true;
    }

    private void giveAdvice(EntityPlayer player) {
        List list1 = player.field_70170_p.func_72839_b(player, player.field_70121_D.func_72314_b((double)16.0F, (double)16.0F, (double)16.0F));
        if (list1 != null && !list1.isEmpty()) {
            for(int i1 = 0; i1 < list1.size(); ++i1) {
                Entity entity = (Entity)list1.get(i1);
                if (entity instanceof IMob || entity instanceof EntityPlayer) {
                    if (player.func_70685_l(entity)) {
                        player.func_145747_a(new ChatComponentText("Ultima Blade: §l§oThe " + ((EntityLivingBase)entity).func_70005_c_() + " is " + player.func_70032_d(entity) + "§l§o blocks away from you."));
                    } else {
                        player.func_145747_a(new ChatComponentText("Ultima Blade: §l§oAn unseen mob is located out of your §l§osight " + player.func_70032_d(entity) + " blocks away from you."));
                        player.func_145747_a(new ChatComponentText("Ultima Blade: §l§oThe mob's health: " + ((EntityLivingBase)entity).func_110143_aJ() + "/" + ((EntityLivingBase)entity).func_110138_aP()));
                        player.func_145747_a(new ChatComponentText("Ultima Blade: §l§oThe mob's name: " + ((EntityLivingBase)entity).func_70005_c_()));
                        player.func_85030_a("mob.wither.hurt", 10.0F, (player.func_70681_au().nextFloat() - player.func_70681_au().nextFloat()) * 0.2F + 0.5F);
                    }
                }
            }
        }

    }

    private void offerAdvice(EntityPlayer player) {
        int y = MathHelper.func_76128_c(player.field_70163_u);
        int x = MathHelper.func_76128_c(player.field_70165_t);
        int z = MathHelper.func_76128_c(player.field_70161_v);

        for(int l1 = -8; l1 <= 8; ++l1) {
            for(int i2 = -8; i2 <= 8; ++i2) {
                for(int j = -8; j <= 8; ++j) {
                    int j2 = x + l1;
                    int k = y + j;
                    int l = z + i2;
                    Block block = player.field_70170_p.func_147439_a(j2, k, l);
                    if (block instanceof BlockOre) {
                        player.func_145747_a(new ChatComponentText("Ultima Blade: §l§oI sense a " + block.func_149732_F() + "§l§o within atleast " + player.func_70011_f((double)j2, (double)k, (double)l) + " blocks of you."));
                        player.func_85030_a("mob.wither.hurt", 10.0F, 0.6F);
                    }
                }
            }
        }

    }

    public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
        if (p_77659_3_.field_70170_p.field_72995_K) {
            if (p_77659_3_.func_70093_af()) {
                this.giveAdvice(p_77659_3_);
            } else {
                this.offerAdvice(p_77659_3_);
            }
        }

        if (p_77659_3_.field_71071_by.func_146028_b(TitanItems.optimaAxe)) {
            WorldServer worldserver = MinecraftServer.func_71276_C().field_71305_c[0];
            WorldInfo worldinfo = worldserver.func_72912_H();
            worldinfo.func_76080_g(9999999);
            worldinfo.func_76090_f(1000000);
            worldinfo.func_76084_b(true);
            worldinfo.func_76069_a(true);
            List list = p_77659_3_.field_70170_p.func_72839_b(p_77659_3_, p_77659_3_.field_70121_D.func_72314_b((double)200.0F, (double)100.0F, (double)200.0F));
            if (list != null && !list.isEmpty()) {
                for(int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity != null && entity.func_70089_S() && entity instanceof EntityLivingBase && !(entity instanceof EntityTitan) && entity != p_77659_3_) {
                        ((EntityLivingBase)entity).func_70690_d(new PotionEffect(ClientProxy.electricJudgment.field_76415_H, Integer.MAX_VALUE, 19));
                        entity.func_70024_g((double)(-MathHelper.func_76126_a(p_77659_3_.field_70177_z * (float)Math.PI / 180.0F) * 1.25F), (double)1.0F, (double)(MathHelper.func_76134_b(p_77659_3_.field_70177_z * (float)Math.PI / 180.0F) * 1.25F));
                        entity.func_70097_a(DamageSourceExtra.lightningBolt, 49.0F);
                        p_77659_3_.field_70170_p.func_72942_c(new EntityGammaLightning(p_77659_3_.field_70170_p, entity.field_70165_t, entity.field_70163_u + (double)entity.field_70131_O, entity.field_70161_v, p_77659_3_.func_70681_au().nextFloat(), p_77659_3_.func_70681_au().nextFloat(), p_77659_3_.func_70681_au().nextFloat()));
                        entity.func_70097_a(DamageSource.func_76365_a(p_77659_3_).func_76348_h().func_151518_m(), 49.0F);
                        if (entity instanceof EntityLivingBase && !(entity instanceof EntityTitan) && (entity.field_70131_O >= 6.0F || entity.func_85032_ar())) {
                            ((EntityLivingBase)entity).func_70106_y();
                            ((EntityLivingBase)entity).func_70096_w().func_75692_b(6, MathHelper.func_76131_a(0.0F, 0.0F, ((EntityLivingBase)entity).func_110138_aP()));
                            ((EntityLivingBase)entity).func_70097_a(DamageSource.field_76380_i, Float.MAX_VALUE);
                        }
                    }
                }
            }
        }

        return super.func_77659_a(p_77659_1_, p_77659_2_, p_77659_3_);
    }

    public boolean func_77644_a(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        attacker.field_70170_p.func_82736_K().func_82764_b("keepInventory", "true");
        float extradamage = EnchantmentHelper.func_152377_a(attacker.func_70694_bm(), target.func_70668_bt());
        int knockbackAmount = EnchantmentHelper.func_77507_b(attacker, target);
        if (target != null) {
            target.func_70015_d(Integer.MAX_VALUE);
            target.func_70690_d(new PotionEffect(ClientProxy.electricJudgment.field_76415_H, Integer.MAX_VALUE, 19));
            target.field_70172_ad = 0;
            if (target instanceof EntityTitan && ((EntityTitan)target).canBeHurtByPlayer()) {
                if (attacker instanceof EntityPlayer) {
                    ((EntityTitan)target).func_70097_a(DamageSource.func_76365_a((EntityPlayer)attacker), this.func_150931_i());
                }

                ((EntityTitan)target).setTitanHealth(((EntityTitan)target).func_110143_aJ() - 3000.0F - extradamage);
                ((EntityTitan)target).func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                ((EntityTitan)target).func_70624_b(attacker);
                ((EntityTitan)target).addTitanVelocity((double)(-MathHelper.func_76126_a(attacker.field_70177_z * (float)Math.PI / 180.0F) * 2.0F + (float)knockbackAmount), (double)0.5F + (double)knockbackAmount, (double)(MathHelper.func_76134_b(attacker.field_70177_z * (float)Math.PI / 180.0F) * 2.0F + (float)knockbackAmount));
            } else if (!(target instanceof EntityTitan)) {
                if (target.field_70131_O == 50.0F && target.field_70130_N == 15.0F || EntityTitan.isOreSpawnBossToExempt(target)) {
                    try {
                        ReflectionHelper.findField(target.getClass(), new String[]{"hurt_timer"}).setInt(target, 0);
                    } catch (Exception var8) {
                        target.field_70172_ad = 0;
                    }

                    double originalHealth = target.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b();
                    target.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)0.0F);
                    target.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(attacker).func_76348_h().func_151518_m(), 40.0F);
                    target.func_70690_d(new PotionEffect(ClientProxy.death.field_76415_H, Integer.MAX_VALUE, 19));
                    ++target.field_70725_aQ;
                    target.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(originalHealth);
                }

                target.func_70096_w().func_75692_b(6, MathHelper.func_76131_a(target.func_110143_aJ() - this.func_150931_i() - extradamage, 0.0F, target.func_110138_aP()));
                target.func_85030_a("thetitans:slashFlesh", 10.0F, 1.0F);
                target.field_70159_w = (double)(-MathHelper.func_76126_a(attacker.field_70177_z * (float)Math.PI / 180.0F) * 6.0F + (float)knockbackAmount);
                target.field_70181_x = (double)6.0F + (double)knockbackAmount;
                target.field_70179_y = (double)(MathHelper.func_76134_b(attacker.field_70177_z * (float)Math.PI / 180.0F) * 6.0F + (float)knockbackAmount);
                if (!target.func_70089_S()) {
                    target.func_70645_a(DamageSource.field_76376_m);
                    target.field_70170_p.func_72960_a(target, (byte)3);
                }
            }
        }

        return true;
    }

    public EnumRarity func_77613_e(ItemStack stack) {
        return TheTitans.godly;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_77636_d(ItemStack stack) {
        return true;
    }

    public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
        int sharpness = EnchantmentHelper.func_77506_a(Enchantment.field_77338_j.field_77352_x, stack);
        if (sharpness <= 0) {
            stack.func_77966_a(Enchantment.field_77338_j, 100);
        }

        int smite = EnchantmentHelper.func_77506_a(Enchantment.field_77339_k.field_77352_x, stack);
        if (smite <= 0) {
            stack.func_77966_a(Enchantment.field_77339_k, 100);
        }

        int bug = EnchantmentHelper.func_77506_a(Enchantment.field_77336_l.field_77352_x, stack);
        if (bug <= 0) {
            stack.func_77966_a(Enchantment.field_77336_l, 100);
        }

        int fire = EnchantmentHelper.func_77506_a(Enchantment.field_77334_n.field_77352_x, stack);
        if (fire <= 0) {
            stack.func_77966_a(Enchantment.field_77334_n, 100);
        }

        int titanslaying = EnchantmentHelper.func_77506_a(Enchantment.field_77335_o.field_77352_x, stack);
        if (titanslaying <= 0) {
            stack.func_77966_a(Enchantment.field_77335_o, 100);
        }

    }

    public void func_77663_a(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new NBTTagCompound());
        } else {
            stack.func_77978_p().func_74757_a("Unbreakable", true);
        }

        entityIn.func_70066_B();
        if (entityIn instanceof EntityPlayer && !worldIn.field_72995_K) {
            if (stack.func_77960_j() == 0 && entityIn.field_70173_aa % 2 == 0) {
                ((EntityPlayer)entityIn).func_145747_a(new ChatComponentText("Ultima Blade: You are unworthy of my power."));
                ((EntityPlayer)entityIn).field_71071_by.func_146026_a(TitanItems.ultimaBlade);
                ((EntityPlayer)entityIn).func_145747_a(new ChatComponentText("§7§lYou are unworthy of this weapon."));
            } else {
                ((EntityPlayer)entityIn).func_71029_a(TitansAchievments.ultimaBlade);
                if (((EntityPlayer)entityIn).field_71071_by.func_146028_b(TitanItems.optimaAxe)) {
                    WorldServer worldserver = MinecraftServer.func_71276_C().field_71305_c[0];
                    WorldInfo worldinfo = worldserver.func_72912_H();
                    worldinfo.func_76080_g(9999999);
                    worldinfo.func_76090_f(1000000);
                    worldinfo.func_76084_b(true);
                    worldinfo.func_76069_a(true);
                    if (((EntityPlayer)entityIn).func_70681_au().nextInt(5) == 0) {
                        for(int l = 0; l < 5; ++l) {
                            int i = MathHelper.func_76128_c(((EntityPlayer)entityIn).field_70165_t + (double)(((EntityPlayer)entityIn).func_70681_au().nextInt() * 200 - 100));
                            int j = MathHelper.func_76128_c(((EntityPlayer)entityIn).field_70163_u + (double)(((EntityPlayer)entityIn).func_70681_au().nextInt() * 100 - 50));
                            int k = MathHelper.func_76128_c(((EntityPlayer)entityIn).field_70161_v + (double)(((EntityPlayer)entityIn).func_70681_au().nextInt() * 200 - 100));
                            EntityGammaLightning entitylightning = new EntityGammaLightning(((EntityPlayer)entityIn).field_70170_p, (double)i, (double)j, (double)k, ((EntityPlayer)entityIn).func_70681_au().nextFloat(), ((EntityPlayer)entityIn).func_70681_au().nextFloat(), ((EntityPlayer)entityIn).func_70681_au().nextFloat());
                            if (World.func_147466_a(((EntityPlayer)entityIn).field_70170_p, i, j - 1, k) && ((EntityPlayer)entityIn).field_70170_p.func_72855_b(entitylightning.field_70121_D) && ((EntityPlayer)entityIn).field_70170_p.func_72945_a(entitylightning, entitylightning.field_70121_D).isEmpty() && !((EntityPlayer)entityIn).field_70170_p.func_72953_d(entitylightning.field_70121_D)) {
                                ((EntityPlayer)entityIn).field_70170_p.func_72942_c(entitylightning);
                            }
                        }
                    }

                    List list = ((EntityPlayer)entityIn).field_70170_p.func_72839_b((EntityPlayer)entityIn, ((EntityPlayer)entityIn).field_70121_D.func_72314_b((double)200.0F, (double)100.0F, (double)200.0F));
                    if (list != null && !list.isEmpty()) {
                        for(int i1 = 0; i1 < list.size(); ++i1) {
                            Entity entity = (Entity)list.get(i1);
                            if (entity != null && entity.func_70089_S() && entity instanceof EntityLivingBase && !(entity instanceof EntityTitan) && ((EntityPlayer)entityIn).func_70681_au().nextInt(60) == 0 && entity != entityIn) {
                                entity.func_70024_g((double)(-MathHelper.func_76126_a(entityIn.field_70177_z * (float)Math.PI / 180.0F) * 1.25F), (double)1.0F, (double)(MathHelper.func_76134_b(entityIn.field_70177_z * (float)Math.PI / 180.0F) * 1.25F));
                                entity.func_70097_a(DamageSourceExtra.lightningBolt, 49.0F);
                                ((EntityPlayer)entityIn).field_70170_p.func_72942_c(new EntityGammaLightning(((EntityPlayer)entityIn).field_70170_p, entity.field_70165_t, entity.field_70163_u + (double)entity.field_70131_O, entity.field_70161_v, ((EntityPlayer)entityIn).func_70681_au().nextFloat(), ((EntityPlayer)entityIn).func_70681_au().nextFloat(), ((EntityPlayer)entityIn).func_70681_au().nextFloat()));
                                entity.func_70097_a(DamageSource.func_76365_a((EntityPlayer)entityIn).func_76348_h().func_151518_m(), 49.0F);
                            }
                        }
                    }
                }
            }
        }

        if (entityIn.field_70163_u < (double)-45.0F) {
            entityIn.field_70181_x += (double)10.0F;
        }

        stack.func_151001_c("§lThe Ultima Blade");

        for(int i = 0; i < 3; ++i) {
            entityIn.field_70170_p.func_72869_a("fireworksSpark", ((EntityLivingBase)entityIn).field_70165_t + (((EntityLivingBase)entityIn).func_70681_au().nextDouble() - (double)0.5F) * (double)((EntityLivingBase)entityIn).field_70130_N, ((EntityLivingBase)entityIn).field_70163_u + ((EntityLivingBase)entityIn).func_70681_au().nextDouble() * (double)((EntityLivingBase)entityIn).field_70131_O, ((EntityLivingBase)entityIn).field_70161_v + (((EntityLivingBase)entityIn).func_70681_au().nextDouble() - (double)0.5F) * (double)((EntityLivingBase)entityIn).field_70130_N, (((EntityLivingBase)entityIn).func_70681_au().nextDouble() - (double)0.5F) * (double)2.0F, (double)1.0F, (((EntityLivingBase)entityIn).func_70681_au().nextDouble() - (double)0.5F) * (double)2.0F);
            entityIn.field_70170_p.func_72869_a("explode", ((EntityLivingBase)entityIn).field_70165_t + (((EntityLivingBase)entityIn).func_70681_au().nextDouble() - (double)0.5F) * (double)((EntityLivingBase)entityIn).field_70130_N, ((EntityLivingBase)entityIn).field_70163_u + ((EntityLivingBase)entityIn).func_70681_au().nextDouble() * (double)((EntityLivingBase)entityIn).field_70131_O, ((EntityLivingBase)entityIn).field_70161_v + (((EntityLivingBase)entityIn).func_70681_au().nextDouble() - (double)0.5F) * (double)((EntityLivingBase)entityIn).field_70130_N, (((EntityLivingBase)entityIn).func_70681_au().nextDouble() - (double)0.5F) * (double)2.0F, (double)1.0F, (((EntityLivingBase)entityIn).func_70681_au().nextDouble() - (double)0.5F) * (double)2.0F);
        }

        if (entityIn instanceof EntityPlayer && entityIn != null) {
            if (((EntityPlayer)entityIn).func_70632_aY()) {
                List list1 = entityIn.field_70170_p.func_72839_b(entityIn, entityIn.field_70121_D.func_72314_b((double)16.0F, (double)16.0F, (double)16.0F));
                if (list1 != null && !list1.isEmpty()) {
                    for(int i11 = 0; i11 < list1.size(); ++i11) {
                        Entity entity1 = (Entity)list1.get(i11);
                        if (entity1 != null && entityIn.func_70068_e(entity1) < (double)100.0F && (entity1 instanceof EntityArrow || entity1 instanceof EntityFireball || entity1 instanceof EntityThrowable || entity1 instanceof EntityTNTPrimed)) {
                            entity1.field_70170_p.func_72885_a(entityIn, entity1.field_70165_t, entity1.field_70163_u, entity1.field_70161_v, entity1.field_70130_N, false, false);
                            entity1.func_70106_y();
                        }
                    }
                }
            }

            ((EntityPlayer)entityIn).func_70691_i(((EntityPlayer)entityIn).func_110138_aP());
            if (((EntityPlayer)entityIn).func_70660_b(Potion.field_76444_x) == null || ((EntityPlayer)entityIn).func_70660_b(Potion.field_76444_x).func_76459_b() <= 1) {
                ((EntityPlayer)entityIn).func_70690_d(new PotionEffect(Potion.field_76444_x.field_76415_H, 5, 249, false));
            }
        }

    }

    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        if (!entityLiving.field_70170_p.field_72995_K && entityLiving instanceof EntityPlayer && ((EntityPlayer)entityLiving).func_70093_af()) {
            List list = entityLiving.field_70170_p.func_72839_b(entityLiving, entityLiving.field_70121_D.func_72314_b((double)64.0F, (double)64.0F, (double)64.0F));
            if (list != null && !list.isEmpty()) {
                for(int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity != null && !(entity instanceof EntityTitan)) {
                        entity.func_85030_a("thetitans:titanpunch", 2.0F, 0.5F + entityLiving.func_70681_au().nextFloat() * 0.25F);
                        entity.func_85030_a("random.fizz", 2.0F, 2.0F);
                        entity.func_70097_a(DamageSource.field_76380_i, Float.MAX_VALUE);
                        if (entity instanceof EntityLivingBase) {
                            this.func_77644_a(stack, (EntityLivingBase)entity, entityLiving);
                        }
                    }
                }
            }
        }

        if (!entityLiving.field_70170_p.field_72995_K && entityLiving instanceof EntityPlayer) {
            ((EntityPlayer)entityLiving).func_71008_a(stack, this.func_77626_a(stack));

            for(int i1 = 0; i1 < 24; ++i1) {
                Vec3 vec3 = ((EntityPlayer)entityLiving).func_70676_i(1.0F);
                double dx = vec3.field_72450_a * (double)i1;
                double dy = (double)entityLiving.func_70047_e() + vec3.field_72448_b * (double)i1;
                double dz = vec3.field_72449_c * (double)i1;
                int y = MathHelper.func_76128_c(entityLiving.field_70163_u + dy);
                int x = MathHelper.func_76128_c(entityLiving.field_70165_t + dx);
                int z = MathHelper.func_76128_c(entityLiving.field_70161_v + dz);
                if (!entityLiving.field_70170_p.func_147437_c(x, y, z)) {
                    entityLiving.field_70170_p.func_72889_a((EntityPlayer)null, 1012, x, y, z, 0);
                }

                if (!entityLiving.field_70170_p.field_72995_K && !entityLiving.field_70170_p.func_147437_c(x, y, z)) {
                    Block block = entityLiving.field_70170_p.func_147439_a(x, y, z);
                    if ((!(block instanceof IGrowable) || block instanceof BlockGrass) && block.func_149688_o() != Material.field_151594_q && !(block instanceof BlockOre)) {
                        int l = entityLiving.field_70170_p.func_72805_g(x, y, z);
                        entityLiving.field_70170_p.func_72926_e(2001, x, y, z, Block.func_149682_b(block) + (l << 12));
                        EntityItem entityitem = new EntityItem(entityLiving.field_70170_p, (double)x, (double)y, (double)z, new ItemStack(Item.func_150898_a(block), 1, l));
                        entityLiving.field_70170_p.func_72838_d(entityitem);
                        entityLiving.field_70170_p.func_147468_f(x, y, z);
                        entityitem.func_70024_g((double)(-MathHelper.func_76126_a(entityLiving.field_70177_z * (float)Math.PI / 180.0F) * 1.0F), (double)0.75F, (double)(MathHelper.func_76134_b(entityLiving.field_70177_z * (float)Math.PI / 180.0F) * 1.0F));
                    } else {
                        entityLiving.field_70170_p.func_147480_a(x, y, z, true);
                    }
                }
            }
        }

        entityLiving.func_85030_a("thetitans:titanSwing", 10.0F, 1.0F);

        for(int i1 = 0; i1 < 24; ++i1) {
            Vec3 vec3 = entityLiving.func_70676_i(1.0F);
            double dx = vec3.field_72450_a * (double)i1;
            double dy = (double)entityLiving.func_70047_e() + vec3.field_72448_b * (double)i1;
            double dz = vec3.field_72449_c * (double)i1;
            List list1 = entityLiving.field_70170_p.func_72839_b(entityLiving, entityLiving.field_70121_D.func_72314_b((double)3.0F, (double)3.0F, (double)3.0F).func_72317_d(dx, dy, dz));
            if (list1 != null && !list1.isEmpty()) {
                for(int i11 = 0; i11 < list1.size(); ++i11) {
                    Entity entity1 = (Entity)list1.get(i11);
                    if (entity1 instanceof EntityTNTPrimed && !entity1.func_85032_ar()) {
                        entity1.field_70170_p.func_72885_a(entityLiving, entity1.field_70165_t, entity1.field_70163_u, entity1.field_70161_v, 4.0F, false, false);
                        entity1.func_70106_y();
                    }

                    if (entity1 instanceof EntityFireball && !entity1.func_85032_ar()) {
                        entity1.field_70170_p.func_72885_a(entityLiving, entity1.field_70165_t, entity1.field_70163_u, entity1.field_70161_v, 0.0F, false, false);
                        entity1.func_70106_y();
                    }

                    if (entity1 instanceof EntityLivingBase && entity1.func_70089_S() && entity1 != entityLiving) {
                        entity1.func_70015_d(Integer.MAX_VALUE);
                        entityLiving.field_70170_p.func_82736_K().func_82764_b("keepInventory", "true");
                        float extradamage = EnchantmentHelper.func_152377_a(entityLiving.func_70694_bm(), ((EntityLivingBase)entity1).func_70668_bt());
                        EnchantmentHelper.func_77507_b(entityLiving, (EntityLivingBase)entity1);
                        if (entity1 != null) {
                            entity1.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(entityLiving), 20000.0F + extradamage);
                            entity1.field_70172_ad = 0;
                            this.func_77644_a(stack, (EntityLivingBase)entity1, entityLiving);
                            if (entity1 instanceof EntityTitan) {
                                ((EntityTitan)entity1).func_70624_b(entityLiving);
                                if (!((EntityTitan)entity1).canBeHurtByPlayer() && entityLiving instanceof EntityPlayer) {
                                    ((EntityPlayer)entityLiving).func_145747_a(new ChatComponentText(((EntityTitan)entity1).func_70005_c_() + ": Quit flailing that giant sword at me."));
                                }

                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}
