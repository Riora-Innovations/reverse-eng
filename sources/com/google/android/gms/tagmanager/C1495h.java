package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.h */
class C1495h extends C1371aj {

    /* renamed from: ID */
    private static final String f3842ID = C0502a.APP_VERSION.toString();
    private final Context mContext;

    public C1495h(Context context) {
        super(f3842ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        try {
            return C1488di.m4388r(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            C1401bh.m4075t("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return C1488di.m4378ku();
        }
    }
}
