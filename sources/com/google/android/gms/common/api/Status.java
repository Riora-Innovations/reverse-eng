package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0762ep;

public final class Status implements Result, SafeParcelable {
    public static final StatusCreator CREATOR = new StatusCreator();

    /* renamed from: zQ */
    public static final Status f518zQ = new Status(0, null, null);

    /* renamed from: zR */
    public static final Status f519zR = new Status(14, null, null);

    /* renamed from: zS */
    public static final Status f520zS = new Status(15, null, null);
    private final PendingIntent mPendingIntent;

    /* renamed from: wj */
    private final int f521wj;

    /* renamed from: yJ */
    private final int f522yJ;

    /* renamed from: zT */
    private final String f523zT;

    public Status(int statusCode) {
        this(1, statusCode, null, null);
    }

    Status(int versionCode, int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this.f521wj = versionCode;
        this.f522yJ = statusCode;
        this.f523zT = statusMessage;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this(1, statusCode, statusMessage, pendingIntent);
    }

    /* renamed from: dn */
    private String m445dn() {
        return this.f523zT != null ? this.f523zT : CommonStatusCodes.getStatusCodeString(this.f522yJ);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: dE */
    public PendingIntent mo3291dE() {
        return this.mPendingIntent;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: dF */
    public String mo3292dF() {
        return this.f523zT;
    }

    @Deprecated
    /* renamed from: dG */
    public ConnectionResult mo3293dG() {
        return new ConnectionResult(this.f522yJ, this.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f521wj == status.f521wj && this.f522yJ == status.f522yJ && C0762ep.equal(this.f523zT, status.f523zT) && C0762ep.equal(this.mPendingIntent, status.mPendingIntent);
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.f522yJ;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f521wj;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return C0762ep.hashCode(Integer.valueOf(this.f521wj), Integer.valueOf(this.f522yJ), this.f523zT, this.mPendingIntent);
    }

    public boolean isInterrupted() {
        return this.f522yJ == 14;
    }

    public boolean isSuccess() {
        return this.f522yJ <= 0;
    }

    public void startResolutionForResult(Activity activity, int requestCode) throws SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), requestCode, null, 0, 0, 0);
        }
    }

    public String toString() {
        return C0762ep.m1965e(this).mo5118a("statusCode", m445dn()).mo5118a("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        StatusCreator.m449a(this, out, flags);
    }
}
