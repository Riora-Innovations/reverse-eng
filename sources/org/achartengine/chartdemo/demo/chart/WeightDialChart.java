package org.achartengine.chartdemo.demo.chart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DialRenderer;
import org.achartengine.renderer.DialRenderer.Type;
import org.achartengine.renderer.SimpleSeriesRenderer;

public class WeightDialChart extends AbstractDemoChart {
    public String getName() {
        return "Weight chart";
    }

    public String getDesc() {
        return "The weight indicator (dial chart)";
    }

    public Intent execute(Context context) {
        CategorySeries category = new CategorySeries("Weight indic");
        category.add("Current", 75.0d);
        category.add("Minimum", 65.0d);
        category.add("Maximum", 90.0d);
        DialRenderer renderer = new DialRenderer();
        renderer.setChartTitleTextSize(20.0f);
        renderer.setLabelsTextSize(15.0f);
        renderer.setLegendTextSize(15.0f);
        int[] iArr = new int[4];
        iArr[0] = 20;
        iArr[1] = 30;
        iArr[2] = 15;
        renderer.setMargins(iArr);
        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
        r.setColor(-16776961);
        renderer.addSeriesRenderer(r);
        SimpleSeriesRenderer r2 = new SimpleSeriesRenderer();
        r2.setColor(Color.rgb(0, 150, 0));
        renderer.addSeriesRenderer(r2);
        SimpleSeriesRenderer r3 = new SimpleSeriesRenderer();
        r3.setColor(-16711936);
        renderer.addSeriesRenderer(r3);
        renderer.setLabelsTextSize(10.0f);
        renderer.setLabelsColor(-1);
        renderer.setShowLabels(true);
        renderer.setVisualTypes(new Type[]{Type.ARROW, Type.NEEDLE, Type.NEEDLE});
        renderer.setMinValue(0.0d);
        renderer.setMaxValue(150.0d);
        return ChartFactory.getDialChartIntent(context, category, renderer, "Weight indicator");
    }
}
