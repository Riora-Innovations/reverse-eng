package p004au.com.bytecode.opencsv.bean;

import java.io.IOException;
import p004au.com.bytecode.opencsv.CSVReader;

/* renamed from: au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy */
public class ColumnPositionMappingStrategy<T> extends HeaderColumnNameMappingStrategy<T> {
    private String[] columnMapping = new String[0];

    public void captureHeader(CSVReader cSVReader) throws IOException {
    }

    public String[] getColumnMapping() {
        if (this.columnMapping != null) {
            return (String[]) this.columnMapping.clone();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public String getColumnName(int i) {
        if (this.columnMapping == null || i >= this.columnMapping.length) {
            return null;
        }
        return this.columnMapping[i];
    }

    public void setColumnMapping(String[] strArr) {
        this.columnMapping = strArr != null ? (String[]) strArr.clone() : null;
    }
}
