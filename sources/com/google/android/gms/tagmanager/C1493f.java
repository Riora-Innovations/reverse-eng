package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.f */
class C1493f extends C1371aj {

    /* renamed from: ID */
    private static final String f3840ID = C0502a.APP_ID.toString();
    private final Context mContext;

    public C1493f(Context context) {
        super(f3840ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        return C1488di.m4388r(this.mContext.getPackageName());
    }
}
