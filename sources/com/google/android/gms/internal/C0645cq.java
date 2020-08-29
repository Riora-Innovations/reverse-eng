package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;

/* renamed from: com.google.android.gms.internal.cq */
public class C0645cq {

    /* renamed from: mg */
    private final Object f1758mg = new Object();

    /* renamed from: pA */
    private int f1759pA = 0;

    /* renamed from: pB */
    private long f1760pB = -1;

    /* renamed from: pC */
    private long f1761pC = -1;

    /* renamed from: pD */
    private int f1762pD = 0;

    /* renamed from: pE */
    private int f1763pE = -1;

    /* renamed from: pz */
    private final String f1764pz;

    public C0645cq(String str) {
        this.f1764pz = str;
    }

    /* renamed from: aJ */
    public synchronized void mo4781aJ() {
        synchronized (this.f1758mg) {
            this.f1762pD++;
        }
    }

    /* renamed from: aK */
    public void mo4782aK() {
        synchronized (this.f1758mg) {
            this.f1759pA++;
        }
    }

    /* renamed from: b */
    public Bundle mo4783b(String str, Context context) {
        Bundle bundle;
        synchronized (this.f1758mg) {
            bundle = new Bundle();
            bundle.putString("session_id", this.f1764pz);
            bundle.putLong("basets", this.f1761pC);
            bundle.putLong("currts", this.f1760pB);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.f1763pE);
            bundle.putInt("pclick", this.f1759pA);
            bundle.putInt("pimp", this.f1762pD);
            C0640cm cmVar = new C0640cm(context);
            bundle.putInt("gnt", cmVar.f1714oY);
            if (cmVar.f1713oX == 1) {
                bundle.putString("net", "wi");
            } else {
                bundle.putString("net", "ed");
            }
        }
        return bundle;
    }

    /* renamed from: b */
    public void mo4784b(C1173z zVar, long j) {
        synchronized (this.f1758mg) {
            if (this.f1761pC == -1) {
                this.f1761pC = j;
                this.f1760pB = this.f1761pC;
            } else {
                this.f1760pB = j;
            }
            if (zVar.extras == null || zVar.extras.getInt("gw", 2) != 1) {
                this.f1763pE++;
            }
        }
    }
}
