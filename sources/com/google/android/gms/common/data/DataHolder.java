package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.AbstractWindowedCursor;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0731ed;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0766er;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class DataHolder implements SafeParcelable {

    /* renamed from: Ai */
    private static final Builder f562Ai = new Builder(new String[0], null) {
        public Builder withRow(ContentValues values) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }

        public Builder withRow(HashMap<String, Object> hashMap) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }
    };
    public static final DataHolderCreator CREATOR = new DataHolderCreator();

    /* renamed from: Aa */
    private final String[] f563Aa;

    /* renamed from: Ab */
    Bundle f564Ab;

    /* renamed from: Ac */
    private final CursorWindow[] f565Ac;

    /* renamed from: Ad */
    private final Bundle f566Ad;

    /* renamed from: Ae */
    int[] f567Ae;

    /* renamed from: Af */
    int f568Af;

    /* renamed from: Ag */
    private Object f569Ag;

    /* renamed from: Ah */
    private boolean f570Ah;
    boolean mClosed;

    /* renamed from: wj */
    private final int f571wj;

    /* renamed from: yJ */
    private final int f572yJ;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: Aa */
        public final String[] f573Aa;
        /* access modifiers changed from: private */

        /* renamed from: Aj */
        public final ArrayList<HashMap<String, Object>> f574Aj;

        /* renamed from: Ak */
        private final String f575Ak;

        /* renamed from: Al */
        private final HashMap<Object, Integer> f576Al;

        /* renamed from: Am */
        private boolean f577Am;

        /* renamed from: An */
        private String f578An;

        private Builder(String[] columns, String uniqueColumn) {
            this.f573Aa = (String[]) C0766er.m1977f(columns);
            this.f574Aj = new ArrayList<>();
            this.f575Ak = uniqueColumn;
            this.f576Al = new HashMap<>();
            this.f577Am = false;
            this.f578An = null;
        }

        /* renamed from: a */
        private void m507a(HashMap<String, Object> hashMap) {
            Object obj = hashMap.get(this.f575Ak);
            if (obj != null) {
                Integer num = (Integer) this.f576Al.remove(obj);
                if (num != null) {
                    this.f574Aj.remove(num.intValue());
                }
                this.f576Al.put(obj, Integer.valueOf(this.f574Aj.size()));
            }
        }

        /* renamed from: dJ */
        private void m510dJ() {
            if (this.f575Ak != null) {
                this.f576Al.clear();
                int size = this.f574Aj.size();
                for (int i = 0; i < size; i++) {
                    Object obj = ((HashMap) this.f574Aj.get(i)).get(this.f575Ak);
                    if (obj != null) {
                        this.f576Al.put(obj, Integer.valueOf(i));
                    }
                }
            }
        }

        public DataHolder build(int statusCode) {
            return new DataHolder(this, statusCode, (Bundle) null);
        }

        public DataHolder build(int statusCode, Bundle metadata) {
            return new DataHolder(this, statusCode, metadata, -1);
        }

        public DataHolder build(int statusCode, Bundle metadata, int maxResults) {
            return new DataHolder(this, statusCode, metadata, maxResults);
        }

        public int getCount() {
            return this.f574Aj.size();
        }

        public Builder removeRowsWithValue(String column, Object value) {
            for (int size = this.f574Aj.size() - 1; size >= 0; size--) {
                if (C0762ep.equal(((HashMap) this.f574Aj.get(size)).get(column), value)) {
                    this.f574Aj.remove(size);
                }
            }
            return this;
        }

        public Builder sort(String sortColumn) {
            C0731ed.m1825d(sortColumn);
            if (!this.f577Am || !sortColumn.equals(this.f578An)) {
                Collections.sort(this.f574Aj, new C0310a(sortColumn));
                m510dJ();
                this.f577Am = true;
                this.f578An = sortColumn;
            }
            return this;
        }

        public Builder withRow(ContentValues values) {
            C0731ed.m1825d(values);
            HashMap hashMap = new HashMap(values.size());
            for (Entry entry : values.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return withRow(hashMap);
        }

        public Builder withRow(HashMap<String, Object> row) {
            C0731ed.m1825d(row);
            if (this.f575Ak != null) {
                m507a(row);
            }
            this.f574Aj.add(row);
            this.f577Am = false;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.common.data.DataHolder$a */
    private static final class C0310a implements Comparator<HashMap<String, Object>> {

        /* renamed from: Ao */
        private final String f579Ao;

        C0310a(String str) {
            this.f579Ao = (String) C0766er.m1977f(str);
        }

        /* renamed from: a */
        public int compare(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
            Object f = C0766er.m1977f(hashMap.get(this.f579Ao));
            Object f2 = C0766er.m1977f(hashMap2.get(this.f579Ao));
            if (f.equals(f2)) {
                return 0;
            }
            if (f instanceof Boolean) {
                return ((Boolean) f).compareTo((Boolean) f2);
            }
            if (f instanceof Long) {
                return ((Long) f).compareTo((Long) f2);
            }
            if (f instanceof Integer) {
                return ((Integer) f).compareTo((Integer) f2);
            }
            if (f instanceof String) {
                return ((String) f).compareTo((String) f2);
            }
            throw new IllegalArgumentException("Unknown type for lValue " + f);
        }
    }

    DataHolder(int versionCode, String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.f570Ah = true;
        this.f571wj = versionCode;
        this.f563Aa = columns;
        this.f565Ac = windows;
        this.f572yJ = statusCode;
        this.f566Ad = metadata;
    }

    public DataHolder(AbstractWindowedCursor cursor, int statusCode, Bundle metadata) {
        this(cursor.getColumnNames(), m500a(cursor), statusCode, metadata);
    }

    private DataHolder(Builder builder, int statusCode, Bundle metadata) {
        this(builder.f573Aa, m501a(builder, -1), statusCode, metadata);
    }

    private DataHolder(Builder builder, int statusCode, Bundle metadata, int maxResults) {
        this(builder.f573Aa, m501a(builder, maxResults), statusCode, metadata);
    }

    public DataHolder(String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.f570Ah = true;
        this.f571wj = 1;
        this.f563Aa = (String[]) C0766er.m1977f(columns);
        this.f565Ac = (CursorWindow[]) C0766er.m1977f(windows);
        this.f572yJ = statusCode;
        this.f566Ad = metadata;
        validateContents();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private static CursorWindow[] m500a(AbstractWindowedCursor abstractWindowedCursor) {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            int count = abstractWindowedCursor.getCount();
            CursorWindow window = abstractWindowedCursor.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i = 0;
            } else {
                window.acquireReference();
                abstractWindowedCursor.setWindow(null);
                arrayList.add(window);
                i = window.getNumRows();
            }
            while (i < count && abstractWindowedCursor.moveToPosition(i)) {
                CursorWindow window2 = abstractWindowedCursor.getWindow();
                if (window2 != null) {
                    window2.acquireReference();
                    abstractWindowedCursor.setWindow(null);
                } else {
                    window2 = new CursorWindow(false);
                    window2.setStartPosition(i);
                    abstractWindowedCursor.fillWindow(i, window2);
                }
                if (window2.getNumRows() == 0) {
                    break;
                }
                arrayList.add(window2);
                i = window2.getNumRows() + window2.getStartPosition();
            }
            abstractWindowedCursor.close();
            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        } catch (Throwable th) {
            abstractWindowedCursor.close();
            throw th;
        }
    }

    /* renamed from: a */
    private static CursorWindow[] m501a(Builder builder, int i) {
        int i2;
        int i3;
        int i4;
        CursorWindow cursorWindow;
        if (builder.f573Aa.length == 0) {
            return new CursorWindow[0];
        }
        List b = (i < 0 || i >= builder.f574Aj.size()) ? builder.f574Aj : builder.f574Aj.subList(0, i);
        int size = b.size();
        CursorWindow cursorWindow2 = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow2);
        cursorWindow2.setNumColumns(builder.f573Aa.length);
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i5 + ")");
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i5);
                    cursorWindow2.setNumColumns(builder.f573Aa.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                    i2 = 0;
                } else {
                    i2 = i6;
                }
                Map map = (Map) b.get(i5);
                boolean z = true;
                for (int i7 = 0; i7 < builder.f573Aa.length && z; i7++) {
                    String str = builder.f573Aa[i7];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow2.putNull(i2, i7);
                    } else if (obj instanceof String) {
                        z = cursorWindow2.putString((String) obj, i2, i7);
                    } else if (obj instanceof Long) {
                        z = cursorWindow2.putLong(((Long) obj).longValue(), i2, i7);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow2.putLong((long) ((Integer) obj).intValue(), i2, i7);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow2.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i2, i7);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow2.putBlob((byte[]) obj, i2, i7);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                if (!z) {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i5 + " - allocating new window.");
                    cursorWindow2.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setNumColumns(builder.f573Aa.length);
                    arrayList.add(cursorWindow3);
                    i4 = i5 - 1;
                    cursorWindow = cursorWindow3;
                    i3 = 0;
                } else {
                    i3 = i2 + 1;
                    i4 = i5;
                    cursorWindow = cursorWindow2;
                }
                cursorWindow2 = cursorWindow;
                i5 = i4 + 1;
                i6 = i3;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                int size2 = arrayList.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    ((CursorWindow) arrayList.get(i8)).close();
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static Builder builder(String[] columns) {
        return new Builder(columns, null);
    }

    public static Builder builder(String[] columns, String uniqueColumn) {
        C0766er.m1977f(uniqueColumn);
        return new Builder(columns, uniqueColumn);
    }

    /* renamed from: e */
    private void m502e(String str, int i) {
        if (this.f564Ab == null || !this.f564Ab.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.f568Af) {
            throw new CursorIndexOutOfBoundsException(i, this.f568Af);
        }
    }

    public static DataHolder empty(int statusCode) {
        return empty(statusCode, null);
    }

    public static DataHolder empty(int statusCode, Bundle metadata) {
        return new DataHolder(f562Ai, statusCode, metadata);
    }

    /* renamed from: I */
    public int mo3333I(int i) {
        int i2 = 0;
        C0766er.m1978v(i >= 0 && i < this.f568Af);
        while (true) {
            if (i2 >= this.f567Ae.length) {
                break;
            } else if (i < this.f567Ae[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == this.f567Ae.length ? i2 - 1 : i2;
    }

    /* renamed from: c */
    public void mo3334c(Object obj) {
        this.f569Ag = obj;
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.f565Ac) {
                    close.close();
                }
            }
        }
    }

    public void copyToBuffer(String column, int row, int windowIndex, CharArrayBuffer dataOut) {
        m502e(column, row);
        this.f565Ac[windowIndex].copyStringToBuffer(row, this.f564Ab.getInt(column), dataOut);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: dH */
    public String[] mo3337dH() {
        return this.f563Aa;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: dI */
    public CursorWindow[] mo3338dI() {
        return this.f565Ac;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.f570Ah && this.f565Ac.length > 0 && !isClosed()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call close() on all DataBuffer extending objects when you are done with them. (" + (this.f569Ag == null ? "internal object: " + toString() : this.f569Ag.toString()) + ")");
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public boolean getBoolean(String column, int row, int windowIndex) {
        m502e(column, row);
        return Long.valueOf(this.f565Ac[windowIndex].getLong(row, this.f564Ab.getInt(column))).longValue() == 1;
    }

    public byte[] getByteArray(String column, int row, int windowIndex) {
        m502e(column, row);
        return this.f565Ac[windowIndex].getBlob(row, this.f564Ab.getInt(column));
    }

    public int getCount() {
        return this.f568Af;
    }

    public int getInteger(String column, int row, int windowIndex) {
        m502e(column, row);
        return this.f565Ac[windowIndex].getInt(row, this.f564Ab.getInt(column));
    }

    public long getLong(String column, int row, int windowIndex) {
        m502e(column, row);
        return this.f565Ac[windowIndex].getLong(row, this.f564Ab.getInt(column));
    }

    public Bundle getMetadata() {
        return this.f566Ad;
    }

    public int getStatusCode() {
        return this.f572yJ;
    }

    public String getString(String column, int row, int windowIndex) {
        m502e(column, row);
        return this.f565Ac[windowIndex].getString(row, this.f564Ab.getInt(column));
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f571wj;
    }

    public boolean hasColumn(String column) {
        return this.f564Ab.containsKey(column);
    }

    public boolean hasNull(String column, int row, int windowIndex) {
        m502e(column, row);
        return this.f565Ac[windowIndex].isNull(row, this.f564Ab.getInt(column));
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public Uri parseUri(String column, int row, int windowIndex) {
        String string = getString(column, row, windowIndex);
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    public void validateContents() {
        this.f564Ab = new Bundle();
        for (int i = 0; i < this.f563Aa.length; i++) {
            this.f564Ab.putInt(this.f563Aa[i], i);
        }
        this.f567Ae = new int[this.f565Ac.length];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f565Ac.length; i3++) {
            this.f567Ae[i3] = i2;
            i2 += this.f565Ac[i3].getNumRows() - (i2 - this.f565Ac[i3].getStartPosition());
        }
        this.f568Af = i2;
    }

    public void writeToParcel(Parcel dest, int flags) {
        DataHolderCreator.m512a(this, dest, flags);
    }
}
