package com.futaba.androidmadlink.data;

import android.util.Log;
import com.futaba.androidmadlink.config.Parameter;
import com.google.android.gms.maps.model.LatLng;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import p004au.com.bytecode.opencsv.CSVWriter;

public class WriteLog {
    public static String setLogName(String senserName, String slot, String[] unitList) {
        String logFileName = "";
        String strUnit = "";
        try {
            SimpleDateFormat nowdate = new SimpleDateFormat("yyyyMMddHHmm");
            nowdate.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            String logFileName2 = nowdate.format(new Date());
            logFileName2.replaceAll("\\s+", "");
            logFileName = new StringBuilder(String.valueOf(senserName)).append("-").append(logFileName2).toString();
            File vPath = new File(Parameter.rootLog);
            if (!vPath.exists()) {
                vPath.mkdirs();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(Parameter.rootLog + "/" + logFileName + "." + Parameter.FILE_EXT_LOG, true));
            bw.write(new StringBuilder(String.valueOf(senserName)).append(" \n").toString());
            bw.write("Slot:" + slot + " \n");
            for (String unit : unitList) {
                strUnit = new StringBuilder(String.valueOf(strUnit)).append(",").append(unit).toString();
            }
            bw.write("Count" + strUnit + " \n");
            bw.close();
        } catch (Exception e) {
            Log.e(Parameter.TAG, "Error :" + e.getMessage());
        }
        return logFileName;
    }

    public static void writeLog(String logFileName, int logCount, String[] Values) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(Parameter.rootLog + "/" + logFileName + "." + Parameter.FILE_EXT_LOG, true));
            String strValue = "";
            for (String _value : Values) {
                strValue = new StringBuilder(String.valueOf(strValue)).append(",").append(_value).toString();
            }
            bw.write(new StringBuilder(String.valueOf(logCount)).append(strValue).append(CSVWriter.DEFAULT_LINE_END).toString());
            bw.close();
        } catch (Exception e) {
            Log.e(Parameter.TAG, "Error :" + e.getMessage());
        }
    }

    public static String setLogName(String viewData) {
        String logFileName = "";
        try {
            SimpleDateFormat nowdate = new SimpleDateFormat("yyyyMMddHHmm");
            nowdate.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            logFileName = nowdate.format(new Date());
            logFileName.replaceAll("\\s+", "");
            File vPath = new File(Parameter.rootLog);
            if (!vPath.exists()) {
                vPath.mkdirs();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(Parameter.rootLog + "/" + logFileName + "." + Parameter.FILE_EXT_LOG, true));
            bw.write(new StringBuilder(String.valueOf(viewData)).append(" \n").toString());
            bw.close();
        } catch (Exception e) {
            Log.e(Parameter.TAG, "Error :" + e.getMessage());
        }
        return logFileName;
    }

    public static void writeLog(String logFileName, String logDatas) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(Parameter.rootLog + "/" + logFileName + "." + Parameter.FILE_EXT_LOG, true));
            bw.write(logDatas);
            bw.close();
        } catch (Exception e) {
            Log.e(Parameter.TAG, "Error :" + e.getMessage());
        }
    }

    public static void WriteGPSLog(String LogFileName, LatLng map, double Altitude, double Speed) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(Parameter.rootGPS + "/" + LogFileName + "." + Parameter.FILE_EXT_GPS, true));
            if (map == null) {
                bw.write("");
                bw.close();
                return;
            }
            bw.write(map.latitude + "," + map.longitude + "," + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) + "," + Altitude + "," + Speed);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
