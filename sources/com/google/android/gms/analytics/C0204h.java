package com.google.android.gms.analytics;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* renamed from: com.google.android.gms.analytics.h */
class C0204h implements C0211m {

    /* renamed from: qI */
    private static final Object f188qI = new Object();

    /* renamed from: qW */
    private static C0204h f189qW;
    private final Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: qX */
    public String f190qX;
    /* access modifiers changed from: private */

    /* renamed from: qY */
    public boolean f191qY = false;
    /* access modifiers changed from: private */

    /* renamed from: qZ */
    public final Object f192qZ = new Object();

    protected C0204h(Context context) {
        this.mContext = context;
        m177bx();
    }

    /* renamed from: bu */
    public static C0204h m175bu() {
        C0204h hVar;
        synchronized (f188qI) {
            hVar = f189qW;
        }
        return hVar;
    }

    /* renamed from: bv */
    private String m176bv() {
        if (!this.f191qY) {
            synchronized (this.f192qZ) {
                if (!this.f191qY) {
                    C0181aa.m74v("Waiting for clientId to load");
                    do {
                        try {
                            this.f192qZ.wait();
                        } catch (InterruptedException e) {
                            C0181aa.m72t("Exception while waiting for clientId: " + e);
                        }
                    } while (!this.f191qY);
                }
            }
        }
        C0181aa.m74v("Loaded clientId");
        return this.f190qX;
    }

    /* renamed from: bx */
    private void m177bx() {
        new Thread("client_id_fetcher") {
            public void run() {
                synchronized (C0204h.this.f192qZ) {
                    C0204h.this.f190qX = C0204h.this.mo2942by();
                    C0204h.this.f191qY = true;
                    C0204h.this.f192qZ.notifyAll();
                }
            }
        }.start();
    }

    /* renamed from: n */
    public static void m178n(Context context) {
        synchronized (f188qI) {
            if (f189qW == null) {
                f189qW = new C0204h(context);
            }
        }
    }

    /* renamed from: y */
    private boolean m179y(String str) {
        try {
            C0181aa.m74v("Storing clientId.");
            FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            C0181aa.m72t("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            C0181aa.m72t("Error writing to clientId file.");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: bw */
    public String mo2941bw() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            return !m179y(lowerCase) ? "0" : lowerCase;
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: by */
    public String mo2942by() {
        String str = null;
        try {
            FileInputStream openFileInput = this.mContext.openFileInput("gaClientId");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                C0181aa.m72t("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else if (read <= 0) {
                C0181aa.m72t("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    C0181aa.m72t("Error reading clientId file, deleting it.");
                    this.mContext.deleteFile("gaClientId");
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            C0181aa.m72t("Error reading clientId file, deleting it.");
            this.mContext.deleteFile("gaClientId");
        }
        return str == null ? mo2941bw() : str;
    }

    public String getValue(String field) {
        if ("&cid".equals(field)) {
            return m176bv();
        }
        return null;
    }

    /* renamed from: x */
    public boolean mo2943x(String str) {
        return "&cid".equals(str);
    }
}
