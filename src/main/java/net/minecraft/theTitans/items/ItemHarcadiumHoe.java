//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import com.google.common.collect.Multimap;
import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemHarcadiumHoe extends ItemSword {
    private float field_150934_a;
    private final Item.ToolMaterial field_150933_b;

    public ItemHarcadiumHoe(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.func_111206_d("thetitans:harcadium_hoe");
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
            target.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(attacker), 300.0F);
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
                        p_77648_1_.func_77972_a(1, p_77648_2_);
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
    }

    public boolean func_150897_b(Block p_150897_1_) {
        return p_150897_1_ == Blocks.field_150458_ak;
    }
}
