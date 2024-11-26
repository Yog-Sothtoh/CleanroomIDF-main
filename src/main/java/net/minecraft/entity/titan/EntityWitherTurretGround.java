//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.command.IEntitySelector;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityWitherTurretGround extends EntityGolem implements IRangedAttackMob {
    public int durabilityLevel;
    public int ferocityLevel;
    public int maniacLevel;
    public int unstabilityLevel;
    public int shurakinLevel;
    public int unbreakingLevel;
    public int shootingTimer;
    public int shots = 14;
    private IEntitySelector attackEntitySelector = new IEntitySelector() {
        private EntityWitherTurretGround turret = EntityWitherTurretGround.this;

        public boolean func_82704_a(Entity p_180027_1_) {
            return p_180027_1_ instanceof EntityLivingBase && this.turret.canTargetEntity((EntityLivingBase)p_180027_1_) && p_180027_1_.func_70089_S() && p_180027_1_.field_70163_u <= this.turret.field_70163_u + (double)6.0F;
        }
    };

    public EntityWitherTurretGround(World worldIn) {
        super(worldIn);
        this.field_70178_ae = true;
        this.field_70156_m = true;
        this.func_70105_a(0.75F, 1.375F);
    }

    public void onKillCommand() {
        this.func_70609_aI();
    }

    @SideOnly(Side.CLIENT)
    public int func_70070_b(float p_70070_1_) {
        return 15728880;
    }

    public float func_70013_c(float p_70013_1_) {
        return 1.0F;
    }

    protected void func_70623_bb() {
    }

    public boolean func_70650_aV() {
        return true;
    }

    protected boolean canTargetEntity(EntityLivingBase entity) {
        if (this.isPlayerCreated()) {
            return !(entity instanceof EntityTitanSpirit) && !(entity instanceof EntityPlayer) && !(entity instanceof EntityGolem) && !(entity instanceof EntityAgeable) && !(entity instanceof EntityIronGolemTitan) && !(entity instanceof EntitySnowGolemTitan) && !(entity instanceof EntityAnimal);
        } else {
            return !(entity instanceof EntityTitanSpirit) && entity instanceof EntityLivingBase && entity.func_70668_bt() != EnumCreatureAttribute.UNDEAD;
        }
    }

    public int func_70658_aO() {
        int i = 0 + this.unbreakingLevel * 6;
        if (i > 20) {
            i = 20;
        }

        return i;
    }

    public EnumCreatureAttribute func_70668_bt() {
        return EnumCreatureAttribute.UNDEAD;
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)4000.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a((double)32.0F);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
    }

    protected boolean func_70041_e_() {
        return false;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, (byte)0);
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return !this.isPlayerCreated() || p_70686_1_ != EntityPlayer.class && p_70686_1_ != EntityAgeable.class && p_70686_1_ != EntityGolem.class;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.shots <= 0 && this.shootingTimer <= 10) {
            this.shots = 14;
        }

        this.field_70761_aq = this.field_70177_z = this.field_70759_as;
        this.field_70122_E = true;
        this.field_70160_al = false;
        this.field_70158_ak = true;
        this.field_70156_m = true;
        this.field_70178_ae = true;
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        if (this.field_70173_aa % 20 == 0) {
            this.func_70691_i(1.0F + (float)this.durabilityLevel);
        }

        if (!this.field_70170_p.field_72995_K) {
            int i = MathHelper.func_76128_c(this.field_70165_t);
            int j = MathHelper.func_76128_c(this.field_70163_u - (double)1.0F);
            int k = MathHelper.func_76128_c(this.field_70161_v);
            if (this.field_70170_p.func_147439_a(i, j, k) != Blocks.field_150357_h) {
                this.field_70170_p.func_147449_b(i, j, k, Blocks.field_150357_h);
            }
        }

        double d8 = (double)15.0F;
        Vec3 vec3 = this.func_70676_i(1.0F);
        double dx = vec3.field_72450_a * d8;
        double dz = vec3.field_72449_c * d8;
        List list11 = this.field_70170_p.func_72839_b(this, this.func_70046_E().func_72314_b((double)16.0F, (double)16.0F, (double)16.0F).func_72317_d(dx, (double)-8.0F, dz));
        if (list11 != null && !list11.isEmpty() && this.func_70638_az() == null) {
            for(int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (entity instanceof EntityLivingBase && entity != null && entity.func_70089_S() && this.func_70638_az() == null && this.canTargetEntity((EntityLivingBase)entity) && this.func_70685_l(entity) && entity.field_70163_u <= this.field_70163_u + (double)6.0F) {
                    this.func_70624_b((EntityLivingBase)entity);
                } else {
                    list11.remove(entity);
                }
            }
        }

        if (this.func_70638_az() != null) {
            if (!this.field_70170_p.field_72995_K) {
                this.func_82196_d(this.func_70638_az(), 1.0F);
                this.func_82196_d(this.func_70638_az(), 1.0F);
            }

            this.func_70671_ap().func_75651_a(this.func_70638_az(), 20.0F, 180.0F);
            if (!this.func_70638_az().func_70089_S() || this.func_70638_az().field_70128_L || this.func_70638_az().field_70163_u > this.field_70163_u + (double)8.0F || this.func_70638_az().func_70068_e(this) > (double)1024.0F || !this.func_70685_l(this.func_70638_az())) {
                this.func_70624_b((EntityLivingBase)null);
            }

            if (!this.canTargetEntity(this.func_70638_az())) {
                this.func_70624_b((EntityLivingBase)null);
            }
        }

    }

    public void func_70071_h_() {
        super.func_70071_h_();

        for(int j = 0; j < 3; ++j) {
            double d10 = this.func_82214_u(j);
            double d2 = this.func_82208_v(j);
            double d4 = this.func_82213_w(j);
            this.field_70170_p.func_72869_a("smoke", d10 + this.field_70146_Z.nextGaussian() * (double)0.3F, d2 + this.field_70146_Z.nextGaussian() * (double)0.3F, d4 + this.field_70146_Z.nextGaussian() * (double)0.3F, (double)0.0F, (double)0.0F, (double)0.0F);
        }

        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        int i = MathHelper.func_76128_c(this.field_70165_t);
        int j = MathHelper.func_76128_c(this.field_70163_u);
        int k = MathHelper.func_76128_c(this.field_70161_v);
        this.field_70159_w = (double)0.0F;
        this.field_70181_x = (double)0.0F;
        this.field_70179_y = (double)0.0F;
        if (this.shootingTimer >= 0) {
            --this.shootingTimer;
        }

        if (this.shootingTimer <= 0) {
            this.shootingTimer = 0;
        }

    }

    public void fall(float distance, float damageMultiplier) {
    }

    public void func_70014_b(NBTTagCompound tagCompound) {
        tagCompound.func_74757_a("PlayerCreated", this.isPlayerCreated());
        tagCompound.func_74768_a("Ench1Level", this.durabilityLevel);
        tagCompound.func_74768_a("Ench2Level", this.ferocityLevel);
        tagCompound.func_74768_a("Ench3Level", this.maniacLevel);
        tagCompound.func_74768_a("Ench4Level", this.unstabilityLevel);
        tagCompound.func_74768_a("Ench5Level", this.shurakinLevel);
        tagCompound.func_74768_a("Ench6Level", this.unbreakingLevel);
    }

    public void func_70037_a(NBTTagCompound tagCompund) {
        if (tagCompund.func_150297_b("Ench1Level", 99)) {
            this.durabilityLevel = tagCompund.func_74762_e("Ench1Level");
        }

        if (tagCompund.func_150297_b("Ench2Level", 99)) {
            this.ferocityLevel = tagCompund.func_74762_e("Ench2Level");
        }

        if (tagCompund.func_150297_b("Ench3Level", 99)) {
            this.maniacLevel = tagCompund.func_74762_e("Ench3Level");
        }

        if (tagCompund.func_150297_b("Ench4Level", 99)) {
            this.unstabilityLevel = tagCompund.func_74762_e("Ench4Level");
        }

        if (tagCompund.func_150297_b("Ench5Level", 99)) {
            this.shurakinLevel = tagCompund.func_74762_e("Ench5Level");
        }

        if (tagCompund.func_150297_b("Ench6Level", 99)) {
            this.unbreakingLevel = tagCompund.func_74762_e("Ench6Level");
        }

        this.setPlayerCreated(tagCompund.func_74767_n("PlayerCreated"));
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

    private double func_82214_u(int p_82214_1_) {
        if (p_82214_1_ <= 0) {
            return this.field_70165_t;
        } else {
            float f = (this.field_70761_aq + (float)(180 * (p_82214_1_ - 1))) / 180.0F * (float)Math.PI;
            float f1 = MathHelper.func_76134_b(f);
            return this.field_70165_t + (double)f1 * 1.2;
        }
    }

    private double func_82208_v(int p_82208_1_) {
        return p_82208_1_ <= 0 ? this.field_70163_u + (double)0.5F : this.field_70163_u + 1.15;
    }

    private double func_82213_w(int p_82213_1_) {
        if (p_82213_1_ <= 0) {
            return this.field_70161_v;
        } else {
            float f = (this.field_70761_aq + (float)(180 * (p_82213_1_ - 1))) / 180.0F * (float)Math.PI;
            float f1 = MathHelper.func_76126_a(f);
            return this.field_70161_v + (double)f1 * 1.2;
        }
    }

    private void launchWitherSkullToEntity(int p_82216_1_, EntityLivingBase p_82216_2_) {
        if (!(p_82216_2_.func_70068_e(this) > (double)900.0F) && !(p_82216_2_.field_70163_u >= this.field_70163_u + (double)5.0F)) {
            this.launchWitherSkullToCoords(p_82216_1_, p_82216_2_.field_70165_t, p_82216_2_.field_70163_u + (double)0.5F, p_82216_2_.field_70161_v, false);
        } else {
            this.launchWitherSkullToCoords(p_82216_1_, p_82216_2_.field_70165_t + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F), p_82216_2_.field_70163_u + (double)0.5F, p_82216_2_.field_70161_v + (this.field_70146_Z.nextDouble() * (double)2.0F - (double)1.0F), false);
        }

    }

    private void launchWitherSkullToCoords(int p_82209_1_, double p_82209_2_, double p_82209_4_, double p_82209_6_, boolean p_82209_8_) {
        if (this.shootingTimer <= 0) {
            this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "random.explode", 0.15F, (1.0F + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2F) * 1.8F);
            this.func_85030_a("thetitans:turretShoot2", 3.0F, 1.0F);
            double d3 = this.func_82214_u(1);
            double d4 = this.func_82208_v(1);
            double d5 = this.func_82213_w(1);
            double d6 = p_82209_2_ - d3;
            double d7 = p_82209_4_ - d4;
            double d8 = p_82209_6_ - d5;
            EntityBulletWitherSkull entitywitherskull = new EntityBulletWitherSkull(this.field_70170_p, this, d6, d7, d8);
            if (p_82209_8_) {
                entitywitherskull.func_82343_e(true);
            }

            entitywitherskull.extraDamage = this.ferocityLevel * 2;
            entitywitherskull.explosivePower = (int)((float)this.unstabilityLevel * 0.75F);
            entitywitherskull.speedFactor = (float)this.shurakinLevel * 0.1F;
            entitywitherskull.field_70163_u = d4;
            entitywitherskull.field_70165_t = d3;
            entitywitherskull.field_70161_v = d5;
            this.field_70170_p.func_72838_d(entitywitherskull);
            this.func_85030_a("thetitans:turretShoot2", 6.0F, 1.0F);
            double d31 = this.func_82214_u(2);
            double d41 = this.func_82208_v(2);
            double d51 = this.func_82213_w(2);
            double d61 = p_82209_2_ - d31;
            double d71 = p_82209_4_ - d41;
            double d81 = p_82209_6_ - d51;
            EntityBulletWitherSkull entitywitherskull1 = new EntityBulletWitherSkull(this.field_70170_p, this, d61, d71, d81);
            if (p_82209_8_) {
                entitywitherskull1.func_82343_e(true);
            }

            entitywitherskull1.extraDamage = this.ferocityLevel * 2;
            entitywitherskull1.explosivePower = (int)((float)this.unstabilityLevel * 0.75F);
            entitywitherskull1.speedFactor = (float)this.shurakinLevel * 0.1F;
            entitywitherskull1.field_70163_u = d41;
            entitywitherskull1.field_70165_t = d31;
            entitywitherskull1.field_70161_v = d51;
            this.field_70170_p.func_72838_d(entitywitherskull1);
            --this.shots;
            --this.shots;
            if (this.shots > 0) {
                this.shootingTimer = 2;
            } else {
                this.shootingTimer = 14 - this.maniacLevel * 4;

                for(int j = 0; j < 3; ++j) {
                    double d10 = this.func_82214_u(j);
                    double d2 = this.func_82208_v(j);
                    double d24 = this.func_82213_w(j);
                    this.field_70170_p.func_72869_a("largesmoke", d10 + this.field_70146_Z.nextGaussian() * (double)0.3F, d2 + this.field_70146_Z.nextGaussian() * (double)0.3F, d24 + this.field_70146_Z.nextGaussian() * (double)0.3F, (double)0.0F, (double)0.0F, (double)0.0F);
                }
            }

            int i = MathHelper.func_76128_c(this.field_70165_t);
            int j = MathHelper.func_76128_c(this.field_70163_u - (double)1.0F);
            int k = MathHelper.func_76128_c(this.field_70161_v);
            this.field_70170_p.func_147449_b(i, j, k, Blocks.field_150426_aN);
        }

    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (this.func_85032_ar()) {
            return false;
        } else if (!(source.func_76346_g() instanceof EntityWitherTurretMortar) && !(source.func_76346_g() instanceof EntityWitherTurretGround) && !(source.func_76346_g() instanceof EntityWitherTurret)) {
            if (source != DamageSource.field_82728_o && source != DamageSource.field_76377_j && source != DamageSource.field_76372_a && source != DamageSource.field_76371_c && source != DamageSourceExtra.lightningBolt && source != DamageSource.field_76370_b && source != DamageSource.field_76376_m && source != DamageSource.field_82727_n && source != DamageSource.field_82729_p && source != DamageSource.field_76369_e && source != DamageSource.field_76367_g) {
                Entity entity = source.func_76346_g();
                if (entity instanceof EntityLivingBase && !this.func_85032_ar()) {
                    List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b((double)100.0F, (double)100.0F, (double)100.0F));

                    for(int i = 0; i < list.size(); ++i) {
                        Entity entity1 = (Entity)list.get(i);
                        if (entity1 instanceof EntityWitherTurretGround) {
                            EntityWitherTurretGround entitypigzombie = (EntityWitherTurretGround)entity1;
                            entitypigzombie.func_70624_b((EntityLivingBase)entity);
                            entitypigzombie.func_70604_c((EntityLivingBase)entity);
                        }

                        this.func_70624_b((EntityLivingBase)entity);
                        this.func_70604_c((EntityLivingBase)entity);
                        this.shootingTimer -= 4;
                    }
                }

                return super.func_70097_a(source, amount);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
        this.launchWitherSkullToEntity(1, p_82196_1_);
        this.func_70671_ap().func_75651_a(p_82196_1_, 180.0F, 180.0F);
    }

    protected String func_70639_aQ() {
        return "mob.wither.idle";
    }

    protected String func_70621_aR() {
        return "mob.wither.hurt";
    }

    protected String func_70673_aS() {
        return this.isPlayerCreated() ? "mob.wither.hurt" : "mob.wither.death";
    }

    protected void func_70609_aI() {
        this.func_70106_y();
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
            if (this.isPlayerCreated()) {
                ItemStack goodTurret = new ItemStack(TitanItems.goodTurret2);
                if (this.durabilityLevel > 0) {
                    goodTurret.func_77966_a(TheTitans.turretEnchant1, this.durabilityLevel);
                }

                if (this.ferocityLevel > 0) {
                    goodTurret.func_77966_a(TheTitans.turretEnchant2, this.ferocityLevel);
                }

                if (this.maniacLevel > 0) {
                    goodTurret.func_77966_a(TheTitans.turretEnchant3, this.maniacLevel);
                }

                if (this.unstabilityLevel > 0) {
                    goodTurret.func_77966_a(TheTitans.turretEnchant4, this.unstabilityLevel);
                }

                if (this.shurakinLevel > 0) {
                    goodTurret.func_77966_a(TheTitans.turretEnchant5, this.shurakinLevel);
                }

                if (this.unbreakingLevel > 0) {
                    goodTurret.func_77966_a(Enchantment.field_77347_r, this.unbreakingLevel);
                }

                this.func_70099_a(goodTurret, 3.0F);
            } else {
                this.func_70099_a(new ItemStack(Items.field_151144_bL, 1, 1), 6.0F);
                this.func_70099_a(new ItemStack(Items.field_151144_bL, 1, 1), 3.0F);
            }

            int i = 10;

            while(i > 0) {
                int j = EntityXPOrb.func_70527_a(i);
                i -= j;
                this.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v, j));
            }

            i = 20;

            while(i > 0) {
                int j = EntityXPOrb.func_70527_a(i);
                i -= j;
                this.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v, j));
            }
        }

        int i = MathHelper.func_76128_c(this.field_70165_t);
        int j = MathHelper.func_76128_c(this.field_70163_u - (double)1.0F);
        int k = MathHelper.func_76128_c(this.field_70161_v);
        this.field_70170_p.func_147449_b(i, j, k, Blocks.field_150357_h);
        if (!this.field_70170_p.field_72995_K) {
            this.func_85030_a("thetitans:turretDeath2", 6.0F, 1.0F);
            this.func_85030_a("thetitans:turretDeath2", 6.0F, 1.0F);
            this.func_85030_a("thetitans:turretDeath2", 6.0F, 1.0F);
            this.func_85030_a("thetitans:turretDeath2", 6.0F, 1.0F);
            this.func_85030_a("thetitans:turretDeath2", 6.0F, 1.0F);
            this.func_85030_a("thetitans:turretDeath2", 6.0F, 1.0F);
            this.func_85030_a("thetitans:turretDeath2", 6.0F, 1.0F);
            this.func_85030_a("thetitans:turretDeath2", 6.0F, 1.0F);
            this.field_70170_p.func_72876_a((Entity)null, this.field_70165_t, this.field_70163_u - (double)1.0F, this.field_70161_v, 2.0F, true);
        }

    }

    public float func_70047_e() {
        return 1.1F;
    }

    public AxisAlignedBB func_70114_g(Entity entityIn) {
        return entityIn.field_70121_D;
    }

    public AxisAlignedBB func_70046_E() {
        return this.field_70121_D;
    }

    public boolean func_70067_L() {
        return true;
    }

    public boolean func_70104_M() {
        return false;
    }

    public boolean isEnchanted() {
        return this.durabilityLevel > 0 || this.ferocityLevel > 0 || this.maniacLevel > 0 || this.unstabilityLevel > 0 || this.shurakinLevel > 0 || this.unbreakingLevel > 0;
    }

    public boolean shouldShowEnchants() {
        return this.isEnchanted();
    }

    protected void func_85033_bc() {
    }

    public void func_70653_a(Entity p_70653_1_, float p_70653_2_, double p_70653_3_, double p_70653_5_) {
    }

    public void func_70024_g(double x, double y, double z) {
    }

    public void func_70091_d(double x, double y, double z) {
    }

    protected int func_70682_h(int p_70682_1_) {
        return p_70682_1_;
    }
}
