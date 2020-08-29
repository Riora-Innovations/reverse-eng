package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.C0171a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.ab */
public final class C0504ab implements SafeParcelable {
    public static final C0505ac CREATOR = new C0505ac();
    public final int height;
    public final int heightPixels;

    /* renamed from: ln */
    public final String f1194ln;

    /* renamed from: lo */
    public final boolean f1195lo;

    /* renamed from: lp */
    public final C0504ab[] f1196lp;
    public final int versionCode;
    public final int width;
    public final int widthPixels;

    public C0504ab() {
        this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
    }

    C0504ab(int i, String str, int i2, int i3, boolean z, int i4, int i5, C0504ab[] abVarArr) {
        this.versionCode = i;
        this.f1194ln = str;
        this.height = i2;
        this.heightPixels = i3;
        this.f1195lo = z;
        this.width = i4;
        this.widthPixels = i5;
        this.f1196lp = abVarArr;
    }

    public C0504ab(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public C0504ab(Context context, AdSize[] adSizeArr) {
        int i;
        AdSize adSize = adSizeArr[0];
        this.versionCode = 2;
        this.f1195lo = false;
        this.width = adSize.getWidth();
        this.height = adSize.getHeight();
        boolean z = this.width == -1;
        boolean z2 = this.height == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            this.widthPixels = m1151a(displayMetrics);
            i = (int) (((float) this.widthPixels) / displayMetrics.density);
        } else {
            int i2 = this.width;
            this.widthPixels = C0659cz.m1534a(displayMetrics, this.width);
            i = i2;
        }
        int i3 = z2 ? m1153c(displayMetrics) : this.height;
        this.heightPixels = C0659cz.m1534a(displayMetrics, i3);
        if (z || z2) {
            this.f1194ln = i + "x" + i3 + "_as";
        } else {
            this.f1194ln = adSize.toString();
        }
        if (adSizeArr.length > 1) {
            this.f1196lp = new C0504ab[adSizeArr.length];
            for (int i4 = 0; i4 < adSizeArr.length; i4++) {
                this.f1196lp[i4] = new C0504ab(context, adSizeArr[i4]);
            }
            return;
        }
        this.f1196lp = null;
    }

    public C0504ab(C0504ab abVar, C0504ab[] abVarArr) {
        this(2, abVar.f1194ln, abVar.height, abVar.heightPixels, abVar.f1195lo, abVar.width, abVar.widthPixels, abVarArr);
    }

    /* renamed from: a */
    public static int m1151a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    /* renamed from: b */
    public static int m1152b(DisplayMetrics displayMetrics) {
        return (int) (((float) m1153c(displayMetrics)) * displayMetrics.density);
    }

    /* renamed from: c */
    private static int m1153c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    /* renamed from: ai */
    public AdSize mo4484ai() {
        return C0171a.m19a(this.width, this.height, this.f1194ln);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0505ac.m1155a(this, out, flags);
    }
}
