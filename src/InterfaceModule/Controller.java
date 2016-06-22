
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
    
    /*@ pure @*/
    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }
    
    /*@ pure @*/
    public Object getParkingMeterList(){
        return manager.getAllParkingMeters();
    }
    
    
    //@requires id.length() == 5;
    //@requires filterType == 0 || filterType == 1;
    //@ensures \result == manager.createReport(id, filterType);
    public String generateValueReport(String id, int filterType) {
        return (String) manager.createReport(id, filterType);
    }
    
    //@requires filter==0 || filter==1;
    //@requires filterType==0 || filterType==1;
    //@ensures \result == manager.createReport(filter, filterType);
    public String generateGeneralReport(int filter, int filterType){
        return (String) manager.createReport(filter, filterType);
    }
    
    //@requires newLogger != null;
    //@ensures \result == "Log importado com sucesso.";
    public String importLogger(Object newLogger) throws InvalidLoggerException, IOException{
        String result = (String) manager.addLogger(newLogger);
        setChanged();
        notifyObservers();
        return result;
    }
    
    //@requires id.length() == 5;
    //@ensures \result != null;
    public JFreeChart generateGraph(String id){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        HashMap<String, Double> hash = (HashMap<String,Double>)manager.getGraphDataset(id);
        for(String date : hash.keySet()){
            String[] aux = date.split("-");
            dataset.addValue(hash.get(date), aux[1], aux[0]);
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Parquímetro: "+id, null /* x-axis label*/, 
                "Centavos" /* y-axis label */, dataset);
        chart.addSubtitle(new TextTitle("Arrecadacao anual mês a mês "));
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
