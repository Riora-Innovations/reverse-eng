package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.k */
public class C1142k extends C1107j {

    /* renamed from: com.google.android.gms.internal.k$a */
    class C1143a {

        /* renamed from: kl */
        private String f3118kl;

        /* renamed from: km */
        private boolean f3119km;

        public C1143a(String str, boolean z) {
            this.f3118kl = str;
            this.f3119km = z;
        }

        public String getId() {
            return this.f3118kl;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.f3119km;
        }
    }

    private C1142k(Context context, C1154n nVar, C1155o oVar) {
        super(context, nVar, oVar);
    }

    /* renamed from: a */
    public static C1142k m3452a(String str, Context context) {
        C0723e eVar = new C0723e();
        m3297a(str, context, eVar);
        return new C1142k(context, eVar, new C1158q(239));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5832b(Context context) {
        long j = 1;
        super.mo5832b(context);
        try {
            C1143a f = mo6418f(context);
            try {
                if (!f.isLimitAdTrackingEnabled()) {
                    j = 0;
                }
                mo5829a(28, j);
                String id = f.getId();
                if (id != null) {
                    mo5830a(30, id);
                }
            } catch (IOException e) {
            }
        } catch (GooglePlayServicesNotAvailableException e2) {
        } catch (IOException e3) {
            mo5829a(28, 1);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public C1143a mo6418f(Context context) throws IOException, GooglePlayServicesNotAvailableException {
        String str;
        int i = 0;
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            String id = advertisingIdInfo.getId();
            if (id == null || !id.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
                str = id;
            } else {
                byte[] bArr = new byte[16];
                int i2 = 0;
                while (i < id.length()) {
                    if (i == 8 || i == 13 || i == 18 || i == 23) {
                        i++;
                    }
                    bArr[i2] = (byte) ((Character.digit(id.charAt(i), 16) << 4) + Character.digit(id.charAt(i + 1), 16));
                    i2++;
                    i += 2;
                }
                str = this.f2854ka.mo4987a(bArr, true);
            }
            return new C1143a(str, advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (GooglePlayServicesRepairableException e) {
            throw new IOException(e);
        }
    }
}
