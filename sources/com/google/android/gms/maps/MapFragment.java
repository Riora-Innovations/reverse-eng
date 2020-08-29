package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
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

public class MapFragment extends Fragment {

    /* renamed from: Pm */
    private final C1194b f3239Pm = new C1194b(this);

    /* renamed from: Pn */
    private GoogleMap f3240Pn;

    /* renamed from: com.google.android.gms.maps.MapFragment$a */
    static class C1193a implements LifecycleDelegate {

        /* renamed from: Po */
        private final Fragment f3241Po;

        /* renamed from: Pp */
        private final IMapFragmentDelegate f3242Pp;

        public C1193a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.f3242Pp = (IMapFragmentDelegate) C0766er.m1977f(iMapFragmentDelegate);
            this.f3241Po = (Fragment) C0766er.m1977f(fragment);
        }

        /* renamed from: gV */
        public IMapFragmentDelegate mo6667gV() {
            return this.f3242Pp;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.f3241Po.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                C1257p.m3678a(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f3242Pp.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C0456c.m1000b(this.f3242Pp.onCreateView(C0456c.m1001h(inflater), C0456c.m1001h(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.f3242Pp.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.f3242Pp.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.f3242Pp.onInflate(C0456c.m1001h(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.f3242Pp.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f3242Pp.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f3242Pp.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.f3242Pp.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.MapFragment$b */
    static class C1194b extends C0445a<C1193a> {

        /* renamed from: Po */
        private final Fragment f3243Po;

        /* renamed from: Pq */
        protected C0457d<C1193a> f3244Pq;

        /* renamed from: nd */
        private Activity f3245nd;

        C1194b(Fragment fragment) {
            this.f3243Po = fragment;
        }

        /* access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.f3245nd = activity;
            mo6668gW();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3929a(C0457d<C1193a> dVar) {
            this.f3244Pq = dVar;
            mo6668gW();
        }

        /* renamed from: gW */
        public void mo6668gW() {
            if (this.f3245nd != null && this.f3244Pq != null && mo3930fj() == null) {
                try {
                    MapsInitializer.initialize(this.f3245nd);
                    this.f3244Pq.mo3940a(new C1193a(this.f3243Po, C1258q.m3679A(this.f3245nd).mo6811f(C0456c.m1001h(this.f3245nd))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions options) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    /* access modifiers changed from: protected */
    /* renamed from: gV */
    public IMapFragmentDelegate mo6653gV() {
        this.f3239Pm.mo6668gW();
        if (this.f3239Pm.mo3930fj() == null) {
            return null;
        }
        return ((C1193a) this.f3239Pm.mo3930fj()).mo6667gV();
    }

    public final GoogleMap getMap() {
        IMapFragmentDelegate gV = mo6653gV();
        if (gV == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = gV.getMap();
            if (map == null) {
                return null;
            }
            if (this.f3240Pn == null || this.f3240Pn.mo6549gM().asBinder() != map.asBinder()) {
                this.f3240Pn = new GoogleMap(map);
            }
            return this.f3240Pn;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3239Pm.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f3239Pm.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.f3239Pm.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.f3239Pm.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f3239Pm.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.f3239Pm.setActivity(activity);
        GoogleMapOptions createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.f3239Pm.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.f3239Pm.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.f3239Pm.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f3239Pm.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.f3239Pm.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
