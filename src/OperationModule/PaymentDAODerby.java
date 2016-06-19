/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperationModule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PaymentDAODerby implements PaymentDAO{
    private File keepFile;
    
    public PaymentDAODerby(){
        keepFile = new File("payments.txt");
    }
    
    @Override
    public void addPayment(Object info[], double fee, double change) {
        
        try{
        BufferedWriter writer = new BufferedWriter(new FileWriter(keepFile));
        StringBuffer s = null;
        if((int)info[0]==1){ s.append(1).append(";");}
        else {
            for(int i: (int[])info[2])
                s.append(i);
            s.append(";");
        }
        s.append(fee).append(";").append(change).append(";");
        writer.write(s.toString());
        writer.write("\n");
        //1|serialNum;fee;change;
        writer.close();
        }catch(IOException e){

        }
    }
    
}
