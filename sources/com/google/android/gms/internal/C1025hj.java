package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.hj */
public class C1025hj implements SafeParcelable, Geofence {
    public static final C1026hk CREATOR = new C1026hk();

    /* renamed from: Hh */
    private final String f2675Hh;

    /* renamed from: KU */
    private final int f2676KU;

    /* renamed from: KW */
    private final short f2677KW;

    /* renamed from: KX */
    private final double f2678KX;

    /* renamed from: KY */
    private final double f2679KY;

    /* renamed from: KZ */
    private final float f2680KZ;

    /* renamed from: La */
    private final int f2681La;

    /* renamed from: Lb */
    private final int f2682Lb;

    /* renamed from: Lz */
    private final long f2683Lz;

    /* renamed from: wj */
    private final int f2684wj;

    public C1025hj(int i, String str, int i2, short s, double d, double d2, float f, long j, int i3, int i4) {
        m3020aH(str);
        m3021b(f);
        m3019a(d, d2);
        int bn = m3022bn(i2);
        this.f2684wj = i;
        this.f2677KW = s;
        this.f2675Hh = str;
        this.f2678KX = d;
        this.f2679KY = d2;
        this.f2680KZ = f;
        this.f2683Lz = j;
        this.f2676KU = bn;
        this.f2681La = i3;
        this.f2682Lb = i4;
    }

    public C1025hj(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        this(1, str, i, s, d, d2, f, j, i2, i3);
    }

    /* renamed from: a */
    private static void m3019a(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        } else if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    /* renamed from: aH */
    private static void m3020aH(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    /* renamed from: b */
    private static void m3021b(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    /* renamed from: bn */
    private static int m3022bn(int i) {
        int i2 = i & 7;
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("No supported transition specified: " + i);
    }

    /* renamed from: bo */
    private static String m3023bo(int i) {
        switch (i) {
            case 1:
                return "CIRCLE";
            default:
                return null;
        }
    }

    /* renamed from: h */
    public static C1025hj m3024h(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        C1025hj av = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return av;
    }

    public int describeContents() {
        C1026hk hkVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof C1025hj)) {
            return false;
        }
        C1025hj hjVar = (C1025hj) obj;
        if (this.f2680KZ != hjVar.f2680KZ) {
            return false;
        }
        if (this.f2678KX != hjVar.f2678KX) {
            return false;
        }
        if (this.f2679KY != hjVar.f2679KY) {
            return false;
        }
        return this.f2677KW == hjVar.f2677KW;
    }

    public long getExpirationTime() {
        return this.f2683Lz;
    }

    public double getLatitude() {
        return this.f2678KX;
    }

    public double getLongitude() {
        return this.f2679KY;
    }

    public int getNotificationResponsiveness() {
        return this.f2681La;
    }

    public String getRequestId() {
        return this.f2675Hh;
    }

    public int getVersionCode() {
        return this.f2684wj;
    }

    /* renamed from: gn */
    public short mo5728gn() {
        return this.f2677KW;
    }

    /* renamed from: go */
    public float mo5729go() {
        return this.f2680KZ;
    }

    /* renamed from: gp */
    public int mo5730gp() {
        return this.f2676KU;
    }

    /* renamed from: gq */
    public int mo5731gq() {
        return this.f2682Lb;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f2678KX);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f2679KY);
        return (((((((i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.f2680KZ)) * 31) + this.f2677KW) * 31) + this.f2676KU;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{m3023bo(this.f2677KW), this.f2675Hh, Integer.valueOf(this.f2676KU), Double.valueOf(this.f2678KX), Double.valueOf(this.f2679KY), Float.valueOf(this.f2680KZ), Integer.valueOf(this.f2681La / 1000), Integer.valueOf(this.f2682Lb), Long.valueOf(this.f2683Lz)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1026hk hkVar = CREATOR;
        C1026hk.m3029a(this, parcel, flags);
    }
}
