//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEndPortal;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.effect.EntityWeatherEffect;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.UserListBansEntry;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanBlocks;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.theTitans.world.WorldProviderVoid;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityWitherzilla extends EntityTitan implements IRangedAttackMob {
    private float[] field_82220_d = new float[2];
    private float[] field_82221_e = new float[2];
    private float[] field_82217_f = new float[2];
    private float[] field_82218_g = new float[2];
    private int[] field_82223_h = new int[2];
    private int[] field_82224_i = new int[2];
    private int blockBreakCounter;
    public int affectTicks;
    private int attackTimer;
    private int omegacounter;
    ArrayList allPlayerList;
    private static final IEntitySelector attackEntitySelector = new IEntitySelector() {
        public boolean func_82704_a(Entity p_180027_1_) {
            return !(p_180027_1_ instanceof EntityTitanSpirit) && !(p_180027_1_ instanceof EntityWitherzillaMinion) && !(p_180027_1_ instanceof EntityWitherTurret) && !(p_180027_1_ instanceof EntityWitherTurretGround) && !(p_180027_1_ instanceof EntityWitherTurretMortar);
        }
    };

    public EntityWitherzilla(World worldIn) {
        super(worldIn);
        this.allPlayerList = Lists.newArrayList(this.field_70170_p.field_73010_i);
        this.func_70105_a(64.0F, 224.0F);
        this.field_70145_X = true;
        this.field_70728_aV = 5000000;
        this.func_85030_a("thetitans:witherzillaSpawn", Float.MAX_VALUE, 1.0F);
    }

    protected void applyEntityAI() {
        this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, attackEntitySelector));
    }

    public int getMinionCap() {
        return 1000;
    }

    public boolean alreadyHasAName() {
        return true;
    }

    public boolean func_70067_L() {
        return true;
    }

    protected void func_70069_a(float p_70069_1_) {
    }

    public int getMinionSpawnRate() {
        return TheTitans.WitherzillaMinionSpawnrate;
    }

    public int getParticleCount() {
        return 100;
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.5F);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(Double.MAX_VALUE);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a((double)1.0F);
    }

    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.GOD;
    }

    public float func_70603_bj() {
        return this.isInOmegaForm() ? 128.0F : 64.0F;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(17, new Integer(0));
        this.field_70180_af.func_75682_a(18, new Integer(0));
        this.field_70180_af.func_75682_a(19, new Integer(0));
    }

    public int getTalkInterval2() {
        return 20;
    }

    public void func_70030_z() {
        super.func_70030_z();
        this.field_70170_p.field_72984_F.func_76320_a("zillaBaseTick");
        if (this.isArmored() && this.func_70089_S() && this.field_70146_Z.nextInt(50) < this.field_70757_a++) {
            this.field_70757_a = -30;
            this.playLivingSound2();
        }

        this.field_70170_p.field_72984_F.func_76319_b();
    }

    public void playLivingSound2() {
        String s = this.func_70639_aQ();
        if (s != null) {
            this.func_85030_a(s, this.func_70599_aP(), 0.9F);
        }

    }

    protected String getLivingSound2() {
        return "thetitans:witherzillaLiving2";
    }

    protected String func_70639_aQ() {
        return "thetitans:witherzillaLiving";
    }

    protected String func_70621_aR() {
        return "thetitans:witherzillaGrunt";
    }

    protected String func_70673_aS() {
        return "thetitans:witherzillaDeath";
    }

    public boolean func_70601_bi() {
        return false;
    }

    public boolean canBeHurtByPlayer() {
        return this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && !this.func_85032_ar();
    }

    protected void func_70076_C() {
        this.field_70170_p.func_82739_e(1013, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
        if (!(this.field_70170_p.field_73011_w instanceof WorldProviderVoid) && !(this.field_70170_p.field_73011_w instanceof WorldProviderEnd)) {
            this.teleportRandomly(false);
        } else {
            this.teleportRandomly(true);
        }

    }

    public void doLightningAttackTo(Entity entity) {
        if (entity != null && entity.func_70089_S() && !(entity instanceof EntityFX) && !(entity instanceof EntityTitanPart)) {
            if (entity instanceof EntityPlayer) {
                ((EntityPlayer)entity).func_145747_a(new ChatComponentText("§k" + this.field_70146_Z.nextInt(1234567890)));
            }

            if (entity instanceof EntityLivingBase && !(entity instanceof EntityTitan) && (entity.field_70131_O >= 6.0F || entity.func_85032_ar() || entity instanceof EntityEnderColossusCrystal)) {
                ((EntityLivingBase)entity).func_70645_a(DamageSource.field_76380_i);
                ((EntityLivingBase)entity).func_70106_y();
                ((EntityLivingBase)entity).func_70606_j(0.0F);
                ((EntityLivingBase)entity).func_70097_a(DamageSource.field_76380_i, Float.MAX_VALUE);
            }

            if (entity != null && entity instanceof EntityLivingBase && (this.affectTicks >= 600 || entity.field_70131_O >= 6.0F) && !(entity instanceof EntityTitan)) {
                ((EntityLivingBase)entity).func_70606_j(0.0F);

                for(int i = 0; i < 50; ++i) {
                    this.attackChoosenEntity(entity, (float)Integer.MAX_VALUE, 0);
                }
            }

            if (entity instanceof EntityTitan) {
                ((EntityTitan)entity).setInvulTime(((EntityTitan)entity).getInvulTime() - 20);
            } else {
                entity.field_70181_x += (double)0.5F;
            }

            this.attackChoosenEntity(entity, 20.0F, 0);
            if (entity instanceof EntityMob) {
                ((EntityLivingBase)entity).func_70604_c(this);
            }

            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)(this.field_70146_Z.nextFloat() * this.func_70047_e()), this.field_70161_v, this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat()));
            this.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_70170_p, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat()));
            entity.field_70172_ad = 1;
        }

    }

    public void func_70624_b(EntityLivingBase p_70624_1_) {
        if (this.field_70170_p.field_73011_w instanceof WorldProviderVoid && p_70624_1_ != null && this.field_70165_t == (double)0.0F && this.field_70163_u == (double)200.0F && this.field_70161_v == (double)0.0F) {
            EntityLivingBase var2 = null;
        } else {
            super.func_70624_b(p_70624_1_);
        }

    }

    public void func_70636_d() {
        if (!(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
            WorldServer worldserver = MinecraftServer.func_71276_C().field_71305_c[0];
            WorldInfo worldinfo = worldserver.func_72912_H();
            if (this.func_70638_az() != null && this.func_70638_az() instanceof EntityEnderColossus) {
                worldinfo.func_76080_g(0);
                worldinfo.func_76090_f(0);
                worldinfo.func_76084_b(false);
                worldinfo.func_76069_a(false);
            } else {
                worldinfo.func_76080_g(9999999);
                worldinfo.func_76090_f(1000000);
                worldinfo.func_76084_b(true);
                worldinfo.func_76069_a(true);
            }
        }

        if (!(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
            if (this.field_70146_Z.nextInt(2) == 0) {
                for(int l = 0; l < 20; ++l) {
                    int i = MathHelper.func_76128_c(this.field_70165_t);
                    int j = MathHelper.func_76128_c(this.field_70163_u);
                    int k = MathHelper.func_76128_c(this.field_70161_v);
                    int i1 = i + MathHelper.func_76136_a(this.field_70146_Z, 10, 100) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int j1 = j + MathHelper.func_76136_a(this.field_70146_Z, 10, 100) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    int k1 = k + MathHelper.func_76136_a(this.field_70146_Z, 10, 100) * MathHelper.func_76136_a(this.field_70146_Z, -1, 1);
                    EntityGammaLightning entitylightning = new EntityGammaLightning(this.field_70170_p, (double)i1, (double)j1, (double)k1, this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat());
                    if (this.field_70146_Z.nextInt(5) == 0 && World.func_147466_a(this.field_70170_p, i1, j1 - 1, k1) && this.field_70170_p.func_72855_b(entitylightning.field_70121_D) && this.field_70170_p.func_72945_a(entitylightning, entitylightning.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(entitylightning.field_70121_D)) {
                        this.field_70170_p.func_72942_c(entitylightning);
                    }
                }
            }
        } else {
            if (this.func_70092_e((double)0.0F, (double)200.0F, (double)0.0F) > (double)50000.0F) {
                this.func_70107_b((double)0.0F, (double)200.0F, (double)0.0F);
            }

            ArrayList listp = Lists.newArrayList(this.field_70170_p.field_72996_f);
            if (!this.field_70170_p.field_72995_K && listp != null && !listp.isEmpty() && this.field_70146_Z.nextInt(4) == 0) {
                for(int i1 = 0; i1 < listp.size(); ++i1) {
                    Entity entity = (Entity)listp.get(i1);
                    if (entity != null && entity.func_70089_S()) {
                        if (entity instanceof EntityWitherTurret && !((EntityWitherTurret)entity).isPlayerCreated()) {
                            this.func_70107_b((double)0.0F, (double)200.0F, (double)0.0F);
                            this.field_70761_aq = this.field_70177_z = this.field_70759_as = 0.0F;
                            this.func_70624_b((EntityLivingBase)null);
                        }

                        if (entity instanceof EntityWitherTurretGround && !((EntityWitherTurretGround)entity).isPlayerCreated()) {
                            this.func_70107_b((double)0.0F, (double)200.0F, (double)0.0F);
                            this.field_70761_aq = this.field_70177_z = this.field_70759_as = 0.0F;
                            this.func_70624_b((EntityLivingBase)null);
                        }

                        if (entity instanceof EntityWitherTurretMortar && !((EntityWitherTurretMortar)entity).isPlayerCreated()) {
                            this.func_70107_b((double)0.0F, (double)200.0F, (double)0.0F);
                            this.field_70761_aq = this.field_70177_z = this.field_70759_as = 0.0F;
                            this.func_70624_b((EntityLivingBase)null);
                        }
                    }
                }
            }
        }

        if (this.affectTicks >= 800) {
            this.func_82142_c(true);
        } else {
            this.func_82142_c(false);
        }

        --this.omegacounter;
        this.func_70105_a(this.omegacounter > 0 ? 128.0F : 64.0F, this.omegacounter > 0 ? 448.0F : 224.0F);
        this.field_70170_p.func_72877_b(18000L);
        ArrayList listp = Lists.newArrayList(this.field_70170_p.field_73010_i);
        if (listp != null && !listp.isEmpty() && this.field_70146_Z.nextInt(4) == 0) {
            for(int i1 = 0; i1 < listp.size(); ++i1) {
                Entity entity = (Entity)listp.get(i1);
                if (entity != null && entity instanceof EntityPlayer && this.field_70146_Z.nextInt(100) == 0) {
                    this.func_70642_aH();
                    if (!(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
                        ((EntityPlayer)entity).func_70097_a((new DamageSource("generic")).func_76359_i().func_76348_h().func_151518_m(), 10.0F);
                        ((EntityPlayer)entity).func_145747_a(new ChatComponentText(StatCollector.func_74838_a("dialog.witherzilla.taunt." + this.field_70146_Z.nextInt(6))));
                    } else {
                        ((EntityPlayer)entity).func_145747_a(new ChatComponentText(StatCollector.func_74838_a("dialog.witherzilla.plead." + this.field_70146_Z.nextInt(6))));
                    }
                }
            }
        }

        List list = this.field_70170_p.field_72996_f;
        if (list != null && !list.isEmpty() && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
            for(int i1 = 0; i1 < list.size(); ++i1) {
                Entity entity = (Entity)list.get(i1);
                if (entity != null && entity.func_70089_S() && this.func_70638_az() != null && entity instanceof EntityWitherzillaMinion) {
                    ((EntityWitherzillaMinion)entity).func_70624_b(this.func_70638_az());
                }

                if (entity != null && entity.func_70089_S() && !(entity instanceof EntityWitherzillaMinion) && !(entity instanceof EntityWitherSkull) && !(entity instanceof EntityWitherTurret) && !(entity instanceof EntityWitherTurretGround) && !(entity instanceof EntityWitherTurretMortar) && !(entity instanceof EntityWeatherEffect) && !(entity instanceof EntityWitherzillaMinion) && !(entity instanceof EntityTitan) && !(entity instanceof EntityTitanSpirit) && !(entity instanceof EntityPlayer)) {
                    if (this.getInvulTime() > 1) {
                        if (entity instanceof EntityLivingBase) {
                            if (entity instanceof EntityLiving) {
                                ((EntityLiving)entity).func_70661_as().func_75499_g();
                            }

                            entity.field_70181_x = 0.05 - this.field_70181_x * 0.2;
                            ((EntityLivingBase)entity).field_70172_ad = (int)this.field_70146_Z.nextGaussian() * 20;
                            ((EntityLivingBase)entity).field_70701_bs = (float)this.field_70146_Z.nextGaussian();
                            ((EntityLivingBase)entity).field_70702_br = (float)this.field_70146_Z.nextGaussian();
                            ((EntityLivingBase)entity).field_70761_aq = ((EntityLivingBase)entity).field_70177_z = ((EntityLivingBase)entity).field_70759_as += (float)this.field_70146_Z.nextGaussian() * 10.0F;
                        } else {
                            entity.field_70159_w = this.field_70146_Z.nextGaussian() * (double)0.5F;
                            entity.field_70181_x = this.field_70146_Z.nextGaussian() * (double)0.5F;
                            entity.field_70179_y = this.field_70146_Z.nextGaussian() * (double)0.5F;
                            entity.field_70177_z += 10.0F;
                            entity.field_70172_ad = (int)this.field_70146_Z.nextGaussian() * 20;
                        }
                    } else {
                        this.doLightningAttackTo(entity);
                    }
                }
            }
        }

        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(Double.MAX_VALUE);
        if (TheTitans.NightmareMode) {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)2.0E7F + (double)this.getExtraPower() * (double)2.0E7F);
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)1.0E7F + (double)this.getExtraPower() * (double)1.0E7F);
        }

        if (this.field_70173_aa % 3 + this.field_70146_Z.nextInt(3) != 0 && this.getInvulTime() < 1000) {
            this.func_94058_c("§l" + StatCollector.func_74838_a("entity.WitherBossTitan.name"));
        } else {
            this.func_94058_c("§kRegnator");
        }

        if (this.func_70638_az() != null && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid) && (this.affectTicks >= 600 || this.func_70638_az().field_70131_O > 6.0F && !(this.func_70638_az() instanceof EntityTitan))) {
            this.doLightningAttackTo(this.func_70638_az());
            if (this.isInOmegaForm()) {
                for(int i1 = 0; i1 < 19; ++i1) {
                    this.doLightningAttackTo(this.func_70638_az());
                    this.func_70638_az().func_70097_a(DamageSource.field_76380_i, 1.0F);
                }
            }
        }

        ++this.affectTicks;
        if (this.affectTicks >= 1010) {
            this.affectTicks = 0;
        }

        if (this.func_70638_az() != null && !this.func_70638_az().func_70089_S()) {
            this.func_70624_b((EntityLivingBase)null);
        }

        if (this.numMinions < this.getMinionCap() && this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K) {
            EntityWitherzillaMinion entitychicken = new EntityWitherzillaMinion(this.field_70170_p);
            entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v, this.field_70177_z, 0.0F);
            entitychicken.func_82206_m();
            this.field_70170_p.func_72838_d(entitychicken);
            entitychicken.func_70024_g((double)(-MathHelper.func_76126_a(this.field_70759_as * (float)Math.PI / 180.0F) * 3.0F), (double)0.0F, (double)(MathHelper.func_76134_b(this.field_70759_as * (float)Math.PI / 180.0F) * 3.0F));
            ++this.numMinions;
        }

        if (this.field_70146_Z.nextInt(120) == 0 && this.func_70638_az() != null && !this.field_70170_p.field_72995_K) {
            if (TheTitans.NightmareMode) {
                this.field_70170_p.func_72885_a(this, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 14.0F, true, true);
            } else {
                this.field_70170_p.func_72885_a(this, this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, 7.0F, false, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
            }
        }

        if (!this.isArmored()) {
            this.field_70181_x *= 0.1;
        } else {
            this.field_70181_x *= 0.9;
        }

        if (!this.field_70170_p.field_72995_K && this.getWatchedTargetId(0) > 0) {
            Entity entity = this.field_70170_p.func_73045_a(this.getWatchedTargetId(0));
            if (entity != null) {
                double d0 = entity.field_70165_t - this.field_70165_t;
                double d1 = entity.field_70163_u + (this.isArmored() ? (double)2.0F : (double)12.0F) - this.field_70163_u;
                double d2 = entity.field_70161_v - this.field_70161_v;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                this.func_70671_ap().func_75651_a(entity, 180.0F, 40.0F);
                if (entity instanceof EntityLivingBase && d3 < (double)10000.0F) {
                    this.func_82196_d((EntityLivingBase)entity, 0.0F);
                }

                if (d3 > (double)64.0F) {
                    double d5 = (double)MathHelper.func_76133_a(d3);
                    this.field_70159_w += d0 / d5 * (double)1.5F - this.field_70159_w;
                    this.field_70181_x += d1 / d5 * (double)1.5F - this.field_70181_x;
                    this.field_70179_y += d2 / d5 * (double)1.5F - this.field_70179_y;
                    this.field_70761_aq = this.field_70177_z = (float)Math.atan2(this.field_70179_y, this.field_70159_w) * (180F / (float)Math.PI) - 90.0F;
                }
            }
        }

        super.func_70636_d();

        for(int i = 0; i < 2; ++i) {
            this.field_82218_g[i] = this.field_82221_e[i];
            this.field_82217_f[i] = this.field_82220_d[i];
        }

        for(int i = 0; i < 2; ++i) {
            int j = this.getWatchedTargetId(i + 1);
            Entity entity1 = null;
            if (j > 0) {
                entity1 = this.field_70170_p.func_73045_a(j);
            }

            if (entity1 != null) {
                double d1 = this.func_82214_u(i + 1);
                double d3 = this.func_82208_v(i + 1);
                double d5 = this.func_82213_w(i + 1);
                double d6 = entity1.field_70165_t - d1;
                double d7 = entity1.field_70163_u + (double)entity1.func_70047_e() - d3;
                double d8 = entity1.field_70161_v - d5;
                double d9 = (double)MathHelper.func_76133_a(d6 * d6 + d8 * d8);
                float f = (float)(Math.atan2(d8, d6) * (double)180.0F / Math.PI) - 90.0F;
                float f1 = (float)(-(Math.atan2(d7, d9) * (double)180.0F / Math.PI));
                this.field_82220_d[i] = this.func_82204_b(this.field_82220_d[i], f1, 5.0F);
                this.field_82221_e[i] = this.func_82204_b(this.field_82221_e[i], f, 5.0F);
            } else {
                if (this.field_70146_Z.nextInt(120) == 0) {
                    for(int var41 = 0; var41 < 36; ++var41) {
                        this.field_82220_d[i] = this.func_82204_b(this.field_82220_d[i], this.field_70146_Z.nextFloat() * 360.0F - 180.0F, 5.0F);
                    }
                }

                if (this.field_70146_Z.nextInt(120) == 0) {
                    for(int var42 = 0; var42 < 36; ++var42) {
                        this.field_82221_e[i] = this.func_82204_b(this.field_82221_e[i], this.field_70146_Z.nextFloat() * 360.0F - 180.0F, 5.0F);
                    }
                }
            }
        }

        this.shouldParticlesBeUpward = false;
        boolean flag = this.isArmored();

        for(int j = 0; j < 3; ++j) {
            double d10 = this.func_82214_u(j);
            double d2 = this.func_82208_v(j);
            double d4 = this.func_82213_w(j);

            for(int j1 = 0; j1 < 15; ++j1) {
                this.field_70170_p.func_72869_a("largesmoke", d10 + this.field_70146_Z.nextGaussian() * (double)32.0F, d2 + this.field_70146_Z.nextGaussian() * (double)32.0F, d4 + this.field_70146_Z.nextGaussian() * (double)32.0F, (double)0.0F, (double)0.0F, (double)0.0F);
            }

            if (flag && this.field_70170_p.field_73012_v.nextInt(4) == 0) {
                this.field_70170_p.func_72869_a("mobSpell", d10 + this.field_70146_Z.nextGaussian() * (double)32.0F, d2 + this.field_70146_Z.nextGaussian() * (double)32.0F, d4 + this.field_70146_Z.nextGaussian() * (double)32.0F, (double)0.7F, (double)0.7F, (double)0.5F);
            }
        }

        if (this.getInvulTime() > 0) {
            for(int j = 0; j < 3; ++j) {
                this.field_70170_p.func_72869_a("mobSpell", this.field_70165_t + this.field_70146_Z.nextGaussian() * (double)32.0F, this.field_70163_u + (double)(this.field_70146_Z.nextFloat() * 210.0F), this.field_70161_v + this.field_70146_Z.nextGaussian() * (double)32.0F, (double)0.7F, (double)0.7F, (double)0.9F);
            }
        }

        if (this.field_70170_p.field_72995_K) {
            for(int i1 = 0; i1 < this.getParticleCount(); ++i1) {
                this.field_70170_p.func_72869_a(this.getParticles(), this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N * (double)3.0F, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)210.0F, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N * (double)3.0F, (double)0.0F, (double)0.5F, (double)0.0F);
            }
        }

    }

    public boolean func_70652_k(Entity p_70652_1_) {
        if (!(p_70652_1_.field_70131_O >= 6.0F) && !(p_70652_1_ instanceof EntityTitan)) {
            return false;
        } else {
            float f = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
            int i = this.getKnockbackAmount();

            for(int it = 0; it < 10; ++it) {
                this.attackChoosenEntity(p_70652_1_, f, 2);
                if (p_70652_1_ instanceof EntityTitan && ((EntityTitan)p_70652_1_).getInvulTime() > 1) {
                    ((EntityTitan)p_70652_1_).setInvulTime(((EntityTitan)p_70652_1_).getInvulTime() - 20);
                }
            }

            return super.func_70652_k(p_70652_1_);
        }
    }

    protected void func_70619_bc() {
        --this.attackTimer;
        if (this.getInvulTime() > 0) {
            if (this.field_70173_aa % 1 == 0) {
                this.func_70691_i(this.func_110138_aP() / 800.0F);
            }

            int i = this.getInvulTime() - 1;
            this.setInvulTime(i);
            if (i <= 0) {
                this.blockBreakCounter = 1;
                this.field_70170_p.func_82739_e(1013, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                if (this.allPlayerList != null && !this.allPlayerList.isEmpty()) {
                    for(int i1 = 0; i1 < this.allPlayerList.size(); ++i1) {
                        Entity entity = (Entity)this.allPlayerList.get(i1);
                        if (entity instanceof EntityPlayer) {
                            this.field_70170_p.func_72980_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, "thetitans:witherzillaSpawn", 10.0F, 1.0F, false);
                        }
                    }
                }
            }
        } else {
            super.func_70619_bc();
            if (!(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
                this.omegacounter = 600;
            }

            if (this.field_70173_aa % 400 == 0 && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
                EntityPlayer entity = this.field_70170_p.func_72890_a(this, (double)-1.0F);
                if (this.allPlayerList != null && !this.allPlayerList.isEmpty() && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid) && this.func_70638_az() == null && this.field_70170_p.field_73011_w == entity.field_70170_p.field_73011_w) {
                    for(int i1 = 0; i1 < this.allPlayerList.size(); ++i1) {
                        this.teleportToEntity(entity, true);
                        if (!entity.field_71075_bZ.field_75102_a) {
                            this.func_70624_b(entity);
                        }
                    }
                }

                if (this.deathTicks <= 0 && this.allPlayerList != null && !this.allPlayerList.isEmpty() && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid) && this.field_70146_Z.nextInt(20) == 0 && this.func_70638_az() != null && this.func_70638_az() == entity && this.isArmored()) {
                    for(int i1 = 0; i1 < this.allPlayerList.size(); ++i1) {
                        if (!this.field_70170_p.field_72995_K) {
                            MinecraftServer minecraftserver = MinecraftServer.func_71276_C();
                            GameProfile gameprofile = minecraftserver.func_152358_ax().func_152655_a(entity.func_70005_c_());
                            EntityPlayerMP entityplayermp = minecraftserver.func_71203_ab().func_152612_a(entity.func_70005_c_());
                            if (entityplayermp != null && entity.func_70005_c_() != "Umbrella_Ghast") {
                                this.attackChoosenEntity(entity, (float)Integer.MAX_VALUE, 0);
                                entity.func_70106_y();
                                UserListBansEntry userlistbansentry = new UserListBansEntry(gameprofile, (Date)null, entity.func_70005_c_(), (Date)null, (String)null);
                                minecraftserver.func_71203_ab().func_152608_h().func_152687_a(userlistbansentry);
                                entityplayermp.field_71135_a.func_147360_c("You've been banned from this server by Witherzilla for being annoying.");
                            }
                        }
                    }
                }
            }

            if (this.func_70638_az() != null && this.canAttack() && this.func_70638_az() instanceof EntityLivingBase) {
                double d0 = this.func_70068_e(this.func_70638_az());
                if (d0 < (double)(this.field_70130_N * this.field_70130_N + this.func_70638_az().field_70130_N * this.func_70638_az().field_70130_N) + (double)6000.0F) {
                    this.func_71038_i();
                    this.func_70652_k(this.func_70638_az());
                }
            }

            if (this.func_70638_az() != null) {
                ArrayList listp = Lists.newArrayList(this.field_70170_p.field_73010_i);
                if (listp != null && !listp.isEmpty()) {
                    for(int i1 = 0; i1 < listp.size(); ++i1) {
                        Entity entity = (Entity)listp.get(i1);
                        if (entity != null && entity instanceof EntityPlayer && this.func_70638_az() instanceof EntityWitherzilla) {
                            ((EntityPlayer)entity).func_145747_a(new ChatComponentText("§l§kRegnator: There's another me. This is a paradox!"));
                        }
                    }
                }
            }

            if (this.field_70163_u <= (double)0.0F) {
                if (!(this.field_70170_p.field_73011_w instanceof WorldProviderVoid) && !(this.field_70170_p.field_73011_w instanceof WorldProviderEnd)) {
                    this.teleportRandomly(false);
                } else {
                    this.teleportRandomly(true);
                }
            }

            List list = this.field_70170_p.field_72996_f;
            if (list != null && !list.isEmpty()) {
                for(int i1 = 0; i1 < list.size(); ++i1) {
                    Entity entity = (Entity)list.get(i1);
                    if (!(this.field_70170_p.field_73011_w instanceof WorldProviderVoid) && entity != null && entity instanceof EntityPlayer && ((EntityPlayer)entity).func_70694_bm() != null && ((EntityPlayer)entity).func_70694_bm().func_77973_b() != TitanItems.ultimaBlade) {
                        ((EntityPlayer)entity).func_70669_a(((EntityPlayer)entity).func_70694_bm());
                        ((EntityPlayer)entity).func_70694_bm().field_77994_a = 0;
                        ((EntityPlayer)entity).func_71028_bD();
                        this.doLightningAttackTo(entity);
                    }

                    if (entity instanceof EntityAgeable || entity instanceof EntityAmbientCreature || entity instanceof EntityWaterMob) {
                        list.remove(entity);
                    }
                }
            }

            for(int i = 1; i < 3; ++i) {
                if (this.field_70173_aa >= this.field_82223_h[i - 1] && this.func_70638_az() != null) {
                    this.field_82223_h[i - 1] = this.field_70173_aa + this.field_70146_Z.nextInt(20);
                    int k2 = i - 1;
                    int l2 = this.field_82224_i[i - 1];
                    this.field_82224_i[k2] = this.field_82224_i[i - 1] + 1;
                    if (l2 > 15) {
                        for(int i11 = 0; i11 < 100; ++i11) {
                            float f = 100.0F;
                            float f1 = 20.0F;
                            double d0 = MathHelper.func_82716_a(this.field_70146_Z, this.field_70165_t - (double)f, this.field_70165_t + (double)f);
                            double d1 = MathHelper.func_82716_a(this.field_70146_Z, this.field_70163_u - (double)f1, this.field_70163_u + (double)f1);
                            double d2 = MathHelper.func_82716_a(this.field_70146_Z, this.field_70161_v - (double)f, this.field_70161_v + (double)f);
                            this.launchWitherSkullToCoords(i + 1, d0, d1, d2, true);
                        }

                        this.field_82224_i[i - 1] = 0;
                    }

                    int i1 = this.getWatchedTargetId(i);
                    if (i1 > 0) {
                        Entity entity = this.field_70170_p.func_73045_a(i1);
                        if (entity != null && entity.func_70089_S()) {
                            this.launchWitherSkullToEntity(i + 1, (EntityLivingBase)entity);
                            this.field_82223_h[i - 1] = this.field_70173_aa;
                            this.field_82224_i[i - 1] = 0;
                        } else {
                            this.func_82211_c(i, 0);
                        }
                    } else if (this.func_70638_az() != null && this.func_70638_az().func_70089_S()) {
                        this.func_82211_c(i, this.func_70638_az().func_145782_y());
                    } else {
                        this.func_82211_c(i, 0);
                    }
                }
            }

            if (this.func_70638_az() != null) {
                this.func_82211_c(0, this.func_70638_az().func_145782_y());
            } else {
                this.func_82211_c(0, 0);
            }

            if (this.blockBreakCounter > 0) {
                --this.blockBreakCounter;
                if (this.blockBreakCounter == 0 && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                    int i = MathHelper.func_76128_c(this.field_70163_u);
                    int i1 = MathHelper.func_76128_c(this.field_70165_t);
                    int j1 = MathHelper.func_76128_c(this.field_70161_v);
                    boolean flag = false;

                    for(int l1 = -32; l1 <= 32; ++l1) {
                        for(int i2 = -32; i2 <= 32; ++i2) {
                            for(int j = -32; j <= 246; ++j) {
                                int j2 = i1 + l1;
                                int k = i + j;
                                int l = j1 + i2;
                                Block block = this.field_70170_p.func_147439_a(j2, k, l);
                                if (!block.isAir(this.field_70170_p, j2, k, l) && block.func_149712_f(this.field_70170_p, j2, k, l) != -1.0F) {
                                    flag = this.field_70170_p.func_147480_a(j2, k, l, false) || flag;
                                }
                            }
                        }
                    }

                    if (flag) {
                        this.destroyBlocksInAABB(this.field_70121_D);
                        this.field_70170_p.func_72889_a((EntityPlayer)null, 1012, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
                    }
                }
            }
        }

    }

    public void onKillCommand() {
        ArrayList list11 = Lists.newArrayList(this.field_70170_p.field_73010_i);
        if (list11 != null && !list11.isEmpty()) {
            for(int i1 = 0; i1 < list11.size(); ++i1) {
                Entity entity = (Entity)list11.get(i1);
                if (entity != null && entity instanceof EntityPlayer) {
                    ((EntityPlayer)entity).func_145747_a(new ChatComponentText(StatCollector.func_74838_a("dialog.witherzilla.killattempt")));
                }
            }
        }

    }

    private double func_82214_u(int p_82214_1_) {
        return this.field_70165_t;
    }

    private double func_82208_v(int p_82208_1_) {
        return this.field_70163_u + (double)12.0F;
    }

    private double func_82213_w(int p_82213_1_) {
        return this.field_70161_v;
    }

    private float func_82204_b(float p_82204_1_, float p_82204_2_, float p_82204_3_) {
        float f3 = MathHelper.func_76142_g(p_82204_2_ - p_82204_1_);
        if (f3 > p_82204_3_) {
            f3 = p_82204_3_;
        }

        if (f3 < -p_82204_3_) {
            f3 = -p_82204_3_;
        }

        return p_82204_1_ + f3;
    }

    private void launchWitherSkullToEntity(int p_82216_1_, EntityLivingBase p_82216_2_) {
        if (!(p_82216_2_ instanceof EntityTitan) && !(p_82216_2_.field_70131_O >= 6.0F)) {
            this.launchWitherSkullToCoords(p_82216_1_, p_82216_2_.field_70165_t, p_82216_2_.field_70163_u + (double)p_82216_2_.func_70047_e() * (double)0.5F, p_82216_2_.field_70161_v, p_82216_1_ == 0 && this.field_70146_Z.nextFloat() < 0.001F);
            p_82216_2_.func_70097_a(DamageSource.func_76358_a(this), 21.0F);
            p_82216_2_.field_70172_ad = 0;
        } else {
            double d0 = this.func_70068_e(p_82216_2_);
            if (d0 < (double)1000.0F && this.attackTimer <= 0) {
                this.attackTimer = 10;
                this.func_70652_k(p_82216_2_);
            }
        }

        this.launchWitherSkullToCoords(p_82216_1_, p_82216_2_.field_70165_t, p_82216_2_.field_70163_u + (double)p_82216_2_.func_70047_e() * (double)0.5F, p_82216_2_.field_70161_v, p_82216_1_ == 0 && this.field_70146_Z.nextFloat() < 0.001F);
    }

    private void launchWitherSkullToCoords(int p_82209_1_, double p_82209_2_, double p_82209_4_, double p_82209_6_, boolean p_82209_8_) {
        double d3 = this.func_82214_u(p_82209_1_);
        double d4 = this.func_82208_v(p_82209_1_);
        double d5 = this.func_82213_w(p_82209_1_);
        double d6 = p_82209_2_ - d3;
        double d7 = p_82209_4_ - d4;
        double d8 = p_82209_6_ - d5;
        EntityWitherSkull entitywitherskull = new EntityWitherSkull(this.field_70170_p, this, d6, d7, d8);
        if (p_82209_8_) {
            entitywitherskull.func_82343_e(true);
        }

        entitywitherskull.field_70163_u = d4;
        entitywitherskull.field_70165_t = d3;
        entitywitherskull.field_70161_v = d5;
        this.field_70170_p.func_72908_a(d3, d4, d5, "mob.wither.shoot", 3.0F, 0.8F);
        this.field_70170_p.func_72838_d(entitywitherskull);
    }

    public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
        if (!(p_82196_1_ instanceof EntityTitan) && !(p_82196_1_.field_70131_O >= 6.0F)) {
            this.launchWitherSkullToEntity(0, p_82196_1_);
        } else {
            double d0 = this.func_70068_e(p_82196_1_);
            if (d0 < (double)1000.0F && this.attackTimer <= 0) {
                this.attackTimer = 1 + this.field_70146_Z.nextInt(9);
                this.func_70652_k(p_82196_1_);
            }
        }

    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (this.field_70146_Z.nextInt(10) == 0 && !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid)) {
            this.omegacounter = 600;
        }

        if (!this.func_85032_ar() && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.getExtraPower() <= 5) {
            if (!(source.func_76346_g() instanceof EntityWitherzillaMinion) && (!source.func_94541_c() || source.func_76346_g() instanceof EntityWitherTurret)) {
                if (this.isArmored() && !(source.func_76346_g() instanceof EntityPlayer) && !(source.func_76346_g() instanceof EntityTitan)) {
                    if (source.func_76346_g() != null && this.field_70146_Z.nextInt(10) == 0) {
                        this.teleportToEntity(source.func_76346_g(), false);
                    }

                    return false;
                } else {
                    if (this.blockBreakCounter <= 0) {
                        this.blockBreakCounter = 1;
                    }

                    ++this.field_70173_aa;
                    return super.func_70097_a(source, amount);
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean attackWitherzillaFrom(DamageSource source, float amount) {
        if (!(source.func_76346_g() instanceof EntityWitherzillaMinion) && !(source.func_76346_g() instanceof EntityWitherzilla) && (!source.func_94541_c() || source.func_76346_g() instanceof EntityWitherTurret)) {
            if (this.isArmored() && !(source.func_76346_g() instanceof EntityPlayer) && !(source.func_76346_g() instanceof EntityTitan)) {
                return false;
            } else {
                if (this.blockBreakCounter <= 0) {
                    this.blockBreakCounter = 1;
                }

                return super.func_70097_a(source, amount);
            }
        } else {
            return false;
        }
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            for(int x = 0; x < 250; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                entitylargefireball.func_70107_b(this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                ++entitylargefireball.field_70181_x;
                entitylargefireball.setXPCount(32000);
                this.field_70170_p.func_72838_d(entitylargefireball);
            }

            Item it = null;
            Block bl = null;
            Iterator ilist = Item.field_150901_e.iterator();
            int icount = 0;

            while(ilist.hasNext()) {
                it = (Item)ilist.next();
                if (it != null) {
                    ++icount;
                }
            }

            int j = 0;

            while(j < 256) {
                int k = 1 + this.field_70146_Z.nextInt(icount);

                for(Iterator var14 = Item.field_150901_e.iterator(); k > 0 && var14.hasNext(); --k) {
                    it = (Item)var14.next();
                }

                if (it != null && it != TitanItems.ultimaBlade) {
                    ++j;
                    EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)12.0F, this.field_70163_u + (double)12.0F + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)12.0F, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)12.0F, new ItemStack(it, 1, 0));
                    this.field_70170_p.func_72838_d(var3);
                }
            }

            Iterator blist = Block.field_149771_c.iterator();
            int bcount = 0;

            while(blist.hasNext()) {
                bl = (Block)blist.next();
                if (bl != null) {
                    ++bcount;
                }
            }

            int j = 0;

            while(j < 256) {
                int k = 1 + this.field_70146_Z.nextInt(bcount);

                for(Iterator var16 = Block.field_149771_c.iterator(); k > 0 && var16.hasNext(); --k) {
                    bl = (Block)var16.next();
                }

                if (bl != null) {
                    ++j;
                    EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)12.0F, this.field_70163_u + (double)12.0F + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)12.0F, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)12.0F, new ItemStack(Item.func_150898_a(bl), 1, 0));
                    this.field_70170_p.func_72838_d(var3);
                }
            }

            for(int l = 0; l < 1024; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150402_ci));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 512; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150339_S));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 512; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150340_R));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 256; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150475_bE));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 256; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150484_ah));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 128; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(TitanBlocks.harcadium_block));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 128; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(TitanBlocks.void_block));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 128; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(TitanBlocks.bedrock_block));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 256; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150380_bt));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }
        }

    }

    protected void func_70623_bb() {
    }

    protected float func_70599_aP() {
        return 1000.0F;
    }

    @SideOnly(Side.CLIENT)
    public int func_70070_b(float p_70070_1_) {
        return 15728880;
    }

    public float func_70013_c(float p_70013_1_) {
        return 1.0F;
    }

    public void fall(float distance, float damageMultiplier) {
    }

    public void func_70690_d(PotionEffect p_70690_1_) {
    }

    @SideOnly(Side.CLIENT)
    public float func_82207_a(int p_82207_1_) {
        return this.field_82221_e[p_82207_1_];
    }

    @SideOnly(Side.CLIENT)
    public float func_82210_r(int p_82210_1_) {
        return this.field_82220_d[p_82210_1_];
    }

    public int getWatchedTargetId(int p_82203_1_) {
        return this.field_70180_af.func_75679_c(17 + p_82203_1_);
    }

    public void func_82211_c(int p_82211_1_, int p_82211_2_) {
        this.field_70180_af.func_75692_b(17 + p_82211_1_, p_82211_2_);
    }

    public boolean isArmored() {
        return this.func_110143_aJ() <= this.func_110138_aP() / 2.0F;
    }

    public EnumCreatureAttribute func_70668_bt() {
        return EnumCreatureAttribute.UNDEAD;
    }

    public void func_70078_a(Entity entityIn) {
        this.field_70154_o = null;
    }

    public StatBase getAchievement() {
        return this.field_70170_p.field_73011_w instanceof WorldProviderVoid ? TitansAchievments.witherzilla : TitansAchievments.witherzilla2;
    }

    public int getThreashHold() {
        return 210;
    }

    protected void inactDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            this.createBeaconPortal(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70161_v));
            if (this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
                this.func_70628_a(true, 0);
                this.func_82160_b(true, 0);
                this.func_70600_l(1);
            }

            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.field_70170_p);
            entitytitan.func_70012_b(this.field_70165_t, this.field_70163_u + (double)48.0F, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitytitan);
            entitytitan.setVesselHunting(true);
            entitytitan.setSpiritType(12);
        }

    }

    protected void onTitanDeathUpdate() {
        this.field_70180_af.func_75692_b(6, MathHelper.func_76131_a(this.field_70180_af.func_111145_d(5), 0.0F, this.func_110138_aP()));
        this.field_70729_aU = false;
        if (this.field_70180_af.func_111145_d(5) <= 0.0F) {
            ++this.deathTicks;
        }

        if (this.deathTicks > 180 && this.deathTicks % 1 == 0) {
            float f = (this.field_70146_Z.nextFloat() - 0.5F) * 24.0F;
            float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 80.0F;
            float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 24.0F;
            this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)f, this.field_70163_u + (double)2.0F + (double)f1, this.field_70161_v + (double)f2, (double)0.0F, (double)0.0F, (double)0.0F);
        }

        if (this.field_70170_p.field_73011_w instanceof WorldProviderVoid) {
            this.func_70012_b((double)0.0F, (double)120.0F, (double)0.0F, (float)(this.deathTicks * 10), 0.0F);
        }

        if (!this.field_70170_p.field_72995_K && this.deathTicks == 1) {
            this.func_85030_a(this.func_70673_aS(), this.func_70599_aP(), this.func_70647_i());
            this.field_70170_p.func_82739_e(1018, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
            this.field_70170_p.func_82739_e(1018, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
            this.field_70170_p.func_82739_e(1018, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
            this.field_70170_p.func_82739_e(1018, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
            MinecraftServer.func_71276_C().func_147139_a(EnumDifficulty.PEACEFUL);
            ArrayList listp = Lists.newArrayList(this.field_70170_p.field_73010_i);
            if (listp != null && !listp.isEmpty()) {
                for(int i1 = 0; i1 < listp.size(); ++i1) {
                    Entity entity = (Entity)listp.get(i1);
                    if (entity != null && entity instanceof EntityPlayer) {
                        ((EntityPlayer)entity).func_71029_a(this.getAchievement());
                        ((EntityPlayer)entity).func_71029_a(AchievementList.field_150964_J);
                        ItemStack item = new ItemStack(TitanItems.ultimaBlade, 1, 1);
                        ((EntityPlayer)entity).func_70099_a(item, 0.0F);
                        this.func_70642_aH();
                        if (this.field_70170_p.field_73011_w instanceof WorldProviderVoid) {
                            ((EntityPlayer)entity).func_145747_a(new ChatComponentText(StatCollector.func_74838_a("dialog.witherzilla.death")));
                        } else {
                            ((EntityPlayer)entity).func_145747_a(new ChatComponentText(StatCollector.func_74838_a("dialog.witherzilla.defeat")));
                        }
                    }
                }
            }
        }

        if (this.deathTicks >= 200) {
            this.setInvulTime(2000);
        }

        if (this.deathTicks >= 400) {
            this.func_70106_y();
        }

    }

    private void createBeaconPortal(int p_70975_1_, int p_70975_2_) {
        byte b0 = 64;
        BlockEndPortal.field_149948_a = true;
        byte b1 = 4;

        for(int k = b0 - 1; k <= b0 + 32; ++k) {
            for(int l = p_70975_1_ - b1; l <= p_70975_1_ + b1; ++l) {
                for(int i1 = p_70975_2_ - b1; i1 <= p_70975_2_ + b1; ++i1) {
                    double d0 = (double)(l - p_70975_1_);
                    double d1 = (double)(i1 - p_70975_2_);
                    double d2 = d0 * d0 + d1 * d1;
                    if (d2 <= ((double)b1 - (double)0.5F) * ((double)b1 - (double)0.5F)) {
                        if (k < b0) {
                            if (d2 <= ((double)(b1 - 1) - (double)0.5F) * ((double)(b1 - 1) - (double)0.5F)) {
                                this.field_70170_p.func_147449_b(l, k, i1, Blocks.field_150357_h);
                            }
                        } else if (k > b0) {
                            this.field_70170_p.func_147449_b(l, k, i1, Blocks.field_150350_a);
                        } else if (d2 > ((double)(b1 - 1) - (double)0.5F) * ((double)(b1 - 1) - (double)0.5F)) {
                            this.field_70170_p.func_147449_b(l, k, i1, Blocks.field_150357_h);
                        } else {
                            this.field_70170_p.func_147449_b(l, k, i1, Blocks.field_150384_bq);
                        }
                    }
                }
            }
        }

        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 0, p_70975_2_, Blocks.field_150357_h);
        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 1, p_70975_2_, Blocks.field_150357_h);
        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 2, p_70975_2_, Blocks.field_150357_h);
        this.field_70170_p.func_147449_b(p_70975_1_ - 1, b0 + 2, p_70975_2_, Blocks.field_150478_aa);
        this.field_70170_p.func_147449_b(p_70975_1_ + 1, b0 + 2, p_70975_2_, Blocks.field_150478_aa);
        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 2, p_70975_2_ - 1, Blocks.field_150478_aa);
        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 2, p_70975_2_ + 1, Blocks.field_150478_aa);
        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 3, p_70975_2_, Blocks.field_150357_h);
        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 4, p_70975_2_, Blocks.field_150484_ah);
        this.field_70170_p.func_147449_b(p_70975_1_ + 1, b0 + 4, p_70975_2_ + 1, Blocks.field_150484_ah);
        this.field_70170_p.func_147449_b(p_70975_1_ + 1, b0 + 4, p_70975_2_, Blocks.field_150484_ah);
        this.field_70170_p.func_147449_b(p_70975_1_ + 1, b0 + 4, p_70975_2_ - 1, Blocks.field_150484_ah);
        this.field_70170_p.func_147449_b(p_70975_1_ - 1, b0 + 4, p_70975_2_ + 1, Blocks.field_150484_ah);
        this.field_70170_p.func_147449_b(p_70975_1_ - 1, b0 + 4, p_70975_2_, Blocks.field_150484_ah);
        this.field_70170_p.func_147449_b(p_70975_1_ - 1, b0 + 4, p_70975_2_ - 1, Blocks.field_150484_ah);
        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 4, p_70975_2_ + 1, Blocks.field_150484_ah);
        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 4, p_70975_2_ - 1, Blocks.field_150484_ah);
        this.field_70170_p.func_147449_b(p_70975_1_, b0 + 5, p_70975_2_, Blocks.field_150461_bJ);
    }

    protected void func_85033_bc() {
    }

    public float func_70047_e() {
        return this.isInOmegaForm() ? 380.8F : 190.4F;
    }

    protected boolean teleportRandomly(boolean bool) {
        double d0 = this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)64.0F;
        double d2 = this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)64.0F;
        return bool ? this.teleportTo((double)0.0F, (double)200.0F, (double)0.0F) : this.teleportTo(d0, (double)200.0F, d2);
    }

    protected boolean teleportToEntity(Entity p_70816_1_, boolean bool) {
        Vec3 vec3 = Vec3.func_72443_a(this.field_70165_t - p_70816_1_.field_70165_t, this.field_70121_D.field_72338_b + (double)(this.field_70131_O / 2.0F) - p_70816_1_.field_70163_u + (double)p_70816_1_.func_70047_e(), this.field_70161_v - p_70816_1_.field_70161_v);
        vec3 = vec3.func_72432_b();
        double d0 = (double)32.0F;
        double d1 = this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)16.0F - vec3.field_72450_a * d0;
        double d2 = this.field_70163_u + (double)(this.field_70146_Z.nextInt(16) - 8) - vec3.field_72448_b * d0;
        double d3 = this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)16.0F - vec3.field_72449_c * d0;
        if (bool) {
            this.doLightningAttackTo(p_70816_1_);
            return this.teleportTo(p_70816_1_.field_70165_t, p_70816_1_.field_70163_u, p_70816_1_.field_70161_v);
        } else {
            return this.teleportTo(d1, d2, d3);
        }
    }

    protected boolean teleportTo(double p_70825_1_, double p_70825_3_, double p_70825_5_) {
        EnderTeleportEvent event = new EnderTeleportEvent(this, p_70825_1_, p_70825_3_, p_70825_5_, 0.0F);
        if (MinecraftForge.EVENT_BUS.post(event)) {
            return false;
        } else {
            if (!this.field_70170_p.field_72995_K) {
                this.func_70107_b(p_70825_1_, p_70825_3_, p_70825_5_);
            }

            return true;
        }
    }

    public boolean func_70058_J() {
        return false;
    }

    public boolean isInOmegaForm() {
        return !(this.field_70170_p.field_73011_w instanceof WorldProviderVoid);
    }
}
