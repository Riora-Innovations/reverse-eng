package p004au.com.bytecode.opencsv.bean;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import p004au.com.bytecode.opencsv.CSVReader;

/* renamed from: au.com.bytecode.opencsv.bean.MappingStrategy */
public interface MappingStrategy<T> {
    void captureHeader(CSVReader cSVReader) throws IOException;

    T createBean() throws InstantiationException, IllegalAccessException;

    PropertyDescriptor findDescriptor(int i) throws IntrospectionException;
}
