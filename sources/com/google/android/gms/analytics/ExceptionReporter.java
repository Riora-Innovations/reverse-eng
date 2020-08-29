package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.ExceptionBuilder;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class ExceptionReporter implements UncaughtExceptionHandler {
    private final Context mContext;

    /* renamed from: rd */
    private final UncaughtExceptionHandler f101rd;

    /* renamed from: re */
    private final Tracker f102re;

    /* renamed from: rf */
    private ExceptionParser f103rf;

    public ExceptionReporter(Tracker tracker, UncaughtExceptionHandler originalHandler, Context context) {
        if (tracker == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.f101rd = originalHandler;
            this.f102re = tracker;
            this.f103rf = new StandardExceptionParser(context, new ArrayList());
            this.mContext = context.getApplicationContext();
            C0181aa.m74v("ExceptionReporter created, original handler is " + (originalHandler == null ? "null" : originalHandler.getClass().getName()));
        }
    }

    public ExceptionParser getExceptionParser() {
        return this.f103rf;
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        this.f103rf = exceptionParser;
    }

    public void uncaughtException(Thread t, Throwable e) {
        String str = "UncaughtException";
        if (this.f103rf != null) {
            str = this.f103rf.getDescription(t != null ? t.getName() : null, e);
        }
        C0181aa.m74v("Tracking Exception: " + str);
        this.f102re.send(new ExceptionBuilder().setDescription(str).setFatal(true).build());
        GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
        if (this.f101rd != null) {
            C0181aa.m74v("Passing exception to original handler.");
            this.f101rd.uncaughtException(t, e);
        }
    }
}
