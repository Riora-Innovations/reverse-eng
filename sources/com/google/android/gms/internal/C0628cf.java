package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.cf */
public final class C0628cf implements SafeParcelable {
    public static final C0629cg CREATOR = new C0629cg();
    public final int errorCode;

    /* renamed from: mt */
    public final List<String> f1663mt;

    /* renamed from: mu */
    public final List<String> f1664mu;

    /* renamed from: mx */
    public final long f1665mx;

    /* renamed from: nw */
    public final String f1666nw;

    /* renamed from: oi */
    public final String f1667oi;

    /* renamed from: oj */
    public final long f1668oj;

    /* renamed from: ok */
    public final boolean f1669ok;

    /* renamed from: ol */
    public final long f1670ol;

    /* renamed from: om */
    public final List<String> f1671om;

    /* renamed from: on */
    public final String f1672on;

    /* renamed from: oo */
    public final long f1673oo;
    public final int orientation;
    public final int versionCode;

    public C0628cf(int i) {
        this(3, null, null, null, i, null, -1, false, -1, null, -1, -1, null, -1);
    }

    C0628cf(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4) {
        this.versionCode = i;
        this.f1666nw = str;
        this.f1667oi = str2;
        this.f1663mt = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.f1664mu = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.f1668oj = j;
        this.f1669ok = z;
        this.f1670ol = j2;
        this.f1671om = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.f1665mx = j3;
        this.orientation = i3;
        this.f1672on = str3;
        this.f1673oo = j4;
    }

    public C0628cf(String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4) {
        this(3, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0629cg.m1429a(this, out, flags);
    }
}
