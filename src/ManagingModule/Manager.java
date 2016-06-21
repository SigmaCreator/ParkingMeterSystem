
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
    /*
    //@requires info[0] == 1
    //
    //@ensures \result == loggerBank.addLogger((File)info[1])
    //@also
    //@requires info[0] == 2
    //
    //@ensures \result == reportCreator.createReport((int)info[1], (int)info[2])
    //@also
    //@requires info[0] == 3
    //
    //@ensures \result == reportCreator.createReport((int[])info[1], (int)info[2])
    public Object defineAction(Object[] info) throws InvalidLoggerException, IOException{
        //info[0] = action;
        //info[1] = File newLogger | int filter | int[] id
        //info[2] = int filterType
        Object o;
        switch((int)info[0]){
            case 1: o = loggerBank.addLogger((File)info[1]);
                    break;
            case 2: o = reportCreator.createReport((int)info[1], (int)info[2]);
                    break;
            case 3: o = reportCreator.createReport((int[])info[1], (int)info[2]);
                    break;
            //case 4: gera grafico de valor arrecadado por ano mes a mes
            default: o = null;
        }
        return o;
    }  
    */
    public Object addLogger(Object newLogger) throws InvalidLoggerException, IOException{
        return loggerBank.addLogger((File)newLogger);
    }
    
    public Object createReport(int filter, int filterType){
        return reportCreator.createReport(filter, filterType);
    }
    
    public Object createReport(String id, int filterType){
        return reportCreator.createReport(id, filterType);
    }
    
    public Object getGraphDataset(String id){
        return graphGenerator.generateDataset(id);
    }
    
    public Object getAllPartkingMeters(){
        return loggerBank.getParkingMeterList();
    }
}
