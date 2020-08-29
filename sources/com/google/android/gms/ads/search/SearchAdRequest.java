package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.C0520aj;
import com.google.android.gms.internal.C0520aj.C0521a;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR = C0520aj.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;

    /* renamed from: kA */
    private final C0520aj f70kA;

    /* renamed from: qA */
    private final int f71qA;

    /* renamed from: qB */
    private final int f72qB;

    /* renamed from: qC */
    private final String f73qC;

    /* renamed from: qD */
    private final int f74qD;

    /* renamed from: qE */
    private final String f75qE;

    /* renamed from: qF */
    private final int f76qF;

    /* renamed from: qG */
    private final int f77qG;

    /* renamed from: qH */
    private final String f78qH;

    /* renamed from: qu */
    private final int f79qu;

    /* renamed from: qv */
    private final int f80qv;

    /* renamed from: qw */
    private final int f81qw;

    /* renamed from: qx */
    private final int f82qx;

    /* renamed from: qy */
    private final int f83qy;

    /* renamed from: qz */
    private final int f84qz;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: kB */
        public final C0521a f85kB = new C0521a();
        /* access modifiers changed from: private */

        /* renamed from: qA */
        public int f86qA = 0;
        /* access modifiers changed from: private */

        /* renamed from: qB */
        public int f87qB;
        /* access modifiers changed from: private */

        /* renamed from: qC */
        public String f88qC;
        /* access modifiers changed from: private */

        /* renamed from: qD */
        public int f89qD;
        /* access modifiers changed from: private */

        /* renamed from: qE */
        public String f90qE;
        /* access modifiers changed from: private */

        /* renamed from: qF */
        public int f91qF;
        /* access modifiers changed from: private */

        /* renamed from: qG */
        public int f92qG;
        /* access modifiers changed from: private */

        /* renamed from: qH */
        public String f93qH;
        /* access modifiers changed from: private */

        /* renamed from: qu */
        public int f94qu;
        /* access modifiers changed from: private */

        /* renamed from: qv */
        public int f95qv;
        /* access modifiers changed from: private */

        /* renamed from: qw */
        public int f96qw;
        /* access modifiers changed from: private */

        /* renamed from: qx */
        public int f97qx;
        /* access modifiers changed from: private */

        /* renamed from: qy */
        public int f98qy;
        /* access modifiers changed from: private */

        /* renamed from: qz */
        public int f99qz;

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f85kB.mo4537a(networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.f85kB.mo4543h(deviceId);
            return this;
        }

        public SearchAdRequest build() {
            return new SearchAdRequest(this);
        }

        public Builder setAnchorTextColor(int anchorTextColor) {
            this.f94qu = anchorTextColor;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.f95qv = backgroundColor;
            this.f96qw = Color.argb(0, 0, 0, 0);
            this.f97qx = Color.argb(0, 0, 0, 0);
            return this;
        }

        public Builder setBackgroundGradient(int top, int bottom) {
            this.f95qv = Color.argb(0, 0, 0, 0);
            this.f96qw = bottom;
            this.f97qx = top;
            return this;
        }

        public Builder setBorderColor(int borderColor) {
            this.f98qy = borderColor;
            return this;
        }

        public Builder setBorderThickness(int borderThickness) {
            this.f99qz = borderThickness;
            return this;
        }

        public Builder setBorderType(int borderType) {
            this.f86qA = borderType;
            return this;
        }

        public Builder setCallButtonColor(int callButtonColor) {
            this.f87qB = callButtonColor;
            return this;
        }

        public Builder setCustomChannels(String channelIds) {
            this.f88qC = channelIds;
            return this;
        }

        public Builder setDescriptionTextColor(int descriptionTextColor) {
            this.f89qD = descriptionTextColor;
            return this;
        }

        public Builder setFontFace(String fontFace) {
            this.f90qE = fontFace;
            return this;
        }

        public Builder setHeaderTextColor(int headerTextColor) {
            this.f91qF = headerTextColor;
            return this;
        }

        public Builder setHeaderTextSize(int headerTextSize) {
            this.f92qG = headerTextSize;
            return this;
        }

        public Builder setLocation(Location location) {
            this.f85kB.mo4536a(location);
            return this;
        }

        public Builder setQuery(String query) {
            this.f93qH = query;
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.f85kB.mo4541e(tagForChildDirectedTreatment);
            return this;
        }
    }

    private SearchAdRequest(Builder builder) {
        this.f79qu = builder.f94qu;
        this.f80qv = builder.f95qv;
        this.f81qw = builder.f96qw;
        this.f82qx = builder.f97qx;
        this.f83qy = builder.f98qy;
        this.f84qz = builder.f99qz;
        this.f71qA = builder.f86qA;
        this.f72qB = builder.f87qB;
        this.f73qC = builder.f88qC;
        this.f74qD = builder.f89qD;
        this.f75qE = builder.f90qE;
        this.f76qF = builder.f91qF;
        this.f77qG = builder.f92qG;
        this.f78qH = builder.f93qH;
        this.f70kA = new C0520aj(builder.f85kB, this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: N */
    public C0520aj mo2705N() {
        return this.f70kA;
    }

    public int getAnchorTextColor() {
        return this.f79qu;
    }

    public int getBackgroundColor() {
        return this.f80qv;
    }

    public int getBackgroundGradientBottom() {
        return this.f81qw;
    }

    public int getBackgroundGradientTop() {
        return this.f82qx;
    }

    public int getBorderColor() {
        return this.f83qy;
    }

    public int getBorderThickness() {
        return this.f84qz;
    }

    public int getBorderType() {
        return this.f71qA;
    }

    public int getCallButtonColor() {
        return this.f72qB;
    }

    public String getCustomChannels() {
        return this.f73qC;
    }

    public int getDescriptionTextColor() {
        return this.f74qD;
    }

    public String getFontFace() {
        return this.f75qE;
    }

    public int getHeaderTextColor() {
        return this.f76qF;
    }

    public int getHeaderTextSize() {
        return this.f77qG;
    }

    public Location getLocation() {
        return this.f70kA.getLocation();
    }

    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.f70kA.getNetworkExtras(networkExtrasClass);
    }

    public String getQuery() {
        return this.f78qH;
    }

    public boolean isTestDevice(Context context) {
        return this.f70kA.isTestDevice(context);
    }
}
