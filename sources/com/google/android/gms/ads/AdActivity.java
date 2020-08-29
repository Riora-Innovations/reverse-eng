package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.C0593bv;
import com.google.android.gms.internal.C0595bw;
import com.google.android.gms.internal.C0662da;

public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";

    /* renamed from: kz */
    private C0595bw f54kz;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f54kz = C0593bv.m1326a(this);
        if (this.f54kz == null) {
            C0662da.m1555w("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.f54kz.onCreate(savedInstanceState);
        } catch (RemoteException e) {
            C0662da.m1549b("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.f54kz != null) {
                this.f54kz.onDestroy();
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            if (this.f54kz != null) {
                this.f54kz.onPause();
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        try {
            if (this.f54kz != null) {
                this.f54kz.onRestart();
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        try {
            if (this.f54kz != null) {
                this.f54kz.onResume();
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        try {
            if (this.f54kz != null) {
                this.f54kz.onSaveInstanceState(outState);
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(outState);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        try {
            if (this.f54kz != null) {
                this.f54kz.onStart();
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            if (this.f54kz != null) {
                this.f54kz.onStop();
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }
}
