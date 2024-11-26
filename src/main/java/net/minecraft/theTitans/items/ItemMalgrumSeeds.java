//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemMalgrumSeeds extends Item implements IPlantable {
    public ItemMalgrumSeeds() {
        this.func_77655_b("malgrum_seeds");
        this.func_111206_d("thetitans:malgrum_seeds");
        this.func_77637_a(TheTitans.titansTab);
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (p_77648_7_ != 1) {
            return false;
        } else if (p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) && p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, p_77648_1_)) {
            if (p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_).canSustainPlant(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, ForgeDirection.UP, this) && p_77648_3_.func_147437_c(p_77648_4_, p_77648_5_ + 1, p_77648_6_)) {
                p_77648_3_.func_72980_b((double)p_77648_4_, (double)p_77648_5_, (double)p_77648_6_, "thetitans:titanPress", 0.5F, 1.0F, false);
                p_77648_3_.func_147465_d(p_77648_4_, p_77648_5_ + 1, p_77648_6_, TitanBlocks.malgrumCrop, 0, 3);
                --p_77648_1_.field_77994_a;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
        return EnumPlantType.Crop;
    }

    public Block getPlant(IBlockAccess world, int x, int y, int z) {
        return TitanBlocks.malgrumCrop;
    }

    public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
        return 0;
    }
}
