package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.C0504ab;
import com.google.android.gms.internal.C0659cz;

public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");

    /* renamed from: kC */
    private final String f57kC;

    /* renamed from: v */
    private final int f58v;

    /* renamed from: w */
    private final int f59w;

    public AdSize(int width, int height) {
        this(width, height, (width == -1 ? "FULL" : String.valueOf(width)) + "x" + (height == -2 ? "AUTO" : String.valueOf(height)) + "_as");
    }

    AdSize(int width, int height, String formatString) {
        if (width < 0 && width != -1) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + width);
        } else if (height >= 0 || height == -2) {
            this.f59w = width;
            this.f58v = height;
            this.f57kC = formatString;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + height);
        }
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) other;
        return this.f59w == adSize.f59w && this.f58v == adSize.f58v && this.f57kC.equals(adSize.f57kC);
    }

    public int getHeight() {
        return this.f58v;
    }

    public int getHeightInPixels(Context context) {
        return this.f58v == -2 ? C0504ab.m1152b(context.getResources().getDisplayMetrics()) : C0659cz.m1533a(context, this.f58v);
    }

    public int getWidth() {
        return this.f59w;
    }

    public int getWidthInPixels(Context context) {
        return this.f59w == -1 ? C0504ab.m1151a(context.getResources().getDisplayMetrics()) : C0659cz.m1533a(context, this.f59w);
    }

    public int hashCode() {
        return this.f57kC.hashCode();
    }

    public boolean isAutoHeight() {
        return this.f58v == -2;
    }

    public boolean isFullWidth() {
        return this.f59w == -1;
    }

    public String toString() {
        return this.f57kC;
    }
}
