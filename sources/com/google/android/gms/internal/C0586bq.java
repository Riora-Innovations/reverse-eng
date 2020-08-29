package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0453b.C0454a;
import com.google.android.gms.dynamic.C0456c;

/* renamed from: com.google.android.gms.internal.bq */
public final class C0586bq implements SafeParcelable {
    public static final C0585bp CREATOR = new C0585bp();

    /* renamed from: kN */
    public final C0663db f1534kN;

    /* renamed from: mZ */
    public final String f1535mZ;

    /* renamed from: nA */
    public final int f1536nA;

    /* renamed from: nr */
    public final C0580bn f1537nr;

    /* renamed from: ns */
    public final C1166u f1538ns;

    /* renamed from: nt */
    public final C0587br f1539nt;

    /* renamed from: nu */
    public final C0665dd f1540nu;

    /* renamed from: nv */
    public final C0527ap f1541nv;

    /* renamed from: nw */
    public final String f1542nw;

    /* renamed from: nx */
    public final boolean f1543nx;

    /* renamed from: ny */
    public final String f1544ny;

    /* renamed from: nz */
    public final C0592bu f1545nz;
    public final int orientation;
    public final int versionCode;

    C0586bq(int i, C0580bn bnVar, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, C0663db dbVar) {
        this.versionCode = i;
        this.f1537nr = bnVar;
        this.f1538ns = (C1166u) C0456c.m1000b(C0454a.m999G(iBinder));
        this.f1539nt = (C0587br) C0456c.m1000b(C0454a.m999G(iBinder2));
        this.f1540nu = (C0665dd) C0456c.m1000b(C0454a.m999G(iBinder3));
        this.f1541nv = (C0527ap) C0456c.m1000b(C0454a.m999G(iBinder4));
        this.f1542nw = str;
        this.f1543nx = z;
        this.f1544ny = str2;
        this.f1545nz = (C0592bu) C0456c.m1000b(C0454a.m999G(iBinder5));
        this.orientation = i2;
        this.f1536nA = i3;
        this.f1535mZ = str3;
        this.f1534kN = dbVar;
    }

    public C0586bq(C0580bn bnVar, C1166u uVar, C0587br brVar, C0592bu buVar, C0663db dbVar) {
        this.versionCode = 1;
        this.f1537nr = bnVar;
        this.f1538ns = uVar;
        this.f1539nt = brVar;
        this.f1540nu = null;
        this.f1541nv = null;
        this.f1542nw = null;
        this.f1543nx = false;
        this.f1544ny = null;
        this.f1545nz = buVar;
        this.orientation = -1;
        this.f1536nA = 4;
        this.f1535mZ = null;
        this.f1534kN = dbVar;
    }

    public C0586bq(C1166u uVar, C0587br brVar, C0527ap apVar, C0592bu buVar, C0665dd ddVar, boolean z, int i, String str, C0663db dbVar) {
        this.versionCode = 1;
        this.f1537nr = null;
        this.f1538ns = uVar;
        this.f1539nt = brVar;
        this.f1540nu = ddVar;
        this.f1541nv = apVar;
        this.f1542nw = null;
        this.f1543nx = z;
        this.f1544ny = null;
        this.f1545nz = buVar;
        this.orientation = i;
        this.f1536nA = 3;
        this.f1535mZ = str;
        this.f1534kN = dbVar;
    }

    public C0586bq(C1166u uVar, C0587br brVar, C0527ap apVar, C0592bu buVar, C0665dd ddVar, boolean z, int i, String str, String str2, C0663db dbVar) {
        this.versionCode = 1;
        this.f1537nr = null;
        this.f1538ns = uVar;
        this.f1539nt = brVar;
        this.f1540nu = ddVar;
        this.f1541nv = apVar;
        this.f1542nw = str2;
        this.f1543nx = z;
        this.f1544ny = str;
        this.f1545nz = buVar;
        this.orientation = i;
        this.f1536nA = 3;
        this.f1535mZ = null;
        this.f1534kN = dbVar;
    }

    public C0586bq(C1166u uVar, C0587br brVar, C0592bu buVar, C0665dd ddVar, int i, C0663db dbVar) {
        this.versionCode = 1;
        this.f1537nr = null;
        this.f1538ns = uVar;
        this.f1539nt = brVar;
        this.f1540nu = ddVar;
        this.f1541nv = null;
        this.f1542nw = null;
        this.f1543nx = false;
        this.f1544ny = null;
        this.f1545nz = buVar;
        this.orientation = i;
        this.f1536nA = 1;
        this.f1535mZ = null;
        this.f1534kN = dbVar;
    }

    public C0586bq(C1166u uVar, C0587br brVar, C0592bu buVar, C0665dd ddVar, boolean z, int i, C0663db dbVar) {
        this.versionCode = 1;
        this.f1537nr = null;
        this.f1538ns = uVar;
        this.f1539nt = brVar;
        this.f1540nu = ddVar;
        this.f1541nv = null;
        this.f1542nw = null;
        this.f1543nx = z;
        this.f1544ny = null;
        this.f1545nz = buVar;
        this.orientation = i;
        this.f1536nA = 2;
        this.f1535mZ = null;
        this.f1534kN = dbVar;
    }

    /* renamed from: a */
    public static C0586bq m1304a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(C0586bq.class.getClassLoader());
            return (C0586bq) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m1305a(Intent intent, C0586bq bqVar) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bqVar);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: at */
    public IBinder mo4659at() {
        return C0456c.m1001h(this.f1538ns).asBinder();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: au */
    public IBinder mo4660au() {
        return C0456c.m1001h(this.f1539nt).asBinder();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: av */
    public IBinder mo4661av() {
        return C0456c.m1001h(this.f1540nu).asBinder();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: aw */
    public IBinder mo4662aw() {
        return C0456c.m1001h(this.f1541nv).asBinder();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ax */
    public IBinder mo4663ax() {
        return C0456c.m1001h(this.f1545nz).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0585bp.m1301a(this, out, flags);
    }
}
