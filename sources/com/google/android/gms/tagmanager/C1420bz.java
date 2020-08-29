package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.bz */
class C1420bz extends C1371aj {

    /* renamed from: ID */
    private static final String f3647ID = C0502a.OS_VERSION.toString();

    public C1420bz() {
        super(f3647ID, new String[0]);
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        return C1488di.m4388r(VERSION.RELEASE);
    }
}
