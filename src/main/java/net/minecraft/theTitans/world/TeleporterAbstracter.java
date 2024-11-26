//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.theTitans.world;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterAbstracter extends Teleporter {
    private final WorldServer worldServerInstance;
    private final Random random;
    private final LongHashMap destinationCoordinateCache = new LongHashMap();
    private final List destinationCoordinateKeys = new ArrayList();

    public TeleporterAbstracter(WorldServer par1WorldServer) {
        super(par1WorldServer);
        this.worldServerInstance = par1WorldServer;
        this.random = new Random(par1WorldServer.func_72905_C());
    }

    public void func_77185_a(Entity par1Entity, double par2, double par4, double par6, float par8) {
        if (this.worldServerInstance.field_73011_w.field_76574_g != 1) {
            if (!this.func_77184_b(par1Entity, par2, par4, par6, par8)) {
                this.func_85188_a(par1Entity);
                this.func_77184_b(par1Entity, par2, par4, par6, par8);
            }
        } else {
            int i = MathHelper.func_76128_c(par1Entity.field_70165_t);
            int j = MathHelper.func_76128_c(par1Entity.field_70163_u) - 1;
            int k = MathHelper.func_76128_c(par1Entity.field_70161_v);
            byte b0 = 1;
            byte b1 = 0;

            for(int l = -2; l <= 2; ++l) {
                for(int i1 = -2; i1 <= 2; ++i1) {
                    for(int j1 = -1; j1 < 3; ++j1) {
                        int k1 = i + i1 * b0 + l * b1;
                        int var10000 = j + j1;
                        int i2 = k + i1 * b1 - l * b0;
                        boolean var20 = j1 < 0;
                    }
                }
            }

            par1Entity.func_70012_b((double)i, (double)j, (double)k, par1Entity.field_70177_z, 0.0F);
            par1Entity.field_70159_w = par1Entity.field_70181_x = par1Entity.field_70179_y = (double)0.0F;
        }

    }

    public boolean func_77184_b(Entity par1Entity, double par2, double par4, double par6, float par8) {
        short short1 = 128;
        double d3 = (double)-1.0F;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = MathHelper.func_76128_c(par1Entity.field_70165_t);
        int i1 = MathHelper.func_76128_c(par1Entity.field_70161_v);
        long j1 = ChunkCoordIntPair.func_77272_a(l, i1);
        boolean flag = true;
        if (this.destinationCoordinateCache.func_76161_b(j1)) {
            Teleporter.PortalPosition portalposition = (Teleporter.PortalPosition)this.destinationCoordinateCache.func_76164_a(j1);
            d3 = (double)0.0F;
            i = portalposition.field_71574_a;
            j = portalposition.field_71572_b;
            k = portalposition.field_71573_c;
            portalposition.field_85087_d = this.worldServerInstance.func_82737_E();
            flag = false;
        } else {
            for(int k1 = l - short1; k1 <= l + short1; ++k1) {
                double d5 = (double)k1 + (double)0.5F - par1Entity.field_70165_t;

                for(int l1 = i1 - short1; l1 <= i1 + short1; ++l1) {
                    double d6 = (double)l1 + (double)0.5F - par1Entity.field_70161_v;

                    for(int i2 = this.worldServerInstance.func_72940_L() - 1; i2 >= 0; --i2) {
                    }
                }
            }
        }

        if (d3 >= (double)0.0F) {
            if (flag) {
                this.destinationCoordinateCache.func_76163_a(j1, new Teleporter.PortalPosition(this, i, j, k, this.worldServerInstance.func_82737_E()));
                this.destinationCoordinateKeys.add(j1);
            }

            double d8 = (double)i + (double)0.5F;
            double d9 = (double)j + (double)0.5F;
            double d4 = (double)k + (double)0.5F;
            int j2 = -1;
            int k2 = par1Entity.func_82148_at();
            if (j2 > -1) {
                int l2 = Direction.field_71578_g[j2];
                int i3 = Direction.field_71583_a[j2];
                int j3 = Direction.field_71581_b[j2];
                int k3 = Direction.field_71583_a[l2];
                int l3 = Direction.field_71581_b[l2];
                boolean flag1 = !this.worldServerInstance.func_147437_c(i + i3 + k3, j, k + j3 + l3) || !this.worldServerInstance.func_147437_c(i + i3 + k3, j + 1, k + j3 + l3);
                boolean flag2 = !this.worldServerInstance.func_147437_c(i + i3, j, k + j3) || !this.worldServerInstance.func_147437_c(i + i3, j + 1, k + j3);
                if (flag1 && flag2) {
                    j2 = Direction.field_71580_e[j2];
                    l2 = Direction.field_71580_e[l2];
                    i3 = Direction.field_71583_a[j2];
                    j3 = Direction.field_71581_b[j2];
                    k3 = Direction.field_71583_a[l2];
                    l3 = Direction.field_71581_b[l2];
                    int k1 = i - k3;
                    d8 -= (double)k3;
                    int i4 = k - l3;
                    d4 -= (double)l3;
                    flag1 = !this.worldServerInstance.func_147437_c(k1 + i3 + k3, j, i4 + j3 + l3) || !this.worldServerInstance.func_147437_c(k1 + i3 + k3, j + 1, i4 + j3 + l3);
                    flag2 = !this.worldServerInstance.func_147437_c(k1 + i3, j, i4 + j3) || !this.worldServerInstance.func_147437_c(k1 + i3, j + 1, i4 + j3);
                }

                float f1 = 0.5F;
                float f2 = 0.5F;
                if (!flag1 && flag2) {
                    f1 = 1.0F;
                } else if (flag1 && !flag2) {
                    f1 = 0.0F;
                } else if (flag1 && flag2) {
                    f2 = 0.0F;
                }

                d8 += (double)((float)k3 * f1 + f2 * (float)i3);
                d4 += (double)((float)l3 * f1 + f2 * (float)j3);
                float f3 = 0.0F;
                float f4 = 0.0F;
                float f5 = 0.0F;
                float f6 = 0.0F;
                if (j2 == k2) {
                    f3 = 1.0F;
                    f4 = 1.0F;
                } else if (j2 == Direction.field_71580_e[k2]) {
                    f3 = -1.0F;
                    f4 = -1.0F;
                } else if (j2 == Direction.field_71577_f[k2]) {
                    f5 = 1.0F;
                    f6 = -1.0F;
                } else {
                    f5 = -1.0F;
                    f6 = 1.0F;
                }

                double d10 = par1Entity.field_70159_w;
                double d11 = par1Entity.field_70179_y;
                par1Entity.field_70159_w = d10 * (double)f3 + d11 * (double)f6;
                par1Entity.field_70179_y = d10 * (double)f5 + d11 * (double)f4;
                par1Entity.field_70177_z = par8 - (float)(k2 * 90) + (float)(j2 * 90);
            } else {
                par1Entity.field_70159_w = par1Entity.field_70181_x = par1Entity.field_70179_y = (double)0.0F;
            }

            par1Entity.func_70012_b(d8, d9, d4, par1Entity.field_70177_z, par1Entity.field_70125_A);
            return true;
        } else {
            return false;
        }
    }

    public boolean func_85188_a(Entity par1Entity) {
        byte b0 = 16;
        double d0 = (double)-1.0F;
        int i = MathHelper.func_76128_c(par1Entity.field_70165_t);
        int j = MathHelper.func_76128_c(par1Entity.field_70163_u);
        int k = MathHelper.func_76128_c(par1Entity.field_70161_v);
        int l = i;
        int i1 = j;
        int j1 = k;
        int k1 = 0;
        int l1 = this.random.nextInt(4);

        for(int i2 = i - b0; i2 <= i + b0; ++i2) {
            double d1 = (double)i2 + (double)0.5F - par1Entity.field_70165_t;

            for(int j2 = k - b0; j2 <= k + b0; ++j2) {
                double d2 = (double)j2 + (double)0.5F - par1Entity.field_70161_v;

                label287:
                for(int k2 = this.worldServerInstance.func_72940_L() - 1; k2 >= 0; --k2) {
                    if (this.worldServerInstance.func_147437_c(i2, k2, j2)) {
                        while(k2 > 0 && this.worldServerInstance.func_147437_c(i2, k2 - 1, j2)) {
                            --k2;
                        }

                        for(int i3 = l1; i3 < l1 + 4; ++i3) {
                            int l2 = i3 % 2;
                            int k3 = 1 - l2;
                            if (i3 % 4 >= 2) {
                                l2 = -l2;
                                k3 = -k3;
                            }

                            for(int j3 = 0; j3 < 3; ++j3) {
                                for(int i4 = 0; i4 < 4; ++i4) {
                                    for(int l3 = -1; l3 < 4; ++l3) {
                                        int k4 = i2 + (i4 - 1) * l2 + j3 * k3;
                                        int j4 = k2 + l3;
                                        int l4 = j2 + (i4 - 1) * k3 - j3 * l2;
                                        if (l3 < 0 && !this.worldServerInstance.func_147439_a(k4, j4, l4).func_149688_o().func_76220_a() || l3 >= 0 && !this.worldServerInstance.func_147437_c(k4, j4, l4)) {
                                            continue label287;
                                        }
                                    }
                                }
                            }

                            double d4 = (double)k2 + (double)0.5F - par1Entity.field_70163_u;
                            double d3 = d1 * d1 + d4 * d4 + d2 * d2;
                            if (d0 < (double)0.0F || d3 < d0) {
                                d0 = d3;
                                l = i2;
                                i1 = k2;
                                j1 = j2;
                                k1 = i3 % 4;
                            }
                        }
                    }
                }
            }
        }

        if (d0 < (double)0.0F) {
            for(int var37 = i - b0; var37 <= i + b0; ++var37) {
                double d1 = (double)var37 + (double)0.5F - par1Entity.field_70165_t;

                for(int j2 = k - b0; j2 <= k + b0; ++j2) {
                    double d2 = (double)j2 + (double)0.5F - par1Entity.field_70161_v;

                    label224:
                    for(int k2 = this.worldServerInstance.func_72940_L() - 1; k2 >= 0; --k2) {
                        if (this.worldServerInstance.func_147437_c(var37, k2, j2)) {
                            while(k2 > 0 && this.worldServerInstance.func_147437_c(var37, k2 - 1, j2)) {
                                --k2;
                            }

                            for(int i3 = l1; i3 < l1 + 2; ++i3) {
                                int l2 = i3 % 2;
                                int k3 = 1 - l2;

                                for(int j3 = 0; j3 < 4; ++j3) {
                                    for(int i4 = -1; i4 < 4; ++i4) {
                                        int l3 = var37 + (j3 - 1) * l2;
                                        int k4 = k2 + i4;
                                        int j4 = j2 + (j3 - 1) * k3;
                                        if (i4 < 0 && !this.worldServerInstance.func_147439_a(l3, k4, j4).func_149688_o().func_76220_a() || i4 >= 0 && !this.worldServerInstance.func_147437_c(l3, k4, j4)) {
                                            continue label224;
                                        }
                                    }
                                }

                                double d4 = (double)k2 + (double)0.5F - par1Entity.field_70163_u;
                                double d3 = d1 * d1 + d4 * d4 + d2 * d2;
                                if (d0 < (double)0.0F || d3 < d0) {
                                    d0 = d3;
                                    l = var37;
                                    i1 = k2;
                                    j1 = j2;
                                    k1 = i3 % 2;
                                }
                            }
                        }
                    }
                }
            }
        }

        int i5 = l;
        int j5 = i1;
        int j2 = j1;
        int k5 = k1 % 2;
        int l5 = 1 - k5;
        if (k1 % 4 >= 2) {
            k5 = -k5;
            l5 = -l5;
        }

        if (d0 < (double)0.0F) {
            if (i1 < 70) {
                i1 = 70;
            }

            if (i1 > this.worldServerInstance.func_72940_L() - 10) {
                i1 = this.worldServerInstance.func_72940_L() - 10;
            }

            j5 = i1;

            for(int k2 = -1; k2 <= 1; ++k2) {
                for(int i3 = 1; i3 < 3; ++i3) {
                    for(int l2 = -1; l2 < 3; ++l2) {
                        int k3 = i5 + (i3 - 1) * k5 + k2 * l5;
                        int var10000 = j5 + l2;
                        int i4 = j2 + (i3 - 1) * l5 - k2 * k5;
                        boolean flag = l2 < 0;
                    }
                }
            }
        }

        for(int k2 = 0; k2 < 4; ++k2) {
            for(int i3 = 0; i3 < 4; ++i3) {
                for(int l2 = -1; l2 < 4; ++l2) {
                    int var64 = i5 + (i3 - 1) * k5;
                    var64 = j5 + l2;
                    var64 = j2 + (i3 - 1) * l5;
                    if (i3 != 0 && i3 != 3 && l2 != -1 && l2 != 3) {
                        var64 = 0;
                    } else {
                        var64 = 1;
                    }
                }
            }

            for(int var52 = 0; var52 < 4; ++var52) {
                for(int l2 = -1; l2 < 4; ++l2) {
                    int var69 = i5 + (var52 - 1) * k5;
                    var69 = j5 + l2;
                    var69 = j2 + (var52 - 1) * l5;
                }
            }
        }

        return true;
    }

    public void func_85189_a(long par1) {
        if (par1 % 100L == 0L) {
            Iterator iterator = this.destinationCoordinateKeys.iterator();
            long j = par1 - 600L;

            while(iterator.hasNext()) {
                Long olong = (Long)iterator.next();
                Teleporter.PortalPosition portalposition = (Teleporter.PortalPosition)this.destinationCoordinateCache.func_76164_a(olong);
                if (portalposition == null || portalposition.field_85087_d < j) {
                    iterator.remove();
                    this.destinationCoordinateCache.func_76159_d(olong);
                }
            }
        }

    }
}
