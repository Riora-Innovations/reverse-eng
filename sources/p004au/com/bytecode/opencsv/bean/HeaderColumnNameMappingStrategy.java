package p004au.com.bytecode.opencsv.bean;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import p004au.com.bytecode.opencsv.CSVReader;

/* renamed from: au.com.bytecode.opencsv.bean.HeaderColumnNameMappingStrategy */
public class HeaderColumnNameMappingStrategy<T> implements MappingStrategy<T> {
    protected Map<String, PropertyDescriptor> descriptorMap = null;
    protected String[] header;
    protected Class<T> type;

    private PropertyDescriptor[] loadDescriptors(Class<T> cls) throws IntrospectionException {
        return Introspector.getBeanInfo(cls).getPropertyDescriptors();
    }

    public void captureHeader(CSVReader cSVReader) throws IOException {
        this.header = cSVReader.readNext();
    }

    public T createBean() throws InstantiationException, IllegalAccessException {
        return this.type.newInstance();
    }

    public PropertyDescriptor findDescriptor(int i) throws IntrospectionException {
        String columnName = getColumnName(i);
        if (columnName == null || columnName.trim().length() <= 0) {
            return null;
        }
        return findDescriptor(columnName);
    }

    /* access modifiers changed from: protected */
    public PropertyDescriptor findDescriptor(String str) throws IntrospectionException {
        if (this.descriptorMap == null) {
            this.descriptorMap = loadDescriptorMap(getType());
        }
        return (PropertyDescriptor) this.descriptorMap.get(str.toUpperCase().trim());
    }

    /* access modifiers changed from: protected */
    public String getColumnName(int i) {
        if (this.header == null || i >= this.header.length) {
            return null;
        }
        return this.header[i];
    }

    public Class<T> getType() {
        return this.type;
    }

    /* access modifiers changed from: protected */
    public Map<String, PropertyDescriptor> loadDescriptorMap(Class<T> cls) throws IntrospectionException {
        PropertyDescriptor[] loadDescriptors;
        HashMap hashMap = new HashMap();
        for (PropertyDescriptor propertyDescriptor : loadDescriptors(getType())) {
            hashMap.put(propertyDescriptor.getName().toUpperCase().trim(), propertyDescriptor);
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public boolean matches(String str, PropertyDescriptor propertyDescriptor) {
        return propertyDescriptor.getName().equals(str.trim());
    }

    public void setType(Class<T> cls) {
        this.type = cls;
    }
}
