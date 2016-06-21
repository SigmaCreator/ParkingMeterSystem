
package InterfaceModule;

import ExceptionModule.InvalidLoggerException;
import ManagingModule.Manager;
import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
        //TODO ALL
public class Controller extends Observable{
    private final Manager manager;
    private static Controller instance;
    
    protected Controller(){
        manager = Manager.getInstance();
    }
    
    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }
    
    public Object getParkingMeterList(){
        return manager.getAllPartkingMeters();
    }
    
    public String generateValueReport(String id, int filterType) {
        return (String) manager.createReport(id, filterType);
    }
    
    public String generateGeneralReport(int filter, int filterType){
        return (String) manager.createReport(filter, filterType);
    }
    
    public String importLogger(Object newLogger) throws InvalidLoggerException, IOException{
        String result = (String) manager.addLogger(newLogger);
        setChanged();
        notifyObservers();
        return result;
    }
    
    public JFreeChart generateGraph(String id){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        HashMap<String, Double> hash = (HashMap<String,Double>)manager.getGraphDataset(id);
        for(String date : hash.keySet()){
            String[] aux = date.split("-");
            dataset.addValue(hash.get(date), aux[1], aux[0]);
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Performance: JFreeSVG vs Batik", null /* x-axis label*/, 
                "Milliseconds" /* y-axis label */, dataset);
        chart.addSubtitle(new TextTitle("Time to generate 1000 charts in SVG " 
               + "format (lower bars = better performance)"));
        chart.setBackgroundPaint(Color.white);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        chart.getLegend().setFrame(BlockBorder.NONE);
        return chart;
    }
    
}
