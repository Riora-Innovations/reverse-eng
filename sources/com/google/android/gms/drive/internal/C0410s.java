package com.google.android.gms.drive.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C0420w.C0421a;
import com.google.android.gms.internal.C0766er;

/* renamed from: com.google.android.gms.drive.internal.s */
public class C0410s<C extends DriveEvent> extends C0421a {

    /* renamed from: DR */
    private final Listener<C> f796DR;

    /* renamed from: DS */
    private final C0412a<C> f797DS;

    /* renamed from: Dm */
    private final int f798Dm;

    /* renamed from: com.google.android.gms.drive.internal.s$a */
    private static class C0412a<E extends DriveEvent> extends Handler {
        private C0412a(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public void mo3761a(Listener<E> listener, E e) {
            sendMessage(obtainMessage(1, new Pair(listener, e)));
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    ((Listener) pair.first).onEvent((DriveEvent) pair.second);
                    return;
                default:
                    Log.wtf("EventCallback", "Don't know how to handle this event");
                    return;
            }
        }
    }

    public C0410s(Looper looper, int i, Listener<C> listener) {
        this.f798Dm = i;
        this.f796DR = listener;
        this.f797DS = new C0412a<>(looper);
    }

    /* renamed from: a */
    public void mo3760a(OnEventResponse onEventResponse) throws RemoteException {
        C0766er.m1978v(this.f798Dm == onEventResponse.getEventType());
        switch (onEventResponse.getEventType()) {
            case 1:
                this.f797DS.mo3761a(this.f796DR, onEventResponse.mo3601fa());
                return;
            case 2:
                this.f797DS.mo3761a(this.f796DR, onEventResponse.mo3602fb());
                return;
            default:
                Log.w("EventCallback", "Unexpected event type:" + onEventResponse.getEventType());
                return;
        }
    }
}
