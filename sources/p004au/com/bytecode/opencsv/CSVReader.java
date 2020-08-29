package p004au.com.bytecode.opencsv;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* renamed from: au.com.bytecode.opencsv.CSVReader */
public class CSVReader implements Closeable {
    public static final int DEFAULT_SKIP_LINES = 0;

    /* renamed from: br */
    private BufferedReader f1br;
    private boolean hasNext;
    private boolean linesSkiped;
    private CSVParser parser;
    private int skipLines;

    public CSVReader(Reader reader) {
        this(reader, ',', '\"', (char) CSVParser.DEFAULT_ESCAPE_CHARACTER);
    }

    public CSVReader(Reader reader, char c) {
        this(reader, c, '\"', (char) CSVParser.DEFAULT_ESCAPE_CHARACTER);
    }

    public CSVReader(Reader reader, char c, char c2) {
        this(reader, c, c2, CSVParser.DEFAULT_ESCAPE_CHARACTER, 0, false);
    }

    public CSVReader(Reader reader, char c, char c2, char c3) {
        this(reader, c, c2, c3, 0, false);
    }

    public CSVReader(Reader reader, char c, char c2, char c3, int i) {
        this(reader, c, c2, c3, i, false);
    }

    public CSVReader(Reader reader, char c, char c2, char c3, int i, boolean z) {
        this(reader, c, c2, c3, i, z, true);
    }

    public CSVReader(Reader reader, char c, char c2, char c3, int i, boolean z, boolean z2) {
        this.hasNext = true;
        this.f1br = new BufferedReader(reader);
        this.parser = new CSVParser(c, c2, c3, z, z2);
        this.skipLines = i;
    }

    public CSVReader(Reader reader, char c, char c2, int i) {
        this(reader, c, c2, CSVParser.DEFAULT_ESCAPE_CHARACTER, i, false);
    }

    public CSVReader(Reader reader, char c, char c2, boolean z) {
        this(reader, c, c2, CSVParser.DEFAULT_ESCAPE_CHARACTER, 0, z);
    }

    private String getNextLine() throws IOException {
        if (!this.linesSkiped) {
            for (int i = 0; i < this.skipLines; i++) {
                this.f1br.readLine();
            }
            this.linesSkiped = true;
        }
        String readLine = this.f1br.readLine();
        if (readLine == null) {
            this.hasNext = false;
        }
        if (this.hasNext) {
            return readLine;
        }
        return null;
    }

    public void close() throws IOException {
        this.f1br.close();
    }

    public List<String[]> readAll() throws IOException {
        ArrayList arrayList = new ArrayList();
        while (this.hasNext) {
            String[] readNext = readNext();
            if (readNext != null) {
                arrayList.add(readNext);
            }
        }
        return arrayList;
    }

    public String[] readNext() throws IOException {
        String[] strArr = null;
        while (true) {
            String nextLine = getNextLine();
            if (!this.hasNext) {
                return strArr;
            }
            String[] parseLineMulti = this.parser.parseLineMulti(nextLine);
            if (parseLineMulti.length <= 0) {
                parseLineMulti = strArr;
            } else if (strArr != null) {
                String[] strArr2 = new String[(strArr.length + parseLineMulti.length)];
                System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                System.arraycopy(parseLineMulti, 0, strArr2, strArr.length, parseLineMulti.length);
                parseLineMulti = strArr2;
            }
            if (!this.parser.isPending()) {
                return parseLineMulti;
            }
            strArr = parseLineMulti;
        }
    }
}
