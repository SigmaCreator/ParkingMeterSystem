package OperationModule;


import ExceptionModule.NoThatSWrongException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

    @Override
    public Ticket[] getAll(String label) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
