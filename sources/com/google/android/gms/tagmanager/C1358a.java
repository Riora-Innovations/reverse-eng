package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.C0806fl;
import com.google.android.gms.internal.C0808fn;
import java.io.IOException;

/* renamed from: com.google.android.gms.tagmanager.a */
class C1358a {

    /* renamed from: TA */
    private static C1358a f3560TA;

    /* renamed from: qI */
    private static Object f3561qI = new Object();

    /* renamed from: Tv */
    private volatile long f3562Tv;

    /* renamed from: Tw */
    private volatile long f3563Tw;

    /* renamed from: Tx */
    private volatile long f3564Tx;

    /* renamed from: Ty */
    private final C0806fl f3565Ty;

    /* renamed from: Tz */
    private C1361a f3566Tz;
    private volatile boolean mClosed;
    /* access modifiers changed from: private */
    public final Context mContext;

    /* renamed from: pI */
    private final Thread f3567pI;

    /* renamed from: qK */
    private volatile Info f3568qK;

    /* renamed from: com.google.android.gms.tagmanager.a$a */
    public interface C1361a {
        /* renamed from: ix */
        Info mo7564ix();
    }

    private C1358a(Context context) {
        this(context, null, C0808fn.m2115eI());
    }

    C1358a(Context context, C1361a aVar, C0806fl flVar) {
        this.f3562Tv = 900000;
        this.f3563Tw = 30000;
        this.mClosed = false;
        this.f3566Tz = new C1361a() {
            /* renamed from: ix */
            public Info mo7564ix() {
                boolean z = false;
                try {
                    return AdvertisingIdClient.getAdvertisingIdInfo(C1358a.this.mContext);
                } catch (IllegalStateException e) {
                    C1401bh.m4078w("IllegalStateException getting Advertising Id Info");
                    return z;
                } catch (GooglePlayServicesRepairableException e2) {
                    C1401bh.m4078w("GooglePlayServicesRepairableException getting Advertising Id Info");
                    return z;
                } catch (IOException e3) {
                    C1401bh.m4078w("IOException getting Ad Id Info");
                    return z;
                } catch (GooglePlayServicesNotAvailableException e4) {
                    C1401bh.m4078w("GooglePlayServicesNotAvailableException getting Advertising Id Info");
                    return z;
                } catch (Exception e5) {
                    C1401bh.m4078w("Unknown exception. Could not get the Advertising Id Info.");
                    return z;
                }
            }
        };
        this.f3565Ty = flVar;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (aVar != null) {
            this.f3566Tz = aVar;
        }
        this.f3567pI = new Thread(new Runnable() {
            public void run() {
                C1358a.this.m3980iv();
            }
        });
    }

    /* renamed from: E */
    static C1358a m3977E(Context context) {
        if (f3560TA == null) {
            synchronized (f3561qI) {
                if (f3560TA == null) {
                    f3560TA = new C1358a(context);
                    f3560TA.start();
                }
            }
        }
        return f3560TA;
    }

    /* access modifiers changed from: private */
    /* renamed from: iv */
    public void m3980iv() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.f3568qK = this.f3566Tz.mo7564ix();
                Thread.sleep(this.f3562Tv);
            } catch (InterruptedException e) {
                C1401bh.m4076u("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    /* renamed from: iw */
    private void m3981iw() {
        if (this.f3565Ty.currentTimeMillis() - this.f3564Tx >= this.f3563Tw) {
            interrupt();
            this.f3564Tx = this.f3565Ty.currentTimeMillis();
        }
    }

    /* access modifiers changed from: 0000 */
    public void interrupt() {
        this.f3567pI.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        m3981iw();
        if (this.f3568qK == null) {
            return true;
        }
        return this.f3568qK.isLimitAdTrackingEnabled();
    }

    /* renamed from: iu */
    public String mo7562iu() {
        m3981iw();
        if (this.f3568qK == null) {
            return null;
        }
        return this.f3568qK.getId();
    }

    /* access modifiers changed from: 0000 */
    public void start() {
        this.f3567pI.start();
    }
}
