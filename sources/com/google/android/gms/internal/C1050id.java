package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.id */
public class C1050id implements SafeParcelable {
    public static final C1051ie CREATOR = new C1051ie();

    /* renamed from: OG */
    public final String f2869OG;

    /* renamed from: OH */
    public final String f2870OH;
    public final int versionCode;

    public C1050id(int i, String str, String str2) {
        this.versionCode = i;
        this.f2869OG = str;
        this.f2870OH = str2;
    }

    public C1050id(Context context, Locale locale) {
        this.versionCode = 0;
        this.f2869OG = context.getPackageName();
        this.f2870OH = locale.toString();
    }

    public int describeContents() {
        C1051ie ieVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof C1050id)) {
            return false;
        }
        C1050id idVar = (C1050id) object;
        return this.f2870OH.equals(idVar.f2870OH) && this.f2869OG.equals(idVar.f2869OG);
    }

    public int hashCode() {
        return C0762ep.hashCode(this.f2869OG, this.f2870OH);
    }

    public String toString() {
        return C0762ep.m1965e(this).mo5118a("clientPackageName", this.f2869OG).mo5118a("locale", this.f2870OH).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C1051ie ieVar = CREATOR;
        C1051ie.m3096a(this, out, flags);
    }
}
