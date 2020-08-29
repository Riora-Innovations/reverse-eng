package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0167R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.maps.internal.C1259r;

public final class CameraPosition implements SafeParcelable {
    public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
    public final float bearing;
    public final LatLng target;
    public final float tilt;

    /* renamed from: wj */
    private final int f3289wj;
    public final float zoom;

    public static final class Builder {

        /* renamed from: PF */
        private LatLng f3290PF;

        /* renamed from: PG */
        private float f3291PG;

        /* renamed from: PH */
        private float f3292PH;

        /* renamed from: PI */
        private float f3293PI;

        public Builder() {
        }

        public Builder(CameraPosition previous) {
            this.f3290PF = previous.target;
            this.f3291PG = previous.zoom;
            this.f3292PH = previous.tilt;
            this.f3293PI = previous.bearing;
        }

        public Builder bearing(float bearing) {
            this.f3293PI = bearing;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.f3290PF, this.f3291PG, this.f3292PH, this.f3293PI);
        }

        public Builder target(LatLng location) {
            this.f3290PF = location;
            return this;
        }

        public Builder tilt(float tilt) {
            this.f3292PH = tilt;
            return this;
        }

        public Builder zoom(float zoom) {
            this.f3291PG = zoom;
            return this;
        }
    }

    CameraPosition(int versionCode, LatLng target2, float zoom2, float tilt2, float bearing2) {
        C0766er.m1975b(target2, (Object) "null camera target");
        C0766er.m1976b(0.0f <= tilt2 && tilt2 <= 90.0f, (Object) "Tilt needs to be between 0 and 90 inclusive");
        this.f3289wj = versionCode;
        this.target = target2;
        this.zoom = zoom2;
        this.tilt = tilt2 + 0.0f;
        if (((double) bearing2) <= 0.0d) {
            bearing2 = (bearing2 % 360.0f) + 360.0f;
        }
        this.bearing = bearing2 % 360.0f;
    }

    public CameraPosition(LatLng target2, float zoom2, float tilt2, float bearing2) {
        this(1, target2, zoom2, tilt2, bearing2);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition camera) {
        return new Builder(camera);
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, C0167R.styleable.MapAttrs);
        LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(2) ? obtainAttributes.getFloat(2, 0.0f) : 0.0f), (double) (obtainAttributes.hasValue(3) ? obtainAttributes.getFloat(3, 0.0f) : 0.0f));
        Builder builder = builder();
        builder.target(latLng);
        if (obtainAttributes.hasValue(5)) {
            builder.zoom(obtainAttributes.getFloat(5, 0.0f));
        }
        if (obtainAttributes.hasValue(1)) {
            builder.bearing(obtainAttributes.getFloat(1, 0.0f));
        }
        if (obtainAttributes.hasValue(4)) {
            builder.tilt(obtainAttributes.getFloat(4, 0.0f));
        }
        return builder.build();
    }

    public static final CameraPosition fromLatLngZoom(LatLng target2, float zoom2) {
        return new CameraPosition(target2, zoom2, 0.0f, 0.0f);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) o;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f3289wj;
    }

    public int hashCode() {
        return C0762ep.hashCode(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        return C0762ep.m1965e(this).mo5118a("target", this.target).mo5118a("zoom", Float.valueOf(this.zoom)).mo5118a("tilt", Float.valueOf(this.tilt)).mo5118a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1259r.m3686hc()) {
            C1262a.m3716a(this, out, flags);
        } else {
            CameraPositionCreator.m3690a(this, out, flags);
        }
    }
}
