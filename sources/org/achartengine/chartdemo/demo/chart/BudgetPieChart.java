package org.achartengine.chartdemo.demo.chart;

import android.content.Context;
import android.content.Intent;
import org.achartengine.ChartFactory;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

public class BudgetPieChart extends AbstractDemoChart {
    public String getName() {
        return "Budget chart";
    }

    public String getDesc() {
        return "The budget per project for this year (pie chart)";
    }

    public Intent execute(Context context) {
        double[] values = {12.0d, 14.0d, 11.0d, 10.0d, 19.0d};
        DefaultRenderer renderer = buildCategoryRenderer(new int[]{-16776961, -16711936, -65281, -256, -16711681});
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(20.0f);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(false);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
        r.setGradientStart(0.0d, -16776961);
        r.setGradientStop(0.0d, -16711936);
        r.setHighlighted(true);
        return ChartFactory.getPieChartIntent(context, buildCategoryDataset("Project budget", values), renderer, "Budget");
    }
}
