package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.plus.PlusShare;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage implements SafeParcelable {
    public static final Creator<WebImage> CREATOR = new C0323b();

    /* renamed from: AR */
    private final Uri f607AR;

    /* renamed from: v */
    private final int f608v;

    /* renamed from: w */
    private final int f609w;

    /* renamed from: wj */
    private final int f610wj;

    WebImage(int versionCode, Uri url, int width, int height) {
        this.f610wj = versionCode;
        this.f607AR = url;
        this.f609w = width;
        this.f608v = height;
    }

    public WebImage(Uri url) throws IllegalArgumentException {
        this(url, 0, 0);
    }

    public WebImage(Uri url, int width, int height) throws IllegalArgumentException {
        this(1, url, width, height);
        if (url == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (width < 0 || height < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject json) throws IllegalArgumentException {
        this(m545c(json), json.optInt("width", 0), json.optInt("height", 0));
    }

    /* renamed from: c */
    private static Uri m545c(JSONObject jSONObject) {
        Uri uri = null;
        if (!jSONObject.has(PlusShare.KEY_CALL_TO_ACTION_URL)) {
            return uri;
        }
        try {
            return Uri.parse(jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL));
        } catch (JSONException e) {
            return uri;
        }
    }

    /* renamed from: cT */
    public JSONObject mo3407cT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PlusShare.KEY_CALL_TO_ACTION_URL, this.f607AR.toString());
            jSONObject.put("width", this.f609w);
            jSONObject.put("height", this.f608v);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) other;
        return C0762ep.equal(this.f607AR, webImage.f607AR) && this.f609w == webImage.f609w && this.f608v == webImage.f608v;
    }

    public int getHeight() {
        return this.f608v;
    }

    public Uri getUrl() {
        return this.f607AR;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f610wj;
    }

    public int getWidth() {
        return this.f609w;
    }

    public int hashCode() {
        return C0762ep.hashCode(this.f607AR, Integer.valueOf(this.f609w), Integer.valueOf(this.f608v));
    }

    public String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.f609w), Integer.valueOf(this.f608v), this.f607AR.toString()});
    }

    public void writeToParcel(Parcel out, int flags) {
        C0323b.m558a(this, out, flags);
    }
}
