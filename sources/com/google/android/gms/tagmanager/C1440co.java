package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.C0608c.C0618j;
import com.google.android.gms.tagmanager.C1399bg.C1400a;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.tagmanager.co */
class C1440co implements Runnable {

    /* renamed from: TM */
    private final String f3693TM;

    /* renamed from: Ui */
    private volatile String f3694Ui;

    /* renamed from: Wg */
    private final C1406bm f3695Wg;

    /* renamed from: Wh */
    private final String f3696Wh;

    /* renamed from: Wi */
    private C1399bg<C0618j> f3697Wi;

    /* renamed from: Wj */
    private volatile C1519r f3698Wj;

    /* renamed from: Wk */
    private volatile String f3699Wk;
    private final Context mContext;

    C1440co(Context context, String str, C1406bm bmVar, C1519r rVar) {
        this.mContext = context;
        this.f3695Wg = bmVar;
        this.f3693TM = str;
        this.f3698Wj = rVar;
        this.f3696Wh = "/r?id=" + str;
        this.f3694Ui = this.f3696Wh;
        this.f3699Wk = null;
    }

    public C1440co(Context context, String str, C1519r rVar) {
        this(context, str, new C1406bm(), rVar);
    }

    /* renamed from: jx */
    private boolean m4193jx() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        C1401bh.m4077v("...no network connectivity");
        return false;
    }

    /* renamed from: jy */
    private void m4194jy() {
        if (!m4193jx()) {
            this.f3697Wi.mo7602a(C1400a.NOT_AVAILABLE);
            return;
        }
        C1401bh.m4077v("Start loading resource from network ...");
        String jz = mo7673jz();
        C1405bl ji = this.f3695Wg.mo7617ji();
        try {
            InputStream bo = ji.mo7594bo(jz);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                C1449cr.m4224b(bo, byteArrayOutputStream);
                C0618j b = C0618j.m1402b(byteArrayOutputStream.toByteArray());
                C1401bh.m4077v("Successfully loaded supplemented resource: " + b);
                if (b.f1638fV == null && b.f1637fU.length == 0) {
                    C1401bh.m4077v("No change for container: " + this.f3693TM);
                }
                this.f3697Wi.mo7603i(b);
                ji.close();
                C1401bh.m4077v("Load resource from network finished.");
            } catch (IOException e) {
                C1401bh.m4072b("Error when parsing downloaded resources from url: " + jz + " " + e.getMessage(), e);
                this.f3697Wi.mo7602a(C1400a.SERVER_ERROR);
                ji.close();
            }
        } catch (FileNotFoundException e2) {
            C1401bh.m4078w("No data is retrieved from the given url: " + jz + ". Make sure container_id: " + this.f3693TM + " is correct.");
            this.f3697Wi.mo7602a(C1400a.SERVER_ERROR);
            ji.close();
        } catch (IOException e3) {
            C1401bh.m4072b("Error when loading resources from url: " + jz + " " + e3.getMessage(), e3);
            this.f3697Wi.mo7602a(C1400a.IO_ERROR);
            ji.close();
        } catch (Throwable th) {
            ji.close();
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7670a(C1399bg<C0618j> bgVar) {
        this.f3697Wi = bgVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bf */
    public void mo7671bf(String str) {
        if (str == null) {
            this.f3694Ui = this.f3696Wh;
            return;
        }
        C1401bh.m4074s("Setting CTFE URL path: " + str);
        this.f3694Ui = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bu */
    public void mo7672bu(String str) {
        C1401bh.m4074s("Setting previous container version: " + str);
        this.f3699Wk = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: jz */
    public String mo7673jz() {
        String str = this.f3698Wj.mo7812iO() + this.f3694Ui + "&v=a59512756";
        if (this.f3699Wk != null && !this.f3699Wk.trim().equals("")) {
            str = str + "&pv=" + this.f3699Wk;
        }
        return C1429ce.m4170ju().mo7668jv().equals(C1430a.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    public void run() {
        if (this.f3697Wi == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.f3697Wi.mo7604iM();
        m4194jy();
    }
}
