package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0709dr;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice implements SafeParcelable {
    public static final Creator<CastDevice> CREATOR = new C0291b();

    /* renamed from: wC */
    private String f404wC;

    /* renamed from: wD */
    String f405wD;

    /* renamed from: wE */
    private Inet4Address f406wE;

    /* renamed from: wF */
    private String f407wF;

    /* renamed from: wG */
    private String f408wG;

    /* renamed from: wH */
    private String f409wH;

    /* renamed from: wI */
    private int f410wI;

    /* renamed from: wJ */
    private List<WebImage> f411wJ;

    /* renamed from: wj */
    private final int f412wj;

    private CastDevice() {
        this(1, null, null, null, null, null, -1, new ArrayList());
    }

    CastDevice(int versionCode, String deviceId, String hostAddress, String friendlyName, String modelName, String deviceVersion, int servicePort, List<WebImage> icons) {
        this.f412wj = versionCode;
        this.f404wC = deviceId;
        this.f405wD = hostAddress;
        if (this.f405wD != null) {
            try {
                InetAddress byName = InetAddress.getByName(this.f405wD);
                if (byName instanceof Inet4Address) {
                    this.f406wE = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                this.f406wE = null;
            }
        }
        this.f407wF = friendlyName;
        this.f408wG = modelName;
        this.f409wH = deviceVersion;
        this.f410wI = servicePort;
        this.f411wJ = icons;
    }

    public static CastDevice getFromBundle(Bundle extras) {
        if (extras == null) {
            return null;
        }
        extras.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) extras.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        return getDeviceId() == null ? castDevice.getDeviceId() == null : C0709dr.m1723a(this.f404wC, castDevice.f404wC) && C0709dr.m1723a(this.f406wE, castDevice.f406wE) && C0709dr.m1723a(this.f408wG, castDevice.f408wG) && C0709dr.m1723a(this.f407wF, castDevice.f407wF) && C0709dr.m1723a(this.f409wH, castDevice.f409wH) && this.f410wI == castDevice.f410wI && C0709dr.m1723a(this.f411wJ, castDevice.f411wJ);
    }

    public String getDeviceId() {
        return this.f404wC;
    }

    public String getDeviceVersion() {
        return this.f409wH;
    }

    public String getFriendlyName() {
        return this.f407wF;
    }

    public WebImage getIcon(int preferredWidth, int preferredHeight) {
        WebImage webImage;
        WebImage webImage2 = null;
        if (this.f411wJ.isEmpty()) {
            return null;
        }
        if (preferredWidth <= 0 || preferredHeight <= 0) {
            return (WebImage) this.f411wJ.get(0);
        }
        WebImage webImage3 = null;
        for (WebImage webImage4 : this.f411wJ) {
            int width = webImage4.getWidth();
            int height = webImage4.getHeight();
            if (width < preferredWidth || height < preferredHeight) {
                if (width < preferredWidth && height < preferredHeight && (webImage2 == null || (webImage2.getWidth() < width && webImage2.getHeight() < height))) {
                    webImage = webImage3;
                }
                webImage4 = webImage2;
                webImage = webImage3;
            } else {
                if (webImage3 == null || (webImage3.getWidth() > width && webImage3.getHeight() > height)) {
                    WebImage webImage5 = webImage2;
                    webImage = webImage4;
                    webImage4 = webImage5;
                }
                webImage4 = webImage2;
                webImage = webImage3;
            }
            webImage3 = webImage;
            webImage2 = webImage4;
        }
        if (webImage3 == null) {
            webImage3 = webImage2 != null ? webImage2 : (WebImage) this.f411wJ.get(0);
        }
        return webImage3;
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.f411wJ);
    }

    public Inet4Address getIpAddress() {
        return this.f406wE;
    }

    public String getModelName() {
        return this.f408wG;
    }

    public int getServicePort() {
        return this.f410wI;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f412wj;
    }

    public boolean hasIcons() {
        return !this.f411wJ.isEmpty();
    }

    public int hashCode() {
        if (this.f404wC == null) {
            return 0;
        }
        return this.f404wC.hashCode();
    }

    public boolean isSameDevice(CastDevice castDevice) {
        if (castDevice == null) {
            return false;
        }
        if (getDeviceId() == null) {
            return castDevice.getDeviceId() == null;
        }
        return C0709dr.m1723a(getDeviceId(), castDevice.getDeviceId());
    }

    public void putInBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
        }
    }

    public String toString() {
        return String.format("\"%s\" (%s)", new Object[]{this.f407wF, this.f404wC});
    }

    public void writeToParcel(Parcel out, int flags) {
        C0291b.m412a(this, out, flags);
    }
}
