
package PersistenceModule;

import OperationModule.LoggerDAO;
import ResourceModule.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

public class LoggerDAODerby implements LoggerDAO{
    private File keepFile;
    
    //@ensures keepFile == new File("logger.txt")
    public LoggerDAODerby(){
        keepFile = new File("logger.txt");
    }
    
    @Override
    public void addLog(Logger log) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(keepFile, true));
            bw.write(log.toString());
            bw.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LoggerDAODerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
