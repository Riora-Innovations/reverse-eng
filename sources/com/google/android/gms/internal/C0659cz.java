package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.support.p000v4.internal.view.SupportMenu;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.cz */
public final class C0659cz {

    /* renamed from: pT */
    public static final Handler f1785pT = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static int m1533a(Context context, int i) {
        return m1534a(context.getResources().getDisplayMetrics(), i);
    }

    /* renamed from: a */
    public static int m1534a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    /* renamed from: a */
    public static void m1535a(ViewGroup viewGroup, C0504ab abVar, String str) {
        m1536a(viewGroup, abVar, str, -16777216, -1);
    }

    /* renamed from: a */
    private static void m1536a(ViewGroup viewGroup, C0504ab abVar, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            TextView textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int a = m1533a(context, 3);
            frameLayout.addView(textView, new LayoutParams(abVar.widthPixels - a, abVar.heightPixels - a, 17));
            viewGroup.addView(frameLayout, abVar.widthPixels, abVar.heightPixels);
        }
    }

    /* renamed from: a */
    public static void m1537a(ViewGroup viewGroup, C0504ab abVar, String str, String str2) {
        C0662da.m1555w(str2);
        m1536a(viewGroup, abVar, str, SupportMenu.CATEGORY_MASK, -16777216);
    }

    /* renamed from: aW */
    public static boolean m1538aW() {
        return Build.DEVICE.startsWith("generic");
    }

    /* renamed from: aX */
    public static boolean m1539aX() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: l */
    public static String m1540l(Context context) {
        String string = Secure.getString(context.getContentResolver(), "android_id");
        if (string == null || m1538aW()) {
            string = "emulator";
        }
        return m1541r(string);
    }

    /* renamed from: r */
    public static String m1541r(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, instance.digest())});
            } catch (NoSuchAlgorithmException e) {
                i++;
            }
        }
        return null;
    }
}
