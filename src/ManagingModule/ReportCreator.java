
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
    
    public String createReport(int[] id, int filterType, int filter){
        report.addLog(loggerBank.getLogger(id));
        return report.getReport();
    }
    
}
