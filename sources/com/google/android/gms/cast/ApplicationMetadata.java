package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
    public static final Creator<ApplicationMetadata> CREATOR = new C0290a();
    String mName;

    /* renamed from: wj */
    private final int f371wj;

    /* renamed from: wk */
    String f372wk;

    /* renamed from: wl */
    List<WebImage> f373wl;

    /* renamed from: wm */
    List<String> f374wm;

    /* renamed from: wn */
    String f375wn;

    /* renamed from: wo */
    Uri f376wo;

    private ApplicationMetadata() {
        this.f371wj = 1;
        this.f373wl = new ArrayList();
        this.f374wm = new ArrayList();
    }

    ApplicationMetadata(int versionCode, String applicationId, String name, List<WebImage> images, List<String> namespaces, String senderAppIdentifier, Uri senderAppLaunchUrl) {
        this.f371wj = versionCode;
        this.f372wk = applicationId;
        this.mName = name;
        this.f373wl = images;
        this.f374wm = namespaces;
        this.f375wn = senderAppIdentifier;
        this.f376wo = senderAppLaunchUrl;
    }

    public boolean areNamespacesSupported(List<String> namespaces) {
        return this.f374wm != null && this.f374wm.containsAll(namespaces);
    }

    /* renamed from: cR */
    public Uri mo3038cR() {
        return this.f376wo;
    }

    public int describeContents() {
        return 0;
    }

    public String getApplicationId() {
        return this.f372wk;
    }

    public List<WebImage> getImages() {
        return this.f373wl;
    }

    public String getName() {
        return this.mName;
    }

    public String getSenderAppIdentifier() {
        return this.f375wn;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f371wj;
    }

    public boolean isNamespaceSupported(String namespace) {
        return this.f374wm != null && this.f374wm.contains(namespace);
    }

    public String toString() {
        return this.mName;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0290a.m409a(this, out, flags);
    }
}
