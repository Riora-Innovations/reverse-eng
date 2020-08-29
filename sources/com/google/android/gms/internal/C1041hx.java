package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* renamed from: com.google.android.gms.internal.hx */
public final class C1041hx extends C1028hm implements SafeParcelable {
    public static final C1044hy CREATOR = new C1044hy();

    /* renamed from: Od */
    private final Bundle f2823Od;

    /* renamed from: Oe */
    private final C1045hz f2824Oe;

    /* renamed from: Of */
    private final LatLng f2825Of;

    /* renamed from: Og */
    private final float f2826Og;

    /* renamed from: Oh */
    private final LatLngBounds f2827Oh;

    /* renamed from: Oi */
    private final String f2828Oi;

    /* renamed from: Oj */
    private final Uri f2829Oj;

    /* renamed from: Ok */
    private final boolean f2830Ok;

    /* renamed from: Ol */
    private final float f2831Ol;

    /* renamed from: Om */
    private final int f2832Om;

    /* renamed from: On */
    private final long f2833On;

    /* renamed from: Oo */
    private final List<C1035ht> f2834Oo;

    /* renamed from: Op */
    private final Map<C1035ht, String> f2835Op;

    /* renamed from: Oq */
    private final TimeZone f2836Oq;

    /* renamed from: Or */
    private Locale f2837Or;

    /* renamed from: Os */
    private C1049ic f2838Os;

    /* renamed from: uS */
    private final String f2839uS;

    /* renamed from: wj */
    final int f2840wj;

    /* renamed from: com.google.android.gms.internal.hx$a */
    public static final class C1042a implements SafeParcelable {
        public static final C1040hw CREATOR = new C1040hw();

        /* renamed from: LE */
        private final String f2841LE;

        /* renamed from: Ot */
        private final String f2842Ot;

        /* renamed from: Ou */
        private final int f2843Ou;
        private final String mTag;

        /* renamed from: wj */
        final int f2844wj;

        /* renamed from: com.google.android.gms.internal.hx$a$a */
        public static class C1043a {

            /* renamed from: LE */
            private final String f2845LE;

            /* renamed from: Ot */
            private String f2846Ot;

            /* renamed from: Ou */
            private int f2847Ou;
            private final String mTag;

            public C1043a(String str, String str2) {
                this.f2845LE = str;
                this.mTag = str2;
            }

            /* renamed from: aK */
            public C1043a mo5816aK(String str) {
                this.f2846Ot = str;
                return this;
            }

            /* renamed from: bv */
            public C1043a mo5817bv(int i) {
                this.f2847Ou = i;
                return this;
            }

            /* renamed from: gJ */
            public C1042a mo5818gJ() {
                return new C1042a(0, this.f2845LE, this.mTag, this.f2846Ot, this.f2847Ou);
            }
        }

        C1042a(int i, String str, String str2, String str3, int i2) {
            this.f2844wj = i;
            this.f2841LE = str;
            this.mTag = str2;
            this.f2842Ot = str3;
            this.f2843Ou = i2;
        }

        public int describeContents() {
            C1040hw hwVar = CREATOR;
            return 0;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof C1042a)) {
                return false;
            }
            C1042a aVar = (C1042a) object;
            return this.f2841LE.equals(aVar.f2841LE) && C0762ep.equal(this.mTag, aVar.mTag);
        }

        /* renamed from: gH */
        public String mo5809gH() {
            return this.f2842Ot;
        }

        /* renamed from: gI */
        public int mo5810gI() {
            return this.f2843Ou;
        }

        public String getTag() {
            return this.mTag;
        }

        /* renamed from: gt */
        public String mo5812gt() {
            return this.f2841LE;
        }

        public int hashCode() {
            return C0762ep.hashCode(this.f2841LE, this.mTag, this.f2842Ot, Integer.valueOf(this.f2843Ou));
        }

        public String toString() {
            return C0762ep.m1965e(this).mo5118a("placeId", this.f2841LE).mo5118a("tag", this.mTag).mo5118a("callingAppPackageName", this.f2842Ot).mo5118a("callingAppVersionCode", Integer.valueOf(this.f2843Ou)).toString();
        }

        public void writeToParcel(Parcel parcel, int flags) {
            C1040hw hwVar = CREATOR;
            C1040hw.m3055a(this, parcel, flags);
        }
    }

    C1041hx(int i, String str, List<C1035ht> list, Bundle bundle, C1045hz hzVar, LatLng latLng, float f, LatLngBounds latLngBounds, String str2, Uri uri, boolean z, float f2, int i2, long j) {
        this.f2840wj = i;
        this.f2839uS = str;
        this.f2834Oo = Collections.unmodifiableList(list);
        this.f2823Od = bundle;
        this.f2824Oe = hzVar;
        this.f2825Of = latLng;
        this.f2826Og = f;
        this.f2827Oh = latLngBounds;
        this.f2828Oi = str2;
        this.f2829Oj = uri;
        this.f2830Ok = z;
        this.f2831Ol = f2;
        this.f2832Om = i2;
        this.f2833On = j;
        HashMap hashMap = new HashMap();
        for (String str3 : bundle.keySet()) {
            hashMap.put(C1035ht.m3048aI(str3), bundle.getString(str3));
        }
        this.f2835Op = Collections.unmodifiableMap(hashMap);
        this.f2836Oq = TimeZone.getTimeZone(this.f2828Oi);
        this.f2837Or = null;
        this.f2838Os = null;
    }

    /* renamed from: aJ */
    private void m3058aJ(String str) {
        if (this.f2838Os != null) {
            this.f2838Os.mo5838a(new C1043a(this.f2839uS, str));
        }
    }

    public int describeContents() {
        C1044hy hyVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof C1041hx)) {
            return false;
        }
        C1041hx hxVar = (C1041hx) object;
        return this.f2839uS.equals(hxVar.f2839uS) && C0762ep.equal(this.f2837Or, hxVar.f2837Or) && this.f2833On == hxVar.f2833On;
    }

    /* renamed from: gA */
    public Uri mo5791gA() {
        m3058aJ("getWebsiteUri");
        return this.f2829Oj;
    }

    /* renamed from: gB */
    public boolean mo5792gB() {
        m3058aJ("isPermanentlyClosed");
        return this.f2830Ok;
    }

    /* renamed from: gC */
    public int mo5793gC() {
        m3058aJ("getPriceLevel");
        return this.f2832Om;
    }

    /* renamed from: gD */
    public long mo5794gD() {
        return this.f2833On;
    }

    /* renamed from: gE */
    public Bundle mo5795gE() {
        return this.f2823Od;
    }

    /* renamed from: gF */
    public C1045hz mo5796gF() {
        return this.f2824Oe;
    }

    /* renamed from: gG */
    public String mo5797gG() {
        return this.f2828Oi;
    }

    public String getId() {
        m3058aJ("getId");
        return this.f2839uS;
    }

    public float getRating() {
        m3058aJ("getRating");
        return this.f2831Ol;
    }

    /* renamed from: gw */
    public List<C1035ht> mo5800gw() {
        m3058aJ("getTypes");
        return this.f2834Oo;
    }

    /* renamed from: gx */
    public LatLng mo5801gx() {
        m3058aJ("getLatLng");
        return this.f2825Of;
    }

    /* renamed from: gy */
    public float mo5802gy() {
        m3058aJ("getLevelNumber");
        return this.f2826Og;
    }

    /* renamed from: gz */
    public LatLngBounds mo5803gz() {
        m3058aJ("getViewport");
        return this.f2827Oh;
    }

    public int hashCode() {
        return C0762ep.hashCode(this.f2839uS, this.f2837Or, Long.valueOf(this.f2833On));
    }

    public String toString() {
        return C0762ep.m1965e(this).mo5118a("id", this.f2839uS).mo5118a("localization", this.f2824Oe).mo5118a("locale", this.f2837Or).mo5118a("latlng", this.f2825Of).mo5118a("levelNumber", Float.valueOf(this.f2826Og)).mo5118a("viewport", this.f2827Oh).mo5118a("timeZone", this.f2828Oi).mo5118a("websiteUri", this.f2829Oj).mo5118a("isPermanentlyClosed", Boolean.valueOf(this.f2830Ok)).mo5118a("priceLevel", Integer.valueOf(this.f2832Om)).mo5118a("timestampSecs", Long.valueOf(this.f2833On)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1044hy hyVar = CREATOR;
        C1044hy.m3076a(this, parcel, flags);
    }
}
