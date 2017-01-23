/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdminWorkArea;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;

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
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Sumeet
 */
public class dummy extends javax.swing.JPanel {

    /**
     *
     * Creates new form ManageNetworkJPanel
     */
    public dummy() {
        initComponents();
//        this.setSize(1020, 720);

        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        dataset1.addValue(1.0, "S1", "Category 1");
        dataset1.addValue(4.0, "S1", "Category 2");
        dataset1.addValue(3.0, "S1", "Category 3");
        dataset1.addValue(5.0, "S1", "Category 4");
        dataset1.addValue(5.0, "S1", "Category 5");
        dataset1.addValue(7.0, "S1", "Category 6");
        dataset1.addValue(7.0, "S1", "Category 7");
        dataset1.addValue(8.0, "S1", "Category 8");
        
        dataset1.addValue(5.0, "S2", "Category 1");
        dataset1.addValue(7.0, "S2", "Category 2");
        dataset1.addValue(6.0, "S2", "Category 3");
        dataset1.addValue(8.0, "S2", "Category 4");
        dataset1.addValue(4.0, "S2", "Category 5");
        dataset1.addValue(4.0, "S2", "Category 6");
        dataset1.addValue(2.0, "S2", "Category 7");
        dataset1.addValue(1.0, "S2", "Category 8");

        // create the first renderer...
        //      final CategoryLabelGenerator generator = new StandardCategoryLabelGenerator();
        final CategoryItemRenderer renderer = new BarRenderer();
        //    renderer.setLabelGenerator(generator);
        //renderer.setItemLabelsVisible(true);

        final CategoryPlot plot = new CategoryPlot();
        plot.setDataset(dataset1);
        plot.setRenderer(renderer);
        
        plot.setDomainAxis(new CategoryAxis("Category"));
        plot.setRangeAxis(new NumberAxis("Value"));
        
        plot.setOrientation(PlotOrientation.VERTICAL);
        plot.setRangeGridlinesVisible(true);
        plot.setDomainGridlinesVisible(true);

        // now create the second dataset and renderer...
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        dataset2.addValue(9.0, "T1", "Category 1");
        dataset2.addValue(7.0, "T1", "Category 2");
        dataset2.addValue(2.0, "T1", "Category 3");
        dataset2.addValue(6.0, "T1", "Category 4");
        dataset2.addValue(6.0, "T1", "Category 5");
        dataset2.addValue(9.0, "T1", "Category 6");
        dataset2.addValue(5.0, "T1", "Category 7");
        dataset2.addValue(4.0, "T1", "Category 8");
        
        final CategoryItemRenderer renderer2 = new LineAndShapeRenderer();
        plot.setDataset(1, dataset2);
        plot.setRenderer(1, renderer2);

        // create the third dataset and renderer...
//        final ValueAxis rangeAxis2 = new NumberAxis("Axis 2");
//        plot.setRangeAxis(1, rangeAxis2);
//
//        DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
//        dataset3.addValue(94.0, "R1", "Category 1");
//        dataset3.addValue(75.0, "R1", "Category 2");
//        dataset3.addValue(22.0, "R1", "Category 3");
//        dataset3.addValue(74.0, "R1", "Category 4");
//        dataset3.addValue(83.0, "R1", "Category 5");
//        dataset3.addValue(9.0, "R1", "Category 6");
//        dataset3.addValue(23.0, "R1", "Category 7");
//        dataset3.addValue(98.0, "R1", "Category 8");
//
//        plot.setDataset(2, dataset3);
//        final CategoryItemRenderer renderer3 = new LineAndShapeRenderer();
//        plot.setRenderer(2, renderer3);
//        plot.mapDatasetToRangeAxis(2, 1);
        // change the rendering order so the primary dataset appears "behind" the 
        // other datasets...
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        final JFreeChart chart = new JFreeChart(plot);
        chart.setTitle("Overlaid Bar Chart");
        //  chart.setLegend(new StandardLegend());

        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
//        chartPanel.add(cha)
//        containerPanel.add(chartPanel, BorderLayout.CENTER);

//        setSize(200,200);
        //add(new JTextField(10));
//        setVisible(true);
        setLayout(new FlowLayout());
//        containerPanel.setSize(200, 200);
//        innerPanel.setSize(100, 100);
        containerPanel.setLayout(new FlowLayout());
        containerPanel.add(chartPanel, BorderLayout.CENTER);
//        innerPanel.add(new JTextField(10));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerPanel = new javax.swing.JPanel();
        innerPanel = new javax.swing.JPanel();

        javax.swing.GroupLayout innerPanelLayout = new javax.swing.GroupLayout(innerPanel);
        innerPanel.setLayout(innerPanelLayout);
        innerPanelLayout.setHorizontalGroup(
            innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );
        innerPanelLayout.setVerticalGroup(
            innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(innerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
        );
        containerPanelLayout.setVerticalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(innerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(747, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String... args) throws ParseException {
//        JFrame frame = new JFrame("Charts ...");
//        frame.add(new dummy());
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 1000);

        String email = "ankur@g...mail.com.";
        System.out.println(new SimpleDateFormat("MM/dd/yyyy").parse("16/234/1234"));
    }
    
    private static boolean isValidateEmailId(String email) {
        if (email.contains("..")) {
            return false;
        }
        
        Pattern pattern = Pattern.compile("@.*@");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            return false;
        }
        
        return email.matches("\\w+@\\w+\\.\\w[\\w.]*\\w");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel containerPanel;
    private javax.swing.JPanel innerPanel;
    // End of variables declaration//GEN-END:variables

}
