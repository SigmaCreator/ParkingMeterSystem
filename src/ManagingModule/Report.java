
package ManagingModule;

public class Report { // OK
    private StringBuilder report;
    
    //@ensures report == new StringBuilder()
    public Report(){
        report = new StringBuilder();
    }
    
    public void addLog(String logger){
        report.append("\n");
        report.append(logger);
    }
    
    /*@ pure @*/
    public String getReport(){
        return report.toString();
    }
}
