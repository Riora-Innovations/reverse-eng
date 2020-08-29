package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.C1025hj;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {

        /* renamed from: Hh */
        private String f3175Hh = null;

        /* renamed from: KU */
        private int f3176KU = 0;

        /* renamed from: KV */
        private long f3177KV = Long.MIN_VALUE;

        /* renamed from: KW */
        private short f3178KW = -1;

        /* renamed from: KX */
        private double f3179KX;

        /* renamed from: KY */
        private double f3180KY;

        /* renamed from: KZ */
        private float f3181KZ;

        /* renamed from: La */
        private int f3182La = 0;

        /* renamed from: Lb */
        private int f3183Lb = -1;

        public Geofence build() {
            if (this.f3175Hh == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (this.f3176KU == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            } else if ((this.f3176KU & 4) != 0 && this.f3183Lb < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            } else if (this.f3177KV == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if (this.f3178KW == -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            } else if (this.f3182La >= 0) {
                return new C1025hj(this.f3175Hh, this.f3176KU, 1, this.f3179KX, this.f3180KY, this.f3181KZ, this.f3177KV, this.f3182La, this.f3183Lb);
            } else {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
        }

        public Builder setCircularRegion(double latitude, double longitude, float radius) {
            this.f3178KW = 1;
            this.f3179KX = latitude;
            this.f3180KY = longitude;
            this.f3181KZ = radius;
            return this;
        }

        public Builder setExpirationDuration(long durationMillis) {
            if (durationMillis < 0) {
                this.f3177KV = -1;
            } else {
                this.f3177KV = SystemClock.elapsedRealtime() + durationMillis;
            }
            return this;
        }

        public Builder setLoiteringDelay(int loiteringDelayMs) {
            this.f3183Lb = loiteringDelayMs;
            return this;
        }

        public Builder setNotificationResponsiveness(int notificationResponsivenessMs) {
            this.f3182La = notificationResponsivenessMs;
            return this;
        }

        public Builder setRequestId(String requestId) {
            this.f3175Hh = requestId;
            return this;
        }

        public Builder setTransitionTypes(int transitionTypes) {
            this.f3176KU = transitionTypes;
            return this;
        }
    }

    String getRequestId();
}
