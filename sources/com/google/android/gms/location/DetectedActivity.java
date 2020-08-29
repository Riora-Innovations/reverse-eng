package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DetectedActivity implements SafeParcelable {
    public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;

    /* renamed from: KS */
    int f3172KS;

    /* renamed from: KT */
    int f3173KT;

    /* renamed from: wj */
    private final int f3174wj;

    public DetectedActivity(int activityType, int confidence) {
        this.f3174wj = 1;
        this.f3172KS = activityType;
        this.f3173KT = confidence;
    }

    public DetectedActivity(int versionCode, int activityType, int confidence) {
        this.f3174wj = versionCode;
        this.f3172KS = activityType;
        this.f3173KT = confidence;
    }

    /* renamed from: bh */
    private int m3574bh(int i) {
        if (i > 6) {
            return 4;
        }
        return i;
    }

    public int describeContents() {
        return 0;
    }

    public int getConfidence() {
        return this.f3173KT;
    }

    public int getType() {
        return m3574bh(this.f3172KS);
    }

    public int getVersionCode() {
        return this.f3174wj;
    }

    public String toString() {
        return "DetectedActivity [type=" + getType() + ", confidence=" + this.f3173KT + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        DetectedActivityCreator.m3575a(this, out, flags);
    }
}
