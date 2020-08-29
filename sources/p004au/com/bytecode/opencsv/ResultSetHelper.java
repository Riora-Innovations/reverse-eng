package p004au.com.bytecode.opencsv;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/* renamed from: au.com.bytecode.opencsv.ResultSetHelper */
public interface ResultSetHelper {
    String[] getColumnNames(ResultSet resultSet) throws SQLException;

    String[] getColumnValues(ResultSet resultSet) throws SQLException, IOException;
}
