package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.C0520aj;
import com.google.android.gms.internal.C0520aj.C0521a;
import java.util.Date;
import java.util.Set;

public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR = C0520aj.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;

    /* renamed from: kA */
    private final C0520aj f55kA;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: kB */
        public final C0521a f56kB = new C0521a();

        public Builder addKeyword(String keyword) {
            this.f56kB.mo4542g(keyword);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f56kB.mo4537a(networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.f56kB.mo4543h(deviceId);
            return this;
        }

        public AdRequest build() {
            return new AdRequest(this);
        }

        public Builder setBirthday(Date birthday) {
            this.f56kB.mo4538a(birthday);
            return this;
        }

        public Builder setGender(int gender) {
            this.f56kB.mo4539d(gender);
            return this;
        }

        public Builder setLocation(Location location) {
            this.f56kB.mo4536a(location);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.f56kB.mo4541e(tagForChildDirectedTreatment);
            return this;
        }
    }

    private AdRequest(Builder builder) {
        this.f55kA = new C0520aj(builder.f56kB);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: N */
    public C0520aj mo2610N() {
        return this.f55kA;
    }

    public Date getBirthday() {
        return this.f55kA.getBirthday();
    }

    public int getGender() {
        return this.f55kA.getGender();
    }

    public Set<String> getKeywords() {
        return this.f55kA.getKeywords();
    }

    public Location getLocation() {
        return this.f55kA.getLocation();
    }

    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.f55kA.getNetworkExtras(networkExtrasClass);
    }

    public boolean isTestDevice(Context context) {
        return this.f55kA.isTestDevice(context);
    }
}
