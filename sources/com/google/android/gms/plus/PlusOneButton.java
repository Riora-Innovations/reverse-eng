package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.internal.C0769eu;
import com.google.android.gms.plus.internal.C1339g;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    /* access modifiers changed from: private */

    /* renamed from: QV */
    public View f3411QV;

    /* renamed from: QW */
    private int f3412QW;
    /* access modifiers changed from: private */

    /* renamed from: QX */
    public int f3413QX;

    /* renamed from: QY */
    private OnPlusOneClickListener f3414QY;
    private int mSize;

    /* renamed from: pS */
    private String f3415pS;

    protected class DefaultOnPlusOneClickListener implements OnClickListener, OnPlusOneClickListener {

        /* renamed from: QZ */
        private final OnPlusOneClickListener f3416QZ;

        public DefaultOnPlusOneClickListener(OnPlusOneClickListener proxy) {
            this.f3416QZ = proxy;
        }

        public void onClick(View view) {
            Intent intent = (Intent) PlusOneButton.this.f3411QV.getTag();
            if (this.f3416QZ != null) {
                this.f3416QZ.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = PlusOneButton.this.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, PlusOneButton.this.f3413QX);
            }
        }
    }

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSize = getSize(context, attrs);
        this.f3412QW = getAnnotation(context, attrs);
        this.f3413QX = -1;
        m3797v(getContext());
        if (isInEditMode()) {
        }
    }

    protected static int getAnnotation(Context context, AttributeSet attrs) {
        String a = C0769eu.m1989a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attrs, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(a)) {
            return 2;
        }
        return !"NONE".equalsIgnoreCase(a) ? 1 : 0;
    }

    protected static int getSize(Context context, AttributeSet attrs) {
        String a = C0769eu.m1989a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attrs, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(a)) {
            return 0;
        }
        if ("MEDIUM".equalsIgnoreCase(a)) {
            return 1;
        }
        return "TALL".equalsIgnoreCase(a) ? 2 : 3;
    }

    /* renamed from: v */
    private void m3797v(Context context) {
        if (this.f3411QV != null) {
            removeView(this.f3411QV);
        }
        this.f3411QV = C1339g.m3910a(context, this.mSize, this.f3412QW, this.f3415pS, this.f3413QX);
        setOnPlusOneClickListener(this.f3414QY);
        addView(this.f3411QV);
    }

    public void initialize(String url, int activityRequestCode) {
        C0766er.m1970a(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.f3415pS = url;
        this.f3413QX = activityRequestCode;
        m3797v(getContext());
    }

    public void initialize(String url, OnPlusOneClickListener plusOneClickListener) {
        this.f3415pS = url;
        this.f3413QX = 0;
        m3797v(getContext());
        setOnPlusOneClickListener(plusOneClickListener);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.f3411QV.layout(0, 0, right - left, bottom - top);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.f3411QV;
        measureChild(view, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setAnnotation(int annotation) {
        this.f3412QW = annotation;
        m3797v(getContext());
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener listener) {
        this.f3414QY = listener;
        this.f3411QV.setOnClickListener(new DefaultOnPlusOneClickListener(listener));
    }

    public void setSize(int size) {
        this.mSize = size;
        m3797v(getContext());
    }
}
