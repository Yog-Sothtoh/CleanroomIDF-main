//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.world;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.titan.EntitySpiderTitan;
import net.minecraft.init.Blocks;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.apache.logging.log4j.LogManager;

public class WorldGenSpiderTitan extends WorldGenerator {
    private Block field_150520_a;

    public WorldGenSpiderTitan(Block p_i45464_1_) {
        this.field_150520_a = p_i45464_1_;
    }

    public boolean func_76484_a(World worldIn, Random rng, int x, int y, int z) {
        if (!worldIn.func_147439_a(x, y - 1, z).func_149662_c()) {
            --y;
        } else if (worldIn.func_147439_a(x, y, z).func_149662_c()) {
            ++y;
        } else if (!worldIn.field_72995_K && worldIn.func_147437_c(x, y, z) && worldIn.func_147439_a(x, y - 1, z).func_149662_c() && rng.nextInt(30) == 0) {
            EntitySpiderTitan entityomegafish = new EntitySpiderTitan(worldIn);
            entityomegafish.destroyBlocksInAABBGriefingBypass(entityomegafish.field_70121_D);
            entityomegafish.func_110161_a((IEntityLivingData)null);
            entityomegafish.func_70012_b((double)((float)x + 0.5F), (double)y, (double)((float)z + 0.5F), rng.nextFloat() * 360.0F, 0.0F);
            worldIn.func_72838_d(entityomegafish);
            LogManager.getLogger(TheTitans.class).info("Found a succesfully spawned Spider Titan at " + x + ", " + y + ", " + z + ", spawning.");
            this.generateSpidersWeb(worldIn, x, y, z);
            return true;
        }

        return false;
    }

    private void generateSpidersWeb(World worldIn, int x, int y, int z) {
        for(int l1 = x - 11; l1 <= x + 11; ++l1) {
            for(int j1 = y - 11; j1 <= y; ++j1) {
                for(int i2 = z - 11; i2 <= z + 11; ++i2) {
                    if (worldIn.func_147439_a(l1, j1, i2).func_149712_f(worldIn, l1, j1, i2) != -1.0F) {
                        worldIn.func_147465_d(l1, j1, i2, Blocks.field_150321_G, 0, 2);
                    }
                }
            }
        }

    }
}
