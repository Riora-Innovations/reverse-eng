package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.C1156p.C1157a;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.j */
public abstract class C1107j extends C1046i {

    /* renamed from: kc */
    private static Method f3061kc;

    /* renamed from: kd */
    private static Method f3062kd;

    /* renamed from: ke */
    private static Method f3063ke;

    /* renamed from: kf */
    private static Method f3064kf;

    /* renamed from: kg */
    private static Method f3065kg;

    /* renamed from: kh */
    private static Method f3066kh;

    /* renamed from: ki */
    private static String f3067ki;

    /* renamed from: kj */
    private static C1156p f3068kj;

    /* renamed from: kk */
    static boolean f3069kk = false;
    private static long startTime = 0;

    /* renamed from: com.google.android.gms.internal.j$a */
    static class C1108a extends Exception {
        public C1108a() {
        }

        public C1108a(Throwable th) {
            super(th);
        }
    }

    protected C1107j(Context context, C1154n nVar, C1155o oVar) {
        super(context, nVar, oVar);
    }

    /* renamed from: a */
    static String m3295a(Context context, C1154n nVar) throws C1108a {
        if (f3063ke == null) {
            throw new C1108a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) f3063ke.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return nVar.mo4987a(byteBuffer.array(), true);
            }
            throw new C1108a();
        } catch (IllegalAccessException e) {
            throw new C1108a(e);
        } catch (InvocationTargetException e2) {
            throw new C1108a(e2);
        }
    }

    /* renamed from: a */
    static ArrayList<Long> m3296a(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws C1108a {
        if (f3064kf == null || motionEvent == null) {
            throw new C1108a();
        }
        try {
            return (ArrayList) f3064kf.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (IllegalAccessException e) {
            throw new C1108a(e);
        } catch (InvocationTargetException e2) {
            throw new C1108a(e2);
        }
    }

    /* renamed from: a */
    protected static synchronized void m3297a(String str, Context context, C1154n nVar) {
        synchronized (C1107j.class) {
            if (!f3069kk) {
                try {
                    f3068kj = new C1156p(nVar, null);
                    f3067ki = str;
                    m3301e(context);
                    startTime = m3303w().longValue();
                    f3069kk = true;
                } catch (C1108a | UnsupportedOperationException e) {
                }
            }
        }
    }

    /* renamed from: b */
    static String m3298b(Context context, C1154n nVar) throws C1108a {
        if (f3066kh == null) {
            throw new C1108a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) f3066kh.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return nVar.mo4987a(byteBuffer.array(), true);
            }
            throw new C1108a();
        } catch (IllegalAccessException e) {
            throw new C1108a(e);
        } catch (InvocationTargetException e2) {
            throw new C1108a(e2);
        }
    }

    /* renamed from: b */
    private static String m3299b(byte[] bArr, String str) throws C1108a {
        try {
            return new String(f3068kj.mo6438c(bArr, str), "UTF-8");
        } catch (C1157a e) {
            throw new C1108a(e);
        } catch (UnsupportedEncodingException e2) {
            throw new C1108a(e2);
        }
    }

    /* renamed from: d */
    static String m3300d(Context context) throws C1108a {
        if (f3065kg == null) {
            throw new C1108a();
        }
        try {
            String str = (String) f3065kg.invoke(null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new C1108a();
        } catch (IllegalAccessException e) {
            throw new C1108a(e);
        } catch (InvocationTargetException e2) {
            throw new C1108a(e2);
        }
    }

    /* renamed from: e */
    private static void m3301e(Context context) throws C1108a {
        try {
            byte[] d = f3068kj.mo6439d(C1159r.getKey());
            byte[] c = f3068kj.mo6438c(d, C1159r.m3507A());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new C1108a();
                }
            }
            File createTempFile = File.createTempFile("ads", ".jar", cacheDir);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(c, 0, c.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), cacheDir.getAbsolutePath(), null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(m3299b(d, C1159r.m3508B()));
            Class loadClass2 = dexClassLoader.loadClass(m3299b(d, C1159r.m3514H()));
            Class loadClass3 = dexClassLoader.loadClass(m3299b(d, C1159r.m3512F()));
            Class loadClass4 = dexClassLoader.loadClass(m3299b(d, C1159r.m3518L()));
            Class loadClass5 = dexClassLoader.loadClass(m3299b(d, C1159r.m3510D()));
            Class loadClass6 = dexClassLoader.loadClass(m3299b(d, C1159r.m3516J()));
            f3061kc = loadClass.getMethod(m3299b(d, C1159r.m3509C()), new Class[0]);
            f3062kd = loadClass2.getMethod(m3299b(d, C1159r.m3515I()), new Class[0]);
            f3063ke = loadClass3.getMethod(m3299b(d, C1159r.m3513G()), new Class[]{Context.class});
            f3064kf = loadClass4.getMethod(m3299b(d, C1159r.m3519M()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            f3065kg = loadClass5.getMethod(m3299b(d, C1159r.m3511E()), new Class[]{Context.class});
            f3066kh = loadClass6.getMethod(m3299b(d, C1159r.m3517K()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(cacheDir, name.replace(".jar", ".dex")).delete();
        } catch (FileNotFoundException e) {
            throw new C1108a(e);
        } catch (IOException e2) {
            throw new C1108a(e2);
        } catch (ClassNotFoundException e3) {
            throw new C1108a(e3);
        } catch (C1157a e4) {
            throw new C1108a(e4);
        } catch (NoSuchMethodException e5) {
            throw new C1108a(e5);
        } catch (NullPointerException e6) {
            throw new C1108a(e6);
        }
    }

    /* renamed from: v */
    static String m3302v() throws C1108a {
        if (f3067ki != null) {
            return f3067ki;
        }
        throw new C1108a();
    }

    /* renamed from: w */
    static Long m3303w() throws C1108a {
        if (f3061kc == null) {
            throw new C1108a();
        }
        try {
            return (Long) f3061kc.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new C1108a(e);
        } catch (InvocationTargetException e2) {
            throw new C1108a(e2);
        }
    }

    /* renamed from: x */
    static String m3304x() throws C1108a {
        if (f3062kd == null) {
            throw new C1108a();
        }
        try {
            return (String) f3062kd.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new C1108a(e);
        } catch (InvocationTargetException e2) {
            throw new C1108a(e2);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:1:0x0001] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo5832b(android.content.Context r4) {
        /*
            r3 = this;
            r0 = 1
            java.lang.String r1 = m3304x()     // Catch:{ a -> 0x002f, IOException -> 0x0027 }
            r3.mo5830a(r0, r1)     // Catch:{ a -> 0x002f, IOException -> 0x0027 }
        L_0x0008:
            r0 = 2
            java.lang.String r1 = m3302v()     // Catch:{ a -> 0x002d, IOException -> 0x0027 }
            r3.mo5830a(r0, r1)     // Catch:{ a -> 0x002d, IOException -> 0x0027 }
        L_0x0010:
            r0 = 25
            java.lang.Long r1 = m3303w()     // Catch:{ a -> 0x002b, IOException -> 0x0027 }
            long r1 = r1.longValue()     // Catch:{ a -> 0x002b, IOException -> 0x0027 }
            r3.mo5829a(r0, r1)     // Catch:{ a -> 0x002b, IOException -> 0x0027 }
        L_0x001d:
            r0 = 24
            java.lang.String r1 = m3300d(r4)     // Catch:{ a -> 0x0029, IOException -> 0x0027 }
            r3.mo5830a(r0, r1)     // Catch:{ a -> 0x0029, IOException -> 0x0027 }
        L_0x0026:
            return
        L_0x0027:
            r0 = move-exception
            goto L_0x0026
        L_0x0029:
            r0 = move-exception
            goto L_0x0026
        L_0x002b:
            r0 = move-exception
            goto L_0x001d
        L_0x002d:
            r0 = move-exception
            goto L_0x0010
        L_0x002f:
            r0 = move-exception
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1107j.mo5832b(android.content.Context):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008a A[ExcHandler: IOException (e java.io.IOException), Splitter:B:6:0x0010] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo5833c(android.content.Context r7) {
        /*
            r6 = this;
            r0 = 2
            java.lang.String r1 = m3302v()     // Catch:{ a -> 0x0097, IOException -> 0x008a }
            r6.mo5830a(r0, r1)     // Catch:{ a -> 0x0097, IOException -> 0x008a }
        L_0x0008:
            r0 = 1
            java.lang.String r1 = m3304x()     // Catch:{ a -> 0x0094, IOException -> 0x008a }
            r6.mo5830a(r0, r1)     // Catch:{ a -> 0x0094, IOException -> 0x008a }
        L_0x0010:
            java.lang.Long r0 = m3303w()     // Catch:{ a -> 0x0092, IOException -> 0x008a }
            long r0 = r0.longValue()     // Catch:{ a -> 0x0092, IOException -> 0x008a }
            r2 = 25
            r6.mo5829a(r2, r0)     // Catch:{ a -> 0x0092, IOException -> 0x008a }
            long r2 = startTime     // Catch:{ a -> 0x0092, IOException -> 0x008a }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0034
            r2 = 17
            long r3 = startTime     // Catch:{ a -> 0x0092, IOException -> 0x008a }
            long r0 = r0 - r3
            r6.mo5829a(r2, r0)     // Catch:{ a -> 0x0092, IOException -> 0x008a }
            r0 = 23
            long r1 = startTime     // Catch:{ a -> 0x0092, IOException -> 0x008a }
            r6.mo5829a(r0, r1)     // Catch:{ a -> 0x0092, IOException -> 0x008a }
        L_0x0034:
            android.view.MotionEvent r0 = r6.f2852jY     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            android.util.DisplayMetrics r1 = r6.f2853jZ     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            java.util.ArrayList r1 = m3296a(r0, r1)     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            r2 = 14
            r0 = 0
            java.lang.Object r0 = r1.get(r0)     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            long r3 = r0.longValue()     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            r6.mo5829a(r2, r3)     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            r2 = 15
            r0 = 1
            java.lang.Object r0 = r1.get(r0)     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            long r3 = r0.longValue()     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            r6.mo5829a(r2, r3)     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            int r0 = r1.size()     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            r2 = 3
            if (r0 < r2) goto L_0x0073
            r2 = 16
            r0 = 2
            java.lang.Object r0 = r1.get(r0)     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            long r0 = r0.longValue()     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            r6.mo5829a(r2, r0)     // Catch:{ a -> 0x0090, IOException -> 0x008a }
        L_0x0073:
            r0 = 27
            com.google.android.gms.internal.n r1 = r6.f2854ka     // Catch:{ a -> 0x008e, IOException -> 0x008a }
            java.lang.String r1 = m3295a(r7, r1)     // Catch:{ a -> 0x008e, IOException -> 0x008a }
            r6.mo5830a(r0, r1)     // Catch:{ a -> 0x008e, IOException -> 0x008a }
        L_0x007e:
            r0 = 29
            com.google.android.gms.internal.n r1 = r6.f2854ka     // Catch:{ a -> 0x008c, IOException -> 0x008a }
            java.lang.String r1 = m3298b(r7, r1)     // Catch:{ a -> 0x008c, IOException -> 0x008a }
            r6.mo5830a(r0, r1)     // Catch:{ a -> 0x008c, IOException -> 0x008a }
        L_0x0089:
            return
        L_0x008a:
            r0 = move-exception
            goto L_0x0089
        L_0x008c:
            r0 = move-exception
            goto L_0x0089
        L_0x008e:
            r0 = move-exception
            goto L_0x007e
        L_0x0090:
            r0 = move-exception
            goto L_0x0073
        L_0x0092:
            r0 = move-exception
            goto L_0x0034
        L_0x0094:
            r0 = move-exception
            goto L_0x0010
        L_0x0097:
            r0 = move-exception
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1107j.mo5833c(android.content.Context):void");
    }
}
