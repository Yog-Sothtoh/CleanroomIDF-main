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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.ClientProxy;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.EntityImmortalItem;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class ItemAdminiumSword extends ItemSword {
    public ItemAdminiumSword(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.func_111206_d("thetitans:adminium_sword");
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
    }

    public EnumAction func_77661_b(ItemStack p_77661_1_) {
        return EnumAction.bow;
    }

    public boolean func_77644_a(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.func_77972_a(1, attacker);
        if (target != null && !target.field_70170_p.field_72995_K) {
            ++target.field_70181_x;
            target.field_70172_ad = 0;
            if (target.field_70131_O >= 6.0F || target instanceof EntityTitan || !target.field_70122_E) {
                try {
                    ReflectionHelper.findField(EntityLivingBase.class, new String[]{"recentlyHit", "field_70718_bc"}).setInt(target, 100);
                } catch (Exception var6) {
                    target.field_70172_ad = 0;
                }

                try {
                    ReflectionHelper.findField(EntityLivingBase.class, new String[]{"hurt_timer"}).setInt(target, 0);
                    target.field_70172_ad = 0;
                } catch (Exception var5) {
                    target.field_70172_ad = 0;
                }

                target.func_70606_j(target.func_110143_aJ() - 5.0E9F);
                target.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(attacker), 5.0E9F);
                target.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                if (target.field_70131_O == 50.0F && target.field_70130_N == 15.0F) {
                    target.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)0.0F);
                    target.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(attacker), 40.0F);
                    target.func_70103_a((byte)3);
                    target.func_70690_d(new PotionEffect(ClientProxy.death.field_76415_H, Integer.MAX_VALUE, 19));
                    ++target.field_70725_aQ;
                }

                if (target instanceof EntityTitan && ((EntityTitan)target).canBeHurtByPlayer() && !(target instanceof EntityWitherzilla) && ((EntityTitan)target).getInvulTime() < 1) {
                    target.field_70170_p.func_72885_a((Entity)null, target.field_70165_t, target.field_70163_u + (double)(target.field_70131_O * 0.5F), target.field_70161_v, 7.0F, false, false);
                    target.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                    ((EntityTitan)target).setTitanHealth(((EntityTitan)target).func_110143_aJ() - 1000.0F);
                }
            }
        }

        return true;
    }

    public void func_77615_a(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_) {
        int j = this.func_77626_a(p_77615_1_) - p_77615_4_;
        ArrowLooseEvent event = new ArrowLooseEvent(p_77615_3_, p_77615_1_, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (!event.isCanceled()) {
            j = event.charge;
            float f = (float)j / 60.0F;
            f = (f * f + f * 2.0F) / 3.0F;
            if (!((double)f < 0.1)) {
                if (f > 1.0F) {
                    f = 1.0F;
                }

                p_77615_3_.func_85030_a("thetitans:titanSwing", 1.0F, 2.0F);
                p_77615_3_.func_71038_i();
                Vec3 vec3 = p_77615_3_.func_70676_i(1.0F);
                double dx = vec3.field_72450_a * (double)4.0F;
                double dy = (double)p_77615_3_.func_70047_e() + vec3.field_72448_b * (double)4.0F;
                double dz = vec3.field_72449_c * (double)4.0F;
                List list1 = p_77615_3_.field_70170_p.func_72839_b(p_77615_3_, p_77615_3_.field_70121_D.func_72314_b((double)4.0F, (double)4.0F, (double)4.0F).func_72317_d(dx, dy, dz));
                if (list1 != null && !list1.isEmpty()) {
                    for(int i11 = 0; i11 < list1.size(); ++i11) {
                        Entity entity1 = (Entity)list1.get(i11);
                        if (entity1 != p_77615_3_ && (entity1 instanceof EntityLivingBase || entity1 instanceof EntityTitanPart || entity1 instanceof EntityTitan)) {
                            ++entity1.field_70181_x;

                            try {
                                ReflectionHelper.findField(EntityLivingBase.class, new String[]{"recentlyHit", "field_70718_bc"}).setInt(entity1, 100);
                            } catch (Exception var19) {
                            }

                            entity1.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(p_77615_3_), 1.0E10F * f);
                            if (entity1 instanceof EntityLivingBase) {
                                ((EntityLivingBase)entity1).func_70606_j(((EntityLivingBase)entity1).func_110143_aJ() - 2000.0F * f);
                            }

                            entity1.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                            if (entity1 instanceof EntityTitan && ((EntityTitan)entity1).canBeHurtByPlayer() && !(entity1 instanceof EntityWitherzilla) && ((EntityTitan)entity1).getInvulTime() < 1) {
                                entity1.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                                ((EntityTitan)entity1).setTitanHealth(((EntityTitan)entity1).func_110143_aJ() - 2000.0F * f);
                            }
                        }
                    }
                }

            }
        }
    }

    public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
        return true;
    }

    public static MovingObjectPosition raytraceFromEntity(World world, Entity player, boolean wut, double range) {
        float f = 1.0F;
        float f1 = player.field_70127_C + (player.field_70125_A - player.field_70127_C) * f;
        float f2 = player.field_70126_B + (player.field_70177_z - player.field_70126_B) * f;
        double d0 = player.field_70169_q + (player.field_70165_t - player.field_70169_q) * (double)f;
        double d1 = player.field_70167_r + (player.field_70163_u - player.field_70167_r) * (double)f;
        if (!world.field_72995_K && player instanceof EntityPlayer) {
            ++d1;
        }

        double d2 = player.field_70166_s + (player.field_70161_v - player.field_70166_s) * (double)f;
        Vec3 vec3 = Vec3.func_72443_a(d0, d1, d2);
        float f3 = MathHelper.func_76134_b(-f2 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = MathHelper.func_76126_a(-f2 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f5 = -MathHelper.func_76134_b(-f1 * ((float)Math.PI / 180F));
        float f6 = MathHelper.func_76126_a(-f1 * ((float)Math.PI / 180F));
        float f7 = f4 * f5;
        float f8 = f3 * f5;
        Vec3 vec31 = vec3.func_72441_c((double)f7 * range, (double)f6 * range, (double)f8 * range);
        return world.func_72901_a(vec3, vec31, wut);
    }

    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        MovingObjectPosition raycast = raytraceFromEntity(entityLiving.field_70170_p, entityLiving, true, (double)6.0F);
        if (!entityLiving.field_70170_p.field_72995_K && raycast != null) {
            Block block = entityLiving.field_70170_p.func_147439_a(raycast.field_72311_b, raycast.field_72312_c, raycast.field_72309_d);
            if ((!(block instanceof IGrowable) || block instanceof BlockGrass) && block.func_149688_o() != Material.field_151594_q && !(block instanceof BlockOre)) {
                int l = entityLiving.field_70170_p.func_72805_g(raycast.field_72311_b, raycast.field_72312_c, raycast.field_72309_d);
                entityLiving.field_70170_p.func_72926_e(2001, raycast.field_72311_b, raycast.field_72312_c, raycast.field_72309_d, Block.func_149682_b(block) + (l << 12));
                EntityItem entityitem = new EntityItem(entityLiving.field_70170_p, (double)raycast.field_72311_b, (double)raycast.field_72312_c, (double)raycast.field_72309_d, new ItemStack(Item.func_150898_a(block), 1, l));
                entityLiving.field_70170_p.func_72838_d(entityitem);
                entityLiving.field_70170_p.func_147468_f(raycast.field_72311_b, raycast.field_72312_c, raycast.field_72309_d);
            } else {
                entityLiving.field_70170_p.func_147480_a(raycast.field_72311_b, raycast.field_72312_c, raycast.field_72309_d, true);
            }
        }

        return false;
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

    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, 0);
    }

    public EnumRarity func_77613_e(ItemStack stack) {
        return TheTitans.godly;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_77636_d(ItemStack stack) {
        return true;
    }
}
