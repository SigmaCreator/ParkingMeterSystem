package OperationModule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TicketDAODerby implements TicketDAO { //OK!
    private File keepFile;
    
    public TicketDAODerby (){
        keepFile = new File("tickets.txt");
    }

    public void add(Ticket t) {
    try{
    BufferedWriter writer = new BufferedWriter(new FileWriter(keepFile));
    
    writer.write(t.toString());
    writer.write("\n");
    
    writer.close();
    }catch(IOException e){
        
    }
    }

    public Ticket[] getAll(String label) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
