
package ManagingModule;

import java.util.HashMap;

public class ReportCreator {
    private static ReportCreator instance;
    private final LoggerBank loggerBank;
    
    protected ReportCreator(){
        loggerBank = LoggerBank.getInstance();
    }
    
    /*@ pure @*/
    public static ReportCreator getInstance(){
        if(instance == null) 
            instance = new ReportCreator();
        return instance;
    }
    
    public String createReport(int filter, int filterType){
        Report report = new Report();
        String[] log = loggerBank.toString().split("\n");
        boolean write = false;
        String date;
        for(String line: log){
            if(line.split(":")[0].equalsIgnoreCase("log_date")){
                date = line.split(":")[1];
                write = filterType==0 ? filter==Integer.parseInt(date.split("-")[0]) : filter==Integer.parseInt(date.split("-")[1]);
            }
            if(write) report.addLog(line);
        }
        return report.getReport();
    }
    
    public String createReport(String id, int filterType){ //total valor arrecadado agrupados por mês ou ano
        Report report = new Report();
        String[] log = loggerBank.getLogger(id).split("\n");
        HashMap<String, Integer> data = new HashMap<>();
        String date[] = new String[3], key = null;
        report.addLog("Relatório de Valores por "+(filterType==0 ? "Mês": "Ano"));
        
        for(String line: log){
            if(line.split(":")[0].equalsIgnoreCase("log_date")){
                date = line.split(":")[1].split("-");
                key = filterType==0 ? date[0]+"-"+date[2] : date[2];
            }else if(line.split(":")[0].equalsIgnoreCase("Valor arrecadado")){
                if(!data.containsKey(key))
                    data.put(key, Integer.parseInt(line.split(":")[1]));
                else
                    data.replace(key, data.get(key)+Integer.parseInt(line.split(":")[1]));
            }
        }
        
        for(String s: data.keySet()){
            report.addLog((filterType==0 ? "Mês ": "Ano ")+ s);
            report.addLog("Valor arrecadado: "+data.get(s));
        }
        
        return report.getReport();
    }
    
}
