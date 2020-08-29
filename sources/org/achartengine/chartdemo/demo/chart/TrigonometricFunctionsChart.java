package org.achartengine.chartdemo.demo.chart;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public class TrigonometricFunctionsChart extends AbstractDemoChart {
    public String getName() {
        return "Trigonometric functions";
    }

    public String getDesc() {
        return "The graphical representations of the sin and cos functions (line chart)";
    }

    public Intent execute(Context context) {
        String[] titles = {"sin", "cos"};
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int count = 90 + 1;
        arrayList.add(new double[count]);
        arrayList.add(new double[count]);
        double[] sinValues = new double[count];
        double[] cosValues = new double[count];
        arrayList2.add(sinValues);
        arrayList2.add(cosValues);
        for (int i = 0; i < count; i++) {
            int angle = i * 4;
            ((double[]) arrayList.get(0))[i] = (double) angle;
            ((double[]) arrayList.get(1))[i] = (double) angle;
            double rAngle = Math.toRadians((double) angle);
            sinValues[i] = Math.sin(rAngle);
            cosValues[i] = Math.cos(rAngle);
        }
        XYMultipleSeriesRenderer renderer = buildRenderer(new int[]{-16776961, -16711681}, new PointStyle[]{PointStyle.POINT, PointStyle.POINT});
        setChartSettings(renderer, "Trigonometric functions", "X (in degrees)", "Y", 0.0d, 360.0d, -1.0d, 1.0d, -7829368, DefaultRenderer.TEXT_COLOR);
        renderer.setXLabels(20);
        renderer.setYLabels(10);
        return ChartFactory.getLineChartIntent(context, buildDataset(titles, arrayList, arrayList2), renderer);
    }
}
