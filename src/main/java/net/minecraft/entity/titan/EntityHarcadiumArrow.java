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
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.titanminion.EntitySkeletonMinion;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityHarcadiumArrow extends EntityArrow {
    private int xTile = -1;
    private int yTile = -1;
    private int zTile = -1;
    private Block inTile;
    private int inData;
    private boolean inGround;
    public int field_70251_a;
    public int field_70249_b;
    public Entity field_70250_c;
    private int ticksInGround;
    private int ticksInAir;
    private double damage = (double)30.0F;
    private int knockbackStrength;

    public EntityHarcadiumArrow(World worldIn) {
        super(worldIn);
        this.field_70155_l = (double)10.0F;
        this.func_70105_a(0.5F, 0.5F);
    }

    public EntityHarcadiumArrow(World worldIn, double x, double y, double z) {
        super(worldIn);
        this.field_70155_l = (double)10.0F;
        this.func_70105_a(0.5F, 0.5F);
        this.func_70107_b(x, y, z);
    }

    public EntityHarcadiumArrow(World worldIn, EntityLivingBase shooter, EntityLivingBase p_i1755_3_, float p_i1755_4_, float p_i1755_5_) {
        super(worldIn);
        this.field_70155_l = (double)10.0F;
        this.field_70250_c = shooter;
        if (shooter instanceof EntityPlayer) {
            this.field_70251_a = 1;
        }

        this.field_70163_u = shooter.field_70163_u + (double)shooter.func_70047_e() - (double)0.1F;
        double d0 = p_i1755_3_.field_70165_t - shooter.field_70165_t;
        double d1 = p_i1755_3_.field_70121_D.field_72338_b + (double)(p_i1755_3_.field_70131_O / 3.0F) - this.field_70163_u;
        double d2 = p_i1755_3_.field_70161_v - shooter.field_70161_v;
        double d3 = (double)MathHelper.func_76133_a(d0 * d0 + d2 * d2);
        if (d3 >= 1.0E-7) {
            float f2 = (float)(Math.atan2(d2, d0) * (double)180.0F / Math.PI) - 90.0F;
            float f3 = (float)(-(Math.atan2(d1, d3) * (double)180.0F / Math.PI));
            double d4 = d0 / d3;
            double d5 = d2 / d3;
            this.func_70012_b(shooter.field_70165_t + d4, this.field_70163_u, shooter.field_70161_v + d5, f2, f3);
            float f4 = (float)(d3 * (double)0.2F);
            this.func_70186_c(d0, d1 + (double)f4, d2, p_i1755_4_, p_i1755_5_);
        }

    }

    public EntityHarcadiumArrow(World worldIn, EntityLivingBase shooter, float p_i1756_3_) {
        super(worldIn);
        this.field_70155_l = (double)10.0F;
        this.field_70250_c = shooter;
        if (shooter instanceof EntityPlayer) {
            this.field_70251_a = 1;
        }

        this.func_70105_a(0.5F, 0.5F);
        this.func_70012_b(shooter.field_70165_t, shooter.field_70163_u + (double)shooter.func_70047_e(), shooter.field_70161_v, shooter.field_70177_z, shooter.field_70125_A);
        this.field_70165_t -= (double)(MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float)Math.PI) * 0.16F);
        this.field_70163_u -= (double)0.1F;
        this.field_70161_v -= (double)(MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float)Math.PI) * 0.16F);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70159_w = (double)(-MathHelper.func_76126_a(this.field_70177_z / 180.0F * (float)Math.PI) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float)Math.PI));
        this.field_70179_y = (double)(MathHelper.func_76134_b(this.field_70177_z / 180.0F * (float)Math.PI) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * (float)Math.PI));
        this.field_70181_x = (double)(-MathHelper.func_76126_a(this.field_70125_A / 180.0F * (float)Math.PI));
        this.func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, p_i1756_3_ * 1.5F, 1.0F);
    }

    protected void func_70088_a() {
        this.field_70180_af.func_75682_a(16, (byte)0);
    }

    public void func_70186_c(double x, double y, double z, float velocity, float inaccuracy) {
        float f2 = MathHelper.func_76133_a(x * x + y * y + z * z);
        x /= (double)f2;
        y /= (double)f2;
        z /= (double)f2;
        x += this.field_70146_Z.nextGaussian() * (double)(this.field_70146_Z.nextBoolean() ? -1 : 1) * (double)0.0075F * (double)inaccuracy;
        y += this.field_70146_Z.nextGaussian() * (double)(this.field_70146_Z.nextBoolean() ? -1 : 1) * (double)0.0075F * (double)inaccuracy;
        z += this.field_70146_Z.nextGaussian() * (double)(this.field_70146_Z.nextBoolean() ? -1 : 1) * (double)0.0075F * (double)inaccuracy;
        x *= (double)velocity;
        y *= (double)velocity;
        z *= (double)velocity;
        this.field_70159_w = x;
        this.field_70181_x = y;
        this.field_70179_y = z;
        float f3 = MathHelper.func_76133_a(x * x + z * z);
        this.field_70126_B = this.field_70177_z = (float)(Math.atan2(x, z) * (double)180.0F / Math.PI);
        this.field_70127_C = this.field_70125_A = (float)(Math.atan2(y, (double)f3) * (double)180.0F / Math.PI);
        this.ticksInGround = 0;
    }

    @SideOnly(Side.CLIENT)
    public void func_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
        this.func_70107_b(p_180426_1_, p_180426_3_, p_180426_5_);
        this.func_70101_b(p_180426_7_, p_180426_8_);
    }

    @SideOnly(Side.CLIENT)
    public void func_70016_h(double x, double y, double z) {
        this.field_70159_w = x;
        this.field_70181_x = y;
        this.field_70179_y = z;
        if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
            float f = MathHelper.func_76133_a(x * x + z * z);
            this.field_70126_B = this.field_70177_z = (float)(Math.atan2(x, z) * (double)180.0F / Math.PI);
            this.field_70127_C = this.field_70125_A = (float)(Math.atan2(y, (double)f) * (double)180.0F / Math.PI);
            this.field_70127_C = this.field_70125_A;
            this.field_70126_B = this.field_70177_z;
            this.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
            this.ticksInGround = 0;
        }

    }

    public void func_70071_h_() {
        this.func_70030_z();
        if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
            float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            this.field_70126_B = this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * (double)180.0F / Math.PI);
            this.field_70127_C = this.field_70125_A = (float)(Math.atan2(this.field_70181_x, (double)f) * (double)180.0F / Math.PI);
        }

        Block block = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
        if (block.func_149688_o() != Material.field_151579_a) {
            block.func_149719_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
            AxisAlignedBB axisalignedbb = block.func_149668_a(this.field_70170_p, this.xTile, this.yTile, this.zTile);
            if (axisalignedbb != null && axisalignedbb.func_72318_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v))) {
                this.inGround = true;
            }
        }

        if (this.field_70249_b > 0) {
            --this.field_70249_b;
        }

        if (this.inGround) {
            int j = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
            if (block == this.inTile && j == this.inData) {
                ++this.ticksInGround;
                if (this.field_70250_c != null && (this.field_70250_c instanceof EntitySkeletonTitan || this.field_70250_c instanceof EntityLivingBase && ((EntityLivingBase)this.field_70250_c).func_70694_bm() != null && EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, ((EntityLivingBase)this.field_70250_c).func_70694_bm()) > 0) && this.ticksInGround > 80) {
                    switch (this.field_70146_Z.nextInt(5)) {
                        case 0:
                            EntityTNTPrimed tnt = new EntityTNTPrimed(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, (EntityLivingBase)this.field_70250_c);
                            tnt.field_70516_a = 40 + this.field_70146_Z.nextInt(40);
                            tnt.func_85030_a("game.tnt.primed", 1.0F, 1.0F);
                            if (!this.field_70170_p.field_72995_K) {
                                this.field_70170_p.func_72838_d(tnt);
                            }
                            break;
                        case 1:
                            EntityCreeper creeper = new EntityCreeper(this.field_70170_p);
                            creeper.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
                            creeper.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 40, 4, false));
                            creeper.func_146079_cb();
                            if (!this.field_70170_p.field_72995_K) {
                                this.field_70170_p.func_72838_d(creeper);
                            }
                            break;
                        case 2:
                            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat()));
                            break;
                        case 3:
                            EntitySkeletonMinion skeleton = new EntitySkeletonMinion(this.field_70170_p);
                            skeleton.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
                            skeleton.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 200, 4, false));
                            if (this.field_70250_c instanceof EntitySkeletonTitan) {
                                skeleton.master = (EntitySkeletonTitan)this.field_70250_c;
                                skeleton.func_82201_a(((EntitySkeletonTitan)this.field_70250_c).getSkeletonType());
                            }

                            if (this.field_70146_Z.nextInt(2) == 0) {
                                skeleton.func_110161_a((IEntityLivingData)null);
                            }

                            if (!this.field_70170_p.field_72995_K) {
                                this.field_70170_p.func_72838_d(skeleton);
                            }
                            break;
                        case 4:
                            this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 2.0F, false, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                    }

                    this.func_70106_y();
                }

                if (this.ticksInGround >= 1200 || this.ticksInGround >= 100 && !(this.field_70250_c instanceof EntityPlayer)) {
                    this.func_70106_y();
                }
            } else {
                this.inGround = false;
                this.field_70159_w *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
                this.field_70181_x *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
                this.field_70179_y *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        } else {
            ++this.ticksInAir;
            Vec3 vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            Vec3 vec3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
            MovingObjectPosition movingobjectposition = this.field_70170_p.func_147447_a(vec31, vec3, false, true, false);
            vec31 = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            vec3 = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
            if (movingobjectposition != null) {
                vec3 = Vec3.func_72443_a(movingobjectposition.field_72307_f.field_72450_a, movingobjectposition.field_72307_f.field_72448_b, movingobjectposition.field_72307_f.field_72449_c);
            }

            Entity entity = null;
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b((double)1.0F, (double)1.0F, (double)1.0F));
            double d0 = (double)0.0F;

            for(int i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity)list.get(i);
                if (entity1.func_70067_L() && (entity1 != this.field_70250_c || this.ticksInAir >= 5)) {
                    float f1 = 0.3F;
                    AxisAlignedBB axisalignedbb1 = entity1.field_70121_D.func_72314_b((double)f1, (double)f1, (double)f1);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb1.func_72327_a(vec31, vec3);
                    if (movingobjectposition1 != null) {
                        double d1 = vec31.func_72438_d(movingobjectposition1.field_72307_f);
                        if (d1 < d0 || d0 == (double)0.0F) {
                            entity = entity1;
                            d0 = d1;
                        }
                    }
                }
            }

            if (entity != null) {
                movingobjectposition = new MovingObjectPosition(entity);
            }

            if (movingobjectposition != null && movingobjectposition.field_72308_g != null && movingobjectposition.field_72308_g instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.field_72308_g;
                if (entityplayer.field_71075_bZ.field_75102_a || this.field_70250_c instanceof EntityPlayer && !((EntityPlayer)this.field_70250_c).func_96122_a(entityplayer)) {
                    movingobjectposition = null;
                }
            }

            if (movingobjectposition != null) {
                if (movingobjectposition.field_72308_g == null) {
                    this.xTile = movingobjectposition.field_72311_b;
                    this.yTile = movingobjectposition.field_72312_c;
                    this.zTile = movingobjectposition.field_72309_d;
                    this.inTile = this.field_70170_p.func_147439_a(this.xTile, this.yTile, this.zTile);
                    this.inData = this.field_70170_p.func_72805_g(this.xTile, this.yTile, this.zTile);
                    this.field_70159_w = (double)((float)(movingobjectposition.field_72307_f.field_72450_a - this.field_70165_t));
                    this.field_70181_x = (double)((float)(movingobjectposition.field_72307_f.field_72448_b - this.field_70163_u));
                    this.field_70179_y = (double)((float)(movingobjectposition.field_72307_f.field_72449_c - this.field_70161_v));
                    float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
                    this.field_70165_t -= this.field_70159_w / (double)f2 * (double)0.05F;
                    this.field_70163_u -= this.field_70181_x / (double)f2 * (double)0.05F;
                    this.field_70161_v -= this.field_70179_y / (double)f2 * (double)0.05F;
                    this.func_85030_a("random.bowhit", 1.0F, 1.2F / (this.field_70146_Z.nextFloat() * 0.2F + 0.9F));
                    this.inGround = true;
                    this.field_70249_b = 7;
                    this.func_70243_d(false);
                    if (this.inTile.func_149688_o() != Material.field_151579_a) {
                        this.inTile.func_149670_a(this.field_70170_p, this.xTile, this.yTile, this.zTile, this);
                    }
                } else {
                    float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
                    int k = MathHelper.func_76143_f((double)f2 * this.damage / (double)2.0F);
                    if (this.func_70241_g()) {
                        k += this.field_70146_Z.nextInt(k / 2 + 2);
                    }

                    DamageSource damagesource;
                    if (this.field_70250_c == null) {
                        damagesource = DamageSourceExtra.causeHarcadiumArrowDamage(this, this);
                    } else {
                        damagesource = DamageSourceExtra.causeHarcadiumArrowDamage(this, this.field_70250_c);
                    }

                    if (movingobjectposition.field_72308_g.field_70131_O >= 6.0F || movingobjectposition.field_72308_g instanceof EntityTitan) {
                        movingobjectposition.field_72308_g.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                        movingobjectposition.field_72308_g.func_70097_a(DamageSourceExtra.causeAntiTitanDamage(this.field_70250_c), 300.0F);
                        this.func_70106_y();
                        if (this.field_70251_a == 1) {
                            movingobjectposition.field_72308_g.func_145779_a(TitanItems.harcadiumArrow, 1);
                        }
                    }

                    if (this.func_70027_ad()) {
                        movingobjectposition.field_72308_g.func_70015_d(15);
                    }

                    if (movingobjectposition.field_72308_g.func_70097_a(damagesource, (float)k)) {
                        if (movingobjectposition.field_72308_g instanceof EntityLivingBase) {
                            EntityLivingBase entitylivingbase = (EntityLivingBase)movingobjectposition.field_72308_g;
                            if (!this.field_70170_p.field_72995_K) {
                                entitylivingbase.func_85034_r(entitylivingbase.func_85035_bI() + 1);
                            }

                            if (this.knockbackStrength > 0) {
                                float f4 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
                                if (f4 > 0.0F) {
                                    movingobjectposition.field_72308_g.func_70024_g(this.field_70159_w * (double)this.knockbackStrength * 0.8 / (double)f4, (double)0.5F, this.field_70179_y * (double)this.knockbackStrength * 0.8 / (double)f4);
                                }
                            }

                            if (this.field_70250_c instanceof EntityLivingBase) {
                                EnchantmentHelper.func_151384_a(entitylivingbase, this.field_70250_c);
                                EnchantmentHelper.func_151385_b((EntityLivingBase)this.field_70250_c, entitylivingbase);
                            }

                            if (this.field_70250_c != null && movingobjectposition.field_72308_g != this.field_70250_c && movingobjectposition.field_72308_g instanceof EntityPlayer && this.field_70250_c instanceof EntityPlayerMP) {
                                ((EntityPlayerMP)this.field_70250_c).field_71135_a.func_147359_a(new S2BPacketChangeGameState(6, 0.0F));
                            }
                        }

                        this.func_85030_a("random.bowhit", 1.0F, 1.2F / (this.field_70146_Z.nextFloat() * 0.2F + 0.9F));
                        if (!(movingobjectposition.field_72308_g instanceof EntityEnderman)) {
                            this.func_70106_y();
                            if (this.field_70251_a == 1) {
                                movingobjectposition.field_72308_g.func_145779_a(TitanItems.harcadiumArrow, 1);
                            }
                        }
                    } else {
                        if (movingobjectposition.field_72308_g instanceof EntityLivingBase && movingobjectposition.field_72308_g != this.field_70250_c && !(movingobjectposition.field_72308_g instanceof EntityTitan)) {
                            if (this.knockbackStrength > 0) {
                                float f4 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
                                if (f4 > 0.0F) {
                                    movingobjectposition.field_72308_g.func_70024_g(this.field_70159_w * (double)this.knockbackStrength * 0.8 / (double)f4, (double)0.5F, this.field_70179_y * (double)this.knockbackStrength * 0.8 / (double)f4);
                                }
                            }

                            this.field_70170_p.func_72960_a((EntityLivingBase)movingobjectposition.field_72308_g, (byte)2);
                            if (movingobjectposition.field_72308_g instanceof EntityLiving) {
                                ((EntityLiving)movingobjectposition.field_72308_g).func_70096_w().func_75692_b(6, MathHelper.func_76131_a(((EntityLiving)movingobjectposition.field_72308_g).func_110143_aJ() - (float)k, 0.0F, ((EntityLiving)movingobjectposition.field_72308_g).func_110138_aP()));
                            }

                            if (!((EntityLivingBase)movingobjectposition.field_72308_g).func_70089_S()) {
                                this.field_70170_p.func_72960_a((EntityLivingBase)movingobjectposition.field_72308_g, (byte)3);
                                ((EntityLivingBase)movingobjectposition.field_72308_g).func_70645_a(damagesource);
                            }
                        }

                        this.field_70159_w *= (double)-0.1F;
                        this.field_70181_x *= (double)-0.1F;
                        this.field_70179_y *= (double)-0.1F;
                        this.field_70177_z += 180.0F;
                        this.field_70126_B += 180.0F;
                        this.ticksInAir = 0;
                    }
                }
            }

            if (this.func_70241_g()) {
                for(int i = 0; i < 4; ++i) {
                    this.field_70170_p.func_72869_a("critMagic", this.field_70165_t + this.field_70159_w * (double)i / (double)4.0F, this.field_70163_u + this.field_70181_x * (double)i / (double)4.0F, this.field_70161_v + this.field_70179_y * (double)i / (double)4.0F, -this.field_70159_w, -this.field_70181_x + 0.2, -this.field_70179_y);
                }
            }

            for(int i = 0; i < 4; ++i) {
                this.field_70170_p.func_72869_a("crit", this.field_70165_t + this.field_70159_w * (double)i / (double)4.0F, this.field_70163_u + this.field_70181_x * (double)i / (double)4.0F, this.field_70161_v + this.field_70179_y * (double)i / (double)4.0F, -this.field_70159_w, -this.field_70181_x + 0.2, -this.field_70179_y);
            }

            this.field_70165_t += this.field_70159_w;
            this.field_70163_u += this.field_70181_x;
            this.field_70161_v += this.field_70179_y;
            float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * (double)180.0F / Math.PI);

            for(this.field_70125_A = (float)(Math.atan2(this.field_70181_x, (double)f2) * (double)180.0F / Math.PI); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {
            }

            while(this.field_70125_A - this.field_70127_C >= 180.0F) {
                this.field_70127_C += 360.0F;
            }

            while(this.field_70177_z - this.field_70126_B < -180.0F) {
                this.field_70126_B -= 360.0F;
            }

            while(this.field_70177_z - this.field_70126_B >= 180.0F) {
                this.field_70126_B += 360.0F;
            }

            this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
            this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
            float f3 = 0.99F;
            float f1 = 0.05F;
            if (this.func_70090_H()) {
                for(int l = 0; l < 4; ++l) {
                    float f4 = 0.25F;
                    this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * (double)f4, this.field_70163_u - this.field_70181_x * (double)f4, this.field_70161_v - this.field_70179_y * (double)f4, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                }

                f3 = 0.8F;
            }

            if (this.func_70026_G()) {
                this.func_70066_B();
            }

            this.field_70159_w *= (double)f3;
            this.field_70181_x *= (double)f3;
            this.field_70179_y *= (double)f3;
            this.field_70181_x -= (double)f1;
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.func_145775_I();
        }

    }

    public void func_70014_b(NBTTagCompound p_70014_1_) {
        p_70014_1_.func_74777_a("xTile", (short)this.xTile);
        p_70014_1_.func_74777_a("yTile", (short)this.yTile);
        p_70014_1_.func_74777_a("zTile", (short)this.zTile);
        p_70014_1_.func_74777_a("life", (short)this.ticksInGround);
        p_70014_1_.func_74774_a("inTile", (byte)Block.func_149682_b(this.inTile));
        p_70014_1_.func_74774_a("inData", (byte)this.inData);
        p_70014_1_.func_74774_a("shake", (byte)this.field_70249_b);
        p_70014_1_.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
        p_70014_1_.func_74774_a("pickup", (byte)this.field_70251_a);
        p_70014_1_.func_74780_a("damage", this.damage);
    }

    public void func_70037_a(NBTTagCompound p_70037_1_) {
        this.xTile = p_70037_1_.func_74765_d("xTile");
        this.yTile = p_70037_1_.func_74765_d("yTile");
        this.zTile = p_70037_1_.func_74765_d("zTile");
        this.ticksInGround = p_70037_1_.func_74765_d("life");
        this.inTile = Block.func_149729_e(p_70037_1_.func_74771_c("inTile") & 255);
        this.inData = p_70037_1_.func_74771_c("inData") & 255;
        this.field_70249_b = p_70037_1_.func_74771_c("shake") & 255;
        this.inGround = p_70037_1_.func_74771_c("inGround") == 1;
        if (p_70037_1_.func_150297_b("damage", 99)) {
            this.damage = p_70037_1_.func_74769_h("damage");
        }

        if (p_70037_1_.func_150297_b("pickup", 99)) {
            this.field_70251_a = p_70037_1_.func_74771_c("pickup");
        } else if (p_70037_1_.func_150297_b("player", 99)) {
            this.field_70251_a = p_70037_1_.func_74767_n("player") ? 1 : 0;
        }

    }

    public void func_70100_b_(EntityPlayer entityIn) {
        if (!this.field_70170_p.field_72995_K && this.inGround && this.field_70249_b <= 0) {
            boolean flag = this.field_70251_a == 1 || this.field_70251_a == 2 && entityIn.field_71075_bZ.field_75098_d;
            if (this.field_70251_a == 1 && !entityIn.field_71071_by.func_70441_a(new ItemStack(TitanItems.harcadiumArrow, 1))) {
                flag = false;
            }

            if (flag) {
                this.func_85030_a("random.pop", 0.2F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                entityIn.func_71001_a(this, 1);
                this.func_70106_y();
            }
        }

    }

    protected boolean func_70041_e_() {
        return false;
    }

    public void func_70239_b(double p_70239_1_) {
        this.damage = p_70239_1_;
    }

    public double func_70242_d() {
        return this.damage;
    }

    public void func_70240_a(int p_70240_1_) {
        this.knockbackStrength = p_70240_1_;
    }

    public boolean func_70075_an() {
        return false;
    }

    public void func_70243_d(boolean p_70243_1_) {
        byte b0 = this.field_70180_af.func_75683_a(16);
        if (p_70243_1_) {
            this.field_70180_af.func_75692_b(16, (byte)(b0 | 1));
        } else {
            this.field_70180_af.func_75692_b(16, (byte)(b0 & -2));
        }

    }

    public boolean func_70241_g() {
        byte b0 = this.field_70180_af.func_75683_a(16);
        return (b0 & 1) != 0;
    }
}
