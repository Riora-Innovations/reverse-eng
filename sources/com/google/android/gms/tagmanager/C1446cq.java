package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.C0608c.C0614f;
import com.google.android.gms.internal.C1112jd.C1113a;
import com.google.android.gms.internal.C1147kd;
import com.google.android.gms.internal.C1148ke;
import com.google.android.gms.tagmanager.C1399bg.C1400a;
import com.google.android.gms.tagmanager.C1449cr.C1453c;
import com.google.android.gms.tagmanager.C1449cr.C1457g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* renamed from: com.google.android.gms.tagmanager.cq */
class C1446cq implements C1516f {

    /* renamed from: TM */
    private final String f3709TM;

    /* renamed from: Wi */
    private C1399bg<C1113a> f3710Wi;

    /* renamed from: Wp */
    private final ExecutorService f3711Wp = Executors.newSingleThreadExecutor();
    private final Context mContext;

    C1446cq(Context context, String str) {
        this.mContext = context;
        this.f3709TM = str;
    }

    /* renamed from: a */
    private C1453c m4210a(ByteArrayOutputStream byteArrayOutputStream) {
        boolean z = false;
        try {
            return C1392ba.m4060br(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            C1401bh.m4074s("Tried to convert binary resource to string for JSON parsing; not UTF-8 format");
            return z;
        } catch (JSONException e2) {
            C1401bh.m4078w("Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return z;
        }
    }

    /* renamed from: k */
    private C1453c m4211k(byte[] bArr) {
        boolean z = false;
        try {
            return C1449cr.m4223b(C0614f.m1379a(bArr));
        } catch (C1147kd e) {
            C1401bh.m4078w("Resource doesn't contain a binary container");
            return z;
        } catch (C1457g e2) {
            C1401bh.m4078w("Resource doesn't contain a binary container");
            return z;
        }
    }

    /* renamed from: a */
    public void mo7680a(C1399bg<C1113a> bgVar) {
        this.f3710Wi = bgVar;
    }

    /* renamed from: b */
    public void mo7681b(final C1113a aVar) {
        this.f3711Wp.execute(new Runnable() {
            public void run() {
                C1446cq.this.mo7683c(aVar);
            }
        });
    }

    /* renamed from: bP */
    public C1453c mo7682bP(int i) {
        C1401bh.m4077v("Atttempting to load container from resource ID " + i);
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            C1449cr.m4224b(openRawResource, byteArrayOutputStream);
            C1453c a = m4210a(byteArrayOutputStream);
            return a != null ? a : m4211k(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            C1401bh.m4078w("Error reading default container resource with ID " + i);
            return null;
        } catch (NotFoundException e2) {
            C1401bh.m4078w("No default container resource found.");
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo7683c(C1113a aVar) {
        boolean z = false;
        File jD = mo7686jD();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(jD);
            try {
                fileOutputStream.write(C1148ke.m3474d(aVar));
                z = true;
                try {
                } catch (IOException e) {
                    C1401bh.m4078w("error closing stream for writing resource to disk");
                }
            } catch (IOException e2) {
                C1401bh.m4078w("Error writing resource to disk. Removing resource from disk.");
                jD.delete();
                try {
                } catch (IOException e3) {
                    C1401bh.m4078w("error closing stream for writing resource to disk");
                }
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    C1401bh.m4078w("error closing stream for writing resource to disk");
                }
            }
        } catch (FileNotFoundException e5) {
            C1401bh.m4075t("Error opening resource file for writing");
        }
        return z;
    }

    /* renamed from: iN */
    public void mo7684iN() {
        this.f3711Wp.execute(new Runnable() {
            public void run() {
                C1446cq.this.mo7685jC();
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: jC */
    public void mo7685jC() {
        if (this.f3710Wi == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.f3710Wi.mo7604iM();
        C1401bh.m4077v("Start loading resource from disk ...");
        if ((C1429ce.m4170ju().mo7668jv() == C1430a.CONTAINER || C1429ce.m4170ju().mo7668jv() == C1430a.CONTAINER_DEBUG) && this.f3709TM.equals(C1429ce.m4170ju().getContainerId())) {
            this.f3710Wi.mo7602a(C1400a.NOT_AVAILABLE);
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(mo7686jD());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                C1449cr.m4224b(fileInputStream, byteArrayOutputStream);
                this.f3710Wi.mo7603i(C1113a.m3317l(byteArrayOutputStream.toByteArray()));
                try {
                } catch (IOException e) {
                    C1401bh.m4078w("error closing stream for reading resource from disk");
                }
            } catch (IOException e2) {
                C1401bh.m4078w("error reading resource from disk");
                this.f3710Wi.mo7602a(C1400a.IO_ERROR);
                try {
                } catch (IOException e3) {
                    C1401bh.m4078w("error closing stream for reading resource from disk");
                }
            } finally {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    C1401bh.m4078w("error closing stream for reading resource from disk");
                }
            }
            C1401bh.m4077v("Load resource from disk finished.");
        } catch (FileNotFoundException e5) {
            C1401bh.m4074s("resource not on disk");
            this.f3710Wi.mo7602a(C1400a.NOT_AVAILABLE);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: jD */
    public File mo7686jD() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.f3709TM);
    }

    public synchronized void release() {
        this.f3711Wp.shutdown();
    }
}
