package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.analytics.a */
class C0180a implements C0211m {

    /* renamed from: qI */
    private static Object f140qI = new Object();

    /* renamed from: qJ */
    private static C0180a f141qJ;
    private Context mContext;

    /* renamed from: qK */
    private Info f142qK;

    /* renamed from: qL */
    private long f143qL;

    private C0180a(Context context) {
        this.mContext = context;
    }

    /* renamed from: bj */
    private Info m69bj() {
        boolean z = false;
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
        } catch (IllegalStateException e) {
            C0181aa.m75w("IllegalStateException getting Ad Id Info");
            return z;
        } catch (GooglePlayServicesRepairableException e2) {
            C0181aa.m75w("GooglePlayServicesRepairableException getting Ad Id Info");
            return z;
        } catch (IOException e3) {
            C0181aa.m75w("IOException getting Ad Id Info");
            return z;
        } catch (GooglePlayServicesNotAvailableException e4) {
            C0181aa.m75w("GooglePlayServicesNotAvailableException getting Ad Id Info");
            return z;
        } catch (Exception e5) {
            C0181aa.m75w("Unknown exception. Could not get the ad Id.");
            return z;
        }
    }

    /* renamed from: m */
    public static C0211m m70m(Context context) {
        if (f141qJ == null) {
            synchronized (f140qI) {
                if (f141qJ == null) {
                    f141qJ = new C0180a(context);
                }
            }
        }
        return f141qJ;
    }

    public String getValue(String field) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f143qL > 1000) {
            this.f142qK = m69bj();
            this.f143qL = currentTimeMillis;
        }
        if (this.f142qK != null) {
            if ("&adid".equals(field)) {
                return this.f142qK.getId();
            }
            if ("&ate".equals(field)) {
                return this.f142qK.isLimitAdTrackingEnabled() ? "1" : "0";
            }
        }
        return null;
    }
}
