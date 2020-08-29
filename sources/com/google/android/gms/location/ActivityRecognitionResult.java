package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0766er;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    public static final String EXTRA_ACTIVITY_RESULT = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT";

    /* renamed from: KP */
    List<DetectedActivity> f3168KP;

    /* renamed from: KQ */
    long f3169KQ;

    /* renamed from: KR */
    long f3170KR;

    /* renamed from: wj */
    private final int f3171wj;

    public ActivityRecognitionResult(int versionCode, List<DetectedActivity> probableActivities, long timeMillis, long elapsedRealtimeMillis) {
        this.f3171wj = 1;
        this.f3168KP = probableActivities;
        this.f3169KQ = timeMillis;
        this.f3170KR = elapsedRealtimeMillis;
    }

    public ActivityRecognitionResult(DetectedActivity mostProbableActivity, long time, long elapsedRealtimeMillis) {
        this(Collections.singletonList(mostProbableActivity), time, elapsedRealtimeMillis);
    }

    public ActivityRecognitionResult(List<DetectedActivity> probableActivities, long time, long elapsedRealtimeMillis) {
        C0766er.m1976b(probableActivities != null && probableActivities.size() > 0, (Object) "Must have at least 1 detected activity");
        this.f3171wj = 1;
        this.f3168KP = probableActivities;
        this.f3169KQ = time;
        this.f3170KR = elapsedRealtimeMillis;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        if (!hasResult(intent)) {
            return null;
        }
        return (ActivityRecognitionResult) intent.getExtras().get(EXTRA_ACTIVITY_RESULT);
    }

    public static boolean hasResult(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra(EXTRA_ACTIVITY_RESULT);
    }

    public int describeContents() {
        return 0;
    }

    public int getActivityConfidence(int activityType) {
        for (DetectedActivity detectedActivity : this.f3168KP) {
            if (detectedActivity.getType() == activityType) {
                return detectedActivity.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.f3170KR;
    }

    public DetectedActivity getMostProbableActivity() {
        return (DetectedActivity) this.f3168KP.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.f3168KP;
    }

    public long getTime() {
        return this.f3169KQ;
    }

    public int getVersionCode() {
        return this.f3171wj;
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.f3168KP + ", timeMillis=" + this.f3169KQ + ", elapsedRealtimeMillis=" + this.f3170KR + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        ActivityRecognitionResultCreator.m3573a(this, out, flags);
    }
}
