package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0167R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1214a;
import com.google.android.gms.maps.internal.C1259r;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final GoogleMapOptionsCreator CREATOR = new GoogleMapOptionsCreator();

    /* renamed from: Pc */
    private Boolean f3228Pc;

    /* renamed from: Pd */
    private Boolean f3229Pd;

    /* renamed from: Pe */
    private int f3230Pe;

    /* renamed from: Pf */
    private CameraPosition f3231Pf;

    /* renamed from: Pg */
    private Boolean f3232Pg;

    /* renamed from: Ph */
    private Boolean f3233Ph;

    /* renamed from: Pi */
    private Boolean f3234Pi;

    /* renamed from: Pj */
    private Boolean f3235Pj;

    /* renamed from: Pk */
    private Boolean f3236Pk;

    /* renamed from: Pl */
    private Boolean f3237Pl;

    /* renamed from: wj */
    private final int f3238wj;

    public GoogleMapOptions() {
        this.f3230Pe = -1;
        this.f3238wj = 1;
    }

    GoogleMapOptions(int versionCode, byte zOrderOnTop, byte useViewLifecycleInFragment, int mapType, CameraPosition camera, byte zoomControlsEnabled, byte compassEnabled, byte scrollGesturesEnabled, byte zoomGesturesEnabled, byte tiltGesturesEnabled, byte rotateGesturesEnabled) {
        this.f3230Pe = -1;
        this.f3238wj = versionCode;
        this.f3228Pc = C1214a.m3630a(zOrderOnTop);
        this.f3229Pd = C1214a.m3630a(useViewLifecycleInFragment);
        this.f3230Pe = mapType;
        this.f3231Pf = camera;
        this.f3232Pg = C1214a.m3630a(zoomControlsEnabled);
        this.f3233Ph = C1214a.m3630a(compassEnabled);
        this.f3234Pi = C1214a.m3630a(scrollGesturesEnabled);
        this.f3235Pj = C1214a.m3630a(zoomGesturesEnabled);
        this.f3236Pk = C1214a.m3630a(tiltGesturesEnabled);
        this.f3237Pl = C1214a.m3630a(rotateGesturesEnabled);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, C0167R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(0)) {
            googleMapOptions.mapType(obtainAttributes.getInt(0, -1));
        }
        if (obtainAttributes.hasValue(13)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(13, false));
        }
        if (obtainAttributes.hasValue(12)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(12, false));
        }
        if (obtainAttributes.hasValue(6)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(6, true));
        }
        if (obtainAttributes.hasValue(7)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(7, true));
        }
        if (obtainAttributes.hasValue(8)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(8, true));
        }
        if (obtainAttributes.hasValue(9)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(9, true));
        }
        if (obtainAttributes.hasValue(11)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(11, true));
        }
        if (obtainAttributes.hasValue(10)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(10, true));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attrs));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public GoogleMapOptions camera(CameraPosition camera) {
        this.f3231Pf = camera;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean enabled) {
        this.f3233Ph = Boolean.valueOf(enabled);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: gN */
    public byte mo6621gN() {
        return C1214a.m3631c(this.f3228Pc);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: gO */
    public byte mo6622gO() {
        return C1214a.m3631c(this.f3229Pd);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: gP */
    public byte mo6623gP() {
        return C1214a.m3631c(this.f3232Pg);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: gQ */
    public byte mo6624gQ() {
        return C1214a.m3631c(this.f3233Ph);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: gR */
    public byte mo6625gR() {
        return C1214a.m3631c(this.f3234Pi);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: gS */
    public byte mo6626gS() {
        return C1214a.m3631c(this.f3235Pj);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: gT */
    public byte mo6627gT() {
        return C1214a.m3631c(this.f3236Pk);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: gU */
    public byte mo6628gU() {
        return C1214a.m3631c(this.f3237Pl);
    }

    public CameraPosition getCamera() {
        return this.f3231Pf;
    }

    public Boolean getCompassEnabled() {
        return this.f3233Ph;
    }

    public int getMapType() {
        return this.f3230Pe;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.f3237Pl;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.f3234Pi;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.f3236Pk;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.f3229Pd;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f3238wj;
    }

    public Boolean getZOrderOnTop() {
        return this.f3228Pc;
    }

    public Boolean getZoomControlsEnabled() {
        return this.f3232Pg;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.f3235Pj;
    }

    public GoogleMapOptions mapType(int mapType) {
        this.f3230Pe = mapType;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean enabled) {
        this.f3237Pl = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean enabled) {
        this.f3234Pi = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean enabled) {
        this.f3236Pk = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.f3229Pd = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1259r.m3686hc()) {
            C1199a.m3622a(this, out, flags);
        } else {
            GoogleMapOptionsCreator.m3608a(this, out, flags);
        }
    }

    public GoogleMapOptions zOrderOnTop(boolean zOrderOnTop) {
        this.f3228Pc = Boolean.valueOf(zOrderOnTop);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean enabled) {
        this.f3232Pg = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean enabled) {
        this.f3235Pj = Boolean.valueOf(enabled);
        return this;
    }
}
