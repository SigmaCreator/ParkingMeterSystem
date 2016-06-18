package OperationModule;

import ExceptionModule.NegativeCardFundsException;
import ExceptionModule.NotEnoughCardFundsException;
import ExceptionModule.SerialNumberLengthIsNotEnough;

class CardController { //OK
    Card card;
    CardModifier cardModifier;
    
    public CardController(){ cardModifier = new CardModifier(); }
    
    public String setCard(int[] serialNum, int funds) throws SerialNumberLengthIsNotEnough, NegativeCardFundsException{
        card = new Card(serialNum,funds);
        return card.toString();
    }
    
    public int getFunds(){
        return cardModifier.getFunds();
    }
    
    public int[] getSerialNum(){ 
        return cardModifier.getSerialNum();
    }

    public Boolean setSerialNum(int[] serialNum) {
        return cardModifier.setSerialNum(serialNum);
    }
    
    public Boolean addFunds(int value){
        return cardModifier.addFunds(value);
    }
    
    public void subFunds(int value) throws NotEnoughCardFundsException{
        cardModifier.subFunds(value);
    }
    
    
}
