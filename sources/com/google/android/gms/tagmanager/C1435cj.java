package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.cj */
class C1435cj extends C1371aj {

    /* renamed from: ID */
    private static final String f3692ID = C0502a.RESOLUTION.toString();
    private final Context mContext;

    public C1435cj(Context context) {
        super(f3692ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        return C1488di.m4388r(i + "x" + displayMetrics.heightPixels);
    }
}
