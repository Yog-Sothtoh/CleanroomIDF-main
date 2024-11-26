//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFallingBlockTitan extends EntityFallingBlock {
    private Block field_145811_e;
    public int field_145814_a;
    public int field_145812_b;
    public boolean field_145813_c;
    private boolean field_145808_f;
    private boolean field_145809_g;
    private int field_145815_h;
    private float field_145816_i;
    public NBTTagCompound field_145810_d;

    public EntityFallingBlockTitan(World p_i1706_1_) {
        super(p_i1706_1_);
        this.field_145813_c = true;
        this.field_145815_h = 40;
        this.field_145816_i = 2.0F;
    }

    public EntityFallingBlockTitan(World p_i45318_1_, double p_i45318_2_, double p_i45318_4_, double p_i45318_6_, Block p_i45318_8_) {
        this(p_i45318_1_, p_i45318_2_, p_i45318_4_, p_i45318_6_, p_i45318_8_, 0);
    }

    public EntityFallingBlockTitan(World p_i45319_1_, double p_i45319_2_, double p_i45319_4_, double p_i45319_6_, Block p_i45319_8_, int p_i45319_9_) {
        super(p_i45319_1_);
        this.field_145813_c = true;
        this.field_145815_h = 40;
        this.field_145816_i = 2.0F;
        this.field_145811_e = p_i45319_8_;
        this.field_145814_a = p_i45319_9_;
        this.field_70156_m = true;
        this.func_70105_a(0.98F, 0.98F);
        this.field_70129_M = this.field_70131_O / 2.0F;
        this.func_70107_b(p_i45319_2_, p_i45319_4_, p_i45319_6_);
        this.field_70169_q = p_i45319_2_;
        this.field_70167_r = p_i45319_4_;
        this.field_70166_s = p_i45319_6_;
    }

    protected boolean func_70041_e_() {
        return false;
    }

    protected void func_70088_a() {
    }

    public boolean func_70067_L() {
        return false;
    }

    public void func_70071_h_() {
        this.field_145809_g = true;
        this.field_70158_ak = false;
        if (this.field_145811_e.func_149688_o() == Material.field_151579_a) {
            this.field_145811_e = Blocks.field_150354_m;
        } else {
            this.field_70169_q = this.field_70165_t;
            this.field_70167_r = this.field_70163_u;
            this.field_70166_s = this.field_70161_v;
            ++this.field_145812_b;
            this.field_70181_x -= (double)0.04F;
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= (double)0.98F;
            this.field_70181_x *= (double)0.98F;
            this.field_70179_y *= (double)0.98F;
            if (!this.field_70170_p.field_72995_K && this.field_145812_b > 40) {
                int i = MathHelper.func_76128_c(this.field_70165_t);
                int j = MathHelper.func_76128_c(this.field_70163_u);
                int k = MathHelper.func_76128_c(this.field_70161_v);
                if (this.field_70122_E) {
                    this.field_70159_w *= (double)0.7F;
                    this.field_70179_y *= (double)0.7F;
                    this.field_70181_x *= (double)-0.5F;
                    if (this.field_70170_p.func_147439_a(i, j, k) != Blocks.field_150326_M) {
                        this.func_70106_y();
                        if (!this.field_145808_f && this.field_70170_p.func_147472_a(this.field_145811_e, i, j, k, true, 1, (Entity)null, (ItemStack)null) && !BlockFalling.func_149831_e(this.field_70170_p, i, j - 1, k) && this.field_70170_p.func_147465_d(i, j, k, this.field_145811_e, this.field_145814_a, 3)) {
                            Minecraft.func_71410_x().field_71438_f.func_72708_a("largeexplode", (double)i, (double)j, (double)k, (double)0.0F, (double)0.0F, (double)0.0F);
                            Minecraft.func_71410_x().field_71452_i.func_147215_a(i, j, k, this.field_145811_e, Block.func_149682_b(this.field_145811_e) >> 12 & 255);
                            if (this.field_70170_p.func_72890_a(this, (double)16.0F) != null) {
                                this.func_85030_a("thetitans:titanPress", 1.0F, 1.0F + this.field_70146_Z.nextFloat() * 0.25F);
                            }

                            if (this.field_145811_e instanceof BlockFalling) {
                                ((BlockFalling)this.field_145811_e).func_149828_a(this.field_70170_p, i, j, k, this.field_145814_a);
                            }

                            if (this.field_145810_d != null && this.field_145811_e instanceof ITileEntityProvider) {
                                TileEntity tileentity = this.field_70170_p.func_147438_o(i, j, k);
                                if (tileentity != null) {
                                    NBTTagCompound nbttagcompound = new NBTTagCompound();
                                    tileentity.func_145841_b(nbttagcompound);

                                    for(String s : this.field_145810_d.func_150296_c()) {
                                        NBTBase nbtbase = this.field_145810_d.func_74781_a(s);
                                        if (!s.equals("x") && !s.equals("y") && !s.equals("z")) {
                                            nbttagcompound.func_74782_a(s, nbtbase.func_74737_b());
                                        }
                                    }

                                    tileentity.func_145839_a(nbttagcompound);
                                    tileentity.func_70296_d();
                                }
                            }
                        } else if (this.field_145813_c && this.field_145808_f) {
                            this.func_70099_a(new ItemStack(this.field_145811_e, 1, this.field_145811_e.func_149692_a(this.field_145814_a)), 0.0F);
                        }
                    }
                } else if (!this.field_70170_p.field_72995_K && (j < 1 || j > 256) || this.field_145812_b > 1000) {
                    this.func_70099_a(new ItemStack(this.field_145811_e, 1, this.field_145811_e.func_149692_a(this.field_145814_a)), 0.0F);
                    Minecraft.func_71410_x().field_71438_f.func_72708_a("largeexplode", (double)i, (double)j, (double)k, (double)0.0F, (double)0.0F, (double)0.0F);
                    Minecraft.func_71410_x().field_71452_i.func_147215_a(i, j, k, this.field_145811_e, Block.func_149682_b(this.field_145811_e) >> 12 & 255);
                    this.func_70069_a((float)this.field_145812_b);
                    if (this.field_70170_p.func_72890_a(this, (double)16.0F) != null) {
                        this.func_85030_a("thetitans:titanPress", 1.0F, 1.25F + this.field_70146_Z.nextFloat() * 0.25F);
                    }

                    this.func_70106_y();
                }
            }
        }

    }

    protected void func_70069_a(float p_70069_1_) {
        if (this.field_145809_g) {
            int i = MathHelper.func_76123_f(p_70069_1_ - 1.0F);
            if (i > 0) {
                ArrayList arraylist = new ArrayList(this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)1.0F, (double)1.0F, (double)1.0F)));
                boolean flag = this.field_145811_e == Blocks.field_150467_bQ;
                DamageSource damagesource = flag ? DamageSource.field_82728_o : DamageSource.field_82729_p;

                for(Entity entity : arraylist) {
                    entity.field_70172_ad = 0;
                    entity.func_70097_a(damagesource, Math.min((float)MathHelper.func_76141_d((float)i * this.field_145816_i), (float)this.field_145815_h * 10.0F));
                    if (this.field_145811_e == Blocks.field_150480_ab) {
                        entity.func_70015_d(20);
                    }
                }

                if (flag && (double)this.field_70146_Z.nextFloat() < (double)0.05F + (double)i * 0.05) {
                    int j = this.field_145814_a >> 2;
                    int k = this.field_145814_a & 3;
                    ++j;
                    if (j > 2) {
                        this.field_145808_f = true;
                    } else {
                        this.field_145814_a = k | j << 2;
                    }
                }
            }
        }

    }

    protected void func_70014_b(NBTTagCompound p_70014_1_) {
        p_70014_1_.func_74774_a("Tile", (byte)Block.func_149682_b(this.field_145811_e));
        p_70014_1_.func_74768_a("TileID", Block.func_149682_b(this.field_145811_e));
        p_70014_1_.func_74774_a("Data", (byte)this.field_145814_a);
        p_70014_1_.func_74774_a("Time", (byte)this.field_145812_b);
        p_70014_1_.func_74757_a("DropItem", this.field_145813_c);
        p_70014_1_.func_74757_a("HurtEntities", this.field_145809_g);
        p_70014_1_.func_74776_a("FallHurtAmount", this.field_145816_i);
        p_70014_1_.func_74768_a("FallHurtMax", this.field_145815_h);
        if (this.field_145810_d != null) {
            p_70014_1_.func_74782_a("TileEntityData", this.field_145810_d);
        }

    }

    protected void func_70037_a(NBTTagCompound p_70037_1_) {
        if (p_70037_1_.func_150297_b("TileID", 99)) {
            this.field_145811_e = Block.func_149729_e(p_70037_1_.func_74762_e("TileID"));
        } else {
            this.field_145811_e = Block.func_149729_e(p_70037_1_.func_74771_c("Tile") & 255);
        }

        this.field_145814_a = p_70037_1_.func_74771_c("Data") & 255;
        this.field_145812_b = p_70037_1_.func_74771_c("Time") & 255;
        if (p_70037_1_.func_150297_b("HurtEntities", 99)) {
            this.field_145809_g = p_70037_1_.func_74767_n("HurtEntities");
            this.field_145816_i = p_70037_1_.func_74760_g("FallHurtAmount");
            this.field_145815_h = p_70037_1_.func_74762_e("FallHurtMax");
        } else if (this.field_145811_e == Blocks.field_150467_bQ) {
            this.field_145809_g = true;
        }

        if (p_70037_1_.func_150297_b("DropItem", 99)) {
            this.field_145813_c = p_70037_1_.func_74767_n("DropItem");
        }

        if (p_70037_1_.func_150297_b("TileEntityData", 10)) {
            this.field_145810_d = p_70037_1_.func_74775_l("TileEntityData");
        }

        if (this.field_145811_e.func_149688_o() == Material.field_151579_a) {
            this.field_145811_e = Blocks.field_150354_m;
        }

    }

    public void func_145806_a(boolean p_145806_1_) {
        this.field_145809_g = p_145806_1_;
    }

    public void func_85029_a(CrashReportCategory p_85029_1_) {
        super.func_85029_a(p_85029_1_);
        p_85029_1_.func_71507_a("Immitating block ID", Block.func_149682_b(this.field_145811_e));
        p_85029_1_.func_71507_a("Immitating block data", this.field_145814_a);
    }

    @SideOnly(Side.CLIENT)
    public float func_70053_R() {
        return 0.0F;
    }

    @SideOnly(Side.CLIENT)
    public World func_145807_e() {
        return this.field_70170_p;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_90999_ad() {
        return false;
    }

    public Block func_145805_f() {
        return this.field_145811_e;
    }
}
