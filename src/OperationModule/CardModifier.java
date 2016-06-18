package OperationModule;

import ExceptionModule.NotEnoughCardFundsException;

class CardModifier { //OK
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
    
}
