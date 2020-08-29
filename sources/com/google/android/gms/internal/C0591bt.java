package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;

/* renamed from: com.google.android.gms.internal.bt */
public final class C0591bt extends FrameLayout implements OnClickListener {

    /* renamed from: nK */
    private final ImageButton f1557nK;

    /* renamed from: nd */
    private final Activity f1558nd;

    public C0591bt(Activity activity, int i) {
        super(activity);
        this.f1558nd = activity;
        setOnClickListener(this);
        this.f1557nK = new ImageButton(activity);
        this.f1557nK.setImageResource(17301527);
        this.f1557nK.setBackgroundColor(0);
        this.f1557nK.setOnClickListener(this);
        this.f1557nK.setPadding(0, 0, 0, 0);
        int a = C0659cz.m1533a((Context) activity, i);
        addView(this.f1557nK, new LayoutParams(a, a, 17));
    }

    /* renamed from: g */
    public void mo4683g(boolean z) {
        this.f1557nK.setVisibility(z ? 4 : 0);
    }

    public void onClick(View view) {
        this.f1558nd.finish();
    }
}
