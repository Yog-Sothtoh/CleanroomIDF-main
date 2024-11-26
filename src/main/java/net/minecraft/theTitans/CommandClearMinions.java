//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.entity.titan.EntityHarcadiumArrow;
import net.minecraft.entity.titan.EntityTitan;
import net.minecraft.entity.titan.EntityTitanSpirit;
import net.minecraft.entity.titanminion.ITemplar;
import net.minecraft.util.ChatComponentTranslation;

public class CommandClearMinions extends CommandBase {
    public CommandClearMinions() {
    }

    public String func_71517_b() {
        return "clearMinions";
    }

    public int func_82362_a() {
        return 0;
    }

    public String func_71518_a(ICommandSender p_71518_1_) {
        return "commands.killminions.usage";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
        EntityPlayerMP entityplayermp = func_71521_c(p_71515_1_);
        p_71515_1_.func_145747_a(new ChatComponentTranslation("commands.killminions.processing", new Object[0]));
        List list = entityplayermp.field_70170_p.field_72996_f;
        if (list != null && !list.isEmpty()) {
            for(int i1 = 0; i1 < list.size(); ++i1) {
                Entity entity = (Entity)list.get(i1);
                if (entity != null && (!entity.func_70089_S() && !(entity instanceof EntityTitan) && !(entity instanceof EntityTitanSpirit) || entity.getClass() == (Class)EntityList.field_75625_b.get("MutantCreatures.SpiderPig") || entity.getClass() == (Class)EntityList.field_75625_b.get("Scorpion") || entity.getClass() == (Class)EntityList.field_75625_b.get("PurplePower") || entity instanceof ITemplar || entity instanceof EntitySlime || entity instanceof EntityFallingBlock || entity instanceof EntityHarcadiumArrow || entity instanceof EntityArrow || entity instanceof EntityFireball || entity instanceof EntityTNTPrimed || entity instanceof EntityItem || entity instanceof EntityXPOrb || entity instanceof EntityThrowable)) {
                    entity.func_70106_y();
                    entity.field_70128_L = true;
                }
            }
        }

        p_71515_1_.func_145747_a(new ChatComponentTranslation("commands.killminions.success", new Object[0]));
    }
}
