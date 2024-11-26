//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package thehippomaster.AnimationAPI.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Timer;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.CommonProxy;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    private Timer mcTimer;

    public ClientProxy() {
    }

    public void initTimer() {
        this.mcTimer = (Timer)ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.func_71410_x(), AnimationAPI.fTimer);
    }

    public float getPartialTick() {
        return this.mcTimer.field_74281_c;
    }

    public World getWorldClient() {
        return FMLClientHandler.instance().getWorldClient();
    }
}
