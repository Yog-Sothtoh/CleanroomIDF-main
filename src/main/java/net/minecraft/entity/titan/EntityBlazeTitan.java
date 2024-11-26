//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.entity.titan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.titan.ai.EntityAINearestTargetTitan;
import net.minecraft.entity.titanminion.EntityBlazeMinion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import net.minecraft.theTitans.DamageSourceExtra;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.theTitans.TitanItems;
import net.minecraft.theTitans.TitansAchievments;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityBlazeTitan extends EntityTitan implements IEntityMultiPartTitan {
    private float heightOffset = 32.0F;
    private int heightOffsetUpdateTime;
    public boolean shouldBurn;
    public EntityTitanPart[] partArray;
    public EntityTitanPart head;
    public EntityTitanPart[] rods = new EntityTitanPart[12];

    public EntityBlazeTitan(World worldIn) {
        super(worldIn);
        this.head = new EntityTitanPart(worldIn, this, "head", 8.0F, 8.0F);
        this.rods[0] = new EntityTitanPart(worldIn, this, "rod1", 2.0F, 8.0F);
        this.rods[1] = new EntityTitanPart(worldIn, this, "rod2", 2.0F, 8.0F);
        this.rods[2] = new EntityTitanPart(worldIn, this, "rod3", 2.0F, 8.0F);
        this.rods[3] = new EntityTitanPart(worldIn, this, "rod4", 2.0F, 8.0F);
        this.rods[4] = new EntityTitanPart(worldIn, this, "rod5", 2.0F, 8.0F);
        this.rods[5] = new EntityTitanPart(worldIn, this, "rod6", 2.0F, 8.0F);
        this.rods[6] = new EntityTitanPart(worldIn, this, "rod7", 2.0F, 8.0F);
        this.rods[7] = new EntityTitanPart(worldIn, this, "rod8", 2.0F, 8.0F);
        this.rods[8] = new EntityTitanPart(worldIn, this, "rod9", 2.0F, 8.0F);
        this.rods[9] = new EntityTitanPart(worldIn, this, "rod10", 2.0F, 8.0F);
        this.rods[10] = new EntityTitanPart(worldIn, this, "rod11", 2.0F, 8.0F);
        this.rods[11] = new EntityTitanPart(worldIn, this, "rod12", 2.0F, 8.0F);
        this.partArray = new EntityTitanPart[]{this.head, this.rods[0], this.rods[1], this.rods[2], this.rods[3], this.rods[4], this.rods[5], this.rods[6], this.rods[7], this.rods[8], this.rods[9], this.rods[10], this.rods[11]};
        this.shouldParticlesBeUpward = true;
        this.func_70105_a(8.0F, 8.0F);
        this.field_70728_aV = 50000;
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityIronGolemTitan.class, 0, false));
        this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntitySnowGolemTitan.class, 0, false));
        this.field_70170_p.func_72838_d(this.head);
        this.field_70170_p.func_72838_d(this.rods[0]);
        this.field_70170_p.func_72838_d(this.rods[1]);
        this.field_70170_p.func_72838_d(this.rods[2]);
        this.field_70170_p.func_72838_d(this.rods[3]);
        this.field_70170_p.func_72838_d(this.rods[4]);
        this.field_70170_p.func_72838_d(this.rods[5]);
        this.field_70170_p.func_72838_d(this.rods[6]);
        this.field_70170_p.func_72838_d(this.rods[7]);
        this.field_70170_p.func_72838_d(this.rods[8]);
        this.field_70170_p.func_72838_d(this.rods[9]);
        this.field_70170_p.func_72838_d(this.rods[10]);
        this.field_70170_p.func_72838_d(this.rods[11]);
    }

    protected void applyEntityAI() {
        this.field_70714_bg.func_75776_a(4, new AIFireballAttack());
        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, true));
        if (TheTitans.TitansFFAMode) {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.BlazeTitanSorter));
        } else {
            this.field_70715_bh.func_75776_a(0, new EntityAINearestTargetTitan(this, EntityLivingBase.class, 0, false, false, ITitan.SearchForAThingToKill));
        }

    }

    public float func_70047_e() {
        return 4.0F;
    }

    public boolean isArmored() {
        return this.func_110143_aJ() <= this.func_110138_aP() / 4.0F || TheTitans.NightmareMode || TheTitans.TotalDestructionMode;
    }

    public int getMinionCap() {
        return 120;
    }

    public int getPriestCap() {
        return 60;
    }

    public int getZealotCap() {
        return 20;
    }

    public int getTemplarCap() {
        return 8;
    }

    protected void func_70069_a(float p_70069_1_) {
    }

    public boolean func_70686_a(Class p_70686_1_) {
        return p_70686_1_ != this.head.getClass() && p_70686_1_ != this.rods[0].getClass() && p_70686_1_ != this.rods[1].getClass() && p_70686_1_ != this.rods[2].getClass() && p_70686_1_ != this.rods[3].getClass() && p_70686_1_ != this.rods[4].getClass() && p_70686_1_ != this.rods[5].getClass() && p_70686_1_ != this.rods[6].getClass() && p_70686_1_ != this.rods[7].getClass() && p_70686_1_ != this.rods[8].getClass() && p_70686_1_ != this.rods[9].getClass() && p_70686_1_ != this.rods[10].getClass() && p_70686_1_ != this.rods[11].getClass() && p_70686_1_ != EntityTitanFireball.class && p_70686_1_ != EntityBlazeMinion.class && p_70686_1_ != EntityBlazeTitan.class;
    }

    public boolean func_70601_bi() {
        return this.field_70146_Z.nextInt(250) == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && super.func_70601_bi();
    }

    public int getMinionSpawnRate() {
        return TheTitans.BlazeTitanMinionSpawnrate;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(16, new Byte((byte)0));
    }

    public int getParticleCount() {
        return 40;
    }

    public String getParticles() {
        return this.field_70146_Z.nextInt(this.func_70026_G() ? 2 : 6) == 0 ? "explode" : "largesmoke";
    }

    public int getRegenTime() {
        return 10;
    }

    public EnumTitanStatus getTitanStatus() {
        return EnumTitanStatus.AVERAGE;
    }

    protected String func_70639_aQ() {
        return "thetitans:titanBlazeBreathe";
    }

    protected String func_70621_aR() {
        return "thetitans:titanBlazeGrunt";
    }

    protected String func_70673_aS() {
        return "thetitans:titanBlazeDeath";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
    }

    @SideOnly(Side.CLIENT)
    public int func_70070_b(float p_70070_1_) {
        return 15728880;
    }

    public float func_70013_c(float p_70013_1_) {
        return 1.0F;
    }

    public double getSpeed() {
        return (double)0.5F + (double)this.getExtraPower() * 0.001;
    }

    public void func_70636_d() {
        switch (this.field_70146_Z.nextInt(2)) {
            case 0:
                this.func_94058_c("§cBlaze Titan");
                break;
            case 1:
                this.func_94058_c("§6Blaze Titan");
        }

        this.field_70160_al = true;
        this.field_70122_E = false;
        if (this.field_70170_p.field_72995_K && this.deathTicks < this.getThreashHold()) {
            for(int i = 0; i < this.getParticleCount(); ++i) {
                if (this.shouldParticlesBeUpward) {
                    this.field_70170_p.func_72869_a(this.getParticles(), this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u - (double)16.0F + this.field_70146_Z.nextDouble() * (double)16.0F, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                } else {
                    this.field_70170_p.func_72869_a(this.getParticles(), this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u - (double)16.0F + this.field_70146_Z.nextDouble() * (double)16.0F, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)2.0F, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)2.0F);
                }
            }

            if (TheTitans.NightmareMode && this.field_70146_Z.nextInt(20) == 0) {
                for(int i = 0; i < 2; ++i) {
                    this.field_70170_p.func_72869_a("flame", this.field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, this.field_70163_u - (double)16.0F + this.field_70146_Z.nextDouble() * (double)16.0F, this.field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                }
            }
        }

        for(int i = 0; i < 8; ++i) {
            double d0 = this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 8.0F - 4.0F);
            double d1 = this.field_70163_u + (double)(this.field_70146_Z.nextFloat() * 20.0F);
            double d2 = this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 8.0F - 4.0F);
            if (!this.field_70170_p.field_72995_K && (this.field_70170_p.func_147439_a((int)d0, (int)d1 + (int)this.func_70047_e(), (int)d2).func_149662_c() || this.field_70170_p.func_147439_a((int)d0, (int)d1 + (int)this.func_70047_e(), (int)d2).func_149688_o().func_76224_d())) {
                this.func_70107_b(this.field_70165_t, this.field_70163_u + 0.1, this.field_70161_v);
            }
        }

        for(int in = 0; in < 1000; ++in) {
            double d0 = this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 8.0F - 4.0F);
            double d1 = this.field_70163_u - (double)this.field_70146_Z.nextInt(20);
            double d2 = this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 8.0F - 4.0F);
            if (!this.field_70170_p.field_72995_K && (this.field_70170_p.func_147439_a((int)d0, (int)d1, (int)d2).func_149662_c() || this.field_70170_p.func_147439_a((int)d0, (int)d1, (int)d2).func_149688_o().func_76224_d())) {
                this.field_70181_x = (double)0.25F;
            }
        }

        if (this.field_70173_aa > 5) {
            float f = this.field_70761_aq * (float)Math.PI / 180.0F;
            float f6 = (float)this.field_70173_aa * (float)Math.PI * 0.008F + 0.15F;

            for(int i = 0; i < 4; ++i) {
                this.rods[i].func_70012_b(this.field_70165_t - (double)(MathHelper.func_76134_b(f6 + f) * 10.0F), this.field_70163_u - (double)(4.0F + MathHelper.func_76134_b((float)(i * 2 + this.field_70173_aa) * 0.03F)), this.field_70161_v - (double)(MathHelper.func_76126_a(f6 + f) * 10.0F), 0.0F, 0.0F);
                ++f6;
            }

            f6 = ((float)Math.PI / 4F) + (float)this.field_70173_aa * (float)Math.PI * -0.005F - 1.4F;

            for(int var32 = 4; var32 < 8; ++var32) {
                this.rods[var32].func_70012_b(this.field_70165_t - (double)(MathHelper.func_76134_b(f6 + f) * 7.0F), this.field_70163_u - (double)(10.0F + MathHelper.func_76134_b((float)(var32 * 3 + this.field_70173_aa) * 0.05F)), this.field_70161_v - (double)(MathHelper.func_76126_a(f6 + f) * 7.0F), 0.0F, 0.0F);
                ++f6;
            }

            f6 = 0.47123894F + (float)this.field_70173_aa * (float)Math.PI * 0.003F - 0.8F;

            int var33;
            for(var33 = 8; var33 < 12; ++var33) {
                this.rods[var33].func_70012_b(this.field_70165_t - (double)(MathHelper.func_76134_b(f6 + f) * 4.0F), this.field_70163_u - (double)(17.0F + MathHelper.func_76134_b(((float)var33 * 1.5F + (float)this.field_70173_aa) * 0.02F)), this.field_70161_v - (double)(MathHelper.func_76126_a(f6 + f) * 4.0F), 0.0F, 0.0F);
                ++f6;
            }

            this.head.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);

            for(int u = 0; u < this.getParticleCount(); ++u) {
                for(int w = 0; w < this.rods.length; ++w) {
                    this.field_70170_p.func_72869_a(this.getParticles(), this.rods[w].field_70165_t + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.rods[w].field_70130_N, this.rods[w].field_70163_u + this.field_70146_Z.nextDouble() * (double)this.rods[w].field_70131_O, this.rods[w].field_70161_v + (this.field_70146_Z.nextDouble() - (double)0.5F) * (double)this.rods[w].field_70130_N, (double)0.0F, (double)0.0F, (double)0.0F);
                }
            }

            if (this.func_70089_S()) {
                this.collideWithEntities(this.head, this.field_70170_p.func_72839_b(this, this.head.field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.rods[0], this.field_70170_p.func_72839_b(this, this.rods[0].field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.rods[1], this.field_70170_p.func_72839_b(this, this.rods[1].field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.rods[2], this.field_70170_p.func_72839_b(this, this.rods[2].field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.rods[3], this.field_70170_p.func_72839_b(this, this.rods[3].field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.rods[4], this.field_70170_p.func_72839_b(this, this.rods[4].field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.rods[5], this.field_70170_p.func_72839_b(this, this.rods[5].field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.rods[6], this.field_70170_p.func_72839_b(this, this.rods[6].field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.rods[7], this.field_70170_p.func_72839_b(this, this.rods[7].field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.rods[8], this.field_70170_p.func_72839_b(this, this.rods[8].field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.rods[9], this.field_70170_p.func_72839_b(this, this.rods[9].field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.rods[10], this.field_70170_p.func_72839_b(this, this.rods[10].field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
                this.collideWithEntities(this.rods[11], this.field_70170_p.func_72839_b(this, this.rods[11].field_70121_D.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F)));
            }

            this.destroyBlocksInAABB(this.head.field_70121_D);
            this.destroyBlocksInAABB(this.rods[0].field_70121_D);
            this.destroyBlocksInAABB(this.rods[1].field_70121_D);
            this.destroyBlocksInAABB(this.rods[2].field_70121_D);
            this.destroyBlocksInAABB(this.rods[3].field_70121_D);
            this.destroyBlocksInAABB(this.rods[4].field_70121_D);
            this.destroyBlocksInAABB(this.rods[5].field_70121_D);
            this.destroyBlocksInAABB(this.rods[6].field_70121_D);
            this.destroyBlocksInAABB(this.rods[7].field_70121_D);
            this.destroyBlocksInAABB(this.rods[8].field_70121_D);
            this.destroyBlocksInAABB(this.rods[9].field_70121_D);
            this.destroyBlocksInAABB(this.rods[10].field_70121_D);
            this.destroyBlocksInAABB(this.rods[11].field_70121_D);

            for(int k = 0; k < this.partArray.length; ++k) {
                List list = this.field_70170_p.func_72839_b(this, this.partArray[k].field_70121_D.func_72314_b((double)0.5F, (double)0.5F, (double)0.5F));
                if (list != null && !list.isEmpty()) {
                    for(int j = 0; j < list.size(); ++j) {
                        Entity entity = (Entity)list.get(j);
                        if (entity instanceof EntityFireball && ((EntityFireball)entity).field_70235_a != this && !(entity instanceof EntitySmallFireball) && !(entity instanceof EntityLightningBall) && !(entity instanceof EntityGargoyleTitanFireball) && !(entity instanceof EntityWebShot)) {
                            ((EntityFireball)entity).func_70097_a(DamageSource.func_92087_a(this), 0.0F);
                        }

                        if (entity instanceof EntityTitanFireball && ((EntityTitanFireball)entity).field_70235_a != null && ((EntityTitanFireball)entity).field_70235_a != this) {
                            ((EntityTitanFireball)entity).onImpactPublic(this);
                        }

                        if (entity instanceof EntityGargoyleTitanFireball) {
                            this.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                            this.field_70170_p.func_72885_a((Entity)(((EntityGargoyleTitanFireball)entity).field_70235_a != null ? ((EntityGargoyleTitanFireball)entity).field_70235_a : (EntityGargoyleTitanFireball)entity), ((EntityGargoyleTitanFireball)entity).field_70165_t, ((EntityGargoyleTitanFireball)entity).field_70163_u, ((EntityGargoyleTitanFireball)entity).field_70161_v, 8.0F, false, false);
                            this.attackEntityFromPart(this.partArray[var33], DamageSource.func_76362_a((EntityGargoyleTitanFireball)entity, (Entity)(((EntityGargoyleTitanFireball)entity).field_70235_a != null ? ((EntityGargoyleTitanFireball)entity).field_70235_a : (EntityGargoyleTitanFireball)entity)), 1000.0F);
                            entity.func_70106_y();
                        }

                        if (entity instanceof EntityHarcadiumArrow) {
                            this.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                            this.attackEntityFromPart(this.partArray[var33], DamageSourceExtra.causeHarcadiumArrowDamage((EntityHarcadiumArrow)entity, (Entity)(((EntityHarcadiumArrow)entity).field_70250_c != null ? ((EntityHarcadiumArrow)entity).field_70250_c : (EntityHarcadiumArrow)entity)), 500.0F);
                            entity.func_70106_y();
                        }

                        if (entity instanceof EntityWebShot && ((EntityWebShot)entity).field_70235_a != this) {
                            this.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                            this.attackEntityFromPart(this.partArray[var33], DamageSourceExtra.causeAntiTitanDamage((Entity)(((EntityWebShot)entity).field_70235_a != this ? ((EntityWebShot)entity).field_70235_a : (EntityWebShot)entity)), 300.0F);
                            int i1 = MathHelper.func_76128_c(this.partArray[var33].field_70163_u);
                            int i11 = MathHelper.func_76128_c(this.partArray[var33].field_70165_t);
                            int j1 = MathHelper.func_76128_c(this.partArray[var33].field_70161_v);
                            boolean flag = false;

                            for(int l1 = -2 - this.field_70146_Z.nextInt(4); l1 <= 2 + this.field_70146_Z.nextInt(4); ++l1) {
                                for(int i2 = -2 - this.field_70146_Z.nextInt(4); i2 <= 2 + this.field_70146_Z.nextInt(4); ++i2) {
                                    for(int h = -2; h <= 2 + this.field_70146_Z.nextInt(5); ++h) {
                                        int j2 = i11 + l1;
                                        int k1 = i1 + h;
                                        int l = j1 + i2;
                                        Block block1 = this.field_70170_p.func_147439_a(j2, k1, l);
                                        if (!block1.func_149662_c()) {
                                            this.field_70170_p.func_147449_b(j2, k1, l, Blocks.field_150321_G);
                                        }
                                    }
                                }
                            }

                            entity.func_70106_y();
                        }

                        if (entity instanceof EntitySnowball) {
                            this.func_85030_a("thetitans:titanpunch", 10.0F, 1.0F);
                            this.attackEntityFromPart(this.partArray[k], DamageSource.func_76356_a((EntitySnowball)entity, (Entity)(((EntitySnowball)entity).func_85052_h() != null ? ((EntitySnowball)entity).func_85052_h() : (EntitySnowball)entity)), 25.0F);
                            entity.func_70106_y();
                            if (this.field_70172_ad > 15) {
                                this.field_70172_ad = 15;
                            }
                        }
                    }
                }
            }
        }

        if (TheTitans.NightmareMode) {
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)1800.0F + (double)(this.getExtraPower() * 40));
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)80000.0F + (double)(this.getExtraPower() * 4000));
        } else {
            this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)600.0F + (double)(this.getExtraPower() * 20));
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)40000.0F + (double)(this.getExtraPower() * 2000));
        }

        if (this.numMinions < this.getMinionCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate()) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            EntityBlazeMinion entitychicken = new EntityBlazeMinion(this.field_70170_p);
            entitychicken.setMinionType(0);
            entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u - (double)2.0F, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitychicken);
            ++this.numMinions;
        }

        if (this.numPriests < this.getPriestCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 2) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            EntityBlazeMinion entitychicken = new EntityBlazeMinion(this.field_70170_p);
            entitychicken.setMinionType(1);
            entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u - (double)2.0F, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitychicken);
            ++this.numPriests;
        }

        if (this.numZealots < this.getZealotCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 4) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            EntityBlazeMinion entitychicken = new EntityBlazeMinion(this.field_70170_p);
            entitychicken.setMinionType(2);
            entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u - (double)2.0F, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitychicken);
            ++this.numZealots;
        }

        if (this.numBishop < this.getBishopCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 8) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            EntityBlazeMinion entitychicken = new EntityBlazeMinion(this.field_70170_p);
            entitychicken.setMinionType(3);
            entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u - (double)2.0F, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitychicken);
            ++this.numBishop;
        }

        if (this.numTemplar < this.getTemplarCap() && (this.field_70146_Z.nextInt(this.getMinionSpawnRate() * 16) == 0 || this.getInvulTime() > 1) && this.func_110143_aJ() > 0.0F && !this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            EntityBlazeMinion entitychicken = new EntityBlazeMinion(this.field_70170_p);
            entitychicken.setMinionType(4);
            entitychicken.func_70012_b(this.field_70165_t, this.field_70163_u - (double)2.0F, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitychicken);
            ++this.numTemplar;
        }

        if (this.field_70170_p.field_72995_K && this.field_70146_Z.nextInt(48) == 0) {
            this.field_70170_p.func_72980_b(this.field_70165_t + (double)0.5F, this.field_70163_u + (double)0.5F, this.field_70161_v + (double)0.5F, "fire.fire", 10.0F + this.field_70146_Z.nextFloat(), this.field_70146_Z.nextFloat() * 0.3F + 0.2F, false);
        }

        if (this.func_70638_az() != null && !this.field_70170_p.field_72995_K) {
            this.func_70625_a(this.func_70638_az(), 5.0F, 180.0F);
            this.func_70605_aq().func_75642_a(this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v, (double)20.0F);
            if (this.field_70163_u < this.func_70638_az().field_70163_u + (double)20.0F) {
                if (this.field_70181_x < (double)0.0F) {
                    this.field_70181_x = (double)0.0F;
                }

                this.field_70181_x += (0.8 - this.field_70181_x) * 0.8;
            }
        } else if (!this.field_70122_E && this.field_70181_x < (double)0.0F) {
            this.field_70181_x *= (double)0.25F;
        }

        super.func_70636_d();
    }

    protected void func_70619_bc() {
        if (this.getInvulTime() < 0) {
            --this.heightOffsetUpdateTime;
            if (this.heightOffsetUpdateTime <= 0) {
                this.heightOffsetUpdateTime = 300;
                this.heightOffset = 40.0F + (float)this.field_70146_Z.nextGaussian() * 16.0F;
            }

            EntityLivingBase entitylivingbase = this.func_70638_az();
            if (entitylivingbase != null && entitylivingbase.field_70163_u + (double)entitylivingbase.func_70047_e() > this.field_70163_u + (double)this.func_70047_e() + (double)this.heightOffset) {
                this.field_70181_x += (0.9 - this.field_70181_x) * 0.9;
                this.field_70160_al = true;
            }
        }

        super.func_70619_bc();
    }

    public void fall(float distance, float damageMultiplier) {
    }

    protected Item func_146068_u() {
        return Items.field_151072_bj;
    }

    public int func_70646_bf() {
        return 180;
    }

    protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
        if (this.deathTicks > 0) {
            for(int x = 0; x < 32; ++x) {
                EntityXPBomb entitylargefireball = new EntityXPBomb(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                entitylargefireball.func_70107_b(this.field_70165_t, this.field_70163_u + (double)4.0F, this.field_70161_v);
                ++entitylargefireball.field_70181_x;
                entitylargefireball.setXPCount(18000);
                this.field_70170_p.func_72838_d(entitylargefireball);
            }

            for(int l = 0; l < 144 + this.field_70146_Z.nextInt(144 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151072_bj));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 96 + this.field_70146_Z.nextInt(96 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151065_br));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 64 + this.field_70146_Z.nextInt(64 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151044_h));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 24 + this.field_70146_Z.nextInt(64 + p_70628_2_) + p_70628_2_; ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151043_k));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 16 + this.field_70146_Z.nextInt(24 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151166_bC));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 16 + this.field_70146_Z.nextInt(24 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Items.field_151045_i));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            for(int l = 0; l < 1 + this.field_70146_Z.nextInt(8 + p_70628_2_); ++l) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(TitanItems.harcadium));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            if (this.field_70146_Z.nextInt(5) == 0) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150357_h));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }

            if (this.field_70146_Z.nextInt(5) == 0) {
                EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), this.field_70163_u + (double)10.0F + (double)(this.field_70146_Z.nextFloat() * 10.0F), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * 12.0F - 6.0F), new ItemStack(Blocks.field_150357_h));
                entityitem.field_145804_b = 40;
                this.field_70170_p.func_72838_d(entityitem);
            }
        }

    }

    protected void func_82164_bB() {
        this.func_145779_a(Items.field_151067_bt, 64);
    }

    public boolean func_70845_n() {
        return (this.field_70180_af.func_75683_a(16) & 1) != 0;
    }

    public void func_70844_e(boolean p_70844_1_) {
        byte b0 = this.field_70180_af.func_75683_a(16);
        if (p_70844_1_) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.field_70180_af.func_75692_b(16, b0);
    }

    public boolean func_70027_ad() {
        return this.func_70845_n() && this.field_70172_ad < 20;
    }

    protected boolean isValidLightLevel() {
        return true;
    }

    public Entity[] func_70021_al() {
        return this.partArray;
    }

    public boolean func_70058_J() {
        return false;
    }

    protected void func_82167_n(Entity p_82167_1_) {
        if (!(p_82167_1_ instanceof EntitySmallFireball) || !(p_82167_1_ instanceof EntityLargeFireball)) {
            p_82167_1_.func_70108_f(this);
        }

    }

    public StatBase getAchievement() {
        return TitansAchievments.blazetitan;
    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (this.isArmored()) {
            amount /= 3.0F;
        }

        if (this.func_85032_ar()) {
            return false;
        } else if (!(source.func_76346_g() instanceof EntityBlazeMinion) && !(source.func_76346_g() instanceof EntityBlazeTitan)) {
            if (source.func_76347_k()) {
                this.func_70691_i(amount);
                return false;
            } else {
                return super.func_70097_a(source, amount);
            }
        } else {
            return false;
        }
    }

    protected void inactDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            this.func_85030_a("mob.blaze.death", this.func_70599_aP(), this.func_70647_i());
            if (this.field_70170_p.func_82736_K().func_82766_b("doMobLoot")) {
                this.func_70628_a(true, 0);
                this.func_82160_b(true, 0);
                this.func_70600_l(1);
            }

            EntityTitanSpirit entitytitan = new EntityTitanSpirit(this.field_70170_p);
            entitytitan.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            this.field_70170_p.func_72838_d(entitytitan);
            entitytitan.setVesselHunting(false);
            entitytitan.setSpiritType(9);
        }

    }

    public boolean attackEntityFromPart(EntityTitanPart p_70965_1_, DamageSource source, float amount) {
        this.func_82195_e(source, amount);
        return true;
    }

    protected boolean func_82195_e(DamageSource p_82195_1_, float p_82195_2_) {
        return this.func_70097_a(p_82195_1_, p_82195_2_);
    }

    public World func_82194_d() {
        return this.field_70170_p;
    }

    class AIFireballAttack extends EntityAIBase {
        private EntityBlazeTitan field_179469_a = EntityBlazeTitan.this;
        private int field_179467_b;
        private int field_179468_c;

        public AIFireballAttack() {
            this.func_75248_a(4);
        }

        public boolean func_75250_a() {
            EntityLivingBase entitylivingbase = this.field_179469_a.func_70638_az();
            return entitylivingbase != null && entitylivingbase.func_70089_S();
        }

        public void func_75249_e() {
            this.field_179467_b = 0;
            this.field_179469_a.func_70844_e(true);
        }

        public void func_75251_c() {
            this.field_179469_a.func_70844_e(false);
        }

        public void func_75246_d() {
            --this.field_179468_c;
            EntityLivingBase entitylivingbase = this.field_179469_a.func_70638_az();
            double d0 = this.field_179469_a.func_70068_e(entitylivingbase);
            if (d0 <= this.field_179469_a.getMeleeRange()) {
                if (this.field_179468_c <= 0) {
                    this.field_179468_c = 30;
                    float f = (float)this.field_179469_a.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                    int i = this.field_179469_a.getKnockbackAmount();
                    this.field_179469_a.attackChoosenEntity(entitylivingbase, f, i);
                    if (entitylivingbase.field_70131_O > 6.0F || entitylivingbase instanceof EntityTitan) {
                        this.field_179469_a.attackChoosenEntity(entitylivingbase, f, i);
                        this.field_179469_a.attackChoosenEntity(entitylivingbase, f, i);
                        this.field_179469_a.attackChoosenEntity(entitylivingbase, f, i);
                        this.field_179469_a.attackChoosenEntity(entitylivingbase, f, i);
                        this.field_179469_a.attackChoosenEntity(entitylivingbase, f, i);
                    }
                }
            } else if (d0 > this.field_179469_a.getMeleeRange()) {
                double d1 = entitylivingbase.field_70165_t - this.field_179469_a.field_70165_t;
                double d2 = entitylivingbase.field_70163_u - (this.field_179469_a.field_70163_u + (double)(this.field_179469_a.field_70131_O * 0.5F));
                double d3 = entitylivingbase.field_70161_v - this.field_179469_a.field_70161_v;
                if (this.field_179468_c <= 0) {
                    ++this.field_179467_b;
                    if (this.field_179467_b == 1) {
                        this.field_179468_c = this.field_179469_a.isArmored() ? 10 : 20 + this.field_179469_a.func_70681_au().nextInt(40);
                    } else if (this.field_179467_b <= 4) {
                        this.field_179468_c = 6;
                    } else {
                        this.field_179468_c = this.field_179469_a.isArmored() ? 10 : 20 + this.field_179469_a.func_70681_au().nextInt(40);
                        this.field_179467_b = 0;
                    }

                    if (this.field_179467_b > 1) {
                        float f = MathHelper.func_76129_c(MathHelper.func_76133_a(d0)) * 0.75F;
                        this.field_179469_a.func_85030_a("thetitans:titanGhastFireball", 100.0F, 1.1F);

                        for(int i = 0; i < 100; ++i) {
                            EntityTitanFireball entitylargefireball = new EntityTitanFireball(this.field_179469_a.field_70170_p, this.field_179469_a, d1 + this.field_179469_a.func_70681_au().nextGaussian() * (double)f, d2, d3 + this.field_179469_a.func_70681_au().nextGaussian() * (double)f, 2);
                            double d8 = (double)10.0F;
                            Vec3 vec3 = this.field_179469_a.func_70676_i(1.0F);
                            entitylargefireball.field_70165_t = this.field_179469_a.field_70165_t + vec3.field_72450_a * d8;
                            entitylargefireball.field_70163_u = this.field_179469_a.field_70163_u + (double)4.0F + vec3.field_72448_b * d8;
                            entitylargefireball.field_70161_v = this.field_179469_a.field_70161_v + vec3.field_72449_c * d8;
                            this.field_179469_a.field_70170_p.func_72838_d(entitylargefireball);
                            entitylargefireball.setFireballID(2);
                            if (this.field_179469_a.func_70681_au().nextInt(50) == 0) {
                                this.field_179469_a.field_70170_p.func_72885_a(this.field_179469_a, entitylivingbase.field_70165_t, entitylivingbase.field_70163_u, entitylivingbase.field_70161_v, 4.0F, false, false);
                                entitylivingbase.func_70097_a(DamageSourceExtra.lightningBolt, 49.0F);
                                float f2 = (float)EntityBlazeTitan.this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
                                int i1 = EntityBlazeTitan.this.getKnockbackAmount();
                                EntityBlazeTitan.this.attackChoosenEntity(entitylivingbase, f2, i1);
                                this.field_179469_a.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_179469_a.field_70170_p, this.field_179469_a.field_70165_t, this.field_179469_a.field_70163_u + (double)this.field_179469_a.func_70047_e(), this.field_179469_a.field_70161_v, 1.0F, 0.8F, 0.0F));
                                this.field_179469_a.field_70170_p.func_72942_c(new EntityGammaLightning(this.field_179469_a.field_70170_p, entitylivingbase.field_70165_t, entitylivingbase.field_70163_u, entitylivingbase.field_70161_v, 1.0F, 0.8F, 0.0F));
                            }
                        }
                    }
                }
            } else {
                this.field_179469_a.func_70661_as().func_75499_g();
            }

            super.func_75246_d();
        }
    }
}
