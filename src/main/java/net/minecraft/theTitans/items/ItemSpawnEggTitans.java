//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSpawnEggTitans extends Item {
    public int my_id = 0;

    public ItemSpawnEggTitans(String unlocalizedName, int j) {
        this.my_id = j;
        this.field_77777_bU = 64;
        this.func_111206_d("thetitans:" + unlocalizedName);
        this.func_77655_b(unlocalizedName);
        this.func_77637_a(CreativeTabs.field_78026_f);
    }

    public boolean func_77648_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        if (par3World.field_72995_K) {
            return true;
        } else {
            Entity ent = spawn_something(this.my_id, par3World, (double)par4 + (double)0.5F, (double)par5 + 1.01, (double)par6 + (double)0.5F);
            if (ent != null && ent instanceof EntityLiving && par1ItemStack.func_82837_s()) {
                ((EntityLiving)ent).func_94058_c(par1ItemStack.func_82833_r());
            }

            if (!par2EntityPlayer.field_71075_bZ.field_75098_d) {
                --par1ItemStack.field_77994_a;
            }

            return true;
        }
    }

    public static Entity spawn_something(int id, World world, double d0, double d1, double d2) {
        int entityID = 0;
        int skelly_type = 0;
        String name = null;
        switch (id) {
            case 384:
                name = "OverlordScorpion";
                break;
            case 385:
                name = "MethuselahKraken";
        }

        Entity ent = null;
        if (entityID != 0 || name != null) {
            ent = spawnCreature(world, entityID, name, d0, d1, d2);
        }

        return ent;
    }

    public static Entity spawnCreature(World par0World, int par1, String name, double par2, double par4, double par6) {
        Entity var8 = null;
        if (name == null) {
            var8 = EntityList.func_75616_a(par1, par0World);
        } else {
            var8 = EntityList.func_75620_a(name, par0World);
        }

        if (var8 != null) {
            var8.func_70012_b(par2, par4, par6, par0World.field_73012_v.nextFloat() * 360.0F, 0.0F);
            par0World.func_72838_d(var8);
            ((EntityLiving)var8).func_110161_a((IEntityLivingData)null);
            ((EntityLiving)var8).func_70642_aH();
        }

        return var8;
    }
}
