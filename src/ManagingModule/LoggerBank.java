
package ManagingModule;

import ExceptionModule.InvalidLoggerException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class LoggerBank {
    private static LoggerBank instance;
    private HashMap<String,String> bank;
    
    protected LoggerBank(){
        bank = new HashMap<String,String>();
    }
    
    /*@ pure @*/
    public static LoggerBank getInstance(){
        if(instance == null) 
            instance = new LoggerBank();
        return instance;
    }

    /*@ pure @*/
    public String getLogger(String id) {
        return bank.get(id);
    }
    
    //@requires File !=null
    //@ensures \result.equalsIgnoreCase("Log importado com sucesso.");
    public String addLogger(File file) throws InvalidLoggerException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuffer sb = new StringBuffer();
        String line = br.readLine();
        if(!line.contains(":")) throw new InvalidLoggerException("Arquivo de registro inválido!");
        String id = line.split(":")[1];
        if(id.length()!= 5) throw new InvalidLoggerException("Arquivo de registro inválido!");
        while((line = br.readLine())!=null)
            sb.append("\n").append(line);
        bank.put(id, sb.toString());
        return "Log importado com sucesso.";
    }
    
    @Override
    /*@ pure @*/
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(String s: bank.values())
            sb.append(s).append("\n");
        return sb.toString();
    }
    
    /*@ pure @*/
    public Object getParkingMeterList(){
        return bank.keySet();
    }
    
}
