package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.C0522ak;

public final class AdView extends ViewGroup {

    /* renamed from: kD */
    private final C0522ak f60kD;

    public AdView(Context context) {
        super(context);
        this.f60kD = new C0522ak(this);
    }

    public AdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f60kD = new C0522ak(this, attrs, false);
    }

    public AdView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f60kD = new C0522ak(this, attrs, false);
    }

    public void destroy() {
        this.f60kD.destroy();
    }

    public AdListener getAdListener() {
        return this.f60kD.getAdListener();
    }

    public AdSize getAdSize() {
        return this.f60kD.getAdSize();
    }

    public String getAdUnitId() {
        return this.f60kD.getAdUnitId();
    }

    public void loadAd(AdRequest adRequest) {
        this.f60kD.mo4546a(adRequest.mo2610N());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i = ((right - left) - measuredWidth) / 2;
            int i2 = ((bottom - top) - measuredHeight) / 2;
            childAt.layout(i, i2, measuredWidth + i, measuredHeight + i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int i2 = 0;
        View childAt = getChildAt(0);
        AdSize adSize = getAdSize();
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
            i = childAt.getMeasuredWidth();
            i2 = childAt.getMeasuredHeight();
        } else if (adSize != null) {
            Context context = getContext();
            i = adSize.getWidthInPixels(context);
            i2 = adSize.getHeightInPixels(context);
        } else {
            i = 0;
        }
        setMeasuredDimension(View.resolveSize(Math.max(i, getSuggestedMinimumWidth()), widthMeasureSpec), View.resolveSize(Math.max(i2, getSuggestedMinimumHeight()), heightMeasureSpec));
    }

    public void pause() {
        this.f60kD.pause();
    }

    public void resume() {
        this.f60kD.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.f60kD.setAdListener(adListener);
    }

    public void setAdSize(AdSize adSize) {
        this.f60kD.setAdSizes(adSize);
    }

    public void setAdUnitId(String adUnitId) {
        this.f60kD.setAdUnitId(adUnitId);
    }
}
