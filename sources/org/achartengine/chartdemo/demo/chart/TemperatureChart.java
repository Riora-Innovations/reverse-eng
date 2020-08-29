package org.achartengine.chartdemo.demo.chart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint.Align;
import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.RangeCategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public class TemperatureChart extends AbstractDemoChart {
    public String getName() {
        return "Temperature range chart";
    }

    public String getDesc() {
        return "The monthly temperature (vertical range chart)";
    }

    public Intent execute(Context context) {
        double[] minValues = {-24.0d, -19.0d, -10.0d, -1.0d, 7.0d, 12.0d, 15.0d, 14.0d, 9.0d, 1.0d, -11.0d, -16.0d};
        double[] maxValues = {7.0d, 12.0d, 24.0d, 28.0d, 33.0d, 35.0d, 37.0d, 36.0d, 28.0d, 19.0d, 11.0d, 4.0d};
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        RangeCategorySeries rangeCategorySeries = new RangeCategorySeries("Temperature");
        int length = minValues.length;
        for (int k = 0; k < length; k++) {
            rangeCategorySeries.add(minValues[k], maxValues[k]);
        }
        dataset.addSeries(rangeCategorySeries.toXYSeries());
        XYMultipleSeriesRenderer renderer = buildBarRenderer(new int[]{-16711681});
        setChartSettings(renderer, "Monthly temperature range", "Month", "Celsius degrees", 0.5d, 12.5d, -30.0d, 45.0d, -7829368, DefaultRenderer.TEXT_COLOR);
        renderer.setBarSpacing(0.5d);
        renderer.setXLabels(0);
        renderer.setYLabels(10);
        renderer.addXTextLabel(1.0d, "Jan");
        renderer.addXTextLabel(3.0d, "Mar");
        renderer.addXTextLabel(5.0d, "May");
        renderer.addXTextLabel(7.0d, "Jul");
        renderer.addXTextLabel(10.0d, "Oct");
        renderer.addXTextLabel(12.0d, "Dec");
        renderer.addYTextLabel(-25.0d, "Very cold");
        renderer.addYTextLabel(-10.0d, "Cold");
        renderer.addYTextLabel(5.0d, "OK");
        renderer.addYTextLabel(20.0d, "Nice");
        int[] iArr = new int[4];
        iArr[0] = 30;
        iArr[1] = 70;
        iArr[2] = 10;
        renderer.setMargins(iArr);
        renderer.setYLabelsAlign(Align.RIGHT);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setDisplayChartValues(true);
        r.setChartValuesTextSize(12.0f);
        r.setChartValuesSpacing(3.0f);
        r.setGradientEnabled(true);
        r.setGradientStart(-20.0d, -16776961);
        r.setGradientStop(20.0d, -16711936);
        return ChartFactory.getRangeBarChartIntent(context, dataset, renderer, Type.DEFAULT, "Temperature range");
    }
}
