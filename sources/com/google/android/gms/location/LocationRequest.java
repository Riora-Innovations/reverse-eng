package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0762ep;

public final class LocationRequest implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;

    /* renamed from: KV */
    long f3185KV;

    /* renamed from: Lc */
    long f3186Lc;

    /* renamed from: Ld */
    long f3187Ld;

    /* renamed from: Le */
    boolean f3188Le;

    /* renamed from: Lf */
    int f3189Lf;

    /* renamed from: Lg */
    float f3190Lg;
    int mPriority;

    /* renamed from: wj */
    private final int f3191wj;

    public LocationRequest() {
        this.f3191wj = 1;
        this.mPriority = PRIORITY_BALANCED_POWER_ACCURACY;
        this.f3186Lc = 3600000;
        this.f3187Ld = 600000;
        this.f3188Le = false;
        this.f3185KV = Long.MAX_VALUE;
        this.f3189Lf = Integer.MAX_VALUE;
        this.f3190Lg = 0.0f;
    }

    LocationRequest(int versionCode, int priority, long interval, long fastestInterval, boolean explicitFastestInterval, long expireAt, int numUpdates, float smallestDisplacement) {
        this.f3191wj = versionCode;
        this.mPriority = priority;
        this.f3186Lc = interval;
        this.f3187Ld = fastestInterval;
        this.f3188Le = explicitFastestInterval;
        this.f3185KV = expireAt;
        this.f3189Lf = numUpdates;
        this.f3190Lg = smallestDisplacement;
    }

    /* renamed from: a */
    private static void m3576a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    /* renamed from: bi */
    private static void m3577bi(int i) {
        switch (i) {
            case 100:
            case PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
            case PRIORITY_LOW_POWER /*104*/:
            case PRIORITY_NO_POWER /*105*/:
                return;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    /* renamed from: bj */
    public static String m3578bj(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case PRIORITY_LOW_POWER /*104*/:
                return "PRIORITY_LOW_POWER";
            case PRIORITY_NO_POWER /*105*/:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
        }
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    /* renamed from: r */
    private static void m3579r(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) object;
        return this.mPriority == locationRequest.mPriority && this.f3186Lc == locationRequest.f3186Lc && this.f3187Ld == locationRequest.f3187Ld && this.f3188Le == locationRequest.f3188Le && this.f3185KV == locationRequest.f3185KV && this.f3189Lf == locationRequest.f3189Lf && this.f3190Lg == locationRequest.f3190Lg;
    }

    public long getExpirationTime() {
        return this.f3185KV;
    }

    public long getFastestInterval() {
        return this.f3187Ld;
    }

    public long getInterval() {
        return this.f3186Lc;
    }

    public int getNumUpdates() {
        return this.f3189Lf;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.f3190Lg;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f3191wj;
    }

    public int hashCode() {
        return C0762ep.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.f3186Lc), Long.valueOf(this.f3187Ld), Boolean.valueOf(this.f3188Le), Long.valueOf(this.f3185KV), Integer.valueOf(this.f3189Lf), Float.valueOf(this.f3190Lg));
    }

    public LocationRequest setExpirationDuration(long millis) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (millis > Long.MAX_VALUE - elapsedRealtime) {
            this.f3185KV = Long.MAX_VALUE;
        } else {
            this.f3185KV = elapsedRealtime + millis;
        }
        if (this.f3185KV < 0) {
            this.f3185KV = 0;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long millis) {
        this.f3185KV = millis;
        if (this.f3185KV < 0) {
            this.f3185KV = 0;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long millis) {
        m3579r(millis);
        this.f3188Le = true;
        this.f3187Ld = millis;
        return this;
    }

    public LocationRequest setInterval(long millis) {
        m3579r(millis);
        this.f3186Lc = millis;
        if (!this.f3188Le) {
            this.f3187Ld = (long) (((double) this.f3186Lc) / 6.0d);
        }
        return this;
    }

    public LocationRequest setNumUpdates(int numUpdates) {
        if (numUpdates <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + numUpdates);
        }
        this.f3189Lf = numUpdates;
        return this;
    }

    public LocationRequest setPriority(int priority) {
        m3577bi(priority);
        this.mPriority = priority;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float smallestDisplacementMeters) {
        m3576a(smallestDisplacementMeters);
        this.f3190Lg = smallestDisplacementMeters;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[").append(m3578bj(this.mPriority));
        if (this.mPriority != 105) {
            sb.append(" requested=");
            sb.append(this.f3186Lc + "ms");
        }
        sb.append(" fastest=");
        sb.append(this.f3187Ld + "ms");
        if (this.f3185KV != Long.MAX_VALUE) {
            long elapsedRealtime = this.f3185KV - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(elapsedRealtime + "ms");
        }
        if (this.f3189Lf != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.f3189Lf);
        }
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        LocationRequestCreator.m3580a(this, parcel, flags);
    }
}
