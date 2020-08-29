package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.C0458e.C0459a;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.internal.C0767es;
import com.google.android.gms.internal.C0768et;

public final class SignInButton extends FrameLayout implements OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mSize;

    /* renamed from: yX */
    private int f501yX;

    /* renamed from: yY */
    private View f502yY;

    /* renamed from: yZ */
    private OnClickListener f503yZ;

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SignInButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f503yZ = null;
        setStyle(0, 0);
    }

    /* renamed from: c */
    private static Button m433c(Context context, int i, int i2) {
        C0768et etVar = new C0768et(context);
        etVar.mo5125a(context.getResources(), i, i2);
        return etVar;
    }

    /* renamed from: v */
    private void m434v(Context context) {
        if (this.f502yY != null) {
            removeView(this.f502yY);
        }
        try {
            this.f502yY = C0767es.m1980d(context, this.mSize, this.f501yX);
        } catch (C0459a e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.f502yY = m433c(context, this.mSize, this.f501yX);
        }
        addView(this.f502yY);
        this.f502yY.setEnabled(isEnabled());
        this.f502yY.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.f503yZ != null && view == this.f502yY) {
            this.f503yZ.onClick(this);
        }
    }

    public void setColorScheme(int colorScheme) {
        setStyle(this.mSize, colorScheme);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.f502yY.setEnabled(enabled);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.f503yZ = listener;
        if (this.f502yY != null) {
            this.f502yY.setOnClickListener(this);
        }
    }

    public void setSize(int buttonSize) {
        setStyle(buttonSize, this.f501yX);
    }

    public void setStyle(int buttonSize, int colorScheme) {
        boolean z = true;
        C0766er.m1970a(buttonSize >= 0 && buttonSize < 3, "Unknown button size " + buttonSize);
        if (colorScheme < 0 || colorScheme >= 2) {
            z = false;
        }
        C0766er.m1970a(z, "Unknown color scheme " + colorScheme);
        this.mSize = buttonSize;
        this.f501yX = colorScheme;
        m434v(getContext());
    }
}
