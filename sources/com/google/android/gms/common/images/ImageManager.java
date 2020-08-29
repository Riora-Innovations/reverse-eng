package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.C0321a.C0322a;
import com.google.android.gms.internal.C0731ed;
import com.google.android.gms.internal.C0770ev;
import com.google.android.gms.internal.C0812fr;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    /* access modifiers changed from: private */

    /* renamed from: Ar */
    public static final Object f588Ar = new Object();
    /* access modifiers changed from: private */

    /* renamed from: As */
    public static HashSet<Uri> f589As = new HashSet<>();

    /* renamed from: At */
    private static ImageManager f590At;

    /* renamed from: Au */
    private static ImageManager f591Au;
    /* access modifiers changed from: private */

    /* renamed from: Av */
    public final ExecutorService f592Av = Executors.newFixedThreadPool(4);
    /* access modifiers changed from: private */

    /* renamed from: Aw */
    public final C0316b f593Aw;
    /* access modifiers changed from: private */

    /* renamed from: Ax */
    public final Map<C0321a, ImageReceiver> f594Ax;
    /* access modifiers changed from: private */

    /* renamed from: Ay */
    public final Map<Uri, ImageReceiver> f595Ay;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper());

    private final class ImageReceiver extends ResultReceiver {

        /* renamed from: AA */
        boolean f596AA = false;
        /* access modifiers changed from: private */

        /* renamed from: Az */
        public final ArrayList<C0321a> f598Az;
        private final Uri mUri;

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
            this.f598Az = new ArrayList<>();
        }

        /* renamed from: c */
        public void mo3392c(C0321a aVar) {
            C0731ed.m1822a(!this.f596AA, "Cannot add an ImageRequest when mHandlingRequests is true");
            C0731ed.m1823ac("ImageReceiver.addImageRequest() must be called in the main thread");
            this.f598Az.add(aVar);
        }

        /* renamed from: d */
        public void mo3393d(C0321a aVar) {
            C0731ed.m1822a(!this.f596AA, "Cannot remove an ImageRequest when mHandlingRequests is true");
            C0731ed.m1823ac("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.f598Az.remove(aVar);
        }

        /* renamed from: dN */
        public void mo3394dN() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            ImageManager.this.f592Av.execute(new C0317c(this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$a */
    private static final class C0315a {
        /* renamed from: a */
        static int m540a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$b */
    private static final class C0316b extends C0770ev<C0322a, Bitmap> {
        public C0316b(Context context) {
            super(m541w(context));
        }

        /* renamed from: w */
        private static int m541w(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (int) (((float) (((!((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0) || !C0812fr.m2121eJ()) ? activityManager.getMemoryClass() : C0315a.m540a(activityManager)) * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(C0322a aVar, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void entryRemoved(boolean z, C0322a aVar, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, aVar, bitmap, bitmap2);
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$c */
    private final class C0317c implements Runnable {

        /* renamed from: AC */
        private final ParcelFileDescriptor f600AC;
        private final Uri mUri;

        public C0317c(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.f600AC = parcelFileDescriptor;
        }

        public void run() {
            C0731ed.m1824ad("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.f600AC != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.f600AC.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.f600AC.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new C0320f(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$d */
    private final class C0318d implements Runnable {

        /* renamed from: AD */
        private final C0321a f602AD;

        public C0318d(C0321a aVar) {
            this.f602AD = aVar;
        }

        public void run() {
            C0731ed.m1823ac("LoadImageRunnable must be executed on the main thread");
            ImageManager.this.m527b(this.f602AD);
            C0322a aVar = this.f602AD.f611AF;
            if (aVar.uri == null) {
                this.f602AD.mo3421b(ImageManager.this.mContext, true);
                return;
            }
            Bitmap a = ImageManager.this.m523a(aVar);
            if (a != null) {
                this.f602AD.mo3418a(ImageManager.this.mContext, a, true);
                return;
            }
            this.f602AD.mo3424x(ImageManager.this.mContext);
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f595Ay.get(aVar.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(aVar.uri);
                ImageManager.this.f595Ay.put(aVar.uri, imageReceiver);
            }
            imageReceiver.mo3392c(this.f602AD);
            if (this.f602AD.f614AI != 1) {
                ImageManager.this.f594Ax.put(this.f602AD, imageReceiver);
            }
            synchronized (ImageManager.f588Ar) {
                if (!ImageManager.f589As.contains(aVar.uri)) {
                    ImageManager.f589As.add(aVar.uri);
                    imageReceiver.mo3394dN();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$e */
    private static final class C0319e implements ComponentCallbacks2 {

        /* renamed from: Aw */
        private final C0316b f603Aw;

        public C0319e(C0316b bVar) {
            this.f603Aw = bVar;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.f603Aw.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.f603Aw.evictAll();
            } else if (level >= 20) {
                this.f603Aw.trimToSize(this.f603Aw.size() / 2);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$f */
    private final class C0320f implements Runnable {

        /* renamed from: AE */
        private boolean f605AE;
        private final Bitmap mBitmap;
        private final Uri mUri;

        /* renamed from: zf */
        private final CountDownLatch f606zf;

        public C0320f(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.f605AE = z;
            this.f606zf = countDownLatch;
        }

        /* renamed from: a */
        private void m544a(ImageReceiver imageReceiver, boolean z) {
            imageReceiver.f596AA = true;
            ArrayList a = imageReceiver.f598Az;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                C0321a aVar = (C0321a) a.get(i);
                if (z) {
                    aVar.mo3418a(ImageManager.this.mContext, this.mBitmap, false);
                } else {
                    aVar.mo3421b(ImageManager.this.mContext, false);
                }
                if (aVar.f614AI != 1) {
                    ImageManager.this.f594Ax.remove(aVar);
                }
            }
            imageReceiver.f596AA = false;
        }

        public void run() {
            C0731ed.m1823ac("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.f593Aw != null) {
                if (this.f605AE) {
                    ImageManager.this.f593Aw.evictAll();
                    System.gc();
                    this.f605AE = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.f593Aw.put(new C0322a(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f595Ay.remove(this.mUri);
            if (imageReceiver != null) {
                m544a(imageReceiver, z);
            }
            this.f606zf.countDown();
            synchronized (ImageManager.f588Ar) {
                ImageManager.f589As.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        if (withMemoryCache) {
            this.f593Aw = new C0316b(this.mContext);
            if (C0812fr.m2124eM()) {
                m530dL();
            }
        } else {
            this.f593Aw = null;
        }
        this.f594Ax = new HashMap();
        this.f595Ay = new HashMap();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m523a(C0322a aVar) {
        if (this.f593Aw == null) {
            return null;
        }
        return (Bitmap) this.f593Aw.get(aVar);
    }

    /* renamed from: a */
    public static ImageManager m524a(Context context, boolean z) {
        if (z) {
            if (f591Au == null) {
                f591Au = new ImageManager(context, true);
            }
            return f591Au;
        }
        if (f590At == null) {
            f590At = new ImageManager(context, false);
        }
        return f590At;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m527b(C0321a aVar) {
        C0731ed.m1823ac("ImageManager.cleanupHashMaps() must be called in the main thread");
        if (aVar.f614AI == 1) {
            return true;
        }
        ImageReceiver imageReceiver = (ImageReceiver) this.f594Ax.get(aVar);
        if (imageReceiver == null) {
            return true;
        }
        if (imageReceiver.f596AA) {
            return false;
        }
        this.f594Ax.remove(aVar);
        imageReceiver.mo3393d(aVar);
        return true;
    }

    public static ImageManager create(Context context) {
        return m524a(context, false);
    }

    /* renamed from: dL */
    private void m530dL() {
        this.mContext.registerComponentCallbacks(new C0319e(this.f593Aw));
    }

    /* renamed from: a */
    public void mo3386a(C0321a aVar) {
        C0731ed.m1823ac("ImageManager.loadImage() must be called in the main thread");
        boolean b = m527b(aVar);
        C0318d dVar = new C0318d(aVar);
        if (b) {
            dVar.run();
        } else {
            this.mHandler.post(dVar);
        }
    }

    public void loadImage(ImageView imageView, int resId) {
        C0321a aVar = new C0321a(resId);
        aVar.mo3419a(imageView);
        mo3386a(aVar);
    }

    public void loadImage(ImageView imageView, Uri uri) {
        C0321a aVar = new C0321a(uri);
        aVar.mo3419a(imageView);
        mo3386a(aVar);
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        C0321a aVar = new C0321a(uri);
        aVar.mo3417L(defaultResId);
        aVar.mo3419a(imageView);
        mo3386a(aVar);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        C0321a aVar = new C0321a(uri);
        aVar.mo3420a(listener);
        mo3386a(aVar);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        C0321a aVar = new C0321a(uri);
        aVar.mo3417L(defaultResId);
        aVar.mo3420a(listener);
        mo3386a(aVar);
    }
}
