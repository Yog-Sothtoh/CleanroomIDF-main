//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class BlockVoidOre extends BlockOre {
    public static final Block.SoundType soundTypeVoid = new Block.SoundType("stone", 10.0F, 0.5F);
    private Random rand = new Random();

    public BlockVoidOre(Material materialIn, String name) {
        this.setHarvestLevel("pickaxe", 1000);
        this.func_149711_c(800.0F);
        this.func_149752_b(6000000.0F);
        this.func_149647_a(TheTitans.titansTab);
        this.func_149663_c(name);
        this.func_149658_d("thetitans:" + name);
        this.func_149672_a(soundTypeVoid);
    }

    public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
        float f = 0.01F;
        return AxisAlignedBB.func_72330_a((double)((float)p_149668_2_ + f), (double)p_149668_3_, (double)((float)p_149668_4_ + f), (double)((float)(p_149668_2_ + 1) - f), (double)((float)(p_149668_3_ + 1) - f), (double)((float)(p_149668_4_ + 1) - f));
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB func_149633_g(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
        float f = 0.01F;
        return AxisAlignedBB.func_72330_a((double)((float)p_149633_2_ + f), (double)p_149633_3_, (double)((float)p_149633_4_ + f), (double)((float)(p_149633_2_ + 1) - f), (double)(p_149633_3_ + 1), (double)((float)(p_149633_4_ + 1) - f));
    }

    public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return TitanItems.voidItem;
    }

    public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) {
        return MathHelper.func_76136_a(this.rand, 12000, 12000);
    }

    public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
        p_149670_5_.func_70097_a(DamageSource.field_76380_i, 4.0F);
        p_149670_5_.field_70159_w *= 0.2;
        p_149670_5_.field_70179_y *= 0.2;
        if (p_149670_5_ instanceof EntityPlayer) {
            ((EntityPlayer)p_149670_5_).func_71020_j(0.2F);
        }

        if (p_149670_5_ instanceof EntityLivingBase && ((EntityLivingBase)p_149670_5_).func_70681_au().nextInt(10) == 0) {
            ((EntityLivingBase)p_149670_5_).func_70015_d(40);
        }

        if (p_149670_5_ instanceof EntityLivingBase && ((EntityLivingBase)p_149670_5_).func_70681_au().nextInt(60) == 0) {
            ((EntityLivingBase)p_149670_5_).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 160, 1));
        }

    }

    public void func_149636_a(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
        p_149636_2_.func_71064_a(StatList.field_75934_C[func_149682_b(this)], 1);
        p_149636_2_.func_71020_j(10.0F);
        if (this.canSilkHarvest(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_) && EnchantmentHelper.func_77502_d(p_149636_2_)) {
            ArrayList<ItemStack> items = new ArrayList();
            ItemStack itemstack = this.func_149644_j(p_149636_6_);
            if (itemstack != null) {
                items.add(itemstack);
            }

            ForgeEventFactory.fireBlockHarvesting(items, p_149636_1_, this, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_, 0, 1.0F, true, p_149636_2_);

            for(ItemStack is : items) {
                this.func_149642_a(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, is);
            }
        } else {
            this.harvesters.set(p_149636_2_);
            int i1 = EnchantmentHelper.func_77517_e(p_149636_2_);
            this.func_149697_b(p_149636_1_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_, i1);
            this.harvesters.set((Object)null);
            p_149636_2_.field_70170_p.func_72885_a((Entity)null, p_149636_2_.field_70165_t, p_149636_2_.field_70163_u, p_149636_2_.field_70161_v, 1.0F, false, p_149636_2_.field_70170_p.func_82736_K().func_82766_b("doTileDrops"));
        }

    }

    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
        return false;
    }

    public int func_149738_a(World p_149738_1_) {
        return 30;
    }

    public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
        this.func_149734_b(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
    }

    @SideOnly(Side.CLIENT)
    public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
        this.func_150186_m(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_);
        if (p_149734_5_.nextInt(20) == 0) {
            p_149734_1_.func_72980_b((double)((float)p_149734_2_ + 0.5F), (double)((float)p_149734_3_ + 0.5F), (double)((float)p_149734_4_ + 0.5F), "thetitans:harcadiumBlockHum", 1.0F, 0.75F, false);
        }

    }

    private void func_150186_m(World p_150186_1_, int p_150186_2_, int p_150186_3_, int p_150186_4_) {
        Random random = p_150186_1_.field_73012_v;
        double d0 = (double)0.0625F;

        for(int l = 0; l < 6; ++l) {
            double d1 = (double)((float)p_150186_2_ + random.nextFloat());
            double d2 = (double)((float)p_150186_3_ + random.nextFloat());
            double d3 = (double)((float)p_150186_4_ + random.nextFloat());
            if (l == 0 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_ + 1, p_150186_4_).func_149662_c()) {
                d2 = (double)(p_150186_3_ + 1) + d0;
            }

            if (l == 1 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_ - 1, p_150186_4_).func_149662_c()) {
                d2 = (double)(p_150186_3_ + 0) - d0;
            }

            if (l == 2 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_, p_150186_4_ + 1).func_149662_c()) {
                d3 = (double)(p_150186_4_ + 1) + d0;
            }

            if (l == 3 && !p_150186_1_.func_147439_a(p_150186_2_, p_150186_3_, p_150186_4_ - 1).func_149662_c()) {
                d3 = (double)(p_150186_4_ + 0) - d0;
            }

            if (l == 4 && !p_150186_1_.func_147439_a(p_150186_2_ + 1, p_150186_3_, p_150186_4_).func_149662_c()) {
                d1 = (double)(p_150186_2_ + 1) + d0;
            }

            if (l == 5 && !p_150186_1_.func_147439_a(p_150186_2_ - 1, p_150186_3_, p_150186_4_).func_149662_c()) {
                d1 = (double)(p_150186_2_ + 0) - d0;
            }

            if (d1 < (double)p_150186_2_ || d1 > (double)(p_150186_2_ + 1) || d2 < (double)0.0F || d2 > (double)(p_150186_3_ + 1) || d3 < (double)p_150186_4_ || d3 > (double)(p_150186_4_ + 1)) {
                p_150186_1_.func_72869_a("smoke", d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
                p_150186_1_.func_72869_a("largesmoke", d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
                p_150186_1_.func_72869_a("depthsuspend", d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
                p_150186_1_.func_72869_a("depthsuspend", d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
                p_150186_1_.func_72869_a("depthsuspend", d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
                p_150186_1_.func_72869_a("depthsuspend", d1, d2, d3, (double)0.0F, (double)0.0F, (double)0.0F);
            }
        }

    }
}
