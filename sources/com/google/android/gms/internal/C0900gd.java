package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.gd */
public class C0900gd {

    /* renamed from: HB */
    protected C0819fx f2487HB;

    /* renamed from: HC */
    protected C0902a f2488HC;

    /* renamed from: com.google.android.gms.internal.gd$a */
    public static final class C0902a {

        /* renamed from: HD */
        public IBinder f2489HD;

        /* renamed from: HE */
        public int f2490HE;
        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;

        private C0902a(int i, IBinder iBinder) {
            this.f2490HE = -1;
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.gravity = i;
            this.f2489HD = iBinder;
        }

        /* renamed from: fQ */
        public Bundle mo5557fQ() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.gravity);
            bundle.putInt("popupLocationInfo.displayId", this.f2490HE);
            bundle.putInt("popupLocationInfo.left", this.left);
            bundle.putInt("popupLocationInfo.top", this.top);
            bundle.putInt("popupLocationInfo.right", this.right);
            bundle.putInt("popupLocationInfo.bottom", this.bottom);
            return bundle;
        }
    }

    /* renamed from: com.google.android.gms.internal.gd$b */
    private static final class C0903b extends C0900gd implements OnAttachStateChangeListener, OnGlobalLayoutListener {

        /* renamed from: GA */
        private boolean f2491GA = false;

        /* renamed from: HF */
        private WeakReference<View> f2492HF;

        protected C0903b(C0819fx fxVar, int i) {
            super(fxVar, i);
        }

        /* renamed from: g */
        private void m2801g(View view) {
            int i = -1;
            if (C0812fr.m2126eO()) {
                Display display = view.getDisplay();
                if (display != null) {
                    i = display.getDisplayId();
                }
            }
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.f2488HC.f2490HE = i;
            this.f2488HC.f2489HD = windowToken;
            this.f2488HC.left = iArr[0];
            this.f2488HC.top = iArr[1];
            this.f2488HC.right = iArr[0] + width;
            this.f2488HC.bottom = iArr[1] + height;
            if (this.f2491GA) {
                mo5553fN();
                this.f2491GA = false;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: aV */
        public void mo5551aV(int i) {
            this.f2488HC = new C0902a(i, null);
        }

        /* renamed from: f */
        public void mo5552f(View view) {
            this.f2487HB.mo5345fH();
            if (this.f2492HF != null) {
                View view2 = (View) this.f2492HF.get();
                Context context = this.f2487HB.getContext();
                if (view2 == null && (context instanceof Activity)) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    if (C0812fr.m2125eN()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            }
            this.f2492HF = null;
            Context context2 = this.f2487HB.getContext();
            if (view == null && (context2 instanceof Activity)) {
                View findViewById = ((Activity) context2).findViewById(16908290);
                if (findViewById == null) {
                    findViewById = ((Activity) context2).getWindow().getDecorView();
                }
                C0891fz.m2398g("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
                view = findViewById;
            }
            if (view != null) {
                m2801g(view);
                this.f2492HF = new WeakReference<>(view);
                view.addOnAttachStateChangeListener(this);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            }
            C0891fz.m2399h("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
        }

        /* renamed from: fN */
        public void mo5553fN() {
            if (this.f2488HC.f2489HD != null) {
                C0900gd.super.mo5553fN();
            } else {
                this.f2491GA = this.f2492HF != null;
            }
        }

        public void onGlobalLayout() {
            if (this.f2492HF != null) {
                View view = (View) this.f2492HF.get();
                if (view != null) {
                    m2801g(view);
                }
            }
        }

        public void onViewAttachedToWindow(View v) {
            m2801g(v);
        }

        public void onViewDetachedFromWindow(View v) {
            this.f2487HB.mo5345fH();
            v.removeOnAttachStateChangeListener(this);
        }
    }

    private C0900gd(C0819fx fxVar, int i) {
        this.f2487HB = fxVar;
        mo5551aV(i);
    }

    /* renamed from: a */
    public static C0900gd m2794a(C0819fx fxVar, int i) {
        return C0812fr.m2122eK() ? new C0903b(fxVar, i) : new C0900gd(fxVar, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: aV */
    public void mo5551aV(int i) {
        this.f2488HC = new C0902a(i, new Binder());
    }

    /* renamed from: f */
    public void mo5552f(View view) {
    }

    /* renamed from: fN */
    public void mo5553fN() {
        this.f2487HB.mo5296a(this.f2488HC.f2489HD, this.f2488HC.mo5557fQ());
    }

    /* renamed from: fO */
    public Bundle mo5554fO() {
        return this.f2488HC.mo5557fQ();
    }

    /* renamed from: fP */
    public IBinder mo5555fP() {
        return this.f2488HC.f2489HD;
    }

    public void setGravity(int gravity) {
        this.f2488HC.gravity = gravity;
    }
}
