//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderNowhere extends WorldProvider {
    public WorldProviderNowhere() {
    }

    public void func_76572_b() {
        this.field_76578_c = new WorldChuckNowhere(TheTitans.nowhere, 0.0F);
        this.field_76578_c.func_76935_a(0, 0).func_76745_m().func_76732_a(0.0F, 0.0F);
        this.field_76574_g = 201;
        this.field_76576_e = true;
    }

    public IChunkProvider func_76555_c() {
        return new ChunkProviderNowhere(this.field_76579_a, this.field_76579_a.func_72905_C());
    }

    public float func_76563_a(long p_76563_1_, float p_76563_3_) {
        return 0.0F;
    }

    @SideOnly(Side.CLIENT)
    public float[] func_76560_a(float p_76560_1_, float p_76560_2_) {
        return null;
    }

    public boolean canBlockFreeze(int x, int y, int z, boolean byWater) {
        return false;
    }

    public boolean canSnowAt(int x, int y, int z, boolean checkLight) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public Vec3 func_76562_b(float p_76562_1, float p_76562_2) {
        return Vec3.func_72443_a(0.196078431372549, 0.0196078431372549, 0.196078431372549);
    }

    @SideOnly(Side.CLIENT)
    public boolean func_76561_g() {
        return false;
    }

    public boolean func_76567_e() {
        return false;
    }

    public boolean func_76569_d() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public float func_76571_f() {
        return 8.0F;
    }

    public boolean func_76566_a(int p_76566_1_, int p_76566_2_) {
        return this.field_76579_a.func_147474_b(p_76566_1_, p_76566_2_).func_149688_o().func_76230_c();
    }

    public ChunkCoordinates func_76554_h() {
        return new ChunkCoordinates(100, 50, 0);
    }

    public int func_76557_i() {
        return 50;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_76568_b(int p_76568_1_, int p_76568_2_) {
        return true;
    }

    public String func_80007_l() {
        return "The Nowhere";
    }

    public String getInternalNameSuffix() {
        return "_nowhere";
    }

    public String getWelcomeMessage() {
        return "Entering your DEATH!";
    }

    public String getDepartMessage() {
        return "Leaving the Nowhere.";
    }
}
