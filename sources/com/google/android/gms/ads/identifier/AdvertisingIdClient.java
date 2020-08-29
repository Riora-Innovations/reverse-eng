package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C0292a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.internal.C1163t;
import com.google.android.gms.internal.C1163t.C1164a;
import java.io.IOException;

public final class AdvertisingIdClient {

    public static final class Info {

        /* renamed from: kF */
        private final String f66kF;

        /* renamed from: kG */
        private final boolean f67kG;

        public Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.f66kF = advertisingId;
            this.f67kG = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.f66kF;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.f67kG;
        }
    }

    /* renamed from: a */
    static Info m22a(Context context, C0292a aVar) throws IOException {
        try {
            C1163t b = C1164a.m3528b(aVar.mo3247dm());
            Info info = new Info(b.getId(), b.mo6444a(true));
            try {
                context.unbindService(aVar);
            } catch (IllegalArgumentException e) {
                Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", e);
            }
            return info;
        } catch (RemoteException e2) {
            Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
            throw new IOException("Remote exception");
        } catch (InterruptedException e3) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            try {
                context.unbindService(aVar);
            } catch (IllegalArgumentException e4) {
                Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", e4);
            }
            throw th;
        }
    }

    /* renamed from: g */
    private static C0292a m23g(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            try {
                GooglePlayServicesUtil.m430s(context);
                C0292a aVar = new C0292a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                if (context.bindService(intent, aVar, 1)) {
                    return aVar;
                }
                throw new IOException("Connection failure");
            } catch (GooglePlayServicesNotAvailableException e) {
                throw new IOException(e);
            }
        } catch (NameNotFoundException e2) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        C0766er.m1973ad("Calling this from your main thread can lead to deadlock");
        return m22a(context, m23g(context));
    }
}
