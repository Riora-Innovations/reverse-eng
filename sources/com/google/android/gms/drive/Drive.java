package com.google.android.gms.drive;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0294b;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.C0361l;
import com.google.android.gms.drive.internal.C0380n;
import com.google.android.gms.drive.internal.C0391p;
import com.google.android.gms.internal.C0732ee;
import java.util.List;

public final class Drive {
    public static final Api API = new Api(f636va, new Scope[0]);

    /* renamed from: Da */
    public static final Scope f634Da = new Scope(Scopes.DRIVE_FULL);

    /* renamed from: Db */
    public static final C0332c f635Db = new C0391p();
    public static final DriveApi DriveApi = new C0361l();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);

    /* renamed from: va */
    public static final C0294b<C0380n> f636va = new C0294b<C0380n>() {
        /* renamed from: d */
        public C0380n mo2998b(Context context, Looper looper, C0732ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            List dT = eeVar.mo5020dT();
            return new C0380n(context, looper, eeVar, connectionCallbacks, onConnectionFailedListener, (String[]) dT.toArray(new String[dT.size()]));
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    private Drive() {
    }
}
