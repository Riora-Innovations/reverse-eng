package p004au.com.bytecode.opencsv.bean;

import java.util.HashMap;
import java.util.Map;

/* renamed from: au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy */
public class HeaderColumnNameTranslateMappingStrategy<T> extends HeaderColumnNameMappingStrategy<T> {
    private Map<String, String> columnMapping = new HashMap();

    public Map<String, String> getColumnMapping() {
        return this.columnMapping;
    }

    /* access modifiers changed from: protected */
    public String getColumnName(int i) {
        if (i < this.header.length) {
            return (String) this.columnMapping.get(this.header[i].toUpperCase());
        }
        return null;
    }

    public void setColumnMapping(Map<String, String> map) {
        for (String str : map.keySet()) {
            this.columnMapping.put(str.toUpperCase(), map.get(str));
        }
    }
}
