package com.google.android.gms.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.C0680di;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.achartengine.chart.TimeChart;
import org.apache.http.impl.client.DefaultHttpClient;

/* renamed from: com.google.android.gms.analytics.ac */
class C0183ac implements C0200d {
    /* access modifiers changed from: private */

    /* renamed from: ua */
    public static final String f149ua = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: rJ */
    public C0206i f150rJ;

    /* renamed from: rr */
    private final C0201e f151rr;

    /* renamed from: ub */
    private final C0185a f152ub;

    /* renamed from: uc */
    private volatile C0212n f153uc;
    /* access modifiers changed from: private */

    /* renamed from: ud */
    public final String f154ud;

    /* renamed from: ue */
    private C0182ab f155ue;

    /* renamed from: uf */
    private long f156uf;

    /* renamed from: ug */
    private final int f157ug;

    /* renamed from: com.google.android.gms.analytics.ac$a */
    class C0185a extends SQLiteOpenHelper {

        /* renamed from: ui */
        private boolean f160ui;

        /* renamed from: uj */
        private long f161uj = 0;

        C0185a(Context context, String str) {
            super(context, str, null, 1);
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private void m97a(SQLiteDatabase sQLiteDatabase) {
            boolean z = false;
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (String add : columnNames) {
                    hashSet.add(add);
                }
                rawQuery.close();
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_string") || !hashSet.remove("hit_time")) {
                    throw new SQLiteException("Database column missing");
                }
                if (!hashSet.remove("hit_app_id")) {
                    z = true;
                }
                if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                } else if (z) {
                    sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
                }
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean m98a(java.lang.String r11, android.database.sqlite.SQLiteDatabase r12) {
            /*
                r10 = this;
                r8 = 0
                r9 = 0
                java.lang.String r1 = "SQLITE_MASTER"
                r0 = 1
                java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
                r0 = 0
                java.lang.String r3 = "name"
                r2[r0] = r3     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
                java.lang.String r3 = "name=?"
                r0 = 1
                java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
                r0 = 0
                r4[r0] = r11     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
                r5 = 0
                r6 = 0
                r7 = 0
                r0 = r12
                android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
                boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0053, all -> 0x004c }
                if (r1 == 0) goto L_0x0025
                r1.close()
            L_0x0025:
                return r0
            L_0x0026:
                r0 = move-exception
                r0 = r9
            L_0x0028:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
                r1.<init>()     // Catch:{ all -> 0x004f }
                java.lang.String r2 = "Error querying for table "
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x004f }
                java.lang.StringBuilder r1 = r1.append(r11)     // Catch:{ all -> 0x004f }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x004f }
                com.google.android.gms.analytics.C0181aa.m75w(r1)     // Catch:{ all -> 0x004f }
                if (r0 == 0) goto L_0x0043
                r0.close()
            L_0x0043:
                r0 = r8
                goto L_0x0025
            L_0x0045:
                r0 = move-exception
            L_0x0046:
                if (r9 == 0) goto L_0x004b
                r9.close()
            L_0x004b:
                throw r0
            L_0x004c:
                r0 = move-exception
                r9 = r1
                goto L_0x0046
            L_0x004f:
                r1 = move-exception
                r9 = r0
                r0 = r1
                goto L_0x0046
            L_0x0053:
                r0 = move-exception
                r0 = r1
                goto L_0x0028
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.C0183ac.C0185a.m98a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.f160ui || this.f161uj + 3600000 <= C0183ac.this.f150rJ.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.f160ui = true;
                this.f161uj = C0183ac.this.f150rJ.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    C0183ac.this.mContext.getDatabasePath(C0183ac.this.f154ud).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.f160ui = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
        }

        public void onCreate(SQLiteDatabase db) {
            C0214p.m197B(db.getPath());
        }

        public void onOpen(SQLiteDatabase db) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (!m98a("hits2", db)) {
                db.execSQL(C0183ac.f149ua);
            } else {
                m97a(db);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    C0183ac(C0201e eVar, Context context) {
        this(eVar, context, "google_analytics_v4.db", 2000);
    }

    C0183ac(C0201e eVar, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.f154ud = str;
        this.f151rr = eVar;
        this.f150rJ = new C0206i() {
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        };
        this.f152ub = new C0185a(this.mContext, this.f154ud);
        this.f153uc = new C0190ah(new DefaultHttpClient(), this.mContext);
        this.f156uf = 0;
        this.f157ug = i;
    }

    /* renamed from: G */
    private SQLiteDatabase m78G(String str) {
        try {
            return this.f152ub.getWritableDatabase();
        } catch (SQLiteException e) {
            C0181aa.m75w(str);
            return null;
        }
    }

    /* renamed from: a */
    private void m80a(Map<String, String> map, long j, String str) {
        long j2;
        SQLiteDatabase G = m78G("Error opening database for putHit");
        if (G != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_string", m86t(map));
            contentValues.put("hit_time", Long.valueOf(j));
            if (map.containsKey("AppUID")) {
                try {
                    j2 = Long.parseLong((String) map.get("AppUID"));
                } catch (NumberFormatException e) {
                    j2 = 0;
                }
            } else {
                j2 = 0;
            }
            contentValues.put("hit_app_id", Long.valueOf(j2));
            if (str == null) {
                str = "http://www.google-analytics.com/collect";
            }
            if (str.length() == 0) {
                C0181aa.m75w("Empty path: not sending hit");
                return;
            }
            contentValues.put("hit_url", str);
            try {
                G.insert("hits2", null, contentValues);
                this.f151rr.mo2933p(false);
            } catch (SQLiteException e2) {
                C0181aa.m75w("Error storing hit");
            }
        }
    }

    /* renamed from: a */
    private void m81a(Map<String, String> map, Collection<C0680di> collection) {
        String substring = "&_v".substring(1);
        if (collection != null) {
            for (C0680di diVar : collection) {
                if ("appendVersion".equals(diVar.getId())) {
                    map.put(substring, diVar.getValue());
                    return;
                }
            }
        }
    }

    /* renamed from: co */
    private void m84co() {
        int cq = (mo2878cq() - this.f157ug) + 1;
        if (cq > 0) {
            List s = mo2880s(cq);
            C0181aa.m74v("Store full, deleting " + s.size() + " hits to make room.");
            mo2873a((String[]) s.toArray(new String[0]));
        }
    }

    /* renamed from: t */
    static String m86t(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(C0239y.encode((String) entry.getKey()) + "=" + C0239y.encode((String) entry.getValue()));
        }
        return TextUtils.join("&", arrayList);
    }

    /* renamed from: a */
    public void mo2872a(Map<String, String> map, long j, String str, Collection<C0680di> collection) {
        mo2877cp();
        m84co();
        m81a(map, collection);
        m80a(map, j, str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2873a(String[] strArr) {
        boolean z = true;
        if (strArr == null || strArr.length == 0) {
            C0181aa.m75w("Empty hitIds passed to deleteHits.");
            return;
        }
        SQLiteDatabase G = m78G("Error opening database for deleteHits.");
        if (G != null) {
            try {
                G.delete("hits2", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                C0201e eVar = this.f151rr;
                if (mo2878cq() != 0) {
                    z = false;
                }
                eVar.mo2933p(z);
            } catch (SQLiteException e) {
                C0181aa.m75w("Error deleting hits " + strArr);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    /* renamed from: b */
    public void mo2874b(Collection<C0238x> collection) {
        if (collection == null || collection.isEmpty()) {
            C0181aa.m75w("Empty/Null collection passed to deleteHits.");
            return;
        }
        String[] strArr = new String[collection.size()];
        int i = 0;
        for (C0238x ci : collection) {
            int i2 = i + 1;
            strArr[i] = String.valueOf(ci.mo2987ci());
            i = i2;
        }
        mo2873a(strArr);
    }

    /* renamed from: bp */
    public void mo2875bp() {
        boolean z = true;
        C0181aa.m74v("Dispatch running...");
        if (this.f153uc.mo2902bA()) {
            List t = mo2881t(40);
            if (t.isEmpty()) {
                C0181aa.m74v("...nothing to dispatch");
                this.f151rr.mo2933p(true);
                return;
            }
            if (this.f155ue == null) {
                this.f155ue = new C0182ab("_t=dispatch&_v=ma4.0.0", true);
            }
            if (mo2878cq() > t.size()) {
                z = false;
            }
            int a = this.f153uc.mo2899a(t, this.f155ue, z);
            C0181aa.m74v("sent " + a + " of " + t.size() + " hits");
            mo2874b((Collection<C0238x>) t.subList(0, Math.min(a, t.size())));
            if (a != t.size() || mo2878cq() <= 0) {
                this.f155ue = null;
            } else {
                GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
            }
        }
    }

    /* renamed from: bq */
    public C0212n mo2876bq() {
        return this.f153uc;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cp */
    public int mo2877cp() {
        boolean z = true;
        long currentTimeMillis = this.f150rJ.currentTimeMillis();
        if (currentTimeMillis <= this.f156uf + TimeChart.DAY) {
            return 0;
        }
        this.f156uf = currentTimeMillis;
        SQLiteDatabase G = m78G("Error opening database for deleteStaleHits.");
        if (G == null) {
            return 0;
        }
        int delete = G.delete("hits2", "HIT_TIME < ?", new String[]{Long.toString(this.f150rJ.currentTimeMillis() - 2592000000L)});
        C0201e eVar = this.f151rr;
        if (mo2878cq() != 0) {
            z = false;
        }
        eVar.mo2933p(z);
        return delete;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cq */
    public int mo2878cq() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase G = m78G("Error opening database for getNumStoredHits.");
        if (G != null) {
            try {
                Cursor rawQuery = G.rawQuery("SELECT COUNT(*) from hits2", null);
                if (rawQuery.moveToFirst()) {
                    i = (int) rawQuery.getLong(0);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e) {
                C0181aa.m75w("Error getting numStoredHits");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return i;
    }

    /* renamed from: i */
    public void mo2879i(long j) {
        boolean z = true;
        SQLiteDatabase G = m78G("Error opening database for clearHits");
        if (G != null) {
            if (j == 0) {
                G.delete("hits2", null, null);
            } else {
                G.delete("hits2", "hit_app_id = ?", new String[]{Long.valueOf(j).toString()});
            }
            C0201e eVar = this.f151rr;
            if (mo2878cq() != 0) {
                z = false;
            }
            eVar.mo2933p(z);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> mo2880s(int r14) {
        /*
            r13 = this;
            r10 = 0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            if (r14 > 0) goto L_0x000f
            java.lang.String r0 = "Invalid maxHits specified. Skipping"
            com.google.android.gms.analytics.C0181aa.m75w(r0)
            r0 = r9
        L_0x000e:
            return r0
        L_0x000f:
            java.lang.String r0 = "Error opening database for peekHitIds."
            android.database.sqlite.SQLiteDatabase r0 = r13.m78G(r0)
            if (r0 != 0) goto L_0x0019
            r0 = r9
            goto L_0x000e
        L_0x0019:
            java.lang.String r1 = "hits2"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "%s ASC"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            r11 = 0
            java.lang.String r12 = "hit_id"
            r8[r11] = r12     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            java.lang.String r8 = java.lang.Integer.toString(r14)     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0088 }
            if (r0 == 0) goto L_0x0055
        L_0x0043:
            r0 = 0
            long r2 = r1.getLong(r0)     // Catch:{ SQLiteException -> 0x0088 }
            java.lang.String r0 = java.lang.String.valueOf(r2)     // Catch:{ SQLiteException -> 0x0088 }
            r9.add(r0)     // Catch:{ SQLiteException -> 0x0088 }
            boolean r0 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0088 }
            if (r0 != 0) goto L_0x0043
        L_0x0055:
            if (r1 == 0) goto L_0x005a
            r1.close()
        L_0x005a:
            r0 = r9
            goto L_0x000e
        L_0x005c:
            r0 = move-exception
            r1 = r10
        L_0x005e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r2.<init>()     // Catch:{ all -> 0x0086 }
            java.lang.String r3 = "Error in peekHits fetching hitIds: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0086 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0086 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0086 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0086 }
            com.google.android.gms.analytics.C0181aa.m75w(r0)     // Catch:{ all -> 0x0086 }
            if (r1 == 0) goto L_0x005a
            r1.close()
            goto L_0x005a
        L_0x007e:
            r0 = move-exception
            r1 = r10
        L_0x0080:
            if (r1 == 0) goto L_0x0085
            r1.close()
        L_0x0085:
            throw r0
        L_0x0086:
            r0 = move-exception
            goto L_0x0080
        L_0x0088:
            r0 = move-exception
            goto L_0x005e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.C0183ac.mo2880s(int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f2, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00fa, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0173, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0174, code lost:
        r11 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0179, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x017a, code lost:
        r2 = r1;
        r3 = r12;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        return r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0173 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* renamed from: t */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.analytics.C0238x> mo2881t(int r16) {
        /*
            r15 = this;
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.lang.String r1 = "Error opening database for peekHits"
            android.database.sqlite.SQLiteDatabase r1 = r15.m78G(r1)
            if (r1 != 0) goto L_0x000f
            r1 = r10
        L_0x000e:
            return r1
        L_0x000f:
            r11 = 0
            java.lang.String r2 = "hits2"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            r4 = 0
            java.lang.String r5 = "hit_id"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            r4 = 1
            java.lang.String r5 = "hit_time"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "%s ASC"
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            r12 = 0
            java.lang.String r13 = "hit_id"
            r9[r12] = r13     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            java.lang.String r9 = java.lang.Integer.toString(r16)     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0179, all -> 0x0173 }
            r11.<init>()     // Catch:{ SQLiteException -> 0x0179, all -> 0x0173 }
            boolean r2 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
            if (r2 == 0) goto L_0x005d
        L_0x0044:
            com.google.android.gms.analytics.x r2 = new com.google.android.gms.analytics.x     // Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
            r3 = 0
            r4 = 0
            long r4 = r12.getLong(r4)     // Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
            r6 = 1
            long r6 = r12.getLong(r6)     // Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
            r2.<init>(r3, r4, r6)     // Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
            r11.add(r2)     // Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
            boolean r2 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
            if (r2 != 0) goto L_0x0044
        L_0x005d:
            if (r12 == 0) goto L_0x0062
            r12.close()
        L_0x0062:
            r10 = 0
            java.lang.String r2 = "hits2"
            r3 = 3
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0171 }
            r4 = 0
            java.lang.String r5 = "hit_id"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x0171 }
            r4 = 1
            java.lang.String r5 = "hit_string"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x0171 }
            r4 = 2
            java.lang.String r5 = "hit_url"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x0171 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "%s ASC"
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ SQLiteException -> 0x0171 }
            r13 = 0
            java.lang.String r14 = "hit_id"
            r9[r13] = r14     // Catch:{ SQLiteException -> 0x0171 }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ SQLiteException -> 0x0171 }
            java.lang.String r9 = java.lang.Integer.toString(r16)     // Catch:{ SQLiteException -> 0x0171 }
            android.database.Cursor r2 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0171 }
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            if (r1 == 0) goto L_0x00ca
            r3 = r10
        L_0x0098:
            r0 = r2
            android.database.sqlite.SQLiteCursor r0 = (android.database.sqlite.SQLiteCursor) r0     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            r1 = r0
            android.database.CursorWindow r1 = r1.getWindow()     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            int r1 = r1.getNumRows()     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            if (r1 <= 0) goto L_0x00fe
            java.lang.Object r1 = r11.get(r3)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            com.google.android.gms.analytics.x r1 = (com.google.android.gms.analytics.C0238x) r1     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            r4 = 1
            java.lang.String r4 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            r1.mo2984E(r4)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            java.lang.Object r1 = r11.get(r3)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            com.google.android.gms.analytics.x r1 = (com.google.android.gms.analytics.C0238x) r1     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            r4 = 2
            java.lang.String r4 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            r1.mo2985F(r4)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        L_0x00c2:
            int r1 = r3 + 1
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            if (r3 != 0) goto L_0x0185
        L_0x00ca:
            if (r2 == 0) goto L_0x00cf
            r2.close()
        L_0x00cf:
            r1 = r11
            goto L_0x000e
        L_0x00d2:
            r1 = move-exception
            r2 = r1
            r3 = r11
            r1 = r10
        L_0x00d6:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0176 }
            r4.<init>()     // Catch:{ all -> 0x0176 }
            java.lang.String r5 = "Error in peekHits fetching hitIds: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x0176 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0176 }
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch:{ all -> 0x0176 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.analytics.C0181aa.m75w(r2)     // Catch:{ all -> 0x0176 }
            if (r3 == 0) goto L_0x000e
            r3.close()
            goto L_0x000e
        L_0x00f7:
            r1 = move-exception
        L_0x00f8:
            if (r11 == 0) goto L_0x00fd
            r11.close()
        L_0x00fd:
            throw r1
        L_0x00fe:
            java.lang.String r4 = "HitString for hitId %d too large.  Hit will be deleted."
            r1 = 1
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            r6 = 0
            java.lang.Object r1 = r11.get(r3)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            com.google.android.gms.analytics.x r1 = (com.google.android.gms.analytics.C0238x) r1     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            long r7 = r1.mo2987ci()     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            r5[r6] = r1     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            java.lang.String r1 = java.lang.String.format(r4, r5)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            com.google.android.gms.analytics.C0181aa.m75w(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            goto L_0x00c2
        L_0x011c:
            r1 = move-exception
            r12 = r2
        L_0x011e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0167 }
            r2.<init>()     // Catch:{ all -> 0x0167 }
            java.lang.String r3 = "Error in peekHits fetching hitString: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0167 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0167 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x0167 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0167 }
            com.google.android.gms.analytics.C0181aa.m75w(r1)     // Catch:{ all -> 0x0167 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0167 }
            r2.<init>()     // Catch:{ all -> 0x0167 }
            r3 = 0
            java.util.Iterator r4 = r11.iterator()     // Catch:{ all -> 0x0167 }
        L_0x0142:
            boolean r1 = r4.hasNext()     // Catch:{ all -> 0x0167 }
            if (r1 == 0) goto L_0x015a
            java.lang.Object r1 = r4.next()     // Catch:{ all -> 0x0167 }
            com.google.android.gms.analytics.x r1 = (com.google.android.gms.analytics.C0238x) r1     // Catch:{ all -> 0x0167 }
            java.lang.String r5 = r1.mo2986ch()     // Catch:{ all -> 0x0167 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0167 }
            if (r5 == 0) goto L_0x0163
            if (r3 == 0) goto L_0x0162
        L_0x015a:
            if (r12 == 0) goto L_0x015f
            r12.close()
        L_0x015f:
            r1 = r2
            goto L_0x000e
        L_0x0162:
            r3 = 1
        L_0x0163:
            r2.add(r1)     // Catch:{ all -> 0x0167 }
            goto L_0x0142
        L_0x0167:
            r1 = move-exception
        L_0x0168:
            if (r12 == 0) goto L_0x016d
            r12.close()
        L_0x016d:
            throw r1
        L_0x016e:
            r1 = move-exception
            r12 = r2
            goto L_0x0168
        L_0x0171:
            r1 = move-exception
            goto L_0x011e
        L_0x0173:
            r1 = move-exception
            r11 = r12
            goto L_0x00f8
        L_0x0176:
            r1 = move-exception
            r11 = r3
            goto L_0x00f8
        L_0x0179:
            r1 = move-exception
            r2 = r1
            r3 = r12
            r1 = r10
            goto L_0x00d6
        L_0x017f:
            r1 = move-exception
            r2 = r1
            r3 = r12
            r1 = r11
            goto L_0x00d6
        L_0x0185:
            r3 = r1
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.C0183ac.mo2881t(int):java.util.List");
    }
}
