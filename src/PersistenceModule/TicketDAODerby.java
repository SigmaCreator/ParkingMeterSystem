package PersistenceModule;

import OperationModule.Ticket;
import OperationModule.TicketDAO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TicketDAODerby implements TicketDAO { //OK!
    private File keepFile;
    
    //@ensures keepFile == new File("tickets.txt")
    public TicketDAODerby (){
        keepFile = new File("tickets.txt");
    }

    //@requires t != null;
    public void add(Ticket t) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(keepFile));
    
            writer.write(t.toString());
            writer.write("\n");
    
            writer.close();
        }catch(IOException e){
        
        }
    }
}
