package org.achartengine.chartdemo.demo.chart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint.Align;
import java.util.ArrayList;
import java.util.Date;
import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class SensorValuesChart extends AbstractDemoChart {
    private static final long DAY = 86400000;
    private static final long HOUR = 3600000;
    private static final int HOURS = 24;

    public String getName() {
        return "Sensor data";
    }

    public String getDesc() {
        return "The temperature, as read from an outside and an inside sensors";
    }

    public Intent execute(Context context) {
        String[] titles = {"Inside", "Outside"};
        long now = ((long) Math.round((float) (new Date().getTime() / 86400000))) * 86400000;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < titles.length; i++) {
            Date[] dates = new Date[HOURS];
            for (int j = 0; j < HOURS; j++) {
                dates[j] = new Date(now - (((long) (24 - j)) * HOUR));
            }
            arrayList.add(dates);
        }
        ArrayList arrayList2 = new ArrayList();
        double[] dArr = new double[HOURS];
        // fill-array-data instruction
        dArr[0] = 4626660487188394803;
        dArr[1] = 4626744929681408000;
        dArr[2] = 4626801224676750131;
        dArr[3] = 4626744929681408000;
        dArr[4] = 4626716782183736934;
        dArr[5] = 4626716782183736934;
        dArr[6] = 4626688634686065869;
        dArr[7] = 4626632339690723738;
        dArr[8] = 4626491602202368410;
        dArr[9] = 4626407159709355213;
        dArr[10] = 4626379012211684147;
        dArr[11] = 4626294569718670950;
        dArr[12] = 4626238274723328819;
        dArr[13] = 4626210127225657754;
        dArr[14] = 4626294569718670950;
        dArr[15] = 4626407159709355213;
        dArr[16] = 4626491602202368410;
        dArr[17] = 4626576044695381606;
        dArr[18] = 4626660487188394803;
        dArr[19] = 4626773077179079066;
        dArr[20] = 4626857519672092262;
        dArr[21] = 4626913814667434394;
        dArr[22] = 4626801224676750131;
        dArr[23] = 4626744929681408000;
        arrayList2.add(dArr);
        arrayList2.add(new double[]{1.9d, 1.2d, 0.9d, 0.5d, 0.1d, -0.5d, -0.6d, Double.MAX_VALUE, Double.MAX_VALUE, -1.8d, -0.3d, 1.4d, 3.4d, 4.9d, 7.0d, 6.4d, 3.4d, 2.0d, 1.5d, 0.9d, -0.5d, Double.MAX_VALUE, -1.9d, -2.5d, -4.3d});
        XYMultipleSeriesRenderer renderer = buildRenderer(new int[]{-16711936, -16776961}, new PointStyle[]{PointStyle.CIRCLE, PointStyle.DIAMOND});
        int length = renderer.getSeriesRendererCount();
        for (int i2 = 0; i2 < length; i2++) {
            ((XYSeriesRenderer) renderer.getSeriesRendererAt(i2)).setFillPoints(true);
        }
        setChartSettings(renderer, "Sensor temperature", "Hour", "Celsius degrees", (double) ((Date[]) arrayList.get(0))[0].getTime(), (double) ((Date[]) arrayList.get(0))[23].getTime(), -5.0d, 30.0d, DefaultRenderer.TEXT_COLOR, DefaultRenderer.TEXT_COLOR);
        renderer.setXLabels(10);
        renderer.setYLabels(10);
        renderer.setShowGrid(true);
        renderer.setXLabelsAlign(Align.CENTER);
        renderer.setYLabelsAlign(Align.RIGHT);
        return ChartFactory.getTimeChartIntent(context, buildDateDataset(titles, arrayList, arrayList2), renderer, "h:mm a");
    }
}
