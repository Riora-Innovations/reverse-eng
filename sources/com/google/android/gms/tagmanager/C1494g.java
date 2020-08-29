package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.g */
class C1494g extends C1371aj {

    /* renamed from: ID */
    private static final String f3841ID = C0502a.APP_NAME.toString();
    private final Context mContext;

    public C1494g(Context context) {
        super(f3841ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return C1488di.m4388r(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (NameNotFoundException e) {
            C1401bh.m4073c("App name is not found.", e);
            return C1488di.m4378ku();
        }
    }
}
