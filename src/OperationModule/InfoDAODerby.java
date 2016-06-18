package OperationModule;

import ExceptionModule.NonExistentActionException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class InfoDAODerby implements InfoDAO{ //OK
    
    private Information information;
    private File keepFile;
    //Label: info
    
    public InfoDAODerby(){
        information = Information.getInstance();
        keepFile = new File("information.txt");
    }
   
    
    public Object get(String label) throws NonExistentActionException{
        try{
            FileReader fr = new FileReader(keepFile);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line!=null){
                String aux[] = line.split(":");
                if(aux[0].equals(label)) return aux[1];
            }
            br.close();
        } catch (IOException ex) {
        } 
        throw new NonExistentActionException("Label invalido");
    }
    
    public void set(String label, Object value){
    
    String arquivoTmp = "ARQUIVO-tmp";
    try{
    BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
    BufferedReader reader = new BufferedReader(new FileReader(keepFile));

    String linha;
    boolean wrote = false;
    while ((linha = reader.readLine()) != null) {
        String aux[] = linha.split(":");
        if (aux[0].equals(label)) {
            linha = label+":"+value;
            wrote = true;
        }
        writer.write(linha + "\n");
    }
    if(!wrote){
        writer.write(label+":"+value);
    }

    writer.close();        
    reader.close();

    keepFile.delete();
    new File(arquivoTmp).renameTo(keepFile);
    }catch(IOException e){
        
    }
    }
    
}
