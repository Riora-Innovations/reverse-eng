package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {

    /* renamed from: XB */
    private static TagManager f3553XB;

    /* renamed from: TN */
    private final DataLayer f3554TN;

    /* renamed from: Wj */
    private final C1519r f3555Wj;

    /* renamed from: XA */
    private final ConcurrentMap<C1505n, Boolean> f3556XA;

    /* renamed from: Xz */
    private final C1357a f3557Xz;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.TagManager$a */
    interface C1357a {
        /* renamed from: a */
        C1508o mo7559a(Context context, TagManager tagManager, Looper looper, String str, int i, C1519r rVar);
    }

    TagManager(Context context, C1357a containerHolderLoaderProvider, DataLayer dataLayer) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.f3557Xz = containerHolderLoaderProvider;
        this.f3556XA = new ConcurrentHashMap();
        this.f3554TN = dataLayer;
        this.f3554TN.mo7527a((C1350b) new C1350b() {
            /* renamed from: v */
            public void mo7543v(Map<String, Object> map) {
                Object obj = map.get(DataLayer.EVENT_KEY);
                if (obj != null) {
                    TagManager.this.m3970bE(obj.toString());
                }
            }
        });
        this.f3554TN.mo7527a((C1350b) new C1477d(this.mContext));
        this.f3555Wj = new C1519r();
    }

    /* access modifiers changed from: private */
    /* renamed from: bE */
    public void m3970bE(String str) {
        for (C1505n ba : this.f3556XA.keySet()) {
            ba.mo7793ba(str);
        }
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (f3553XB == null) {
                if (context == null) {
                    C1401bh.m4075t("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                f3553XB = new TagManager(context, new C1357a() {
                    /* renamed from: a */
                    public C1508o mo7559a(Context context, TagManager tagManager, Looper looper, String str, int i, C1519r rVar) {
                        return new C1508o(context, tagManager, looper, str, i, rVar);
                    }
                }, new DataLayer(new C1524v(context)));
            }
            tagManager = f3553XB;
        }
        return tagManager;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7548a(C1505n nVar) {
        this.f3556XA.put(nVar, Boolean.valueOf(true));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo7549b(C1505n nVar) {
        return this.f3556XA.remove(nVar) != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public synchronized boolean mo7550f(Uri uri) {
        boolean z;
        C1429ce ju = C1429ce.m4170ju();
        if (ju.mo7666f(uri)) {
            String containerId = ju.getContainerId();
            switch (ju.mo7668jv()) {
                case NONE:
                    for (C1505n nVar : this.f3556XA.keySet()) {
                        if (nVar.getContainerId().equals(containerId)) {
                            nVar.mo7794bc(null);
                            nVar.refresh();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (C1505n nVar2 : this.f3556XA.keySet()) {
                        if (nVar2.getContainerId().equals(containerId)) {
                            nVar2.mo7794bc(ju.mo7669jw());
                            nVar2.refresh();
                        } else if (nVar2.mo7796iF() != null) {
                            nVar2.mo7794bc(null);
                            nVar2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public DataLayer getDataLayer() {
        return this.f3554TN;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        C1508o a = this.f3557Xz.mo7559a(this.mContext, this, null, containerId, defaultContainerResourceId, this.f3555Wj);
        a.mo7806iI();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        C1508o a = this.f3557Xz.mo7559a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.f3555Wj);
        a.mo7806iI();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        C1508o a = this.f3557Xz.mo7559a(this.mContext, this, null, containerId, defaultContainerResourceId, this.f3555Wj);
        a.mo7808iK();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        C1508o a = this.f3557Xz.mo7559a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.f3555Wj);
        a.mo7808iK();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        C1508o a = this.f3557Xz.mo7559a(this.mContext, this, null, containerId, defaultContainerResourceId, this.f3555Wj);
        a.mo7807iJ();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        C1508o a = this.f3557Xz.mo7559a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.f3555Wj);
        a.mo7807iJ();
        return a;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        C1401bh.setLogLevel(enableVerboseLogging ? 2 : 5);
    }
}
