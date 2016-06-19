package OperationModule;

import ExceptionModule.NonExistentInformationException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class InfoDAODerby implements InfoDAO{ //OK
    
    private File keepFile;
    //Label: info
    
    public InfoDAODerby(){
        keepFile = new File("information.txt");
    }
    
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
    
    public void set(String label, Object value){
    
        String arquivoTmp = "ARQUIVO-tmp";
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
            BufferedReader reader = new BufferedReader(new FileReader(keepFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String aux[] = line.split(":");
                if (aux[0].equals(label)) {
                    line = label+":"+value;
                }
                writer.write(line + "\n");
            }

            writer.close();        
            reader.close();

            keepFile.delete();
            new File(arquivoTmp).renameTo(keepFile);
        }catch(IOException e){

        }
    }
    
}
