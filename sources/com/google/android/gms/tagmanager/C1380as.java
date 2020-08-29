package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.tagmanager.as */
class C1380as extends Thread implements C1379ar {

    /* renamed from: Vc */
    private static C1380as f3594Vc;

    /* renamed from: Vb */
    private final LinkedBlockingQueue<Runnable> f3595Vb = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */

    /* renamed from: Vd */
    public volatile C1382at f3596Vd;
    private volatile boolean mClosed = false;
    /* access modifiers changed from: private */
    public final Context mContext;

    /* renamed from: sa */
    private volatile boolean f3597sa = false;

    private C1380as(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    /* renamed from: H */
    static C1380as m4026H(Context context) {
        if (f3594Vc == null) {
            f3594Vc = new C1380as(context);
        }
        return f3594Vc;
    }

    /* renamed from: a */
    private String m4029a(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    /* renamed from: a */
    public void mo7586a(Runnable runnable) {
        this.f3595Vb.add(runnable);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7588b(String str, long j) {
        final long j2 = j;
        final String str2 = str;
        mo7586a((Runnable) new Runnable() {
            public void run() {
                if (C1380as.this.f3596Vd == null) {
                    C1471cy kh = C1471cy.m4323kh();
                    kh.mo7760a(C1380as.this.mContext, this);
                    C1380as.this.f3596Vd = kh.mo7763ki();
                }
                C1380as.this.f3596Vd.mo7592e(j2, str2);
            }
        });
    }

    /* renamed from: bn */
    public void mo7587bn(String str) {
        mo7588b(str, System.currentTimeMillis());
    }

    public void run() {
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.f3595Vb.take();
                if (!this.f3597sa) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                C1401bh.m4076u(e.toString());
            } catch (Throwable th) {
                C1401bh.m4075t("Error on GAThread: " + m4029a(th));
                C1401bh.m4075t("Google Analytics is shutting down.");
                this.f3597sa = true;
            }
        }
    }
}
