package com.futaba.androidmadlink.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MathUtil {
    public static double round(double v, int scale) {
        if (scale <= 0) {
            return (double) Math.round(v);
        }
        StringBuffer formatStr = new StringBuffer();
        formatStr.append("#.");
        for (int i = 0; i < scale; i++) {
            formatStr.append("#");
        }
        DecimalFormat d = new DecimalFormat(formatStr.toString());
        d.setRoundingMode(RoundingMode.HALF_UP);
        return Double.parseDouble(d.format(v));
    }

    public static int roundToInt(double v) {
        String doubleStr = Double.valueOf(round(v, 0)).toString();
        return Integer.parseInt(doubleStr.substring(0, doubleStr.indexOf(".")));
    }

    public static double calMaxValue(double[] values) {
        double maxValue = 0.0d;
        if (values.length < 1) {
            return 0.0d;
        }
        for (double d : values) {
            if (Double.isNaN(d)) {
                return Double.NaN;
            }
            if (d > maxValue) {
                maxValue = d;
            }
        }
        return maxValue;
    }

    public static double calMinValue(Double[] doubles) {
        double minValue = 0.0d;
        if (doubles.length < 1) {
            return 0.0d;
        }
        for (Double doubleValue : doubles) {
            double d = doubleValue.doubleValue();
            if (Double.isNaN(d)) {
                return Double.NaN;
            }
            if (d < minValue) {
                minValue = d;
            }
        }
        return minValue;
    }
}
