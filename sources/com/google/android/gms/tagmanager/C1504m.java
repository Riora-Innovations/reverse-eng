package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.m */
class C1504m extends C1371aj {

    /* renamed from: ID */
    private static final String f3852ID = C0502a.CONSTANT.toString();
    private static final String VALUE = C0546b.VALUE.toString();

    public C1504m() {
        super(f3852ID, VALUE);
    }

    /* renamed from: iB */
    public static String m4431iB() {
        return f3852ID;
    }

    /* renamed from: iC */
    public static String m4432iC() {
        return VALUE;
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        return (C0661a) map.get(VALUE);
    }
}
