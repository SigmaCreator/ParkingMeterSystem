package PersistenceModule;

import OperationModule.Bank;
import OperationModule.BankDAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BankDAODerby implements BankDAO { //OK
    private File keepFile;
    
    //@ensures keepFile == new File("bank.txt")
    public BankDAODerby(){ keepFile = new File("bank.txt"); }

    
    //@requires bank != null;
    public void update(Bank bank) {
        String arquivoTmp = "ARQUIVO-tmp";
        try{
        BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
        BufferedReader reader = new BufferedReader(new FileReader(arquivoTmp));
        
        writer.write(bank.toString());
        
        writer.close();        
        reader.close();

        keepFile.delete();
        new File(arquivoTmp).renameTo(keepFile);
        }catch(IOException e){
        
        }
    }
    
    
    
}
  
