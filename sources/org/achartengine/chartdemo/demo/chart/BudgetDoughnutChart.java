package org.achartengine.chartdemo.demo.chart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.ChartFactory;
import org.achartengine.renderer.DefaultRenderer;

public class BudgetDoughnutChart extends AbstractDemoChart {
    public String getName() {
        return "Budget chart for several years";
    }

    public String getDesc() {
        return "The budget per project for several years (doughnut chart)";
    }

    public Intent execute(Context context) {
        List<double[]> values = new ArrayList<>();
        values.add(new double[]{12.0d, 14.0d, 11.0d, 10.0d, 19.0d});
        values.add(new double[]{10.0d, 9.0d, 14.0d, 20.0d, 11.0d});
        List<String[]> titles = new ArrayList<>();
        titles.add(new String[]{"P1", "P2", "P3", "P4", "P5"});
        titles.add(new String[]{"Project1", "Project2", "Project3", "Project4", "Project5"});
        DefaultRenderer renderer = buildCategoryRenderer(new int[]{-16776961, -16711936, -65281, -256, -16711681});
        renderer.setApplyBackgroundColor(true);
        renderer.setBackgroundColor(Color.rgb(222, 222, 200));
        renderer.setLabelsColor(-7829368);
        return ChartFactory.getDoughnutChartIntent(context, buildMultipleCategoryDataset("Project budget", titles, values), renderer, "Doughnut chart demo");
    }
}
