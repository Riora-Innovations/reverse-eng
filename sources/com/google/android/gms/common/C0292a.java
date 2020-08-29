package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.common.a */
public class C0292a implements ServiceConnection {

    /* renamed from: yG */
    boolean f504yG = false;

    /* renamed from: yH */
    private final BlockingQueue<IBinder> f505yH = new LinkedBlockingQueue();

    /* renamed from: dm */
    public IBinder mo3247dm() throws InterruptedException {
        if (this.f504yG) {
            throw new IllegalStateException();
        }
        this.f504yG = true;
        return (IBinder) this.f505yH.take();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        try {
            this.f505yH.put(service);
        } catch (InterruptedException e) {
        }
    }

    public void onServiceDisconnected(ComponentName name) {
    }
}
