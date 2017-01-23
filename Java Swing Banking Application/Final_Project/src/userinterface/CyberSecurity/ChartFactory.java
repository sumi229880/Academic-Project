/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CyberSecurity;

import Business.UserAccount.LoginDetails;
import Business.UserAccount.UserAccount;
import java.awt.Color;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Sumeet
 */
public class ChartFactory {

    public static ChartPanel createChart(UserAccount account) {
        Map<String, LoginDetails> loginDetails = account.getLoginDetails();
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();

        Collection<LoginDetails> values = loginDetails.values();

        for (LoginDetails details : values) {
            dataset1.addValue(TimeUnit.MILLISECONDS.toHours(details.getLogoutTime() - details.getLoginTime()), HOURS_WORKED_BY_USER, details.getLoginDate());
            dataset2.addValue(2.5, MINIMUM_WORKING_HOURS, details.getLoginDate());
        }

        dataset1.addValue(2, HOURS_WORKED_BY_USER, "4-19-2016");
        dataset1.addValue(3, HOURS_WORKED_BY_USER, "4-20-2016");
        dataset2.addValue(2.5, MINIMUM_WORKING_HOURS, "4-19-2016");
        dataset2.addValue(2.5, MINIMUM_WORKING_HOURS, "4-20-2016");

        final CategoryItemRenderer renderer = new BarRenderer();

        final CategoryPlot plot = new CategoryPlot();
        plot.setDataset(dataset1);
        plot.setRenderer(renderer);

        plot.setDomainAxis(new CategoryAxis("Date"));
        plot.setRangeAxis(new NumberAxis("Hours"));

        plot.setOrientation(PlotOrientation.VERTICAL);
        plot.setRangeGridlinesVisible(true);
        plot.setDomainGridlinesVisible(true);

        // now create the second dataset and renderer...
        final CategoryItemRenderer renderer2 = new LineAndShapeRenderer();
        plot.setDataset(1, dataset2);
        plot.setRenderer(1, renderer2);

        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        final JFreeChart chart = new JFreeChart(plot);
        chart.setTitle("Employee work hours");

        chart.setBackgroundPaint(Color.WHITE);
        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        return chartPanel;
    }
    private static final String MINIMUM_WORKING_HOURS = "Minimum working hours";

    private static final String HOURS_WORKED_BY_USER = "Hours worked per day";
}
