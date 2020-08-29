package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.C0167R;
import java.util.LinkedHashSet;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.ib */
public class C1048ib {
    private static final String TAG = C1048ib.class.getSimpleName();

    /* renamed from: Lk */
    private final C1027hl<C1013hg> f2856Lk;

    /* renamed from: OA */
    private final LinkedHashSet<String> f2857OA = new LinkedHashSet<>();

    /* renamed from: Or */
    private final Locale f2858Or;

    /* renamed from: Os */
    private final C1049ic f2859Os;

    /* renamed from: Oz */
    private final C1050id f2860Oz;
    private final Context mContext;

    public C1048ib(Context context, Locale locale, C1027hl<C1013hg> hlVar) {
        int i;
        this.mContext = context;
        this.f2856Lk = hlVar;
        this.f2858Or = locale;
        this.f2860Oz = new C1050id(context, locale);
        this.f2857OA.add(context.getString(C0167R.string.location_client_powered_by_google));
        String packageName = this.mContext.getPackageName();
        try {
            i = this.mContext.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (NameNotFoundException e) {
            i = -1;
        }
        this.f2859Os = new C1049ic(this.f2856Lk, packageName, i);
    }
}
