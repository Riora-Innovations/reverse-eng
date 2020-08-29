package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.maps.internal.C1218c;
import com.google.android.gms.maps.internal.C1258q;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private MapsInitializer() {
    }

    public static int initialize(Context context) {
        C0766er.m1977f(context);
        try {
            C1218c A = C1258q.m3679A(context);
            try {
                CameraUpdateFactory.m3588a(A.mo6812gY());
                BitmapDescriptorFactory.m3688a(A.mo6813gZ());
                return 0;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } catch (GooglePlayServicesNotAvailableException e2) {
            return e2.errorCode;
        }
    }
}
