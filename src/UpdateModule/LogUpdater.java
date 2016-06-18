package UpdateModule;

import ManagingModule.Manager;
import ResourceModule.Logger;

public class LogUpdater {
    private static LogUpdater instance;
    private Manager manager = Manager.getInstance();
    
    protected LogUpdater(){}
    
    public static LogUpdater getInstance(){
        if(instance == null)
            instance = new LogUpdater();
        return instance;
    }

    public void sendLog(Integer[] id, Logger logger) {
        manager.sendLog(id,logger);
    }
    
    
}
