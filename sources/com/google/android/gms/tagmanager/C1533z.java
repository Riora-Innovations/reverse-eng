package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.z */
class C1533z extends C1371aj {

    /* renamed from: ID */
    private static final String f3920ID = C0502a.DEVICE_ID.toString();
    private final Context mContext;

    public C1533z(Context context) {
        super(f3920ID, new String[0]);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: G */
    public String mo7821G(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        String G = mo7821G(this.mContext);
        return G == null ? C1488di.m4378ku() : C1488di.m4388r(G);
    }
}
