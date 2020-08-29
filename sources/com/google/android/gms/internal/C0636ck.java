package com.google.android.gms.internal;

import com.google.android.gms.plus.PlusShare;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ck */
public final class C0636ck {
    /* access modifiers changed from: private */

    /* renamed from: mg */
    public final Object f1683mg = new Object();
    /* access modifiers changed from: private */

    /* renamed from: nX */
    public int f1684nX = -2;

    /* renamed from: ng */
    private C0665dd f1685ng;

    /* renamed from: oA */
    public final C0536ar f1686oA = new C0536ar() {
        /* renamed from: a */
        public void mo4576a(C0665dd ddVar, Map<String, String> map) {
            synchronized (C0636ck.this.f1683mg) {
                String str = (String) map.get(PlusShare.KEY_CALL_TO_ACTION_URL);
                if (str == null) {
                    C0662da.m1555w("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (str.contains("%40mediation_adapters%40")) {
                    str = str.replaceAll("%40mediation_adapters%40", C0647cs.m1495b(ddVar.getContext(), (String) map.get("check_adapters"), C0636ck.this.f1687ox));
                    C0662da.m1554v("Ad request URL modified to " + str);
                }
                C0636ck.this.f1688oy = str;
                C0636ck.this.f1683mg.notify();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: ox */
    public String f1687ox;
    /* access modifiers changed from: private */

    /* renamed from: oy */
    public String f1688oy;

    /* renamed from: oz */
    public final C0536ar f1689oz = new C0536ar() {
        /* renamed from: a */
        public void mo4576a(C0665dd ddVar, Map<String, String> map) {
            synchronized (C0636ck.this.f1683mg) {
                String str = (String) map.get("errors");
                C0662da.m1555w("Invalid " + ((String) map.get("type")) + " request error: " + str);
                C0636ck.this.f1684nX = 1;
                C0636ck.this.f1683mg.notify();
            }
        }
    };

    public C0636ck(String str) {
        this.f1687ox = str;
    }

    /* renamed from: aI */
    public String mo4762aI() {
        String str;
        synchronized (this.f1683mg) {
            while (this.f1688oy == null && this.f1684nX == -2) {
                try {
                    this.f1683mg.wait();
                } catch (InterruptedException e) {
                    C0662da.m1555w("Ad request service was interrupted.");
                    str = null;
                }
            }
            str = this.f1688oy;
        }
        return str;
    }

    /* renamed from: b */
    public void mo4763b(C0665dd ddVar) {
        synchronized (this.f1683mg) {
            this.f1685ng = ddVar;
        }
    }

    public int getErrorCode() {
        int i;
        synchronized (this.f1683mg) {
            i = this.f1684nX;
        }
        return i;
    }
}
