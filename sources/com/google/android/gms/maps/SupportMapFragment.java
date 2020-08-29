package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.p000v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0445a;
import com.google.android.gms.dynamic.C0456c;
import com.google.android.gms.dynamic.C0457d;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.maps.internal.C1257p;
import com.google.android.gms.maps.internal.C1258q;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportMapFragment extends Fragment {

    /* renamed from: Pn */
    private GoogleMap f3255Pn;

    /* renamed from: Py */
    private final C1198b f3256Py = new C1198b(this);

    /* renamed from: com.google.android.gms.maps.SupportMapFragment$a */
    static class C1197a implements LifecycleDelegate {

        /* renamed from: Pp */
        private final IMapFragmentDelegate f3257Pp;

        /* renamed from: Pz */
        private final Fragment f3258Pz;

        public C1197a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.f3257Pp = (IMapFragmentDelegate) C0766er.m1977f(iMapFragmentDelegate);
            this.f3258Pz = (Fragment) C0766er.m1977f(fragment);
        }

        /* renamed from: gV */
        public IMapFragmentDelegate mo6683gV() {
            return this.f3257Pp;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.f3258Pz.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                C1257p.m3678a(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f3257Pp.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C0456c.m1000b(this.f3257Pp.onCreateView(C0456c.m1001h(inflater), C0456c.m1001h(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.f3257Pp.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.f3257Pp.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.f3257Pp.onInflate(C0456c.m1001h(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.f3257Pp.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f3257Pp.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f3257Pp.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.f3257Pp.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.SupportMapFragment$b */
    static class C1198b extends C0445a<C1197a> {

        /* renamed from: Pq */
        protected C0457d<C1197a> f3259Pq;

        /* renamed from: Pz */
        private final Fragment f3260Pz;

        /* renamed from: nd */
        private Activity f3261nd;

        C1198b(Fragment fragment) {
            this.f3260Pz = fragment;
        }

        /* access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.f3261nd = activity;
            mo6684gW();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3929a(C0457d<C1197a> dVar) {
            this.f3259Pq = dVar;
            mo6684gW();
        }

        /* renamed from: gW */
        public void mo6684gW() {
            if (this.f3261nd != null && this.f3259Pq != null && mo3930fj() == null) {
                try {
                    MapsInitializer.initialize(this.f3261nd);
                    this.f3259Pq.mo3940a(new C1197a(this.f3260Pz, C1258q.m3679A(this.f3261nd).mo6811f(C0456c.m1001h(this.f3261nd))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions options) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    /* access modifiers changed from: protected */
    /* renamed from: gV */
    public IMapFragmentDelegate mo6681gV() {
        this.f3256Py.mo6684gW();
        if (this.f3256Py.mo3930fj() == null) {
            return null;
        }
        return ((C1197a) this.f3256Py.mo3930fj()).mo6683gV();
    }

    public final GoogleMap getMap() {
        IMapFragmentDelegate gV = mo6681gV();
        if (gV == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = gV.getMap();
            if (map == null) {
                return null;
            }
            if (this.f3255Pn == null || this.f3255Pn.mo6549gM().asBinder() != map.asBinder()) {
                this.f3255Pn = new GoogleMap(map);
            }
            return this.f3255Pn;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3256Py.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f3256Py.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.f3256Py.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.f3256Py.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f3256Py.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.f3256Py.setActivity(activity);
        GoogleMapOptions createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.f3256Py.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.f3256Py.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.f3256Py.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f3256Py.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.f3256Py.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
