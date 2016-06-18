package OperationModule;

import ExceptionModule.NegativeCardFundsException;
import ExceptionModule.NotEnoughCardFundsException;
import ExceptionModule.SerialNumberLengthIsNotEnough;

public interface CardDAO{
      public String setCard(int[] serialNum, int funds) throws SerialNumberLengthIsNotEnough, NegativeCardFundsException;
    
    public int getFunds();
    
    public int[] getSerialNum();

    public Boolean setSerialNum(int[] serialNum);
    
    public Boolean addFunds(int value);
    
    public void subFunds(int value) throws NotEnoughCardFundsException;
}



/*class CardDAO { //OK
    Card card;

    public int[] getSerialNum(){ 
        return card.getSerialNum();
    }
    
    public Boolean setSerialNum(int[] serialNum) {
        return card.setSerialNum(serialNum);
    }
    
    public Boolean addFunds(int value){
        return card.addFunds(value);
    }
    
    public void subFunds(int value) throws NotEnoughCardFundsException{
        card.subFunds(value);
    }

    public int getFunds() {
        return card.getFunds();
    }
    
}*/
