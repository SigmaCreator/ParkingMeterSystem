
package ManagingModule;

import java.util.Arrays;

public class ReportCreator {
    private static ReportCreator instance;
    private LoggerBank loggerBank = LoggerBank.getInstance();
    private Report report;
    
    protected ReportCreator(){}
    
    public static ReportCreator getInstance(){
        if(instance == null) 
            instance = new ReportCreator();
        return instance;
    }
    
    public String createReport(int filterType, int filter){
        
        return null;
    }
    
    public String createReport(int[] id, int filterType, int filter){ //total valor arrecadado agrupados por mês ou ano
        String[] log = loggerBank.getLogger(id).split("\n");
        String date;
        boolean write = false;
        double total = 0;
        for(String line: log){
            if(line.split(":")[0].equalsIgnoreCase("log_date")){
                date = line.split(":")[1];
                write = filterType==0 ? filter==Integer.parseInt(date.split("-")[0]) : filter==Integer.parseInt(date.split("-")[2]);
            }
            if(write && ) report.addLog(line);
        }
        return report.getReport();
    }
    
}
