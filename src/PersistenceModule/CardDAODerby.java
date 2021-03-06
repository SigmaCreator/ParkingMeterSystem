package PersistenceModule;

import OperationModule.Card;
import OperationModule.CardDAO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CardDAODerby implements CardDAO { //OK
    private File keepFile;
    
    //@ensures keepFile == new File("cards.txt")
    public CardDAODerby() {
        keepFile = new File("cards.txt");
    }

    //@requires c != null;
    public void addCard(Card c, int fee){

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
