package com.google.android.gms.internal;

import com.google.android.gms.internal.C1041hx.C1042a;
import com.google.android.gms.internal.C1041hx.C1042a.C1043a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.internal.ic */
public class C1049ic {

    /* renamed from: OB */
    private static int f2861OB = 10000;

    /* renamed from: OC */
    private static int f2862OC = 1000;

    /* renamed from: Lk */
    private final C1027hl<C1013hg> f2863Lk;

    /* renamed from: OD */
    private final String f2864OD;

    /* renamed from: OE */
    private final BlockingQueue<C1042a> f2865OE;

    /* renamed from: OF */
    private int f2866OF;

    /* renamed from: Ou */
    private final int f2867Ou;

    /* renamed from: mg */
    private final Object f2868mg = new Object();

    public C1049ic(C1027hl<C1013hg> hlVar, String str, int i) {
        this.f2863Lk = hlVar;
        this.f2864OD = str;
        this.f2867Ou = i;
        this.f2865OE = new LinkedBlockingQueue(f2861OB);
        this.f2866OF = f2862OC;
    }

    /* renamed from: a */
    public void mo5838a(C1043a aVar) {
        aVar.mo5816aK(this.f2864OD);
        aVar.mo5817bv(this.f2867Ou);
        this.f2865OE.offer(aVar.mo5818gJ());
    }
}
