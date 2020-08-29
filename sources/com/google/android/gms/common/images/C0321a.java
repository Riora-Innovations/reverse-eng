package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.internal.C0724ea;
import com.google.android.gms.internal.C0729eb;
import com.google.android.gms.internal.C0730ec;
import com.google.android.gms.internal.C0731ed;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0812fr;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.images.a */
public final class C0321a {

    /* renamed from: AF */
    final C0322a f611AF;

    /* renamed from: AG */
    private int f612AG;

    /* renamed from: AH */
    private int f613AH;

    /* renamed from: AI */
    int f614AI;

    /* renamed from: AJ */
    private int f615AJ;

    /* renamed from: AK */
    private WeakReference<OnImageLoadedListener> f616AK;

    /* renamed from: AL */
    private WeakReference<ImageView> f617AL;

    /* renamed from: AM */
    private WeakReference<TextView> f618AM;

    /* renamed from: AN */
    private int f619AN;

    /* renamed from: AO */
    private boolean f620AO;

    /* renamed from: AP */
    private boolean f621AP;

    /* renamed from: AQ */
    private int f622AQ;

    /* renamed from: com.google.android.gms.common.images.a$a */
    public static final class C0322a {
        public final Uri uri;

        public C0322a(Uri uri2) {
            this.uri = uri2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0322a)) {
                return false;
            }
            return this == obj || ((C0322a) obj).hashCode() == hashCode();
        }

        public int hashCode() {
            return C0762ep.hashCode(this.uri);
        }
    }

    public C0321a(int i) {
        this.f612AG = 0;
        this.f613AH = 0;
        this.f619AN = -1;
        this.f620AO = true;
        this.f621AP = false;
        this.f611AF = new C0322a(null);
        this.f613AH = i;
    }

    public C0321a(Uri uri) {
        this.f612AG = 0;
        this.f613AH = 0;
        this.f619AN = -1;
        this.f620AO = true;
        this.f621AP = false;
        this.f611AF = new C0322a(uri);
        this.f613AH = 0;
    }

    /* renamed from: a */
    private C0724ea m547a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof C0724ea) {
            drawable = ((C0724ea) drawable).mo4990dO();
        }
        return new C0724ea(drawable, drawable2);
    }

    /* renamed from: a */
    private void m548a(Drawable drawable, boolean z, boolean z2, boolean z3) {
        switch (this.f614AI) {
            case 1:
                if (!z2) {
                    OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.f616AK.get();
                    if (onImageLoadedListener != null) {
                        onImageLoadedListener.onImageLoaded(this.f611AF.uri, drawable, z3);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                ImageView imageView = (ImageView) this.f617AL.get();
                if (imageView != null) {
                    m549a(imageView, drawable, z, z2, z3);
                    return;
                }
                return;
            case 3:
                TextView textView = (TextView) this.f618AM.get();
                if (textView != null) {
                    m550a(textView, this.f619AN, drawable, z, z2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m549a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
        boolean z4 = !z2 && !z3;
        if (z4 && (imageView instanceof C0730ec)) {
            int dQ = ((C0730ec) imageView).mo5016dQ();
            if (this.f613AH != 0 && dQ == this.f613AH) {
                return;
            }
        }
        boolean b = m551b(z, z2);
        Drawable drawable2 = b ? m547a(imageView.getDrawable(), drawable) : drawable;
        imageView.setImageDrawable(drawable2);
        if (imageView instanceof C0730ec) {
            C0730ec ecVar = (C0730ec) imageView;
            ecVar.mo5015d(z3 ? this.f611AF.uri : null);
            ecVar.mo5014N(z4 ? this.f613AH : 0);
        }
        if (b) {
            ((C0724ea) drawable2).startTransition(250);
        }
    }

    /* renamed from: a */
    private void m550a(TextView textView, int i, Drawable drawable, boolean z, boolean z2) {
        boolean b = m551b(z, z2);
        Drawable[] compoundDrawables = C0812fr.m2126eO() ? textView.getCompoundDrawablesRelative() : textView.getCompoundDrawables();
        Drawable drawable2 = b ? m547a(compoundDrawables[i], drawable) : drawable;
        Drawable drawable3 = i == 0 ? drawable2 : compoundDrawables[0];
        Drawable drawable4 = i == 1 ? drawable2 : compoundDrawables[1];
        Drawable drawable5 = i == 2 ? drawable2 : compoundDrawables[2];
        Drawable drawable6 = i == 3 ? drawable2 : compoundDrawables[3];
        if (C0812fr.m2126eO()) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable3, drawable4, drawable5, drawable6);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable3, drawable4, drawable5, drawable6);
        }
        if (b) {
            ((C0724ea) drawable2).startTransition(250);
        }
    }

    /* renamed from: b */
    private boolean m551b(boolean z, boolean z2) {
        return this.f620AO && !z2 && (!z || this.f621AP);
    }

    /* renamed from: L */
    public void mo3417L(int i) {
        this.f613AH = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3418a(Context context, Bitmap bitmap, boolean z) {
        C0731ed.m1825d(bitmap);
        if ((this.f622AQ & 1) != 0) {
            bitmap = C0729eb.m1816a(bitmap);
        }
        m548a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    /* renamed from: a */
    public void mo3419a(ImageView imageView) {
        C0731ed.m1825d(imageView);
        this.f616AK = null;
        this.f617AL = new WeakReference<>(imageView);
        this.f618AM = null;
        this.f619AN = -1;
        this.f614AI = 2;
        this.f615AJ = imageView.hashCode();
    }

    /* renamed from: a */
    public void mo3420a(OnImageLoadedListener onImageLoadedListener) {
        C0731ed.m1825d(onImageLoadedListener);
        this.f616AK = new WeakReference<>(onImageLoadedListener);
        this.f617AL = null;
        this.f618AM = null;
        this.f619AN = -1;
        this.f614AI = 1;
        this.f615AJ = C0762ep.hashCode(onImageLoadedListener, this.f611AF);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo3421b(Context context, boolean z) {
        Drawable drawable = null;
        if (this.f613AH != 0) {
            Resources resources = context.getResources();
            drawable = resources.getDrawable(this.f613AH);
            if ((this.f622AQ & 1) != 0) {
                drawable = C0729eb.m1818a(resources, drawable);
            }
        }
        m548a(drawable, z, false, false);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0321a)) {
            return false;
        }
        return this == obj || ((C0321a) obj).hashCode() == hashCode();
    }

    public int hashCode() {
        return this.f615AJ;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: x */
    public void mo3424x(Context context) {
        Drawable drawable = null;
        if (this.f612AG != 0) {
            Resources resources = context.getResources();
            drawable = resources.getDrawable(this.f612AG);
            if ((this.f622AQ & 1) != 0) {
                drawable = C0729eb.m1818a(resources, drawable);
            }
        }
        m548a(drawable, false, true, false);
    }
}
