package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.cu */
public final class C0650cu {

    /* renamed from: pK */
    private static final ThreadFactory f1774pK = new ThreadFactory() {

        /* renamed from: pN */
        private final AtomicInteger f1777pN = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker #" + this.f1777pN.getAndIncrement());
        }
    };

    /* renamed from: pL */
    private static final ThreadPoolExecutor f1775pL = new ThreadPoolExecutor(0, 10, 65, TimeUnit.SECONDS, new SynchronousQueue(true), f1774pK);

    public static void execute(final Runnable task) {
        try {
            f1775pL.execute(new Runnable() {
                public void run() {
                    Process.setThreadPriority(10);
                    task.run();
                }
            });
        } catch (RejectedExecutionException e) {
            C0662da.m1549b("Too many background threads already running. Aborting task.", e);
        }
    }
}
