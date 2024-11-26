//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.ai.EntityAIDefendVillage;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.theTitans.TitanBlocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.village.Village;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGargoyle extends EntityGolem {
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private int attackTimer;
    private int field_175479_bo;
    private EntityLivingBase field_175478_bn;
    private int homeCheckTimer;
    Village villageObj;

    public EntityGargoyle(World p_i1694_1_) {
        super(p_i1694_1_);
        this.func_70062_b(0, new ItemStack(Blocks.field_150348_b));
        this.func_70105_a(0.75F, 2.5F);
        this.func_70661_as().func_75491_a(true);
        this.field_70714_bg.func_75776_a(1, new AIPerch());
        this.field_70714_bg.func_75776_a(2, new AIBeamAttack());
        this.field_70714_bg.func_75776_a(3, new EntityAIAttackOnCollide(this, (double)1.0F, true));
        this.field_70714_bg.func_75776_a(6, new EntityAIWander(this, (double)0.75F));
        this.field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.field_70714_bg.func_75776_a(8, new EntityAILookIdle(this));
        this.field_70715_bh.func_75776_a(0, new EntityAIDefendVillage(this));
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        this.field_70715_bh.func_75776_a(2, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, IMob.field_82192_a));
    }

    protected void func_70629_bd() {
        if (--this.homeCheckTimer <= 0) {
            this.homeCheckTimer = 70 + this.field_70146_Z.nextInt(50);
            this.villageObj = this.field_70170_p.field_72982_D.func_75550_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v), 32);
            if (this.villageObj == null) {
                this.func_110177_bN();
            } else {
                ChunkCoordinates chunkcoordinates = this.villageObj.func_75577_a();
                this.func_110171_b(chunkcoordinates.field_71574_a, chunkcoordinates.field_71572_b, chunkcoordinates.field_71573_c, (int)((float)this.villageObj.func_75568_b() * 0.6F));
            }
        }

        super.func_70629_bd();
    }

    public void func_70645_a(DamageSource p_70645_1_) {
        if (!this.isPlayerCreated() && this.field_70717_bb != null && this.villageObj != null) {
            this.villageObj.func_82688_a(this.field_70717_bb.func_70005_c_(), -5);
        }

        super.func_70645_a(p_70645_1_);
    }

    public Village getVillage() {
        return this.villageObj;
    }

    public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
        return this.field_70170_p.func_147439_a(p_70783_1_, p_70783_2_ - 1, p_70783_3_) != Blocks.field_150344_f && this.field_70170_p.func_147439_a(p_70783_1_, p_70783_2_ - 1, p_70783_3_) != Blocks.field_150347_e ? this.field_70170_p.func_72801_o(p_70783_1_, p_70783_2_, p_70783_3_) - 0.5F : 10.0F;
    }

    public float func_175477_p(float p_175477_1_) {
        return ((float)this.field_175479_bo + p_175477_1_) / 80.0F;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(13, new Byte((byte)0));
        this.field_70180_af.func_75682_a(16, (byte)0);
        this.field_70180_af.func_75682_a(17, 0);
        this.func_70096_w().func_75682_a(21, (byte)0);
    }

    public int getGargoyleType() {
        return this.field_70180_af.func_75683_a(13);
    }

    public void setGargoyleType(int p_82201_1_) {
        this.field_70180_af.func_75692_b(13, (byte)p_82201_1_);
        switch (p_82201_1_) {
            case 0:
            default:
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)50.0F);
                this.func_70606_j(50.0F);
            case 1:
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)30.0F);
                this.func_70606_j(30.0F);
            case 2:
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)200.0F);
                this.func_70606_j(200.0F);
            case 3:
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)80.0F);
                this.func_70606_j(80.0F);
            case 4:
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)100.0F);
                this.func_70606_j(100.0F);
            case 5:
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)120.0F);
                this.func_70606_j(120.0F);
            case 6:
                this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)60.0F);
                this.func_70606_j(60.0F);
        }
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        this.setPlayerCreated(tagCompund.func_74767_n("PlayerCreated"));
        if (tagCompund.func_150297_b("GargoyleType", 99)) {
            this.setGargoyleType(tagCompund.func_74771_c("GargoyleType"));
        }

    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        tagCompound.func_74757_a("PlayerCreated", this.isPlayerCreated());
        tagCompound.func_74774_a("GargoyleType", (byte)this.getGargoyleType());
    }

    public void setAggressive(boolean p_82197_1_) {
        this.func_70096_w().func_75692_b(21, (byte)(p_82197_1_ ? 1 : 0));
    }

    public boolean getAggressive() {
        return this.func_70096_w().func_75683_a(21) == 1;
    }

    protected float func_70672_c(DamageSource p_70672_1_, float p_70672_2_) {
        p_70672_2_ = super.func_70672_c(p_70672_1_, p_70672_2_);
        if (p_70672_1_.func_76346_g() == this) {
            p_70672_2_ = 0.0F;
        }

        if (p_70672_1_.func_94541_c()) {
            p_70672_2_ = (float)((double)p_70672_2_ * (double)2.0F);
        }

        if (p_70672_1_.func_76347_k()) {
            p_70672_2_ = 0.0F;
        }

        return p_70672_2_;
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != EntityGargoyle.class && p_70686_1_ != EntityGargoyleTitan.class ? (this.isPlayerCreated() && EntityPlayer.class.isAssignableFrom(p_70686_1_) ? false : super.func_70686_a(p_70686_1_)) : false;
    }

    public boolean isPlayerCreated() {
        return (this.field_70180_af.func_75683_a(16) & 1) != 0;
    }

    public void setPlayerCreated(boolean p_70849_1_) {
        byte b0 = this.field_70180_af.func_75683_a(16);
        if (p_70849_1_) {
            this.field_70180_af.func_75692_b(16, (byte)(b0 | 1));
        } else {
            this.field_70180_af.func_75692_b(16, (byte)(b0 & -2));
        }

    }

    public boolean func_70650_aV() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a((double)32.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.25F);
    }

    protected int func_70682_h(int p_70682_1_) {
        return p_70682_1_;
    }

    protected void func_82167_n(Entity p_82167_1_) {
        if (p_82167_1_ instanceof IMob && this.func_70681_au().nextInt(20) == 0) {
            this.func_70624_b((EntityLivingBase)p_82167_1_);
        }

        if (p_82167_1_ instanceof EntityGargoyle && this.func_70638_az() == null && ((EntityGargoyle)p_82167_1_).func_70638_az() == null && this.field_70122_E && ((EntityGargoyle)p_82167_1_).field_70122_E && this.func_70092_e(((EntityGargoyle)p_82167_1_).waypointX, ((EntityGargoyle)p_82167_1_).waypointY, ((EntityGargoyle)p_82167_1_).waypointZ) < (double)4.0F) {
            ++this.waypointY;
            this.field_70145_X = false;
        }

        super.func_82167_n(p_82167_1_);
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.getGargoyleType() == 6) {
            this.field_70170_p.func_72869_a("flame", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
            this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
        }

        if (this.attackTimer > 0) {
            --this.attackTimer;
        }

        if (this.getVillage() != null && !this.field_70170_p.field_72995_K && this.func_70638_az() == null && this.func_70092_e((double)this.getVillage().func_75577_a().field_71574_a, (double)this.getVillage().func_75577_a().field_71572_b, (double)this.getVillage().func_75577_a().field_71573_c) > (double)1024.0F) {
            double d0 = (double)this.getVillage().func_75577_a().field_71574_a - this.field_70165_t;
            double d1 = (double)this.getVillage().func_75577_a().field_71573_c - this.field_70161_v;
            double d3 = d0 * d0 + d1 * d1;
            if (this.field_70163_u <= (double)this.getVillage().func_75577_a().field_71572_b + (double)1.0F) {
                this.field_70181_x += 0.6 - this.field_70181_x;
            }

            double d5 = (double)MathHelper.func_76133_a(d3);
            this.field_70159_w += d0 / d5 * 0.6 - this.field_70159_w;
            this.field_70179_y += d1 / d5 * 0.6 - this.field_70179_y;
        }

        if (this.getVillage() != null && !this.field_70170_p.field_72995_K && this.func_70638_az() == null) {
            List list = this.field_70170_p.func_72872_a(Entity.class, AxisAlignedBB.func_72330_a((double)(this.getVillage().func_75577_a().field_71574_a - this.getVillage().func_75568_b()), (double)(this.getVillage().func_75577_a().field_71572_b - 4), (double)(this.getVillage().func_75577_a().field_71573_c - this.getVillage().func_75568_b()), (double)(this.getVillage().func_75577_a().field_71574_a + this.getVillage().func_75568_b()), (double)(this.getVillage().func_75577_a().field_71572_b + 4), (double)(this.getVillage().func_75577_a().field_71573_c + this.getVillage().func_75568_b())));
            if (list != null && !list.isEmpty() && this.field_70146_Z.nextInt(2) == 0) {
                for(int i = 0; i < list.size(); ++i) {
                    Entity entity = (Entity)list.get(i);
                    if (this.func_70089_S() && entity.func_70089_S() && this.func_70686_a(entity.getClass()) && entity instanceof EntityLivingBase && entity instanceof IMob) {
                        this.func_70624_b((EntityLivingBase)entity);
                    }
                }
            }
        }

        if (!this.field_70170_p.field_72995_K && this.func_70638_az() == null) {
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)16.0F, (double)32.0F, (double)16.0F));
            if (list != null && !list.isEmpty() && this.field_70146_Z.nextInt(20) == 0) {
                for(int i = 0; i < list.size(); ++i) {
                    Entity entity = (Entity)list.get(i);
                    if (this.func_70089_S() && entity.func_70089_S() && this.func_70686_a(entity.getClass()) && entity instanceof EntityLivingBase && entity instanceof IMob) {
                        this.func_70624_b((EntityLivingBase)entity);
                    }
                }
            }
        }

        if (this.func_70638_az() != null && !this.func_70638_az().func_70089_S()) {
            this.func_70624_b((EntityLivingBase)null);
        }

        if (this.func_70638_az() == null && this.getNatureBlock(this.field_70170_p.func_147439_a((int)this.waypointX, (int)this.waypointY, (int)this.waypointZ)) && this.getNatureBlock(this.field_70170_p.func_147439_a((int)this.waypointX, (int)this.waypointY, (int)this.waypointZ)) && this.field_70170_p.func_72937_j((int)this.waypointX, (int)this.waypointY + 1, (int)this.waypointZ)) {
            double d0 = this.waypointX - this.field_70165_t;
            double d1 = this.waypointY + (double)1.0F - this.field_70163_u;
            double d2 = this.waypointZ - this.field_70161_v;
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
            if (d3 == (double)4.0F) {
                this.field_70761_aq = this.field_70177_z = this.field_70759_as += 180.0F;
            }

            if (d3 > (double)3.0F) {
                double d5 = (double)MathHelper.func_76133_a(d3);
                this.field_70159_w += d0 / d5 * 0.6 - this.field_70159_w;
                this.field_70181_x += d1 / d5 * 0.6 - this.field_70181_x;
                this.field_70179_y += d2 / d5 * 0.6 - this.field_70179_y;
                this.func_70671_ap().func_75650_a(this.waypointX, this.waypointY, this.waypointZ, 180.0F, 0.0F);
                this.field_70761_aq = this.field_70177_z = this.field_70759_as;
                this.field_70145_X = true;
            } else {
                this.func_70012_b(this.waypointX + (double)0.5F, this.waypointY + (double)1.0F, this.waypointZ + (double)0.5F, this.field_70759_as, 40.0F);
                this.field_70761_aq = this.field_70177_z = this.field_70759_as;
                this.field_70145_X = false;
                this.func_70066_B();
                if (this.field_70173_aa % (this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u - 1, (int)this.field_70161_v) == this.getFavoriteBlockToPerch() ? 20 : 40) == 0) {
                    this.func_70691_i(this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u - 1, (int)this.field_70161_v) == this.getFavoriteBlockToPerch() ? 2.0F : 1.0F);
                }
            }
        }

        Entity entity = this.func_70638_az();
        double move = entity != null ? 0.2 + this.field_70146_Z.nextDouble() * 0.6 : 0.6;
        if (entity != null) {
            this.setAggressive(true);
        } else {
            this.setAggressive(false);
        }

        if (!this.field_70122_E && this.field_70181_x < (double)0.0F) {
            this.field_70181_x *= move;
        }

        if (!this.field_70170_p.field_72995_K && entity != null) {
            double d0 = entity.field_70165_t - this.field_70165_t;
            double d1 = entity.field_70161_v - this.field_70161_v;
            double d3 = d0 * d0 + d1 * d1;
            if (d3 > (this.getGargoyleType() == 3 ? (double)256.0F : (double)4.0F) && (this.func_70685_l(entity) || this.func_70094_T() || this.field_70163_u <= (double)0.0F)) {
                if (this.field_70163_u <= entity.field_70163_u + (double)1.0F) {
                    this.field_70181_x += move - this.field_70181_x;
                }

                double d5 = (double)MathHelper.func_76133_a(d3);
                this.field_70159_w += d0 / d5 * move - this.field_70159_w;
                this.field_70179_y += d1 / d5 * move - this.field_70179_y;
                this.func_70625_a(entity, 180.0F, 40.0F);
                this.field_70761_aq = this.field_70177_z = this.field_70759_as;
            }
        }

        if (this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > (double)2.5000003E-7F && this.field_70146_Z.nextInt(5) == 0) {
            int i = MathHelper.func_76128_c(this.field_70165_t);
            int j = MathHelper.func_76128_c(this.field_70163_u - (double)0.2F - (double)this.field_70129_M);
            int k = MathHelper.func_76128_c(this.field_70161_v);
            Block block = this.field_70170_p.func_147439_a(i, j, k);
            if (block.func_149688_o() != Material.field_151579_a) {
                this.field_70170_p.func_72869_a("blockcrack_" + Block.func_149682_b(block) + "_" + this.field_70170_p.func_72805_g(i, j, k), this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, this.field_70121_D.field_72338_b + 0.1, this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)this.field_70130_N, (double)4.0F * ((double)this.field_70146_Z.nextFloat() - (double)0.5F), (double)0.5F, ((double)this.field_70146_Z.nextFloat() - (double)0.5F) * (double)4.0F);
            }
        }

        if (this.getNatureBlock(this.field_70170_p.func_147439_a((int)this.waypointX, (int)this.waypointY + 1, (int)this.waypointZ))) {
            ++this.waypointY;
        }

        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 10 == 0 && !this.getNatureBlock(this.field_70170_p.func_147439_a((int)this.waypointX, (int)this.waypointY, (int)this.waypointZ)) && (this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) != this.getFavoriteBlockToPerch() || this.field_70170_p.func_147439_a((int)this.waypointX, (int)this.waypointY, (int)this.waypointZ) != this.getFavoriteBlockToPerch() || this.field_70170_p.func_147439_a((int)this.waypointX, (int)this.waypointY + 1, (int)this.waypointZ).func_149688_o() != Material.field_151579_a || this.field_70170_p.func_147439_a((int)this.waypointX, (int)this.waypointY + 2, (int)this.waypointZ).func_149688_o() != Material.field_151579_a || !this.field_70170_p.func_72937_j((int)this.waypointX, (int)this.waypointY + 1, (int)this.waypointZ))) {
            int i = MathHelper.func_76128_c(this.field_70163_u);
            int i1 = MathHelper.func_76128_c(this.field_70165_t);
            int j1 = MathHelper.func_76128_c(this.field_70161_v);
            boolean flag = false;

            for(int l1 = -6; l1 <= 6; ++l1) {
                for(int i2 = -6; i2 <= 6; ++i2) {
                    for(int j = -6; j <= 6; ++j) {
                        int j2 = i1 + l1;
                        int k = i + j;
                        int l = j1 + i2;
                        Block blockmain = this.field_70170_p.func_147439_a(j2, k, l);
                        Block block1 = this.field_70170_p.func_147439_a(j2, k + 1, l);
                        Block block2 = this.field_70170_p.func_147439_a(j2, k + 2, l);
                        if (!this.field_70170_p.field_72995_K && this.getNatureBlock(blockmain) && (blockmain == this.getFavoriteBlockToPerch() && this.field_70146_Z.nextInt(20) == 0 || this.field_70146_Z.nextInt(300) == 0) && this.field_70170_p.func_72937_j(j2, k + 1, l) && block1.func_149688_o() == Material.field_151579_a && block2.func_149688_o() == Material.field_151579_a) {
                            this.waypointX = (double)j2;
                            this.waypointY = (double)k;
                            this.waypointZ = (double)l;
                        }
                    }
                }
            }
        }

    }

    public boolean getNatureBlock(Block block) {
        return (block.func_149662_c() || block == this.getFavoriteBlockToPerch()) && block != Blocks.field_150348_b && block != Blocks.field_150357_h && block != Blocks.field_150364_r && block != Blocks.field_150363_s && block != Blocks.field_150354_m && block != Blocks.field_150346_d && block != Blocks.field_150351_n && block != Blocks.field_150349_c && block != Blocks.field_150391_bh && block != Blocks.field_150424_aL && block != Blocks.field_150425_aM;
    }

    public boolean getUNNatureBlock(Block block) {
        return (!block.func_149662_c() || block != this.getFavoriteBlockToPerch()) && (block == Blocks.field_150348_b || block == Blocks.field_150357_h || block == Blocks.field_150364_r || block == Blocks.field_150363_s || block == Blocks.field_150354_m || block == Blocks.field_150346_d || block == Blocks.field_150351_n || block == Blocks.field_150349_c || block == Blocks.field_150391_bh || block == Blocks.field_150424_aL || block == Blocks.field_150425_aM);
    }

    public Block getFavoriteBlockToPerch() {
        switch (this.getGargoyleType()) {
            case 0:
            default:
                return TitanBlocks.stoneperch;
            case 1:
                return TitanBlocks.sandstoneperch;
            case 2:
                return TitanBlocks.obsidianperch;
            case 3:
                return TitanBlocks.goldperch;
            case 4:
                return TitanBlocks.ironperch;
            case 5:
                return TitanBlocks.endstoneperch;
            case 6:
                return TitanBlocks.netherbrickperch;
        }
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (this.func_85032_ar()) {
            return false;
        } else if (source != DamageSource.field_76368_d && source != DamageSource.field_76369_e && source != DamageSource.field_76370_b && source != DamageSource.field_76372_a) {
            return source.func_76346_g() == null || !(source.func_76346_g() instanceof EntityGargoyle) && !(source.func_76346_g() instanceof EntityGargoyleTitan) ? super.func_70097_a(source, amount) : false;
        } else {
            return false;
        }
    }

    public boolean func_70652_k(Entity p_70652_1_) {
        this.attackTimer = 10;
        this.field_70170_p.func_72960_a(this, (byte)4);
        boolean flag = p_70652_1_.func_70097_a(DamageSource.func_76358_a(this), this.getGargoyleType() == 6 ? 14.0F : (this.getGargoyleType() == 5 ? 26.0F : (this.getGargoyleType() == 4 ? 14.0F : (this.getGargoyleType() == 3 ? 20.0F : (this.getGargoyleType() == 2 ? 18.0F : (this.getGargoyleType() == 1 ? 4.0F : 8.0F))))));
        this.func_71038_i();
        if (flag) {
            switch (this.getGargoyleType()) {
                case 0:
                default:
                    p_70652_1_.field_70181_x += 0.3;
                    break;
                case 1:
                    p_70652_1_.field_70181_x += 0.15;
                    break;
                case 2:
                    p_70652_1_.field_70181_x += (double)0.5F;
                    break;
                case 3:
                    p_70652_1_.field_70181_x += 0.6;
                    this.func_85030_a("mob.zombie.remedy", 1.0F + this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat() * 0.7F + 0.3F);
                    break;
                case 4:
                    p_70652_1_.field_70181_x += 0.4;
                    break;
                case 5:
                    p_70652_1_.field_70181_x += (double)0.5F;
                    break;
                case 6:
                    p_70652_1_.field_70181_x += 0.3;
                    p_70652_1_.func_70015_d(10);
            }
        }

        this.func_85030_a("mob.irongolem.throw", 1.0F, 1.0F);
        return flag && this.field_70724_aR <= 0;
    }

    @SideOnly(Side.CLIENT)
    public void func_70103_a(byte p_70103_1_) {
        if (p_70103_1_ == 4) {
            this.attackTimer = 10;
            this.func_85030_a("mob.irongolem.throw", 1.0F, 1.0F);
        } else {
            super.func_70103_a(p_70103_1_);
        }

    }

    protected String func_70639_aQ() {
        return this.getNatureBlock(this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b - (double)0.5F), MathHelper.func_76128_c(this.field_70161_v))) ? null : "thetitans:gargoyleLiving";
    }

    protected String func_70621_aR() {
        return "thetitans:gargoyleGrunt";
    }

    protected String func_70673_aS() {
        return "thetitans:gargoyleDeath";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
        this.func_85030_a("mob.irongolem.walk", 1.0F, 1.0F);
    }

    private void func_175463_b(int p_175463_1_) {
        this.field_70180_af.func_75692_b(17, p_175463_1_);
    }

    public boolean func_175474_cn() {
        return this.field_70180_af.func_75679_c(17) != 0;
    }

    public EntityLivingBase getTargetedEntity() {
        if (!this.func_175474_cn()) {
            return null;
        } else if (this.field_70170_p.field_72995_K) {
            if (this.field_175478_bn != null) {
                return this.field_175478_bn;
            } else {
                Entity entity = this.field_70170_p.func_73045_a(this.field_70180_af.func_75679_c(17));
                if (entity instanceof EntityLivingBase) {
                    this.field_175478_bn = (EntityLivingBase)entity;
                    return this.field_175478_bn;
                } else {
                    return null;
                }
            }
        } else {
            return this.func_70638_az();
        }
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        int j = this.field_70146_Z.nextInt(5);
        switch (this.getGargoyleType()) {
            case 0:
            default:
                for(int k = 0; k < j; ++k) {
                    this.func_145778_a(Item.func_150898_a(Blocks.field_150348_b), 1, 0.0F);
                }
                break;
            case 1:
                for(int k = 0; k < j; ++k) {
                    this.func_145778_a(Item.func_150898_a(Blocks.field_150322_A), 1, 0.0F);
                }
                break;
            case 2:
                for(int k = 0; k < j; ++k) {
                    this.func_145778_a(Item.func_150898_a(Blocks.field_150343_Z), 1, 0.0F);
                }
                break;
            case 3:
                for(int k = 0; k < j; ++k) {
                    this.func_145778_a(Item.func_150898_a(Blocks.field_150340_R), 1, 0.0F);
                }
                break;
            case 4:
                for(int k = 0; k < j; ++k) {
                    this.func_145778_a(Item.func_150898_a(Blocks.field_150339_S), 1, 0.0F);
                }
                break;
            case 5:
                for(int k = 0; k < j; ++k) {
                    this.func_145778_a(Item.func_150898_a(Blocks.field_150377_bs), 1, 0.0F);
                }
                break;
            case 6:
                for(int k = 0; k < j; ++k) {
                    this.func_145778_a(Item.func_150898_a(Blocks.field_150385_bj), 1, 0.0F);
                }
        }

    }

    class AIBeamAttack extends EntityAIBase {
        private EntityGargoyle field_179456_a = EntityGargoyle.this;
        private int field_179455_b;

        public AIBeamAttack() {
            this.func_75248_a(3);
        }

        public boolean func_75250_a() {
            EntityLivingBase entitylivingbase = this.field_179456_a.func_70638_az();
            return entitylivingbase != null && entitylivingbase.func_70089_S() && this.field_179456_a.getGargoyleType() == 3;
        }

        public boolean func_75253_b() {
            return super.func_75253_b() && this.field_179456_a.func_70638_az() != null && this.field_179456_a.getGargoyleType() == 3;
        }

        public void func_75249_e() {
            this.field_179455_b = -10;
            this.field_179456_a.func_70661_as().func_75499_g();
            this.field_179456_a.func_70671_ap().func_75651_a(this.field_179456_a.func_70638_az(), 90.0F, 90.0F);
            this.field_179456_a.field_70160_al = true;
        }

        public void func_75251_c() {
            this.field_179456_a.func_70624_b((EntityLivingBase)null);
        }

        public void func_75246_d() {
            EntityLivingBase entitylivingbase = this.field_179456_a.func_70638_az();
            this.field_179456_a.func_70661_as().func_75499_g();
            this.field_179456_a.func_70671_ap().func_75651_a(entitylivingbase, 90.0F, 90.0F);
            if (!this.field_179456_a.func_70685_l(entitylivingbase)) {
                this.field_179456_a.func_70624_b((EntityLivingBase)null);
            } else {
                ++this.field_179455_b;
                this.field_179456_a.field_70761_aq = this.field_179456_a.field_70177_z = this.field_179456_a.field_70759_as;
                if (this.field_179455_b > 0) {
                    entitylivingbase.func_70097_a(DamageSource.field_76376_m, 1.0F);
                    entitylivingbase.func_70015_d(1 + this.field_179455_b);
                }

                if (this.field_179455_b == 0) {
                    this.field_179456_a.field_70170_p.func_72960_a(this.field_179456_a, (byte)21);
                } else if (this.field_179455_b >= 60) {
                    float f = 12.0F;
                    if (this.field_179456_a.field_70170_p.field_73013_u == EnumDifficulty.HARD) {
                        f += 4.0F;
                    }

                    this.field_179456_a.func_70652_k(entitylivingbase);
                    entitylivingbase.func_70097_a(DamageSource.func_76354_b(this.field_179456_a, this.field_179456_a), f);
                    this.field_179456_a.func_70624_b((EntityLivingBase)null);
                } else if (this.field_179455_b >= 60 && this.field_179455_b % 20 == 0) {
                }

                super.func_75246_d();
            }

        }
    }

    class AIPerch extends EntityAIBase {
        public AIPerch() {
            this.func_75248_a(7);
        }

        public boolean func_75250_a() {
            Block blockmain = EntityGargoyle.this.field_70170_p.func_147439_a((int)EntityGargoyle.this.waypointX, (int)EntityGargoyle.this.waypointY, (int)EntityGargoyle.this.waypointZ);
            return EntityGargoyle.this.getNatureBlock(blockmain) && EntityGargoyle.this.func_70638_az() == null;
        }
    }
}
