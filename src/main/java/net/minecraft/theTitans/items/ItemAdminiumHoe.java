//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import com.google.common.collect.Multimap;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockOre;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
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
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemAdminiumHoe extends ItemSword {
    private float field_150934_a;
    private final Item.ToolMaterial field_150933_b;

    public ItemAdminiumHoe(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.func_111206_d("thetitans:adminium_hoe");
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
        this.field_150934_a = material.func_78000_c();
        this.field_150933_b = material;
    }

    public float func_150931_i() {
        return this.field_150933_b.func_78000_c() - 4.0F;
    }

    public Multimap func_111205_h() {
        Multimap multimap = super.func_111205_h();
        multimap.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.field_150934_a - (double)4.0F, 0));
        return multimap;
    }

    public boolean func_77644_a(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.func_77972_a(1, attacker);
        if (target != null && (target.field_70131_O >= 6.0F || target instanceof EntityTitan || !target.field_70122_E)) {
            target.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(attacker), 1.0E9F);
            target.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
        }

        return true;
    }

    public EnumAction func_77661_b(ItemStack p_77661_1_) {
        return EnumAction.none;
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
            return false;
        } else {
            UseHoeEvent event = new UseHoeEvent(p_77648_2_, p_77648_1_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_);
            if (MinecraftForge.EVENT_BUS.post(event)) {
                return false;
            } else if (event.getResult() == Result.ALLOW) {
                p_77648_1_.func_77972_a(1, p_77648_2_);
                return true;
            } else {
                Block block = p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
                if (p_77648_7_ != 0 && p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_ + 1, p_77648_6_).isAir(p_77648_3_, p_77648_4_, p_77648_5_ + 1, p_77648_6_) && (block == Blocks.field_150349_c || block == Blocks.field_150346_d || block == Blocks.field_150360_v || block == Blocks.field_150391_bh || block == Blocks.field_150351_n)) {
                    Block block1 = Blocks.field_150458_ak;
                    p_77648_3_.func_72908_a((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), block1.field_149762_H.func_150498_e(), (block.field_149762_H.func_150497_c() + 1.0F) / 2.0F, block.field_149762_H.func_150494_d() * 0.8F);
                    p_77648_3_.func_72908_a((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), block1.field_149762_H.func_150498_e(), (block1.field_149762_H.func_150497_c() + 1.0F) / 2.0F, block1.field_149762_H.func_150494_d() * 0.8F);
                    if (p_77648_3_.field_72995_K) {
                        return true;
                    } else {
                        p_77648_3_.func_147449_b(p_77648_4_, p_77648_5_, p_77648_6_, block1);
                        return true;
                    }
                } else {
                    return false;
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

    public boolean func_150897_b(Block p_150897_1_) {
        return p_150897_1_ == Blocks.field_150458_ak;
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
