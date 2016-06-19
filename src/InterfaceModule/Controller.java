
package InterfaceModule;

import ExceptionModule.InvalidLoggerException;
import ManagingModule.Manager;
import java.io.IOException;
        //TODO ALL
public class Controller {
    private Manager manager;
    
    public Controller(){
        manager = Manager.getInstance();
    }
    
    public String generateValueReport(){
        return null;
    }
    
    public String generateGeneralReport(){
        return null;
    }
    
    public void generateGraph(){
        
    }
    
}
