package p004au.com.bytecode.opencsv;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/* renamed from: au.com.bytecode.opencsv.CSVWriter */
public class CSVWriter implements Closeable {
    public static final char DEFAULT_ESCAPE_CHARACTER = '\"';
    public static final String DEFAULT_LINE_END = "\n";
    public static final char DEFAULT_QUOTE_CHARACTER = '\"';
    public static final char DEFAULT_SEPARATOR = ',';
    public static final int INITIAL_STRING_SIZE = 128;
    public static final char NO_ESCAPE_CHARACTER = 0;
    public static final char NO_QUOTE_CHARACTER = 0;
    private char escapechar;
    private String lineEnd;

    /* renamed from: pw */
    private PrintWriter f2pw;
    private char quotechar;
    private Writer rawWriter;
    private ResultSetHelper resultService;
    private char separator;

    public CSVWriter(Writer writer) {
        this(writer, ',');
    }

    public CSVWriter(Writer writer, char c) {
        this(writer, c, '\"');
    }

    public CSVWriter(Writer writer, char c, char c2) {
        this(writer, c, c2, '\"');
    }

    public CSVWriter(Writer writer, char c, char c2, char c3) {
        this(writer, c, c2, c3, DEFAULT_LINE_END);
    }

    public CSVWriter(Writer writer, char c, char c2, char c3, String str) {
        this.resultService = new ResultSetHelperService();
        this.rawWriter = writer;
        this.f2pw = new PrintWriter(writer);
        this.separator = c;
        this.quotechar = c2;
        this.escapechar = c3;
        this.lineEnd = str;
    }

    public CSVWriter(Writer writer, char c, char c2, String str) {
        this(writer, c, c2, '\"', str);
    }

    private boolean stringContainsSpecialCharacters(String str) {
        return (str.indexOf(this.quotechar) == -1 && str.indexOf(this.escapechar) == -1) ? false : true;
    }

    public boolean checkError() {
        return this.f2pw.checkError();
    }

    public void close() throws IOException {
        flush();
        this.f2pw.close();
        this.rawWriter.close();
    }

    public void flush() throws IOException {
        this.f2pw.flush();
    }

    /* access modifiers changed from: protected */
    public StringBuilder processLine(String str) {
        StringBuilder sb = new StringBuilder(128);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (this.escapechar != 0 && charAt == this.quotechar) {
                sb.append(this.escapechar).append(charAt);
            } else if (this.escapechar == 0 || charAt != this.escapechar) {
                sb.append(charAt);
            } else {
                sb.append(this.escapechar).append(charAt);
            }
        }
        return sb;
    }

    public void setResultService(ResultSetHelper resultSetHelper) {
        this.resultService = resultSetHelper;
    }

    public void writeAll(ResultSet resultSet, boolean z) throws SQLException, IOException {
        if (z) {
            writeColumnNames(resultSet);
        }
        while (resultSet.next()) {
            writeNext(this.resultService.getColumnValues(resultSet));
        }
    }

    public void writeAll(List<String[]> list) {
        for (String[] writeNext : list) {
            writeNext(writeNext);
        }
    }

    /* access modifiers changed from: protected */
    public void writeColumnNames(ResultSet resultSet) throws SQLException {
        writeNext(this.resultService.getColumnNames(resultSet));
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r1v6, types: [java.lang.StringBuilder] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeNext(java.lang.String[] r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x0003
        L_0x0002:
            return
        L_0x0003:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r0 = 128(0x80, float:1.794E-43)
            r2.<init>(r0)
            r0 = 0
        L_0x000b:
            int r1 = r5.length
            if (r0 >= r1) goto L_0x003c
            if (r0 == 0) goto L_0x0015
            char r1 = r4.separator
            r2.append(r1)
        L_0x0015:
            r1 = r5[r0]
            if (r1 != 0) goto L_0x001c
        L_0x0019:
            int r0 = r0 + 1
            goto L_0x000b
        L_0x001c:
            char r3 = r4.quotechar
            if (r3 == 0) goto L_0x0025
            char r3 = r4.quotechar
            r2.append(r3)
        L_0x0025:
            boolean r3 = r4.stringContainsSpecialCharacters(r1)
            if (r3 == 0) goto L_0x002f
            java.lang.StringBuilder r1 = r4.processLine(r1)
        L_0x002f:
            r2.append(r1)
            char r1 = r4.quotechar
            if (r1 == 0) goto L_0x0019
            char r1 = r4.quotechar
            r2.append(r1)
            goto L_0x0019
        L_0x003c:
            java.lang.String r0 = r4.lineEnd
            r2.append(r0)
            java.io.PrintWriter r0 = r4.f2pw
            java.lang.String r1 = r2.toString()
            r0.write(r1)
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: p004au.com.bytecode.opencsv.CSVWriter.writeNext(java.lang.String[]):void");
    }
}
