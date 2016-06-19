package OperationModule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class CardDAODerby implements CardDAO { //OK
    private File keepFile;
    
    //@ensures keepFile == new File("cards.txt")
    public CardDAODerby() {
        keepFile = new File("cards.txt");
    }

    @Override
    public void addCard(Card c, double fee){

        try{
        BufferedWriter writer = new BufferedWriter(new FileWriter(keepFile));

        writer.write(c.toString());
        writer.write(fee+";");
        writer.write("\n");

        writer.close();
        }catch(IOException e){

        }
    }

}
