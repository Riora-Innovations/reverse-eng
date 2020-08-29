package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.common.GooglePlayServicesUtil;

/* renamed from: com.google.android.gms.internal.ek */
public class C0751ek {

    /* renamed from: Cb */
    private static final Uri f2049Cb = Uri.parse("http://plus.google.com/");

    /* renamed from: Cc */
    private static final Uri f2050Cc = f2049Cb.buildUpon().appendPath("circles").appendPath("find").build();

    /* renamed from: af */
    public static Intent m1900af(String str) {
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    /* renamed from: ag */
    private static Uri m1901ag(String str) {
        return Uri.parse("market://details").buildUpon().appendQueryParameter("id", str).build();
    }

    /* renamed from: ah */
    public static Intent m1902ah(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(m1901ag(str));
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        return intent;
    }

    /* renamed from: ai */
    public static Intent m1903ai(String str) {
        Uri parse = Uri.parse("bazaar://search?q=pname:" + str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.setFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        return intent;
    }

    /* renamed from: eh */
    public static Intent m1904eh() {
        return new Intent("android.settings.DATE_SETTINGS");
    }
}
