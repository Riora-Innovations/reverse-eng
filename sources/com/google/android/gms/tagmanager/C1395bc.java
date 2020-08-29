package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.bc */
class C1395bc extends C1371aj {

    /* renamed from: ID */
    private static final String f3624ID = C0502a.LANGUAGE.toString();

    public C1395bc() {
        super(f3624ID, new String[0]);
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return false;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return C1488di.m4378ku();
        }
        String language = locale.getLanguage();
        return language == null ? C1488di.m4378ku() : C1488di.m4388r(language.toLowerCase());
    }
}
