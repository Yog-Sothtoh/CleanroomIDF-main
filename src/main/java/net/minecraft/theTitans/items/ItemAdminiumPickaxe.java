//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.EntityImmortalItem;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemAdminiumPickaxe extends ItemPickaxe {
    public ItemAdminiumPickaxe(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.func_111206_d("thetitans:adminium_pickaxe");
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
    }

    public boolean func_77644_a(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.func_77972_a(1, attacker);
        if (target != null && (target.field_70131_O >= 6.0F || target instanceof EntityTitan || !target.field_70122_E)) {
            target.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(attacker), 3.0E9F);
            target.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
        }

        return true;
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
