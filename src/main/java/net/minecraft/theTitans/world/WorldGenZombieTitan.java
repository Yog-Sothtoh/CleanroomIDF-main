//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.world;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityZombieTitan;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.apache.logging.log4j.LogManager;

public class WorldGenZombieTitan extends WorldGenerator {
    private Block field_150520_a;

    public WorldGenZombieTitan(Block p_i45464_1_) {
        this.field_150520_a = p_i45464_1_;
    }

    public boolean func_76484_a(World worldIn, Random rng, int x, int y, int z) {
        if (!worldIn.func_147439_a(x, y - 1, z).func_149662_c()) {
            --y;
        } else if (worldIn.func_147439_a(x, y, z).func_149662_c()) {
            ++y;
        } else if (!worldIn.field_72995_K && worldIn.func_147437_c(x, y, z) && worldIn.func_147439_a(x, y - 1, z).func_149662_c() && rng.nextInt(100) == 0) {
            EntityZombieTitan entityomegafish = new EntityZombieTitan(worldIn);
            entityomegafish.destroyBlocksInAABBGriefingBypass(entityomegafish.field_70121_D);
            entityomegafish.func_110161_a((IEntityLivingData)null);
            entityomegafish.func_70012_b((double)((float)x + 0.5F), (double)y, (double)((float)z + 0.5F), rng.nextFloat() * 360.0F, 0.0F);
            EntityTitan otherTitan = (EntityTitan)worldIn.func_72857_a(EntityTitan.class, entityomegafish.field_70121_D.func_72314_b((double)200.0F, (double)200.0F, (double)200.0F), entityomegafish);
            if (otherTitan != null) {
                return false;
            }

            LogManager.getLogger(TheTitans.class).info("Found a succesfully spawned Zombie Titan at " + x + ", " + y + ", " + z + ", spawning.");
            worldIn.func_72838_d(entityomegafish);
            return true;
        }

        return false;
    }
}
