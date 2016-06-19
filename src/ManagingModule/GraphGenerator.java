/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagingModule;

import java.util.HashMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraphGenerator {
    private LoggerBank loggerBank;
    
    public GraphGenerator(){
        loggerBank = LoggerBank.getInstance();
    }
    
    public CategoryDataset generateDataset(int[] id){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        String [] log = loggerBank.getLogger(id).split("\n");
        HashMap<String, Double> values = new HashMap<>();
        String month, year, key="";
        for(String line : log){
            if(line.split(":")[0].equalsIgnoreCase("log_date")){
                month = line.split(":")[1].split("-")[0];
                year = line.split(":")[1].split("-")[2];
                key = year+"-"+month;
            }
            if(line.split(":")[0].equalsIgnoreCase("Valor Arrecadado")) {
                double aux = Double.parseDouble(line.split(":")[1]);
                if(values.containsKey(key))
                    values.replace(key, values.get(key)+aux);
                else
                    values.put(key, aux);
            }
        }
        //dataset.addValue(valor, mês, ano);
        for(String date : values.keySet())
            dataset.addValue(values.get(date), date.split("-")[1], date.split("-")[0]);
        return dataset;
    }
}
