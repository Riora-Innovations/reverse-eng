package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0445a;
import com.google.android.gms.dynamic.C0456c;
import com.google.android.gms.dynamic.C0457d;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.maps.internal.C1258q;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView extends FrameLayout {

    /* renamed from: Pn */
    private GoogleMap f3246Pn;

    /* renamed from: Pr */
    private final C1196b f3247Pr;

    /* renamed from: com.google.android.gms.maps.MapView$a */
    static class C1195a implements LifecycleDelegate {

        /* renamed from: Ps */
        private final ViewGroup f3248Ps;

        /* renamed from: Pt */
        private final IMapViewDelegate f3249Pt;

        /* renamed from: Pu */
        private View f3250Pu;

        public C1195a(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.f3249Pt = (IMapViewDelegate) C0766er.m1977f(iMapViewDelegate);
            this.f3248Ps = (ViewGroup) C0766er.m1977f(viewGroup);
        }

        /* renamed from: gX */
        public IMapViewDelegate mo6676gX() {
            return this.f3249Pt;
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.f3249Pt.onCreate(savedInstanceState);
                this.f3250Pu = (View) C0456c.m1000b(this.f3249Pt.getView());
                this.f3248Ps.removeAllViews();
                this.f3248Ps.addView(this.f3250Pu);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.f3249Pt.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.f3249Pt.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f3249Pt.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f3249Pt.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.f3249Pt.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.MapView$b */
    static class C1196b extends C0445a<C1195a> {

        /* renamed from: Pq */
        protected C0457d<C1195a> f3251Pq;

        /* renamed from: Pv */
        private final ViewGroup f3252Pv;

        /* renamed from: Pw */
        private final GoogleMapOptions f3253Pw;
        private final Context mContext;

        C1196b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.f3252Pv = viewGroup;
            this.mContext = context;
            this.f3253Pw = googleMapOptions;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3929a(C0457d<C1195a> dVar) {
            this.f3251Pq = dVar;
            mo6677gW();
        }

        /* renamed from: gW */
        public void mo6677gW() {
            if (this.f3251Pq != null && mo3930fj() == null) {
                try {
                    this.f3251Pq.mo3940a(new C1195a(this.f3252Pv, C1258q.m3679A(this.mContext).mo6808a(C0456c.m1001h(this.mContext), this.f3253Pw)));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.f3247Pr = new C1196b(this, context, null);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f3247Pr = new C1196b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f3247Pr = new C1196b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, GoogleMapOptions options) {
        super(context);
        this.f3247Pr = new C1196b(this, context, options);
    }

    public final GoogleMap getMap() {
        if (this.f3246Pn != null) {
            return this.f3246Pn;
        }
        this.f3247Pr.mo6677gW();
        if (this.f3247Pr.mo3930fj() == null) {
            return null;
        }
        try {
            this.f3246Pn = new GoogleMap(((C1195a) this.f3247Pr.mo3930fj()).mo6676gX().getMap());
            return this.f3246Pn;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.f3247Pr.onCreate(savedInstanceState);
        if (this.f3247Pr.mo3930fj() == null) {
            C1196b bVar = this.f3247Pr;
            C1196b.m989b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.f3247Pr.onDestroy();
    }

    public final void onLowMemory() {
        this.f3247Pr.onLowMemory();
    }

    public final void onPause() {
        this.f3247Pr.onPause();
    }

    public final void onResume() {
        this.f3247Pr.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.f3247Pr.onSaveInstanceState(outState);
    }
}
