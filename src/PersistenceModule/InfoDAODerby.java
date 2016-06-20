package PersistenceModule;

import ExceptionModule.NonExistentInformationException;
import OperationModule.InfoDAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InfoDAODerby implements InfoDAO{ //OK
    
    private File keepFile;
    //Label: info
    
    //@ensures keepFile == new File("information.txt")
    public InfoDAODerby(){
        keepFile = new File("info.ini");
    }
    
    //@requires aux[0] == label
    //
    //@ensures \result == aux
    public Object get(String label) throws NonExistentInformationException {
        try{
            FileReader fr = new FileReader(keepFile);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line!=null){
                String aux[] = line.split(":");
                if(aux[0].equals(label)) return aux;
            }
            
            br.close();
        } catch (IOException ex) {       
        }
        
        throw new NonExistentInformationException("Não existe informação com tal label");
        
    }
    
}
