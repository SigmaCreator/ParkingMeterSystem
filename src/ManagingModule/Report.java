
package ManagingModule;

public class Report { // OK
    private StringBuilder report;
    
    public Report(){
        report = new StringBuilder();
    }
    
    public void addLog(String logger){
        report.append("\n");
        report.append(logger);
    }
    
    public String getReport(){
        return report.toString();
    }
}
