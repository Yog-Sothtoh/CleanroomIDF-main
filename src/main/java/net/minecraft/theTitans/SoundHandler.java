//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class SoundHandler {
    public SoundHandler() {
    }

    public static void onEntityPlay(String name, World world, Entity entityName, float volume, float pitch) {
        world.func_72956_a(entityName, "thetitans:" + name, volume, pitch);
    }
}
