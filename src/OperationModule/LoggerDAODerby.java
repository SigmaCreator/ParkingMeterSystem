/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperationModule;

import ResourceModule.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

/**
 *
 * @author Pedro
 */
public class LoggerDAODerby implements LoggerDAO{
    private File keepFile;
    
    public LoggerDAODerby(){
        keepFile = new File("logger.txt");
    }
    @Override
    public void addLog(Logger log) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(keepFile));
            bw.write(log.toString());
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LoggerDAODerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
