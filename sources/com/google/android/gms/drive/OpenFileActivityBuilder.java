package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C0380n;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.internal.C0766er;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";

    /* renamed from: CX */
    private String f649CX;

    /* renamed from: CY */
    private DriveId f650CY;

    /* renamed from: Dk */
    private String[] f651Dk;

    public IntentSender build(GoogleApiClient apiClient) {
        C0766er.m1975b(this.f651Dk, (Object) "setMimeType(String[]) must be called on this builder before calling build()");
        C0766er.m1970a(apiClient.isConnected(), "Client must be connected");
        try {
            return ((C0380n) apiClient.mo3256a(Drive.f636va)).mo3738eT().mo3768a(new OpenFileIntentSenderRequest(this.f649CX, this.f651Dk, this.f650CY));
        } catch (RemoteException e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.f650CY = (DriveId) C0766er.m1977f(folder);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String title) {
        this.f649CX = (String) C0766er.m1977f(title);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] mimeTypes) {
        C0766er.m1976b(mimeTypes != null && mimeTypes.length > 0, (Object) "mimeTypes may not be null and must contain at least one value");
        this.f651Dk = mimeTypes;
        return this;
    }
}
