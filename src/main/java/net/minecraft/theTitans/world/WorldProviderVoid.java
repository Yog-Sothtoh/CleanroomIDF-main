//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.world;

import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.titan.EntityWitherzilla;
import net.minecraft.theTitans.TheTitans;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import scala.util.Random;

public class WorldProviderVoid extends WorldProvider {
    public WorldProviderVoid() {
    }

    public void func_76572_b() {
        this.field_76578_c = new WorldChunkManagerHell(TheTitans.voidland, 0.0F);
        this.field_76578_c.func_76935_a(0, 0).func_76745_m().func_76732_a(2.0F, 0.0F);
        this.field_76574_g = 200;
        this.field_76576_e = true;
    }

    public IChunkProvider func_76555_c() {
        return new ChunkProviderVoid(this.field_76579_a, this.field_76579_a.func_72905_C());
    }

    public float func_76563_a(long p_76563_1_, float p_76563_3_) {
        return 0.5F;
    }

    @SideOnly(Side.CLIENT)
    public float[] func_76560_a(float p_76560_1_, float p_76560_2_) {
        return null;
    }

    @SideOnly(Side.CLIENT)
    public Vec3 func_76562_b(float p_76562_1, float p_76562_2) {
        new Random();
        ArrayList allPlayerList = Lists.newArrayList(this.field_76579_a.field_72996_f);
        EntityWitherzilla witherzilla = null;
        if (allPlayerList != null && !allPlayerList.isEmpty()) {
            for(int i1 = 0; i1 < allPlayerList.size(); ++i1) {
                Entity entity = (Entity)allPlayerList.get(i1);
                if (entity instanceof EntityWitherzilla && entity.field_70170_p.field_73011_w == this) {
                    witherzilla = (EntityWitherzilla)entity;
                }
            }
        }

        EntityPlayer player = this.field_76579_a.func_72977_a((double)0.0F, (double)0.0F, (double)0.0F, (double)-1.0F);
        float pi = (float)Math.PI;
        double dou1 = (double)MathHelper.func_76134_b((float)player.field_70173_aa * 0.05F + pi * 1.0F);
        double dou2 = (double)MathHelper.func_76126_a((float)player.field_70173_aa * 0.05F + pi * 2.0F);
        double dou3 = -((double)MathHelper.func_76134_b((float)player.field_70173_aa * 0.05F + pi * 3.0F));
        return witherzilla != null ? (witherzilla.deathTicks > 0 ? Vec3.func_72443_a((double)1.0F, (double)1.0F, (double)1.0F) : Vec3.func_72443_a(dou1, dou2, dou3)) : Vec3.func_72443_a(0.09, 0.09, 0.09);
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

    public boolean canBlockFreeze(int x, int y, int z, boolean byWater) {
        return false;
    }

    public boolean canSnowAt(int x, int y, int z, boolean checkLight) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public float func_76571_f() {
        return 128.0F;
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
        return "The Void";
    }

    public String getInternalNameSuffix() {
        return "_void";
    }

    public String getWelcomeMessage() {
        return "Entering your DOOM!";
    }

    public String getDepartMessage() {
        return "Leaving the Void.";
    }
}
