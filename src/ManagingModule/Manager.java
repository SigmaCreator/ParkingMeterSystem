
package ManagingModule;

import ExceptionModule.InvalidLoggerException;
import java.io.File;
import java.io.IOException;

public class Manager {
    private static Manager instance;
    private final ReportCreator reportCreator = ReportCreator.getInstance();
    private final LoggerBank loggerBank = LoggerBank.getInstance();
    private final GraphGenerator graphGenerator = GraphGenerator.getInstance();
    
    
    protected Manager(){}
    
    /*@ pure @*/
    public static Manager getInstance(){
        if(instance == null) 
            instance = new Manager();
        return instance;
    }
    
    //@requires newLogger != null;
    //@ensures \result == "Log importado com sucesso.";
    public Object addLogger(Object newLogger) throws InvalidLoggerException, IOException{
        return loggerBank.addLogger((File)newLogger);
    }
    
    //@requires filter==0 || filter==1;
    //@requires filterType==0 || filterType==1;
    //@ensures \result == reportCreator.createReport(filter, filterType);
    public Object createReport(int filter, int filterType){
        return reportCreator.createReport(filter, filterType);
    }
    
    //@requires id.length() == 5;
    //@requires filterType == 0 || filterType == 1;
    //@ensures \result == reportCreator.createReport(id, filterType);
    public Object createReport(String id, int filterType){
        return reportCreator.createReport(id, filterType);
    }
    
    //@requires id.length() == 5;
    //@ensures \result == graphGenerator.generateDataset(id);
    public Object getGraphDataset(String id){
        return graphGenerator.generateDataset(id);
    }
    
    /*@ pure @*/
    public Object getAllParkingMeters(){
        return loggerBank.getParkingMeterList();
    }
}
