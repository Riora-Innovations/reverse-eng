package com.google.android.gms.tagmanager;

import android.os.Build;
import android.support.p000v4.p002os.EnvironmentCompat;
import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.aa */
class C1362aa extends C1371aj {

    /* renamed from: ID */
    private static final String f3571ID = C0502a.DEVICE_NAME.toString();

    public C1362aa() {
        super(f3571ID, new String[0]);
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (!str2.startsWith(str) && !str.equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
            str2 = str + " " + str2;
        }
        return C1488di.m4388r(str2);
    }
}
