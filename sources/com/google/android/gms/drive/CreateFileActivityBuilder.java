package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C0380n;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.internal.C0766er;
import java.io.IOException;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";

    /* renamed from: CV */
    private MetadataChangeSet f630CV;

    /* renamed from: CW */
    private Contents f631CW;

    /* renamed from: CX */
    private String f632CX;

    /* renamed from: CY */
    private DriveId f633CY;

    public IntentSender build(GoogleApiClient apiClient) {
        C0766er.m1975b(this.f631CW, (Object) "Must provide initial contents to CreateFileActivityBuilder.");
        try {
            this.f631CW.getParcelFileDescriptor().close();
        } catch (IOException e) {
        }
        this.f631CW.close();
        C0766er.m1970a(apiClient.isConnected(), "Client must be connected");
        try {
            return ((C0380n) apiClient.mo3256a(Drive.f636va)).mo3738eT().mo3767a(new CreateFileIntentSenderRequest(this.f630CV.mo3519eS(), this.f631CW.mo3433eP(), this.f632CX, this.f633CY));
        } catch (RemoteException e2) {
            throw new RuntimeException("Unable to connect Drive Play Service", e2);
        }
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.f633CY = (DriveId) C0766er.m1977f(folder);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String title) {
        this.f632CX = (String) C0766er.m1977f(title);
        return this;
    }

    public CreateFileActivityBuilder setInitialContents(Contents contents) {
        this.f631CW = (Contents) C0766er.m1977f(contents);
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.f630CV = (MetadataChangeSet) C0766er.m1977f(metadataChangeSet);
        return this;
    }
}
