//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.titan.EntityWitherzillaMinion;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenVoid extends BiomeGenBase {
    public BiomeGenVoid(int p_i1990_1_) {
        super(p_i1990_1_);
        this.field_76761_J.clear();
        this.field_76762_K.clear();
        this.field_76755_L.clear();
        this.field_82914_M.clear();
        this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityWitherzillaMinion.class, 100, 12, 12));
        this.field_76752_A = Blocks.field_150357_h;
        this.field_76753_B = Blocks.field_150357_h;
        this.field_76760_I = new BiomeVoidDecorator();
    }

    @SideOnly(Side.CLIENT)
    public int func_76731_a(float p_76731_1_) {
        return 0;
    }
}
