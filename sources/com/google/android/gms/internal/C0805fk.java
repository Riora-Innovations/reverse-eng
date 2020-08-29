package com.google.android.gms.internal;

import android.util.Base64;

/* renamed from: com.google.android.gms.internal.fk */
public final class C0805fk {
    /* renamed from: d */
    public static String m2112d(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    /* renamed from: e */
    public static String m2113e(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 10);
    }
}
