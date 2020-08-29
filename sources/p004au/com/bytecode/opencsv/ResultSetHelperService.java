package p004au.com.bytecode.opencsv;

import com.google.android.gms.cast.CastStatusCodes;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/* renamed from: au.com.bytecode.opencsv.ResultSetHelperService */
public class ResultSetHelperService implements ResultSetHelper {
    public static final int CLOBBUFFERSIZE = 2048;
    private static final int LONGNVARCHAR = -16;
    private static final int NCHAR = -15;
    private static final int NCLOB = 2011;
    private static final int NVARCHAR = -9;

    private String getColumnValue(ResultSet resultSet, int i, int i2) throws SQLException, IOException {
        String str = "";
        switch (i) {
            case LONGNVARCHAR /*-16*/:
            case NCHAR /*-15*/:
            case NVARCHAR /*-9*/:
            case -1:
            case 1:
            case 12:
                str = resultSet.getString(i2);
                break;
            case -7:
            case 2000:
                str = handleObject(resultSet.getObject(i2));
                break;
            case -6:
            case 4:
            case 5:
                str = handleInteger(resultSet, i2);
                break;
            case -5:
                str = handleLong(resultSet, i2);
                break;
            case 2:
            case 3:
            case 6:
            case 7:
            case 8:
                str = handleBigDecimal(resultSet.getBigDecimal(i2));
                break;
            case 16:
                str = Boolean.valueOf(resultSet.getBoolean(i2)).toString();
                break;
            case 91:
                str = handleDate(resultSet, i2);
                break;
            case 92:
                str = handleTime(resultSet.getTime(i2));
                break;
            case 93:
                str = handleTimestamp(resultSet.getTimestamp(i2));
                break;
            case CastStatusCodes.APPLICATION_NOT_RUNNING /*2005*/:
            case NCLOB /*2011*/:
                Clob clob = resultSet.getClob(i2);
                if (clob != null) {
                    str = read(clob);
                    break;
                }
                break;
            default:
                str = "";
                break;
        }
        return str == null ? "" : str;
    }

    private String handleBigDecimal(BigDecimal bigDecimal) {
        return bigDecimal == null ? "" : bigDecimal.toString();
    }

    private String handleDate(ResultSet resultSet, int i) throws SQLException {
        Date date = resultSet.getDate(i);
        if (date != null) {
            return new SimpleDateFormat("dd-MMM-yyyy").format(date);
        }
        return null;
    }

    private String handleInteger(ResultSet resultSet, int i) throws SQLException {
        return resultSet.wasNull() ? "" : Integer.toString(resultSet.getInt(i));
    }

    private String handleLong(ResultSet resultSet, int i) throws SQLException {
        return resultSet.wasNull() ? "" : Long.toString(resultSet.getLong(i));
    }

    private String handleObject(Object obj) {
        return obj == null ? "" : String.valueOf(obj);
    }

    private String handleTime(Time time) {
        if (time == null) {
            return null;
        }
        return time.toString();
    }

    private String handleTimestamp(Timestamp timestamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        if (timestamp == null) {
            return null;
        }
        return simpleDateFormat.format(timestamp);
    }

    private static String read(Clob clob) throws SQLException, IOException {
        StringBuilder sb = new StringBuilder((int) clob.length());
        Reader characterStream = clob.getCharacterStream();
        char[] cArr = new char[2048];
        while (true) {
            int read = characterStream.read(cArr, 0, cArr.length);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    public String[] getColumnNames(ResultSet resultSet) throws SQLException {
        ArrayList arrayList = new ArrayList();
        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 0; i < metaData.getColumnCount(); i++) {
            arrayList.add(metaData.getColumnName(i + 1));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public String[] getColumnValues(ResultSet resultSet) throws SQLException, IOException {
        ArrayList arrayList = new ArrayList();
        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 0; i < metaData.getColumnCount(); i++) {
            arrayList.add(getColumnValue(resultSet, metaData.getColumnType(i + 1), i + 1));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
