//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.world;

import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeVoidDecorator extends BiomeDecorator {
    protected World worldObj;
    protected WorldGenerator turretGen;
    protected WorldGenerator turretGen2;
    protected WorldGenerator turretGen3;

    public BiomeVoidDecorator() {
        this.turretGen = new WorldGenTurretTowers(Blocks.field_150357_h);
        this.turretGen2 = new WorldGenGroundTurretTowers(Blocks.field_150357_h);
        this.turretGen3 = new WorldGenMortarTurretTowers(Blocks.field_150357_h);
    }

    protected void func_150513_a(BiomeGenBase p_150513_1_) {
        this.func_76797_b();
        if (this.field_76813_b.nextInt(2) == 0) {
            int i = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            int j = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            int k = this.field_76815_a.func_72825_h(i, j);
            this.turretGen.func_76484_a(this.field_76815_a, this.field_76813_b, i, k, j);
        }

        if (this.field_76813_b.nextInt(2) == 0) {
            int i = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            int j = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            int k = this.field_76815_a.func_72825_h(i, j);
            this.turretGen2.func_76484_a(this.field_76815_a, this.field_76813_b, i, k, j);
        }

        if (this.field_76813_b.nextInt(5) == 0) {
            int i = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            int j = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            int k = this.field_76815_a.func_72825_h(i, j);
            this.turretGen3.func_76484_a(this.field_76815_a, this.field_76813_b, i, k, j);
        }

        if (this.field_76814_c == 0 && this.field_76811_d == 0) {
            EntityWitherzilla witherzilla = new EntityWitherzilla(this.field_76815_a);
            witherzilla.func_70012_b((double)0.0F, (double)200.0F, (double)0.0F, this.field_76813_b.nextFloat() * 360.0F, 0.0F);
            this.field_76815_a.func_72838_d(witherzilla);
        }

    }
}
