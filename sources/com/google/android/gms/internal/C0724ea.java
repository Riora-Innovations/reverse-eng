package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import android.support.p000v4.view.MotionEventCompat;

/* renamed from: com.google.android.gms.internal.ea */
public final class C0724ea extends Drawable implements Callback {

    /* renamed from: AO */
    private boolean f1973AO;

    /* renamed from: AS */
    private int f1974AS;

    /* renamed from: AT */
    private long f1975AT;

    /* renamed from: AU */
    private int f1976AU;

    /* renamed from: AV */
    private int f1977AV;

    /* renamed from: AW */
    private int f1978AW;

    /* renamed from: AX */
    private int f1979AX;

    /* renamed from: AY */
    private int f1980AY;

    /* renamed from: AZ */
    private boolean f1981AZ;

    /* renamed from: Ba */
    private C0728b f1982Ba;

    /* renamed from: Bb */
    private Drawable f1983Bb;

    /* renamed from: Bc */
    private Drawable f1984Bc;

    /* renamed from: Bd */
    private boolean f1985Bd;

    /* renamed from: Be */
    private boolean f1986Be;

    /* renamed from: Bf */
    private boolean f1987Bf;

    /* renamed from: Bg */
    private int f1988Bg;

    /* renamed from: com.google.android.gms.internal.ea$a */
    private static final class C0726a extends Drawable {
        /* access modifiers changed from: private */

        /* renamed from: Bh */
        public static final C0726a f1989Bh = new C0726a();

        /* renamed from: Bi */
        private static final C0727a f1990Bi = new C0727a();

        /* renamed from: com.google.android.gms.internal.ea$a$a */
        private static final class C0727a extends ConstantState {
            private C0727a() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return C0726a.f1989Bh;
            }
        }

        private C0726a() {
        }

        public void draw(Canvas canvas) {
        }

        public ConstantState getConstantState() {
            return f1990Bi;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int alpha) {
        }

        public void setColorFilter(ColorFilter cf) {
        }
    }

    /* renamed from: com.google.android.gms.internal.ea$b */
    static final class C0728b extends ConstantState {

        /* renamed from: Bj */
        int f1991Bj;

        /* renamed from: Bk */
        int f1992Bk;

        C0728b(C0728b bVar) {
            if (bVar != null) {
                this.f1991Bj = bVar.f1991Bj;
                this.f1992Bk = bVar.f1992Bk;
            }
        }

        public int getChangingConfigurations() {
            return this.f1991Bj;
        }

        public Drawable newDrawable() {
            return new C0724ea(this);
        }
    }

    public C0724ea(Drawable drawable, Drawable drawable2) {
        this(null);
        if (drawable == null) {
            drawable = C0726a.f1989Bh;
        }
        this.f1983Bb = drawable;
        drawable.setCallback(this);
        this.f1982Ba.f1992Bk |= drawable.getChangingConfigurations();
        if (drawable2 == null) {
            drawable2 = C0726a.f1989Bh;
        }
        this.f1984Bc = drawable2;
        drawable2.setCallback(this);
        this.f1982Ba.f1992Bk |= drawable2.getChangingConfigurations();
    }

    C0724ea(C0728b bVar) {
        this.f1974AS = 0;
        this.f1978AW = MotionEventCompat.ACTION_MASK;
        this.f1980AY = 0;
        this.f1973AO = true;
        this.f1982Ba = new C0728b(bVar);
    }

    public boolean canConstantState() {
        if (!this.f1985Bd) {
            this.f1986Be = (this.f1983Bb.getConstantState() == null || this.f1984Bc.getConstantState() == null) ? false : true;
            this.f1985Bd = true;
        }
        return this.f1986Be;
    }

    /* renamed from: dO */
    public Drawable mo4990dO() {
        return this.f1984Bc;
    }

    public void draw(Canvas canvas) {
        boolean z = true;
        boolean z2 = false;
        switch (this.f1974AS) {
            case 1:
                this.f1975AT = SystemClock.uptimeMillis();
                this.f1974AS = 2;
                break;
            case 2:
                if (this.f1975AT >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f1975AT)) / ((float) this.f1979AX);
                    if (uptimeMillis < 1.0f) {
                        z = false;
                    }
                    if (z) {
                        this.f1974AS = 0;
                    }
                    float min = Math.min(uptimeMillis, 1.0f);
                    this.f1980AY = (int) ((min * ((float) (this.f1977AV - this.f1976AU))) + ((float) this.f1976AU));
                    break;
                }
                break;
        }
        z2 = z;
        int i = this.f1980AY;
        boolean z3 = this.f1973AO;
        Drawable drawable = this.f1983Bb;
        Drawable drawable2 = this.f1984Bc;
        if (z2) {
            if (!z3 || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.f1978AW) {
                drawable2.setAlpha(this.f1978AW);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.f1978AW - i);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.f1978AW);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.f1978AW);
        }
        invalidateSelf();
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f1982Ba.f1991Bj | this.f1982Ba.f1992Bk;
    }

    public ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.f1982Ba.f1991Bj = getChangingConfigurations();
        return this.f1982Ba;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.f1983Bb.getIntrinsicHeight(), this.f1984Bc.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.f1983Bb.getIntrinsicWidth(), this.f1984Bc.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.f1987Bf) {
            this.f1988Bg = Drawable.resolveOpacity(this.f1983Bb.getOpacity(), this.f1984Bc.getOpacity());
            this.f1987Bf = true;
        }
        return this.f1988Bg;
    }

    public void invalidateDrawable(Drawable who) {
        if (C0812fr.m2121eJ()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public Drawable mutate() {
        if (!this.f1981AZ && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.f1983Bb.mutate();
            this.f1984Bc.mutate();
            this.f1981AZ = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        this.f1983Bb.setBounds(bounds);
        this.f1984Bc.setBounds(bounds);
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        if (C0812fr.m2121eJ()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.scheduleDrawable(this, what, when);
            }
        }
    }

    public void setAlpha(int alpha) {
        if (this.f1980AY == this.f1978AW) {
            this.f1980AY = alpha;
        }
        this.f1978AW = alpha;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter cf) {
        this.f1983Bb.setColorFilter(cf);
        this.f1984Bc.setColorFilter(cf);
    }

    public void startTransition(int durationMillis) {
        this.f1976AU = 0;
        this.f1977AV = this.f1978AW;
        this.f1980AY = 0;
        this.f1979AX = durationMillis;
        this.f1974AS = 1;
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        if (C0812fr.m2121eJ()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.unscheduleDrawable(this, what);
            }
        }
    }
}
