package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.C0520aj;
import com.google.android.gms.internal.C0520aj.C0521a;
import java.util.Date;
import java.util.Set;

public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = C0520aj.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;

    /* renamed from: kA */
    private final C0520aj f62kA;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: kB */
        public final C0521a f63kB = new C0521a();

        public Builder addKeyword(String keyword) {
            this.f63kB.mo4542g(keyword);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f63kB.mo4537a(networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.f63kB.mo4543h(deviceId);
            return this;
        }

        public PublisherAdRequest build() {
            return new PublisherAdRequest(this);
        }

        public Builder setBirthday(Date birthday) {
            this.f63kB.mo4538a(birthday);
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            this.f63kB.mo4544i(contentUrl);
            return this;
        }

        public Builder setGender(int gender) {
            this.f63kB.mo4539d(gender);
            return this;
        }

        public Builder setLocation(Location location) {
            this.f63kB.mo4536a(location);
            return this;
        }

        public Builder setManualImpressionsEnabled(boolean manualImpressionsEnabled) {
            this.f63kB.mo4540d(manualImpressionsEnabled);
            return this;
        }

        public Builder setPublisherProvidedId(String publisherProvidedId) {
            this.f63kB.mo4545j(publisherProvidedId);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.f63kB.mo4541e(tagForChildDirectedTreatment);
            return this;
        }
    }

    private PublisherAdRequest(Builder builder) {
        this.f62kA = new C0520aj(builder.f63kB);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: N */
    public C0520aj mo2654N() {
        return this.f62kA;
    }

    public Date getBirthday() {
        return this.f62kA.getBirthday();
    }

    public String getContentUrl() {
        return this.f62kA.getContentUrl();
    }

    public int getGender() {
        return this.f62kA.getGender();
    }

    public Set<String> getKeywords() {
        return this.f62kA.getKeywords();
    }

    public Location getLocation() {
        return this.f62kA.getLocation();
    }

    public boolean getManualImpressionsEnabled() {
        return this.f62kA.getManualImpressionsEnabled();
    }

    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.f62kA.getNetworkExtras(networkExtrasClass);
    }

    public String getPublisherProvidedId() {
        return this.f62kA.getPublisherProvidedId();
    }

    public boolean isTestDevice(Context context) {
        return this.f62kA.isTestDevice(context);
    }
}
