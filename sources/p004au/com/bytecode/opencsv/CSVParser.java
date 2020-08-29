package p004au.com.bytecode.opencsv;

import java.io.IOException;
import java.util.ArrayList;

/* renamed from: au.com.bytecode.opencsv.CSVParser */
public class CSVParser {
    public static final char DEFAULT_ESCAPE_CHARACTER = '\\';
    public static final boolean DEFAULT_IGNORE_LEADING_WHITESPACE = true;
    public static final char DEFAULT_QUOTE_CHARACTER = '\"';
    public static final char DEFAULT_SEPARATOR = ',';
    public static final boolean DEFAULT_STRICT_QUOTES = false;
    public static final int INITIAL_READ_SIZE = 128;
    public static final char NULL_CHARACTER = 0;
    private final char escape;
    private final boolean ignoreLeadingWhiteSpace;
    private boolean inField;
    private String pending;
    private final char quotechar;
    private final char separator;
    private final boolean strictQuotes;

    public CSVParser() {
        this(',', '\"', DEFAULT_ESCAPE_CHARACTER);
    }

    public CSVParser(char c) {
        this(c, '\"', DEFAULT_ESCAPE_CHARACTER);
    }

    public CSVParser(char c, char c2) {
        this(c, c2, DEFAULT_ESCAPE_CHARACTER);
    }

    public CSVParser(char c, char c2, char c3) {
        this(c, c2, c3, false);
    }

    public CSVParser(char c, char c2, char c3, boolean z) {
        this(c, c2, c3, z, true);
    }

    public CSVParser(char c, char c2, char c3, boolean z, boolean z2) {
        this.inField = false;
        if (anyCharactersAreTheSame(c, c2, c3)) {
            throw new UnsupportedOperationException("The separator, quote, and escape characters must be different!");
        } else if (c == 0) {
            throw new UnsupportedOperationException("The separator character must be defined!");
        } else {
            this.separator = c;
            this.quotechar = c2;
            this.escape = c3;
            this.strictQuotes = z;
            this.ignoreLeadingWhiteSpace = z2;
        }
    }

    private boolean anyCharactersAreTheSame(char c, char c2, char c3) {
        return isSameCharacter(c, c2) || isSameCharacter(c, c3) || isSameCharacter(c2, c3);
    }

    private boolean isNextCharacterEscapedQuote(String str, boolean z, int i) {
        return z && str.length() > i + 1 && str.charAt(i + 1) == this.quotechar;
    }

    private boolean isSameCharacter(char c, char c2) {
        return c != 0 && c == c2;
    }

    private String[] parseLine(String str, boolean z) throws IOException {
        boolean z2;
        StringBuilder sb = null;
        if (!z && this.pending != null) {
            this.pending = null;
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb2 = new StringBuilder(128);
            if (this.pending != null) {
                sb2.append(this.pending);
                this.pending = null;
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z3 = z2;
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (charAt == this.escape) {
                    if (isNextCharacterEscapable(str, z3 || this.inField, i)) {
                        sb2.append(str.charAt(i + 1));
                        i++;
                    }
                } else if (charAt == this.quotechar) {
                    if (isNextCharacterEscapedQuote(str, z3 || this.inField, i)) {
                        sb2.append(str.charAt(i + 1));
                        i++;
                    } else {
                        if (!this.strictQuotes && i > 2 && str.charAt(i - 1) != this.separator && str.length() > i + 1 && str.charAt(i + 1) != this.separator) {
                            if (!this.ignoreLeadingWhiteSpace || sb2.length() <= 0 || !isAllWhiteSpace(sb2)) {
                                sb2.append(charAt);
                            } else {
                                sb2.setLength(0);
                            }
                        }
                        z3 = !z3;
                    }
                    this.inField = !this.inField;
                } else if (charAt == this.separator && !z3) {
                    arrayList.add(sb2.toString());
                    sb2.setLength(0);
                    this.inField = false;
                } else if (!this.strictQuotes || z3) {
                    sb2.append(charAt);
                    this.inField = true;
                }
                i++;
            }
            if (!z3) {
                sb = sb2;
            } else if (z) {
                sb2.append(CSVWriter.DEFAULT_LINE_END);
                this.pending = sb2.toString();
            } else {
                throw new IOException("Un-terminated quoted field at end of CSV line");
            }
            if (sb != null) {
                arrayList.add(sb.toString());
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        } else if (this.pending == null) {
            return null;
        } else {
            String str2 = this.pending;
            this.pending = null;
            return new String[]{str2};
        }
    }

    /* access modifiers changed from: protected */
    public boolean isAllWhiteSpace(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isNextCharacterEscapable(String str, boolean z, int i) {
        return z && str.length() > i + 1 && (str.charAt(i + 1) == this.quotechar || str.charAt(i + 1) == this.escape);
    }

    public boolean isPending() {
        return this.pending != null;
    }

    public String[] parseLine(String str) throws IOException {
        return parseLine(str, false);
    }

    public String[] parseLineMulti(String str) throws IOException {
        return parseLine(str, true);
    }
}
