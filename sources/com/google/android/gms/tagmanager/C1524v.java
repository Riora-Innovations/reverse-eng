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
import com.google.android.gms.tagmanager.DataLayer.C1351c.C1352a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.gms.tagmanager.v */
class C1524v implements C1351c {
    /* access modifiers changed from: private */

    /* renamed from: UD */
    public static final String f3895UD = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});

    /* renamed from: Ty */
    private C0806fl f3896Ty;

    /* renamed from: UE */
    private final Executor f3897UE;

    /* renamed from: UF */
    private C1528a f3898UF;

    /* renamed from: UG */
    private int f3899UG;
    /* access modifiers changed from: private */
    public final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.v$a */
    class C1528a extends SQLiteOpenHelper {
        C1528a(Context context, String str) {
            super(context, str, null, 1);
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private void m4525a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (String add : columnNames) {
                    hashSet.add(add);
                }
                rawQuery.close();
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
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
        private boolean m4526a(java.lang.String r11, android.database.sqlite.SQLiteDatabase r12) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1524v.C1528a.m4526a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                C1524v.this.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
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
            if (!m4526a("datalayer", db)) {
                db.execSQL(C1524v.f3895UD);
            } else {
                m4525a(db);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v$b */
    private static class C1529b {

        /* renamed from: UA */
        final String f3908UA;

        /* renamed from: UM */
        final byte[] f3909UM;

        C1529b(String str, byte[] bArr) {
            this.f3908UA = str;
            this.f3909UM = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.f3908UA + " serialized hash = " + Arrays.hashCode(this.f3909UM);
        }
    }

    public C1524v(Context context) {
        this(context, C0808fn.m2115eI(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    C1524v(Context context, C0806fl flVar, String str, int i, Executor executor) {
        this.mContext = context;
        this.f3896Ty = flVar;
        this.f3899UG = i;
        this.f3897UE = executor;
        this.f3898UF = new C1528a(this.mContext, str);
    }

    /* renamed from: G */
    private SQLiteDatabase m4501G(String str) {
        try {
            return this.f3898UF.getWritableDatabase();
        } catch (SQLiteException e) {
            C1401bh.m4078w(str);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m4506b(List<C1529b> list, long j) {
        try {
            long currentTimeMillis = this.f3896Ty.currentTimeMillis();
            m4521t(currentTimeMillis);
            m4507bQ(list.size());
            m4511c(list, currentTimeMillis + j);
            m4517iW();
        } catch (Throwable th) {
            m4517iW();
            throw th;
        }
    }

    /* renamed from: bQ */
    private void m4507bQ(int i) {
        int iV = (m4516iV() - this.f3899UG) + i;
        if (iV > 0) {
            List bR = m4508bR(iV);
            C1401bh.m4076u("DataLayer store full, deleting " + bR.size() + " entries to make room.");
            m4513g((String[]) bR.toArray(new String[0]));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* renamed from: bR */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> m4508bR(int r14) {
        /*
            r13 = this;
            r10 = 0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            if (r14 > 0) goto L_0x000f
            java.lang.String r0 = "Invalid maxEntries specified. Skipping."
            com.google.android.gms.tagmanager.C1401bh.m4078w(r0)
            r0 = r9
        L_0x000e:
            return r0
        L_0x000f:
            java.lang.String r0 = "Error opening database for peekEntryIds."
            android.database.sqlite.SQLiteDatabase r0 = r13.m4501G(r0)
            if (r0 != 0) goto L_0x0019
            r0 = r9
            goto L_0x000e
        L_0x0019:
            java.lang.String r1 = "datalayer"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            r3 = 0
            java.lang.String r4 = "ID"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "%s ASC"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            r11 = 0
            java.lang.String r12 = "ID"
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
            java.lang.String r3 = "Error in peekEntries fetching entryIds: "
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1524v.m4508bR(int):java.util.List");
    }

    /* access modifiers changed from: private */
    /* renamed from: bj */
    public void m4509bj(String str) {
        SQLiteDatabase G = m4501G("Error opening database for clearKeysWithPrefix.");
        if (G != null) {
            try {
                C1401bh.m4077v("Cleared " + G.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                C1401bh.m4078w("Error deleting entries with key prefix: " + str + " (" + e + ").");
            } finally {
                m4517iW();
            }
        }
    }

    /* renamed from: c */
    private List<C1349a> m4510c(List<C1529b> list) {
        ArrayList arrayList = new ArrayList();
        for (C1529b bVar : list) {
            arrayList.add(new C1349a(bVar.f3908UA, m4519j(bVar.f3909UM)));
        }
        return arrayList;
    }

    /* renamed from: c */
    private void m4511c(List<C1529b> list, long j) {
        SQLiteDatabase G = m4501G("Error opening database for writeEntryToDatabase.");
        if (G != null) {
            for (C1529b bVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", bVar.f3908UA);
                contentValues.put("value", bVar.f3909UM);
                G.insert("datalayer", null, contentValues);
            }
        }
    }

    /* renamed from: d */
    private List<C1529b> m4512d(List<C1349a> list) {
        ArrayList arrayList = new ArrayList();
        for (C1349a aVar : list) {
            arrayList.add(new C1529b(aVar.f3548UA, m4520j(aVar.f3549UB)));
        }
        return arrayList;
    }

    /* renamed from: g */
    private void m4513g(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase G = m4501G("Error opening database for deleteEntries.");
            if (G != null) {
                try {
                    G.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    C1401bh.m4078w("Error deleting entries " + Arrays.toString(strArr));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: iT */
    public List<C1349a> m4514iT() {
        try {
            m4521t(this.f3896Ty.currentTimeMillis());
            return m4510c(m4515iU());
        } finally {
            m4517iW();
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: iU */
    private List<C1529b> m4515iU() {
        SQLiteDatabase G = m4501G("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (G == null) {
            return arrayList;
        }
        Cursor query = G.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new C1529b(query.getString(0), query.getBlob(1)));
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
        return arrayList;
    }

    /* renamed from: iV */
    private int m4516iV() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase G = m4501G("Error opening database for getNumStoredEntries.");
        if (G != null) {
            try {
                Cursor rawQuery = G.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (rawQuery.moveToFirst()) {
                    i = (int) rawQuery.getLong(0);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e) {
                C1401bh.m4078w("Error getting numStoredEntries");
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

    /* renamed from: iW */
    private void m4517iW() {
        try {
            this.f3898UF.close();
        } catch (SQLiteException e) {
        }
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0029 A[SYNTHETIC, Splitter:B:20:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0038 A[SYNTHETIC, Splitter:B:27:0x0038] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object m4519j(byte[] r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r6)
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0018, ClassNotFoundException -> 0x0025, all -> 0x0032 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0018, ClassNotFoundException -> 0x0025, all -> 0x0032 }
            java.lang.Object r0 = r1.readObject()     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043, all -> 0x0041 }
            if (r1 == 0) goto L_0x0014
            r1.close()     // Catch:{ IOException -> 0x0047 }
        L_0x0014:
            r2.close()     // Catch:{ IOException -> 0x0047 }
        L_0x0017:
            return r0
        L_0x0018:
            r1 = move-exception
            r1 = r0
        L_0x001a:
            if (r1 == 0) goto L_0x001f
            r1.close()     // Catch:{ IOException -> 0x0023 }
        L_0x001f:
            r2.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0017
        L_0x0023:
            r1 = move-exception
            goto L_0x0017
        L_0x0025:
            r1 = move-exception
            r1 = r0
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()     // Catch:{ IOException -> 0x0030 }
        L_0x002c:
            r2.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0017
        L_0x0030:
            r1 = move-exception
            goto L_0x0017
        L_0x0032:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0036:
            if (r1 == 0) goto L_0x003b
            r1.close()     // Catch:{ IOException -> 0x003f }
        L_0x003b:
            r2.close()     // Catch:{ IOException -> 0x003f }
        L_0x003e:
            throw r0
        L_0x003f:
            r1 = move-exception
            goto L_0x003e
        L_0x0041:
            r0 = move-exception
            goto L_0x0036
        L_0x0043:
            r3 = move-exception
            goto L_0x0027
        L_0x0045:
            r3 = move-exception
            goto L_0x001a
        L_0x0047:
            r1 = move-exception
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1524v.m4519j(byte[]):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e A[SYNTHETIC, Splitter:B:20:0x002e] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m4520j(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x001b, all -> 0x0028 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x001b, all -> 0x0028 }
            r1.writeObject(r6)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            byte[] r0 = r2.toByteArray()     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            if (r1 == 0) goto L_0x0017
            r1.close()     // Catch:{ IOException -> 0x003b }
        L_0x0017:
            r2.close()     // Catch:{ IOException -> 0x003b }
        L_0x001a:
            return r0
        L_0x001b:
            r1 = move-exception
            r1 = r0
        L_0x001d:
            if (r1 == 0) goto L_0x0022
            r1.close()     // Catch:{ IOException -> 0x0026 }
        L_0x0022:
            r2.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x001a
        L_0x0026:
            r1 = move-exception
            goto L_0x001a
        L_0x0028:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x002c:
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ IOException -> 0x0035 }
        L_0x0031:
            r2.close()     // Catch:{ IOException -> 0x0035 }
        L_0x0034:
            throw r0
        L_0x0035:
            r1 = move-exception
            goto L_0x0034
        L_0x0037:
            r0 = move-exception
            goto L_0x002c
        L_0x0039:
            r3 = move-exception
            goto L_0x001d
        L_0x003b:
            r1 = move-exception
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1524v.m4520j(java.lang.Object):byte[]");
    }

    /* renamed from: t */
    private void m4521t(long j) {
        SQLiteDatabase G = m4501G("Error opening database for deleteOlderThan.");
        if (G != null) {
            try {
                C1401bh.m4077v("Deleted " + G.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                C1401bh.m4078w("Error deleting old entries.");
            }
        }
    }

    /* renamed from: a */
    public void mo7536a(final C1352a aVar) {
        this.f3897UE.execute(new Runnable() {
            public void run() {
                aVar.mo7539b(C1524v.this.m4514iT());
            }
        });
    }

    /* renamed from: a */
    public void mo7537a(List<C1349a> list, final long j) {
        final List d = m4512d(list);
        this.f3897UE.execute(new Runnable() {
            public void run() {
                C1524v.this.m4506b(d, j);
            }
        });
    }

    /* renamed from: bi */
    public void mo7538bi(final String str) {
        this.f3897UE.execute(new Runnable() {
            public void run() {
                C1524v.this.m4509bj(str);
            }
        });
    }
}
