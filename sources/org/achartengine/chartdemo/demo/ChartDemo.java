package org.achartengine.chartdemo.demo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.achartengine.chartdemo.demo.chart.AverageCubicTemperatureChart;
import org.achartengine.chartdemo.demo.chart.AverageTemperatureChart;
import org.achartengine.chartdemo.demo.chart.BudgetDoughnutChart;
import org.achartengine.chartdemo.demo.chart.BudgetPieChart;
import org.achartengine.chartdemo.demo.chart.CombinedTemperatureChart;
import org.achartengine.chartdemo.demo.chart.IDemoChart;
import org.achartengine.chartdemo.demo.chart.MultipleTemperatureChart;
import org.achartengine.chartdemo.demo.chart.PieChartBuilder;
import org.achartengine.chartdemo.demo.chart.ProjectStatusBubbleChart;
import org.achartengine.chartdemo.demo.chart.ProjectStatusChart;
import org.achartengine.chartdemo.demo.chart.SalesBarChart;
import org.achartengine.chartdemo.demo.chart.SalesComparisonChart;
import org.achartengine.chartdemo.demo.chart.SalesGrowthChart;
import org.achartengine.chartdemo.demo.chart.SalesStackedBarChart;
import org.achartengine.chartdemo.demo.chart.ScatterChart;
import org.achartengine.chartdemo.demo.chart.SensorValuesChart;
import org.achartengine.chartdemo.demo.chart.TemperatureChart;
import org.achartengine.chartdemo.demo.chart.TrigonometricFunctionsChart;
import org.achartengine.chartdemo.demo.chart.WeightDialChart;
import org.achartengine.chartdemo.demo.chart.XYChartBuilder;

public class ChartDemo extends ListActivity {
    private IDemoChart[] mCharts = {new AverageTemperatureChart(), new AverageCubicTemperatureChart(), new SalesStackedBarChart(), new SalesBarChart(), new TrigonometricFunctionsChart(), new ScatterChart(), new SalesComparisonChart(), new ProjectStatusChart(), new SalesGrowthChart(), new BudgetPieChart(), new BudgetDoughnutChart(), new ProjectStatusBubbleChart(), new TemperatureChart(), new WeightDialChart(), new SensorValuesChart(), new CombinedTemperatureChart(), new MultipleTemperatureChart()};
    private String[] mMenuSummary;
    private String[] mMenuText;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int length = this.mCharts.length;
        this.mMenuText = new String[(length + 3)];
        this.mMenuSummary = new String[(length + 3)];
        this.mMenuText[0] = "Embedded line chart demo";
        this.mMenuSummary[0] = "A demo on how to include a clickable line chart into a graphical activity";
        this.mMenuText[1] = "Embedded pie chart demo";
        this.mMenuSummary[1] = "A demo on how to include a clickable pie chart into a graphical activity";
        for (int i = 0; i < length; i++) {
            this.mMenuText[i + 2] = this.mCharts[i].getName();
            this.mMenuSummary[i + 2] = this.mCharts[i].getDesc();
        }
        this.mMenuText[length + 2] = "Random values charts";
        this.mMenuSummary[length + 2] = "Chart demos using randomly generated values";
        setListAdapter(new SimpleAdapter(this, getListValues(), 17367044, new String[]{IDemoChart.NAME, IDemoChart.DESC}, new int[]{16908308, 16908309}));
    }

    private List<Map<String, String>> getListValues() {
        List<Map<String, String>> values = new ArrayList<>();
        int length = this.mMenuText.length;
        for (int i = 0; i < length; i++) {
            Map<String, String> v = new HashMap<>();
            v.put(IDemoChart.NAME, this.mMenuText[i]);
            v.put(IDemoChart.DESC, this.mMenuSummary[i]);
            values.add(v);
        }
        return values;
    }

    /* access modifiers changed from: protected */
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent;
        super.onListItemClick(l, v, position, id);
        if (position == 0) {
            intent = new Intent(this, XYChartBuilder.class);
        } else if (position == 1) {
            intent = new Intent(this, PieChartBuilder.class);
        } else if (position <= this.mCharts.length + 1) {
            intent = this.mCharts[position - 2].execute(this);
        } else {
            intent = new Intent(this, GeneratedChartDemo.class);
        }
        startActivity(intent);
    }
}
