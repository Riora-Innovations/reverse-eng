package p004au.com.bytecode.opencsv.bean;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p004au.com.bytecode.opencsv.CSVReader;

/* renamed from: au.com.bytecode.opencsv.bean.CsvToBean */
public class CsvToBean<T> {
    private Map<Class<?>, PropertyEditor> editorMap = null;

    private void addEditorToMap(Class<?> cls, PropertyEditor propertyEditor) {
        if (propertyEditor != null) {
            this.editorMap.put(cls, propertyEditor);
        }
    }

    private String checkForTrim(String str, PropertyDescriptor propertyDescriptor) {
        return trimmableProperty(propertyDescriptor) ? str.trim() : str;
    }

    private PropertyEditor getPropertyEditorValue(Class<?> cls) {
        if (this.editorMap == null) {
            this.editorMap = new HashMap();
        }
        PropertyEditor propertyEditor = (PropertyEditor) this.editorMap.get(cls);
        if (propertyEditor != null) {
            return propertyEditor;
        }
        PropertyEditor findEditor = PropertyEditorManager.findEditor(cls);
        addEditorToMap(cls, findEditor);
        return findEditor;
    }

    private boolean trimmableProperty(PropertyDescriptor propertyDescriptor) {
        return !propertyDescriptor.getPropertyType().getName().contains("String");
    }

    /* access modifiers changed from: protected */
    public Object convertValue(String str, PropertyDescriptor propertyDescriptor) throws InstantiationException, IllegalAccessException {
        PropertyEditor propertyEditor = getPropertyEditor(propertyDescriptor);
        if (propertyEditor == null) {
            return str;
        }
        propertyEditor.setAsText(str);
        return propertyEditor.getValue();
    }

    /* access modifiers changed from: protected */
    public PropertyEditor getPropertyEditor(PropertyDescriptor propertyDescriptor) throws InstantiationException, IllegalAccessException {
        Class propertyEditorClass = propertyDescriptor.getPropertyEditorClass();
        return propertyEditorClass != null ? (PropertyEditor) propertyEditorClass.newInstance() : getPropertyEditorValue(propertyDescriptor.getPropertyType());
    }

    public List<T> parse(MappingStrategy<T> mappingStrategy, CSVReader cSVReader) {
        try {
            mappingStrategy.captureHeader(cSVReader);
            ArrayList arrayList = new ArrayList();
            while (true) {
                String[] readNext = cSVReader.readNext();
                if (readNext == null) {
                    return arrayList;
                }
                arrayList.add(processLine(mappingStrategy, readNext));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error parsing CSV!", e);
        }
    }

    public List<T> parse(MappingStrategy<T> mappingStrategy, Reader reader) {
        return parse(mappingStrategy, new CSVReader(reader));
    }

    /* access modifiers changed from: protected */
    public T processLine(MappingStrategy<T> mappingStrategy, String[] strArr) throws IllegalAccessException, InvocationTargetException, InstantiationException, IntrospectionException {
        T createBean = mappingStrategy.createBean();
        for (int i = 0; i < strArr.length; i++) {
            PropertyDescriptor findDescriptor = mappingStrategy.findDescriptor(i);
            if (findDescriptor != null) {
                Object convertValue = convertValue(checkForTrim(strArr[i], findDescriptor), findDescriptor);
                findDescriptor.getWriteMethod().invoke(createBean, new Object[]{convertValue});
            }
        }
        return createBean;
    }
}
