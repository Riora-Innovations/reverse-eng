package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents implements SafeParcelable {
    public static final Creator<Contents> CREATOR = new C0330a();

    /* renamed from: AC */
    final ParcelFileDescriptor f623AC;

    /* renamed from: CQ */
    final int f624CQ;

    /* renamed from: CR */
    final int f625CR;

    /* renamed from: CS */
    final DriveId f626CS;

    /* renamed from: CT */
    private boolean f627CT = false;

    /* renamed from: CU */
    private boolean f628CU = false;
    private boolean mClosed = false;

    /* renamed from: wj */
    final int f629wj;

    Contents(int versionCode, ParcelFileDescriptor parcelFileDescriptor, int requestId, int mode, DriveId driveId) {
        this.f629wj = versionCode;
        this.f623AC = parcelFileDescriptor;
        this.f624CQ = requestId;
        this.f625CR = mode;
        this.f626CS = driveId;
    }

    public void close() {
        this.mClosed = true;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: eP */
    public int mo3433eP() {
        return this.f624CQ;
    }

    public DriveId getDriveId() {
        return this.f626CS;
    }

    public InputStream getInputStream() {
        if (this.mClosed) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.f625CR != 268435456) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (this.f627CT) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else {
            this.f627CT = true;
            return new FileInputStream(this.f623AC.getFileDescriptor());
        }
    }

    public int getMode() {
        return this.f625CR;
    }

    public OutputStream getOutputStream() {
        if (this.mClosed) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.f625CR != 536870912) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (this.f628CU) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else {
            this.f628CU = true;
            return new FileOutputStream(this.f623AC.getFileDescriptor());
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!this.mClosed) {
            return this.f623AC;
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0330a.m632a(this, dest, flags);
    }
}
