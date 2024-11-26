//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanPart;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class ItemHarcadiumSword extends ItemSword {
    public ItemHarcadiumSword(String unlocalizedName, Item.ToolMaterial material) {
        super(material);
        this.func_111206_d("thetitans:harcadium_sword");
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(TheTitans.titansTab);
    }

    public EnumAction func_77661_b(ItemStack p_77661_1_) {
        return EnumAction.bow;
    }

    public void func_77663_a(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof EntityPlayer) {
            ((EntityPlayer)entityIn).func_71029_a(TitansAchievments.harcadiumSword);
        }

        super.func_77663_a(stack, worldIn, entityIn, itemSlot, isSelected);
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
                        Entity target = (Entity)list1.get(i11);
                        if (target != p_77615_3_ && (target instanceof EntityLivingBase || target instanceof EntityTitanPart)) {
                            target.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(p_77615_3_), 1000.0F * f);
                            target.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                            target.func_85030_a("thetitans:slashFlesh", 2.0F, 1.25F);
                        }
                    }
                }

            }
        }
    }

    public boolean func_77644_a(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.func_77972_a(1, attacker);
        if (target != null) {
            target.func_85030_a("thetitans:slashFlesh", 2.0F, 1.3F + target.func_70681_au().nextFloat() * 0.5F);
            if (target.field_70131_O >= 6.0F || target instanceof EntityTitan || !target.field_70122_E) {
                target.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(attacker), 500.0F);
                target.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
            }
        }

        return true;
    }
}
