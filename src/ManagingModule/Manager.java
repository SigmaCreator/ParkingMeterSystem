
package ManagingModule;

import ExceptionModule.InvalidLoggerException;
import ResourceModule.Logger;
import java.io.File;
import java.io.IOException;

public class Manager {
    private static Manager instance;
    private ReportCreator reportCreator = ReportCreator.getInstance();
    private LoggerBank loggerBank = LoggerBank.getInstance();
    
    protected Manager(){}
    
    public static Manager getInstance(){
        if(instance == null) 
            instance = new Manager();
        return instance;
    }
    
    public Object defineAction(Object[] info){
        Object o;
        switch((int)info[0]){
            //case 1: o = reportCreator.createReport((int[])info[1]);
            //case 2: graphGenerator;
            default: o = null;
        }
        return o;
    }

    public void sendLog(File f) throws InvalidLoggerException, IOException{
        loggerBank.addLogger(f);
    }
    
    
}
