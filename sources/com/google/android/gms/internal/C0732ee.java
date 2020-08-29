package com.google.android.gms.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ee */
public final class C0732ee {

    /* renamed from: Bo */
    private final C0733a f1996Bo;

    /* renamed from: zp */
    private final View f1997zp;

    /* renamed from: com.google.android.gms.internal.ee$a */
    public static final class C0733a implements SafeParcelable {
        public static final C0765eq CREATOR = new C0765eq();

        /* renamed from: Bp */
        private final List<String> f1998Bp;

        /* renamed from: vi */
        private final String f1999vi;

        /* renamed from: wj */
        private final int f2000wj;

        /* renamed from: zo */
        private final int f2001zo;

        /* renamed from: zq */
        private final String f2002zq;

        C0733a(int i, String str, List<String> list, int i2, String str2) {
            this.f1998Bp = new ArrayList();
            this.f2000wj = i;
            this.f1999vi = str;
            this.f1998Bp.addAll(list);
            this.f2001zo = i2;
            this.f2002zq = str2;
        }

        public C0733a(String str, Collection<String> collection, int i, String str2) {
            this(3, str, new ArrayList(collection), i, str2);
        }

        /* renamed from: dR */
        public String mo5025dR() {
            return this.f1999vi != null ? this.f1999vi : "<<default account>>";
        }

        /* renamed from: dS */
        public int mo5026dS() {
            return this.f2001zo;
        }

        /* renamed from: dT */
        public List<String> mo5027dT() {
            return new ArrayList(this.f1998Bp);
        }

        /* renamed from: dV */
        public String mo5028dV() {
            return this.f2002zq;
        }

        public int describeContents() {
            return 0;
        }

        public String getAccountName() {
            return this.f1999vi;
        }

        public int getVersionCode() {
            return this.f2000wj;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0765eq.m1967a(this, out, flags);
        }
    }

    public C0732ee(String str, Collection<String> collection, int i, View view, String str2) {
        this.f1996Bo = new C0733a(str, collection, i, str2);
        this.f1997zp = view;
    }

    /* renamed from: dR */
    public String mo5018dR() {
        return this.f1996Bo.mo5025dR();
    }

    /* renamed from: dS */
    public int mo5019dS() {
        return this.f1996Bo.mo5026dS();
    }

    /* renamed from: dT */
    public List<String> mo5020dT() {
        return this.f1996Bo.mo5027dT();
    }

    /* renamed from: dU */
    public String[] mo5021dU() {
        return (String[]) this.f1996Bo.mo5027dT().toArray(new String[0]);
    }

    /* renamed from: dV */
    public String mo5022dV() {
        return this.f1996Bo.mo5028dV();
    }

    /* renamed from: dW */
    public View mo5023dW() {
        return this.f1997zp;
    }

    public String getAccountName() {
        return this.f1996Bo.getAccountName();
    }
}
