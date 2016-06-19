
package ManagingModule;

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
    
    public String createReport(int filter, int filterType){
        String[] log = loggerBank.toString().split("\n");
        boolean write = false;
        String date;
        for(String line: log){
            if(line.split(":")[0].equalsIgnoreCase("log_date")){
                date = line.split(":")[1];
                write = filterType==0 ? filter==Integer.parseInt(date.split("-")[0]) : filter==Integer.parseInt(date.split("-")[2]);
            }
            if(write) report.addLog(line);
        }
        return report.getReport();
    }
    
    public String createReport(int[] id, int filterType){ //total valor arrecadado agrupados por mês ou ano
        String[] log = loggerBank.getLogger(id).split("\n");
        String date;
        int filter = 0;
        double total = 0;
        for(String line: log){
            if(line.split(":")[0].equalsIgnoreCase("log_date")){
                date = line.split(":")[1];
                if(filterType==0){
                    int month = Integer.parseInt(date.split("-")[0]);
                    filter = filter==0 ? month : filter;
                    if (filter!=month){
                        report.addLog("Mês "+filter);
                        report.addLog("Valor arrecadado: "+total);
                        total = 0;
                        filter = month;
                    }
                }else{
                    int year = Integer.parseInt(date.split("-")[2]);
                    filter = filter==0 ? year : filter;
                    if(filter!=year){
                        report.addLog("Ano "+filter);
                        report.addLog("Valor arrecadado: "+total);
                        total = 0;
                        filter = year;
                    }
                }       
            }
            if(line.split(":")[0].equalsIgnoreCase("Valor Arrecadado")) total+=Integer.parseInt(line.split(":")[1]);
        }
        return report.getReport();
    }
    
}
