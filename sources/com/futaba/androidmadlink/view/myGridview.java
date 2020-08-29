package com.futaba.androidmadlink.view;

import android.content.Context;
import android.support.p003v7.widget.GridLayout;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;

public class myGridview extends GridLayout {
    public myGridview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public myGridview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public myGridview(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
