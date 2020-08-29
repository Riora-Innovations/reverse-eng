package com.futaba.androidmadlink.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DataFunctions {
    public static String converTimeUtcToLocal(String srcTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        if (srcTime == null || "".equals(srcTime)) {
            long result_time = System.currentTimeMillis();
            sdf.setTimeZone(TimeZone.getDefault());
            return sdf.format(Long.valueOf(result_time));
        }
        try {
            sdf.setTimeZone(TimeZone.getTimeZone("GMT00:00"));
            Date utcDate = sdf.parse(srcTime.toString());
            sdf.setTimeZone(TimeZone.getDefault());
            return sdf.format(utcDate);
        } catch (Exception e) {
            long result_time2 = System.currentTimeMillis();
            sdf.setTimeZone(TimeZone.getDefault());
            return sdf.format(Long.valueOf(result_time2));
        }
    }
}
