//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.titanminion.EntityBlazeMinion;
import net.minecraft.entity.titanminion.EntityCaveSpiderMinion;
import net.minecraft.entity.titanminion.EntityCreeperMinion;
import net.minecraft.entity.titanminion.EntityEndermanMinion;
import net.minecraft.entity.titanminion.EntityGhastMinion;
import net.minecraft.entity.titanminion.EntityPigZombieMinion;
import net.minecraft.entity.titanminion.EntitySilverfishMinion;
import net.minecraft.entity.titanminion.EntitySkeletonMinion;
import net.minecraft.entity.titanminion.EntitySpiderMinion;
import net.minecraft.entity.titanminion.EntityZombieMinion;
import net.minecraft.entity.titanminion.EnumMinionType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.world.WorldProviderVoid;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityTitanSpirit extends EntityLiving {
    public int spiritType;
    public int spiritNameID;
    public float tonnage;
    public boolean isSearchingForVessel = true;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private EntityLivingBase prevEntity;

    public EntityTitanSpirit(World worldIn) {
        super(worldIn);
        this.func_70105_a(8.0F, 8.0F);
        this.field_70145_X = true;
        this.field_70178_ae = true;
        this.field_70158_ak = true;
        this.func_85030_a("thetitans:titanBirth", 10000.0F, 2.0F);
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        super.func_70037_a(tagCompund);
        this.setTonnage(tagCompund.func_74760_g("Tonnage"));
        this.setSpiritType(tagCompund.func_74762_e("SpiritType"));
        this.setSpiritNameID(tagCompund.func_74762_e("SpiritNameID"));
        this.setVesselHunting(tagCompund.func_74767_n("ShouldHuntForVessels"));
    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        super.func_70014_b(tagCompound);
        tagCompound.func_74776_a("Tonnage", this.getTonnage());
        tagCompound.func_74768_a("SpiritType", this.getSpiritType());
        tagCompound.func_74768_a("SpiritNameID", this.getSpiritNameID());
        tagCompound.func_74757_a("ShouldHuntForVessels", this.isVesselHunting());
    }

    protected void func_70069_a(float p_70069_1_) {
    }

    protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {
    }

    public void func_70612_e(float p_70612_1_, float p_70612_2_) {
        if (this.func_70090_H()) {
            this.func_70060_a(p_70612_1_, p_70612_2_, 0.02F);
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= (double)0.8F;
            this.field_70181_x *= (double)0.8F;
            this.field_70179_y *= (double)0.8F;
        } else if (this.func_70058_J()) {
            this.func_70060_a(p_70612_1_, p_70612_2_, 0.02F);
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= (double)0.5F;
            this.field_70181_x *= (double)0.5F;
            this.field_70179_y *= (double)0.5F;
        } else {
            float f2 = 0.91F;
            if (this.field_70122_E) {
                f2 = this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v)).field_149765_K * 0.91F;
            }

            float f3 = 0.16277136F / (f2 * f2 * f2);
            this.func_70060_a(p_70612_1_, p_70612_2_, this.field_70122_E ? 0.1F * f3 : 0.02F);
            f2 = 0.91F;
            if (this.field_70122_E) {
                f2 = this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v)).field_149765_K * 0.91F;
            }

            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= (double)f2;
            this.field_70181_x *= (double)f2;
            this.field_70179_y *= (double)f2;
        }

        this.field_70722_aY = this.field_70721_aZ;
        double d1 = this.field_70165_t - this.field_70169_q;
        double d0 = this.field_70161_v - this.field_70166_s;
        float f4 = MathHelper.func_76133_a(d1 * d1 + d0 * d0) * 4.0F;
        if (f4 > 1.0F) {
            f4 = 1.0F;
        }

        this.field_70721_aZ += (f4 - this.field_70721_aZ) * 0.4F;
        this.field_70754_ba += this.field_70721_aZ;
    }

    public boolean func_70617_f_() {
        return false;
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(Double.MAX_VALUE);
    }

    public boolean isVesselHunting() {
        return this.isSearchingForVessel;
    }

    public void setVesselHunting(boolean p_70819_1_) {
        this.isSearchingForVessel = p_70819_1_;
    }

    public int getSpiritType() {
        return this.spiritType;
    }

    public void setSpiritType(int p_82215_1_) {
        this.spiritType = p_82215_1_;
    }

    public int getSpiritNameID() {
        return this.spiritNameID;
    }

    public void setSpiritNameID(int p_82215_1_) {
        this.spiritNameID = p_82215_1_;
    }

    public float getTonnage() {
        return this.tonnage;
    }

    public void setTonnage(float p_82215_1_) {
        this.tonnage = p_82215_1_;
    }

    public float getMaxTonnage() {
        switch (this.getSpiritType()) {
            case 1:
                return 8000.0F;
            case 2:
                return 12000.0F;
            case 3:
                return 16000.0F;
            case 4:
                return 20000.0F;
            case 5:
                return 100000.0F;
            case 6:
                return 20000.0F;
            case 7:
                return 25000.0F;
            case 8:
                return 20000.0F;
            case 9:
                return 40000.0F;
            case 10:
                return 150000.0F;
            case 11:
                return 200000.0F;
            case 12:
                return 1.0E7F;
            default:
                return 1.0F;
        }
    }

    public String func_70005_c_() {
        switch (this.getSpiritType()) {
            case 1:
                return StatCollector.func_74838_a("entity.SilverfishTitan.name");
            case 2:
                return StatCollector.func_74838_a("entity.CaveSpiderTitan.name");
            case 3:
                return StatCollector.func_74838_a("entity.SpiderTitan.name");
            case 4:
                return StatCollector.func_74838_a("entity.SkeletonTitan.name");
            case 5:
                return StatCollector.func_74838_a("entity.WitherSkeletonTitan.name");
            case 6:
                return StatCollector.func_74838_a("entity.ZombieTitan.name");
            case 7:
                return StatCollector.func_74838_a("entity.CreeperTitan.name");
            case 8:
                return StatCollector.func_74838_a("entity.PigZombieTitan.name");
            case 9:
                return StatCollector.func_74838_a("entity.BlazeTitan.name");
            case 10:
                return StatCollector.func_74838_a("entity.EndermanTitan.realname");
            case 11:
                return StatCollector.func_74838_a("entity.GhastTitan.name");
            case 12:
                return "§kRegnator";
            default:
                return StatCollector.func_74838_a("entity.TitanSpirit.name");
        }
    }

    public void func_70106_y() {
        if (!this.field_70170_p.field_72995_K) {
            switch (this.getSpiritType()) {
                case 1:
                    this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 18.0F, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                    EntitySilverfishTitan omegafish = new EntitySilverfishTitan(this.field_70170_p);
                    omegafish.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    omegafish.func_82206_m();
                    this.field_70170_p.func_72838_d(omegafish);
                    break;
                case 2:
                    this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 12.0F, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                    EntityCaveSpiderTitan cavespidertitan = new EntityCaveSpiderTitan(this.field_70170_p);
                    cavespidertitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    cavespidertitan.func_82206_m();
                    this.field_70170_p.func_72838_d(cavespidertitan);
                    break;
                case 3:
                    this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 12.0F, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                    EntitySpiderTitan spidertitan = new EntitySpiderTitan(this.field_70170_p);
                    spidertitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    spidertitan.func_82206_m();
                    this.field_70170_p.func_72838_d(spidertitan);
                    break;
                case 4:
                    this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 18.0F, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                    EntitySkeletonTitan skeletontitan = new EntitySkeletonTitan(this.field_70170_p);
                    skeletontitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    skeletontitan.setSkeletonType(0);
                    skeletontitan.func_82206_m();
                    this.field_70170_p.func_72838_d(skeletontitan);
                    break;
                case 5:
                    this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 18.0F, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                    EntitySkeletonTitan witherskeletontitan = new EntitySkeletonTitan(this.field_70170_p);
                    witherskeletontitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    witherskeletontitan.setSkeletonType(1);
                    witherskeletontitan.func_82206_m();
                    this.field_70170_p.func_72838_d(witherskeletontitan);
                    break;
                case 6:
                    this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 18.0F, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                    EntityZombieTitan zombietitan = new EntityZombieTitan(this.field_70170_p);
                    zombietitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    zombietitan.func_110161_a((IEntityLivingData)null);
                    zombietitan.func_82206_m();
                    this.field_70170_p.func_72838_d(zombietitan);
                    if (this.prevEntity != null) {
                        zombietitan.setChild(((EntityZombieMinion)this.prevEntity).func_70631_g_());
                        zombietitan.setVillager(((EntityZombieMinion)this.prevEntity).func_82231_m());
                    }
                    break;
                case 7:
                    this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 18.0F, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                    EntityCreeperTitan creepertitan = new EntityCreeperTitan(this.field_70170_p);
                    creepertitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    creepertitan.func_82206_m();
                    this.field_70170_p.func_72838_d(creepertitan);
                    if (this.prevEntity != null) {
                        creepertitan.setPowered(((EntityCreeperMinion)this.prevEntity).func_70830_n());
                    }
                    break;
                case 8:
                    this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 18.0F, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                    EntityPigZombieTitan pigzombietitan = new EntityPigZombieTitan(this.field_70170_p);
                    pigzombietitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    pigzombietitan.func_82206_m();
                    this.field_70170_p.func_72838_d(pigzombietitan);
                    if (this.prevEntity != null) {
                        pigzombietitan.setChild(((EntityPigZombieMinion)this.prevEntity).func_70631_g_());
                    }
                    break;
                case 9:
                    this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 16.0F, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                    EntityBlazeTitan blazetitan = new EntityBlazeTitan(this.field_70170_p);
                    blazetitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    blazetitan.func_82206_m();
                    this.field_70170_p.func_72838_d(blazetitan);
                    break;
                case 10:
                    this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 45.0F, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                    EntityEnderColossus endercolossus = new EntityEnderColossus(this.field_70170_p);
                    endercolossus.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    endercolossus.func_82206_m();
                    this.field_70170_p.func_72838_d(endercolossus);
                    break;
                case 11:
                    this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 8.0F, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                    EntityGhastTitan ghasttitan = new EntityGhastTitan(this.field_70170_p);
                    ghasttitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                    ghasttitan.func_82206_m();
                    this.field_70170_p.func_72838_d(ghasttitan);
                    break;
                case 12:
                    if (this.field_70170_p.field_73011_w instanceof WorldProviderVoid) {
                        if (this.prevEntity != null) {
                            ((EntityPlayer)this.prevEntity).func_145747_a(new ChatComponentText("In the end, you are your own undoing."));
                        }

                        this.field_70170_p.field_72984_F.func_76320_a("changeDimension");
                        MinecraftServer minecraftserver = MinecraftServer.func_71276_C();
                        int j = this.field_71093_bK;
                        WorldServer worldserver = minecraftserver.func_71218_a(j);
                        WorldServer worldserver1 = minecraftserver.func_71218_a(0);
                        this.field_71093_bK = 0;
                        this.field_70170_p.field_72984_F.func_76320_a("reposition");
                        minecraftserver.func_71203_ab().func_82448_a(this, j, worldserver, worldserver1);
                        this.field_70170_p.field_72984_F.func_76318_c("reloading");
                        Entity entity = EntityList.func_75620_a(EntityList.func_75621_b(this), worldserver1);
                        if (entity != null) {
                            entity.func_82141_a(this, true);
                            worldserver1.func_72838_d(entity);
                        }

                        this.field_70170_p.field_72984_F.func_76319_b();
                        worldserver.func_82742_i();
                        worldserver1.func_82742_i();
                        this.field_70170_p.field_72984_F.func_76319_b();
                    } else {
                        if (this.prevEntity != null) {
                            ((EntityPlayer)this.prevEntity).func_70097_a(DamageSource.field_76380_i, Float.MAX_VALUE);
                            ((EntityPlayer)this.prevEntity).func_70606_j(0.0F);
                            ((EntityPlayer)this.prevEntity).func_70096_w().func_75692_b(6, MathHelper.func_76131_a(0.0F, 0.0F, ((EntityPlayer)this.prevEntity).func_110138_aP()));
                        }

                        this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 7.0F, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
                        EntityWitherzilla witherzilla = new EntityWitherzilla(this.field_70170_p);
                        witherzilla.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
                        witherzilla.func_82206_m();
                        this.field_70170_p.func_72838_d(witherzilla);
                        if (this.prevEntity != null) {
                            ((EntityPlayer)this.prevEntity).func_145747_a(new ChatComponentText("This universe is flawed, Notch. They've corrupted it. It has to go."));
                        }
                    }
            }

            ArrayList listp = Lists.newArrayList(this.field_70170_p.field_73010_i);
            if (this.getSpiritType() != 12 && listp != null && !listp.isEmpty() && !this.field_70170_p.field_72995_K) {
                for(int i1 = 0; i1 < listp.size(); ++i1) {
                    Entity entity = (Entity)listp.get(i1);
                    if (entity != null && entity instanceof EntityPlayer) {
                        this.func_70642_aH();
                        ((EntityPlayer)entity).func_145747_a(new ChatComponentText(this.func_70005_c_() + ": Now to return to where we left off, " + ((EntityPlayer)entity).func_70005_c_() + "."));
                    }
                }
            }
        }

        super.func_70106_y();
    }

    public void func_70636_d() {
        if (this.getTonnage() >= this.getMaxTonnage()) {
            this.func_70106_y();
        }

        if (this.getTonnage() < 0.0F) {
            this.setTonnage(0.0F);
        } else {
            this.setTonnage(this.getTonnage() - 1.0F);
        }

        List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)32.0F, (double)32.0F, (double)32.0F));
        if (this.isVesselHunting() && list != null && !list.isEmpty()) {
            for(int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                if (entity != null && entity.func_70089_S() && entity instanceof EntityLivingBase && !(entity instanceof EntityTitan) && !(entity instanceof EntityTitanSpirit) && !(entity instanceof EntityTitanPart)) {
                    if (this.field_70173_aa + this.func_145782_y() % 40 == 0) {
                        entity.func_70097_a(DamageSourceExtra.causeSoulStealingDamage(this), 2.0F);
                    }

                    double speed = entity.func_70093_af() ? 0.2 : 0.4;
                    double mx = this.field_70165_t - entity.field_70165_t;
                    double my = this.field_70163_u + (double)4.0F - (entity.field_70163_u + (double)1.0F);
                    double mz = this.field_70161_v - entity.field_70161_v;
                    float f2 = MathHelper.func_76133_a(mx * mx + my * my + mz * mz);
                    entity.field_70159_w += mx / (double)f2 * speed * speed;
                    entity.field_70181_x += my / (double)f2 * speed * speed;
                    entity.field_70179_y += mz / (double)f2 * speed * speed;
                    short short1 = (short)((int)this.func_70032_d(entity));

                    for(int f = 0; f < short1; ++f) {
                        double d9 = (double)f / ((double)short1 - (double)1.0F);
                        double d6 = this.field_70165_t + mx * -d9;
                        double d7 = this.field_70163_u + (double)4.0F + my * -d9;
                        double d8 = this.field_70161_v + mz * -d9;
                        this.field_70170_p.func_72869_a("fireworksSpark", d6, d7, d8, entity.field_70159_w, entity.field_70181_x, entity.field_70179_y);
                    }
                }

                if (entity != null && entity instanceof EntityItem) {
                    entity.field_70172_ad = 0;
                    double mx = this.field_70165_t - entity.field_70165_t;
                    double my = this.field_70163_u + (double)4.0F - entity.field_70163_u;
                    double mz = this.field_70161_v - entity.field_70161_v;
                    float f2 = MathHelper.func_76133_a(mx * mx + my * my + mz * mz);
                    entity.field_70159_w += mx / (double)f2 * 0.3 * 0.3;
                    entity.field_70181_x += my / (double)f2 * 0.3 * 0.3;
                    entity.field_70179_y += mz / (double)f2 * 0.3 * 0.3;
                }

                if (entity != null && entity instanceof EntityTNTPrimed) {
                    entity.field_70172_ad = 0;
                    double mx = this.field_70165_t - entity.field_70165_t;
                    double my = this.field_70163_u + (double)4.0F - entity.field_70163_u;
                    double mz = this.field_70161_v - entity.field_70161_v;
                    float f2 = MathHelper.func_76133_a(mx * mx + my * my + mz * mz);
                    entity.field_70159_w += mx / (double)f2 * 0.3 * 0.3;
                    entity.field_70181_x += my / (double)f2 * 0.3 * 0.3;
                    entity.field_70179_y += mz / (double)f2 * 0.3 * 0.3;
                }

                if (entity != null && entity instanceof EntityFallingBlock) {
                    entity.field_70172_ad = 0;
                    float f6 = (float)(entity.field_70173_aa + entity.func_145782_y()) * (float)Math.PI * -0.5F;
                    double mx = this.field_70165_t + (double)(MathHelper.func_76134_b(f6) * 16.0F) - entity.field_70165_t;
                    double my = this.field_70163_u + (double)4.0F - entity.field_70163_u;
                    double mz = this.field_70161_v + (double)(MathHelper.func_76126_a(f6) * 16.0F) - entity.field_70161_v;
                    float f2 = MathHelper.func_76133_a(mx * mx + my * my + mz * mz);
                    entity.field_70159_w += mx / (double)f2 * 0.4 * 0.4;
                    entity.field_70181_x += my / (double)f2 * 0.4 * 0.4;
                    entity.field_70179_y += mz / (double)f2 * 0.4 * 0.4;
                    ArrayList arraylist = new ArrayList(this.field_70170_p.func_72839_b(entity, entity.field_70121_D));
                    boolean flag = ((EntityFallingBlock)entity).func_145805_f() == Blocks.field_150467_bQ;
                    DamageSource damagesource = flag ? DamageSource.field_82728_o : DamageSource.field_82729_p;

                    for(Entity entity1 : arraylist) {
                        entity1.func_70097_a(damagesource, 20.0F);
                    }
                }

                if (entity != null && entity instanceof EntityFireball) {
                    entity.field_70172_ad = 0;
                    double mx = this.field_70165_t - entity.field_70165_t;
                    double my = this.field_70163_u + (double)4.0F - entity.field_70163_u;
                    double mz = this.field_70161_v - entity.field_70161_v;
                    float f2 = MathHelper.func_76133_a(mx * mx + my * my + mz * mz);
                    entity.field_70159_w += mx / (double)f2 * 0.3 * 0.3;
                    entity.field_70181_x += my / (double)f2 * 0.3 * 0.3;
                    entity.field_70179_y += mz / (double)f2 * 0.3 * 0.3;
                }
            }
        }

        if (this.spiritNameID <= 0) {
            this.spiritNameID = 1;
        }

        super.func_70636_d();
        if (this.field_70163_u <= (double)-45.0F) {
            this.func_70107_b(this.field_70165_t, (double)0.0F, this.field_70161_v);
        }

        this.func_70606_j(Float.MAX_VALUE);
        this.field_70725_aQ = 0;

        for(int i = 0; i < 30; ++i) {
            float f = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70130_N;
            float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70131_O;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * this.field_70130_N;
            this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t + (double)f, this.field_70163_u + (double)4.0F + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
            this.field_70170_p.func_72869_a("explode", this.field_70165_t + (double)f, this.field_70163_u + (double)2.0F + (double)f1, this.field_70161_v + (double)f2, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t + (double)f, this.field_70163_u + (double)4.0F + (double)f1, this.field_70161_v + (double)f2, this.field_70159_w, this.field_70181_x, this.field_70179_y);
        }

        List theBoundingBox = this.field_70170_p.func_72839_b(this, this.field_70121_D);
        if (theBoundingBox != null && !theBoundingBox.isEmpty()) {
            for(int i1 = 0; i1 < theBoundingBox.size(); ++i1) {
                Entity entity = (Entity)theBoundingBox.get(i1);
                if (entity != null) {
                    if (this.spiritType == 1 && entity instanceof EntitySilverfishMinion && ((EntitySilverfishMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        this.prevEntity = (EntitySilverfishMinion)entity;
                        this.func_70106_y();
                    }

                    if (this.spiritType == 2 && entity instanceof EntityCaveSpiderMinion && ((EntityCaveSpiderMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        this.prevEntity = (EntityCaveSpiderMinion)entity;
                        this.func_70106_y();
                    }

                    if (this.spiritType == 3 && entity instanceof EntitySpiderMinion && ((EntitySpiderMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        this.prevEntity = (EntitySpiderMinion)entity;
                        this.func_70106_y();
                    }

                    if (this.spiritType == 4 && entity instanceof EntitySkeletonMinion && ((EntitySkeletonMinion)entity).func_82202_m() != 1 && ((EntitySkeletonMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        this.prevEntity = (EntitySkeletonMinion)entity;
                        this.func_70106_y();
                    }

                    if (this.spiritType == 5 && entity instanceof EntitySkeletonMinion && ((EntitySkeletonMinion)entity).func_82202_m() == 1 && ((EntitySkeletonMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        this.prevEntity = (EntitySkeletonMinion)entity;
                        this.func_70106_y();
                    }

                    if (this.spiritType == 6 && entity instanceof EntityZombieMinion && ((EntityZombieMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        this.prevEntity = (EntityZombieMinion)entity;
                        this.func_70106_y();
                    }

                    if (this.spiritType == 7 && entity instanceof EntityCreeperMinion && ((EntityCreeperMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        this.prevEntity = (EntityCreeperMinion)entity;
                        this.func_70106_y();
                    }

                    if (this.spiritType == 8 && entity instanceof EntityPigZombieMinion && ((EntityPigZombieMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        this.prevEntity = (EntityPigZombieMinion)entity;
                        this.func_70106_y();
                    }

                    if (this.spiritType == 9 && entity instanceof EntityBlazeMinion && ((EntityBlazeMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        this.prevEntity = (EntityBlazeMinion)entity;
                        this.func_70106_y();
                    }

                    if (this.spiritType == 10 && entity instanceof EntityEndermanMinion && ((EntityEndermanMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        this.prevEntity = (EntityEndermanMinion)entity;
                        this.func_70106_y();
                    }

                    if (this.spiritType == 11 && entity instanceof EntityGhastMinion && ((EntityGhastMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                        this.prevEntity = (EntityGhastMinion)entity;
                        this.func_70106_y();
                    }

                    if (this.spiritType == 12 && entity instanceof EntityPlayer) {
                        this.prevEntity = (EntityPlayer)entity;
                        this.func_70106_y();
                    }

                    if (entity instanceof EntityLivingBase) {
                        ((EntityLivingBase)entity).func_70097_a(DamageSourceExtra.causeSoulStealingDamage(this), 100.0F);
                        ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 300, 3));
                    }

                    if (entity instanceof EntityItem && ((EntityItem)entity).field_145804_b < 0 && ((EntityItem)entity).func_92059_d().func_77973_b() != Items.field_151156_bN) {
                        ((EntityItem)entity).func_70097_a(DamageSourceExtra.causeSoulStealingDamage(this), 100.0F);
                    }

                    if (entity instanceof EntityEnderCrystal) {
                        ((EntityEnderCrystal)entity).func_70097_a(DamageSourceExtra.causeSoulStealingDamage(this), 100.0F);
                    }
                }
            }
        }

    }

    protected void func_70626_be() {
        super.func_70626_be();
        if (this.waypointY <= (double)0.0F) {
            this.waypointY = (double)0.0F;
        }

        if (this.waypointY > (double)255.0F) {
            this.waypointY = (double)255.0F;
        }

        if (this.isVesselHunting() && this.field_70173_aa % 20 == 0 && this.field_70146_Z.nextInt(5) == 0) {
            EntityPlayer player = this.field_70170_p.func_72890_a(this, (double)256.0F);
            if (player != null) {
                this.waypointX = player.field_70165_t + (double)((this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 32.0F);
                this.waypointY = player.field_70163_u + (double)32.0F + (double)((this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 16.0F);
                this.waypointZ = player.field_70161_v + (double)((this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 32.0F);
            } else {
                this.waypointX = this.field_70165_t + (double)((this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 32.0F);
                this.waypointY = this.field_70163_u + (double)((this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 32.0F);
                this.waypointZ = this.field_70161_v + (double)((this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 32.0F);
            }
        }

        double d0 = this.waypointX - this.field_70165_t;
        double d1 = this.waypointY - this.field_70163_u;
        double d2 = this.waypointZ - this.field_70161_v;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;
        d3 = (double)MathHelper.func_76133_a(d3);
        if (this.isVesselHunting() && this.func_70092_e(this.waypointX, this.waypointY, this.waypointZ) > (double)40000.0F) {
            this.waypointX = this.field_70165_t;
            this.waypointY = this.field_70163_u;
            this.waypointZ = this.field_70161_v;
        }

        if (this.func_70092_e(this.waypointX, this.waypointY, this.waypointZ) > (double)4.0F) {
            this.field_70159_w += d0 / d3 * 0.15;
            this.field_70181_x += d1 / d3 * 0.15;
            this.field_70179_y += d2 / d3 * 0.15;
        }

        if (!this.isVesselHunting()) {
            this.waypointX = this.field_70165_t + (double)((this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 128.0F);
            this.waypointY = (double)255.0F;
            this.waypointZ = this.field_70161_v + (double)((this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 128.0F);
            if (this.field_70163_u >= (double)254.0F) {
                this.setVesselHunting(true);
                if (!this.field_70170_p.field_72995_K) {
                    if (this.field_70146_Z.nextInt(2) != 0 && this.getSpiritType() != 12) {
                        this.func_70107_b(this.field_70165_t + (double)((this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 1024.0F), (double)250.0F, this.field_70161_v + (double)((this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * 1024.0F));
                    } else {
                        this.field_70170_p.func_82739_e(1013, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                        ArrayList listp = Lists.newArrayList(this.field_70170_p.field_73010_i);
                        if (listp != null && !listp.isEmpty() && !this.field_70170_p.field_72995_K) {
                            for(int i1 = 0; i1 < listp.size(); ++i1) {
                                Entity entity = (Entity)listp.get(i1);
                                if (entity != null && entity instanceof EntityPlayer) {
                                    this.func_70642_aH();
                                    ((EntityPlayer)entity).func_145747_a(new ChatComponentText(this.func_70005_c_() + ": I always come back, " + ((EntityPlayer)entity).func_70005_c_() + "."));
                                }
                            }
                        }
                    }
                }
            }
        } else {
            List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)256.0F, (double)256.0F, (double)256.0F));
            if (list != null && !list.isEmpty()) {
                for(int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (entity != null) {
                        if (this.spiritType == 1 && entity instanceof EntitySilverfishMinion && ((EntitySilverfishMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                            ((EntityLiving)entity).func_70624_b(this);
                            this.waypointX = entity.field_70165_t;
                            this.waypointY = entity.field_70163_u;
                            this.waypointZ = entity.field_70161_v;
                        }

                        if (this.spiritType == 2 && entity instanceof EntityCaveSpiderMinion && ((EntityCaveSpiderMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                            ((EntityLiving)entity).func_70624_b(this);
                            this.waypointX = entity.field_70165_t;
                            this.waypointY = entity.field_70163_u;
                            this.waypointZ = entity.field_70161_v;
                        }

                        if (this.spiritType == 3 && entity instanceof EntitySpiderMinion && ((EntitySpiderMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                            ((EntityLiving)entity).func_70624_b(this);
                            this.waypointX = entity.field_70165_t;
                            this.waypointY = entity.field_70163_u;
                            this.waypointZ = entity.field_70161_v;
                        }

                        if (this.spiritType == 4 && entity instanceof EntitySkeletonMinion && ((EntitySkeletonMinion)entity).func_82202_m() != 1 && ((EntitySkeletonMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                            ((EntityLiving)entity).func_70624_b(this);
                            this.waypointX = entity.field_70165_t;
                            this.waypointY = entity.field_70163_u;
                            this.waypointZ = entity.field_70161_v;
                        }

                        if (this.spiritType == 5 && entity instanceof EntitySkeletonMinion && ((EntitySkeletonMinion)entity).func_82202_m() == 1 && ((EntitySkeletonMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                            ((EntityLiving)entity).func_70624_b(this);
                            this.waypointX = entity.field_70165_t;
                            this.waypointY = entity.field_70163_u;
                            this.waypointZ = entity.field_70161_v;
                        }

                        if (this.spiritType == 6 && entity instanceof EntityZombieMinion && ((EntityZombieMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                            ((EntityLiving)entity).func_70624_b(this);
                            this.waypointX = entity.field_70165_t;
                            this.waypointY = entity.field_70163_u;
                            this.waypointZ = entity.field_70161_v;
                        }

                        if (this.spiritType == 7 && entity instanceof EntityCreeperMinion && ((EntityCreeperMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                            ((EntityLiving)entity).func_70624_b(this);
                            this.waypointX = entity.field_70165_t;
                            this.waypointY = entity.field_70163_u;
                            this.waypointZ = entity.field_70161_v;
                        }

                        if (this.spiritType == 8 && entity instanceof EntityPigZombieMinion && ((EntityPigZombieMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                            ((EntityLiving)entity).func_70624_b(this);
                            this.waypointX = entity.field_70165_t;
                            this.waypointY = entity.field_70163_u;
                            this.waypointZ = entity.field_70161_v;
                        }

                        if (this.spiritType == 9 && entity instanceof EntityBlazeMinion && ((EntityBlazeMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                            ((EntityLiving)entity).func_70624_b(this);
                            this.waypointX = entity.field_70165_t;
                            this.waypointY = entity.field_70163_u;
                            this.waypointZ = entity.field_70161_v;
                        }

                        if (this.spiritType == 10 && entity instanceof EntityEndermanMinion && ((EntityEndermanMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                            ((EntityLiving)entity).func_70624_b(this);
                            this.waypointX = entity.field_70165_t;
                            this.waypointY = entity.field_70163_u;
                            this.waypointZ = entity.field_70161_v;
                        }

                        if (this.spiritType == 11 && entity instanceof EntityGhastMinion && ((EntityGhastMinion)entity).getMinionType() == EnumMinionType.TEMPLAR) {
                            ((EntityLiving)entity).func_70624_b(this);
                            this.waypointX = entity.field_70165_t;
                            this.waypointY = entity.field_70163_u;
                            this.waypointZ = entity.field_70161_v;
                        }

                        if (this.spiritType == 12 && entity instanceof EntityPlayer) {
                            this.waypointX = entity.field_70165_t;
                            this.waypointY = entity.field_70163_u;
                            this.waypointZ = entity.field_70161_v;
                        }
                    }
                }
            }
        }

    }

    protected void func_70623_bb() {
    }

    protected void func_85033_bc() {
        List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)1.0F, (double)1.0F, (double)1.0F));
        if (list != null && !list.isEmpty()) {
            for(int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                if (entity != null && entity instanceof EntityLivingBase && !(entity instanceof EntityTitan) && !(entity instanceof EntityTitanSpirit) && !(entity instanceof EntityTitanPart)) {
                    entity.field_70172_ad = 0;
                    double mx = this.field_70165_t - entity.field_70165_t;
                    double my = this.field_70163_u + (double)4.0F - entity.field_70163_u;
                    double mz = this.field_70161_v - entity.field_70161_v;
                    float f2 = MathHelper.func_76133_a(mx * mx + my * my + mz * mz);
                    entity.field_70159_w += mx / (double)f2 * 0.9 * 0.9;
                    entity.field_70181_x += my / (double)f2 * 0.9 * 0.9;
                    entity.field_70179_y += mz / (double)f2 * 0.9 * 0.9;
                    ((EntityLivingBase)entity).func_70097_a(DamageSourceExtra.causeSoulStealingDamage(this), 100.0F);
                    ((EntityLivingBase)entity).func_70606_j(((EntityLivingBase)entity).func_110143_aJ() - 100.0F);
                    ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 100, 3));
                    ((EntityLivingBase)entity).func_82149_j(this);
                    if (((EntityLivingBase)entity).field_70725_aQ > 0) {
                        this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t, this.field_70163_u, this.field_70161_v, (double)1.0F, (double)0.0F, (double)0.0F);
                        this.func_85030_a("random.explode", 4.0F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 0.7F);
                        this.func_85030_a("thetitans:titanCreeperExplosion", 10.0F, this.func_70647_i() + 0.5F);
                        this.func_85030_a("mob.endermen.portal", 10.0F, this.func_70647_i() + 0.75F);
                        ((EntityLivingBase)entity).func_70106_y();
                        this.setTonnage(this.getTonnage() + ((EntityLivingBase)entity).func_110138_aP());
                    }
                }

                if (this.isVesselHunting() && entity != null && entity instanceof EntityItem) {
                    entity.field_70172_ad = 0;
                    double mx = this.field_70165_t - entity.field_70165_t;
                    double my = this.field_70163_u + (double)4.0F - entity.field_70163_u;
                    double mz = this.field_70161_v - entity.field_70161_v;
                    float f2 = MathHelper.func_76133_a(mx * mx + my * my + mz * mz);
                    entity.field_70159_w += mx / (double)f2 * 0.9 * 0.9;
                    entity.field_70181_x += my / (double)f2 * 0.9 * 0.9;
                    entity.field_70179_y += mz / (double)f2 * 0.9 * 0.9;
                    entity.func_70097_a(DamageSourceExtra.causeSoulStealingDamage(this), 100.0F);
                }
            }
        }

    }

    public boolean func_70067_L() {
        return false;
    }

    protected boolean func_70041_e_() {
        return false;
    }

    public boolean func_70104_M() {
        return false;
    }

    public boolean func_145773_az() {
        return true;
    }

    protected String func_70639_aQ() {
        switch (this.getSpiritType()) {
            case 1:
                return "thetitans:titanSilverfishLiving";
            case 2:
                return "thetitans:titanSpiderLiving";
            case 3:
                return "thetitans:titanSpiderLiving";
            case 4:
                return "thetitans:titanSkeletonLiving";
            case 5:
                return "thetitans:titanWitherSkeletonLiving";
            case 6:
                return "thetitans:titanZombieLiving";
            case 7:
                return "thetitans:titanCreeperLiving";
            case 8:
                return "thetitans:titanPigZombieLiving";
            case 9:
                return "thetitans:titanBlazeBreathe";
            case 10:
                return "thetitans:titanEnderColossusRoar";
            case 11:
                return "thetitans:titanGhastLiving";
            case 12:
                return "thetitans:witherzillaLiving";
            default:
                return "mob.wither/idle";
        }
    }

    protected String func_70621_aR() {
        return "";
    }

    protected String func_70673_aS() {
        return "";
    }

    protected float func_70599_aP() {
        return 6.0F;
    }

    protected void func_70665_d(DamageSource p_70665_1_, float p_70665_2_) {
    }

    public boolean func_85032_ar() {
        return true;
    }

    protected void func_70609_aI() {
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        return false;
    }
}
