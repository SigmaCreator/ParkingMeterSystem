
package ManagingModule;

import ExceptionModule.InvalidLoggerException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LoggerBank {
    private static LoggerBank instance;
    private HashMap<Integer[],String> bank;
    
    protected LoggerBank(){}
    
    /*@ pure @*/
    public static LoggerBank getInstance(){
        if(instance == null) 
            instance = new LoggerBank();
        return instance;
    }

    /*@ pure @*/
    public String getLogger(int[] id) {
        return bank.get(id);
    }
    
    //@requires idString.length()== 5
    //
    //@ensures bank.containsKey(id) == true
    public String addLogger(File file) throws InvalidLoggerException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuffer sb = new StringBuffer();
        String line = br.readLine();
        String idString = line.split(":")[1];
        if(idString.length()!= 5) throw new InvalidLoggerException("Arquivo de registro inválido!");
        Integer[] id = new Integer[5];
        for(int i=0; i<5; i++)
            id[i] = Integer.parseInt(String.valueOf(idString.charAt(i))); 
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
}
