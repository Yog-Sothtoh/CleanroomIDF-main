//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

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
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.EntityImmortalItem;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class ItemAdamantiumSword extends ItemSword {
    public static Item.ToolMaterial enumToolMaterialAdamantium = EnumHelper.addToolMaterial("Adamantium", Integer.MAX_VALUE, 2, 9999999.0F, 1.0E37F, 0);

    public ItemAdamantiumSword(String unlocalizedName) {
        super(enumToolMaterialAdamantium);
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
        p_77624_3_.add("§3§lThe weapon of the CHOSEN ONE.");
        p_77624_3_.add("§3§lCan destroy anything. (expect deities)");
        p_77624_3_.add("§3§lOnly the CHOSEN ONE (you) is allowed to wield it");
    }

    public boolean func_150894_a(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {
        return true;
    }

    public boolean func_77644_a(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if (target != null && !target.field_70170_p.field_72995_K) {
            ++target.field_70181_x;
            target.field_70172_ad = 0;
            target.func_70606_j(0.0F);
            target.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(attacker), Float.MAX_VALUE);
            target.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
            if (target instanceof EntityTitan && ((EntityTitan)target).canBeHurtByPlayer() && !(target instanceof EntityWitherzilla) && ((EntityTitan)target).getInvulTime() < 1) {
                target.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                ((EntityTitan)target).setTitanHealth(((EntityTitan)target).func_110143_aJ() - 3000.0F);
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
                            entity1.field_70172_ad = 0;
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

    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        if (entityLiving instanceof EntityPlayer) {
            for(int i1 = 0; i1 < 4; ++i1) {
                Vec3 vec3 = ((EntityPlayer)entityLiving).func_70676_i(1.0F);
                double dx = i1 == 0 ? vec3.field_72450_a : vec3.field_72450_a * (double)i1;
                double dy = i1 == 0 ? (double)entityLiving.func_70047_e() + vec3.field_72448_b : (double)entityLiving.func_70047_e() + vec3.field_72448_b * (double)i1;
                double dz = i1 == 0 ? vec3.field_72449_c : vec3.field_72449_c * (double)i1;
                int y = MathHelper.func_76128_c(entityLiving.field_70163_u + dy);
                int x = MathHelper.func_76128_c(entityLiving.field_70165_t + dx);
                int z = MathHelper.func_76128_c(entityLiving.field_70161_v + dz);
                if (!entityLiving.field_70170_p.func_147437_c(x, y, z)) {
                    entityLiving.field_70170_p.func_72889_a((EntityPlayer)null, 1012, x, y, z, 0);
                }

                if (!entityLiving.field_70170_p.field_72995_K && !entityLiving.field_70170_p.func_147437_c(x, y, z)) {
                    stack.func_77972_a(2, entityLiving);
                    Block block = entityLiving.field_70170_p.func_147439_a(x, y, z);
                    if ((!(block instanceof IGrowable) || block instanceof BlockGrass) && block.func_149688_o() != Material.field_151594_q && !(block instanceof BlockOre)) {
                        int l = entityLiving.field_70170_p.func_72805_g(x, y, z);
                        entityLiving.field_70170_p.func_72926_e(2001, x, y, z, Block.func_149682_b(block) + (l << 12));
                        EntityItem entityitem = new EntityItem(entityLiving.field_70170_p, (double)x, (double)y, (double)z, new ItemStack(Item.func_150898_a(block), 1, l));
                        entityLiving.field_70170_p.func_72838_d(entityitem);
                        entityLiving.field_70170_p.func_147468_f(x, y, z);
                    } else {
                        entityLiving.field_70170_p.func_147480_a(x, y, z, true);
                    }
                }
            }
        }

        return false;
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
