package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.C0424y;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.internal.C1147kd;
import com.google.android.gms.internal.C1148ke;

public class DriveId implements SafeParcelable {
    public static final Creator<DriveId> CREATOR = new C0333d();

    /* renamed from: Dc */
    final String f637Dc;

    /* renamed from: Dd */
    final long f638Dd;

    /* renamed from: De */
    final long f639De;

    /* renamed from: Df */
    private volatile String f640Df;

    /* renamed from: wj */
    final int f641wj;

    DriveId(int versionCode, String resourceId, long sqlId, long databaseInstanceId) {
        boolean z = false;
        this.f640Df = null;
        this.f641wj = versionCode;
        this.f637Dc = resourceId;
        C0766er.m1979x(!"".equals(resourceId));
        if (!(resourceId == null && sqlId == -1)) {
            z = true;
        }
        C0766er.m1979x(z);
        this.f638Dd = sqlId;
        this.f639De = databaseInstanceId;
    }

    public DriveId(String resourceId, long sqlId, long databaseInstanceId) {
        this(1, resourceId, sqlId, databaseInstanceId);
    }

    /* renamed from: aq */
    public static DriveId m625aq(String str) {
        C0766er.m1977f(str);
        return new DriveId(str, -1, -1);
    }

    public static DriveId decodeFromString(String s) {
        C0766er.m1976b(s.startsWith("DriveId:"), (Object) "Invalid DriveId: " + s);
        return m626f(Base64.decode(s.substring("DriveId:".length()), 10));
    }

    /* renamed from: f */
    static DriveId m626f(byte[] bArr) {
        try {
            C0424y g = C0424y.m877g(bArr);
            return new DriveId(g.versionCode, "".equals(g.f803DV) ? null : g.f803DV, g.f804DW, g.f805DX);
        } catch (C1147kd e) {
            throw new IllegalArgumentException();
        }
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: eR */
    public final byte[] mo3474eR() {
        C0424y yVar = new C0424y();
        yVar.versionCode = this.f641wj;
        yVar.f803DV = this.f637Dc == null ? "" : this.f637Dc;
        yVar.f804DW = this.f638Dd;
        yVar.f805DX = this.f639De;
        return C1148ke.m3474d(yVar);
    }

    public final String encodeToString() {
        if (this.f640Df == null) {
            this.f640Df = "DriveId:" + Base64.encodeToString(mo3474eR(), 10);
        }
        return this.f640Df;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.f639De != this.f639De) {
            Log.w("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
        } else if (driveId.f638Dd == -1 && this.f638Dd == -1) {
            return driveId.f637Dc.equals(this.f637Dc);
        } else {
            return driveId.f638Dd == this.f638Dd;
        }
    }

    public String getResourceId() {
        return this.f637Dc;
    }

    public int hashCode() {
        return this.f638Dd == -1 ? this.f637Dc.hashCode() : (String.valueOf(this.f639De) + String.valueOf(this.f638Dd)).hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0333d.m637a(this, out, flags);
    }
}
