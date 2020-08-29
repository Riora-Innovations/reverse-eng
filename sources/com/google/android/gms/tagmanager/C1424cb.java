package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.C0806fl;
import com.google.android.gms.internal.C0808fn;
import com.google.android.gms.tagmanager.C1479db.C1480a;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.achartengine.chart.TimeChart;
import org.apache.http.impl.client.DefaultHttpClient;

/* renamed from: com.google.android.gms.tagmanager.cb */
class C1424cb implements C1382at {
    /* access modifiers changed from: private */

    /* renamed from: ua */
    public static final String f3657ua = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    /* access modifiers changed from: private */

    /* renamed from: Ty */
    public C0806fl f3658Ty;

    /* renamed from: VL */
    private final C1426b f3659VL;

    /* renamed from: VM */
    private volatile C1363ab f3660VM;

    /* renamed from: VN */
    private final C1383au f3661VN;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: ud */
    public final String f3662ud;

    /* renamed from: uf */
    private long f3663uf;

    /* renamed from: ug */
    private final int f3664ug;

    /* renamed from: com.google.android.gms.tagmanager.cb$a */
    class C1425a implements C1480a {
        C1425a() {
        }

        /* renamed from: a */
        public void mo7658a(C1377ap apVar) {
            C1424cb.this.m4149u(apVar.mo7582ci());
        }

        /* renamed from: b */
        public void mo7659b(C1377ap apVar) {
            C1424cb.this.m4149u(apVar.mo7582ci());
            C1401bh.m4077v("Permanent failure dispatching hitId: " + apVar.mo7582ci());
        }

        /* renamed from: c */
        public void mo7660c(C1377ap apVar) {
            long je = apVar.mo7583je();
            if (je == 0) {
                C1424cb.this.m4145c(apVar.mo7582ci(), C1424cb.this.f3658Ty.currentTimeMillis());
            } else if (je + 14400000 < C1424cb.this.f3658Ty.currentTimeMillis()) {
                C1424cb.this.m4149u(apVar.mo7582ci());
                C1401bh.m4077v("Giving up on failed hitId: " + apVar.mo7582ci());
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cb$b */
    class C1426b extends SQLiteOpenHelper {

        /* renamed from: ui */
        private boolean f3667ui;

        /* renamed from: uj */
        private long f3668uj = 0;

        C1426b(Context context, String str) {
            super(context, str, null, 1);
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private void m4161a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (String add : columnNames) {
                    hashSet.add(add);
                }
                rawQuery.close();
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean m4162a(java.lang.String r11, android.database.sqlite.SQLiteDatabase r12) {
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
                com.google.android.gms.tagmanager.C1401bh.m4078w(r1)     // Catch:{ all -> 0x004f }
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1424cb.C1426b.m4162a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.f3667ui || this.f3668uj + 3600000 <= C1424cb.this.f3658Ty.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.f3667ui = true;
                this.f3668uj = C1424cb.this.f3658Ty.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    C1424cb.this.mContext.getDatabasePath(C1424cb.this.f3662ud).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.f3667ui = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
        }

        public void onCreate(SQLiteDatabase db) {
            C1372ak.m4011B(db.getPath());
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
            if (!m4162a("gtm_hits", db)) {
                db.execSQL(C1424cb.f3657ua);
            } else {
                m4161a(db);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    C1424cb(C1383au auVar, Context context) {
        this(auVar, context, "gtm_urls.db", 2000);
    }

    C1424cb(C1383au auVar, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.f3662ud = str;
        this.f3661VN = auVar;
        this.f3658Ty = C0808fn.m2115eI();
        this.f3659VL = new C1426b(this.mContext, this.f3662ud);
        this.f3660VM = new C1479db(new DefaultHttpClient(), this.mContext, new C1425a());
        this.f3663uf = 0;
        this.f3664ug = i;
    }

    /* renamed from: G */
    private SQLiteDatabase m4139G(String str) {
        try {
            return this.f3659VL.getWritableDatabase();
        } catch (SQLiteException e) {
            C1401bh.m4078w(str);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m4145c(long j, long j2) {
        SQLiteDatabase G = m4139G("Error opening database for getNumStoredHits.");
        if (G != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                G.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException e) {
                C1401bh.m4078w("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
                m4149u(j);
            }
        }
    }

    /* renamed from: co */
    private void m4146co() {
        int cq = (mo7654cq() - this.f3664ug) + 1;
        if (cq > 0) {
            List s = mo7656s(cq);
            C1401bh.m4077v("Store full, deleting " + s.size() + " hits to make room.");
            mo7652a((String[]) s.toArray(new String[0]));
        }
    }

    /* renamed from: f */
    private void m4147f(long j, String str) {
        SQLiteDatabase G = m4139G("Error opening database for putHit");
        if (G != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", Integer.valueOf(0));
            try {
                G.insert("gtm_hits", null, contentValues);
                this.f3661VN.mo7593p(false);
            } catch (SQLiteException e) {
                C1401bh.m4078w("Error storing hit");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public void m4149u(long j) {
        mo7652a(new String[]{String.valueOf(j)});
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7652a(String[] strArr) {
        boolean z = true;
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase G = m4139G("Error opening database for deleteHits.");
            if (G != null) {
                try {
                    G.delete("gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    C1383au auVar = this.f3661VN;
                    if (mo7654cq() != 0) {
                        z = false;
                    }
                    auVar.mo7593p(z);
                } catch (SQLiteException e) {
                    C1401bh.m4078w("Error deleting hits");
                }
            }
        }
    }

    /* renamed from: bp */
    public void mo7591bp() {
        C1401bh.m4077v("GTM Dispatch running...");
        if (this.f3660VM.mo7568bA()) {
            List t = mo7657t(40);
            if (t.isEmpty()) {
                C1401bh.m4077v("...nothing to dispatch");
                this.f3661VN.mo7593p(true);
                return;
            }
            this.f3660VM.mo7569e(t);
            if (mo7655js() > 0) {
                C1471cy.m4323kh().mo7762bp();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cp */
    public int mo7653cp() {
        boolean z = true;
        long currentTimeMillis = this.f3658Ty.currentTimeMillis();
        if (currentTimeMillis <= this.f3663uf + TimeChart.DAY) {
            return 0;
        }
        this.f3663uf = currentTimeMillis;
        SQLiteDatabase G = m4139G("Error opening database for deleteStaleHits.");
        if (G == null) {
            return 0;
        }
        int delete = G.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.f3658Ty.currentTimeMillis() - 2592000000L)});
        C1383au auVar = this.f3661VN;
        if (mo7654cq() != 0) {
            z = false;
        }
        auVar.mo7593p(z);
        return delete;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cq */
    public int mo7654cq() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase G = m4139G("Error opening database for getNumStoredHits.");
        if (G != null) {
            try {
                Cursor rawQuery = G.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                if (rawQuery.moveToFirst()) {
                    i = (int) rawQuery.getLong(0);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e) {
                C1401bh.m4078w("Error getting numStoredHits");
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

    /* renamed from: e */
    public void mo7592e(long j, String str) {
        mo7653cp();
        m4146co();
        m4147f(j, str);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040  */
    /* renamed from: js */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo7655js() {
        /*
            r10 = this;
            r8 = 0
            r9 = 0
            java.lang.String r0 = "Error opening database for getNumStoredHits."
            android.database.sqlite.SQLiteDatabase r0 = r10.m4139G(r0)
            if (r0 != 0) goto L_0x000b
        L_0x000a:
            return r8
        L_0x000b:
            java.lang.String r1 = "gtm_hits"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            r3 = 1
            java.lang.String r4 = "hit_first_send_time"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            java.lang.String r3 = "hit_first_send_time=0"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            int r0 = r1.getCount()     // Catch:{ SQLiteException -> 0x004b, all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r1.close()
        L_0x002d:
            r8 = r0
            goto L_0x000a
        L_0x002f:
            r0 = move-exception
            r0 = r9
        L_0x0031:
            java.lang.String r1 = "Error getting num untried hits"
            com.google.android.gms.tagmanager.C1401bh.m4078w(r1)     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x004e
            r0.close()
            r0 = r8
            goto L_0x002d
        L_0x003d:
            r0 = move-exception
        L_0x003e:
            if (r9 == 0) goto L_0x0043
            r9.close()
        L_0x0043:
            throw r0
        L_0x0044:
            r0 = move-exception
            r9 = r1
            goto L_0x003e
        L_0x0047:
            r1 = move-exception
            r9 = r0
            r0 = r1
            goto L_0x003e
        L_0x004b:
            r0 = move-exception
            r0 = r1
            goto L_0x0031
        L_0x004e:
            r0 = r8
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1424cb.mo7655js():int");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> mo7656s(int r14) {
        /*
            r13 = this;
            r10 = 0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            if (r14 > 0) goto L_0x000f
            java.lang.String r0 = "Invalid maxHits specified. Skipping"
            com.google.android.gms.tagmanager.C1401bh.m4078w(r0)
            r0 = r9
        L_0x000e:
            return r0
        L_0x000f:
            java.lang.String r0 = "Error opening database for peekHitIds."
            android.database.sqlite.SQLiteDatabase r0 = r13.m4139G(r0)
            if (r0 != 0) goto L_0x0019
            r0 = r9
            goto L_0x000e
        L_0x0019:
            java.lang.String r1 = "gtm_hits"
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
            com.google.android.gms.tagmanager.C1401bh.m4078w(r0)     // Catch:{ all -> 0x0086 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1424cb.mo7656s(int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e8, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f0, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0169, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x016a, code lost:
        r11 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0170, code lost:
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
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0169 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* renamed from: t */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.tagmanager.C1377ap> mo7657t(int r16) {
        /*
            r15 = this;
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.lang.String r1 = "Error opening database for peekHits"
            android.database.sqlite.SQLiteDatabase r1 = r15.m4139G(r1)
            if (r1 != 0) goto L_0x000f
            r1 = r10
        L_0x000e:
            return r1
        L_0x000f:
            r11 = 0
            java.lang.String r2 = "gtm_hits"
            r3 = 3
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            r4 = 0
            java.lang.String r5 = "hit_id"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            r4 = 1
            java.lang.String r5 = "hit_time"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            r4 = 2
            java.lang.String r5 = "hit_first_send_time"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "%s ASC"
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            r12 = 0
            java.lang.String r13 = "hit_id"
            r9[r12] = r13     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            java.lang.String r9 = java.lang.Integer.toString(r16)     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r11.<init>()     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            boolean r2 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            if (r2 == 0) goto L_0x0066
        L_0x0049:
            com.google.android.gms.tagmanager.ap r2 = new com.google.android.gms.tagmanager.ap     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            r3 = 0
            long r3 = r12.getLong(r3)     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            r5 = 1
            long r5 = r12.getLong(r5)     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            r7 = 2
            long r7 = r12.getLong(r7)     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            r2.<init>(r3, r5, r7)     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            r11.add(r2)     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            boolean r2 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            if (r2 != 0) goto L_0x0049
        L_0x0066:
            if (r12 == 0) goto L_0x006b
            r12.close()
        L_0x006b:
            r10 = 0
            java.lang.String r2 = "gtm_hits"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0167 }
            r4 = 0
            java.lang.String r5 = "hit_id"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x0167 }
            r4 = 1
            java.lang.String r5 = "hit_url"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x0167 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "%s ASC"
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ SQLiteException -> 0x0167 }
            r13 = 0
            java.lang.String r14 = "hit_id"
            r9[r13] = r14     // Catch:{ SQLiteException -> 0x0167 }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ SQLiteException -> 0x0167 }
            java.lang.String r9 = java.lang.Integer.toString(r16)     // Catch:{ SQLiteException -> 0x0167 }
            android.database.Cursor r2 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0167 }
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            if (r1 == 0) goto L_0x00c0
            r3 = r10
        L_0x009c:
            r0 = r2
            android.database.sqlite.SQLiteCursor r0 = (android.database.sqlite.SQLiteCursor) r0     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            r1 = r0
            android.database.CursorWindow r1 = r1.getWindow()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            int r1 = r1.getNumRows()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            if (r1 <= 0) goto L_0x00f4
            java.lang.Object r1 = r11.get(r3)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            com.google.android.gms.tagmanager.ap r1 = (com.google.android.gms.tagmanager.C1377ap) r1     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            r4 = 1
            java.lang.String r4 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            r1.mo7581F(r4)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        L_0x00b8:
            int r1 = r3 + 1
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            if (r3 != 0) goto L_0x017b
        L_0x00c0:
            if (r2 == 0) goto L_0x00c5
            r2.close()
        L_0x00c5:
            r1 = r11
            goto L_0x000e
        L_0x00c8:
            r1 = move-exception
            r2 = r1
            r3 = r11
            r1 = r10
        L_0x00cc:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x016c }
            r4.<init>()     // Catch:{ all -> 0x016c }
            java.lang.String r5 = "Error in peekHits fetching hitIds: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x016c }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x016c }
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch:{ all -> 0x016c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x016c }
            com.google.android.gms.tagmanager.C1401bh.m4078w(r2)     // Catch:{ all -> 0x016c }
            if (r3 == 0) goto L_0x000e
            r3.close()
            goto L_0x000e
        L_0x00ed:
            r1 = move-exception
        L_0x00ee:
            if (r11 == 0) goto L_0x00f3
            r11.close()
        L_0x00f3:
            throw r1
        L_0x00f4:
            java.lang.String r4 = "HitString for hitId %d too large.  Hit will be deleted."
            r1 = 1
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            r6 = 0
            java.lang.Object r1 = r11.get(r3)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            com.google.android.gms.tagmanager.ap r1 = (com.google.android.gms.tagmanager.C1377ap) r1     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            long r7 = r1.mo7582ci()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            r5[r6] = r1     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            java.lang.String r1 = java.lang.String.format(r4, r5)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            com.google.android.gms.tagmanager.C1401bh.m4078w(r1)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            goto L_0x00b8
        L_0x0112:
            r1 = move-exception
            r12 = r2
        L_0x0114:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x015d }
            r2.<init>()     // Catch:{ all -> 0x015d }
            java.lang.String r3 = "Error in peekHits fetching hit url: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x015d }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x015d }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x015d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x015d }
            com.google.android.gms.tagmanager.C1401bh.m4078w(r1)     // Catch:{ all -> 0x015d }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x015d }
            r2.<init>()     // Catch:{ all -> 0x015d }
            r3 = 0
            java.util.Iterator r4 = r11.iterator()     // Catch:{ all -> 0x015d }
        L_0x0138:
            boolean r1 = r4.hasNext()     // Catch:{ all -> 0x015d }
            if (r1 == 0) goto L_0x0150
            java.lang.Object r1 = r4.next()     // Catch:{ all -> 0x015d }
            com.google.android.gms.tagmanager.ap r1 = (com.google.android.gms.tagmanager.C1377ap) r1     // Catch:{ all -> 0x015d }
            java.lang.String r5 = r1.mo7584jf()     // Catch:{ all -> 0x015d }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x015d }
            if (r5 == 0) goto L_0x0159
            if (r3 == 0) goto L_0x0158
        L_0x0150:
            if (r12 == 0) goto L_0x0155
            r12.close()
        L_0x0155:
            r1 = r2
            goto L_0x000e
        L_0x0158:
            r3 = 1
        L_0x0159:
            r2.add(r1)     // Catch:{ all -> 0x015d }
            goto L_0x0138
        L_0x015d:
            r1 = move-exception
        L_0x015e:
            if (r12 == 0) goto L_0x0163
            r12.close()
        L_0x0163:
            throw r1
        L_0x0164:
            r1 = move-exception
            r12 = r2
            goto L_0x015e
        L_0x0167:
            r1 = move-exception
            goto L_0x0114
        L_0x0169:
            r1 = move-exception
            r11 = r12
            goto L_0x00ee
        L_0x016c:
            r1 = move-exception
            r11 = r3
            goto L_0x00ee
        L_0x016f:
            r1 = move-exception
            r2 = r1
            r3 = r12
            r1 = r10
            goto L_0x00cc
        L_0x0175:
            r1 = move-exception
            r2 = r1
            r3 = r12
            r1 = r11
            goto L_0x00cc
        L_0x017b:
            r3 = r1
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1424cb.mo7657t(int):java.util.List");
    }
}
