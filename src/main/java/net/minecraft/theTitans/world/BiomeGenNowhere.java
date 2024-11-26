//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.titanminion.EntityDragonMinion;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenNowhere extends BiomeGenBase {
    public BiomeGenNowhere(int p_i1990_1_) {
        super(p_i1990_1_);
        this.field_76761_J.clear();
        this.field_76762_K.clear();
        this.field_76755_L.clear();
        this.field_82914_M.clear();
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityEnderman.class, 100, 12, 12));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityDragonMinion.class, 10, 1, 1));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityZombie.class, 1, 1, 1));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityPigZombie.class, 1, 1, 1));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySkeleton.class, 1, 1, 1));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySpider.class, 1, 1, 1));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityCreeper.class, 1, 1, 1));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityCaveSpider.class, 1, 1, 1));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityGhast.class, 1, 1, 1));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntitySlime.class, 1, 1, 1));
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityMagmaCube.class, 1, 1, 1));
        this.field_76752_A = Blocks.field_150348_b;
        this.field_76753_B = Blocks.field_150348_b;
        this.field_76760_I = new BiomeNowhereDecorator();
    }

    @SideOnly(Side.CLIENT)
    public int func_76731_a(float p_76731_1_) {
        return 0;
    }
}
