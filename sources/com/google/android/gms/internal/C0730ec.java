package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

/* renamed from: com.google.android.gms.internal.ec */
public final class C0730ec extends ImageView {

    /* renamed from: Bl */
    private Uri f1993Bl;

    /* renamed from: Bm */
    private int f1994Bm;

    /* renamed from: Bn */
    private int f1995Bn;

    /* renamed from: N */
    public void mo5014N(int i) {
        this.f1994Bm = i;
    }

    /* renamed from: d */
    public void mo5015d(Uri uri) {
        this.f1993Bl = uri;
    }

    /* renamed from: dQ */
    public int mo5016dQ() {
        return this.f1994Bm;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1995Bn != 0) {
            canvas.drawColor(this.f1995Bn);
        }
    }
}
