package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.android.gms.dynamic.a */
public abstract class C0445a<T extends LifecycleDelegate> {
    /* access modifiers changed from: private */

    /* renamed from: Fp */
    public T f858Fp;
    /* access modifiers changed from: private */

    /* renamed from: Fq */
    public Bundle f859Fq;
    /* access modifiers changed from: private */

    /* renamed from: Fr */
    public LinkedList<C0452a> f860Fr;

    /* renamed from: Fs */
    private final C0457d<T> f861Fs = new C0457d<T>() {
        /* renamed from: a */
        public void mo3940a(T t) {
            C0445a.this.f858Fp = t;
            Iterator it = C0445a.this.f860Fr.iterator();
            while (it.hasNext()) {
                ((C0452a) it.next()).mo3941b(C0445a.this.f858Fp);
            }
            C0445a.this.f860Fr.clear();
            C0445a.this.f859Fq = null;
        }
    };

    /* renamed from: com.google.android.gms.dynamic.a$a */
    private interface C0452a {
        /* renamed from: b */
        void mo3941b(LifecycleDelegate lifecycleDelegate);

        int getState();
    }

    /* renamed from: a */
    private void m986a(Bundle bundle, C0452a aVar) {
        if (this.f858Fp != null) {
            aVar.mo3941b(this.f858Fp);
            return;
        }
        if (this.f860Fr == null) {
            this.f860Fr = new LinkedList<>();
        }
        this.f860Fr.add(aVar);
        if (bundle != null) {
            if (this.f859Fq == null) {
                this.f859Fq = (Bundle) bundle.clone();
            } else {
                this.f859Fq.putAll(bundle);
            }
        }
        mo3929a(this.f861Fs);
    }

    /* renamed from: aO */
    private void m987aO(int i) {
        while (!this.f860Fr.isEmpty() && ((C0452a) this.f860Fr.getLast()).getState() >= i) {
            this.f860Fr.removeLast();
        }
    }

    /* renamed from: b */
    public static void m989b(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String b = GooglePlayServicesUtil.m427b(context, isGooglePlayServicesAvailable, -1);
        String b2 = GooglePlayServicesUtil.m426b(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(b);
        linearLayout.addView(textView);
        if (b2 != null) {
            Button button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(b2);
            linearLayout.addView(button);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    context.startActivity(GooglePlayServicesUtil.m422a(context, isGooglePlayServicesAvailable, -1));
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3928a(FrameLayout frameLayout) {
        m989b(frameLayout);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo3929a(C0457d<T> dVar);

    /* renamed from: fj */
    public T mo3930fj() {
        return this.f858Fp;
    }

    public void onCreate(final Bundle savedInstanceState) {
        m986a(savedInstanceState, (C0452a) new C0452a() {
            /* renamed from: b */
            public void mo3941b(LifecycleDelegate lifecycleDelegate) {
                C0445a.this.f858Fp.onCreate(savedInstanceState);
            }

            public int getState() {
                return 1;
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        final LayoutInflater layoutInflater = inflater;
        final ViewGroup viewGroup = container;
        final Bundle bundle = savedInstanceState;
        m986a(savedInstanceState, (C0452a) new C0452a() {
            /* renamed from: b */
            public void mo3941b(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(C0445a.this.f858Fp.onCreateView(layoutInflater, viewGroup, bundle));
            }

            public int getState() {
                return 2;
            }
        });
        if (this.f858Fp == null) {
            mo3928a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.f858Fp != null) {
            this.f858Fp.onDestroy();
        } else {
            m987aO(1);
        }
    }

    public void onDestroyView() {
        if (this.f858Fp != null) {
            this.f858Fp.onDestroyView();
        } else {
            m987aO(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle attrs, final Bundle savedInstanceState) {
        m986a(savedInstanceState, (C0452a) new C0452a() {
            /* renamed from: b */
            public void mo3941b(LifecycleDelegate lifecycleDelegate) {
                C0445a.this.f858Fp.onInflate(activity, attrs, savedInstanceState);
            }

            public int getState() {
                return 0;
            }
        });
    }

    public void onLowMemory() {
        if (this.f858Fp != null) {
            this.f858Fp.onLowMemory();
        }
    }

    public void onPause() {
        if (this.f858Fp != null) {
            this.f858Fp.onPause();
        } else {
            m987aO(5);
        }
    }

    public void onResume() {
        m986a((Bundle) null, (C0452a) new C0452a() {
            /* renamed from: b */
            public void mo3941b(LifecycleDelegate lifecycleDelegate) {
                C0445a.this.f858Fp.onResume();
            }

            public int getState() {
                return 5;
            }
        });
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.f858Fp != null) {
            this.f858Fp.onSaveInstanceState(outState);
        } else if (this.f859Fq != null) {
            outState.putAll(this.f859Fq);
        }
    }
}
