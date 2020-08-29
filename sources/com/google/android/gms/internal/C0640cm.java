package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.cm */
public final class C0640cm {

    /* renamed from: oM */
    public final int f1702oM;

    /* renamed from: oN */
    public final boolean f1703oN;

    /* renamed from: oO */
    public final boolean f1704oO;

    /* renamed from: oP */
    public final String f1705oP;

    /* renamed from: oQ */
    public final String f1706oQ;

    /* renamed from: oR */
    public final boolean f1707oR;

    /* renamed from: oS */
    public final boolean f1708oS;

    /* renamed from: oT */
    public final boolean f1709oT;

    /* renamed from: oU */
    public final String f1710oU;

    /* renamed from: oV */
    public final String f1711oV;

    /* renamed from: oW */
    public final int f1712oW;

    /* renamed from: oX */
    public final int f1713oX;

    /* renamed from: oY */
    public final int f1714oY;

    /* renamed from: oZ */
    public final int f1715oZ;

    /* renamed from: pa */
    public final int f1716pa;

    /* renamed from: pb */
    public final int f1717pb;

    /* renamed from: pc */
    public final float f1718pc;

    /* renamed from: pd */
    public final int f1719pd;

    /* renamed from: pe */
    public final int f1720pe;

    public C0640cm(Context context) {
        boolean z = true;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Locale locale = Locale.getDefault();
        PackageManager packageManager = context.getPackageManager();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.f1702oM = audioManager.getMode();
        this.f1703oN = m1470a(packageManager, "geo:0,0?q=donuts") != null;
        if (m1470a(packageManager, "http://www.google.com") == null) {
            z = false;
        }
        this.f1704oO = z;
        this.f1705oP = telephonyManager.getNetworkOperator();
        this.f1706oQ = locale.getCountry();
        this.f1707oR = C0659cz.m1538aW();
        this.f1708oS = audioManager.isMusicActive();
        this.f1709oT = audioManager.isSpeakerphoneOn();
        this.f1710oU = locale.getLanguage();
        this.f1711oV = m1471a(packageManager);
        this.f1712oW = audioManager.getStreamVolume(3);
        this.f1713oX = m1469a(context, connectivityManager, packageManager);
        this.f1714oY = telephonyManager.getNetworkType();
        this.f1715oZ = telephonyManager.getPhoneType();
        this.f1716pa = audioManager.getRingerMode();
        this.f1717pb = audioManager.getStreamVolume(2);
        this.f1718pc = displayMetrics.density;
        this.f1719pd = displayMetrics.widthPixels;
        this.f1720pe = displayMetrics.heightPixels;
    }

    /* renamed from: a */
    private static int m1469a(Context context, ConnectivityManager connectivityManager, PackageManager packageManager) {
        if (!C0653cv.m1509a(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            return -2;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getType();
        }
        return -1;
    }

    /* renamed from: a */
    private static ResolveInfo m1470a(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    /* renamed from: a */
    private static String m1471a(PackageManager packageManager) {
        ResolveInfo a = m1470a(packageManager, "market://details?id=com.google.android.gms.ads");
        if (a == null) {
            return null;
        }
        ActivityInfo activityInfo = a.activityInfo;
        if (activityInfo == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode + "." + activityInfo.packageName;
            }
            return null;
        } catch (NameNotFoundException e) {
            return null;
        }
    }
}
