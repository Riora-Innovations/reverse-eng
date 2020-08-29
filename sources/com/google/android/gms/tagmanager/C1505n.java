package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;

/* renamed from: com.google.android.gms.tagmanager.n */
class C1505n implements ContainerHolder {

    /* renamed from: TU */
    private Container f3853TU;

    /* renamed from: TV */
    private Container f3854TV;

    /* renamed from: TW */
    private C1507b f3855TW;

    /* renamed from: TX */
    private C1506a f3856TX;

    /* renamed from: TY */
    private TagManager f3857TY;

    /* renamed from: vl */
    private Status f3858vl;

    /* renamed from: zk */
    private boolean f3859zk;

    /* renamed from: zs */
    private final Looper f3860zs;

    /* renamed from: com.google.android.gms.tagmanager.n$a */
    public interface C1506a {
        /* renamed from: bc */
        void mo7797bc(String str);

        /* renamed from: iF */
        String mo7798iF();

        /* renamed from: iH */
        void mo7799iH();
    }

    /* renamed from: com.google.android.gms.tagmanager.n$b */
    private class C1507b extends Handler {

        /* renamed from: TZ */
        private final ContainerAvailableListener f3861TZ;

        public C1507b(ContainerAvailableListener containerAvailableListener, Looper looper) {
            super(looper);
            this.f3861TZ = containerAvailableListener;
        }

        /* renamed from: bd */
        public void mo7800bd(String str) {
            sendMessage(obtainMessage(1, str));
        }

        /* access modifiers changed from: protected */
        /* renamed from: be */
        public void mo7801be(String str) {
            this.f3861TZ.onContainerAvailable(C1505n.this, str);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    mo7801be((String) msg.obj);
                    return;
                default:
                    C1401bh.m4075t("Don't know how to handle this message.");
                    return;
            }
        }
    }

    public C1505n(Status status) {
        this.f3858vl = status;
        this.f3860zs = null;
    }

    public C1505n(TagManager tagManager, Looper looper, Container container, C1506a aVar) {
        this.f3857TY = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.f3860zs = looper;
        this.f3853TU = container;
        this.f3856TX = aVar;
        this.f3858vl = Status.f518zQ;
        tagManager.mo7548a(this);
    }

    /* renamed from: iG */
    private void m4435iG() {
        if (this.f3855TW != null) {
            this.f3855TW.mo7800bd(this.f3854TV.mo7513iD());
        }
    }

    /* renamed from: a */
    public synchronized void mo7792a(Container container) {
        if (!this.f3859zk) {
            if (container == null) {
                C1401bh.m4075t("Unexpected null container.");
            } else {
                this.f3854TV = container;
                m4435iG();
            }
        }
    }

    /* renamed from: ba */
    public synchronized void mo7793ba(String str) {
        if (!this.f3859zk) {
            this.f3853TU.mo7505ba(str);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bc */
    public void mo7794bc(String str) {
        if (this.f3859zk) {
            C1401bh.m4075t("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.f3856TX.mo7797bc(str);
        }
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.f3859zk) {
                C1401bh.m4075t("ContainerHolder is released.");
            } else {
                if (this.f3854TV != null) {
                    this.f3853TU = this.f3854TV;
                    this.f3854TV = null;
                }
                container = this.f3853TU;
            }
        }
        return container;
    }

    /* access modifiers changed from: 0000 */
    public String getContainerId() {
        if (!this.f3859zk) {
            return this.f3853TU.getContainerId();
        }
        C1401bh.m4075t("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public Status getStatus() {
        return this.f3858vl;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: iF */
    public String mo7796iF() {
        if (!this.f3859zk) {
            return this.f3856TX.mo7798iF();
        }
        C1401bh.m4075t("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public synchronized void refresh() {
        if (this.f3859zk) {
            C1401bh.m4075t("Refreshing a released ContainerHolder.");
        } else {
            this.f3856TX.mo7799iH();
        }
    }

    public synchronized void release() {
        if (this.f3859zk) {
            C1401bh.m4075t("Releasing a released ContainerHolder.");
        } else {
            this.f3859zk = true;
            this.f3857TY.mo7549b(this);
            this.f3853TU.release();
            this.f3853TU = null;
            this.f3854TV = null;
            this.f3856TX = null;
            this.f3855TW = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerAvailableListener listener) {
        if (this.f3859zk) {
            C1401bh.m4075t("ContainerHolder is released.");
        } else if (listener == null) {
            this.f3855TW = null;
        } else {
            this.f3855TW = new C1507b(listener, this.f3860zs);
            if (this.f3854TV != null) {
                m4435iG();
            }
        }
    }
}
