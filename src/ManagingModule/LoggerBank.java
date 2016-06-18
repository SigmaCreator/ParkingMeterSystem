
package ManagingModule;

import ResourceModule.Logger;
import java.util.HashMap;

public class LoggerBank {
    private static LoggerBank instance;
    private HashMap<Integer[],Logger> bank;
    
    protected LoggerBank(){}
    
    public static LoggerBank getInstance(){
        if(instance == null) 
            instance = new LoggerBank();
        return instance;
    }

    public Logger getLogger(int[] id) {
        return bank.get(id);
    }
    
    public Boolean addLogger(Integer[] id, Object logger){
        if( bank.put(id,(Logger)logger) != null ) return true;
        return false;
    }
}
