
package ManagingModule;

public class Report { // OK
    private StringBuilder report;
    
    //@ensures report == new StringBuilder()
    public Report(){
        report = new StringBuilder();
    }
    
    public void addLog(String logger){
        report.append(logger);
        report.append("\n");
    }
    
    /*@ pure @*/
    public String getReport(){
        return report.toString();
    }
}
