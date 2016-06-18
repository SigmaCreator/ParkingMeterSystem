
package ManagingModule;

import ResourceModule.Logger;


public class Report { // OK
    private StringBuilder report;
    
    public Report(){
        report = new StringBuilder();
    }
    
    public void addLog(Logger logger){
        report.append("\n");
        report.append(logger.toString());
    }
    
    public StringBuilder getReportBuilder(){
        return report;
    }
    
    public String getReport(){
        return report.toString();
    }
}
