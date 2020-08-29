package com.futaba.androidmadlink.config;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import android.util.Log;
import com.futaba.androidmadlink.C0112R;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Parameter {
    public static Map<String, Integer> BAUD_RATE = null;
    public static final String CMD_CLEAR_LOG = "be";
    public static final String CMD_CLEAR_SETTING = "ae";
    public static final String CMD_DEFAULT_SETTING = "dl";
    public static final String CMD_READ_LOG = "br";
    public static final String CMD_READ_SETTING = "sr";
    public static final String CMD_REBOOT = "rt";
    public static final String CMD_WRITE_SETTING = "sw";
    public static Map<String, Byte> DATA_BITS = null;
    public static final String DATE_FORMAT_TODAY = "yyyyMMdd";
    public static final String[] Data_ARRAY = {"C0", "C1", "C2", "C3", "C4"};
    public static final String FILE_EXT_GPS = "nema";
    public static final String FILE_EXT_LOG = "txt";
    public static final String FILE_EXT_SETTING = "set";
    public static Map<String, Integer> FLOW = null;
    public static boolean GPSLocusActivityIsOpen = false;
    public static final int LOG_DATA_SIZE = 4100;
    private static String PACKAGE_NAME = "com.futaba.mclink";
    public static Map<String, Byte> PARITY = null;
    public static final String PREFS_KEY_BAUD_RATE = "BAUD_RATE";
    public static final String PREFS_KEY_DATA_BITS = "DATA_BITS";
    public static final String PREFS_KEY_FLOW = "FLOW";
    public static final String PREFS_KEY_PARITY = "PARITY";
    public static final String PREFS_KEY_STOP_BITS = "STOP_BITS";
    public static final String PREFS_NAME = "COM_PREFS";
    public static final int RETRY_TIMES = 20;
    public static final String ROOT_PATH = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString())).append("/Download").toString();
    public static final int SETTING_DATA_SIZE = 196;
    public static final boolean SHOW_LOGCAT = true;
    public static Map<String, Byte> STOP_BITS = null;
    public static final String TAG = "TMA1Tool";
    public static final int TIMEOUT_LOG = 10;
    public static final int TIMEOUT_SETTING = 1;
    private static String _AlertSound = "";
    private static int _ScreenMode = 0;
    static String _defoultAlertSound = "android.resource://com.futaba.androidmadlink/raw/alert";
    private static String _path = "";
    public static String machine_Name = "";
    public static int machine_Type = 0;
    public static String rootGPS = "";
    public static String rootGaugeFile = "/TMA_1/Settings.xml";
    public static String rootLog = "";
    public static String rootPath = "/TMA_1";

    static {
        BAUD_RATE = new HashMap();
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("300", Integer.valueOf(300));
        map.put("600", Integer.valueOf(600));
        map.put("1200", Integer.valueOf(1200));
        map.put("4800", Integer.valueOf(4800));
        map.put("9600", Integer.valueOf(9600));
        map.put("19200", Integer.valueOf(19200));
        map.put("38400", Integer.valueOf(38400));
        map.put("57600", Integer.valueOf(57600));
        map.put("115200", Integer.valueOf(115200));
        map.put("230400", Integer.valueOf(230400));
        BAUD_RATE = Collections.unmodifiableMap(map);
        PARITY = new HashMap();
        Map<String, Byte> map2 = new LinkedHashMap<>();
        map2.put("None", Byte.valueOf(0));
        map2.put("Odd", Byte.valueOf(1));
        map2.put("Even", Byte.valueOf(2));
        map2.put("Mark", Byte.valueOf(3));
        map2.put("Space", Byte.valueOf(4));
        PARITY = Collections.unmodifiableMap(map2);
        DATA_BITS = new HashMap();
        Map<String, Byte> map3 = new LinkedHashMap<>();
        map3.put("7", Byte.valueOf(7));
        map3.put("8", Byte.valueOf(8));
        DATA_BITS = Collections.unmodifiableMap(map3);
        STOP_BITS = new HashMap();
        Map<String, Byte> map4 = new LinkedHashMap<>();
        map4.put("1", Byte.valueOf(0));
        map4.put("2", Byte.valueOf(2));
        STOP_BITS = Collections.unmodifiableMap(map4);
        FLOW = new HashMap();
        Map<String, Integer> map5 = new LinkedHashMap<>();
        map5.put("None", Integer.valueOf(0));
        map5.put("Xon/Xoff", Integer.valueOf(1024));
        map5.put("RTS/CTS", Integer.valueOf(256));
        map5.put("DTR/DSR", Integer.valueOf(512));
        FLOW = Collections.unmodifiableMap(map5);
    }

    public static void setPath(String _rootPath) {
        _path = _rootPath;
        rootPath = new StringBuilder(String.valueOf(_rootPath)).append("/TMA_1").toString();
        rootLog = new StringBuilder(String.valueOf(_rootPath)).append("/TMA_1/Log").toString();
        rootGPS = new StringBuilder(String.valueOf(_rootPath)).append("/TMA_1/MyPath").toString();
        rootGaugeFile = new StringBuilder(String.valueOf(_rootPath)).append("/TMA_1/Settings.xml").toString();
    }

    public static int getVerCode(Context context) {
        int verCode = -1;
        try {
            PACKAGE_NAME = context.getPackageName();
            return context.getPackageManager().getPackageInfo(PACKAGE_NAME, 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.e(TAG, e.getMessage(), e);
            return verCode;
        }
    }

    public static String getVerName(Context context) {
        PACKAGE_NAME = context.getPackageName();
        String verName = "";
        try {
            return context.getPackageManager().getPackageInfo(PACKAGE_NAME, 0).versionName;
        } catch (NameNotFoundException e) {
            Log.e(TAG, e.getMessage(), e);
            return verName;
        }
    }

    public static String getAppName(Context context) {
        return context.getResources().getText(C0112R.string.app_name).toString();
    }

    public static void setScreenMode(int ScreenMode) {
        _ScreenMode = ScreenMode;
    }

    public static int getScreenMode() {
        return _ScreenMode;
    }

    public static String getDefoulAlertSound() {
        return _defoultAlertSound;
    }

    public static void setAlertSound(String AlertSound) {
        _AlertSound = AlertSound;
    }

    public static String getAlertSound() {
        return _AlertSound;
    }
}
