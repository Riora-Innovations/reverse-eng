package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.eg */
public abstract class C0735eg implements SafeParcelable {

    /* renamed from: Br */
    private static final Object f2005Br = new Object();

    /* renamed from: Bs */
    private static ClassLoader f2006Bs = null;

    /* renamed from: Bt */
    private static Integer f2007Bt = null;

    /* renamed from: Bu */
    private boolean f2008Bu = false;

    /* renamed from: a */
    private static boolean m1837a(Class<?> cls) {
        boolean z = false;
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return z;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ae */
    public static boolean m1838ae(String str) {
        ClassLoader dX = m1839dX();
        if (dX == null) {
            return true;
        }
        try {
            return m1837a(dX.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: dX */
    protected static ClassLoader m1839dX() {
        ClassLoader classLoader;
        synchronized (f2005Br) {
            classLoader = f2006Bs;
        }
        return classLoader;
    }

    /* access modifiers changed from: protected */
    /* renamed from: dY */
    public static Integer m1840dY() {
        Integer num;
        synchronized (f2005Br) {
            num = f2007Bt;
        }
        return num;
    }

    /* access modifiers changed from: protected */
    /* renamed from: dZ */
    public boolean mo5034dZ() {
        return this.f2008Bu;
    }
}
