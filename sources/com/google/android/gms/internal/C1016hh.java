package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.C1174a;
import com.google.android.gms.location.C1174a.C1175a;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.hh */
public class C1016hh {

    /* renamed from: Lk */
    private final C1027hl<C1013hg> f2653Lk;

    /* renamed from: Ll */
    private ContentProviderClient f2654Ll = null;

    /* renamed from: Lm */
    private boolean f2655Lm = false;

    /* renamed from: Ln */
    private HashMap<LocationListener, C1018b> f2656Ln = new HashMap<>();
    private final Context mContext;

    /* renamed from: com.google.android.gms.internal.hh$a */
    private static class C1017a extends Handler {

        /* renamed from: Lo */
        private final LocationListener f2657Lo;

        public C1017a(LocationListener locationListener) {
            this.f2657Lo = locationListener;
        }

        public C1017a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.f2657Lo = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.f2657Lo.onLocationChanged(new Location((Location) msg.obj));
                    return;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    return;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.hh$b */
    private static class C1018b extends C1175a {

        /* renamed from: Lp */
        private Handler f2658Lp;

        C1018b(LocationListener locationListener, Looper looper) {
            this.f2658Lp = looper == null ? new C1017a(locationListener) : new C1017a(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.f2658Lp == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.f2658Lp.sendMessage(obtain);
        }

        public void release() {
            this.f2658Lp = null;
        }
    }

    public C1016hh(Context context, C1027hl<C1013hg> hlVar) {
        this.mContext = context;
        this.f2653Lk = hlVar;
    }

    public Location getLastLocation() {
        this.f2653Lk.mo5716bm();
        try {
            return ((C1013hg) this.f2653Lk.mo5717eb()).mo5680aF(this.mContext.getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: gl */
    public void mo5690gl() {
        if (this.f2655Lm) {
            setMockMode(false);
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.f2656Ln) {
                for (C1018b bVar : this.f2656Ln.values()) {
                    if (bVar != null) {
                        ((C1013hg) this.f2653Lk.mo5717eb()).mo5673a((C1174a) bVar);
                    }
                }
                this.f2656Ln.clear();
            }
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) {
        this.f2653Lk.mo5716bm();
        try {
            ((C1013hg) this.f2653Lk.mo5717eb()).mo5662a(callbackIntent);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(LocationListener listener) {
        this.f2653Lk.mo5716bm();
        C0766er.m1975b(listener, (Object) "Invalid null listener");
        synchronized (this.f2656Ln) {
            C1018b bVar = (C1018b) this.f2656Ln.remove(listener);
            if (this.f2654Ll != null && this.f2656Ln.isEmpty()) {
                this.f2654Ll.release();
                this.f2654Ll = null;
            }
            if (bVar != null) {
                bVar.release();
                try {
                    ((C1013hg) this.f2653Lk.mo5717eb()).mo5673a((C1174a) bVar);
                } catch (RemoteException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) {
        this.f2653Lk.mo5716bm();
        try {
            ((C1013hg) this.f2653Lk.mo5717eb()).mo5670a(request, callbackIntent);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) {
        this.f2653Lk.mo5716bm();
        if (looper == null) {
            C0766er.m1975b(Looper.myLooper(), (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        synchronized (this.f2656Ln) {
            C1018b bVar = (C1018b) this.f2656Ln.get(listener);
            C1018b bVar2 = bVar == null ? new C1018b(listener, looper) : bVar;
            this.f2656Ln.put(listener, bVar2);
            try {
                ((C1013hg) this.f2653Lk.mo5717eb()).mo5672a(request, (C1174a) bVar2, this.mContext.getPackageName());
            } catch (RemoteException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void setMockLocation(Location mockLocation) {
        this.f2653Lk.mo5716bm();
        try {
            ((C1013hg) this.f2653Lk.mo5717eb()).setMockLocation(mockLocation);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void setMockMode(boolean isMockMode) {
        this.f2653Lk.mo5716bm();
        try {
            ((C1013hg) this.f2653Lk.mo5717eb()).setMockMode(isMockMode);
            this.f2655Lm = isMockMode;
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }
}
