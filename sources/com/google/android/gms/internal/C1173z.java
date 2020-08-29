package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.z */
public final class C1173z implements SafeParcelable {
    public static final C0503aa CREATOR = new C0503aa();
    public final Bundle extras;

    /* renamed from: le */
    public final long f3158le;

    /* renamed from: lf */
    public final int f3159lf;

    /* renamed from: lg */
    public final List<String> f3160lg;

    /* renamed from: lh */
    public final boolean f3161lh;

    /* renamed from: li */
    public final boolean f3162li;

    /* renamed from: lj */
    public final String f3163lj;

    /* renamed from: lk */
    public final C0524am f3164lk;

    /* renamed from: ll */
    public final Location f3165ll;

    /* renamed from: lm */
    public final String f3166lm;
    public final int tagForChildDirectedTreatment;
    public final int versionCode;

    C1173z(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, C0524am amVar, Location location, String str2) {
        this.versionCode = i;
        this.f3158le = j;
        this.extras = bundle;
        this.f3159lf = i2;
        this.f3160lg = list;
        this.f3161lh = z;
        this.tagForChildDirectedTreatment = i3;
        this.f3162li = z2;
        this.f3163lj = str;
        this.f3164lk = amVar;
        this.f3165ll = location;
        this.f3166lm = str2;
    }

    public C1173z(Context context, C0520aj ajVar) {
        C0524am amVar = null;
        this.versionCode = 3;
        Date birthday = ajVar.getBirthday();
        this.f3158le = birthday != null ? birthday.getTime() : -1;
        this.f3166lm = ajVar.getContentUrl();
        this.f3159lf = ajVar.getGender();
        Set keywords = ajVar.getKeywords();
        this.f3160lg = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        this.f3161lh = ajVar.isTestDevice(context);
        this.tagForChildDirectedTreatment = ajVar.mo4526al();
        this.f3165ll = ajVar.getLocation();
        AdMobExtras adMobExtras = (AdMobExtras) ajVar.getNetworkExtras(AdMobExtras.class);
        this.extras = adMobExtras != null ? adMobExtras.getExtras() : null;
        this.f3162li = ajVar.getManualImpressionsEnabled();
        this.f3163lj = ajVar.getPublisherProvidedId();
        SearchAdRequest aj = ajVar.mo4524aj();
        if (aj != null) {
            amVar = new C0524am(aj);
        }
        this.f3164lk = amVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0503aa.m1148a(this, out, flags);
    }
}
