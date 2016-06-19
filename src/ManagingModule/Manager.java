
package ManagingModule;

import ExceptionModule.InvalidLoggerException;
import java.io.File;
import java.io.IOException;

public class Manager {
    private static Manager instance;
    private ReportCreator reportCreator = ReportCreator.getInstance();
    private LoggerBank loggerBank = LoggerBank.getInstance();
    
    protected Manager(){}
    
    /*@ pure @*/
    public static Manager getInstance(){
        if(instance == null) 
            instance = new Manager();
        return instance;
    }
    
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

    /*@ pure @*/
    public void sendLog(File f) throws InvalidLoggerException, IOException{
        loggerBank.addLogger(f);
    }
    
    
}
